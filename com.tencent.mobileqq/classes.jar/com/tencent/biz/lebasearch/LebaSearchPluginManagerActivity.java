package com.tencent.biz.lebasearch;

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
import com.tencent.biz.lebasearch.widget.LebaSearchBounceScrollView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class LebaSearchPluginManagerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  static double jdField_a_of_type_Double = 0.5D;
  static int jdField_a_of_type_Int = 110;
  static double jdField_b_of_type_Double = 0.4D;
  byte jdField_a_of_type_Byte;
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long = -1L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new LebaSearchPluginManagerActivity.5(this);
  protected View a;
  protected Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected TextView a;
  LebaSearchBounceScrollView jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView;
  LebaViewItem jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = null;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  List<LebaViewItem> jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected TextView b;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private boolean jdField_b_of_type_Boolean = false;
  protected ImageView c;
  protected TextView c;
  
  private void a()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376809);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372871);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new LebaSearchPluginManagerActivity.1(this));
    this.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(new LebaSearchPluginManagerActivity.2(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365882));
    Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_Int;
    double d1 = i;
    double d2 = jdField_a_of_type_Double;
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject1).height = ((int)(d1 * d2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(i - getTitleBarHeight() - this.jdField_a_of_type_Float * 56.0F));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377310));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372867));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372870));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368354));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841668);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131379008));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372875));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131690706));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView = ((LebaSearchBounceScrollView)super.findViewById(2131377672));
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if ((localObject1 != null) && (localObject2 != null))
      {
        i = AIOUtils.b(4.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject1).topMargin += i;
        ((RelativeLayout.LayoutParams)localObject2).topMargin += i;
      }
    }
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.setOnTouchListener(new LebaSearchPluginManagerActivity.3(this));
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.setOnScrollChangedListener(new LebaSearchPluginManagerActivity.4(this));
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      localObject1 = null;
    } else {
      localObject1 = new BitmapDrawable(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((LebaPluginInfo)localObject2).strResName);
    localObject1 = findViewById(2131370013);
    if (!this.jdField_a_of_type_Boolean) {
      ((View)localObject1).setBackgroundColor(Color.parseColor("#59D3FF"));
    }
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.createPluginSetDialogForMain(this.app, this, 1, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName, null, this.jdField_a_of_type_AndroidOsHandler);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.createPluginSetDialogForMain(this.app, this, 2, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName, "", this.jdField_a_of_type_AndroidOsHandler);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean a(ILebaHelperService paramILebaHelperService)
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.jdField_b_of_type_Int = (getResources().getDisplayMetrics().heightPixels - i);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", 0L);
    this.jdField_a_of_type_JavaUtilList = null;
    if (paramILebaHelperService != null) {
      this.jdField_a_of_type_JavaUtilList = paramILebaHelperService.getLebaMgrList();
    }
    paramILebaHelperService = this.jdField_a_of_type_JavaUtilList;
    if (paramILebaHelperService != null)
    {
      paramILebaHelperService = paramILebaHelperService.iterator();
      while (paramILebaHelperService.hasNext())
      {
        localObject = (LebaViewItem)paramILebaHelperService.next();
        if ((((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == this.jdField_a_of_type_Long)) {
          this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = ((LebaViewItem)localObject);
        }
      }
    }
    paramILebaHelperService = this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem;
    if (paramILebaHelperService != null)
    {
      if (paramILebaHelperService.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) {
        return false;
      }
      this.jdField_a_of_type_Byte = this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_Byte;
    }
    try
    {
      paramILebaHelperService = BitmapFactory.decodeResource(getResources(), 2130842422);
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c(paramILebaHelperService, 110, 110);
      paramILebaHelperService.recycle();
      label206:
      if ((!Build.BRAND.startsWith("samsung")) && (!Build.BRAND.startsWith("Coolpad"))) {
        this.jdField_a_of_type_Boolean = true;
      } else {
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_b_of_type_Boolean = Build.BOARD.equals("mx");
      return true;
      return false;
    }
    catch (OutOfMemoryError paramILebaHelperService)
    {
      break label206;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_Byte == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839297);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131696028);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839280);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131696032);
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_Byte != this.jdField_a_of_type_Byte) {
      i = -1;
    } else {
      i = 0;
    }
    setResult(i);
  }
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    jdField_a_of_type_Double = this.jdField_a_of_type_AndroidViewView.getHeight() / this.jdField_b_of_type_Int;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramInt = this.jdField_b_of_type_Int;
    double d1 = paramInt;
    double d2 = jdField_a_of_type_Double;
    Double.isNaN(d1);
    localLayoutParams.height = ((int)(d1 * d2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(paramInt - getTitleBarHeight() - this.jdField_a_of_type_Float * 56.0F));
    d1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
    d2 = this.jdField_b_of_type_Int;
    double d3 = jdField_a_of_type_Double;
    Double.isNaN(d2);
    Double.isNaN(d1);
    double d4 = this.jdField_a_of_type_Float * 56.0F;
    Double.isNaN(d4);
    paramInt = (int)(d1 - d2 * (1.0D - d3) + d4);
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.setMaxOverScrollY(paramInt);
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.getScrollY());
      c(this.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.getScrollY());
    }
    this.jdField_b_of_type_AndroidViewView.postInvalidate();
  }
  
  @TargetApi(11)
  private void c(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i;
      int j;
      double d1;
      if (this.jdField_b_of_type_Boolean)
      {
        i = 460;
        j = 443;
      }
      else
      {
        j = this.jdField_b_of_type_Int;
        d1 = j;
        Double.isNaN(d1);
        i = (int)(d1 * 0.39D);
        d1 = j;
        Double.isNaN(d1);
        j = (int)(d1 * 0.29D);
      }
      paramInt = this.jdField_a_of_type_AndroidViewView.getHeight() - paramInt;
      if (Build.VERSION.SDK_INT < 11)
      {
        if (paramInt <= j)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      if ((paramInt <= i) && (paramInt >= j))
      {
        d1 = paramInt - j;
        paramInt = this.jdField_b_of_type_Int;
        double d2 = paramInt;
        Double.isNaN(d2);
        float f;
        if (d1 <= d2 * 0.01D)
        {
          f = 0.05F;
        }
        else
        {
          d2 = paramInt;
          Double.isNaN(d2);
          if (d1 <= d2 * 0.02D)
          {
            f = 0.15F;
          }
          else
          {
            d2 = paramInt;
            Double.isNaN(d2);
            if (d1 <= d2 * 0.03D)
            {
              f = 0.25F;
            }
            else
            {
              d2 = paramInt;
              Double.isNaN(d2);
              if (d1 <= d2 * 0.04D)
              {
                f = 0.35F;
              }
              else
              {
                d2 = paramInt;
                Double.isNaN(d2);
                if (d1 <= d2 * 0.05D)
                {
                  f = 0.45F;
                }
                else
                {
                  d2 = paramInt;
                  Double.isNaN(d2);
                  if (d1 <= d2 * 0.06D)
                  {
                    f = 0.55F;
                  }
                  else
                  {
                    d2 = paramInt;
                    Double.isNaN(d2);
                    if (d1 <= d2 * 0.07000000000000001D)
                    {
                      f = 0.65F;
                    }
                    else
                    {
                      d2 = paramInt;
                      Double.isNaN(d2);
                      if (d1 <= d2 * 0.08D)
                      {
                        f = 0.75F;
                      }
                      else
                      {
                        d2 = paramInt;
                        Double.isNaN(d2);
                        if (d1 <= d2 * 0.08D) {
                          f = 0.85F;
                        } else {
                          f = 0.95F;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(f);
        return;
      }
      if (paramInt < j)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    i = this.jdField_b_of_type_Int;
    double d1 = i;
    double d2 = jdField_a_of_type_Double;
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject).height = ((int)(d1 * d2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(i - getTitleBarHeight() - this.jdField_a_of_type_Float * 56.0F));
    i = this.jdField_a_of_type_AndroidViewView.getHeight();
    localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    double d4 = jdField_a_of_type_Double;
    d1 = jdField_b_of_type_Double;
    double d3 = d4 - 0.3D;
    d2 = (d1 * d4 - 0.05D) / d3;
    d1 = i - paramInt;
    i = this.jdField_b_of_type_Int;
    double d5 = i;
    Double.isNaN(d5);
    Double.isNaN(d1);
    double d6 = i;
    Double.isNaN(d6);
    d3 = (d1 - d5 * 0.3D) / (d3 * d6);
    d5 = i;
    Double.isNaN(d5);
    if (d1 <= d5 * 0.3D)
    {
      float f = this.jdField_a_of_type_Float;
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(f * 30.0F));
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(f * 30.0F));
      d1 = i;
      Double.isNaN(d1);
      d2 = ((RelativeLayout.LayoutParams)localObject).height / 2;
      Double.isNaN(d2);
      d3 = paramInt;
      Double.isNaN(d3);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(d1 * 0.1D * 0.5D - d2 + d3));
      localLayoutParams.height = ((int)(this.jdField_a_of_type_Float * 32.0F));
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - this.jdField_a_of_type_Float * 1.0F));
    }
    else
    {
      d5 = i;
      Double.isNaN(d5);
      if (d1 >= d5 * d4)
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)(jdField_a_of_type_Int * this.jdField_a_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        d2 = jdField_b_of_type_Double;
        Double.isNaN(d1);
        d3 = ((RelativeLayout.LayoutParams)localObject).height / 2;
        Double.isNaN(d3);
        d4 = paramInt;
        Double.isNaN(d4);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(d1 * d2 - d3 + d4));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + this.jdField_a_of_type_Float * 10.0F));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - this.jdField_a_of_type_Float * 5.0F));
      }
      else
      {
        d4 = jdField_a_of_type_Int - 30;
        Double.isNaN(d4);
        d5 = this.jdField_a_of_type_Float;
        Double.isNaN(d5);
        ((RelativeLayout.LayoutParams)localObject).height = ((int)((d4 * d3 + 30.0D) * d5));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        i = this.jdField_b_of_type_Int;
        d4 = i;
        Double.isNaN(d4);
        Double.isNaN(d1);
        d5 = i;
        Double.isNaN(d5);
        d6 = ((RelativeLayout.LayoutParams)localObject).height / 2;
        Double.isNaN(d6);
        double d7 = paramInt;
        Double.isNaN(d7);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)((d1 - d4 * 0.3D) * d2 + d5 * 0.1D * 0.5D - d6 + d7));
        d2 = ((RelativeLayout.LayoutParams)localObject).height;
        d1 = d3 * 9.0D + 1.0D;
        d3 = this.jdField_a_of_type_Float;
        Double.isNaN(d3);
        Double.isNaN(d2);
        localLayoutParams.height = ((int)(d2 + d3 * d1));
        localLayoutParams.width = localLayoutParams.height;
        d2 = ((RelativeLayout.LayoutParams)localObject).topMargin;
        d3 = this.jdField_a_of_type_Float;
        Double.isNaN(d3);
        d1 = d1 * d3 / 2.0D;
        Double.isNaN(d2);
        localLayoutParams.topMargin = ((int)(d2 - d1));
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2131559806);
    paramBundle = (ILebaHelperService)this.app.getRuntimeService(ILebaHelperService.class, "");
    if (paramBundle != null) {
      paramBundle.setFlagBackFromMgr();
    } else {
      QLog.d("qqBaseActivity", 1, "doOnCreate lebaHelperService == null");
    }
    if (!a(paramBundle))
    {
      finish();
      return false;
    }
    a();
    if (this.jdField_a_of_type_Long == 886L) {
      ReportController.b(this.app, "dc00899", "Grp_nearby", "", "dyn_set", "visit_nearby_intro", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369202)
    {
      if (i == 2131377310)
      {
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_Byte != 0) {
          bool = true;
        } else {
          bool = false;
        }
        a(bool);
      }
    }
    else {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity
 * JD-Core Version:    0.7.0.1
 */