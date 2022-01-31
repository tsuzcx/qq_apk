import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bcfy
  extends bdvu
{
  bcfy(bcfr parambcfr) {}
  
  public void onDone(bdvv parambdvv)
  {
    bcgd localbcgd = new bcgd();
    Bundle localBundle = parambdvv.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    localbcgd.jdField_a_of_type_Boolean = true;
    localbcgd.jdField_a_of_type_JavaLangString = str1;
    bcge.a().setChanged();
    bcge.a().notifyObservers(localbcgd);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambdvv);
    }
    azmj.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambdvv.a, str1, "", "", "");
    if (parambdvv.a == 0)
    {
      parambdvv = new File(bckh.a(str1, i, bool));
      if (parambdvv.exists()) {}
      try
      {
        bdcs.a(parambdvv.getAbsolutePath(), aljq.cu, false);
        parambdvv.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        azmj.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!bcfr.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambdvv.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(4));
    i = bdee.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agoj)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agmy))) {
        break label428;
      }
      alsy.a("gift_aio", "fail_cartoon", str2, "", "", "");
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
      parambdvv = "0";
      label441:
      if (!nav.a().a(str2)) {
        break label521;
      }
    }
    label521:
    for (int j = 2;; j = 1)
    {
      azmj.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject + "", parambdvv, i + "");
      break;
      parambdvv = "1";
      break label441;
    }
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    String str = parambdvv.a().getString("GiftAnimationId");
    bcgd localbcgd = new bcgd();
    localbcgd.jdField_a_of_type_Boolean = false;
    localbcgd.jdField_a_of_type_JavaLangString = str;
    bcge.a().setChanged();
    bcge.a().notifyObservers(localbcgd);
    return super.onStart(parambdvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfy
 * JD-Core Version:    0.7.0.1
 */