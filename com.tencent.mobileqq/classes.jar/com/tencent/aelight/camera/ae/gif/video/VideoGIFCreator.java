package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.gif.preview.VideoFilterProcess;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;

public class VideoGIFCreator
{
  private static String jdField_a_of_type_JavaLangString = "GIFCreator";
  private int jdField_a_of_type_Int = 0;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private VideoFilterProcess jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoFilterProcess = new VideoFilterProcess();
  private VideoDecoder jdField_a_of_type_ComTencentAelightCameraAeGifVideoVideoDecoder;
  private VideoGIFCreator.Callback jdField_a_of_type_ComTencentAelightCameraAeGifVideoVideoGIFCreator$Callback;
  private VideoGIFCreator.TextConfig jdField_a_of_type_ComTencentAelightCameraAeGifVideoVideoGIFCreator$TextConfig;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new SurfaceTextureFilter();
  private GifEncoder jdField_a_of_type_DovComQqImVideoGifEncoder = new GifEncoder();
  private int jdField_b_of_type_Int = 380;
  private BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private int jdField_c_of_type_Int = 380;
  private BaseFilter jdField_c_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  
  public VideoGIFCreator(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("input video = ");
    localStringBuilder.append(paramString);
    QLog.d((String)localObject, 4, localStringBuilder.toString());
    localObject = new HandlerThread("GIFCreatorHT");
    ((HandlerThread)localObject).start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(((HandlerThread)localObject).getLooper());
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
  
  public void a(VideoGIFCreator.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoVideoGIFCreator$Callback = paramCallback;
    QLog.d(jdField_a_of_type_JavaLangString, 4, "start create gif");
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoGIFCreator.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator
 * JD-Core Version:    0.7.0.1
 */