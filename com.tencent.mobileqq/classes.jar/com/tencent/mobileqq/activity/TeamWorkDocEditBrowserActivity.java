package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    this.jdField_a_of_type_JavaLangClass = TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.class;
  }
  
  public static Intent a(Intent paramIntent, String paramString, Context paramContext)
  {
    paramIntent.putExtra("title", " ");
    paramIntent.putExtra("url", paramString);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    return paramIntent;
  }
  
  public static void a(Context paramContext, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent;
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      localIntent = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
      String str = paramBundle.getString("url");
      i = paramBundle.getInt("key_team_work_edit_type");
      if (paramBundle.getBoolean("temp_preview_from_qq")) {
        localIntent.putExtra("temp_preview_from_qq", true);
      }
      if (paramBundle.getParcelable("key_team_work_file_import_info") != null)
      {
        localIntent.putExtra("key_team_work_file_import_info", paramBundle.getParcelable("key_team_work_file_import_info"));
        if (((TeamWorkFileImportInfo)paramBundle.getParcelable("key_team_work_file_import_info")).e) {
          localIntent.putExtra("key_is_new_pad_flag", true);
        }
      }
      localIntent.putExtra("url", str);
      localIntent.putExtra("key_team_work_edit_type", i);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("isScreenOrientationPortrait", true);
      localIntent.putExtra("title", " ");
      localIntent.addFlags(603979776);
      if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
        break label236;
      }
    }
    label236:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((Activity)paramContext).startActivityForResult(localIntent, 14001);
        return;
      }
      paramContext.startActivity(localIntent);
      return;
      QQToast.a(BaseApplication.getContext(), paramContext.getResources().getString(2131433009), 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      return;
    }
  }
  
  public ArrayList a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return paramArrayList;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    String str;
    label190:
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
          break label448;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TeamWorkDocEditBrowserActivity", 4, "file length:" + FileUtil.a(str));
        }
        if ((paramInt != 0) || (GifDrawable.isGifFile(new File(str)))) {
          break label442;
        }
        localObject1 = QZoneShareManager.a(str, i);
        if (localObject1 == null) {
          break label440;
        }
        str = ((File)localObject1).getAbsolutePath();
        localArrayList2.add(localObject1);
        localHashMap = new HashMap();
        localHashMap.put("Connection", "keep-alive");
        localHashMap.put("Referer", paramString4);
        localObject1 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
        WebViewFragment localWebViewFragment = b();
        localObject3 = "";
        if (localWebViewFragment != null) {
          localObject3 = localWebViewFragment.b();
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label575;
        }
        if (!((String)localObject3).contains("docx.qq.com")) {
          break label451;
        }
      }
    }
    label440:
    label442:
    label448:
    label451:
    Object localObject2;
    label575:
    for (Object localObject1 = ((TicketManager)localObject1).getPskey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "docx.qq.com");; localObject2 = null)
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
          localObject1 = HttpUtil.a(paramString4, paramString1, paramString2, (Map)localObject1, (Map)localObject3, localHashMap);
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
          break label190;
          if (!((String)localObject3).contains("docs.qq.com")) {
            break label575;
          }
          localObject1 = ((TicketManager)localObject1).getPskey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "docs.qq.com");
          continue;
          localHashMap.put("Cookie", "p_skey=" + (String)localObject1 + ";p_uin=" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + ";skey=" + paramString2);
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
      QZoneShareManager.a(localArrayList2);
      return localArrayList1;
    }
  }
  
  public void a(int paramInt)
  {
    WebViewFragment localWebViewFragment = b();
    if ((localWebViewFragment instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)) {
      ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)localWebViewFragment).b(paramInt);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnStop()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    super.doOnStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity
 * JD-Core Version:    0.7.0.1
 */