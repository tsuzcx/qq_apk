import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.util.DisplayUtil;

class bfir
  extends bfch
{
  bfir(bfip parambfip) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView)
    {
      if ((bfip.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    if (paramInt == 20005)
    {
      bfip.a(this.a).jdField_a_of_type_Int = 3;
      paramString = (bfci)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(113);
      if (this.a.jdField_a_of_type_Int > 3) {
        paramString.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bfip.a(this.a).frienduin, bfip.a(this.a).bagId, 3000L, bfip.a(this.a));
      }
    }
    String str1;
    String str2;
    label299:
    do
    {
      for (;;)
      {
        return;
        paramString.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bfip.a(this.a).frienduin, bfip.a(this.a).bagId, 3000L, bfip.a(this.a));
      }
      if (paramInt != -1) {
        break label497;
      }
      str1 = bfip.a(this.a).getResources().getString(2131697223);
      str2 = com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[com.tencent.mobileqq.utils.NetworkUtil.getSystemNetwork(bfip.a(this.a))];
      if (this.a.jdField_a_of_type_Int < 4) {
        break;
      }
      amxb.a("cartoon", "timeout", bfip.a(this.a).frienduin, bfcv.b(bfip.a(this.a)) + str2, "", "");
      break label546;
      if (!(this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToAllSurfaceView)) {
        break label549;
      }
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, bfip.a(this.a).n, DisplayUtil.dip2px(bfip.a(this.a), 16.0F));
      bfip.a(this.a).jdField_a_of_type_Int = 2;
    } while (bfip.a(this.a).c <= 0L);
    if (bfip.a(this.a).b > bfip.a(this.a).c + 3000L)
    {
      return;
      if (bfip.a(this.a) == null) {
        break label551;
      }
    }
    label546:
    label549:
    label551:
    for (paramString = "0";; paramString = "1")
    {
      bcef.b(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, "" + bfip.a(this.a).frienduin, "" + bfcv.b(bfip.a(this.a)), paramString, str2);
      break label546;
      label497:
      paramString = bfip.a(this.a).getResources().getString(2131697222);
      break label299;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(bfip.a(this.a));
      this.a.a(2000L);
      break;
      paramString = str1;
      break label299;
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
      if ((bfip.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    bfip.a(this.a).b = NetConnInfoCenter.getServerTimeMillis();
    bfip.a(this.a).jdField_a_of_type_Int = 2;
    if (bfip.a(this.a).c > 0L)
    {
      if (bfip.a(this.a).b > bfip.a(this.a).c + 3000L) {
        return;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(bfip.a(this.a));
      this.a.a(2000L);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt1 <= 0) {
        break label224;
      }
    }
    label224:
    for (paramInt1 = bfip.a(this.a).m;; paramInt1 = bfip.a(this.a).n)
    {
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, paramInt1, DisplayUtil.dip2px(bfip.a(this.a), 16.0F));
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfir
 * JD-Core Version:    0.7.0.1
 */