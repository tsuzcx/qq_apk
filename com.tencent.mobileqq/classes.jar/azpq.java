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
public final class azpq
  extends azpm
{
  private bhif a;
  
  public azpq(@Nullable azlw paramazlw, @Nullable azfe paramazfe)
  {
    super("VasProfileDiyBackgroundComponent", paramazlw, paramazfe);
  }
  
  public boolean a(@NotNull azpj paramazpj)
  {
    Intrinsics.checkParameterIsNotNull(paramazpj, "data");
    if (this.jdField_a_of_type_Bhif != null) {
      return true;
    }
    label149:
    for (;;)
    {
      try
      {
        paramazpj = paramazpj.a();
        if (paramazpj != null)
        {
          if ((paramazpj.b() instanceof JSONObject))
          {
            this.jdField_a_of_type_Bhif = bhif.a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((ViewGroup)a()).a((JSONObject)paramazpj.b());
            break label149;
          }
        }
        else
        {
          a("card-diy");
          return true;
        }
      }
      catch (Exception paramazpj)
      {
        QLog.e(b(), 1, (Throwable)paramazpj, new Object[0]);
        a().removeAllViews();
        return true;
      }
      if ((paramazpj.b() instanceof JSONArray)) {
        this.jdField_a_of_type_Bhif = bhif.a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((ViewGroup)a()).a((JSONArray)paramazpj.b());
      }
    }
  }
  
  public void f()
  {
    super.f();
    bhif localbhif = this.jdField_a_of_type_Bhif;
    if (localbhif != null) {
      localbhif.a();
    }
    this.jdField_a_of_type_Bhif = ((bhif)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpq
 * JD-Core Version:    0.7.0.1
 */