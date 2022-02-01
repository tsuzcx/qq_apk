import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class bjpx
  extends Handler
{
  public bjpx(bjpu parambjpu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bjko.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    bjpw localbjpw;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbjpw = (bjpw)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbjpw == null) {
          bjko.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        bjlu.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        bjlu.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbjpw.jdField_b_of_type_Int != 1) {
          str1 = localbjpw.jdField_b_of_type_JavaLangString.substring(localbjpw.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Bjpt.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbjpw.jdField_b_of_type_JavaLangString;
            continue;
            bjko.e("PCPushProxy", "handleMessage get key = null");
            localbjpw = null;
          }
        }
      } while (localbjpw == null);
      if (localbjpw.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        bjlu.a("100", localbjpw.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bjpt.a(localbjpw);
        return;
        bjlu.a("100", "ANDROIDQQ.PCPUSH." + localbjpw.c, str1);
      }
      this.a.jdField_a_of_type_Bjpt.a(str2);
      return;
    } while (localbjpw == null);
    bjlu.a("500", localbjpw.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpx
 * JD-Core Version:    0.7.0.1
 */