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
  private final SubscribeShareHelper.ShareActionItemClickListenr b;
  
  public SubscribeShareHelper$SheetItemClickProcessor(SubscribeShareHelper paramSubscribeShareHelper, SubscribeShareHelper.ShareActionItemClickListenr paramShareActionItemClickListenr)
  {
    this.b = paramShareActionItemClickListenr;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.a.b();
    if (SubscribeShareHelper.a(this.a) != null)
    {
      if (this.a.a == null) {
        return;
      }
      int i = paramActionSheetItem.action;
      paramActionSheetItem = this.b;
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
                          if ((SubscribeShareHelper.a(this.a) == null) || (SubscribeShareHelper.a(this.a).b == null)) {
                            break;
                          }
                          SubscribeLaucher.a(SubscribeShareHelper.a(this.a).b.poster.yzOrderPage.get());
                          VSReporter.b(SubscribeShareHelper.a(this.a).b.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
                          break;
                        case 154: 
                          SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", SubscribeShareHelper.a(this.a).b.poster.id.get()));
                          VSReporter.b(SubscribeShareHelper.a(this.a).b.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                          break;
                        case 153: 
                          SubscribeShareHelper.g(this.a).a(SubscribeShareHelper.a(this.a));
                          if ((SubscribeShareHelper.a(this.a) == null) || (SubscribeShareHelper.a(this.a).b == null)) {
                            break;
                          }
                          VSReporter.a(SubscribeShareHelper.a(this.a).b.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, SubscribeShareHelper.a(this.a).g(), SubscribeShareHelper.a(this.a).d() });
                          break;
                        case 152: 
                          if ((SubscribeShareHelper.a(this.a) == null) || (SubscribeShareHelper.a(this.a).b == null)) {
                            break;
                          }
                          SubscribeLaucher.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", SubscribeShareHelper.a(this.a).b.poster.id.get()));
                          VSReporter.a(SubscribeShareHelper.a(this.a).b.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
                        }
                        break;
                      case 11: 
                        SubscribeShareHelper.d(this.a);
                        break;
                      case 9: 
                      case 10: 
                        SubscribeShareHelper.a(this.a, i);
                        break;
                      }
                    }
                    else if ((SubscribeShareHelper.a(this.a) != null) && (SubscribeShareHelper.a(this.a).b != null))
                    {
                      VSReporter.a(SubscribeShareHelper.a(this.a).b.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
                      SubscribeLaucher.a(SubscribeConstants.a(SubscribeShareHelper.a(this.a).b.poster.id.get()));
                    }
                  }
                }
                else if ((SubscribeShareHelper.h(this.a) != null) && (SubscribeShareHelper.h(this.a).isColorNoteExist()))
                {
                  QQToast.makeText(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131887835), 5000).show();
                  SubscribeShareHelper.h(this.a).deleteColorNote();
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ： delete colorNote");
                }
              }
              else if (SubscribeShareHelper.h(this.a) != null) {
                if (SubscribeShareHelper.h(this.a).canAddColorNote())
                {
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                  SubscribeShareHelper.h(this.a).insertColorNote();
                }
                else
                {
                  SubscribeShareHelper.h(this.a).onCannotAdd();
                }
              }
            }
            else {
              SubscribeShareHelper.f(this.a);
            }
          }
          else {
            SubscribeShareHelper.e(this.a);
          }
        }
        else {
          SubscribeShareHelper.c(this.a);
        }
      }
      else {
        SubscribeShareHelper.b(this.a);
      }
      if ((i != 11) && (i != 40) && (SubscribeShareHelper.a(this.a) != null))
      {
        paramActionSheetItem = this.a;
        SubscribeShareHelper.a(paramActionSheetItem, SubscribeShareHelper.a(paramActionSheetItem).b, i - 1, SubscribeShareHelper.a(this.a).e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */