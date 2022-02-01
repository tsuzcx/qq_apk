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
import anzj;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ocd;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import ozs;
import pfa;
import ppu;
import qjg;
import qjp;
import qno;
import qqv;
import qqw;
import qqx;
import qxa;
import qxt;
import qyl;
import sel;
import ubg;

public class ComponentSocialOperation
  extends FrameLayout
  implements View.OnClickListener, qjg
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  public ImageView a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  SocializeFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  qno jdField_a_of_type_Qno;
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
      return paramInt + anzj.a(2131701196);
    }
    paramInt /= 100000000;
    return paramInt + anzj.a(2131701162);
  }
  
  @NotNull
  private String a(ArticleInfo paramArticleInfo, SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", ozs.d);
        if (sel.a(paramArticleInfo))
        {
          localJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
          localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
          localJSONObject.put("feeds_type", "" + ozs.a(paramArticleInfo));
          localJSONObject.put("kandian_mode", "" + ozs.e());
          localJSONObject.put("tab_source", "" + ozs.d());
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
          localJSONObject.put("feeds_source", paramSocializeFeedsInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long);
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
    qxa localqxa = new qxa();
    paramReportInfo.mUin = ozs.a();
    paramReportInfo.mSource = 0;
    paramReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    paramReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
    paramReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    paramReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    paramReportInfo.mServerContext = paramArticleInfo.mServerContext;
    paramReportInfo.mReadTimeLength = -1;
    localqxa.jdField_a_of_type_Long = paramSocializeFeedsInfo.jdField_a_of_type_Long;
    if (paramSocializeFeedsInfo.jdField_a_of_type_Qxt != null) {
      localqxa.jdField_b_of_type_Long = paramSocializeFeedsInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
    }
    localqxa.jdField_a_of_type_Int = paramSocializeFeedsInfo.jdField_b_of_type_Int;
    localqxa.jdField_b_of_type_Int = paramSocializeFeedsInfo.d;
    paramArticleInfo = paramSocializeFeedsInfo.jdField_a_of_type_JavaUtilList;
    if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
    {
      localqxa.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArticleInfo = paramArticleInfo.iterator();
      while (paramArticleInfo.hasNext())
      {
        paramSocializeFeedsInfo = (qxt)paramArticleInfo.next();
        if (paramSocializeFeedsInfo != null) {
          localqxa.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long));
        }
      }
    }
    paramReportInfo.mFeedsReportData = localqxa;
    paramArticleInfo = new ArrayList();
    paramArticleInfo.add(paramReportInfo);
    pfa.a().a(paramArticleInfo);
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    String str;
    Intent localIntent;
    if (ubg.a(paramArticleInfo.mChannelID))
    {
      str = "0X8009361";
      Object localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        localIntent = new Intent((Context)localObject, ReadInJoyDeliverBiuActivity.class);
        localIntent.putExtra("arg_article_info", paramArticleInfo);
        localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
        if (this.jdField_a_of_type_Qno.a.e() != 70) {
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
      if (!sel.o(paramArticleInfo)) {
        ocd.a(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      sel.a(paramArticleInfo, this.jdField_a_of_type_Qno.a.e());
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
      ocd.a(null, paramArticleInfo.mSubscribeID, str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
    }
  }
  
  private boolean a(@NotNull ArticleInfo paramArticleInfo)
  {
    return (sel.i(paramArticleInfo)) || (sel.g(paramArticleInfo)) || (sel.j(paramArticleInfo)) || (sel.k(paramArticleInfo));
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qno = new qno();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    boolean bool = ubg.a(paramArticleInfo.mChannelID);
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
      if (!sel.o(paramArticleInfo)) {
        ocd.a(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), str1, str1, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      sel.a(paramArticleInfo, this.jdField_a_of_type_Qno.a.e());
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
      pfa.a().a(ozs.a(), paramSocializeFeedsInfo.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramArticleInfo);
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
      ocd.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
      break label136;
      if (a(paramArticleInfo))
      {
        if (!sel.o(paramArticleInfo)) {
          ocd.a(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), str2, str2, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
        }
        sel.a(paramArticleInfo, this.jdField_a_of_type_Qno.a.e());
      }
      for (;;)
      {
        paramReportInfo.mOperation = 13;
        break;
        ocd.a(null, paramArticleInfo.mSubscribeID, str2, str2, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      i = this.jdField_a_of_type_Int - 1;
      break label157;
    }
  }
  
  private void c(@NotNull ArticleInfo paramArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    String str;
    if (ubg.a(paramArticleInfo.mChannelID))
    {
      str = "0X8009360";
      if (!a(paramArticleInfo)) {
        break label144;
      }
      if (!sel.o(paramArticleInfo)) {
        ocd.a(null, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, paramString, false);
      }
      sel.a(paramArticleInfo, this.jdField_a_of_type_Qno.a.e());
    }
    for (;;)
    {
      paramReportInfo.mOperation = 3;
      if (!sel.a(this.jdField_a_of_type_Qno.a.a())) {
        break label199;
      }
      ozs.a(getContext(), paramArticleInfo, 1, true, 0, true);
      return;
      str = "0X8007B67";
      break;
      label144:
      ocd.a(null, paramArticleInfo.mSubscribeID, str, str, 0, 0, String.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, paramString, false);
    }
    label199:
    ozs.a(getContext(), paramArticleInfo, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560133, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131364854));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131380510));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131380509));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131380508);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363540));
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.8F, 1.0F, 1.8F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.8F, 0.85F, 1.8F, 0.85F, 1, 0.5F, 1, 0.5F);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.85F, 1.0F, 0.85F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new qqv(this));
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new qqw(this));
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new qqx(this));
  }
  
  public void a(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof ppu))
    {
      paramObject = (ppu)paramObject;
      this.jdField_a_of_type_Qno.a(paramObject);
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
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846371);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846374);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        break label88;
        label186:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131717336);
      }
      label197:
      break;
      label199:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717037);
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
    ozs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
    ReportInfo localReportInfo = new ReportInfo();
    if (paramView.getId() == 2131364854) {
      c(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
    }
    for (;;)
    {
      a(localArticleInfo, localSocializeFeedsInfo, localReportInfo);
      break;
      if (paramView.getId() == 2131380508) {
        b(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
      } else if (paramView.getId() == 2131363540) {
        a(localArticleInfo, localSocializeFeedsInfo, str, localReportInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation
 * JD-Core Version:    0.7.0.1
 */