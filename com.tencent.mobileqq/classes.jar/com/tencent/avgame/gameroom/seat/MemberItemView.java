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
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.util.AVGameUtils;
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
    boolean bool = false;
    if (AVGameUtils.b() == 2)
    {
      if (GameEngine.a().a()) {
        bool = GameEngine.a().e();
      }
    }
    else {
      return bool;
    }
    return true;
  }
  
  public RectF a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      localObject = null;
    }
    RectF localRectF;
    do
    {
      return localObject;
      localObject = new int[2];
      GameRoomViewLayoutParamsDef.a(this, (int[])localObject);
      localRectF = new RectF();
      localRectF.left = localObject[0];
      localRectF.top = localObject[1];
      localRectF.right = (localRectF.left + getMeasuredWidth());
      localRectF.bottom = (localRectF.top + getMeasuredHeight());
      localObject = localRectF;
    } while (!QLog.isColorLevel());
    QLog.i("MemberItemView", 2, "getPlayerHeadViewRect rectF:" + localRectF);
    return localRectF;
  }
  
  public MemberVideoDisplayInfo a(ISeatPresenter paramISeatPresenter)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
      return null;
    }
    MemberVideoDisplayInfo localMemberVideoDisplayInfo = new MemberVideoDisplayInfo();
    int[] arrayOfInt = new int[2];
    String str = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin;
    GameRoomViewLayoutParamsDef.a(this.jdField_c_of_type_AndroidWidgetImageView, arrayOfInt);
    localMemberVideoDisplayInfo.jdField_a_of_type_Int = arrayOfInt[0];
    localMemberVideoDisplayInfo.jdField_b_of_type_Int = arrayOfInt[1];
    localMemberVideoDisplayInfo.jdField_c_of_type_Int = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localMemberVideoDisplayInfo.d = this.jdField_c_of_type_AndroidWidgetImageView.getMeasuredHeight();
    localMemberVideoDisplayInfo.jdField_a_of_type_Long = Long.valueOf(str).longValue();
    paramISeatPresenter = paramISeatPresenter.a(str);
    boolean bool1 = bool2;
    if (paramISeatPresenter != null)
    {
      bool1 = bool2;
      if (paramISeatPresenter.hasCameraVideo()) {
        bool1 = true;
      }
    }
    localMemberVideoDisplayInfo.jdField_a_of_type_Boolean = bool1;
    paramISeatPresenter = GameEngine.a().a();
    if ((bool1) && (paramISeatPresenter.b(str))) {
      localMemberVideoDisplayInfo.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MemberItemView", 2, "getVideoDisplayInfo info:" + localMemberVideoDisplayInfo.toString());
      }
      return localMemberVideoDisplayInfo;
      if (paramISeatPresenter.c(str)) {
        localMemberVideoDisplayInfo.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372115));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377508));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377509));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372963));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368539));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376650));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout = ((TalkingEffectLayout)findViewById(2131378933));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setAnimatorListener(new MemberItemView.1(this));
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout = ((CoverRoundCornerRelativeLayout)findViewById(2131379643));
    float f = GameRoomViewLayoutParamsDef.u * 24 / 180;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setRadius(getResources().getColor(2131165345), f);
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setPressCoverColor(1073741824);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.u;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.u;
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.u;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.u;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, SeatMemberInfo paramSeatMemberInfo, ISeatPresenter paramISeatPresenter)
  {
    if ((paramSeatMemberInfo == null) || (paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) || (GameEngine.a().a() == null)) {}
    label141:
    label159:
    label425:
    label570:
    label605:
    for (;;)
    {
      return;
      EngineData localEngineData = GameEngine.a().a();
      Player localPlayer = paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = paramSeatMemberInfo;
      String str;
      int i;
      boolean bool1;
      label120:
      boolean bool2;
      int j;
      if (TextUtils.isEmpty(localPlayer.nick))
      {
        str = localPlayer.uin;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        i = localEngineData.a(localPlayer.uin);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
        paramISeatPresenter = paramISeatPresenter.a(String.valueOf(localPlayer.uin));
        if ((paramISeatPresenter == null) || (!paramISeatPresenter.hasCameraVideo())) {
          break label390;
        }
        bool1 = true;
        if ((!bool1) || (!localEngineData.b(localPlayer.uin))) {
          break label396;
        }
        bool2 = true;
        if ((!bool1) || (bool2)) {
          break label402;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(null);
        if (localPlayer.isHost())
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838906);
        }
        j = GameEngine.a().a().a();
        if ((j != 0) && (j != 10)) {
          break label425;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if ((j != 0) || (a())) {
          break label570;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (localPlayer.status != 0) {
          break label524;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690512);
        if (!localPlayer.isHost()) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label605;
        }
        QLog.i("MemberItemView", 2, "update player:" + localPlayer + " hasCameraVideo:" + bool1 + " isBigVideo:" + bool2 + " gameStatus:" + j + " iScore:" + i + " player:" + localPlayer);
        return;
        str = localPlayer.nick;
        break;
        bool1 = false;
        break label120;
        bool2 = false;
        break label141;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramUserInfoHandler.a(String.valueOf(localPlayer.uin), (byte)1));
        break label159;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        switch (paramSeatMemberInfo.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838908);
          break;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838909);
          break;
        case 2: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838910);
          break;
        case 3: 
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838911);
          break;
          if (!localPlayer.isHost())
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838907);
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          continue;
          if (!localPlayer.isHost()) {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MemberItemView", 2, "playSpeakingAnim isSpeaking = " + paramBoolean);
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
    return (this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.setIsPressed(isPressed());
    this.jdField_a_of_type_ComTencentAvgameGameroomCoverRoundCornerRelativeLayout.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.MemberItemView
 * JD-Core Version:    0.7.0.1
 */