package com.tencent.mobileqq.activity.springfestival;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;

class HBEntryBannerView$1
  implements IPreloadRes.OnDownloadCallback
{
  HBEntryBannerView$1(HBEntryBannerView paramHBEntryBannerView, String paramString, int paramInt, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString)) && ((paramObject instanceof String)))
    {
      paramString = (String)paramObject;
      paramBoolean = FileUtils.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "playFireWorkAnimation onDownloadCallback exist = " + paramBoolean + ",apngFilePath = " + paramString);
      }
      if (paramBoolean)
      {
        paramObject = new VasApngFactory.Options();
        paramObject.a(URLDrawableHelper.TRANSPARENT);
        paramObject.a(this.jdField_a_of_type_Int);
        paramString = VasApngFactory.a("", paramObject, paramString);
        HBEntryBannerView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerView).setImageDrawable(paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalEntryManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryBannerView.1
 * JD-Core Version:    0.7.0.1
 */