package com.tencent.mobileqq.activity.springfestival;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;

class HBEntryShareActivity$2
  implements IPreloadRes.OnDownloadCallback
{
  HBEntryShareActivity$2(HBEntryShareActivity paramHBEntryShareActivity, String paramString, TextView paramTextView, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a)) && ((paramObject instanceof String)))
    {
      paramString = (String)paramObject;
      paramBoolean = FileUtils.fileExists(paramString);
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("initViewByIntent btnImgApngUrl onDownloadCallback exist = ");
        paramObject.append(paramBoolean);
        paramObject.append(",apngFilePath = ");
        paramObject.append(paramString);
        QLog.d("HBEntryShareActivity", 2, paramObject.toString());
      }
      if (paramBoolean)
      {
        paramObject = new ApngOptions();
        paramObject.a(URLDrawableHelperConstants.a);
        paramString = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", paramObject, paramString);
        this.b.setBackgroundDrawable(paramString);
        this.b.setOnTouchListener(this.d.a);
      }
      this.c.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryShareActivity.2
 * JD-Core Version:    0.7.0.1
 */