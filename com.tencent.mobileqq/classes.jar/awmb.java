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

public class awmb
{
  private static final SparseArray<int[]> a = new SparseArray();
  private static final SparseArray<awkx> b = new SparseArray();
  private static final SparseArray<awlz> c = new SparseArray();
  
  static
  {
    a.put(101, aggx.jdField_a_of_type_ArrayOfInt);
    a.put(105, aggx.e);
    a.put(102, aggx.l);
    a.put(103, aggx.s);
    a.put(106, aggx.w);
    a.put(104, aggx.B);
    c.put(201, awlz.a(PlusPanel.e, 130201));
    c.put(202, awlz.a(PlusPanel.d, 130202));
    c.put(203, awlz.a(PlusPanel.C, 130203));
    c.put(204, awlz.a(PlusPanel.G, 130204));
    c.put(205, awlz.a(PlusPanel.h, 130205));
    c.put(206, awlz.a(PlusPanel.i, 130206));
    c.put(207, awlz.a(PlusPanel.k, 130207));
    c.put(220, awlz.a(PlusPanel.n, 130220));
    c.put(208, awlz.a(PlusPanel.w, 130208));
    c.put(209, awlz.a(PlusPanel.D, 130209));
    c.put(210, awlz.a(PlusPanel.A, 130210));
    c.put(211, awlz.a(PlusPanel.q, 130211));
    c.put(212, awlz.a(PlusPanel.y, 130212));
    c.put(213, awlz.a(PlusPanel.u, 130213));
    c.put(214, awlz.a(PlusPanel.r, 130214));
    c.put(215, awlz.a(PlusPanel.B, 130215));
    c.put(216, awlz.a(PlusPanel.F, 130216));
    c.put(217, awlz.a(PlusPanel.b, 130217));
    c.put(218, awlz.a(PlusPanel.c, 130218));
    c.put(219, awlz.a(PlusPanel.t, 130219));
    c.put(221, awlz.a(PlusPanel.p, 130221));
  }
  
  private static int a(List<awkx> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((awkx)paramList.get(i)).jdField_d_of_type_Int == 5) || (((awkx)paramList.get(i)).jdField_d_of_type_Int == 6)) {
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
      if (babd.a())
      {
        localObject = (awlw)aoks.a().a(611);
        if (localObject != null) {
          return ((awlw)localObject).a;
        }
      }
      else
      {
        boolean bool = azmk.b();
        localObject = (awlw)aoks.a().a(495);
        if (localObject != null)
        {
          if (paramBoolean)
          {
            if (bool) {
              return ((awlw)localObject).d;
            }
            return ((awlw)localObject).c;
          }
          if (bool) {
            return ((awlw)localObject).b;
          }
          localObject = ((awlw)localObject).a;
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
  
  public static awkx a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static awkx a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (awkx)b.get(paramInt);
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (awkw)aoks.a().a(496);
        if (localObject != null)
        {
          List localList = ((awkw)localObject).a;
          if (localList.size() > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localList.size()) {
                break label133;
              }
              localObject = (awkx)localList.get(i);
              int[] arrayOfInt = (int[])a.get(((awkx)localObject).jdField_a_of_type_Int);
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
  
  private static awlc a(int paramInt)
  {
    return (awlc)aoks.a().a(paramInt);
  }
  
  static String a(int paramInt)
  {
    awlz localawlz = (awlz)c.get(paramInt);
    if (localawlz != null) {
      return String.valueOf(localawlz.jdField_a_of_type_Int);
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
        int j = localArrayList2.size();
        i = 0;
        if (i < j)
        {
          awlc localawlc = (awlc)localArrayList2.get(i);
          if (localawlc.a.appid > 0) {
            localArrayList1.add(localawlc.a);
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
  
  public static List<awkx> a(boolean paramBoolean, Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (awkw)aoks.a().a(496);
        if (localObject != null)
        {
          localObject = ((awkw)localObject).a;
          if (((List)localObject).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < ((List)localObject).size())
            {
              awkx localawkx = (awkx)((List)localObject).get(i);
              arrayOfInt = (int[])a.get(localawkx.jdField_a_of_type_Int);
              if (arrayOfInt != null) {
                break label215;
              }
              b.put(localawkx.jdField_a_of_type_Int, localawkx);
              j = 1;
              if (j == 0) {
                break label220;
              }
              k = localawkx.jdField_a_of_type_Int;
              localawkx.jdField_d_of_type_Int = k;
              localawkx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localawkx.a();
              localawkx.b = localawkx.b();
              if (j == 0) {
                break label229;
              }
              j = 0;
              localawkx.e = j;
              localawkx.jdField_a_of_type_ArrayOfInt = arrayOfInt;
              localArrayList.add(localawkx);
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
  
  private static void a(List<awkx> paramList)
  {
    Collections.sort(paramList);
  }
  
  private static void a(List<awkx> paramList, Context paramContext)
  {
    int i = a(paramList);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PlusPanelUtil", 2, "did not have camera icon");
      }
      return;
    }
    int[] arrayOfInt = aggx.v;
    awkx localawkx = new awkx();
    localawkx.jdField_d_of_type_Int = 6;
    localawkx.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(arrayOfInt[1]);
    localawkx.e = arrayOfInt[3];
    localawkx.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    if (ShortVideoUtils.f())
    {
      localawkx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localawkx);
      return;
    }
    a.put(103, aggx.v);
    localawkx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(aggx.s[2]);
    paramList.set(i, localawkx);
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
    awlz localawlz = (awlz)c.get(paramInt);
    if (localawlz != null) {
      return localawlz.jdField_a_of_type_ArrayOfInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awmb
 * JD-Core Version:    0.7.0.1
 */