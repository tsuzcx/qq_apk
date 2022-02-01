package com.tencent.biz.pubaccount.api.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface.ActionItem;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qidian.QidianManager;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$PublicAccountBrowserShareMenuHandler
  extends SwiftBrowserShareMenuHandler
{
  private PublicAccountBrowserImpl$PublicAccountBrowserFragment$PublicAccountBrowserShareMenuHandler(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void a()
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
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696385);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842838;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 34;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(2);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131719187);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846622;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(3);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696394);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846628;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (ReadInJoyHelper.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mApp != null))
    {
      localObject1 = "readinjoy_" + this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mApp.getAccount() + "_" + 1;
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
      if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean("share_to_news", false)))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696395);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839213;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 13;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList1.add(localObject1);
      }
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(9);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131719285);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846632;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(10);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131719286);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846634;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((localSwiftBrowserShareMenuHandler != null) && (localSwiftBrowserShareMenuHandler.b()) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696398);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839217;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 12;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(5);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131719186);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846611;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(4);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131719276);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846614;
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
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696392);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130844580;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 20;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList1.add(localObject1);
    }
    ArrayList localArrayList2 = new ArrayList();
    int i;
    Object localObject2;
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.e) && (this.b != null))
    {
      localObject1 = this.b.iterator();
      j = 0;
      i = j;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject1).next();
        localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        switch (((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_Int)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          j = i;
          break;
          if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_JavaLangString)) {}
          for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695202);; localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_JavaLangString)
          {
            localActionSheetItem.icon = 2130842843;
            localActionSheetItem.iconNeedBg = true;
            localActionSheetItem.action = 30;
            localActionSheetItem.argus = "";
            localArrayList2.add(localActionSheetItem);
            i = 1;
            break;
          }
          localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131695255);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842835;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 31;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
          localArrayList2.add(localObject2);
          i = 1;
        }
      }
    }
    else
    {
      i = 0;
    }
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
          switch (((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_JavaLangString)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695202);; localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject2).jdField_a_of_type_JavaLangString)
            {
              localActionSheetItem.icon = 2130842843;
              localActionSheetItem.iconNeedBg = true;
              localActionSheetItem.action = 37;
              localActionSheetItem.argus = "";
              localArrayList2.add(localActionSheetItem);
              i = 1;
              break;
            }
          case 3: 
            localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131696381);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130842844;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 35;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
            localArrayList2.add(localObject2);
            i = 1;
          }
        }
      }
    }
    localObject1 = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mComponentsProvider.a(64);
    if ((localObject1 != null) && (((SwiftBrowserScreenShotHandler)localObject1).a()) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696405);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842842;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 21;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(6);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696366);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846668;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2)).a.b & 0x4000) == 0L))
    {
      localObject2 = a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mUrl;
      }
      if (TeamWorkConvertUtils.a((String)localObject1))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696374);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130850998;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 68;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        localArrayList2.add(localObject1);
        TeamWorkConvertUtils.a(0, 0);
      }
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(7);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696375);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846651;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(1);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696372);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846662;
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
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696388);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130842840;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 38;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
      localArrayList2.add(localObject1);
    }
    if (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(11);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131696378);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130846694;
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
    }
    do
    {
      do
      {
        return;
        if (i == 8)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.a(i);
          return;
        }
        super.onItemClick(paramActionSheetItem, paramShareActionSheet);
        if ((i != 2) && (i != 3)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mApp == null);
      ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mApp.getCurrentAccountUin(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
      return;
    } while ((i != 6) || (this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mApp == null));
    ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountBrowserImpl$PublicAccountBrowserFragment.mApp.getCurrentAccountUin(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.PublicAccountBrowserShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */