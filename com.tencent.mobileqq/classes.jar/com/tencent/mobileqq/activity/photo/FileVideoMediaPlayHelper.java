package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr.ICallBackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class FileVideoMediaPlayHelper
  extends MediaPlayHelper
  implements TVK_IDownloadMgr.ICallBackListener, TVK_IMediaPlayer.OnCaptureImageListener
{
  Context jdField_a_of_type_AndroidContentContext;
  private FileVideoMediaPlayHelper.OnCaptureVideoFrameImageListener jdField_a_of_type_ComTencentMobileqqActivityPhotoFileVideoMediaPlayHelper$OnCaptureVideoFrameImageListener;
  private VideoPlayControllerForAIO.OnDownloadListener jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO$OnDownloadListener = null;
  private TVK_IDownloadMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr;
  TVK_PlayerVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private long e = -1L;
  private long f = 0L;
  
  private int a(long paramLong)
  {
    if (paramLong <= 2097152) {}
    int i;
    while (paramLong <= 20971520)
    {
      i = 32;
      break;
    }
    if (paramLong <= 209715200) {
      i = 128;
    } else if (paramLong <= 524288000) {
      i = 512;
    } else if (paramLong <= 1073741824) {
      i = 1024;
    } else if (paramLong <= -50331648) {
      i = 2048;
    } else {
      i = 4096;
    }
    return i * 1024;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)) {
      return this.f;
    }
    return super.a();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr;
      if (localObject != null)
      {
        int i = this.jdField_d_of_type_Int;
        if (i > -1) {
          ((TVK_IDownloadMgr)localObject).stopPreLoad(i);
        }
        i = this.jdField_d_of_type_Int;
        if (i > -1) {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(i);
        }
        i = this.jdField_c_of_type_Int;
        if (i > -1) {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(i);
        }
        localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr;
        if (localObject != null)
        {
          ((TVK_IDownloadMgr)localObject).DownloadDeinit(20160714);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = null;
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("FileVideoMediaPlayHelper releaseMediaPlayer:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
          QLog.i("PauseDebug", 1, ((StringBuilder)localObject).toString());
        }
        super.a();
        return;
      }
    }
    super.a();
  }
  
  public void a(FileVideoMediaPlayHelper.OnCaptureVideoFrameImageListener paramOnCaptureVideoFrameImageListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoFileVideoMediaPlayHelper$OnCaptureVideoFrameImageListener = paramOnCaptureVideoFrameImageListener;
  }
  
  public void a(VideoPlayControllerForAIO.OnDownloadListener paramOnDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO$OnDownloadListener = paramOnDownloadListener;
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong, String paramString3, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean)
    {
      super.a(paramString1, paramString2, paramArrayOfString, paramLong, paramString3, paramContext);
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getDownloadMgr(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadInit(BaseApplicationImpl.getApplication().getBaseContext(), 20160714, "");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCookie(20160714, (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, this);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPlayWithSavePath(20160714, paramArrayOfString[0], FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString), 0L, 0, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, this.jdField_c_of_type_Int, 6);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("RawVideoPlay", "true");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    paramString1 = new HashMap();
    paramString1.put("shouq_bus_type", "bus_type_video_file");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(paramString1);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.e);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString, 0L, 0L, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
  
  public boolean a(Context paramContext, IVideoViewBase paramIVideoViewBase)
  {
    if ((super.a(paramContext, paramIVideoViewBase)) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCaptureImageListener(this);
    }
    return super.a(paramContext, paramIVideoViewBase);
  }
  
  public void downloadCallBack(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean)
    {
      super.OnDownloadCallback(paramString);
      return;
    }
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.getInt("callBackType");
      paramString.getInt("fileSize");
      l2 = paramString.getInt("offset");
      j = paramString.getInt("playID");
      this.f = paramString.getLong("speedKBS");
      if (this.jdField_c_of_type_Long == 0L) {
        this.jdField_c_of_type_Long = a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Long);
      }
      if ((j != this.jdField_d_of_type_Long) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration() > 1L) && (l2 > this.e)) {
        this.e = l2;
      }
      l1 = l2;
      if (l2 < this.e) {
        l1 = this.e;
      }
      boolean bool = this.jdField_b_of_type_Boolean;
      if (!bool) {
        break label735;
      }
      if (QLog.isDevelopLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[");
        paramString.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
        paramString.append("],playid +[");
        paramString.append(j);
        paramString.append("] callBackType[ ");
        paramString.append(i);
        paramString.append(" ]download success! igon");
        QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, paramString.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO$OnDownloadListener == null) {
        break label734;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO$OnDownloadListener.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
      return;
    }
    catch (JSONException paramString)
    {
      long l2;
      int j;
      long l1;
      paramString.printStackTrace();
    }
    if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString) != this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Long) {
      return;
    }
    label734:
    label735:
    do
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO$OnDownloadListener.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
      return;
      do
      {
        l2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString);
        if (QLog.isDevelopLevel())
        {
          paramString = new StringBuilder();
          paramString.append("[");
          paramString.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
          paramString.append("],playid +[");
          paramString.append(j);
          paramString.append("] callBackType[");
          paramString.append(i);
          paramString.append("]， tempLen:");
          paramString.append(l2);
          QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, paramString.toString());
        }
        l1 -= l2;
        if ((l1 > this.jdField_c_of_type_Long) && (!this.jdField_c_of_type_Boolean))
        {
          if (QLog.isDevelopLevel())
          {
            paramString = new StringBuilder();
            paramString.append("[");
            paramString.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
            paramString.append("],playid +[");
            paramString.append(j);
            paramString.append("] need download block currentBlockId:");
            paramString.append(this.jdField_d_of_type_Int);
            QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, paramString.toString());
          }
          ThreadManager.getUIHandler().post(new FileVideoMediaPlayHelper.1(this, j));
          this.jdField_c_of_type_Boolean = true;
          return;
        }
        if ((this.jdField_d_of_type_Int > 0) && (l1 < this.jdField_c_of_type_Long))
        {
          ThreadManager.getUIHandler().post(new FileVideoMediaPlayHelper.2(this));
          this.jdField_d_of_type_Int = -1;
          this.jdField_c_of_type_Boolean = false;
        }
        float f1 = (float)l2 / (float)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Long;
        paramString = new StringBuilder();
        paramString.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692707));
        paramString.append("(");
        paramString.append(FileUtil.a(l2));
        paramString.append("/");
        paramString.append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Long));
        paramString.append(")");
        paramString = paramString.toString();
        if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO$OnDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long, f1, paramString);
          return;
        }
        return;
        return;
      } while (i == 2);
      if (i == 3) {
        break;
      }
    } while (i == 7);
  }
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    ThreadManagerV2.getUIHandlerV2().post(new FileVideoMediaPlayHelper.4(this));
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    ThreadManagerV2.executeOnSubThread(new FileVideoMediaPlayHelper.3(this, paramBitmap));
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
    super.onSeekComplete(paramTVK_IMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper
 * JD-Core Version:    0.7.0.1
 */