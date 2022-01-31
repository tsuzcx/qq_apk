import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class bfrg
  extends Handler
{
  public bfrg(bfrd parambfrd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bflp.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    bfrf localbfrf;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbfrf = (bfrf)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbfrf == null) {
          bflp.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        bfmy.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        bfmy.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbfrf.jdField_b_of_type_Int != 1) {
          str1 = localbfrf.jdField_b_of_type_JavaLangString.substring(localbfrf.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Bfrc.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbfrf.jdField_b_of_type_JavaLangString;
            continue;
            bflp.e("PCPushProxy", "handleMessage get key = null");
            localbfrf = null;
          }
        }
      } while (localbfrf == null);
      if (localbfrf.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        bfmy.a("100", localbfrf.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bfrc.a(localbfrf);
        return;
        bfmy.a("100", "ANDROIDQQ.PCPUSH." + localbfrf.c, str1);
      }
      this.a.jdField_a_of_type_Bfrc.a(str2);
      return;
    } while (localbfrf == null);
    bfmy.a("500", localbfrf.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrg
 * JD-Core Version:    0.7.0.1
 */