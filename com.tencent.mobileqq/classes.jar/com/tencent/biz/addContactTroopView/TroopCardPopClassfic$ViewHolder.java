package com.tencent.biz.addContactTroopView;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class TroopCardPopClassfic$ViewHolder
  extends RecyclerView.ViewHolder
{
  public TextView a;
  public ImageView b;
  
  public TroopCardPopClassfic$ViewHolder(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131440503));
    this.b = ((ImageView)paramView.findViewById(2131440502));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.b.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
      return;
    }
    this.b.setColorFilter(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic.ViewHolder
 * JD-Core Version:    0.7.0.1
 */