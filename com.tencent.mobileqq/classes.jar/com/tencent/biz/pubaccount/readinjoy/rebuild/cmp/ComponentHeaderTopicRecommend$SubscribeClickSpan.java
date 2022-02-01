package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.ClickableSpanPressed;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.mobileqq.utils.Base64Util;

public class ComponentHeaderTopicRecommend$SubscribeClickSpan
  extends ClickableSpan
  implements ReadInJoyYAFolderTextView.ClickableSpanPressed
{
  private int jdField_a_of_type_Int = -1;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  protected String a;
  boolean jdField_a_of_type_Boolean;
  
  public ComponentHeaderTopicRecommend$SubscribeClickSpan(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidTextTextPaint != null) {
      updateDrawState(this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = ReadInJoyConstants.k + Base64Util.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 0);
    if ((!TextUtils.isEmpty(paramView)) && (ViolaAccessHelper.b(paramView)))
    {
      ViolaAccessHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.getContext(), null, ViolaAccessHelper.c(paramView), null);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.getContext(), PublicAccountBrowserImpl.class);
    localIntent.putExtra("url", paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.getContext().startActivity(localIntent);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = -1)
    {
      paramTextPaint.bgColor = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend.SubscribeClickSpan
 * JD-Core Version:    0.7.0.1
 */