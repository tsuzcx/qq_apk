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
  public static final int a = Color.rgb(64, 64, 65);
  public static final int b = Color.rgb(166, 166, 166);
  public static final int c = Color.argb(205, 255, 255, 255);
  public static final int d = Color.argb(154, 255, 255, 255);
  public static final int e = Color.rgb(19, 19, 19);
  public static long f = -1L;
  public static AnonymousChatHelper k;
  public HashMap<String, AnonymousChatHelper.AnonymousInfo> g = new HashMap();
  public AnonymousChatHelper.AnonymousStatusListener h;
  public AnonymousChatHelper.AnonymousReport i;
  public boolean j = false;
  
  public static AnonymousChatHelper a()
  {
    if (k == null) {
      k = new AnonymousChatHelper();
    }
    return k;
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
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.extLong & 0x3) == 3;
  }
  
  public static String d(MessageRecord paramMessageRecord)
  {
    if (!c(paramMessageRecord)) {
      return "";
    }
    if (AskAnonymousUtil.a(paramMessageRecord)) {
      return BaseApplicationImpl.getApplication().getResources().getString(2131896598);
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131895011);
  }
  
  public static void e(MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extLong |= 0x3;
  }
  
  public static boolean f(MessageRecord paramMessageRecord)
  {
    int m;
    if (((paramMessageRecord instanceof ChatMessage)) && (((ChatMessage)paramMessageRecord).fakeSenderType == 2)) {
      m = 1;
    } else {
      m = 0;
    }
    return (m == 0) && (!paramMessageRecord.isMultiMsg) && (g(paramMessageRecord).a == 2);
  }
  
  public static AnonymousChatHelper.AnonymousExtInfo g(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("anonymous");
    paramMessageRecord = new AnonymousChatHelper.AnonymousExtInfo();
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("flags")) {
        paramMessageRecord.a = ((JSONObject)localObject).getInt("flags");
      }
      if (((JSONObject)localObject).has("an_id")) {
        paramMessageRecord.b = ((JSONObject)localObject).getString("an_id");
      }
      if (((JSONObject)localObject).has("an_nick")) {
        paramMessageRecord.c = ((JSONObject)localObject).getString("an_nick");
      }
      if (((JSONObject)localObject).has("head_protrait")) {
        paramMessageRecord.d = ((JSONObject)localObject).getInt("head_protrait");
      }
      if (((JSONObject)localObject).has("expire_time")) {
        paramMessageRecord.e = ((JSONObject)localObject).getInt("expire_time");
      }
      if (((JSONObject)localObject).has("rankColor"))
      {
        paramMessageRecord.f = ((JSONObject)localObject).optString("rankColor");
        return paramMessageRecord;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramMessageRecord;
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramString1 = this.i;
      if (paramString1 == null) {
        return null;
      }
      return paramString1.c;
    }
    return null;
  }
  
  public void a(AnonymousChatHelper.AnonymousStatusListener paramAnonymousStatusListener)
  {
    this.h = paramAnonymousStatusListener;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (this.j)
    {
      if ((paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1) || (paramMessageRecord.longMsgCount == 0)) {
        this.j = false;
      }
      return;
    }
    if (a(paramMessageRecord.frienduin))
    {
      AnonymousChatHelper.AnonymousInfo localAnonymousInfo = b(paramMessageRecord.frienduin);
      paramMessageRecord.vipBubbleID = localAnonymousInfo.b;
      paramMessageRecord.extLong |= 0x3;
      paramMessageRecord.saveExtInfoToExtStr("anonymous", a(2, localAnonymousInfo.f, localAnonymousInfo.d, localAnonymousInfo.c, localAnonymousInfo.e, localAnonymousInfo.g));
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
    if (this.g.containsKey(paramString1))
    {
      localObject = (AnonymousChatHelper.AnonymousInfo)this.g.get(paramString1);
      ((AnonymousChatHelper.AnonymousInfo)localObject).c = paramInt1;
      if ((paramString2 != null) && (!paramString2.equals(((AnonymousChatHelper.AnonymousInfo)localObject).d)))
      {
        AnonymousChatHelper.AnonymousStatusListener localAnonymousStatusListener = this.h;
        if (localAnonymousStatusListener != null) {
          localAnonymousStatusListener.a(paramString1, paramString2);
        }
      }
      ((AnonymousChatHelper.AnonymousInfo)localObject).d = paramString2;
      ((AnonymousChatHelper.AnonymousInfo)localObject).b = paramLong;
      ((AnonymousChatHelper.AnonymousInfo)localObject).e = paramInt2;
      ((AnonymousChatHelper.AnonymousInfo)localObject).f = paramString3;
      ((AnonymousChatHelper.AnonymousInfo)localObject).g = paramString4;
      this.g.put(paramString1, localObject);
      return;
    }
    Object localObject = new AnonymousChatHelper.AnonymousInfo(this, false);
    ((AnonymousChatHelper.AnonymousInfo)localObject).c = paramInt1;
    ((AnonymousChatHelper.AnonymousInfo)localObject).d = paramString2;
    ((AnonymousChatHelper.AnonymousInfo)localObject).b = paramLong;
    ((AnonymousChatHelper.AnonymousInfo)localObject).e = paramInt2;
    ((AnonymousChatHelper.AnonymousInfo)localObject).f = paramString3;
    ((AnonymousChatHelper.AnonymousInfo)localObject).g = paramString4;
    this.g.put(paramString1, localObject);
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
      if (this.i == null) {
        this.i = new AnonymousChatHelper.AnonymousReport(this);
      }
      AnonymousChatHelper.AnonymousReport localAnonymousReport = this.i;
      localAnonymousReport.a = paramString1;
      localAnonymousReport.b = paramString2;
      localAnonymousReport.c = paramMessageRecord;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.g.containsKey(paramString))
    {
      ((AnonymousChatHelper.AnonymousInfo)this.g.get(paramString)).a = paramBoolean;
      return;
    }
    this.g.put(paramString, new AnonymousChatHelper.AnonymousInfo(this, paramBoolean));
  }
  
  public boolean a(String paramString)
  {
    if (this.g.containsKey(paramString)) {
      return ((AnonymousChatHelper.AnonymousInfo)this.g.get(paramString)).a;
    }
    return false;
  }
  
  public AnonymousChatHelper.AnonymousInfo b(String paramString)
  {
    return (AnonymousChatHelper.AnonymousInfo)this.g.get(paramString);
  }
  
  public void b()
  {
    this.g.clear();
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (this.j)
    {
      if ((paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1) || (paramMessageRecord.longMsgCount == 0)) {
        this.j = false;
      }
      return;
    }
    if (a(paramMessageRecord.frienduin))
    {
      AnonymousChatHelper.AnonymousInfo localAnonymousInfo = b(paramMessageRecord.frienduin);
      paramMessageRecord.vipBubbleID = localAnonymousInfo.b;
      paramMessageRecord.extLong |= 0x3;
      paramMessageRecord.saveExtInfoToExtStr("anonymous", a(2, null, localAnonymousInfo.d, localAnonymousInfo.c, localAnonymousInfo.e, localAnonymousInfo.g));
    }
  }
  
  public void c()
  {
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.anonymous.AnonymousChatHelper
 * JD-Core Version:    0.7.0.1
 */