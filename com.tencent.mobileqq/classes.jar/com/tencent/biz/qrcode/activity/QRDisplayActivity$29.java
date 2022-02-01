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
    paramShareActionSheet = new StringBuilder();
    paramShareActionSheet.append(" showMyQrCodeActionSheet() click item = ");
    paramShareActionSheet.append(paramActionSheetItem.action);
    QLog.d("QRDisplayActivity", 2, paramShareActionSheet.toString());
    int i = paramActionSheetItem.action;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 9)
          {
            if (i != 10)
            {
              if (i != 26)
              {
                if (i != 39)
                {
                  if (i != 72) {
                    return;
                  }
                  QRDisplayActivity.a(this.a, paramActionSheetItem.uinType, paramActionSheetItem.uin);
                  return;
                }
                this.a.e();
                return;
              }
              if (QFileAssistantUtils.a())
              {
                paramActionSheetItem = this.a;
                QRDisplayActivity.a(paramActionSheetItem, 0, QFileAssistantUtils.a(paramActionSheetItem.app));
                return;
              }
              QRDisplayActivity.a(this.a, 6000, AppConstants.DATALINE_PC_UIN);
              return;
            }
            paramActionSheetItem = this.a;
            paramActionSheetItem.i = 3;
            QRDisplayActivity.a(paramActionSheetItem);
            return;
          }
          paramActionSheetItem = this.a;
          paramActionSheetItem.i = 2;
          QRDisplayActivity.a(paramActionSheetItem);
          return;
        }
        paramActionSheetItem = this.a;
        paramActionSheetItem.i = 1;
        QRDisplayActivity.a(paramActionSheetItem);
        return;
      }
      paramActionSheetItem = this.a;
      paramActionSheetItem.i = 0;
      QRDisplayActivity.a(paramActionSheetItem);
      return;
    }
    paramActionSheetItem = this.a;
    paramActionSheetItem.i = 4;
    QRDisplayActivity.d(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.29
 * JD-Core Version:    0.7.0.1
 */