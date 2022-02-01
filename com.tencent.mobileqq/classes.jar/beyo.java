import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class beyo
  extends bgod
{
  beyo(beyh parambeyh) {}
  
  public void onDone(bgoe parambgoe)
  {
    Object localObject2 = new beyt();
    Bundle localBundle = parambgoe.a();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    ((beyt)localObject2).jdField_a_of_type_Boolean = true;
    ((beyt)localObject2).jdField_a_of_type_JavaLangString = str1;
    beyu.a().setChanged();
    beyu.a().notifyObservers(localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + parambgoe);
    }
    bcef.b(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, parambgoe.a, str1, "", "", "");
    if (parambgoe.a == 0)
    {
      parambgoe = new File(bfcv.a(str1, i, bool));
      if (parambgoe.exists()) {}
      try
      {
        localObject2 = parambgoe.getAbsolutePath().replace(".zip", "_tmp");
        FileUtils.uncompressZip(parambgoe.getAbsolutePath(), (String)localObject2, false);
        bfcv.a(parambgoe, (String)localObject2);
        parambgoe.delete();
        this.a.jdField_a_of_type_JavaUtilHashMap.put(str1, Integer.valueOf(3));
        bcef.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) || (this.a.jdField_a_of_type_AndroidAppActivity != null)) && (!beyh.jdField_a_of_type_JavaLangString.equals(this.a.b))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        parambgoe.delete();
      }
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(4));
    i = NetworkUtil.getSystemNetwork(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahik)) && (!(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahgz))) {
        break label446;
      }
      amxb.a("gift_aio", "fail_cartoon", str2, "", "", "");
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
      parambgoe = "0";
      label459:
      if (!nmy.a().a(str2)) {
        break label539;
      }
    }
    label539:
    for (int j = 2;; j = 1)
    {
      bcef.b(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject1 + "", parambgoe, i + "");
      break;
      parambgoe = "1";
      break label459;
    }
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    String str = parambgoe.a().getString("GiftAnimationId");
    beyt localbeyt = new beyt();
    localbeyt.jdField_a_of_type_Boolean = false;
    localbeyt.jdField_a_of_type_JavaLangString = str;
    beyu.a().setChanged();
    beyu.a().notifyObservers(localbeyt);
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyo
 * JD-Core Version:    0.7.0.1
 */