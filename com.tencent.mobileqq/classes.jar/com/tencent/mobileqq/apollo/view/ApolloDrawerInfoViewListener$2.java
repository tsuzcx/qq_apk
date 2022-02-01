package com.tencent.mobileqq.apollo.view;

import amme;
import anbt;
import ancc;
import anct;
import anmz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class ApolloDrawerInfoViewListener$2
  implements Runnable
{
  public ApolloDrawerInfoViewListener$2(anmz paramanmz, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    Object localObject1;
    try
    {
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangObject == null)) {
        return;
      }
      if (anmz.a(this.this$0).get() == null) {
        return;
      }
      localObject1 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
        return;
      }
      anct localanct = (anct)anmz.a(this.this$0).get();
      localObject2 = localanct.a();
      ancc localancc = localanct.a();
      if ((localObject2 == null) || (localancc == null)) {
        return;
      }
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.equals(localancc.b)) {
          ((anbt)localObject2).a(str, true);
        }
      }
      if (localThrowable.a() == null) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloDrawerInfoViewListener", 1, localThrowable, new Object[0]);
      return;
    }
    Object localObject2 = localThrowable.a().getCurrentUin();
    boolean bool = anmz.a(this.this$0, (String)localObject2, (ArrayList)localObject1);
    QLog.d("ApolloDrawerInfoViewListener", 1, "onApolloDressChange reGetFrame:" + bool);
    if (bool)
    {
      localObject1 = (amme)localThrowable.a().getManager(QQManagerFactory.APOLLO_MANAGER);
      if ((localObject1 != null) && (amme.a(localThrowable.a()) != 2))
      {
        ThreadManager.getSubThreadHandler().post(new ApolloDrawerInfoViewListener.2.1(this, (amme)localObject1));
        ThreadManager.getSubThreadHandler().postDelayed(new ApolloDrawerInfoViewListener.2.2(this, (amme)localObject1), 100L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.2
 * JD-Core Version:    0.7.0.1
 */