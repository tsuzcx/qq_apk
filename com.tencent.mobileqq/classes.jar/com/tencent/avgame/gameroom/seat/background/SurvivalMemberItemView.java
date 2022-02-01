package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.widget.RoundCorneredRelativeLayout;
import java.util.Random;

public class SurvivalMemberItemView
  extends RelativeLayout
{
  public SurvivalMemberInfo a;
  public ImageView b;
  public RoundCorneredRelativeLayout c;
  private Animator.AnimatorListener d = new SurvivalMemberItemView.1(this);
  private Animator.AnimatorListener e = new SurvivalMemberItemView.2(this);
  
  public SurvivalMemberItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SurvivalMemberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SurvivalMemberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(long paramLong, UserInfoHandler paramUserInfoHandler)
  {
    if (20 < new Random().nextInt(100) % 100 + 1) {
      return UserInfoHandler.a();
    }
    return paramUserInfoHandler.a(String.valueOf(paramLong), (byte)1, true, true);
  }
  
  public void a()
  {
    this.c = ((RoundCorneredRelativeLayout)findViewById(2131447698));
    float f = GameRoomViewLayoutParamsDef.K / 6;
    this.c.setRadius(f, f, f, f);
    this.b = ((ImageView)findViewById(2131440088));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.K;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.L;
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, SurvivalMemberInfo paramSurvivalMemberInfo, ISurvivalSeatBgPresenter paramISurvivalSeatBgPresenter)
  {
    if ((paramSurvivalMemberInfo != null) && (paramSurvivalMemberInfo.a() >= 0L) && (paramSurvivalMemberInfo.c() != -1) && (IGameEngine.K() != null))
    {
      this.a = paramSurvivalMemberInfo;
      this.b.setImageBitmap(a(paramSurvivalMemberInfo.a(), paramUserInfoHandler));
      this.b.setAlpha(0.5F);
      if (paramSurvivalMemberInfo.b() == 0) {
        paramISurvivalSeatBgPresenter.a(this, this.d);
      }
      return;
    }
    paramUserInfoHandler = this.a;
    if ((paramUserInfoHandler != null) && (paramUserInfoHandler.a() < 0L) && (this.a.c() >= 0) && (this.a.b() != 0)) {
      paramISurvivalSeatBgPresenter.b(this, this.e);
    } else {
      this.b.setImageBitmap(null);
    }
    this.b.setBackgroundColor(getContext().getResources().getColor(2131165551));
    this.a = paramSurvivalMemberInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalMemberItemView
 * JD-Core Version:    0.7.0.1
 */