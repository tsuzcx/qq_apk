import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bahm
  extends bbwt
{
  bahm(bahf parambahf) {}
  
  public void onDone(bbwu parambbwu)
  {
    bahr localbahr = new bahr();
    Bundle localBundle = parambbwu.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    localbahr.jdField_a_of_type_Boolean = true;
    localbahr.jdField_a_of_type_JavaLangString = str1;
    bahs.a().setChanged();
    bahs.a().notifyObservers(localbahr);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambbwu);
    }
    axqy.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambbwu.a, str1, "", "", "");
    if (parambbwu.a == 0)
    {
      parambbwu = new File(balu.a(str1, i, bool));
      if (parambbwu.exists()) {}
      try
      {
        bbdx.a(parambbwu.getAbsolutePath(), ajsd.ct, false);
        parambbwu.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        axqy.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!bahf.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambbwu.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(4));
    i = bbfj.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aerj)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeqb))) {
        break label428;
      }
      akbj.a("gift_aio", "fail_cartoon", str2, "", "", "");
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
      parambbwu = "0";
      label441:
      if (!myb.a().a(str2)) {
        break label521;
      }
    }
    label521:
    for (int j = 2;; j = 1)
    {
      axqy.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject + "", parambbwu, i + "");
      break;
      parambbwu = "1";
      break label441;
    }
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    String str = parambbwu.a().getString("GiftAnimationId");
    bahr localbahr = new bahr();
    localbahr.jdField_a_of_type_Boolean = false;
    localbahr.jdField_a_of_type_JavaLangString = str;
    bahs.a().setChanged();
    bahs.a().notifyObservers(localbahr);
    return super.onStart(parambbwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bahm
 * JD-Core Version:    0.7.0.1
 */