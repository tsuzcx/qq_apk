import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.PngsTextDrawer.1;
import dov.com.qq.im.video.PngsTextDrawer.2;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bias
{
  private static String jdField_a_of_type_JavaLangString = biag.class.getSimpleName();
  private int jdField_a_of_type_Int = 320;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bhsj jdField_a_of_type_Bhsj;
  private biat jdField_a_of_type_Biat;
  private int jdField_b_of_type_Int = 320;
  private String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.tencent.mobileqq/cache/gifPreview/";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  
  public bias(String paramString)
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
  
  public void a(biat parambiat)
  {
    this.jdField_a_of_type_Biat = parambiat;
    QLog.d(jdField_a_of_type_JavaLangString, 4, "start add text to png");
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsTextDrawer.2(this, parambiat));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsTextDrawer.1(this, paramFloat3, paramFloat4, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramFloat1, paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bias
 * JD-Core Version:    0.7.0.1
 */