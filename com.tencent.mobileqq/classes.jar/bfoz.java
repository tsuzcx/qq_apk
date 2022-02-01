import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bfoz
  extends bhhe
{
  bfoz(bfos parambfos) {}
  
  public void onDone(bhhf parambhhf)
  {
    bfpe localbfpe = new bfpe();
    Bundle localBundle = parambhhf.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    localbfpe.jdField_a_of_type_Boolean = true;
    localbfpe.jdField_a_of_type_JavaLangString = str1;
    bfpf.a().setChanged();
    bfpf.a().notifyObservers(localbfpe);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambhhf);
    }
    bcst.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambhhf.a, str1, "", "", "");
    if (parambhhf.a == 0)
    {
      parambhhf = new File(bftg.a(str1, i, bool));
      if (parambhhf.exists()) {}
      try
      {
        bgmg.a(parambhhf.getAbsolutePath(), anhk.cx, false);
        parambhhf.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        bcst.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!bfos.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambhhf.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(4));
    i = bgnt.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aidf)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aibv))) {
        break label428;
      }
      anqt.a("gift_aio", "fail_cartoon", str2, "", "", "");
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
      parambhhf = "0";
      label441:
      if (!njo.a().a(str2)) {
        break label521;
      }
    }
    label521:
    for (int j = 2;; j = 1)
    {
      bcst.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject + "", parambhhf, i + "");
      break;
      parambhhf = "1";
      break label441;
    }
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    String str = parambhhf.a().getString("GiftAnimationId");
    bfpe localbfpe = new bfpe();
    localbfpe.jdField_a_of_type_Boolean = false;
    localbfpe.jdField_a_of_type_JavaLangString = str;
    bfpf.a().setChanged();
    bfpf.a().notifyObservers(localbfpe);
    return super.onStart(parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfoz
 * JD-Core Version:    0.7.0.1
 */