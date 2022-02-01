package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.util.Pair;
import zka;
import zke;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(zka paramzka, String paramString1, String paramString2, zke paramzke) {}
  
  public void run()
  {
    Pair localPair = zka.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      FileUtils.deleteFile((String)localPair.first);
      FileUtils.deleteFile((String)localPair.second);
      if (this.jdField_a_of_type_Zke != null) {
        this.jdField_a_of_type_Zke.a(2, true, this.b, new Object[0]);
      }
    }
    while (this.jdField_a_of_type_Zke == null) {
      return;
    }
    this.jdField_a_of_type_Zke.a(2, false, this.b, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */