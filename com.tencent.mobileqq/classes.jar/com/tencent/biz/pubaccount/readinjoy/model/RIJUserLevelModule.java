package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJUserLevelDialog.DialogSettingInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;

public class RIJUserLevelModule
{
  private static volatile RIJUserLevelModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule;
  private Map<Long, RIJUserLevelRequestModule.UserLevelInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  private RIJUserLevelModule()
  {
    RIJUserLevelModule.1 local1 = new RIJUserLevelModule.1(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(local1);
    c();
  }
  
  /* Error */
  public static RIJUserLevelModule a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 40	com/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule:jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule	Lcom/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 40	com/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule:jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule	Lcom/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule
    //   21: dup
    //   22: invokespecial 41	com/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule:<init>	()V
    //   25: putstatic 40	com/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule:jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule	Lcom/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 40	com/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule:jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelModule	Lcom/tencent/biz/pubaccount/readinjoy/model/RIJUserLevelModule;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localRIJUserLevelModule	RIJUserLevelModule
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private RIJUserLevelRequestModule.UserLevelInfo a(long paramLong)
  {
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo2 = (RIJUserLevelRequestModule.UserLevelInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo1 = localUserLevelInfo2;
    if (localUserLevelInfo2 == null)
    {
      localUserLevelInfo1 = new RIJUserLevelRequestModule.UserLevelInfo();
      localUserLevelInfo1.uin = paramLong;
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localUserLevelInfo1);
    }
    return localUserLevelInfo1;
  }
  
  private void a(long paramLong, int paramInt)
  {
    RIJUserLevelRequestModule localRIJUserLevelRequestModule = ReadInJoyLogicEngine.a().a();
    if (localRIJUserLevelRequestModule != null) {
      localRIJUserLevelRequestModule.a(paramLong, paramInt);
    }
  }
  
  private void a(Context paramContext, RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo == null)
    {
      QLog.d("RIJUserLevelModel", 1, "showErrorDialog userLevelInfo is null.");
      return;
    }
    b(paramContext, paramUserLevelInfo);
    RIJUserLevelDialog.DialogSettingInfo localDialogSettingInfo = new RIJUserLevelDialog.DialogSettingInfo();
    localDialogSettingInfo.jdField_a_of_type_JavaLangString = paramUserLevelInfo.errorDialogTitle;
    localDialogSettingInfo.c = paramUserLevelInfo.errorDialogContent;
    localDialogSettingInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJUserLevelDialog$DialogClick = new RIJUserLevelModule.2(this, paramContext, paramUserLevelInfo);
    ReadInJoyUtils.a(paramContext, localDialogSettingInfo);
  }
  
