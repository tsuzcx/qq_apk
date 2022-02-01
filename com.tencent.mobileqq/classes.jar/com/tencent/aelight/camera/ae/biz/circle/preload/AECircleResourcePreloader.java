package com.tencent.aelight.camera.ae.biz.circle.preload;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.aelight.camera.log.AEQLog;

public class AECircleResourcePreloader
{
  private static AECircleResourcePreloader jdField_a_of_type_ComTencentAelightCameraAeBizCirclePreloadAECircleResourcePreloader;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public volatile boolean a;
  private boolean b;
  
  public AECircleResourcePreloader()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static AECircleResourcePreloader a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeBizCirclePreloadAECircleResourcePreloader == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeBizCirclePreloadAECircleResourcePreloader == null) {
          jdField_a_of_type_ComTencentAelightCameraAeBizCirclePreloadAECircleResourcePreloader = new AECircleResourcePreloader();
        }
      }
    }
    return jdField_a_of_type_ComTencentAelightCameraAeBizCirclePreloadAECircleResourcePreloader;
  }
  
  public void a(Context paramContext)
  {
    AEQLog.a("[Performance2]AECircleResourcePreloader", "loadAEPhotoListContentView... ");
    long l = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (a()) {
        return;
      }
      AEQLog.a("[Performance2]AECircleResourcePreloader", "loadAEPhotoListContentView... create");
      try
      {
        LayoutInflater.from(paramContext).inflate(2064318494, null);
        LayoutInflater.from(paramContext).inflate(2064318611, null);
        LayoutInflater.from(paramContext).inflate(2064318523, null);
        LayoutInflater.from(paramContext).inflate(2064318509, null);
        this.b = true;
      }
      catch (Throwable paramContext)
      {
        AEQLog.a("[Performance2]AECircleResourcePreloader", "exception:", paramContext);
      }
      paramContext = new StringBuilder();
      paramContext.append("loadAEPhotoListContentView... cost:");
      paramContext.append(System.currentTimeMillis() - l);
      AEQLog.a("[Performance2]AECircleResourcePreloader", paramContext.toString());
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.preload.AECircleResourcePreloader
 * JD-Core Version:    0.7.0.1
 */