package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.util.Pair;
import zzf;
import zzj;

public class SubscribeDraftManager$5
  implements Runnable
{
  public SubscribeDraftManager$5(zzf paramzzf, String paramString1, String paramString2, zzj paramzzj) {}
  
  public void run()
  {
    Object localObject = zzf.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localObject != null)
    {
      localObject = zzf.a(this.this$0, (String)((Pair)localObject).first);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label74;
      }
      if (this.jdField_a_of_type_Zzj != null) {
        this.jdField_a_of_type_Zzj.a(6, true, this.b, new Object[] { localObject });
      }
    }
    label74:
    while (this.jdField_a_of_type_Zzj == null) {
      return;
    }
    this.jdField_a_of_type_Zzj.a(6, false, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.5
 * JD-Core Version:    0.7.0.1
 */