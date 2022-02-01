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
public final class baij
  extends baic
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bahw jdField_a_of_type_Bahw;
  private ShakeImageView jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private ShakeImageView jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView;
  
  public baij(@Nullable baei parambaei, @Nullable azxr paramazxr)
  {
    super("VasProfileWzryBackgroundComponent", parambaei, paramazxr);
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
  
  private final boolean a(bahw parambahw)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = b();
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = new Object[3];
      localObject2[0] = Long.valueOf(parambahw.b());
      localObject2[1] = parambahw.a();
      localObject2[2] = parambahw.c();
      localObject2 = String.format("initWzryDynamicBgAndHero bgId=%s bgUrl=%s heroUrl=%s", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
      QLog.d((String)localObject1, 2, (String)localObject2);
    }
    if ((!TextUtils.isEmpty((CharSequence)parambahw.a())) || (!TextUtils.isEmpty((CharSequence)parambahw.c()))) {
      try
      {
        parambahw = azxs.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, parambahw.b());
        String str = parambahw + "wzBgImage.png";
        localObject2 = parambahw + "wzMainImage.png";
        localObject1 = BaseApplicationImpl.sImageCache.get(str);
        parambahw = (bahw)localObject1;
        if (!(localObject1 instanceof Bitmap)) {
          parambahw = null;
        }
        localObject1 = (Bitmap)parambahw;
        if (localObject1 != null)
        {
          parambahw = (bahw)localObject1;
          if (!((Bitmap)localObject1).isRecycled()) {}
        }
        else
        {
          parambahw = bhgm.a(str);
        }
        if ((parambahw != null) && ((Intrinsics.areEqual(this.jdField_a_of_type_AndroidGraphicsBitmap, parambahw) ^ true)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = parambahw;
          BaseApplicationImpl.sImageCache.put(str, parambahw);
        }
        localObject1 = BaseApplicationImpl.sImageCache.get(localObject2);
        parambahw = (bahw)localObject1;
        if (!(localObject1 instanceof Bitmap)) {
          parambahw = null;
        }
        localObject1 = (Bitmap)parambahw;
        if (localObject1 != null)
        {
          parambahw = (bahw)localObject1;
          if (!((Bitmap)localObject1).isRecycled()) {}
        }
        else
        {
          parambahw = bhgm.a((String)localObject2);
        }
        if ((parambahw != null) && ((Intrinsics.areEqual(this.jdField_b_of_type_AndroidGraphicsBitmap, parambahw) ^ true)))
        {
          this.jdField_b_of_type_AndroidGraphicsBitmap = parambahw;
          BaseApplicationImpl.sImageCache.put(localObject2, parambahw);
        }
        return true;
      }
      catch (Throwable parambahw)
      {
        QLog.e(b(), 1, "initWzryDynamicBgAndHero fail.", parambahw);
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
  
  public boolean a(@NotNull bahz parambahz)
  {
    Intrinsics.checkParameterIsNotNull(parambahz, "data");
    if (parambahz.a() == null)
    {
      parambahz = this.jdField_a_of_type_AndroidWidgetImageView;
      if (parambahz != null) {
        parambahz.setBackgroundResource(b());
      }
    }
    while ((parambahz.a().equals(this.jdField_a_of_type_Bahw)) && (b())) {
      return true;
    }
    this.jdField_a_of_type_Bahw = parambahz.a();
    a(parambahz.a());
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
 * Qualified Name:     baij
 * JD-Core Version:    0.7.0.1
 */