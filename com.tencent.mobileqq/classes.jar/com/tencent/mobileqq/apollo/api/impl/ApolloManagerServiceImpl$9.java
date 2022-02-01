package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ApolloManagerServiceImpl$9
  implements Runnable
{
  ApolloManagerServiceImpl$9(ApolloManagerServiceImpl paramApolloManagerServiceImpl, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = ApolloManagerServiceImpl.access$300(this.this$0);
    if (localObject1 != null)
    {
      localObject2 = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label62;
        }
        localObject1 = ((ApolloDaoManagerServiceImpl)localObject2).getFavNeedDownloadAction();
      }
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label74;
      }
    }
    label62:
    label74:
    do
    {
      return;
      localObject1 = ((ApolloDaoManagerServiceImpl)localObject2).getNeedDownloadAction(this.jdField_a_of_type_Int);
      break;
      localObject2 = new ArrayList();
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        ((List)localObject2).add(((List)localObject1).get(i));
        if (((i + 1) % 8 == 0) || (i + 1 == ((List)localObject1).size()))
        {
          this.this$0.downloadResAndPanel((List)localObject2, this.jdField_a_of_type_Int + "apollo_key" + i);
          ((List)localObject2).clear();
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    Object localObject2 = new StringBuilder("update action[");
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((StringBuilder)localObject2).append(((ApolloActionData)((Iterator)localObject1).next()).actionId).append(",");
    }
    ((StringBuilder)localObject2).append("]");
    QLog.d("ApolloManager", 2, "checkPanelActionRes... action: " + ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */