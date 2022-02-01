package com.tencent.biz.pubaccount.util;

import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class ScreenshotContentObserver$1
  extends FileObserver
{
  ScreenshotContentObserver$1(ScreenshotContentObserver paramScreenshotContentObserver, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver))) || (paramString.contains("temp")) || (ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver) == null)) {
      return;
    }
    ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ScreenshotContentObserver.1
 * JD-Core Version:    0.7.0.1
 */