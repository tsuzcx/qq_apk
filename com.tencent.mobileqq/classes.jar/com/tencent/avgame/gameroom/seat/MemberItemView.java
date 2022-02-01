package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.qphone.base.util.QLog;

public class MemberItemView
  extends RelativeLayout
{
  public SeatMemberInfo a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  public TalkingEffectLayout g;
  public CoverRoundCornerRelativeLayout h;
  public TextView i;
  
  public MemberItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MemberItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MemberItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean b()
  {
    if (AVGameUtil.b() == 2)
    {
      if (IGameEngine.I().d()) {
        return IGameEngine.I().v();
      }
      return true;
    }
    return false;
  }
  
  public MemberVideoDisplayInfo a(ISeatPresenter paramISeatPresenter)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((SeatMemberInfo)localObject).a != null))
    {
      localObject = new MemberVideoDisplayInfo();
      int[] arrayOfInt = new int[2];
      String str = this.a.a.uin;
      GameRoomViewLayoutParamsDef.a(this.f, arrayOfInt);
      boolean bool2 = false;
      ((MemberVideoDisplayInfo)localObject).b = arrayOfInt[0];
      ((MemberVideoDisplayInfo)localObject).c = arrayOfInt[1];
      ((MemberVideoDisplayInfo)localObject).d = this.f.getMeasuredWidth();
      ((MemberVideoDisplayInfo)localObject).e = this.f.getMeasuredHeight();
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
          QLog.i("MemberItemView", 2, paramISeatPresenter.toString());
        }
        return localObject;
      }
      if ((bool1) && (IGameEngine.I().s().d(str))) {
        ((MemberVideoDisplayInfo)localObject).h = true;
      } else if (IGameEngine.I().s().e(str)) {
        ((MemberVideoDisplayInfo)localObject).m = true;
      }
      if (QLog.isColorLevel())
      {
        paramISeatPresenter = new StringBuilder();
        paramISeatPresenter.append("getVideoDisplayInfo info:");
        paramISeatPresenter.append(((MemberVideoDisplayInfo)localObject).toString());
        QLog.i("MemberItemView", 2, paramISeatPresenter.toString());
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
    this.f = ((ImageView)findViewById(2131440088));
    this.e = ((ImageView)findViewById(2131435156));
    this.i = ((TextView)findViewById(2131444356));
    this.g = ((TalkingEffectLayout)findViewById(2131446842));
    this.g.setAnimatorListener(new MemberItemView.1(this));
    this.h = ((CoverRoundCornerRelativeLayout)findViewById(2131447698));
    float f1 = GameRoomViewLayoutParamsDef.F * 24 / 180;
    this.h.setRadius(getResources().getColor(2131165547), f1);
    this.h.setPressCoverColor(1073741824);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    this.h.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    this.g.setLayoutParams(localLayoutParams);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, SeatMemberInfo paramSeatMemberInfo, ISeatPresenter paramISeatPresenter)
  {
    if ((paramSeatMemberInfo != null) && (paramSeatMemberInfo.a != null) && (IGameEngine.K() != null))
    {
      if (IGameEngine.J()) {
        return;
      }
      EngineData localEngineData = IGameEngine.I().s();
      Player localPlayer = paramSeatMemberInfo.a;
      this.a = paramSeatMemberInfo;
      String str;
      if (TextUtils.isEmpty(localPlayer.nick)) {
        str = localPlayer.uin;
      } else {
        str = localPlayer.nick;
      }
      this.b.setText(str);
      int j = localEngineData.b(localPlayer.uin);
      this.c.setText(String.valueOf(j));
      paramISeatPresenter = paramISeatPresenter.a(String.valueOf(localPlayer.uin));
      boolean bool1;
      if ((paramISeatPresenter != null) && (paramISeatPresenter.hasCameraVideo())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((bool1) && (localEngineData.d(localPlayer.uin))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((bool1) && (!bool2)) {
        this.f.setImageBitmap(null);
      } else {
        this.f.setImageBitmap(paramUserInfoHandler.a(String.valueOf(localPlayer.uin), (byte)1));
      }
      if (localPlayer.isHost())
      {
        this.e.setVisibility(0);
        this.e.setImageResource(2130838851);
      }
      int k = localEngineData.j();
      if ((k != 0) && (k != 10))
      {
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        int m = paramSeatMemberInfo.b;
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3) {
              this.d.setBackgroundResource(2130838853);
            } else {
              this.d.setBackgroundResource(2130838859);
            }
          }
          else {
            this.d.setBackgroundResource(2130838857);
          }
        }
        else {
          this.d.setBackgroundResource(2130838855);
        }
      }
      else
      {
        this.c.setVisibility(8);
        this.d.setVisibility(8);
      }
      if ((k == 0) && (!b()))
      {
        this.i.setVisibility(0);
        if (localPlayer.status == 0)
        {
          this.i.setText(2131887348);
          if (!localPlayer.isHost()) {
            this.e.setVisibility(8);
          }
          this.b.setAlpha(0.3F);
        }
        else
        {
          if (!localPlayer.isHost())
          {
            this.e.setVisibility(0);
            this.e.setImageResource(2130838852);
          }
          this.i.setVisibility(8);
          this.b.setAlpha(1.0F);
        }
      }
      else
      {
        if (!localPlayer.isHost()) {
          this.e.setVisibility(8);
        }
        this.i.setVisibility(8);
        this.b.setAlpha(1.0F);
      }
      if (QLog.isColorLevel())
      {
        paramUserInfoHandler = new StringBuilder();
        paramUserInfoHandler.append("update player:");
        paramUserInfoHandler.append(localPlayer);
        paramUserInfoHandler.append(" hasCameraVideo:");
        paramUserInfoHandler.append(bool1);
        paramUserInfoHandler.append(" isBigVideo:");
        paramUserInfoHandler.append(bool2);
        paramUserInfoHandler.append(" gameStatus:");
        paramUserInfoHandler.append(k);
        paramUserInfoHandler.append(" iScore:");
        paramUserInfoHandler.append(j);
        paramUserInfoHandler.append(" player:");
        paramUserInfoHandler.append(localPlayer);
        QLog.i("MemberItemView", 2, paramUserInfoHandler.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playSpeakingAnim isSpeaking = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MemberItemView", 2, localStringBuilder.toString());
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
  
  public boolean a(String paramString)
  {
    SeatMemberInfo localSeatMemberInfo = this.a;
    return (localSeatMemberInfo != null) && (localSeatMemberInfo.a != null) && (TextUtils.equals(paramString, this.a.a.uin));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.h.setIsPressed(isPressed());
    this.h.postInvalidate();
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
        QLog.i("MemberItemView", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.MemberItemView
 * JD-Core Version:    0.7.0.1
 */