import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class biev
  extends Handler
{
  public biev(bies parambies, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bhzm.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    bieu localbieu;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbieu = (bieu)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbieu == null) {
          bhzm.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        bias.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        bias.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbieu.jdField_b_of_type_Int != 1) {
          str1 = localbieu.jdField_b_of_type_JavaLangString.substring(localbieu.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Bier.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbieu.jdField_b_of_type_JavaLangString;
            continue;
            bhzm.e("PCPushProxy", "handleMessage get key = null");
            localbieu = null;
          }
        }
      } while (localbieu == null);
      if (localbieu.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        bias.a("100", localbieu.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bier.a(localbieu);
        return;
        bias.a("100", "ANDROIDQQ.PCPUSH." + localbieu.c, str1);
      }
      this.a.jdField_a_of_type_Bier.a(str2);
      return;
    } while (localbieu == null);
    bias.a("500", localbieu.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biev
 * JD-Core Version:    0.7.0.1
 */