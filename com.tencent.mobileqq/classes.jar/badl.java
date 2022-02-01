import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.view.ShakeImageView;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileWzBackgroundComponent.onVasDataUpdate.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileWzBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profile/ProfileCardInfo;)V", "mCardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "mDefaultBackgroundView", "Landroid/widget/ImageView;", "mWzBg", "Landroid/graphics/Bitmap;", "mWzBgView", "Lcom/tencent/mobileqq/profile/view/ShakeImageView;", "mWzCharacter", "mWzCharacterView", "initWzryDynamicBgAndHero", "", "data", "onCreate", "", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onVasDataUpdate", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "updateImage", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class badl
  extends bade
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bacy jdField_a_of_type_Bacy;
  private ShakeImageView jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private ShakeImageView jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView;
  
  public badl(@Nullable azxt paramazxt, @Nullable azrb paramazrb)
  {
    super("VasProfileWzryBackgroundComponent", paramazxt, paramazrb);
  }
  
  private final void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView;
      if (localObject != null) {
        ((ShakeImageView)localObject).setImage(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(a().getWidth() * 1.1D), (int)(a().getHeight() * 1.1D), 1.0F);
      }
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView;
      if (localObject != null) {
        ((ShakeImageView)localObject).setImage(this.jdField_b_of_type_AndroidGraphicsBitmap, (int)(a().getWidth() * 1.1D), (int)(a().getHeight() * 1.1D), -1.0F);
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) && (this.jdField_b_of_type_AndroidGraphicsBitmap == null))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setBackgroundResource(b());
      }
      a(false);
      return;
    }
    a("card-wzry");
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(null);
    }
    a(true);
  }
  
  private final boolean a(bacy parambacy)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = b();
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = new Object[3];
      localObject2[0] = Long.valueOf(parambacy.b());
      localObject2[1] = parambacy.a();
      localObject2[2] = parambacy.c();
      localObject2 = String.format("initWzryDynamicBgAndHero bgId=%s bgUrl=%s heroUrl=%s", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
      QLog.d((String)localObject1, 2, (String)localObject2);
    }
    if ((!TextUtils.isEmpty((CharSequence)parambacy.a())) || (!TextUtils.isEmpty((CharSequence)parambacy.c()))) {
      try
      {
        parambacy = azrc.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambacy.b());
        String str = parambacy + "wzBgImage.png";
        localObject2 = parambacy + "wzMainImage.png";
        localObject1 = BaseApplicationImpl.sImageCache.get(str);
        parambacy = (bacy)localObject1;
        if (!(localObject1 instanceof Bitmap)) {
          parambacy = null;
        }
        localObject1 = (Bitmap)parambacy;
        if (localObject1 != null)
        {
          parambacy = (bacy)localObject1;
          if (!((Bitmap)localObject1).isRecycled()) {}
        }
        else
        {
          parambacy = bgyo.a(str);
        }
        if ((parambacy != null) && ((Intrinsics.areEqual(this.jdField_a_of_type_AndroidGraphicsBitmap, parambacy) ^ true)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = parambacy;
          BaseApplicationImpl.sImageCache.put(str, parambacy);
        }
        localObject1 = BaseApplicationImpl.sImageCache.get(localObject2);
        parambacy = (bacy)localObject1;
        if (!(localObject1 instanceof Bitmap)) {
          parambacy = null;
        }
        localObject1 = (Bitmap)parambacy;
        if (localObject1 != null)
        {
          parambacy = (bacy)localObject1;
          if (!((Bitmap)localObject1).isRecycled()) {}
        }
        else
        {
          parambacy = bgyo.a((String)localObject2);
        }
        if ((parambacy != null) && ((Intrinsics.areEqual(this.jdField_b_of_type_AndroidGraphicsBitmap, parambacy) ^ true)))
        {
          this.jdField_b_of_type_AndroidGraphicsBitmap = parambacy;
          BaseApplicationImpl.sImageCache.put(localObject2, parambacy);
        }
        return true;
      }
      catch (Throwable parambacy)
      {
        QLog.e(b(), 1, "initWzryDynamicBgAndHero fail.", parambacy);
      }
    }
    return false;
  }
  
  public void a(@NotNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    super.a(paramBaseActivity, paramBundle);
    paramBundle = new ImageView((Context)paramBaseActivity);
    paramBundle.setContentDescription((CharSequence)"qqvip_bg");
    a().addView((View)paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = paramBundle;
    paramBundle = new ShakeImageView((Context)paramBaseActivity);
    paramBundle.setContentDescription((CharSequence)"qqvip_wzry_bg");
    a().addView((View)paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView = paramBundle;
    paramBaseActivity = new ShakeImageView((Context)paramBaseActivity);
    paramBaseActivity.setContentDescription((CharSequence)"qqvip_wzry_character");
    a().addView((View)paramBaseActivity);
    this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView = paramBaseActivity;
  }
  
  public boolean a(@NotNull badb parambadb)
  {
    Intrinsics.checkParameterIsNotNull(parambadb, "data");
    if (parambadb.a() == null)
    {
      parambadb = this.jdField_a_of_type_AndroidWidgetImageView;
      if (parambadb != null) {
        parambadb.setBackgroundResource(b());
      }
    }
    while ((parambadb.a().equals(this.jdField_a_of_type_Bacy)) && (b())) {
      return true;
    }
    this.jdField_a_of_type_Bacy = parambadb.a();
    a(parambadb.a());
    a().post((Runnable)new VasProfileWzBackgroundComponent.onVasDataUpdate.1(this));
    return true;
  }
  
  public void f()
  {
    super.f();
    a().removeView((View)this.jdField_a_of_type_AndroidWidgetImageView);
    a().removeView((View)this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView);
    a().removeView((View)this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)null);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView = ((ShakeImageView)null);
    this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView = ((ShakeImageView)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badl
 * JD-Core Version:    0.7.0.1
 */