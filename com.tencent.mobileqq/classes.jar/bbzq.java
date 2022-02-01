import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbcfi;>;

public class bbzq
{
  public static long a;
  public static HashMap<bcfj, bbzr> a;
  public static boolean a;
  public static final HashMap<bcfh, bbzr> b;
  public static boolean b;
  protected static final HashMap<String, Integer> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(bcfh parambcfh)
  {
    if (parambcfh == null) {
      return -1;
    }
    if (c.size() == 0)
    {
      c.put(bcet.class.getSimpleName(), Integer.valueOf(101));
      c.put(bcev.class.getSimpleName(), Integer.valueOf(101));
      c.put(bceu.class.getSimpleName(), Integer.valueOf(101));
      c.put(bcdb.class.getSimpleName(), Integer.valueOf(102));
      c.put(bcew.class.getSimpleName(), Integer.valueOf(102));
      c.put(bmbe.class.getSimpleName(), Integer.valueOf(103));
      c.put(atqq.class.getSimpleName(), Integer.valueOf(104));
      c.put(bces.class.getSimpleName(), Integer.valueOf(105));
      c.put(bcgs.class.getSimpleName(), Integer.valueOf(106));
      c.put(bcfb.class.getSimpleName(), Integer.valueOf(107));
      c.put(bcex.class.getSimpleName(), Integer.valueOf(108));
      c.put(bcez.class.getSimpleName(), Integer.valueOf(109));
    }
    Integer localInteger = (Integer)c.get(parambcfh.getClass().getSimpleName());
    if (localInteger == null) {
      return -1;
    }
    if ((parambcfh instanceof bcgs))
    {
      if (((bcgs)parambcfh).jdField_a_of_type_Int == -1) {
        return localInteger.intValue();
      }
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static List<bcfh> a(List<bcfi> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false, true);
  }
  
  public static List<bcfh> a(List<bcfi> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static List<bcfh> a(List<bcfi> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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
      if ((localObject1 instanceof bceg))
      {
        localObject4 = (bceg)localObject1;
        localObject1 = (Integer)((HashMap)localObject3).get(Long.valueOf(((bceg)localObject4).jdField_a_of_type_Long));
        if (localObject1 == null) {}
        for (localObject1 = Integer.valueOf(1);; localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1))
        {
          ((HashMap)localObject3).put(Long.valueOf(((bceg)localObject4).jdField_a_of_type_Long), localObject1);
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
    paramList = (List<bcfi>)localObject1;
    label271:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof bceg)) {
        break label1026;
      }
      bceg localbceg = (bceg)localObject1;
      if (!TextUtils.isEmpty(paramList)) {
        break label1023;
      }
      paramList = localbceg.b();
      Object localObject5;
      if (paramBoolean3)
      {
        if (!paramBoolean1) {
          break label729;
        }
        if (bcnc.a(localbceg.jdField_a_of_type_Long))
        {
          ((List)localObject3).add(Long.valueOf(localbceg.jdField_a_of_type_Long));
          if (localbceg.a() != null)
          {
            i = 0;
            if (i < localbceg.a().size())
            {
              localObject5 = (bcfj)localbceg.a().get(i);
              bbzr localbbzr = new bbzr();
              localbbzr.jdField_a_of_type_JavaLangString = paramList;
              if ((localObject5 instanceof bcfs))
              {
                localbbzr.jdField_a_of_type_Long = ((bcfs)localObject5).jdField_a_of_type_Long;
                label385:
                localbbzr.jdField_a_of_type_Int = (i + 1);
                localbbzr.jdField_a_of_type_Boolean = false;
                localObject1 = "";
                if (!(localObject5 instanceof bceh)) {
                  break label516;
                }
                localObject1 = ((bceh)localObject5).jdField_b_of_type_JavaLangString;
              }
              for (;;)
              {
                localbbzr.jdField_b_of_type_JavaLangString = ((String)localObject1);
                localbbzr.jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
                jdField_a_of_type_JavaUtilHashMap.put(localObject5, localbbzr);
                if ((localObject5 instanceof bceh)) {
                  ((bceh)localObject5).e = localbceg.c;
                }
                i += 1;
                break;
                if ((localObject5 instanceof bceh))
                {
                  localbbzr.jdField_a_of_type_Long = ((bceh)localObject5).d();
                  break label385;
                }
                localbbzr.jdField_a_of_type_Long = localbceg.jdField_a_of_type_Long;
                break label385;
                label516:
                if ((localObject5 instanceof bcfs)) {
                  localObject1 = ((bcfs)localObject5).d;
                }
              }
            }
          }
        }
        else
        {
          jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
          ((List)localObject4).add(Long.valueOf(localbceg.jdField_a_of_type_Long));
        }
      }
      localObject1 = localbceg.a();
      if (((List)localObject1).size() > 0)
      {
        boolean bool1;
        label590:
        label610:
        label636:
        int j;
        if (!TextUtils.isEmpty(localbceg.d()))
        {
          bool1 = true;
          boolean bool2 = localbceg.jdField_b_of_type_Boolean;
          if (TextUtils.isEmpty(localbceg.d)) {
            break label754;
          }
          paramBoolean2 = true;
          localObject5 = new bceq(localbceg, bool1, bool2);
          if (localbceg.jdField_a_of_type_Boolean) {
            break label759;
          }
          bool1 = true;
          ((bceq)localObject5).a(bool1);
          localArrayList1.add(localObject5);
          j = ((List)localObject1).size();
          i = 0;
          label665:
          if (i >= j) {
            break label847;
          }
          localObject5 = (bcfj)((List)localObject1).get(i);
          if (!(localObject5 instanceof bceh)) {
            break label765;
          }
          localObject5 = (bceh)localObject5;
          bcnf.a((bcfj)localObject5, j, i);
          localArrayList1.add(localObject5);
        }
        for (;;)
        {
          i += 1;
          break label665;
          label729:
          localArrayList2.add(Long.valueOf(localbceg.jdField_a_of_type_Long));
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
          if ((localObject5 instanceof bcfs))
          {
            localObject5 = (bcfs)localObject5;
            bcnf.a((bcfj)localObject5, j, i);
            localArrayList1.add(localObject5);
          }
          else if ((localObject5 instanceof bcgs))
          {
            localArrayList1.add((bcgs)localObject5);
          }
          else if ((localObject5 instanceof bcfj))
          {
            localArrayList1.add(localObject5);
          }
        }
        label847:
        if (!TextUtils.isEmpty(localbceg.d))
        {
          localObject1 = new bcer(localbceg.d, localbceg.e, localbceg.jdField_a_of_type_Long);
          ((bcer)localObject1).a(paramBoolean2);
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
        bcnc.a("all_result", "exp_content", i, 0, new String[] { paramList, bcnc.a((List)localObject4), "", bcnc.a("dynamic_unite_search.1", (List)localObject2) });
        if (localArrayList2.size() > 0) {
          bcnc.a("all_result", "load_content", new String[] { paramList, bcnc.a(localArrayList2), "", bcnc.a("dynamic_unite_search.1", (List)localObject2) });
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
    float f = paramTextView.getResources().getDimensionPixelSize(2131298375) / paramTextView.getResources().getDisplayMetrics().densityDpi * FontSettingManager.systemMetrics.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = (bgls)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if ((localObject != null) && (((bgls)localObject).b(paramString))) {
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
 * Qualified Name:     bbzq
 * JD-Core Version:    0.7.0.1
 */