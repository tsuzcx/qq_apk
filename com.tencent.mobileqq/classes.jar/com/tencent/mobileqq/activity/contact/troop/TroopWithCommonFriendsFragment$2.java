package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;

class TroopWithCommonFriendsFragment$2
  extends CommonAdapter<CommonTroopData>
{
  TroopWithCommonFriendsFragment$2(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new TroopCommonHolder(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373689));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373672));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373680));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373678));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373690));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131373688));
    return paramContext;
  }
  
  protected void a(ViewHolder paramViewHolder, CommonTroopData paramCommonTroopData, int paramInt)
  {
    TroopWithCommonFriendsFragment.a(this.a, paramViewHolder, paramCommonTroopData, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.2
 * JD-Core Version:    0.7.0.1
 */