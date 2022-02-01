package com.tencent.mobileqq.activity.springfestival;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;

class HBEntryBannerView$1
  implements IPreloadRes.OnDownloadCallback
{
  HBEntryBannerView$1(HBEntryBannerView paramHBEntryBannerView, String paramString, int paramInt, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a)) && ((paramObject instanceof String)))
    {
      paramString = (String)paramObject;
      paramBoolean = FileUtils.fileExists(paramString);
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("playFireWorkAnimation onDownloadCallback exist = ");
        paramObject.append(paramBoolean);
        paramObject.append(",apngFilePath = ");
        paramObject.append(paramString);
        QLog.d("HBEntryBannerView", 2, paramObject.toString());
      }
      if (paramBoolean)
      {
        paramObject = new ApngOptions();
        paramObject.a(URLDrawableHelper.TRANSPARENT);
        paramObject.a(this.b);
        paramString = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", paramObject, paramString);
        HBEntryBannerView.a(this.d).setImageDrawable(paramString);
      }
      this.c.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryBannerView.1
 * JD-Core Version:    0.7.0.1
 */