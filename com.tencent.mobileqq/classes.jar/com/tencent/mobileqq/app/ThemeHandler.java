package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasMonitorHandler;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import znk;

public class ThemeHandler
  extends BusinessHandler
{
  private static String jdField_a_of_type_JavaLangString;
  public Bundle a;
  public ThemeDiyStyleLogic.StyleCallBack a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  AtomicBoolean b;
  
  ThemeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private HashMap a(String paramString)
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
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"AuthSvr.ThemeAuth".equals(paramFromServiceMsg.getServiceCmd())) {}
    Object localObject2;
    int k;
    int j;
    Object localObject1;
    boolean bool;
    label933:
    label939:
    label1007:
    label1270:
    do
    {
      Object localObject3;
      Object localObject4;
      String str1;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "onReceive~ handleThemeAuth res.isSuccess=" + paramFromServiceMsg.isSuccess() + ",data=" + PkgTools.a((byte[])paramObject));
        }
        for (;;)
        {
          try
          {
            localObject2 = new ThemeAuth.RspBody();
            if (paramObject != null) {
              ((ThemeAuth.RspBody)localObject2).mergeFrom((byte[])paramObject);
            }
            if (((ThemeAuth.RspBody)localObject2).uint32_sub_cmd.has())
            {
              i = ((ThemeAuth.RspBody)localObject2).uint32_sub_cmd.get();
              if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
                break label933;
              }
              k = 1;
              j = i;
              if (k == 0)
              {
                j = i;
                if (-1 == i)
                {
                  paramFromServiceMsg = new ThemeAuth.ReqBody();
                  paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
                  j = paramFromServiceMsg.uint32_sub_cmd.get();
                }
                if (1 == j) {
                  ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface).edit().putLong("authTime", 0L).commit();
                }
                QLog.e("Theme.ThemeHandler", 1, "onReceive Error: isSuccess=false, data=" + PkgTools.a((byte[])paramObject) + ", subCmd=" + j);
                if (3 != j) {
                  break;
                }
              }
              if (1 != j) {
                break label2549;
              }
              paramObject = (ThemeAuth.SubCmd0x1RspAuth)((ThemeAuth.RspBody)localObject2).msg_subcmd0x1_rsp_auth.get();
              j = paramObject.int32_result.get();
              if (QLog.isColorLevel()) {
                QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, authResult=" + j);
              }
              paramFromServiceMsg = new ThemeAuth.ReqBody();
              paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
              paramFromServiceMsg = (ThemeAuth.SubCmd0x1ReqAuth)paramFromServiceMsg.msg_subcmd0x1_req_auth.get();
              localObject1 = String.valueOf(paramFromServiceMsg.uint32_theme_id.get());
              localObject3 = paramFromServiceMsg.str_theme_version.get();
              if (j == 0) {
                break label939;
              }
              QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth, error, ret:" + j + ", reqthemeId:" + (String)localObject1 + ", reqVersion:" + (String)localObject3);
              VasMonitorHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_theme_auth_fail", String.valueOf(j), String.valueOf(j), null, 0.0F);
              ThemeReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "204", 157, NetworkUtil.a(null), 0 - j, (String)localObject1, (String)localObject3, "1", "");
            }
          }
          catch (Exception paramToServiceMsg)
          {
            QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Exception=" + paramToServiceMsg.getMessage());
            return;
          }
          try
          {
            paramFromServiceMsg = new HashMap();
            paramFromServiceMsg.put("param_themeId", localObject1);
            paramFromServiceMsg.put("param_themeVersion", localObject3);
            paramFromServiceMsg.put("param_FailCode", String.valueOf(j));
            localObject4 = StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
            str1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
            if (j != 0) {
              break label3235;
            }
            bool = true;
            ((StatisticCollector)localObject4).a(str1, "VipThemeAuthHandleError", bool, 1L, 0L, paramFromServiceMsg, "", false);
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth, StatisticCollector error=" + paramFromServiceMsg.toString());
            continue;
            if (j == 4) {
              break label1024;
            }
            ThemeUtil.setWeekLoopTheme(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, null, 0L);
            bool = SkinEngine.getInstances().setSkinRootPath(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), null);
            QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth vip Error, set default theme");
            i = 4;
            if (j == 1) {
              break label3241;
            }
          }
          if ((j < 1) || (j == 5) || (j > 13)) {
            break label1270;
          }
          ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface).edit().putInt("themeAuthResult", j).commit();
          ThemeUtil.setCurrentThemeIdVersion(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "1000", "0");
          paramToServiceMsg = ((ThemeAuth.RspBody)localObject2).msg_subcmd0x1_rsp_auth.str_err_msg.get();
          QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, authResult=" + j + ", reqthemeId:" + (String)localObject1 + ", err_msg=" + paramToServiceMsg);
          if ((3 != j) || ("1000".equals(localObject1))) {
            break label1007;
          }
          ThemeUtil.setErrorThemeId(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), (String)localObject1, false);
          paramToServiceMsg = ThemeUtil.getUserCurrentThemeVersion(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          bool = SkinEngine.getInstances().setSkinRootPath(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), null);
          QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, set default theme");
          if (bool == true) {
            ThreadManager.getUIHandler().post(new znk(this));
          }
          paramFromServiceMsg = ThemeUtil.getThemeInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), (String)localObject1);
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg.status = "1";
            ThemeUtil.setThemeInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramFromServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth error, set theme status=ThemeUtil.THEME_STATUS_DOWNLOAD_END, reqthemeId=" + (String)localObject1);
            }
          }
          try
          {
            FileUtils.a(ThemeUtil.getThemeResourcePath(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), (String)localObject1, paramToServiceMsg), true);
            return;
          }
          catch (Exception paramToServiceMsg)
          {
            QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth delete Error, msg=" + paramToServiceMsg.getMessage());
            return;
          }
          i = -1;
          continue;
          k = 0;
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, authResult=" + j);
          }
        }
        if (j != 2) {
          break label3247;
        }
        break label3241;
        if (bool) {
          ReportController.b(null, "CliOper", "", "", "theme", "0X8007234", 0, 0, String.valueOf(i), "", "", "");
        }
        if ((!android.text.TextUtils.isEmpty(paramToServiceMsg)) && (bool))
        {
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(Conversation.class);
          paramObject = new Message();
          paramObject.what = 1049;
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("expireMsg", paramToServiceMsg);
          ((Bundle)localObject2).putString("themeId", (String)localObject1);
          ((Bundle)localObject2).putInt("authResult", j);
          ((Bundle)localObject2).putInt("expireType", i);
          paramObject.obj = localObject2;
          paramFromServiceMsg.sendMessage(paramObject);
        }
      } while (!ThemeBackground.getMarkOfAioBgFromDiy(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_aio_path", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
      ChatBackground.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "null");
      ThemeBackground.clear(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), "theme_bg_aio_path", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      return;
      if (j == 0)
      {
        String str3 = String.valueOf(paramObject.uint32_theme_id.get());
        paramFromServiceMsg = paramObject.str_version.get();
        localObject2 = paramObject.str_download_url.get();
        i = paramObject.int32_suit_id.get();
        if ((QLog.isColorLevel()) || ((localObject3 != null) && (!((String)localObject1).equals(str3)))) {
          QLog.d("Theme.ThemeHandler", 2, "authHandler get themeId=" + str3 + ",ver=" + paramFromServiceMsg + ",Url=" + (String)localObject2 + ", seriesId=" + i + ", reqthemeId:" + (String)localObject1 + ", reqVersion:" + (String)localObject3);
        }
        if (("999".equals(str3)) || ("1000".equals(str3))) {
          break label3280;
        }
        if ((!android.text.TextUtils.isEmpty(paramFromServiceMsg)) && (!"0".equals(str3))) {
          break label3229;
        }
        localObject2 = String.valueOf(200);
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        if (i == 0) {
          break label3301;
        }
        paramFromServiceMsg = String.valueOf(i);
        ThemeUtil.setWeekLoopTheme((AppRuntime)localObject1, paramFromServiceMsg, null, 0L);
        if ((!"0".equals(str3)) && (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("url", paramObject.str_download_url.get());
          localBundle.putString("themeId", str3);
          localBundle.putString("version", (String)localObject2);
          localBundle.putLong("size", paramObject.uint32_size.get());
          if (paramObject.int32_is_sound_theme.get() != 1) {
            break label3306;
          }
          bool = true;
          localBundle.putBoolean("isVoiceTheme", bool);
          localBundle.putInt("themeType", 1);
          localBundle.putBoolean("skipEngineChange", true);
          localBundle.putString("oldEnginePath", paramToServiceMsg.extraData.getString("oldEnginePath", null));
          if (paramObject.uint32_diy_theme_flag.get() == 1)
          {
            paramToServiceMsg = (ThemeAuth.RspDiyThemeInfo)paramObject.rsp_diy_theme_info.get();
            int m = paramToServiceMsg.uin32_drawer_tab_id.get();
            int n = paramToServiceMsg.uin32_message_tab_id.get();
            int i1 = paramToServiceMsg.uin32_aio_tab_id.get();
            localObject4 = paramToServiceMsg.str_drawer_tab_url.get();
            str1 = paramToServiceMsg.str_message_tab_url.get();
            String str2 = paramToServiceMsg.str_aio_tab_url.get();
            MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
            SharedPreferences localSharedPreferences = localMobileQQ.getSharedPreferences("theme_background_path_" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 0);
            ThemeAuth.RspDiyThemeDetail localRspDiyThemeDetail = (ThemeAuth.RspDiyThemeDetail)paramObject.rsp_diy_theme_detail.get();
            j = 0;
            if (j < 3)
            {
              if (j == 0)
              {
                localObject1 = (ThemeAuth.DiyThemeDetail)localRspDiyThemeDetail.drawer_tab_detail.get();
                paramObject = "theme_bg_setting_path";
                paramToServiceMsg = (ToServiceMsg)localObject4;
                paramFromServiceMsg = "theme_bg_setting_path_png";
                i = m;
              }
              String str4;
              for (;;)
              {
                localObject3 = paramToServiceMsg;
                if (android.text.TextUtils.isEmpty(paramToServiceMsg)) {
                  localObject3 = ((ThemeAuth.DiyThemeDetail)localObject1).str_bg_url.get();
                }
                if (1 <= i) {
                  break;
                }
                i = ((ThemeAuth.DiyThemeDetail)localObject1).uin32_id.get();
                if (QLog.isColorLevel()) {
                  QLog.d("Theme.ThemeHandler", 2, "update sv ThemeBackground, page=" + j + ", id=" + i + ", url=" + (String)localObject3);
                }
                if (android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label3292;
                }
                paramToServiceMsg = localSharedPreferences.getString(paramFromServiceMsg + "_id", "");
                str4 = localSharedPreferences.getString(paramFromServiceMsg + "_url", "");
                if ((!("" + i).equals(paramToServiceMsg)) || (android.text.TextUtils.isEmpty(str4))) {
                  break label3312;
                }
                bool = true;
                if (!QLog.isColorLevel()) {
                  break label3287;
                }
                QLog.d("Theme.ThemeHandler", 2, "updateThemeBackgroundPic, bgType=" + paramFromServiceMsg + ", notChange=" + bool + ", localId=" + paramToServiceMsg + ", id=" + i + ", url=" + (String)localObject3 + ", t=" + j);
                break label3287;
                if (j == 1)
                {
                  localObject1 = (ThemeAuth.DiyThemeDetail)localRspDiyThemeDetail.message_tab_detail.get();
                  paramObject = "theme_bg_message_path";
                  paramToServiceMsg = str1;
                  paramFromServiceMsg = "theme_bg_message_path_png";
                  i = n;
                }
                else
                {
                  paramToServiceMsg = localMobileQQ.getSharedPreferences("chat_background_path_" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 0).getString("chat_uniform_bg", null);
                  if ((!android.text.TextUtils.isEmpty(paramToServiceMsg)) && (!"null".equals(paramToServiceMsg)) && (!"none".equals(paramToServiceMsg))) {
                    break label3292;
                  }
                  localObject1 = (ThemeAuth.DiyThemeDetail)localRspDiyThemeDetail.aio_tab_detail.get();
                  paramToServiceMsg = str2;
                  paramObject = "theme_bg_aio_path";
                  paramFromServiceMsg = "theme_bg_aio_path";
                  i = i1;
                }
              }
              if (localObject1 != null) {}
              for (paramToServiceMsg = ((ThemeAuth.DiyThemeDetail)localObject1).str_name.get();; paramToServiceMsg = "" + i)
              {
                if (localObject1 == null) {
                  break label3318;
                }
                k = ((ThemeAuth.DiyThemeDetail)localObject1).uin32_feetype.get();
                if (localObject1 == null) {
                  break label3324;
                }
                localObject1 = ((ThemeAuth.DiyThemeDetail)localObject1).str_bg_thumbnail_url.get();
                str4 = ChatBackgroundManager.a(true, "" + i);
                ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramFromServiceMsg, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), str4, (String)localObject3, "" + i, paramToServiceMsg, k, (String)localObject1, true);
                if (!paramFromServiceMsg.equals(paramObject))
                {
                  paramFromServiceMsg = ChatBackgroundManager.a(true, "" + i);
                  ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramObject, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), paramFromServiceMsg, (String)localObject3, "" + i, paramToServiceMsg, k, (String)localObject1, true);
                }
                if (j != 2) {
                  break;
                }
                ChatBackground.a(localMobileQQ, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, str4);
                break;
              }
            }
          }
          ((ThemeSwitchManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(184)).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str3, (String)localObject2, localBundle);
          return;
        }
        a(null, null, true);
        return;
      }
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth unknow type ret=" + j);
      a(null, null, true);
      return;
      if (2 != j) {
        break;
      }
      i = ((ThemeAuth.SubCmd0x2RspCheck)((ThemeAuth.RspBody)localObject2).msg_subcmd0x2_rsp_check.get()).int32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeHandler", 2, "handleThemeVersionCheck:" + i);
      }
      paramToServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if (!android.text.TextUtils.isEmpty(paramToServiceMsg))
      {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences(paramToServiceMsg, 0);
        if (i == 6) {
          paramToServiceMsg.edit().putBoolean("need_check_theme_ver", true).commit();
        }
        if (paramToServiceMsg.getBoolean("need_check_theme_ver", false)) {
          paramToServiceMsg.edit().putBoolean("need_check_theme_ver", false).commit();
        }
      }
    } while (i != 0);
    label1024:
    label1067:
    label1465:
    label1482:
    label1775:
    label2549:
    paramToServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(Conversation.class);
    label1439:
    label1594:
    label1850:
    label2015:
    label2281:
    paramFromServiceMsg = new Message();
    label2237:
    label2266:
    paramFromServiceMsg.what = 1038;
    paramFromServiceMsg.obj = jdField_a_of_type_JavaLangString;
    paramToServiceMsg.sendMessage(paramFromServiceMsg);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B9E", "0X8005B9E", 0, 0, "", "", "", "");
    paramFromServiceMsg = new Message();
    paramFromServiceMsg.what = 1039;
    paramToServiceMsg.sendMessageDelayed(paramFromServiceMsg, 90000L);
    return;
    if (3 == j)
    {
      if (k != 0)
      {
        paramToServiceMsg = (ThemeAuth.SubCmd0x3RspSet)((ThemeAuth.RspBody)localObject2).msg_subcmd0x3_rsp_set.get();
        i = paramToServiceMsg.int32_result.get();
        paramFromServiceMsg = String.valueOf(paramToServiceMsg.uint32_theme_id.get());
      }
      for (paramToServiceMsg = paramToServiceMsg.str_diy_theme_err_msg.get();; paramToServiceMsg = "服务器保存超时，请重试。")
      {
        if ((QLog.isColorLevel()) || (i != 0)) {
          QLog.d("Theme.ThemeHandler", 1, "handleThemeAuth Set result:" + i + ", themeId:" + paramFromServiceMsg);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack != null) && (this.jdField_a_of_type_AndroidOsBundle != null)) {
          break;
        }
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:null == service || null == reqbundle, result:" + i);
        this.jdField_a_of_type_AndroidOsBundle = null;
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack = null;
        return;
        paramFromServiceMsg = new ThemeAuth.ReqBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        j = ((ThemeAuth.SubCmd0x3ReqSet)paramFromServiceMsg.msg_subcmd0x3_req_set.get()).uint32_theme_id.get();
        i = -404;
        paramFromServiceMsg = String.valueOf(j);
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("message", paramToServiceMsg);
      this.jdField_a_of_type_AndroidOsBundle.putInt("result_int", i);
      if ((!android.text.TextUtils.isEmpty(paramFromServiceMsg)) && (paramFromServiceMsg.equals(this.jdField_a_of_type_AndroidOsBundle.getString("themeId"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "handleThemeAuth set back themeId=" + paramFromServiceMsg + ", result=" + i);
        }
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack;
        if (i != 0) {
          break label3330;
        }
      }
    }
    label3330:
    for (int i = 4;; i = 8)
    {
      paramToServiceMsg.callback(16, i, this.jdField_a_of_type_AndroidOsBundle, null);
      this.jdField_a_of_type_AndroidOsBundle = null;
      this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack = null;
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:themeId has changed themeId=" + paramFromServiceMsg + ", rbThemeid=" + this.jdField_a_of_type_AndroidOsBundle.getString("themeId"));
      return;
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth subCmd error, subCmd:" + j);
      return;
      break label1850;
      label3229:
      localObject2 = paramFromServiceMsg;
      break label1465;
      label3235:
      bool = false;
      break;
      label3241:
      i = 1;
      break label1067;
      label3247:
      if ((j == 10) || (j == 11))
      {
        i = 2;
        break label1067;
      }
      if (j != 6) {
        break label1067;
      }
      i = 3;
      break label1067;
      label3280:
      paramFromServiceMsg = "20000000";
      break label1439;
      label3287:
      if (!bool) {
        break label2237;
      }
      label3292:
      j += 1;
      break label1775;
      label3301:
      paramFromServiceMsg = null;
      break label1482;
      label3306:
      bool = false;
      break label1594;
      label3312:
      bool = false;
      break label2015;
      label3318:
      k = 1;
      break label2266;
      label3324:
      localObject1 = null;
      break label2281;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth mApp == nul themeId:" + paramString1);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    Object localObject1 = ThemeUtil.getThemePreferences((Context)localObject3);
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    label390:
    String str;
    if (1 > ((SharedPreferences)localObject1).getInt("themeSpVersion", 0))
    {
      localObject4 = ((SharedPreferences)localObject1).edit();
      try
      {
        localObject1 = ((SharedPreferences)localObject1).getString("userDownloadTheme", "");
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject5 = new JSONObject((String)localObject1);
          localObject6 = ((JSONObject)localObject5).keys();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = String.valueOf(((Iterator)localObject6).next());
            if ((!android.text.TextUtils.isEmpty((CharSequence)localObject7)) && (!"1000".equals(localObject7)) && (!"999".equals(localObject7)))
            {
              localObject8 = ((JSONObject)localObject5).getJSONObject((String)localObject7);
              if (localObject8 != null)
              {
                localObject9 = ((JSONObject)localObject8).optString("version");
                if ((!android.text.TextUtils.isEmpty((CharSequence)localObject9)) && (ThemeDownloader.a((Context)localObject3, (String)localObject7, (String)localObject9, 0L, "themeDataUpdate0")) && (!ThemeDownloader.a((Context)localObject3, (String)localObject7, "20000000", 0L, "themeDataUpdate1")) && (FileUtils.c(ThemeUtil.getThemeDownloadFilePath((Context)localObject3, (String)localObject7, (String)localObject9), ThemeUtil.getThemeDownloadFilePath((Context)localObject3, (String)localObject7, "20000000"))))
                {
                  localObject2 = ThemeUtil.getThemeInfo((Context)localObject3, (String)localObject7);
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    localObject1 = new ThemeUtil.ThemeInfo();
                    ((ThemeUtil.ThemeInfo)localObject1).themeId = ((String)localObject7);
                    ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme = ((JSONObject)localObject8).optBoolean("sound");
                    ((ThemeUtil.ThemeInfo)localObject1).fileNum = ((JSONObject)localObject8).optInt("fileNum");
                    ((ThemeUtil.ThemeInfo)localObject1).status = ((JSONObject)localObject8).optString("status");
                  }
                  ((ThemeUtil.ThemeInfo)localObject1).version = ((String)localObject9);
                  ((ThemeUtil.ThemeInfo)localObject1).zipVer = Integer.parseInt((String)localObject9);
                  ThemeUtil.setThemeInfo((Context)localObject3, (ThemeUtil.ThemeInfo)localObject1);
                }
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
      localObject2 = SkinEngine.getInstances().getSkinRootPath();
      localObject4 = ThemeUtil.getCurrentThemeInfo();
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeHandler", 2, "sendThemeAuth init: themeId:" + paramString1 + ", version=" + paramString2 + ", skThemeId:" + ((Bundle)localObject4).getString("themeId") + ", skVersion:" + ((Bundle)localObject4).getString("version") + ", qqVersion:" + "7.6.3");
      }
      str = paramString2;
      if (android.text.TextUtils.isEmpty(paramString2))
      {
        paramString2 = ((Bundle)localObject4).getString("version");
        str = paramString2;
        if (android.text.TextUtils.isEmpty(paramString2)) {
          str = "0";
        }
      }
      paramString2 = paramString1;
      if (android.text.TextUtils.isEmpty(paramString1))
      {
        paramString1 = ((Bundle)localObject4).getString("themeId");
        paramString2 = paramString1;
        if (android.text.TextUtils.isEmpty(paramString1)) {
          paramString2 = "1000";
        }
      }
      paramString1 = ((Bundle)localObject4).getString("themePath");
      try
      {
        localObject5 = new ThemeAuth.SubCmd0x1ReqAuth();
        ((ThemeAuth.SubCmd0x1ReqAuth)localObject5).uint32_op_type.set(1);
        ((ThemeAuth.SubCmd0x1ReqAuth)localObject5).uint32_theme_id.set(Integer.parseInt(paramString2));
        ((ThemeAuth.SubCmd0x1ReqAuth)localObject5).str_theme_version.set(str);
        ((ThemeAuth.SubCmd0x1ReqAuth)localObject5).str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
        localObject6 = ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        localObject4 = ((SharedPreferences)localObject6).getString("currentThemeId_6.3.5", null);
        l1 = ((SharedPreferences)localObject6).getLong("themeSetTimeKey", 0L);
        QLog.d("Theme.ThemeHandler", 2, "Theme Auth themeId=" + paramString2 + ",version=" + str + ", userThemeId=" + (String)localObject4 + ",currentThemeResPath=" + paramString1 + ", usr=" + com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 2) + ", oldTime=" + l1);
        if ("1000".equals(paramString2)) {
          break label1530;
        }
        localObject7 = a(paramString1);
        if (((HashMap)localObject7).size() < 3) {
          QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth fileMD5 size error:size=" + ((HashMap)localObject7).size());
        }
        localObject7 = ((HashMap)localObject7).entrySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject7).hasNext())
          {
            localObject8 = (Map.Entry)((Iterator)localObject7).next();
            if (QLog.isColorLevel()) {
              QLog.i("Theme.ThemeHandler", 2, "Theme file Info,Filepath=" + (String)((Map.Entry)localObject8).getKey() + ",FileMd5=" + (String)((Map.Entry)localObject8).getValue());
            }
            localObject9 = new ThemeAuth.ThemeFileInfo();
            ((ThemeAuth.ThemeFileInfo)localObject9).str_file_path.set((String)((Map.Entry)localObject8).getKey());
            ((ThemeAuth.ThemeFileInfo)localObject9).str_file_md5.set((String)((Map.Entry)localObject8).getValue());
            ((ThemeAuth.SubCmd0x1ReqAuth)localObject5).rpt_msg_topic_file_info.add((MessageMicro)localObject9);
            continue;
            if (BaseApplicationImpl.IS_SUPPORT_THEME) {
              break;
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("Theme.ThemeHandler", 1, "Theme Auth send Exception:" + paramString1.getMessage() + ", themeId=" + paramString2 + ", version=" + str);
      }
    }
    label1019:
    do
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth ERROR_CODE_ISNOT_SUPPORT_THEME.");
      int j = NetworkUtil.a(null);
      if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
        break label1648;
      }
      i = 1;
      ThemeReporter.a(null, "theme_detail", "205", 157, j, i, paramString2, str, "1", "");
      paramString1 = new File(AppConstants.bT);
      if (paramString1.exists()) {
        break;
      }
      paramString1.mkdirs();
      return;
      ((SharedPreferences.Editor)localObject4).remove("userDownloadTheme");
      break label390;
      ((SharedPreferences)localObject6).edit().putLong("authTime", 0L).commit();
      localObject6 = new ThemeAuth.ReqBody();
      ((ThemeAuth.ReqBody)localObject6).uint32_sub_cmd.set(1);
      ((ThemeAuth.ReqBody)localObject6).int32_plat_id.set(109);
      ((ThemeAuth.ReqBody)localObject6).str_qq_version.set("7.6.3.3565");
      ((ThemeAuth.ReqBody)localObject6).uint32_qq_version.set(Integer.parseInt("3565"));
      ((ThemeAuth.ReqBody)localObject6).msg_subcmd0x1_req_auth.set((MessageMicro)localObject5);
      ((ThemeAuth.ReqBody)localObject6).setHasFlag(true);
      localObject5 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
      ((ToServiceMsg)localObject5).putWupBuffer(((ThemeAuth.ReqBody)localObject6).toByteArray());
      ((ToServiceMsg)localObject5).extraData.putString("oldEnginePath", (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeHandler", 2, "Theme Auth send request, themeID=" + paramString2 + ", userThemeId=" + (String)localObject4);
      }
      super.b((ToServiceMsg)localObject5);
    } while (("1000".equals(paramString2)) || (android.text.TextUtils.isEmpty(paramString1)));
    label1048:
    label1132:
    Object localObject2 = new File(paramString1);
    long l1 = System.currentTimeMillis();
    localObject3 = ThemeUtil.getThemeInfo((Context)localObject3, paramString2);
    long l2 = System.currentTimeMillis();
    if (localObject3 != null) {}
    for (int i = 1;; i = -1)
    {
      ThemeReporter.a(null, "theme_sp_speed", "204", 153, -1, i, String.valueOf(l2 - l1), "6653", "read", "");
      if ((((File)localObject2).isDirectory()) && (localObject3 != null))
      {
        i = ThemeUtil.getFileNumInFile((File)localObject2);
        if ((i > 0) && ((((ThemeUtil.ThemeInfo)localObject3).fileNum <= 0) || (i >= ((ThemeUtil.ThemeInfo)localObject3).fileNum))) {
          break label1019;
        }
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo.fileNum:" + ((ThemeUtil.ThemeInfo)localObject3).fileNum + ", fileNum:" + i + ", themeId=" + paramString2 + ", version=" + str + ", currentThemeResPath:" + paramString1);
        ThemeReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "204", 157, NetworkUtil.a(null), 101, paramString2, "665", String.valueOf(i), String.valueOf(((ThemeUtil.ThemeInfo)localObject3).fileNum));
        break label1019;
        label1530:
        if ((!android.text.TextUtils.isEmpty((CharSequence)localObject4)) && (!"1000".equals(localObject4))) {
          break label1132;
        }
        l1 = ((SharedPreferences)localObject6).getLong("authTime", 0L);
        l2 = System.currentTimeMillis();
        if (l2 > l1 + 7200000L)
        {
          ((SharedPreferences)localObject6).edit().putLong("authTime", l2).commit();
          break label1132;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Theme.ThemeHandler", 2, "sendThemeAuth nowTime <= authTime + 2h");
        return;
      }
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo == null || currentThemeResPath:" + paramString1);
      break label1019;
      label1648:
      i = -40;
      break label1048;
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 84
    //   11: iconst_2
    //   12: new 86	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1080
    //   22: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 866
    //   32: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 1082
    //   42: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +8 -> 67
    //   62: aload 4
    //   64: ifnonnull +13 -> 77
    //   67: ldc 84
    //   69: iconst_2
    //   70: ldc_w 1084
    //   73: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: return
    //   77: aload 4
    //   79: ldc_w 446
    //   82: aload_1
    //   83: invokevirtual 444	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: aload 5
    //   89: putfield 722	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack	Lcom/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$StyleCallBack;
    //   92: aload_0
    //   93: aload 4
    //   95: putfield 724	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   98: new 732	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet
    //   101: dup
    //   102: invokespecial 1085	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:<init>	()V
    //   105: astore_2
    //   106: aload_2
    //   107: getfield 734	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_theme_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: aload_1
    //   111: invokestatic 850	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   117: aload_3
    //   118: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: istore 8
    //   123: iload 7
    //   125: istore 6
    //   127: iload 8
    //   129: ifne +9 -> 138
    //   132: aload_3
    //   133: invokestatic 850	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   136: istore 6
    //   138: aload_2
    //   139: getfield 1088	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_suit_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: iload 6
    //   144: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   147: ldc_w 1090
    //   150: aload 4
    //   152: ldc_w 1092
    //   155: invokevirtual 743	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +240 -> 401
    //   164: new 1094	com/tencent/pb/theme/ThemeAuth$diyThemeInfo
    //   167: dup
    //   168: invokespecial 1095	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:<init>	()V
    //   171: astore_1
    //   172: aload_1
    //   173: getfield 1096	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_drawer_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   176: aload 4
    //   178: ldc_w 1098
    //   181: invokevirtual 743	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   184: invokestatic 850	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   187: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   190: aload_1
    //   191: getfield 1099	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_message_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   194: aload 4
    //   196: ldc_w 1101
    //   199: invokevirtual 743	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 850	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   205: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   208: aload_1
    //   209: getfield 1102	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_aio_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   212: aload 4
    //   214: ldc_w 1104
    //   217: invokevirtual 743	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: invokestatic 850	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   226: aload_2
    //   227: getfield 1108	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:diy_theme_info	Lcom/tencent/pb/theme/ThemeAuth$diyThemeInfo;
    //   230: aload_1
    //   231: invokevirtual 1109	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   234: aload_2
    //   235: getfield 1110	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_diy_theme_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   238: iconst_1
    //   239: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   242: new 167	com/tencent/pb/theme/ThemeAuth$ReqBody
    //   245: dup
    //   246: invokespecial 168	com/tencent/pb/theme/ThemeAuth$ReqBody:<init>	()V
    //   249: astore_1
    //   250: aload_1
    //   251: getfield 178	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   254: iconst_3
    //   255: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   258: aload_1
    //   259: getfield 1005	com/tencent/pb/theme/ThemeAuth$ReqBody:int32_plat_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   262: bipush 109
    //   264: invokevirtual 1006	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   267: aload_1
    //   268: getfield 1009	com/tencent/pb/theme/ThemeAuth$ReqBody:str_qq_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   271: ldc_w 1011
    //   274: invokevirtual 885	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   277: aload_1
    //   278: getfield 1014	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_qq_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   281: ldc_w 1016
    //   284: invokestatic 850	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   287: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   290: aload_1
    //   291: getfield 730	com/tencent/pb/theme/ThemeAuth$ReqBody:msg_subcmd0x3_req_set	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet;
    //   294: aload_2
    //   295: invokevirtual 1111	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   298: aload_1
    //   299: iconst_1
    //   300: invokevirtual 1021	com/tencent/pb/theme/ThemeAuth$ReqBody:setHasFlag	(Z)V
    //   303: new 170	com/tencent/qphone/base/remote/ToServiceMsg
    //   306: dup
    //   307: ldc_w 1023
    //   310: aload_0
    //   311: getfield 181	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   314: invokevirtual 1026	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   317: ldc 122
    //   319: invokespecial 1029	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   322: astore_2
    //   323: aload_2
    //   324: aload_1
    //   325: invokevirtual 1032	com/tencent/pb/theme/ThemeAuth$ReqBody:toByteArray	()[B
    //   328: invokevirtual 1036	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   331: aload_0
    //   332: aload_2
    //   333: invokespecial 1041	com/tencent/mobileqq/app/BusinessHandler:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   336: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq -263 -> 76
    //   342: ldc 84
    //   344: iconst_2
    //   345: ldc_w 1113
    //   348: invokestatic 112	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: return
    //   352: astore_1
    //   353: ldc 84
    //   355: iconst_2
    //   356: new 86	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   363: ldc_w 1115
    //   366: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_1
    //   370: invokevirtual 399	java/lang/Exception:toString	()Ljava/lang/String;
    //   373: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: return
    //   383: astore_1
    //   384: ldc 84
    //   386: iconst_1
    //   387: ldc_w 1117
    //   390: aload_1
    //   391: invokestatic 1120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: iload 7
    //   396: istore 6
    //   398: goto -260 -> 138
    //   401: aload_2
    //   402: getfield 1110	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_diy_theme_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   405: iconst_0
    //   406: invokevirtual 883	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   409: goto -167 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	ThemeHandler
    //   0	412	1	paramString1	String
    //   0	412	2	paramString2	String
    //   0	412	3	paramString3	String
    //   0	412	4	paramBundle	Bundle
    //   0	412	5	paramStyleCallBack	ThemeDiyStyleLogic.StyleCallBack
    //   125	272	6	i	int
    //   1	394	7	j	int
    //   121	7	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   77	123	352	java/lang/Exception
    //   138	242	352	java/lang/Exception
    //   242	351	352	java/lang/Exception
    //   384	394	352	java/lang/Exception
    //   401	409	352	java/lang/Exception
    //   132	138	383	java/lang/Exception
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
          break label377;
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
        paramString1.str_qq_version.set("7.6.3.3565");
        paramString1.uint32_qq_version.set(Integer.parseInt("3565"));
        paramString1.msg_subcmd0x2_req_check.set(paramString2);
        paramString1.setHasFlag(true);
        paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
        paramString2.putWupBuffer(paramString1.toByteArray());
        super.b(paramString2);
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
      label377:
      paramBoolean = "h".equals(paramString2);
      if (paramBoolean) {
        i -= 2000;
      } else {
        i -= 3000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler
 * JD-Core Version:    0.7.0.1
 */