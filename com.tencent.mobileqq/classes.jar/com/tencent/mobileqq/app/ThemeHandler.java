package com.tencent.mobileqq.app;

import android.content.Context;
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
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
  private static String jdField_a_of_type_JavaLangString = null;
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
    paramString = FileUtils.a(paramString);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while ((i < 3) && (i < paramString.size()))
    {
      int j = new Random().nextInt(paramString.size() - 1);
      String str1 = (String)paramString.get(j);
      String str2 = str1.substring(str1.substring(0, str1.lastIndexOf(47)).lastIndexOf('/') + 1);
      if ((str2 != null) && (str2.length() > 0) && (!localHashMap.containsKey(str2)))
      {
        String str3 = FileUtils.b(str1, "MD5");
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme getRandomFileMd5 file=" + str1 + ",key=" + str2 + ",md5=" + str3 + ", files=" + paramString.size() + ", index=" + j);
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
    Object localObject1 = IndividuationUrlHelper.a(paramBaseActivity, "theme", "mvip.gongneng.android.theme.index_dynamic_tab");
    Object localObject2 = new StringBuilder().append((String)localObject1);
    if (((String)localObject1).contains("?"))
    {
      localObject1 = "&";
      localObject1 = (String)localObject1;
      localObject2 = (String)localObject1 + "dialog_source=other&authresult=" + paramInt2;
      localObject1 = localObject2;
      if (!android.text.TextUtils.isEmpty(paramString)) {
        if (!((String)localObject2).contains("id=[id]")) {
          break label207;
        }
      }
    }
    label207:
    for (localObject1 = ((String)localObject2).replace("[id]", paramString);; localObject1 = (String)localObject2 + "&id=" + paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeHandler", 2, "theme market url: " + (String)localObject1);
      }
      VasWebviewUtil.openQQBrowserWithoutAD(paramBaseActivity, (String)localObject1, 32L, localIntent, true, -1);
      return;
      localObject1 = "?";
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ThemeAuth.DiyThemeDetail paramDiyThemeDetail)
  {
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    Object localObject = ThemeBackground.getSharedPreferences(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 0);
    if ((paramInt1 == 2) && (!ChatBackgroundManager.a(localMobileQQ, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), null).equals("null"))) {
      return;
    }
    if (android.text.TextUtils.isEmpty(paramString1)) {
      paramString1 = paramDiyThemeDetail.str_bg_url.get();
    }
    for (;;)
    {
      int i = paramInt2;
      if (1 > paramInt2) {
        i = paramDiyThemeDetail.uin32_id.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeHandler", 2, "update sv ThemeBackground, page=" + paramInt1 + ", id=" + i + ", url=" + paramString1);
      }
      String str1;
      boolean bool;
      if (!android.text.TextUtils.isEmpty(paramString1))
      {
        str1 = ((SharedPreferences)localObject).getString(paramString3 + "_id", "");
        localObject = ((SharedPreferences)localObject).getString(paramString3 + "_url", "");
        if ((!("" + i).equals(str1)) || (android.text.TextUtils.isEmpty((CharSequence)localObject))) {
          break label631;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "updateThemeBackgroundPic, bgType=" + paramString3 + ", notChange=" + bool + ", localId=" + str1 + ", id=" + i + ", url=" + paramString1 + ", page=" + paramInt1);
        }
        if (bool) {
          break;
        }
        if (paramDiyThemeDetail == null) {
          break label637;
        }
        localObject = paramDiyThemeDetail.str_name.get();
        label358:
        if (paramDiyThemeDetail == null) {
          break label663;
        }
        paramInt2 = paramDiyThemeDetail.uin32_feetype.get();
        label372:
        if (paramDiyThemeDetail == null) {
          break label668;
        }
        str1 = paramDiyThemeDetail.str_bg_thumbnail_url.get();
        label387:
        String str2 = ChatBackgroundManager.a(true, "" + i);
        ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString3, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), str2, paramString1, "" + i, (String)localObject, paramInt2, str1, true);
        if (!paramString3.equals(paramString2))
        {
          String str3 = ChatBackgroundManager.a(true, "" + i);
          ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString2, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), str3, paramString1, "" + i, (String)localObject, paramInt2, str1, true);
        }
        if (paramInt1 == 2) {
          ChatBackground.a(localMobileQQ, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, str2);
        }
      }
      if ((!"100".equals(String.valueOf(i))) && (!"0".equals(String.valueOf(i)))) {
        break;
      }
      if (paramDiyThemeDetail != null) {}
      for (paramInt1 = paramDiyThemeDetail.uin32_feetype.get();; paramInt1 = 1)
      {
        ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString3, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "", "", "", "", paramInt1, null, true);
        return;
        label631:
        bool = false;
        break;
        label637:
        localObject = "" + i;
        break label358;
        label663:
        paramInt2 = 1;
        break label372;
        label668:
        str1 = null;
        break label387;
      }
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, ThemeAuth.SubCmd0x1RspAuth paramSubCmd0x1RspAuth)
  {
    int i = paramSubCmd0x1RspAuth.uint32_concise_id.get();
    int j = paramSubCmd0x1RspAuth.uint32_concise_switch.get();
    int k = paramSubCmd0x1RspAuth.uint32_study_switch.get();
    int m = paramSubCmd0x1RspAuth.uint32_young_switch.get();
    boolean bool2;
    if (j == 1)
    {
      bool1 = true;
      paramSubCmd0x1RspAuth = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (k != 1) {
        break label294;
      }
      bool2 = true;
      label64:
      if (m != 1) {
        break label300;
      }
    }
    label294:
    label300:
    for (boolean bool3 = true;; bool3 = false)
    {
      SimpleUIHandler.a(bool1, i, paramSubCmd0x1RspAuth, bool2, bool3);
      if ((3 != paramInt) || ("1000".equals(paramString1))) {
        break label337;
      }
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
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth error, set theme status=ThemeUtil.THEME_STATUS_DOWNLOAD_END, reqthemeId=" + paramString1);
        }
      }
      try
      {
        paramString1 = new ThemeLocator().a(paramString1).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
        FileUtils.a(paramString1, true);
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth no right, delete: " + paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth delete Error, msg=" + paramString1.getMessage());
        return;
      }
      bool1 = false;
      break;
      bool2 = false;
      break label64;
    }
    label337:
    if (paramInt != 4) {
      ThemeUtil.setWeekLoopTheme(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, null, 0L);
    }
    boolean bool1 = SkinEngine.getInstances().setSkinRootPath(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), null);
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth vip Error, set default theme");
    if ((paramInt == 1) || (paramInt == 2)) {
      i = 1;
    }
    for (;;)
    {
      if (bool1) {
        ReportController.b(null, "CliOper", "", "", "theme", "0X8007234", 0, 0, String.valueOf(i), "", "", "");
      }
      paramSubCmd0x1RspAuth = paramString2;
      if (android.text.TextUtils.isEmpty(paramString2)) {
        paramSubCmd0x1RspAuth = HardCodeUtil.a(2131714788);
      }
      if (bool1)
      {
        paramString2 = Message.obtain();
        Bundle localBundle = new Bundle();
        localBundle.putString("expireMsg", paramSubCmd0x1RspAuth);
        localBundle.putString("themeId", paramString1);
        localBundle.putInt("authResult", paramInt);
        localBundle.putInt("expireType", i);
        localBundle.putInt("sSimpleOpen", j);
        paramString2.obj = localBundle;
        if (j != 1) {
          break label720;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new ThemeHandler.2(this, paramString2), 4000L);
      }
      for (;;)
      {
        if (ThemeBackground.getMarkOfAioBgFromDiy(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_aio_path", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()))
        {
          ChatBackground.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "null");
          ThemeBackground.clear(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_aio_path", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        }
        ThemeBackground.clear(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_setting_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        ThemeBackground.clear(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_message_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        ThemeBackground.clear(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_friend_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        ThemeBackground.clear(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_dynamic_path_png", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        return;
        if ((paramInt == 10) || (paramInt == 11))
        {
          i = 2;
          break;
        }
        if (paramInt != 6) {
          break label733;
        }
        i = 3;
        break;
        label720:
        BannerManager.a().a(28, 2, paramString2);
      }
      label733:
      i = 4;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    String str1 = paramBundle.getString("themeId");
    String str2 = paramBundle.getString("themePath");
    Object localObject2;
    Object localObject3;
    String str3;
    try
    {
      localObject2 = new ThemeAuth.SubCmd0x1ReqAuth();
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).uint32_op_type.set(1);
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).uint32_theme_id.set(Integer.parseInt(str1));
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).str_theme_version.set("20000000");
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
      localObject3 = ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      str3 = ((SharedPreferences)localObject3).getString("currentThemeId_6.3.5", null);
      l1 = ((SharedPreferences)localObject3).getLong("themeSetTimeKey", 0L);
      QLog.d("Theme.ThemeHandler", 1, "Theme Auth themeId=" + str1 + ",version=" + "20000000" + ", userThemeId=" + str3 + ",currentThemeResPath=" + str2 + ", usr=" + com.tencent.mobileqq.text.TextUtils.hideUinInShowString(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 2) + ", oldTime=" + l1);
      if ("1000".equals(str1)) {
        break label967;
      }
      Object localObject4 = a(str2);
      if (((HashMap)localObject4).size() < 3) {
        QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth fileMD5 size error:size=" + ((HashMap)localObject4).size());
      }
      localObject4 = ((HashMap)localObject4).entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "Theme file Info,Filepath=" + (String)localEntry.getKey() + ",FileMd5=" + (String)localEntry.getValue());
          }
          ThemeAuth.ThemeFileInfo localThemeFileInfo = new ThemeAuth.ThemeFileInfo();
          localThemeFileInfo.str_file_path.set((String)localEntry.getKey());
          localThemeFileInfo.str_file_md5.set((String)localEntry.getValue());
          ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).rpt_msg_topic_file_info.add(localThemeFileInfo);
          continue;
          if (BaseApplicationImpl.IS_SUPPORT_THEME) {
            break;
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("Theme.ThemeHandler", 1, "Theme Auth send Exception:" + paramBundle.getMessage() + ", themeId=" + str1 + ", version=" + "20000000");
    }
    label518:
    label566:
    do
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth ERROR_CODE_ISNOT_SUPPORT_THEME.");
      int j = NetworkUtil.a(null);
      if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
        break;
      }
      i = 1;
      ThemeReporter.a(null, "theme_detail", "205", 157, j, i, str1, "20000000", "1", "");
      return;
      ((SharedPreferences)localObject3).edit().putLong("authTime", 0L).commit();
      localObject3 = new ThemeAuth.ReqBody();
      ((ThemeAuth.ReqBody)localObject3).uint32_sub_cmd.set(1);
      ((ThemeAuth.ReqBody)localObject3).int32_plat_id.set(109);
      ((ThemeAuth.ReqBody)localObject3).str_qq_version.set("8.5.5.5105");
      ((ThemeAuth.ReqBody)localObject3).uint32_qq_version.set(Integer.parseInt("5105"));
      ((ThemeAuth.ReqBody)localObject3).msg_subcmd0x1_req_auth.set((MessageMicro)localObject2);
      ((ThemeAuth.ReqBody)localObject3).setHasFlag(true);
      localObject2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
      ((ToServiceMsg)localObject2).putWupBuffer(((ThemeAuth.ReqBody)localObject3).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putAll(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeHandler", 2, "Theme Auth send request, themeID=" + str1 + ", userThemeId=" + str3);
      }
      super.sendPbReq((ToServiceMsg)localObject2);
    } while (("1000".equals(str1)) || (android.text.TextUtils.isEmpty(str2)));
    paramBundle = new File(str2);
    long l1 = System.currentTimeMillis();
    localObject1 = ThemeUtil.getThemeInfo((Context)localObject1, str1);
    long l2 = System.currentTimeMillis();
    if (localObject1 != null) {}
    for (int i = 1;; i = -1)
    {
      ThemeReporter.a(null, "theme_sp_speed", "204", 153, -1, i, String.valueOf(l2 - l1), "6653", "read", "");
      if ((paramBundle.isDirectory()) && (localObject1 != null))
      {
        i = ThemeUtil.getFileNumInFile(paramBundle);
        if ((i > 0) && ((((ThemeUtil.ThemeInfo)localObject1).fileNum <= 0) || (i >= ((ThemeUtil.ThemeInfo)localObject1).fileNum))) {
          break;
        }
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo.fileNum:" + ((ThemeUtil.ThemeInfo)localObject1).fileNum + ", fileNum:" + i + ", themeId=" + str1 + ", version=" + "20000000" + ", currentThemeResPath:" + str2);
        ThemeReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "204", 157, NetworkUtil.a(null), 101, str1, "665", String.valueOf(i), String.valueOf(((ThemeUtil.ThemeInfo)localObject1).fileNum));
        break;
        label967:
        if ((!android.text.TextUtils.isEmpty(str3)) && (!"1000".equals(str3))) {
          break label566;
        }
        l1 = ((SharedPreferences)localObject3).getLong("authTime", 0L);
        l2 = System.currentTimeMillis();
        if ((l2 > l1 + 7200000L) || (StudyModeManager.a()))
        {
          ((SharedPreferences)localObject3).edit().putLong("authTime", l2).commit();
          break label566;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "sendThemeAuth nowTime <= authTime + 2h");
        }
        DarkModeManager.b(true);
        return;
      }
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo == null || currentThemeResPath:" + str2);
      break;
      i = -40;
      break label518;
    }
  }
  
  private void a(ThemeAuth.RspBody paramRspBody)
  {
    int i = ((ThemeAuth.SubCmd0x2RspCheck)paramRspBody.msg_subcmd0x2_rsp_check.get()).int32_result.get();
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "handleThemeVersionCheck:" + i);
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
      BannerManager.a().a(27, 2, paramRspBody);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B9E", "0X8005B9E", 0, 0, "", "", "", "");
      ThreadManagerV2.getUIHandlerV2().postDelayed(new ThemeHandler.3(this), 90000L);
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, ThemeAuth.RspBody paramRspBody, boolean paramBoolean)
  {
    String str = HardCodeUtil.a(2131714791);
    int i;
    if (paramBoolean)
    {
      paramToServiceMsg = (ThemeAuth.SubCmd0x3RspSet)paramRspBody.msg_subcmd0x3_rsp_set.get();
      i = paramToServiceMsg.int32_result.get();
      paramRspBody = String.valueOf(paramToServiceMsg.uint32_theme_id.get());
    }
    for (paramToServiceMsg = paramToServiceMsg.str_diy_theme_err_msg.get();; paramToServiceMsg = str)
    {
      if ((QLog.isColorLevel()) || (i != 0)) {
        QLog.d("Theme.ThemeHandler", 1, "handleThemeAuth Set result:" + i + ", themeId:" + paramRspBody);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack != null) && (this.jdField_a_of_type_AndroidOsBundle != null)) {
        break;
      }
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:null == service || null == reqbundle, result:" + i);
      this.jdField_a_of_type_AndroidOsBundle = null;
      this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack = null;
      return true;
      paramRspBody = new ThemeAuth.ReqBody();
      paramRspBody.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      int j = ((ThemeAuth.SubCmd0x3ReqSet)paramRspBody.msg_subcmd0x3_req_set.get()).uint32_theme_id.get();
      i = -404;
      paramRspBody = String.valueOf(j);
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("message", paramToServiceMsg);
    this.jdField_a_of_type_AndroidOsBundle.putInt("result_int", i);
    if ((!android.text.TextUtils.isEmpty(paramRspBody)) && (paramRspBody.equals(this.jdField_a_of_type_AndroidOsBundle.getString("themeId"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeHandler", 2, "handleThemeAuth set back themeId=" + paramRspBody + ", result=" + i);
      }
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack;
      if (i == 0)
      {
        i = 4;
        paramToServiceMsg.a(16, i, this.jdField_a_of_type_AndroidOsBundle, null);
        this.jdField_a_of_type_AndroidOsBundle = null;
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack = null;
        this.c.set(true);
      }
    }
    for (;;)
    {
      return false;
      i = 8;
      break;
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:themeId has changed themeId=" + paramRspBody + ", rbThemeid=" + this.jdField_a_of_type_AndroidOsBundle.getString("themeId"));
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, ThemeAuth.SubCmd0x1RspAuth paramSubCmd0x1RspAuth, String paramString1, String paramString2)
  {
    String str2 = String.valueOf(paramSubCmd0x1RspAuth.uint32_theme_id.get());
    String str1 = paramSubCmd0x1RspAuth.str_version.get();
    String str3 = paramSubCmd0x1RspAuth.str_download_url.get();
    int i = paramSubCmd0x1RspAuth.uint32_concise_id.get();
    int j = paramSubCmd0x1RspAuth.uint32_concise_switch.get();
    int k = paramSubCmd0x1RspAuth.uint32_study_switch.get();
    int m = paramSubCmd0x1RspAuth.uint32_young_switch.get();
    int n = paramSubCmd0x1RspAuth.int32_suit_id.get();
    if ((QLog.isColorLevel()) || ((paramString2 != null) && (!paramString1.equals(str2)))) {
      QLog.d("Theme.ThemeHandler", 2, "authHandler get themeId=" + str2 + ",ver=" + str1 + ",Url=" + str3 + ", seriesId=" + n + ", reqthemeId:" + paramString1 + ", reqVersion:" + paramString2 + ", sSimpleThemeId:" + i + ", sSimpleOpen:" + j);
    }
    boolean bool1;
    boolean bool2;
    label221:
    boolean bool3;
    if (j == 1)
    {
      bool1 = true;
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (k != 1) {
        break label388;
      }
      bool2 = true;
      if (m != 1) {
        break label394;
      }
      bool3 = true;
      label230:
      SimpleUIHandler.a(bool1, i, paramString1, bool2, bool3);
      if ((!"999".equals(str2)) && (!"1000".equals(str2))) {
        break label731;
      }
    }
    label388:
    label394:
    label731:
    for (paramString1 = "20000000";; paramString1 = str1)
    {
      if ((android.text.TextUtils.isEmpty(paramString1)) || ("0".equals(str2))) {
        paramString1 = String.valueOf(200);
      }
      paramToServiceMsg = paramToServiceMsg.extraData.getString("oldEnginePath", null);
      paramString2 = SkinEngine.getInstances().getSkinRootPath();
      QLog.e("Theme.ThemeHandler", 1, "engine path old is : " + paramToServiceMsg + " new is " + paramString2);
      if ((!android.text.TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramToServiceMsg)))
      {
        QLog.e("Theme.ThemeHandler", 1, "engine init during auth, resend auth");
        a();
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label221;
        bool3 = false;
        break label230;
      }
      if (n <= 0)
      {
        QLog.e("Theme.ThemeHandler", 1, "clear weekTheme because seriesId=" + n);
        ThemeUtil.setWeekLoopTheme(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, null, 0L);
      }
      if (n > 0)
      {
        paramToServiceMsg = ThemeUtil.getWeekLoopTheme(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!android.text.TextUtils.isEmpty(paramToServiceMsg)) {
          b(paramToServiceMsg, "203");
        }
      }
      for (;;)
      {
        return false;
        if ((!"0".equals(str2)) && (!android.text.TextUtils.isEmpty(paramString1)) && (!this.c.get()))
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
          b(str2, "204");
        }
        else
        {
          a(null, null, true);
        }
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ("204".equalsIgnoreCase(paramString2))
    {
      if (!DarkModeManager.a(paramString1, paramString2)) {
        a(paramString1, paramString2);
      }
      while (ThemeUtil.isFixTheme(paramString1)) {
        return;
      }
      ThemeSwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, "20000000");
      return;
    }
    a(paramString1, paramString2);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
      return;
    }
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    Object localObject1 = ThemeUtil.getThemePreferences(localMobileQQ);
    Object localObject4;
    Object localObject3;
    if (1 > ((SharedPreferences)localObject1).getInt("themeSpVersion", 0))
    {
      localObject4 = ((SharedPreferences)localObject1).edit();
      try
      {
        localObject1 = ((SharedPreferences)localObject1).getString("userDownloadTheme", "");
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
        {
          JSONObject localJSONObject1 = new JSONObject((String)localObject1);
          Iterator localIterator = localJSONObject1.keys();
          while (localIterator.hasNext())
          {
            String str1 = String.valueOf(localIterator.next());
            if ((!android.text.TextUtils.isEmpty(str1)) && (!"1000".equals(str1)) && (!"999".equals(str1)))
            {
              JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str1);
              if (localJSONObject2 != null)
              {
                String str2 = localJSONObject2.optString("version");
                localObject3 = ThemeUtil.getThemeInfo(localMobileQQ, str1);
                localObject1 = localObject3;
                if (localObject3 == null)
                {
                  localObject1 = new ThemeUtil.ThemeInfo();
                  ((ThemeUtil.ThemeInfo)localObject1).themeId = str1;
                  ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme = localJSONObject2.optBoolean("sound");
                  ((ThemeUtil.ThemeInfo)localObject1).fileNum = localJSONObject2.optInt("fileNum");
                }
                ((ThemeUtil.ThemeInfo)localObject1).version = str2;
                ((ThemeUtil.ThemeInfo)localObject1).zipVer = Integer.parseInt(str2);
                ((ThemeUtil.ThemeInfo)localObject1).status = "1";
                ThemeUtil.setThemeInfo(localMobileQQ, (ThemeUtil.ThemeInfo)localObject1);
              }
            }
          }
        }
        ((SharedPreferences.Editor)localObject4).putInt("themeSpVersion", 1).commit();
      }
      catch (Exception localException)
      {
        QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth themeUpdate error:" + localException.getMessage());
      }
    }
    else
    {
      localObject4 = ThemeUtil.getCurrentThemeInfo();
      ((Bundle)localObject4).putString("oldEnginePath", ((Bundle)localObject4).getString("themePath"));
      QLog.d("Theme.ThemeHandler", 1, "sendThemeAuth init: , skThemeId:" + ((Bundle)localObject4).getString("themeId") + ", skVersion:" + ((Bundle)localObject4).getString("version") + ", qqVersion:" + "8.5.5");
      localObject3 = ((Bundle)localObject4).getString("themeId");
      localObject2 = localObject3;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = "1000";
        ((Bundle)localObject4).putString("themeId", "1000");
      }
      if (QQTheme.b((String)localObject2))
      {
        localObject3 = ThemeSwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getString("themeID");
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth isThemeSimpleUI:" + (String)localObject2 + " pre:" + (String)localObject3);
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
          break label526;
        }
        localObject2 = "1000";
        label478:
        ((Bundle)localObject4).putString("themeId", (String)localObject2);
        if (!"1000".equals(localObject3)) {
          break label531;
        }
        ((Bundle)localObject4).remove("themePath");
      }
    }
    for (;;)
    {
      a((Bundle)localObject4);
      return;
      ((SharedPreferences.Editor)localObject4).remove("userDownloadTheme");
      break;
      label526:
      localObject2 = localObject3;
      break label478;
      label531:
      if (!"999".equals(localObject3)) {
        break label565;
      }
      ((Bundle)localObject4).putString("themePath", new ThemeLocator().a().d());
    }
    label565:
    Object localObject2 = new ThemeLocator().a((String)localObject3);
    ((IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(3, ((ThemeLocator)localObject2).b(), true, false, 0L, new ThemeHandler.5(this, (ThemeLocator)localObject2, localMobileQQ, (Bundle)localObject4));
  }
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool1 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    boolean bool2 = SimpleUIUtil.a();
    if (!bool2)
    {
      if (!bool1) {
        break label110;
      }
      ThemeSwitcher.a("1103", paramString2, null);
    }
    for (;;)
    {
      QLog.e("Theme.ThemeHandler", 1, "onGetServerTheme: " + paramString1 + "," + bool2 + "," + bool1 + "," + paramString2);
      if (!ThemeUtil.isFixTheme(paramString1)) {
        ThemeSwitchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, "20000000");
      }
      return;
      label110:
      ThemeSwitcher.a(paramString1, paramString2, new ThemeHandler.4(this));
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 144
    //   11: iconst_2
    //   12: new 146	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1181
    //   22: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 675
    //   32: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 1183
    //   42: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +8 -> 67
    //   62: aload 4
    //   64: ifnonnull +13 -> 77
    //   67: ldc 144
    //   69: iconst_2
    //   70: ldc_w 1185
    //   73: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: return
    //   77: aload 4
    //   79: ldc_w 479
    //   82: aload_1
    //   83: invokevirtual 477	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: aload 5
    //   89: putfield 870	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack	Lcom/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$StyleCallBack;
    //   92: aload_0
    //   93: aload 4
    //   95: putfield 872	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   98: new 880	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet
    //   101: dup
    //   102: invokespecial 1186	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:<init>	()V
    //   105: astore_2
    //   106: aload_2
    //   107: getfield 882	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_theme_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: aload_1
    //   111: invokestatic 565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   117: aload_3
    //   118: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: istore 8
    //   123: iload 7
    //   125: istore 6
    //   127: iload 8
    //   129: ifne +9 -> 138
    //   132: aload_3
    //   133: invokestatic 565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   136: istore 6
    //   138: aload_2
    //   139: getfield 1189	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_suit_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: iload 6
    //   144: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   147: aload 4
    //   149: ldc_w 1191
    //   152: invokevirtual 1195	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   155: astore_1
    //   156: aload_1
    //   157: ifnull +9 -> 166
    //   160: aload 4
    //   162: aload_1
    //   163: invokevirtual 746	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   166: ldc_w 1197
    //   169: aload 4
    //   171: ldc_w 1199
    //   174: invokevirtual 544	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   180: ifeq +277 -> 457
    //   183: new 1201	com/tencent/pb/theme/ThemeAuth$diyThemeInfo
    //   186: dup
    //   187: invokespecial 1202	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:<init>	()V
    //   190: astore_1
    //   191: aload_1
    //   192: getfield 1203	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_drawer_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   195: aload 4
    //   197: ldc_w 1205
    //   200: invokevirtual 544	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokestatic 565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   206: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   209: aload_1
    //   210: getfield 1206	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_message_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   213: aload 4
    //   215: ldc_w 1208
    //   218: invokevirtual 544	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   221: invokestatic 565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   224: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   227: aload_1
    //   228: getfield 1209	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_aio_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   231: aload 4
    //   233: ldc_w 1211
    //   236: invokevirtual 544	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokestatic 565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   242: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   245: aload_1
    //   246: getfield 1214	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_freind_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   249: aload 4
    //   251: ldc_w 1216
    //   254: invokevirtual 544	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   257: invokestatic 565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   260: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   263: aload_1
    //   264: getfield 1219	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_dynamics_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   267: aload 4
    //   269: ldc_w 1221
    //   272: invokevirtual 544	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: invokestatic 565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   278: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   281: aload_2
    //   282: getfield 1225	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:diy_theme_info	Lcom/tencent/pb/theme/ThemeAuth$diyThemeInfo;
    //   285: aload_1
    //   286: invokevirtual 1226	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   289: aload_2
    //   290: getfield 1227	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_diy_theme_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   293: iconst_1
    //   294: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   297: new 41	com/tencent/pb/theme/ThemeAuth$ReqBody
    //   300: dup
    //   301: invokespecial 43	com/tencent/pb/theme/ThemeAuth$ReqBody:<init>	()V
    //   304: astore_1
    //   305: aload_1
    //   306: getfield 57	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   309: iconst_3
    //   310: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   313: aload_1
    //   314: getfield 701	com/tencent/pb/theme/ThemeAuth$ReqBody:int32_plat_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   317: bipush 109
    //   319: invokevirtual 704	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   322: aload_1
    //   323: getfield 707	com/tencent/pb/theme/ThemeAuth$ReqBody:str_qq_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   326: ldc_w 709
    //   329: invokevirtual 573	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   332: aload_1
    //   333: getfield 712	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_qq_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: ldc_w 714
    //   339: invokestatic 565	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   342: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   345: aload_1
    //   346: getfield 878	com/tencent/pb/theme/ThemeAuth$ReqBody:msg_subcmd0x3_req_set	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet;
    //   349: aload_2
    //   350: invokevirtual 1228	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   353: aload_1
    //   354: iconst_1
    //   355: invokevirtual 723	com/tencent/pb/theme/ThemeAuth$ReqBody:setHasFlag	(Z)V
    //   358: new 45	com/tencent/qphone/base/remote/ToServiceMsg
    //   361: dup
    //   362: ldc_w 725
    //   365: aload_0
    //   366: getfield 38	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   369: invokevirtual 728	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   372: ldc_w 730
    //   375: invokespecial 733	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   378: astore_2
    //   379: aload_2
    //   380: aload_1
    //   381: invokevirtual 736	com/tencent/pb/theme/ThemeAuth$ReqBody:toByteArray	()[B
    //   384: invokevirtual 740	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   387: aload_0
    //   388: aload_2
    //   389: invokespecial 752	com/tencent/mobileqq/app/BusinessHandler:sendPbReq	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   392: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq -319 -> 76
    //   398: ldc 144
    //   400: iconst_2
    //   401: ldc_w 1230
    //   404: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: return
    //   408: astore_1
    //   409: ldc 144
    //   411: iconst_2
    //   412: new 146	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 1232
    //   422: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_1
    //   426: invokevirtual 1233	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: return
    //   439: astore_1
    //   440: ldc 144
    //   442: iconst_1
    //   443: ldc_w 1235
    //   446: aload_1
    //   447: invokestatic 1238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   450: iload 7
    //   452: istore 6
    //   454: goto -316 -> 138
    //   457: aload_2
    //   458: getfield 1227	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_diy_theme_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: iconst_0
    //   462: invokevirtual 556	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   465: goto -168 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	ThemeHandler
    //   0	468	1	paramString1	String
    //   0	468	2	paramString2	String
    //   0	468	3	paramString3	String
    //   0	468	4	paramBundle	Bundle
    //   0	468	5	paramStyleCallBack	ThemeDiyStyleLogic.StyleCallBack
    //   125	328	6	i	int
    //   1	450	7	j	int
    //   121	7	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   77	123	408	java/lang/Exception
    //   138	156	408	java/lang/Exception
    //   160	166	408	java/lang/Exception
    //   166	297	408	java/lang/Exception
    //   297	407	408	java/lang/Exception
    //   440	450	408	java/lang/Exception
    //   457	465	408	java/lang/Exception
    //   132	138	439	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    label12:
    String str;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
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
    } while ((android.text.TextUtils.isEmpty(paramString1)) || ("1000".equals(paramString1)) || ("999".equals(paramString1)) || (android.text.TextUtils.isEmpty(str)));
    jdField_a_of_type_JavaLangString = paramString1;
    for (;;)
    {
      int i;
      try
      {
        i = Integer.parseInt(str) % 10000;
        paramString2 = ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
        if (!"m".equals(paramString2)) {
          break label378;
        }
        i -= 1000;
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "ver = " + i);
        }
        paramString2 = new ThemeAuth.SubCmd0x2ReqCheck();
        paramString2.str_theme_version.set(String.valueOf(i));
        paramString2.uint32_theme_id.set(Integer.parseInt(paramString1));
        paramString1 = new ThemeAuth.ReqBody();
        paramString1.uint32_sub_cmd.set(2);
        paramString1.int32_plat_id.set(109);
        paramString1.str_qq_version.set("8.5.5.5105");
        paramString1.uint32_qq_version.set(Integer.parseInt("5105"));
        paramString1.msg_subcmd0x2_req_check.set(paramString2);
        paramString1.setHasFlag(true);
        paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
        paramString2.putWupBuffer(paramString1.toByteArray());
        super.sendPbReq(paramString2);
        if (!QLog.isColorLevel()) {
          break label12;
        }
        QLog.i("Theme.ThemeHandler", 2, "ThemeVersion Check sent,cur_ver = " + i);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Theme.ThemeHandler", 2, "Exception:" + paramString1.toString());
      return;
      label378:
      paramBoolean = "h".equals(paramString2);
      if (paramBoolean) {
        i -= 2000;
      } else {
        i -= 3000;
      }
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  /* Error */
  public void onReceive(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 730
    //   3: aload_2
    //   4: invokevirtual 1271	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   7: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +51 -> 68
    //   20: ldc 144
    //   22: iconst_2
    //   23: new 146	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 1273
    //   33: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 1276	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   40: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   43: ldc_w 1278
    //   46: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_3
    //   50: checkcast 1280	[B
    //   53: checkcast 1280	[B
    //   56: invokestatic 1286	com/tencent/mobileqq/utils/httputils/PkgTools:toHexStr	([B)Ljava/lang/String;
    //   59: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: new 812	com/tencent/pb/theme/ThemeAuth$RspBody
    //   71: dup
    //   72: invokespecial 1287	com/tencent/pb/theme/ThemeAuth$RspBody:<init>	()V
    //   75: astore 7
    //   77: aload_3
    //   78: ifnull +16 -> 94
    //   81: aload 7
    //   83: aload_3
    //   84: checkcast 1280	[B
    //   87: checkcast 1280	[B
    //   90: invokevirtual 1290	com/tencent/pb/theme/ThemeAuth$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: pop
    //   94: aload 7
    //   96: getfield 1291	com/tencent/pb/theme/ThemeAuth$RspBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   99: invokevirtual 1294	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   102: ifeq +601 -> 703
    //   105: aload 7
    //   107: getfield 1291	com/tencent/pb/theme/ThemeAuth$RspBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 63	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: istore 4
    //   115: aload_2
    //   116: invokevirtual 1276	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   119: ifeq +590 -> 709
    //   122: aload_3
    //   123: ifnull +586 -> 709
    //   126: iconst_1
    //   127: istore 6
    //   129: iload 4
    //   131: istore 5
    //   133: iload 6
    //   135: ifne +64 -> 199
    //   138: aload_0
    //   139: aload_1
    //   140: iload 4
    //   142: invokespecial 1296	com/tencent/mobileqq/app/ThemeHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)I
    //   145: istore 5
    //   147: ldc 144
    //   149: iconst_1
    //   150: new 146	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 1298
    //   160: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_3
    //   164: checkcast 1280	[B
    //   167: checkcast 1280	[B
    //   170: invokestatic 1286	com/tencent/mobileqq/utils/httputils/PkgTools:toHexStr	([B)Ljava/lang/String;
    //   173: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 1300
    //   179: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 5
    //   184: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iconst_3
    //   194: iload 5
    //   196: if_icmpne -183 -> 13
    //   199: iconst_1
    //   200: iload 5
    //   202: if_icmpne +637 -> 839
    //   205: aload 7
    //   207: getfield 1304	com/tencent/pb/theme/ThemeAuth$RspBody:msg_subcmd0x1_rsp_auth	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth;
    //   210: invokevirtual 1305	com/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   213: checkcast 347	com/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth
    //   216: astore_2
    //   217: aload_2
    //   218: getfield 1306	com/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   221: invokevirtual 825	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   224: istore 4
    //   226: new 41	com/tencent/pb/theme/ThemeAuth$ReqBody
    //   229: dup
    //   230: invokespecial 43	com/tencent/pb/theme/ThemeAuth$ReqBody:<init>	()V
    //   233: astore_3
    //   234: aload_3
    //   235: aload_1
    //   236: invokevirtual 49	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   239: iconst_4
    //   240: aload_1
    //   241: invokevirtual 49	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   244: arraylength
    //   245: iconst_4
    //   246: isub
    //   247: invokevirtual 53	com/tencent/pb/theme/ThemeAuth$ReqBody:mergeFrom	([BII)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   250: pop
    //   251: aload_3
    //   252: getfield 718	com/tencent/pb/theme/ThemeAuth$ReqBody:msg_subcmd0x1_req_auth	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth;
    //   255: invokevirtual 1307	com/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   258: checkcast 548	com/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth
    //   261: astore 8
    //   263: aload 8
    //   265: getfield 559	com/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth:uint32_theme_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   268: invokevirtual 63	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   271: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   274: astore_3
    //   275: aload 8
    //   277: getfield 568	com/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth:str_theme_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   280: invokevirtual 282	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   283: astore 8
    //   285: iload 4
    //   287: ifeq +428 -> 715
    //   290: ldc 144
    //   292: iconst_1
    //   293: new 146	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 1309
    //   303: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload 4
    //   308: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: ldc_w 922
    //   314: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 924
    //   324: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 8
    //   329: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload_0
    //   339: getfield 36	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: ldc_w 1311
    //   345: iload 4
    //   347: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   350: iload 4
    //   352: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   355: aconst_null
    //   356: fconst_0
    //   357: invokestatic 1316	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   360: new 97	java/util/HashMap
    //   363: dup
    //   364: invokespecial 98	java/util/HashMap:<init>	()V
    //   367: astore 9
    //   369: aload 9
    //   371: ldc_w 481
    //   374: iload 4
    //   376: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   379: invokevirtual 176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: invokestatic 582	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   386: invokestatic 1322	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   389: ldc_w 295
    //   392: ldc_w 1311
    //   395: iconst_0
    //   396: lconst_0
    //   397: ldc2_w 1323
    //   400: aload 9
    //   402: ldc_w 295
    //   405: iconst_1
    //   406: invokevirtual 1328	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   409: aload_0
    //   410: getfield 36	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   413: ldc_w 690
    //   416: ldc_w 766
    //   419: sipush 157
    //   422: aconst_null
    //   423: invokestatic 688	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   426: iconst_0
    //   427: iload 4
    //   429: isub
    //   430: aload_3
    //   431: aload 8
    //   433: ldc_w 412
    //   436: ldc_w 295
    //   439: invokestatic 697	com/tencent/mobileqq/theme/ThemeReporter:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   442: new 97	java/util/HashMap
    //   445: dup
    //   446: invokespecial 98	java/util/HashMap:<init>	()V
    //   449: astore 9
    //   451: aload 9
    //   453: ldc_w 1330
    //   456: aload_3
    //   457: invokevirtual 176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   460: pop
    //   461: aload 9
    //   463: ldc_w 1332
    //   466: aload 8
    //   468: invokevirtual 176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: aload 9
    //   474: ldc_w 1334
    //   477: iload 4
    //   479: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   482: invokevirtual 176	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload_0
    //   487: getfield 38	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   490: invokevirtual 255	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   493: invokestatic 1322	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   496: astore 10
    //   498: aload_0
    //   499: getfield 38	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   502: invokevirtual 258	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   505: astore 11
    //   507: iload 4
    //   509: ifne +390 -> 899
    //   512: iconst_1
    //   513: istore 6
    //   515: aload 10
    //   517: aload 11
    //   519: ldc_w 1336
    //   522: iload 6
    //   524: lconst_1
    //   525: lconst_0
    //   526: aload 9
    //   528: ldc_w 295
    //   531: iconst_0
    //   532: invokevirtual 1328	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   535: iload 4
    //   537: iconst_1
    //   538: if_icmplt +248 -> 786
    //   541: iload 4
    //   543: iconst_5
    //   544: if_icmpeq +242 -> 786
    //   547: iload 4
    //   549: bipush 14
    //   551: if_icmpeq +235 -> 786
    //   554: iload 4
    //   556: bipush 20
    //   558: if_icmpgt +228 -> 786
    //   561: aload_0
    //   562: getfield 38	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   565: invokestatic 69	com/tencent/mobileqq/theme/ThemeUtil:getUinThemePreferences	(Lmqq/app/AppRuntime;)Landroid/content/SharedPreferences;
    //   568: invokeinterface 75 1 0
    //   573: ldc_w 1338
    //   576: iload 4
    //   578: invokeinterface 1104 3 0
    //   583: invokeinterface 87 1 0
    //   588: pop
    //   589: aload_0
    //   590: getfield 38	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   593: ldc_w 366
    //   596: ldc_w 342
    //   599: invokestatic 1341	com/tencent/mobileqq/theme/ThemeUtil:setCurrentThemeIdVersion	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;
    //   602: pop
    //   603: aload 7
    //   605: getfield 1304	com/tencent/pb/theme/ThemeAuth$RspBody:msg_subcmd0x1_rsp_auth	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth;
    //   608: getfield 1344	com/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth:str_err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   611: invokevirtual 282	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   614: astore_1
    //   615: ldc 144
    //   617: iconst_1
    //   618: new 146	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   625: ldc_w 1346
    //   628: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: iload 4
    //   633: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   636: ldc_w 922
    //   639: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload_3
    //   643: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: ldc_w 1348
    //   649: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload_1
    //   653: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: aload_0
    //   663: iload 4
    //   665: aload_3
    //   666: aload_1
    //   667: aload_2
    //   668: invokespecial 1350	com/tencent/mobileqq/app/ThemeHandler:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth;)V
    //   671: return
    //   672: astore_1
    //   673: ldc 144
    //   675: iconst_1
    //   676: new 146	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   683: ldc_w 1352
    //   686: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_1
    //   690: invokevirtual 442	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   693: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: return
    //   703: iconst_m1
    //   704: istore 4
    //   706: goto -591 -> 115
    //   709: iconst_0
    //   710: istore 6
    //   712: goto -583 -> 129
    //   715: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   718: ifeq -309 -> 409
    //   721: ldc 144
    //   723: iconst_2
    //   724: new 146	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   731: ldc_w 1354
    //   734: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: iload 4
    //   739: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: goto -339 -> 409
    //   751: astore 9
    //   753: ldc 144
    //   755: iconst_1
    //   756: new 146	java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   763: ldc_w 1356
    //   766: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload 9
    //   771: invokevirtual 1233	java/lang/Exception:toString	()Ljava/lang/String;
    //   774: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: goto -248 -> 535
    //   786: iload 4
    //   788: ifne +16 -> 804
    //   791: aload_0
    //   792: aload_1
    //   793: aload_2
    //   794: aload_3
    //   795: aload 8
    //   797: invokespecial 1358	com/tencent/mobileqq/app/ThemeHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth;Ljava/lang/String;Ljava/lang/String;)Z
    //   800: ifeq -787 -> 13
    //   803: return
    //   804: ldc 144
    //   806: iconst_1
    //   807: new 146	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 1360
    //   817: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: iload 4
    //   822: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: aload_0
    //   832: aconst_null
    //   833: aconst_null
    //   834: iconst_1
    //   835: invokevirtual 1032	com/tencent/mobileqq/app/ThemeHandler:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   838: return
    //   839: iconst_2
    //   840: iload 5
    //   842: if_icmpne +10 -> 852
    //   845: aload_0
    //   846: aload 7
    //   848: invokespecial 1362	com/tencent/mobileqq/app/ThemeHandler:a	(Lcom/tencent/pb/theme/ThemeAuth$RspBody;)V
    //   851: return
    //   852: iconst_3
    //   853: iload 5
    //   855: if_icmpne +16 -> 871
    //   858: aload_0
    //   859: aload_1
    //   860: aload 7
    //   862: iload 6
    //   864: invokespecial 1364	com/tencent/mobileqq/app/ThemeHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/pb/theme/ThemeAuth$RspBody;Z)Z
    //   867: ifeq -854 -> 13
    //   870: return
    //   871: ldc 144
    //   873: iconst_1
    //   874: new 146	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   881: ldc_w 1366
    //   884: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: iload 5
    //   889: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   892: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   898: return
    //   899: iconst_0
    //   900: istore 6
    //   902: goto -387 -> 515
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	905	0	this	ThemeHandler
    //   0	905	1	paramToServiceMsg	ToServiceMsg
    //   0	905	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	905	3	paramObject	Object
    //   113	708	4	i	int
    //   131	757	5	j	int
    //   127	774	6	bool	boolean
    //   75	786	7	localRspBody	ThemeAuth.RspBody
    //   261	535	8	localObject	Object
    //   367	160	9	localHashMap	HashMap
    //   751	19	9	localException	Exception
    //   496	20	10	localStatisticCollector	com.tencent.mobileqq.statistics.StatisticCollector
    //   505	13	11	str	String
    // Exception table:
    //   from	to	target	type
    //   68	77	672	java/lang/Exception
    //   81	94	672	java/lang/Exception
    //   94	115	672	java/lang/Exception
    //   115	122	672	java/lang/Exception
    //   138	193	672	java/lang/Exception
    //   205	285	672	java/lang/Exception
    //   290	409	672	java/lang/Exception
    //   409	442	672	java/lang/Exception
    //   561	671	672	java/lang/Exception
    //   715	748	672	java/lang/Exception
    //   753	783	672	java/lang/Exception
    //   791	803	672	java/lang/Exception
    //   804	838	672	java/lang/Exception
    //   845	851	672	java/lang/Exception
    //   858	870	672	java/lang/Exception
    //   871	898	672	java/lang/Exception
    //   442	507	751	java/lang/Exception
    //   515	535	751	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler
 * JD-Core Version:    0.7.0.1
 */