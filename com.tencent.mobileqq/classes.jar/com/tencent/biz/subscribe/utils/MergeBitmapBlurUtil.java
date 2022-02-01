package com.tencent.biz.subscribe.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import mqq.os.MqqHandler;

public class MergeBitmapBlurUtil
{
  public static void a(String paramString, ImageView paramImageView)
  {
    ThreadManager.post(new MergeBitmapBlurUtil.1(paramString, paramImageView), 5, null, false);
  }
  
  private static void b(Bitmap paramBitmap, ImageView paramImageView)
  {
    ThreadManager.getUIHandler().post(new MergeBitmapBlurUtil.2(paramBitmap, paramImageView));
  }
  
  private static void b(String paramString, Bitmap paramBitmap, ImageView paramImageView)
  {
    if (paramBitmap != null)
    {
      Bitmap localBitmap = ImageUtil.a(paramImageView.getContext(), paramBitmap, 0.25F, 20.0F);
      if (localBitmap != null)
      {
        Canvas localCanvas = new Canvas();
        if (localBitmap.isMutable()) {
          localObject = localBitmap;
        } else {
          localObject = localBitmap.copy(localBitmap.getConfig(), true);
        }
        localCanvas.setBitmap((Bitmap)localObject);
        localCanvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
        Object localObject = VideoUtils.b(paramBitmap.getWidth(), paramBitmap.getHeight(), paramImageView.getWidth(), paramImageView.getHeight());
        paramBitmap = BitmapUtils.a(BitmapUtils.a(localBitmap, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), true), paramBitmap);
        b(paramBitmap, paramImageView);
        CommonImageCacheHelper.a(paramString, paramBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil
 * JD-Core Version:    0.7.0.1
 */