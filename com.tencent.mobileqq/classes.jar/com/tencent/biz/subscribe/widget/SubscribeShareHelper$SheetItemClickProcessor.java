package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.res.Resources;
import com.tencent.biz.subscribe.SubscribeConstants;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class SubscribeShareHelper$SheetItemClickProcessor
  implements ShareActionSheet.OnItemClickListener
{
  private final SubscribeShareHelper.ShareActionItemClickListenr jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper$ShareActionItemClickListenr;
  
  public SubscribeShareHelper$SheetItemClickProcessor(SubscribeShareHelper paramSubscribeShareHelper, SubscribeShareHelper.ShareActionItemClickListenr paramShareActionItemClickListenr)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper$ShareActionItemClickListenr = paramShareActionItemClickListenr;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper.b();
    if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) == null) || (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper.a == null)) {}
    for (;;)
    {
      return;
      int i = paramActionSheetItem.action;
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper$ShareActionItemClickListenr != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper$ShareActionItemClickListenr.a(i);
      }
      switch (i)
      {
      }
      while ((i != 11) && (i != 40) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null))
      {
        SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper, SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, i - 1, SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
        SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
        continue;
        SubscribeShareHelper.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
        continue;
        SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper, i);
        continue;
        SubscribeShareHelper.c(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
        continue;
        SubscribeShareHelper.d(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
        continue;
        SubscribeShareHelper.e(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
        continue;
        if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          VSReporter.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
          SubscribeLaucher.a(SubscribeConstants.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
          continue;
          if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            SubscribeLaucher.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
            VSReporter.b(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
            continue;
            if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              SubscribeLaucher.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              VSReporter.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
              continue;
              SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper));
              if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
              {
                VSReporter.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).f(), SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).c() });
                continue;
                SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
                VSReporter.b(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                continue;
                if (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) {
                  if (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).b())
                  {
                    QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                    SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).e();
                  }
                  else
                  {
                    SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).i();
                    continue;
                    if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).c()))
                    {
                      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690976), 5000).a();
                      SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).f();
                      QLog.d("SubscribeShareHelper", 2, "mColorNoteController ： delete colorNote");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */