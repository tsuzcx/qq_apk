package com.tencent.av.wtogether;

import android.app.Activity;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.widget.QQToast;

class DavWTogetherObserver$3
  implements Runnable
{
  DavWTogetherObserver$3(DavWTogetherObserver paramDavWTogetherObserver, boolean paramBoolean, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WTogetherUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.DavWTogetherObserver.3
 * JD-Core Version:    0.7.0.1
 */