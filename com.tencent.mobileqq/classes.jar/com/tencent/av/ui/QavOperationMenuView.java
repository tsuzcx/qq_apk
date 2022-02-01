package com.tencent.av.ui;

import agej;
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
import bdll;
import bhez;
import bhsr;
import bhtq;
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
import lwa;
import mik;
import mil;
import mrd;
import mrf;
import mrl;
import mup;
import muq;
import mvd;

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
  mik jdField_a_of_type_Mik = null;
  mrf jdField_a_of_type_Mrf = null;
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
    LayoutInflater.from(getContext()).inflate(2131559758, this, true);
    setBackgroundResource(2130842154);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363363));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363382));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(getContext().getString(2131694793), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(new mil(this));
    ImageView localImageView = (ImageView)findViewById(2131363379);
    if (AEFilterSupport.a() > 3)
    {
      Drawable localDrawable = getResources().getDrawable(2130841906);
      muq localmuq = muq.a(getResources(), 2130841906, 2131165933);
      localmuq.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localImageView.setImageDrawable(localmuq);
      localImageView.setBackgroundDrawable(null);
      localImageView.setOnClickListener(this);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372137));
      if (AudioHelper.a(0) == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(536870656);
        setBackgroundColor(2130755583);
      }
      return;
      localImageView.setVisibility(8);
    }
  }
  
  private void a(mrd parammrd, View paramView)
  {
    paramView.setClickable(parammrd.a());
    int i;
    TextView localTextView;
    int j;
    int k;
    if (parammrd.c())
    {
      i = 0;
      paramView.setVisibility(i);
      if ((paramView instanceof TextView))
      {
        localTextView = (TextView)paramView;
        j = mup.a(paramView, 2131376566);
        k = mup.a(paramView, 2131364737);
        String str = parammrd.b();
        paramView = mup.a(paramView, 2131376592);
        if (TextUtils.isEmpty(str)) {
          break label168;
        }
        localTextView.setTag(2131376566, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131376592, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, agej.a(28.0F, localTextView.getResources()), agej.a(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
    }
    label168:
    label250:
    for (;;)
    {
      if (!bhsr.a(parammrd.a())) {
        localTextView.setText(parammrd.a());
      }
      return;
      i = 8;
      break;
      localTextView.setTag(2131376592, null);
      if (parammrd.b()) {}
      for (i = 2131165944;; i = 2131165943)
      {
        if ((parammrd.b() == j) && (i == k)) {
          break label250;
        }
        localTextView.setTag(2131376566, Integer.valueOf(parammrd.b()));
        localTextView.setTag(2131364737, Integer.valueOf(i));
        AudioHelper.a(getResources(), localTextView, parammrd.b(), i, i);
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
    int i = agej.a(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(bhez.a(i, i));
    paramTextView.setDecodeHandler(bhez.a);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, mrd parammrd)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramInt < 0)) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= paramInt)
    {
      parammrd = a(parammrd);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammrd, paramInt);
      return parammrd;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    mrd localmrd = (mrd)localView.getTag(2131372144);
    if ((localmrd != null) && (localmrd.a() == parammrd.a())) {
      return localView;
    }
    parammrd = a(parammrd);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammrd, paramInt);
    return parammrd;
  }
  
  View a(mrd parammrd)
  {
    if (parammrd == null) {
      return null;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams(localLayoutParams);
    localButton.setSingleLine();
    AudioHelper.a(getResources(), localButton, parammrd.b(), 2131165943, 2131165943);
    if (!bhsr.a(parammrd.a())) {
      localButton.setText(parammrd.a());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(parammrd.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131372144, parammrd);
    localButton.setTextSize(bhtq.e(agej.a(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(agej.a(8.0F, getResources()));
    parammrd.a = ((int)Math.max(mvd.a(localButton), agej.a(28.0F, getResources())));
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
      if ((this.jdField_a_of_type_Mrf == null) || (!this.jdField_a_of_type_Mrf.a())) {
        break label123;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.jdField_a_of_type_Boolean = true;
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363379);
      if ((((ImageView)localObject1).getVisibility() == 0) && (this.c == null)) {
        this.c = lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (View)localObject1, 7);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((this.jdField_a_of_type_Mrf != null) && (this.jdField_a_of_type_Mrf.a().size() != 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      }
      return;
      label123:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    Object localObject1 = this.jdField_a_of_type_Mrf.a().iterator();
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
      localObject2 = (mrd)((Iterator)localObject1).next();
      localView = a(j, (mrd)localObject2);
      if (localView != null) {}
    }
    else
    {
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(j, i - j);
      }
      if (this.jdField_a_of_type_Mrf == null) {
        break label821;
      }
      i = this.jdField_a_of_type_Mrf.a();
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
      localObject1 = this.jdField_a_of_type_Mrf.b();
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
        localObject2 = (mrd)((ArrayList)localObject1).get(m);
        if (!((mrd)localObject2).c()) {
          break label832;
        }
        if (i == 5) {
          break;
        }
        j = ((mrd)localObject2).a + j;
        label324:
        i += 1;
        label328:
        m += 1;
      }
    }
    if (localView.getId() == 2131694731)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        k = (int)mvd.b(getContext(), localView.getPaddingRight());
        m = (int)mvd.b(getContext(), localView.getPaddingTop());
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131694729)
    {
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 6);
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        k = (int)mvd.b(getContext(), localView.getPaddingRight());
        m = (int)mvd.b(getContext(), localView.getPaddingTop());
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131694734)
    {
      this.d = lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 9);
      if (this.d != null)
      {
        k = (int)mvd.b(getContext(), localView.getPaddingRight());
        m = (int)mvd.b(getContext(), localView.getPaddingTop());
        this.d.a(0, k, m, 0).a();
      }
    }
    a((mrd)localObject2, localView);
    j += 1;
    if ((((mrd)localObject2).c()) && (AudioHelper.a(0) == 1)) {
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
      j = ((mrd)localObject2).a / 2 + j;
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
        bdll.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
        break;
        n = 0;
        break label715;
        int i1 = i + 1;
        n = ((mrd)((ArrayList)localObject1).get(i)).a + j;
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
    if (i == 2131363379)
    {
      if (this.jdField_a_of_type_Mik != null) {
        this.jdField_a_of_type_Mik.a(this, 3);
      }
      if (this.c != null)
      {
        lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.c, 7);
        this.c = null;
      }
      mrl.a("0X800A566", 0);
      if (i != 2131694731) {
        break label121;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 2);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Mik == null) {
        break;
      }
      this.jdField_a_of_type_Mik.a(this, paramView);
      break;
      label121:
      if (i == 2131694729)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
        {
          lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch, 6);
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = null;
        }
      }
      else if ((i == 2131694734) && (this.d != null))
      {
        lwa.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.d, 9);
        this.d = null;
      }
    }
  }
  
  public void setQavMenuActionListener(mik parammik)
  {
    this.jdField_a_of_type_Mik = parammik;
  }
  
  public void setViewController(mrf parammrf)
  {
    this.jdField_a_of_type_Mrf = parammrf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */