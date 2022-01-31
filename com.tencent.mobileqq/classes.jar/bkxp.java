import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import dov.com.tencent.mobileqq.richmedia.capture.view.TvkVideoViewHelper.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bkxp
  implements acwb, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  public Context a;
  private View jdField_a_of_type_AndroidViewView;
  private bkxq jdField_a_of_type_Bkxq;
  private bkxr jdField_a_of_type_Bkxr;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  boolean b = false;
  boolean c = false;
  
  public bkxp(Context paramContext, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "OnDownloadCallback " + paramString);
    }
  }
  
  View a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
      {
        View localView = (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
        return localView;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TvkVideoViewHelper", 1, localException, new Object[0]);
    }
    return null;
  }
  
  public View a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!this.b)
    {
      TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.b = true;
    }
    if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext)) {
      if (QLog.isColorLevel()) {
        QLog.d("TvkVideoViewHelper", 2, "TVK_SDK is not installed");
      }
    }
    do
    {
      return null;
      this.jdField_a_of_type_AndroidViewView = a();
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).addViewCallBack(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (!this.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TvkVideoViewHelper", 2, "hasn't opening URL, now prepare");
        }
        b();
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(0);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
  }
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "handleMessage");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(0, paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        break label131;
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TvkVideoViewHelper", 2, "ERROR : mVideoProxyFactory is null");
    return;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    label131:
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    localTVK_PlayerVideoInfo.setPlayType(2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_capture_guide");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, (String[])this.jdField_a_of_type_JavaUtilList.toArray(new String[0]), 0L, 0L, localTVK_PlayerVideoInfo, null);
    this.c = true;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void d()
  {
    c();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_Bkxq != null) {
      this.jdField_a_of_type_Bkxq.a();
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = "onError sdkError : " + paramInt1 + "  sdkDetailError : " + paramInt2 + "s:" + paramString;
    if (QLog.isColorLevel()) {
      QLog.e("TvkVideoViewHelper", 2, paramTVK_IMediaPlayer);
    }
    if (this.jdField_a_of_type_Bkxr != null) {
      this.jdField_a_of_type_Bkxr.a(paramTVK_IMediaPlayer);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onInfo");
    }
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onNetVideoInfo");
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onSurfaceDestory");
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new TvkVideoViewHelper.1(this));
    }
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onVideoPreparing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkxp
 * JD-Core Version:    0.7.0.1
 */