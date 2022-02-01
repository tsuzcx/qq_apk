package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Path;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class HalfAlgorithm$TransPathJob
  implements Runnable
{
  private List<PointSet> a;
  private WeakReference<TransPathJobListener> b;
  private int c;
  
  public HalfAlgorithm$TransPathJob(int paramInt, List<PointSet> paramList, TransPathJobListener paramTransPathJobListener)
  {
    this.c = paramList;
    this.a = paramTransPathJobListener;
    Object localObject;
    this.b = new WeakReference(localObject);
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = this.b;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TransPathJob begin:");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(" - ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        localObject1 = ((StringBuilder)localObject1).toString();
        String str = "TransPathJob";
        QLog.d("TransPathJob", 2, (String)localObject1);
        Path localPath2 = new Path();
        localPath2.reset();
        ArrayList localArrayList1 = new ArrayList();
        Path localPath1 = new Path();
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = this.a.iterator();
        localObject1 = null;
        while (localIterator.hasNext())
        {
          Object localObject2 = (PointSet)localIterator.next();
          if (localObject1 != null)
          {
            ((PointSet)localObject2).b((PointSet)localObject1);
            localObject1 = null;
          }
          if (HalfAlgorithm.a(this.this$0, ((PointSet)localObject2).a.a, ((PointSet)localObject2).a.b, ((PointSet)localObject2).a.c, ((PointSet)localObject2).a.d, ((PointSet)localObject2).c.a, ((PointSet)localObject2).c.b, ((PointSet)localObject2).b.a, ((PointSet)localObject2).b.b, ((PointSet)localObject2).b.c, ((PointSet)localObject2).b.d, localPath1, localArrayList2))
          {
            if (localArrayList2.size() > 0)
            {
              localPath2.addPath(localPath1);
              HalfAlgorithm.a(this.this$0, localArrayList1, localArrayList2);
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("TransPathJob segment == 0:");
              ((StringBuilder)localObject2).append(System.currentTimeMillis());
              QLog.d(str, 2, ((StringBuilder)localObject2).toString());
            }
            localPath1.reset();
            localArrayList2.clear();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("TransPathJob no segment:");
            ((StringBuilder)localObject1).append(System.currentTimeMillis());
            QLog.d(str, 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
        localObject1 = (TransPathJobListener)this.b.get();
        if (localObject1 != null)
        {
          int i = this.c;
          boolean bool;
          if (localArrayList1.size() > 0) {
            bool = true;
          } else {
            bool = false;
          }
          ((TransPathJobListener)localObject1).a(i, bool, localPath2, localArrayList1);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TransPathJob end:");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        QLog.d(str, 2, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = (TransPathJobListener)((WeakReference)localObject1).get();
      if (localObject1 != null) {
        ((TransPathJobListener)localObject1).a(this.c, false, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm.TransPathJob
 * JD-Core Version:    0.7.0.1
 */