package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import amtj;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import odq;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import pay;
import pgb;
import pgw;
import pkm;
import pvc;
import qpj;
import qps;
import qtr;
import qwy;
import qwz;
import qxa;
import rdy;
import rer;
import rfj;
import uhv;

public class ComponentSocialOperation
  extends FrameLayout
  implements View.OnClickListener, qpj
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  SocializeFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  qtr jdField_a_of_type_Qtr;
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
      return paramInt + amtj.a(2131701431);
    }
    paramInt /= 100000000;
    return paramInt + amtj.a(2131701397);
  }
  
  @NotNull
  private String a(ArticleInfo paramArticleInfo, SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", pay.d);
        if (pgb.a(paramArticleInfo))
        {
          localJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
          localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
          localJSONObject.put("feeds_type", "" + pay.a(paramArticleInfo));
          localJSONObject.put("kandian_mode", "" + pay.e());
          localJSONObject.put("tab_source", "" + pay.d());
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
          localJSONObject.put("feeds_source", paramSocializeFeedsInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
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
  
  private void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, ReportInfo paramReportInfo)
  {
    rdy localrdy = new rdy();
    paramReportInfo.mUin = pay.a();
    paramReportInfo.mSource = 0;
    paramReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    paramReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
    paramReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    paramReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    paramReportInfo.mServerContext = paramArticleInfo.mServerContext;
    paramReportInfo.mReadTimeLength = -1;
    localrdy.jdField_a_of_type_Long = paramSocializeFeedsInfo.jdField_a_of_type_Long;
    if (paramSocializeFeedsInfo.jdField_a_of_type_Rer != null) {
      localrdy.jdField_b_of_type_Long = paramSocializeFeedsInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
    }
    localrdy.jdField_a_of_type_Int = paramSocializeFeedsInfo.jdField_b_of_type_Int;
    localrdy.jdField_b_of_type_Int = paramSocializeFeedsInfo.d;
    paramArticleInfo = paramSocializeFeedsInfo.jdField_a_of_type_JavaUtilList;
    if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
    {
      localrdy.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        paramSocializeFeedsInfo = (rer)paramArticleInfo.next();
        if (paramSocializeFeedsInfo != null) {
          localrdy.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long));
        }
      }
    }
    paramReportInfo.mFeedsReportData = localrdy;
    paramArticleInfo = new ArrayList();
    paramArticleInfo.add(paramReportInfo);
    pkm.a().a(paramArticleInfo);
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    String str;
    Intent localIntent;
    if (uhv.a(paramArticleInfo.mChannelID))
    {
      str = "0X8009361";
      Object localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        localIntent = new Intent((Context)localObject, ReadInJoyDeliverBiuActivity.class);
        localIntent.putExtra("arg_article_info", paramArticleInfo);
        localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
        if (this.jdField_a_of_type_Qtr.a.e() != 70) {
          break label226;
        }
        localIntent.putExtra("biu_src", 9);
        localIntent.putExtra("arg_from_type", 14);
        label112:
        ((Activity)localObject).startActivity(localIntent);
        ((Activity)localObject).overridePendingTransition(0, 0);
      }
      if (!a(paramArticleInfo)) {
        break label249;
      }
      if (!pgb.o(paramArticleInfo)) {
        odq.a(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long), str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      pgw.b(paramArticleInfo, this.jdField_a_of_type_Qtr.a.e());
    }
    for (;;)
    {
      paramReportInfo.mOperation = 25;
      return;
      str = "0X8007EE4";
      break;
      label226:
      localIntent.putExtra("biu_src", 1);
      localIntent.putExtra("arg_from_type", 1);
      break label112;
      label249:
      odq.a(null, paramArticleInfo.mSubscribeID, str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
    }
  }
  
  private boolean a(@NotNull ArticleInfo paramArticleInfo)
  {
    return (pgb.i(paramArticleInfo)) || (pgb.g(paramArticleInfo)) || (pgb.j(paramArticleInfo)) || (pgb.k(paramArticleInfo));
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qtr = new qtr();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    boolean bool = uhv.a(paramArticleInfo.mChannelID);
    String str1;
    String str2;
    if (bool)
    {
      str1 = "0X800935E";
      if (!bool) {
        break label232;
      }
      str2 = "0X800935F";
      label29:
      if (this.jdField_a_of_type_Boolean) {
        break label240;
      }
      bool = true;
      label39:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label301;
      }
      if (!a(paramArticleInfo)) {
        break label246;
      }
      if (!pgb.o(paramArticleInfo)) {
        odq.a(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      pgw.b(paramArticleInfo, this.jdField_a_of_type_Qtr.a.e());
      label136:
      paramReportInfo.mOperation = 2;
      if (!this.jdField_a_of_type_Boolean) {
        break label450;
      }
      i = this.jdField_a_of_type_Int + 1;
      label157:
      this.jdField_a_of_type_Int = i;
      a(true);
      paramString = paramArticleInfo.mSocialFeedInfo;
      if (!this.jdField_a_of_type_Boolean) {
        break label461;
      }
    }
    label301:
    label450:
    label461:
    for (int i = 1;; i = 0)
    {
      paramString.jdField_c_of_type_Int = i;
      paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramArticleInfo = paramArticleInfo.clone();
      pkm.a().a(pay.a(), paramSocializeFeedsInfo.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramArticleInfo);
      return;
      str1 = "0X8007B65";
      break;
      label232:
      str2 = "0X8007B66";
      break label29;
      label240:
      bool = false;
      break label39;
      label246:
      odq.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
      break label136;
      if (a(paramArticleInfo))
      {
        if (!pgb.o(paramArticleInfo)) {
          odq.a(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long), str2, str2, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
        }
        pgw.b(paramArticleInfo, this.jdField_a_of_type_Qtr.a.e());
      }
      for (;;)
      {
        paramReportInfo.mOperation = 13;
        break;
        odq.a(null, paramArticleInfo.mSubscribeID, str2, str2, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      i = this.jdField_a_of_type_Int - 1;
      break label157;
    }
  }
  
  private void c(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    String str;
    if (uhv.a(paramArticleInfo.mChannelID))
    {
      str = "0X8009360";
      if (!a(paramArticleInfo)) {
        break label144;
      }
      if (!pgb.o(paramArticleInfo)) {
        odq.a(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long), str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      pgw.b(paramArticleInfo, this.jdField_a_of_type_Qtr.a.e());
    }
    for (;;)
    {
      paramReportInfo.mOperation = 3;
      if (!pgb.a(this.jdField_a_of_type_Qtr.a.a())) {
        break label199;
      }
      pay.a(getContext(), paramArticleInfo, 1, true, 0, true);
      return;
      str = "0X8007B67";
      break;
      label144:
      odq.a(null, paramArticleInfo.mSubscribeID, str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
    }
    label199:
    pay.a(getContext(), paramArticleInfo, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560140, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131364882));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131380234));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131380233));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131380232);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363569));
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.8F, 1.0F, 1.8F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.8F, 0.85F, 1.8F, 0.85F, 1, 0.5F, 1, 0.5F);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.85F, 1.0F, 0.85F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new qwy(this));
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new qwz(this));
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new qxa(this));
  }
  
  public void a(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof pvc))
    {
      paramObject = (pvc)paramObject;
      this.jdField_a_of_type_Qtr.a(paramObject);
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
  
  public void a(qps paramqps)
  {
    this.jdField_a_of_type_Qtr.a(paramqps);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
      if (this.jdField_b_of_type_Int <= 0) {
        break label199;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Int));
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int <= 0) {
        break label212;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_c_of_type_Int));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846279);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#07D0B0"));
        label88:
        if (this.jdField_a_of_type_Int <= 0) {
          break label186;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_Int));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label197;
        }
        QLog.d("ComponentSocialOperation", 2, "set upvote to " + this.jdField_a_of_type_Boolean + ", set num:" + this.jdField_a_of_type_Int);
        break;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846282);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        break label88;
        label186:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717568);
      }
      label197:
      break;
      label199:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717272);
    }
    label212:
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
    pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
    ReportInfo localReportInfo = new ReportInfo();
    if (paramView.getId() == 2131364882) {
      c(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
    }
    for (;;)
    {
      a(localArticleInfo, localSocializeFeedsInfo, localReportInfo);
      break;
      if (paramView.getId() == 2131380232) {
        b(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
      } else if (paramView.getId() == 2131363569) {
        a(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation
 * JD-Core Version:    0.7.0.1
 */