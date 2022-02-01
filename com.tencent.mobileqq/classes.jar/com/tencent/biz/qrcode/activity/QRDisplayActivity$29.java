package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

class QRDisplayActivity$29
  implements ShareActionSheet.OnItemClickListener
{
  QRDisplayActivity$29(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    paramShareActionSheet.dismiss();
    QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() click item = " + paramActionSheetItem.action);
    switch (paramActionSheetItem.action)
    {
    default: 
      return;
    case 26: 
      if (QFileAssistantUtils.a())
      {
        QRDisplayActivity.a(this.a, 0, QFileAssistantUtils.a(this.a.app));
        return;
      }
      QRDisplayActivity.a(this.a, 6000, AppConstants.DATALINE_PC_UIN);
      return;
    case 72: 
      QRDisplayActivity.a(this.a, paramActionSheetItem.uinType, paramActionSheetItem.uin);
      return;
    case 2: 
      this.a.i = 0;
      QRDisplayActivity.a(this.a);
      return;
    case 3: 
      this.a.i = 1;
      QRDisplayActivity.a(this.a);
      return;
    case 9: 
      this.a.i = 2;
      QRDisplayActivity.a(this.a);
      return;
    case 10: 
      this.a.i = 3;
      QRDisplayActivity.a(this.a);
      return;
    case 39: 
      this.a.e();
      return;
    }
    this.a.i = 4;
    QRDisplayActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.29
 * JD-Core Version:    0.7.0.1
 */