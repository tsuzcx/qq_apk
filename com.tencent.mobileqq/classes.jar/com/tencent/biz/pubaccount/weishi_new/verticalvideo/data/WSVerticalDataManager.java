package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import acvc;
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
import pgj;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uep;
import ugd;
import uke;
import ukh;
import ukl;
import uko;
import unu;
import uoy;
import uqf;
import uqt;
import usf;
import usp;
import usq;
import usr;
import uss;
import ust;
import usu;
import usv;
import usw;
import uvh;

public class WSVerticalDataManager
{
  private static String a;
  private volatile String b = "";
  private volatile String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  private stSimpleMetaFeed a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    Object localObject = null;
    int i = 0;
    if (i < paramArrayList.size())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.get(i);
      if (localstSimpleMetaFeed.video_type == 2) {}
      do
      {
        i += 1;
        break;
        localObject = localstSimpleMetaFeed;
      } while (TextUtils.isEmpty(localstSimpleMetaFeed.feed_desc));
      return localstSimpleMetaFeed;
    }
    return localObject;
  }
  
  public static WSVerticalDataManager a()
  {
    return usu.a();
  }
  
  private String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return "";
    }
    WSRedDotPushMsg localWSRedDotPushMsg = uqt.a();
    pgj localpgj = uqt.a();
    if (localpgj != null) {
      localpgj.a(null);
    }
    if (localWSRedDotPushMsg == null) {
      return "";
    }
    return localWSRedDotPushMsg.mMsgData;
  }
  
  private ArrayList<String> a(boolean paramBoolean, List<usv> paramList, String paramString)
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
          paramString = (usv)paramList.next();
          if ((paramString != null) && ((paramString.a() instanceof stSimpleMetaFeed))) {
            localArrayList.add(((stSimpleMetaFeed)paramString.a()).id);
          }
        }
      }
    }
  }
  
  private void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, usf paramusf, int paramInt)
  {
    if ((paramusf instanceof uvh))
    {
      paramusf = ((uvh)paramusf).a();
      if (!(paramusf instanceof WSVerticalPageFragment)) {
        break label82;
      }
    }
    label82:
    for (paramusf = (WSVerticalPageFragment)paramusf;; paramusf = null)
    {
      if ((paramusf != null) && (paramusf.getActivity() != null))
      {
        if (!paramusf.getActivity().isFinishing()) {
          ugd.a().a(paramInt, paramstSimpleGetFeedListRsp.config);
        }
        if (TextUtils.equals(paramusf.a(), "aio_home_page")) {
          ugd.a().b(paramstSimpleGetFeedListRsp.config);
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
        acvc.d("WSVerticalDataManagerLog", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSVerticalDataManager.5());
      return;
      jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, usf paramusf)
  {
    if ((!paramBoolean) || (!TextUtils.equals(paramString, "aio_home_page"))) {
      return;
    }
    paramString = uqt.a();
    if (paramString != null)
    {
      a(paramusf, paramString);
      return;
    }
    a(paramusf);
  }
  
  private void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if (CollectionUtils.isEmpty(paramArrayList)) {}
    pgj localpgj;
    do
    {
      return;
      pgj.b((stSimpleMetaFeed)paramArrayList.get(0));
      paramArrayList = a(paramArrayList);
      localpgj = uqt.a();
    } while ((localpgj == null) || (paramArrayList == null));
    uqf.a("WSVerticalDataManagerLog", "saveLastFeedInfo");
    localpgj.a(paramArrayList);
  }
  
  private void a(uko paramuko, boolean paramBoolean1, usf paramusf, boolean paramBoolean2, Object paramObject, Subscriber<? super ust> paramSubscriber, String paramString)
  {
    if (!paramuko.a())
    {
      uqf.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramuko.jdField_a_of_type_Int + ", msg:" + paramuko.jdField_a_of_type_JavaLangString);
      paramSubscriber.onError(new WSVerticalDataManager.ResponseThrowable(paramuko.jdField_a_of_type_Int, paramuko.jdField_a_of_type_JavaLangString));
      return;
    }
    if ((paramuko.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp))
    {
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramuko.jdField_a_of_type_JavaLangObject;
      if (paramBoolean1) {
        if (paramuko.jdField_a_of_type_Ukl == null) {
          break label293;
        }
      }
      label293:
      for (int i = paramuko.jdField_a_of_type_Ukl.b();; i = 2)
      {
        a(localstSimpleGetFeedListRsp, paramusf, i);
        this.c = localstSimpleGetFeedListRsp.attach_info;
        this.b = localstSimpleGetFeedListRsp.session;
        a(localstSimpleGetFeedListRsp.gdt_args);
        if (paramuko.jdField_a_of_type_Uke != null) {
          unu.a().a(localstSimpleGetFeedListRsp.trace_id, paramuko.jdField_a_of_type_Uke.a);
        }
        paramuko = localstSimpleGetFeedListRsp.feeds;
        a(paramuko);
        paramuko = a(paramuko, paramString);
        uqf.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] itemDataList size:" + paramuko.size() + ", isRefresh:" + paramBoolean2 + ", isFirst:" + paramBoolean1 + ", mAttachInfo:" + this.c + ", mLastSession:" + this.b + ", gdtArgs:" + jdField_a_of_type_JavaLangString);
        paramSubscriber.onNext(new ust(paramuko, paramBoolean2, paramBoolean1, paramObject));
        return;
      }
    }
    uqf.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    paramSubscriber.onError(new WSVerticalDataManager.ResponseThrowable(paramuko.jdField_a_of_type_Int, paramuko.jdField_a_of_type_JavaLangString));
  }
  
  private void a(uko paramuko, boolean paramBoolean1, boolean paramBoolean2, usf paramusf, Object paramObject, String paramString)
  {
    Observable.create(new uss(this, paramuko, paramBoolean2, paramusf, paramBoolean1, paramObject, paramString)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new usr(this, paramusf));
  }
  
  private void a(usf paramusf)
  {
    uqf.a("WSVerticalDataManagerLog", "fetchVerticalListDataFromLocal");
    uep.a().c(new usq(this, paramusf));
  }
  
  private void a(usf paramusf, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    IWSPushBaseStrategy localIWSPushBaseStrategy = paramWSRedDotPushMsg.mStrategyInfo;
    if (TextUtils.isEmpty(paramWSRedDotPushMsg.mFeedIds)) {}
    do
    {
      do
      {
        return;
      } while ((localIWSPushBaseStrategy == null) || (localIWSPushBaseStrategy.getType() == 2) || (((WSPushStrategyInfo)localIWSPushBaseStrategy).mWSPushVideoModel == null) || (TextUtils.isEmpty(((WSPushStrategyInfo)localIWSPushBaseStrategy).mWSPushVideoModel.jdField_a_of_type_JavaLangString)));
      paramWSRedDotPushMsg = ((WSPushStrategyInfo)localIWSPushBaseStrategy).mWSPushVideoModel.a(paramWSRedDotPushMsg.mFeedIds);
    } while (paramusf == null);
    paramusf.a(a(Arrays.asList(new stSimpleMetaFeed[] { paramWSRedDotPushMsg })), false, true, null);
  }
  
  private String b()
  {
    pgj localpgj = uqt.a();
    String str = "";
    if (localpgj != null) {
      str = localpgj.c();
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
      acvc.d("WSVerticalDataManagerLog", "onResult", paramJSONObject1);
    }
  }
  
  public List<usv> a(List paramList)
  {
    return a(paramList, "");
  }
  
  public List<usv> a(List paramList, String paramString)
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
          usv localusv = new usv();
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
          {
            usw.a(localstSimpleMetaFeed);
            usw.a(BaseApplicationImpl.getContext(), localstSimpleMetaFeed, paramString);
            localusv.a(usw.a(localstSimpleMetaFeed));
          }
          localusv.a(localstSimpleMetaFeed);
          localArrayList.add(localusv);
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
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, List<usv> paramList, usf paramusf, Object paramObject)
  {
    uqf.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][fetchVerticalListData] scene:" + paramInt + ", isRefresh:" + paramBoolean1 + ", isFirst:" + paramBoolean2 + ", from:" + paramString + ", attachInfo:" + this.c + ", lastSession" + this.b + ", gdtArgs:" + jdField_a_of_type_JavaLangString);
    a(paramString, paramBoolean2, paramusf);
    paramList = a(paramBoolean2, paramList, paramString);
    String str = a(paramBoolean2);
    paramusf = new usp(this, System.currentTimeMillis(), paramBoolean2, paramBoolean1, paramusf, paramObject, paramString);
    a("");
    byte b1;
    if (paramBoolean1)
    {
      paramString = "";
      if (!paramBoolean1) {
        break label229;
      }
      b1 = 1;
      label162:
      if (!paramBoolean2) {
        break label235;
      }
    }
    label229:
    label235:
    for (byte b2 = 1;; b2 = 0)
    {
      paramString = new uko(new uoy(paramString, b1, b2, paramList, paramInt, jdField_a_of_type_JavaLangString, "", this.b, str), null, paramusf, 1001);
      ukh.a().a(paramString);
      return;
      paramString = this.c;
      break;
      b1 = 0;
      break label162;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager
 * JD-Core Version:    0.7.0.1
 */