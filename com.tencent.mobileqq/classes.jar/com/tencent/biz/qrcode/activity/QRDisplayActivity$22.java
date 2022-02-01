package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class QRDisplayActivity$22
  implements WXShareHelper.WXShareListener
{
  QRDisplayActivity$22(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a.g == null) || (!this.a.g.equals(paramBaseResp.transaction))) {
      return;
    }
    String str1;
    label53:
    String str3;
    int i;
    if (this.a.jdField_c_of_type_Int == 2)
    {
      if (this.a.i != 2) {
        break label159;
      }
      str1 = "qr_wechat";
      str3 = this.a.jdField_c_of_type_JavaLangString;
      i = this.a.a;
      if (paramBaseResp.errCode != 0) {
        break label165;
      }
    }
    label159:
    label165:
    for (String str2 = "0";; str2 = "1")
    {
      TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, String.valueOf(i), str2 });
      switch (paramBaseResp.errCode)
      {
      case -1: 
      default: 
        QRUtils.a(1, 2131719291);
        this.a.a(false);
        return;
        str1 = "qr_circle";
        break label53;
      }
    }
    QRUtils.a(2, 2131719309);
    this.a.a(true);
    return;
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.22
 * JD-Core Version:    0.7.0.1
 */