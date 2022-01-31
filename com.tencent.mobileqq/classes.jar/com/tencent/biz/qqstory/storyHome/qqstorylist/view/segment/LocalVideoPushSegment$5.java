package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import uxv;
import vcf;
import vcl;
import ved;

public class LocalVideoPushSegment$5
  implements Runnable
{
  public LocalVideoPushSegment$5(vcf paramvcf, LocalMediaInfo paramLocalMediaInfo, vcl paramvcl) {}
  
  public void run()
  {
    Object localObject1 = null;
    long l = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo._id;
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inMutable = true;
    localObject2 = MediaStore.Images.Thumbnails.getThumbnail(vcf.b(this.this$0).getContentResolver(), l, 1, (BitmapFactory.Options)localObject2);
    if (localObject2 != null) {}
    try
    {
      localObject1 = Bitmap.createBitmap((Bitmap)localObject2).copy(Bitmap.Config.ARGB_8888, true);
      if (localObject1 != null)
      {
        Canvas localCanvas = new Canvas((Bitmap)localObject1);
        Paint localPaint = new Paint();
        localPaint.setColor(-16777216);
        localPaint.setAlpha(100);
        localCanvas.drawRect(0.0F, 0.0F, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), localPaint);
        localCanvas.save();
        localCanvas.restore();
        ((Bitmap)localObject2).recycle();
        localObject1 = new BitmapDrawable(vcf.c(this.this$0).getResources(), this.this$0.a.a((Bitmap)localObject1));
        ThreadManager.getUIHandler().post(new LocalVideoPushSegment.5.1(this, (BitmapDrawable)localObject1));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ved.c("Q.qqstory.home.LocalVideoPushSegment", "create new bitmap error:%s", localException);
        BitmapDrawable localBitmapDrawable = null;
        continue;
        localBitmapDrawable = new BitmapDrawable(vcf.d(this.this$0).getResources(), (Bitmap)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.5
 * JD-Core Version:    0.7.0.1
 */