package com.tencent.mobileqq.apollo.sdk;

import akxn;
import akxo;
import akxr;
import akyc;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CmShowViewListener$2
  implements Runnable
{
  public CmShowViewListener$2(akyc paramakyc, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangObject != null))
      {
        if (akyc.a(this.this$0).get() == null) {
          return;
        }
        Object localObject2 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
        if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
        {
          Object localObject1 = (akxn)akyc.a(this.this$0).get();
          akxo localakxo = ((akxn)localObject1).a();
          localObject1 = ((akxn)localObject1).a();
          if ((localakxo != null) && (localObject1 != null))
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              if (str.equals(((akxr)localObject1).b)) {
                localakxo.a(str, true);
              }
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_ApolloDrawerInfoViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowViewListener.2
 * JD-Core Version:    0.7.0.1
 */