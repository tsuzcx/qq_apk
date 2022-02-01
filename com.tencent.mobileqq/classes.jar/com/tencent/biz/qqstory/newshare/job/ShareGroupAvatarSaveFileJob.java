package com.tencent.biz.qqstory.newshare.job;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.shareGroup.icon.RestrictedBitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ShareGroupAvatarSaveFileJob
  extends ShareGroupAvatarJob
{
  private final String c;
  
  public ShareGroupAvatarSaveFileJob(String paramString1, String paramString2)
  {
    a(false, true);
    this.a = paramString1;
    this.c = paramString2;
  }
  
  private boolean a(RestrictedBitmap paramRestrictedBitmap)
  {
    boolean bool = false;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramRestrictedBitmap.a(), paramRestrictedBitmap.b(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramRestrictedBitmap.a(), 0.0F, 0.0F, null);
      ImageUtil.a(ImageUtil.a(localBitmap, 100), new File(this.c));
      bool = true;
    }
    catch (IOException paramRestrictedBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramRestrictedBitmap, new Object[0]);
      return false;
    }
    catch (OutOfMemoryError paramRestrictedBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramRestrictedBitmap, new Object[0]);
    }
    return bool;
    return false;
  }
  
  protected void a(RestrictedBitmap paramRestrictedBitmap)
  {
    ThreadManager.post(new ShareGroupAvatarSaveFileJob.1(this, paramRestrictedBitmap), 8, null, true);
  }
  
  protected void a(Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramError, new Object[0]);
    }
    b(false);
  }
  
  public void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("ShareGroupAvatarSaveFileJob_sgi"))) {
      this.a = ((String)a("ShareGroupAvatarSaveFileJob_sgi"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.ShareGroupAvatarSaveFileJob
 * JD-Core Version:    0.7.0.1
 */