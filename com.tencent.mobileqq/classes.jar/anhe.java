import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class anhe
  extends anhg
  implements anhi
{
  public anhe(anhj paramanhj)
  {
    super(null, paramanhj);
    this.jdField_a_of_type_Anhi = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = ancb.k;
    return str + paramString + ".zip";
  }
  
  public void a(anhg paramanhg, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    bhhf localbhhf = new bhhf(paramString1, new File(paramString2));
    localbhhf.p = true;
    localbhhf.n = true;
    localbhhf.f = "apollo_gif";
    localbhhf.b = 1;
    localbhhf.q = true;
    localbhhf.r = true;
    localbhhf.a(new anhf(this, paramString1, paramString2, paramString3));
    paramanhg = BaseApplicationImpl.getApplication();
    if (paramanhg != null)
    {
      paramanhg = paramanhg.getRuntime();
      if (!(paramanhg instanceof QQAppInterface)) {}
    }
    for (paramanhg = (QQAppInterface)paramanhg;; paramanhg = null)
    {
      if (paramanhg != null)
      {
        paramanhg = (bhhh)paramanhg.getManager(47);
        if (paramanhg != null)
        {
          paramanhg = paramanhg.a(3);
          if (paramanhg != null) {
            paramanhg.a(localbhhf, localbhhf.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbhhf));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhe
 * JD-Core Version:    0.7.0.1
 */