package com.tencent.mobileqq.ar.ARRecord.worldcup;

import aafj;
import aafk;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRecord.ARWorldCupRecordDpc;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController.RecordListener;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.worldcup.ARWorldCupConstant;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ARWorldCupRecordController
  implements ARWorldCupStateListener
{
  public static String a;
  public static boolean a;
  public static String b;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aafk(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private VideoRecordController.RecordListener jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener = new aafj(this);
  private VideoRecordController jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController;
  private VideoProcessor jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupVideoProcessor;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = ARWorldCupRecordDpc.a().jdField_b_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public ARWorldCupRecordController(VideoRecordController paramVideoRecordController)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = paramVideoRecordController;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController == null) {
      throw new RuntimeException("VideoRecordController must be not null!");
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ar_world_cup_record");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupVideoProcessor = new VideoProcessor();
  }
  
  private long a(int paramInt)
  {
    long l = 3000L;
    if (paramInt == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.worldcup.record", 2, String.format("getMaxRecordDuration, state:%s, duration:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
      }
      return l;
      if (paramInt != 3) {
        if (paramInt == 102)
        {
          QLog.d("Q.worldcup.record", 4, String.format("getMaxRecordDuration, mCircleRecordDuration=%s", new Object[] { Long.valueOf(this.jdField_b_of_type_Long) }));
          if (this.jdField_b_of_type_Long > 3000L) {
            this.jdField_b_of_type_Long = 3000L;
          }
          l = 3000L - this.jdField_b_of_type_Long + 4000L;
        }
        else
        {
          l = 1000L;
        }
      }
    }
  }
  
  private String a(int paramInt)
  {
    String str = null;
    File localFile;
    if (this.jdField_c_of_type_Boolean) {
      if (paramInt == 1) {
        localFile = new File(ARWorldCupConstant.c, "recog");
      }
    }
    for (;;)
    {
      if (localFile != null)
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        str = localFile.getAbsolutePath();
      }
      return str;
      if (paramInt == 3)
      {
        localFile = new File(ARWorldCupConstant.c, "cross");
      }
      else if (paramInt == 9)
      {
        localFile = new File(ARWorldCupConstant.c, "game");
      }
      else if (paramInt == 102)
      {
        localFile = new File(ARWorldCupConstant.c, "tsz");
        continue;
        localFile = new File(ARWorldCupConstant.c, "arworld");
      }
      else
      {
        localFile = null;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("updateState, preState: %s --> state: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_Int == 15) && (paramInt != 0))
    {
      QLog.e("Q.worldcup.record", 1, "updateState, update fail");
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(String paramString)
  {
    jdField_b_of_type_JavaLangString = paramString;
    boolean bool = FileUtil.a(paramString);
    jdField_a_of_type_Boolean = true;
    a(bool, jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("handleMergeFinish: isSuc: %s, resultPath: %s", new Object[] { Boolean.valueOf(bool), paramString }));
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if ((!str.contains("cover")) && (!str.contains("game")))
        {
          new File(str).delete();
          if (QLog.isColorLevel()) {
            QLog.d("Q.worldcup.record", 2, String.format("delete temp file: %s", new Object[] { str }));
          }
        }
      }
    }
    long l = VideoProcessor.a(jdField_b_of_type_JavaLangString);
    paramString = new HashMap();
    paramString.put("circleDuration", String.valueOf(this.jdField_b_of_type_Long));
    paramString.put("videoLength", String.valueOf(l));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "worldcup_record_video", true, 0L, 1L, paramString, "");
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    a(0);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.ar.worldcup.record");
    localIntent.putExtra("key_result", paramBoolean);
    localIntent.putExtra("key_cover_pic", paramString1);
    localIntent.putExtra("key_video", paramString2);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("sendRecordResultBroadcast, picPath:%s, videoPath:%s", new Object[] { paramString1, paramString2 }));
    }
  }
  
  private void b(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void b(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void c(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a()
  {
    boolean bool;
    if ((ARWorldCupRecordDpc.a().jdField_a_of_type_Boolean) && (VideoEncoderUtils.a()))
    {
      bool = true;
      if (!bool) {
        break label131;
      }
      jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupVideoProcessor.a();
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.d = true;
      jdField_b_of_type_JavaLangString = null;
      jdField_a_of_type_Boolean = false;
      a(0);
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.b(2130838188);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.worldcup.record", 2, String.format("enable, isSupportRecord: %s, mSegmentRecord: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.jdField_c_of_type_Boolean) }));
      }
      return;
      bool = false;
      break;
      label131:
      jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupVideoProcessor.a();
      jdField_b_of_type_JavaLangString = VideoProcessor.a(0);
      jdField_a_of_type_Boolean = true;
      QLog.d("Q.worldcup.record", 1, "not support record");
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.d)
    {
      paramArrayOfFloat2 = GPUBaseFilter.a(ARRenderManagerImpl.jdField_a_of_type_Int, ARRenderManagerImpl.jdField_b_of_type_Int, 540, 960);
      if ((!this.e) || (this.jdField_b_of_type_Int >= 30) || (this.jdField_c_of_type_Boolean)) {
        break label193;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label71;
      }
      QLog.e("Q.worldcup.record", 1, String.format("onVideoFrameAvailable, but mCoverBitmap == null", new Object[0]));
    }
    label71:
    while (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController == null)
    {
      do
      {
        return;
        if (this.jdField_c_of_type_Int == -1) {
          this.jdField_c_of_type_Int = GlUtil.a(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(3553, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, paramArrayOfFloat2, paramLong);
        }
        this.jdField_b_of_type_Int += 1;
      } while (!QLog.isColorLevel());
      QLog.d("Q.worldcup.record", 2, String.format("drawCoverFrame, timestampNanos: %s, mCoverFrameCount: %s, glTextureId: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      return;
    }
    label193:
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("onStateChanged, %s -> %s, enable:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), Boolean.valueOf(this.d) }));
    }
    if (!this.d) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    switch (this.jdField_a_of_type_Int)
                    {
                    default: 
                      return;
                    case 0: 
                      if (paramInt == 1)
                      {
                        a(paramInt, 2, 0L);
                        return;
                      }
                      if (paramInt == 3)
                      {
                        if (this.jdField_c_of_type_Boolean)
                        {
                          a(paramInt, 103, 0L);
                          return;
                        }
                        b(paramInt, 103, 0L);
                        return;
                      }
                      break;
                    }
                  } while (paramInt != 102);
                  if (this.jdField_c_of_type_Boolean)
                  {
                    a(paramInt, 5, 0L);
                    return;
                  }
                  b(paramInt, 5, 0L);
                  return;
                  if (paramInt == 1)
                  {
                    a(paramInt, 2, 0L);
                    return;
                  }
                } while (paramInt != 2);
                if (this.jdField_c_of_type_Boolean)
                {
                  long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
                  if (l < 1000L)
                  {
                    a(paramInt, l);
                    return;
                  }
                  a(paramInt, 0L);
                  return;
                }
                b(paramInt, 0L);
                return;
                if (paramInt == 1)
                {
                  a(paramInt, 2, 0L);
                  return;
                }
              } while (paramInt != 3);
              if (this.jdField_c_of_type_Boolean)
              {
                a(paramInt, 103, 0L);
                return;
              }
              b(paramInt, 103, 0L);
              return;
            } while (paramInt != 15);
            if (QLog.isColorLevel()) {
              QLog.d("Q.worldcup.record", 2, String.format("traversing door, had broken!", new Object[0]));
            }
            a(paramInt, 0L);
            return;
            if (paramInt == 102)
            {
              if (this.jdField_c_of_type_Boolean)
              {
                a(paramInt, 5, 0L);
                return;
              }
              b(paramInt, 5, 0L);
              return;
            }
          } while (paramInt != 15);
          if (QLog.isColorLevel()) {
            QLog.d("Q.worldcup.record", 2, String.format("traversing over, had broken!", new Object[0]));
          }
          a(paramInt, 0L);
          return;
        } while (paramInt != 15);
        if (QLog.isColorLevel()) {
          QLog.d("Q.worldcup.record", 2, String.format("notify loop end, had broken!", new Object[0]));
        }
        a(paramInt, 0L);
        return;
        if (paramInt == 9)
        {
          c(((Integer)paramObject).intValue(), 0L);
          return;
        }
      } while (paramInt != 15);
      if (QLog.isColorLevel()) {
        QLog.d("Q.worldcup.record", 2, String.format("inside 360 video, had broken!", new Object[0]));
      }
      a(paramInt, 0L);
      return;
    } while (paramInt != 11);
    a(paramInt, 0L);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("disable, state: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(false, false);
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.b(-1);
    }
    this.jdField_c_of_type_Int = -1;
    this.d = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.a(null);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController.b(-1);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, "uninit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.worldcup.ARWorldCupRecordController
 * JD-Core Version:    0.7.0.1
 */