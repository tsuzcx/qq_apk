package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData.SearchWord;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

class WebFastRelatedSearchCreator$RelatedSearchViewHolder
  extends BaseItemViewHolder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private List<TextView> jdField_a_of_type_JavaUtilList;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private List<LinearLayout> jdField_b_of_type_JavaUtilList;
  private final int e = 2;
  
  private WebFastRelatedSearchCreator$RelatedSearchViewHolder(View paramView, BaseData paramBaseData, Context paramContext)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377366));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377650));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377651));
    if (paramBaseData.s == 20) {
      a((RelatedSearchData)paramBaseData);
    }
  }
  
  private void a(RelatedSearchData paramRelatedSearchData)
  {
    int i = paramRelatedSearchData.jdField_a_of_type_JavaUtilList.size();
    if (i <= 0) {}
    for (;;)
    {
      return;
      int k = (i + 1) / 2;
      i = 0;
      while (i < k)
      {
        int j = ViewUtils.a(13.0F);
        if (i == k - 1) {}
        for (float f = 5.0F;; f = 15.0F)
        {
          int m = ViewUtils.a(f);
          paramRelatedSearchData = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramRelatedSearchData.setOrientation(0);
          Object localObject = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject).setMargins(j, 0, j, m);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramRelatedSearchData, (ViewGroup.LayoutParams)localObject);
          this.jdField_b_of_type_JavaUtilList.add(paramRelatedSearchData);
          j = 0;
          while (j < 2)
          {
            localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 0.5F);
            ((TextView)localObject).setTextSize(2, 16.0F);
            ((TextView)localObject).setTextColor(Color.parseColor("#4D7CAF"));
            ((TextView)localObject).setIncludeFontPadding(false);
            ((TextView)localObject).setMaxLines(1);
            ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
            m = ViewUtils.a(5.0F);
            ((TextView)localObject).setPadding(m, 0, m, m);
            paramRelatedSearchData.addView((View)localObject, localLayoutParams);
            this.jdField_a_of_type_JavaUtilList.add(localObject);
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    int j = 0;
    super.a();
    Object localObject;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.s == 20)
    {
      localObject = (RelatedSearchData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
      if (!WebFastRelatedSearchCreator.a)
      {
        i = 0;
        for (;;)
        {
          if (i < ((RelatedSearchData)localObject).jdField_a_of_type_JavaUtilList.size())
          {
            RelatedSearchData.SearchWord localSearchWord = (RelatedSearchData.SearchWord)((RelatedSearchData)localObject).jdField_a_of_type_JavaUtilList.get(i);
            try
            {
              WebFastRelatedSearchCreator.a("0X800983E", new RIJTransMergeKanDianReport.ReportR5Builder().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.j).a(localSearchWord, i + 1).f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c).g(((RelatedSearchData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).jdField_a_of_type_JavaLangString).a());
              i += 1;
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                localJSONException2.printStackTrace();
              }
            }
          }
        }
      }
    }
    try
    {
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.j).f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c);
      i = j;
      if (RIJAladdinUtils.f()) {
        i = 1;
      }
      WebFastRelatedSearchCreator.a("0X8009857", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).p(i).g(((RelatedSearchData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).jdField_a_of_type_JavaLangString).a());
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        localJSONException1.printStackTrace();
      }
    }
    WebFastRelatedSearchCreator.a = true;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.s)
    {
    default: 
      throw new IllegalArgumentException();
    }
    paramBaseData1 = (RelatedSearchData)paramBaseData2;
    int j = paramBaseData1.jdField_a_of_type_JavaUtilList.size();
    int k = (j + 1) / 2;
    int i = 0;
    if (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (i >= k) {
        ((LinearLayout)this.jdField_b_of_type_JavaUtilList.get(i)).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        ((LinearLayout)this.jdField_b_of_type_JavaUtilList.get(i)).setVisibility(0);
      }
    }
    i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i >= j) {
        ((TextView)this.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        ((TextView)this.jdField_a_of_type_JavaUtilList.get(i)).setVisibility(0);
        ((TextView)this.jdField_a_of_type_JavaUtilList.get(i)).setText(((RelatedSearchData.SearchWord)paramBaseData1.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString);
        RelatedSearchData.SearchWord localSearchWord = (RelatedSearchData.SearchWord)paramBaseData1.jdField_a_of_type_JavaUtilList.get(i);
        ((TextView)this.jdField_a_of_type_JavaUtilList.get(i)).setOnClickListener(new WebFastRelatedSearchCreator.RelatedSearchViewHolder.1(this, i + 1, localSearchWord, paramBaseData2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastRelatedSearchCreator.RelatedSearchViewHolder
 * JD-Core Version:    0.7.0.1
 */