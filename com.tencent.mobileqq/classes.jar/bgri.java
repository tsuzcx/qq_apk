import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;

class bgri
  extends bgkn
{
  bgri(bgrg parambgrg) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView)
    {
      if ((bgrg.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    if (paramInt == 20005)
    {
      bgrg.a(this.a).jdField_a_of_type_Int = 3;
      paramString = (bgko)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
      if (this.a.jdField_a_of_type_Int > 3) {
        paramString.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bgrg.a(this.a).frienduin, bgrg.a(this.a).bagId, 3000L, bgrg.a(this.a));
      }
    }
    String str1;
    String str2;
    label300:
    do
    {
      for (;;)
      {
        return;
        paramString.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bgrg.a(this.a).frienduin, bgrg.a(this.a).bagId, 3000L, bgrg.a(this.a));
      }
      if (paramInt != -1) {
        break label498;
      }
      str1 = bgrg.a(this.a).getResources().getString(2131697500);
      str2 = com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[com.tencent.mobileqq.utils.NetworkUtil.getSystemNetwork(bgrg.a(this.a))];
      if (this.a.jdField_a_of_type_Int < 4) {
        break;
      }
      anzp.a("cartoon", "timeout", bgrg.a(this.a).frienduin, bglb.b(bgrg.a(this.a)) + str2, "", "");
      break label547;
      if (!(this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToAllSurfaceView)) {
        break label550;
      }
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, bgrg.a(this.a).n, DisplayUtil.dip2px(bgrg.a(this.a), 16.0F));
      bgrg.a(this.a).jdField_a_of_type_Int = 2;
    } while (bgrg.a(this.a).c <= 0L);
    if (bgrg.a(this.a).b > bgrg.a(this.a).c + 3000L)
    {
      return;
      if (bgrg.a(this.a) == null) {
        break label552;
      }
    }
    label547:
    label550:
    label552:
    for (paramString = "0";; paramString = "1")
    {
      bdla.b(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, "" + bgrg.a(this.a).frienduin, "" + bglb.b(bgrg.a(this.a)), paramString, str2);
      break label547;
      label498:
      paramString = bgrg.a(this.a).getResources().getString(2131697499);
      break label300;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(bgrg.a(this.a));
      this.a.a(2000L);
      break;
      paramString = str1;
      break label300;
      break;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView)
    {
      if ((bgrg.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    bgrg.a(this.a).b = NetConnInfoCenter.getServerTimeMillis();
    bgrg.a(this.a).jdField_a_of_type_Int = 2;
    if (bgrg.a(this.a).c > 0L)
    {
      if (bgrg.a(this.a).b > bgrg.a(this.a).c + 3000L) {
        return;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(bgrg.a(this.a));
      this.a.a(2000L);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt1 <= 0) {
        break label224;
      }
    }
    label224:
    for (paramInt1 = bgrg.a(this.a).m;; paramInt1 = bgrg.a(this.a).n)
    {
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, paramInt1, DisplayUtil.dip2px(bgrg.a(this.a), 16.0F));
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgri
 * JD-Core Version:    0.7.0.1
 */