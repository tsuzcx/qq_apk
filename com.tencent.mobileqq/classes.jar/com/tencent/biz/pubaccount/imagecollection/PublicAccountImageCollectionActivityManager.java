package com.tencent.biz.pubaccount.imagecollection;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

public class PublicAccountImageCollectionActivityManager
{
  private static String a = "PublicAccountImageCollectionActivityManager";
  private static Stack<Activity> b;
  private static PublicAccountImageCollectionActivityManager c;
  private static int d = 3;
  
  public static PublicAccountImageCollectionActivityManager a()
  {
    if (c == null) {
      c = new PublicAccountImageCollectionActivityManager();
    }
    return c;
  }
  
  private void d()
  {
    Activity localActivity = (Activity)b.firstElement();
    if (localActivity != null)
    {
      localActivity.finish();
      b.remove(localActivity);
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (b == null) {
      b = new Stack();
    }
    b.add(paramActivity);
  }
  
  public void b()
  {
    Stack localStack = b;
    if ((localStack != null) && (localStack.size() > d))
    {
      int j = b.size();
      int k = d;
      int i = 0;
      while (i < j - k)
      {
        d();
        i += 1;
      }
    }
  }
  
  public void b(Activity paramActivity)
  {
    Stack localStack = b;
    if ((localStack != null) && (paramActivity != null)) {
      localStack.remove(paramActivity);
    }
  }
  
  public int c()
  {
    Object localObject = b;
    if (localObject != null)
    {
      int i = ((Stack)localObject).size();
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getActivityStackNum = ");
        localStringBuilder.append(i);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionActivityManager
 * JD-Core Version:    0.7.0.1
 */