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
  private PointSet a = new PointSet();
  private Path b = null;
  private List<PathDrawer.PathSegment> c = null;
  private Map<Integer, ResultInfo> d = null;
  private int e = 0;
  
  private void a()
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.clear();
    if (this.b == null) {
      this.b = new Path();
    }
    this.b.reset();
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
        l = ((PathDrawer.PathSegment)paramList1.get(paramList1.size() - 1)).d();
        i = ((PathDrawer.PathSegment)paramList1.get(paramList1.size() - 1)).e();
      }
      else
      {
        i = 0;
      }
      if (((PathDrawer.PathSegment)paramList2.get(0)).d() == l)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addjust time and seg :");
        ((StringBuilder)localObject).append(l);
        QLog.d("DoodleAlgorithm", 2, ((StringBuilder)localObject).toString());
        localObject = paramList2.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PathDrawer.PathSegment localPathSegment = (PathDrawer.PathSegment)((Iterator)localObject).next();
          if (localPathSegment.d() != l) {
            break;
          }
          localPathSegment.a(localPathSegment.e() + i + 1);
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
    this.a.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    if (paramList == null) {
      return;
    }
    paramList.clear();
    a();
  }
  
  public void a(int paramInt, boolean paramBoolean, Path paramPath, List<PathDrawer.PathSegment> paramList)
  {
    if (this.d == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onResult :");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(" : ");
      ((StringBuilder)???).append(this.e);
      QLog.d("DoodleAlgorithm", 2, ((StringBuilder)???).toString());
    }
    if (((!paramBoolean) || (paramList == null) || (paramPath == null)) && (QLog.isColorLevel())) {
      QLog.d("DoodleAlgorithm", 2, "onResult error!!");
    }
    synchronized (this.d)
    {
      ResultInfo localResultInfo = new ResultInfo();
      localResultInfo.a = paramInt;
      localResultInfo.c = paramBoolean;
      localResultInfo.b = paramPath;
      localResultInfo.d = paramList;
      this.d.put(Integer.valueOf(paramInt), localResultInfo);
      if (this.d.size() == this.e)
      {
        this.d.notifyAll();
        QLog.d("DoodleAlgorithm", 2, "onResult the last one, notify all");
      }
      return;
    }
  }
  
  public void a(Path paramPath, List<PathDrawer.PathSegment> paramList)
  {
    if (paramList == null)
    {
      this.a.a();
      paramPath.quadTo(this.a.c.a, this.a.c.b, this.a.b.a, this.a.b.b);
      return;
    }
    a();
    this.a.a();
    if (a(this.a.a.a, this.a.a.b, this.a.a.c, this.a.a.d, this.a.c.a, this.a.c.b, this.a.b.a, this.a.b.b, this.a.b.c, this.a.b.d, this.b, this.c))
    {
      if (this.c.size() > 0)
      {
        paramPath.addPath(this.b);
        a(paramList, this.c);
        this.b = null;
        this.c = null;
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
          a(localPointData.a(), localPointData.b(), localPointData.c(), localPointData.d(), paramPath, null);
        }
        else
        {
          b(localPointData.a(), localPointData.b(), localPointData.c(), localPointData.d(), paramPath, null);
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
            a(((PathData.PointData)localObject1).a(), ((PathData.PointData)localObject1).b(), ((PathData.PointData)localObject1).c(), ((PathData.PointData)localObject1).d(), paramPath, paramList1);
            paramInt = 0;
          }
          else
          {
            b(((PathData.PointData)localObject1).a(), ((PathData.PointData)localObject1).b(), ((PathData.PointData)localObject1).c(), ((PathData.PointData)localObject1).d(), paramPath, paramList1);
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
      this.e = 0;
      if (this.d == null) {
        this.d = new TreeMap();
      }
      this.d.clear();
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
          ???.a(((PathData.PointData)localObject2).a(), ((PathData.PointData)localObject2).b(), ((PathData.PointData)localObject2).c(), ((PathData.PointData)localObject2).d());
          paramPath.moveTo(((PathData.PointData)localObject2).a(), ((PathData.PointData)localObject2).b());
        }
        else if (???.b(((PathData.PointData)localObject2).a(), ((PathData.PointData)localObject2).b(), ((PathData.PointData)localObject2).c(), ((PathData.PointData)localObject2).d()))
        {
          localObject2 = ???.a();
          i = this.e + 1;
          this.e = i;
          ThreadManager.post(new HalfAlgorithm.TransPathJob(this, i, (List)localObject2, this), 8, null, true);
        }
      }
      ???.b();
      paramInt = this.e + 1;
      this.e = paramInt;
      ThreadManager.post(new HalfAlgorithm.TransPathJob(this, paramInt, ???.a, this), 8, null, true);
      synchronized (this.d)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("tranpath wait:");
        ((StringBuilder)localObject1).append(this.e);
        ((StringBuilder)localObject1).append(" - ");
        ((StringBuilder)localObject1).append(this.d.size());
        QLog.d("DoodleAlgorithm", 2, ((StringBuilder)localObject1).toString());
        paramInt = this.d.size();
        i = this.e;
        if (paramInt < i) {
          try
          {
            this.d.wait(60000L);
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
        if (this.d.size() == this.e)
        {
          Iterator localIterator = this.d.values().iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (ResultInfo)localIterator.next();
            if (((ResultInfo)localObject2).b != null) {
              paramPath.addPath(((ResultInfo)localObject2).b);
            }
            if (((ResultInfo)localObject2).d != null) {
              a(paramList1, ((ResultInfo)localObject2).d);
            }
          }
          paramPath = new StringBuilder();
          paramPath.append("transPath end :");
          paramPath.append(this.e);
          QLog.d("DoodleAlgorithm", 2, paramPath.toString());
        }
        else if (QLog.isColorLevel())
        {
          paramPath = new StringBuilder();
          paramPath.append("transPath end with error:");
          paramPath.append(this.d.size());
          paramPath.append(" ---");
          paramPath.append(this.e);
          QLog.d("DoodleAlgorithm", 2, paramPath.toString());
        }
        this.d = null;
        this.e = 0;
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
      this.a.a(paramFloat1, paramFloat2, paramFloat3, paramLong, true);
      paramPath.quadTo(this.a.c.a, this.a.c.b, this.a.b.a, this.a.b.b);
      return;
    }
    a();
    boolean bool = a(this.a.b.a, this.a.b.b, this.a.b.c, this.a.b.d, this.a.d.a, this.a.d.b, (this.a.d.a + paramFloat1) / 2.0F, (this.a.d.b + paramFloat2) / 2.0F, (this.a.d.c + paramFloat3) / 2.0F, (this.a.d.d + paramLong) / 2L, this.b, this.c);
    this.a.a(paramFloat1, paramFloat2, paramFloat3, paramLong, bool);
    if (bool)
    {
      if (this.c.size() > 0)
      {
        paramPath.addPath(this.b);
        a(paramList, this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm
 * JD-Core Version:    0.7.0.1
 */