package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ugc.KanDianVideoUploadUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyBaseListViewGroup$2
  implements KandianProgressView.ClickCallBack
{
  ReadInJoyBaseListViewGroup$2(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup) {}
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, str);
    KanDianVideoUploadUtils.b(paramBundle);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    paramString = this.a.a();
    Intent localIntent;
    if ((paramBundle != null) && (paramString != null))
    {
      localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      localIntent.setClass(paramString, KandianVideoUploadService.class);
    }
    try
    {
      paramString.startService(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("KandianVideoUpload", 1, "Kandian retryFail", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup.2
 * JD-Core Version:    0.7.0.1
 */