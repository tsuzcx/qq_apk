package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ComponentHeaderSpecialTopic
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  
  public ComponentHeaderSpecialTopic(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderSpecialTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderSpecialTopic(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic title empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private URL a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mHeaderIconUrl == null) {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
        if (TextUtils.isEmpty(str)) {
          QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic icon url empty");
        }
        if (TextUtils.isEmpty(str)) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject = null;
        }
        Object localObject = RIJPreParseData.a((String)localObject);
        paramArticleInfo.mHeaderIconUrl = ((URL)localObject);
        return localObject;
      }
    }
    return paramArticleInfo.mHeaderIconUrl;
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
  
  private String b(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic url empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private void d()
  {
    String str = b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a());
    if (!TextUtils.isEmpty(str)) {
      ReadInJoyUtils.a(getContext(), str);
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560260, this, true);
  }
  
  public void a()
  {
    super.a();
    setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131376538));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376529));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.c() == 1)) {}
    ArticleInfo localArticleInfo;
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.c() == 1)) {
        localArticleInfo = paramIReadInJoyModel.a();
      }
      switch (paramIReadInJoyModel.c())
      {
      default: 
        return;
      }
    }
    paramIReadInJoyModel = a(localArticleInfo);
    if (paramIReadInJoyModel == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramIReadInJoyModel, getContext());
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (paramView == this) {
        d();
      }
      break;
    }
    for (;;)
    {
      a(RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSpecialTopic
 * JD-Core Version:    0.7.0.1
 */