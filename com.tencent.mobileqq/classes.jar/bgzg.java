import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class bgzg
  implements bdym
{
  bgzg(bgzd parambgzd) {}
  
  public void a(bdyr parambdyr)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      aocz.a("cartoon", "clk_inter", bgzd.a(this.a).frienduin, bgth.b(bgzd.a(this.a)) + "", "", "");
      parambdyr = bgzd.a(this.a);
      if ((parambdyr != null) && (bhnv.a(parambdyr) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        parambdyr = parambdyr.getString(2131696937);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(parambdyr, bgzd.a(this.a).n, bhgr.a(bgzd.a(this.a), 16.0F));
      }
    }
    else
    {
      if (bgzd.a(this.a) != null) {}
      for (parambdyr = "0";; parambdyr = "1")
      {
        bdll.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + bgzd.a(this.a).frienduin, "" + bgth.b(bgzd.a(this.a)), parambdyr, "" + mvb.a(localAppInterface, localAppInterface.getCurrentAccountUin(), bgzd.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    parambdyr = (bgsu)localAppInterface.getManager(113);
    bgzd.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      parambdyr.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bgzd.a(this.a).frienduin, bgzd.a(this.a).bagId, 3000L, bgzd.a(this.a));
      return;
    }
    parambdyr.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bgzd.a(this.a).frienduin, bgzd.a(this.a).bagId, 3000L, bgzd.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzg
 * JD-Core Version:    0.7.0.1
 */