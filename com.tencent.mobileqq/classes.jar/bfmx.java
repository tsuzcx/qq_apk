import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class bfmx
  extends Handler
{
  public bfmx(bfmu parambfmu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bfhg.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    bfmw localbfmw;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbfmw = (bfmw)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbfmw == null) {
          bfhg.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        bfip.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        bfip.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbfmw.jdField_b_of_type_Int != 1) {
          str1 = localbfmw.jdField_b_of_type_JavaLangString.substring(localbfmw.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Bfmt.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbfmw.jdField_b_of_type_JavaLangString;
            continue;
            bfhg.e("PCPushProxy", "handleMessage get key = null");
            localbfmw = null;
          }
        }
      } while (localbfmw == null);
      if (localbfmw.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        bfip.a("100", localbfmw.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bfmt.a(localbfmw);
        return;
        bfip.a("100", "ANDROIDQQ.PCPUSH." + localbfmw.c, str1);
      }
      this.a.jdField_a_of_type_Bfmt.a(str2);
      return;
    } while (localbfmw == null);
    bfip.a("500", localbfmw.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfmx
 * JD-Core Version:    0.7.0.1
 */