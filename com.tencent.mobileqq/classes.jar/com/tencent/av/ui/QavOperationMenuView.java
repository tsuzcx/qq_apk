package com.tencent.av.ui;

import aekt;
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
import azmj;
import bcuq;
import bdje;
import bdkf;
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
import lyc;
import mkk;
import mkl;
import mtb;
import mtd;
import mti;
import mwi;
import mwj;
import mww;

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
  mkk jdField_a_of_type_Mkk = null;
  mtd jdField_a_of_type_Mtd = null;
  private RedTouch b;
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    b();
  }
  
  private void a(mtb parammtb, View paramView)
  {
    paramView.setClickable(parammtb.a());
    int i;
    TextView localTextView;
    int j;
    int k;
    if (parammtb.c())
    {
      i = 0;
      paramView.setVisibility(i);
      if ((paramView instanceof TextView))
      {
        localTextView = (TextView)paramView;
        j = mwi.a(paramView, 2131375656);
        k = mwi.a(paramView, 2131364482);
        String str = parammtb.b();
        paramView = mwi.a(paramView, 2131375682);
        if (TextUtils.isEmpty(str)) {
          break label168;
        }
        localTextView.setTag(2131375656, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131375682, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, aekt.a(28.0F, localTextView.getResources()), aekt.a(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
    }
    label168:
    label248:
    for (;;)
    {
      if (!bdje.a(parammtb.a())) {
        localTextView.setText(parammtb.a());
      }
      return;
      i = 8;
      break;
      localTextView.setTag(2131375682, null);
      if (parammtb.b()) {}
      for (i = 2131165888;; i = 2131165887)
      {
        if ((parammtb.b() == j) && (i == k)) {
          break label248;
        }
        localTextView.setTag(2131375656, Integer.valueOf(parammtb.b()));
        localTextView.setTag(2131364482, Integer.valueOf(i));
        AudioHelper.a(getResources(), localTextView, parammtb.b(), i, i);
        break;
      }
    }
  }
  
  private void b()
  {
    setGravity(80);
    LayoutInflater.from(getContext()).inflate(2131559615, this, true);
    setBackgroundResource(2130841822);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363152));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363171));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(getContext().getString(2131695871), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(new mkl(this));
    ImageView localImageView = (ImageView)findViewById(2131363168);
    if (AEFilterSupport.a())
    {
      Drawable localDrawable = getResources().getDrawable(2130841578);
      mwj localmwj = mwj.a(getResources(), 2130841578, 2131165877);
      localmwj.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localImageView.setImageDrawable(localmwj);
      localImageView.setBackgroundDrawable(null);
      localImageView.setOnClickListener(this);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371433));
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
    int i = aekt.a(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(bcuq.a(i, i));
    paramTextView.setDecodeHandler(bcuq.a);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, mtb parammtb)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramInt < 0)) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= paramInt)
    {
      parammtb = a(parammtb);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammtb, paramInt);
      return parammtb;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    mtb localmtb = (mtb)localView.getTag(2131371440);
    if ((localmtb != null) && (localmtb.a() == parammtb.a())) {
      return localView;
    }
    parammtb = a(parammtb);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammtb, paramInt);
    return parammtb;
  }
  
  View a(mtb parammtb)
  {
    if (parammtb == null) {
      return null;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams(localLayoutParams);
    localButton.setSingleLine();
    AudioHelper.a(getResources(), localButton, parammtb.b(), 2131165887, 2131165887);
    if (!bdje.a(parammtb.a())) {
      localButton.setText(parammtb.a());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(parammtb.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131371440, parammtb);
    localButton.setTextSize(bdkf.e(aekt.a(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(aekt.a(8.0F, getResources()));
    parammtb.a = ((int)Math.max(mww.a(localButton), aekt.a(28.0F, getResources())));
    return localButton;
  }
  
  @SuppressLint({"ResourceType"})
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null)
    {
      if ((this.jdField_a_of_type_Mtd == null) || (!this.jdField_a_of_type_Mtd.a())) {
        break label119;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a = true;
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363168);
      if ((((ImageView)localObject1).getVisibility() == 0) && (this.c == null)) {
        this.c = lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (View)localObject1, 7);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((this.jdField_a_of_type_Mtd != null) && (this.jdField_a_of_type_Mtd.a().size() != 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      }
      return;
      label119:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    Object localObject1 = this.jdField_a_of_type_Mtd.a().iterator();
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
      localObject2 = (mtb)((Iterator)localObject1).next();
      localView = a(j, (mtb)localObject2);
      if (localView != null) {}
    }
    else
    {
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(j, i - j);
      }
      if (this.jdField_a_of_type_Mtd == null) {
        break label817;
      }
      i = this.jdField_a_of_type_Mtd.a();
      i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > 5) {
        break label632;
      }
      k = 1;
      n = ImmersiveUtils.a();
      if (k == 0) {
        break label637;
      }
      j = n / i;
      localObject1 = this.jdField_a_of_type_Mtd.b();
      if (k != 0) {
        break label748;
      }
      m = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if ((m >= ((ArrayList)localObject1).size()) || (i > 5)) {
          break label664;
        }
        localObject2 = (mtb)((ArrayList)localObject1).get(m);
        if (!((mtb)localObject2).c()) {
          break label828;
        }
        if (i == 5) {
          break;
        }
        j = ((mtb)localObject2).a + j;
        label320:
        i += 1;
        label324:
        m += 1;
      }
    }
    if (localView.getId() == 2131695810)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        k = (int)mww.b(getContext(), localView.getPaddingRight());
        m = (int)mww.b(getContext(), localView.getPaddingTop());
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131695808)
    {
      this.b = lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 6);
      if (this.b != null)
      {
        k = (int)mww.b(getContext(), localView.getPaddingRight());
        m = (int)mww.b(getContext(), localView.getPaddingTop());
        this.b.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131695813)
    {
      this.d = lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localView, 9);
      if (this.d != null)
      {
        k = (int)mww.b(getContext(), localView.getPaddingRight());
        m = (int)mww.b(getContext(), localView.getPaddingTop());
        this.d.a(0, k, m, 0).a();
      }
    }
    a((mtb)localObject2, localView);
    j += 1;
    if ((((mtb)localObject2).c()) && (AudioHelper.a(0) == 1)) {
      if (i % 2 == 0)
      {
        localView.setBackgroundColor(-536881408);
        label614:
        i += 1;
      }
    }
    for (;;)
    {
      break;
      localView.setBackgroundColor(-539173668);
      break label614;
      label632:
      k = 0;
      break label238;
      label637:
      j = (int)(n * 1.0F / 5.5F);
      break label252;
      j = ((mtb)localObject2).a / 2 + j;
      break label320;
      label664:
      j = (int)((n - j) * 1.0F / 5.5F);
      i = 0;
      m = 0;
      label682:
      if (m < i2)
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
        if (((View)localObject2).getVisibility() == 0)
        {
          n = 1;
          label711:
          if (n == 0) {
            break label825;
          }
          if (k == 0) {
            break label790;
          }
          n = j;
          label723:
          ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(n, -2));
        }
      }
      label790:
      label817:
      label825:
      for (;;)
      {
        m += 1;
        break label682;
        label748:
        azmj.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
        break;
        n = 0;
        break label711;
        int i1 = i + 1;
        n = ((mtb)((ArrayList)localObject1).get(i)).a + j;
        i = i1;
        break label723;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
        return;
      }
      label828:
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
    int i = paramView.getId();
    if (i == 2131363168)
    {
      if (this.jdField_a_of_type_Mkk != null) {
        this.jdField_a_of_type_Mkk.a(this, 3);
      }
      if (this.c != null)
      {
        lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.c, 7);
        this.c = null;
      }
      mti.a("0X800A566", 0);
    }
    do
    {
      do
      {
        while (i == 2131695810)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
          {
            lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 2);
            this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
          }
          return;
          if (this.jdField_a_of_type_Mkk != null) {
            this.jdField_a_of_type_Mkk.a(this, paramView);
          }
        }
        if (i != 2131695808) {
          break;
        }
      } while (this.b == null);
      lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.b, 6);
      this.b = null;
      return;
    } while ((i != 2131695813) || (this.d == null));
    lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.d, 9);
    this.d = null;
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN"));
    }
  }
  
  public void setQavMenuActionListener(mkk parammkk)
  {
    this.jdField_a_of_type_Mkk = parammkk;
  }
  
  public void setViewController(mtd parammtd)
  {
    this.jdField_a_of_type_Mtd = parammtd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */