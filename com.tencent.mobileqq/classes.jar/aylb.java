import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aylb
{
  public static int a = 3;
  
  public static int a(ayjk paramayjk)
  {
    int j = 1;
    int i;
    if ((paramayjk instanceof ayiz)) {
      i = 2;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while ((paramayjk instanceof ayiv));
      i = j;
    } while ((paramayjk instanceof ayix));
    if ((paramayjk instanceof ayiu)) {
      return 3;
    }
    return 0;
  }
  
  private static int a(ayla paramayla, List<ayjl> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = 0;
    while (j < paramList.size())
    {
      ayjl localayjl = (ayjl)paramList.get(j);
      String str = "";
      Object localObject;
      int i;
      if ((localayjl instanceof ayjh))
      {
        localObject = (ayjh)localayjl;
        if ((((ayjh)localObject).a() instanceof String)) {
          str = (String)((ayjh)localObject).a();
        }
        i = ((ayjh)localObject).e();
      }
      while ((str.equals(paramayla.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify)) && (i == paramayla.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identifyType))
      {
        paramayla.jdField_a_of_type_Boolean = true;
        paramayla.jdField_a_of_type_Ayjl = localayjl;
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "bEffective ");
        return j;
        if ((localayjl instanceof ayij))
        {
          localObject = (ayij)localayjl;
          str = ((ayij)localObject).e();
          i = ((ayij)localObject).e();
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
  
  private static ayjk a(Object paramObject)
  {
    if ((paramObject instanceof ayiz))
    {
      paramObject = (ayiz)paramObject;
      return new ayiz(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof ayiv))
    {
      paramObject = (ayiv)paramObject;
      return new ayiv(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof ayix))
    {
      paramObject = (ayix)paramObject;
      return new ayix(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof ayiu))
    {
      paramObject = (ayiu)paramObject;
      return new ayiu(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    return null;
  }
  
  public static ArrayList a(String paramString, ArrayList<ayla> paramArrayList, List paramList)
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
      localObject2 = (ayla)paramArrayList.get(j);
      k = 0;
      if (k < localArrayList.size())
      {
        if ((localArrayList.get(k) instanceof ayjk))
        {
          int m = a((ayjk)localArrayList.get(k));
          if ((m == 0) || (((ayla)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.businessType != m)) {
            break label465;
          }
          bool = a((ayla)localObject2, (ayjk)localArrayList.get(k));
          label234:
          if (!bool) {}
        }
      }
      else
      {
        if (((ayla)localObject2).jdField_a_of_type_Boolean != true) {
          break label456;
        }
        if ((((ayla)localObject2).jdField_a_of_type_Ayjl instanceof ayjh)) {
          ((ayjh)((ayla)localObject2).jdField_a_of_type_Ayjl).a(((ayla)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        if ((((ayla)localObject2).jdField_a_of_type_Ayjl instanceof ayij)) {
          ((ayij)((ayla)localObject2).jdField_a_of_type_Ayjl).a(((ayla)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        ((ArrayList)localObject1).add(((ayla)localObject2).jdField_a_of_type_Ayjl);
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
        paramString = new ayjb((List)localObject1, paramString);
        localArrayList.add(0, paramString);
        localArrayList.add(0, new ayis(paramString, paramString.a(), false));
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
    } while (!(localObject instanceof ayjb));
    for (paramList = (ayjb)localObject;; paramList = null)
    {
      if (paramList != null)
      {
        paramList = paramList.a();
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (ayjl)paramList.next();
            if ((localObject != null) && ((localObject instanceof ayjq)))
            {
              localObject = (ayjq)localObject;
              if ((localObject != null) && (((ayjq)localObject).a != null))
              {
                localObject = ((ayjq)localObject).a.appId;
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
  
  private static void a(List paramList, int paramInt1, List<ayjl> paramList1, ayii paramayii, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
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
      if (paramayii != null)
      {
        paramayii = new ayii(paramayii.b(), paramayii.jdField_a_of_type_Long, paramayii.a(), paramList1, paramList1.size(), paramayii.d(), paramayii.c(), paramayii.jdField_b_of_type_JavaUtilList, paramayii.jdField_a_of_type_Boolean, paramayii.jdField_b_of_type_Boolean, paramayii.c, paramayii.d, paramayii.e);
        if ((!paramBoolean1) || (paramInt1 == 0)) {
          break label303;
        }
        if (TextUtils.isEmpty(paramayii.d())) {
          break label288;
        }
        paramBoolean1 = true;
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
        paramayii = new ayii();
        paramayii.jdField_a_of_type_JavaUtilList = paramList1;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "oldTitleGroupMode is empty");
        break;
        label288:
        paramBoolean1 = false;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "newModel.getMoreUrl() is empty");
        continue;
        label303:
        paramBoolean1 = false;
      }
      label307:
      break;
      paramList1 = new ayis(paramayii, paramBoolean1, paramayii.jdField_b_of_type_Boolean);
      if (paramBoolean2) {
        paramList1.jdField_b_of_type_Boolean = true;
      }
      paramList.add(i, paramList1);
      return;
    }
  }
  
  public static void a(List paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList5 = a(paramList);
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = null;
    Object localObject1 = null;
    int i = paramList.size() - 1;
    Object localObject5;
    Object localObject3;
    if (i >= 0)
    {
      localObject5 = paramList.get(i);
      if ((localObject5 instanceof ayis))
      {
        localObject3 = ((ayis)localObject5).a();
        if (((localObject3 instanceof ayii)) && (((ayii)localObject3).jdField_a_of_type_Long == 1701L))
        {
          localObject3 = (ayii)localObject3;
          paramList.remove(i);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      label148:
      localObject3 = localObject1;
      Object localObject4 = localObject2;
      for (;;)
      {
        i -= 1;
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if ((!(localObject3 instanceof ayii)) || (((ayii)localObject3).jdField_a_of_type_Long != 1003L)) {
          break label1020;
        }
        localObject3 = (ayii)localObject3;
        paramList.remove(i);
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label148;
        if (((localObject5 instanceof ayit)) && ((((ayit)localObject5).jdField_a_of_type_Long == 1701L) || (((ayit)localObject5).jdField_a_of_type_Long == 1003L)))
        {
          paramList.remove(i);
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
        else if ((localObject5 instanceof aykd))
        {
          localObject5 = (aykd)localObject5;
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (((aykd)localObject5).a != null)
          {
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((aykd)localObject5).a.a != null)
            {
              String str = ((aykd)localObject5).a.a.appId;
              paramList.remove(i);
              localObject4 = localObject1;
              localObject3 = localObject2;
              if (!a(str, localArrayList5)) {
                if (((aykd)localObject5).jdField_b_of_type_Boolean)
                {
                  localArrayList3.add(0, localObject5);
                  localObject4 = localObject1;
                  localObject3 = localObject2;
                }
                else
                {
                  localArrayList4.add(0, localObject5);
                  localObject4 = localObject1;
                  localObject3 = localObject2;
                }
              }
            }
          }
        }
        else
        {
          localObject4 = localObject1;
          localObject3 = localObject2;
          if ((localObject5 instanceof aykk))
          {
            localObject5 = (aykk)localObject5;
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((aykk)localObject5).jdField_a_of_type_Long == 1003L)
            {
              paramList.remove(i);
              if ((a((aykk)localObject5, paramString)) && (localArrayList1.size() == 0))
              {
                ((aykk)localObject5).c = true;
                localArrayList1.add(0, localObject5);
                azmj.b(null, "dc00898", "", "", "0X800AC11", "0X800AC11", 0, 0, "", "", "", "");
                localObject4 = localObject1;
                localObject3 = localObject2;
              }
              else
              {
                localArrayList2.add(0, localObject5);
                localObject4 = localObject1;
                localObject3 = localObject2;
              }
            }
          }
        }
      }
      int k = 0;
      i = 0;
      int j = 0;
      label568:
      if (k < paramList.size())
      {
        localObject3 = paramList.get(k);
        if (!(localObject3 instanceof ayjb)) {
          break label1017;
        }
        j = k + 1;
      }
      label1008:
      label1017:
      for (;;)
      {
        if ((((localObject3 instanceof ayiu)) && (a((ayiu)localObject3, paramString))) || ((((localObject3 instanceof ayjb)) || ((localObject3 instanceof ayiv)) || ((localObject3 instanceof ayix)) || ((localObject3 instanceof ayku))) && (i <= k))) {
          i = k + 1;
        }
        for (;;)
        {
          k += 1;
          break label568;
          if (localArrayList3.size() > 0)
          {
            a(paramList, j, localArrayList3, localObject2, false, a, true);
            j = localArrayList3.size() + i + 1;
            if (paramList.size() >= j)
            {
              QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF MINI");
              i = j;
            }
          }
          for (;;)
          {
            if (localArrayList4.size() > 0) {
              a(paramList, i, localArrayList4, localObject2, true, a, false);
            }
            k = 0;
            i = 0;
            j = 0;
            label762:
            if (k < paramList.size())
            {
              localObject2 = paramList.get(k);
              if ((!(localObject2 instanceof ayjb)) && ((!(localObject2 instanceof aykd)) || (((aykd)localObject2).jdField_b_of_type_Boolean != true)) && ((!(localObject2 instanceof ayiu)) || (!a((ayiu)localObject2, paramString)))) {
                break label1008;
              }
              j = k + 1;
            }
            for (;;)
            {
              if ((((localObject2 instanceof ayiu)) || ((localObject2 instanceof ayjb)) || ((localObject2 instanceof ayiv)) || ((localObject2 instanceof ayix)) || ((localObject2 instanceof ayku)) || ((localObject2 instanceof aykd)) || ((localObject2 instanceof ayiy)) || ((localObject2 instanceof ayhd))) && (i <= k)) {
                i = k + 1;
              }
              for (;;)
              {
                k += 1;
                break label762;
                if (localArrayList1.size() > 0)
                {
                  a(paramList, j, localArrayList1, localObject1, false, a, true);
                  j = localArrayList1.size() + i + 1;
                  if (paramList.size() >= j)
                  {
                    QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF PUBLLIC");
                    i = j;
                  }
                }
                while (localArrayList2.size() > 0)
                {
                  a(paramList, i, localArrayList2, localObject1, true, a, false);
                  return;
                }
                break;
              }
            }
          }
        }
      }
      label1020:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private static boolean a(ayiu paramayiu, String paramString)
  {
    return (paramayiu != null) && (paramayiu.jdField_a_of_type_JavaUtilList != null) && (paramayiu.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramayiu.jdField_a_of_type_JavaUtilList.get(0) instanceof ayij)) && (((ayij)paramayiu.jdField_a_of_type_JavaUtilList.get(0)).c.equals(paramString));
  }
  
  private static boolean a(aykk paramaykk, String paramString)
  {
    if ((paramaykk == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if ((paramaykk.jdField_a_of_type_JavaUtilArrayList != null) && (paramaykk.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramaykk = (aykn)paramaykk.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((paramaykk != null) && (paramaykk.a.toString().equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(ayla paramayla, ayjk paramayjk)
  {
    if (paramayjk == null) {}
    int i;
    do
    {
      return false;
      i = a(paramayla, paramayjk.a());
    } while (i < 0);
    paramayjk.a().remove(i);
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
    ayjk localayjk;
    if ((paramArrayList.get(i) instanceof ayjk))
    {
      localayjk = (ayjk)paramArrayList.get(i);
      if ((localayjk.a() != null) && (localayjk.a().size() == 0)) {
        if ((i - 1 < 0) || (!(paramArrayList.get(i - 1) instanceof ayis)) || (!((ayis)paramArrayList.get(i - 1)).a().equals(localayjk.a()))) {
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
          if ((a(localayjk) != 0) && (i - 1 >= 0) && ((paramArrayList.get(i - 1) instanceof ayis)) && (((ayis)paramArrayList.get(i - 1)).a().equals(localayjk.a())))
          {
            ayis localayis = (ayis)paramArrayList.get(i - 1);
            if ((localayis.a() != null) && (localayjk.a() != null)) {
              if (localayis.a().a() != null) {
                if (localayis.a().a().size() != localayjk.a().size())
                {
                  QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "add new group title");
                  paramArrayList.remove(i - 1);
                  paramArrayList.add(i - 1, new ayis(localayjk));
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
 * Qualified Name:     aylb
 * JD-Core Version:    0.7.0.1
 */