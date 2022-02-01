package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import acho;
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
import pws;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uzf;
import vau;
import vfh;
import vfk;
import vfo;
import vfr;
import vkc;
import vkk;
import vli;
import vmg;
import vmp;
import vnd;
import vos;
import vpd;
import vpe;
import vpf;
import vpg;
import vph;
import vpi;
import vpj;
import vpk;
import vrx;

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
    return vpi.a();
  }
  
  private String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return "";
    }
    WSRedDotPushMsg localWSRedDotPushMsg = vnd.a();
    pws localpws = vnd.a();
    if (localpws != null) {
      localpws.a(null);
    }
    if (localWSRedDotPushMsg == null) {
      return "";
    }
    return localWSRedDotPushMsg.mMsgData;
  }
  
  private ArrayList<String> a(boolean paramBoolean, List<vpj> paramList, String paramString)
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
          paramString = (vpj)paramList.next();
          if ((paramString != null) && ((paramString.a() instanceof stSimpleMetaFeed))) {
            localArrayList.add(((stSimpleMetaFeed)paramString.a()).id);
          }
        }
      }
    }
  }
  
  private void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, vos paramvos, int paramInt)
  {
    if ((paramvos instanceof vrx))
    {
      paramvos = ((vrx)paramvos).a();
      if (!(paramvos instanceof WSVerticalPageFragment)) {
        break label82;
      }
    }
    label82:
    for (paramvos = (WSVerticalPageFragment)paramvos;; paramvos = null)
    {
      if ((paramvos != null) && (paramvos.getActivity() != null))
      {
        if (!paramvos.getActivity().isFinishing()) {
          vau.a().a(paramInt, paramstSimpleGetFeedListRsp.config);
        }
        if (TextUtils.equals(paramvos.a(), "aio_home_page")) {
          vau.a().b(paramstSimpleGetFeedListRsp.config);
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
        acho.d("WSVerticalDataManagerLog", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSVerticalDataManager.5());
      return;
      jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, vos paramvos)
  {
    if ((!paramBoolean) || (!TextUtils.equals(paramString, "aio_home_page"))) {
      return;
    }
    paramString = vnd.a();
    if (paramString != null)
    {
      a(paramvos, paramString);
      return;
    }
    a(paramvos);
  }
  
  private void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if (CollectionUtils.isEmpty(paramArrayList)) {}
    pws localpws;
    do
    {
      return;
      pws.b((stSimpleMetaFeed)paramArrayList.get(0));
      paramArrayList = vmg.a(paramArrayList);
      localpws = vnd.a();
    } while ((localpws == null) || (paramArrayList == null));
    vmp.a("WSVerticalDataManagerLog", "saveLastFeedInfo");
    localpws.a(paramArrayList);
  }
  
  private void a(vfr paramvfr, boolean paramBoolean1, vos paramvos, boolean paramBoolean2, Object paramObject, Subscriber<? super vph> paramSubscriber, String paramString, long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    vmp.a("weishi-beacon", "请求播放页（推荐)耗时：" + paramLong + "毫秒");
    vkk.a().a(paramLong, paramvfr.jdField_a_of_type_Vfo, "fullscreen_videoplay", paramBoolean1);
    if (!paramvfr.a())
    {
      vmp.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] failed code:" + paramvfr.jdField_a_of_type_Int + ", msg:" + paramvfr.jdField_a_of_type_JavaLangString);
      paramSubscriber.onError(new WSVerticalDataManager.ResponseThrowable(paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString));
      vkk.a().a(paramLong, paramvfr.jdField_a_of_type_Vfo, paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp))
    {
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = (stSimpleGetFeedListRsp)paramvfr.jdField_a_of_type_JavaLangObject;
      if (paramBoolean1) {
        if (paramvfr.jdField_a_of_type_Vfo == null) {
          break label381;
        }
      }
      label381:
      for (int i = paramvfr.jdField_a_of_type_Vfo.b();; i = 2)
      {
        a(localstSimpleGetFeedListRsp, paramvos, i);
        this.c = localstSimpleGetFeedListRsp.attach_info;
        this.b = localstSimpleGetFeedListRsp.session;
        if (!TextUtils.isEmpty(localstSimpleGetFeedListRsp.gdt_args)) {
          a(localstSimpleGetFeedListRsp.gdt_args);
        }
        if (paramvfr.jdField_a_of_type_Vfh != null) {
          vkc.a().a(localstSimpleGetFeedListRsp.trace_id, paramvfr.jdField_a_of_type_Vfh.a);
        }
        paramvfr = localstSimpleGetFeedListRsp.feeds;
        a(paramvfr);
        paramvfr = a(paramvfr, paramString, false);
        vmp.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] itemDataList size:" + paramvfr.size() + ", isRefresh:" + paramBoolean2 + ", isFirst:" + paramBoolean1 + ", mAttachInfo:" + this.c + ", mLastSession:" + this.b + ", gdtArgs:" + jdField_a_of_type_JavaLangString);
        paramSubscriber.onNext(new vph(paramvfr, paramBoolean2, paramBoolean1, paramObject));
        return;
      }
    }
    vmp.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    paramSubscriber.onError(new WSVerticalDataManager.ResponseThrowable(paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString));
    vkk.a().a(paramLong, paramvfr.jdField_a_of_type_Vfo, -1, "数据无法解析或为空");
  }
  
  private void a(vfr paramvfr, boolean paramBoolean1, boolean paramBoolean2, vos paramvos, Object paramObject, String paramString, long paramLong)
  {
    Observable.create(new vpg(this, paramvfr, paramBoolean2, paramvos, paramBoolean1, paramObject, paramString, paramLong)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new vpf(this, paramvos));
  }
  
  private void a(vos paramvos)
  {
    vmp.a("WSVerticalDataManagerLog", "fetchVerticalListDataFromLocal");
    uzf.a().c(new vpe(this, paramvos));
  }
  
  private void a(vos paramvos, WSRedDotPushMsg paramWSRedDotPushMsg)
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
    } while (paramvos == null);
    paramvos.a(a(Arrays.asList(new stSimpleMetaFeed[] { paramWSRedDotPushMsg })), false, true, null);
  }
  
  private String b()
  {
    pws localpws = vnd.a();
    String str = "";
    if (localpws != null) {
      str = localpws.c();
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
      acho.d("WSVerticalDataManagerLog", "onResult", paramJSONObject1);
    }
  }
  
  public List<vpj> a(List paramList)
  {
    return a(paramList, "", false);
  }
  
  public List<vpj> a(List paramList, String paramString, boolean paramBoolean)
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
          vpj localvpj = new vpj();
          if ((localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
          {
            vpk.a(localstSimpleMetaFeed);
            vpk.a(BaseApplicationImpl.getContext(), localstSimpleMetaFeed, paramString);
            localvpj.a(vpk.a(localstSimpleMetaFeed));
          }
          localvpj.a(localstSimpleMetaFeed);
          localArrayList.add(localvpj);
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
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, List<vpj> paramList, vos paramvos, Object paramObject)
  {
    vmp.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][fetchVerticalListData] scene:" + paramInt + ", isRefresh:" + paramBoolean1 + ", isFirst:" + paramBoolean2 + ", from:" + paramString + ", attachInfo:" + this.c + ", lastSession" + this.b + ", gdtArgs:" + jdField_a_of_type_JavaLangString);
    a(paramString, paramBoolean2, paramvos);
    paramList = a(paramBoolean2, paramList, paramString);
    String str = a(paramBoolean2);
    paramvos = new vpd(this, paramBoolean1, paramBoolean2, paramvos, paramObject, paramString, System.currentTimeMillis());
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
      paramString = new vfr(new vli(paramString, b1, b2, paramList, paramInt, jdField_a_of_type_JavaLangString, "", this.b, str), null, paramvos, 1001);
      vfk.a().a(paramString);
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