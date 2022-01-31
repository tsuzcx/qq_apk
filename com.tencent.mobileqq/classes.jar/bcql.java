import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class bcql
  implements baae
{
  bcql(bcqi parambcqi) {}
  
  public void a(baaj parambaaj)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      alsy.a("cartoon", "clk_inter", bcqi.a(this.a).frienduin, bckh.b(bcqi.a(this.a)) + "", "", "");
      parambaaj = bcqi.a(this.a);
      if ((parambaaj != null) && (bdee.a(parambaaj) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        parambaaj = parambaaj.getString(2131698040);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(parambaaj, bcqi.a(this.a).n, bcwh.a(bcqi.a(this.a), 16.0F));
      }
    }
    else
    {
      if (bcqi.a(this.a) != null) {}
      for (parambaaj = "0";; parambaaj = "1")
      {
        azmj.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + bcqi.a(this.a).frienduin, "" + bckh.b(bcqi.a(this.a)), parambaaj, "" + mwu.a(localAppInterface, localAppInterface.getCurrentAccountUin(), bcqi.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    parambaaj = (bcju)localAppInterface.getManager(113);
    bcqi.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      parambaaj.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bcqi.a(this.a).frienduin, bcqi.a(this.a).bagId, 3000L, bcqi.a(this.a));
      return;
    }
    parambaaj.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bcqi.a(this.a).frienduin, bcqi.a(this.a).bagId, 3000L, bcqi.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcql
 * JD-Core Version:    0.7.0.1
 */