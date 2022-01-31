import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bagy
  extends bbwf
{
  bagy(bagr parambagr) {}
  
  public void onDone(bbwg parambbwg)
  {
    bahd localbahd = new bahd();
    Bundle localBundle = parambbwg.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    localbahd.jdField_a_of_type_Boolean = true;
    localbahd.jdField_a_of_type_JavaLangString = str1;
    bahe.a().setChanged();
    bahe.a().notifyObservers(localbahd);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambbwg);
    }
    axqw.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambbwg.a, str1, "", "", "");
    if (parambbwg.a == 0)
    {
      parambbwg = new File(balg.a(str1, i, bool));
      if (parambbwg.exists()) {}
      try
      {
        bbdj.a(parambbwg.getAbsolutePath(), ajsf.ct, false);
        parambbwg.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        axqw.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!bagr.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambbwg.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(4));
    i = bbev.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aerl)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeqd))) {
        break label428;
      }
      akbk.a("gift_aio", "fail_cartoon", str2, "", "", "");
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
      parambbwg = "0";
      label441:
      if (!mye.a().a(str2)) {
        break label521;
      }
    }
    label521:
    for (int j = 2;; j = 1)
    {
      axqw.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject + "", parambbwg, i + "");
      break;
      parambbwg = "1";
      break label441;
    }
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    String str = parambbwg.a().getString("GiftAnimationId");
    bahd localbahd = new bahd();
    localbahd.jdField_a_of_type_Boolean = false;
    localbahd.jdField_a_of_type_JavaLangString = str;
    bahe.a().setChanged();
    bahe.a().notifyObservers(localbahd);
    return super.onStart(parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bagy
 * JD-Core Version:    0.7.0.1
 */