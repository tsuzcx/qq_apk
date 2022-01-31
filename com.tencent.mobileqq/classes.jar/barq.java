import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class barq
  extends balg
{
  barq(baro parambaro) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView)
    {
      if ((baro.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    if (paramInt == 20005)
    {
      baro.a(this.a).jdField_a_of_type_Int = 3;
      paramString = (balh)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(113);
      if (this.a.jdField_a_of_type_Int > 3) {
        paramString.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, baro.a(this.a).frienduin, baro.a(this.a).bagId, 3000L, baro.a(this.a));
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
        paramString.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, baro.a(this.a).frienduin, baro.a(this.a).bagId, 3000L, baro.a(this.a));
      }
      if (paramInt != -1) {
        break label497;
      }
      str1 = baro.a(this.a).getResources().getString(2131698003);
      str2 = ajsd.c[bbfj.a(baro.a(this.a))];
      if (this.a.jdField_a_of_type_Int < 4) {
        break;
      }
      akbj.a("cartoon", "timeout", baro.a(this.a).frienduin, balu.b(baro.a(this.a)) + str2, "", "");
      break label546;
      if (!(this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToAllSurfaceView)) {
        break label549;
      }
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, baro.a(this.a).n, baxn.a(baro.a(this.a), 16.0F));
      baro.a(this.a).jdField_a_of_type_Int = 2;
    } while (baro.a(this.a).c <= 0L);
    if (baro.a(this.a).b > baro.a(this.a).c + 3000L)
    {
      return;
      if (baro.a(this.a) == null) {
        break label551;
      }
    }
    label546:
    label549:
    label551:
    for (paramString = "0";; paramString = "1")
    {
      axqy.b(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, "" + baro.a(this.a).frienduin, "" + balu.b(baro.a(this.a)), paramString, str2);
      break label546;
      label497:
      paramString = baro.a(this.a).getResources().getString(2131698002);
      break label299;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(baro.a(this.a));
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
      if ((baro.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    baro.a(this.a).b = NetConnInfoCenter.getServerTimeMillis();
    baro.a(this.a).jdField_a_of_type_Int = 2;
    if (baro.a(this.a).c > 0L)
    {
      if (baro.a(this.a).b > baro.a(this.a).c + 3000L) {
        return;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(baro.a(this.a));
      this.a.a(2000L);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt1 <= 0) {
        break label224;
      }
    }
    label224:
    for (paramInt1 = baro.a(this.a).m;; paramInt1 = baro.a(this.a).n)
    {
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, paramInt1, baxn.a(baro.a(this.a), 16.0F));
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     barq
 * JD-Core Version:    0.7.0.1
 */