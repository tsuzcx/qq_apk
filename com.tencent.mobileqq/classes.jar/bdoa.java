import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class bdoa
  extends Handler
{
  public bdoa(bdnx parambdnx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bdii.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    bdnz localbdnz;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbdnz = (bdnz)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbdnz == null) {
          bdii.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        bdjr.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        bdjr.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbdnz.jdField_b_of_type_Int != 1) {
          str1 = localbdnz.jdField_b_of_type_JavaLangString.substring(localbdnz.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Bdnw.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbdnz.jdField_b_of_type_JavaLangString;
            continue;
            bdii.e("PCPushProxy", "handleMessage get key = null");
            localbdnz = null;
          }
        }
      } while (localbdnz == null);
      if (localbdnz.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        bdjr.a("100", localbdnz.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bdnw.a(localbdnz);
        return;
        bdjr.a("100", "ANDROIDQQ.PCPUSH." + localbdnz.c, str1);
      }
      this.a.jdField_a_of_type_Bdnw.a(str2);
      return;
    } while (localbdnz == null);
    bdjr.a("500", localbdnz.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdoa
 * JD-Core Version:    0.7.0.1
 */