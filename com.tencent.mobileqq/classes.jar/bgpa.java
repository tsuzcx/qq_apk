import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bgpa
  extends biht
{
  bgpa(bgot parambgot) {}
  
  public void onDone(bihu parambihu)
  {
    Object localObject2 = new bgpf();
    Bundle localBundle = parambihu.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    ((bgpf)localObject2).jdField_a_of_type_Boolean = true;
    ((bgpf)localObject2).jdField_a_of_type_JavaLangString = str1;
    bgpg.a().setChanged();
    bgpg.a().notifyObservers(localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambihu);
    }
    bdll.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambihu.a, str1, "", "", "");
    if (parambihu.a == 0)
    {
      parambihu = new File(bgth.a(str1, i, bool));
      if (parambihu.exists()) {}
      try
      {
        localObject2 = parambihu.getAbsolutePath().replace(".zip", "_tmp");
        bhmi.a(parambihu.getAbsolutePath(), (String)localObject2, false);
        bgth.a(parambihu, (String)localObject2);
        parambihu.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        bdll.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!bgot.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambihu.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(4));
    i = bhnv.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aimx)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ailn))) {
        break label446;
      }
      aocz.a("gift_aio", "fail_cartoon", str2, "", "", "");
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
    label446:
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      parambihu = "0";
      label459:
      if (!nlj.a().a(str2)) {
        break label539;
      }
    }
    label539:
    for (int j = 2;; j = 1)
    {
      bdll.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject1 + "", parambihu, i + "");
      break;
      parambihu = "1";
      break label459;
    }
  }
  
  public boolean onStart(bihu parambihu)
  {
    String str = parambihu.a().getString("GiftAnimationId");
    bgpf localbgpf = new bgpf();
    localbgpf.jdField_a_of_type_Boolean = false;
    localbgpf.jdField_a_of_type_JavaLangString = str;
    bgpg.a().setChanged();
    bgpg.a().notifyObservers(localbgpf);
    return super.onStart(parambihu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpa
 * JD-Core Version:    0.7.0.1
 */