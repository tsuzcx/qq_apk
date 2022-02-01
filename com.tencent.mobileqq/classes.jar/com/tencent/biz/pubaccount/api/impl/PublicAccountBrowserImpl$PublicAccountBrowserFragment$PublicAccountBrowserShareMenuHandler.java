package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface.ActionItem;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qidian.QidianManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$PublicAccountBrowserShareMenuHandler
  extends SwiftBrowserShareMenuHandler
{
  private PublicAccountBrowserImpl$PublicAccountBrowserFragment$PublicAccountBrowserShareMenuHandler(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] aE_()
  {
    ArrayList localArrayList1 = new ArrayList();
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.a.mComponentsProvider.a(4);
    IPublicAccountH5AbilityPlugin localIPublicAccountH5AbilityPlugin = (IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class);
    if ((localSwiftBrowserShareMenuHandler != null) && (localSwiftBrowserShareMenuHandler.l()) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:diandian")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894176);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843691;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 34;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:qq")) && ((this.j & 0x8) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(2);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131916439);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848015;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:QZone")) && ((this.j & 0x10) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(3);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894185);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848021;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if (((this.j & 0x8000000) != 0L) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isOSVersionSupportReadInJoy()) && (this.a.getAppRuntime() != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("readinjoy_");
      ((StringBuilder)localObject1).append(this.a.getAppRuntime().getAccount());
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(1);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
      if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894186);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839220;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 13;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList1.add(localObject1);
      }
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:appMessage")) && ((this.j & 0x4000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(9);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131916538);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848025;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:timeline")) && ((this.j & 0x8000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(10);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131916539);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848027;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((localSwiftBrowserShareMenuHandler != null) && (localSwiftBrowserShareMenuHandler.k()) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894189);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839224;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 12;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:openWithQQBrowser")) && ((this.j & 0x200) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(5);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131916438);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848004;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:openWithSafari")) && ((this.j & 0x100) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(4);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131916529);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848007;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:qiDian")) && ((this.j & 0x10) == 0L)) {
      QidianManager.a(BaseApplicationImpl.getApplication(), localArrayList1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:qiYeQQ")) && ((this.j & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894183);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130845859;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 20;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2;
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.y) && (this.A != null))
    {
      localObject1 = this.A.iterator();
      j = 0;
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject1).next();
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        i = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).a;
        if (i != 1)
        {
          if (i == 2)
          {
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131892985);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130843688;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 31;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
            localArrayList2.add(localObject2);
          }
        }
        else {
          for (;;)
          {
            j = 1;
            break;
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject2).b)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131892927);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).b;
            }
            localActionSheetItem.icon = 2130843696;
            localActionSheetItem.iconNeedBg = true;
            localActionSheetItem.action = 30;
            localActionSheetItem.argus = "";
            localArrayList2.add(localActionSheetItem);
          }
        }
      }
    }
    int i = 0;
    int j = i;
    if (this.z)
    {
      j = i;
      if (this.A != null)
      {
        localObject1 = this.A.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject1).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          j = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).a;
          if (j != 1)
          {
            if (j == 3)
            {
              localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131894172);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130843697;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 35;
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
              localArrayList2.add(localObject2);
            }
          }
          else {
            for (;;)
            {
              i = 1;
              break;
              if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject2).b)) {
                localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131892927);
              } else {
                localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).b;
              }
              localActionSheetItem.icon = 2130843696;
              localActionSheetItem.iconNeedBg = true;
              localActionSheetItem.action = 37;
              localActionSheetItem.argus = "";
              localArrayList2.add(localActionSheetItem);
            }
          }
        }
      }
    }
    localObject1 = (SwiftBrowserScreenShotHandler)this.a.mComponentsProvider.a(64);
    if ((localObject1 != null) && (((SwiftBrowserScreenShotHandler)localObject1).e()) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:screenShotShare")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894196);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843695;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 21;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:favorite")) && ((this.j & 0x2000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(6);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894157);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848061;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:exportTencentDocs")) && ((((SwiftBrowserUIStyleHandler)this.b.d().a(2)).f.d & 0x4000) == 0L))
    {
      localObject2 = g();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = PublicAccountBrowserImpl.PublicAccountBrowserFragment.g(this.a);
      }
      if (TeamWorkConvertUtils.a((String)localObject1))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894165);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130852790;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 68;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList2.add(localObject1);
        TeamWorkConvertUtils.a(0, 0);
      }
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:setFont")) && (this.g))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(7);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894166);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848044;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:copyUrl")) && ((this.j & 0x20) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(1);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894163);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848055;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!TextUtils.isEmpty(this.n)) && ((this.j & 0x40) == 0L) && (j == 0))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(8);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((localSwiftBrowserShareMenuHandler != null) && (localSwiftBrowserShareMenuHandler.m()))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894179);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843693;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 38;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:exposeArticle"))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(11);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131894169);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130848087;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
  }
  
  public void b()
  {
    this.d = null;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.h.dismiss();
    int i = paramActionSheetItem.action;
    if (i == 7)
    {
      super.onItemClick(paramActionSheetItem, paramShareActionSheet);
      this.a.a(i);
      return;
    }
    if (i == 8)
    {
      this.a.a(this.n);
      this.a.a(i);
      return;
    }
    super.onItemClick(paramActionSheetItem, paramShareActionSheet);
    if ((i != 2) && (i != 3))
    {
      if ((i == 6) && (this.a.getAppRuntime() != null)) {
        ReportController.b(null, "CliOper", "", this.a.getAppRuntime().getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
      }
    }
    else if (this.a.getAppRuntime() != null) {
      ReportController.b(null, "CliOper", "", this.a.getAppRuntime().getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */