import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.onlinestatus.view.ConstellationView.3;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/view/ConstellationView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardView;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$OnLineStatusBlurBgListener;", "Lcom/tencent/mobileqq/onlinestatus/constellation/ConstellationSelectCallback;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "activity", "Landroid/app/Activity;", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "accountPanel", "Lcom/tencent/mobileqq/onlinestatus/AccountPanel;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/AccountPanel;)V", "getAccountPanel", "()Lcom/tencent/mobileqq/onlinestatus/AccountPanel;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "appContext", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "getAppContext", "()Lcom/tencent/qphone/base/util/BaseApplication;", "setAppContext", "(Lcom/tencent/qphone/base/util/BaseApplication;)V", "birthdayValue", "", "constellationIndex", "constellationStr", "", "contentView", "Landroid/view/View;", "defaultBgDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "getOnLineStatusBlurBg", "()Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "setOnLineStatusBlurBg", "(Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;)V", "selfProfileCard", "Lcom/tencent/mobileqq/data/Card;", "statusExtInfoObserver", "Lcom/tencent/mobileqq/onlinestatus/constellation/StatusExtInfoObserver;", "todayConstellationTrend", "viewChangeConstellation", "Landroid/widget/TextView;", "viewConstellationDate", "viewConstellationIcon", "Landroid/widget/ImageView;", "viewConstellationName", "viewConstellationTrend", "viewMainBackground", "viewMainTitle", "viewNightThemeBg", "viewSelectConstellation", "viewSelectStatus", "Landroid/widget/Button;", "viewSubTitle", "widthBg", "getWidthBg", "()I", "setWidthBg", "(I)V", "beforeDismiss", "", "bindTextView", "bindView", "blurBackground", "blurBgResult", "isSuccess", "", "bitmap", "Landroid/graphics/Bitmap;", "color", "createView", "initCardRect", "cardRect", "", "initData", "isConstellationVisible", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "(Ljava/lang/Integer;Ljava/lang/Integer;Landroid/content/Intent;)V", "onBackPressed", "onProfileVisibleLoaded", "okClicked", "Lkotlin/Function0;", "onCanceled", "setViewDrawable", "url", "view", "show", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aytj
  extends ayti
  implements ayou
{
  public static final aytm a;
  private int jdField_a_of_type_Int;
  @NotNull
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final aymu jdField_a_of_type_Aymu;
  @NotNull
  private ayos jdField_a_of_type_Ayos;
  private aysj jdField_a_of_type_Aysj;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private final View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  
  static
  {
    jdField_a_of_type_Aytm = new aytm(null);
  }
  
  public aytj(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, @NotNull ayos paramayos, @NotNull aymu paramaymu)
  {
    super((Context)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ayos = paramayos;
    this.jdField_a_of_type_Aymu = paramaymu;
    this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplication.context;
    paramQQAppInterface = a();
    paramQQAppInterface.findViewById(2131376798).setOnClickListener((View.OnClickListener)new aytk(this));
    this.jdField_b_of_type_AndroidViewView = paramQQAppInterface.findViewById(2131365016);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)aytl.a);
    this.jdField_d_of_type_AndroidViewView = paramQQAppInterface;
    b();
    a();
    setContentView(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView;
    paramQQAppInterface = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appContext");
    this.jdField_c_of_type_Int = afur.a(296.0F, paramQQAppInterface.getResources());
    paramQQAppInterface = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appContext");
    int i = afur.a(211.0F, paramQQAppInterface.getResources());
    float f1 = 12;
    float f2 = bgln.a();
    paramQQAppInterface = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "appContext");
    paramQQAppInterface = bggl.a(paramQQAppInterface.getResources(), 2130841445, this.jdField_c_of_type_Int, i);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = bgmo.d(paramQQAppInterface, f1 * f2, this.jdField_c_of_type_Int, i);
      paramActivity = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
      Intrinsics.checkExpressionValueIsNotNull(paramActivity, "appContext");
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(paramActivity.getResources(), paramQQAppInterface);
    }
    aybz.a((Function0)new ConstellationView.3(this));
  }
  
  private final void a(Activity paramActivity, Function0<Unit> paramFunction01, Function0<Unit> paramFunction02)
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("ConstellationView", 2, new Object[] { "onProfileVisibleLoaded: called. ", "constellationVisible: " + bool });
    }
    if (!bool)
    {
      avxq.a(paramActivity, bglp.a((Context)paramActivity, 230, paramActivity.getResources().getString(2131697618), paramActivity.getResources().getString(2131697615), 2131697616, 2131697617, (DialogInterface.OnClickListener)new aytq(paramFunction01), (DialogInterface.OnClickListener)new aytr(paramFunction02)));
      return;
    }
    paramFunction01.invoke();
  }
  
  private final boolean a()
  {
    azsn localazsn = azsm.a;
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localCard == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    return localazsn.a(41609, localCard, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 2;
  }
  
  private final boolean a(String paramString, ImageView paramImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    if (paramImageView != null)
    {
      localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    }
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "drawable");
      paramString.setTag(bgey.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, (int)(12 * bgln.a())));
      paramString.setDecodeHandler(bgey.g);
      if (paramImageView != null) {
        paramImageView.setImageDrawable((Drawable)paramString);
      }
      if (paramString.getStatus() != 2)
      {
        return true;
        i = 0;
      }
      else
      {
        return false;
      }
    }
    if (paramImageView != null) {
      paramImageView.setImageDrawable((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    }
    return false;
  }
  
  private final void b()
  {
    Card localCard = bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intrinsics.checkExpressionValueIsNotNull(localCard, "ProfileCardUtil.initCard…p, app.currentAccountUin)");
    this.jdField_a_of_type_ComTencentMobileqqDataCard = localCard;
    localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localCard == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    this.jdField_b_of_type_Int = ((int)localCard.lBirthday);
    localCard = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localCard == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
    }
    this.jdField_a_of_type_Int = localCard.constellation;
    this.jdField_a_of_type_JavaLangString = bght.c(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Aysj = ((aysj)new aytp(this));
  }
  
  private final void c()
  {
    ayot localayot = new ayot();
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
    }
    localayot.a = ((BaseActivity)localActivity);
    this.jdField_a_of_type_Ayos.a(localayot, (ayou)this);
  }
  
  private final void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext");
    localObject1 = ((BaseApplication)localObject1).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appContext.resources");
    int i;
    Object localObject2;
    if (this.jdField_a_of_type_Int != 0)
    {
      i = 1;
      if (i == 0) {
        break label160;
      }
      localObject2 = ((Resources)localObject1).getString(2131697622);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "res.getString(R.string.q…nstellation_select_part1)");
      localObject1 = ((Resources)localObject1).getString(2131697623);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.getString(R.string.q…nstellation_select_part2)");
      label66:
      TextView localTextView = this.e;
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject2);
      }
      localObject2 = this.f;
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setClickable(true);
        ((TextView)localObject2).setOnClickListener((View.OnClickListener)new aytn(this, (String)localObject1));
        ((TextView)localObject2).setOnTouchListener((View.OnTouchListener)new muf());
        if (!bkpg.a()) {
          break label193;
        }
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837509, 0);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label160:
      localObject2 = ((Resources)localObject1).getString(2131697620);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "res.getString(R.string.q…select_no_birthday_part1)");
      localObject1 = ((Resources)localObject1).getString(2131697621);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.getString(R.string.q…select_no_birthday_part2)");
      break label66;
      label193:
      ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837508, 0);
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
    View localView = View.inflate((Context)BaseApplication.context, 2131561553, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364932));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364933));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377148));
    this.e = ((TextView)localView.findViewById(2131377130));
    this.f = ((TextView)localView.findViewById(2131377125));
    this.g = ((TextView)localView.findViewById(2131364929));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364930));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370464));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131371730);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370480));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378008));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  @NotNull
  public final aymu a()
  {
    return this.jdField_a_of_type_Aymu;
  }
  
  @NotNull
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public final void a()
  {
    a(aysh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), this.jdField_a_of_type_AndroidWidgetImageView);
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_Int != 0)
    {
      bool1 = true;
      if (!bool1) {
        break label413;
      }
      bool2 = a(aysh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), this.jdField_b_of_type_AndroidWidgetImageView);
      label45:
      if (QLog.isColorLevel()) {
        QLog.d("ConstellationView", 2, new Object[] { "bindView: called. ", "bgSuccessLoad: " + bool2 + "  hasBirthdaySet: " + bool1 });
      }
      if (!bool2) {
        break label418;
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = new Ref.IntRef();
      try
      {
        localObject2 = aysh.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("ConstellationView", 2, new Object[] { "bindView: called. ", "constellationStr: " + this.jdField_a_of_type_JavaLangString + ",  textColorFromSp: " + (String)localObject2 });
        }
        ((Ref.IntRef)localObject1).element = Color.parseColor((String)localObject2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          ((Ref.IntRef)localObject1).element = -16777216;
          continue;
          ((Button)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131694344));
          ((Button)localObject1).setEnabled(true);
          continue;
          ((Button)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131694344));
          ((Button)localObject1).setEnabled(false);
        }
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)this.jdField_a_of_type_JavaLangString);
        ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
      }
      localObject2 = this.g;
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)aysh.a());
        ((TextView)localObject2).setTextColor(((Ref.IntRef)localObject1).element);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
      if (localObject1 != null)
      {
        ((Button)localObject1).setOnClickListener((View.OnClickListener)new ayto(this, bool1));
        if (!bool1) {
          break label534;
        }
        if (!aysh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label509;
        }
        ((Button)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getText(2131692850));
        ((Button)localObject1).setEnabled(false);
      }
      f();
      return;
      bool1 = false;
      break;
      label413:
      bool2 = false;
      break label45;
      label418:
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(4);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageDrawable((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      }
    }
  }
  
  public void a(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Intent paramIntent)
  {
    int i = aysf.jdField_a_of_type_Int;
    if (paramInteger1 == null) {}
    while ((paramInteger1.intValue() != i) || (paramIntent == null)) {
      return;
    }
    paramInteger1 = ayts.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_b_of_type_Int != ((Number)paramInteger1.getFirst()).intValue()) {
      QQToast.a((Context)BaseApplication.context, 0, 2131690931, 0).a();
    }
    this.jdField_b_of_type_Int = ((Number)paramInteger1.getFirst()).intValue();
    this.jdField_a_of_type_JavaLangString = ((String)paramInteger1.getSecond());
    a();
  }
  
  public void a(boolean paramBoolean, @Nullable Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)new BitmapDrawable(paramBitmap));
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
      paramArrayOfInt[0] = this.jdField_c_of_type_Int;
      localView = this.jdField_b_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "cardView");
      paramArrayOfInt[1] = afur.a(430.0F, localView.getResources());
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver((BusinessObserver)this.jdField_a_of_type_Aysj);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.jdField_a_of_type_Aymu.a(1040);
  }
  
  public void show()
  {
    View localView;
    if (ThemeUtil.isNowThemeIsNight(null, false, ""))
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setBackgroundResource(2130846139);
      }
      a(false, null, Color.parseColor("#FF010101"));
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver((BusinessObserver)this.jdField_a_of_type_Aysj);
      ayph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      try
      {
        a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        super.show();
        b(true);
        return;
        localView = this.jdField_b_of_type_AndroidViewView;
        if (localView != null) {
          localView.setBackgroundResource(2130846138);
        }
        c();
        localView = this.jdField_c_of_type_AndroidViewView;
        if (localView == null) {
          continue;
        }
        localView.setVisibility(8);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ConstellationView", 2, new Object[] { "show: called. ", "", localException });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytj
 * JD-Core Version:    0.7.0.1
 */