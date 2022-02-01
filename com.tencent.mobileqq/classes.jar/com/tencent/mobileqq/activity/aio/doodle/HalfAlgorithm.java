package com.tencent.mobileqq.activity.aio.doodle;

import agdk;
import agdm;
import agdr;
import agdv;
import agdw;
import agdx;
import agdz;
import agea;
import android.graphics.Path;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lagdm;>;
import java.util.Map;
import java.util.TreeMap;

public class HalfAlgorithm
  extends agdk
  implements agea
{
  private int jdField_a_of_type_Int;
  private agdw jdField_a_of_type_Agdw = new agdw();
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private List<agdr> jdField_a_of_type_JavaUtilList;
  private Map<Integer, agdx> jdField_a_of_type_JavaUtilMap;
  
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
  
  private void a(List<agdr> paramList1, List<agdr> paramList2)
  {
    if ((paramList2 == null) || (paramList1 == null) || (paramList2.size() == 0)) {
      return;
    }
    long l;
    if (paramList1.size() > 0) {
      l = ((agdr)paramList1.get(paramList1.size() - 1)).a();
    }
    for (int i = ((agdr)paramList1.get(paramList1.size() - 1)).a();; i = 0)
    {
      if (((agdr)paramList2.get(0)).a() == l)
      {
        QLog.d("DoodleAlgorithm", 2, "addjust time and seg :" + l);
        Iterator localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          agdr localagdr = (agdr)localIterator.next();
          if (localagdr.a() != l) {
            break;
          }
          localagdr.a(localagdr.a() + i + 1);
        }
      }
      paramList1.addAll(paramList2);
      return;
      l = -1L;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong1, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, long paramLong2, Path paramPath, List<agdr> paramList)
  {
    paramPath.moveTo(paramFloat1, paramFloat2);
    paramPath.quadTo(paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    return a(paramList, paramPath, paramFloat3, paramFloat8, paramLong1, paramLong2);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<agdr> paramList)
  {
    if (paramPath == null) {}
    do
    {
      return;
      paramPath.reset();
      paramPath.moveTo(paramFloat1, paramFloat2);
      this.jdField_a_of_type_Agdw.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    } while (paramList == null);
    paramList.clear();
    a();
  }
  
  public void a(int paramInt, boolean paramBoolean, Path paramPath, List<agdr> paramList)
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
      agdx localagdx = new agdx();
      localagdx.jdField_a_of_type_Int = paramInt;
      localagdx.jdField_a_of_type_Boolean = paramBoolean;
      localagdx.jdField_a_of_type_AndroidGraphicsPath = paramPath;
      localagdx.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localagdx);
      if (this.jdField_a_of_type_JavaUtilMap.size() == this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilMap.notifyAll();
        QLog.d("DoodleAlgorithm", 2, "onResult the last one, notify all");
      }
      return;
    }
  }
  
  public void a(Path paramPath, List<agdr> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_Agdw.a();
      paramPath.quadTo(this.jdField_a_of_type_Agdw.c.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.c.b, this.jdField_a_of_type_Agdw.b.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.b.b);
      return;
    }
    a();
    this.jdField_a_of_type_Agdw.a();
    if (a(this.jdField_a_of_type_Agdw.a.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.a.b, this.jdField_a_of_type_Agdw.a.c, this.jdField_a_of_type_Agdw.a.jdField_a_of_type_Long, this.jdField_a_of_type_Agdw.c.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.c.b, this.jdField_a_of_type_Agdw.b.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.b.b, this.jdField_a_of_type_Agdw.b.c, this.jdField_a_of_type_Agdw.b.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilList))
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
  
  public void a(List<agdm> paramList, Path paramPath, List<agdr> paramList1)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramPath == null) || (paramList1 == null)) {
      return;
    }
    QLog.d("DoodleAlgorithm", 2, "patchPath begin:");
    paramList = paramList.iterator();
    int i = 1;
    if (paramList.hasNext())
    {
      agdm localagdm = (agdm)paramList.next();
      if (i != 0)
      {
        a(localagdm.a(), localagdm.b(), localagdm.c(), localagdm.a(), paramPath, null);
        i = 0;
      }
      for (;;)
      {
        break;
        b(localagdm.a(), localagdm.b(), localagdm.c(), localagdm.a(), paramPath, null);
      }
    }
    a(paramPath, null);
    a(paramList1, paramPath);
    QLog.d("DoodleAlgorithm", 2, "patchpath end:" + paramList1.size());
  }
  
  public void a(List<agdm> arg1, Path paramPath, List<agdr> paramList1, int paramInt)
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
        localObject1 = (agdm)???.next();
        if (paramInt == 0) {
          break label149;
        }
        a(((agdm)localObject1).a(), ((agdm)localObject1).b(), ((agdm)localObject1).c(), ((agdm)localObject1).a(), paramPath, paramList1);
        paramInt = 0;
      }
      for (;;)
      {
        break label86;
        i = 0;
        break;
        b(((agdm)localObject1).a(), ((agdm)localObject1).b(), ((agdm)localObject1).c(), ((agdm)localObject1).a(), paramPath, paramList1);
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
    ??? = (List<agdm>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (agdm)((Iterator)localObject2).next();
      if (??? == null)
      {
        ??? = new agdz();
        ???.a(paramInt);
        ???.a(((agdm)localObject1).a(), ((agdm)localObject1).b(), ((agdm)localObject1).c(), ((agdm)localObject1).a());
        paramPath.moveTo(((agdm)localObject1).a(), ((agdm)localObject1).b());
      }
      else if (???.a(((agdm)localObject1).a(), ((agdm)localObject1).b(), ((agdm)localObject1).c(), ((agdm)localObject1).a()))
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
          localObject2 = (agdx)((Iterator)localObject1).next();
          if (((agdx)localObject2).jdField_a_of_type_AndroidGraphicsPath != null) {
            paramPath.addPath(((agdx)localObject2).jdField_a_of_type_AndroidGraphicsPath);
          }
          if (((agdx)localObject2).jdField_a_of_type_JavaUtilList != null)
          {
            a(paramList1, ((agdx)localObject2).jdField_a_of_type_JavaUtilList);
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
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<agdr> paramList)
  {
    if (paramPath == null) {
      return;
    }
    if (paramList == null)
    {
      this.jdField_a_of_type_Agdw.a(paramFloat1, paramFloat2, paramFloat3, paramLong, true);
      paramPath.quadTo(this.jdField_a_of_type_Agdw.c.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.c.b, this.jdField_a_of_type_Agdw.b.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.b.b);
      return;
    }
    a();
    boolean bool = a(this.jdField_a_of_type_Agdw.b.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.b.b, this.jdField_a_of_type_Agdw.b.c, this.jdField_a_of_type_Agdw.b.jdField_a_of_type_Long, this.jdField_a_of_type_Agdw.d.jdField_a_of_type_Float, this.jdField_a_of_type_Agdw.d.b, (this.jdField_a_of_type_Agdw.d.jdField_a_of_type_Float + paramFloat1) / 2.0F, (this.jdField_a_of_type_Agdw.d.b + paramFloat2) / 2.0F, (this.jdField_a_of_type_Agdw.d.c + paramFloat3) / 2.0F, (this.jdField_a_of_type_Agdw.d.jdField_a_of_type_Long + paramLong) / 2L, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Agdw.a(paramFloat1, paramFloat2, paramFloat3, paramLong, bool);
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