package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import abrl;
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
import plv;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import ulf;
import umu;
import uqz;
import urc;
import urg;
import urj;
import uvo;
import uvw;
import uwt;
import uya;
import uyo;
import vaa;
import vak;
import val;
import vam;
import van;
import vao;
import vap;
import vaq;
import var;
import vdc;

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
    return vap.a();
  }
  
  private String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return "";
    }
    WSRedDotPushMsg localWSRedDotPushMsg = uyo.a();
    plv localplv = uyo.a();
    if (localplv != null) {
      localplv.a(null);
    }
    if (localWSRedDotPushMsg == null) {
      return "";
    }
    return localWSRedDotPushMsg.mMsgData;
  }
  
  private ArrayList<String> a(boolean paramBoolean, List<vaq> paramList, String paramString)
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
          paramString = (vaq)paramList.next();
          if ((paramString != null) && ((paramString.a() instanceof stSimpleMetaFeed))) {
            localArrayList.add(((stSimpleMetaFeed)paramString.a()).id);
          }
        }
      }
    }
  }
  
  private void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, vaa paramvaa, int paramInt)
  {
    if ((paramvaa instanceof vdc))
    {
      paramvaa = ((vdc)paramvaa).a();
      if (!(paramvaa instanceof WSVerticalPageFragment)) {
        break label82;
      }
    }
    label82:
    for (paramvaa = (WSVerticalPageFragment)paramvaa;; paramvaa = null)
    {
      if ((paramvaa != null) && (paramvaa.getActivity() != null))
      {
        if (!paramvaa.getActivity().isFinishing()) {
          umu.a().a(paramInt, paramstSimpleGetFeedListRsp.config);
        }
        if (TextUtils.equals(paramvaa.a(), "aio_home_page")) {
          umu.a().b(paramstSimpleGetFeedListRsp.config);
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
        abrl.d("WSVerticalDataManagerLog", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSVerticalDataManager.5());
      return;
      jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, vaa paramvaa)
  {
    if ((!paramBoolean) || (!TextUtils.equals(paramString, "aio_home_page"))) {
      return;
    }
    paramString = uyo.a();
    if (paramString != null)
    {
      a(paramvaa, paramString);
      return;
    }
    a(paramvaa);
  }
  
  private void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if (CollectionUtils.isEmpty(paramArrayList)) {}
    plv localplv;
    do
    {
      return;
      plv.b((stSimpleMetaFeed)paramArrayList.get(0));
      paramArrayList = a(paramArrayList);
      localplv = uyo.a();
    } while ((localplv == null) || (paramArrayList == null));
    uya.a("WSVerticalDataManagerLog", "saveLastFeedInfo");
    localplv.a(paramArrayList);
  }
  
  private void a(urj paramurj, boolean paramBoolean1, vaa paramvaa, boolean paramBoolean2, Object paramObject, Subscriber<? super vao> paramSubscriber, String paramString, long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    uya.a("weishi-beacon", "请求播放页（推荐)耗时：" + paramLong + "毫秒");
    uvw.a().a(paramLong, paramurj.jdField_a_of_type_Urg, "fullscreen_videoplay", paramBoolean1);
    if (!paramurj.a())
    {
      uya.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramurj.jdField_a_of_type_Int + ", msg:" + paramurj.jdField_a_of_type_JavaLangString);
      paramSubscriber.onError(new WSVerticalDataManager.ResponseThrowable(paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString));
      uvw.a().a(paramLong, paramurj.jdField_a_of_type_Urg, paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp))
    {
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramurj.jdField_a_of_type_JavaLangObject;
      if (paramBoolean1) {
        if (paramurj.jdField_a_of_type_Urg == null) {
          break label371;
        }
      }
      label371:
      for (int i = paramurj.jdField_a_of_type_Urg.b();; i = 2)
      {
        a(localstSimpleGetFeedListRsp, paramvaa, i);
        this.c = localstSimpleGetFeedListRsp.attach_info;
        this.b = localstSimpleGetFeedListRsp.session;
        a(localstSimpleGetFeedListRsp.gdt_args);
        if (paramurj.jdField_a_of_type_Uqz != null) {
          uvo.a().a(localstSimpleGetFeedListRsp.trace_id, paramurj.jdField_a_of_type_Uqz.a);
        }
        paramurj = localstSimpleGetFeedListRsp.feeds;
        a(paramurj);
        paramurj = a(paramurj, paramString, false);
        uya.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] itemDataList size:" + paramurj.size() + ", isRefresh:" + paramBoolean2 + ", isFirst:" + paramBoolean1 + ", mAttachInfo:" + this.c + ", mLastSession:" + this.b + ", gdtArgs:" + jdField_a_of_type_JavaLangString);
        paramSubscriber.onNext(new vao(paramurj, paramBoolean2, paramBoolean1, paramObject));
        return;
      }
    }
    uya.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    paramSubscriber.onError(new WSVerticalDataManager.ResponseThrowable(paramurj.jdField_a_of_type_Int, paramurj.jdField_a_of_type_JavaLangString));
    uvw.a().a(paramLong, paramurj.jdField_a_of_type_Urg, -1, "数据无法解析或为空");
  }
  
  private void a(urj paramurj, boolean paramBoolean1, boolean paramBoolean2, vaa paramvaa, Object paramObject, String paramString, long paramLong)
  {
    Observable.create(new van(this, paramurj, paramBoolean2, paramvaa, paramBoolean1, paramObject, paramString, paramLong)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new vam(this, paramvaa));
  }
  
  private void a(vaa paramvaa)
  {
    uya.a("WSVerticalDataManagerLog", "fetchVerticalListDataFromLocal");
    ulf.a().c(new val(this, paramvaa));
  }
  
  private void a(vaa paramvaa, WSRedDotPushMsg paramWSRedDotPushMsg)
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
    } while (paramvaa == null);
    paramvaa.a(a(Arrays.asList(new stSimpleMetaFeed[] { paramWSRedDotPushMsg })), false, true, null);
  }
  
  private String b()
  {
    plv localplv = uyo.a();
    String str = "";
    if (localplv != null) {
      str = localplv.c();
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
      abrl.d("WSVerticalDataManagerLog", "onResult", paramJSONObject1);
    }
  }
  
  public List<vaq> a(List paramList)
  {
    return a(paramList, "", false);
  }
  
  public List<vaq> a(List paramList, String paramString, boolean paramBoolean)
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
          if ((paramBoolean) && (i == paramList.size() - 1)) {
            localstSimpleMetaFeed.isLoop = true;
          }
          vaq localvaq = new vaq();
          if ((localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
          {
            var.a(localstSimpleMetaFeed);
            var.a(BaseApplicationImpl.getContext(), localstSimpleMetaFeed, paramString);
            localvaq.a(var.a(localstSimpleMetaFeed));
          }
          localvaq.a(localstSimpleMetaFeed);
          localArrayList.add(localvaq);
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
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, List<vaq> paramList, vaa paramvaa, Object paramObject)
  {
    uya.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][fetchVerticalListData] scene:" + paramInt + ", isRefresh:" + paramBoolean1 + ", isFirst:" + paramBoolean2 + ", from:" + paramString + ", attachInfo:" + this.c + ", lastSession" + this.b + ", gdtArgs:" + jdField_a_of_type_JavaLangString);
    a(paramString, paramBoolean2, paramvaa);
    paramList = a(paramBoolean2, paramList, paramString);
    String str = a(paramBoolean2);
    paramvaa = new vak(this, paramBoolean1, paramBoolean2, paramvaa, paramObject, paramString, System.currentTimeMillis());
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
      paramString = new urj(new uwt(paramString, b1, b2, paramList, paramInt, jdField_a_of_type_JavaLangString, "", this.b, str), null, paramvaa, 1001);
      urc.a().a(paramString);
      return;
      paramString = this.c;
      break;
      b1 = 0;
      break label162;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager
 * JD-Core Version:    0.7.0.1
 */