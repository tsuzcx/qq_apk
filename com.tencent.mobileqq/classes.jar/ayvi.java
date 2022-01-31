import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ayvi
{
  public static final String[] a;
  private int jdField_a_of_type_Int;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ayvd jdField_a_of_type_Ayvd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ConcurrentHashMap<String, Long>> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
  private ConcurrentHashMap<String, ArrayList<Object[]>> b = new ConcurrentHashMap(2);
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "msg_cached_max_seq", "msg_cached_min_seq", "msg_readed_seq", "msg_expired_seq" };
  }
  
  public ayvi(QQAppInterface paramQQAppInterface, int paramInt, String paramString, SharedPreferences paramSharedPreferences, ayvd paramayvd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
    this.jdField_a_of_type_Ayvd = paramayvd;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(jdField_a_of_type_ArrayOfJavaLangString.length);
    paramInt = 0;
    while (paramInt <= 3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ConcurrentHashMap(2));
      paramInt += 1;
    }
  }
  
  public int a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
  }
  
  public long a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > 3) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      return 0L;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!localConcurrentHashMap.containsKey(paramString)) {
      localConcurrentHashMap.put(paramString, Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(a(paramInt, paramString), 0L)));
    }
    return ((Long)localConcurrentHashMap.get(paramString)).longValue();
  }
  
  public String a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > 3) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append("_").append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]).append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    int i = 0;
    while (i <= 3)
    {
      ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilArrayList.get(i)).clear();
      i += 1;
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    long l1;
    if (paramInt2 == 1) {
      l1 = Math.max(paramLong, a(paramInt1, paramString));
    }
    for (;;)
    {
      ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).put(paramString, Long.valueOf(l1));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
        break;
      }
      this.jdField_a_of_type_Ayvd.putLong(a(paramInt1, paramString), l1);
      return;
      l1 = paramLong;
      if (paramInt2 == 2)
      {
        long l2 = a(paramInt1, paramString);
        l1 = paramLong;
        if (l2 != 0L) {
          l1 = Math.min(paramLong, l2);
        }
      }
    }
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.b.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.b.put(paramString, localArrayList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvi
 * JD-Core Version:    0.7.0.1
 */