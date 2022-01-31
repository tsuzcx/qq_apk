import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GIFCreator.1;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class biag
{
  private static String jdField_a_of_type_JavaLangString = biag.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private biai jdField_a_of_type_Biai;
  private GifEncoder jdField_a_of_type_DovComQqImVideoGifEncoder = new GifEncoder();
  private List<String> jdField_a_of_type_JavaUtilList;
  private String b = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.tencent.mobileqq/cache/gifPreview/";
  private String c;
  private String d;
  private String e;
  
  public biag(String paramString)
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
      localObject = ((File)localObject).list(new biah(this));
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
    bace.a(this.e);
  }
  
  public void a(biai parambiai)
  {
    this.jdField_a_of_type_Biai = parambiai;
    QLog.d(jdField_a_of_type_JavaLangString, 4, new Object[] { "start create gif, gif path = ", this.c });
    this.jdField_a_of_type_AndroidOsHandler.post(new GIFCreator.1(this, parambiai));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biag
 * JD-Core Version:    0.7.0.1
 */