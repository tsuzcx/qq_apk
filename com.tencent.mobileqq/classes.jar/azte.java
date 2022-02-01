import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class azte
{
  private static final SparseArray<int[]> a = new SparseArray();
  private static final SparseArray<azrz> b = new SparseArray();
  private static final SparseArray<aztc> c = new SparseArray();
  
  static
  {
    a.put(101, aiaf.jdField_a_of_type_ArrayOfInt);
    a.put(105, aiaf.e);
    a.put(102, aiaf.l);
    a.put(103, aiaf.s);
    a.put(106, aiaf.w);
    a.put(104, aiaf.B);
    c.put(201, aztc.a(PlusPanel.e, 130201));
    c.put(202, aztc.a(PlusPanel.d, 130202));
    c.put(203, aztc.a(PlusPanel.E, 130203));
    c.put(204, aztc.a(PlusPanel.I, 130204));
    c.put(205, aztc.a(PlusPanel.h, 130205));
    c.put(206, aztc.a(PlusPanel.i, 130206));
    c.put(207, aztc.a(PlusPanel.k, 130207));
    c.put(220, aztc.a(PlusPanel.n, 130220));
    c.put(208, aztc.a(PlusPanel.y, 130208));
    c.put(209, aztc.a(PlusPanel.F, 130209));
    c.put(210, aztc.a(PlusPanel.C, 130210));
    c.put(211, aztc.a(PlusPanel.s, 130211));
    c.put(212, aztc.a(PlusPanel.A, 130212));
    c.put(213, aztc.a(PlusPanel.w, 130213));
    c.put(214, aztc.a(PlusPanel.t, 130214));
    c.put(215, aztc.a(PlusPanel.D, 130215));
    c.put(216, aztc.a(PlusPanel.H, 130216));
    c.put(217, aztc.a(PlusPanel.b, 130217));
    c.put(218, aztc.a(PlusPanel.c, 130218));
    c.put(219, aztc.a(PlusPanel.v, 130219));
    c.put(221, aztc.a(PlusPanel.p, 130221));
    c.put(222, aztc.a(PlusPanel.q, 130222));
  }
  
  private static int a(List<azrz> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((azrz)paramList.get(i)).jdField_d_of_type_Int == 5) || (((azrz)paramList.get(i)).jdField_d_of_type_Int == 6)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private static SparseIntArray a(boolean paramBoolean)
  {
    try
    {
      Object localObject;
      if (bduy.a())
      {
        localObject = (azsz)aran.a().a(611);
        if (localObject != null) {
          return ((azsz)localObject).a;
        }
      }
      else
      {
        boolean bool = bdgb.b();
        localObject = (azsz)aran.a().a(495);
        if (localObject != null)
        {
          if (paramBoolean)
          {
            if (bool) {
              return ((azsz)localObject).d;
            }
            return ((azsz)localObject).c;
          }
          if (bool) {
            return ((azsz)localObject).b;
          }
          localObject = ((azsz)localObject).a;
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
    }
    return new SparseIntArray();
  }
  
  public static azrz a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static azrz a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (azrz)b.get(paramInt);
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (azry)aran.a().a(496);
        if (localObject != null)
        {
          List localList = ((azry)localObject).a;
          if (localList.size() > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localList.size()) {
                break label133;
              }
              localObject = (azrz)localList.get(i);
              int[] arrayOfInt = (int[])a.get(((azrz)localObject).jdField_a_of_type_Int);
              if (arrayOfInt != null)
              {
                int j = arrayOfInt[0];
                if (paramInt == j) {
                  break;
                }
              }
              i += 1;
            }
          }
        }
        return null;
      }
      catch (Exception localException)
      {
        QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
      }
    }
  }
  
  private static azsf a(int paramInt)
  {
    return (azsf)aran.a().a(paramInt);
  }
  
  static String a(int paramInt)
  {
    aztc localaztc = (aztc)c.get(paramInt);
    if (localaztc != null) {
      return String.valueOf(localaztc.jdField_a_of_type_Int);
    }
    return "";
  }
  
  public static List<TroopAIOAppInfo> a(boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(a(502));
        localArrayList2.add(a(503));
        localArrayList2.add(a(504));
        localArrayList2.add(a(505));
        localArrayList2.add(a(506));
        localArrayList2.add(a(507));
        localArrayList2.add(a(508));
        localArrayList2.add(a(509));
        localArrayList2.add(a(520));
        localArrayList2.add(a(516));
        localArrayList2.add(a(515));
        localArrayList2.add(a(519));
        localArrayList2.add(a(518));
        localArrayList2.add(a(517));
        localArrayList2.add(a(514));
        localArrayList2.add(a(512));
        localArrayList2.add(a(511));
        localArrayList2.add(a(513));
        localArrayList2.add(a(510));
        localArrayList2.add(a(560));
        localArrayList2.add(a(600));
        localArrayList2.add(a(641));
        int j = localArrayList2.size();
        i = 0;
        if (i < j)
        {
          azsf localazsf = (azsf)localArrayList2.get(i);
          if (localazsf.a.appid > 0) {
            localArrayList1.add(localazsf.a);
          }
        }
        else
        {
          a(localArrayList1, paramBoolean);
          return localArrayList1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
        return localArrayList1;
      }
      i += 1;
    }
  }
  
  public static List<azrz> a(boolean paramBoolean, Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (azry)aran.a().a(496);
        if (localObject != null)
        {
          localObject = ((azry)localObject).a;
          if (((List)localObject).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < ((List)localObject).size())
            {
              azrz localazrz = (azrz)((List)localObject).get(i);
              arrayOfInt = (int[])a.get(localazrz.jdField_a_of_type_Int);
              if (arrayOfInt != null) {
                break label215;
              }
              b.put(localazrz.jdField_a_of_type_Int, localazrz);
              j = 1;
              if (j == 0) {
                break label220;
              }
              k = localazrz.jdField_a_of_type_Int;
              localazrz.jdField_d_of_type_Int = k;
              localazrz.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localazrz.a();
              localazrz.b = localazrz.b();
              if (j == 0) {
                break label229;
              }
              j = 0;
              localazrz.e = j;
              localazrz.jdField_a_of_type_ArrayOfInt = arrayOfInt;
              localArrayList.add(localazrz);
              i += 1;
              continue;
            }
            a(localArrayList);
            a(localArrayList, paramContext);
            return localArrayList;
          }
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("PlusPanelUtil", 1, paramContext, new Object[0]);
      }
      return new ArrayList();
      label215:
      int j = 0;
      continue;
      label220:
      int k = arrayOfInt[0];
      continue;
      label229:
      j = arrayOfInt[3];
    }
  }
  
  private static void a(List<azrz> paramList)
  {
    Collections.sort(paramList);
  }
  
  private static void a(List<azrz> paramList, Context paramContext)
  {
    int i = a(paramList);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PlusPanelUtil", 2, "did not have camera icon");
      }
      return;
    }
    int[] arrayOfInt = aiaf.v;
    azrz localazrz = new azrz();
    localazrz.jdField_d_of_type_Int = 6;
    localazrz.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(arrayOfInt[1]);
    localazrz.e = arrayOfInt[3];
    localazrz.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    if (ShortVideoUtils.f())
    {
      localazrz.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localazrz);
      return;
    }
    a.put(103, aiaf.v);
    localazrz.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(aiaf.s[2]);
    paramList.set(i, localazrz);
  }
  
  private static void a(List<TroopAIOAppInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      SparseIntArray localSparseIntArray = a(paramBoolean);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
        int i = localSparseIntArray.get(localTroopAIOAppInfo.appid, -1);
        if (i >= 0) {
          localTroopAIOAppInfo.sort = i;
        } else {
          localIterator.remove();
        }
      }
      Collections.sort(paramList);
    }
  }
  
  public static int[] a(int paramInt)
  {
    aztc localaztc = (aztc)c.get(paramInt);
    if (localaztc != null) {
      return localaztc.jdField_a_of_type_ArrayOfInt;
    }
    return null;
  }
  
  public static int[] b(int paramInt)
  {
    if (a != null) {
      return (int[])a.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azte
 * JD-Core Version:    0.7.0.1
 */