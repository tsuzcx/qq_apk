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
import com.tencent.av.utils.TagIndex;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.AudioHelper;
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
    RedTouch localRedTouch2 = null;
    RedTouch localRedTouch1 = localRedTouch2;
    if (paramView != null)
    {
      localRedTouch1 = localRedTouch2;
      if (paramView.getId() == paramInt1)
      {
        localRedTouch2 = AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramView, paramInt2);
        localRedTouch1 = localRedTouch2;
        if (localRedTouch2 != null)
        {
          localRedTouch2.a(0, (int)UITools.b(getContext(), paramView.getPaddingRight()), (int)UITools.b(getContext(), paramView.getPaddingTop()), 0).a();
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
    LayoutInflater.from(getContext()).inflate(2131559872, this, true);
    setBackgroundResource(2130842353);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363546));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363565));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(getContext().getString(2131695390), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(new QavOperationMenuView.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363562));
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Drawable localDrawable = getResources().getDrawable(2130842104);
      TintStateDrawable localTintStateDrawable = TintStateDrawable.a(getResources(), 2130842104, 2131165964);
      localTintStateDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localTintStateDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    b();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372599));
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
    TextView localTextView;
    int j;
    int k;
    if (paramOperationBtnItem.c())
    {
      i = 0;
      paramView.setVisibility(i);
      if ((paramView instanceof TextView))
      {
        localTextView = (TextView)paramView;
        j = TagIndex.a(paramView, 2131376981);
        k = TagIndex.a(paramView, 2131364978);
        String str = paramOperationBtnItem.b();
        paramView = TagIndex.a(paramView, 2131377009);
        if (TextUtils.isEmpty(str)) {
          break label268;
        }
        localTextView.setTag(2131376981, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131377009, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, AIOUtils.a(28.0F, localTextView.getResources()), AIOUtils.a(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
    }
    label268:
    label350:
    for (;;)
    {
      if (!StringUtil.a(paramOperationBtnItem.a())) {
        localTextView.setText(paramOperationBtnItem.a());
      }
      if ((paramOperationBtnItem.jdField_a_of_type_Boolean) || (paramOperationBtnItem.jdField_a_of_type_Int == 0))
      {
        paramOperationBtnItem.jdField_a_of_type_Int = ((int)Math.max(UITools.a(localTextView), AIOUtils.a(28.0F, getResources())));
        paramOperationBtnItem.jdField_a_of_type_Boolean = false;
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether", 2, "updateView, width[" + paramOperationBtnItem.jdField_a_of_type_Int + "], title[" + paramOperationBtnItem.a() + "]");
        }
      }
      return;
      i = 8;
      break;
      localTextView.setTag(2131377009, null);
      if (paramOperationBtnItem.b()) {}
      for (i = 2131165975;; i = 2131165974)
      {
        if ((paramOperationBtnItem.b() == j) && (i == k)) {
          break label350;
        }
        localTextView.setTag(2131376981, Integer.valueOf(paramOperationBtnItem.b()));
        localTextView.setTag(2131364978, Integer.valueOf(i));
        AudioHelper.a(getResources(), localTextView, paramOperationBtnItem.b(), i, i);
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
    case 2131695326: 
      return 0;
    case 2131695324: 
      return 1;
    case 2131695329: 
      return 3;
    case 2131695337: 
      return 4;
    }
    return 2;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (EffectsRenderController.b()) && (AEFilterSupport.a() > 3)) {
      if (SessionMgr.a().a().A()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2131695326: 
      return 2;
    case 2131695324: 
      return 6;
    case 2131695329: 
      return 9;
    case 2131695337: 
      return 10;
    }
    return 7;
  }
  
  public Drawable a(TextView paramTextView, String paramString)
  {
    int i = AIOUtils.a(28.0F, paramTextView.getResources());
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
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (paramInt < 0)) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= paramInt)
    {
      paramOperationBtnItem = a(paramOperationBtnItem);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramOperationBtnItem, paramInt);
      return paramOperationBtnItem;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    OperationBtnItem localOperationBtnItem = (OperationBtnItem)localView.getTag(2131372606);
    if ((localOperationBtnItem != null) && (localOperationBtnItem.a() == paramOperationBtnItem.a())) {
      return localView;
    }
    paramOperationBtnItem = a(paramOperationBtnItem);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramOperationBtnItem, paramInt);
    return paramOperationBtnItem;
  }
  
  View a(OperationBtnItem paramOperationBtnItem)
  {
    if (paramOperationBtnItem == null) {
      return null;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams(localLayoutParams);
    localButton.setSingleLine();
    AudioHelper.a(getResources(), localButton, paramOperationBtnItem.b(), 2131165974, 2131165974);
    if (!StringUtil.a(paramOperationBtnItem.a())) {
      localButton.setText(paramOperationBtnItem.a());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(paramOperationBtnItem.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131372606, paramOperationBtnItem);
    localButton.setTextSize(ViewUtils.e(AIOUtils.a(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(AIOUtils.a(8.0F, getResources()));
    float f = UITools.a(localButton);
    paramOperationBtnItem.jdField_a_of_type_Int = ((int)Math.max(f, AIOUtils.a(28.0F, getResources())));
    paramOperationBtnItem.jdField_a_of_type_Boolean = false;
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether", 4, "createOperationBtn, title[" + paramOperationBtnItem.a() + "], titleTxtWidth[" + f + "], width[" + paramOperationBtnItem.jdField_a_of_type_Int + "]");
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
      if ((this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController == null) || (!this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController.a())) {
        break label128;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.jdField_a_of_type_Boolean = true;
      b();
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[2] == null)) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[2] = AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetImageView, 7);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController != null) && (this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController.a().size() != 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      }
      return;
      label128:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController.a().iterator();
    int i = 0;
    int j = 0;
    Object localObject2;
    View localView;
    int i2;
    label254:
    int n;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (OperationBtnItem)((Iterator)localObject1).next();
      localView = a(j, (OperationBtnItem)localObject2);
      if (localView != null) {}
    }
    else
    {
      i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > j) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(j, i - j);
      }
      if (this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController == null) {
        break label657;
      }
      localObject1 = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController.b();
      i = ((ArrayList)localObject1).size();
      i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      if (i > 5) {
        break label447;
      }
      k = 1;
      n = ImmersiveUtils.getScreenWidth();
      if (k == 0) {
        break label452;
      }
      i = n / i;
      label268:
      if (k != 0) {
        break label588;
      }
      m = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if ((m >= ((ArrayList)localObject1).size()) || (i > 5)) {
          break label479;
        }
        localObject2 = (OperationBtnItem)((ArrayList)localObject1).get(m);
        if (!((OperationBtnItem)localObject2).c()) {
          break label668;
        }
        if (i == 5) {
          break;
        }
        j = ((OperationBtnItem)localObject2).jdField_a_of_type_Int + j;
        label327:
        i += 1;
        label331:
        m += 1;
      }
    }
    int k = localView.getId();
    int m = b(k);
    if ((m >= 0) && (m < this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch.length)) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[m] = a(localView, k, a(k));
    }
    a((OperationBtnItem)localObject2, localView);
    j += 1;
    if ((((OperationBtnItem)localObject2).c()) && (AudioHelper.a(0) == 1)) {
      if (i % 2 == 0)
      {
        localView.setBackgroundColor(-536881408);
        label429:
        i += 1;
      }
    }
    for (;;)
    {
      break;
      localView.setBackgroundColor(-539173668);
      break label429;
      label447:
      k = 0;
      break label254;
      label452:
      i = (int)(n * 1.0F / 5.5F);
      break label268;
      j = ((OperationBtnItem)localObject2).jdField_a_of_type_Int / 2 + j;
      break label327;
      label479:
      if (n > j)
      {
        i = (int)((n - j) * 1.0F / 5.5F);
        j = 0;
        m = 0;
        label503:
        if ((m >= i2) || (j >= ((ArrayList)localObject1).size())) {
          break label657;
        }
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
        if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0)) {
          break label624;
        }
        n = 1;
        if (n == 0) {
          break label665;
        }
        if (k == 0) {
          break label630;
        }
        n = i;
        ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(n, -2));
      }
      label657:
      label665:
      for (;;)
      {
        label546:
        label558:
        m += 1;
        break label503;
        i = 0;
        break;
        label588:
        ReportController.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
        break;
        label624:
        n = 0;
        break label546;
        label630:
        int i1 = j + 1;
        n = ((OperationBtnItem)((ArrayList)localObject1).get(j)).jdField_a_of_type_Int + i;
        j = i1;
        break label558;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
        return;
      }
      label668:
      break label331;
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131363562)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavMenuActionListener != null) {
        this.jdField_a_of_type_ComTencentAvUiQavMenuActionListener.a(this, 3);
      }
      AVUtil.a("0X800A566", 0);
    }
    for (;;)
    {
      int i = b(j);
      j = a(j);
      if ((i >= 0) && (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch.length))
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[i] != null) {
          AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[i], j);
        }
        this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[i] = null;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentAvUiQavMenuActionListener != null) {
        this.jdField_a_of_type_ComTencentAvUiQavMenuActionListener.a(this, paramView);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */