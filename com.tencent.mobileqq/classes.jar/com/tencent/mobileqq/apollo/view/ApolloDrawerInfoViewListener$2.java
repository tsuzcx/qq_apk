package com.tencent.mobileqq.apollo.view;

import akwc;
import akwl;
import akxc;
import algm;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ApolloDrawerInfoViewListener$2
  implements Runnable
{
  public ApolloDrawerInfoViewListener$2(algm paramalgm, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangObject != null))
      {
        if (algm.a(this.this$0).get() == null) {
          return;
        }
        Object localObject2 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
        if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
        {
          Object localObject1 = (akxc)algm.a(this.this$0).get();
          akwc localakwc = ((akxc)localObject1).a();
          localObject1 = ((akxc)localObject1).a();
          if ((localakwc != null) && (localObject1 != null))
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              if (str.equals(((akwl)localObject1).b)) {
                localakwc.a(str, true);
              }
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloDrawerInfoViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.2
 * JD-Core Version:    0.7.0.1
 */