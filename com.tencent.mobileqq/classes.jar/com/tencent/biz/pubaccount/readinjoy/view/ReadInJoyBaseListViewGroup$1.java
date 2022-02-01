package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.ugc.KanDianVideoUploadUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService.ICallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ReadInJoyBaseListViewGroup$1
  implements KandianVideoUploadService.ICallBack
{
  ReadInJoyBaseListViewGroup$1(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup) {}
  
  public void a(Bundle paramBundle, float paramFloat)
  {
    String str = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "");
    if (this.a.jdField_a_of_type_JavaUtilMap.get(str) != null) {
      ((KandianProgressView)this.a.jdField_a_of_type_JavaUtilMap.get(str)).a((int)paramFloat);
    }
  }
  
  public void a(Bundle paramBundle, int paramInt, float paramFloat)
  {
    QLog.d("KandianVideoUpload", 1, paramBundle.getString("mTaskID") + "service中的状态:" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 200: 
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcKandianVideoUploadService$ICallBack.a(paramBundle, (int)paramFloat);
      return;
    case 202: 
      ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "failed");
      return;
    }
    KanDianVideoUploadUtils.b(paramBundle);
  }
  
  public void a(Bundle paramBundle, String paramString)
  {
    paramString = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.a, paramBundle, "failed");
    if (this.a.jdField_a_of_type_JavaUtilMap.get(paramString) != null) {
      ((KandianProgressView)this.a.jdField_a_of_type_JavaUtilMap.get(paramString)).a();
    }
  }
  
  public void a(String paramString)
  {
    this.a.a();
    ReadInJoyLogicEngine.a().b(true);
    ReadInJoyBaseListViewGroup.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup.1
 * JD-Core Version:    0.7.0.1
 */