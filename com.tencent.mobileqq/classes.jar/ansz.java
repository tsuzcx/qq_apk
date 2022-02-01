import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class ansz
  extends antb
  implements antd
{
  public ansz(ante paramante)
  {
    super(null, paramante);
    this.jdField_a_of_type_Antd = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = annv.k;
    return str + paramString + ".zip";
  }
  
  public void a(antb paramantb, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    bihu localbihu = new bihu(paramString1, new File(paramString2));
    localbihu.p = true;
    localbihu.n = true;
    localbihu.f = "apollo_gif";
    localbihu.b = 1;
    localbihu.q = true;
    localbihu.r = true;
    localbihu.a(new anta(this, paramString1, paramString2, paramString3));
    paramantb = BaseApplicationImpl.getApplication();
    if (paramantb != null)
    {
      paramantb = paramantb.getRuntime();
      if (!(paramantb instanceof QQAppInterface)) {}
    }
    for (paramantb = (QQAppInterface)paramantb;; paramantb = null)
    {
      if (paramantb != null)
      {
        paramantb = (bihw)paramantb.getManager(47);
        if (paramantb != null)
        {
          paramantb = paramantb.a(3);
          if (paramantb != null) {
            paramantb.a(localbihu, localbihu.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbihu));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansz
 * JD-Core Version:    0.7.0.1
 */