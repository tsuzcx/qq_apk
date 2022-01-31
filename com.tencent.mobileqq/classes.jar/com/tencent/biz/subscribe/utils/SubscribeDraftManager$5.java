package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.util.Pair;
import wsw;
import wta;

public class SubscribeDraftManager$5
  implements Runnable
{
  public SubscribeDraftManager$5(wsw paramwsw, String paramString1, String paramString2, wta paramwta) {}
  
  public void run()
  {
    Object localObject = wsw.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localObject != null)
    {
      localObject = wsw.a(this.this$0, (String)((Pair)localObject).first);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label74;
      }
      if (this.jdField_a_of_type_Wta != null) {
        this.jdField_a_of_type_Wta.a(6, true, this.b, new Object[] { localObject });
      }
    }
    label74:
    while (this.jdField_a_of_type_Wta == null) {
      return;
    }
    this.jdField_a_of_type_Wta.a(6, false, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.5
 * JD-Core Version:    0.7.0.1
 */