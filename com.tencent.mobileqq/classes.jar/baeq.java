import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class baeq
{
  public int a;
  private LinkedHashMap<String, List<agau>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<agau> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  public int b;
  private List<agau> b;
  public int c;
  private List<agau> c;
  
  public baeq(List<agau> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
  }
  
  private baer a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, String paramString, baer parambaer, boolean paramBoolean)
  {
    if (((baee.a(paramQQAppInterface, paramTroopInfo)) || (baee.b(paramQQAppInterface, paramTroopInfo))) && (!paramBoolean))
    {
      paramQQAppInterface = baep.a();
      if ((TextUtils.isEmpty(paramString)) || (baep.a(paramString, paramQQAppInterface))) {
        parambaer.jdField_a_of_type_JavaUtilList.add(0, paramQQAppInterface);
      }
    }
    return parambaer;
  }
  
  private baer a(String paramString, boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    paramTroopInfo = a(paramString, paramTroopInfo);
    if (paramTroopInfo.length >= 3)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramTroopInfo[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])paramTroopInfo[1]);
    }
    for (this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramTroopInfo[2]);; this.jdField_a_of_type_ArrayOfJavaLangString = new String[0])
    {
      this.jdField_c_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilLinkedHashMap);
      paramTroopInfo = new baer();
      paramTroopInfo.jdField_a_of_type_JavaLangString = paramString;
      paramTroopInfo.jdField_a_of_type_Boolean = paramBoolean;
      paramTroopInfo.jdField_a_of_type_ArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      paramTroopInfo.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      paramTroopInfo.jdField_a_of_type_JavaUtilList = this.jdField_c_of_type_JavaUtilList;
      return paramTroopInfo;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_ArrayOfInt = new int[0];
    }
  }
  
  private List<agau> a(LinkedHashMap<String, List<agau>> paramLinkedHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    while (paramLinkedHashMap.hasNext()) {
      localArrayList.addAll((Collection)((Map.Entry)paramLinkedHashMap.next()).getValue());
    }
    return localArrayList;
  }
  
  private Object[] a(String paramString, TroopInfo paramTroopInfo)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1;
    Object localObject2;
    int i;
    for (;;)
    {
      agau localagau;
      try
      {
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_c_of_type_Int = 0;
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localagau = (agau)localIterator.next();
        if ((localagau.jdField_a_of_type_Boolean) || ((!TextUtils.isEmpty(paramString)) && (baee.a(localagau.jdField_a_of_type_JavaLangString, paramTroopInfo)))) {
          break label664;
        }
        if ((TextUtils.isEmpty(paramString)) || (!baee.b(localagau.jdField_a_of_type_JavaLangString, paramTroopInfo))) {
          break label228;
        }
      }
      finally {}
      localObject2 = localObject1;
      if (((String)localObject1).length() == 1)
      {
        i = ((String)localObject1).charAt(0);
        localObject2 = localObject1;
        if (!((String)localObject1).equals("★"))
        {
          if ((65 > i) || (i > 90)) {
            break label671;
          }
          label160:
          localObject2 = ((String)localObject1).toUpperCase();
        }
      }
      label167:
      if (localLinkedHashMap.get(localObject2) == null) {
        localLinkedHashMap.put(localObject2, new ArrayList());
      }
      this.jdField_b_of_type_Int += 1;
      ((List)localLinkedHashMap.get(localObject2)).add(localagau);
      continue;
      label228:
      localObject1 = localagau.x;
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        break label688;
      }
      localObject1 = ((String)localObject1).substring(0, 1);
    }
    paramTroopInfo = new baei(paramTroopInfo);
    paramString = new LinkedHashMap();
    long l = System.currentTimeMillis();
    if (localLinkedHashMap.get("★") != null)
    {
      this.jdField_a_of_type_Int += 1;
      Collections.sort((List)localLinkedHashMap.get("★"), paramTroopInfo);
      paramString.put("★", localLinkedHashMap.get("★"));
    }
    for (;;)
    {
      if (c1 <= 'Z')
      {
        if (localLinkedHashMap.get(String.valueOf(c1)) != null)
        {
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)localLinkedHashMap.get(String.valueOf(c1)), paramTroopInfo);
          paramString.put(String.valueOf(c1), localLinkedHashMap.get(String.valueOf(c1)));
        }
      }
      else
      {
        if (localLinkedHashMap.get("#") != null)
        {
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)localLinkedHashMap.get("#"), paramTroopInfo);
          paramString.put("#", localLinkedHashMap.get("#"));
        }
        if (QLog.isColorLevel()) {
          QLog.i("SearchTask", 2, "constructHashStruct-sort: invoked.  cost: " + (System.currentTimeMillis() - l));
        }
        localLinkedHashMap.clear();
        paramTroopInfo = new int[paramString.keySet().size()];
        localObject1 = new String[paramTroopInfo.length];
        localObject2 = paramString.keySet().iterator();
        if (paramTroopInfo.length == 0) {
          return new Object[0];
        }
        paramTroopInfo[0] = 0;
        i = 1;
        while (i < paramTroopInfo.length)
        {
          int j = paramTroopInfo[i];
          int k = paramTroopInfo[(i - 1)];
          paramTroopInfo[i] = (((List)paramString.get(((Iterator)localObject2).next())).size() + k + j);
          i += 1;
        }
        localObject2 = paramString.keySet().iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1[i] = ((String)((Iterator)localObject2).next());
          i += 1;
        }
        return new Object[] { paramString, paramTroopInfo, localObject1 };
        label664:
        localObject1 = "★";
        break;
        label671:
        if ((97 <= i) && (i <= 122))
        {
          break label160;
          label688:
          localObject1 = "#";
          break;
        }
        localObject2 = "#";
        break label167;
        c1 = 'A';
        continue;
      }
      char c1 = (char)(c1 + '\001');
    }
  }
  
  public baer a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, SessionInfo paramSessionInfo, boolean paramBoolean2)
  {
    TroopInfo localTroopInfo = null;
    if (paramSessionInfo != null)
    {
      paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (this.jdField_b_of_type_JavaUtilList = baep.a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList, paramBoolean1);; this.jdField_b_of_type_JavaUtilList = new ArrayList(baep.a(paramString, baep.a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList, paramBoolean1), paramQQAppInterface, localTroopInfo))) {
      return a(paramQQAppInterface, localTroopInfo, paramString, a(paramString, paramBoolean1, localTroopInfo), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baeq
 * JD-Core Version:    0.7.0.1
 */