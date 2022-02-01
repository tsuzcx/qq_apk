package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJWebSearchUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyCapsuleView;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfBean;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyFeedsHeaderViewController
  extends HeaderViewController
  implements View.OnClickListener
{
  protected static int a;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#F1F3F6"));
  private static int jdField_b_of_type_Int = Color.parseColor("#47000000");
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyFeedsHeaderViewController.1(this);
  private ReadInJoyCapsuleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
  private IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new ReadInJoyFeedsHeaderViewController.6(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  protected UniteSearchHandler a;
  protected UniteSearchObserver a;
  HotWordSearchEntryDataModel jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
  protected String a;
  protected boolean a;
  private ReadInJoyCapsuleView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
  protected boolean b;
  private ReadInJoyCapsuleView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ReadInJoyFeedsHeaderViewController(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ReadInJoyFeedsHeaderViewController.2(this);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ReadInJoyFeedsHeaderViewController.4(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560313, null);
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131379277);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364385));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364384));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364383));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369689));
    a(a(ReadInJoyLogicEngine.a().a(0)));
    ((View)localObject).setOnClickListener(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    g();
    localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  private URLDrawable a(ChannelCoverInfo paramChannelCoverInfo, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    paramChannelCoverInfo = ((IPublicAccountGifPlayTimeHttpDownloader)QRoute.api(IPublicAccountGifPlayTimeHttpDownloader.class)).getPubURL(paramChannelCoverInfo.externalExposureBackgroundUrl);
    if (paramChannelCoverInfo == null) {
      return null;
    }
    paramChannelCoverInfo = URLDrawable.getDrawable(paramChannelCoverInfo, (URLDrawable.URLDrawableOptions)localObject);
    if ((paramChannelCoverInfo.getCurrDrawable() instanceof GifDrawable))
    {
      localObject = ((GifDrawable)paramChannelCoverInfo.getCurrDrawable()).getImage();
      if (paramBoolean) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramChannelCoverInfo.setIndividualPause(paramBoolean);
      ((AbstractGifImage)localObject).reset();
      return paramChannelCoverInfo;
    }
  }
  
  private static <T> Iterable<T> a(Iterable<T> paramIterable)
  {
    Object localObject = paramIterable;
    if (paramIterable == null) {
      localObject = Collections.emptyList();
    }
    return localObject;
  }
  
  private List<ChannelCoverInfo> a(List<ChannelCoverInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a(paramList).iterator();
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      if ((localChannelCoverInfo.isExternalExposure) && (((ReadInJoyHelper.m()) && (!ReadInJoyHelper.n())) || (localChannelCoverInfo.mChannelCoverId != 56)))
      {
        paramList = localChannelCoverInfo.externalExposureBackgroundUrl;
        if ((!TextUtils.isEmpty(paramList)) && (!TextUtils.equals(ReadInJoyHelper.e(localChannelCoverInfo.mChannelCoverId), paramList)))
        {
          if (localChannelCoverInfo.isExternalExposurePersist) {
            paramList = "";
          }
          ReadInJoyHelper.a(paramList, localChannelCoverInfo.mChannelCoverId);
          ReadInJoyHelper.a(localChannelCoverInfo.mChannelCoverId, false);
        }
        localArrayList.add(localChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  private void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    URLDrawable localURLDrawable = a(paramChannelCoverInfo, true);
    if (localURLDrawable == null) {
      return;
    }
    if (localURLDrawable.getStatus() == 1)
    {
      if ((localURLDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)localURLDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage = ((IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage)localAbstractGifImage);
          ((IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage)localAbstractGifImage).a(new ReadInJoyFeedsHeaderViewController.5(this, paramChannelCoverInfo));
        }
      }
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLImageView, localURLDrawable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramChannelCoverInfo);
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      return;
      localURLDrawable.startDownload();
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("is_pic", i);
        a(paramString, localJSONObject);
        return;
      }
      catch (JSONException paramString)
      {
        throw new IllegalArgumentException("fail to construct json object");
      }
    }
  }
  
  private void a(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    Iterator localIterator = paramList.iterator();
    label170:
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      ReadInJoyCapsuleView localReadInJoyCapsuleView;
      if (localChannelCoverInfo.mChannelCoverId == 56)
      {
        localReadInJoyCapsuleView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
        paramList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
      }
      for (;;)
      {
        if (localReadInJoyCapsuleView == null) {
          break label170;
        }
        localReadInJoyCapsuleView.setVisibility(0);
        localReadInJoyCapsuleView.setText(localChannelCoverInfo.mChannelCoverName);
        paramList.a(localChannelCoverInfo, this);
        break;
        if (localChannelCoverInfo.mChannelCoverId == 1000000)
        {
          localReadInJoyCapsuleView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
          paramList = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
        }
        else if (localChannelCoverInfo.mChannelCoverId == 2000000)
        {
          a(localChannelCoverInfo);
          paramList = null;
          localReadInJoyCapsuleView = null;
        }
        else
        {
          localReadInJoyCapsuleView = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
          paramList = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
        }
      }
    }
  }
  
  private static int b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 56: 
        return 2130843120;
      }
      return 2130843117;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 56: 
      return 2130843119;
    }
    return 2130843116;
  }
  
  public void a()
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "reportExposure");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a() != null) {
      a("0X8008B88", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a());
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a() != null) {
      a("0X8008B89", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a());
    }
  }
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.b();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.b();
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.b();
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage.a();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      AbstractGifImage.resumeAll();
      return;
      f();
    }
  }
  
  public void d() {}
  
  protected void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() == 0)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size();
    this.jdField_a_of_type_JavaLangString = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.get(jdField_a_of_type_Int % i)).title;
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379277)).setText(this.jdField_a_of_type_JavaLangString);
    jdField_a_of_type_Int += 1;
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!TextUtils.isEmpty(ReadInjoySearchJumpurlConfProcessor.a().jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(localQQAppInterface, 1, 6, false);
      ThreadManager.post(new ReadInJoyFeedsHeaderViewController.3(this, localQQAppInterface), 5, null, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131379277: 
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() > 0) && (jdField_a_of_type_Int > 0)) {
        i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size();
      }
      break;
    }
    for (Object localObject = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.get((jdField_a_of_type_Int - 1) % i);; localObject = null)
    {
      RIJWebSearchUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, (HotWordSearchEntryDataModel.HotSearchItem)localObject);
      UniteSearchReportController.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("active_search").ver1(this.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + UniteSearchReportController.b + "}"));
      break;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_key_ariticle_id", Long.valueOf(((ChannelCoverInfo)localObject).mArticleId));
      localHashMap.put("param_key_channel_cover_style", Integer.valueOf(((ChannelCoverInfo)localObject).mChannelCoverStyle));
      ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, ((ChannelCoverInfo)localObject).mChannelCoverId, ((ChannelCoverInfo)localObject).mChannelCoverName, ((ChannelCoverInfo)localObject).mChannelType, 4, localHashMap);
      a("0X8008B84", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a());
      break;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a();
      ViolaAccessHelper.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131712983), "https://kandian.qq.com/viola/bundle_hotTopic.js?v_bid=3256&statusColor=1", null);
      a("0X8008B85", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a());
      break;
      localObject = (ChannelCoverInfo)paramView.getTag();
      ReadInJoyUtils.a(paramView.getContext(), ((ChannelCoverInfo)localObject).mChannelJumpUrl);
      a("0X800920D", new JSONObject());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController
 * JD-Core Version:    0.7.0.1
 */