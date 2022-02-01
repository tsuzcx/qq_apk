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
  long a = 0L;
  Context b;
  
  public ShareChat$SharePanel$MyOnItemClickListener(ShareChat.SharePanel paramSharePanel, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    paramShareActionSheet = this.b;
    if (paramShareActionSheet == null) {
      return;
    }
    if (this.c.d != null) {
      this.c.d.dismiss();
    }
    if (this.c.f == null) {
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
    this.c.b = i;
    if ((i == 2) || (i == 3))
    {
      int j;
      if (!WXShareHelper.a().b()) {
        j = 2131918154;
      } else if (!WXShareHelper.a().c()) {
        j = 2131918155;
      } else {
        j = -1;
      }
      if (j != -1)
      {
        paramActionSheetItem = this.b;
        QQToast.makeText(paramActionSheetItem, paramActionSheetItem.getString(j), 0).show();
        paramActionSheetItem = this.c;
        paramActionSheetItem.a(paramActionSheetItem.b, this.c.c, 3);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onItemClick, mChoosedChannel[");
    localStringBuilder.append(this.c.b);
    localStringBuilder.append("], position[], id[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], mChoosedLinkType[");
    localStringBuilder.append(this.c.c);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    if (this.c.c == -1)
    {
      this.c.b(this.a, paramShareActionSheet, paramActionSheetItem);
      return;
    }
    this.c.a(this.a, paramShareActionSheet, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.MyOnItemClickListener
 * JD-Core Version:    0.7.0.1
 */