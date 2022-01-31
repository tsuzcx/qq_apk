package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.util.Pair;
import see;
import wsw;
import wta;

public class SubscribeDraftManager$3
  implements Runnable
{
  public void run()
  {
    Object localObject = wsw.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localObject != null)
    {
      localObject = wsw.a(this.this$0, (String)((Pair)localObject).second);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label90;
      }
      localObject = (SubscribeDraftBean)see.a().a((String)localObject, SubscribeDraftBean.class);
      if ((localObject != null) && (this.jdField_a_of_type_Wta != null)) {
        this.jdField_a_of_type_Wta.a(5, true, this.b, new Object[] { localObject });
      }
    }
    label90:
    while (this.jdField_a_of_type_Wta == null) {
      return;
    }
    this.jdField_a_of_type_Wta.a(5, false, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.3
 * JD-Core Version:    0.7.0.1
 */