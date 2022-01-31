package com.tencent.av.ui;

import aciy;
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
import awqx;
import azue;
import baip;
import bajq;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import lxg;
import lxh;
import mfl;
import mfn;
import mfs;
import mis;
import mit;
import mjg;

public class QavOperationMenuView
  extends RelativeLayout
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  public VideoAppInterface a;
  BeautySeekView jdField_a_of_type_ComTencentAvUiBeautySeekView = null;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  lxg jdField_a_of_type_Lxg = null;
  mfn jdField_a_of_type_Mfn = null;
  private RedTouch b;
  
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
  
  private void a(mfl parammfl, View paramView)
  {
    paramView.setClickable(parammfl.a());
    int i;
    TextView localTextView;
    int j;
    int k;
    if (parammfl.c())
    {
      i = 0;
      paramView.setVisibility(i);
      if ((paramView instanceof TextView))
      {
        localTextView = (TextView)paramView;
        j = mis.a(paramView, 2131309425);
        k = mis.a(paramView, 2131298851);
        String str = parammfl.b();
        paramView = mis.a(paramView, 2131309450);
        if (TextUtils.isEmpty(str)) {
          break label168;
        }
        localTextView.setTag(2131309425, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131309450, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, aciy.a(28.0F, localTextView.getResources()), aciy.a(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
    }
    label168:
    label248:
    for (;;)
    {
      if (!baip.a(parammfl.a())) {
        localTextView.setText(parammfl.a());
      }
      return;
      i = 8;
      break;
      localTextView.setTag(2131309450, null);
      if (parammfl.b()) {}
      for (i = 2131100260;; i = 2131100259)
      {
        if ((parammfl.b() == j) && (i == k)) {
          break label248;
        }
        localTextView.setTag(2131309425, Integer.valueOf(parammfl.b()));
        localTextView.setTag(2131298851, Integer.valueOf(i));
        AudioHelper.a(getResources(), localTextView, parammfl.b(), i, i);
        break;
      }
    }
  }
  
  private void b()
  {
    setGravity(80);
    LayoutInflater.from(getContext()).inflate(2131493993, this, true);
    setBackgroundResource(2130841579);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297566));
    this.jdField_a_of_type_ComTencentAvUiBeautySeekView = ((BeautySeekView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297586));
    this.jdField_a_of_type_ComTencentAvUiBeautySeekView.a(getContext().getString(2131630027), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautySeekView.setBeautySeekActionListener(new lxh(this));
    ImageView localImageView = (ImageView)findViewById(2131297583);
    if (AEFilterSupport.a())
    {
      Drawable localDrawable = getResources().getDrawable(2130841352);
      mit localmit = mit.a(getResources(), 2130841352, 2131100249);
      localmit.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localImageView.setImageDrawable(localmit);
      localImageView.setBackgroundDrawable(null);
      localImageView.setOnClickListener(this);
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131305427));
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
    int i = aciy.a(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(azue.a(i, i));
    paramTextView.setDecodeHandler(azue.a);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, mfl parammfl)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramInt < 0)) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= paramInt)
    {
      parammfl = a(parammfl);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammfl, paramInt);
      return parammfl;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    mfl localmfl = (mfl)localView.getTag(2131305434);
    if ((localmfl != null) && (localmfl.a() == parammfl.a())) {
      return localView;
    }
    parammfl = a(parammfl);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(parammfl, paramInt);
    return parammfl;
  }
  
  View a(mfl parammfl)
  {
    if (parammfl == null) {
      return null;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams(localLayoutParams);
    AudioHelper.a(getResources(), localButton, parammfl.b(), 2131100259, 2131100259);
    if (!baip.a(parammfl.a())) {
      localButton.setText(parammfl.a());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(parammfl.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131305434, parammfl);
    localButton.setTextSize(bajq.e(aciy.a(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(aciy.a(8.0F, getResources()));
    parammfl.a = ((int)Math.max(mjg.a(localButton), aciy.a(28.0F, getResources())));
    return localButton;
  }
  
  @SuppressLint({"ResourceType"})
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiBeautySeekView != null)
    {
      if ((this.jdField_a_of_type_Mfn == null) || (!this.jdField_a_of_type_Mfn.a())) {
        break label75;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiBeautySeekView.a = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((this.jdField_a_of_type_Mfn != null) && (this.jdField_a_of_type_Mfn.a().size() != 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      }
      return;
      label75:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    Object localObject1 = this.jdField_a_of_type_Mfn.a().iterator();
    int i = 0;
    int j = 0;
    Object localObject2;
    View localView;
    int i2;
    int k;
    label194:
    int n;
    label208:
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (mfl)((Iterator)localObject1).next();
      localView = a(j, (mfl)localObject2);
      if (localView != null) {}
    }
    else
    {
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(j, i - j);
      }
      if (this.jdField_a_of_type_Mfn == null) {
        break label693;
      }
      i = this.jdField_a_of_type_Mfn.a();
      i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > 5) {
        break label508;
      }
      k = 1;
      n = ImmersiveUtils.a();
      if (k == 0) {
        break label513;
      }
      j = n / i;
      localObject1 = this.jdField_a_of_type_Mfn.b();
      if (k != 0) {
        break label624;
      }
      m = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if ((m >= ((ArrayList)localObject1).size()) || (i > 5)) {
          break label540;
        }
        localObject2 = (mfl)((ArrayList)localObject1).get(m);
        if (!((mfl)localObject2).c()) {
          break label704;
        }
        if (i == 5) {
          break;
        }
        j = ((mfl)localObject2).a + j;
        label276:
        i += 1;
        label280:
        m += 1;
      }
    }
    if (localView.getId() == 2131629970)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localView, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        k = (int)mjg.b(getContext(), localView.getPaddingRight());
        m = (int)mjg.b(getContext(), localView.getPaddingTop());
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131629968)
    {
      this.b = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localView, 6);
      if (this.b != null)
      {
        k = (int)mjg.b(getContext(), localView.getPaddingRight());
        m = (int)mjg.b(getContext(), localView.getPaddingTop());
        this.b.a(0, k, m, 0).a();
      }
    }
    a((mfl)localObject2, localView);
    j += 1;
    if ((((mfl)localObject2).c()) && (AudioHelper.a(0) == 1)) {
      if (i % 2 == 0)
      {
        localView.setBackgroundColor(-536881408);
        label490:
        i += 1;
      }
    }
    for (;;)
    {
      break;
      localView.setBackgroundColor(-539173668);
      break label490;
      label508:
      k = 0;
      break label194;
      label513:
      j = (int)(n * 1.0F / 5.5F);
      break label208;
      j = ((mfl)localObject2).a / 2 + j;
      break label276;
      label540:
      j = (int)((n - j) * 1.0F / 5.5F);
      i = 0;
      m = 0;
      label558:
      if (m < i2)
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
        if (((View)localObject2).getVisibility() == 0)
        {
          n = 1;
          label587:
          if (n == 0) {
            break label701;
          }
          if (k == 0) {
            break label666;
          }
          n = j;
          label599:
          ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(n, -2));
        }
      }
      label666:
      label693:
      label701:
      for (;;)
      {
        m += 1;
        break label558;
        label624:
        awqx.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
        break;
        n = 0;
        break label587;
        int i1 = i + 1;
        n = ((mfl)((ArrayList)localObject1).get(i)).a + j;
        i = i1;
        break label599;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
        return;
      }
      label704:
      break label280;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiBeautySeekView != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautySeekView.a(paramInt);
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
    if (paramView.getId() == 2131297583)
    {
      if (this.jdField_a_of_type_Lxg != null) {
        this.jdField_a_of_type_Lxg.a(this, 3);
      }
      mfs.a("0X800A566", 0);
    }
    for (;;)
    {
      if ((paramView.getId() == 2131629970) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, 2);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
      }
      if ((paramView.getId() == 2131629968) && (this.b != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.b, 6);
        this.b = null;
      }
      return;
      if (this.jdField_a_of_type_Lxg != null) {
        this.jdField_a_of_type_Lxg.a(this, paramView);
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
  
  public void setQavMenuActionListener(lxg paramlxg)
  {
    this.jdField_a_of_type_Lxg = paramlxg;
  }
  
  public void setViewController(mfn parammfn)
  {
    this.jdField_a_of_type_Mfn = parammfn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */