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
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.av.ui.viewcontroller.OperationBtnItem;
import com.tencent.av.ui.viewcontroller.QavOperationMenuViewController;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.TagIndex;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class QavOperationMenuView
  extends QavMenuBaseView
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  QavMenuActionListener jdField_a_of_type_ComTencentAvUiQavMenuActionListener = null;
  BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = null;
  QavOperationMenuViewController jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController = null;
  private boolean jdField_a_of_type_Boolean = false;
  private RedTouch[] jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch = new RedTouch[5];
  private Rect b = null;
  
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
    RedTouch localRedTouch1;
    if ((paramView != null) && (paramView.getId() == paramInt1))
    {
      RedTouch localRedTouch2 = AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramView, paramInt2);
      localRedTouch1 = localRedTouch2;
      if (localRedTouch2 != null)
      {
        localRedTouch2.a(0, (int)UITools.b(getContext(), paramView.getPaddingRight()), (int)UITools.b(getContext(), paramView.getPaddingTop()), 0).a();
        return localRedTouch2;
      }
    }
    else
    {
      localRedTouch1 = null;
    }
    return localRedTouch1;
  }
  
  private void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QavOperationMenuView_");
    ((StringBuilder)localObject).append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    setGravity(80);
    LayoutInflater.from(getContext()).inflate(2131559748, this, true);
    setBackgroundResource(2130842251);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363472));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363489));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(getContext().getString(2131695400), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(new QavOperationMenuView.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363487));
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = getResources().getDrawable(2130842001);
      TintStateDrawable localTintStateDrawable = TintStateDrawable.a(getResources(), 2130842001, 2131165975);
      localTintStateDrawable.setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localTintStateDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    b();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372183));
    if (AudioHelper.a(0) == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(536870656);
      setBackgroundColor(2130755583);
    }
  }
  
  private void a(OperationBtnItem paramOperationBtnItem, View paramView)
  {
    paramView.setClickable(paramOperationBtnItem.a());
    int i;
    if (paramOperationBtnItem.c()) {
      i = 0;
    } else {
      i = 8;
    }
    paramView.setVisibility(i);
    if ((paramView instanceof TextView))
    {
      TextView localTextView = (TextView)paramView;
      int j = TagIndex.a(paramView, 2131376470);
      int k = TagIndex.a(paramView, 2131364861);
      String str = paramOperationBtnItem.b();
      paramView = TagIndex.a(paramView, 2131376491);
      if (!TextUtils.isEmpty(str))
      {
        localTextView.setTag(2131376470, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131376491, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, AIOUtils.b(28.0F, localTextView.getResources()), AIOUtils.b(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
      else
      {
        localTextView.setTag(2131376491, null);
        if (paramOperationBtnItem.b()) {
          i = 2131165986;
        } else {
          i = 2131165985;
        }
        if ((paramOperationBtnItem.b() != j) || (i != k))
        {
          localTextView.setTag(2131376470, Integer.valueOf(paramOperationBtnItem.b()));
          localTextView.setTag(2131364861, Integer.valueOf(i));
          AudioHelper.a(getResources(), localTextView, paramOperationBtnItem.b(), i, i);
        }
      }
      if (!StringUtil.a(paramOperationBtnItem.a())) {
        localTextView.setText(paramOperationBtnItem.a());
      }
      if ((paramOperationBtnItem.jdField_a_of_type_Boolean) || (paramOperationBtnItem.jdField_a_of_type_Int == 0))
      {
        paramOperationBtnItem.jdField_a_of_type_Int = ((int)Math.max(UITools.a(localTextView), AIOUtils.b(28.0F, getResources())));
        paramOperationBtnItem.jdField_a_of_type_Boolean = false;
        if (QLog.isDevelopLevel())
        {
          paramView = new StringBuilder();
          paramView.append("updateView, width[");
          paramView.append(paramOperationBtnItem.jdField_a_of_type_Int);
          paramView.append("], title[");
          paramView.append(paramOperationBtnItem.a());
          paramView.append("]");
          QLog.i("WTogether", 2, paramView.toString());
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    boolean bool2 = false;
    if (localObject2 == null) {
      return false;
    }
    int i = 0;
    boolean bool1;
    Object localObject1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= ((LinearLayout)localObject2).getChildCount()) {
        break;
      }
      localObject1 = ((LinearLayout)localObject2).getChildAt(i);
      if ((localObject1 != null) && (((View)localObject1).getId() == paramInt) && (((View)localObject1).isShown()))
      {
        if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
          this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
        }
        if (this.b == null)
        {
          localObject2 = getResources().getDisplayMetrics();
          this.b = new Rect(0, 0, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
        }
        ((View)localObject1).getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
        bool1 = this.jdField_a_of_type_AndroidGraphicsRect.intersect(this.b);
        break;
      }
      i += 1;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkOperationBtnIsVisible, ret[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], id[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 2131695347: 
      return 4;
    case 2131695339: 
      return 3;
    case 2131695336: 
      return 0;
    case 2131695334: 
      return 1;
    }
    return 2;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (EffectsRenderController.b()) && (AEFilterSupport.a() > 3))
    {
      if (SessionMgr.a().a().r())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2131695347: 
      return 10;
    case 2131695339: 
      return 9;
    case 2131695336: 
      return 2;
    case 2131695334: 
      return 6;
    }
    return 7;
  }
  
  public Drawable a(TextView paramTextView, String paramString)
  {
    int i = AIOUtils.b(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(URLDrawableDecodeHandler.a(i, i));
    paramTextView.setDecodeHandler(URLDrawableDecodeHandler.a);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, OperationBtnItem paramOperationBtnItem)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (paramInt >= 0))
    {
      if (((LinearLayout)localObject).getChildCount() <= paramInt)
      {
        paramOperationBtnItem = a(paramOperationBtnItem);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramOperationBtnItem, paramInt);
        return paramOperationBtnItem;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
      OperationBtnItem localOperationBtnItem = (OperationBtnItem)((View)localObject).getTag(2131372190);
      if ((localOperationBtnItem != null) && (localOperationBtnItem.a() == paramOperationBtnItem.a())) {
        return localObject;
      }
      paramOperationBtnItem = a(paramOperationBtnItem);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramOperationBtnItem, paramInt);
      return paramOperationBtnItem;
    }
    return null;
  }
  
  View a(OperationBtnItem paramOperationBtnItem)
  {
    if (paramOperationBtnItem == null) {
      return null;
    }
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localButton.setSingleLine();
    AudioHelper.a(getResources(), localButton, paramOperationBtnItem.b(), 2131165985, 2131165985);
    if (!StringUtil.a(paramOperationBtnItem.a())) {
      localButton.setText(paramOperationBtnItem.a());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(paramOperationBtnItem.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131372190, paramOperationBtnItem);
    localButton.setTextSize(ViewUtils.e(AIOUtils.b(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(AIOUtils.b(8.0F, getResources()));
    float f = UITools.a(localButton);
    paramOperationBtnItem.jdField_a_of_type_Int = ((int)Math.max(f, AIOUtils.b(28.0F, getResources())));
    paramOperationBtnItem.jdField_a_of_type_Boolean = false;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createOperationBtn, title[");
      ((StringBuilder)localObject).append(paramOperationBtnItem.a());
      ((StringBuilder)localObject).append("], titleTxtWidth[");
      ((StringBuilder)localObject).append(f);
      ((StringBuilder)localObject).append("], width[");
      ((StringBuilder)localObject).append(paramOperationBtnItem.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether", 4, ((StringBuilder)localObject).toString());
    }
    return localButton;
  }
  
  void a(int paramInt)
  {
    BeautySeekView localBeautySeekView = this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView;
    if (localBeautySeekView != null) {
      localBeautySeekView.a(paramInt);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("BEAUTY_SKIN"));
      d();
      postDelayed(new QavOperationMenuView.2(this), 100L);
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
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "onHide");
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void d()
  {
    super.d();
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController;
      if ((localObject1 != null) && (((QavOperationMenuViewController)localObject1).a()))
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.jdField_a_of_type_Boolean = true;
        b();
        localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0))
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch;
          if (localObject1[2] == null) {
            localObject1[2] = AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 7);
          }
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController;
      if ((localObject1 != null) && (((QavOperationMenuViewController)localObject1).a().size() != 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController.a().iterator();
        int i = 0;
        int j = 0;
        Object localObject2;
        int k;
        int m;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (OperationBtnItem)((Iterator)localObject1).next();
          View localView = a(i, (OperationBtnItem)localObject2);
          if (localView == null) {
            break;
          }
          k = localView.getId();
          m = b(k);
          if (m >= 0)
          {
            RedTouch[] arrayOfRedTouch = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch;
            if (m < arrayOfRedTouch.length) {
              arrayOfRedTouch[m] = a(localView, k, a(k));
            }
          }
          a((OperationBtnItem)localObject2, localView);
          k = i + 1;
          i = k;
          if (((OperationBtnItem)localObject2).c())
          {
            i = k;
            if (AudioHelper.a(0) == 1)
            {
              if (j % 2 == 0) {
                localView.setBackgroundColor(-536881408);
              } else {
                localView.setBackgroundColor(-539173668);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        if (j > i) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(i, j - i);
        }
        localObject1 = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController;
        if (localObject1 != null)
        {
          localObject1 = ((QavOperationMenuViewController)localObject1).b();
          i = ((ArrayList)localObject1).size();
          int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
          if (i <= 5) {
            k = 1;
          } else {
            k = 0;
          }
          int i3 = ImmersiveUtils.getScreenWidth();
          if (k != 0) {
            i = i3 / i;
          } else {
            i = (int)(i3 * 1.0F / 5.5F);
          }
          int i1;
          int n;
          if (k == 0)
          {
            i = 0;
            j = 0;
            for (m = 0; (i < ((ArrayList)localObject1).size()) && (j <= 5); m = n)
            {
              localObject2 = (OperationBtnItem)((ArrayList)localObject1).get(i);
              i1 = j;
              n = m;
              if (((OperationBtnItem)localObject2).c())
              {
                if (j != 5) {
                  n = ((OperationBtnItem)localObject2).jdField_a_of_type_Int;
                } else {
                  n = ((OperationBtnItem)localObject2).jdField_a_of_type_Int / 2;
                }
                n = m + n;
                i1 = j + 1;
              }
              i += 1;
              j = i1;
            }
            if (i3 > m) {
              i = (int)((i3 - m) * 1.0F / 5.5F);
            } else {
              i = 0;
            }
          }
          else
          {
            ReportController.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
          }
          m = 0;
          for (j = 0; (m < i2) && (j < ((ArrayList)localObject1).size()); j = n)
          {
            localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            n = j;
            if (i1 != 0)
            {
              if (k != 0)
              {
                n = i;
              }
              else
              {
                n = j + 1;
                i1 = ((OperationBtnItem)((ArrayList)localObject1).get(j)).jdField_a_of_type_Int + i;
                j = n;
                n = i1;
              }
              ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(n, -2));
              n = j;
            }
            m += 1;
          }
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
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
    int j = paramView.getId();
    Object localObject;
    if (j == 2131363487)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavMenuActionListener;
      if (localObject != null) {
        ((QavMenuActionListener)localObject).a(this, 3);
      }
      AVUtil.a("0X800A566", 0);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiQavMenuActionListener;
      if (localObject != null) {
        ((QavMenuActionListener)localObject).a(this, paramView);
      }
    }
    int i = b(j);
    j = a(j);
    if (i >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch;
      if (i < localObject.length)
      {
        if (localObject[i] != null) {
          AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[i], j);
        }
        this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[i] = null;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setQavMenuActionListener(QavMenuActionListener paramQavMenuActionListener)
  {
    this.jdField_a_of_type_ComTencentAvUiQavMenuActionListener = paramQavMenuActionListener;
  }
  
  public void setViewController(QavOperationMenuViewController paramQavOperationMenuViewController)
  {
    this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController = paramQavOperationMenuViewController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */