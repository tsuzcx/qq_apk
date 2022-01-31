package com.tencent.biz.common.offline;

import ayxq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mzk;
import mzl;
import mzo;

public final class OfflineExpire$2
  implements Runnable
{
  public OfflineExpire$2(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      QLog.i(mzl.a, 1, "app == null, download wont start");
      return;
    }
    localObject = (ayxq)((QQAppInterface)localObject).getManager(193);
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    label50:
    mzo localmzo;
    String str1;
    String str2;
    String str3;
    if (i < k)
    {
      localmzo = (mzo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      str1 = localmzo.a.a;
      str2 = localmzo.a.c;
      str3 = localmzo.a.b;
      if (!localmzo.a.f) {
        break label197;
      }
    }
    label197:
    for (int j = 1;; j = 2)
    {
      boolean bool = ((ayxq)localObject).a(10066, "app", str1, k - i, str2, str3, j, 0, mzk.a(localmzo.a.a), localmzo);
      QLog.i(mzl.a, 1, "requestPreDownload bid=" + localmzo.a.a + " re=" + bool);
      i += 1;
      break label50;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.2
 * JD-Core Version:    0.7.0.1
 */