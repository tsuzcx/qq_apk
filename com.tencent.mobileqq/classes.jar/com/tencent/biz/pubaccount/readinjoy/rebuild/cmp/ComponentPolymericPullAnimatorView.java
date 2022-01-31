package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajjy;
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
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import ndn;
import obz;
import odm;
import opw;
import org.json.JSONObject;
import pmk;
import ppu;
import ppv;
import ppw;
import ppx;
import vct;

public class ComponentPolymericPullAnimatorView
  extends LinearLayout
{
  int jdField_a_of_type_Int;
  public Context a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ComponentPolymericView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  opw jdField_a_of_type_Opw;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ComponentPolymericPullAnimatorView(Context paramContext, opw paramopw)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Opw = paramopw;
    b();
  }
  
  private void b()
  {
    setOrientation(1);
    Object localObject1 = this.jdField_a_of_type_Opw.a();
    Object localObject2;
    if ((obz.o((BaseArticleInfo)localObject1)) || (obz.p((BaseArticleInfo)localObject1)))
    {
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494282, null);
      addView((View)localObject2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)((View)localObject2).findViewById(2131302061));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131311534));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131304741));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject2).findViewById(2131299701);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject2).findViewById(2131299097);
      if (!odm.c(this.jdField_a_of_type_Opw.e())) {
        break label373;
      }
      localObject1 = new LinearLayout.LayoutParams(-1, vct.a(getContext(), 45.0F));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Int = 2130842188;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
      localObject1 = new RelativeLayout.LayoutParams(vct.a(getContext(), 18.0F), vct.a(getContext(), 18.0F));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(vct.a(getContext(), 12.0F), 0, vct.a(getContext(), 6.0F), 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131636492));
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
      localObject2 = new LinearLayout.LayoutParams(-1, vct.a(getContext(), 36.0F));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (((ArticleInfo)localObject1).mNewPolymericInfo.jdField_a_of_type_Int == 12)
      {
        this.jdField_a_of_type_Int = 2130842379;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131636522));
      }
      else if (((ArticleInfo)localObject1).mNewPolymericInfo.jdField_a_of_type_Int == 13)
      {
        this.jdField_a_of_type_Int = 2130842317;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131636518));
      }
    }
  }
  
  public ComponentPolymericView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView;
  }
  
  public void a()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Opw.a();
    JSONObject localJSONObject;
    if ((obz.o(localArticleInfo)) || (obz.p(localArticleInfo))) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      Object localObject2;
      ppv localppv;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject2 = new StringBuilder();
        Iterator localIterator = localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label369;
        }
        localppv = (ppv)localIterator.next();
        if (!obz.o(localArticleInfo)) {
          break label346;
        }
        localStringBuilder.append(localppv.jdField_a_of_type_Ppx.b).append(",");
        continue;
        localObject2 = localArticleInfo.mFeedId + "";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label119:
      Object localObject1;
      if (obz.o(localArticleInfo))
      {
        localObject1 = "1";
        ndn.a(null, "CliOper", "", "", "0X8009828", "0X8009828", 0, 0, (String)localObject2, (String)localObject1, localArticleInfo.mStrategyId + "", localJSONObject.toString(), false);
        if (TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaLangString)) {}
      }
      try
      {
        localObject1 = new URL(localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Int)).a((URL)localObject1);
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.b)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localArticleInfo.mNewPolymericInfo.b);
        }
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.c)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(localArticleInfo.mNewPolymericInfo.c);
        }
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.d)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new pmk(this, localArticleInfo, localJSONObject));
        }
        return;
        label346:
        ((StringBuilder)localObject2).append(localppv.jdField_a_of_type_Ppw.jdField_a_of_type_JavaLangString).append(",");
        continue;
        label369:
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
        localJSONObject.put("channel_id", this.jdField_a_of_type_Opw.e());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView
 * JD-Core Version:    0.7.0.1
 */