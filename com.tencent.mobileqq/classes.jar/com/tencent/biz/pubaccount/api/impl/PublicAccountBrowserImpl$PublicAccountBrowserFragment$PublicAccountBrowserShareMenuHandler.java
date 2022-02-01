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
  
  public void C_()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mComponentsProvider.a(4);
    IPublicAccountH5AbilityPlugin localIPublicAccountH5AbilityPlugin = (IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class);
    if ((localSwiftBrowserShareMenuHandler != null) && (localSwiftBrowserShareMenuHandler.c()) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696404);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842738;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 34;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(2);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131718905);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846502;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(3);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696413);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846508;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isOSVersionSupportReadInJoy()) && (this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.getAppRuntime() != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("readinjoy_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.getAppRuntime().getAccount());
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(1);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
      if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696414);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839066;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 13;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList1.add(localObject1);
      }
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(9);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131719003);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846512;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(10);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131719004);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846514;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((localSwiftBrowserShareMenuHandler != null) && (localSwiftBrowserShareMenuHandler.b()) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696417);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839070;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 12;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(5);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131718904);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846491;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(4);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131718994);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846494;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
      QidianManager.a(BaseApplicationImpl.getApplication(), localArrayList1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject1) != null))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696411);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844486;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 20;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2;
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.e) && (this.b != null))
    {
      localObject1 = this.b.iterator();
      j = 0;
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject1).next();
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        i = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_Int;
        if (i != 1)
        {
          if (i == 2)
          {
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131695251);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842735;
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
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_JavaLangString)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695194);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_JavaLangString;
            }
            localActionSheetItem.icon = 2130842743;
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
    if (this.f)
    {
      j = i;
      if (this.b != null)
      {
        localObject1 = this.b.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject1).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          j = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_Int;
          if (j != 1)
          {
            if (j == 3)
            {
              localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696400);
              ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842744;
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
              if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_JavaLangString)) {
                localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695194);
              } else {
                localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_JavaLangString;
              }
              localActionSheetItem.icon = 2130842743;
              localActionSheetItem.iconNeedBg = true;
              localActionSheetItem.action = 37;
              localActionSheetItem.argus = "";
              localArrayList2.add(localActionSheetItem);
            }
          }
        }
      }
    }
    localObject1 = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mComponentsProvider.a(64);
    if ((localObject1 != null) && (((SwiftBrowserScreenShotHandler)localObject1).a()) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696424);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842742;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 21;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(6);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696385);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846548;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2)).a.b & 0x4000) == 0L))
    {
      localObject2 = d();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = PublicAccountBrowserImpl.PublicAccountBrowserFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment);
      }
      if (TeamWorkConvertUtils.a((String)localObject1))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696393);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130850938;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 68;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList2.add(localObject1);
        TeamWorkConvertUtils.a(0, 0);
      }
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(7);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696394);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846531;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(1);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696391);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846542;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_Long & 0x40) == 0L) && (j == 0))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(8);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((localSwiftBrowserShareMenuHandler != null) && (localSwiftBrowserShareMenuHandler.d()))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696407);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842740;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 38;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(11);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696397);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846574;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int i = paramActionSheetItem.action;
    if (i == 7)
    {
      super.onItemClick(paramActionSheetItem, paramShareActionSheet);
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.a(i);
      return;
    }
    if (i == 8)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.a(i);
      return;
    }
    super.onItemClick(paramActionSheetItem, paramShareActionSheet);
    if ((i != 2) && (i != 3))
    {
      if ((i == 6) && (this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.getAppRuntime() != null)) {
        ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.getAppRuntime().getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.getAppRuntime() != null) {
      ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.getAppRuntime().getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */