package com.tencent.mobileqq.ar.arengine;

import aapj;
import aapk;
import aapl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.ar.config.WorldCupMgr.DownloadListener;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ARWorldCupBaseResDownload
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private RemoteArConfigManager jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager;
  private ARWorldCupBaseResDownload.DownloadListener jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener;
  public WorldCupMgr.DownloadListener a;
  public GestureMgr.GestureStatusListener a;
  Runnable jdField_a_of_type_JavaLangRunnable = new aapl(this);
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public ARWorldCupBaseResDownload(AppInterface paramAppInterface, RemoteArConfigManager paramRemoteArConfigManager, ARWorldCupBaseResDownload.DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr$DownloadListener = new aapj(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr$GestureStatusListener = new aapk(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = paramRemoteArConfigManager;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener = paramDownloadListener;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    this.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
    QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "onWorldCupBaseResDownloadProgress. progress = " + paramInt2 + ", progress[0] = " + this.jdField_a_of_type_ArrayOfInt[0] + ", progress[1] = " + this.jdField_a_of_type_ArrayOfInt[1]);
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      paramInt1 = 0;
      for (paramInt2 = i; paramInt1 < 2; paramInt2 = i)
      {
        i = paramInt2;
        if (this.jdField_a_of_type_ArrayOfInt[paramInt1] > 0) {
          i = paramInt2 + this.jdField_a_of_type_ArrayOfInt[paramInt1];
        }
        paramInt1 += 1;
      }
      QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "onWorldCupBaseResDownloadProgress. avgProgress = " + paramInt2 / 2);
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener.a(2, paramInt2 / 2);
      }
    }
    label157:
    do
    {
      do
      {
        do
        {
          break label157;
          do
          {
            return;
          } while ((paramInt2 >= 0) && (paramInt2 != 100));
          if ((this.jdField_a_of_type_ArrayOfInt[0] != 100) || (this.jdField_a_of_type_ArrayOfInt[1] != 100)) {
            break;
          }
          ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_Boolean = false;
        } while (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener == null);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener.a(0, 100);
        return;
      } while (((this.jdField_a_of_type_ArrayOfInt[0] >= 0) && (this.jdField_a_of_type_ArrayOfInt[0] <= 99)) || ((this.jdField_a_of_type_ArrayOfInt[1] >= 0) && (this.jdField_a_of_type_ArrayOfInt[1] <= 99)));
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener == null);
    this.jdField_a_of_type_ComTencentMobileqqArArengineARWorldCupBaseResDownload$DownloadListener.a(1, -1);
  }
  
  private boolean c()
  {
    return WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(0);
  }
  
  private boolean d()
  {
    return GestureMgr.a().a();
  }
  
  public void a()
  {
    int i = 0;
    QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "downloadWorldCupBaseRes.");
    if (c())
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 100;
      if (!d()) {
        break label100;
      }
      this.jdField_a_of_type_ArrayOfInt[1] = 100;
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      while (i < 2)
      {
        a(i, this.jdField_a_of_type_ArrayOfInt[i]);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0);
      WorldCupMgr.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr$DownloadListener);
      break;
      label100:
      this.jdField_a_of_type_ArrayOfInt[1] = 0;
      GestureMgr.a().a(true, this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr$GestureStatusListener);
      GestureMgr.a().b();
    }
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  public boolean a()
  {
    boolean bool2 = c();
    boolean bool3 = d();
    if ((bool2) && (bool3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "isWorldCupBaseResReady. isWorldCupBaseResReady = " + bool1 + ", isWorldCupBaseRes0Ready = " + bool2 + ", isWorldCupBaseRes1Ready = " + bool3);
      return bool1;
    }
  }
  
  public boolean b()
  {
    QLog.i("AREngine_ARWorldCupBaseResDownload", 2, "isWorldCupBaseResDownloading. mIsResDownloading = " + this.jdField_a_of_type_Boolean);
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload
 * JD-Core Version:    0.7.0.1
 */