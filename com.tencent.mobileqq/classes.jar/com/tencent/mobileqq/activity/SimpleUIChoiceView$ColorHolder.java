package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.QQTheme;

class SimpleUIChoiceView$ColorHolder
  extends RecyclerView.ViewHolder
{
  URLImageView a;
  URLImageView b;
  View c;
  
  public SimpleUIChoiceView$ColorHolder(SimpleUIChoiceView paramSimpleUIChoiceView, View paramView)
  {
    super(paramView);
    this.a = ((URLImageView)paramView.findViewById(2131435503));
    this.b = ((URLImageView)paramView.findViewById(2131435518));
    this.c = paramView.findViewById(2131437622);
  }
  
  private Drawable b()
  {
    Resources localResources = this.itemView.getResources();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(5.0F, localResources));
    if (QQTheme.isNowThemeIsNight())
    {
      localGradientDrawable.setStroke(AIOUtils.b(1.5F, localResources), Color.parseColor("#0066CC"));
      return localGradientDrawable;
    }
    localGradientDrawable.setStroke(AIOUtils.b(1.5F, localResources), Color.parseColor("#0099FF"));
    return localGradientDrawable;
  }
  
  public void a()
  {
    this.b.setBackgroundDrawable(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorHolder
 * JD-Core Version:    0.7.0.1
 */