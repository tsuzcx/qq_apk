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
import java.util.List<Lbbmx;>;

public class bbhd
{
  public static long a;
  public static HashMap<bbmy, bbhe> a;
  public static boolean a;
  public static final HashMap<bbmw, bbhe> b;
  public static boolean b;
  protected static final HashMap<String, Integer> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(bbmw parambbmw)
  {
    if (parambbmw == null) {
      return -1;
    }
    if (c.size() == 0)
    {
      c.put(bbmi.class.getSimpleName(), Integer.valueOf(101));
      c.put(bbmk.class.getSimpleName(), Integer.valueOf(101));
      c.put(bbmj.class.getSimpleName(), Integer.valueOf(101));
      c.put(bbkq.class.getSimpleName(), Integer.valueOf(102));
      c.put(bbml.class.getSimpleName(), Integer.valueOf(102));
      c.put(blkm.class.getSimpleName(), Integer.valueOf(103));
      c.put(atig.class.getSimpleName(), Integer.valueOf(104));
      c.put(bbmh.class.getSimpleName(), Integer.valueOf(105));
      c.put(bboh.class.getSimpleName(), Integer.valueOf(106));
      c.put(bbmq.class.getSimpleName(), Integer.valueOf(107));
      c.put(bbmm.class.getSimpleName(), Integer.valueOf(108));
      c.put(bbmo.class.getSimpleName(), Integer.valueOf(109));
    }
    Integer localInteger = (Integer)c.get(parambbmw.getClass().getSimpleName());
    if (localInteger == null) {
      return -1;
    }
    if ((parambbmw instanceof bboh))
    {
      if (((bboh)parambbmw).jdField_a_of_type_Int == -1) {
        return localInteger.intValue();
      }
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static List<bbmw> a(List<bbmx> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false, true);
  }
  
  public static List<bbmw> a(List<bbmx> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static List<bbmw> a(List<bbmx> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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
      if ((localObject1 instanceof bblv))
      {
        localObject4 = (bblv)localObject1;
        localObject1 = (Integer)((HashMap)localObject3).get(Long.valueOf(((bblv)localObject4).jdField_a_of_type_Long));
        if (localObject1 == null) {}
        for (localObject1 = Integer.valueOf(1);; localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1))
        {
          ((HashMap)localObject3).put(Long.valueOf(((bblv)localObject4).jdField_a_of_type_Long), localObject1);
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
    paramList = (List<bbmx>)localObject1;
    label271:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof bblv)) {
        break label1026;
      }
      bblv localbblv = (bblv)localObject1;
      if (!TextUtils.isEmpty(paramList)) {
        break label1023;
      }
      paramList = localbblv.b();
      Object localObject5;
      if (paramBoolean3)
      {
        if (!paramBoolean1) {
          break label729;
        }
        if (bbup.a(localbblv.jdField_a_of_type_Long))
        {
          ((List)localObject3).add(Long.valueOf(localbblv.jdField_a_of_type_Long));
          if (localbblv.a() != null)
          {
            i = 0;
            if (i < localbblv.a().size())
            {
              localObject5 = (bbmy)localbblv.a().get(i);
              bbhe localbbhe = new bbhe();
              localbbhe.jdField_a_of_type_JavaLangString = paramList;
              if ((localObject5 instanceof bbnh))
              {
                localbbhe.jdField_a_of_type_Long = ((bbnh)localObject5).jdField_a_of_type_Long;
                label385:
                localbbhe.jdField_a_of_type_Int = (i + 1);
                localbbhe.jdField_a_of_type_Boolean = false;
                localObject1 = "";
                if (!(localObject5 instanceof bblw)) {
                  break label516;
                }
                localObject1 = ((bblw)localObject5).jdField_b_of_type_JavaLangString;
              }
              for (;;)
              {
                localbbhe.jdField_b_of_type_JavaLangString = ((String)localObject1);
                localbbhe.jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
                jdField_a_of_type_JavaUtilHashMap.put(localObject5, localbbhe);
                if ((localObject5 instanceof bblw)) {
                  ((bblw)localObject5).e = localbblv.c;
                }
                i += 1;
                break;
                if ((localObject5 instanceof bblw))
                {
                  localbbhe.jdField_a_of_type_Long = ((bblw)localObject5).d();
                  break label385;
                }
                localbbhe.jdField_a_of_type_Long = localbblv.jdField_a_of_type_Long;
                break label385;
                label516:
                if ((localObject5 instanceof bbnh)) {
                  localObject1 = ((bbnh)localObject5).d;
                }
              }
            }
          }
        }
        else
        {
          jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
          ((List)localObject4).add(Long.valueOf(localbblv.jdField_a_of_type_Long));
        }
      }
      localObject1 = localbblv.a();
      if (((List)localObject1).size() > 0)
      {
        boolean bool1;
        label590:
        label610:
        label636:
        int j;
        if (!TextUtils.isEmpty(localbblv.d()))
        {
          bool1 = true;
          boolean bool2 = localbblv.jdField_b_of_type_Boolean;
          if (TextUtils.isEmpty(localbblv.d)) {
            break label754;
          }
          paramBoolean2 = true;
          localObject5 = new bbmf(localbblv, bool1, bool2);
          if (localbblv.jdField_a_of_type_Boolean) {
            break label759;
          }
          bool1 = true;
          ((bbmf)localObject5).a(bool1);
          localArrayList1.add(localObject5);
          j = ((List)localObject1).size();
          i = 0;
          label665:
          if (i >= j) {
            break label847;
          }
          localObject5 = (bbmy)((List)localObject1).get(i);
          if (!(localObject5 instanceof bblw)) {
            break label765;
          }
          localObject5 = (bblw)localObject5;
          bbus.a((bbmy)localObject5, j, i);
          localArrayList1.add(localObject5);
        }
        for (;;)
        {
          i += 1;
          break label665;
          label729:
          localArrayList2.add(Long.valueOf(localbblv.jdField_a_of_type_Long));
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
          if ((localObject5 instanceof bbnh))
          {
            localObject5 = (bbnh)localObject5;
            bbus.a((bbmy)localObject5, j, i);
            localArrayList1.add(localObject5);
          }
          else if ((localObject5 instanceof bboh))
          {
            localArrayList1.add((bboh)localObject5);
          }
          else if ((localObject5 instanceof bbmy))
          {
            localArrayList1.add(localObject5);
          }
        }
        label847:
        if (!TextUtils.isEmpty(localbblv.d))
        {
          localObject1 = new bbmg(localbblv.d, localbblv.e, localbblv.jdField_a_of_type_Long);
          ((bbmg)localObject1).a(paramBoolean2);
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
        bbup.a("all_result", "exp_content", i, 0, new String[] { paramList, bbup.a((List)localObject4), "", bbup.a("dynamic_unite_search.1", (List)localObject2) });
        if (localArrayList2.size() > 0) {
          bbup.a("all_result", "load_content", new String[] { paramList, bbup.a(localArrayList2), "", bbup.a("dynamic_unite_search.1", (List)localObject2) });
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
    float f = paramTextView.getResources().getDimensionPixelSize(2131298294) / paramTextView.getResources().getDisplayMetrics().densityDpi * anll.a.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = (bftx)((QQAppInterface)localObject).getManager(203);
      if ((localObject != null) && (((bftx)localObject).b(paramString))) {
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
 * Qualified Name:     bbhd
 * JD-Core Version:    0.7.0.1
 */