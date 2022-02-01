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
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import java.util.Random;

public class SurvivalMemberItemView
  extends RelativeLayout
{
  private Animator.AnimatorListener a;
  public ImageView a;
  public SurvivalMemberInfo a;
  public RoundCorneredRelativeLayout a;
  private Animator.AnimatorListener b = new SurvivalMemberItemView.2(this);
  
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
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new SurvivalMemberItemView.1(this);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)findViewById(2131379643));
    float f = GameRoomViewLayoutParamsDef.z / 6;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setRadius(f, f, f, f);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372963));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.z;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.A;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, SurvivalMemberInfo paramSurvivalMemberInfo, ISurvivalSeatBgPresenter paramISurvivalSeatBgPresenter)
  {
    if ((paramSurvivalMemberInfo == null) || (paramSurvivalMemberInfo.a() < 0L) || (paramSurvivalMemberInfo.b() == -1) || (GameEngine.a().a() == null)) {
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberInfo != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberInfo.a() < 0L) && (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberInfo.b() >= 0) && (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberInfo.a() != 0))
      {
        paramISurvivalSeatBgPresenter.b(this, this.b);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(getContext().getResources().getColor(2131165349));
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberInfo = paramSurvivalMemberInfo;
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
      break;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberInfo = paramSurvivalMemberInfo;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramSurvivalMemberInfo.a(), paramUserInfoHandler));
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
    } while (paramSurvivalMemberInfo.a() != 0);
    paramISurvivalSeatBgPresenter.a(this, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalMemberItemView
 * JD-Core Version:    0.7.0.1
 */