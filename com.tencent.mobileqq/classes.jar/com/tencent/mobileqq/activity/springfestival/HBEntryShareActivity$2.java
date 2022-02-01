package com.tencent.mobileqq.activity.springfestival;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;

class HBEntryShareActivity$2
  implements IPreloadRes.OnDownloadCallback
{
  HBEntryShareActivity$2(HBEntryShareActivity paramHBEntryShareActivity, String paramString, TextView paramTextView, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString)) && ((paramObject instanceof String)))
    {
      paramString = (String)paramObject;
      paramBoolean = FileUtils.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryShareActivity", 2, "initViewByIntent btnImgApngUrl onDownloadCallback exist = " + paramBoolean + ",apngFilePath = " + paramString);
      }
      if (paramBoolean)
      {
        paramObject = new VasApngFactory.Options();
        paramObject.a(URLDrawableHelper.TRANSPARENT);
        paramString = VasApngFactory.a("", paramObject, paramString);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramString);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryShareActivity.a);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalEntryManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryShareActivity.2
 * JD-Core Version:    0.7.0.1
 */