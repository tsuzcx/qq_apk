package com.tencent.comic.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.comic.VipComicShareReportUtils;
import com.tencent.comic.jsp.QQComicJsPlugin;
import com.tencent.comic.utils.VipComicUrlHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebColorNoteInjectImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.util.IWebColorNoteInject;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

class QQComicFragment$QQComicBrowserShareMenuHandler
  extends SwiftBrowserShareMenuHandler
{
  QQComicFragment$QQComicBrowserShareMenuHandler(QQComicFragment paramQQComicFragment) {}
  
  private void a(WebColorNoteInjectImpl paramWebColorNoteInjectImpl, QQBrowserActivity paramQQBrowserActivity)
  {
    if (paramWebColorNoteInjectImpl == null) {
      return;
    }
    Object localObject4 = this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getString(1996881920);
    Object localObject1 = this.jdField_a_of_type_ComTencentComicUiQQComicFragment.a();
    Object localObject2 = "";
    if (localObject1 != null)
    {
      localObject2 = ((QQComicJsPlugin)localObject1).c;
      localObject1 = ((QQComicJsPlugin)localObject1).d;
    }
    else
    {
      localObject1 = "";
    }
    Object localObject3 = localObject2;
    if (((String)localObject2).isEmpty())
    {
      localObject3 = localObject2;
      if (this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getSwiftTitleUI() != null) {
        if (!this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getSwiftTitleUI().a().isEmpty())
        {
          localObject3 = this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getSwiftTitleUI().a();
        }
        else
        {
          localObject2 = localObject4;
          break label117;
        }
      }
    }
    localObject2 = localObject3;
    label117:
    if (((String)localObject1).isEmpty())
    {
      localObject1 = localObject4;
      if (((String)localObject2).equals(localObject4)) {
        localObject1 = paramQQBrowserActivity.getOriginalUrl();
      }
    }
    localObject3 = paramQQBrowserActivity.getOriginalUrl();
    paramQQBrowserActivity = VipComicUrlHelper.a(VipComicUrlHelper.b((String)localObject3, "from", "1041001"), "from", "1041001");
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("originalUrl is ");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(" ,newUrl is ");
      ((StringBuilder)localObject4).append(paramQQBrowserActivity);
      QLog.d("WebLog_WebViewFragment", 2, ((StringBuilder)localObject4).toString());
    }
    localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("colorNoteType", 2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ColorNote mainTitle is ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(",subTitle is ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(",subType is ");
      localStringBuilder.append(paramQQBrowserActivity);
      QLog.d("WebLog_WebViewFragment", 2, localStringBuilder.toString());
    }
    paramWebColorNoteInjectImpl.a(new QQComicFragment.QQComicBrowserShareMenuHandler.1(this, paramQQBrowserActivity, (String)localObject2, (String)localObject1, ((JSONObject)localObject3).toString().getBytes()));
  }
  
  private void d()
  {
    IWebColorNoteInject localIWebColorNoteInject = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getWebColorNoteInjector();
    if (localIWebColorNoteInject != null) {
      localIWebColorNoteInject.a();
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentComicUiQQComicFragment.a();
    String str1 = localObject[0];
    String str2 = localObject[1];
    String str3 = localObject[2];
    String str4 = localObject[3];
    String str5 = localObject[4];
    VipComicShareReportUtils.a((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "6", str4, str5);
    if ((this.jdField_a_of_type_Long & 0x8) == 0L)
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      VipComicShareReportUtils.a((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "1", str4, str5);
    }
    if ((this.jdField_a_of_type_Long & 0x10) == 0L)
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      VipComicShareReportUtils.a((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "2", str4, str5);
    }
    boolean bool = WXShareHelper.a().a();
    if (((this.jdField_a_of_type_Long & 0x4000) == 0L) && (bool))
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      VipComicShareReportUtils.a((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "3", str4, str5);
    }
    if (((this.jdField_a_of_type_Long & 0x8000) == 0L) && (bool))
    {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      VipComicShareReportUtils.a((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "4", str4, str5);
    }
    ArrayList localArrayList1 = new ArrayList();
    if ((this.jdField_a_of_type_Long & 0x2000) == 0L)
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
      VipComicShareReportUtils.b((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "1", str4, str5);
    }
    QQComicJsPlugin localQQComicJsPlugin = this.jdField_a_of_type_ComTencentComicUiQQComicFragment.a();
    int i;
    if ((localQQComicJsPlugin != null) && (localQQComicJsPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0))
    {
      if (localQQComicJsPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (i != 0) {
        j = 117;
      } else {
        j = 116;
      }
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(j));
      if (i != 0) {
        localObject = "5";
      } else {
        localObject = "4";
      }
      VipComicShareReportUtils.b((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, (String)localObject, str4, str5);
    }
    localObject = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
    String str6 = ((QQBrowserActivity)localObject).getOriginalUrl();
    if ((str6 != null) && (str6.indexOf("cancelColorTab=1") == -1))
    {
      WebColorNoteInjectImpl localWebColorNoteInjectImpl = (WebColorNoteInjectImpl)((QQBrowserActivity)localObject).getWebColorNoteInjector();
      if (localWebColorNoteInjectImpl != null)
      {
        a(localWebColorNoteInjectImpl, (QQBrowserActivity)localObject);
        if (localWebColorNoteInjectImpl.a(str6))
        {
          i = 70;
          if (localWebColorNoteInjectImpl.c())
          {
            i = 82;
            localObject = "3";
          }
          else
          {
            localObject = "2";
          }
          localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(i));
          VipComicShareReportUtils.b((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, (String)localObject, str4, str5);
        }
      }
    }
    if ((localQQComicJsPlugin != null) && ((localQQComicJsPlugin.jdField_a_of_type_Int & 0x2) > 0))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
      VipComicShareReportUtils.b((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "9", str4, str5);
    }
    if ((localQQComicJsPlugin != null) && ((localQQComicJsPlugin.jdField_a_of_type_Int & 0x1) > 0))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
      VipComicShareReportUtils.b((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "10", str4, str5);
    }
    return (List[])new ArrayList[] { localArrayList2, localArrayList1 };
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int j = paramActionSheetItem.action;
    paramShareActionSheet = d();
    Object localObject = this.jdField_a_of_type_ComTencentComicUiQQComicFragment.a();
    String str1 = localObject[0];
    String str2 = localObject[1];
    String str3 = localObject[2];
    String str4 = localObject[3];
    localObject = localObject[4];
    if ((j != 2) && (j != 73))
    {
      if (j == 3)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
        {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 2, false);
          return;
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 2, false);
        return;
      }
      if ((j != 9) && (j != 10))
      {
        if (j == 14)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
            return;
          }
          this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p, new String[] { "6" });
          VipComicShareReportUtils.c((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "1", str4, (String)localObject);
          return;
        }
        if (j == 117)
        {
          VipComicShareReportUtils.c((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "5", str4, (String)localObject);
          this.jdField_a_of_type_ComTencentComicUiQQComicFragment.a();
          return;
        }
        if (j == 116)
        {
          VipComicShareReportUtils.c((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "4", str4, (String)localObject);
          this.jdField_a_of_type_ComTencentComicUiQQComicFragment.a();
          return;
        }
        if (j == 70)
        {
          VipComicShareReportUtils.c((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "2", str4, (String)localObject);
          d();
          return;
        }
        if (j == 82)
        {
          VipComicShareReportUtils.c((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "3", str4, (String)localObject);
          d();
          return;
        }
        if (j == 72)
        {
          if (this.jdField_a_of_type_AndroidOsBundle == null) {
            this.jdField_a_of_type_AndroidOsBundle = new Bundle();
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("to_qq", paramActionSheetItem.uin);
          this.jdField_a_of_type_AndroidOsBundle.putString("to_uin_name", paramActionSheetItem.label);
          this.jdField_a_of_type_AndroidOsBundle.putInt("to_uin_type", paramActionSheetItem.uinType);
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
          {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 1, false);
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a != null)
          {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().show();
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a.callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p, new String[] { String.valueOf(101) });
          }
        }
        else if (j == 40)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
          {
            VipComicShareReportUtils.c((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "10", str4, (String)localObject);
            this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p, new String[] { "7" });
          }
        }
        else if ((j == 11) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)))
        {
          VipComicShareReportUtils.c((AppInterface)this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getAppRuntime(), str1, str2, str3, "9", str4, (String)localObject);
          this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getWebView().callJs(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p, new String[] { "8" });
        }
      }
      else
      {
        int i;
        if (!WXShareHelper.a().a()) {
          i = 2131720478;
        } else if (!WXShareHelper.a().b()) {
          i = 2131720479;
        } else {
          i = -1;
        }
        if (i != -1)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getContext(), 0, i, 1).b(this.jdField_a_of_type_ComTencentComicUiQQComicFragment.getResources().getDimensionPixelSize(1996619776));
          return;
        }
        if (j == 9)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
          {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 3, true);
            return;
          }
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 3, true);
          return;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
        {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 4, true);
          return;
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 4, true);
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 1, false);
        return;
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramShareActionSheet, 1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicFragment.QQComicBrowserShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */