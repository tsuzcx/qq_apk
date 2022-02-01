package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.ShareReport;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/RIJActivityResultHandler;", "", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "currentActivity", "Landroid/app/Activity;", "channelID", "", "dataFetchManager", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataFetchManager;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;Landroid/app/Activity;ILcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataFetchManager;)V", "methodsMap", "", "Lkotlin/Function3;", "Landroid/content/Intent;", "", "addShareCount", "resultCode", "handleAdvertisementResultFunc", "what", "intent", "handleChatActivityResultFunc", "handleCommentResultFunc", "handleDeliverWenDaResultFunc", "handleFastWebActivityResultFunc", "handleShareReportFunc", "handleSocialTipMessageBoxFunc", "invokeMethod", "requestCode", "notifyAdapterRefreshFunc", "registerRequestCodeToFunctionMap", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJActivityResultHandler
{
  @JvmField
  public int a;
  @JvmField
  @NotNull
  public Activity a;
  @JvmField
  @NotNull
  public RIJDataFetchManager a;
  @JvmField
  @NotNull
  public ReadInJoyBaseAdapter a;
  private final Map<Integer, Function3<Integer, Integer, Intent, Unit>> a;
  
  public RIJActivityResultHandler(@NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @NotNull Activity paramActivity, int paramInt, @NotNull RIJDataFetchManager paramRIJDataFetchManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager = paramRIJDataFetchManager;
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    a();
  }
  
  private final void a()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(9991), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.1((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(9091), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.2((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(21), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.3((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(19202), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.4((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(125), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.5((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.6((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.7((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10922), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.8((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(20001), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.9((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1032), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.10((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(9999), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.11((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(102), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.12((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(55577), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.13((RIJActivityResultHandler)this));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(117), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.14((RIJActivityResultHandler)this));
  }
  
  private final void a(int paramInt)
  {
    if (-1 == paramInt) {
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), ReadInJoyShareHelperV2.ShareReport.a.a(), 1);
    }
  }
  
  private final void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(paramInt2, paramIntent);
  }
  
  private final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == -1) && (paramIntent != null))
    {
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      if (localAppRuntime == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
      ForwardUtils.a((QQAppInterface)localAppRuntime, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), paramIntent, null);
    }
    paramIntent = ReadInJoyShareHelperV2.ShareReport.a;
    if (-1 == paramInt1) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.a(bool);
      a(paramInt1);
      return;
    }
  }
  
  private final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = ReadInJoyShareHelperV2.ShareReport.a;
    if (-1 == paramInt1) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.a(bool);
      a(paramInt1);
      return;
    }
  }
  
  private final void e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == -10069)
    {
      if (paramIntent == null) {
        break label53;
      }
      paramIntent = paramIntent.getExtras();
      if (paramIntent == null) {
        break label53;
      }
    }
    label53:
    for (paramIntent = paramIntent.get("fast_web_article_info");; paramIntent = null)
    {
      paramIntent = (ArticleInfo)paramIntent;
      if (paramIntent != null) {
        RIJJumpUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  private final void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = ReadInJoyUtils.a();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (paramIntent == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager");
      }
      ((KandianMergeManager)paramIntent).q();
      QLog.d("ReadInJoyListViewGroup", 1, "back from msgbox page, setRead!");
    }
  }
  
  private final void g(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringExtra("arg_result_json");; paramIntent = null) {
      if (paramIntent != null) {
        try
        {
          paramIntent = new JSONObject(paramIntent);
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", this.jdField_a_of_type_Int);
            localJSONObject.put("rowkey", paramIntent.optString("rowkey"));
            localJSONObject.put("topicid", "");
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800982D", "0X800982D", 0, 0, paramIntent.optString("feedsId") + "", "2", "", localJSONObject.toString(), false);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          return;
        }
        catch (Exception paramIntent)
        {
          QLog.e("ReadInJoyListViewGroup", 1, "REQ_CODE_DELIVER_WENDA wrong json : e = " + paramIntent);
        }
      }
    }
  }
  
  private final void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == -1) {
      if (paramIntent == null) {
        break label35;
      }
    }
    label35:
    for (paramIntent = paramIntent.getParcelableExtra("key_ad_info");; paramIntent = null)
    {
      paramIntent = (AdvertisementInfo)paramIntent;
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(paramIntent);
      }
      return;
    }
  }
  
  private final void i(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
      if (localArticleInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager.a(paramInt1, localArticleInfo, paramIntent);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    Function3 localFunction3;
    if ((paramInt1 == 9991) || (paramInt1 == 2))
    {
      localFunction3 = (Function3)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
      if (localFunction3 != null) {
        paramIntent = (Unit)localFunction3.invoke(Integer.valueOf(paramInt2), Integer.valueOf(2), paramIntent);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 9091) {
            break;
          }
          localFunction3 = (Function3)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
        } while (localFunction3 == null);
        paramIntent = (Unit)localFunction3.invoke(Integer.valueOf(paramInt2), Integer.valueOf(0), paramIntent);
        return;
        if (paramInt1 != 1) {
          break;
        }
        localFunction3 = (Function3)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
      } while (localFunction3 == null);
      paramIntent = (Unit)localFunction3.invoke(Integer.valueOf(paramInt2), Integer.valueOf(1), paramIntent);
      return;
      localFunction3 = (Function3)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    } while (localFunction3 == null);
    paramIntent = (Unit)localFunction3.invoke(Integer.valueOf(paramInt2), Integer.valueOf(0), paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJActivityResultHandler
 * JD-Core Version:    0.7.0.1
 */