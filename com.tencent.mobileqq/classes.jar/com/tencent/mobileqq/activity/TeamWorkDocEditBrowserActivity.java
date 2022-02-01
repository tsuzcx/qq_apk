package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TencentDocsPushBean;
import com.tencent.mobileqq.config.business.TencentDocsPushItemBean;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkDocEditBrowserActivity
  extends QQBrowserActivity
{
  public AppInterface a;
  
  public TeamWorkDocEditBrowserActivity()
  {
    this.mFragmentClass = TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.class;
  }
  
  public static Intent a(Intent paramIntent, String paramString, Context paramContext)
  {
    paramIntent.putExtra("title", " ");
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("webStyle", "noBottomBar");
    paramIntent.putExtra("isScreenOrientationPortrait", true);
    paramIntent.putExtra("url", paramString);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramIntent.putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
    return paramIntent;
  }
  
  public static void a(Context paramContext, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject3;
    Object localObject1;
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      localObject3 = paramBundle.getString("tdsourcetag");
      if (localObject3 != null)
      {
        localObject2 = paramBundle.getString("url");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).contains("tdsourcetag")) {
            localObject1 = TeamWorkUtils.b((String)localObject2, (String)localObject3);
          }
        }
        if (a(paramContext, (String)localObject1, (String)localObject3, paramBundle.getBoolean("temp_preview_from_qq")))
        {
          QLog.e("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp");
          localObject1 = paramBundle.getString("tdsourcetag", "");
          if (((paramContext instanceof Activity)) && ((((String)localObject1).equals("s_QQ_file_share_edit")) || (((String)localObject1).equals("s_qq_file_edit"))))
          {
            QLog.d("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp in TeamWorkDocEditBrowserActivity");
            ((Activity)paramContext).finish();
          }
          TeamWorkUtils.a(paramBundle, "0X8009ED7");
          return;
        }
      }
      TeamWorkUtils.a(paramBundle, "0X8009ED6");
      localObject3 = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
      Object localObject2 = paramBundle.getString("url");
      i = paramBundle.getInt("key_team_work_edit_type");
      localObject1 = localObject2;
      Object localObject4;
      Object localObject5;
      if (TeamWorkUtils.b((String)localObject2))
      {
        localObject1 = localObject2;
        if ((paramContext instanceof FragmentActivity))
        {
          localObject4 = (FragmentActivity)paramContext;
          localObject5 = ((FragmentActivity)localObject4).getChatFragment();
          localObject1 = localObject2;
          if (localObject5 != null)
          {
            localObject5 = ((ChatFragment)localObject5).a();
            localObject1 = localObject2;
            if (localObject5 != null)
            {
              String str = ((BaseChatPie)localObject5).a.jdField_a_of_type_JavaLangString;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(str)) {
                  if (((BaseChatPie)localObject5).a.jdField_a_of_type_Int != 0)
                  {
                    localObject1 = localObject2;
                    if (((BaseChatPie)localObject5).a.jdField_a_of_type_Int != 1) {}
                  }
                  else
                  {
                    localObject4 = TeamWorkUtils.a(((FragmentActivity)localObject4).app, str, ((BaseChatPie)localObject5).a.jdField_a_of_type_Int);
                    localObject1 = "?" + (String)localObject4;
                    if (((String)localObject2).contains("?")) {
                      localObject1 = "&" + (String)localObject4;
                    }
                    localObject1 = (String)localObject2 + (String)localObject1;
                  }
                }
              }
            }
          }
        }
      }
      if (paramBundle.getBoolean("temp_preview_from_qq")) {
        ((Intent)localObject3).putExtra("temp_preview_from_qq", true);
      }
      if (paramBundle.getParcelable("key_team_work_file_import_info") != null)
      {
        ((Intent)localObject3).putExtra("key_team_work_file_import_info", paramBundle.getParcelable("key_team_work_file_import_info"));
        if (((TeamWorkFileImportInfo)paramBundle.getParcelable("key_team_work_file_import_info")).f) {
          ((Intent)localObject3).putExtra("key_is_new_pad_flag", true);
        }
      }
      if (paramBundle.getBoolean("doc_from_aio", false))
      {
        ((Intent)localObject3).putExtra("doc_from_aio", true);
        if ((((Intent)localObject3).getBooleanExtra("doc_from_aio", false)) && ((paramContext instanceof FragmentActivity)))
        {
          localObject2 = (FragmentActivity)paramContext;
          localObject4 = ((FragmentActivity)localObject2).getChatFragment();
          if (localObject4 != null)
          {
            localObject4 = ((ChatFragment)localObject4).a();
            if (localObject4 != null)
            {
              localObject5 = ((BaseChatPie)localObject4).a.jdField_a_of_type_JavaLangString;
              int j = ((BaseChatPie)localObject4).a.jdField_a_of_type_Int;
              if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (j != -1))
              {
                ((Intent)localObject3).putExtra("doc_from_aio_uin", (String)localObject5);
                ((Intent)localObject3).putExtra("doc_from_aio_peertype", j);
                ((Intent)localObject3).putExtra("doc_from_aio_nickname", ContactUtils.b(((FragmentActivity)localObject2).app, (String)localObject5, j));
              }
            }
          }
        }
        if (paramBundle.getBoolean("doc_from_forward_dialog", false)) {
          ((Intent)localObject3).putExtra("doc_from_forward_dialog", true);
        }
        if (paramBundle.getString("tdsourcetag") == null) {
          break label838;
        }
        localObject2 = paramBundle.getString("tdsourcetag");
        ((Intent)localObject3).putExtra("tdsourcetag", (String)localObject2);
        ((Intent)localObject3).putExtra("url", TeamWorkUtils.b((String)localObject1, (String)localObject2));
        label670:
        ((Intent)localObject3).putExtra("key_team_work_edit_type", i);
        ((Intent)localObject3).putExtra("hide_more_button", true);
        ((Intent)localObject3).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject3).putExtra("isScreenOrientationPortrait", true);
        ((Intent)localObject3).putExtra("title", " ");
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_file");
        if (TextUtils.isEmpty(((Intent)localObject3).getStringExtra("big_brother_source_key"))) {
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
        }
        if (paramBundle.getBoolean("doc_from_forward_dialog", false)) {
          break label851;
        }
        i = 1;
        label762:
        if (i != 0) {
          ((Intent)localObject3).addFlags(603979776);
        }
        if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
          break label895;
        }
      }
    }
    label838:
    label851:
    label895:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((Activity)paramContext).startActivityForResult((Intent)localObject3, 14001);
        return;
        if ((BaseActivity.sTopActivity == null) || (!(BaseActivity.sTopActivity instanceof SplashActivity)) || (SplashActivity.currentFragment != 2)) {
          break;
        }
        ((Intent)localObject3).putExtra("doc_from_aio", true);
        break;
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        break label670;
        i = 0;
        break label762;
      }
      paramContext.startActivity((Intent)localObject3);
      return;
      QQToast.a(BaseApplication.getContext(), paramContext.getResources().getString(2131692257), 0).b(paramContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, false);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString2 == null) || (paramContext == null)) {
      return false;
    }
    String str3 = (String)TeamWorkUtils.a.get(paramString2);
    if (str3 == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp:configType " + str3);
    }
    paramString2 = (TencentDocsPushBean)QConfigManager.a().a(418);
    if (paramString2 == null) {
      return false;
    }
    paramString2 = (TencentDocsPushItemBean)paramString2.a().get(str3);
    if (paramString2 == null) {
      return false;
    }
    if (paramString2.a())
    {
      Object localObject = paramString2.c();
      if (TextUtils.isEmpty(paramString1)) {}
      try
      {
        String str4 = paramString2.a();
        String str2 = paramString2.b();
        String str1 = "";
        paramString2 = str2;
        localObject = str1;
        if (!str3.equals("docs_miniapp_config_templatelist"))
        {
          if (!TextUtils.isEmpty(paramString1)) {
            break label373;
          }
          paramString2 = new StringBuilder().append(str2).append("?needSave=");
          if (!paramBoolean) {
            break label366;
          }
        }
        label366:
        for (paramString1 = "1";; paramString1 = "0")
        {
          paramString2 = paramString1;
          localObject = str1;
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(paramContext, str4, paramString2, (String)localObject, null, null, 2012, null);
          if (QLog.isColorLevel()) {
            QLog.i("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp:open :scene = " + 2012 + "miniAppId = " + str4 + "entryPath = " + paramString2 + "navigateExtData = " + (String)localObject);
          }
          return true;
          if (paramString1.contains("showh5=1"))
          {
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkDocEditBrowserActivity", 2, "url参数showh5=1, 不走小程序");
            }
            return false;
          }
          if ((paramString1.contains("showh5=0")) || (TextUtils.isEmpty((CharSequence)localObject)) || (!Pattern.matches((String)localObject, paramString1))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TeamWorkDocEditBrowserActivity", 2, "url命中黑名单, 不走小程序");
          }
          return false;
        }
        label373:
        localObject = new StringBuilder().append(str2).append("?url=").append(URLEncoder.encode(paramString1, "utf-8")).append("&needSave=");
        if (paramBoolean) {}
        for (paramString2 = "1";; paramString2 = "0")
        {
          paramString2 = paramString2;
          localObject = "url=" + paramString1;
          break;
        }
        return false;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkDocEditBrowserActivity", 2, "openDocsMiniApp " + paramContext.getMessage());
        }
        if (TextUtils.equals(str3, "s_qq_mini_importing")) {
          TenDocLogReportHelper.a(null, "0X800A4B5");
        }
      }
    }
  }
  
  public ArrayList<String> a(ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return paramArrayList;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    String str;
    label192:
    HashMap localHashMap;
    Object localObject3;
    if (i < paramArrayList.size())
    {
      str = (String)paramArrayList.get(i);
      if (FileUtil.a(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TeamWorkDocEditBrowserActivity", 4, "local url:" + str);
        }
        if (FileUtil.a(str) <= 5242880L) {
          break label452;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TeamWorkDocEditBrowserActivity", 4, "file length:" + FileUtil.a(str));
        }
        if ((paramInt != 0) || (GifDrawable.isGifFile(new File(str)))) {
          break label446;
        }
        localObject1 = QZoneShareManager.compressImages(str, i);
        if (localObject1 == null) {
          break label444;
        }
        str = ((File)localObject1).getAbsolutePath();
        localArrayList2.add(localObject1);
        localHashMap = new HashMap();
        localHashMap.put("Connection", "keep-alive");
        localHashMap.put("Referer", paramString4);
        localObject1 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
        WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
        localObject3 = "";
        if (localWebViewFragment != null) {
          localObject3 = localWebViewFragment.getCurrentUrl();
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label579;
        }
        if (!((String)localObject3).contains("docx.qq.com")) {
          break label455;
        }
      }
    }
    label444:
    label446:
    label452:
    label455:
    Object localObject2;
    label579:
    for (Object localObject1 = ((TicketManager)localObject1).getPskey(this.a.getCurrentAccountUin(), "docx.qq.com");; localObject2 = null)
    {
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = CookieManager.getInstance();
          if (localObject1 != null) {
            localHashMap.put("Cookie", ((CookieManager)localObject1).getCookie((String)localObject3));
          }
          localObject1 = new HashMap();
          ((Map)localObject1).put("type", paramString3);
          localObject3 = new HashMap();
          ((Map)localObject3).put("share_image", str);
          localObject1 = HttpUtil.uploadImage(paramString4, paramString1, paramString2, (Map)localObject1, (Map)localObject3, localHashMap);
          if (localObject1 == null) {}
        }
        try
        {
          localObject1 = new JSONObject((String)localObject1).getString("url");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localArrayList1.add(localObject1);
          }
          i += 1;
          break;
          return null;
          if (paramInt == 2) {}
          break label192;
          if (!((String)localObject3).contains("docs.qq.com")) {
            break label579;
          }
          localObject1 = ((TicketManager)localObject1).getPskey(this.a.getCurrentAccountUin(), "docs.qq.com");
          continue;
          localHashMap.put("Cookie", "p_skey=" + (String)localObject1 + ";p_uin=" + this.a.getCurrentAccountUin() + ";skey=" + paramString2);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TeamWorkDocEditBrowserActivity", 4, localJSONException.getMessage());
            }
          }
        }
      }
      QZoneShareManager.deleteTempFile(localArrayList2);
      return localArrayList1;
    }
  }
  
  public void a(int paramInt)
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)) {
      ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)localWebViewFragment).b(paramInt);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.a = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnStop()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    super.doOnStop();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity
 * JD-Core Version:    0.7.0.1
 */