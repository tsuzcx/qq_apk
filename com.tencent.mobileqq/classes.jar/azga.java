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
import com.tencent.mobileqq.app.QQManagerFactory;
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
public final class azga
  extends azfn
  implements azbg, azcd
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
  private final ayzg jdField_a_of_type_Ayzg;
  @NotNull
  private azbe jdField_a_of_type_Azbe;
  private azgm jdField_a_of_type_Azgm;
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
  
  public azga(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, @NotNull azbe paramazbe, @NotNull ayzg paramayzg)
  {
    super((Context)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Azbe = paramazbe;
    this.jdField_a_of_type_Ayzg = paramayzg;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplication.context;
    this.jdField_d_of_type_AndroidViewView = a();
    this.jdField_d_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new azgb(this));
    paramQQAppInterface = this.jdField_d_of_type_AndroidViewView.findViewById(2131381376);
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "contentView.findViewById(R.id.weather_root)");
    this.jdField_e_of_type_AndroidViewView = paramQQAppInterface;
    this.jdField_e_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)azgc.a);
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
    paramQQAppInterface = bgyo.a(paramQQAppInterface.getResources(), 2130841505, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = bheg.d(paramQQAppInterface, this.jdField_c_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
        paramString.setTag(bgxc.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
        paramString.setDecodeHandler(bgxc.h);
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
      j = 2131691301;
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
      j = 2131693015;
      break;
      label121:
      bool = false;
      break label86;
      label126:
      localButton.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131694701));
      localButton.setEnabled(true);
    }
  }
  
  private final void b()
  {
    this.jdField_a_of_type_Azgm = ((azgm)new azgf(this));
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    Object localObject2 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "appContext.resources");
    localObject1 = ((Resources)localObject2).getString(2131691299);
    if (paramBoolean) {
      localObject1 = ((Resources)localObject2).getString(2131691305);
    }
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((Resources)localObject2).getString(2131691304);
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
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new azgd(this, localObjectRef, paramBoolean));
      ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new mvl());
      if (!blfw.a()) {
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
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130846133);
      a(false, null, Color.parseColor("#FF010101"));
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    do
    {
      return;
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130846132);
      localObject = new azbf();
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      if (localActivity == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
      }
      ((azbf)localObject).a = ((BaseActivity)localActivity);
      this.jdField_a_of_type_Azbe.a((azbf)localObject, (azbg)this);
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER);
        if (localObject != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager");
      }
      boolean bool3 = ((azcb)localObject).a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, (azcd)this);
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
    View localView = View.inflate((Context)BaseApplication.context, 2131561535, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131381373));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370717));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378569));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381375));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377311));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131381372));
    this.f = ((TextView)localView.findViewById(2131377297));
    this.g = ((TextView)localView.findViewById(2131377290));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362213));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365394));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131371993);
    this.h = ((TextView)localView.findViewById(2131370733));
    this.i = ((TextView)localView.findViewById(2131378221));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  @NotNull
  public final ayzg a()
  {
    return this.jdField_a_of_type_Ayzg;
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
    localObject = azeu.a().format((Date)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "defaultDateFormat.format(date)");
    return localObject;
  }
  
  @SuppressLint({"SetTextI18n"})
  public final void a()
  {
    boolean bool2 = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
    }
    Friends localFriends = ((anvk)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    label114:
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
          break label540;
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
          break label551;
        }
        label153:
        localStringBuilder = localStringBuilder.append((String)localObject1);
        localObject1 = localFriends.area;
        if (localObject1 == null) {
          break label559;
        }
        label174:
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = localFriends.temper;
        if (localObject1 == null) {
          break label567;
        }
        localObject1 = (CharSequence)localObject1;
        label222:
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
      if (localObject1 != null) {
        ((Button)localObject1).setOnClickListener((View.OnClickListener)new azge(this));
      }
      this.jdField_a_of_type_Boolean = true;
      a(false);
      localObject2 = (arci)aqxe.a().a(652);
      localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
      j = AIOUtils.dp2px(26.0F, ((BaseApplication)localObject1).getResources());
      if (localObject2 == null) {
        break label578;
      }
      localObject1 = ((arci)localObject2).a(localFriends.weatherTypeId);
      if (localObject1 == null) {
        break label578;
      }
      localObject1 = ((azer)localObject1).b;
      label334:
      a((String)localObject1, this.jdField_a_of_type_AndroidWidgetImageView, 0, j, j, URLDrawableHelper.TRANSPARENT);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        break label584;
      }
      localObject1 = URLDrawableHelper.TRANSPARENT;
      label362:
      if (localObject2 == null) {
        break label593;
      }
      localObject2 = ((arci)localObject2).a(localFriends.weatherTypeId);
      if (localObject2 == null) {
        break label593;
      }
      localObject2 = ((azer)localObject2).c;
      label391:
      a((String)localObject2, this.jdField_b_of_type_AndroidWidgetImageView, (int)this.jdField_c_of_type_Float, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, (Drawable)localObject1);
      if (localFriends.weatherUpdateTime > 0L) {
        break label599;
      }
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
      label448:
      localObject1 = (CharSequence)localFriends.temper;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label635;
      }
      j = 1;
      label475:
      if (j == 0) {
        break label640;
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)"");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER);
      if (localObject1 != null) {
        break label686;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager");
      localObject1 = (CharSequence)"";
      break;
      label540:
      localObject1 = (CharSequence)"";
      break label114;
      label551:
      localObject1 = "";
      break label153;
      label559:
      localObject1 = "";
      break label174;
      label567:
      localObject1 = (CharSequence)"";
      break label222;
      label578:
      localObject1 = null;
      break label334;
      label584:
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label362;
      label593:
      localObject2 = null;
      break label391;
      label599:
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {
        break label448;
      }
      ((TextView)localObject1).setText((CharSequence)a(localFriends.weatherUpdateTime * 1000));
      break label448;
      label635:
      j = 0;
      break label475;
      label640:
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)(localFriends.temper + "°"));
      }
    }
    label686:
    localObject1 = ((azcb)localObject1).a(40001, false, (azcd)this);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver((BusinessObserver)this.jdField_a_of_type_Azgm);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_Ayzg.a(1030);
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver((BusinessObserver)this.jdField_a_of_type_Azgm);
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
 * Qualified Name:     azga
 * JD-Core Version:    0.7.0.1
 */