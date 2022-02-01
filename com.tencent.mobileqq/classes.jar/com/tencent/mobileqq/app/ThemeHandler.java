package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.pb.theme.ThemeAuth.DiyThemeDetail;
import com.tencent.pb.theme.ThemeAuth.ReqBody;
import com.tencent.pb.theme.ThemeAuth.RspBody;
import com.tencent.pb.theme.ThemeAuth.RspDiyThemeDetail;
import com.tencent.pb.theme.ThemeAuth.RspDiyThemeInfo;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1ReqAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1RspAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x2ReqCheck;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x2RspCheck;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x3ReqSet;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x3RspSet;
import com.tencent.pb.theme.ThemeAuth.ThemeFileInfo;
import com.tencent.pb.theme.ThemeAuth.diyThemeInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ThemeHandler
  extends BusinessHandler
{
  private static String jdField_a_of_type_JavaLangString;
  public Bundle a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ThemeDiyStyleLogic.StyleCallBack a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public AtomicBoolean b = new AtomicBoolean(true);
  AtomicBoolean c = new AtomicBoolean(false);
  
  ThemeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
  }
  
  private int a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    int i = paramInt;
    if (-1 == paramInt)
    {
      ThemeAuth.ReqBody localReqBody = new ThemeAuth.ReqBody();
      localReqBody.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      i = localReqBody.uint32_sub_cmd.get();
    }
    if (1 == i) {
      ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface).edit().putLong("authTime", 0L).commit();
    }
    return i;
  }
  
  private HashMap<String, String> a(String paramString)
  {
    paramString = FileUtils.getChildFiles(paramString);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while ((i < 3) && (i < paramString.size()))
    {
      int j = new Random().nextInt(paramString.size() - 1);
      String str1 = (String)paramString.get(j);
      String str2 = str1.substring(str1.substring(0, str1.lastIndexOf(47)).lastIndexOf('/') + 1);
      if ((str2 != null) && (str2.length() > 0) && (!localHashMap.containsKey(str2)))
      {
        String str3 = FileUtils.encryptFile(str1, "MD5");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Theme getRandomFileMd5 file=");
          localStringBuilder.append(str1);
          localStringBuilder.append(",key=");
          localStringBuilder.append(str2);
          localStringBuilder.append(",md5=");
          localStringBuilder.append(str3);
          localStringBuilder.append(", files=");
          localStringBuilder.append(paramString.size());
          localStringBuilder.append(", index=");
          localStringBuilder.append(j);
          QLog.i("Theme.ThemeHandler", 2, localStringBuilder.toString());
        }
        if ((str3 != null) && (str3.length() > 0)) {
          localHashMap.put(str2, str3);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3, BaseActivity paramBaseActivity)
  {
    if (paramInt1 == 1)
    {
      paramBaseActivity.startActivity(new Intent(paramBaseActivity, GeneralSettingActivity.class));
      return;
    }
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40100);
    String str = IndividuationUrlHelper.a(paramBaseActivity, "theme", "mvip.gongneng.android.theme.index_dynamic_tab");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    Object localObject1 = "?";
    if (str.contains("?")) {
      localObject1 = "&";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("dialog_source=other&authresult=");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!android.text.TextUtils.isEmpty(paramString)) {
      if (((String)localObject2).contains("id=[id]"))
      {
        localObject1 = ((String)localObject2).replace("[id]", paramString);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&id=");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("theme market url: ");
      paramString.append((String)localObject1);
      QLog.d("Theme.ThemeHandler", 2, paramString.toString());
    }
    VasWebviewUtil.b(paramBaseActivity, VasWebviewUtil.a((String)localObject1, 54), 32L, localIntent, true, -1);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ThemeAuth.DiyThemeDetail paramDiyThemeDetail)
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    Object localObject1 = ThemeBackground.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 0);
    if ((paramInt1 == 2) && (!ChatBackgroundUtil.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), null).equals("null"))) {
      return;
    }
    if (android.text.TextUtils.isEmpty(paramString1)) {
      paramString1 = paramDiyThemeDetail.str_bg_url.get();
    }
    int i = paramInt2;
    paramInt2 = i;
    if (1 > i) {
      paramInt2 = paramDiyThemeDetail.uin32_id.get();
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("update sv ThemeBackground, page=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", id=");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(", url=");
      ((StringBuilder)localObject2).append(paramString1);
      QLog.d("Theme.ThemeHandler", 2, ((StringBuilder)localObject2).toString());
    }
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString3);
      ((StringBuilder)localObject2).append("_id");
      localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString3);
      ((StringBuilder)localObject3).append("_url");
      localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject3).toString(), "");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramInt2);
      boolean bool;
      if ((((StringBuilder)localObject3).toString().equals(localObject2)) && (!android.text.TextUtils.isEmpty((CharSequence)localObject1))) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateThemeBackgroundPic, bgType=");
        ((StringBuilder)localObject1).append(paramString3);
        ((StringBuilder)localObject1).append(", notChange=");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(", localId=");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(", id=");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(", url=");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(", page=");
        ((StringBuilder)localObject1).append(paramInt1);
        QLog.d("Theme.ThemeHandler", 2, ((StringBuilder)localObject1).toString());
      }
      if (bool) {
        return;
      }
      if (paramDiyThemeDetail != null)
      {
        localObject1 = paramDiyThemeDetail.str_name.get();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramInt2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (paramDiyThemeDetail != null) {
        i = paramDiyThemeDetail.uin32_feetype.get();
      } else {
        i = 1;
      }
      if (paramDiyThemeDetail != null) {
        localObject2 = paramDiyThemeDetail.str_bg_thumbnail_url.get();
      } else {
        localObject2 = null;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramInt2);
      localObject3 = ChatBackgroundUtil.a(true, ((StringBuilder)localObject3).toString());
      Object localObject4 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("");
      ((StringBuilder)localObject5).append(paramInt2);
      ThemeBackground.a(localMobileQQ, paramString3, (String)localObject4, (String)localObject3, paramString1, ((StringBuilder)localObject5).toString(), (String)localObject1, i, (String)localObject2, true);
      if (!paramString3.equals(paramString2))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        int j = paramInt2;
        ((StringBuilder)localObject4).append(j);
        localObject4 = ChatBackgroundUtil.a(true, ((StringBuilder)localObject4).toString());
        localObject5 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(j);
        ThemeBackground.a(localMobileQQ, paramString2, (String)localObject5, (String)localObject4, paramString1, localStringBuilder.toString(), (String)localObject1, i, (String)localObject2, true);
      }
      if (paramInt1 == 2) {
        ChatBackgroundUtil.a(localMobileQQ, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, (String)localObject3);
      }
    }
    if (("100".equals(String.valueOf(paramInt2))) || ("0".equals(String.valueOf(paramInt2))))
    {
      if (paramDiyThemeDetail != null) {
        paramInt1 = paramDiyThemeDetail.uin32_feetype.get();
      } else {
        paramInt1 = 1;
      }
      ThemeBackground.a(localMobileQQ, paramString3, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "", "", "", "", paramInt1, null, true);
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, ThemeAuth.SubCmd0x1RspAuth paramSubCmd0x1RspAuth)
  {
    int i = paramSubCmd0x1RspAuth.uint32_concise_id.get();
    int j = paramSubCmd0x1RspAuth.uint32_concise_switch.get();
    int k = paramSubCmd0x1RspAuth.uint32_study_switch.get();
    int m = paramSubCmd0x1RspAuth.uint32_young_switch.get();
    if (j == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramSubCmd0x1RspAuth = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2;
    if (k == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if (m == 1) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    SimpleUIHandler.a(bool1, i, paramSubCmd0x1RspAuth, bool2, bool3);
    i = 3;
    if ((3 == paramInt) && (!"1000".equals(paramString1)))
    {
      ThemeUtil.setErrorThemeId(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramString1, false);
      ThemeUtil.getUserCurrentThemeVersion(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      bool1 = SkinEngine.getInstances().setSkinRootPath(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), null);
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, set default theme");
      if (bool1 == true) {
        ThreadManager.getUIHandler().post(new ThemeHandler.1(this));
      }
      paramString2 = ThemeUtil.getThemeInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramString1);
      if (paramString2 != null)
      {
        paramString2.status = "1";
        ThemeUtil.setThemeInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramString2);
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("handleThemeAuth error, set theme status=ThemeUtil.THEME_STATUS_DOWNLOAD_END, reqthemeId=");
          paramString2.append(paramString1);
          QLog.i("Theme.ThemeHandler", 2, paramString2.toString());
        }
      }
      try
      {
        paramString1 = new ThemeLocator().a(paramString1).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
        FileUtils.delete(paramString1, true);
        paramString2 = new StringBuilder();
        paramString2.append("handleThemeAuth no right, delete: ");
        paramString2.append(paramString1);
        QLog.e("Theme.ThemeHandler", 1, paramString2.toString());
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleThemeAuth delete Error, msg=");
        paramString2.append(paramString1.getMessage());
        QLog.e("Theme.ThemeHandler", 1, paramString2.toString());
        return;
      }
    }
    if (paramInt != 4) {
      ThemeUtil.setWeekLoopTheme(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, null, 0L);
    }
    boolean bool1 = SkinEngine.getInstances().setSkinRootPath(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), null);
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth vip Error, set default theme");
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 10) && (paramInt != 11))
      {
        if (paramInt != 6) {
          i = 4;
        }
      }
      else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    if (bool1) {
      ReportController.b(null, "CliOper", "", "", "theme", "0X8007234", 0, 0, String.valueOf(i), "", "", "");
    }
    if (android.text.TextUtils.isEmpty(paramString2)) {
      paramString2 = HardCodeUtil.a(2131714718);
    }
    if (bool1)
    {
      paramSubCmd0x1RspAuth = Message.obtain();
      Bundle localBundle = new Bundle();
      localBundle.putString("expireMsg", paramString2);
      localBundle.putString("themeId", paramString1);
      localBundle.putInt("authResult", paramInt);
      localBundle.putInt("expireType", i);
      localBundle.putInt("sSimpleOpen", j);
      paramSubCmd0x1RspAuth.obj = localBundle;
      if (j != 1) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new ThemeHandler.2(this, paramSubCmd0x1RspAuth), 4000L);
      } else {
        BannerManager.a().a(ThemeOverdueBannerProcessor.a, 2, paramSubCmd0x1RspAuth);
      }
    }
    if (ThemeBackground.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_aio_path", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()))
    {
      ChatBackgroundUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "null");
      ThemeBackground.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_aio_path", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
    ThemeBackground.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_setting_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ThemeBackground.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ThemeBackground.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_friend_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ThemeBackground.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_dynamic_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject1 == null)
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
      return;
    }
    MobileQQ localMobileQQ = ((AppInterface)localObject1).getApplication();
    String str2 = paramBundle.getString("themeId");
    String str1 = paramBundle.getString("themePath");
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = new ThemeAuth.SubCmd0x1ReqAuth();
        ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).uint32_op_type.set(1);
        ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).uint32_theme_id.set(Integer.parseInt(str2));
        ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).str_theme_version.set("20000000");
        ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
        SharedPreferences localSharedPreferences = ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        String str3 = localSharedPreferences.getString("currentThemeId_6.3.5", null);
        long l1 = localSharedPreferences.getLong("themeSetTimeKey", 0L);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Theme Auth themeId=");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(",version=");
        ((StringBuilder)localObject2).append("20000000");
        ((StringBuilder)localObject2).append(", userThemeId=");
        ((StringBuilder)localObject2).append(str3);
        ((StringBuilder)localObject2).append(",currentThemeResPath=");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(", usr=");
        ((StringBuilder)localObject2).append(com.tencent.mobileqq.text.TextUtils.hideUinInShowString(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 2));
        ((StringBuilder)localObject2).append(", oldTime=");
        ((StringBuilder)localObject2).append(l1);
        QLog.d("Theme.ThemeHandler", 1, ((StringBuilder)localObject2).toString());
        boolean bool = "1000".equals(str2);
        if (!bool)
        {
          localObject2 = a(str1);
          Object localObject3;
          if (((HashMap)localObject2).size() < 3)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("sendThemeAuth fileMD5 size error:size=");
            ((StringBuilder)localObject3).append(((HashMap)localObject2).size());
            QLog.e("Theme.ThemeHandler", 2, ((StringBuilder)localObject3).toString());
          }
          localObject2 = ((HashMap)localObject2).entrySet().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("Theme file Info,Filepath=");
              ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getKey());
              ((StringBuilder)localObject4).append(",FileMd5=");
              ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getValue());
              QLog.i("Theme.ThemeHandler", 2, ((StringBuilder)localObject4).toString());
            }
            Object localObject4 = new ThemeAuth.ThemeFileInfo();
            ((ThemeAuth.ThemeFileInfo)localObject4).str_file_path.set((String)((Map.Entry)localObject3).getKey());
            ((ThemeAuth.ThemeFileInfo)localObject4).str_file_md5.set((String)((Map.Entry)localObject3).getValue());
            ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).rpt_msg_topic_file_info.add((MessageMicro)localObject4);
            continue;
          }
          localSharedPreferences.edit().putLong("authTime", 0L).commit();
          localObject2 = localObject1;
          break label1095;
        }
        if (!android.text.TextUtils.isEmpty(str3))
        {
          localObject2 = localObject1;
          if (!"1000".equals(str3)) {
            break label1095;
          }
        }
        l1 = localSharedPreferences.getLong("authTime", 0L);
        try
        {
          long l2 = System.currentTimeMillis();
          if ((l2 <= l1 + 7200000L) && (!StudyModeManager.a()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Theme.ThemeHandler", 2, "sendThemeAuth nowTime <= authTime + 2h");
            }
            DarkModeManager.b(true);
            return;
          }
          localSharedPreferences.edit().putLong("authTime", l2).commit();
          localObject2 = new ThemeAuth.ReqBody();
          ((ThemeAuth.ReqBody)localObject2).uint32_sub_cmd.set(1);
          ((ThemeAuth.ReqBody)localObject2).int32_plat_id.set(109);
          ((ThemeAuth.ReqBody)localObject2).str_qq_version.set("8.7.0.5295");
          ((ThemeAuth.ReqBody)localObject2).uint32_qq_version.set(Integer.parseInt("5295"));
          ((ThemeAuth.ReqBody)localObject2).msg_subcmd0x1_req_auth.set((MessageMicro)localObject1);
          ((ThemeAuth.ReqBody)localObject2).setHasFlag(true);
          localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
          ((ToServiceMsg)localObject1).putWupBuffer(((ThemeAuth.ReqBody)localObject2).toByteArray());
          ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("Theme Auth send request, themeID=");
            paramBundle.append(str2);
            paramBundle.append(", userThemeId=");
            paramBundle.append(str3);
            QLog.i("Theme.ThemeHandler", 2, paramBundle.toString());
          }
          super.sendPbReq((ToServiceMsg)localObject1);
          if ((!"1000".equals(str2)) && (!android.text.TextUtils.isEmpty(str1)))
          {
            paramBundle = new File(str1);
            l1 = System.currentTimeMillis();
            localObject1 = ThemeUtil.getThemeInfo(localMobileQQ, str2);
            l2 = System.currentTimeMillis();
            if (localObject1 == null) {
              break label1102;
            }
            i = 1;
            ThemeReporter.a(null, "theme_sp_speed", "204", 153, -1, i, String.valueOf(l2 - l1), "6653", "read", "");
            if ((!paramBundle.isDirectory()) || (localObject1 == null))
            {
              paramBundle = new StringBuilder();
              paramBundle.append("sendThemeAuth fileNum Error:, themeInfo == null || currentThemeResPath:");
              paramBundle.append(str1);
              QLog.e("Theme.ThemeHandler", 1, paramBundle.toString());
            }
          }
          paramBundle = "20000000";
        }
        catch (Exception paramBundle) {}
        localObject1 = new StringBuilder();
      }
      catch (Exception paramBundle) {}
      ((StringBuilder)localObject1).append("Theme Auth send Exception:");
      ((StringBuilder)localObject1).append(paramBundle.getMessage());
      ((StringBuilder)localObject1).append(", themeId=");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(", version=");
      paramBundle = "20000000";
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.e("Theme.ThemeHandler", 1, ((StringBuilder)localObject1).toString());
      if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth ERROR_CODE_ISNOT_SUPPORT_THEME.");
      }
      int j = NetworkUtil.getSystemNetwork(null);
      if (BaseApplicationImpl.IS_SUPPORT_THEME) {
        i = 1;
      } else {
        i = -40;
      }
      ThemeReporter.a(null, "theme_detail", "205", 157, j, i, str2, paramBundle, "1", "");
      return;
      label1095:
      localObject1 = localObject2;
      continue;
      label1102:
      int i = -1;
    }
  }
  
  private void a(ThemeAuth.RspBody paramRspBody)
  {
    int i = ((ThemeAuth.SubCmd0x2RspCheck)paramRspBody.msg_subcmd0x2_rsp_check.get()).int32_result.get();
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("handleThemeVersionCheck:");
      paramRspBody.append(i);
      QLog.i("Theme.ThemeHandler", 2, paramRspBody.toString());
    }
    paramRspBody = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    if (!android.text.TextUtils.isEmpty(paramRspBody))
    {
      paramRspBody = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences(paramRspBody, 0);
      if (i == 6) {
        paramRspBody.edit().putBoolean("need_check_theme_ver", true).commit();
      }
      if (paramRspBody.getBoolean("need_check_theme_ver", false)) {
        paramRspBody.edit().putBoolean("need_check_theme_ver", false).commit();
      }
    }
    if (i == 0)
    {
      paramRspBody = Message.obtain();
      paramRspBody.obj = jdField_a_of_type_JavaLangString;
      BannerManager.a().a(ThemeVersionUpdateBannerProcessor.a, 2, paramRspBody);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B9E", "0X8005B9E", 0, 0, "", "", "", "");
      ThreadManagerV2.getUIHandlerV2().postDelayed(new ThemeHandler.3(this), 90000L);
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, ThemeAuth.RspBody paramRspBody, boolean paramBoolean)
  {
    Object localObject = HardCodeUtil.a(2131714721);
    int j = 4;
    int i;
    if (paramBoolean)
    {
      paramRspBody = (ThemeAuth.SubCmd0x3RspSet)paramRspBody.msg_subcmd0x3_rsp_set.get();
      i = paramRspBody.int32_result.get();
      paramToServiceMsg = String.valueOf(paramRspBody.uint32_theme_id.get());
      paramRspBody = paramRspBody.str_diy_theme_err_msg.get();
    }
    else
    {
      paramRspBody = new ThemeAuth.ReqBody();
      paramRspBody.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      paramToServiceMsg = String.valueOf(((ThemeAuth.SubCmd0x3ReqSet)paramRspBody.msg_subcmd0x3_req_set.get()).uint32_theme_id.get());
      i = -404;
      paramRspBody = (ThemeAuth.RspBody)localObject;
    }
    if ((QLog.isColorLevel()) || (i != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleThemeAuth Set result:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", themeId:");
      ((StringBuilder)localObject).append(paramToServiceMsg);
      QLog.d("Theme.ThemeHandler", 1, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack != null)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject != null)
      {
        ((Bundle)localObject).putString("message", paramRspBody);
        this.jdField_a_of_type_AndroidOsBundle.putInt("result_int", i);
        if ((!android.text.TextUtils.isEmpty(paramToServiceMsg)) && (paramToServiceMsg.equals(this.jdField_a_of_type_AndroidOsBundle.getString("themeId"))))
        {
          if (QLog.isColorLevel())
          {
            paramRspBody = new StringBuilder();
            paramRspBody.append("handleThemeAuth set back themeId=");
            paramRspBody.append(paramToServiceMsg);
            paramRspBody.append(", result=");
            paramRspBody.append(i);
            QLog.d("Theme.ThemeHandler", 2, paramRspBody.toString());
          }
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack;
          if (i == 0) {
            i = j;
          } else {
            i = 8;
          }
          paramToServiceMsg.a(16, i, this.jdField_a_of_type_AndroidOsBundle, null);
          this.jdField_a_of_type_AndroidOsBundle = null;
          this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack = null;
          this.c.set(true);
        }
        else
        {
          paramRspBody = new StringBuilder();
          paramRspBody.append("handleThemeAuth Set result:themeId has changed themeId=");
          paramRspBody.append(paramToServiceMsg);
          paramRspBody.append(", rbThemeid=");
          paramRspBody.append(this.jdField_a_of_type_AndroidOsBundle.getString("themeId"));
          QLog.e("Theme.ThemeHandler", 1, paramRspBody.toString());
        }
        return false;
      }
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleThemeAuth Set result:null == service || null == reqbundle, result:");
    paramToServiceMsg.append(i);
    QLog.e("Theme.ThemeHandler", 1, paramToServiceMsg.toString());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack = null;
    return true;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, ThemeAuth.SubCmd0x1RspAuth paramSubCmd0x1RspAuth, String paramString1, String paramString2)
  {
    String str1 = String.valueOf(paramSubCmd0x1RspAuth.uint32_theme_id.get());
    Object localObject = paramSubCmd0x1RspAuth.str_version.get();
    String str2 = paramSubCmd0x1RspAuth.str_download_url.get();
    int i = paramSubCmd0x1RspAuth.uint32_concise_id.get();
    int j = paramSubCmd0x1RspAuth.uint32_concise_switch.get();
    int k = paramSubCmd0x1RspAuth.uint32_study_switch.get();
    int m = paramSubCmd0x1RspAuth.uint32_young_switch.get();
    int n = paramSubCmd0x1RspAuth.int32_suit_id.get();
    if ((QLog.isColorLevel()) || ((paramString2 != null) && (!paramString1.equals(str1))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("authHandler get themeId=");
      localStringBuilder.append(str1);
      localStringBuilder.append(",ver=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",Url=");
      localStringBuilder.append(str2);
      localStringBuilder.append(", seriesId=");
      localStringBuilder.append(n);
      localStringBuilder.append(", reqthemeId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", reqVersion:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", sSimpleThemeId:");
      localStringBuilder.append(i);
      localStringBuilder.append(", sSimpleOpen:");
      localStringBuilder.append(j);
      QLog.d("Theme.ThemeHandler", 2, localStringBuilder.toString());
    }
    boolean bool1;
    if (j == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2;
    if (k == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if (m == 1) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    SimpleUIHandler.a(bool1, i, paramString1, bool2, bool3);
    if (!"999".equals(str1))
    {
      paramString1 = (String)localObject;
      if (!"1000".equals(str1)) {}
    }
    else
    {
      paramString1 = "20000000";
    }
    if ((android.text.TextUtils.isEmpty(paramString1)) || ("0".equals(str1))) {
      paramString1 = String.valueOf(200);
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("oldEnginePath", null);
    paramString2 = SkinEngine.getInstances().getSkinRootPath();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("engine path old is : ");
    ((StringBuilder)localObject).append(paramToServiceMsg);
    ((StringBuilder)localObject).append(" new is ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.e("Theme.ThemeHandler", 1, ((StringBuilder)localObject).toString());
    if ((!android.text.TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramToServiceMsg)))
    {
      QLog.e("Theme.ThemeHandler", 1, "engine init during auth, resend auth");
      a();
      return true;
    }
    if (n <= 0)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("clear weekTheme because seriesId=");
      paramToServiceMsg.append(n);
      QLog.e("Theme.ThemeHandler", 1, paramToServiceMsg.toString());
      ThemeUtil.setWeekLoopTheme(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, null, 0L);
    }
    if (n > 0)
    {
      paramToServiceMsg = ThemeUtil.getWeekLoopTheme(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!android.text.TextUtils.isEmpty(paramToServiceMsg))
      {
        b(paramToServiceMsg, "203");
        return false;
      }
    }
    if ((!"0".equals(str1)) && (!android.text.TextUtils.isEmpty(paramString1)) && (!this.c.get()))
    {
      if (paramSubCmd0x1RspAuth.uint32_diy_theme_flag.get() == 1)
      {
        paramToServiceMsg = (ThemeAuth.RspDiyThemeInfo)paramSubCmd0x1RspAuth.rsp_diy_theme_info.get();
        paramSubCmd0x1RspAuth = (ThemeAuth.RspDiyThemeDetail)paramSubCmd0x1RspAuth.rsp_diy_theme_detail.get();
        a(0, paramToServiceMsg.uin32_drawer_tab_id.get(), paramToServiceMsg.str_drawer_tab_url.get(), "theme_bg_setting_path", "theme_bg_setting_path_png", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.drawer_tab_detail.get());
        a(1, paramToServiceMsg.uin32_message_tab_id.get(), paramToServiceMsg.str_message_tab_url.get(), "theme_bg_message_path", "theme_bg_message_path_png", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.message_tab_detail.get());
        a(2, paramToServiceMsg.uin32_aio_tab_id.get(), paramToServiceMsg.str_aio_tab_url.get(), "theme_bg_aio_path", "theme_bg_aio_path", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.aio_tab_detail.get());
        a(3, paramToServiceMsg.uin32_friend_tab_id.get(), paramToServiceMsg.str_friend_tab_url.get(), "theme_bg_friend_path", "theme_bg_friend_path_png", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.friend_tab_detail.get());
        a(4, paramToServiceMsg.uin32_dynamic_tab_id.get(), paramToServiceMsg.str_dynamic_tab_url.get(), "theme_bg_dynamic_path", "theme_bg_dynamic_path_png", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.dynamic_tab_detail.get());
      }
      b(str1, "204");
      return false;
    }
    a(null, null, true);
    return false;
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ("204".equalsIgnoreCase(paramString2))
    {
      if (!DarkModeManager.a(paramString1, paramString2))
      {
        a(paramString1, paramString2);
        return;
      }
      if (!ThemeUtil.isFixTheme(paramString1)) {
        ThemeSwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, "20000000");
      }
    }
    else
    {
      a(paramString1, paramString2);
    }
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject1 == null)
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
      return;
    }
    MobileQQ localMobileQQ = ((AppInterface)localObject1).getApplication();
    localObject1 = ThemeUtil.getThemePreferences(localMobileQQ);
    Object localObject3;
    if (1 > ((SharedPreferences)localObject1).getInt("themeSpVersion", 0)) {
      localObject3 = ((SharedPreferences)localObject1).edit();
    }
    label665:
    for (;;)
    {
      Object localObject5;
      try
      {
        localObject1 = ((SharedPreferences)localObject1).getString("userDownloadTheme", "");
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject4 = new JSONObject((String)localObject1);
          localObject5 = ((JSONObject)localObject4).keys();
          if (((Iterator)localObject5).hasNext())
          {
            String str2 = String.valueOf(((Iterator)localObject5).next());
            if ((android.text.TextUtils.isEmpty(str2)) || ("1000".equals(str2)) || ("999".equals(str2))) {
              continue;
            }
            JSONObject localJSONObject = ((JSONObject)localObject4).getJSONObject(str2);
            if (localJSONObject == null) {
              continue;
            }
            String str1 = localJSONObject.optString("version");
            localObject1 = ThemeUtil.getThemeInfo(localMobileQQ, str2);
            if (localObject1 != null) {
              break label665;
            }
            localObject1 = new ThemeUtil.ThemeInfo();
            ((ThemeUtil.ThemeInfo)localObject1).themeId = str2;
            ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme = localJSONObject.optBoolean("sound");
            ((ThemeUtil.ThemeInfo)localObject1).fileNum = localJSONObject.optInt("fileNum");
            ((ThemeUtil.ThemeInfo)localObject1).version = str1;
            ((ThemeUtil.ThemeInfo)localObject1).zipVer = Integer.parseInt(str1);
            ((ThemeUtil.ThemeInfo)localObject1).status = "1";
            ThemeUtil.setThemeInfo(localMobileQQ, (ThemeUtil.ThemeInfo)localObject1);
            continue;
          }
          ((SharedPreferences.Editor)localObject3).remove("userDownloadTheme");
        }
      }
      catch (Exception localException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("sendThemeAuth themeUpdate error:");
        ((StringBuilder)localObject4).append(localException.getMessage());
        QLog.e("Theme.ThemeHandler", 2, ((StringBuilder)localObject4).toString());
      }
      ((SharedPreferences.Editor)localObject3).putInt("themeSpVersion", 1).commit();
      Object localObject4 = ThemeUtil.getCurrentThemeInfo();
      ((Bundle)localObject4).putString("oldEnginePath", ((Bundle)localObject4).getString("themePath"));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendThemeAuth init: , skThemeId:");
      ((StringBuilder)localObject2).append(((Bundle)localObject4).getString("themeId"));
      ((StringBuilder)localObject2).append(", skVersion:");
      ((StringBuilder)localObject2).append(((Bundle)localObject4).getString("version"));
      ((StringBuilder)localObject2).append(", qqVersion:");
      ((StringBuilder)localObject2).append("8.7.0");
      QLog.d("Theme.ThemeHandler", 1, ((StringBuilder)localObject2).toString());
      localObject3 = ((Bundle)localObject4).getString("themeId");
      localObject2 = localObject3;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject3))
      {
        ((Bundle)localObject4).putString("themeId", "1000");
        localObject2 = "1000";
      }
      if (QQTheme.c((String)localObject2))
      {
        localObject3 = ThemeSwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getString("themeID");
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("sendThemeAuth isThemeSimpleUI:");
        ((StringBuilder)localObject5).append((String)localObject2);
        ((StringBuilder)localObject5).append(" pre:");
        ((StringBuilder)localObject5).append((String)localObject3);
        QLog.e("Theme.ThemeHandler", 1, ((StringBuilder)localObject5).toString());
        if (android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "1000";
        } else {
          localObject2 = localObject3;
        }
        ((Bundle)localObject4).putString("themeId", (String)localObject2);
        if ("1000".equals(localObject3))
        {
          ((Bundle)localObject4).remove("themePath");
        }
        else if ("999".equals(localObject3))
        {
          ((Bundle)localObject4).putString("themePath", new ThemeLocator().a().d());
        }
        else
        {
          localObject2 = new ThemeLocator().a((String)localObject3);
          ((IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(3, ((ThemeLocator)localObject2).b(), true, false, 0L, new ThemeHandler.5(this, (ThemeLocator)localObject2, localMobileQQ, (Bundle)localObject4));
          return;
        }
      }
      a((Bundle)localObject4);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool1 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    boolean bool2 = SimpleUIUtil.a();
    if (!bool2) {
      if (bool1) {
        ThemeSwitcher.a("1103", paramString2, null);
      } else {
        ThemeSwitcher.a(paramString1, paramString2, new ThemeHandler.4(this));
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetServerTheme: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",");
    localStringBuilder.append(bool2);
    localStringBuilder.append(",");
    localStringBuilder.append(bool1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString2);
    QLog.e("Theme.ThemeHandler", 1, localStringBuilder.toString());
    if (!ThemeUtil.isFixTheme(paramString1)) {
      ThemeSwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, "20000000");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSVTheme, themeId=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", version=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", seriesIdStr=");
      localStringBuilder.append(paramString3);
      QLog.i("Theme.ThemeHandler", 2, localStringBuilder.toString());
    }
    if ((!android.text.TextUtils.isEmpty(paramString1)) && (paramBundle != null)) {}
    for (;;)
    {
      try
      {
        paramBundle.putString("themeId", paramString1);
        this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack = paramStyleCallBack;
        this.jdField_a_of_type_AndroidOsBundle = paramBundle;
        paramString2 = new ThemeAuth.SubCmd0x3ReqSet();
        paramString2.uint32_theme_id.set(Integer.parseInt(paramString1));
        boolean bool = android.text.TextUtils.isEmpty(paramString3);
        if (bool) {
          break label491;
        }
        try
        {
          i = Integer.parseInt(paramString3);
        }
        catch (Exception paramString1)
        {
          QLog.d("Theme.ThemeHandler", 1, "setSVTheme, parse seriesIdStr exception", paramString1);
          break label491;
        }
        paramString2.uint32_suit_id.set(i);
        paramString1 = paramBundle.getBundle("request");
        if (paramString1 != null) {
          paramBundle.putAll(paramString1);
        }
        if ("201".equals(paramBundle.getString("key_from")))
        {
          paramString1 = new ThemeAuth.diyThemeInfo();
          paramString1.uin32_drawer_tab_id.set(Integer.parseInt(paramBundle.getString("pageDrawer")));
          paramString1.uin32_message_tab_id.set(Integer.parseInt(paramBundle.getString("pageMessage")));
          paramString1.uin32_aio_tab_id.set(Integer.parseInt(paramBundle.getString("pageAIO")));
          paramString1.uin32_freind_tab_id.set(Integer.parseInt(paramBundle.getString("pageFriend")));
          paramString1.uin32_dynamics_tab_id.set(Integer.parseInt(paramBundle.getString("pageDynamic")));
          paramString2.diy_theme_info.set(paramString1);
          paramString2.uint32_diy_theme_flag.set(1);
        }
        else
        {
          paramString2.uint32_diy_theme_flag.set(0);
        }
        paramString1 = new ThemeAuth.ReqBody();
        paramString1.uint32_sub_cmd.set(3);
        paramString1.int32_plat_id.set(109);
        paramString1.str_qq_version.set("8.7.0.5295");
        paramString1.uint32_qq_version.set(Integer.parseInt("5295"));
        paramString1.msg_subcmd0x3_req_set.set(paramString2);
        paramString1.setHasFlag(true);
        paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
        paramString2.putWupBuffer(paramString1.toByteArray());
        super.sendPbReq(paramString2);
        if (QLog.isColorLevel())
        {
          QLog.i("Theme.ThemeHandler", 2, "setSVTheme sendPbReq ok");
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("setSVTheme Exception:");
        paramString2.append(paramString1.toString());
        QLog.e("Theme.ThemeHandler", 2, paramString2.toString());
      }
      return;
      QLog.e("Theme.ThemeHandler", 2, "setSVTheme Error themeId == null");
      return;
      label491:
      int i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    String str;
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      str = paramString2;
      if (!android.text.TextUtils.isEmpty(paramString2)) {}
    }
    else
    {
      paramString2 = ThemeUtil.getCurrentThemeInfo();
      paramString1 = paramString2.getString("themeId");
      str = paramString2.getString("version");
    }
    if ((!android.text.TextUtils.isEmpty(paramString1)) && (!"1000".equals(paramString1)) && (!"999".equals(paramString1)))
    {
      if (android.text.TextUtils.isEmpty(str)) {
        return;
      }
      jdField_a_of_type_JavaLangString = paramString1;
    }
    for (;;)
    {
      int i;
      try
      {
        i = Integer.parseInt(str) % 10000;
        paramString2 = ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
        if ("m".equals(paramString2))
        {
          i -= 1000;
        }
        else
        {
          if (!"h".equals(paramString2)) {
            break label422;
          }
          i -= 2000;
        }
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("ver = ");
          paramString2.append(i);
          QLog.i("Theme.ThemeHandler", 2, paramString2.toString());
        }
        paramString2 = new ThemeAuth.SubCmd0x2ReqCheck();
        paramString2.str_theme_version.set(String.valueOf(i));
        paramString2.uint32_theme_id.set(Integer.parseInt(paramString1));
        paramString1 = new ThemeAuth.ReqBody();
        paramString1.uint32_sub_cmd.set(2);
        paramString1.int32_plat_id.set(109);
        paramString1.str_qq_version.set("8.7.0.5295");
        paramString1.uint32_qq_version.set(Integer.parseInt("5295"));
        paramString1.msg_subcmd0x2_req_check.set(paramString2);
        paramString1.setHasFlag(true);
        paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
        paramString2.putWupBuffer(paramString1.toByteArray());
        super.sendPbReq(paramString2);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("ThemeVersion Check sent,cur_ver = ");
          paramString1.append(i);
          QLog.i("Theme.ThemeHandler", 2, paramString1.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("Exception:");
          paramString2.append(paramString1.toString());
          QLog.e("Theme.ThemeHandler", 2, paramString2.toString());
        }
      }
      return;
      label422:
      i -= 3000;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"AuthSvr.ThemeAuth".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive~ handleThemeAuth res.isSuccess=");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject1).append(",data=");
      ((StringBuilder)localObject1).append(PkgTools.toHexStr((byte[])paramObject));
      QLog.i("Theme.ThemeHandler", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new ThemeAuth.RspBody();
        if (paramObject != null) {
          ((ThemeAuth.RspBody)localObject1).mergeFrom((byte[])paramObject);
        }
        if (!((ThemeAuth.RspBody)localObject1).uint32_sub_cmd.has()) {
          break label987;
        }
        i = ((ThemeAuth.RspBody)localObject1).uint32_sub_cmd.get();
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          break label993;
        }
        bool = true;
        int j = i;
        if (!bool)
        {
          i = a(paramToServiceMsg, i);
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onReceive Error: isSuccess=false, data=");
          paramFromServiceMsg.append(PkgTools.toHexStr((byte[])paramObject));
          paramFromServiceMsg.append(", subCmd=");
          paramFromServiceMsg.append(i);
          QLog.e("Theme.ThemeHandler", 1, paramFromServiceMsg.toString());
          j = i;
          if (3 != i) {
            return;
          }
        }
        if (1 == j)
        {
          paramObject = (ThemeAuth.SubCmd0x1RspAuth)((ThemeAuth.RspBody)localObject1).msg_subcmd0x1_rsp_auth.get();
          i = paramObject.int32_result.get();
          paramFromServiceMsg = new ThemeAuth.ReqBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
          paramFromServiceMsg = (ThemeAuth.SubCmd0x1ReqAuth)paramFromServiceMsg.msg_subcmd0x1_req_auth.get();
          String str1 = String.valueOf(paramFromServiceMsg.uint32_theme_id.get());
          String str2 = paramFromServiceMsg.str_theme_version.get();
          if (i != 0)
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleThemeAuth, error, ret:");
            paramFromServiceMsg.append(i);
            paramFromServiceMsg.append(", reqthemeId:");
            paramFromServiceMsg.append(str1);
            paramFromServiceMsg.append(", reqVersion:");
            paramFromServiceMsg.append(str2);
            QLog.e("Theme.ThemeHandler", 1, paramFromServiceMsg.toString());
            VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_theme_auth_fail", String.valueOf(i), String.valueOf(i), null, 0.0F);
            paramFromServiceMsg = new HashMap();
            paramFromServiceMsg.put("authResult", String.valueOf(i));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "individual_v2_theme_auth_fail", false, 0L, -1L, paramFromServiceMsg, "", true);
          }
          else if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleThemeAuth, authResult=");
            paramFromServiceMsg.append(i);
            QLog.i("Theme.ThemeHandler", 2, paramFromServiceMsg.toString());
          }
          ThemeReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "204", 157, NetworkUtil.getSystemNetwork(null), 0 - i, str1, str2, "1", "");
          Object localObject2;
          try
          {
            paramFromServiceMsg = new HashMap();
            paramFromServiceMsg.put("param_themeId", str1);
            try
            {
              paramFromServiceMsg.put("param_themeVersion", str2);
              paramFromServiceMsg.put("param_FailCode", String.valueOf(i));
              localObject2 = StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
              String str3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
              if (i != 0) {
                break label999;
              }
              bool = true;
              ((StatisticCollector)localObject2).collectPerformance(str3, "VipThemeAuthHandleError", bool, 1L, 0L, paramFromServiceMsg, "", false);
            }
            catch (Exception paramFromServiceMsg) {}
            localObject2 = new StringBuilder();
          }
          catch (Exception paramFromServiceMsg) {}
          ((StringBuilder)localObject2).append("handleThemeAuth, StatisticCollector error=");
          ((StringBuilder)localObject2).append(paramFromServiceMsg.toString());
          QLog.e("Theme.ThemeHandler", 1, ((StringBuilder)localObject2).toString());
          if ((i >= 1) && (i != 5) && (i != 14) && (i <= 20))
          {
            ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface).edit().putInt("themeAuthResult", i).commit();
            ThemeUtil.setCurrentThemeIdVersion(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "1000", "0");
            paramToServiceMsg = ((ThemeAuth.RspBody)localObject1).msg_subcmd0x1_rsp_auth.str_err_msg.get();
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleThemeAuth Error, authResult=");
            paramFromServiceMsg.append(i);
            paramFromServiceMsg.append(", reqthemeId:");
            paramFromServiceMsg.append(str1);
            paramFromServiceMsg.append(", err_msg=");
            paramFromServiceMsg.append(paramToServiceMsg);
            QLog.e("Theme.ThemeHandler", 1, paramFromServiceMsg.toString());
            a(i, str1, paramToServiceMsg, paramObject);
            return;
          }
          if (i == 0)
          {
            if (!a(paramToServiceMsg, paramObject, str1, str2)) {}
          }
          else
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleThemeAuth unknow type ret=");
            paramToServiceMsg.append(i);
            QLog.e("Theme.ThemeHandler", 1, paramToServiceMsg.toString());
            a(null, null, true);
          }
        }
        else
        {
          if (2 == j)
          {
            a((ThemeAuth.RspBody)localObject1);
            return;
          }
          if (3 == j)
          {
            if (!a(paramToServiceMsg, (ThemeAuth.RspBody)localObject1, bool)) {}
          }
          else
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleThemeAuth subCmd error, subCmd:");
            paramToServiceMsg.append(j);
            QLog.e("Theme.ThemeHandler", 1, paramToServiceMsg.toString());
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleThemeAuth Exception=");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("Theme.ThemeHandler", 1, paramFromServiceMsg.toString());
      }
      return;
      label987:
      int i = -1;
      continue;
      label993:
      boolean bool = false;
      continue;
      label999:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler
 * JD-Core Version:    0.7.0.1
 */