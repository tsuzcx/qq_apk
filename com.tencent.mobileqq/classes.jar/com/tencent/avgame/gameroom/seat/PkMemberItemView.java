package com.tencent.avgame.gameroom.seat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import ndl;
import nfc;
import nfv;
import nin;
import niq;
import nju;
import njx;
import njy;
import njz;
import nkd;
import nqf;

public class PkMemberItemView
  extends RelativeLayout
{
  private Drawable a;
  public View a;
  public ImageView a;
  public TextView a;
  public TalkingEffectLayout a;
  public RoundCorneredRelativeLayout a;
  public nkd a;
  public ImageView b;
  public TextView b;
  private TextView c;
  private TextView d;
  
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
    float f = ViewUtils.dpToPx(3.0F);
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
    if ((this.jdField_a_of_type_Nkd == null) || (this.jdField_a_of_type_Nkd.a == null)) {
      localObject = null;
    }
    RectF localRectF;
    do
    {
      return localObject;
      localObject = new int[2];
      nin.a(this, (int[])localObject);
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
  
  public niq a(nju paramnju)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Nkd == null) || (this.jdField_a_of_type_Nkd.a == null)) {
      return null;
    }
    niq localniq = new niq();
    int[] arrayOfInt = new int[2];
    String str = this.jdField_a_of_type_Nkd.a.uin;
    nin.a(this.jdField_b_of_type_AndroidWidgetImageView, arrayOfInt);
    localniq.jdField_a_of_type_Int = arrayOfInt[0];
    localniq.jdField_b_of_type_Int = arrayOfInt[1];
    localniq.jdField_c_of_type_Int = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredWidth();
    localniq.d = this.jdField_b_of_type_AndroidWidgetImageView.getMeasuredHeight();
    localniq.jdField_a_of_type_Long = Long.valueOf(str).longValue();
    paramnju = paramnju.a(str);
    boolean bool1 = bool2;
    if (paramnju != null)
    {
      bool1 = bool2;
      if (paramnju.hasCameraVideo()) {
        bool1 = true;
      }
    }
    localniq.jdField_a_of_type_Boolean = bool1;
    paramnju = nfc.a().a();
    if ((bool1) && (paramnju.b(str))) {
      localniq.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MemberItemView", 2, "getVideoDisplayInfo info:" + localniq.toString());
      }
      return localniq;
      if (paramnju.c(str)) {
        localniq.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371803));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377094));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377095));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372643));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout = ((TalkingEffectLayout)findViewById(2131378502));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setAnimatorListener(new njx(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370798);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)findViewById(2131379209));
    float f = ViewUtils.dip2px(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setRadius(f, f, f, f);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.getLayoutParams();
    localLayoutParams.width = nin.s;
    localLayoutParams.height = nin.s;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.getLayoutParams();
    localLayoutParams.width = nin.s;
    localLayoutParams.height = nin.s;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatTalkingEffectLayout.setLayoutParams(localLayoutParams);
    this.d = ((TextView)findViewById(2131379768));
    this.c = ((TextView)findViewById(2131379767));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.c.setText(String.format("%.2fs", new Object[] { Float.valueOf(paramInt / 1000.0F) }));
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    if (paramBoolean)
    {
      this.c.setTextColor(getResources().getColor(2131165348));
      this.d.setTextColor(getResources().getColor(2131165348));
      return;
    }
    this.c.setTextColor(getResources().getColor(2131167363));
    this.d.setTextColor(getResources().getColor(2131167363));
  }
  
  public void a(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new njz(this, paramView));
    localObjectAnimator.start();
  }
  
  public void a(ndl paramndl, nju paramnju, boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690408));
    paramnju.a(false, paramBoolean);
  }
  
  public void a(ndl paramndl, nkd paramnkd, nju paramnju, boolean paramBoolean)
  {
    if ((paramnkd == null) || (paramnkd.a == null) || (nfc.a().a() == null)) {
      return;
    }
    nfv localnfv = nfc.a().a();
    Player localPlayer = paramnkd.a;
    this.jdField_a_of_type_Nkd = paramnkd;
    Object localObject;
    label58:
    int j;
    int i;
    if (TextUtils.isEmpty(localPlayer.nick))
    {
      localObject = localPlayer.uin;
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      j = localnfv.a(localPlayer.uin);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(j));
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label220;
      }
      i = 21;
      label106:
      ((TextView)localObject).setGravity(i);
      a(paramndl, paramnkd, paramnju, paramBoolean);
      paramnkd = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label227;
      }
    }
    label220:
    label227:
    for (paramndl = "avgame_pk_score_blue@2x.png";; paramndl = "avgame_pk_score_red@2x.png")
    {
      paramnkd.setImageBitmap(nqf.a(paramndl));
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("MemberItemView", 2, "update player:" + localPlayer + " iScore:" + j + " player:" + localPlayer);
      return;
      localObject = localPlayer.nick;
      break label58;
      i = 19;
      break label106;
    }
  }
  
  public void a(nju paramnju, boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690407));
    paramnju.a(false, paramBoolean);
  }
  
  public void a(nkd paramnkd)
  {
    if ((paramnkd == null) || (paramnkd.a == null) || (nfc.a().a() == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    nfv localnfv = nfc.a().a();
    Player localPlayer = paramnkd.a;
    this.jdField_a_of_type_Nkd = paramnkd;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localnfv.a(localPlayer.uin)));
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_Nkd == null;
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_Nkd != null) && (this.jdField_a_of_type_Nkd.a != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_Nkd.a.uin));
  }
  
  public boolean a(ndl paramndl, nkd paramnkd, nju paramnju, boolean paramBoolean)
  {
    if ((paramnkd == null) || (paramnkd.a == null) || (nfc.a().a() == null)) {
      return false;
    }
    nfv localnfv = nfc.a().a();
    paramnkd = paramnkd.a;
    AVGameUserInfo localAVGameUserInfo = paramnju.a(String.valueOf(paramnkd.uin));
    int i;
    int j;
    if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasCameraVideo()))
    {
      i = 1;
      if ((i == 0) || (!localnfv.b(paramnkd.uin))) {
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
      paramnju.a(true, paramBoolean);
      return bool;
      i = 0;
      break;
      j = 0;
      break label86;
    }
    label142:
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramndl.a(String.valueOf(paramnkd.uin), (byte)1, true, true));
    paramnju.a(false, paramBoolean);
    return bool;
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(new FloatEvaluator(), new Object[] { Float.valueOf(1.0F), Float.valueOf(0.0F) });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new njy(this));
    localValueAnimator.start();
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
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.enablePressEffect(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkMemberItemView
 * JD-Core Version:    0.7.0.1
 */