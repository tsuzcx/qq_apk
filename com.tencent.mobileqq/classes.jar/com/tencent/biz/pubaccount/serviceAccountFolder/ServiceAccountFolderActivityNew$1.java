package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;

class ServiceAccountFolderActivityNew$1
  implements View.OnClickListener
{
  ServiceAccountFolderActivityNew$1(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  public void onClick(View paramView)
  {
    if (!FastClickUtils.a("service_account_folder_publish_feed_button", 2000L))
    {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 23) {
        bool = PermissionUtils.isStorePermissionEnable(this.a);
      } else {
        bool = true;
      }
      if (!bool)
      {
        DialogUtil.a(this.a);
      }
      else
      {
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("postUin", ServiceAccountFolderActivityNew.a(this.a));
        ((Intent)localObject).putExtra("sourceFrom", 2);
        if ((ServiceAccountFolderActivityNew.a(this.a) != null) && (ServiceAccountFolderActivityNew.a(this.a).user.youZhan.size() > 0))
        {
          if (((CertifiedAccountMeta.StYouZanShop)ServiceAccountFolderActivityNew.a(this.a).user.youZhan.get(0)).type.get() > 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((Intent)localObject).putExtra("has_shop", bool);
        }
        QZoneHelper.forwardToQQPublicAccountPublishPage(this.a.getActivity(), (Intent)localObject, 0);
        String str = ((CertifiedAccountMeta.StUser)ServiceAccountFolderActivityNew.a(this.a).user.get()).id.get();
        if (ServiceAccountFolderActivityNew.a(this.a) == 0) {
          localObject = "auth_follow";
        } else {
          localObject = "auth_discover";
        }
        VSReporter.a(str, (String)localObject, "post_clk", 0, 0, new String[] { "", "" });
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.1
 * JD-Core Version:    0.7.0.1
 */