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

public class auqg
{
  private static final SparseArray<int[]> a = new SparseArray();
  private static final SparseArray<aupg> b = new SparseArray();
  private static final SparseArray<auqf> c = new SparseArray();
  
  static
  {
    a.put(101, aeft.jdField_a_of_type_ArrayOfInt);
    a.put(105, aeft.e);
    a.put(102, aeft.l);
    a.put(103, aeft.s);
    a.put(106, aeft.w);
    a.put(104, aeft.B);
    c.put(201, auqf.a(PlusPanel.e, 130201));
    c.put(202, auqf.a(PlusPanel.d, 130202));
    c.put(203, auqf.a(PlusPanel.A, 130203));
    c.put(204, auqf.a(PlusPanel.E, 130204));
    c.put(205, auqf.a(PlusPanel.h, 130205));
    c.put(206, auqf.a(PlusPanel.i, 130206));
    c.put(207, auqf.a(PlusPanel.k, 130207));
    c.put(220, auqf.a(PlusPanel.n, 130220));
    c.put(208, auqf.a(PlusPanel.u, 130208));
    c.put(209, auqf.a(PlusPanel.B, 130209));
    c.put(210, auqf.a(PlusPanel.y, 130210));
    c.put(211, auqf.a(PlusPanel.o, 130211));
    c.put(212, auqf.a(PlusPanel.w, 130212));
    c.put(213, auqf.a(PlusPanel.s, 130213));
    c.put(214, auqf.a(PlusPanel.p, 130214));
    c.put(215, auqf.a(PlusPanel.z, 130215));
    c.put(216, auqf.a(PlusPanel.D, 130216));
    c.put(217, auqf.a(PlusPanel.b, 130217));
    c.put(218, auqf.a(PlusPanel.c, 130218));
    c.put(219, auqf.a(PlusPanel.r, 130219));
  }
  
  private static int a(List<aupg> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((aupg)paramList.get(i)).jdField_d_of_type_Int == 5) || (((aupg)paramList.get(i)).jdField_d_of_type_Int == 6)) {
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
      boolean bool = axmv.b();
      Object localObject = (auqe)ampl.a().a(495);
      if (localObject != null)
      {
        if (paramBoolean)
        {
          if (bool) {
            return ((auqe)localObject).d;
          }
          return ((auqe)localObject).c;
        }
        if (bool) {
          return ((auqe)localObject).b;
        }
        localObject = ((auqe)localObject).a;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("PlusPanelUtil", 1, localException, new Object[0]);
    }
    return new SparseIntArray();
  }
  
  public static aupg a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public static aupg a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (aupg)b.get(paramInt);
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (aupf)ampl.a().a(496);
        if (localObject != null)
        {
          List localList = ((aupf)localObject).a;
          if (localList.size() > 0)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localList.size()) {
                break label133;
              }
              localObject = (aupg)localList.get(i);
              int[] arrayOfInt = (int[])a.get(((aupg)localObject).jdField_a_of_type_Int);
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
  
  private static aupl a(int paramInt)
  {
    return (aupl)ampl.a().a(paramInt);
  }
  
  static String a(int paramInt)
  {
    auqf localauqf = (auqf)c.get(paramInt);
    if (localauqf != null) {
      return String.valueOf(localauqf.jdField_a_of_type_Int);
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
        int j = localArrayList2.size();
        i = 0;
        if (i < j)
        {
          aupl localaupl = (aupl)localArrayList2.get(i);
          if (localaupl.a.appid > 0) {
            localArrayList1.add(localaupl.a);
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
  
  public static List<aupg> a(boolean paramBoolean, Context paramContext)
  {
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        Object localObject = (aupf)ampl.a().a(496);
        if (localObject != null)
        {
          localObject = ((aupf)localObject).a;
          if (((List)localObject).size() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < ((List)localObject).size())
            {
              aupg localaupg = (aupg)((List)localObject).get(i);
              arrayOfInt = (int[])a.get(localaupg.jdField_a_of_type_Int);
              if (arrayOfInt != null) {
                break label215;
              }
              b.put(localaupg.jdField_a_of_type_Int, localaupg);
              j = 1;
              if (j == 0) {
                break label220;
              }
              k = localaupg.jdField_a_of_type_Int;
              localaupg.jdField_d_of_type_Int = k;
              localaupg.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localaupg.a();
              localaupg.b = localaupg.b();
              if (j == 0) {
                break label229;
              }
              j = 0;
              localaupg.e = j;
              localaupg.jdField_a_of_type_ArrayOfInt = arrayOfInt;
              localArrayList.add(localaupg);
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
  
  private static void a(List<aupg> paramList)
  {
    Collections.sort(paramList);
  }
  
  private static void a(List<aupg> paramList, Context paramContext)
  {
    int i = a(paramList);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PlusPanelUtil", 2, "did not have camera icon");
      }
      return;
    }
    int[] arrayOfInt = aeft.v;
    aupg localaupg = new aupg();
    localaupg.jdField_d_of_type_Int = 6;
    localaupg.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(arrayOfInt[1]);
    localaupg.e = arrayOfInt[3];
    localaupg.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    if (ShortVideoUtils.f())
    {
      localaupg.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(arrayOfInt[2]);
      paramList.add(i, localaupg);
      return;
    }
    a.put(103, aeft.v);
    localaupg.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(aeft.s[2]);
    paramList.set(i, localaupg);
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
    auqf localauqf = (auqf)c.get(paramInt);
    if (localauqf != null) {
      return localauqf.jdField_a_of_type_ArrayOfInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auqg
 * JD-Core Version:    0.7.0.1
 */