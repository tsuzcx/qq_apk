import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbaj
{
  public static int a = 3;
  
  public static int a(bays parambays)
  {
    int j = 1;
    int i;
    if ((parambays instanceof bayh)) {
      i = 2;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while ((parambays instanceof bayd));
      i = j;
    } while ((parambays instanceof bayf));
    if ((parambays instanceof bayc)) {
      return 3;
    }
    return 0;
  }
  
  private static int a(bbai parambbai, List<bayt> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = 0;
    while (j < paramList.size())
    {
      bayt localbayt = (bayt)paramList.get(j);
      String str = "";
      Object localObject;
      int i;
      if ((localbayt instanceof bayp))
      {
        localObject = (bayp)localbayt;
        if ((((bayp)localObject).a() instanceof String)) {
          str = (String)((bayp)localObject).a();
        }
        i = ((bayp)localObject).e();
      }
      while ((str.equals(parambbai.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify)) && (i == parambbai.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identifyType))
      {
        parambbai.jdField_a_of_type_Boolean = true;
        parambbai.jdField_a_of_type_Bayt = localbayt;
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "bEffective ");
        return j;
        if ((localbayt instanceof baxr))
        {
          localObject = (baxr)localbayt;
          str = ((baxr)localObject).e();
          i = ((baxr)localObject).e();
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
  
  private static bays a(Object paramObject)
  {
    if ((paramObject instanceof bayh))
    {
      paramObject = (bayh)paramObject;
      return new bayh(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof bayd))
    {
      paramObject = (bayd)paramObject;
      return new bayd(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof bayf))
    {
      paramObject = (bayf)paramObject;
      return new bayf(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof bayc))
    {
      paramObject = (bayc)paramObject;
      return new bayc(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    return null;
  }
  
  public static ArrayList a(String paramString, ArrayList<bbai> paramArrayList, List paramList)
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
      localObject2 = (bbai)paramArrayList.get(j);
      k = 0;
      if (k < localArrayList.size())
      {
        if ((localArrayList.get(k) instanceof bays))
        {
          int m = a((bays)localArrayList.get(k));
          if ((m == 0) || (((bbai)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.businessType != m)) {
            break label465;
          }
          bool = a((bbai)localObject2, (bays)localArrayList.get(k));
          label234:
          if (!bool) {}
        }
      }
      else
      {
        if (((bbai)localObject2).jdField_a_of_type_Boolean != true) {
          break label456;
        }
        if ((((bbai)localObject2).jdField_a_of_type_Bayt instanceof bayp)) {
          ((bayp)((bbai)localObject2).jdField_a_of_type_Bayt).a(((bbai)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        if ((((bbai)localObject2).jdField_a_of_type_Bayt instanceof baxr)) {
          ((baxr)((bbai)localObject2).jdField_a_of_type_Bayt).a(((bbai)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        ((ArrayList)localObject1).add(((bbai)localObject2).jdField_a_of_type_Bayt);
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
        paramString = new bayj((List)localObject1, paramString);
        localArrayList.add(0, paramString);
        localArrayList.add(0, new baya(paramString, paramString.a(), false));
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
    } while (!(localObject instanceof bayj));
    for (paramList = (bayj)localObject;; paramList = null)
    {
      if (paramList != null)
      {
        paramList = paramList.a();
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (bayt)paramList.next();
            if ((localObject != null) && ((localObject instanceof bayy)))
            {
              localObject = (bayy)localObject;
              if ((localObject != null) && (((bayy)localObject).a != null))
              {
                localObject = ((bayy)localObject).a.appId;
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
  
  private static void a(List paramList, int paramInt1, List<bayt> paramList1, baxq parambaxq, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
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
      if (parambaxq != null)
      {
        parambaxq = new baxq(parambaxq.b(), parambaxq.jdField_a_of_type_Long, parambaxq.a(), paramList1, paramList1.size(), parambaxq.d(), parambaxq.c(), parambaxq.jdField_b_of_type_JavaUtilList, parambaxq.jdField_a_of_type_Boolean, parambaxq.jdField_b_of_type_Boolean, parambaxq.c, parambaxq.d, parambaxq.e);
        if ((!paramBoolean1) || (paramInt1 == 0)) {
          break label303;
        }
        if (TextUtils.isEmpty(parambaxq.d())) {
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
        parambaxq = new baxq();
        parambaxq.jdField_a_of_type_JavaUtilList = paramList1;
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
      paramList1 = new baya(parambaxq, paramBoolean1, parambaxq.jdField_b_of_type_Boolean);
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
      if ((localObject5 instanceof baya))
      {
        localObject3 = ((baya)localObject5).a();
        if (((localObject3 instanceof baxq)) && (((baxq)localObject3).jdField_a_of_type_Long == 1701L))
        {
          localObject3 = (baxq)localObject3;
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
        if ((!(localObject3 instanceof baxq)) || (((baxq)localObject3).jdField_a_of_type_Long != 1003L)) {
          break label1020;
        }
        localObject3 = (baxq)localObject3;
        paramList.remove(i);
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label148;
        if (((localObject5 instanceof bayb)) && ((((bayb)localObject5).jdField_a_of_type_Long == 1701L) || (((bayb)localObject5).jdField_a_of_type_Long == 1003L)))
        {
          paramList.remove(i);
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
        else if ((localObject5 instanceof bazl))
        {
          localObject5 = (bazl)localObject5;
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (((bazl)localObject5).a != null)
          {
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((bazl)localObject5).a.a != null)
            {
              String str = ((bazl)localObject5).a.a.appId;
              paramList.remove(i);
              localObject4 = localObject1;
              localObject3 = localObject2;
              if (!a(str, localArrayList5)) {
                if (((bazl)localObject5).jdField_b_of_type_Boolean)
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
          if ((localObject5 instanceof bazs))
          {
            localObject5 = (bazs)localObject5;
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((bazs)localObject5).jdField_a_of_type_Long == 1003L)
            {
              paramList.remove(i);
              if ((a((bazs)localObject5, paramString)) && (localArrayList1.size() == 0))
              {
                ((bazs)localObject5).c = true;
                localArrayList1.add(0, localObject5);
                bcef.b(null, "dc00898", "", "", "0X800AC11", "0X800AC11", 0, 0, "", "", "", "");
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
        if (!(localObject3 instanceof bayj)) {
          break label1017;
        }
        j = k + 1;
      }
      label1008:
      label1017:
      for (;;)
      {
        if ((((localObject3 instanceof bayc)) && (a((bayc)localObject3, paramString))) || ((((localObject3 instanceof bayj)) || ((localObject3 instanceof bayd)) || ((localObject3 instanceof bayf)) || ((localObject3 instanceof bbac))) && (i <= k))) {
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
              if ((!(localObject2 instanceof bayj)) && ((!(localObject2 instanceof bazl)) || (((bazl)localObject2).jdField_b_of_type_Boolean != true)) && ((!(localObject2 instanceof bayc)) || (!a((bayc)localObject2, paramString)))) {
                break label1008;
              }
              j = k + 1;
            }
            for (;;)
            {
              if ((((localObject2 instanceof bayc)) || ((localObject2 instanceof bayj)) || ((localObject2 instanceof bayd)) || ((localObject2 instanceof bayf)) || ((localObject2 instanceof bbac)) || ((localObject2 instanceof bazl)) || ((localObject2 instanceof bayg)) || ((localObject2 instanceof bawl))) && (i <= k)) {
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
  
  private static boolean a(bayc parambayc, String paramString)
  {
    return (parambayc != null) && (parambayc.jdField_a_of_type_JavaUtilList != null) && (parambayc.jdField_a_of_type_JavaUtilList.size() > 0) && ((parambayc.jdField_a_of_type_JavaUtilList.get(0) instanceof baxr)) && (((baxr)parambayc.jdField_a_of_type_JavaUtilList.get(0)).c.equals(paramString));
  }
  
  private static boolean a(bazs parambazs, String paramString)
  {
    if ((parambazs == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if ((parambazs.jdField_a_of_type_JavaUtilArrayList != null) && (parambazs.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      parambazs = (bazv)parambazs.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((parambazs != null) && (parambazs.a.toString().equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(bbai parambbai, bays parambays)
  {
    if (parambays == null) {}
    int i;
    do
    {
      return false;
      i = a(parambbai, parambays.a());
    } while (i < 0);
    parambays.a().remove(i);
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
    bays localbays;
    if ((paramArrayList.get(i) instanceof bays))
    {
      localbays = (bays)paramArrayList.get(i);
      if ((localbays.a() != null) && (localbays.a().size() == 0)) {
        if ((i - 1 < 0) || (!(paramArrayList.get(i - 1) instanceof baya)) || (!((baya)paramArrayList.get(i - 1)).a().equals(localbays.a()))) {
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
          if ((a(localbays) != 0) && (i - 1 >= 0) && ((paramArrayList.get(i - 1) instanceof baya)) && (((baya)paramArrayList.get(i - 1)).a().equals(localbays.a())))
          {
            baya localbaya = (baya)paramArrayList.get(i - 1);
            if ((localbaya.a() != null) && (localbays.a() != null)) {
              if (localbaya.a().a() != null) {
                if (localbaya.a().a().size() != localbays.a().size())
                {
                  QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "add new group title");
                  paramArrayList.remove(i - 1);
                  paramArrayList.add(i - 1, new baya(localbays));
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
 * Qualified Name:     bbaj
 * JD-Core Version:    0.7.0.1
 */