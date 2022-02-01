package com.tencent.mobileqq.activity.aio.doodle;

import aghl;
import aghn;
import aghs;
import aghw;
import aghx;
import aghy;
import agia;
import agib;
import android.graphics.Path;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Laghn;>;
import java.util.Map;
import java.util.TreeMap;

public class HalfAlgorithm
  extends aghl
  implements agib
{
  private int jdField_a_of_type_Int;
  private aghx jdField_a_of_type_Aghx = new aghx();
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private List<aghs> jdField_a_of_type_JavaUtilList;
  private Map<Integer, aghy> jdField_a_of_type_JavaUtilMap;
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
  }
  
  private void a(List<aghs> paramList1, List<aghs> paramList2)
  {
    if ((paramList2 == null) || (paramList1 == null) || (paramList2.size() == 0)) {
      return;
    }
    long l;
    if (paramList1.size() > 0) {
      l = ((aghs)paramList1.get(paramList1.size() - 1)).a();
    }
    for (int i = ((aghs)paramList1.get(paramList1.size() - 1)).a();; i = 0)
    {
      if (((aghs)paramList2.get(0)).a() == l)
      {
        QLog.d("DoodleAlgorithm", 2, "addjust time and seg :" + l);
        Iterator localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          aghs localaghs = (aghs)localIterator.next();
          if (localaghs.a() != l) {
            break;
          }
          localaghs.a(localaghs.a() + i + 1);
        }
      }
      paramList1.addAll(paramList2);
      return;
      l = -1L;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong1, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, long paramLong2, Path paramPath, List<aghs> paramList)
  {
    paramPath.moveTo(paramFloat1, paramFloat2);
    paramPath.quadTo(paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    return a(paramList, paramPath, paramFloat3, paramFloat8, paramLong1, paramLong2);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<aghs> paramList)
  {
    if (paramPath == null) {}
    do
    {
      return;
      paramPath.reset();
      paramPath.moveTo(paramFloat1, paramFloat2);
      this.jdField_a_of_type_Aghx.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    } while (paramList == null);
    paramList.clear();
    a();
  }
  
  public void a(int paramInt, boolean paramBoolean, Path paramPath, List<aghs> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleAlgorithm", 2, "onResult :" + paramInt + " : " + this.jdField_a_of_type_Int);
    }
    if (((!paramBoolean) || (paramList == null) || (paramPath == null)) && (QLog.isColorLevel())) {
      QLog.d("DoodleAlgorithm", 2, "onResult error!!");
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      aghy localaghy = new aghy();
      localaghy.jdField_a_of_type_Int = paramInt;
      localaghy.jdField_a_of_type_Boolean = paramBoolean;
      localaghy.jdField_a_of_type_AndroidGraphicsPath = paramPath;
      localaghy.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localaghy);
      if (this.jdField_a_of_type_JavaUtilMap.size() == this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilMap.notifyAll();
        QLog.d("DoodleAlgorithm", 2, "onResult the last one, notify all");
      }
      return;
    }
  }
  
  public void a(Path paramPath, List<aghs> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_Aghx.a();
      paramPath.quadTo(this.jdField_a_of_type_Aghx.c.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.c.b, this.jdField_a_of_type_Aghx.b.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.b.b);
      return;
    }
    a();
    this.jdField_a_of_type_Aghx.a();
    if (a(this.jdField_a_of_type_Aghx.a.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.a.b, this.jdField_a_of_type_Aghx.a.c, this.jdField_a_of_type_Aghx.a.jdField_a_of_type_Long, this.jdField_a_of_type_Aghx.c.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.c.b, this.jdField_a_of_type_Aghx.b.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.b.b, this.jdField_a_of_type_Aghx.b.c, this.jdField_a_of_type_Aghx.b.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilList))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramPath.addPath(this.jdField_a_of_type_AndroidGraphicsPath);
        a(paramList, this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_AndroidGraphicsPath = null;
        this.jdField_a_of_type_JavaUtilList = null;
        return;
      }
      QLog.d("DoodleAlgorithm", 2, "finish segment == 0:" + System.currentTimeMillis());
      return;
    }
    QLog.d("DoodleAlgorithm", 2, "finish failed:" + System.currentTimeMillis());
  }
  
  public void a(List<aghn> paramList, Path paramPath, List<aghs> paramList1)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramPath == null) || (paramList1 == null)) {
      return;
    }
    QLog.d("DoodleAlgorithm", 2, "patchPath begin:");
    paramList = paramList.iterator();
    int i = 1;
    if (paramList.hasNext())
    {
      aghn localaghn = (aghn)paramList.next();
      if (i != 0)
      {
        a(localaghn.a(), localaghn.b(), localaghn.c(), localaghn.a(), paramPath, null);
        i = 0;
      }
      for (;;)
      {
        break;
        b(localaghn.a(), localaghn.b(), localaghn.c(), localaghn.a(), paramPath, null);
      }
    }
    a(paramPath, null);
    a(paramList1, paramPath);
    QLog.d("DoodleAlgorithm", 2, "patchpath end:" + paramList1.size());
  }
  
  public void a(List<aghn> arg1, Path paramPath, List<aghs> paramList1, int paramInt)
  {
    if ((??? == null) || (???.size() == 0) || (paramPath == null) || (paramList1 == null)) {}
    int i;
    label86:
    do
    {
      return;
      QLog.d("DoodleAlgorithm", 2, "transPath begin:" + System.currentTimeMillis());
      if (???.size() > paramInt)
      {
        i = 1;
        if (i != 0) {
          break;
        }
        QLog.d("DoodleAlgorithm", 2, "transPath begin singlethread begin");
        ??? = ???.iterator();
        paramInt = 1;
        if (!???.hasNext()) {
          break label178;
        }
        localObject1 = (aghn)???.next();
        if (paramInt == 0) {
          break label149;
        }
        a(((aghn)localObject1).a(), ((aghn)localObject1).b(), ((aghn)localObject1).c(), ((aghn)localObject1).a(), paramPath, paramList1);
        paramInt = 0;
      }
      for (;;)
      {
        break label86;
        i = 0;
        break;
        b(((aghn)localObject1).a(), ((aghn)localObject1).b(), ((aghn)localObject1).c(), ((aghn)localObject1).a(), paramPath, paramList1);
      }
      a(paramPath, paramList1);
      QLog.d("DoodleAlgorithm", 2, "before merge:" + paramList1.size());
      a(paramList1, 0);
    } while (!QLog.isColorLevel());
    label149:
    label178:
    QLog.d("DoodleAlgorithm", 2, "after merge:" + paramList1.size());
    return;
    Object localObject1 = null;
    paramPath.reset();
    if (paramList1 != null) {
      paramList1.clear();
    }
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new TreeMap();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    QLog.d("DoodleAlgorithm", 2, "transPath begin multithread begin");
    Object localObject2 = ???.iterator();
    ??? = (List<aghn>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (aghn)((Iterator)localObject2).next();
      if (??? == null)
      {
        ??? = new agia();
        ???.a(paramInt);
        ???.a(((aghn)localObject1).a(), ((aghn)localObject1).b(), ((aghn)localObject1).c(), ((aghn)localObject1).a());
        paramPath.moveTo(((aghn)localObject1).a(), ((aghn)localObject1).b());
      }
      else if (???.a(((aghn)localObject1).a(), ((aghn)localObject1).b(), ((aghn)localObject1).c(), ((aghn)localObject1).a()))
      {
        localObject1 = ???.a();
        i = this.jdField_a_of_type_Int + 1;
        this.jdField_a_of_type_Int = i;
        ThreadManager.post(new HalfAlgorithm.TransPathJob(this, i, (List)localObject1, this), 8, null, true);
      }
    }
    ???.a();
    paramInt = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = paramInt;
    ThreadManager.post(new HalfAlgorithm.TransPathJob(this, paramInt, ???.jdField_a_of_type_JavaUtilList, this), 8, null, true);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      QLog.d("DoodleAlgorithm", 2, "tranpath wait:" + this.jdField_a_of_type_Int + " - " + this.jdField_a_of_type_JavaUtilMap.size());
      paramInt = this.jdField_a_of_type_JavaUtilMap.size();
      i = this.jdField_a_of_type_Int;
      if (paramInt >= i) {}
    }
    try
    {
      this.jdField_a_of_type_JavaUtilMap.wait(60000L);
      if (this.jdField_a_of_type_JavaUtilMap.size() == this.jdField_a_of_type_Int)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (aghy)((Iterator)localObject1).next();
          if (((aghy)localObject2).jdField_a_of_type_AndroidGraphicsPath != null) {
            paramPath.addPath(((aghy)localObject2).jdField_a_of_type_AndroidGraphicsPath);
          }
          if (((aghy)localObject2).jdField_a_of_type_JavaUtilList != null)
          {
            a(paramList1, ((aghy)localObject2).jdField_a_of_type_JavaUtilList);
            continue;
            paramPath = finally;
            throw paramPath;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleAlgorithm", 2, "transPath exception:" + localException);
        }
      }
      QLog.d("DoodleAlgorithm", 2, "transPath end :" + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap = null;
      this.jdField_a_of_type_Int = 0;
      QLog.d("DoodleAlgorithm", 2, "before merge:" + paramList1.size());
      a(paramList1, 0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DoodleAlgorithm", 2, "transPath end:" + paramList1.size());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoodleAlgorithm", 2, "transPath end with error:" + this.jdField_a_of_type_JavaUtilMap.size() + " ---" + this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<aghs> paramList)
  {
    if (paramPath == null) {
      return;
    }
    if (paramList == null)
    {
      this.jdField_a_of_type_Aghx.a(paramFloat1, paramFloat2, paramFloat3, paramLong, true);
      paramPath.quadTo(this.jdField_a_of_type_Aghx.c.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.c.b, this.jdField_a_of_type_Aghx.b.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.b.b);
      return;
    }
    a();
    boolean bool = a(this.jdField_a_of_type_Aghx.b.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.b.b, this.jdField_a_of_type_Aghx.b.c, this.jdField_a_of_type_Aghx.b.jdField_a_of_type_Long, this.jdField_a_of_type_Aghx.d.jdField_a_of_type_Float, this.jdField_a_of_type_Aghx.d.b, (this.jdField_a_of_type_Aghx.d.jdField_a_of_type_Float + paramFloat1) / 2.0F, (this.jdField_a_of_type_Aghx.d.b + paramFloat2) / 2.0F, (this.jdField_a_of_type_Aghx.d.c + paramFloat3) / 2.0F, (this.jdField_a_of_type_Aghx.d.jdField_a_of_type_Long + paramLong) / 2L, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Aghx.a(paramFloat1, paramFloat2, paramFloat3, paramLong, bool);
    if (bool)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramPath.addPath(this.jdField_a_of_type_AndroidGraphicsPath);
        a(paramList, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      QLog.d("DoodleAlgorithm", 2, "addpoint segment == 0:" + System.currentTimeMillis());
      return;
    }
    QLog.d("DoodleAlgorithm", 2, "addpoint failed:" + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm
 * JD-Core Version:    0.7.0.1
 */