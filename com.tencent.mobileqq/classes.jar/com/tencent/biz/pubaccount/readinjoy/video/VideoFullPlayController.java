package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.VideoPlayRecommendObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.VideoCountDownView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoFullPlayController
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoPlayRecommendHandler jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler;
  private VideoPlayRecommendObserver jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver;
  private BaseVideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam;
  private IVideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoPlayManager;
  private VideoFullPlayController.OnFullPlayListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController$OnFullPlayListener;
  private VideoFullPlayController.RecommendDataAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController$RecommendDataAdapter;
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private List<VideoFullPlayController.FullPlayInfo> jdField_a_of_type_JavaUtilList;
  private Queue<BaseVideoPlayParam> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private BaseVideoPlayParam jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private BaseVideoPlayParam jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  VideoFullPlayController(Activity paramActivity, FrameLayout paramFrameLayout, VideoFullPlayController.RecommendDataAdapter paramRecommendDataAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController$RecommendDataAdapter = paramRecommendDataAdapter;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = ReadInJoyUtils.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)paramActivity.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver = new VideoFullPlayController.VideoRecommendObserver(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.getCurrentUin();
    }
  }
  
  private void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2)
  {
    if (((paramBaseVideoPlayParam1 instanceof VideoPlayManager.VideoPlayParam)) && ((paramBaseVideoPlayParam2 instanceof VideoPlayManager.VideoPlayParam)))
    {
      paramBaseVideoPlayParam1 = (VideoPlayManager.VideoPlayParam)paramBaseVideoPlayParam1;
      paramBaseVideoPlayParam2 = (VideoPlayManager.VideoPlayParam)paramBaseVideoPlayParam2;
    }
    try
    {
      paramBaseVideoPlayParam2 = paramBaseVideoPlayParam2.a;
      if (paramBaseVideoPlayParam2 != null)
      {
        paramBaseVideoPlayParam2.mChannelID = paramBaseVideoPlayParam1.a.mChannelID;
        paramBaseVideoPlayParam2.mRecommendTime = paramBaseVideoPlayParam1.a.mRecommendTime;
      }
      return;
    }
    catch (Throwable paramBaseVideoPlayParam1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + paramBaseVideoPlayParam1.getMessage());
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null, 0);
    }
  }
  
  private void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver);
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.jdField_a_of_type_Int = (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam);
  }
  
  private void j()
  {
    if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoPlayManager != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController$OnFullPlayListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController$OnFullPlayListener.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoPlayManager.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam = null;
    this.e = false;
  }
  
  public BaseVideoPlayParam a()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_c_of_type_Int);
  }
  
  public String a(String paramString)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoFullPlayController.FullPlayInfo localFullPlayInfo = (VideoFullPlayController.FullPlayInfo)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localFullPlayInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.a());
        localJSONObject2.put("playCount", localFullPlayInfo.jdField_a_of_type_Int);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    localJSONObject1.put("first_rowKey", paramString);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  public List<VideoFullPlayController.FullPlayInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam != null) {
      this.jdField_a_of_type_JavaUtilList.add(new VideoFullPlayController.FullPlayInfo(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam, this.jdField_d_of_type_Int));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "exitFullMode: ");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (!b()) {
      return;
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(paramInt);
      a(paramInt, System.currentTimeMillis());
      return;
    }
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam != null)
    {
      b();
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt <= 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    localMessage.obj = Long.valueOf(paramLong);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + paramBaseVideoPlayParam + " mVideoRootFrameLayout:" + this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).addObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver);
      }
      if ((paramBaseVideoPlayParam != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam = paramBaseVideoPlayParam;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(paramBaseVideoPlayParam.jdField_a_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          break label324;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseVideoPlayParam.jdField_b_of_type_JavaLangString, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      f();
      paramBaseVideoPlayParam = new VideoR5.Builder(null, null, paramBaseVideoPlayParam.c, paramBaseVideoPlayParam.a()).a((int)paramBaseVideoPlayParam.jdField_b_of_type_Long).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramBaseVideoPlayParam, false);
      return;
      bool = false;
      break;
      label324:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.b();
    }
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + paramBaseVideoPlayParam);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam = paramBaseVideoPlayParam;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam != null)
    {
      if (paramBaseVideoPlayParam.jdField_b_of_type_Long == 409409L) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (paramBaseVideoPlayParam.jdField_b_of_type_Long == 56L)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 2;
  }
  
  public void a(IVideoPlayManager paramIVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoPlayManager = paramIVideoPlayManager;
  }
  
  public void a(VideoFullPlayController.OnFullPlayListener paramOnFullPlayListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController$OnFullPlayListener = paramOnFullPlayListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
    h();
  }
  
  public void b(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + paramBaseVideoPlayParam);
    }
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam = paramBaseVideoPlayParam;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(paramBaseVideoPlayParam);
    if (!this.jdField_c_of_type_Boolean) {
      a(3);
    }
    i();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void e()
  {
    h();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler = null;
  }
  
  public void f()
  {
    BaseVideoPlayParam localBaseVideoPlayParam = (BaseVideoPlayParam)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localBaseVideoPlayParam == null)
    {
      g();
      return;
    }
    b(localBaseVideoPlayParam);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = System.currentTimeMillis() - ((Long)paramMessage.obj).longValue();
      if (l >= 1000L)
      {
        paramMessage.arg1 = ((int)(paramMessage.arg1 - l / 1000L));
        a(paramMessage.arg1);
      }
    }
    else
    {
      return true;
    }
    a(paramMessage.arg1, ((Long)paramMessage.obj).longValue());
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam != null)
      {
        String str = new VideoR5.Builder(null, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.c, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.a()).a((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.jdField_b_of_type_Long).a().a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController$OnFullPlayListener != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFullPlayController$OnFullPlayListener.j();
          continue;
          if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam != null)
          {
            str = new VideoR5.Builder(null, null, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.c, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.a()).a((int)this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.jdField_b_of_type_Long).i(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoBaseVideoPlayParam.a()).a().a();
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
            b();
            j();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFullPlayController
 * JD-Core Version:    0.7.0.1
 */