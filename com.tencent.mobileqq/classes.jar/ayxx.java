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
public final class ayxx
  extends ayxt
{
  private bgpf a;
  
  public ayxx(@Nullable aysx paramaysx, @Nullable aymg paramaymg)
  {
    super("VasProfileDiyBackgroundComponent", paramaysx, paramaymg);
  }
  
  public boolean a(@NotNull ayxq paramayxq)
  {
    Intrinsics.checkParameterIsNotNull(paramayxq, "data");
    if (this.jdField_a_of_type_Bgpf != null) {
      return true;
    }
    label149:
    for (;;)
    {
      try
      {
        paramayxq = paramayxq.a();
        if (paramayxq != null)
        {
          if ((paramayxq.b() instanceof JSONObject))
          {
            this.jdField_a_of_type_Bgpf = bgpf.a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((ViewGroup)a()).a((JSONObject)paramayxq.b());
            break label149;
          }
        }
        else
        {
          a("card-diy");
          return true;
        }
      }
      catch (Exception paramayxq)
      {
        QLog.e(b(), 1, (Throwable)paramayxq, new Object[0]);
        a().removeAllViews();
        return true;
      }
      if ((paramayxq.b() instanceof JSONArray)) {
        this.jdField_a_of_type_Bgpf = bgpf.a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a((ViewGroup)a()).a((JSONArray)paramayxq.b());
      }
    }
  }
  
  public void f()
  {
    super.f();
    bgpf localbgpf = this.jdField_a_of_type_Bgpf;
    if (localbgpf != null) {
      localbgpf.a();
    }
    this.jdField_a_of_type_Bgpf = ((bgpf)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxx
 * JD-Core Version:    0.7.0.1
 */