import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class biym
  extends Handler
{
  public biym(biyj parambiyj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bisy.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    biyl localbiyl;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbiyl = (biyl)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbiyl == null) {
          bisy.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        biuh.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        biuh.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbiyl.jdField_b_of_type_Int != 1) {
          str1 = localbiyl.jdField_b_of_type_JavaLangString.substring(localbiyl.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Biyi.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbiyl.jdField_b_of_type_JavaLangString;
            continue;
            bisy.e("PCPushProxy", "handleMessage get key = null");
            localbiyl = null;
          }
        }
      } while (localbiyl == null);
      if (localbiyl.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        biuh.a("100", localbiyl.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Biyi.a(localbiyl);
        return;
        biuh.a("100", "ANDROIDQQ.PCPUSH." + localbiyl.c, str1);
      }
      this.a.jdField_a_of_type_Biyi.a(str2);
      return;
    } while (localbiyl == null);
    biuh.a("500", localbiyl.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biym
 * JD-Core Version:    0.7.0.1
 */