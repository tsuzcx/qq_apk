import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class bmvb
{
  public static int a;
  private static QQFilterRenderManager a;
  public static int b;
  private static QQFilterRenderManager b;
  public static int c = 2;
  private static int d;
  
  static
  {
    bmwb.a();
    bbhm.a(false);
    jdField_b_of_type_Int = 1;
  }
  
  public static int a()
  {
    return d;
  }
  
  public static QQFilterRenderManager a()
  {
    return new QQFilterRenderManager(new int[] { 70, 80, 90, 184 });
  }
  
  public static QQFilterRenderManager a(int paramInt)
  {
    if (paramInt == c) {
      return a;
    }
    return EffectsCameraCaptureView.a();
  }
  
  public static void a(QQFilterRenderManager paramQQFilterRenderManager)
  {
    a = paramQQFilterRenderManager;
  }
  
  public static QQFilterRenderManager b()
  {
    try
    {
      if ((jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.isSurfaceDestroyed())) {
        jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      }
      if (jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = a();
      }
      QQFilterRenderManager localQQFilterRenderManager = jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
      return localQQFilterRenderManager;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvb
 * JD-Core Version:    0.7.0.1
 */