package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajyc;
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
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import noo;
import onk;
import org.json.JSONException;
import org.json.JSONObject;
import osj;
import pax;
import pqs;
import prb;
import pvb;
import pyi;
import pyj;
import pyk;
import qcc;
import qcl;
import qdd;
import rap;
import shx;

public class ComponentSocialOperation
  extends FrameLayout
  implements View.OnClickListener, pqs
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  SocializeFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  public final String a;
  pvb jdField_a_of_type_Pvb;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  ScaleAnimation jdField_b_of_type_AndroidViewAnimationScaleAnimation;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  int jdField_c_of_type_Int = 0;
  public ScaleAnimation c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public ComponentSocialOperation(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "ComponentSocialOperation";
    b(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "ComponentSocialOperation";
    b(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "ComponentSocialOperation";
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
      return String.valueOf(paramInt) + ajyc.a(2131702274);
    }
    paramInt /= 100000000;
    return String.valueOf(paramInt) + ajyc.a(2131702240);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Pvb = new pvb();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559880, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131364515));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378717));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131378716));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131378715);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363290));
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.8F, 1.0F, 1.8F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.8F, 0.85F, 1.8F, 0.85F, 1, 0.5F, 1, 0.5F);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.85F, 1.0F, 0.85F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new pyi(this));
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new pyj(this));
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new pyk(this));
  }
  
  public void a(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof pax))
    {
      paramObject = (pax)paramObject;
      this.jdField_a_of_type_Pvb.a(paramObject);
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
  
  public void a(prb paramprb)
  {
    this.jdField_a_of_type_Pvb.a(paramprb);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
      if (this.jdField_b_of_type_Int <= 0) {
        break label192;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int <= 0) {
        break label204;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_c_of_type_Int));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845457);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#07D0B0"));
        label86:
        if (this.jdField_a_of_type_Int <= 0) {
          break label180;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Int));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label190;
        }
        QLog.d("ComponentSocialOperation", 2, "set upvote to " + this.jdField_a_of_type_Boolean + ", set num:" + this.jdField_a_of_type_Int);
        break;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845460);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        break label86;
        label180:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718604);
      }
      label190:
      break;
      label192:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718351);
    }
    label204:
    this.jdField_c_of_type_AndroidWidgetTextView.setText("Biu");
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    Object localObject3 = "";
    for (;;)
    {
      try
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("folder_status", onk.d);
        if (!rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          continue;
        }
        ((JSONObject)localObject4).put("feeds_source", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID);
        ((JSONObject)localObject4).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        ((JSONObject)localObject4).put("feeds_type", "" + onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
        ((JSONObject)localObject4).put("kandian_mode", "" + onk.e());
        ((JSONObject)localObject4).put("tab_source", "" + onk.d());
        ((JSONObject)localObject4).put("channel_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
        ((JSONObject)localObject4).put("algorithm_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isPGCShortContent()) {
          continue;
        }
        localObject1 = "1";
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        ReportInfo localReportInfo;
        localJSONException.printStackTrace();
        Object localObject2 = localObject3;
        continue;
        localObject2 = "0";
        continue;
        localObject3 = "0X8007B65";
        continue;
        Object localObject4 = "0X8007B66";
        continue;
        String str2 = "0X8007B67";
        continue;
        String str1 = "0X8007EE4";
        continue;
        noo.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, str2, str2, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, (String)localObject2, false);
        continue;
        onk.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
        continue;
        if (paramView.getId() != 2131378715) {
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
        if ((!rap.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        if (rap.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          continue;
        }
        noo.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long), (String)localObject3, (String)localObject3, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, (String)localObject2, false);
        rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Pvb.a.e());
        localReportInfo.mOperation = 2;
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
        paramView.jdField_c_of_type_Int = i;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.clone();
        osj.a().a(onk.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramView);
        continue;
        bool = false;
        continue;
        noo.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, (String)localObject3, (String)localObject3, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, (String)localObject2, false);
        continue;
        if ((!rap.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        if (rap.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          continue;
        }
        noo.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long), (String)localObject4, (String)localObject4, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, (String)localObject2, false);
        rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Pvb.a.e());
        localReportInfo.mOperation = 13;
        continue;
        noo.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, (String)localObject4, (String)localObject4, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, (String)localObject2, false);
        continue;
        i = this.jdField_a_of_type_Int - 1;
        continue;
        i = 0;
        continue;
        if (paramView.getId() != 2131363290) {
          continue;
        }
        paramView = getContext();
        if (!(paramView instanceof Activity)) {
          continue;
        }
        paramView = (Activity)paramView;
        localObject3 = new Intent(paramView, ReadInJoyDeliverBiuActivity.class);
        ((Intent)localObject3).putExtra("arg_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        ((Intent)localObject3).putExtra("feedsType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
        if (this.jdField_a_of_type_Pvb.a.e() != 70) {
          continue;
        }
        ((Intent)localObject3).putExtra("biu_src", 9);
        ((Intent)localObject3).putExtra("arg_from_type", 14);
        paramView.startActivity((Intent)localObject3);
        paramView.overridePendingTransition(0, 0);
        if ((!rap.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        if (rap.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          continue;
        }
        noo.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, (String)localObject2, false);
        rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Pvb.a.e());
        localReportInfo.mOperation = 25;
        continue;
        ((Intent)localObject3).putExtra("biu_src", 1);
        ((Intent)localObject3).putExtra("arg_from_type", 1);
        continue;
        noo.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, (String)localObject2, false);
        continue;
        localReportInfo.mFeedsReportData = paramView;
        paramView = new ArrayList();
        paramView.add(localReportInfo);
        osj.a().a(paramView);
      }
      ((JSONObject)localObject4).put("content_source", localObject1);
      localObject1 = ((JSONObject)localObject4).toString();
      if (QLog.isColorLevel()) {
        QLog.d("ComponentSocialOperation", 2, "onclick v:" + paramView.getId());
      }
      onk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localReportInfo = new ReportInfo();
      bool = shx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      if (!bool) {
        continue;
      }
      localObject3 = "0X800935E";
      if (!bool) {
        continue;
      }
      localObject4 = "0X800935F";
      if (!bool) {
        continue;
      }
      str2 = "0X8009360";
      if (!bool) {
        continue;
      }
      str1 = "0X8009361";
      if (paramView.getId() != 2131364515) {
        continue;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo != null)
      {
        if ((!rap.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!rap.k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        if (!rap.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          noo.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long), str2, str2, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId, (String)localObject1, false);
        }
        rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Pvb.a.e());
      }
      localReportInfo.mOperation = 3;
      if (!rap.a(this.jdField_a_of_type_Pvb.a.a())) {
        continue;
      }
      onk.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, true, 0, true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        continue;
      }
      paramView = new qcc();
      localReportInfo.mUin = onk.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      localReportInfo.mChannelId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      localReportInfo.mAlgorithmId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      localReportInfo.mServerContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo == null) {
        continue;
      }
      paramView.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Qcl != null) {
        paramView.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long;
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
      localObject3 = (qcl)((Iterator)localObject1).next();
      if (localObject3 != null)
      {
        paramView.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((qcl)localObject3).jdField_a_of_type_Long));
        continue;
        ((JSONObject)localObject4).put("feeds_source", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation
 * JD-Core Version:    0.7.0.1
 */