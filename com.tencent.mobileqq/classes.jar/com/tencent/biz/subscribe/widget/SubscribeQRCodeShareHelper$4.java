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
    if ((SubscribeQRCodeShareHelper.a(this.a) == null) || (SubscribeQRCodeShareHelper.a(this.a) == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              switch (i)
              {
              default: 
                return;
              case 2: 
                SubscribeQRCodeShareHelper.a(this.a);
              }
            } while ((SubscribeQRCodeShareHelper.a(this.a) == null) || (SubscribeQRCodeShareHelper.a(this.a).a() == null));
            VSReporter.a(SubscribeQRCodeShareHelper.a(this.a).a().poster.id.get(), "auth_pic_share", "clk_friends", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.a(this.a).f(), SubscribeQRCodeShareHelper.a(this.a).c() });
            return;
            SubscribeQRCodeShareHelper.b(this.a);
          } while ((SubscribeQRCodeShareHelper.a(this.a) == null) || (SubscribeQRCodeShareHelper.a(this.a).a() == null));
          VSReporter.a(SubscribeQRCodeShareHelper.a(this.a).a().poster.id.get(), "auth_pic_share", "clk_qzone", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.a(this.a).f(), SubscribeQRCodeShareHelper.a(this.a).c() });
          return;
          SubscribeQRCodeShareHelper.a(this.a, 0);
        } while ((SubscribeQRCodeShareHelper.a(this.a) == null) || (SubscribeQRCodeShareHelper.a(this.a).a() == null));
        VSReporter.a(SubscribeQRCodeShareHelper.a(this.a).a().poster.id.get(), "auth_pic_share", "clk_wechat", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.a(this.a).f(), SubscribeQRCodeShareHelper.a(this.a).c() });
        return;
        SubscribeQRCodeShareHelper.a(this.a, 1);
      } while ((SubscribeQRCodeShareHelper.a(this.a) == null) || (SubscribeQRCodeShareHelper.a(this.a).a() == null));
      VSReporter.a(SubscribeQRCodeShareHelper.a(this.a).a().poster.id.get(), "auth_pic_share", "clk_moments", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.a(this.a).f(), SubscribeQRCodeShareHelper.a(this.a).c() });
      return;
      SubscribeQRCodeShareHelper.c(this.a);
    } while ((SubscribeQRCodeShareHelper.a(this.a) == null) || (SubscribeQRCodeShareHelper.a(this.a).a() == null));
    VSReporter.a(SubscribeQRCodeShareHelper.a(this.a).a().poster.id.get(), "auth_pic_share", "clk_save_local", 0, 0, new String[] { null, null, SubscribeQRCodeShareHelper.a(this.a).f(), SubscribeQRCodeShareHelper.a(this.a).c() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.4
 * JD-Core Version:    0.7.0.1
 */