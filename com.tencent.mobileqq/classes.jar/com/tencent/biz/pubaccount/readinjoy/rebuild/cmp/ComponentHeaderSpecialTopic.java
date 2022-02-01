package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import ocd;
import org.json.JSONException;
import org.json.JSONObject;
import ozc;
import ozs;
import ppu;
import qno;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import ubg;

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
        Object localObject = ozs.a((String)localObject);
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
      JSONObject localJSONObject = ozs.a();
      localJSONObject.put("feeds_source", paramString);
      localJSONObject.put("kandian_mode", ozs.e());
      String str = ozs.e(this.jdField_a_of_type_Qno.a.a());
      if (ubg.a(this.jdField_a_of_type_Qno.a.e())) {}
      for (paramString = "0X8009357";; paramString = "0X800744D")
      {
        ocd.a(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", localJSONObject.toString(), false);
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
    String str = b(this.jdField_a_of_type_Qno.a.a());
    if (!TextUtils.isEmpty(str)) {
      ozs.a(getContext(), str);
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560128, this, true);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131376142));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376133));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof ppu)) {
      a((ppu)paramObject);
    }
  }
  
  public void a(ppu paramppu)
  {
    if ((paramppu.a()) && (paramppu.c() == 1)) {}
    ArticleInfo localArticleInfo;
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramppu.a()) && (paramppu.c() == 1)) {
        localArticleInfo = paramppu.a();
      }
      switch (paramppu.c())
      {
      default: 
        return;
      }
    }
    paramppu = a(localArticleInfo);
    if (paramppu == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      ozc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramppu, getContext());
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
      a(ozs.d(this.jdField_a_of_type_Qno.a.a()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSpecialTopic
 * JD-Core Version:    0.7.0.1
 */