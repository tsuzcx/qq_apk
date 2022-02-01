import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.PngsTextDrawer.1;
import dov.com.qq.im.ae.gif.video.PngsTextDrawer.2;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bnpj
{
  private static String jdField_a_of_type_JavaLangString = bnox.class.getSimpleName();
  private int jdField_a_of_type_Int = 320;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bnmp jdField_a_of_type_Bnmp;
  private bnpk jdField_a_of_type_Bnpk;
  private int jdField_b_of_type_Int = 320;
  private String jdField_b_of_type_JavaLangString = bmwp.jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  
  public bnpj(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    paramString = new HandlerThread("PngsTextDrawerHT" + System.currentTimeMillis());
    paramString.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
  }
  
  private List<String> a(String paramString)
  {
    String[] arrayOfString = new File(paramString).list();
    Arrays.sort(arrayOfString);
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localArrayList.add(paramString + File.separator + str);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(bnpk parambnpk)
  {
    this.jdField_a_of_type_Bnpk = parambnpk;
    QLog.d(jdField_a_of_type_JavaLangString, 4, "start add text to png");
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsTextDrawer.2(this, parambnpk));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsTextDrawer.1(this, paramFloat3, paramFloat4, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramFloat1, paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpj
 * JD-Core Version:    0.7.0.1
 */