import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avqd
{
  public static int a = 3;
  
  public static int a(avom paramavom)
  {
    int j = 1;
    int i;
    if ((paramavom instanceof avob)) {
      i = 2;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while ((paramavom instanceof avnx));
      i = j;
    } while ((paramavom instanceof avnz));
    if ((paramavom instanceof avnw)) {
      return 3;
    }
    return 0;
  }
  
  private static int a(avqc paramavqc, List<avon> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = 0;
    while (j < paramList.size())
    {
      avon localavon = (avon)paramList.get(j);
      String str = "";
      Object localObject;
      int i;
      if ((localavon instanceof avoj))
      {
        localObject = (avoj)localavon;
        if ((((avoj)localObject).a() instanceof String)) {
          str = (String)((avoj)localObject).a();
        }
        i = ((avoj)localObject).e();
      }
      while ((str.equals(paramavqc.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify)) && (i == paramavqc.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identifyType))
      {
        paramavqc.jdField_a_of_type_Boolean = true;
        paramavqc.jdField_a_of_type_Avon = localavon;
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "bEffective ");
        return j;
        if ((localavon instanceof avnl))
        {
          localObject = (avnl)localavon;
          str = ((avnl)localObject).e();
          i = ((avnl)localObject).e();
        }
        else
        {
          QLog.e("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "unknown type extends ISearchResultModel");
          i = -1;
        }
      }
      j += 1;
    }
    return -1;
  }
  
  private static avom a(Object paramObject)
  {
    if ((paramObject instanceof avob))
    {
      paramObject = (avob)paramObject;
      return new avob(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof avnx))
    {
      paramObject = (avnx)paramObject;
      return new avnx(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof avnz))
    {
      paramObject = (avnz)paramObject;
      return new avnz(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof avnw))
    {
      paramObject = (avnw)paramObject;
      return new avnw(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    return null;
  }
  
  public static ArrayList a(String paramString, ArrayList<avqc> paramArrayList, List paramList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject1 = paramList.get(i);
      localObject2 = a(localObject1);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      for (;;)
      {
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsed", 2, "the i name " + localArrayList.get(i).getClass().getName());
        i += 1;
        break;
        localArrayList.add(localObject1);
      }
    }
    Object localObject1 = new ArrayList();
    int j = 0;
    i = 0;
    int k;
    label161:
    boolean bool;
    if (j < paramArrayList.size())
    {
      localObject2 = (avqc)paramArrayList.get(j);
      k = 0;
      if (k < localArrayList.size())
      {
        if ((localArrayList.get(k) instanceof avom))
        {
          int m = a((avom)localArrayList.get(k));
          if ((m == 0) || (((avqc)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.businessType != m)) {
            break label465;
          }
          bool = a((avqc)localObject2, (avom)localArrayList.get(k));
          label234:
          if (!bool) {}
        }
      }
      else
      {
        if (((avqc)localObject2).jdField_a_of_type_Boolean != true) {
          break label456;
        }
        if ((((avqc)localObject2).jdField_a_of_type_Avon instanceof avoj)) {
          ((avoj)((avqc)localObject2).jdField_a_of_type_Avon).a(((avqc)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        if ((((avqc)localObject2).jdField_a_of_type_Avon instanceof avnl)) {
          ((avnl)((avqc)localObject2).jdField_a_of_type_Avon).a(((avqc)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        ((ArrayList)localObject1).add(((avqc)localObject2).jdField_a_of_type_Avon);
        k = i + 1;
        i = k;
        if (k != 3) {
          break label456;
        }
      }
    }
    for (;;)
    {
      a(localArrayList);
      if (k > 0)
      {
        paramString = new avod((List)localObject1, paramString);
        localArrayList.add(0, paramString);
        localArrayList.add(0, new avnu(paramString, paramString.a(), false));
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "add GroupSearchModelMostUsed");
      }
      QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "the finish Wash orgList size " + paramList.size() + " match mostUsedList size" + paramArrayList.size() + " resultlist " + localArrayList.size());
      return localArrayList;
      k += 1;
      break label161;
      label456:
      j += 1;
      break;
      label465:
      bool = false;
      break label234;
      k = i;
    }
  }
  
  private static ArrayList<String> a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localObject = paramList.next();
    } while (!(localObject instanceof avod));
    for (paramList = (avod)localObject;; paramList = null)
    {
      if (paramList != null)
      {
        paramList = paramList.a();
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (avon)paramList.next();
            if ((localObject != null) && ((localObject instanceof avos)))
            {
              localObject = (avos)localObject;
              if ((localObject != null) && (((avos)localObject).a != null))
              {
                localObject = ((avos)localObject).a.appId;
                if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                  localArrayList.add(localObject);
                }
              }
            }
          }
        }
      }
      return localArrayList;
    }
  }
  
  private static void a(List paramList, int paramInt1, List<avon> paramList1, avnk paramavnk, boolean paramBoolean, int paramInt2)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0))
    {
      QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " no list to add");
      return;
    }
    int i = paramInt1;
    if (paramList.size() < paramInt1)
    {
      i = paramList.size();
      QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " INDEX OUT OF RANGE");
    }
    QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "addListAndTitleToIndex " + paramList1.size());
    if ((paramInt2 > 0) && (paramList1.size() > paramInt2))
    {
      paramInt1 = paramList1.size() - 1;
      while (paramInt1 >= paramInt2)
      {
        paramList1.remove(paramInt1);
        paramInt1 -= 1;
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramavnk != null)
      {
        paramavnk = new avnk(paramavnk.b(), paramavnk.jdField_a_of_type_Long, paramavnk.a(), paramList1, paramList1.size(), paramavnk.d(), paramavnk.c(), paramavnk.jdField_b_of_type_JavaUtilList, paramavnk.jdField_a_of_type_Boolean, paramavnk.jdField_b_of_type_Boolean, paramavnk.c, paramavnk.d, paramavnk.e);
        if ((!paramBoolean) || (paramInt1 == 0)) {
          break label303;
        }
        if (TextUtils.isEmpty(paramavnk.d())) {
          break label288;
        }
        paramBoolean = true;
      }
      for (;;)
      {
        if (paramList1.size() <= 0) {
          break label307;
        }
        paramInt1 = paramList1.size() - 1;
        while (paramInt1 >= 0)
        {
          paramList.add(i, paramList1.get(paramInt1));
          paramInt1 -= 1;
        }
        paramavnk = new avnk();
        paramavnk.jdField_a_of_type_JavaUtilList = paramList1;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "oldTitleGroupMode is empty");
        break;
        label288:
        paramBoolean = false;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "newModel.getMoreUrl() is empty");
        continue;
        label303:
        paramBoolean = false;
      }
      label307:
      break;
      paramList.add(i, new avnu(paramavnk, paramBoolean, paramavnk.jdField_b_of_type_Boolean));
      return;
    }
  }
  
  public static void a(List paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList3 = a(paramList);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = null;
    int i = paramList.size() - 1;
    Object localObject1;
    if (i >= 0)
    {
      Object localObject3 = paramList.get(i);
      localObject1 = localObject2;
      if ((localObject3 instanceof avnu))
      {
        avom localavom = ((avnu)localObject3).a();
        localObject1 = localObject2;
        if ((localavom instanceof avnk))
        {
          localObject1 = localObject2;
          if (((avnk)localavom).jdField_a_of_type_Long == 1701L)
          {
            localObject1 = (avnk)localavom;
            paramList.remove(i);
          }
        }
      }
      if (((localObject3 instanceof avnv)) && (((avnv)localObject3).jdField_a_of_type_Long == 1701L)) {
        paramList.remove(i);
      }
      if ((localObject3 instanceof avpf))
      {
        localObject2 = (avpf)localObject3;
        if ((((avpf)localObject2).a != null) && (((avpf)localObject2).a.a != null))
        {
          localObject3 = ((avpf)localObject2).a.a.appId;
          paramList.remove(i);
          if (!a((String)localObject3, localArrayList3))
          {
            if (!((avpf)localObject2).jdField_b_of_type_Boolean) {
              break label256;
            }
            localArrayList1.add(0, localObject2);
          }
        }
      }
      for (;;)
      {
        i -= 1;
        localObject2 = localObject1;
        break;
        label256:
        localArrayList2.add(0, localObject2);
      }
    }
    int k = 0;
    i = 0;
    int j = 0;
    label276:
    if (k < paramList.size())
    {
      localObject1 = paramList.get(k);
      if (!(localObject1 instanceof avod)) {
        break label451;
      }
      j = k + 1;
    }
    label451:
    for (;;)
    {
      if ((((localObject1 instanceof avnw)) && (a((avnw)localObject1, paramString))) || ((((localObject1 instanceof avnx)) || ((localObject1 instanceof avnz)) || ((localObject1 instanceof avpw))) && (i <= k))) {
        i = k + 1;
      }
      for (;;)
      {
        k += 1;
        break label276;
        if (localArrayList1.size() > 0)
        {
          a(paramList, j, localArrayList1, (avnk)localObject2, false, a);
          j = localArrayList1.size() + i + 1;
          if (paramList.size() >= j) {
            i = j;
          }
        }
        while (localArrayList2.size() > 0)
        {
          a(paramList, i, localArrayList2, (avnk)localObject2, true, a);
          return;
        }
        break;
      }
    }
  }
  
  private static boolean a(avnw paramavnw, String paramString)
  {
    return (paramavnw != null) && (paramavnw.jdField_a_of_type_JavaUtilList != null) && (paramavnw.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramavnw.jdField_a_of_type_JavaUtilList.get(0) instanceof avnl)) && (((avnl)paramavnw.jdField_a_of_type_JavaUtilList.get(0)).c.equals(paramString));
  }
  
  private static boolean a(avqc paramavqc, avom paramavom)
  {
    if (paramavom == null) {}
    int i;
    do
    {
      return false;
      i = a(paramavqc, paramavom.a());
    } while (i < 0);
    paramavom.a().remove(i);
    return true;
  }
  
  public static boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (paramString.equalsIgnoreCase((String)paramArrayList.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(ArrayList paramArrayList)
  {
    boolean bool2;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool2 = false;
    }
    int i;
    boolean bool1;
    do
    {
      return bool2;
      i = paramArrayList.size() - 1;
      bool1 = false;
      bool2 = bool1;
    } while (i < 0);
    avom localavom;
    if ((paramArrayList.get(i) instanceof avom))
    {
      localavom = (avom)paramArrayList.get(i);
      if ((localavom.a() != null) && (localavom.a().size() == 0)) {
        if ((i - 1 < 0) || (!(paramArrayList.get(i - 1) instanceof avnu)) || (!((avnu)paramArrayList.get(i - 1)).a().equals(localavom.a()))) {
          break label323;
        }
      }
    }
    label323:
    for (int j = 1;; j = 0)
    {
      paramArrayList.remove(i);
      if (j != 0)
      {
        i -= 1;
        paramArrayList.remove(i);
      }
      for (;;)
      {
        bool1 = true;
        for (;;)
        {
          i -= 1;
          break;
          if ((a(localavom) != 0) && (i - 1 >= 0) && ((paramArrayList.get(i - 1) instanceof avnu)) && (((avnu)paramArrayList.get(i - 1)).a().equals(localavom.a())))
          {
            avnu localavnu = (avnu)paramArrayList.get(i - 1);
            if ((localavnu.a() != null) && (localavom.a() != null)) {
              if (localavnu.a().a() != null) {
                if (localavnu.a().a().size() != localavom.a().size())
                {
                  QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "add new group title");
                  paramArrayList.remove(i - 1);
                  paramArrayList.add(i - 1, new avnu(localavom));
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqd
 * JD-Core Version:    0.7.0.1
 */