package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import zzf;
import zzj;

public class SubscribeDraftManager$1
  implements Runnable
{
  public SubscribeDraftManager$1(zzf paramzzf, String paramString1, String paramString2, String paramString3, String paramString4, zzj paramzzj) {}
  
  public void run()
  {
    Pair localPair = zzf.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      int i;
      if ((this.this$0.a((String)localPair.first, this.c)) && (this.this$0.a((String)localPair.second, this.d)))
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        if (this.jdField_a_of_type_Zzj != null) {
          this.jdField_a_of_type_Zzj.a(3, true, this.b, new Object[0]);
        }
      }
      label100:
      do
      {
        return;
        i = 0;
        break;
        FileUtils.deleteFile((String)localPair.first);
        FileUtils.deleteFile((String)localPair.second);
      } while (this.jdField_a_of_type_Zzj == null);
      this.jdField_a_of_type_Zzj.a(3, false, this.b, new Object[0]);
      return;
    }
    if (this.jdField_a_of_type_Zzj != null) {
      this.jdField_a_of_type_Zzj.a(3, false, this.b, new Object[0]);
    }
    QLog.d(zzf.jdField_a_of_type_JavaLangString, 4, "modify new draft failed because cat't new folder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.1
 * JD-Core Version:    0.7.0.1
 */