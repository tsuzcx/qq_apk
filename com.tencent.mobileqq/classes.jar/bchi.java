import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class bchi
  implements Manager
{
  private bchd jdField_a_of_type_Bchd = new bchd("Cahce_");
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bchi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public ArrayList<bchg> a(String paramString)
  {
    if (this.jdField_a_of_type_Bchd != null)
    {
      paramString = this.jdField_a_of_type_Bchd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      if ((paramString != null) && (paramString.size() > 10))
      {
        ArrayList localArrayList = new ArrayList(paramString.subList(0, 10));
        QLog.i("MostUsedSearchResultManager", 2, "tmpResult subList 10 ,orglist is " + paramString.size());
        return localArrayList;
      }
      return paramString;
    }
    QLog.e("MostUsedSearchResultManager", 2, "Match with null cache");
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bchd != null)
    {
      this.jdField_a_of_type_Bchd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QLog.d("MostUsedSearchResultManager", 2, "init");
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "init with null cache ");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2))) {}
    for (String str = paramString2;; str = paramString1)
    {
      QLog.d("MostUsedSearchResultManager", 2, "UpdateItemUsed : key= " + paramString1 + " mostusedKey= " + paramString2);
      int i = bchc.a(paramInt);
      if (!a(i)) {
        break;
      }
      paramString1 = new MostUsedSearchItem(str, NetConnInfoCenter.getServerTimeMillis(), paramString3, paramInt, i);
      ThreadManager.getSubThreadHandler().post(new MostUsedSearchResultManager.1(this, paramString1));
      return;
      paramString2 = "";
    }
  }
  
  boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bchd != null) {
      this.jdField_a_of_type_Bchd.a();
    }
  }
  
  public void onDestroy()
  {
    b();
    this.jdField_a_of_type_Bchd = null;
    QLog.d("MostUsedSearchResultManager", 2, "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchi
 * JD-Core Version:    0.7.0.1
 */