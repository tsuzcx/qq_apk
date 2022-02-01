package com.tencent.biz.addContactTroopView;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_search_searchtab.searchtab.RspBody;

public class AddContactTroopHandler$InfoReqObserver
  implements BusinessObserver
{
  protected int a;
  protected WeakReference<AddContactTroopHandler.IGetPopClassAndSearchCB> a;
  protected WeakReference<QQAppInterface> b;
  
  public AddContactTroopHandler$InfoReqObserver(AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIGetPopClassAndSearchCB);
    this.b = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AddContactTroopHandler.IGetPopClassAndSearchCB localIGetPopClassAndSearchCB = (AddContactTroopHandler.IGetPopClassAndSearchCB)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1 = (QQAppInterface)this.b.get();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("InfoReqObserver: type=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", reqType=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(", isSucc=");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", cbIsNull=");
      boolean bool2 = false;
      if (localIGetPopClassAndSearchCB == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", appIsNull=");
      boolean bool1 = bool2;
      if (localObject1 == null) {
        bool1 = true;
      }
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("AddContactTroopHandler", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localIGetPopClassAndSearchCB != null) && (localObject1 != null))
    {
      if ((paramBoolean) && (paramBundle != null)) {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            localObject1 = (AddContactTroopManage)((QQAppInterface)localObject1).getManager(QQManagerFactory.ADDCONTACT_TROOP_SEARCH_POP_MANAGE);
            if (this.jdField_a_of_type_Int == 1)
            {
              localObject2 = new popclassifc.RspBody();
              ((popclassifc.RspBody)localObject2).mergeFrom(paramBundle);
              ((AddContactTroopManage)localObject1).a((popclassifc.RspBody)localObject2);
              localIGetPopClassAndSearchCB.a();
              return;
            }
            if (this.jdField_a_of_type_Int == 2)
            {
              localObject2 = new searchtab.RspBody();
              ((searchtab.RspBody)localObject2).mergeFrom(paramBundle);
              ((AddContactTroopManage)localObject1).a((searchtab.RspBody)localObject2);
              localIGetPopClassAndSearchCB.a();
            }
            return;
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AddContactTroopHandler", 2, "InfoReqObserver exp:", paramBundle);
          }
        }
      }
      localIGetPopClassAndSearchCB.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.AddContactTroopHandler.InfoReqObserver
 * JD-Core Version:    0.7.0.1
 */