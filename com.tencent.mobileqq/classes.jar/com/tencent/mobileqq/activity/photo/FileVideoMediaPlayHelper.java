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
  private long A = 0L;
  TVK_PlayerVideoInfo a;
  Context b;
  private TVK_IDownloadMgr p;
  private int q = -1;
  private String r;
  private VideoPlayControllerForAIO.OnDownloadListener s = null;
  private FileVideoMediaPlayHelper.OnCaptureVideoFrameImageListener t;
  private long u = 0L;
  private long v = -1L;
  private long w = -1L;
  private boolean x = false;
  private boolean y = false;
  private int z = -1;
  
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
  
  public void a()
  {
    if ((this.g != null) && (this.g.h))
    {
      Object localObject = this.p;
      if (localObject != null)
      {
        int i = this.z;
        if (i > -1) {
          ((TVK_IDownloadMgr)localObject).stopPreLoad(i);
        }
        i = this.z;
        if (i > -1) {
          this.p.stopPreLoad(i);
        }
        i = this.q;
        if (i > -1) {
          this.p.stopPreLoad(i);
        }
        localObject = this.p;
        if (localObject != null)
        {
          ((TVK_IDownloadMgr)localObject).DownloadDeinit(20160714);
          this.p = null;
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("FileVideoMediaPlayHelper releaseMediaPlayer:");
          ((StringBuilder)localObject).append(this.g.k);
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
    this.t = paramOnCaptureVideoFrameImageListener;
  }
  
  public void a(VideoPlayControllerForAIO.OnDownloadListener paramOnDownloadListener)
  {
    this.s = paramOnDownloadListener;
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong, String paramString3, Context paramContext)
  {
    this.b = paramContext;
    if (!this.g.h)
    {
      super.a(paramString1, paramString2, paramArrayOfString, paramLong, paramString3, paramContext);
      return;
    }
    this.p = this.c.getDownloadMgr(BaseApplicationImpl.getContext());
    this.p.DownloadInit(BaseApplicationImpl.getApplication().getBaseContext(), 20160714, "");
    if ((this.g.d != null) && (this.g.d.size() > 0)) {
      this.p.setCookie(20160714, (String)this.g.d.get(0));
    }
    this.p.setCallBackListener(20160714, this);
    this.q = this.p.startPlayWithSavePath(20160714, paramArrayOfString[0], FileManagerUtil.a(this.g.b), 0L, 0, this.g.b, 0);
    this.p.setPlayerState(20160714, this.q, 6);
    this.r = this.p.buildPlayURLMp4(this.q);
    this.a = new TVK_PlayerVideoInfo();
    this.a.setConfigMap("RawVideoPlay", "true");
    this.a.setConfigMap("keep_last_frame", "true");
    paramString1 = new HashMap();
    paramString1.put("shouq_bus_type", "bus_type_video_file");
    this.a.setReportInfoMap(paramString1);
    this.d.setOutputMute(this.g.m);
    this.d.openMediaPlayerByUrl(paramContext.getApplicationContext(), this.r, 0L, 0L, this.a);
  }
  
  public boolean a(Context paramContext, IVideoViewBase paramIVideoViewBase)
  {
    if ((super.a(paramContext, paramIVideoViewBase)) && (this.d != null)) {
      this.d.setOnCaptureImageListener(this);
    }
    return super.a(paramContext, paramIVideoViewBase);
  }
  
  public long b()
  {
    if ((this.g != null) && (this.g.h) && (this.p != null)) {
      return this.A;
    }
    return super.b();
  }
  
  public void downloadCallBack(String paramString)
  {
    if (!this.g.h)
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
      this.A = paramString.getLong("speedKBS");
      if (this.u == 0L) {
        this.u = a(this.g.n);
      }
      if ((j != this.v) && (this.d != null) && (this.d.getDuration() > 1L) && (l2 > this.w)) {
        this.w = l2;
      }
      l1 = l2;
      if (l2 < this.w) {
        l1 = this.w;
      }
      boolean bool = this.x;
      if (!bool) {
        break label735;
      }
      if (QLog.isDevelopLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[");
        paramString.append(this.g.k);
        paramString.append("],playid +[");
        paramString.append(j);
        paramString.append("] callBackType[ ");
        paramString.append(i);
        paramString.append(" ]download success! igon");
        QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, paramString.toString());
      }
      if (this.s == null) {
        break label734;
      }
      this.s.b(this.g.k);
      return;
    }
    catch (JSONException paramString)
    {
      long l2;
      int j;
      long l1;
      paramString.printStackTrace();
    }
    if (FileManagerUtil.h(this.g.b) != this.g.n) {
      return;
    }
    label734:
    label735:
    do
    {
      this.x = true;
      this.g.a = false;
      this.s.b(this.g.k);
      return;
      do
      {
        l2 = FileManagerUtil.h(this.g.b);
        if (QLog.isDevelopLevel())
        {
          paramString = new StringBuilder();
          paramString.append("[");
          paramString.append(this.g.k);
          paramString.append("],playid +[");
          paramString.append(j);
          paramString.append("] callBackType[");
          paramString.append(i);
          paramString.append("]， tempLen:");
          paramString.append(l2);
          QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, paramString.toString());
        }
        l1 -= l2;
        if ((l1 > this.u) && (!this.y))
        {
          if (QLog.isDevelopLevel())
          {
            paramString = new StringBuilder();
            paramString.append("[");
            paramString.append(this.g.k);
            paramString.append("],playid +[");
            paramString.append(j);
            paramString.append("] need download block currentBlockId:");
            paramString.append(this.z);
            QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, paramString.toString());
          }
          ThreadManager.getUIHandler().post(new FileVideoMediaPlayHelper.1(this, j));
          this.y = true;
          return;
        }
        if ((this.z > 0) && (l1 < this.u))
        {
          ThreadManager.getUIHandler().post(new FileVideoMediaPlayHelper.2(this));
          this.z = -1;
          this.y = false;
        }
        float f = (float)l2 / (float)this.g.n;
        paramString = new StringBuilder();
        paramString.append(this.b.getString(2131889778));
        paramString.append("(");
        paramString.append(FileUtil.a(l2));
        paramString.append("/");
        paramString.append(FileUtil.a(this.g.n));
        paramString.append(")");
        paramString = paramString.toString();
        if ((this.d != null) && (this.d.isPlaying()))
        {
          this.s.a(this.g.k, f, paramString);
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
    if (h()) {
      this.d.start();
    }
    super.onSeekComplete(paramTVK_IMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper
 * JD-Core Version:    0.7.0.1
 */