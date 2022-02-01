package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TextData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class WebFastTextViewCreator$TextViewHolder
  extends BaseItemViewHolder
  implements View.OnLongClickListener
{
  private TextView a;
  private View b;
  private View c;
  
  public WebFastTextViewCreator$TextViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380639));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363750);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131380890);
    paramView.setOnLongClickListener(this);
  }
  
  private void a(TextData paramTextData)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131166905));
    if (paramTextData.jdField_b_of_type_Int == 3)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#999999"));
    }
    while (paramTextData.jdField_b_of_type_Int != 2) {
      return;
    }
    double d;
    if ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      paramTextData = new TextPaint();
      paramTextData.setTextSize(this.jdField_a_of_type_Float);
      d = paramTextData.getFontMetrics().descent - paramTextData.getFontMetrics().ascent;
      if (d > 0.0D) {
        break label184;
      }
      d = this.jdField_a_of_type_Float;
    }
    label184:
    for (;;)
    {
      ((LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).setMargins(0, (int)(d / 2.0D + 0.5D + this.jdField_c_of_type_Int), AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidWidgetTextView.getResources()), 0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.s)
    {
    default: 
      return;
    }
    paramBaseData1 = (TextData)paramBaseData2;
    if (this.jdField_a_of_type_Float > 0.0F) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_Float);
    }
    if ((this.d > 0) && (this.jdField_c_of_type_Int > 0))
    {
      this.jdField_c_of_type_Int = Utils.dp2px(Double.valueOf(this.jdField_c_of_type_Int).doubleValue());
      this.d = Utils.dp2px(Double.valueOf(this.d).doubleValue());
      this.jdField_a_of_type_AndroidViewView.setPadding(this.d, 0, this.d, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, this.jdField_c_of_type_Int, 0, this.jdField_c_of_type_Int);
    }
    if (this.jdField_b_of_type_Float > 0.0F)
    {
      this.jdField_b_of_type_Float = Utils.dp2px(Double.valueOf(this.jdField_b_of_type_Float).doubleValue());
      this.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(this.jdField_b_of_type_Float, 1.0F);
    }
    if (this.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(paramBaseData1.jdField_a_of_type_Int);
    a(paramBaseData1);
  }
  
  public boolean onLongClick(View paramView)
  {
    new QQCustomMenu().a(0, HardCodeUtil.a(2131716712));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemOnItemClickListener.a(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastTextViewCreator.TextViewHolder
 * JD-Core Version:    0.7.0.1
 */