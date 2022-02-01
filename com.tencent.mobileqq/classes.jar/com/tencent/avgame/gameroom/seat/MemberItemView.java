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
  public ImageView a;
  public TextView a;
  public CoverRoundCornerRelativeLayout a;
  public SeatMemberInfo a;
  public TalkingEffectLayout a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  
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
  
  private boolean a()
  {
    if (AVGameUtil.b() == 2)
    {
      if (IGameEngine.a().a()) {
        return IGameEngine.a().e();
      }
      return true;
    }
    return false;
  }
  
  public RectF a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
    if ((localObject1 != null) && (((SeatMemberInfo)localObject1).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null))
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
  
  public MemberVideoDisplayInfo a(ISeatPresenter paramISeatPresenter)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
    if ((localObject != null) && (((SeatMemberInfo)localObject).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null))
    {
      localObject = new MemberVideoDisplayInfo();
      int[] arrayOfInt = new int[2];
      String str = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin;
      GameRoomViewLayoutParamsDef.a(this.jdField_c_of_type_AndroidWidgetImageView, arrayOfInt);
      boolean bool2 = false;
      ((MemberVideoDisplayInfo)localObject).jdField_a_of_type_Int = arrayOfInt[0];
      ((MemberVideoDisplayInfo)localObject).jdField_b_of_type_Int = arrayOfInt[1];
      ((MemberVideoDisplayInfo)localObject).jdField_c_of_type_Int = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredWidth();
      ((MemberVideoDisplayInfo)localObject).d = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredHeight();
      ((MemberVideoDisplayInfo)localObject).jdField_a_of_type_Long = Long.valueOf(str).longValue();
      paramISeatPresenter = paramISeatPresenter.a(str);
      boolean bool1 = bool2;
      if (paramISeatPresenter != null)
      {
        bool1 = bool2;
        if (paramISeatPresenter.hasCameraVideo()) {
          bool1 = true;
        }
      }
      ((MemberVideoDisplayInfo)localObject).jdField_a_of_type_Boolean = bool1;
      if (IGameEngine.k())
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
      if ((bool1) && (IGameEngine.a().a().b(str))) {
        ((MemberVideoDisplayInfo)localObject).jdField_b_of_type_Boolean = true;
      } else if (IGameEngine.a().a().c(str)) {
        ((MemberVideoDisplayInfo)localObject).jdField_c_of_type_Boolean = true;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376951));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376952));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372550));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368283));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376154));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout = ((TalkingEffectLayout)findViewById(2131378320));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setAnimatorListener(new MemberItemView.1(this));
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout = ((CoverRoundCornerRelativeLayout)findViewById(2131378987));
    float f = GameRoomViewLayoutParamsDef.F * 24 / 180;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setRadius(getResources().getColor(2131165311), f);
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setPressCoverColor(1073741824);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, SeatMemberInfo paramSeatMemberInfo, ISeatPresenter paramISeatPresenter)
  {
    if ((paramSeatMemberInfo != null) && (paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) && (IGameEngine.a() != null))
    {
      if (IGameEngine.k()) {
        return;
      }
      EngineData localEngineData = IGameEngine.a().a();
      Player localPlayer = paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = paramSeatMemberInfo;
      String str;
      if (TextUtils.isEmpty(localPlayer.nick)) {
        str = localPlayer.uin;
      } else {
        str = localPlayer.nick;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      int i = localEngineData.a(localPlayer.uin);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
      paramISeatPresenter = paramISeatPresenter.a(String.valueOf(localPlayer.uin));
      boolean bool1;
      if ((paramISeatPresenter != null) && (paramISeatPresenter.hasCameraVideo())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((bool1) && (localEngineData.b(localPlayer.uin))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((bool1) && (!bool2)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(null);
      } else {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramUserInfoHandler.a(String.valueOf(localPlayer.uin), (byte)1));
      }
      if (localPlayer.isHost())
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838666);
      }
      int j = localEngineData.a();
      if ((j != 0) && (j != 10))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        int k = paramSeatMemberInfo.jdField_a_of_type_Int;
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3) {
              this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838668);
            } else {
              this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838671);
            }
          }
          else {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838670);
          }
        }
        else {
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838669);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if ((j == 0) && (!a()))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (localPlayer.status == 0)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690437);
          if (!localPlayer.isHost()) {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        }
        else
        {
          if (!localPlayer.isHost())
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838667);
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        }
      }
      else
      {
        if (!localPlayer.isHost()) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
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
        paramUserInfoHandler.append(j);
        paramUserInfoHandler.append(" iScore:");
        paramUserInfoHandler.append(i);
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
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.b();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  public boolean a(String paramString)
  {
    SeatMemberInfo localSeatMemberInfo = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
    return (localSeatMemberInfo != null) && (localSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setIsPressed(isPressed());
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.MemberItemView
 * JD-Core Version:    0.7.0.1
 */