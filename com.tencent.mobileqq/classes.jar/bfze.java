import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class bfze
  extends bfss
{
  bfze(bfzc parambfzc) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView)
    {
      if ((bfzc.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    if (paramInt == 20005)
    {
      bfzc.a(this.a).jdField_a_of_type_Int = 3;
      paramString = (bfst)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(113);
      if (this.a.jdField_a_of_type_Int > 3) {
        paramString.a("OidbSvc.0x7f7", 2039, this.a.jdField_a_of_type_Int, bfzc.a(this.a).frienduin, bfzc.a(this.a).bagId, 3000L, bfzc.a(this.a));
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
        paramString.a("OidbSvc.0x6b5", 1717, this.a.jdField_a_of_type_Int, bfzc.a(this.a).frienduin, bfzc.a(this.a).bagId, 3000L, bfzc.a(this.a));
      }
      if (paramInt != -1) {
        break label497;
      }
      str1 = bfzc.a(this.a).getResources().getString(2131697032);
      str2 = anhk.c[bgnt.a(bfzc.a(this.a))];
      if (this.a.jdField_a_of_type_Int < 4) {
        break;
      }
      anqt.a("cartoon", "timeout", bfzc.a(this.a).frienduin, bftg.b(bfzc.a(this.a)) + str2, "", "");
      break label546;
      if (!(this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToAllSurfaceView)) {
        break label549;
      }
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, bfzc.a(this.a).n, bggq.a(bfzc.a(this.a), 16.0F));
      bfzc.a(this.a).jdField_a_of_type_Int = 2;
    } while (bfzc.a(this.a).c <= 0L);
    if (bfzc.a(this.a).b > bfzc.a(this.a).c + 3000L)
    {
      return;
      if (bfzc.a(this.a) == null) {
        break label551;
      }
    }
    label546:
    label549:
    label551:
    for (paramString = "0";; paramString = "1")
    {
      bcst.b(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, "" + bfzc.a(this.a).frienduin, "" + bftg.b(bfzc.a(this.a)), paramString, str2);
      break label546;
      label497:
      paramString = bfzc.a(this.a).getResources().getString(2131697031);
      break label299;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(bfzc.a(this.a));
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
      if ((bfzc.a(this.a) == null) || (this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)) {
        return;
      }
    }
    bfzc.a(this.a).b = NetConnInfoCenter.getServerTimeMillis();
    bfzc.a(this.a).jdField_a_of_type_Int = 2;
    if (bfzc.a(this.a).c > 0L)
    {
      if (bfzc.a(this.a).b > bfzc.a(this.a).c + 3000L) {
        return;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(bfzc.a(this.a));
      this.a.a(2000L);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt1 <= 0) {
        break label224;
      }
    }
    label224:
    for (paramInt1 = bfzc.a(this.a).m;; paramInt1 = bfzc.a(this.a).n)
    {
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a(paramString, paramInt1, bggq.a(bfzc.a(this.a), 16.0F));
      ((TroopGiftToAllSurfaceView)this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfze
 * JD-Core Version:    0.7.0.1
 */