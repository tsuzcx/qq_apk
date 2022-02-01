package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.relationx.friendclue.FriendClueConfigHelper;
import com.tencent.mobileqq.relationx.friendclue.FriendClueReporter;

public class IntimateContentItemClueView
  extends IntimateContentItemBaseView
{
  FriendClueConfigHelper i;
  private TextView j;
  private Boolean k = Boolean.valueOf(false);
  
  public IntimateContentItemClueView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemClueView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemClueView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131433755) {
      return;
    }
    paramView = this.i;
    if (paramView != null)
    {
      paramView.a(this.h.l(), this.h.k());
      FriendClueReporter.b(1);
    }
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt) {}
  
  protected boolean a()
  {
    if (this.i == null)
    {
      this.i = new FriendClueConfigHelper(this.h.n());
      FriendClueConfigHelper localFriendClueConfigHelper = this.i;
      this.k = Boolean.valueOf(FriendClueConfigHelper.a());
    }
    else
    {
      this.k = Boolean.valueOf(FriendClueConfigHelper.a());
    }
    if (IntimateUtil.a(this.e)) {
      this.k = Boolean.valueOf(false);
    }
    return this.k.booleanValue();
  }
  
  protected void b()
  {
    this.j = ((TextView)LayoutInflater.from(this.a).inflate(2131625173, this, true).findViewById(2131433755));
    this.j.setOnClickListener(this);
  }
  
  protected void c()
  {
    super.c();
    if (this.k.booleanValue()) {
      FriendClueReporter.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemClueView
 * JD-Core Version:    0.7.0.1
 */