import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class azfv
  extends batl
{
  azfv(azfo paramazfo) {}
  
  public void onDone(batm parambatm)
  {
    azga localazga = new azga();
    Bundle localBundle = parambatm.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    localazga.jdField_a_of_type_Boolean = true;
    localazga.jdField_a_of_type_JavaLangString = str1;
    azgb.a().setChanged();
    azgb.a().notifyObservers(localazga);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambatm);
    }
    awqx.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambatm.a, str1, "", "", "");
    if (parambatm.a == 0)
    {
      parambatm = new File(azkd.a(str1, i, bool));
      if (parambatm.exists()) {}
      try
      {
        bace.a(parambatm.getAbsolutePath(), ajed.cs, false);
        parambatm.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        awqx.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!azfo.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambatm.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(4));
    i = badq.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aego)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aefe))) {
        break label428;
      }
      ajnb.a("gift_aio", "fail_cartoon", str2, "", "", "");
      break;
      if (i == 2) {
        i = 3;
      } else if (i == 3) {
        i = 2;
      } else if (i == 4) {
        i = 1;
      } else {
        i = 4;
      }
    }
    label428:
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      parambatm = "0";
      label441:
      if (!mnf.a().a(str2)) {
        break label521;
      }
    }
    label521:
    for (int j = 2;; j = 1)
    {
      awqx.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject + "", parambatm, i + "");
      break;
      parambatm = "1";
      break label441;
    }
  }
  
  public boolean onStart(batm parambatm)
  {
    String str = parambatm.a().getString("GiftAnimationId");
    azga localazga = new azga();
    localazga.jdField_a_of_type_Boolean = false;
    localazga.jdField_a_of_type_JavaLangString = str;
    azgb.a().setChanged();
    azgb.a().notifyObservers(localazga);
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azfv
 * JD-Core Version:    0.7.0.1
 */