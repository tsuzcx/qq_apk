package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class BirthdayActivatePage
  extends ActivateBasePage
{
  public long[] k = null;
  private WeakReference<ActivateFriendActivity> l;
  private View.OnClickListener m = new BirthdayActivatePage.1(this);
  private ActivateFriendGrid.GridCallBack n = new BirthdayActivatePage.2(this);
  
  public BirthdayActivatePage(Context paramContext)
  {
    super(paramContext);
    this.l = new WeakReference((ActivateFriendActivity)paramContext);
    this.f.setText(2131886166);
    this.f.setOnClickListener(this.m);
    this.i.setGridCallBack(this.n);
    this.h.setVisibility(0);
  }
  
  public void a()
  {
    this.b = this.a.inflate(2131627242, this, false);
    this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.c = ((TextView)this.b.findViewById(2131427595));
    this.f = ((Button)this.b.findViewById(2131427589));
    this.g = ((TextView)this.b.findViewById(2131427594));
    this.h = ((TextView)this.b.findViewById(2131427588));
    this.i = ((ActivateFriendGrid)this.b.findViewById(2131433777));
    a((TextView)this.b.findViewById(2131427610));
    addView(this.b);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BirthdayActivatePage.class.getSimpleName(), 2, "hideLoading ");
    }
    findViewById(2131429402).setVisibility(0);
    if (this.k == null) {
      findViewById(2131432518).setVisibility(0);
    } else {
      findViewById(2131432518).setVisibility(8);
    }
    findViewById(2131427593).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage
 * JD-Core Version:    0.7.0.1
 */