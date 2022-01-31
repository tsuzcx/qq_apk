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

public class awhs
{
  private static final SparseArray<int[]> a = new SparseArray();
  private static final SparseArray<awgo> b = new SparseArray();
  private static final SparseArray<awhq> c = new SparseArray();
  
  static
  {
    a.put(101, agci.jdField_a_of_type_ArrayOfInt);
    a.put(105, agci.e);
    a.put(102, agci.l);
    a.put(103, agci.s);
    a.put(106, agci.w);
    a.put(104, agci.B);
    c.put(201, awhq.a(PlusPanel.e, 130201));
    c.put(202, awhq.a(PlusPanel.d, 130202));
    c.put(203, awhq.a(PlusPanel.C, 130203));
    c.put(204, awhq.a(PlusPanel.G, 130204));
    c.put(205, awhq.a(PlusPanel.h, 130205));
    c.put(206, awhq.a(PlusPanel.i, 130206));
    c.put(207, awhq.a(PlusPanel.k, 130207));
    c.put(220, awhq.a(PlusPanel.n, 130220));
    c.put(208, awhq.a(PlusPanel.w, 130208));
    c.put(209, awhq.a(PlusPanel.D, 130209));
    c.put(210, awhq.a(PlusPanel.A, 130210));
    c.put(211, awhq.a(PlusPanel.q, 130211));
    c.put(212, awhq.a(PlusPanel.y, 130212));
    c.put(213, awhq.a(PlusPanel.u, 130213));
    c.put(214, awhq.a(PlusPanel.r, 130214));
    c.put(215, awhq.a(PlusPanel.B, 130215));
    c.put(216, awhq.a(PlusPanel.F, 130216));
    c.put(217, awhq.a(PlusPanel.b, 130217));
    c.put(218, awhq.a(PlusPanel.c, 130218));
    c.put(219, awhq.a(PlusPanel.t, 130219));
    c.put(221, awhq.a(PlusPanel.p, 130221));
  }
  
  private static int a(List<awgo> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((awgo)paramList.get(i)).jdField_d_of_type_Int == 5) || (((awgo)paramList.get(i)).jdField_d_of_type_Int == 6)) {
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
      if (azwu.a())
      {
        localObject = (awhn)aogj.a().a(611);
        if (localObject != null) {
          return ((awhn)localObject).a;
        }
      }
      else
      {
        boolean bool = azib.b();
        localObject = (awhn)aogj.a().a(495);
        if (localObject != null)
        {
          if (paramBoolean)
          {
            if (bool) {
              return ((awhn)localObject).d;
            }
            return ((awhn)localObject).c;
          }
          if (bool) {
            return ((awhn)localObject).b;
          }
          localObject = ((awhn)localObject).a;
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
  
  public static awgo a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static awgo a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (awgo)b.get(paramInt);
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (awgn)aogj.a().a(496);
        if (localObject != null)
        {
          List localList = ((awgn)localObject).a;
          if (localList.size() > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localList.size()) {
                break label133;
              }
              localObject = (awgo)localList.get(i);
              int[] arrayOfInt = (int[])a.get(((awgo)localObject).jdField_a_of_type_Int);
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
  
  private static awgt a(int paramInt)
  {
    return (awgt)aogj.a().a(paramInt);
  }
  
  static String a(int paramInt)
  {
    awhq localawhq = (awhq)c.get(paramInt);
    if (localawhq != null) {
      return String.valueOf(localawhq.jdField_a_of_type_Int);
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
          awgt localawgt = (awgt)localArrayList2.get(i);
          if (localawgt.a.appid > 0) {
            localArrayList1.add(localawgt.a);
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
  
  public static List<awgo> a(boolean paramBoolean, Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (awgn)aogj.a().a(496);
        if (localObject != null)
        {
          localObject = ((awgn)localObject).a;
          if (((List)localObject).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < ((List)localObject).size())
            {
              awgo localawgo = (awgo)((List)localObject).get(i);
              arrayOfInt = (int[])a.get(localawgo.jdField_a_of_type_Int);
              if (arrayOfInt != null) {
                break label215;
              }
              b.put(localawgo.jdField_a_of_type_Int, localawgo);
              j = 1;
              if (j == 0) {
                break label220;
              }
              k = localawgo.jdField_a_of_type_Int;
              localawgo.jdField_d_of_type_Int = k;
              localawgo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localawgo.a();
              localawgo.b = localawgo.b();
              if (j == 0) {
                break label229;
              }
              j = 0;
              localawgo.e = j;
              localawgo.jdField_a_of_type_ArrayOfInt = arrayOfInt;
              localArrayList.add(localawgo);
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
  
  private static void a(List<awgo> paramList)
  {
    Collections.sort(paramList);
  }
  
  private static void a(List<awgo> paramList, Context paramContext)
  {
    int i = a(paramList);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PlusPanelUtil", 2, "did not have camera icon");
      }
      return;
    }
    int[] arrayOfInt = agci.v;
    awgo localawgo = new awgo();
    localawgo.jdField_d_of_type_Int = 6;
    localawgo.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(arrayOfInt[1]);
    localawgo.e = arrayOfInt[3];
    localawgo.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    if (ShortVideoUtils.f())
    {
      localawgo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localawgo);
      return;
    }
    a.put(103, agci.v);
    localawgo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(agci.s[2]);
    paramList.set(i, localawgo);
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
    awhq localawhq = (awhq)c.get(paramInt);
    if (localawhq != null) {
      return localawhq.jdField_a_of_type_ArrayOfInt;
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
 * Qualified Name:     awhs
 * JD-Core Version:    0.7.0.1
 */