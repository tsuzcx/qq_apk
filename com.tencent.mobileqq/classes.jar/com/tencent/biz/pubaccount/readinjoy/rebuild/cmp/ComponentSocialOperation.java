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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
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
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lwn;
import lwp;
import lwq;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentSocialOperation
  extends FrameLayout
  implements View.OnClickListener, ComponentView
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  SocializeFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  public final String a;
  public boolean a;
  int b;
  public ScaleAnimation b;
  public TextView b;
  public ScaleAnimation c;
  TextView c;
  
  public ComponentSocialOperation(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "ComponentSocialOperation";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    b(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "ComponentSocialOperation";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    b(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "ComponentSocialOperation";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public String a(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    if (paramInt < 100000000)
    {
      paramInt /= 10000;
      return String.valueOf(paramInt) + "万";
    }
    paramInt /= 100000000;
    return String.valueOf(paramInt) + "亿";
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130969587, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131366849));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131367052));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131367051));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131367050);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131367053));
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.8F, 1.0F, 1.8F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.8F, 0.85F, 1.8F, 0.85F, 1, 0.5F, 1, 0.5F);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.85F, 1.0F, 0.85F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new lwn(this));
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new lwp(this));
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new lwq(this));
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
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.d;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.c == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      a(false);
      return;
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
      if (this.jdField_b_of_type_Int <= 0) {
        break label201;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.f <= 0) {
        break label213;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.f));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843369);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#07D0B0"));
        label94:
        if (this.jdField_a_of_type_Int <= 0) {
          break label189;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Int));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label199;
        }
        QLog.d("ComponentSocialOperation", 2, "set upvote to " + this.jdField_a_of_type_Boolean + ", set num:" + this.jdField_a_of_type_Int);
        break;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843372);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        break label94;
        label189:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131428487);
      }
      label199:
      break;
      label201:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131428488);
    }
    label213:
    this.jdField_c_of_type_AndroidWidgetTextView.setText("Biu");
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = "";
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.d);
        if (!ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          continue;
        }
        ((JSONObject)localObject2).put("feeds_source", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID);
        ((JSONObject)localObject2).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        ((JSONObject)localObject2).put("feeds_type", "" + ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
        ((JSONObject)localObject2).put("kandian_mode", "" + ReadInJoyUtils.e());
        ((JSONObject)localObject2).put("tab_source", "" + ReadInJoyUtils.d());
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        localJSONException.printStackTrace();
        continue;
        PublicAccountReportUtils.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, "0X8007B67", "0X8007B67", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "", (String)localObject1, false);
        continue;
        ReadInJoyUtils.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
        continue;
        if (paramView.getId() != 2131367050) {
          continue;
        }
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        boolean bool = true;
        this.jdField_a_of_type_Boolean = bool;
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        if ((!ReadInJoyBaseAdapter.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        if (ReadInJoyBaseAdapter.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          continue;
        }
        PublicAccountReportUtils.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007B65", "0X8007B65", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), "0", "", (String)localObject1, false);
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
        localJSONException.mOperation = 2;
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        int i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        a(true);
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo;
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        i = 1;
        paramView.c = i;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.clone();
        ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramView);
        continue;
        bool = false;
        continue;
        PublicAccountReportUtils.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, "0X8007B65", "0X8007B65", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "", (String)localObject1, false);
        continue;
        if ((!ReadInJoyBaseAdapter.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        if (ReadInJoyBaseAdapter.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          continue;
        }
        PublicAccountReportUtils.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007B66", "0X8007B66", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), "0", "", (String)localObject1, false);
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
        localJSONException.mOperation = 13;
        continue;
        PublicAccountReportUtils.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, "0X8007B66", "0X8007B66", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "", (String)localObject1, false);
        continue;
        i = this.jdField_a_of_type_Int - 1;
        continue;
        i = 0;
        continue;
        if (paramView.getId() != 2131367053) {
          continue;
        }
        paramView = getContext();
        if (!(paramView instanceof Activity)) {
          continue;
        }
        paramView = (Activity)paramView;
        Object localObject3 = new Intent(paramView, ReadInJoyDeliverBiuActivity.class);
        ((Intent)localObject3).putExtra("arg_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        ((Intent)localObject3).putExtra("feedsType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e() != 70) {
          continue;
        }
        ((Intent)localObject3).putExtra("biu_src", 9);
        ((Intent)localObject3).putExtra("arg_from_type", 14);
        paramView.startActivity((Intent)localObject3);
        paramView.overridePendingTransition(0, 0);
        if ((!ReadInJoyBaseAdapter.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        if (ReadInJoyBaseAdapter.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          continue;
        }
        PublicAccountReportUtils.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007EE4", "0X8007EE4", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), "0", "", (String)localObject1, false);
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
        localJSONException.mOperation = 25;
        continue;
        ((Intent)localObject3).putExtra("biu_src", 1);
        ((Intent)localObject3).putExtra("arg_from_type", 1);
        continue;
        PublicAccountReportUtils.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, "0X8007EE4", "0X8007EE4", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "", (String)localObject1, false);
        continue;
        localJSONException.mFeedsReportData = paramView;
        paramView = new ArrayList();
        paramView.add(localJSONException);
        ReadInJoyLogicEngine.a().a(paramView);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComponentSocialOperation", 2, "onclick v:" + paramView.getId());
      }
      ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localObject2 = new ReportInfo();
      if (paramView.getId() != 2131366849) {
        continue;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo != null)
      {
        if ((!ReadInJoyBaseAdapter.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        if (!ReadInJoyBaseAdapter.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          PublicAccountReportUtils.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007B67", "0X8007B67", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), "0", "", (String)localObject1, false);
        }
        ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      }
      ((ReportInfo)localObject2).mOperation = 3;
      if (!ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a())) {
        continue;
      }
      ReadInJoyUtils.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, true, 0, true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        continue;
      }
      paramView = new ReportInfo.FeedsReportData();
      ((ReportInfo)localObject2).mUin = ReadInJoyUtils.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      ((ReportInfo)localObject2).mAlgorithmId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mServerContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo == null) {
        continue;
      }
      paramView.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        paramView.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      paramView.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_b_of_type_Int;
      paramView.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.d;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        continue;
      }
      paramView.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        continue;
      }
      localObject3 = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject1).next();
      if (localObject3 != null)
      {
        paramView.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((SocializeFeedsInfo.FeedsInfoUser)localObject3).jdField_a_of_type_Long));
        continue;
        ((JSONObject)localObject2).put("feeds_source", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation
 * JD-Core Version:    0.7.0.1
 */