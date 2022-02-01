package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.qwallet.transaction.NotifyMsgObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class QQWalletTransMsgItemBuilder$2
  extends NotifyMsgObserver
{
  QQWalletTransMsgItemBuilder$2(QQWalletTransMsgItemBuilder paramQQWalletTransMsgItemBuilder) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = QQWalletTransMsgItemBuilder.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNotifyMsg btype:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" bid:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((((INotifyMsgApi)QRoute.api(INotifyMsgApi.class)).isBusinessTypeAAPay(paramInt)) && (!TextUtils.isEmpty(paramString)) && (paramBundle != null))
    {
      localObject1 = (SparseArray)this.a.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localObject1 != null)
      {
        paramInt = 0;
        while (paramInt < ((SparseArray)localObject1).size())
        {
          localObject2 = (WeakReference)((SparseArray)localObject1).valueAt(paramInt);
          paramBundle = null;
          if (localObject2 != null) {
            paramBundle = (QQWalletTransMsgItemBuilder.QWalletTransMsgHolder)((WeakReference)localObject2).get();
          }
          if ((paramBundle != null) && ((paramBundle.a instanceof MessageForQQWalletMsg)))
          {
            localObject2 = (MessageForQQWalletMsg)paramBundle.a;
            if ((localObject2 != null) && (((MessageForQQWalletMsg)localObject2).messageType == 16) && (((MessageForQQWalletMsg)localObject2).mQQWalletTransferMsg != null) && (((MessageForQQWalletMsg)localObject2).mQQWalletTransferMsg.listId != null) && (paramString.equals(((MessageForQQWalletMsg)localObject2).mQQWalletTransferMsg.listId))) {
              this.a.a(paramBundle, (MessageForQQWalletMsg)localObject2, ((MessageForQQWalletMsg)localObject2).mQQWalletTransferMsg.elem);
            }
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletTransMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */