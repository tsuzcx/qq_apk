import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class bcuu
  implements baen
{
  bcuu(bcur parambcur) {}
  
  public void a(baes parambaes)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      alxn.a("cartoon", "clk_inter", bcur.a(this.a).frienduin, bcoq.b(bcur.a(this.a)) + "", "", "");
      parambaes = bcur.a(this.a);
      if ((parambaes != null) && (bdin.a(parambaes) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        parambaes = parambaes.getString(2131698042);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(parambaes, bcur.a(this.a).n, bdaq.a(bcur.a(this.a), 16.0F));
      }
    }
    else
    {
      if (bcur.a(this.a) != null) {}
      for (parambaes = "0";; parambaes = "1")
      {
        azqs.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + bcur.a(this.a).frienduin, "" + bcoq.b(bcur.a(this.a)), parambaes, "" + mwu.a(localAppInterface, localAppInterface.getCurrentAccountUin(), bcur.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    parambaes = (bcod)localAppInterface.getManager(113);
    bcur.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      parambaes.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bcur.a(this.a).frienduin, bcur.a(this.a).bagId, 3000L, bcur.a(this.a));
      return;
    }
    parambaes.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bcur.a(this.a).frienduin, bcur.a(this.a).bagId, 3000L, bcur.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcuu
 * JD-Core Version:    0.7.0.1
 */