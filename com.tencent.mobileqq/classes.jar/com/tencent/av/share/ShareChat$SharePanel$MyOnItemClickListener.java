package com.tencent.av.share;

import android.content.Context;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class ShareChat$SharePanel$MyOnItemClickListener
  implements ShareActionSheet.OnItemClickListener
{
  long jdField_a_of_type_Long = 0L;
  Context jdField_a_of_type_AndroidContentContext;
  
  public ShareChat$SharePanel$MyOnItemClickListener(ShareChat.SharePanel paramSharePanel, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    paramShareActionSheet = this.jdField_a_of_type_AndroidContentContext;
    if (paramShareActionSheet == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel$IHandle == null) {
      return;
    }
    int i = paramActionSheetItem.action;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i != 24)
            {
              if (i != 26)
              {
                if (i != 123)
                {
                  if (i != 9)
                  {
                    if (i != 10)
                    {
                      if (i != 72)
                      {
                        if (i != 73) {
                          return;
                        }
                        i = 73;
                      }
                      else
                      {
                        i = 72;
                      }
                    }
                    else {
                      i = 3;
                    }
                  }
                  else {
                    i = 2;
                  }
                }
                else {
                  i = 5;
                }
              }
              else {
                i = 26;
              }
            }
            else {
              i = 7;
            }
          }
          else {
            i = 6;
          }
        }
        else {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
    else {
      i = 4;
    }
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.jdField_a_of_type_Int = i;
    if ((i == 2) || (i == 3))
    {
      int j;
      if (!WXShareHelper.a().a()) {
        j = 2131720478;
      } else if (!WXShareHelper.a().b()) {
        j = 2131720479;
      } else {
        j = -1;
      }
      if (j != -1)
      {
        paramActionSheetItem = this.jdField_a_of_type_AndroidContentContext;
        QQToast.a(paramActionSheetItem, paramActionSheetItem.getString(j), 0).a();
        paramActionSheetItem = this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel;
        paramActionSheetItem.a(paramActionSheetItem.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b, 3);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onItemClick, mChoosedChannel[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.jdField_a_of_type_Int);
    localStringBuilder.append("], position[], id[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], mChoosedLinkType[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b == -1)
    {
      this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.b(this.jdField_a_of_type_Long, paramShareActionSheet, paramActionSheetItem);
      return;
    }
    this.jdField_a_of_type_ComTencentAvShareShareChat$SharePanel.a(this.jdField_a_of_type_Long, paramShareActionSheet, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.MyOnItemClickListener
 * JD-Core Version:    0.7.0.1
 */