import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileDiyBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profile/ProfileCardInfo;)V", "mQVipBackgroundCreator", "Lcom/tencent/mobileqq/vip/diy/QVipBackgroundCreator;", "onDestroy", "", "onVasDataUpdate", "", "data", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class baig
  extends baic
{
  private biiu a;
  
  public baig(@Nullable baei parambaei, @Nullable azxr paramazxr)
  {
    super("VasProfileDiyBackgroundComponent", parambaei, paramazxr);
  }
  
  public boolean a(@NotNull bahz parambahz)
  {
    Intrinsics.checkParameterIsNotNull(parambahz, "data");
    if (this.jdField_a_of_type_Biiu != null) {
      return true;
    }
    label149:
    for (;;)
    {
      try
      {
        parambahz = parambahz.a();
        if (parambahz != null)
        {
          if ((parambahz.b() instanceof JSONObject))
          {
            this.jdField_a_of_type_Biiu = biiu.a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((ViewGroup)a()).a((JSONObject)parambahz.b());
            break label149;
          }
        }
        else
        {
          a("card-diy");
          return true;
        }
      }
      catch (Exception parambahz)
      {
        QLog.e(b(), 1, (Throwable)parambahz, new Object[0]);
        a().removeAllViews();
        return true;
      }
      if ((parambahz.b() instanceof JSONArray)) {
        this.jdField_a_of_type_Biiu = biiu.a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((ViewGroup)a()).a((JSONArray)parambahz.b());
      }
    }
  }
  
  public void f()
  {
    super.f();
    biiu localbiiu = this.jdField_a_of_type_Biiu;
    if (localbiiu != null) {
      localbiiu.a();
    }
    this.jdField_a_of_type_Biiu = ((biiu)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baig
 * JD-Core Version:    0.7.0.1
 */