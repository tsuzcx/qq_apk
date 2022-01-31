package com.tencent.mobileqq.apollo;

import aknx;
import aliw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApolloManager$8
  implements Runnable
{
  public ApolloManager$8(aknx paramaknx, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      localObject2 = (aliw)this.this$0.a.getManager(155);
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label65;
        }
        localObject1 = ((aliw)localObject2).c();
      }
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label77;
      }
    }
    label65:
    label77:
    do
    {
      return;
      localObject1 = ((aliw)localObject2).b(this.jdField_a_of_type_Int);
      break;
      localObject2 = new ArrayList();
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        ((List)localObject2).add(((List)localObject1).get(i));
        if (((i + 1) % 8 == 0) || (i + 1 == ((List)localObject1).size()))
        {
          this.this$0.a((List)localObject2, this.jdField_a_of_type_Int + "apollo_key" + i);
          ((List)localObject2).clear();
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    Object localObject2 = new StringBuilder("update action[");
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject2).append(((ApolloActionData)((Iterator)localObject1).next()).actionId).append(",");
    }
    ((StringBuilder)localObject2).append("]");
    QLog.d("ApolloManager", 2, "checkPanelActionRes... action: " + ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.8
 * JD-Core Version:    0.7.0.1
 */