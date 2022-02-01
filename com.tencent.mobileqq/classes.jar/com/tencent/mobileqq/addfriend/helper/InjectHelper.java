package com.tencent.mobileqq.addfriend.helper;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.processor.BaseAddFriendProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.relationx.addFrd.processor.ExtendFriendAddFriendProcessor;
import com.tencent.mobileqq.relationx.addFrd.processor.KplAddFriendProcessor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public class InjectHelper
{
  @ConfigInject(configPath="Business/qqaddfriend-impl/src/main/resources/Inject_AddFriendBusinessProcessor.yml", version=1)
  public static ArrayList<Class<? extends BaseAddFriendProcessor>> a;
  private static final ArrayList<BaseAddFriendProcessor> c = new ArrayList();
  private volatile boolean b = false;
  
  static
  {
    a = new ArrayList();
    a.add(KplAddFriendProcessor.class);
    a.add(ExtendFriendAddFriendProcessor.class);
  }
  
  private void b(AppInterface paramAppInterface)
  {
    c.clear();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Class)localIterator.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initBusinessProcessors| ");
        localStringBuilder.append(((Class)localObject1).getName());
        QLog.d("AddFrd.InjectHelper", 2, localStringBuilder.toString());
      }
      Object localObject2;
      try
      {
        localObject1 = (BaseAddFriendProcessor)((Class)localObject1).getConstructor(new Class[] { AppInterface.class }).newInstance(new Object[] { paramAppInterface });
      }
      catch (Exception localException)
      {
        QLog.d("AddFrd.InjectHelper", 1, "initBusinessProcessors fail.", localException);
        localObject2 = null;
      }
      if (localObject2 != null) {
        c.add(localObject2);
      }
    }
  }
  
  public ArrayList<BaseAddFriendProcessor> a(AppInterface paramAppInterface)
  {
    if (!this.b)
    {
      b(paramAppInterface);
      this.b = true;
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.helper.InjectHelper
 * JD-Core Version:    0.7.0.1
 */