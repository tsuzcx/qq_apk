import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/view/WeatherView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$OnLineStatusBlurBgListener;", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionManager$ReceiveDataListener;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "activity", "Landroid/app/Activity;", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "accountPanel", "Lcom/tencent/mobileqq/onlinestatus/AccountPanel;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/AccountPanel;)V", "getAccountPanel", "()Lcom/tencent/mobileqq/onlinestatus/AccountPanel;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "appContext", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "getAppContext", "()Lcom/tencent/qphone/base/util/BaseApplication;", "setAppContext", "(Lcom/tencent/qphone/base/util/BaseApplication;)V", "contentView", "Landroid/view/View;", "cornerBg", "", "getCornerBg", "()F", "setCornerBg", "(F)V", "defaultWeatherDrawable", "Landroid/graphics/drawable/Drawable;", "heightBg", "", "getHeightBg", "()I", "setHeightBg", "(I)V", "needSwitchOnlineStatus", "", "nightThemeBg", "getOnLineStatusBlurBg", "()Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "setOnLineStatusBlurBg", "(Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;)V", "permissionItem", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionChecker$OnlineStatusPermissionItem;", "viewAddress", "Landroid/widget/TextView;", "viewChangeFriends", "viewDate", "viewMainTitle", "viewSelectFriends", "viewSelectStatus", "Landroid/widget/Button;", "getViewSelectStatus", "()Landroid/widget/Button;", "setViewSelectStatus", "(Landroid/widget/Button;)V", "viewSubTitle", "viewTemperature", "viewWeatherBg", "Landroid/widget/ImageView;", "viewWeatherHint", "viewWeatherIcon", "viewWeatherName", "weatherObserver", "Lcom/tencent/mobileqq/onlinestatus/weather/WeatherObserver;", "weatherRootView", "widthBg", "getWidthBg", "setWidthBg", "beforeDismiss", "", "bindTextView", "hasPartPermission", "bindView", "blurBackground", "blurBgResult", "isSuccess", "bitmap", "Landroid/graphics/Bitmap;", "color", "createView", "initCardRect", "cardRect", "", "initData", "onActivityResult", "requestCode", "responseCode", "data", "Landroid/content/Intent;", "onBackPressed", "onDataReceived", "item", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusFriendsPermissionItem;", "smartSelectedList", "", "setImageDrawable", "url", "", "view", "corner", "outWidth", "outHeight", "drawable", "show", "specialDate", "time", "", "updateButtonAndSpan", "updateButtonText", "change", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class axzo
  extends axzb
  implements axuv, axvr
{
  private int jdField_a_of_type_Int;
  @NotNull
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final axsv jdField_a_of_type_Axsv;
  @NotNull
  private axut jdField_a_of_type_Axut;
  private ayaa jdField_a_of_type_Ayaa;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private float jdField_c_of_type_Float;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private final View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private final View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public axzo(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, @NotNull axut paramaxut, @NotNull axsv paramaxsv)
  {
    super((Context)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Axut = paramaxut;
    this.jdField_a_of_type_Axsv = paramaxsv;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplication.context;
    this.jdField_d_of_type_AndroidViewView = a();
    this.jdField_d_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new axzp(this));
    paramQQAppInterface = this.jdField_d_of_type_AndroidViewView.findViewById(2131381018);
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "contentView.findViewById(R.id.weather_root)");
    this.jdField_e_of_type_AndroidViewView = paramQQAppInterface;
    this.jdField_e_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)axzq.a);
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView;
    b();
    setContentView(this.jdField_d_of_type_AndroidViewView);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appContext");
    paramQQAppInterface = paramQQAppInterface.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appContext.resources");
    int j = paramQQAppInterface.getDisplayMetrics().widthPixels;
    paramQQAppInterface = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appContext");
    this.jdField_a_of_type_Int = (j - AIOUtils.dp2px(80.0F, paramQQAppInterface.getResources()));
    paramQQAppInterface = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appContext");
    this.jdField_b_of_type_Int = AIOUtils.dp2px(211.0F, paramQQAppInterface.getResources());
    this.jdField_c_of_type_Float = (12 * DeviceInfoUtil.getDesity());
    paramQQAppInterface = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appContext");
    paramQQAppInterface = bfpx.a(paramQQAppInterface.getResources(), 2130841498, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = bfvo.d(paramQQAppInterface, this.jdField_c_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(paramActivity, "appContext");
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)new BitmapDrawable(paramActivity.getResources(), paramQQAppInterface));
    }
  }
  
  private final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    localURLDrawableOptions.mRequestWidth = paramInt2;
    localURLDrawableOptions.mRequestHeight = paramInt3;
    paramDrawable = (CharSequence)paramString;
    if ((paramDrawable == null) || (paramDrawable.length() == 0))
    {
      paramInt2 = 1;
      if (paramInt2 == 0) {
        break label82;
      }
      if (paramImageView != null) {
        paramImageView.setImageDrawable(localURLDrawableOptions.mFailedDrawable);
      }
    }
    label82:
    do
    {
      return;
      paramInt2 = 0;
      break;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramInt1 > 0)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramString, "drawable");
        paramString.setTag(bfol.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
        paramString.setDecodeHandler(bfol.h);
      }
    } while (paramImageView == null);
    paramImageView.setImageDrawable((Drawable)paramString);
  }
  
  private final void a(boolean paramBoolean)
  {
    boolean bool = true;
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    int j;
    if (localButton != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus() != 1030) {
        break label126;
      }
      if (!paramBoolean) {
        break label114;
      }
      j = 2131691216;
      if (QLog.isColorLevel()) {
        QLog.d("WeatherView", 2, new Object[] { "updateButtonText: called. ", "change: " + paramBoolean });
      }
      if (paramBoolean) {
        break label121;
      }
      label86:
      this.jdField_a_of_type_Boolean = bool;
      localButton.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(j));
      localButton.setEnabled(paramBoolean);
    }
    for (;;)
    {
      return;
      label114:
      j = 2131692909;
      break;
      label121:
      bool = false;
      break label86;
      label126:
      localButton.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131694500));
      localButton.setEnabled(true);
    }
  }
  
  private final void b()
  {
    this.jdField_a_of_type_Ayaa = ((ayaa)new axzt(this));
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    Object localObject2 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "appContext.resources");
    localObject1 = ((Resources)localObject2).getString(2131691214);
    if (paramBoolean) {
      localObject1 = ((Resources)localObject2).getString(2131691220);
    }
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((Resources)localObject2).getString(2131691219);
    localObject2 = this.f;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = this.g;
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText((CharSequence)localObjectRef.element);
      ((TextView)localObject1).setClickable(true);
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new axzr(this, localObjectRef, paramBoolean));
      ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new mun());
      if (!bjuk.a()) {
        break label166;
      }
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837509, 0);
    }
    for (;;)
    {
      return;
      label166:
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837508, 0);
    }
  }
  
  private final void c()
  {
    Object localObject;
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130846045);
      a(false, null, Color.parseColor("#FF010101"));
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    do
    {
      return;
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130846044);
      localObject = new axuu();
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      if (localActivity == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
      }
      ((axuu)localObject).a = ((BaseActivity)localActivity);
      this.jdField_a_of_type_Axut.a((axuu)localObject, (axuv)this);
      localObject = this.jdField_c_of_type_AndroidViewView;
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
  }
  
  private final void f()
  {
    boolean bool1 = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    boolean bool2;
    if (localObject != null)
    {
      if (!((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).isAllHasPermission()) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(370);
        if (localObject != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager");
      }
      boolean bool3 = ((axvp)localObject).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, (axvr)this);
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      b(bool2);
      a(bool1);
      return;
      bool2 = false;
    }
  }
  
  @NotNull
  public final Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @NotNull
  public final View a()
  {
    View localView = View.inflate((Context)BaseApplication.context, 2131561473, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131381015));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370534));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378279));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381017));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377038));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381014));
    this.f = ((TextView)localView.findViewById(2131377024));
    this.g = ((TextView)localView.findViewById(2131377017));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362210));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365299));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131371803);
    this.h = ((TextView)localView.findViewById(2131370550));
    this.i = ((TextView)localView.findViewById(2131377933));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  @NotNull
  public final axsv a()
  {
    return this.jdField_a_of_type_Axsv;
  }
  
  @NotNull
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  @NotNull
  public final String a(long paramLong)
  {
    Object localObject = new Date(paramLong);
    localObject = axyi.a().format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultDateFormat.format(date)");
    return localObject;
  }
  
  @SuppressLint({"SetTextI18n"})
  public final void a()
  {
    boolean bool2 = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    Friends localFriends = ((amsw)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    label113:
    int j;
    if (localObject2 != null)
    {
      localObject1 = localFriends.weatherTip;
      if (localObject1 != null)
      {
        localObject1 = (CharSequence)localObject1;
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
    }
    else
    {
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = localFriends.weatherType;
        if (localObject1 == null) {
          break label539;
        }
        localObject1 = (CharSequence)localObject1;
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject2 = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localFriends.city;
        if (localObject1 == null) {
          break label550;
        }
        label152:
        localStringBuilder = localStringBuilder.append((String)localObject1);
        localObject1 = localFriends.area;
        if (localObject1 == null) {
          break label558;
        }
        label173:
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = localFriends.temper;
        if (localObject1 == null) {
          break label566;
        }
        localObject1 = (CharSequence)localObject1;
        label221:
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
      if (localObject1 != null) {
        ((Button)localObject1).setOnClickListener((View.OnClickListener)new axzs(this));
      }
      this.jdField_a_of_type_Boolean = true;
      a(false);
      localObject2 = (apzf)apub.a().a(652);
      localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
      j = AIOUtils.dp2px(26.0F, ((BaseApplication)localObject1).getResources());
      if (localObject2 == null) {
        break label577;
      }
      localObject1 = ((apzf)localObject2).a(localFriends.weatherTypeId);
      if (localObject1 == null) {
        break label577;
      }
      localObject1 = ((axyf)localObject1).b;
      label333:
      a((String)localObject1, this.jdField_a_of_type_AndroidWidgetImageView, 0, j, j, URLDrawableHelper.TRANSPARENT);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        break label583;
      }
      localObject1 = URLDrawableHelper.TRANSPARENT;
      label361:
      if (localObject2 == null) {
        break label592;
      }
      localObject2 = ((apzf)localObject2).a(localFriends.weatherTypeId);
      if (localObject2 == null) {
        break label592;
      }
      localObject2 = ((axyf)localObject2).c;
      label390:
      a((String)localObject2, this.jdField_b_of_type_AndroidWidgetImageView, (int)this.jdField_c_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, (Drawable)localObject1);
      if (localFriends.weatherUpdateTime > 0L) {
        break label598;
      }
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
      label447:
      localObject1 = (CharSequence)localFriends.temper;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label634;
      }
      j = 1;
      label474:
      if (j == 0) {
        break label639;
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(370);
      if (localObject1 != null) {
        break label685;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager");
      localObject1 = (CharSequence)"";
      break;
      label539:
      localObject1 = (CharSequence)"";
      break label113;
      label550:
      localObject1 = "";
      break label152;
      label558:
      localObject1 = "";
      break label173;
      label566:
      localObject1 = (CharSequence)"";
      break label221;
      label577:
      localObject1 = null;
      break label333;
      label583:
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label361;
      label592:
      localObject2 = null;
      break label390;
      label598:
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {
        break label447;
      }
      ((TextView)localObject1).setText((CharSequence)a(localFriends.weatherUpdateTime * 1000));
      break label447;
      label634:
      j = 0;
      break label474;
      label639:
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)(localFriends.temper + "°"));
      }
    }
    label685:
    localObject1 = ((axvp)localObject1).a(40001, false, (axvr)this);
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (!((OnlineStatusFriendsPermissionItem)localObject1).allHasPermission) {
        bool1 = true;
      }
    }
    b(bool1);
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if ((paramInt1 == 998) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getSerializableExtra("online_status_permission_item") != null))
    {
      paramIntent = paramIntent.getSerializableExtra("online_status_permission_item");
      if (paramIntent == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem");
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent);
      f();
    }
  }
  
  public void a(@NotNull OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, @NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramOnlineStatusFriendsPermissionItem, "item");
    Intrinsics.checkParameterIsNotNull(paramList, "smartSelectedList");
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      f();
    }
  }
  
  public void a(boolean paramBoolean, @Nullable Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null) && (this.jdField_d_of_type_AndroidViewView != null)) {
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)new BitmapDrawable(paramBitmap));
    }
    while (this.jdField_d_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(paramInt);
  }
  
  protected void a(@Nullable int[] paramArrayOfInt)
  {
    View localView;
    if (paramArrayOfInt != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      if (localView.getWidth() == 0) {
        break label81;
      }
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      if (localView.getHeight() == 0) {
        break label81;
      }
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[0] = localView.getWidth();
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = localView.getHeight();
    }
    for (;;)
    {
      return;
      label81:
      paramArrayOfInt[0] = this.jdField_a_of_type_Int;
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = AIOUtils.dp2px(430.0F, localView.getResources());
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver((BusinessObserver)this.jdField_a_of_type_Ayaa);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_Axsv.a(1030);
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver((BusinessObserver)this.jdField_a_of_type_Ayaa);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)null);
    a();
    c();
    try
    {
      a(this.h, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(this.i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      super.show();
      b(true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WeatherView", 2, new Object[] { "show: called. ", "", localException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzo
 * JD-Core Version:    0.7.0.1
 */