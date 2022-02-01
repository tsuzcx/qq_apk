package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJUserInfoUtil;", "", "()V", "TAG", "", "expiredTimeSecond", "", "realtimeSwitch", "", "addUinToList", "", "uinList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uin", "init", "isUserInfoExpired", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadInJoyUserInfo;", "requestUserInfo", "articleInfoList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "channelId", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJUserInfoUtil
{
  private static long jdField_a_of_type_Long = 9223372036854775807L;
  public static final RIJUserInfoUtil a;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJUserInfoUtil = new RIJUserInfoUtil();
  }
  
  private final void a(ArrayList<String> paramArrayList, String paramString)
  {
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (!CollectionsKt.contains((Iterable)paramArrayList, paramString)) && (paramString != null)) {
      paramArrayList.add(paramString);
    }
  }
  
  public final void a()
  {
    long l = 9223372036854775807L;
    boolean bool = false;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(396);
    if (localAladdinConfig != null) {}
    for (int i = localAladdinConfig.getIntegerFromString("realtimeSwitch", 0);; i = 0)
    {
      if (i == 1) {
        bool = true;
      }
      jdField_a_of_type_Boolean = bool;
      if (localAladdinConfig != null) {
        l = localAladdinConfig.getLongFromString("expiredTime", 9223372036854775807L);
      }
      jdField_a_of_type_Long = l;
      QLog.i("RIJUserInfoUtil", 1, "[init] realtimeSwitch = " + jdField_a_of_type_Boolean + ", expiredTimeSecond = " + jdField_a_of_type_Long);
      return;
    }
  }
  
  public final void a(@Nullable List<? extends ArticleInfo> paramList, int paramInt)
  {
    ThreadManager.excute((Runnable)new RIJUserInfoUtil.requestUserInfo.runnable.1(paramInt, paramList), 128, null, false);
  }
  
  public final boolean a(@NotNull ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInJoyUserInfo, "userInfo");
    long l = (System.currentTimeMillis() - paramReadInJoyUserInfo.lastUpdateTimeMilliSecond) / 1000;
    if (l >= jdField_a_of_type_Long) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("RIJUserInfoUtil", 1, "[isUserInfoExpired] isExpired = " + bool + ", uin = " + paramReadInJoyUserInfo.uin + ", nickName = " + paramReadInJoyUserInfo.nick + ", updateIntervalSecond = " + l + ", expiredTimeSecond = " + jdField_a_of_type_Long);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJUserInfoUtil
 * JD-Core Version:    0.7.0.1
 */