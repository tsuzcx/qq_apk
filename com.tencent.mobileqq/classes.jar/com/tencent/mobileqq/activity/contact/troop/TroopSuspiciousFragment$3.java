package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.ViewHolder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

class TroopSuspiciousFragment$3
  extends CommonAdapter<MessageRecord>
{
  TroopSuspiciousFragment$3(TroopSuspiciousFragment paramTroopSuspiciousFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new SuspiciousHolder(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131374134));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374117));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131374125));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374138));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131374123));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131374135));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131374137));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131374124));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131374133));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131379998));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131379997);
    TroopSuspiciousHelper.a(paramContext.a(), false);
    return paramContext;
  }
  
  protected void a(ViewHolder paramViewHolder, MessageRecord paramMessageRecord, int paramInt)
  {
    TroopSuspiciousFragment.a(this.a, paramViewHolder, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment.3
 * JD-Core Version:    0.7.0.1
 */