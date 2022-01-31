import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class azpz
  implements axcd
{
  azpz(azpw paramazpw) {}
  
  public void a(axci paramaxci)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      ajnb.a("cartoon", "clk_inter", azpw.a(this.a).frienduin, azkd.b(azpw.a(this.a)) + "", "", "");
      paramaxci = azpw.a(this.a);
      if ((paramaxci != null) && (badq.a(paramaxci) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        paramaxci = paramaxci.getString(2131632133);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramaxci, azpw.a(this.a).n, azvv.a(azpw.a(this.a), 16.0F));
      }
    }
    else
    {
      if (azpw.a(this.a) != null) {}
      for (paramaxci = "0";; paramaxci = "1")
      {
        awqx.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + azpw.a(this.a).frienduin, "" + azkd.b(azpw.a(this.a)), paramaxci, "" + mje.a(localAppInterface, localAppInterface.getCurrentAccountUin(), azpw.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    paramaxci = (azjq)localAppInterface.getManager(113);
    azpw.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      paramaxci.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, azpw.a(this.a).frienduin, azpw.a(this.a).bagId, 3000L, azpw.a(this.a));
      return;
    }
    paramaxci.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, azpw.a(this.a).frienduin, azpw.a(this.a).bagId, 3000L, azpw.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azpz
 * JD-Core Version:    0.7.0.1
 */