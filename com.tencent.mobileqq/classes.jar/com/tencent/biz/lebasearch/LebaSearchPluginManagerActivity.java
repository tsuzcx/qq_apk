package com.tencent.biz.lebasearch;

import Override;
import agej;
import akgr;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arsh;
import bdll;
import bhmq;
import bhpc;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import npx;
import npy;
import npz;
import nqb;
import nqc;

public class LebaSearchPluginManagerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static double a;
  static int jdField_a_of_type_Int = 110;
  static double jdField_b_of_type_Double = 0.4D;
  byte jdField_a_of_type_Byte;
  public float a;
  long jdField_a_of_type_Long = -1L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new nqc(this);
  public View a;
  protected Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  protected TextView a;
  public arsh a;
  bhpc jdField_a_of_type_Bhpc = null;
  public AccountDetailBounceScrollView a;
  List<arsh> jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean = true;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  bhpc jdField_b_of_type_Bhpc = null;
  private boolean jdField_b_of_type_Boolean;
  protected ImageView c;
  protected TextView c;
  
  static
  {
    jdField_a_of_type_Double = 0.5D;
  }
  
  public LebaSearchPluginManagerActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Arsh = null;
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376925);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372804);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new npx(this));
    this.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(new npy(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365759));
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height = ((int)(this.jdField_b_of_type_Int * jdField_a_of_type_Double));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(this.jdField_b_of_type_Int - getTitleBarHeight() - 56.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377430));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372800));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372803));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368224));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841593);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131379168));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372808));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369042));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131690559));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView = ((AccountDetailBounceScrollView)super.findViewById(2131377803));
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if ((localObject1 != null) && (localObject2 != null))
      {
        int i = agej.a(4.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject1).topMargin += i;
        ((RelativeLayout.LayoutParams)localObject2).topMargin += i;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setOnTouchListener(new npz(this));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setOnScrollChangedListener(new nqb(this));
    Object localObject2 = this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    for (Object localObject1 = null;; localObject1 = new BitmapDrawable(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((LebaPluginInfo)localObject2).strResName);
      localObject1 = findViewById(2131369909);
      if (!this.jdField_a_of_type_Boolean) {
        ((View)localObject1).setBackgroundColor(Color.parseColor("#59D3FF"));
      }
      b();
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Bhpc == null) {
        this.jdField_a_of_type_Bhpc = Utils.createPluginSetDialogForMain(this.app, this, 1, this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, null, this.jdField_a_of_type_AndroidOsHandler);
      }
      if (!this.jdField_a_of_type_Bhpc.isShowing()) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_Bhpc.show();
      return;
      if (this.jdField_b_of_type_Bhpc == null) {
        this.jdField_b_of_type_Bhpc = Utils.createPluginSetDialogForMain(this.app, this, 2, this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, "", this.jdField_a_of_type_AndroidOsHandler);
      }
    } while (this.jdField_b_of_type_Bhpc.isShowing());
    this.jdField_b_of_type_Bhpc.show();
  }
  
  private boolean a()
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.jdField_b_of_type_Int = (getResources().getDisplayMetrics().heightPixels - i);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", 0L);
    this.jdField_a_of_type_JavaUtilList = akgr.a().a();
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      arsh localarsh = (arsh)((Iterator)localObject).next();
      if ((localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == this.jdField_a_of_type_Long)) {
        this.jdField_a_of_type_Arsh = localarsh;
      }
    }
    if ((this.jdField_a_of_type_Arsh == null) || (this.jdField_a_of_type_Arsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
      return false;
    }
    this.jdField_a_of_type_Byte = this.jdField_a_of_type_Arsh.jdField_a_of_type_Byte;
    try
    {
      localObject = BitmapFactory.decodeResource(getResources(), 2130842308);
      this.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.c((Bitmap)localObject, 110, 110);
      ((Bitmap)localObject).recycle();
      label192:
      if ((Build.BRAND.startsWith("samsung")) || (Build.BRAND.startsWith("Coolpad"))) {}
      for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
      {
        this.jdField_b_of_type_Boolean = Build.BOARD.equals("mx");
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label192;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Arsh.jdField_a_of_type_Byte == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839308);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695377);
      if (this.jdField_a_of_type_Arsh.jdField_a_of_type_Byte == this.jdField_a_of_type_Byte) {
        break label75;
      }
    }
    label75:
    for (int i = -1;; i = 0)
    {
      setResult(i);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839291);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695381);
      break;
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    jdField_a_of_type_Double = this.jdField_a_of_type_AndroidViewView.getHeight() / this.jdField_b_of_type_Int;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height = ((int)(this.jdField_b_of_type_Int * jdField_a_of_type_Double));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(this.jdField_b_of_type_Int - getTitleBarHeight() - this.jdField_a_of_type_Float * 56.0F));
    paramInt = (int)(this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() - this.jdField_b_of_type_Int * (1.0D - jdField_a_of_type_Double) + this.jdField_a_of_type_Float * 56.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.setMaxOverScrollY(paramInt);
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY());
      c(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY());
    }
    this.jdField_b_of_type_AndroidViewView.postInvalidate();
  }
  
  @TargetApi(11)
  private void c(int paramInt)
  {
    int j;
    if (paramInt >= 0)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label53;
      }
      j = 460;
    }
    for (int i = 443;; i = (int)(0.29D * this.jdField_b_of_type_Int))
    {
      paramInt = this.jdField_a_of_type_AndroidViewView.getHeight() - paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        break label88;
      }
      if (paramInt > i) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label53:
      j = (int)(0.39D * this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    return;
    label88:
    if ((paramInt <= j) && (paramInt >= i))
    {
      float f;
      if (paramInt - i <= 0.01D * this.jdField_b_of_type_Int) {
        f = 0.05F;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(f);
        return;
        if (paramInt - i <= 0.02D * this.jdField_b_of_type_Int) {
          f = 0.15F;
        } else if (paramInt - i <= 0.03D * this.jdField_b_of_type_Int) {
          f = 0.25F;
        } else if (paramInt - i <= 0.04D * this.jdField_b_of_type_Int) {
          f = 0.35F;
        } else if (paramInt - i <= 0.05D * this.jdField_b_of_type_Int) {
          f = 0.45F;
        } else if (paramInt - i <= 0.06D * this.jdField_b_of_type_Int) {
          f = 0.55F;
        } else if (paramInt - i <= 0.07000000000000001D * this.jdField_b_of_type_Int) {
          f = 0.65F;
        } else if (paramInt - i <= this.jdField_b_of_type_Int * 0.08D) {
          f = 0.75F;
        } else if (paramInt - i <= this.jdField_b_of_type_Int * 0.08D) {
          f = 0.85F;
        } else {
          f = 0.95F;
        }
      }
    }
    if (paramInt < i)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height = ((int)(this.jdField_b_of_type_Int * jdField_a_of_type_Double));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(this.jdField_b_of_type_Int - getTitleBarHeight() - 56.0F * this.jdField_a_of_type_Float));
    i = this.jdField_a_of_type_AndroidViewView.getHeight() - paramInt;
    localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    double d1 = jdField_a_of_type_Double;
    double d2 = (jdField_b_of_type_Double * d1 - 0.05D) / (d1 - 0.3D);
    double d3 = (i - this.jdField_b_of_type_Int * 0.3D) / ((d1 - 0.3D) * this.jdField_b_of_type_Int);
    if (i <= this.jdField_b_of_type_Int * 0.3D)
    {
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(30.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(30.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.jdField_b_of_type_Int * 0.1D * 0.5D - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
      localLayoutParams.height = ((int)(32.0F * this.jdField_a_of_type_Float));
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - 1.0F * this.jdField_a_of_type_Float));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      return;
      if (i >= d1 * this.jdField_b_of_type_Int)
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)(jdField_a_of_type_Int * this.jdField_a_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * jdField_b_of_type_Double - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + 10.0F * this.jdField_a_of_type_Float));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - 5.0F * this.jdField_a_of_type_Float));
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)((30.0D + (jdField_a_of_type_Int - 30) * d3) * this.jdField_a_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)((i - this.jdField_b_of_type_Int * 0.3D) * d2 + this.jdField_b_of_type_Int * 0.1D * 0.5D - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + (1.0D + 9.0D * d3) * this.jdField_a_of_type_Float));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - (1.0D + 9.0D * d3) * this.jdField_a_of_type_Float / 2.0D));
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2131559814);
    akgr.jdField_a_of_type_Int |= 0x1;
    if (!a())
    {
      finish();
      return false;
    }
    a();
    if (this.jdField_a_of_type_Long == 886L) {
      bdll.b(this.app, "dc00899", "Grp_nearby", "", "dyn_set", "visit_nearby_intro", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Arsh.jdField_a_of_type_Byte != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        break;
      }
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity
 * JD-Core Version:    0.7.0.1
 */