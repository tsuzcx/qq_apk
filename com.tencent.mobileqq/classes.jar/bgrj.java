import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

class bgrj
  implements bdzc
{
  bgrj(bgrg parambgrg) {}
  
  public void a(bdzh parambdzh)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      anzp.a("cartoon", "clk_inter", bgrg.a(this.a).frienduin, bglb.b(bgrg.a(this.a)) + "", "", "");
      parambdzh = bgrg.a(this.a);
      if ((parambdzh != null) && (NetworkUtil.getSystemNetwork(parambdzh) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        parambdzh = parambdzh.getString(2131697356);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(parambdzh, bgrg.a(this.a).n, DisplayUtil.dip2px(bgrg.a(this.a), 16.0F));
      }
    }
    else
    {
      if (bgrg.a(this.a) != null) {}
      for (parambdzh = "0";; parambdzh = "1")
      {
        bdla.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + bgrg.a(this.a).frienduin, "" + bglb.b(bgrg.a(this.a)), parambdzh, "" + mvi.a(localAppInterface, localAppInterface.getCurrentAccountUin(), bgrg.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    parambdzh = (bgko)localAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    bgrg.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      parambdzh.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bgrg.a(this.a).frienduin, bgrg.a(this.a).bagId, 3000L, bgrg.a(this.a));
      return;
    }
    parambdzh.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bgrg.a(this.a).frienduin, bgrg.a(this.a).bagId, 3000L, bgrg.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrj
 * JD-Core Version:    0.7.0.1
 */