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
public final class badi
  extends bade
{
  private bhzp a;
  
  public badi(@Nullable azxt paramazxt, @Nullable azrb paramazrb)
  {
    super("VasProfileDiyBackgroundComponent", paramazxt, paramazrb);
  }
  
  public boolean a(@NotNull badb parambadb)
  {
    Intrinsics.checkParameterIsNotNull(parambadb, "data");
    if (this.jdField_a_of_type_Bhzp != null) {
      return true;
    }
    label149:
    for (;;)
    {
      try
      {
        parambadb = parambadb.a();
        if (parambadb != null)
        {
          if ((parambadb.b() instanceof JSONObject))
          {
            this.jdField_a_of_type_Bhzp = bhzp.a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((ViewGroup)a()).a((JSONObject)parambadb.b());
            break label149;
          }
        }
        else
        {
          a("card-diy");
          return true;
        }
      }
      catch (Exception parambadb)
      {
        QLog.e(b(), 1, (Throwable)parambadb, new Object[0]);
        a().removeAllViews();
        return true;
      }
      if ((parambadb.b() instanceof JSONArray)) {
        this.jdField_a_of_type_Bhzp = bhzp.a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((ViewGroup)a()).a((JSONArray)parambadb.b());
      }
    }
  }
  
  public void f()
  {
    super.f();
    bhzp localbhzp = this.jdField_a_of_type_Bhzp;
    if (localbhzp != null) {
      localbhzp.a();
    }
    this.jdField_a_of_type_Bhzp = ((bhzp)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badi
 * JD-Core Version:    0.7.0.1
 */