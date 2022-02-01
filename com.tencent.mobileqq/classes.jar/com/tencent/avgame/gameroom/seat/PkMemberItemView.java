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
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
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
    float f = ViewUtils.b(3.0F);
    paramView1 = ObjectAnimator.ofFloat(paramView1, "translationX", new float[] { 0.0F, f, -f, f, -f, f / 2.0F, -f / 2.0F, f / 4.0F, -f / 4.0F, 0.0F });
    paramView2 = ObjectAnimator.ofFloat(paramView2, "translationX", new float[] { 0.0F, f, -f, f, -f, f / 2.0F, -f / 2.0F, f / 4.0F, -f / 4.0F, 0.0F });
    paramView1.setDuration(500L);
    paramView2.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.playTogether(new Animator[] { paramView2, paramView1 });
    localAnimatorSet.start();
  }
  
  public RectF a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.a == null)) {
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
    QLog.i("PkMemberItemView", 2, "getPlayerHeadViewRect rectF:" + localRectF);
    return localRectF;
  }
  
  public MemberVideoDisplayInfo a(ISeatPresenter paramISeatPresenter)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.a == null)) {
      return null;
    }
    MemberVideoDisplayInfo localMemberVideoDisplayInfo = new MemberVideoDisplayInfo();
    int[] arrayOfInt = new int[2];
    String str = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.a.uin;
    GameRoomViewLayoutParamsDef.a(this.jdField_b_of_type_AndroidWidgetImageView, arrayOfInt);
    localMemberVideoDisplayInfo.jdField_a_of_type_Int = arrayOfInt[0];
    localMemberVideoDisplayInfo.jdField_b_of_type_Int = arrayOfInt[1];
    localMemberVideoDisplayInfo.jdField_c_of_type_Int = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localMemberVideoDisplayInfo.d = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredHeight();
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
        QLog.i("PkMemberItemView", 2, "getVideoDisplayInfo info:" + localMemberVideoDisplayInfo.toString());
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
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372963));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout = ((TalkingEffectLayout)findViewById(2131378933));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setAnimatorListener(new PkMemberItemView.1(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371079);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)findViewById(2131379643));
    float f = ViewUtils.a(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setRadius(f, f, f, f);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.getLayoutParams();
    localLayoutParams.width = GameRoomViewLayoutParamsDef.u;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.u;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.getLayoutParams();
    if (GameEngine.a().i()) {
      localLayoutParams.width = (GameRoomViewLayoutParamsDef.u + ViewUtils.a(11.0F));
    }
    for (localLayoutParams.height = (GameRoomViewLayoutParamsDef.u + ViewUtils.a(11.0F));; localLayoutParams.height = GameRoomViewLayoutParamsDef.u)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setLayoutParams(localLayoutParams);
      this.d = ((TextView)findViewById(2131380195));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380194));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368295));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.e = ((TextView)findViewById(2131380196));
      return;
      localLayoutParams.width = GameRoomViewLayoutParamsDef.u;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PkMemberItemView", 2, "showAnswerResult isSelf:" + paramBoolean + " type: " + paramInt);
    }
    FontStyleConfig localFontStyleConfig = GameEngine.a().a().a;
    this.e.setVisibility(0);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.e.setText(2131690377);
      this.e.setTextColor(Color.parseColor(localFontStyleConfig.y));
      return;
    case 2: 
      this.e.setText(2131690379);
      this.e.setTextColor(Color.parseColor(localFontStyleConfig.w));
      return;
    case 3: 
      this.e.setText(2131690378);
      this.e.setTextColor(Color.parseColor(localFontStyleConfig.x));
      return;
    }
    this.e.setText("");
    this.e.setVisibility(4);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690500));
    paramISeatPresenter.a(false, paramBoolean);
  }
  
  public void a(UserInfoHandler paramUserInfoHandler, SeatMemberInfo paramSeatMemberInfo, ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    if ((paramSeatMemberInfo == null) || (paramSeatMemberInfo.a == null) || (GameEngine.a().a() == null)) {
      return;
    }
    EngineData localEngineData = GameEngine.a().a();
    Player localPlayer = paramSeatMemberInfo.a;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = paramSeatMemberInfo;
    Object localObject;
    label58:
    int j;
    int i;
    if (TextUtils.isEmpty(localPlayer.nick))
    {
      localObject = localPlayer.uin;
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      j = localEngineData.a(localPlayer.uin);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(j));
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label220;
      }
      i = 21;
      label106:
      ((TextView)localObject).setGravity(i);
      a(paramUserInfoHandler, paramSeatMemberInfo, paramISeatPresenter, paramBoolean);
      paramSeatMemberInfo = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label227;
      }
    }
    label220:
    label227:
    for (paramUserInfoHandler = "avgame_pk_score_blue@2x.png";; paramUserInfoHandler = "avgame_pk_score_red@2x.png")
    {
      paramSeatMemberInfo.setImageBitmap(AVGameUtils.a(paramUserInfoHandler));
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PkMemberItemView", 2, "update player:" + localPlayer + " iScore:" + j + " player:" + localPlayer);
      return;
      localObject = localPlayer.nick;
      break label58;
      i = 19;
      break label106;
    }
  }
  
  public void a(ISeatPresenter paramISeatPresenter, boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690499));
    paramISeatPresenter.a(false, paramBoolean);
  }
  
  public void a(SeatMemberInfo paramSeatMemberInfo)
  {
    if ((paramSeatMemberInfo == null) || (paramSeatMemberInfo.a == null) || (GameEngine.a().a() == null)) {}
    EngineData localEngineData;
    Player localPlayer;
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localEngineData = GameEngine.a().a();
      localPlayer = paramSeatMemberInfo.a;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo = paramSeatMemberInfo;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localEngineData.a(localPlayer.uin)));
    } while (!QLog.isColorLevel());
    QLog.i("PkMemberItemView", 2, "updateScore player score:" + localEngineData.a(localPlayer.uin));
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(AVGameUtils.a(paramString));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    paramString = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    paramString.width = (GameRoomViewLayoutParamsDef.u + ViewUtils.b(12.0F));
    paramString.height = (GameRoomViewLayoutParamsDef.u + ViewUtils.b(12.0F));
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PkMemberItemView", 2, "playSpeakingAnim isSpeaking = " + paramBoolean);
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
    if ((paramSeatMemberInfo == null) || (paramSeatMemberInfo.a == null) || (GameEngine.a().a() == null)) {
      return false;
    }
    EngineData localEngineData = GameEngine.a().a();
    paramSeatMemberInfo = paramSeatMemberInfo.a;
    AVGameUserInfo localAVGameUserInfo = paramISeatPresenter.a(String.valueOf(paramSeatMemberInfo.uin));
    int i;
    int j;
    if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasCameraVideo()))
    {
      i = 1;
      if ((i == 0) || (!localEngineData.b(paramSeatMemberInfo.uin))) {
        break label130;
      }
      j = 1;
      label86:
      if ((i == 0) || (j != 0)) {
        break label136;
      }
    }
    label130:
    label136:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        break label142;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramISeatPresenter.a(true, paramBoolean);
      return bool;
      i = 0;
      break;
      j = 0;
      break label86;
    }
    label142:
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramUserInfoHandler.a(String.valueOf(paramSeatMemberInfo.uin), (byte)1, true, false));
    paramISeatPresenter.a(false, paramBoolean);
    return bool;
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.a != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatMemberInfo.a.uin));
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
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165348));
      this.d.setTextColor(getResources().getColor(2131165348));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167374));
    this.d.setTextColor(getResources().getColor(2131167374));
  }
  
  public void c()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView.getColorFilter() != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(null);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(null);
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText("0");
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.enablePressEffect(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.postInvalidate();
  }
  
  public void e()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.d.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkMemberItemView
 * JD-Core Version:    0.7.0.1
 */