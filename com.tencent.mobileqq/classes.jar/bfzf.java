import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class bfzf
  implements bdfr
{
  bfzf(bfzc parambfzc) {}
  
  public void a(bdfw parambdfw)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      anqt.a("cartoon", "clk_inter", bfzc.a(this.a).frienduin, bftg.b(bfzc.a(this.a)) + "", "", "");
      parambdfw = bfzc.a(this.a);
      if ((parambdfw != null) && (bgnt.a(parambdfw) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        parambdfw = parambdfw.getString(2131696888);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(parambdfw, bfzc.a(this.a).n, bggq.a(bfzc.a(this.a), 16.0F));
      }
    }
    else
    {
      if (bfzc.a(this.a) != null) {}
      for (parambdfw = "0";; parambdfw = "1")
      {
        bcst.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + bfzc.a(this.a).frienduin, "" + bftg.b(bfzc.a(this.a)), parambdfw, "" + muc.a(localAppInterface, localAppInterface.getCurrentAccountUin(), bfzc.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    parambdfw = (bfst)localAppInterface.getManager(113);
    bfzc.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      parambdfw.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bfzc.a(this.a).frienduin, bfzc.a(this.a).bagId, 3000L, bfzc.a(this.a));
      return;
    }
    parambdfw.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bfzc.a(this.a).frienduin, bfzc.a(this.a).bagId, 3000L, bfzc.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzf
 * JD-Core Version:    0.7.0.1
 */