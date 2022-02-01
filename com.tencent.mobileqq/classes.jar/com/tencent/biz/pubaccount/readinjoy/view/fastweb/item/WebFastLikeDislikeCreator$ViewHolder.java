package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONException;

public class WebFastLikeDislikeCreator$ViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = true;
  
  public WebFastLikeDislikeCreator$ViewHolder(WebFastLikeDislikeCreator paramWebFastLikeDislikeCreator, Context paramContext, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369710));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380443));
    paramWebFastLikeDislikeCreator = (LinearLayout)paramView.findViewById(2131366606);
    int j = paramWebFastLikeDislikeCreator.getChildCount();
    int k = a(j);
    int i = 0;
    while (i < j)
    {
      paramContext = paramWebFastLikeDislikeCreator.getChildAt(i);
      ((LinearLayout.LayoutParams)paramContext.getLayoutParams()).width = k;
      paramContext.setOnClickListener(this);
      i += 1;
    }
  }
  
  private int a(int paramInt)
  {
    return (int)Math.floor(((int)DeviceInfoUtil.a(true) - this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298816) * 2 - (paramInt - 1) * this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDimensionPixelSize(2131298817)) * 1.0D / paramInt);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    ThreadManager.executeOnSubThread(new WebFastLikeDislikeCreator.ViewHolder.1(this, paramArticleInfo));
    a("0X80101DC");
  }
  
  private void a(FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimation = localScaleAnimation;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new WebFastLikeDislikeCreator.ViewHolder.2(this, paramFastWebArticleInfo));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void a(String paramString)
  {
    int j = 1;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (localArticleInfo == null) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = ReportUtil.a(localArticleInfo);
    for (;;)
    {
      try
      {
        localReportR5Builder.b("source_from", "2");
        localReportR5Builder.j();
        localReportR5Builder.k();
        localReportR5Builder.l();
        localReportR5Builder.a(localArticleInfo.mAlgorithmID);
        localReportR5Builder.b(localArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localReportR5Builder.b("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localReportR5Builder.b("businessID", i);
        }
        if (!RIJAladdinUtils.e()) {
          break label217;
        }
        i = 1;
        localReportR5Builder.b("artical_interact_area", i);
        localReportR5Builder.b("artical_interact_type", RIJAladdinUtils.d());
        if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
        {
          if (!RIJAladdinUtils.f()) {
            break label222;
          }
          i = j;
          localReportR5Builder.b("ad_relative_pos", i);
        }
        ReportUtil.a(localArticleInfo, paramString, localReportR5Builder.a());
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(WebFastLikeDislikeCreator.a(), 2, "parseR5 has error !", paramString);
      return;
      label217:
      int i = 0;
      continue;
      label222:
      i = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a("0X80099DA");
      a("0X80100DB");
      a("0X8009A5A");
    }
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = paramBaseData2.a;
    if (paramBaseData1 != null)
    {
      if (RIJAladdinUtils.d() != 1) {
        break label288;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370616).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370595).setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370668).setBackgroundColor(0);
      paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label280;
      }
    }
    label280:
    for (int i = 2130843070;; i = 2130841846)
    {
      paramBaseData2.setImageResource(i);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370596)).setImageResource(2130841833);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370669)).setImageResource(2130842825);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370597)).setTextColor(Color.parseColor("#737373"));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370670)).setTextColor(Color.parseColor("#737373"));
      if (!RIJAladdinUtils.e())
      {
        paramBaseData1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366606);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131366606).setPadding(paramBaseData1.getPaddingLeft(), ViewUtils.b(10.5F), paramBaseData1.getPaddingRight(), paramBaseData1.getPaddingBottom());
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370616).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370595).getLayoutParams().height = -2;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370668).getLayoutParams().height = -2;
      return;
    }
    label288:
    paramBaseData2 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBaseData1.jdField_a_of_type_Boolean)
    {
      i = 2130843069;
      paramBaseData2.setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(paramBaseData1.jdField_a_of_type_Int, 99990000L, "9999万+", WebFastLikeDislikeCreator.a));
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label403;
      }
      i = Color.parseColor("#F64B31");
      label350:
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
      if (!paramBaseData1.jdField_a_of_type_Boolean) {
        break label411;
      }
    }
    label403:
    label411:
    for (paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849788);; paramBaseData1 = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849787))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370616).setBackgroundDrawable(paramBaseData1);
      return;
      i = 2130841845;
      break;
      i = -16777216;
      break label350;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a;
      if (localObject == null) {
        AIOUtils.a(WebFastLikeDislikeCreator.a(), "", new IllegalArgumentException());
      } else {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131370595: 
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b);
          break;
        case 2131370616: 
          if (((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean)
          {
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean = false;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Int -= 1;
            ReportUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009765", "2");
          }
          for (;;)
          {
            a((FastWebArticleInfo)localObject);
            ReadInJoyLogicEngineEventDispatcher.a().d();
            ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean, (FastWebArticleInfo)localObject);
            break;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Boolean = true;
            ((FastWebArticleInfo)localObject).jdField_a_of_type_Int += 1;
            ReportUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8009764", "2");
          }
        case 2131370668: 
          localObject = this.jdField_a_of_type_AndroidViewView.getContext();
          a("0X8009A5B");
          if ((localObject instanceof FastWebActivity)) {
            ((FastWebActivity)localObject).a(false, false);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder
 * JD-Core Version:    0.7.0.1
 */