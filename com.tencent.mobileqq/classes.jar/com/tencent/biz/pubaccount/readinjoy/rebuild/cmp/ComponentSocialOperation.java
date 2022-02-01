package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentSocialOperation
  extends FrameLayout
  implements View.OnClickListener, ComponentView
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  SocializeFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  ScaleAnimation jdField_b_of_type_AndroidViewAnimationScaleAnimation;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  int jdField_c_of_type_Int = 0;
  ScaleAnimation jdField_c_of_type_AndroidViewAnimationScaleAnimation;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public ComponentSocialOperation(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    if (paramInt < 100000000)
    {
      paramInt /= 10000;
      return paramInt + HardCodeUtil.a(2131702337);
    }
    paramInt /= 100000000;
    return paramInt + HardCodeUtil.a(2131702303);
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, ReportInfo paramReportInfo)
  {
    ReportInfo.FeedsReportData localFeedsReportData = new ReportInfo.FeedsReportData();
    paramReportInfo.mUin = ReadInJoyUtils.a();
    paramReportInfo.mSource = 0;
    paramReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    paramReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
    paramReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    paramReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    paramReportInfo.mServerContext = paramArticleInfo.mServerContext;
    paramReportInfo.mReadTimeLength = -1;
    localFeedsReportData.jdField_a_of_type_Long = paramSocializeFeedsInfo.jdField_a_of_type_Long;
    if (paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
      localFeedsReportData.jdField_b_of_type_Long = paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
    }
    localFeedsReportData.jdField_a_of_type_Int = paramSocializeFeedsInfo.jdField_b_of_type_Int;
    localFeedsReportData.jdField_b_of_type_Int = paramSocializeFeedsInfo.d;
    paramArticleInfo = paramSocializeFeedsInfo.jdField_a_of_type_JavaUtilList;
    if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
    {
      localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        paramSocializeFeedsInfo = (SocializeFeedsInfo.FeedsInfoUser)paramArticleInfo.next();
        if (paramSocializeFeedsInfo != null) {
          localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long));
        }
      }
    }
    paramReportInfo.mFeedsReportData = localFeedsReportData;
    paramArticleInfo = new ArrayList();
    paramArticleInfo.add(paramReportInfo);
    ReadInJoyLogicEngine.a().a(paramArticleInfo);
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    String str;
    Intent localIntent;
    if (ReadinjoyReportUtils.a(paramArticleInfo.mChannelID))
    {
      str = "0X8009361";
      Object localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        localIntent = new Intent((Context)localObject, ReadInJoyDeliverBiuActivity.class);
        localIntent.putExtra("arg_article_info", paramArticleInfo);
        localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e() != 70) {
          break label233;
        }
        localIntent.putExtra("biu_src", 9);
        localIntent.putExtra("arg_from_type", 14);
        label106:
        ((Activity)localObject).startActivity(localIntent);
        ((Activity)localObject).overridePendingTransition(0, 0);
      }
      if (!a(paramArticleInfo)) {
        break label254;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      RIJFrameworkReportManager.b(paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
    }
    for (;;)
    {
      paramReportInfo.mOperation = 25;
      return;
      str = "0X8007EE4";
      break;
      label233:
      localIntent.putExtra("biu_src", 1);
      localIntent.putExtra("arg_from_type", 1);
      break label106;
      label254:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
    }
  }
  
  private boolean a(@NotNull ArticleInfo paramArticleInfo)
  {
    return (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo));
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    boolean bool = ReadinjoyReportUtils.a(paramArticleInfo.mChannelID);
    String str1;
    String str2;
    if (bool)
    {
      str1 = "0X800935E";
      if (!bool) {
        break label245;
      }
      str2 = "0X800935F";
      label29:
      if (this.jdField_a_of_type_Boolean) {
        break label253;
      }
      bool = true;
      label39:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label326;
      }
      if (!a(paramArticleInfo)) {
        break label259;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      RIJFrameworkReportManager.b(paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      label149:
      paramReportInfo.mOperation = 2;
      if (!this.jdField_a_of_type_Boolean) {
        break label500;
      }
      i = this.jdField_a_of_type_Int + 1;
      label170:
      this.jdField_a_of_type_Int = i;
      a(true);
      paramString = paramArticleInfo.mSocialFeedInfo;
      if (!this.jdField_a_of_type_Boolean) {
        break label511;
      }
    }
    label245:
    label253:
    label511:
    for (int i = 1;; i = 0)
    {
      paramString.jdField_c_of_type_Int = i;
      paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramArticleInfo = paramArticleInfo.clone();
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), paramSocializeFeedsInfo.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramArticleInfo);
      return;
      str1 = "0X8007B65";
      break;
      str2 = "0X8007B66";
      break label29;
      bool = false;
      break label39;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
      break label149;
      if (a(paramArticleInfo))
      {
        if (!RIJItemViewType.o(paramArticleInfo)) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), str2, str2, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
        }
        RIJFrameworkReportManager.b(paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      }
      for (;;)
      {
        paramReportInfo.mOperation = 13;
        break;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, str2, str2, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      i = this.jdField_a_of_type_Int - 1;
      break label170;
    }
  }
  
  private void c(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    String str;
    if (ReadinjoyReportUtils.a(paramArticleInfo.mChannelID))
    {
      str = "0X8009360";
      if (!a(paramArticleInfo)) {
        break label157;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      RIJFrameworkReportManager.b(paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
    }
    for (;;)
    {
      paramReportInfo.mOperation = 3;
      if (!RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a())) {
        break label224;
      }
      RIJJumpUtils.a(getContext(), paramArticleInfo, 1, true, 0, true);
      return;
      str = "0X8007B67";
      break;
      label157:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
    }
    label224:
    RIJJumpUtils.a(getContext(), paramArticleInfo, true);
  }
  
  @VisibleForTesting
  @NotNull
  String a(ArticleInfo paramArticleInfo, SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
        if (RIJItemViewType.a(paramArticleInfo))
        {
          localJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
          localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
          localJSONObject.put("feeds_type", "" + RIJFeedsType.a(paramArticleInfo));
          localJSONObject.put("kandian_mode", "" + RIJAppSetting.a());
          localJSONObject.put("tab_source", "" + RIJTransMergeKanDianReport.a());
          localJSONObject.put("channel_id", "" + paramArticleInfo.mChannelID);
          localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
          if (paramArticleInfo.isPGCShortContent())
          {
            paramArticleInfo = "1";
            localJSONObject.put("content_source", paramArticleInfo);
            return localJSONObject.toString();
          }
        }
        else
        {
          localJSONObject.put("feeds_source", paramSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
          continue;
        }
        paramArticleInfo = "0";
      }
      catch (JSONException paramArticleInfo)
      {
        QLog.e("ComponentSocialOperation", 1, QLog.getStackTraceString(paramArticleInfo));
        return "";
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560265, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131365105));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131381015));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131381014));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131381013);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363729));
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.8F, 1.0F, 1.8F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.8F, 0.85F, 1.8F, 0.85F, 1, 0.5F, 1, 0.5F);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.85F, 1.0F, 0.85F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new ComponentSocialOperation.1(this));
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new ComponentSocialOperation.2(this));
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new ComponentSocialOperation.3(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramObject.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.d;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_c_of_type_Int != 1) {
        break label113;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.f;
      a(false);
      return;
      label113:
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
      if (this.jdField_b_of_type_Int <= 0) {
        break label200;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int <= 0) {
        break label213;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_c_of_type_Int));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846730);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#07D0B0"));
        label88:
        if (this.jdField_a_of_type_Int <= 0) {
          break label187;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Int));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label198;
        }
        QLog.d("ComponentSocialOperation", 2, "set upvote to " + this.jdField_a_of_type_Boolean + ", set num:" + this.jdField_a_of_type_Int);
        break;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846733);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        break label88;
        label187:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718426);
      }
      label198:
      break;
      label200:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718131);
    }
    label213:
    this.jdField_c_of_type_AndroidWidgetTextView.setText("Biu");
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    SocializeFeedsInfo localSocializeFeedsInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
    if ((localArticleInfo == null) || (localSocializeFeedsInfo == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str = a(localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentSocialOperation", 2, "onclick v:" + paramView.getId());
    }
    RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
    ReportInfo localReportInfo = new ReportInfo();
    if (paramView.getId() == 2131365105) {
      c(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
    }
    for (;;)
    {
      a(localArticleInfo, localSocializeFeedsInfo, localReportInfo);
      break;
      if (paramView.getId() == 2131381013) {
        b(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
      } else if (paramView.getId() == 2131363729) {
        a(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation
 * JD-Core Version:    0.7.0.1
 */