import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

class bjzl
  extends Handler
{
  public bjzl(bjzi parambjzi, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str1 = null;
    bjtx.b("PCPushProxy", "handleMessage msg.what = " + paramMessage.what + ", msg.obj = " + paramMessage.obj);
    String str2;
    bjzk localbjzk;
    switch (paramMessage.what)
    {
    default: 
      str2 = (String)paramMessage.obj;
      if (str2 != null)
      {
        localbjzk = (bjzk)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str2);
        if (localbjzk == null) {
          bjtx.e("PCPushProxy", "handleMessage get entry = null, key = " + str2);
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        bjvg.a("200", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        bjvg.a("100", "ANDROIDQQ.PCPUSH.UNREADPOP", "10");
        return;
        if (localbjzk.jdField_b_of_type_Int != 1) {
          str1 = localbjzk.jdField_b_of_type_JavaLangString.substring(localbjzk.jdField_b_of_type_JavaLangString.indexOf("#") + 1);
        }
        for (;;)
        {
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.jdField_a_of_type_Bjzh.a(this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
            return;
            str1 = localbjzk.jdField_b_of_type_JavaLangString;
            continue;
            bjtx.e("PCPushProxy", "handleMessage get key = null");
            localbjzk = null;
          }
        }
      } while (localbjzk == null);
      if (localbjzk.c.startsWith("ANDROIDQQ.PCPUSH.")) {
        bjvg.a("100", localbjzk.c, str1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bjzh.a(localbjzk);
        return;
        bjvg.a("100", "ANDROIDQQ.PCPUSH." + localbjzk.c, str1);
      }
      this.a.jdField_a_of_type_Bjzh.a(str2);
      return;
    } while (localbjzk == null);
    bjvg.a("500", localbjzk.c, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzl
 * JD-Core Version:    0.7.0.1
 */