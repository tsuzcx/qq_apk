package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import laa;
import lab;
import lac;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoReporter
{
  public static int a;
  public static String a;
  public static HashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "7.6.0".replace(".", "");
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    boolean bool1 = ReadInJoyHelper.f();
    boolean bool2 = ReadInJoyHelper.g();
    if (!bool1) {
      return 0;
    }
    if (bool2) {
      return 3;
    }
    return 1;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 4: 
      return 2;
    }
    return 3;
  }
  
  public static int a(int paramInt, String paramString)
  {
    int j = 1;
    int i;
    if (paramInt != 2)
    {
      i = j;
      if (paramInt != 3) {}
    }
    else
    {
      i = j;
      if (!TextUtils.isEmpty(paramString)) {
        i = paramString.hashCode();
      }
    }
    return i;
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return -1;
    }
    if (paramArticleInfo.videoJumpChannelID > 0) {
      return paramArticleInfo.videoJumpChannelID;
    }
    if (ReadInJoyHelper.d(BaseApplicationImpl.getApplication().getRuntime()) == 1) {
      return 56;
    }
    return 409409;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int j = 2;
    if (paramInt == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface == null) {
        break label74;
      }
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface == null) {
        break label74;
      }
    }
    label74:
    for (paramInt = paramQQAppInterface.wMemberNum;; paramInt = 2)
    {
      int i = paramInt;
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramInt != 3000);
        paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(52);
        i = j;
      } while (paramQQAppInterface == null);
      return paramQQAppInterface.a(paramString);
    }
  }
  
  public static Bundle a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    int j = 0;
    int i = 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("makeAdVideoPlayParam(in) ");
      ((StringBuilder)localObject).append("autoPlay:").append(paramBoolean1).append(", ");
      ((StringBuilder)localObject).append("bt:").append(paramInt1).append(", ");
      ((StringBuilder)localObject).append("et:").append(paramInt2).append(", ");
      ((StringBuilder)localObject).append("bf:").append(paramBoolean2).append(", ");
      ((StringBuilder)localObject).append("ef:").append(paramBoolean3).append(", ");
      ((StringBuilder)localObject).append("pa:").append(paramInt3);
      QLog.d("VideoReporter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("arg_video_bt", paramInt1);
    ((Bundle)localObject).putInt("arg_video_et", paramInt2);
    if (paramBoolean2)
    {
      paramInt1 = 1;
      ((Bundle)localObject).putInt("arg_video_bf", paramInt1);
      paramInt1 = j;
      if (paramBoolean3) {
        paramInt1 = 1;
      }
      ((Bundle)localObject).putInt("arg_video_ef", paramInt1);
      ((Bundle)localObject).putInt("arg_video_pp", 2);
      ((Bundle)localObject).putInt("arg_video_pa", paramInt3);
      if (!paramBoolean1) {
        break label265;
      }
    }
    label265:
    for (paramInt1 = i;; paramInt1 = 2)
    {
      ((Bundle)localObject).putInt("arg_video_pb", paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("VideoReporter", 2, "makeAdVideoPlayParam(out) param:" + ((Bundle)localObject).toString());
      }
      return localObject;
      paramInt1 = 0;
      break;
    }
  }
  
  public static String a()
  {
    int i = NetworkUtil.b(BaseApplicationImpl.getApplication().getApplicationContext());
    if (i == 1) {
      return "0";
    }
    if ((i == 3) || (i == 4)) {
      return "1";
    }
    return "2";
  }
  
  public static String a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      paramInt = i;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("camera_type", paramInt);
        return a(localJSONObject);
        if (paramInt == 2) {
          paramInt = 2;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        paramInt = 0;
      }
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("jump_to_channel", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localJSONObject.put("jump_to_channel", paramInt);
      localJSONObject.put("video_session_id", paramString1);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
  
  public static String a(int paramInt, JSONObject paramJSONObject)
  {
    return a(null, null, null, null, paramInt, paramJSONObject);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, JSONObject paramJSONObject)
  {
    return a(null, null, paramString1, paramString2, paramInt, paramJSONObject);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channel_id", paramInt);
      label28:
      return a(paramString1, paramString2, paramString3, paramString4, localJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      break label28;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("video_duration", paramLong2);
        return a(paramString1, paramString2, paramString3, paramString4, paramLong1, paramJSONObject);
      }
      catch (Exception localException) {}
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("current_duration", paramLong);
      label28:
      return a(paramString1, paramString2, paramString3, paramString4, localJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      break label28;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject)
  {
    String str = a();
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(paramString1))
        {
          localJSONObject.put("md5", paramString1);
          localJSONObject.put("network_type", str);
          localJSONObject.put("os", "1");
          if (jdField_a_of_type_JavaLangString == null) {
            jdField_a_of_type_JavaLangString = "7.6.0".replace(".", "");
          }
          localJSONObject.put("version", jdField_a_of_type_JavaLangString);
          localJSONObject.put("imei", ReadInJoyUtils.f());
          localJSONObject.put("imsi", ReadInJoyUtils.g());
          localJSONObject.put("kandian_mode_new", a());
          localJSONObject.put("kandian_mode", ReadInJoyUtils.e());
          if (paramJSONObject == null) {
            break;
          }
          paramString1 = paramJSONObject.keys();
          if (!paramString1.hasNext()) {
            break;
          }
          paramString2 = (String)paramString1.next();
          localJSONObject.put(paramString2, paramJSONObject.getString(paramString2));
          continue;
        }
        localJSONObject.put("aid", paramString4);
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return "";
      }
      localJSONObject.put("vid", paramString3);
      localJSONObject.put("puin", paramString2);
    }
    paramString1 = localJSONObject.toString();
    return paramString1;
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    return a(null, null, null, null, paramJSONObject);
  }
  
  public static void a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    StringBuilder localStringBuilder;
    if (paramInt1 == 56)
    {
      localReportInfo.mOpSource = 11;
      localReportInfo.mSourceArticleId = paramLong1;
      localReportInfo.mInnerId = paramString;
      localReportInfo.mChannelId = paramInt1;
      localReportInfo.mAlgorithmId = paramInt2;
      localReportInfo.mStrategyId = paramInt3;
      localReportInfo.mOperation = paramInt4;
      localReportInfo.mPlayTimeLength = ((int)paramLong2);
      localReportInfo.mVideoExtraRepoerData = paramVideoExtraRepoerData;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("reportVideoUserOperationByOidbOfFeed--mUin:").append(localReportInfo.mUin).append("; mSource:").append(localReportInfo.mSource).append("; mOpSource:").append(localReportInfo.mOpSource).append("; mInnerId:").append(localReportInfo.mInnerId).append("; mChannelId:").append(localReportInfo.mChannelId).append("; mAlgorithmId:").append(localReportInfo.mAlgorithmId).append("; mStrategyId:").append(localReportInfo.mStrategyId).append("; mOperation:").append(localReportInfo.mOperation).append("; mPlayTimeLength:").append(localReportInfo.mPlayTimeLength).append("; videoExtraRepoerData:");
        if (paramVideoExtraRepoerData == null) {
          break label310;
        }
      }
    }
    label310:
    for (paramString = paramVideoExtraRepoerData.toString();; paramString = "null")
    {
      QLog.d("VideoReporter", 2, paramString);
      localArrayList.add(localReportInfo);
      new UserOperationModule(null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
      return;
      localReportInfo.mOpSource = 0;
      break;
    }
  }
  
  public static void a(long paramLong1, String paramString, int paramInt1, int paramInt2, long paramLong2, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData)
  {
    a(paramLong1, paramString, paramInt1, 0, 0, paramInt2, paramLong2, paramVideoExtraRepoerData);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, VideoAdInfo paramVideoAdInfo, Bundle paramBundle)
  {
    if ((paramAppInterface == null) || (paramVideoAdInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoReporter", 2, "reportAdVideoUserOperationBy0x886 invalid variable");
      }
    }
    do
    {
      return;
      new UserOperationModule(paramAppInterface, null, null, ReadInJoyMSFService.a(), null).a(paramInt, paramVideoAdInfo, paramBundle);
    } while (!QLog.isColorLevel());
    QLog.d("VideoReporter", 2, "reportAdVideoUserOperationBy0x886 mTraceID=" + paramVideoAdInfo.h);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    ThreadManager.executeOnSubThread(new lab(paramInt1, paramQQAppInterface, paramString, paramInt2, paramLong));
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    ThreadManager.executeOnSubThread(new lac(paramMessageRecord));
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData)
  {
    ThreadManager.post(new laa(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramVideoExtraRepoerData), 5, null, true);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    String str = "";
    if (paramInt1 == 1008) {
      str = "1";
    }
    if (paramInt1 == 0) {
      str = "2";
    }
    for (;;)
    {
      PublicAccountReportUtils.a(null, "CliOper", "", "", paramString1, paramString1, 0, 0, str, Integer.toString(paramInt2), paramString3, paramString2, false);
      return;
      if (paramInt1 == 1) {
        str = "3";
      } else if (paramInt1 == 3000) {
        str = "4";
      }
    }
  }
  
  public static String b()
  {
    if ((ReadInJoyUtils.a() instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
      return MD5Utils.d(localQQAppInterface.c() + "_" + System.currentTimeMillis());
    }
    return MD5Utils.d("_" + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoReporter
 * JD-Core Version:    0.7.0.1
 */