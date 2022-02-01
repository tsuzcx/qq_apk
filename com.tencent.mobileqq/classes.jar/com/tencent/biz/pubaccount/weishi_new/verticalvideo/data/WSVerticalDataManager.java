package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import acqy;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushVideoModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pnp;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uen;
import ugb;
import ujk;
import ujn;
import uju;
import ulf;
import unx;
import upe;
import ups;
import ure;
import uro;
import urp;
import urq;
import urr;
import urs;
import urt;
import uru;
import urv;
import uuf;

public class WSVerticalDataManager
{
  private static String a;
  private volatile String b = "";
  private volatile String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static WSVerticalDataManager a()
  {
    return urt.a();
  }
  
  private String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return "";
    }
    WSRedDotPushMsg localWSRedDotPushMsg = ups.a();
    pnp localpnp = ups.a();
    if (localpnp != null) {
      localpnp.a(null);
    }
    if (localWSRedDotPushMsg == null) {
      return "";
    }
    return localWSRedDotPushMsg.mMsgData;
  }
  
  private ArrayList<String> a(boolean paramBoolean, List<uru> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((TextUtils.equals(paramString, "aio_home_page")) && (paramBoolean))
    {
      paramList = b();
      if (!TextUtils.isEmpty(paramList)) {
        localArrayList.add(paramList);
      }
    }
    for (;;)
    {
      return localArrayList;
      if ((paramList != null) && (paramBoolean))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramString = (uru)paramList.next();
          if ((paramString != null) && ((paramString.a() instanceof stSimpleMetaFeed))) {
            localArrayList.add(((stSimpleMetaFeed)paramString.a()).id);
          }
        }
      }
    }
  }
  
  private void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, ure paramure)
  {
    if ((paramure instanceof uuf))
    {
      paramure = ((uuf)paramure).a();
      if (!(paramure instanceof WSVerticalPageFragment)) {
        break label83;
      }
    }
    label83:
    for (paramure = (WSVerticalPageFragment)paramure;; paramure = null)
    {
      if ((paramure != null) && (paramure.getActivity() != null))
      {
        if (!paramure.getActivity().isFinishing()) {
          ugb.a().a(paramstSimpleGetFeedListRsp.config, "global_key_video_layer");
        }
        if (TextUtils.equals(paramure.a(), "aio_home_page")) {
          ugb.a().b(paramstSimpleGetFeedListRsp.config);
        }
      }
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("gdt_pageindex", 0);
        jdField_a_of_type_JavaLangString = paramString.toString();
        String str = LocalMultiProcConfig.getString("cache_key_gdt_args", "");
        if (!TextUtils.isEmpty(str))
        {
          b(new JSONObject(str), paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        acqy.d("WSVerticalDataManagerLog", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSVerticalDataManager.5());
      return;
      jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, ure paramure)
  {
    if ((!paramBoolean) || (!TextUtils.equals(paramString, "aio_home_page"))) {
      return;
    }
    paramString = ups.a();
    if (paramString != null)
    {
      a(paramure, paramString);
      return;
    }
    a(paramure);
  }
  
  private void a(uju paramuju, boolean paramBoolean1, ure paramure, boolean paramBoolean2, Object paramObject, Subscriber<? super urs> paramSubscriber, String paramString)
  {
    if (!paramuju.a())
    {
      upe.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramuju.jdField_a_of_type_Int + ", msg:" + paramuju.jdField_a_of_type_JavaLangString);
      paramSubscriber.onError(new WSVerticalDataManager.ResponseThrowable(paramuju.jdField_a_of_type_Int, paramuju.jdField_a_of_type_JavaLangString));
      return;
    }
    if ((paramuju.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp))
    {
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramuju.jdField_a_of_type_JavaLangObject;
      if (paramBoolean1) {
        a(localstSimpleGetFeedListRsp, paramure);
      }
      this.c = localstSimpleGetFeedListRsp.attach_info;
      this.b = localstSimpleGetFeedListRsp.session;
      a(localstSimpleGetFeedListRsp.gdt_args);
      ulf.c(localstSimpleGetFeedListRsp.gdt_args);
      if (!TextUtils.isEmpty(localstSimpleGetFeedListRsp.gdt_args)) {
        jdField_a_of_type_JavaLangString = localstSimpleGetFeedListRsp.gdt_args;
      }
      if (paramuju.jdField_a_of_type_Ujk != null) {
        ugb.a().a(localstSimpleGetFeedListRsp.trace_id, paramuju.jdField_a_of_type_Ujk.a);
      }
      paramuju = a(localstSimpleGetFeedListRsp.feeds, paramString);
      upe.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] itemDataList size:" + paramuju.size() + ", isRefresh:" + paramBoolean2 + ", isFirst:" + paramBoolean1 + ", mAttachInfo:" + this.c + ", mLastSession:" + this.b + ", gdtArgs:" + jdField_a_of_type_JavaLangString);
      paramSubscriber.onNext(new urs(paramuju, paramBoolean2, paramBoolean1, paramObject));
      return;
    }
    upe.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    paramSubscriber.onError(new WSVerticalDataManager.ResponseThrowable(paramuju.jdField_a_of_type_Int, paramuju.jdField_a_of_type_JavaLangString));
  }
  
  private void a(uju paramuju, boolean paramBoolean1, boolean paramBoolean2, ure paramure, Object paramObject, String paramString)
  {
    Observable.create(new urr(this, paramuju, paramBoolean2, paramure, paramBoolean1, paramObject, paramString)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new urq(this, paramure));
  }
  
  private void a(ure paramure)
  {
    upe.a("WSVerticalDataManagerLog", "fetchVerticalListDataFromLocal");
    uen.a().c(new urp(this, paramure));
  }
  
  private void a(ure paramure, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    IWSPushBaseStrategy localIWSPushBaseStrategy = paramWSRedDotPushMsg.mStrategyInfo;
    if (TextUtils.isEmpty(paramWSRedDotPushMsg.mFeedIds)) {}
    do
    {
      do
      {
        return;
      } while ((localIWSPushBaseStrategy == null) || (localIWSPushBaseStrategy.getType() == 2) || (((WSPushStrategyInfo)localIWSPushBaseStrategy).mWSPushVideoModel == null));
      paramWSRedDotPushMsg = ((WSPushStrategyInfo)localIWSPushBaseStrategy).mWSPushVideoModel.a(paramWSRedDotPushMsg.mFeedIds);
    } while (paramure == null);
    paramure.a(a(Arrays.asList(new stSimpleMetaFeed[] { paramWSRedDotPushMsg })), false, true, null);
  }
  
  private String b()
  {
    pnp localpnp = ups.a();
    String str = "";
    if (localpnp != null) {
      str = localpnp.c();
    }
    return str;
  }
  
  private static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
      return;
    }
    try
    {
      paramJSONObject1.put("deep_link_version", 1);
      paramJSONObject2.put("device_info", paramJSONObject1);
      jdField_a_of_type_JavaLangString = paramJSONObject2.toString();
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      acqy.d("WSVerticalDataManagerLog", "onResult", paramJSONObject1);
    }
  }
  
  public List<uru> a(List paramList)
  {
    return a(paramList, "");
  }
  
  public List<uru> a(List paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtils.isEmpty(paramList))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if ((paramList.get(i) instanceof stSimpleMetaFeed))
        {
          stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.get(i);
          uru localuru = new uru();
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
          {
            urv.a(localstSimpleMetaFeed);
            urv.a(BaseApplicationImpl.getContext(), localstSimpleMetaFeed, paramString);
            localuru.a(urv.a(localstSimpleMetaFeed));
          }
          localuru.a(localstSimpleMetaFeed);
          localArrayList.add(localuru);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.c = "";
    this.b = "";
    jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, List<uru> paramList, ure paramure, Object paramObject)
  {
    upe.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][fetchVerticalListData] scene:" + paramInt + ", isRefresh:" + paramBoolean1 + ", isFirst:" + paramBoolean2 + ", from:" + paramString + ", attachInfo:" + this.c + ", lastSession" + this.b + ", gdtArgs:" + jdField_a_of_type_JavaLangString);
    a(paramString, paramBoolean2, paramure);
    paramList = a(paramBoolean2, paramList, paramString);
    String str = a(paramBoolean2);
    paramure = new uro(this, System.currentTimeMillis(), paramBoolean2, paramBoolean1, paramure, paramObject, paramString);
    byte b1;
    if (paramBoolean1)
    {
      paramString = "";
      if (!paramBoolean1) {
        break label224;
      }
      b1 = 1;
      label157:
      if (!paramBoolean2) {
        break label230;
      }
    }
    label224:
    label230:
    for (byte b2 = 1;; b2 = 0)
    {
      paramString = new uju(new unx(paramString, b1, b2, paramList, paramInt, jdField_a_of_type_JavaLangString, "", this.b, str), null, paramure, 1001);
      ujn.a().a(paramString);
      return;
      paramString = this.c;
      break;
      b1 = 0;
      break label157;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager
 * JD-Core Version:    0.7.0.1
 */