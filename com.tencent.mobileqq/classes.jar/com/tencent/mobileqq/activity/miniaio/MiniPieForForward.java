package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.Observable;

public class MiniPieForForward
  extends MiniPie
{
  private View Y;
  private RelativeLayout Z;
  private ForwardTroopMemberControllerForMiniPie aa = null;
  private RelativeLayout ab;
  private boolean ac = false;
  
  public MiniPieForForward(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
  }
  
  private void C()
  {
    if (this.Z == null)
    {
      QLog.e(this.a, 2, "mGroupMemberView null");
      return;
    }
    QLog.i(this.a, 2, "hideGroupMemberDialog");
    this.ac = false;
    if (this.q != null) {
      this.q.setBackgroundResource(2130840457);
    }
    if (this.m != null) {
      this.m.setBackgroundDrawable(this.b.getResources().getDrawable(2130840457));
    }
    RelativeLayout localRelativeLayout = this.ab;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(0);
    }
    this.Z.setVisibility(8);
  }
  
  private float D()
  {
    Intent localIntent = ((Activity)this.b).getIntent();
    float f = 0.78F;
    if (localIntent != null) {
      f = localIntent.getFloatExtra("minaio_scaled_ration", 0.78F);
    }
    if (!MiniPieHelper.e()) {
      f = 1.0F;
    }
    return f;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.Z == null)
    {
      QLog.e(this.a, 2, "mGroupMemberView null");
      return;
    }
    if ((paramInt != 1) && (paramInt != 3000))
    {
      QLog.e(this.a, 2, "showGroupMemberDialog with wrong uin type");
      return;
    }
    ReportController.b(this.d, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 2, 0, "", "", "", "");
    QLog.i(this.a, 2, "showGroupMemberDialog");
    RelativeLayout localRelativeLayout = this.ab;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(4);
    }
    float f = D();
    if (this.aa == null)
    {
      this.aa = new ForwardTroopMemberControllerForMiniPie(this.b);
      this.aa.a(this.d, paramString, paramInt, f);
      paramString = this.aa.a();
      if (paramString != null) {
        this.Z.addView(paramString);
      }
    }
    this.ac = true;
    if (this.q != null) {
      this.q.setBackgroundResource(2130840449);
    }
    if (this.m != null) {
      this.m.setBackgroundDrawable(this.b.getResources().getDrawable(2130840449));
    }
    this.Z.setVisibility(0);
  }
  
  protected void A()
  {
    this.a = "MiniPieForForward";
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void e() {}
  
  protected void i()
  {
    super.i();
    if (this.n != null) {
      this.n.setVisibility(0);
    }
    if (this.m != null)
    {
      this.ab = ((RelativeLayout)this.m.findViewById(2131444906));
      if ((this.f != 1) && (this.f != 3000))
      {
        localObject = this.ab;
        if (localObject != null) {
          ((RelativeLayout)localObject).setVisibility(4);
        }
      }
      else
      {
        localObject = this.ab;
        if (localObject != null)
        {
          ((RelativeLayout)localObject).setVisibility(0);
          this.ab.setOnClickListener(this);
        }
        localObject = (ImageView)this.m.findViewById(2131436194);
        if (localObject != null) {
          ((ImageView)localObject).setBackgroundResource(2130840454);
        }
      }
      this.m.setBackgroundResource(2130840457);
    }
    float f = D();
    this.q.setBackgroundResource(2130840457);
    this.Y = this.q.findViewById(2131432003);
    Object localObject = this.Y;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    this.Z = ((RelativeLayout)this.q.findViewById(2131434434));
    localObject = (RelativeLayout)this.q.findViewById(2131444897);
    if (localObject != null)
    {
      int i = this.b.getResources().getDimensionPixelSize(2131297496);
      if ((f > 0.0F) && (f <= 1.0F))
      {
        i = (int)(i / f);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = i;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
        double d = f;
        Double.isNaN(d);
        i = (int)(16.0D / d);
        localObject = (TextView)this.q.findViewById(2131447463);
        if (localObject != null)
        {
          ((TextView)localObject).setTextSize(2, i);
          ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(0));
          localLayoutParams = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
          localLayoutParams.setMargins((int)(localLayoutParams.leftMargin / f), (int)(localLayoutParams.topMargin / f), (int)(localLayoutParams.rightMargin / f), (int)(localLayoutParams.bottomMargin / f));
          ((TextView)localObject).setLayoutParams(localLayoutParams);
        }
        localObject = (RelativeLayout)this.q.findViewById(2131436180);
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.height = ((int)(localLayoutParams.height / f));
            localLayoutParams.width = ((int)(localLayoutParams.width / f));
            ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
          }
        }
        localObject = (ImageView)this.q.findViewById(2131435503);
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.height = ((int)(localLayoutParams.height / f));
            localLayoutParams.width = ((int)(localLayoutParams.width / f));
            localLayoutParams.setMargins((int)(localLayoutParams.leftMargin / f), (int)(localLayoutParams.topMargin / f), (int)(localLayoutParams.rightMargin / f), (int)(localLayoutParams.bottomMargin / f));
            ((ImageView)localObject).setLayoutParams(localLayoutParams);
          }
        }
        localObject = (ImageView)this.q.findViewById(2131436194);
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            i = (int)(AIOUtils.b(18.0F, this.b.getResources()) / f);
            localLayoutParams.height = i;
            localLayoutParams.width = i;
            ((ImageView)localObject).setLayoutParams(localLayoutParams);
          }
        }
      }
    }
  }
  
  protected void j()
  {
    super.j();
    this.s.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131436180)
    {
      if (i == 2131444906) {
        a(this.g, this.f);
      }
    }
    else {
      t();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.E.b(20);
  }
  
  public void t()
  {
    if (this.ac)
    {
      C();
      return;
    }
    QLog.i(this.a, 2, "doOnFinish");
    Object localObject = this.Z;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).removeAllViews();
      localObject = this.aa;
      if (localObject != null)
      {
        ((ForwardTroopMemberControllerForMiniPie)localObject).b();
        this.aa = null;
      }
    }
    super.t();
    ((Activity)this.b).overridePendingTransition(0, 0);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObservable = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" update");
      QLog.d(paramObservable, 2, localStringBuilder.toString());
    }
    if ((paramObject instanceof RefreshMessageContext))
    {
      paramObservable = (RefreshMessageContext)paramObject;
      paramObject = (ChatContext)paramObservable.a;
      if ((this.c.b != null) && (this.c.b.equals(paramObject.a())))
      {
        if ((this.H == paramObject.b()) && (paramObservable.j) && (paramObservable.f))
        {
          long l = this.H + 300L - SystemClock.uptimeMillis();
          if (l <= 0L) {
            l = 0L;
          }
          a(131076, l);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "refreshMessageContext sync theSameUinAIO return");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.a, 2, "update--> do nothing");
    }
  }
  
  protected void y()
  {
    ImageButton localImageButton = (ImageButton)this.q.findViewById(2131427978);
    if (localImageButton != null) {
      localImageButton.setVisibility(8);
    }
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieForForward
 * JD-Core Version:    0.7.0.1
 */