import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class bard
  implements aycf
{
  bard(bara parambara) {}
  
  public void a(ayck paramayck)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.a.jdField_a_of_type_Int >= 4)
    {
      akbk.a("cartoon", "clk_inter", bara.a(this.a).frienduin, balg.b(bara.a(this.a)) + "", "", "");
      paramayck = bara.a(this.a);
      if ((paramayck != null) && (bbev.a(paramayck) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
        paramayck = paramayck.getString(2131697853);
        ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramayck, bara.a(this.a).n, bawz.a(bara.a(this.a), 16.0F));
      }
    }
    else
    {
      if (bara.a(this.a) != null) {}
      for (paramayck = "0";; paramayck = "1")
      {
        axqw.b(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + bara.a(this.a).frienduin, "" + balg.b(bara.a(this.a)), paramayck, "" + mud.a(localAppInterface, localAppInterface.getCurrentAccountUin(), bara.a(this.a).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
    paramayck = (bakt)localAppInterface.getManager(113);
    bara.a(this.a).a = NetConnInfoCenter.getServerTimeMillis();
    if (this.a.jdField_a_of_type_Int > 3)
    {
      paramayck.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bara.a(this.a).frienduin, bara.a(this.a).bagId, 3000L, bara.a(this.a));
      return;
    }
    paramayck.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bara.a(this.a).frienduin, bara.a(this.a).bagId, 3000L, bara.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bard
 * JD-Core Version:    0.7.0.1
 */