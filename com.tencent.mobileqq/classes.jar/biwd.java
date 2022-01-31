import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.1;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.2;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.3;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.4;
import dov.com.qq.im.video.GifEncoder;

public class biwd
{
  private static String jdField_a_of_type_JavaLangString = bivn.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bivk jdField_a_of_type_Bivk = new bivk();
  private biwc jdField_a_of_type_Biwc;
  private biwf jdField_a_of_type_Biwf;
  private biwg jdField_a_of_type_Biwg;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new SurfaceTextureFilter();
  private GifEncoder jdField_a_of_type_DovComQqImVideoGifEncoder = new GifEncoder();
  private int jdField_b_of_type_Int = 380;
  private BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private int jdField_c_of_type_Int = 380;
  private BaseFilter jdField_c_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  
  public biwd(String paramString)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "input video = " + paramString);
    HandlerThread localHandlerThread = new HandlerThread("GIFCreatorHT");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoGIFCreator.1(this, paramString));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoGIFCreator.4(this));
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoGIFCreator.2(this, paramBitmap, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public void a(biwf parambiwf)
  {
    this.jdField_a_of_type_Biwf = parambiwf;
    QLog.d(jdField_a_of_type_JavaLangString, 4, "start create gif");
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoGIFCreator.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwd
 * JD-Core Version:    0.7.0.1
 */