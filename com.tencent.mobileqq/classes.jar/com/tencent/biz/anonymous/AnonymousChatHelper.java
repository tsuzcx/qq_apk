package com.tencent.biz.anonymous;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AnonymousChatHelper
{
  public static final int a;
  public static long a;
  public static AnonymousChatHelper a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public AnonymousChatHelper.AnonymousReport a;
  public AnonymousChatHelper.AnonymousStatusListener a;
  public HashMap<String, AnonymousChatHelper.AnonymousInfo> a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Int = Color.rgb(64, 64, 65);
    jdField_b_of_type_Int = Color.rgb(166, 166, 166);
    jdField_c_of_type_Int = Color.argb(205, 255, 255, 255);
    d = Color.argb(154, 255, 255, 255);
    e = Color.rgb(19, 19, 19);
    jdField_a_of_type_Long = -1L;
  }
  
  public AnonymousChatHelper()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static AnonymousChatHelper.AnonymousExtInfo a(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("anonymous");
    paramMessageRecord = new AnonymousChatHelper.AnonymousExtInfo();
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("flags")) {
        paramMessageRecord.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("flags");
      }
      if (((JSONObject)localObject).has("an_id")) {
        paramMessageRecord.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("an_id");
      }
      if (((JSONObject)localObject).has("an_nick")) {
        paramMessageRecord.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("an_nick");
      }
      if (((JSONObject)localObject).has("head_protrait")) {
        paramMessageRecord.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("head_protrait");
      }
      if (((JSONObject)localObject).has("expire_time")) {
        paramMessageRecord.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("expire_time");
      }
      if (((JSONObject)localObject).has("rankColor"))
      {
        paramMessageRecord.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("rankColor");
        return paramMessageRecord;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramMessageRecord;
  }
  
  public static AnonymousChatHelper a()
  {
    if (jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper == null) {
      jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper = new AnonymousChatHelper();
    }
    return jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://pub.idqqimg.com/pc/group/anony/portrait/img/");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("flags", paramInt1);
      localJSONObject.put("an_id", paramString1);
      localJSONObject.put("an_nick", paramString2);
      localJSONObject.put("head_protrait", paramInt2);
      localJSONObject.put("expire_time", paramInt3);
      localJSONObject.put("rankColor", paramString3);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("getJsonStr JSONException:");
        paramString2.append(paramString1.toString());
        QLog.d("AnonymousChatHelper", 2, paramString2.toString());
      }
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if (!a(paramMessageRecord)) {
      return "";
    }
    if (AskAnonymousUtil.a(paramMessageRecord)) {
      return BaseApplicationImpl.getApplication().getResources().getString(2131698649);
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131697238);
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramContext = paramContext.getSharedPreferences("anonymous_chat", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("first_enter_anonymous");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    if (paramContext.getBoolean(localStringBuilder.toString(), true))
    {
      paramContext = paramContext.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("first_enter_anonymous");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      paramContext.putBoolean(localStringBuilder.toString(), false).commit();
      return true;
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.extLong & 0x3) == 3;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    int i;
    if (((paramMessageRecord instanceof ChatMessage)) && (((ChatMessage)paramMessageRecord).fakeSenderType == 2)) {
      i = 1;
    } else {
      i = 0;
    }
    return (i == 0) && (!paramMessageRecord.isMultiMsg) && (a(paramMessageRecord).jdField_a_of_type_Int == 2);
  }
  
  public static void c(MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extLong |= 0x3;
  }
  
  public AnonymousChatHelper.AnonymousInfo a(String paramString)
  {
    return (AnonymousChatHelper.AnonymousInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramString1 = this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousReport;
      if (paramString1 == null) {
        return null;
      }
      return paramString1.jdField_c_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(AnonymousChatHelper.AnonymousStatusListener paramAnonymousStatusListener)
  {
    this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener = paramAnonymousStatusListener;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1) || (paramMessageRecord.longMsgCount == 0)) {
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    if (a(paramMessageRecord.frienduin))
    {
      AnonymousChatHelper.AnonymousInfo localAnonymousInfo = a(paramMessageRecord.frienduin);
      paramMessageRecord.vipBubbleID = localAnonymousInfo.jdField_a_of_type_Long;
      paramMessageRecord.extLong |= 0x3;
      paramMessageRecord.saveExtInfoToExtStr("anonymous", a(2, localAnonymousInfo.jdField_b_of_type_JavaLangString, localAnonymousInfo.jdField_a_of_type_JavaLangString, localAnonymousInfo.jdField_a_of_type_Int, localAnonymousInfo.jdField_b_of_type_Int, localAnonymousInfo.jdField_c_of_type_JavaLangString));
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("nickName=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", vipBubbleId=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", headId=");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("AnonymousUpdate", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      localObject = (AnonymousChatHelper.AnonymousInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_a_of_type_Int = paramInt1;
      if ((paramString2 != null) && (!paramString2.equals(((AnonymousChatHelper.AnonymousInfo)localObject).jdField_a_of_type_JavaLangString)))
      {
        AnonymousChatHelper.AnonymousStatusListener localAnonymousStatusListener = this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener;
        if (localAnonymousStatusListener != null) {
          localAnonymousStatusListener.a(paramString1, paramString2);
        }
      }
      ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_a_of_type_Long = paramLong;
      ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_b_of_type_Int = paramInt2;
      ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_b_of_type_JavaLangString = paramString3;
      ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_c_of_type_JavaLangString = paramString4;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localObject);
      return;
    }
    Object localObject = new AnonymousChatHelper.AnonymousInfo(this, false);
    ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_a_of_type_Int = paramInt1;
    ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_a_of_type_JavaLangString = paramString2;
    ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_a_of_type_Long = paramLong;
    ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_b_of_type_Int = paramInt2;
    ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_b_of_type_JavaLangString = paramString3;
    ((AnonymousChatHelper.AnonymousInfo)localObject).jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localObject);
  }
  
  public void a(String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramMessageRecord == null) {
        return;
      }
      paramMessageRecord = ReportPlugin.a(paramMessageRecord);
      if (TextUtils.isEmpty(paramMessageRecord)) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousReport == null) {
        this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousReport = new AnonymousChatHelper.AnonymousReport(this);
      }
      AnonymousChatHelper.AnonymousReport localAnonymousReport = this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousReport;
      localAnonymousReport.jdField_a_of_type_JavaLangString = paramString1;
      localAnonymousReport.jdField_b_of_type_JavaLangString = paramString2;
      localAnonymousReport.jdField_c_of_type_JavaLangString = paramMessageRecord;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      ((AnonymousChatHelper.AnonymousInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, new AnonymousChatHelper.AnonymousInfo(this, paramBoolean));
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return ((AnonymousChatHelper.AnonymousInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizAnonymousAnonymousChatHelper$AnonymousStatusListener = null;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1) || (paramMessageRecord.longMsgCount == 0)) {
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    if (a(paramMessageRecord.frienduin))
    {
      AnonymousChatHelper.AnonymousInfo localAnonymousInfo = a(paramMessageRecord.frienduin);
      paramMessageRecord.vipBubbleID = localAnonymousInfo.jdField_a_of_type_Long;
      paramMessageRecord.extLong |= 0x3;
      paramMessageRecord.saveExtInfoToExtStr("anonymous", a(2, null, localAnonymousInfo.jdField_a_of_type_JavaLangString, localAnonymousInfo.jdField_a_of_type_Int, localAnonymousInfo.jdField_b_of_type_Int, localAnonymousInfo.jdField_c_of_type_JavaLangString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.anonymous.AnonymousChatHelper
 * JD-Core Version:    0.7.0.1
 */