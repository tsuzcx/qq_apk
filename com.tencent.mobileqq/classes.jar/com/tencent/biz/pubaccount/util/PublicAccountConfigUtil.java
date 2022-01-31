package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.ByteArrayInputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mts;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PublicAccountConfigUtil
{
  public static int a;
  private static QQHashMap jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap;
  public static String a;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public static boolean a;
  public static int b;
  public static String b;
  public static boolean b;
  public static int c;
  public static String c;
  public static boolean c;
  public static int d;
  public static String d;
  public static boolean d;
  public static String e;
  public static boolean e;
  public static String f;
  public static boolean f;
  public static String g;
  public static boolean g;
  public static String h;
  public static boolean h;
  public static String i;
  public static boolean i;
  public static String j;
  public static boolean j;
  public static String k;
  public static boolean k;
  public static boolean l;
  public static boolean m;
  public static boolean n;
  public static boolean o;
  public static boolean p;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    jdField_d_of_type_JavaLangString = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
    jdField_h_of_type_JavaLangString = "";
    jdField_k_of_type_Boolean = true;
    jdField_i_of_type_JavaLangString = "";
    jdField_j_of_type_JavaLangString = "";
    jdField_k_of_type_JavaLangString = "";
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i1 = paramQQAppInterface.getInt("service_account_folder_config_version", 0);
    }
    return i1;
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getResources().getDrawable(2130839128);
    case 1: 
      return paramContext.getResources().getDrawable(2130839200);
    }
    return paramContext.getResources().getDrawable(2130839205);
  }
  
  public static PublicAccountConfigUtil.PublicAccountConfigFolder a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 3) {
      i1 = 2;
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(paramQQAppInterface, paramContext);
    }
    if (jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap == null) {
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new PublicAccountConfigUtil.1(2011, 0, 1000);
    }
    return (PublicAccountConfigUtil.PublicAccountConfigFolder)jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.get(Integer.valueOf(i1));
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    paramQQAppInterface = localObject;
    if (localSharedPreferences != null) {
      paramQQAppInterface = localSharedPreferences.getString("public_account_center_url_config_data", null);
    }
    return paramQQAppInterface;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 1);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    PublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = a(paramQQAppInterface, paramContext, paramInt);
    if (localPublicAccountConfigFolder != null) {
      return localPublicAccountConfigFolder.a();
    }
    return b(paramQQAppInterface, paramContext, paramInt);
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "resetPublicAccountConfig");
    }
    jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
    jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_f_of_type_Boolean = false;
    jdField_g_of_type_Boolean = false;
    jdField_h_of_type_Boolean = false;
    jdField_i_of_type_Boolean = false;
    jdField_j_of_type_Boolean = false;
    jdField_h_of_type_JavaLangString = "";
    jdField_k_of_type_Boolean = true;
    m = false;
    jdField_a_of_type_Int = 0;
    jdField_k_of_type_JavaLangString = "";
    n = false;
    o = false;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_i_of_type_JavaLangString = "";
    jdField_j_of_type_JavaLangString = "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getPreferences().getString("readinjoy_search_jump_url_config_data_" + paramQQAppInterface.getCurrentAccountUin(), "");
    if (!TextUtils.isEmpty(str))
    {
      b(paramQQAppInterface, str);
      return;
    }
    jdField_d_of_type_JavaLangString = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
    jdField_e_of_type_JavaLangString = null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("service_account_folder_config_version", paramInt);
      paramQQAppInterface.commit();
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap == null) {
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new PublicAccountConfigUtil.2(2011, 0, 1000);
    }
    if (!c(paramQQAppInterface, paramContext, SharedPreUtils.e(paramContext)))
    {
      localObject = new PublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 1, 2131430062, 2130839200);
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(1), localObject);
    }
    Object localObject = SharedPreUtils.h(paramContext);
    String str = SharedPreUtils.i(paramContext);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)))
    {
      paramQQAppInterface = new PublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 2, 2131428431, 2130839205);
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(2), paramQQAppInterface);
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
      paramQQAppInterface = new PublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, 2, (String)localObject, str);
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(2), paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      jdField_d_of_type_JavaLangString = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (a(str1))
        {
          jdField_a_of_type_JavaLangString = str1;
          if (!a(str2)) {
            break label210;
          }
          jdField_b_of_type_JavaLangString = str2;
          if (!paramString.has("readinjoy_search_url")) {
            break label218;
          }
          str1 = paramString.getString("readinjoy_search_url");
          if (a(str1)) {
            jdField_c_of_type_JavaLangString = str1;
          }
          if (!paramString.has("image_collection_comment")) {
            break label226;
          }
          jdField_d_of_type_Boolean = paramString.getBoolean("image_collection_comment");
          paramString = paramQQAppInterface.getPreferences().getString("readinjoy_search_jump_url_config_data_" + paramQQAppInterface.getCurrentAccountUin(), "");
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          b(paramQQAppInterface, paramString);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "loadPublicAccountCenterUrlConfig error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
        jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
        jdField_d_of_type_Boolean = false;
        return;
      }
      jdField_a_of_type_JavaLangString = "http://find.mp.qq.com/public/index?_wv=67109947&_bid=2258";
      continue;
      label210:
      jdField_b_of_type_JavaLangString = "http://find.mp.qq.com/public/categories?_wv=67109947&_bid=2258";
      continue;
      label218:
      b(paramQQAppInterface, 0);
      continue;
      label226:
      b(paramQQAppInterface, 0);
    }
    jdField_d_of_type_JavaLangString = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
    jdField_e_of_type_JavaLangString = null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str7 = null;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("tim_url")) {
        localJSONObject.getString("tim_url");
      }
      if (!localJSONObject.has("tim_url_card")) {
        break label576;
      }
      paramQQAppInterface = localJSONObject.getString("tim_url_card");
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        paramQQAppInterface.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("PublicAccountConfigUtil", 2, "update public account qq mail config error.", paramQQAppInterface);
          continue;
          str6 = null;
          continue;
          str5 = null;
          continue;
          str4 = null;
          continue;
          str3 = null;
          continue;
          str2 = null;
          continue;
          str1 = null;
          continue;
          paramString = null;
          continue;
          paramQQAppInterface = null;
        }
      }
    }
    if (localJSONObject.has("tim_wording"))
    {
      paramString = localJSONObject.getString("tim_wording");
      if (localJSONObject.has("tim_url_icon"))
      {
        str1 = localJSONObject.getString("tim_url_icon");
        if (localJSONObject.has("tim_url_icon_725"))
        {
          str2 = localJSONObject.getString("tim_url_icon_725");
          if (localJSONObject.has("qim_url_card"))
          {
            str3 = localJSONObject.getString("qim_url_card");
            if (localJSONObject.has("qim_wording"))
            {
              str4 = localJSONObject.getString("qim_wording");
              if (localJSONObject.has("qim_url_icon"))
              {
                str5 = localJSONObject.getString("qim_url_icon");
                if (localJSONObject.has("qim_url_icon_720"))
                {
                  str6 = localJSONObject.getString("qim_url_icon_720");
                  if (localJSONObject.has("qim_url_icon_story")) {
                    str7 = localJSONObject.getString("qim_url_icon_story");
                  }
                  if (a(paramQQAppInterface)) {
                    localEditor.putString("profile_card_tim_online_url", paramQQAppInterface);
                  }
                  if (a(str1)) {
                    localEditor.putString("profile_card_tim_online_icon_url", str1);
                  }
                  if (a(str2)) {
                    localEditor.putString("profile_card_tim_online_icon_725_url", str2);
                  }
                  if (!TextUtils.isEmpty(paramString)) {
                    localEditor.putString("profile_card_tim_online_wording", paramString);
                  }
                  if (a(str3)) {
                    localEditor.putString("profile_card_qim_online_url", str3);
                  }
                  if (a(str5)) {
                    localEditor.putString("profile_card_qim_online_icon_url", str5);
                  }
                  if (a(str6)) {
                    localEditor.putString("profile_card_qim_online_icon_url_720", str6);
                  }
                  if (a(str7)) {
                    localEditor.putString("key_story_qim_online_icon_url", str7);
                  }
                  if (!TextUtils.isEmpty(str4)) {
                    localEditor.putString("profile_card_qim_online_wording", str4);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountConfigUtil", 2, "updatePublicAccountQQMailConfigData url_card_tim_online:" + paramQQAppInterface + "; url_card_qim_online:" + str3);
                  }
                  localEditor.putInt("public_account_qq_mail_config_version", paramInt);
                  localEditor.commit();
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    return p;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    boolean bool = c(paramQQAppInterface, paramContext, paramString);
    if (bool) {
      SharedPreUtils.f(paramContext, paramString);
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.e("PublicAccountConfigUtil", 2, "updateEqqConfig fail");
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeRecommendConfig xml: " + paramString);
    }
    label3081:
    label3213:
    for (;;)
    {
      int i1;
      boolean bool;
      try
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        Object localObject1 = paramString.getElementsByTagName("recommendFullVersion");
        int i2;
        Object localObject2;
        int i3;
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = SubscriptRecommendController.b(paramQQAppInterface);
          if (i1 <= i2) {
            continue;
          }
          localObject1 = (Element)paramString.getElementsByTagName("recommendFullScreen").item(0);
          localObject2 = (Element)paramString.getElementsByTagName("recommendURL").item(0);
          i3 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = ((Element)localObject2).getFirstChild().getNodeValue();
          if (i3 != 1) {
            break label3207;
          }
          bool = true;
          SubscriptRecommendController.a(paramQQAppInterface, bool, (String)localObject1);
          SubscriptRecommendController.b(paramQQAppInterface, i1);
          if (i3 == 1)
          {
            localObject2 = (WebProcessManager)paramQQAppInterface.getManager(12);
            if (localObject2 != null) {
              ((WebProcessManager)localObject2).a(66);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("SubscriptRecommendConfig update fullrecommend config. version : ").append(i1).append(" switch : ");
            if (i3 != 1) {
              break label3213;
            }
            bool = true;
            QLog.d("PublicAccountConfigUtil", 2, bool + " url : " + (String)localObject1 + " oldVersion : " + i2);
          }
        }
        localObject1 = paramString.getElementsByTagName("recommendBottomVersion");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = SubscriptRecommendController.c(paramQQAppInterface);
          if (i1 <= i2) {
            break label3087;
          }
          i3 = Integer.valueOf(((Element)paramString.getElementsByTagName("recommendBottom").item(0)).getFirstChild().getNodeValue()).intValue();
          if (i3 != 1) {
            break label3081;
          }
          bool = true;
          SubscriptRecommendController.a(paramQQAppInterface, bool);
          SubscriptRecommendController.c(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update innerrecommend config. preversion -> version " + i2 + "->" + i1 + " switch : " + i3);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("kandian_read_data").item(0);
        if (localObject1 != null)
        {
          i1 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i1 != 1) {
            break label3219;
          }
          bool = true;
          SharedPreUtils.b((Context)localObject1, bool);
        }
        localObject1 = paramString.getElementsByTagName("channel_version");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          i2 = ReadInJoyHelper.a(paramQQAppInterface);
          if (i1 <= i2) {
            break label3122;
          }
          localObject2 = (Element)paramString.getElementsByTagName("channel_id").item(0);
          Element localElement = (Element)paramString.getElementsByTagName("channel_name").item(0);
          localObject1 = (Element)paramString.getElementsByTagName("channel_type").item(0);
          i3 = Integer.valueOf(((Element)localObject2).getFirstChild().getNodeValue()).intValue();
          localObject2 = String.valueOf(localElement.getFirstChild().getNodeValue());
          int i4 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.a(paramQQAppInterface, i3, (String)localObject2, i4);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "update channelInfo config. preversion -> version " + i2 + "->" + i1 + " channelID : " + i3 + " channelName: " + (String)localObject2 + " channelType: " + i4);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("video_sound").item(0);
        if (localObject1 != null)
        {
          i1 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i1 != 0) {
            break label3157;
          }
          bool = true;
          SharedPreUtils.c((Context)localObject1, bool);
          localObject1 = VideoVolumeControl.a();
          if (i1 != 0) {
            break label3163;
          }
          bool = true;
          ((VideoVolumeControl)localObject1).a(bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get video sound config " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_support_enable");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (i1 <= 0) {
            break label3169;
          }
          bool = true;
          ReadInJoyHelper.b(paramQQAppInterface, bool);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "updateSupportMultiVideoSwitch， supportEnable = " + i1);
          }
        }
        localObject1 = (Element)paramString.getElementsByTagName("rn_switch").item(0);
        if (localObject1 != null)
        {
          i1 = Integer.valueOf(((Element)localObject1).getFirstChild().getNodeValue()).intValue();
          localObject1 = paramQQAppInterface.getApp();
          if (i1 == 1) {
            break label3175;
          }
          bool = true;
          SharedPreUtils.a((Context)localObject1, bool, paramQQAppInterface.c());
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "get interesrLableRn config " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_struct_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3181;
          }
          bool = true;
          ReadInJoyHelper.d(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("shortvideo_troop_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3187;
          }
          bool = true;
          ReadInJoyHelper.e(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("shortvideo_nontroop_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3193;
          }
          bool = true;
          ReadInJoyHelper.f(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("video_social_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          if (Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label3199;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "parse kandian video social switch = " + bool);
          }
          ReadInJoyHelper.g(paramQQAppInterface, bool);
        }
        localObject1 = paramString.getElementsByTagName("videochannel_video_autoplay");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video channel auto play switch default value = " + i1);
          }
          ReadInJoyHelper.b(paramQQAppInterface, i1);
        }
        localObject1 = paramString.getElementsByTagName("video_jump_to");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video jump default value = " + i1);
          }
          ReadInJoyHelper.d(paramQQAppInterface, i1);
        }
        localObject1 = paramString.getElementsByTagName("defaultBitRate");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          localObject1 = (Element)((NodeList)localObject1).item(0);
          ReadInJoyHelper.v(paramQQAppInterface, ((Element)localObject1).getFirstChild().getNodeValue());
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "defaultBitRate value = " + ((Element)localObject1).getFirstChild().getNodeValue());
          }
        }
        localObject1 = paramString.getElementsByTagName("CUKingCard_Dlg");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.e(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "CUKingCardDlg value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_channel_style");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.l(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_channel_style value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_dynamic_recommend_strategyid");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.m(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "multi_video_dynamic_recommend_strategyid value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_dynamic_recommend_duration_limit");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.n(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "multi_video_dynamic_recommend_duration_limit value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_dynamic_recommend_duration_percent");
        float f1;
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          f1 = Float.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).floatValue();
          ReadInJoyHelper.a(paramQQAppInterface, f1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "multi_video_dynamic_recommend_duration_percent value = " + f1);
          }
        }
        localObject1 = paramString.getElementsByTagName("multi_video_dynamic_recommend_operator");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.o(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "multi_video_dynamic_recommend_operator value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_strategyid");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.p(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_strategyid value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_duration_limit");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.q(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_duration_limit value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_duration_percent");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          f1 = Float.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).floatValue();
          ReadInJoyHelper.b(paramQQAppInterface, f1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_duration_percent value = " + f1);
          }
        }
        localObject1 = paramString.getElementsByTagName("video_dynamic_recommend_operator");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.r(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video_dynamic_recommend_operator value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("web_viola_render_switch");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.s(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "web_viola_render_switch value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("web_viola_render_mode");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          ReadInJoyHelper.t(paramQQAppInterface, i1);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "web_viola_render_mode value = " + i1);
          }
        }
        localObject1 = paramString.getElementsByTagName("videochannel_video_autoplay_18mo");
        if ((localObject1 != null) && (((NodeList)localObject1).getLength() > 0))
        {
          i1 = Integer.valueOf(((Element)((NodeList)localObject1).item(0)).getFirstChild().getNodeValue()).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfigUtil", 2, "video flow video channel auto play switch default value = " + i1);
          }
          ReadInJoyHelper.c(paramQQAppInterface, i1);
        }
        paramString = paramString.getElementsByTagName("click_videocard_jump_comment");
        if ((paramString == null) || (paramString.getLength() <= 0)) {
          break label3205;
        }
        i1 = Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "video channel feeds click switch default value = " + i1);
        }
        ReadInJoyHelper.a(paramQQAppInterface, i1);
        break label3205;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig same version ! " + i1);
        continue;
        bool = false;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "update subscript recommend config error." + paramQQAppInterface);
        }
        return false;
      }
      continue;
      label3087:
      label3219:
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfigUtil", 2, "SubscriptRecommendConfig update fail same version " + i1);
        continue;
        label3122:
        if (QLog.isColorLevel())
        {
          QLog.d("PublicAccountConfigUtil", 2, "update channelInfo fail same version " + i1);
          continue;
          label3157:
          bool = false;
          continue;
          label3163:
          bool = false;
          continue;
          label3169:
          bool = false;
          continue;
          label3175:
          bool = false;
          continue;
          label3181:
          bool = false;
          continue;
          label3187:
          bool = false;
          continue;
          label3193:
          bool = false;
          continue;
          label3199:
          bool = false;
          continue;
          return true;
          bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
      return false;
    }
    return true;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i1 = paramQQAppInterface.getInt("public_account_center_url_config_version", 0);
    }
    return i1;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 2);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return paramContext.getString(2131430062);
    }
    return paramContext.getString(2131428431);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null)
    {
      jdField_f_of_type_JavaLangString = localSharedPreferences.getString("service_account_folder_name", null);
      jdField_g_of_type_JavaLangString = localSharedPreferences.getString("service_account_folder_icon", null);
      jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("service_account_folder_delete", false);
      p = localSharedPreferences.getBoolean("service_folder_redclean_after_enter", false);
      jdField_b_of_type_Boolean = localSharedPreferences.getBoolean("service_account_folder_redspots", false);
      jdField_e_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload", false);
      jdField_f_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload_wifi", false);
      jdField_g_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload_4G", false);
      jdField_h_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload_3G", false);
      jdField_i_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_preload_2G", false);
      l = localSharedPreferences.getBoolean("public_account_bottom_bar", false);
      jdField_j_of_type_Boolean = localSharedPreferences.getBoolean("kandian_feeds_image_preload", false);
      jdField_h_of_type_JavaLangString = localSharedPreferences.getString("kandian_feeds_fling_LToR_host", "");
      m = localSharedPreferences.getBoolean("readInJoy_ip_connect", false);
      jdField_a_of_type_Int = localSharedPreferences.getInt("readInJoy_ip_connect_full_report", 0);
      jdField_k_of_type_JavaLangString = localSharedPreferences.getString("readInJoy_ip_connect_report_tail", "");
      n = localSharedPreferences.getBoolean("readInJoy_loading_img", false);
      jdField_c_of_type_Boolean = localSharedPreferences.getBoolean("service_account_folder_redspots_delete", false);
      o = localSharedPreferences.getBoolean("big_data_share_channel", false);
      jdField_b_of_type_Int = localSharedPreferences.getInt("album_predown_enable", 0);
      jdField_c_of_type_Int = localSharedPreferences.getInt("album_predown_photo_rule", 0);
      jdField_d_of_type_Int = localSharedPreferences.getInt("album_predown_slide_photocounts", 0);
      jdField_k_of_type_Boolean = localSharedPreferences.getBoolean("ad_preload_tool_process", true);
      jdField_i_of_type_JavaLangString = localSharedPreferences.getString("key_read_in_joy_preload_tool_config", "");
      jdField_j_of_type_JavaLangString = localSharedPreferences.getString("key_read_in_joy_release_service_config", "");
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("public_account_center_url_config_version", paramInt);
      paramQQAppInterface.commit();
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      jdField_e_of_type_JavaLangString = paramString.optString("kQQPASearchDiscoverPageUrl");
      if (paramString.has("kQQPASearchJumpUrl"))
      {
        paramQQAppInterface = paramString.getString("kQQPASearchJumpUrl");
        jdField_d_of_type_JavaLangString = paramQQAppInterface;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "loadConfig292Data(). readinjoy_search_jump_url=" + paramQQAppInterface + ", discoveryPageUrl = " + jdField_e_of_type_JavaLangString);
        }
      }
      else
      {
        SharedPreUtils.a(paramQQAppInterface.getApp(), "readinjoy_search_jump_url_version", paramQQAppInterface.getCurrentAccountUin(), 0);
        if (QLog.isColorLevel())
        {
          QLog.d("PublicAccountConfigUtil", 2, "loadConfig292Data(). set the versionCode=0");
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "loadPublicAccountCenterUrlConfig error", paramQQAppInterface);
      }
      jdField_d_of_type_JavaLangString = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "loadConfig292Data(). use the default url. exception=" + paramQQAppInterface.getStackTrace());
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = paramString.trim();
        paramContext = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramContext.getBytes("utf-8")));
        int i1 = Integer.parseInt(paramContext.getElementsByTagName("version").item(0).getFirstChild().getNodeValue());
        int i2 = SubscriptRecommendController.a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig prevVersion = " + i2 + ", version = " + i1);
        }
        if (i1 == i2)
        {
          if (!QLog.isColorLevel()) {
            break label330;
          }
          QLog.d("PublicAccountConfigUtil", 2, "IGNORE THIS ACTION because of SAME VERSION");
          break label330;
        }
        paramContext = paramContext.getElementsByTagName("public-account-folder");
        if (paramContext.getLength() <= 0) {
          break label332;
        }
        paramContext = (Element)paramContext.item(0);
        i2 = Integer.parseInt(paramContext.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
        paramContext = paramContext.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
        SubscriptRecommendController.a(paramQQAppInterface, i1);
        SubscriptRecommendController.a(paramQQAppInterface, i2, paramContext);
        paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(12);
        if (paramQQAppInterface == null) {
          break label332;
        }
        paramQQAppInterface.e();
        break label332;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "updateSubscribeConfig xml is empty");
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "updateSubscribeConfig error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
    label330:
    return false;
    label332:
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i1;
    do
    {
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountConfigUtil", 2, "update readinjoy folder xml: " + paramString);
        }
        try
        {
          paramString = paramString.trim();
          paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          Object localObject = paramString.getElementsByTagName("id");
          if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
          {
            i1 = Integer.valueOf(((Element)((NodeList)localObject).item(0)).getFirstChild().getNodeValue()).intValue();
            if (i1 > SharedPreUtils.z(paramQQAppInterface.getApp()))
            {
              localObject = (Element)paramString.getElementsByTagName("name").item(0);
              paramString = (Element)paramString.getElementsByTagName("icon").item(0);
              localObject = ((Element)localObject).getFirstChild().getNodeValue();
              paramString = paramString.getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString))) {
                SharedPreUtils.a(paramQQAppInterface.getApp(), (String)localObject, paramString);
              }
              SharedPreUtils.s(paramQQAppInterface.getApp(), i1);
              return false;
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return false;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountConfigUtil", 2, "readinjoy folder config same id ! " + i1);
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      boolean bool2;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (!a(str1)) {
          break label145;
        }
        jdField_a_of_type_JavaLangString = str1;
        bool1 = true;
        if (a(str2))
        {
          jdField_b_of_type_JavaLangString = str2;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramString.has("readinjoy_search_url"))
        {
          str1 = paramString.getString("readinjoy_search_url");
          bool2 = bool1;
          if (a(str1))
          {
            jdField_c_of_type_JavaLangString = str1;
            bool2 = true;
          }
        }
        if (paramString.has("image_collection_comment"))
        {
          jdField_d_of_type_Boolean = paramString.getBoolean("image_collection_comment");
          return true;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "checkPublicAccountCenterUrlConfigData error", paramString);
        }
        paramString.printStackTrace();
        return false;
      }
      return bool2;
      label145:
      boolean bool1 = false;
    }
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i1 = paramQQAppInterface.getInt("public_account_qq_mail_config_version", 0);
    }
    return i1;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return a(paramQQAppInterface, paramContext, 3);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new mts(paramQQAppInterface));
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfigUtil", 2, "parseConfigXml xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getElementsByTagName("public-account-folder");
        int i2 = paramString.getLength();
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject = (Element)paramString.item(i1);
          int i3 = Integer.parseInt(((Element)localObject).getElementsByTagName("id").item(0).getFirstChild().getNodeValue());
          localObject = new PublicAccountConfigUtil.PublicAccountConfigFolder(paramQQAppInterface, paramContext, i3, ((Element)localObject).getElementsByTagName("name").item(0).getFirstChild().getNodeValue(), ((Element)localObject).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue());
          if (jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap == null) {
            jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new PublicAccountConfigUtil.3(2011, 0, 1000);
          }
          jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(Integer.valueOf(i3), localObject);
          i1 += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml xml is empty");
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "parsePublicAccountConfigXml error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    return false;
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    label1541:
    label1547:
    label1553:
    label1559:
    label1565:
    label1571:
    label1577:
    label1583:
    label1589:
    label1595:
    label1601:
    label1607:
    label1613:
    label1619:
    label1625:
    label1631:
    label1890:
    label1892:
    for (;;)
    {
      String str1;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.has("service_folder_name")) {
          break label1892;
        }
        str1 = localJSONObject.getString("service_folder_name");
        String str2;
        if (localJSONObject.has("service_folder_icon"))
        {
          str2 = localJSONObject.getString("service_folder_icon");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
            break label1636;
          }
          jdField_f_of_type_JavaLangString = str1;
          jdField_g_of_type_JavaLangString = str2;
          if (!QLog.isColorLevel()) {
            break label1641;
          }
          QLog.d("PublicAccountConfigUtil", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData SERVICE_ACCOUNT_FOLDER_NAME:" + jdField_f_of_type_JavaLangString + " SERVICE_ACCOUNT_FOLDER_ICON:" + jdField_g_of_type_JavaLangString);
          break label1641;
          if (!localJSONObject.has("service_folder_redspots")) {
            break label1631;
          }
          jdField_b_of_type_Boolean = localJSONObject.getBoolean("service_folder_redspots");
          if (!QLog.isColorLevel()) {
            break label1646;
          }
          QLog.d("PublicAccountConfigUtil", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_redspots:" + jdField_b_of_type_Boolean);
          break label1646;
          if (!localJSONObject.has("service_folder_delete")) {
            break label1625;
          }
          jdField_a_of_type_Boolean = localJSONObject.getBoolean("service_folder_delete");
          if (!QLog.isColorLevel()) {
            break label1651;
          }
          QLog.d("PublicAccountConfigUtil", 2, "SERVICE_ACCOUNT_FOLDER_CONFIG_CMD checkPublicAccountCenterUrlConfigData service_folder_delete:" + jdField_a_of_type_Boolean);
          break label1651;
          if (!localJSONObject.has("ServiceFolder_RedClean_After_Enter")) {
            break label1619;
          }
          p = localJSONObject.getBoolean("ServiceFolder_RedClean_After_Enter");
          if (!QLog.isColorLevel()) {
            break label1657;
          }
          QLog.d("PublicAccountConfigUtil", 2, "ServiceFolder_RedClean_After_Enter = " + p);
          break label1657;
          if (!localJSONObject.has("readInJoy_feeds_preload")) {
            break label1613;
          }
          jdField_e_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload");
          if (!QLog.isColorLevel()) {
            break label1663;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload:" + jdField_e_of_type_Boolean);
          break label1663;
          if (!localJSONObject.has("readInJoy_feeds_preload_wifi")) {
            break label1607;
          }
          jdField_f_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_wifi");
          if (!QLog.isColorLevel()) {
            break label1669;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload wifi:" + jdField_f_of_type_Boolean);
          break label1669;
          if (!localJSONObject.has("readInJoy_feeds_preload_4G")) {
            break label1601;
          }
          jdField_g_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_4G");
          if (!QLog.isColorLevel()) {
            break label1675;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload 4G:" + jdField_g_of_type_Boolean);
          break label1675;
          if (!localJSONObject.has("readInJoy_feeds_preload_3G")) {
            break label1595;
          }
          jdField_h_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_3G");
          if (!QLog.isColorLevel()) {
            break label1681;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload 3G:" + jdField_h_of_type_Boolean);
          break label1681;
          if (!localJSONObject.has("readInJoy_feeds_preload_2G")) {
            break label1589;
          }
          jdField_i_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_preload_2G");
          if (!QLog.isColorLevel()) {
            break label1687;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds preload 2G:" + jdField_i_of_type_Boolean);
          break label1687;
          if (!localJSONObject.has("pub_account_bottom_bar")) {
            break label1583;
          }
          l = localJSONObject.getBoolean("pub_account_bottom_bar");
          if (!QLog.isColorLevel()) {
            break label1693;
          }
          QLog.d("PublicAccountConfigUtil", 2, "needPABottomBar: " + l);
          break label1693;
          if (!localJSONObject.has("readInJoy_feeds_image_preload")) {
            break label1577;
          }
          jdField_j_of_type_Boolean = localJSONObject.getBoolean("readInJoy_feeds_image_preload");
          if (!QLog.isColorLevel()) {
            break label1699;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoy feeds image preload" + jdField_j_of_type_Boolean);
          break label1699;
          if (!localJSONObject.has("kandian_feeds_fling_LToR_host")) {
            break label1571;
          }
          jdField_h_of_type_JavaLangString = localJSONObject.optJSONArray("kandian_feeds_fling_LToR_host").toString();
          if (!QLog.isColorLevel()) {
            break label1705;
          }
          QLog.d("PublicAccountConfigUtil", 2, "kandian_feeds_fling_LToR_host" + jdField_h_of_type_JavaLangString);
          break label1705;
          if (!localJSONObject.has("readInJoy_ip_connect")) {
            break label1565;
          }
          m = localJSONObject.getBoolean("readInJoy_ip_connect");
          if (!QLog.isColorLevel()) {
            break label1711;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoy_ip_connect:" + m);
          break label1711;
          if ((!localJSONObject.has("readInJoy_ip_connect_full_report")) || (!localJSONObject.has("readInJoy_ip_connect_report_tail"))) {
            break label1559;
          }
          jdField_a_of_type_Int = localJSONObject.getInt("readInJoy_ip_connect_full_report");
          jdField_k_of_type_JavaLangString = localJSONObject.getString("readInJoy_ip_connect_report_tail");
          if (!QLog.isColorLevel()) {
            break label1717;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoy_ip_connect_full_report:" + jdField_a_of_type_Int + ", readInJoy_ip_connect_report_tail:" + jdField_k_of_type_JavaLangString);
          break label1717;
          if (!localJSONObject.has("readInJoy_load_img")) {
            break label1553;
          }
          n = localJSONObject.getBoolean("readInJoy_load_img");
          if (!QLog.isColorLevel()) {
            break label1723;
          }
          QLog.d("PublicAccountConfigUtil", 2, "readInJoyLoadImg:" + n);
          break label1723;
          if (!localJSONObject.has("service_account_folder_redspots_delete")) {
            break label1547;
          }
          jdField_c_of_type_Boolean = localJSONObject.getBoolean("service_account_folder_redspots_delete");
          if (!QLog.isColorLevel()) {
            break label1729;
          }
          QLog.d("PublicAccountConfigUtil", 2, "service_account_folder_redspots_delete:" + jdField_c_of_type_Boolean);
          break label1729;
          if (!localJSONObject.has("disable_big_data_channel")) {
            break label1541;
          }
          o = localJSONObject.getBoolean("disable_big_data_channel");
          if (!QLog.isColorLevel()) {
            break label1735;
          }
          QLog.d("PublicAccountConfigUtil", 2, "disable big data channel is " + o);
          break label1735;
          if (!localJSONObject.has("album_predown_enable")) {
            break label1535;
          }
          jdField_b_of_type_Int = localJSONObject.getInt("album_predown_enable");
          if (!QLog.isColorLevel()) {
            break label1741;
          }
          QLog.d("PublicAccountConfigUtil", 2, "imageCollectionPreloadEnable is " + jdField_b_of_type_Int);
          break label1741;
          if (!localJSONObject.has("album_predown_photo_rule")) {
            break label1529;
          }
          jdField_c_of_type_Int = localJSONObject.getInt("album_predown_photo_rule");
          if (!QLog.isColorLevel()) {
            break label1747;
          }
          QLog.d("PublicAccountConfigUtil", 2, "imageCollectionPreloadCoverEnable is " + jdField_c_of_type_Int);
          break label1747;
          if (!localJSONObject.has("album_predown_slide_photocounts")) {
            break label1523;
          }
          jdField_d_of_type_Int = localJSONObject.getInt("album_predown_slide_photocounts");
          if (!QLog.isColorLevel()) {
            break label1753;
          }
          QLog.d("PublicAccountConfigUtil", 2, "imageCollectionPreloadImageEnable is " + jdField_d_of_type_Int);
          break label1753;
          if (!localJSONObject.has("preload_tool_process")) {
            break label1517;
          }
          jdField_k_of_type_Boolean = localJSONObject.getBoolean("preload_tool_process");
          if (!QLog.isColorLevel()) {
            break label1759;
          }
          QLog.d("PublicAccountConfigUtil", 2, "preload tool progress is " + jdField_k_of_type_Boolean);
          break label1759;
          if (localJSONObject.has("useNewLogic"))
          {
            jdField_i_of_type_JavaLangString = paramString;
            if (!QLog.isColorLevel()) {
              break label1765;
            }
            QLog.d("PublicAccountConfigUtil", 2, "read in joy preload tool progress config is " + paramString);
            break label1765;
            i23 = 0;
            if (!localJSONObject.has("releaseServiceMinMem")) {
              break label1774;
            }
            jdField_j_of_type_JavaLangString = paramString;
            if (!QLog.isColorLevel()) {
              break label1771;
            }
            QLog.d("PublicAccountConfigUtil", 2, "release web service config is " + paramString);
            break label1771;
            paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
            if (paramQQAppInterface == null) {
              break label1890;
            }
            paramQQAppInterface.sendEmptyMessage(1009);
            break label1890;
          }
        }
        else
        {
          str2 = "";
          continue;
          return false;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountConfigUtil", 2, "checkPublicAccountCenterUrlConfigData error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        return false;
      }
      int i22 = 0;
      continue;
      label1517:
      int i21 = 0;
      continue;
      label1523:
      int i20 = 0;
      continue;
      label1529:
      int i19 = 0;
      continue;
      label1535:
      int i18 = 0;
      continue;
      int i17 = 0;
      continue;
      int i16 = 0;
      continue;
      int i15 = 0;
      continue;
      int i14 = 0;
      continue;
      int i13 = 0;
      continue;
      int i12 = 0;
      continue;
      int i11 = 0;
      continue;
      int i10 = 0;
      continue;
      int i9 = 0;
      continue;
      int i8 = 0;
      continue;
      int i7 = 0;
      continue;
      int i6 = 0;
      continue;
      int i5 = 0;
      continue;
      int i4 = 0;
      continue;
      int i3 = 0;
      continue;
      int i2 = 0;
      continue;
      label1636:
      int i1 = 0;
      continue;
      label1641:
      i1 = 1;
      continue;
      label1646:
      i2 = 1;
      continue;
      label1651:
      i3 = 1;
      continue;
      label1657:
      i4 = 1;
      continue;
      label1663:
      i5 = 1;
      continue;
      i6 = 1;
      continue;
      i7 = 1;
      continue;
      i8 = 1;
      continue;
      i9 = 1;
      continue;
      i10 = 1;
      continue;
      i11 = 1;
      continue;
      i12 = 1;
      continue;
      i13 = 1;
      continue;
      i14 = 1;
      continue;
      i15 = 1;
      continue;
      i16 = 1;
      continue;
      i17 = 1;
      continue;
      i18 = 1;
      continue;
      i19 = 1;
      continue;
      i20 = 1;
      continue;
      i21 = 1;
      continue;
      label1765:
      i22 = 1;
      continue;
      label1771:
      int i23 = 1;
      label1774:
      if ((i1 == 0) && (i2 == 0) && (i3 == 0) && (i5 == 0) && (i6 == 0) && (i7 == 0) && (i8 == 0) && (i9 == 0) && (i10 == 0) && (i11 == 0) && (i13 == 0) && (i14 == 0) && (i15 == 0) && (i16 == 0) && (i17 == 0) && (i18 == 0) && (i19 == 0) && (i20 == 0) && (i21 == 0) && (i12 == 0) && (i22 == 0) && (i23 == 0)) {
        if (i4 != 0)
        {
          continue;
          return true;
          str1 = "";
        }
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {}
    try
    {
      paramQQAppInterface = new JSONObject();
      paramQQAppInterface.put("pacenter_url", jdField_a_of_type_JavaLangString);
      paramQQAppInterface.put("pacategory_url", jdField_b_of_type_JavaLangString);
      paramQQAppInterface.put("readinjoy_search_url", jdField_c_of_type_JavaLangString);
      paramQQAppInterface.put("image_collection_comment", jdField_d_of_type_Boolean);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("public_account_center_url_config_data", paramQQAppInterface.toString());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updatePublicAccountCenterUrlConfigData error", paramQQAppInterface);
      }
      paramQQAppInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil
 * JD-Core Version:    0.7.0.1
 */