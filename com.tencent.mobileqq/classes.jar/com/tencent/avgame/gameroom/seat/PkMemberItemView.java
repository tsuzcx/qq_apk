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
  private Drawable a;
  public View a;
  public ImageView a;
  public TextView a;
  public SeatMemberInfo a;
  public TalkingEffectLayout a;
  public RoundCorneredRelativeLayout a;
  public ImageView b;
  public TextView b;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
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
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-13618879);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private void a(View paramView1, View paramView2)
  {
    float f1 = ViewUtils.b(3.0F);
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
  
  public RectF a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
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
  
  public MemberVideoDisplayInfo a(ISeatPresenter paramISeatPresenter)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
    if ((localObject != null) && (((SeatMemberInfo)localObject).a != null))
    {
      localObject = new MemberVideoDisplayInfo();
      int[] arrayOfInt = new int[2];
      String str = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.a.uin;
      GameRoomViewLayoutParamsDef.a(this.jdField_b_of_type_AndroidWidgetImageView, arrayOfInt);
      boolean bool2 = false;
      ((MemberVideoDisplayInfo)localObject).jdField_a_of_type_Int = arrayOfInt[0];
      ((MemberVideoDisplayInfo)localObject).jdField_b_of_type_Int = arrayOfInt[1];
      ((MemberVideoDisplayInfo)localObject).jdField_c_of_type_Int = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredWidth();
      ((MemberVideoDisplayInfo)localObject).d = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredHeight();
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
          QLog.i("PkMemberItemView", 2, paramISeatPresenter.toString());
        }
        return localObject;
      }
      paramISeatPresenter = IGameEngine.a().a();
      if ((bool1) && (paramISeatPresenter.b(str))) {
        ((MemberVideoDisplayInfo)localObject).jdField_b_of_type_Boolean = true;
      } else if (paramISeatPresenter.c(str)) {
        ((MemberVideoDisplayInfo)localObject).jdField_c_of_type_Boolean = true;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376951));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376952));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372550));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout = ((TalkingEffectLayout)findViewById(2131378320));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setAnimatorListener(new PkMemberItemView.1(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370713);
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)findViewById(2131378987));
    float f = ViewUtils.a(12.0F);
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout.setRadius(f, f, f, f);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.getLayoutParams();
    if (IGameEngine.a().i())
    {
      localLayoutParams.width = (GameRoomViewLayoutParamsDef.F + ViewUtils.a(11.0F));
      localLayoutParams.height = (GameRoomViewLayoutParamsDef.F + ViewUtils.a(11.0F));
    }
    else
    {
      localLayoutParams.width = GameRoomViewLayoutParamsDef.F;
      localLayoutParams.height = GameRoomViewLayoutParamsDef.F;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setLayoutParams(localLayoutParams);
    this.d = ((TextView)findViewById(2131379514));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379513));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368047));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.e = ((TextView)findViewById(2131379515));
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
    if (IGameEngine.k()) {
      return;
    }
    Object localObject = IGameEngine.a().a().a;
    this.e.setVisibility(0);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.e.setText("");
          this.e.setVisibility(4);
          return;
        }
        this.e.setText(2131690301);
        this.e.setTextColor(Color.parseColor(((FontStyleConfig)localObject).x));
        return;
      }
      this.e.setText(2131690302);
      this.e.setTextColor(Color.parseColor(((FontStyleConfig)localObject).w));
      return;
    }
    this.e.setText(2131690300);
    this.e.setTextColor(Color.parseColor(((FontStyleConfig)localObject).y));
  }
  
  public void a(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new PkMemberItemView.3(this, paramView));
    localObjectAnimator.start();
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690425));
    paramISeatPresenter.a(false, paramBoolean);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, SeatMemberInfo paramSeatMemberInfo, ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    if ((paramSeatMemberInfo != null) && (paramSeatMemberInfo.a != null))
    {
      if (IGameEngine.a() == null) {
        return;
      }
      EngineData localEngineData = IGameEngine.a().a();
      Player localPlayer = paramSeatMemberInfo.a;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = paramSeatMemberInfo;
      if (TextUtils.isEmpty(localPlayer.nick)) {
        localObject = localPlayer.uin;
      } else {
        localObject = localPlayer.nick;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      int i = 0;
      if (!IGameEngine.k()) {
        i = localEngineData.a(localPlayer.uin);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
      Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      int j;
      if (paramBoolean) {
        j = 21;
      } else {
        j = 19;
      }
      ((TextView)localObject).setGravity(j);
      a(paramUserInfoHandler, paramSeatMemberInfo, paramISeatPresenter, paramBoolean);
      paramSeatMemberInfo = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        paramUserInfoHandler = "avgame_pk_score_blue@2x.png";
      } else {
        paramUserInfoHandler = "avgame_pk_score_red@2x.png";
      }
      paramSeatMemberInfo.setImageBitmap(AVGameUtil.a(paramUserInfoHandler));
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        paramUserInfoHandler = new StringBuilder();
        paramUserInfoHandler.append("update player:");
        paramUserInfoHandler.append(localPlayer);
        paramUserInfoHandler.append(" iScore:");
        paramUserInfoHandler.append(i);
        paramUserInfoHandler.append(" player:");
        paramUserInfoHandler.append(localPlayer);
        QLog.i("PkMemberItemView", 2, paramUserInfoHandler.toString());
      }
    }
  }
  
  public void a(ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690424));
    paramISeatPresenter.a(false, paramBoolean);
  }
  
  public void a(SeatMemberInfo paramSeatMemberInfo)
  {
    if ((paramSeatMemberInfo != null) && (paramSeatMemberInfo.a != null))
    {
      if (IGameEngine.a() == null) {
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      Player localPlayer = paramSeatMemberInfo.a;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = paramSeatMemberInfo;
      if (!IGameEngine.k())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(IGameEngine.a().a().a(localPlayer.uin)));
        if (QLog.isColorLevel())
        {
          paramSeatMemberInfo = new StringBuilder();
          paramSeatMemberInfo.append("updateScore player score:");
          paramSeatMemberInfo.append(IGameEngine.a().a().a(localPlayer.uin));
          QLog.i("PkMemberItemView", 2, paramSeatMemberInfo.toString());
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(AVGameUtil.a(paramString));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    paramString = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    paramString.width = (GameRoomViewLayoutParamsDef.F + ViewUtils.b(12.0F));
    paramString.height = (GameRoomViewLayoutParamsDef.F + ViewUtils.b(12.0F));
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramString);
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
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.b();
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo == null;
  }
  
  public boolean a(UserInfoHandler paramUserInfoHandler, SeatMemberInfo paramSeatMemberInfo, ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    if ((paramSeatMemberInfo != null) && (paramSeatMemberInfo.a != null))
    {
      if (IGameEngine.a() == null) {
        return false;
      }
      paramSeatMemberInfo = paramSeatMemberInfo.a;
      AVGameUserInfo localAVGameUserInfo = paramISeatPresenter.a(String.valueOf(paramSeatMemberInfo.uin));
      int i;
      if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasCameraVideo())) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((!IGameEngine.k()) && (i != 0) && (IGameEngine.a().a().b(paramSeatMemberInfo.uin))) {
        j = 1;
      } else {
        j = 0;
      }
      boolean bool;
      if ((i != 0) && (j == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramISeatPresenter.a(true, paramBoolean);
        return bool;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramUserInfoHandler.a(String.valueOf(paramSeatMemberInfo.uin), (byte)1, true, false));
      paramISeatPresenter.a(false, paramBoolean);
      return bool;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    SeatMemberInfo localSeatMemberInfo = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo;
    return (localSeatMemberInfo != null) && (localSeatMemberInfo.a != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.a.uin));
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(new FloatEvaluator(), new Object[] { Float.valueOf(1.0F), Float.valueOf(0.0F) });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new PkMemberItemView.2(this));
    localValueAnimator.start();
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("%.2fs", new Object[] { Float.valueOf(paramInt / 1000.0F) }));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(0);
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165314));
      this.d.setTextColor(getResources().getColor(2131165314));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167394));
    this.d.setTextColor(getResources().getColor(2131167394));
  }
  
  public void c()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView.getColorFilter() != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(null);
      }
    }
    else {
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(null);
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText("0");
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout.a(true);
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout.postInvalidate();
  }
  
  public void e()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.d.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkMemberItemView
 * JD-Core Version:    0.7.0.1
 */