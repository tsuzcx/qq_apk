import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bggs
  extends bhyn
{
  bggs(bggl parambggl) {}
  
  public void onDone(bhyo parambhyo)
  {
    Object localObject2 = new bggx();
    Bundle localBundle = parambhyo.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    ((bggx)localObject2).jdField_a_of_type_Boolean = true;
    ((bggx)localObject2).jdField_a_of_type_JavaLangString = str1;
    bggy.a().setChanged();
    bggy.a().notifyObservers(localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambhyo);
    }
    bdla.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambhyo.a, str1, "", "", "");
    if (parambhyo.a == 0)
    {
      parambhyo = new File(bglb.a(str1, i, bool));
      if (parambhyo.exists()) {}
      try
      {
        localObject2 = parambhyo.getAbsolutePath().replace(".zip", "_tmp");
        FileUtils.uncompressZip(parambhyo.getAbsolutePath(), (String)localObject2, false);
        bglb.a(parambhyo, (String)localObject2);
        parambhyo.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        bdla.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!bggl.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambhyo.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(4));
    i = NetworkUtil.getSystemNetwork(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aidd)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aibs))) {
        break label446;
      }
      anzp.a("gift_aio", "fail_cartoon", str2, "", "", "");
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
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      parambhyo = "0";
      label459:
      if (!nty.a().a(str2)) {
        break label539;
      }
    }
    label539:
    for (int j = 2;; j = 1)
    {
      bdla.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject1 + "", parambhyo, i + "");
      break;
      parambhyo = "1";
      break label459;
    }
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    String str = parambhyo.a().getString("GiftAnimationId");
    bggx localbggx = new bggx();
    localbggx.jdField_a_of_type_Boolean = false;
    localbggx.jdField_a_of_type_JavaLangString = str;
    bggy.a().setChanged();
    bggy.a().notifyObservers(localbggx);
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggs
 * JD-Core Version:    0.7.0.1
 */