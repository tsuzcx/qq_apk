package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentUgcSource
  extends LinearLayout
  implements View.OnClickListener, ComponentInheritView
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  private String jdField_a_of_type_JavaLangString;
  
  public ComponentContentUgcSource(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentUgcSource(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcSource", 2, "business url is " + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject1 = new Intent(getContext(), PublicAccountBrowser.class);
    ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_JavaLangString);
    getContext().startActivity((Intent)localObject1);
    localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
    localObject1 = "";
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.d);
      ((JSONObject)localObject2).put("feeds_source", ReadInJoyUtils.a(localArticleInfo));
      ((JSONObject)localObject2).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject2).put("feeds_type", "" + ReadInJoyUtils.a(localArticleInfo));
      ((JSONObject)localObject2).put("kandian_mode", "" + ReadInJoyUtils.e());
      ((JSONObject)localObject2).put("tab_source", "" + ReadInJoyUtils.d());
      ((JSONObject)localObject2).put("topic_id", "" + localArticleInfo.businessId);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        localJSONException.printStackTrace();
        continue;
        String str = localArticleInfo.mArticleID + "";
      }
    }
    if ((ReadInJoyBaseAdapter.f(localArticleInfo)) || (ReadInJoyBaseAdapter.g(localArticleInfo)) || (ReadInJoyBaseAdapter.h(localArticleInfo)) || (ReadInJoyBaseAdapter.i(localArticleInfo)))
    {
      localObject2 = "0";
      PublicAccountReportUtils.a(null, ReadInJoyUtils.a(localArticleInfo), "0X8008201", "0X8008201", 0, 0, String.valueOf(localArticleInfo.mFeedId), (String)localObject2, "", (String)localObject1, false);
      ReadInJoyBaseAdapter.a(localArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.e());
      return;
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969659, this, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367354));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367353));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
      paramObject = paramObject.a();
      if (paramObject != null) {
        break label47;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcSource", 2, "article info is null");
      }
    }
    return;
    label47:
    if ((ReadInJoyBaseAdapter.f(paramObject)) || ((ReadInJoyBaseAdapter.g(paramObject)) && (!ReadInJoyBaseAdapter.k(paramObject))) || (ReadInJoyUtils.f(paramObject)) || ((ReadInJoyUtils.g(paramObject)) && (!ReadInJoyBaseAdapter.j(paramObject))) || (ReadInJoyBaseAdapter.b(paramObject)))
    {
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = paramObject.businessName;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(paramObject.businessNamePrefix))
    {
      localSpannableStringBuilder.append(paramObject.businessNamePrefix);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#07D0B0")), 0, localSpannableStringBuilder.length(), 33);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramObject.businessUrl;
      return;
      localSpannableStringBuilder.append((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource
 * JD-Core Version:    0.7.0.1
 */