  private void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramUserLevelInfo.uin), paramUserLevelInfo);
    b();
  }
  
  private void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo, RIJUserLevelModule.UserLevelCallBack paramUserLevelCallBack)
  {
    if (paramUserLevelCallBack != null) {
      paramUserLevelCallBack.a(paramUserLevelInfo);
    }
  }
  
  private void a(Object paramObject)
  {
    Gson localGson = new Gson();
    if ((paramObject instanceof String))
    {
      paramObject = (RIJUserLevelRequestModule.UserLevelInfo)localGson.fromJson(paramObject.toString(), RIJUserLevelRequestModule.UserLevelInfo.class);
      if (paramObject != null) {
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramObject.uin), paramObject);
      }
    }
  }
  
  private void a(oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt)
  {
    QLog.d("RIJUserLevelModel", 1, "updateUserLevelInfo!");
    if (paramPrivilegeRspBody == null) {
      return;
    }
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo = a(paramLong);
    localUserLevelInfo.jumpUrl = RIJPBFieldUtils.a(paramPrivilegeRspBody.jump_url);
    localUserLevelInfo.level = RIJPBFieldUtils.a(paramPrivilegeRspBody.level);
    localUserLevelInfo.opesAllowedMap.put(Integer.valueOf(paramInt), Boolean.valueOf(RIJPBFieldUtils.a(paramPrivilegeRspBody.is_allowed)));
    localUserLevelInfo.dailyTopicNum = RIJPBFieldUtils.a(paramPrivilegeRspBody.daily_topic_num);
    localUserLevelInfo.operFobidWording.put(Integer.valueOf(paramInt), RIJPBFieldUtils.a(paramPrivilegeRspBody.forbid_wording, ""));
    localUserLevelInfo.isInLevelGrayList = RIJPBFieldUtils.a(paramPrivilegeRspBody.is_experience);
    a(localUserLevelInfo);
    QLog.d("RIJUserLevelModel", 1, "updateUserLevelInfo! cacheUserLevelInfo=" + localUserLevelInfo);
  }
  
  public static boolean a()
  {
    return Aladdin.getConfig(389).getIntegerFromString("ugc_privilege_switch", 0) == 1;
  }
  
  private void b()
  {
    Gson localGson = new Gson();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      String str = localGson.toJson((RIJUserLevelRequestModule.UserLevelInfo)((Map.Entry)localIterator.next()).getValue());
      if (!TextUtils.isEmpty(str)) {
        localJSONArray.put(str);
      }
    }
    if (localJSONArray.length() > 0) {
      ReadInJoyHelper.a("user_info_level_sp", localJSONArray.toString());
    }
    QLog.d("RIJUserLevelModel", 1, "save2Local ,datas=" + localJSONArray);
  }
  
  private void b(Context paramContext, RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if ((paramUserLevelInfo == null) || (paramContext == null)) {
      return;
    }
    String str2 = paramContext.getString(2131699725);
    String str1;
    switch (paramUserLevelInfo.currentOpType)
    {
    default: 
      str1 = paramContext.getString(2131699754);
    }
    for (;;)
    {
      paramUserLevelInfo.errorDialogContent = (paramContext.getString(2131699713) + paramUserLevelInfo.level + str1);
      paramUserLevelInfo.errorDialogTitle = str2;
      return;
      str1 = paramContext.getString(2131699752);
      continue;
      str1 = paramContext.getString(2131699751);
      continue;
      str2 = paramContext.getString(2131699724);
      str1 = paramContext.getString(2131699753);
    }
  }
  
  private void c()
  {
    String str = (String)ReadInJoyHelper.a("user_info_level_sp", "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(str);
        int i = 0;
        while (i < localJSONArray.length())
        {
          a(localJSONArray.get(i));
          i += 1;
        }
        QLog.d("RIJUserLevelModel", 1, "loadUserInfoFromSP ,data=" + str);
      }
      catch (Exception localException)
      {
        QLog.d("RIJUserLevelModel", 1, "loadUserInfoFromSP error! msg=" + localException);
      }
    }
  }
  
  public RIJUserLevelRequestModule.UserLevelInfo a(int paramInt)
  {
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo = a(ReadInJoyUtils.a());
    localUserLevelInfo.currentOpType = paramInt;
    return localUserLevelInfo;
  }
  
  public void a()
  {
    QLog.d("RIJUserLevelModel", 1, "preRequestUserLevel! hasPreRequest=" + this.jdField_a_of_type_Boolean);
    long l = ReadInJoyUtils.a();
    a(l, 5);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(l, 7);
    a(l, 6);
    a(l, 11);
    this.jdField_a_of_type_Boolean = true;
  }
  
  @Deprecated
  public void a(int paramInt, RIJUserLevelModule.UserLevelCallBack paramUserLevelCallBack)
  {
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo = a(paramInt);
    a(localUserLevelInfo, paramUserLevelCallBack);
    a(localUserLevelInfo.uin, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt, true);
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool = a();
    QLog.d("RIJUserLevelModel", 2, "getCacheUserLevel ,switchOpen=" + bool + " operType=" + paramInt);
    if (!bool) {
      return paramBoolean;
    }
    Boolean localBoolean = (Boolean)a(paramInt).opesAllowedMap.get(Integer.valueOf(paramInt));
    QLog.d("RIJUserLevelModel", 2, "getCacheUserLevel ,isAllow=" + localBoolean);
    if ((localBoolean == null) || (localBoolean.booleanValue())) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public boolean a(Context paramContext, int paramInt, @Nullable RIJUserLevelModule.UserLevelCallBack paramUserLevelCallBack)
  {
    boolean bool = a();
    QLog.d("RIJUserLevelModel", 1, "doActionsByUserLevel ,switchOpen=" + bool + " operType=" + paramInt);
    RIJUserLevelRequestModule.UserLevelInfo localUserLevelInfo = a(paramInt);
    if (!bool)
    {
      a(localUserLevelInfo, paramUserLevelCallBack);
      return true;
    }
    Boolean localBoolean = (Boolean)localUserLevelInfo.opesAllowedMap.get(Integer.valueOf(paramInt));
    if ((localBoolean == null) || (localBoolean.booleanValue()))
    {
      bool = true;
      if (!bool) {
        break label156;
      }
      a(localUserLevelInfo, paramUserLevelCallBack);
    }
    for (;;)
    {
      QLog.d("RIJUserLevelModel", 1, "doActionsByUserLevel ,isAllow=" + localBoolean);
      a(localUserLevelInfo.uin, paramInt);
      return bool;
      bool = false;
      break;
      label156:
      a(paramContext, localUserLevelInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule
 * JD-Core Version:    0.7.0.1
 */