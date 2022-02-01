import com.tencent.TMG.utils.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/reward/VasRewardAdService$realShowAd$profitableCallback$1", "Lcooperation/vip/reward/VasProfitableCallback;", "onResult", "", "profitable", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmop
  implements bmoi
{
  bmop(bmkg parambmkg) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bmkg.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("VasRewardAdService", 0, "showRewardAdv onResult profitable: " + paramBoolean);
    }
    if (paramBoolean == true) {
      bmom.a(this.jdField_a_of_type_Bmom);
    }
    while (paramBoolean) {
      return;
    }
    bmom.a(this.jdField_a_of_type_Bmom, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmop
 * JD-Core Version:    0.7.0.1
 */