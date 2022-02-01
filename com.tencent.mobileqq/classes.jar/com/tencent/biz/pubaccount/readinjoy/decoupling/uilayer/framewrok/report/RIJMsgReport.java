package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJMsgReport;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "msgNum", "", "getMsgNum", "()I", "setMsgNum", "(I)V", "addMessageNumToR5", "r5", "", "Lorg/json/JSONObject;", "addMessageReportToR5", "addReportToR5Common", "jsonFunCall", "Lkotlin/Function1;", "recodrMsgNum", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJMsgReport
{
  private static int jdField_a_of_type_Int = 0;
  public static final RIJMsgReport a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "RIJMsgReport";
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokReportRIJMsgReport = new RIJMsgReport();
  }
  
  private final String a(String paramString, Function1<? super JSONObject, Unit> paramFunction1)
  {
    Object localObject = (JSONObject)null;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject = localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, localJSONException.getMessage());
        continue;
      }
      if (localObject != null)
      {
        paramFunction1.invoke(localObject);
        paramString = ((JSONObject)localObject).toString();
      }
      return paramString;
      localObject = new JSONObject();
    }
  }
  
  @Nullable
  public final String a(@Nullable String paramString)
  {
    return a(paramString, (Function1)new RIJMsgReport.addMessageReportToR5.1((RIJMsgReport)this));
  }
  
  public final void a()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER); localObject == null; localObject = null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager");
    }
    localObject = (KandianMergeManager)localObject;
    if (localObject != null) {
      jdField_a_of_type_Int = ((KandianMergeManager)localObject).e();
    }
  }
  
  public final void a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "r5");
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);; localObject = null)
    {
      localObject = (KandianMergeManager)localObject;
      if (localObject != null)
      {
        localObject = ((KandianMergeManager)localObject).a();
        if (localObject != null)
        {
          paramJSONObject.put("message_type", ((KandianMsgBoxRedPntInfo)localObject).mMsgType);
          paramJSONObject.put("sys_msg_from", ((KandianMsgBoxRedPntInfo)localObject).mUin);
          paramJSONObject.put("sys_msg_id", ((KandianMsgBoxRedPntInfo)localObject).sysMsgID);
        }
      }
      return;
    }
  }
  
  @Nullable
  public final String b(@Nullable String paramString)
  {
    return a(paramString, (Function1)new RIJMsgReport.addMessageNumToR5.1((RIJMsgReport)this));
  }
  
  public final void b(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "r5");
    if (jdField_a_of_type_Int != 0) {
      paramJSONObject.put("tab_reddot_num", jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJMsgReport
 * JD-Core Version:    0.7.0.1
 */