package com.tencent.av.ui;

import actj;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axqy;
import bavw;
import bbkk;
import bbll;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lvv;
import mhs;
import mht;
import mqh;
import mqj;
import mqo;
import mto;
import mtp;
import muc;

public class QavOperationMenuView
  extends RelativeLayout
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public VideoAppInterface a;
  BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = null;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  mhs jdField_a_of_type_Mhs = null;
  mqj jdField_a_of_type_Mqj = null;
  private RedTouch b;
  private RedTouch c;
  
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    b();
  }
  
  private void a(mqh parammqh, View paramView)
  {
    paramView.setClickable(parammqh.a());
    int i;
    TextView localTextView;
    int j;
    int k;
    if (parammqh.c())
    {
      i = 0;
      paramView.setVisibility(i);
      if ((paramView instanceof TextView))
      {
        localTextView = (TextView)paramView;
        j = mto.a(paramView, 2131375175);
        k = mto.a(paramView, 2131364410);
        String str = parammqh.b();
        paramView = mto.a(paramView, 2131375200);
        if (TextUtils.isEmpty(str)) {
          break label168;
        }
        localTextView.setTag(2131375175, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131375200, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, actj.a(28.0F, localTextView.getResources()), actj.a(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
    }
    label168:
    label248:
    for (;;)
    {
      if (!bbkk.a(parammqh.a())) {
        localTextView.setText(parammqh.a());
      }
      return;
      i = 8;
      break;
      localTextView.setTag(2131375200, null);
      if (parammqh.b()) {}
      for (i = 2131165850;; i = 2131165849)
      {
        if ((parammqh.b() == j) && (i == k)) {
          break label248;
        }
        localTextView.setTag(2131375175, Integer.valueOf(parammqh.b()));
        localTextView.setTag(2131364410, Integer.valueOf(i));
        AudioHelper.a(getResources(), localTextView, parammqh.b(), i, i);
        break;
      }
    }
  }
  
  private void b()
  {
    setGravity(80);
    LayoutInflater.from(getContext()).inflate(2131559563, this, true);
    setBackgroundResource(2130841671);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363116));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363135));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(getContext().getString(2131695711), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(new mht(this));
    ImageView localImageView = (ImageView)findViewById(2131363132);
    if (AEFilterSupport.a())
    {
      Drawable localDrawable = getResources().getDrawable(2130841430);
      mtp localmtp = mtp.a(getResources(), 2130841430, 2131165839);
      localmtp.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localImageView.setImageDrawable(localmtp);
      localImageView.setBackgroundDrawable(null);
      localImageView.setOnClickListener(this);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371120));
      if (AudioHelper.a(0) == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(536870656);
        setBackgroundColor(2130755583);
      }
      return;
      localImageView.setVisibility(8);
    }
  }
  
  public Drawable a(TextView paramTextView, String paramString)
  {
    int i = actj.a(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(bavw.a(i, i));
    paramTextView.setDecodeHandler(bavw.a);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, mqh parammqh)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramInt < 0)) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= paramInt)
    {
      parammqh = a(parammqh);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammqh, paramInt);
      return parammqh;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    mqh localmqh = (mqh)localView.getTag(2131371127);
    if ((localmqh != null) && (localmqh.a() == parammqh.a())) {
      return localView;
    }
    parammqh = a(parammqh);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammqh, paramInt);
    return parammqh;
  }
  
  View a(mqh parammqh)
  {
    if (parammqh == null) {
      return null;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams(localLayoutParams);
    AudioHelper.a(getResources(), localButton, parammqh.b(), 2131165849, 2131165849);
    if (!bbkk.a(parammqh.a())) {
      localButton.setText(parammqh.a());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(parammqh.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131371127, parammqh);
    localButton.setTextSize(bbll.e(actj.a(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(actj.a(8.0F, getResources()));
    parammqh.a = ((int)Math.max(muc.a(localButton), actj.a(28.0F, getResources())));
    return localButton;
  }
  
  @SuppressLint({"ResourceType"})
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null)
    {
      if ((this.jdField_a_of_type_Mqj == null) || (!this.jdField_a_of_type_Mqj.a())) {
        break label119;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a = true;
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363132);
      if ((((ImageView)localObject1).getVisibility() == 0) && (this.c == null)) {
        this.c = lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (View)localObject1, 7);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((this.jdField_a_of_type_Mqj != null) && (this.jdField_a_of_type_Mqj.a().size() != 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      }
      return;
      label119:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    Object localObject1 = this.jdField_a_of_type_Mqj.a().iterator();
    int i = 0;
    int j = 0;
    Object localObject2;
    View localView;
    int i2;
    int k;
    label238:
    int n;
    label252:
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (mqh)((Iterator)localObject1).next();
      localView = a(j, (mqh)localObject2);
      if (localView != null) {}
    }
    else
    {
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(j, i - j);
      }
      if (this.jdField_a_of_type_Mqj == null) {
        break label737;
      }
      i = this.jdField_a_of_type_Mqj.a();
      i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > 5) {
        break label552;
      }
      k = 1;
      n = ImmersiveUtils.a();
      if (k == 0) {
        break label557;
      }
      j = n / i;
      localObject1 = this.jdField_a_of_type_Mqj.b();
      if (k != 0) {
        break label668;
      }
      m = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if ((m >= ((ArrayList)localObject1).size()) || (i > 5)) {
          break label584;
        }
        localObject2 = (mqh)((ArrayList)localObject1).get(m);
        if (!((mqh)localObject2).c()) {
          break label748;
        }
        if (i == 5) {
          break;
        }
        j = ((mqh)localObject2).a + j;
        label320:
        i += 1;
        label324:
        m += 1;
      }
    }
    if (localView.getId() == 2131695652)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        k = (int)muc.b(getContext(), localView.getPaddingRight());
        m = (int)muc.b(getContext(), localView.getPaddingTop());
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131695650)
    {
      this.b = lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 6);
      if (this.b != null)
      {
        k = (int)muc.b(getContext(), localView.getPaddingRight());
        m = (int)muc.b(getContext(), localView.getPaddingTop());
        this.b.a(0, k, m, 0).a();
      }
    }
    a((mqh)localObject2, localView);
    j += 1;
    if ((((mqh)localObject2).c()) && (AudioHelper.a(0) == 1)) {
      if (i % 2 == 0)
      {
        localView.setBackgroundColor(-536881408);
        label534:
        i += 1;
      }
    }
    for (;;)
    {
      break;
      localView.setBackgroundColor(-539173668);
      break label534;
      label552:
      k = 0;
      break label238;
      label557:
      j = (int)(n * 1.0F / 5.5F);
      break label252;
      j = ((mqh)localObject2).a / 2 + j;
      break label320;
      label584:
      j = (int)((n - j) * 1.0F / 5.5F);
      i = 0;
      m = 0;
      label602:
      if (m < i2)
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
        if (((View)localObject2).getVisibility() == 0)
        {
          n = 1;
          label631:
          if (n == 0) {
            break label745;
          }
          if (k == 0) {
            break label710;
          }
          n = j;
          ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(n, -2));
        }
      }
      label643:
      label668:
      label710:
      label737:
      label745:
      for (;;)
      {
        m += 1;
        break label602;
        axqy.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
        break;
        n = 0;
        break label631;
        int i1 = i + 1;
        n = ((mqh)((ArrayList)localObject1).get(i)).a + j;
        i = i1;
        break label643;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
        return;
      }
      label748:
      break label324;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(paramInt);
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
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363132)
    {
      if (this.jdField_a_of_type_Mhs != null) {
        this.jdField_a_of_type_Mhs.a(this, 3);
      }
      if (this.c != null)
      {
        lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.c, 7);
        this.c = null;
      }
      mqo.a("0X800A566", 0);
    }
    for (;;)
    {
      if ((paramView.getId() == 2131695652) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 2);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
      }
      if ((paramView.getId() == 2131695650) && (this.b != null))
      {
        lvv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.b, 6);
        this.b = null;
      }
      return;
      if (this.jdField_a_of_type_Mhs != null) {
        this.jdField_a_of_type_Mhs.a(this, paramView);
      }
    }
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN"));
    }
  }
  
  public void setQavMenuActionListener(mhs parammhs)
  {
    this.jdField_a_of_type_Mhs = parammhs;
  }
  
  public void setViewController(mqj parammqj)
  {
    this.jdField_a_of_type_Mqj = parammqj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */