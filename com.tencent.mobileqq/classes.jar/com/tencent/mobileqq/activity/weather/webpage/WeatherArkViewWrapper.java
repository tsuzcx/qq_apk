package com.tencent.mobileqq.activity.weather.webpage;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.mvvm.LifeCycleExtKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkViewWrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleRes", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "arkHeight", "getArkHeight", "()I", "setArkHeight", "(I)V", "arkLoadCallback", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "arkView", "Lcom/tencent/ark/open/ArkView;", "getArkView", "()Lcom/tencent/ark/open/ArkView;", "downInArk", "", "hasMakeUpForTheLossDownEvent", "hasMove", "isArkLoaded", "()Z", "setArkLoaded", "(Z)V", "mSlideStartDir", "", "mStartTime", "", "mStartX", "", "mStartY", "scaledTouchSlop", "getScaledTouchSlop", "scaledTouchSlop$delegate", "Lkotlin/Lazy;", "topPadding", "getTopPadding", "topPadding$delegate", "touchEventData", "Landroidx/lifecycle/MutableLiveData;", "Landroid/view/MotionEvent;", "getTouchEventData", "()Landroidx/lifecycle/MutableLiveData;", "viewModel", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "createLoadFailView", "Landroid/view/View;", "dispatchTouchEvent", "event", "initArkView", "", "appName", "", "appView", "appVersion", "appMeta", "initViewModel", "store", "Landroidx/lifecycle/ViewModelStoreOwner;", "makeUpForLossDownEvent", "isForArk", "onLoadFailed", "onLoadSuccess", "onLoading", "setArkFixScaleDensity", "swipeDirectionJudge", "curX", "curY", "touchInArk", "y", "translateYToArkY", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherArkViewWrapper
  extends FrameLayout
{
  public static final WeatherArkViewWrapper.Companion a;
  private byte jdField_a_of_type_Byte;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @NotNull
  private final MutableLiveData<MotionEvent> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private ArkViewImplement.LoadCallback jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback;
  @NotNull
  private final ArkView jdField_a_of_type_ComTencentArkOpenArkView;
  private WeatherWebArkViewModel jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new WeatherArkViewWrapper.topPadding.2(this));
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final Lazy jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)new WeatherArkViewWrapper.scaledTouchSlop.2(this));
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper$Companion = new WeatherArkViewWrapper.Companion(null);
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WeatherArkViewWrapper(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentArkOpenArkView = new ArkView(paramContext, null);
    paramContext = getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources");
    paramContext = new ArkAppInfo.Size(paramContext.getDisplayMetrics().widthPixels, -1);
    setArkFixScaleDensity();
    this.jdField_a_of_type_ComTencentArkOpenArkView.setSize(paramContext, paramContext, paramContext);
    this.jdField_a_of_type_ComTencentArkOpenArkView.setBorderType(0);
    addView((View)this.jdField_a_of_type_ComTencentArkOpenArkView);
    setArkHeight(AIOUtils.a(310, getResources()));
  }
  
  private final float a(float paramFloat)
  {
    float f = getScrollY();
    if (this.jdField_a_of_type_Int > 0) {}
    for (int i = a();; i = 0) {
      return paramFloat + f - i;
    }
  }
  
  private final int a()
  {
    return ((Number)this.jdField_a_of_type_KotlinLazy.getValue()).intValue();
  }
  
  private final View a()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, this.jdField_a_of_type_Int);
    ((FrameLayout.LayoutParams)localObject).gravity = 1;
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setId(2131381832);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.setBackgroundColor(-1);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageResource(2130839619);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    int j = AIOUtils.a(170.0F, getResources()) - a();
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(getContext());
    }
    localLayoutParams.topMargin = i;
    localLayoutParams.gravity = 1;
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(2131720641);
    ((TextView)localObject).setTextSize(1, 15.0F);
    ((TextView)localObject).setTextColor(-16777216);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = AIOUtils.a(20.0F, getResources());
    localLayoutParams.gravity = 1;
    localLinearLayout.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    return (View)localLinearLayout;
  }
  
  private final void a()
  {
    WeatherWebArkViewModel localWeatherWebArkViewModel = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel;
    if (localWeatherWebArkViewModel != null) {
      localWeatherWebArkViewModel.a(1);
    }
    WeatherDCReportHelper.a().a(null, "new_ark_callup_success");
  }
  
  private final void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = Math.abs(paramFloat1 - this.jdField_a_of_type_Float);
    paramFloat2 = Math.abs(paramFloat2 - this.jdField_b_of_type_Float);
    if ((paramFloat1 > b()) || (paramFloat2 > b())) {
      if (paramFloat2 <= paramFloat1) {
        break label110;
      }
    }
    label110:
    for (byte b1 = 2;; b1 = 1)
    {
      this.jdField_a_of_type_Byte = b1;
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebArkWrapper", 2, "swipeDirectionJudge: absDx -> " + paramFloat1 + ", absDy -> " + paramFloat2 + ", mSlideStartDir -> " + this.jdField_a_of_type_Byte);
      }
      return;
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    MotionEvent localMotionEvent;
    if (!this.c)
    {
      this.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebArkWrapper", 2, "dispatchMissingDownEvent isForArk: " + paramBoolean);
      }
      localMotionEvent = MotionEvent.obtain(this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 0);
      if (!paramBoolean) {
        break label82;
      }
      super.dispatchTouchEvent(localMotionEvent);
    }
    for (;;)
    {
      localMotionEvent.recycle();
      return;
      label82:
      MutableLiveData localMutableLiveData = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
      if (localMotionEvent != null) {
        localMutableLiveData.setValue(localMotionEvent);
      }
    }
  }
  
  private final boolean a(float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    float f = a(paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkWrapper", 2, "touchInArk: locationX -> " + arrayOfInt[0] + ", locationY -> " + arrayOfInt[1] + ", scrollY => " + getScrollY() + ", eventY -> " + paramFloat + ", arkHeight-> " + this.jdField_a_of_type_Int);
    }
    return (f >= arrayOfInt[1]) && (f <= arrayOfInt[1] + this.jdField_a_of_type_Int);
  }
  
  private final int b()
  {
    return ((Number)this.jdField_b_of_type_KotlinLazy.getValue()).intValue();
  }
  
  private final void b()
  {
    WeatherWebArkViewModel localWeatherWebArkViewModel = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel;
    if (localWeatherWebArkViewModel != null) {
      localWeatherWebArkViewModel.a(0);
    }
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel;
    if (localObject != null) {
      ((WeatherWebArkViewModel)localObject).a(-1);
    }
    setArkHeight(AIOUtils.a(310, getResources()));
    localObject = findViewById(2131381832);
    if (localObject == null) {
      localObject = a();
    }
    for (;;)
    {
      addView((View)localObject);
      WeatherDCReportHelper.a().a(null, "new_ark_callup_fail");
      return;
      if ((((View)localObject).getParent() instanceof ViewGroup))
      {
        ViewParent localViewParent = ((View)localObject).getParent();
        if (localViewParent == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)localViewParent).removeView((View)localObject);
      }
    }
  }
  
  @NotNull
  public final MutableLiveData<MotionEvent> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  @NotNull
  public final ArkView a()
  {
    return this.jdField_a_of_type_ComTencentArkOpenArkView;
  }
  
  public final void a(@NotNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    Intrinsics.checkParameterIsNotNull(paramViewModelStoreOwner, "store");
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel = ((WeatherWebArkViewModel)LifeCycleExtKt.a(paramViewModelStoreOwner).get(WeatherWebArkViewModel.class));
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appName");
    Intrinsics.checkParameterIsNotNull(paramString2, "appView");
    Intrinsics.checkParameterIsNotNull(paramString3, "appVersion");
    Intrinsics.checkParameterIsNotNull(paramString4, "appMeta");
    String str = ArkAppCenterUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkWrapper", 2, "initArkView appName: " + paramString1 + ", appView: " + paramString2 + ", appVersion: " + paramString3 + ", appMeta: " + paramString4 + ", appConfig: " + str);
    }
    this.jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback = ((ArkViewImplement.LoadCallback)new WeatherArkViewWrapper.initArkView.1(this));
    this.jdField_a_of_type_ComTencentArkOpenArkView.load(paramString1, paramString2, paramString3, paramString4, str, this.jdField_a_of_type_ComTencentArkArkViewImplement$LoadCallback);
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    boolean bool2 = true;
    Object localObject;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      if (localObject != null) {
        break label66;
      }
      label25:
      if (localObject != null) {
        break label162;
      }
      label30:
      if (localObject != null) {
        break label320;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        i = j;
        label42:
        boolean bool1 = bool2;
        if (i != 0) {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
        }
        label66:
        do
        {
          return bool1;
          localObject = null;
          break;
          if (((Integer)localObject).intValue() != 0) {
            break label25;
          }
          this.jdField_b_of_type_Boolean = a(paramMotionEvent.getY());
          this.jdField_a_of_type_Boolean = false;
          this.c = false;
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          this.jdField_b_of_type_Float = paramMotionEvent.getY();
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          i = j;
          if (!QLog.isColorLevel()) {
            break label42;
          }
          QLog.d("WeatherWebArkWrapper", 2, "onTouchEvent ACTION_DOWN  downInArk: " + this.jdField_b_of_type_Boolean);
          i = j;
          break label42;
          if (((Integer)localObject).intValue() != 2) {
            break label30;
          }
          if (this.jdField_a_of_type_Byte == 0) {
            a(paramMotionEvent.getX(), paramMotionEvent.getY());
          }
          bool1 = bool2;
        } while (this.jdField_a_of_type_Byte == 0);
        label162:
        this.jdField_a_of_type_Boolean = true;
        getParent().requestDisallowInterceptTouchEvent(true);
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Byte == 1)) {
          a(true);
        }
        for (j = 1;; j = i)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WeatherWebArkWrapper", 2, "onTouchEvent ACTION_MOVE mSlideStartDir: " + this.jdField_a_of_type_Byte + ", downInArk: " + this.jdField_b_of_type_Boolean);
          i = j;
          break;
          a(false);
          localObject = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
          if (paramMotionEvent != null) {
            ((MutableLiveData)localObject).setValue(paramMotionEvent);
          }
        }
        label320:
        if (((Integer)localObject).intValue() == 1)
        {
          label329:
          if ((!this.jdField_b_of_type_Boolean) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Byte != 1))) {
            break label467;
          }
          a(true);
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebArkWrapper", 2, "onTouchEvent ACTION_UP mSlideStartDir: " + this.jdField_a_of_type_Byte + ", downInArk: " + this.jdField_b_of_type_Boolean + ", hasMove:" + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Byte = 0;
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      break;
      i = j;
      if (((Integer)localObject).intValue() != 3) {
        break;
      }
      break label329;
      label467:
      a(false);
      localObject = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
      if (paramMotionEvent != null) {
        ((MutableLiveData)localObject).setValue(paramMotionEvent);
      }
    }
  }
  
  public final void setArkFixScaleDensity()
  {
    float f = FontSettingManager.systemMetrics.density;
    QLog.i("WeatherWebArkWrapper", 1, "setArkFixScaleDensity system: " + f);
    if (f > 0) {
      this.jdField_a_of_type_ComTencentArkOpenArkView.setScaleDensity(f);
    }
  }
  
  public final void setArkHeight(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkWrapper", 2, "arkHeight set value : " + paramInt);
    }
    if (paramInt > 0) {}
    for (int i = a();; i = 0)
    {
      setPadding(0, i, 0, 0);
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  public final void setArkLoaded(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherArkViewWrapper
 * JD-Core Version:    0.7.0.1
 */