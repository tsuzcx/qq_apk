package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.AEPath.GIF.CACHE;
import com.tencent.aelight.camera.ae.gif.filter.GifFilterProcess;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.io.File;
import java.util.List;

public class PngsCreator
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreator";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private GifFilterProcess jdField_a_of_type_ComTencentAelightCameraAeGifFilterGifFilterProcess = new GifFilterProcess();
  private PngsCreator.Callback jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreator$Callback;
  private RepeatVideoDecoder jdField_a_of_type_ComTencentAelightCameraAeGifVideoRepeatVideoDecoder;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new SurfaceTextureFilter();
  private List<PTFaceAttr> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  
  public PngsCreator(String paramString, List<PTFaceAttr> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
  
  public void a(PngsCreator.Callback paramCallback)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.GIF.CACHE.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(System.currentTimeMillis());
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    try
    {
      new File(this.jdField_b_of_type_JavaLangString).mkdirs();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, new Object[] { "pngDir = ", this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreator$Callback = paramCallback;
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreator.2(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreator.3(this, paramString));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreator.4(this, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreator
 * JD-Core Version:    0.7.0.1
 */