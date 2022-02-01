package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ComponentPolymericPullAnimatorView
  extends LinearLayout
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  ComponentPolymericView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ComponentPolymericPullAnimatorView(Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
    b();
  }
  
  private void b()
  {
    setOrientation(1);
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    Object localObject2;
    if ((RIJFeedsType.o((BaseArticleInfo)localObject1)) || (RIJFeedsType.p((BaseArticleInfo)localObject1)))
    {
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560238, null);
      addView((View)localObject2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)((View)localObject2).findViewById(2131368603));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131379432));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131371850));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject2).findViewById(2131365922);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject2).findViewById(2131365255);
      if (!DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e())) {
        break label373;
      }
      localObject1 = new LinearLayout.LayoutParams(-1, DisplayUtil.b(getContext(), 45.0F));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Int = 2130843033;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
      localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.b(getContext(), 18.0F), DisplayUtil.b(getContext(), 18.0F));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(DisplayUtil.b(getContext(), 12.0F), 0, DisplayUtil.b(getContext(), 6.0F), 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702339));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, Utils.rp2px(18.0D));
    }
    for (;;)
    {
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView = new ComponentPolymericView(this.jdField_a_of_type_AndroidContentContext);
      BezierSideBarView localBezierSideBarView = new BezierSideBarView(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView, (ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).addView(localBezierSideBarView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setSideBarView(localBezierSideBarView);
      addView((View)localObject1);
      return;
      label373:
      localObject2 = new LinearLayout.LayoutParams(-1, DisplayUtil.b(getContext(), 36.0F));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (((ArticleInfo)localObject1).mNewPolymericInfo.jdField_a_of_type_Int == 12)
      {
        this.jdField_a_of_type_Int = 2130843229;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702369));
      }
      else if (((ArticleInfo)localObject1).mNewPolymericInfo.jdField_a_of_type_Int == 13)
      {
        this.jdField_a_of_type_Int = 2130843172;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702365));
      }
    }
  }
  
  public ComponentPolymericView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView;
  }
  
  public void a()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    JSONObject localJSONObject;
    if ((RIJFeedsType.o(localArticleInfo)) || (RIJFeedsType.p(localArticleInfo))) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      Object localObject2;
      NewPolymericInfo.PackArticleInfo localPackArticleInfo;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject2 = new StringBuilder();
        localObject3 = localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label384;
        }
        localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)((Iterator)localObject3).next();
        if (!RIJFeedsType.o(localArticleInfo)) {
          break label361;
        }
        localStringBuilder.append(localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackTopicExtraInfo.b).append(",");
        continue;
        localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label119:
      Object localObject3 = localArticleInfo.mFeedId + "";
      Object localObject1;
      if (RIJFeedsType.o(localArticleInfo))
      {
        localObject1 = "1";
        ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009828", "0X8009828", 0, 0, (String)localObject3, (String)localObject1, localArticleInfo.mStrategyId + "", localJSONObject.toString(), false);
        if (TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaLangString)) {}
      }
      try
      {
        localObject1 = new URL(localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Int)).setImage((URL)localObject1);
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.b)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mNewPolymericInfo.b);
        }
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.c)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(localArticleInfo.mNewPolymericInfo.c);
        }
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.d)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ComponentPolymericPullAnimatorView.1(this, localArticleInfo, localJSONObject));
        }
        return;
        label361:
        ((StringBuilder)localObject2).append(localPackArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructNewPolymericInfo$PackQuestionAnswerExtraInfo.jdField_a_of_type_JavaLangString).append(",");
        continue;
        label384:
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
        localJSONObject.put("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e());
        localJSONObject.put("rowkey", ((StringBuilder)localObject2).toString());
        localJSONObject.put("topicid", ((StringBuilder)localObject1).toString());
        break label119;
        localObject1 = "2";
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.d("ComponentPolymericPullAnimatorView topic icon", 2, localMalformedURLException, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView
 * JD-Core Version:    0.7.0.1
 */