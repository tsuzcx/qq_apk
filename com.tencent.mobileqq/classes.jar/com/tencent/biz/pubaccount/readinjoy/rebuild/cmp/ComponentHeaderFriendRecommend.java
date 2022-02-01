package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;

public class ComponentHeaderFriendRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  RingAvatarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView;
  private List<Long> jdField_a_of_type_JavaUtilList = null;
  ReadInJoyHeadImageView[] jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ComponentHeaderFriendRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderFriendRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderFriendRecommend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (CmpCtxt.a(paramArticleInfo)))
    {
      str = paramArticleInfo.mSocialFeedInfo.c;
      paramArticleInfo = str;
      if (TextUtils.isEmpty(str)) {
        paramArticleInfo = "";
      }
    }
    for (;;)
    {
      return paramArticleInfo;
      try
      {
        str = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
        paramArticleInfo = str;
        if (!TextUtils.isEmpty(str)) {
          continue;
        }
        QLog.w("ComponentHeaderFriendRecommend", 1, "ReadInJoyHeader friend recommend description empty");
        return str;
      }
      catch (Exception paramArticleInfo)
      {
        for (;;)
        {
          paramArticleInfo.printStackTrace();
          str = null;
        }
      }
    }
  }
  
  private List<Long> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    ArrayList localArrayList1 = new ArrayList();
    if (localObject == null) {
      return localArrayList1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
    {
      localObject = new ArrayList(1);
      try
      {
        ((List)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSubscribeID)));
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return localObject;
      }
    }
    ArrayList localArrayList2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (c()))
    {
      localArrayList2 = new ArrayList(1);
      localArrayList2.add(Long.valueOf(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long));
      return localArrayList2;
    }
    if ((((ArticleInfo)localObject).mPackInfoObj != null) && (((ArticleInfo)localObject).mPackInfoObj.has())) {}
    try
    {
      localArrayList2.addAll(((articlesummary.FriendRecommendInfo)((ArticleInfo)localObject).mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      if (localArrayList2.isEmpty()) {
        QLog.w("ComponentHeaderFriendRecommend", 1, "ReadInJoyHeader friend recommend uin list empty");
      }
      return localArrayList2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
      localJSONObject.put("feeds_source", paramString);
      localJSONObject.put("kandian_mode", RIJAppSetting.a());
      String str = RIJFeedsType.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a());
      if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e())) {}
      for (paramString = "0X8009357";; paramString = "0X800744D")
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", localJSONObject.toString(), false);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(List<Long> paramList)
  {
    if ((paramList != null) && (paramList.size() == 1))
    {
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) && (!c())) {
        setOnClickListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(RIJStringUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSubscribeName));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(((Long)paramList.get(0)).longValue());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (c()))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    setOnClickListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private String b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) && (!c())) {
      return null;
    }
    if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.d)) {
      return paramArticleInfo.mSocialFeedInfo.d;
    }
    int i = paramArticleInfo.mSocialFeedInfo.e;
    if (i > 0) {
      return ReadInJoyTimeUtils.a(i, true);
    }
    return HardCodeUtil.a(2131702329);
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
    {
      String str = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2);
      ReadInJoyUtils.a(getContext(), str);
    }
    for (;;)
    {
      a(RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
      return;
      a(paramLong);
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a() == null) {
      return false;
    }
    return CmpCtxt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (c()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSocialFeedInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject).d)))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((SocializeFeedsInfo)localObject).d);
        return;
      }
      localObject = b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a());
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560255, this, true);
  }
  
  public void a(long paramLong)
  {
    String str1 = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    ReadInJoyUtils.a(getContext(), str1);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.a = localArticleInfo;
    String str2 = RIJTransMergeKanDianReport.a("1", localArticleInfo, paramLong);
    if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e())) {}
    for (str1 = "0X800935C"; CmpCtxt.a(localArticleInfo); str1 = "0X8007BA3")
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mFeedId), "0", "" + localArticleInfo.mStrategyId, str2, false);
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, localArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mArticleID), "" + localArticleInfo.mStrategyId, str2, false);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (RIJQQAppInterfaceUtil.a())
    {
      List localList = a();
      if ((localList.size() > 0) && (localList.contains(Long.valueOf(paramLong))))
      {
        int i = localList.indexOf(Long.valueOf(paramLong));
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376526));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376530));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = new ReadInJoyHeadImageView[4];
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[0] = ((ReadInJoyHeadImageView)findViewById(2131376513));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[1] = ((ReadInJoyHeadImageView)findViewById(2131376514));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[2] = ((ReadInJoyHeadImageView)findViewById(2131376515));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[3] = ((ReadInJoyHeadImageView)findViewById(2131376516));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131376529));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376523));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376520));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376528));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364011));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)findViewById(2131376480));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369821));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (b()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if (b())
      {
        this.jdField_a_of_type_JavaUtilList = a();
        a(paramIReadInJoyModel, this.jdField_a_of_type_JavaUtilList);
        a(this.jdField_a_of_type_JavaUtilList);
        UtilsForComponent.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView, this.jdField_b_of_type_AndroidWidgetImageView);
        d();
        setFollowBotton();
      }
      return;
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < Math.min(4, paramList.size()))
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setHeadImgByUin(((Long)paramList.get(i)).longValue());
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setOnClickListener(new ComponentHeaderFriendRecommend.1(this, paramList, i));
        i += 1;
      }
      i = Math.min(4, paramList.size());
      while (i < 4)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[i].setOnClickListener(null);
        i += 1;
      }
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void b()
  {
    super.b();
    Object localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.i()) || (c()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), AIOUtils.a(15.0F, getResources()), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), AIOUtils.a(12.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), AIOUtils.a(15.0F, getResources()), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 48;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)findViewById(2131376525);
      if ((((LinearLayout)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        if (!a()) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.a(12.0F), 0, ViewUtils.a(12.0F), 0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), AIOUtils.a(7.5F, getResources()), this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), AIOUtils.a(7.5F, getResources()));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), AIOUtils.a(7.5F, getResources()), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    ((RelativeLayout.LayoutParams)localObject).setMargins(ViewUtils.a(12.0F), 0, ViewUtils.a(2.25F), 0);
  }
  
  public boolean b()
  {
    IReadInJoyModel localIReadInJoyModel = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a;
    return (localIReadInJoyModel.a()) && ((localIReadInJoyModel.c() == 2) || (localIReadInJoyModel.c() == 3));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (paramView == this)
      {
        localObject = a();
        if ((localObject != null) && (((List)localObject).size() == 1)) {
          b(((Long)((List)localObject).get(0)).longValue());
        }
      }
    case 2131376529: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = a();
        if ((localObject != null) && (((List)localObject).size() == 1)) {
          b(((Long)((List)localObject).get(0)).longValue());
        }
      }
    }
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    ArticleInfo localArticleInfo;
    if (localAppRuntime != null)
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      if (!ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e())) {
        break label265;
      }
    }
    label265:
    for (Object localObject = "0X800941D";; localObject = "0X80080EC")
    {
      RIJFrameworkReportManager.a(localArticleInfo, (String)localObject, (String)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      ReadInJoyLogicEngine.d(localArticleInfo);
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null))
      {
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        ReadInJoyLogicEngine.a().a().a(localAppRuntime.getAccount(), String.valueOf(l), true, "", new ComponentHeaderFriendRecommend.2(this, localArticleInfo));
      }
      c();
      break;
    }
  }
  
  public void setFollowBotton()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    if (localArticleInfo == null) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    if (localSocializeFeedsInfo.h == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702358));
      return;
    }
    if ((localArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.h == 2))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702394));
      this.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend
 * JD-Core Version:    0.7.0.1
 */