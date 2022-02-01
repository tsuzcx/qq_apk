package com.tencent.biz.qqstory.newshare.job;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class WeChatImageJob
  extends Job
{
  private Bitmap a;
  private Drawable b;
  private boolean c;
  private boolean d;
  
  public WeChatImageJob(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(false, true);
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    if (paramBitmap == null) {
      return null;
    }
    Object localObject2 = paramBitmap;
    Object localObject3 = paramBitmap;
    for (;;)
    {
      int m;
      Object localObject1;
      try
      {
        m = paramBitmap.getWidth();
        localObject2 = paramBitmap;
        localObject3 = paramBitmap;
        int n = paramBitmap.getHeight();
        if (m <= n) {
          break label341;
        }
        i = n;
        if (m <= n) {
          break label348;
        }
        localObject2 = paramBitmap;
        localObject3 = paramBitmap;
        j = (m - n) / 2;
        if (n <= m) {
          break label354;
        }
        localObject2 = paramBitmap;
        localObject3 = paramBitmap;
        k = (n - m) / 2;
        localObject2 = paramBitmap;
        localObject3 = paramBitmap;
        paramBitmap = Bitmap.createBitmap(paramBitmap, j, k, i, i, null, false);
        if (m * n > 8000)
        {
          double d1 = i * i;
          Double.isNaN(d1);
          d1 = 8000.0D / d1;
          localObject2 = paramBitmap;
          localObject3 = paramBitmap;
          d1 = Math.sqrt(d1);
          double d2 = i;
          Double.isNaN(d2);
          i = (int)(d2 * d1);
          localObject2 = paramBitmap;
          localObject3 = paramBitmap;
          localObject1 = Bitmap.createScaledBitmap(paramBitmap, i, i, true);
          try
          {
            paramBitmap.recycle();
            localObject2 = null;
            paramBitmap = (Bitmap)localObject1;
            localObject1 = localObject2;
          }
          catch (Exception localException1)
          {
            localObject2 = localObject1;
            localObject3 = paramBitmap;
            continue;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            localObject2 = localObject1;
            localObject3 = paramBitmap;
            continue;
          }
        }
        else
        {
          localObject2 = paramBitmap;
          localObject1 = paramBitmap;
          paramBitmap = (Bitmap)localObject2;
        }
      }
      catch (Exception localException2)
      {
        localObject3 = localObject2;
        localObject2 = localObject4;
        paramBitmap = (Bitmap)localObject2;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("WeChatImageJob", 2, localException2, new Object[0]);
          paramBitmap = (Bitmap)localObject2;
          localObject1 = localObject3;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localObject2 = localObject5;
        System.gc();
        paramBitmap = (Bitmap)localObject2;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("WeChatImageJob", 2, localOutOfMemoryError2, new Object[0]);
          localObject1 = localObject3;
          paramBitmap = (Bitmap)localObject2;
        }
      }
      if (paramBitmap == null) {
        return localObject1;
      }
      return paramBitmap;
      label341:
      int i = m;
      continue;
      label348:
      int j = 0;
      continue;
      label354:
      int k = 0;
    }
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (i > 0) {
      if (j <= 0) {
        return null;
      }
    }
    try
    {
      Object localObject = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (localObject != null) {
        try
        {
          Canvas localCanvas = new Canvas((Bitmap)localObject);
          localCanvas.drawColor(-1);
          paramDrawable.setBounds(0, 0, i, j);
          paramDrawable.draw(localCanvas);
          return localObject;
        }
        catch (Exception paramDrawable)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawableToBitmapWhiteBg ");
          ((StringBuilder)localObject).append(paramDrawable.getMessage());
          SLog.e("WeChatImageJob", ((StringBuilder)localObject).toString());
          return null;
        }
      }
      return localObject;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
    return null;
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Bitmap localBitmap1;
      if (paramBitmap.isMutable()) {
        localBitmap1 = paramBitmap;
      } else {
        localBitmap1 = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      }
      Canvas localCanvas = new Canvas(localBitmap1);
      Bitmap localBitmap2 = ImageUtil.a(BaseApplicationImpl.sApplication.getResources(), 2130848586);
      float f1 = paramBitmap.getWidth() / 2.0F;
      float f2 = paramBitmap.getHeight() / 2.0F;
      Object localObject;
      if (localBitmap2.getWidth() <= f1)
      {
        localObject = localBitmap2;
        if (localBitmap2.getHeight() <= f2) {}
      }
      else
      {
        float f3 = localBitmap2.getWidth();
        float f4 = localBitmap2.getHeight();
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f1 / f3, f2 / f4);
        int i = (int)f3;
        int j = (int)f4;
        try
        {
          localObject = Bitmap.createBitmap(localBitmap2, 0, 0, i, j, (Matrix)localObject, true);
          localBitmap2.recycle();
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject = localBitmap2;
          if (QLog.isColorLevel())
          {
            QLog.e("WeChatImageJob", 2, localOutOfMemoryError, new Object[0]);
            localObject = localBitmap2;
          }
        }
      }
      localCanvas.drawBitmap((Bitmap)localObject, paramBitmap.getWidth() / 2 - ((Bitmap)localObject).getWidth() / 2, paramBitmap.getHeight() / 2 - ((Bitmap)localObject).getHeight() / 2, new Paint());
      ((Bitmap)localObject).recycle();
      return localBitmap1;
    }
    return null;
  }
  
  public static Bitmap c(Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i > 0) {
      if (j <= 0) {
        return null;
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = localBitmap;
      if (localBitmap != null)
      {
        localObject = new Paint();
        ((Paint)localObject).setColor(-1);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawRect(0.0F, 0.0F, i, j, (Paint)localObject);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, (Paint)localObject);
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject3 = c((Bitmap)localObject1);
    }
    else
    {
      localObject1 = this.b;
      if (localObject1 == null) {
        break label137;
      }
      localObject3 = a((Drawable)localObject1);
    }
    localObject1 = localObject3;
    if (this.c) {
      localObject1 = TroopShareUtility.a(ImageUtil.c((Bitmap)localObject3, 70, 70));
    }
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = TroopShareUtility.a(ImageUtil.c(0));
    }
    localObject3 = a((Bitmap)localObject3);
    localObject1 = localObject3;
    Object localObject2;
    if (this.d) {
      try
      {
        localObject1 = b((Bitmap)localObject3);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addPlayIconInBitmapForWeChat oom error");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        SLog.c("WeChatImageJob", localStringBuilder.toString());
        localObject2 = localObject3;
      }
    }
    a("WeChatImageJob_out_bitmap", localObject2);
    b(true);
    return;
    label137:
    b(false);
  }
  
  public void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (paramMap.containsKey("WeChatImageJob_in_bitmap")) {
        this.a = ((Bitmap)b("WeChatImageJob_in_bitmap"));
      }
      if (paramMap.containsKey("WeChatImageJob_in_drawable")) {
        this.b = ((Drawable)b("WeChatImageJob_in_drawable"));
      }
    }
  }
  
  public boolean b()
  {
    return (this.a != null) || (this.b != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.WeChatImageJob
 * JD-Core Version:    0.7.0.1
 */