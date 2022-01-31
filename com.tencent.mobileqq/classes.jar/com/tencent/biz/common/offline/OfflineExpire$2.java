package com.tencent.biz.common.offline;

import ayxs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mzh;
import mzi;
import mzl;

public final class OfflineExpire$2
  implements Runnable
{
  public OfflineExpire$2(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      QLog.i(mzi.a, 1, "app == null, download wont start");
      return;
    }
    localObject = (ayxs)((QQAppInterface)localObject).getManager(193);
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    label50:
    mzl localmzl;
    String str1;
    String str2;
    String str3;
    if (i < k)
    {
      localmzl = (mzl)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      str1 = localmzl.a.a;
      str2 = localmzl.a.c;
      str3 = localmzl.a.b;
      if (!localmzl.a.f) {
        break label197;
      }
    }
    label197:
    for (int j = 1;; j = 2)
    {
      boolean bool = ((ayxs)localObject).a(10066, "app", str1, k - i, str2, str3, j, 0, mzh.a(localmzl.a.a), localmzl);
      QLog.i(mzi.a, 1, "requestPreDownload bid=" + localmzl.a.a + " re=" + bool);
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