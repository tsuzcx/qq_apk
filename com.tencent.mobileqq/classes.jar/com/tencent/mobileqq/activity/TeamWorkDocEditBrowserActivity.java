package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TencentDocsPushBean;
import com.tencent.mobileqq.config.business.TencentDocsPushItemBean;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
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
    boolean bool = NetworkUtil.isNetSupport(BaseApplication.getContext());
    int j = 0;
    if (bool)
    {
      Object localObject3 = paramBundle.getString("tdsourcetag");
      if (localObject3 != null)
      {
        localObject2 = paramBundle.getString("url");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).contains("tdsourcetag")) {
            localObject1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl((String)localObject2, (String)localObject3);
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
          ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(paramBundle, "0X8009ED7");
          return;
        }
      }
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(paramBundle, "0X8009ED6");
      localObject3 = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
      Object localObject2 = paramBundle.getString("url");
      int i = paramBundle.getInt("key_team_work_edit_type");
      Object localObject1 = localObject2;
      Object localObject4;
      Object localObject5;
      if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsFormUrl((String)localObject2))
      {
        localObject1 = localObject2;
        if ((paramContext instanceof BaseActivity))
        {
          localObject4 = (BaseActivity)paramContext;
          localObject5 = ((BaseActivity)localObject4).getChatFragment();
          localObject1 = localObject2;
          if (localObject5 != null)
          {
            localObject5 = ((ChatFragment)localObject5).k();
            localObject1 = localObject2;
            if (localObject5 != null)
            {
              String str = ((BaseChatPie)localObject5).ah.b;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(str)) {
                  if (((BaseChatPie)localObject5).ah.a != 0)
                  {
                    localObject1 = localObject2;
                    if (((BaseChatPie)localObject5).ah.a != 1) {}
                  }
                  else
                  {
                    localObject4 = ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).getTroopFormGrayParameter(((BaseActivity)localObject4).app, str, ((BaseChatPie)localObject5).ah.a);
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("?");
                    ((StringBuilder)localObject1).append((String)localObject4);
                    localObject1 = ((StringBuilder)localObject1).toString();
                    if (((String)localObject2).contains("?"))
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("&");
                      ((StringBuilder)localObject1).append((String)localObject4);
                      localObject1 = ((StringBuilder)localObject1).toString();
                    }
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append((String)localObject2);
                    ((StringBuilder)localObject4).append((String)localObject1);
                    localObject1 = ((StringBuilder)localObject4).toString();
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
        if (((TeamWorkFileImportInfo)paramBundle.getParcelable("key_team_work_file_import_info")).s) {
          ((Intent)localObject3).putExtra("key_is_new_pad_flag", true);
        }
      }
      if (paramBundle.getBoolean("doc_from_aio", false)) {
        ((Intent)localObject3).putExtra("doc_from_aio", true);
      } else if ((QBaseActivity.sTopActivity != null) && ((QBaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 2)) {
        ((Intent)localObject3).putExtra("doc_from_aio", true);
      }
      if ((((Intent)localObject3).getBooleanExtra("doc_from_aio", false)) && ((paramContext instanceof BaseActivity)))
      {
        localObject2 = (BaseActivity)paramContext;
        localObject4 = ((BaseActivity)localObject2).getChatFragment();
        if (localObject4 != null)
        {
          localObject4 = ((ChatFragment)localObject4).k();
          if (localObject4 != null)
          {
            localObject5 = ((BaseChatPie)localObject4).ah.b;
            int k = ((BaseChatPie)localObject4).ah.a;
            if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (k != -1))
            {
              ((Intent)localObject3).putExtra("doc_from_aio_uin", (String)localObject5);
              ((Intent)localObject3).putExtra("doc_from_aio_peertype", k);
              ((Intent)localObject3).putExtra("doc_from_aio_nickname", ContactUtils.a(((BaseActivity)localObject2).app, (String)localObject5, k));
            }
          }
        }
      }
      if (paramBundle.getBoolean("doc_from_forward_dialog", false)) {
        ((Intent)localObject3).putExtra("doc_from_forward_dialog", true);
      }
      if (paramBundle.getString("tdsourcetag") != null)
      {
        localObject2 = paramBundle.getString("tdsourcetag");
        ((Intent)localObject3).putExtra("tdsourcetag", (String)localObject2);
        ((Intent)localObject3).putExtra("url", ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl((String)localObject1, (String)localObject2));
      }
      else
      {
        ((Intent)localObject3).putExtra("url", (String)localObject1);
      }
      ((Intent)localObject3).putExtra("key_team_work_edit_type", i);
      ((Intent)localObject3).putExtra("hide_more_button", true);
      ((Intent)localObject3).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject3).putExtra("isScreenOrientationPortrait", true);
      ((Intent)localObject3).putExtra("title", " ");
      ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_file");
      if (TextUtils.isEmpty(((Intent)localObject3).getStringExtra("big_brother_source_key"))) {
        ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
      }
      if ((paramBundle.getBoolean("doc_from_forward_dialog", false) ^ true)) {
        ((Intent)localObject3).addFlags(603979776);
      }
      i = j;
      if (paramBoolean)
      {
        i = j;
        if ((paramContext instanceof Activity)) {
          i = 1;
        }
      }
      if (i != 0)
      {
        ((Activity)paramContext).startActivityForResult((Intent)localObject3, 14001);
        return;
      }
      paramContext.startActivity((Intent)localObject3);
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), paramContext.getResources().getString(2131889169), 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, false);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str1;
    Object localObject;
    if ((paramString2 != null) && (paramContext != null))
    {
      str1 = (String)ITeamWorkUtils.MINIAPP_CONFIG_TYPE_MAP.get(paramString2);
      if (str1 == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("openDocsMiniApp:configType ");
        paramString2.append(str1);
        QLog.i("TeamWorkDocEditBrowserActivity", 2, paramString2.toString());
      }
      paramString2 = (TencentDocsPushBean)QConfigManager.b().b(418);
      if (paramString2 == null) {
        return false;
      }
      paramString2 = (TencentDocsPushItemBean)paramString2.a().get(str1);
      if (paramString2 == null) {
        return false;
      }
      if (paramString2.a())
      {
        localObject = paramString2.d();
        if (!TextUtils.isEmpty(paramString1))
        {
          if (paramString1.contains("showh5=1"))
          {
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkDocEditBrowserActivity", 2, "url参数showh5=1, 不走小程序");
            }
            return false;
          }
          if ((!paramString1.contains("showh5=0")) && (!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches((String)localObject, paramString1)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("TeamWorkDocEditBrowserActivity", 2, "url命中黑名单, 不走小程序");
            }
            return false;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        String str2 = paramString2.b();
        localObject = paramString2.c();
        if (str1.equals("docs_miniapp_config_templatelist")) {
          break label582;
        }
        boolean bool = TextUtils.isEmpty(paramString1);
        paramString2 = "1";
        if (bool)
        {
          paramString1 = new StringBuilder();
          paramString1.append((String)localObject);
          paramString1.append("?needSave=");
          if (!paramBoolean) {
            break label568;
          }
          paramString1.append(paramString2);
          paramString1 = paramString1.toString();
          break label585;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("?url=");
        localStringBuilder.append(URLEncoder.encode(paramString1, "utf-8"));
        localStringBuilder.append("&needSave=");
        if (!paramBoolean) {
          break label575;
        }
        localStringBuilder.append(paramString2);
        paramString2 = localStringBuilder.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("url=");
        ((StringBuilder)localObject).append(paramString1);
        localObject = ((StringBuilder)localObject).toString();
        paramString1 = paramString2;
        paramString2 = (String)localObject;
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(paramContext, str2, paramString1, paramString2, null, null, 2012, null);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("openDocsMiniApp:open :scene = ");
          paramContext.append(2012);
          paramContext.append("miniAppId = ");
          paramContext.append(str2);
          paramContext.append("entryPath = ");
          paramContext.append(paramString1);
          paramContext.append("navigateExtData = ");
          paramContext.append(paramString2);
          QLog.i("TeamWorkDocEditBrowserActivity", 2, paramContext.toString());
        }
        return true;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("openDocsMiniApp ");
          paramString1.append(paramContext.getMessage());
          QLog.e("TeamWorkDocEditBrowserActivity", 2, paramString1.toString());
        }
        if (TextUtils.equals(str1, "s_qq_mini_importing")) {
          TenDocLogReportHelper.a(null, "0X800A4B5");
        }
      }
      return false;
      return false;
      label568:
      paramString2 = "0";
      continue;
      label575:
      paramString2 = "0";
      continue;
      label582:
      paramString1 = (String)localObject;
      label585:
      paramString2 = "";
    }
  }
  
  public ArrayList<String> a(ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return paramArrayList;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        String str = (String)paramArrayList.get(i);
        if (FileUtil.d(str))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("local url:");
            ((StringBuilder)localObject1).append(str);
            QLog.d("TeamWorkDocEditBrowserActivity", 4, ((StringBuilder)localObject1).toString());
          }
          long l = FileUtil.f(str);
          Object localObject3 = null;
          if (l > 5242880L)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("file length:");
              ((StringBuilder)localObject1).append(FileUtil.f(str));
              QLog.d("TeamWorkDocEditBrowserActivity", 4, ((StringBuilder)localObject1).toString());
            }
            if ((paramInt == 0) && (!GifDrawable.isGifFile(new File(str))))
            {
              localObject1 = QZoneShareManager.compressImages(str, i);
              if (localObject1 != null)
              {
                str = ((File)localObject1).getAbsolutePath();
                localArrayList2.add(localObject1);
              }
              else
              {
                return null;
              }
            }
          }
          HashMap localHashMap = new HashMap();
          localHashMap.put("Connection", "keep-alive");
          localHashMap.put("Referer", paramString4);
          TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
          Object localObject1 = getCurrentWebViewFragment();
          if (localObject1 != null) {
            localObject2 = ((WebViewFragment)localObject1).getCurrentUrl();
          } else {
            localObject2 = "";
          }
          localObject1 = localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if (((String)localObject2).contains("docx.qq.com"))
            {
              localObject1 = localTicketManager.getPskey(this.a.getCurrentAccountUin(), "docx.qq.com");
            }
            else
            {
              localObject1 = localObject3;
              if (((String)localObject2).contains("docs.qq.com")) {
                localObject1 = localTicketManager.getPskey(this.a.getCurrentAccountUin(), "docs.qq.com");
              }
            }
          }
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = CookieManager.getInstance();
            if (localObject1 != null) {
              localHashMap.put("Cookie", ((CookieManager)localObject1).getCookie((String)localObject2));
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("p_skey=");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(";p_uin=");
            ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
            ((StringBuilder)localObject2).append(";skey=");
            ((StringBuilder)localObject2).append(paramString2);
            localHashMap.put("Cookie", ((StringBuilder)localObject2).toString());
          }
          localObject1 = new HashMap();
          ((Map)localObject1).put("type", paramString3);
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("share_image", str);
          localObject1 = HttpUtil.uploadImage(paramString4, paramString1, paramString2, (Map)localObject1, (Map)localObject2, localHashMap);
          if (localObject1 != null) {
            try
            {
              localObject1 = new JSONObject((String)localObject1).getString("url");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                localArrayList1.add(localObject1);
              }
            }
            catch (JSONException localJSONException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TeamWorkDocEditBrowserActivity", 4, localJSONException.getMessage());
              }
            }
          }
        }
        i += 1;
      }
      QZoneShareManager.deleteTempFile(localArrayList2);
      return localArrayList1;
    }
    return paramArrayList;
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.a = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnStop()
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