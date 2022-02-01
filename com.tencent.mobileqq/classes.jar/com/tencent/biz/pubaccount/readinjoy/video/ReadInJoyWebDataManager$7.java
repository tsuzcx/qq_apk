package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReadInJoyWebDataManager$7
  implements ReadInJoyWebDataManager.HttpFetchBizCallback
{
  ReadInJoyWebDataManager$7(ReadInJoyWebDataManager paramReadInJoyWebDataManager) {}
  
  public void a(JSONObject paramJSONObject)
  {
    ReadInJoyWebDataManager.a(this.a, paramJSONObject.toString());
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "preLoadMsgBox HttpFetchBizCallback jsonRetData result" + ReadInJoyWebDataManager.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.7
 * JD-Core Version:    0.7.0.1
 */