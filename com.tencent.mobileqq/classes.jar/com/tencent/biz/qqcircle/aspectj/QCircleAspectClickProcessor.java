package com.tencent.biz.qqcircle.aspectj;

import com.tencent.biz.qqcircle.fragments.QCircleNewPolymerizeDetailFragment;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class QCircleAspectClickProcessor
{
  static
  {
    try
    {
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      b = localThrowable;
    }
  }
  
  public static QCircleAspectClickProcessor a()
  {
    QCircleAspectClickProcessor localQCircleAspectClickProcessor = a;
    if (localQCircleAspectClickProcessor != null) {
      return localQCircleAspectClickProcessor;
    }
    throw new NoAspectBoundException("com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor", b);
  }
  
  private Object a(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() != null) && (paramObject.getClass().getEnclosingClass() != null))
    {
      if (paramObject.getClass().getEnclosingClass().isMemberClass()) {
        try
        {
          localObject = paramObject.getClass().getDeclaredField("this$1");
          ((Field)localObject).setAccessible(true);
          paramObject = b(((Field)localObject).get(paramObject));
          return paramObject;
        }
        catch (Exception paramObject)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getOuterObject error");
          ((StringBuilder)localObject).append(paramObject.getMessage());
          QLog.d("QCircleAspectClickProcessor", 1, ((StringBuilder)localObject).toString());
          paramObject.printStackTrace();
          return null;
        }
      }
      return b(paramObject);
    }
    QLog.e("QCircleAspectClickProcessor", 1, "getOuterObject target is null");
    return null;
  }
  
  private Object b(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("QCircleAspectClickProcessor", 1, "getDirectOuterObject target is null");
      return null;
    }
    try
    {
      localObject = paramObject.getClass().getDeclaredField("this$0");
      ((Field)localObject).setAccessible(true);
      paramObject = ((Field)localObject).get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDirectOuterObject error");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      QLog.d("QCircleAspectClickProcessor", 1, ((StringBuilder)localObject).toString());
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private boolean c(Object paramObject)
  {
    if ((paramObject instanceof QCircleBaseFeedChildPresenter))
    {
      paramObject = (QCircleBaseFeedChildPresenter)paramObject;
      if ((paramObject.getParentView() != null) && ((paramObject.getParentView().getQCircleBaseFragment() instanceof QCircleNewPolymerizeDetailFragment))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor
 * JD-Core Version:    0.7.0.1
 */