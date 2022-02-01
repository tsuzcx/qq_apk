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
import java.util.List<Lbcfq;>;

public class bbzx
{
  public static long a;
  public static HashMap<bcfr, bbzy> a;
  public static boolean a;
  public static final HashMap<bcfp, bbzy> b;
  public static boolean b;
  protected static final HashMap<String, Integer> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(bcfp parambcfp)
  {
    if (parambcfp == null) {
      return -1;
    }
    if (c.size() == 0)
    {
      c.put(bcfb.class.getSimpleName(), Integer.valueOf(101));
      c.put(bcfd.class.getSimpleName(), Integer.valueOf(101));
      c.put(bcfc.class.getSimpleName(), Integer.valueOf(101));
      c.put(bcdj.class.getSimpleName(), Integer.valueOf(102));
      c.put(bcfe.class.getSimpleName(), Integer.valueOf(102));
      c.put(bmlp.class.getSimpleName(), Integer.valueOf(103));
      c.put(auaa.class.getSimpleName(), Integer.valueOf(104));
      c.put(bcfa.class.getSimpleName(), Integer.valueOf(105));
      c.put(bcha.class.getSimpleName(), Integer.valueOf(106));
      c.put(bcfj.class.getSimpleName(), Integer.valueOf(107));
      c.put(bcff.class.getSimpleName(), Integer.valueOf(108));
      c.put(bcfh.class.getSimpleName(), Integer.valueOf(109));
    }
    Integer localInteger = (Integer)c.get(parambcfp.getClass().getSimpleName());
    if (localInteger == null) {
      return -1;
    }
    if ((parambcfp instanceof bcha))
    {
      if (((bcha)parambcfp).jdField_a_of_type_Int == -1) {
        return localInteger.intValue();
      }
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static List<bcfp> a(List<bcfq> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false, true);
  }
  
  public static List<bcfp> a(List<bcfq> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static List<bcfp> a(List<bcfq> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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
      if ((localObject1 instanceof bceo))
      {
        localObject4 = (bceo)localObject1;
        localObject1 = (Integer)((HashMap)localObject3).get(Long.valueOf(((bceo)localObject4).jdField_a_of_type_Long));
        if (localObject1 == null) {}
        for (localObject1 = Integer.valueOf(1);; localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1))
        {
          ((HashMap)localObject3).put(Long.valueOf(((bceo)localObject4).jdField_a_of_type_Long), localObject1);
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
    paramList = (List<bcfq>)localObject1;
    label271:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof bceo)) {
        break label1026;
      }
      bceo localbceo = (bceo)localObject1;
      if (!TextUtils.isEmpty(paramList)) {
        break label1023;
      }
      paramList = localbceo.b();
      Object localObject5;
      if (paramBoolean3)
      {
        if (!paramBoolean1) {
          break label729;
        }
        if (bcni.a(localbceo.jdField_a_of_type_Long))
        {
          ((List)localObject3).add(Long.valueOf(localbceo.jdField_a_of_type_Long));
          if (localbceo.a() != null)
          {
            i = 0;
            if (i < localbceo.a().size())
            {
              localObject5 = (bcfr)localbceo.a().get(i);
              bbzy localbbzy = new bbzy();
              localbbzy.jdField_a_of_type_JavaLangString = paramList;
              if ((localObject5 instanceof bcga))
              {
                localbbzy.jdField_a_of_type_Long = ((bcga)localObject5).jdField_a_of_type_Long;
                label385:
                localbbzy.jdField_a_of_type_Int = (i + 1);
                localbbzy.jdField_a_of_type_Boolean = false;
                localObject1 = "";
                if (!(localObject5 instanceof bcep)) {
                  break label516;
                }
                localObject1 = ((bcep)localObject5).jdField_b_of_type_JavaLangString;
              }
              for (;;)
              {
                localbbzy.jdField_b_of_type_JavaLangString = ((String)localObject1);
                localbbzy.jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
                jdField_a_of_type_JavaUtilHashMap.put(localObject5, localbbzy);
                if ((localObject5 instanceof bcep)) {
                  ((bcep)localObject5).e = localbceo.c;
                }
                i += 1;
                break;
                if ((localObject5 instanceof bcep))
                {
                  localbbzy.jdField_a_of_type_Long = ((bcep)localObject5).d();
                  break label385;
                }
                localbbzy.jdField_a_of_type_Long = localbceo.jdField_a_of_type_Long;
                break label385;
                label516:
                if ((localObject5 instanceof bcga)) {
                  localObject1 = ((bcga)localObject5).d;
                }
              }
            }
          }
        }
        else
        {
          jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
          ((List)localObject4).add(Long.valueOf(localbceo.jdField_a_of_type_Long));
        }
      }
      localObject1 = localbceo.a();
      if (((List)localObject1).size() > 0)
      {
        boolean bool1;
        label590:
        label610:
        label636:
        int j;
        if (!TextUtils.isEmpty(localbceo.d()))
        {
          bool1 = true;
          boolean bool2 = localbceo.jdField_b_of_type_Boolean;
          if (TextUtils.isEmpty(localbceo.d)) {
            break label754;
          }
          paramBoolean2 = true;
          localObject5 = new bcey(localbceo, bool1, bool2);
          if (localbceo.jdField_a_of_type_Boolean) {
            break label759;
          }
          bool1 = true;
          ((bcey)localObject5).a(bool1);
          localArrayList1.add(localObject5);
          j = ((List)localObject1).size();
          i = 0;
          label665:
          if (i >= j) {
            break label847;
          }
          localObject5 = (bcfr)((List)localObject1).get(i);
          if (!(localObject5 instanceof bcep)) {
            break label765;
          }
          localObject5 = (bcep)localObject5;
          bcnl.a((bcfr)localObject5, j, i);
          localArrayList1.add(localObject5);
        }
        for (;;)
        {
          i += 1;
          break label665;
          label729:
          localArrayList2.add(Long.valueOf(localbceo.jdField_a_of_type_Long));
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
          if ((localObject5 instanceof bcga))
          {
            localObject5 = (bcga)localObject5;
            bcnl.a((bcfr)localObject5, j, i);
            localArrayList1.add(localObject5);
          }
          else if ((localObject5 instanceof bcha))
          {
            localArrayList1.add((bcha)localObject5);
          }
          else if ((localObject5 instanceof bcfr))
          {
            localArrayList1.add(localObject5);
          }
        }
        label847:
        if (!TextUtils.isEmpty(localbceo.d))
        {
          localObject1 = new bcez(localbceo.d, localbceo.e, localbceo.jdField_a_of_type_Long);
          ((bcez)localObject1).a(paramBoolean2);
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
        bcni.a("all_result", "exp_content", i, 0, new String[] { paramList, bcni.a((List)localObject4), "", bcni.a("dynamic_unite_search.1", (List)localObject2) });
        if (localArrayList2.size() > 0) {
          bcni.a("all_result", "load_content", new String[] { paramList, bcni.a(localArrayList2), "", bcni.a("dynamic_unite_search.1", (List)localObject2) });
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
    float f = paramTextView.getResources().getDimensionPixelSize(2131298307) / paramTextView.getResources().getDisplayMetrics().densityDpi * anxh.a.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = (bgty)((QQAppInterface)localObject).getManager(203);
      if ((localObject != null) && (((bgty)localObject).b(paramString))) {
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
 * Qualified Name:     bbzx
 * JD-Core Version:    0.7.0.1
 */