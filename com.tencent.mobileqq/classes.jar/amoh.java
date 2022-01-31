import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class amoh
  implements amoi
{
  amof jdField_a_of_type_Amof;
  amog jdField_a_of_type_Amog;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  amoh(QQAppInterface paramQQAppInterface, amog paramamog)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amog = paramamog;
    this.jdField_a_of_type_Amof = this.jdField_a_of_type_Amog.jdField_a_of_type_Amof;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_troop_upgrade_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_troop_upgrade_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public void a() {}
  
  public boolean a()
  {
    return !a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(FTSTroopSync.class.getSimpleName());
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject).next();
      try
      {
        localArrayList.add(new FTSTroopSync(5, Long.parseLong(localTroopInfo.troopuin)));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("FTSTroopUpgrader", 2, "startUpgrade exception : " + localException.toString());
      }
    }
    if (this.jdField_a_of_type_Amog.a(localArrayList))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amoh
 * JD-Core Version:    0.7.0.1
 */