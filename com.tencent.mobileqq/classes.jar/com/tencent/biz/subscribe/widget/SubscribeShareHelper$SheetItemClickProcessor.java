package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.res.Resources;
import com.tencent.biz.subscribe.SubscribeConstants;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
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
    if (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper.a == null) {
        return;
      }
      int i = paramActionSheetItem.action;
      paramActionSheetItem = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper$ShareActionItemClickListenr;
      if (paramActionSheetItem != null) {
        paramActionSheetItem.a(i);
      }
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i != 40)
            {
              if (i != 70)
              {
                if (i != 82)
                {
                  if (i != 137) {
                    if (i != 157)
                    {
                      switch (i)
                      {
                      default: 
                        switch (i)
                        {
                        default: 
                          break;
                        case 155: 
                          if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) == null) || (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
                            break;
                          }
                          SubscribeLaucher.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
                          VSReporter.b(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
                          break;
                        case 154: 
                          SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
                          VSReporter.b(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                          break;
                        case 153: 
                          SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper));
                          if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) == null) || (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
                            break;
                          }
                          VSReporter.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).f(), SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).c() });
                          break;
                        case 152: 
                          if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) == null) || (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
                            break;
                          }
                          SubscribeLaucher.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
                          VSReporter.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
                        }
                        break;
                      case 11: 
                        SubscribeShareHelper.c(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
                        break;
                      case 9: 
                      case 10: 
                        SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper, i);
                        break;
                      }
                    }
                    else if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
                    {
                      VSReporter.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
                      SubscribeLaucher.a(SubscribeConstants.a(SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
                    }
                  }
                }
                else if ((SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).isColorNoteExist()))
                {
                  QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690896), 5000).a();
                  SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).deleteColorNote();
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ： delete colorNote");
                }
              }
              else if (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null) {
                if (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).canAddColorNote())
                {
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                  SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).insertColorNote();
                }
                else
                {
                  SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).onCannotAdd();
                }
              }
            }
            else {
              SubscribeShareHelper.e(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
            }
          }
          else {
            SubscribeShareHelper.d(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
          }
        }
        else {
          SubscribeShareHelper.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
        }
      }
      else {
        SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper);
      }
      if ((i != 11) && (i != 40) && (SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper) != null))
      {
        paramActionSheetItem = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper;
        SubscribeShareHelper.a(paramActionSheetItem, SubscribeShareHelper.a(paramActionSheetItem).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, i - 1, SubscribeShareHelper.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeShareHelper).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */