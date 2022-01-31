import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Layjk;>;

public class aydw
{
  public static long a;
  public static HashMap<ayjl, aydx> a;
  public static boolean a;
  public static final HashMap<ayjj, aydx> b;
  public static boolean b;
  protected static final HashMap<String, Integer> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(ayjj paramayjj)
  {
    if (paramayjj == null) {
      return -1;
    }
    if (c.size() == 0)
    {
      c.put(ayiv.class.getSimpleName(), Integer.valueOf(101));
      c.put(ayix.class.getSimpleName(), Integer.valueOf(101));
      c.put(ayiw.class.getSimpleName(), Integer.valueOf(101));
      c.put(ayhd.class.getSimpleName(), Integer.valueOf(102));
      c.put(ayiy.class.getSimpleName(), Integer.valueOf(102));
      c.put(biru.class.getSimpleName(), Integer.valueOf(103));
      c.put(aqyn.class.getSimpleName(), Integer.valueOf(104));
      c.put(ayiu.class.getSimpleName(), Integer.valueOf(105));
      c.put(ayku.class.getSimpleName(), Integer.valueOf(106));
      c.put(ayjd.class.getSimpleName(), Integer.valueOf(107));
      c.put(ayiz.class.getSimpleName(), Integer.valueOf(108));
      c.put(ayjb.class.getSimpleName(), Integer.valueOf(109));
    }
    Integer localInteger = (Integer)c.get(paramayjj.getClass().getSimpleName());
    if (localInteger == null) {
      return -1;
    }
    if ((paramayjj instanceof ayku))
    {
      if (((ayku)paramayjj).jdField_a_of_type_Int == -1) {
        return localInteger.intValue();
      }
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static List<ayjj> a(List<ayjk> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false, true);
  }
  
  public static List<ayjj> a(List<ayjk> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static List<ayjj> a(List<ayjk> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null)
    {
      QLog.d("Q.uniteSearch.SearchUtil", 2, "getItemListFromGroupResult  result is null.");
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = new HashMap();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if ((localObject1 instanceof ayii))
      {
        localObject4 = (ayii)localObject1;
        localObject1 = (Integer)((HashMap)localObject3).get(Long.valueOf(((ayii)localObject4).jdField_a_of_type_Long));
        if (localObject1 == null) {}
        for (localObject1 = Integer.valueOf(1);; localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1))
        {
          ((HashMap)localObject3).put(Long.valueOf(((ayii)localObject4).jdField_a_of_type_Long), localObject1);
          break;
        }
      }
    }
    ((HashMap)localObject3).size();
    localObject2 = new ArrayList();
    ((List)localObject2).addAll(((HashMap)localObject3).keySet());
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    jdField_a_of_type_JavaUtilHashMap.clear();
    localObject1 = "";
    Iterator localIterator = paramList.iterator();
    paramList = (List<ayjk>)localObject1;
    label271:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof ayii)) {
        break label1026;
      }
      ayii localayii = (ayii)localObject1;
      if (!TextUtils.isEmpty(paramList)) {
        break label1023;
      }
      paramList = localayii.b();
      Object localObject5;
      if (paramBoolean3)
      {
        if (!paramBoolean1) {
          break label729;
        }
        if (ayrd.a(localayii.jdField_a_of_type_Long))
        {
          ((List)localObject3).add(Long.valueOf(localayii.jdField_a_of_type_Long));
          if (localayii.a() != null)
          {
            i = 0;
            if (i < localayii.a().size())
            {
              localObject5 = (ayjl)localayii.a().get(i);
              aydx localaydx = new aydx();
              localaydx.jdField_a_of_type_JavaLangString = paramList;
              if ((localObject5 instanceof ayju))
              {
                localaydx.jdField_a_of_type_Long = ((ayju)localObject5).jdField_a_of_type_Long;
                label385:
                localaydx.jdField_a_of_type_Int = (i + 1);
                localaydx.jdField_a_of_type_Boolean = false;
                localObject1 = "";
                if (!(localObject5 instanceof ayij)) {
                  break label516;
                }
                localObject1 = ((ayij)localObject5).jdField_b_of_type_JavaLangString;
              }
              for (;;)
              {
                localaydx.jdField_b_of_type_JavaLangString = ((String)localObject1);
                localaydx.jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
                jdField_a_of_type_JavaUtilHashMap.put(localObject5, localaydx);
                if ((localObject5 instanceof ayij)) {
                  ((ayij)localObject5).d = localayii.c;
                }
                i += 1;
                break;
                if ((localObject5 instanceof ayij))
                {
                  localaydx.jdField_a_of_type_Long = ((ayij)localObject5).d();
                  break label385;
                }
                localaydx.jdField_a_of_type_Long = localayii.jdField_a_of_type_Long;
                break label385;
                label516:
                if ((localObject5 instanceof ayju)) {
                  localObject1 = ((ayju)localObject5).d;
                }
              }
            }
          }
        }
        else
        {
          jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
          ((List)localObject4).add(Long.valueOf(localayii.jdField_a_of_type_Long));
        }
      }
      localObject1 = localayii.a();
      if (((List)localObject1).size() > 0)
      {
        boolean bool1;
        label590:
        label610:
        label636:
        int j;
        if (!TextUtils.isEmpty(localayii.d()))
        {
          bool1 = true;
          boolean bool2 = localayii.jdField_b_of_type_Boolean;
          if (TextUtils.isEmpty(localayii.d)) {
            break label754;
          }
          paramBoolean2 = true;
          localObject5 = new ayis(localayii, bool1, bool2);
          if (localayii.jdField_a_of_type_Boolean) {
            break label759;
          }
          bool1 = true;
          ((ayis)localObject5).a(bool1);
          localArrayList1.add(localObject5);
          j = ((List)localObject1).size();
          i = 0;
          label665:
          if (i >= j) {
            break label847;
          }
          localObject5 = (ayjl)((List)localObject1).get(i);
          if (!(localObject5 instanceof ayij)) {
            break label765;
          }
          localObject5 = (ayij)localObject5;
          ayrg.a((ayjl)localObject5, j, i);
          localArrayList1.add(localObject5);
        }
        for (;;)
        {
          i += 1;
          break label665;
          label729:
          localArrayList2.add(Long.valueOf(localayii.jdField_a_of_type_Long));
          break;
          bool1 = false;
          break label590;
          label754:
          paramBoolean2 = false;
          break label610;
          label759:
          bool1 = false;
          break label636;
          label765:
          if ((localObject5 instanceof ayju))
          {
            localObject5 = (ayju)localObject5;
            ayrg.a((ayjl)localObject5, j, i);
            localArrayList1.add(localObject5);
          }
          else if ((localObject5 instanceof ayku))
          {
            localArrayList1.add((ayku)localObject5);
          }
          else if ((localObject5 instanceof ayjl))
          {
            localArrayList1.add(localObject5);
          }
        }
        label847:
        if (!TextUtils.isEmpty(localayii.d))
        {
          localObject1 = new ayit(localayii.d, localayii.e, localayii.jdField_a_of_type_Long);
          ((ayit)localObject1).a(paramBoolean2);
          localArrayList1.add(localObject1);
        }
      }
    }
    label1026:
    for (;;)
    {
      break;
      if (((List)localObject4).size() > 0) {
        if (!jdField_b_of_type_Boolean) {
          break label1017;
        }
      }
      label1017:
      for (i = 2;; i = 1)
      {
        ayrd.a("all_result", "exp_content", i, 0, new String[] { paramList, ayrd.a((List)localObject4), "", ayrd.a("dynamic_unite_search.1", (List)localObject2) });
        if (localArrayList2.size() > 0) {
          ayrd.a("all_result", "load_content", new String[] { paramList, ayrd.a(localArrayList2), "", ayrd.a("dynamic_unite_search.1", (List)localObject2) });
        }
        jdField_a_of_type_Boolean = false;
        return localArrayList1;
      }
      label1023:
      break label271;
    }
  }
  
  public static List<Long> a(long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtil", 2, "clearCache");
    }
  }
  
  public static void a(TextView paramTextView)
  {
    float f = paramTextView.getResources().getDimensionPixelSize(2131298212) / paramTextView.getResources().getDisplayMetrics().densityDpi * alnq.a.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = (bckx)((QQAppInterface)localObject).getManager(203);
      if ((localObject != null) && (((bckx)localObject).b(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public static long[] a(List<Long> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydw
 * JD-Core Version:    0.7.0.1
 */