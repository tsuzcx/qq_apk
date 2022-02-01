package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class LocalVideoPushSegment$5
  implements Runnable
{
  LocalVideoPushSegment$5(LocalVideoPushSegment paramLocalVideoPushSegment, LocalMediaInfo paramLocalMediaInfo, LocalVideoPushSegment.OnLoadThumbBitmapListener paramOnLoadThumbBitmapListener) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo._id;
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inMutable = true;
    Bitmap localBitmap = MediaStore.Images.Thumbnails.getThumbnail(LocalVideoPushSegment.b(this.this$0).getContentResolver(), l, 1, (BitmapFactory.Options)localObject1);
    localObject1 = null;
    Canvas localCanvas = null;
    Object localObject2;
    if (localBitmap != null)
    {
      try
      {
        localObject1 = Bitmap.createBitmap(localBitmap).copy(Bitmap.Config.ARGB_8888, true);
      }
      catch (Exception localException)
      {
        SLog.c("Q.qqstory.home.LocalVideoPushSegment", "create new bitmap error:%s", localException);
        localObject2 = localCanvas;
      }
      if (localObject2 != null)
      {
        localCanvas = new Canvas((Bitmap)localObject2);
        Paint localPaint = new Paint();
        localPaint.setColor(-16777216);
        localPaint.setAlpha(100);
        localCanvas.drawRect(0.0F, 0.0F, localBitmap.getWidth(), localBitmap.getHeight(), localPaint);
        localCanvas.save();
        localCanvas.restore();
        localBitmap.recycle();
        localObject2 = new BitmapDrawable(LocalVideoPushSegment.c(this.this$0).getResources(), this.this$0.a.a((Bitmap)localObject2));
      }
      else
      {
        localObject2 = new BitmapDrawable(LocalVideoPushSegment.d(this.this$0).getResources(), localBitmap);
      }
    }
    ThreadManager.getUIHandler().post(new LocalVideoPushSegment.5.1(this, (BitmapDrawable)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.5
 * JD-Core Version:    0.7.0.1
 */