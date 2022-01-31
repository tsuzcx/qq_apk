import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.GIFCreator.1;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bleo
{
  private static String jdField_a_of_type_JavaLangString = bleo.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bleq jdField_a_of_type_Bleq;
  private GifEncoder jdField_a_of_type_DovComQqImVideoGifEncoder = new GifEncoder();
  private List<String> jdField_a_of_type_JavaUtilList;
  private String b = bkpc.b;
  private String c;
  private String d;
  private String e;
  
  public bleo(String paramString)
  {
    this.e = paramString;
    this.jdField_a_of_type_JavaUtilList = a(paramString);
    this.c = (this.b + System.currentTimeMillis() + ".gif");
    this.d = (this.b + System.currentTimeMillis() + "_compressed.gif");
    try
    {
      paramString = new File(this.b);
      if (!paramString.isDirectory())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, this.b + " is not a directory");
        boolean bool = paramString.mkdirs();
        QLog.d(jdField_a_of_type_JavaLangString, 4, "mkdirs return " + bool);
      }
      paramString = new HandlerThread("GIFCreatorHT" + System.currentTimeMillis());
      paramString.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "check dir exception, msg = " + paramString.getMessage());
      }
    }
  }
  
  private List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new File(paramString);
    if (((File)localObject).isDirectory())
    {
      localObject = ((File)localObject).list(new blep(this));
      if (localObject != null)
      {
        Arrays.sort((Object[])localObject);
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          localArrayList.add(paramString + File.separator + str);
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    bdhb.a(this.e);
  }
  
  public void a(bleq parambleq)
  {
    this.jdField_a_of_type_Bleq = parambleq;
    QLog.d(jdField_a_of_type_JavaLangString, 4, new Object[] { "start create gif, gif path = ", this.c });
    this.jdField_a_of_type_AndroidOsHandler.post(new GIFCreator.1(this, parambleq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bleo
 * JD-Core Version:    0.7.0.1
 */