package com.tencent.mobileqq.activity.qwallet.utils;

import ahcw;
import ahcy;
import ahiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.lang.ref.WeakReference;

public final class QWalletTools$3
  implements Runnable
{
  public QWalletTools$3(WeakReference paramWeakReference1, WeakReference paramWeakReference2, int paramInt) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    RedDotImageView localRedDotImageView = (RedDotImageView)this.b.get();
    if ((localObject != null) && (localRedDotImageView != null))
    {
      localObject = (ahcw)((QQAppInterface)localObject).getManager(273);
      ahcy localahcy = ((ahcw)localObject).a("2001");
      if ((localahcy.a) && (ahiw.a(localahcy.b, this.jdField_a_of_type_Int)))
      {
        ((ahcw)localObject).b("2001");
        localRedDotImageView.post(new QWalletTools.3.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.3
 * JD-Core Version:    0.7.0.1
 */