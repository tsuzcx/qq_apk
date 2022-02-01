package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BannerVideoInfoWidget3$BannerViewHolder
{
  public View a;
  public ImageView b;
  public TextView c;
  public TextView d;
  public ImageView e;
  public TextView f;
  public int g;
  public Drawable h;
  
  public BannerVideoInfoWidget3$BannerViewHolder(View paramView)
  {
    this.a = paramView.findViewById(2131437267);
    this.b = ((ImageView)paramView.findViewById(2131437266));
    this.c = ((TextView)paramView.findViewById(2131437256));
    this.d = ((TextView)paramView.findViewById(2131437252));
    this.e = ((ImageView)paramView.findViewById(2131437265));
    this.f = ((TextView)paramView.findViewById(2131427516));
    this.g = paramView.getContext().getResources().getDimensionPixelOffset(2131299794);
    this.h = paramView.getContext().getResources().getDrawable(2130840079);
  }
  
  public void a()
  {
    this.a.setBackgroundResource(2130840074);
    View localView = this.a;
    localView.setPadding(localView.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
    this.b.setVisibility(8);
    this.b.setImageResource(2130840079);
    this.d.setVisibility(8);
    this.d.setText("");
    this.d.setTypeface(null, 1);
    this.d.setContentDescription("");
    this.d.setTextColor(-16777216);
    this.c.setVisibility(8);
    this.c.setText("");
    this.c.setContentDescription("");
    this.c.setTextColor(-16777216);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3.BannerViewHolder
 * JD-Core Version:    0.7.0.1
 */