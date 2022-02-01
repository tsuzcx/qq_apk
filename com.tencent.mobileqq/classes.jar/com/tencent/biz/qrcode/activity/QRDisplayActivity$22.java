package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class QRDisplayActivity$22
  implements WXShareHelper.WXShareListener
{
  QRDisplayActivity$22(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (this.a.g != null)
    {
      if (!this.a.g.equals(paramBaseResp.transaction)) {
        return;
      }
      if (this.a.jdField_c_of_type_Int == 2)
      {
        String str1;
        if (this.a.i == 2) {
          str1 = "qr_wechat";
        } else {
          str1 = "qr_circle";
        }
        String str3 = this.a.jdField_c_of_type_JavaLangString;
        i = this.a.a;
        String str2;
        if (paramBaseResp.errCode == 0) {
          str2 = "0";
        } else {
          str2 = "1";
        }
        TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, String.valueOf(i), str2 });
      }
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QRUtils.a(1, 2131719009);
          this.a.a(false);
          return;
        }
        QRUtils.a(2, 2131719027);
        this.a.a(true);
        return;
      }
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.22
 * JD-Core Version:    0.7.0.1
 */