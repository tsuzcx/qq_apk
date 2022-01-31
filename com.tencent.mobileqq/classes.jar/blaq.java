import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.PngsCreator.1;
import dov.com.qq.im.ae.gif.video.PngsCreator.2;
import dov.com.qq.im.ae.gif.video.PngsCreator.3;
import dov.com.qq.im.ae.gif.video.PngsCreator.4;
import dov.com.qq.im.ae.gif.video.PngsCreator.5;
import java.io.File;
import java.util.List;

public class blaq
{
  private static String jdField_a_of_type_JavaLangString = blaq.class.getSimpleName();
  private double jdField_a_of_type_Double = 1.0D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bkxq jdField_a_of_type_Bkxq = new bkxq();
  private blar jdField_a_of_type_Blar;
  private blav jdField_a_of_type_Blav;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new SurfaceTextureFilter();
  private List<List<List<PointF>>> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<List<float[]>> jdField_b_of_type_JavaUtilList;
  
  public blaq(String paramString, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_Double = paramDouble;
    paramList = new HandlerThread("PngCreatorHT");
    paramList.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramList.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreator.1(this, paramString));
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreator.5(this));
  }
  
  public void a(blar paramblar)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_JavaLangString = (bkkv.jdField_b_of_type_JavaLangString + File.separator + System.currentTimeMillis());
    try
    {
      new File(this.jdField_b_of_type_JavaLangString).mkdirs();
      QLog.d(jdField_a_of_type_JavaLangString, 4, new Object[] { "pngDir = ", this.jdField_b_of_type_JavaLangString });
      this.jdField_a_of_type_Blar = paramblar;
      this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreator.2(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreator.3(this, paramString));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreator.4(this, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blaq
 * JD-Core Version:    0.7.0.1
 */