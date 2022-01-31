import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aypk
{
  public static int a = 3;
  
  public static int a(aynt paramaynt)
  {
    int j = 1;
    int i;
    if ((paramaynt instanceof ayni)) {
      i = 2;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while ((paramaynt instanceof ayne));
      i = j;
    } while ((paramaynt instanceof ayng));
    if ((paramaynt instanceof aynd)) {
      return 3;
    }
    return 0;
  }
  
  private static int a(aypj paramaypj, List<aynu> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = 0;
    while (j < paramList.size())
    {
      aynu localaynu = (aynu)paramList.get(j);
      String str = "";
      Object localObject;
      int i;
      if ((localaynu instanceof aynq))
      {
        localObject = (aynq)localaynu;
        if ((((aynq)localObject).a() instanceof String)) {
          str = (String)((aynq)localObject).a();
        }
        i = ((aynq)localObject).e();
      }
      while ((str.equals(paramaypj.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify)) && (i == paramaypj.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identifyType))
      {
        paramaypj.jdField_a_of_type_Boolean = true;
        paramaypj.jdField_a_of_type_Aynu = localaynu;
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "bEffective ");
        return j;
        if ((localaynu instanceof ayms))
        {
          localObject = (ayms)localaynu;
          str = ((ayms)localObject).e();
          i = ((ayms)localObject).e();
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
  
  private static aynt a(Object paramObject)
  {
    if ((paramObject instanceof ayni))
    {
      paramObject = (ayni)paramObject;
      return new ayni(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof ayne))
    {
      paramObject = (ayne)paramObject;
      return new ayne(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof ayng))
    {
      paramObject = (ayng)paramObject;
      return new ayng(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof aynd))
    {
      paramObject = (aynd)paramObject;
      return new aynd(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    return null;
  }
  
  public static ArrayList a(String paramString, ArrayList<aypj> paramArrayList, List paramList)
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
      localObject2 = (aypj)paramArrayList.get(j);
      k = 0;
      if (k < localArrayList.size())
      {
        if ((localArrayList.get(k) instanceof aynt))
        {
          int m = a((aynt)localArrayList.get(k));
          if ((m == 0) || (((aypj)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.businessType != m)) {
            break label465;
          }
          bool = a((aypj)localObject2, (aynt)localArrayList.get(k));
          label234:
          if (!bool) {}
        }
      }
      else
      {
        if (((aypj)localObject2).jdField_a_of_type_Boolean != true) {
          break label456;
        }
        if ((((aypj)localObject2).jdField_a_of_type_Aynu instanceof aynq)) {
          ((aynq)((aypj)localObject2).jdField_a_of_type_Aynu).a(((aypj)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        if ((((aypj)localObject2).jdField_a_of_type_Aynu instanceof ayms)) {
          ((ayms)((aypj)localObject2).jdField_a_of_type_Aynu).a(((aypj)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        ((ArrayList)localObject1).add(((aypj)localObject2).jdField_a_of_type_Aynu);
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
        paramString = new aynk((List)localObject1, paramString);
        localArrayList.add(0, paramString);
        localArrayList.add(0, new aynb(paramString, paramString.a(), false));
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
    } while (!(localObject instanceof aynk));
    for (paramList = (aynk)localObject;; paramList = null)
    {
      if (paramList != null)
      {
        paramList = paramList.a();
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (aynu)paramList.next();
            if ((localObject != null) && ((localObject instanceof aynz)))
            {
              localObject = (aynz)localObject;
              if ((localObject != null) && (((aynz)localObject).a != null))
              {
                localObject = ((aynz)localObject).a.appId;
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
  
  private static void a(List paramList, int paramInt1, List<aynu> paramList1, aymr paramaymr, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
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
      if (paramaymr != null)
      {
        paramaymr = new aymr(paramaymr.b(), paramaymr.jdField_a_of_type_Long, paramaymr.a(), paramList1, paramList1.size(), paramaymr.d(), paramaymr.c(), paramaymr.jdField_b_of_type_JavaUtilList, paramaymr.jdField_a_of_type_Boolean, paramaymr.jdField_b_of_type_Boolean, paramaymr.c, paramaymr.d, paramaymr.e);
        if ((!paramBoolean1) || (paramInt1 == 0)) {
          break label303;
        }
        if (TextUtils.isEmpty(paramaymr.d())) {
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
        paramaymr = new aymr();
        paramaymr.jdField_a_of_type_JavaUtilList = paramList1;
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
      paramList1 = new aynb(paramaymr, paramBoolean1, paramaymr.jdField_b_of_type_Boolean);
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
      if ((localObject5 instanceof aynb))
      {
        localObject3 = ((aynb)localObject5).a();
        if (((localObject3 instanceof aymr)) && (((aymr)localObject3).jdField_a_of_type_Long == 1701L))
        {
          localObject3 = (aymr)localObject3;
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
        if ((!(localObject3 instanceof aymr)) || (((aymr)localObject3).jdField_a_of_type_Long != 1003L)) {
          break label1020;
        }
        localObject3 = (aymr)localObject3;
        paramList.remove(i);
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label148;
        if (((localObject5 instanceof aync)) && ((((aync)localObject5).jdField_a_of_type_Long == 1701L) || (((aync)localObject5).jdField_a_of_type_Long == 1003L)))
        {
          paramList.remove(i);
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
        else if ((localObject5 instanceof ayom))
        {
          localObject5 = (ayom)localObject5;
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (((ayom)localObject5).a != null)
          {
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((ayom)localObject5).a.a != null)
            {
              String str = ((ayom)localObject5).a.a.appId;
              paramList.remove(i);
              localObject4 = localObject1;
              localObject3 = localObject2;
              if (!a(str, localArrayList5)) {
                if (((ayom)localObject5).jdField_b_of_type_Boolean)
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
          if ((localObject5 instanceof ayot))
          {
            localObject5 = (ayot)localObject5;
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((ayot)localObject5).jdField_a_of_type_Long == 1003L)
            {
              paramList.remove(i);
              if ((a((ayot)localObject5, paramString)) && (localArrayList1.size() == 0))
              {
                ((ayot)localObject5).c = true;
                localArrayList1.add(0, localObject5);
                azqs.b(null, "dc00898", "", "", "0X800AC11", "0X800AC11", 0, 0, "", "", "", "");
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
        if (!(localObject3 instanceof aynk)) {
          break label1017;
        }
        j = k + 1;
      }
      label1008:
      label1017:
      for (;;)
      {
        if ((((localObject3 instanceof aynd)) && (a((aynd)localObject3, paramString))) || ((((localObject3 instanceof aynk)) || ((localObject3 instanceof ayne)) || ((localObject3 instanceof ayng)) || ((localObject3 instanceof aypd))) && (i <= k))) {
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
              if ((!(localObject2 instanceof aynk)) && ((!(localObject2 instanceof ayom)) || (((ayom)localObject2).jdField_b_of_type_Boolean != true)) && ((!(localObject2 instanceof aynd)) || (!a((aynd)localObject2, paramString)))) {
                break label1008;
              }
              j = k + 1;
            }
            for (;;)
            {
              if ((((localObject2 instanceof aynd)) || ((localObject2 instanceof aynk)) || ((localObject2 instanceof ayne)) || ((localObject2 instanceof ayng)) || ((localObject2 instanceof aypd)) || ((localObject2 instanceof ayom)) || ((localObject2 instanceof aynh)) || ((localObject2 instanceof aylm))) && (i <= k)) {
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
  
  private static boolean a(aynd paramaynd, String paramString)
  {
    return (paramaynd != null) && (paramaynd.jdField_a_of_type_JavaUtilList != null) && (paramaynd.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramaynd.jdField_a_of_type_JavaUtilList.get(0) instanceof ayms)) && (((ayms)paramaynd.jdField_a_of_type_JavaUtilList.get(0)).c.equals(paramString));
  }
  
  private static boolean a(ayot paramayot, String paramString)
  {
    if ((paramayot == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if ((paramayot.jdField_a_of_type_JavaUtilArrayList != null) && (paramayot.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramayot = (ayow)paramayot.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((paramayot != null) && (paramayot.a.toString().equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(aypj paramaypj, aynt paramaynt)
  {
    if (paramaynt == null) {}
    int i;
    do
    {
      return false;
      i = a(paramaypj, paramaynt.a());
    } while (i < 0);
    paramaynt.a().remove(i);
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
    aynt localaynt;
    if ((paramArrayList.get(i) instanceof aynt))
    {
      localaynt = (aynt)paramArrayList.get(i);
      if ((localaynt.a() != null) && (localaynt.a().size() == 0)) {
        if ((i - 1 < 0) || (!(paramArrayList.get(i - 1) instanceof aynb)) || (!((aynb)paramArrayList.get(i - 1)).a().equals(localaynt.a()))) {
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
          if ((a(localaynt) != 0) && (i - 1 >= 0) && ((paramArrayList.get(i - 1) instanceof aynb)) && (((aynb)paramArrayList.get(i - 1)).a().equals(localaynt.a())))
          {
            aynb localaynb = (aynb)paramArrayList.get(i - 1);
            if ((localaynb.a() != null) && (localaynt.a() != null)) {
              if (localaynb.a().a() != null) {
                if (localaynb.a().a().size() != localaynt.a().size())
                {
                  QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "add new group title");
                  paramArrayList.remove(i - 1);
                  paramArrayList.add(i - 1, new aynb(localaynt));
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
 * Qualified Name:     aypk
 * JD-Core Version:    0.7.0.1
 */