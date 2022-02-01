package com.tencent.av.ui;

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
import bdla;
import bgxc;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lbz;
import lfe;
import lph;
import lvv;
import mip;
import miq;
import mrj;
import mrl;
import mrr;
import muw;
import mux;
import mvk;

public class QavOperationMenuView
  extends QavMenuBaseView
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = null;
  mip jdField_a_of_type_Mip = null;
  mrl jdField_a_of_type_Mrl = null;
  private boolean jdField_a_of_type_Boolean;
  private RedTouch[] jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[5];
  private Rect b;
  
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
  
  private RedTouch a(View paramView, int paramInt1, int paramInt2)
  {
    RedTouch localRedTouch2 = null;
    RedTouch localRedTouch1 = localRedTouch2;
    if (paramView != null)
    {
      localRedTouch1 = localRedTouch2;
      if (paramView.getId() == paramInt1)
      {
        localRedTouch2 = lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramView, paramInt2);
        localRedTouch1 = localRedTouch2;
        if (localRedTouch2 != null)
        {
          localRedTouch2.a(0, (int)mvk.b(getContext(), paramView.getPaddingRight()), (int)mvk.b(getContext(), paramView.getPaddingTop()), 0).a();
          localRedTouch1 = localRedTouch2;
        }
      }
    }
    return localRedTouch1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = ("QavOperationMenuView_" + AudioHelper.b());
    setGravity(80);
    LayoutInflater.from(getContext()).inflate(2131559796, this, true);
    setBackgroundResource(2130842210);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363459));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363478));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(getContext().getString(2131695147), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(new miq(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363475));
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (lph.b()) && (AEFilterSupport.a() > 3))
    {
      Drawable localDrawable = getResources().getDrawable(2130841961);
      mux localmux = mux.a(getResources(), 2130841961, 2131165960);
      localmux.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localmux);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (lbz.a().a().A()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372295));
      if (AudioHelper.a(0) == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(536870656);
        setBackgroundColor(2130755583);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void a(mrj parammrj, View paramView)
  {
    paramView.setClickable(parammrj.a());
    int i;
    TextView localTextView;
    int j;
    int k;
    if (parammrj.c())
    {
      i = 0;
      paramView.setVisibility(i);
      if ((paramView instanceof TextView))
      {
        localTextView = (TextView)paramView;
        j = muw.a(paramView, 2131376587);
        k = muw.a(paramView, 2131364855);
        String str = parammrj.b();
        paramView = muw.a(paramView, 2131376613);
        if (TextUtils.isEmpty(str)) {
          break label273;
        }
        localTextView.setTag(2131376587, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131376613, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, AIOUtils.dp2px(28.0F, localTextView.getResources()), AIOUtils.dp2px(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
    }
    label273:
    label358:
    for (;;)
    {
      if (!StringUtil.isEmpty(parammrj.a())) {
        localTextView.setText(parammrj.a());
      }
      if ((parammrj.jdField_a_of_type_Boolean) || (parammrj.jdField_a_of_type_Int == 0))
      {
        parammrj.jdField_a_of_type_Int = ((int)Math.max(mvk.a(localTextView), AIOUtils.dp2px(28.0F, getResources())));
        parammrj.jdField_a_of_type_Boolean = false;
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether", 2, "updateView, width[" + parammrj.jdField_a_of_type_Int + "], title[" + parammrj.a() + "]");
        }
      }
      return;
      i = 8;
      break;
      localTextView.setTag(2131376613, null);
      if (parammrj.b()) {}
      for (i = 2131165971;; i = 2131165970)
      {
        if ((parammrj.b() == j) && (i == k)) {
          break label358;
        }
        localTextView.setTag(2131376587, Integer.valueOf(parammrj.b()));
        localTextView.setTag(2131364855, Integer.valueOf(i));
        AudioHelper.a(getResources(), localTextView, parammrj.b(), i, i);
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
          if (this.b == null)
          {
            localObject = getResources().getDisplayMetrics();
            this.b = new Rect(0, 0, ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
          }
          localView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
          bool1 = this.jdField_a_of_type_AndroidGraphicsRect.intersect(this.b);
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
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 2131695083: 
      return 0;
    case 2131695081: 
      return 1;
    case 2131695086: 
      return 3;
    case 2131695094: 
      return 4;
    }
    return 2;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2131695083: 
      return 2;
    case 2131695081: 
      return 6;
    case 2131695086: 
      return 9;
    case 2131695094: 
      return 10;
    }
    return 7;
  }
  
  public Drawable a(TextView paramTextView, String paramString)
  {
    int i = AIOUtils.dp2px(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(bgxc.a(i, i));
    paramTextView.setDecodeHandler(bgxc.a);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, mrj parammrj)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramInt < 0)) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= paramInt)
    {
      parammrj = a(parammrj);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammrj, paramInt);
      return parammrj;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    mrj localmrj = (mrj)localView.getTag(2131372302);
    if ((localmrj != null) && (localmrj.a() == parammrj.a())) {
      return localView;
    }
    parammrj = a(parammrj);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammrj, paramInt);
    return parammrj;
  }
  
  View a(mrj parammrj)
  {
    if (parammrj == null) {
      return null;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams(localLayoutParams);
    localButton.setSingleLine();
    AudioHelper.a(getResources(), localButton, parammrj.b(), 2131165970, 2131165970);
    if (!StringUtil.isEmpty(parammrj.a())) {
      localButton.setText(parammrj.a());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(parammrj.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131372302, parammrj);
    localButton.setTextSize(ViewUtils.pxTosp(AIOUtils.dp2px(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(AIOUtils.dp2px(8.0F, getResources()));
    float f = mvk.a(localButton);
    parammrj.jdField_a_of_type_Int = ((int)Math.max(f, AIOUtils.dp2px(28.0F, getResources())));
    parammrj.jdField_a_of_type_Boolean = false;
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether", 4, "createOperationBtn, title[" + parammrj.a() + "], titleTxtWidth[" + f + "], width[" + parammrj.jdField_a_of_type_Int + "]");
    }
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
  
  public void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN"));
      g();
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
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null)
    {
      if ((this.jdField_a_of_type_Mrl == null) || (!this.jdField_a_of_type_Mrl.a())) {
        break label156;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        if (!lbz.a().a().A()) {
          break label145;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if ((this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[2] == null)) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[2] = lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 7);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((this.jdField_a_of_type_Mrl != null) && (this.jdField_a_of_type_Mrl.a().size() != 0)) {
          break label168;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      }
      return;
      label145:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label156:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    label168:
    Object localObject1 = this.jdField_a_of_type_Mrl.a().iterator();
    int i = 0;
    int j = 0;
    Object localObject2;
    View localView;
    int i2;
    label275:
    int n;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (mrj)((Iterator)localObject1).next();
      localView = a(j, (mrj)localObject2);
      if (localView != null) {}
    }
    else
    {
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(j, i - j);
      }
      if (this.jdField_a_of_type_Mrl == null) {
        break label673;
      }
      i = this.jdField_a_of_type_Mrl.a();
      i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > 5) {
        break label477;
      }
      k = 1;
      n = ImmersiveUtils.a();
      if (k == 0) {
        break label482;
      }
      i = n / i;
      label289:
      localObject1 = this.jdField_a_of_type_Mrl.b();
      if (k != 0) {
        break label604;
      }
      m = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if ((m >= ((ArrayList)localObject1).size()) || (i > 5)) {
          break label509;
        }
        localObject2 = (mrj)((ArrayList)localObject1).get(m);
        if (!((mrj)localObject2).c()) {
          break label684;
        }
        if (i == 5) {
          break;
        }
        j = ((mrj)localObject2).jdField_a_of_type_Int + j;
        label357:
        i += 1;
        label361:
        m += 1;
      }
    }
    int k = localView.getId();
    int m = b(k);
    if ((m >= 0) && (m < this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch.length)) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[m] = a(localView, k, a(k));
    }
    a((mrj)localObject2, localView);
    j += 1;
    if ((((mrj)localObject2).c()) && (AudioHelper.a(0) == 1)) {
      if (i % 2 == 0)
      {
        localView.setBackgroundColor(-536881408);
        label459:
        i += 1;
      }
    }
    for (;;)
    {
      break;
      localView.setBackgroundColor(-539173668);
      break label459;
      label477:
      k = 0;
      break label275;
      label482:
      i = (int)(n * 1.0F / 5.5F);
      break label289;
      j = ((mrj)localObject2).jdField_a_of_type_Int / 2 + j;
      break label357;
      label509:
      if (n > j)
      {
        i = (int)((n - j) * 1.0F / 5.5F);
        j = 0;
        m = 0;
        if (m >= i2) {
          break label673;
        }
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
        if (((View)localObject2).getVisibility() != 0) {
          break label640;
        }
        n = 1;
        if (n == 0) {
          break label681;
        }
        if (k == 0) {
          break label646;
        }
        n = i;
        ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(n, -2));
      }
      label533:
      label673:
      label681:
      for (;;)
      {
        label562:
        label574:
        m += 1;
        break label533;
        i = 0;
        break;
        label604:
        bdla.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
        break;
        n = 0;
        break label562;
        int i1 = j + 1;
        n = ((mrj)((ArrayList)localObject1).get(j)).jdField_a_of_type_Int + i;
        j = i1;
        break label574;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
        return;
      }
      label640:
      label646:
      label684:
      break label361;
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131363475)
    {
      if (this.jdField_a_of_type_Mip != null) {
        this.jdField_a_of_type_Mip.a(this, 3);
      }
      mrr.a("0X800A566", 0);
    }
    for (;;)
    {
      int i = b(j);
      j = a(j);
      if ((i >= 0) && (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch.length))
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i] != null) {
          lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i], j);
        }
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i] = null;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Mip != null) {
        this.jdField_a_of_type_Mip.a(this, paramView);
      }
    }
  }
  
  public void setQavMenuActionListener(mip parammip)
  {
    this.jdField_a_of_type_Mip = parammip;
  }
  
  public void setViewController(mrl parammrl)
  {
    this.jdField_a_of_type_Mrl = parammrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */