import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class bdnl
  extends Handler
{
  public bdnl(bdni parambdni, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bdht.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    bdnk localbdnk;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbdnk = (bdnk)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbdnk == null) {
          bdht.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        bdjc.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        bdjc.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbdnk.jdField_b_of_type_Int != 1) {
          str1 = localbdnk.jdField_b_of_type_JavaLangString.substring(localbdnk.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Bdnh.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbdnk.jdField_b_of_type_JavaLangString;
            continue;
            bdht.e("PCPushProxy", "handleMessage get key = null");
            localbdnk = null;
          }
        }
      } while (localbdnk == null);
      if (localbdnk.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        bdjc.a("100", localbdnk.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bdnh.a(localbdnk);
        return;
        bdjc.a("100", "ANDROIDQQ.PCPUSH." + localbdnk.c, str1);
      }
      this.a.jdField_a_of_type_Bdnh.a(str2);
      return;
    } while (localbdnk == null);
    bdjc.a("500", localbdnk.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdnl
 * JD-Core Version:    0.7.0.1
 */