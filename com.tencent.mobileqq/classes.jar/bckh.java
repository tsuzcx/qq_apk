import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bckh
  extends bead
{
  bckh(bcka parambcka) {}
  
  public void onDone(beae parambeae)
  {
    bckm localbckm = new bckm();
    Bundle localBundle = parambeae.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    localbckm.jdField_a_of_type_Boolean = true;
    localbckm.jdField_a_of_type_JavaLangString = str1;
    bckn.a().setChanged();
    bckn.a().notifyObservers(localbckm);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambeae);
    }
    azqs.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambeae.a, str1, "", "", "");
    if (parambeae.a == 0)
    {
      parambeae = new File(bcoq.a(str1, i, bool));
      if (parambeae.exists()) {}
      try
      {
        bdhb.a(parambeae.getAbsolutePath(), alof.cu, false);
        parambeae.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        azqs.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!bcka.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambeae.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(4));
    i = bdin.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agsy)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agrn))) {
        break label428;
      }
      alxn.a("gift_aio", "fail_cartoon", str2, "", "", "");
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
      parambeae = "0";
      label441:
      if (!nav.a().a(str2)) {
        break label521;
      }
    }
    label521:
    for (int j = 2;; j = 1)
    {
      azqs.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject + "", parambeae, i + "");
      break;
      parambeae = "1";
      break label441;
    }
  }
  
  public boolean onStart(beae parambeae)
  {
    String str = parambeae.a().getString("GiftAnimationId");
    bckm localbckm = new bckm();
    localbckm.jdField_a_of_type_Boolean = false;
    localbckm.jdField_a_of_type_JavaLangString = str;
    bckn.a().setChanged();
    bckn.a().notifyObservers(localbckm);
    return super.onStart(parambeae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckh
 * JD-Core Version:    0.7.0.1
 */