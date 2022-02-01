package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Path;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HalfAlgorithm
  extends PathAlgorithm
  implements TransPathJobListener
{
  private int jdField_a_of_type_Int = 0;
  private Path jdField_a_of_type_AndroidGraphicsPath = null;
  private PointSet jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet = new PointSet();
  private List<PathDrawer.PathSegment> jdField_a_of_type_JavaUtilList = null;
  private Map<Integer, ResultInfo> jdField_a_of_type_JavaUtilMap = null;
  
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
  
  private void a(List<PathDrawer.PathSegment> paramList1, List<PathDrawer.PathSegment> paramList2)
  {
    if ((paramList2 != null) && (paramList1 != null))
    {
      if (paramList2.size() == 0) {
        return;
      }
      long l = -1L;
      int i;
      if (paramList1.size() > 0)
      {
        l = ((PathDrawer.PathSegment)paramList1.get(paramList1.size() - 1)).a();
        i = ((PathDrawer.PathSegment)paramList1.get(paramList1.size() - 1)).a();
      }
      else
      {
        i = 0;
      }
      if (((PathDrawer.PathSegment)paramList2.get(0)).a() == l)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addjust time and seg :");
        ((StringBuilder)localObject).append(l);
        QLog.d("DoodleAlgorithm", 2, ((StringBuilder)localObject).toString());
        localObject = paramList2.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PathDrawer.PathSegment localPathSegment = (PathDrawer.PathSegment)((Iterator)localObject).next();
          if (localPathSegment.a() != l) {
            break;
          }
          localPathSegment.a(localPathSegment.a() + i + 1);
        }
      }
      paramList1.addAll(paramList2);
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong1, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, long paramLong2, Path paramPath, List<PathDrawer.PathSegment> paramList)
  {
    paramPath.moveTo(paramFloat1, paramFloat2);
    paramPath.quadTo(paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    return a(paramList, paramPath, paramFloat3, paramFloat8, paramLong1, paramLong2);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<PathDrawer.PathSegment> paramList)
  {
    if (paramPath == null) {
      return;
    }
    paramPath.reset();
    paramPath.moveTo(paramFloat1, paramFloat2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    if (paramList == null) {
      return;
    }
    paramList.clear();
    a();
  }
  
  public void a(int paramInt, boolean paramBoolean, Path paramPath, List<PathDrawer.PathSegment> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onResult :");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(" : ");
      ((StringBuilder)???).append(this.jdField_a_of_type_Int);
      QLog.d("DoodleAlgorithm", 2, ((StringBuilder)???).toString());
    }
    if (((!paramBoolean) || (paramList == null) || (paramPath == null)) && (QLog.isColorLevel())) {
      QLog.d("DoodleAlgorithm", 2, "onResult error!!");
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      ResultInfo localResultInfo = new ResultInfo();
      localResultInfo.jdField_a_of_type_Int = paramInt;
      localResultInfo.jdField_a_of_type_Boolean = paramBoolean;
      localResultInfo.jdField_a_of_type_AndroidGraphicsPath = paramPath;
      localResultInfo.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localResultInfo);
      if (this.jdField_a_of_type_JavaUtilMap.size() == this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilMap.notifyAll();
        QLog.d("DoodleAlgorithm", 2, "onResult the last one, notify all");
      }
      return;
    }
  }
  
  public void a(Path paramPath, List<PathDrawer.PathSegment> paramList)
  {
    if (paramList == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a();
      paramPath.quadTo(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.c.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.c.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.b);
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a();
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.c.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.c.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilList))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramPath.addPath(this.jdField_a_of_type_AndroidGraphicsPath);
        a(paramList, this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_AndroidGraphicsPath = null;
        this.jdField_a_of_type_JavaUtilList = null;
        return;
      }
      paramPath = new StringBuilder();
      paramPath.append("finish segment == 0:");
      paramPath.append(System.currentTimeMillis());
      QLog.d("DoodleAlgorithm", 2, paramPath.toString());
      return;
    }
    paramPath = new StringBuilder();
    paramPath.append("finish failed:");
    paramPath.append(System.currentTimeMillis());
    QLog.d("DoodleAlgorithm", 2, paramPath.toString());
  }
  
  public void a(List<PathData.PointData> paramList, Path paramPath, List<PathDrawer.PathSegment> paramList1)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramPath != null))
    {
      if (paramList1 == null) {
        return;
      }
      QLog.d("DoodleAlgorithm", 2, "patchPath begin:");
      paramList = paramList.iterator();
      int i = 1;
      while (paramList.hasNext())
      {
        PathData.PointData localPointData = (PathData.PointData)paramList.next();
        if (i != 0)
        {
          i = 0;
          a(localPointData.a(), localPointData.b(), localPointData.c(), localPointData.a(), paramPath, null);
        }
        else
        {
          b(localPointData.a(), localPointData.b(), localPointData.c(), localPointData.a(), paramPath, null);
        }
      }
      a(paramPath, null);
      a(paramList1, paramPath);
      paramList = new StringBuilder();
      paramList.append("patchpath end:");
      paramList.append(paramList1.size());
      QLog.d("DoodleAlgorithm", 2, paramList.toString());
    }
  }
  
  public void a(List<PathData.PointData> arg1, Path paramPath, List<PathDrawer.PathSegment> paramList1, int paramInt)
  {
    if ((??? != null) && (???.size() != 0) && (paramPath != null))
    {
      if (paramList1 == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("transPath begin:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("DoodleAlgorithm", 2, ((StringBuilder)localObject1).toString());
      int i;
      if (???.size() > paramInt) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        QLog.d("DoodleAlgorithm", 2, "transPath begin singlethread begin");
        ??? = ???.iterator();
        paramInt = 1;
        while (???.hasNext())
        {
          localObject1 = (PathData.PointData)???.next();
          if (paramInt != 0)
          {
            a(((PathData.PointData)localObject1).a(), ((PathData.PointData)localObject1).b(), ((PathData.PointData)localObject1).c(), ((PathData.PointData)localObject1).a(), paramPath, paramList1);
            paramInt = 0;
          }
          else
          {
            b(((PathData.PointData)localObject1).a(), ((PathData.PointData)localObject1).b(), ((PathData.PointData)localObject1).c(), ((PathData.PointData)localObject1).a(), paramPath, paramList1);
          }
        }
        a(paramPath, paramList1);
        ??? = new StringBuilder();
        ???.append("before merge:");
        ???.append(paramList1.size());
        QLog.d("DoodleAlgorithm", 2, ???.toString());
        a(paramList1, 0);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ???.append("after merge:");
          ???.append(paramList1.size());
          QLog.d("DoodleAlgorithm", 2, ???.toString());
        }
        return;
      }
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
      localObject1 = ???.iterator();
      ??? = null;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PathData.PointData)((Iterator)localObject1).next();
        if (??? == null)
        {
          ??? = new SubPathInfo();
          ???.a(paramInt);
          ???.a(((PathData.PointData)localObject2).a(), ((PathData.PointData)localObject2).b(), ((PathData.PointData)localObject2).c(), ((PathData.PointData)localObject2).a());
          paramPath.moveTo(((PathData.PointData)localObject2).a(), ((PathData.PointData)localObject2).b());
        }
        else if (???.a(((PathData.PointData)localObject2).a(), ((PathData.PointData)localObject2).b(), ((PathData.PointData)localObject2).c(), ((PathData.PointData)localObject2).a()))
        {
          localObject2 = ???.a();
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          ThreadManager.post(new HalfAlgorithm.TransPathJob(this, i, (List)localObject2, this), 8, null, true);
        }
      }
      ???.a();
      paramInt = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = paramInt;
      ThreadManager.post(new HalfAlgorithm.TransPathJob(this, paramInt, ???.jdField_a_of_type_JavaUtilList, this), 8, null, true);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("tranpath wait:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(" - ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilMap.size());
        QLog.d("DoodleAlgorithm", 2, ((StringBuilder)localObject1).toString());
        paramInt = this.jdField_a_of_type_JavaUtilMap.size();
        i = this.jdField_a_of_type_Int;
        if (paramInt < i) {
          try
          {
            this.jdField_a_of_type_JavaUtilMap.wait(60000L);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("transPath exception:");
              ((StringBuilder)localObject2).append(localException);
              QLog.d("DoodleAlgorithm", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        if (this.jdField_a_of_type_JavaUtilMap.size() == this.jdField_a_of_type_Int)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (ResultInfo)localIterator.next();
            if (((ResultInfo)localObject2).jdField_a_of_type_AndroidGraphicsPath != null) {
              paramPath.addPath(((ResultInfo)localObject2).jdField_a_of_type_AndroidGraphicsPath);
            }
            if (((ResultInfo)localObject2).jdField_a_of_type_JavaUtilList != null) {
              a(paramList1, ((ResultInfo)localObject2).jdField_a_of_type_JavaUtilList);
            }
          }
          paramPath = new StringBuilder();
          paramPath.append("transPath end :");
          paramPath.append(this.jdField_a_of_type_Int);
          QLog.d("DoodleAlgorithm", 2, paramPath.toString());
        }
        else if (QLog.isColorLevel())
        {
          paramPath = new StringBuilder();
          paramPath.append("transPath end with error:");
          paramPath.append(this.jdField_a_of_type_JavaUtilMap.size());
          paramPath.append(" ---");
          paramPath.append(this.jdField_a_of_type_Int);
          QLog.d("DoodleAlgorithm", 2, paramPath.toString());
        }
        this.jdField_a_of_type_JavaUtilMap = null;
        this.jdField_a_of_type_Int = 0;
        ??? = new StringBuilder();
        ???.append("before merge:");
        ???.append(paramList1.size());
        QLog.d("DoodleAlgorithm", 2, ???.toString());
        a(paramList1, 0);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ???.append("transPath end:");
          ???.append(paramList1.size());
          QLog.d("DoodleAlgorithm", 2, ???.toString());
        }
        return;
      }
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<PathDrawer.PathSegment> paramList)
  {
    if (paramPath == null) {
      return;
    }
    if (paramList == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a(paramFloat1, paramFloat2, paramFloat3, paramLong, true);
      paramPath.quadTo(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.c.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.c.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.b);
      return;
    }
    a();
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.b.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.d.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.d.b, (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.d.jdField_a_of_type_Float + paramFloat1) / 2.0F, (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.d.b + paramFloat2) / 2.0F, (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.d.c + paramFloat3) / 2.0F, (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.d.jdField_a_of_type_Long + paramLong) / 2L, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePointSet.a(paramFloat1, paramFloat2, paramFloat3, paramLong, bool);
    if (bool)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramPath.addPath(this.jdField_a_of_type_AndroidGraphicsPath);
        a(paramList, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      paramPath = new StringBuilder();
      paramPath.append("addpoint segment == 0:");
      paramPath.append(System.currentTimeMillis());
      QLog.d("DoodleAlgorithm", 2, paramPath.toString());
      return;
    }
    paramPath = new StringBuilder();
    paramPath.append("addpoint failed:");
    paramPath.append(System.currentTimeMillis());
    QLog.d("DoodleAlgorithm", 2, paramPath.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm
 * JD-Core Version:    0.7.0.1
 */