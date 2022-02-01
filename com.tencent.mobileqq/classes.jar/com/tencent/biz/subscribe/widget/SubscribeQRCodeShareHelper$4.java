package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class SubscribeQRCodeShareHelper$4
  implements ShareActionSheet.OnItemClickListener
{
  SubscribeQRCodeShareHelper$4(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    if (SubscribeQRCodeShareHelper.f(this.a) != null)
    {
      if (SubscribeQRCodeShareHelper.c(this.a) == null) {
        return;
      }
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 9)
          {
            if (i != 10)
            {
              if (i != 39) {
                return;
              }
              SubscribeQRCodeShareHelper.j(this.a);
              if ((SubscribeQRCodeShareHelper.f(this.a) != null) && (SubscribeQRCodeShareHelper.f(this.a).a() != null)) {
                VSReporter.a(SubscribeQRCodeShareHelper.f(this.a).a().poster.id.get(), "auth_pic_share", "clk_save_local", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.f(this.a).g(), SubscribeQRCodeShareHelper.f(this.a).d() });
              }
            }
            else
            {
              SubscribeQRCodeShareHelper.a(this.a, 1);
              if ((SubscribeQRCodeShareHelper.f(this.a) != null) && (SubscribeQRCodeShareHelper.f(this.a).a() != null)) {
                VSReporter.a(SubscribeQRCodeShareHelper.f(this.a).a().poster.id.get(), "auth_pic_share", "clk_moments", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.f(this.a).g(), SubscribeQRCodeShareHelper.f(this.a).d() });
              }
            }
          }
          else
          {
            SubscribeQRCodeShareHelper.a(this.a, 0);
            if ((SubscribeQRCodeShareHelper.f(this.a) != null) && (SubscribeQRCodeShareHelper.f(this.a).a() != null)) {
              VSReporter.a(SubscribeQRCodeShareHelper.f(this.a).a().poster.id.get(), "auth_pic_share", "clk_wechat", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.f(this.a).g(), SubscribeQRCodeShareHelper.f(this.a).d() });
            }
          }
        }
        else
        {
          SubscribeQRCodeShareHelper.i(this.a);
          if ((SubscribeQRCodeShareHelper.f(this.a) != null) && (SubscribeQRCodeShareHelper.f(this.a).a() != null)) {
            VSReporter.a(SubscribeQRCodeShareHelper.f(this.a).a().poster.id.get(), "auth_pic_share", "clk_qzone", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.f(this.a).g(), SubscribeQRCodeShareHelper.f(this.a).d() });
          }
        }
      }
      else
      {
        SubscribeQRCodeShareHelper.h(this.a);
        if ((SubscribeQRCodeShareHelper.f(this.a) != null) && (SubscribeQRCodeShareHelper.f(this.a).a() != null)) {
          VSReporter.a(SubscribeQRCodeShareHelper.f(this.a).a().poster.id.get(), "auth_pic_share", "clk_friends", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.f(this.a).g(), SubscribeQRCodeShareHelper.f(this.a).d() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.4
 * JD-Core Version:    0.7.0.1
 */