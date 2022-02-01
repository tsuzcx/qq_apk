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

public class azar
{
  private static final SparseArray<int[]> a = new SparseArray();
  private static final SparseArray<ayzm> b = new SparseArray();
  private static final SparseArray<azap> c = new SparseArray();
  
  static
  {
    a.put(101, ahqr.jdField_a_of_type_ArrayOfInt);
    a.put(105, ahqr.e);
    a.put(102, ahqr.l);
    a.put(103, ahqr.s);
    a.put(106, ahqr.w);
    a.put(104, ahqr.B);
    c.put(201, azap.a(PlusPanel.e, 130201));
    c.put(202, azap.a(PlusPanel.d, 130202));
    c.put(203, azap.a(PlusPanel.E, 130203));
    c.put(204, azap.a(PlusPanel.I, 130204));
    c.put(205, azap.a(PlusPanel.h, 130205));
    c.put(206, azap.a(PlusPanel.i, 130206));
    c.put(207, azap.a(PlusPanel.k, 130207));
    c.put(220, azap.a(PlusPanel.n, 130220));
    c.put(208, azap.a(PlusPanel.y, 130208));
    c.put(209, azap.a(PlusPanel.F, 130209));
    c.put(210, azap.a(PlusPanel.C, 130210));
    c.put(211, azap.a(PlusPanel.s, 130211));
    c.put(212, azap.a(PlusPanel.A, 130212));
    c.put(213, azap.a(PlusPanel.w, 130213));
    c.put(214, azap.a(PlusPanel.t, 130214));
    c.put(215, azap.a(PlusPanel.D, 130215));
    c.put(216, azap.a(PlusPanel.H, 130216));
    c.put(217, azap.a(PlusPanel.b, 130217));
    c.put(218, azap.a(PlusPanel.c, 130218));
    c.put(219, azap.a(PlusPanel.v, 130219));
    c.put(221, azap.a(PlusPanel.p, 130221));
    c.put(222, azap.a(PlusPanel.q, 130222));
  }
  
  private static int a(List<ayzm> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((ayzm)paramList.get(i)).jdField_d_of_type_Int == 5) || (((ayzm)paramList.get(i)).jdField_d_of_type_Int == 6)) {
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
      if (bdch.a())
      {
        localObject = (azam)aqlk.a().a(611);
        if (localObject != null) {
          return ((azam)localObject).a;
        }
      }
      else
      {
        boolean bool = bcnj.b();
        localObject = (azam)aqlk.a().a(495);
        if (localObject != null)
        {
          if (paramBoolean)
          {
            if (bool) {
              return ((azam)localObject).d;
            }
            return ((azam)localObject).c;
          }
          if (bool) {
            return ((azam)localObject).b;
          }
          localObject = ((azam)localObject).a;
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
  
  public static ayzm a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static ayzm a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (ayzm)b.get(paramInt);
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (ayzl)aqlk.a().a(496);
        if (localObject != null)
        {
          List localList = ((ayzl)localObject).a;
          if (localList.size() > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localList.size()) {
                break label133;
              }
              localObject = (ayzm)localList.get(i);
              int[] arrayOfInt = (int[])a.get(((ayzm)localObject).jdField_a_of_type_Int);
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
  
  private static ayzs a(int paramInt)
  {
    return (ayzs)aqlk.a().a(paramInt);
  }
  
  static String a(int paramInt)
  {
    azap localazap = (azap)c.get(paramInt);
    if (localazap != null) {
      return String.valueOf(localazap.jdField_a_of_type_Int);
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
          ayzs localayzs = (ayzs)localArrayList2.get(i);
          if (localayzs.a.appid > 0) {
            localArrayList1.add(localayzs.a);
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
  
  public static List<ayzm> a(boolean paramBoolean, Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (ayzl)aqlk.a().a(496);
        if (localObject != null)
        {
          localObject = ((ayzl)localObject).a;
          if (((List)localObject).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < ((List)localObject).size())
            {
              ayzm localayzm = (ayzm)((List)localObject).get(i);
              arrayOfInt = (int[])a.get(localayzm.jdField_a_of_type_Int);
              if (arrayOfInt != null) {
                break label215;
              }
              b.put(localayzm.jdField_a_of_type_Int, localayzm);
              j = 1;
              if (j == 0) {
                break label220;
              }
              k = localayzm.jdField_a_of_type_Int;
              localayzm.jdField_d_of_type_Int = k;
              localayzm.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localayzm.a();
              localayzm.b = localayzm.b();
              if (j == 0) {
                break label229;
              }
              j = 0;
              localayzm.e = j;
              localayzm.jdField_a_of_type_ArrayOfInt = arrayOfInt;
              localArrayList.add(localayzm);
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
  
  private static void a(List<ayzm> paramList)
  {
    Collections.sort(paramList);
  }
  
  private static void a(List<ayzm> paramList, Context paramContext)
  {
    int i = a(paramList);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PlusPanelUtil", 2, "did not have camera icon");
      }
      return;
    }
    int[] arrayOfInt = ahqr.v;
    ayzm localayzm = new ayzm();
    localayzm.jdField_d_of_type_Int = 6;
    localayzm.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(arrayOfInt[1]);
    localayzm.e = arrayOfInt[3];
    localayzm.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    if (ShortVideoUtils.f())
    {
      localayzm.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localayzm);
      return;
    }
    a.put(103, ahqr.v);
    localayzm.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(ahqr.s[2]);
    paramList.set(i, localayzm);
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
    azap localazap = (azap)c.get(paramInt);
    if (localazap != null) {
      return localazap.jdField_a_of_type_ArrayOfInt;
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
 * Qualified Name:     azar
 * JD-Core Version:    0.7.0.1
 */