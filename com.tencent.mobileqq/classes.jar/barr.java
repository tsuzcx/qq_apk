import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class barr
  implements aych
{
  barr(baro parambaro) {}
  
  public void a(aycm paramaycm)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      akbj.a("cartoon", "clk_inter", baro.a(this.a).frienduin, balu.b(baro.a(this.a)) + "", "", "");
      paramaycm = baro.a(this.a);
      if ((paramaycm != null) && (bbfj.a(paramaycm) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        paramaycm = paramaycm.getString(2131697863);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramaycm, baro.a(this.a).n, baxn.a(baro.a(this.a), 16.0F));
      }
    }
    else
    {
      if (baro.a(this.a) != null) {}
      for (paramaycm = "0";; paramaycm = "1")
      {
        axqy.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + baro.a(this.a).frienduin, "" + balu.b(baro.a(this.a)), paramaycm, "" + mua.a(localAppInterface, localAppInterface.getCurrentAccountUin(), baro.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    paramaycm = (balh)localAppInterface.getManager(113);
    baro.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      paramaycm.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, baro.a(this.a).frienduin, baro.a(this.a).bagId, 3000L, baro.a(this.a));
      return;
    }
    paramaycm.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, baro.a(this.a).frienduin, baro.a(this.a).bagId, 3000L, baro.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     barr
 * JD-Core Version:    0.7.0.1
 */