package com.tencent.biz.addContactTroopView;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class TroopCardPopClassfic$ViewHolder
  extends RecyclerView.ViewHolder
{
  public ImageView a;
  public TextView a;
  
  public TroopCardPopClassfic$ViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373362));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373361));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic.ViewHolder
 * JD-Core Version:    0.7.0.1
 */