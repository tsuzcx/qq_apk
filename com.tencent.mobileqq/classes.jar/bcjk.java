import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class bcjk
  extends Handler
{
  public bcjk(bcjh parambcjh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bcds.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    bcjj localbcjj;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbcjj = (bcjj)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbcjj == null) {
          bcds.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        bcfb.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        bcfb.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbcjj.jdField_b_of_type_Int != 1) {
          str1 = localbcjj.jdField_b_of_type_JavaLangString.substring(localbcjj.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Bcjg.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbcjj.jdField_b_of_type_JavaLangString;
            continue;
            bcds.e("PCPushProxy", "handleMessage get key = null");
            localbcjj = null;
          }
        }
      } while (localbcjj == null);
      if (localbcjj.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        bcfb.a("100", localbcjj.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bcjg.a(localbcjj);
        return;
        bcfb.a("100", "ANDROIDQQ.PCPUSH." + localbcjj.c, str1);
      }
      this.a.jdField_a_of_type_Bcjg.a(str2);
      return;
    } while (localbcjj == null);
    bcfb.a("500", localbcjj.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcjk
 * JD-Core Version:    0.7.0.1
 */