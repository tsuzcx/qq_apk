import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

class bfis
  implements bcsd
{
  bfis(bfip parambfip) {}
  
  public void a(bcsi parambcsi)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      amxb.a("cartoon", "clk_inter", bfip.a(this.a).frienduin, bfcv.b(bfip.a(this.a)) + "", "", "");
      parambcsi = bfip.a(this.a);
      if ((parambcsi != null) && (NetworkUtil.getSystemNetwork(parambcsi) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        parambcsi = parambcsi.getString(2131697079);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(parambcsi, bfip.a(this.a).n, DisplayUtil.dip2px(bfip.a(this.a), 16.0F));
      }
    }
    else
    {
      if (bfip.a(this.a) != null) {}
      for (parambcsi = "0";; parambcsi = "1")
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + bfip.a(this.a).frienduin, "" + bfcv.b(bfip.a(this.a)), parambcsi, "" + muk.a(localAppInterface, localAppInterface.getCurrentAccountUin(), bfip.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    parambcsi = (bfci)localAppInterface.getManager(113);
    bfip.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      parambcsi.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bfip.a(this.a).frienduin, bfip.a(this.a).bagId, 3000L, bfip.a(this.a));
      return;
    }
    parambcsi.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bfip.a(this.a).frienduin, bfip.a(this.a).bagId, 3000L, bfip.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfis
 * JD-Core Version:    0.7.0.1
 */