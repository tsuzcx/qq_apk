package com.tencent.mobileqq.activity.qwallet.utils;

import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.ShowInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.lang.ref.WeakReference;

final class QWalletTools$3
  implements Runnable
{
  QWalletTools$3(WeakReference paramWeakReference1, WeakReference paramWeakReference2, int paramInt) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    RedDotImageView localRedDotImageView = (RedDotImageView)this.b.get();
    if ((localObject != null) && (localRedDotImageView != null))
    {
      localObject = (QWalletRedManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_RED_MANAGER);
      QWalletRedManager.ShowInfo localShowInfo = ((QWalletRedManager)localObject).a("2001");
      if ((localShowInfo.a) && (QWalletTools.a(localShowInfo.b, this.jdField_a_of_type_Int)))
      {
        ((QWalletRedManager)localObject).b("2001");
        localRedDotImageView.post(new QWalletTools.3.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.3
 * JD-Core Version:    0.7.0.1
 */