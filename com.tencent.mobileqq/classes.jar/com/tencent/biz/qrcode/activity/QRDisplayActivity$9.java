package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QRDisplayActivity$9
  extends QidianBusinessObserver
{
  QRDisplayActivity$9(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "mBusinessObserver onQidianGroupInfo qrcode url: " + paramBoolean);
    }
    if ((this.a.b) || (this.a.isFinishing())) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.i();
      return;
    }
    String str = (String)paramHashMap.get("uin");
    paramHashMap = (String)paramHashMap.get("url");
    this.a.a(str, 2, paramHashMap);
    paramHashMap = QRUtils.a(paramHashMap, -1);
    if (paramHashMap != null)
    {
      this.a.a = paramHashMap;
      this.a.h();
      return;
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.9
 * JD-Core Version:    0.7.0.1
 */