package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QRDisplayActivity$9
  extends QidianBusinessObserver
{
  QRDisplayActivity$9(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mBusinessObserver onQidianGroupInfo qrcode url: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QRDisplayActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.a.b)
    {
      if (this.a.isFinishing()) {
        return;
      }
      if (!paramBoolean)
      {
        this.a.i();
        return;
      }
      localObject = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("url");
      this.a.a((String)localObject, 2, paramHashMap);
      paramHashMap = QRUtils.a(paramHashMap, -1);
      if (paramHashMap != null)
      {
        localObject = this.a;
        ((QRDisplayActivity)localObject).a = paramHashMap;
        ((QRDisplayActivity)localObject).h();
        return;
      }
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.9
 * JD-Core Version:    0.7.0.1
 */