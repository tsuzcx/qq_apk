package com.tencent.av.ui;

import afur;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bcst;
import bgey;
import bgsp;
import bgtn;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lve;
import mho;
import mhp;
import mqg;
import mqi;
import mqo;
import mtq;
import mtr;
import mue;

public class QavOperationMenuView
  extends QavMenuBaseView
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = null;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  mho jdField_a_of_type_Mho = null;
  mqi jdField_a_of_type_Mqi = null;
  private boolean jdField_a_of_type_Boolean;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private RedTouch c;
  private RedTouch d;
  
  public QavOperationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavOperationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavOperationMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = ("QavOperationMenuView_" + AudioHelper.b());
    setGravity(80);
    LayoutInflater.from(getContext()).inflate(2131559751, this, true);
    setBackgroundResource(2130842142);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363339));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363358));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(getContext().getString(2131694751), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(new mhp(this));
    ImageView localImageView = (ImageView)findViewById(2131363355);
    if (AEFilterSupport.a())
    {
      Drawable localDrawable = getResources().getDrawable(2130841894);
      mtr localmtr = mtr.a(getResources(), 2130841894, 2131165932);
      localmtr.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localImageView.setImageDrawable(localmtr);
      localImageView.setBackgroundDrawable(null);
      localImageView.setOnClickListener(this);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372023));
      if (AudioHelper.a(0) == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(536870656);
        setBackgroundColor(2130755583);
      }
      return;
      localImageView.setVisibility(8);
    }
  }
  
  private void a(mqg parammqg, View paramView)
  {
    paramView.setClickable(parammqg.a());
    int i;
    TextView localTextView;
    int j;
    int k;
    if (parammqg.c())
    {
      i = 0;
      paramView.setVisibility(i);
      if ((paramView instanceof TextView))
      {
        localTextView = (TextView)paramView;
        j = mtq.a(paramView, 2131376434);
        k = mtq.a(paramView, 2131364691);
        String str = parammqg.b();
        paramView = mtq.a(paramView, 2131376460);
        if (TextUtils.isEmpty(str)) {
          break label168;
        }
        localTextView.setTag(2131376434, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131376460, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, afur.a(28.0F, localTextView.getResources()), afur.a(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
    }
    label168:
    label250:
    for (;;)
    {
      if (!bgsp.a(parammqg.a())) {
        localTextView.setText(parammqg.a());
      }
      return;
      i = 8;
      break;
      localTextView.setTag(2131376460, null);
      if (parammqg.b()) {}
      for (i = 2131165943;; i = 2131165942)
      {
        if ((parammqg.b() == j) && (i == k)) {
          break label250;
        }
        localTextView.setTag(2131376434, Integer.valueOf(parammqg.b()));
        localTextView.setTag(2131364691, Integer.valueOf(i));
        AudioHelper.a(getResources(), localTextView, parammqg.b(), i, i);
        break;
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i < ((LinearLayout)localObject).getChildCount())
      {
        View localView = ((LinearLayout)localObject).getChildAt(i);
        if ((localView != null) && (localView.getId() == paramInt) && (localView.isShown()))
        {
          if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
            this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
          }
          if (this.jdField_b_of_type_AndroidGraphicsRect == null)
          {
            localObject = getResources().getDisplayMetrics();
            this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
          }
          localView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
          bool1 = this.jdField_a_of_type_AndroidGraphicsRect.intersect(this.jdField_b_of_type_AndroidGraphicsRect);
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, "checkOperationBtnIsVisible, ret[" + bool1 + "], id[" + paramInt + "]");
        return bool1;
      }
      i += 1;
    }
  }
  
  public Drawable a(TextView paramTextView, String paramString)
  {
    int i = afur.a(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(bgey.a(i, i));
    paramTextView.setDecodeHandler(bgey.a);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, mqg parammqg)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramInt < 0)) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= paramInt)
    {
      parammqg = a(parammqg);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammqg, paramInt);
      return parammqg;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    mqg localmqg = (mqg)localView.getTag(2131372030);
    if ((localmqg != null) && (localmqg.a() == parammqg.a())) {
      return localView;
    }
    parammqg = a(parammqg);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammqg, paramInt);
    return parammqg;
  }
  
  View a(mqg parammqg)
  {
    if (parammqg == null) {
      return null;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams(localLayoutParams);
    localButton.setSingleLine();
    AudioHelper.a(getResources(), localButton, parammqg.b(), 2131165942, 2131165942);
    if (!bgsp.a(parammqg.a())) {
      localButton.setText(parammqg.a());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(parammqg.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131372030, parammqg);
    localButton.setTextSize(bgtn.e(afur.a(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(afur.a(8.0F, getResources()));
    parammqg.a = ((int)Math.max(mue.a(localButton), afur.a(28.0F, getResources())));
    return localButton;
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(paramInt);
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN"));
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    super.c(paramLong, paramBoolean);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN"));
      f();
      postDelayed(new QavOperationMenuView.2(this), 100L);
    }
  }
  
  public void d(long paramLong, boolean paramBoolean)
  {
    super.d(paramLong, paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "onHide");
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.jdField_a_of_type_Long) > 200L))
    {
      this.jdField_a_of_type_Long = l;
      EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, -1029L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ResourceType"})
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null)
    {
      if ((this.jdField_a_of_type_Mqi == null) || (!this.jdField_a_of_type_Mqi.a())) {
        break label123;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.jdField_a_of_type_Boolean = true;
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363355);
      if ((((ImageView)localObject1).getVisibility() == 0) && (this.c == null)) {
        this.c = lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (View)localObject1, 7);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((this.jdField_a_of_type_Mqi != null) && (this.jdField_a_of_type_Mqi.a().size() != 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      }
      return;
      label123:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    Object localObject1 = this.jdField_a_of_type_Mqi.a().iterator();
    int i = 0;
    int j = 0;
    Object localObject2;
    View localView;
    int i2;
    int k;
    label242:
    int n;
    label256:
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (mqg)((Iterator)localObject1).next();
      localView = a(j, (mqg)localObject2);
      if (localView != null) {}
    }
    else
    {
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(j, i - j);
      }
      if (this.jdField_a_of_type_Mqi == null) {
        break label821;
      }
      i = this.jdField_a_of_type_Mqi.a();
      i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > 5) {
        break label636;
      }
      k = 1;
      n = ImmersiveUtils.a();
      if (k == 0) {
        break label641;
      }
      j = n / i;
      localObject1 = this.jdField_a_of_type_Mqi.b();
      if (k != 0) {
        break label752;
      }
      m = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if ((m >= ((ArrayList)localObject1).size()) || (i > 5)) {
          break label668;
        }
        localObject2 = (mqg)((ArrayList)localObject1).get(m);
        if (!((mqg)localObject2).c()) {
          break label832;
        }
        if (i == 5) {
          break;
        }
        j = ((mqg)localObject2).a + j;
        label324:
        i += 1;
        label328:
        m += 1;
      }
    }
    if (localView.getId() == 2131694689)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        k = (int)mue.b(getContext(), localView.getPaddingRight());
        m = (int)mue.b(getContext(), localView.getPaddingTop());
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131694687)
    {
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 6);
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        k = (int)mue.b(getContext(), localView.getPaddingRight());
        m = (int)mue.b(getContext(), localView.getPaddingTop());
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131694692)
    {
      this.d = lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 9);
      if (this.d != null)
      {
        k = (int)mue.b(getContext(), localView.getPaddingRight());
        m = (int)mue.b(getContext(), localView.getPaddingTop());
        this.d.a(0, k, m, 0).a();
      }
    }
    a((mqg)localObject2, localView);
    j += 1;
    if ((((mqg)localObject2).c()) && (AudioHelper.a(0) == 1)) {
      if (i % 2 == 0)
      {
        localView.setBackgroundColor(-536881408);
        label618:
        i += 1;
      }
    }
    for (;;)
    {
      break;
      localView.setBackgroundColor(-539173668);
      break label618;
      label636:
      k = 0;
      break label242;
      label641:
      j = (int)(n * 1.0F / 5.5F);
      break label256;
      j = ((mqg)localObject2).a / 2 + j;
      break label324;
      label668:
      j = (int)((n - j) * 1.0F / 5.5F);
      i = 0;
      m = 0;
      label686:
      if (m < i2)
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
        if (((View)localObject2).getVisibility() == 0)
        {
          n = 1;
          label715:
          if (n == 0) {
            break label829;
          }
          if (k == 0) {
            break label794;
          }
          n = j;
          label727:
          ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(n, -2));
        }
      }
      label794:
      label821:
      label829:
      for (;;)
      {
        m += 1;
        break label686;
        label752:
        bcst.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
        break;
        n = 0;
        break label715;
        int i1 = i + 1;
        n = ((mqg)((ArrayList)localObject1).get(i)).a + j;
        i = i1;
        break label727;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
        return;
      }
      label832:
      break label328;
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131363355)
    {
      if (this.jdField_a_of_type_Mho != null) {
        this.jdField_a_of_type_Mho.a(this, 3);
      }
      if (this.c != null)
      {
        lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.c, 7);
        this.c = null;
      }
      mqo.a("0X800A566", 0);
      if (i != 2131694689) {
        break label121;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 2);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Mho == null) {
        break;
      }
      this.jdField_a_of_type_Mho.a(this, paramView);
      break;
      label121:
      if (i == 2131694687)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
        {
          lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch, 6);
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = null;
        }
      }
      else if ((i == 2131694692) && (this.d != null))
      {
        lve.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.d, 9);
        this.d = null;
      }
    }
  }
  
  public void setQavMenuActionListener(mho parammho)
  {
    this.jdField_a_of_type_Mho = parammho;
  }
  
  public void setViewController(mqi parammqi)
  {
    this.jdField_a_of_type_Mqi = parammqi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */