package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class SpringPopBanner$4
  implements IPreloadService.OnGetPathListener
{
  SpringPopBanner$4(SpringPopBanner paramSpringPopBanner, int paramInt, String paramString) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResult: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", path: ");
      localStringBuilder.append(paramPathResult.filePath);
      QLog.d("shua2021_SpringPopBanner", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.filePath))) {
      SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner).a().runOnUiThread(new SpringPopBanner.4.1(this, paramPathResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringPopBanner.4
 * JD-Core Version:    0.7.0.1
 */