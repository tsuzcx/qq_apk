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
    paramContext.c = ((LinearLayout)paramViewGroup.findViewById(2131441363));
    paramContext.d = ((ImageView)paramViewGroup.findViewById(2131441346));
    paramContext.e = ((LinearLayout)paramViewGroup.findViewById(2131441354));
    paramContext.f = ((TextView)paramViewGroup.findViewById(2131441352));
    paramContext.g = ((TextView)paramViewGroup.findViewById(2131441364));
    paramContext.h = ((Button)paramViewGroup.findViewById(2131441362));
    return paramContext;
  }
  
  protected void a(ViewHolder paramViewHolder, CommonTroopData paramCommonTroopData, int paramInt)
  {
    TroopWithCommonFriendsFragment.a(this.a, paramViewHolder, paramCommonTroopData, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.2
 * JD-Core Version:    0.7.0.1
 */