package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import mqq.util.WeakReference;

public class PositionActivatePage
  extends ActivateBasePage
{
  String k;
  private WeakReference<ActivateFriendActivity> l;
  private ActivateFriendGrid.GridCallBack m = new PositionActivatePage.1(this);
  private View.OnClickListener n = new PositionActivatePage.2(this);
  private View.OnClickListener o = new PositionActivatePage.3(this);
  
  public PositionActivatePage(Context paramContext)
  {
    super(paramContext);
    this.l = new WeakReference((ActivateFriendActivity)paramContext);
    this.f.setText(2131886167);
    this.f.setOnClickListener(this.n);
    this.i.setGridCallBack(this.m);
    this.g.setVisibility(0);
    this.g.setOnClickListener(this.o);
  }
  
  public void a()
  {
    this.b = this.a.inflate(2131627243, this, false);
    this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.c = ((TextView)this.b.findViewById(2131427595));
    this.d = ((TextView)this.b.findViewById(2131427591));
    this.e = ((TextView)this.b.findViewById(2131427592));
    this.f = ((Button)this.b.findViewById(2131427589));
    this.g = ((TextView)this.b.findViewById(2131427594));
    this.h = ((TextView)this.b.findViewById(2131427588));
    this.i = ((ActivateFriendGrid)this.b.findViewById(2131433777));
    a((TextView)this.b.findViewById(2131427610));
    addView(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.PositionActivatePage
 * JD-Core Version:    0.7.0.1
 */