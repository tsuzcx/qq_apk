import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class amnq
  extends amns
  implements amnu
{
  public amnq(amnv paramamnv)
  {
    super(null, paramamnv);
    this.jdField_a_of_type_Amnu = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = amip.k;
    return str + paramString + ".zip";
  }
  
  public void a(amns paramamns, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    bgoe localbgoe = new bgoe(paramString1, new File(paramString2));
    localbgoe.p = true;
    localbgoe.n = true;
    localbgoe.f = "apollo_gif";
    localbgoe.b = 1;
    localbgoe.q = true;
    localbgoe.r = true;
    localbgoe.a(new amnr(this, paramString1, paramString2, paramString3));
    paramamns = BaseApplicationImpl.getApplication();
    if (paramamns != null)
    {
      paramamns = paramamns.getRuntime();
      if (!(paramamns instanceof QQAppInterface)) {}
    }
    for (paramamns = (QQAppInterface)paramamns;; paramamns = null)
    {
      if (paramamns != null)
      {
        paramamns = (bgog)paramamns.getManager(47);
        if (paramamns != null)
        {
          paramamns = paramamns.a(3);
          if (paramamns != null) {
            paramamns.a(localbgoe, localbgoe.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbgoe));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnq
 * JD-Core Version:    0.7.0.1
 */