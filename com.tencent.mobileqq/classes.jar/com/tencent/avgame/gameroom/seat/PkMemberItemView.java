package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class PkMemberItemView
  extends RelativeLayout
{
  public SeatMemberInfo a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public ImageView e;
  public View f;
  public TalkingEffectLayout g;
  public RoundCorneredRelativeLayout h;
  private TextView i;
  private TextView j;
  private TextView k;
  private Drawable l;
  private ImageView m;
  
  public PkMemberItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PkMemberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PkMemberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView1, View paramView2)
  {
    float f1 = ViewUtils.dpToPx(3.0F);
    float f2 = -f1;
    float f3 = f1 / 2.0F;
    float f4 = f2 / 2.0F;
    float f5 = f1 / 4.0F;
    float f6 = f2 / 4.0F;
    paramView1 = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { 0.0F, f1, f2, f1, f2, f3, f4, f5, f6, 0.0F });
    paramView2 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { 0.0F, f1, f2, f1, f2, f3, f4, f5, f6, 0.0F });
    paramView1.setDuration(500L);
    paramView2.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.playTogether(new Animator[] { paramView2, paramView1 });
    localAnimatorSet.start();
  }
  
  private Drawable getDefaultColorDrawable()
  {
    if (this.l == null) {
      this.l = new ColorDrawable(-13618879);
    }
    return this.l;
  }
  
  public MemberVideoDisplayInfo a(ISeatPresenter paramISeatPresenter)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((SeatMemberInfo)localObject).a != null))
    {
      localObject = new MemberVideoDisplayInfo();
      int[] arrayOfInt = new int[2];
      String str = this.a.a.uin;
      GameRoomViewLayoutParamsDef.a(this.e, arrayOfInt);
      boolean bool2 = false;
      ((MemberVideoDisplayInfo)localObject).b = arrayOfInt[0];
      ((MemberVideoDisplayInfo)localObject).c = arrayOfInt[1];
      ((MemberVideoDisplayInfo)localObject).d = this.e.getMeasuredWidth();
      ((MemberVideoDisplayInfo)localObject).e = this.e.getMeasuredHeight();
      ((MemberVideoDisplayInfo)localObject).a = Long.valueOf(str).longValue();
      paramISeatPresenter = paramISeatPresenter.a(str);
      boolean bool1 = bool2;
      if (paramISeatPresenter != null)
      {
        bool1 = bool2;
        if (paramISeatPresenter.hasCameraVideo()) {
          bool1 = true;
        }
      }
      ((MemberVideoDisplayInfo)localObject).g = bool1;
      if (IGameEngine.J())
      {
        if (QLog.isColorLevel())
        {
          paramISeatPresenter = new StringBuilder();
          paramISeatPresenter.append("getVideoDisplayInfo info:");
          paramISeatPresenter.append(((MemberVideoDisplayInfo)localObject).toString());
          QLog.i("PkMemberItemView", 2, paramISeatPresenter.toString());
        }
        return localObject;
      }
      paramISeatPresenter = IGameEngine.I().s();
      if ((bool1) && (paramISeatPresenter.d(str))) {
        ((MemberVideoDisplayInfo)localObject).h = true;
      } else if (paramISeatPresenter.e(str)) {
        ((MemberVideoDisplayInfo)localObject).m = true;
      }
      if (QLog.isColorLevel())
      {
        paramISeatPresenter = new StringBuilder();
        paramISeatPresenter.append("getVideoDisplayInfo info:");
        paramISeatPresenter.append(((MemberVideoDisplayInfo)localObject).toString());
        QLog.i("PkMemberItemView", 2, paramISeatPresenter.toString());
      }
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    this.b = ((TextView)findViewById(2131439121));
    this.c = ((TextView)findViewById(2131445312));
    this.d = ((ImageView)findViewById(2131445316));
    this.e = ((ImageView)findViewById(2131440088));
    this.g = ((TalkingEffectLayout)findViewById(2131446842));
    this.g.setAnimatorListener(new PkMemberItemView.1(this));
    this.f = findViewById(2131437992);
    this.h = ((RoundCorneredRelativeLayout)findViewById(2131447698));
    float f1 = ViewUtils.dip2px(12.0F);
    this.h.setRadius(f1, f1, f1, f1);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    this.h.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    if (IGameEngine.I().D())
    {
      localLayoutParams.width = (GameRoomViewLayoutParamsDef.F + ViewUtils.dip2px(11.0F));
      localLayoutParams.height = (GameRoomViewLayoutParamsDef.F + ViewUtils.dip2px(11.0F));
    }
    else
    {
      localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
      localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    }
    this.g.setLayoutParams(localLayoutParams);
    this.j = ((TextView)findViewById(2131448262));
    this.i = ((TextView)findViewById(2131448261));
    this.m = ((ImageView)findViewById(2131434897));
    this.m.setVisibility(8);
    this.k = ((TextView)findViewById(2131448265));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showAnswerResult isSelf:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" type: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("PkMemberItemView", 2, ((StringBuilder)localObject).toString());
    }
    if (IGameEngine.J()) {
      return;
    }
    Object localObject = IGameEngine.I().s().x;
    this.k.setVisibility(0);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.k.setText("");
          this.k.setVisibility(4);
          return;
        }
        this.k.setText(2131887212);
        this.k.setTextColor(Color.parseColor(((FontStyleConfig)localObject).F));
        return;
      }
      this.k.setText(2131887213);
      this.k.setTextColor(Color.parseColor(((FontStyleConfig)localObject).E));
      return;
    }
    this.k.setText(2131887211);
    this.k.setTextColor(Color.parseColor(((FontStyleConfig)localObject).G));
  }
  
  public void a(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.e, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new PkMemberItemView.3(this, paramView));
    localObjectAnimator.start();
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    this.e.setImageDrawable(getDefaultColorDrawable());
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setVisibility(8);
    this.f.setVisibility(0);
    this.b.setText(getResources().getString(2131887336));
    paramISeatPresenter.a(false, paramBoolean);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, SeatMemberInfo paramSeatMemberInfo, ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    if ((paramSeatMemberInfo != null) && (paramSeatMemberInfo.a != null))
    {
      if (IGameEngine.K() == null) {
        return;
      }
      EngineData localEngineData = IGameEngine.I().s();
      Player localPlayer = paramSeatMemberInfo.a;
      this.a = paramSeatMemberInfo;
      if (TextUtils.isEmpty(localPlayer.nick)) {
        localObject = localPlayer.uin;
      } else {
        localObject = localPlayer.nick;
      }
      this.b.setText((CharSequence)localObject);
      int n = 0;
      if (!IGameEngine.J()) {
        n = localEngineData.b(localPlayer.uin);
      }
      this.c.setText(String.valueOf(n));
      Object localObject = this.c;
      int i1;
      if (paramBoolean) {
        i1 = 21;
      } else {
        i1 = 19;
      }
      ((TextView)localObject).setGravity(i1);
      b(paramUserInfoHandler, paramSeatMemberInfo, paramISeatPresenter, paramBoolean);
      paramSeatMemberInfo = this.d;
      if (paramBoolean) {
        paramUserInfoHandler = "avgame_pk_score_blue@2x.png";
      } else {
        paramUserInfoHandler = "avgame_pk_score_red@2x.png";
      }
      paramSeatMemberInfo.setImageBitmap(AVGameUtil.c(paramUserInfoHandler));
      this.f.setVisibility(8);
      if (QLog.isColorLevel())
      {
        paramUserInfoHandler = new StringBuilder();
        paramUserInfoHandler.append("update player:");
        paramUserInfoHandler.append(localPlayer);
        paramUserInfoHandler.append(" iScore:");
        paramUserInfoHandler.append(n);
        paramUserInfoHandler.append(" player:");
        paramUserInfoHandler.append(localPlayer);
        QLog.i("PkMemberItemView", 2, paramUserInfoHandler.toString());
      }
    }
  }
  
  public void a(ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    this.e.setImageDrawable(getDefaultColorDrawable());
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setVisibility(0);
    this.b.setText(getResources().getString(2131887335));
    paramISeatPresenter.a(false, paramBoolean);
  }
  
  public void a(SeatMemberInfo paramSeatMemberInfo)
  {
    if ((paramSeatMemberInfo != null) && (paramSeatMemberInfo.a != null))
    {
      if (IGameEngine.K() == null) {
        return;
      }
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      Player localPlayer = paramSeatMemberInfo.a;
      this.a = paramSeatMemberInfo;
      if (!IGameEngine.J())
      {
        this.c.setText(String.valueOf(IGameEngine.I().s().b(localPlayer.uin)));
        if (QLog.isColorLevel())
        {
          paramSeatMemberInfo = new StringBuilder();
          paramSeatMemberInfo.append("updateScore player score:");
          paramSeatMemberInfo.append(IGameEngine.I().s().b(localPlayer.uin));
          QLog.i("PkMemberItemView", 2, paramSeatMemberInfo.toString());
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.m.setImageBitmap(AVGameUtil.c(paramString));
    this.m.setVisibility(0);
    paramString = this.m.getLayoutParams();
    paramString.width = (GameRoomViewLayoutParamsDef.F + ViewUtils.dpToPx(12.0F));
    paramString.height = (GameRoomViewLayoutParamsDef.F + ViewUtils.dpToPx(12.0F));
    this.m.setLayoutParams(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playSpeakingAnim isSpeaking = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("PkMemberItemView", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.g.a();
      return;
    }
    this.g.b();
    this.g.setVisibility(4);
    this.b.setTextColor(-1);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    this.i.setText(String.format("%.2fs", new Object[] { Float.valueOf(paramInt / 1000.0F) }));
    this.i.setVisibility(0);
    this.j.setVisibility(0);
    if (paramBoolean)
    {
      this.i.setTextColor(getResources().getColor(2131165550));
      this.j.setTextColor(getResources().getColor(2131165550));
      return;
    }
    this.i.setTextColor(getResources().getColor(2131168464));
    this.j.setTextColor(getResources().getColor(2131168464));
  }
  
  public boolean b()
  {
    return this.a == null;
  }
  
  public boolean b(UserInfoHandler paramUserInfoHandler, SeatMemberInfo paramSeatMemberInfo, ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    if ((paramSeatMemberInfo != null) && (paramSeatMemberInfo.a != null))
    {
      if (IGameEngine.K() == null) {
        return false;
      }
      paramSeatMemberInfo = paramSeatMemberInfo.a;
      AVGameUserInfo localAVGameUserInfo = paramISeatPresenter.a(String.valueOf(paramSeatMemberInfo.uin));
      int n;
      if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasCameraVideo())) {
        n = 1;
      } else {
        n = 0;
      }
      int i1;
      if ((!IGameEngine.J()) && (n != 0) && (IGameEngine.I().s().d(paramSeatMemberInfo.uin))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      boolean bool;
      if ((n != 0) && (i1 == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        this.e.setImageDrawable(null);
        paramISeatPresenter.a(true, paramBoolean);
        return bool;
      }
      this.e.setImageBitmap(paramUserInfoHandler.a(String.valueOf(paramSeatMemberInfo.uin), (byte)1, true, false));
      paramISeatPresenter.a(false, paramBoolean);
      return bool;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    SeatMemberInfo localSeatMemberInfo = this.a;
    return (localSeatMemberInfo != null) && (localSeatMemberInfo.a != null) && (TextUtils.equals(paramString, this.a.a.uin));
  }
  
  public void c()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(new FloatEvaluator(), new Object[] { Float.valueOf(1.0F), Float.valueOf(0.0F) });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new PkMemberItemView.2(this));
    localValueAnimator.start();
  }
  
  public void d()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (this.e.getColorFilter() != null) {
        this.e.setColorFilter(null);
      }
    }
    else {
      this.e.setColorFilter(null);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.h.a(true);
    this.h.postInvalidate();
  }
  
  public void e()
  {
    this.c.setText("0");
  }
  
  public void f()
  {
    this.i.setVisibility(4);
    this.j.setVisibility(4);
  }
  
  public RectF getPlayerHeadViewRect()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((SeatMemberInfo)localObject1).a != null))
    {
      Object localObject2 = new int[2];
      GameRoomViewLayoutParamsDef.a(this, (int[])localObject2);
      localObject1 = new RectF();
      ((RectF)localObject1).left = localObject2[0];
      ((RectF)localObject1).top = localObject2[1];
      ((RectF)localObject1).right = (((RectF)localObject1).left + getMeasuredWidth());
      ((RectF)localObject1).bottom = (((RectF)localObject1).top + getMeasuredHeight());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getPlayerHeadViewRect rectF:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("PkMemberItemView", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkMemberItemView
 * JD-Core Version:    0.7.0.1
 */