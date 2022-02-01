package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.qphone.base.util.QLog;

class FunnyPicHelper$CalcPath
{
  private IVipComicMqqManagerService a;
  private CustomEmotionData b;
  private String c;
  private boolean d;
  
  public FunnyPicHelper$CalcPath(IVipComicMqqManagerService paramIVipComicMqqManagerService, CustomEmotionData paramCustomEmotionData)
  {
    this.a = paramIVipComicMqqManagerService;
    this.b = paramCustomEmotionData;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public CalcPath c()
  {
    this.c = AppConstants.SDCARD_IMG_FAVORITE;
    this.d = false;
    Object localObject = this.a;
    if ((localObject != null) && (((IVipComicMqqManagerService)localObject).isComicEmoticon(this.b)))
    {
      if ((!TextUtils.isEmpty(this.b.emoPath)) && (this.b.emoPath.startsWith(AppConstants.SDCARD_IMG_FAVORITE)))
      {
        this.c = this.b.emoPath;
        return this;
      }
      if (!TextUtils.isEmpty(this.b.md5))
      {
        this.c = this.a.getFilePath(this.b.md5);
        return this;
      }
      if (!TextUtils.isEmpty(this.b.resid))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(DiySecureFileHelper.a(this.b.resid));
        this.c = ((StringBuilder)localObject).toString();
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(this.b.url.substring(this.b.url.lastIndexOf("/") + 1));
      this.c = ((StringBuilder)localObject).toString();
      return this;
    }
    if (this.b.url.contains("qto_"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(FunnyPicHelperConstant.a(this.b.url));
      this.c = ((StringBuilder)localObject).toString();
      return this;
    }
    if (!TextUtils.isEmpty(FunnyPicHelperConstant.a(this.b.eId)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(this.b.eId);
      this.c = ((StringBuilder)localObject).toString();
      this.d = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("emotion is FunnyPic path download from server->");
        ((StringBuilder)localObject).append(this.b.eId);
        QLog.d("FunyPicHelper", 2, ((StringBuilder)localObject).toString());
        return this;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(this.b.resid);
      this.c = ((StringBuilder)localObject).toString();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FunnyPicHelper.CalcPath
 * JD-Core Version:    0.7.0.1
 */