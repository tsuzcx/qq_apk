import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class aswm
{
  public static int a;
  public static SparseArray<WeakReference<aswm>> a;
  long jdField_a_of_type_Long = -1L;
  Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private asww jdField_a_of_type_Asww;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private boolean b;
  public int c;
  private boolean c;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_Int = -1;
  }
  
  private aswm(Context paramContext, int paramInt)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public static View a(Context paramContext)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        return (View)localTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      }
      return (View)localTVK_IProxyFactory.createVideoView(paramContext);
    }
    return null;
  }
  
  public static aswm a(Context paramContext, int paramInt)
  {
    paramContext = new aswm(paramContext, paramInt);
    jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramContext));
    return paramContext;
  }
  
  private void b()
  {
    ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).addViewCallBack(new aswn(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return -1L;
  }
  
  public aswx a()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_c_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      QLog.d("VideoBaseItem", 2, " you have paused Mediaplayer");
    }
    return new aswx(this, this.jdField_c_of_type_Int, this.jdField_a_of_type_Long);
  }
  
  public void a()
  {
    c();
    this.jdField_c_of_type_Int = 5;
    this.jdField_a_of_type_Asww = null;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Int == 4) {
      a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0L, paramLong, paramBoolean);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    b();
    this.jdField_c_of_type_Int = 1;
  }
  
  public void a(asww paramasww)
  {
    this.jdField_a_of_type_Asww = paramasww;
  }
  
  public void a(aswx paramaswx)
  {
    if (this.jdField_c_of_type_Int != 3) {
      QLog.d("VideoBaseItem", 2, "you should check thi status.Have you stopped Mediaplayer");
    }
    while ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)this.jdField_a_of_type_Long);
    }
    this.jdField_c_of_type_Int = 2;
    QLog.d("VideoBaseItem", 2, "you restart mediaplayer");
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Int < 1)
    {
      QLog.d("VideoBaseItem", 2, "you should check video staus! this function only call be calld after VideoStatusRecord.ITEM_BIND_VIEW");
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, "video view is empty,please check,you shold bind TencentSdkView", 0).show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getApplication(), (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new aswo(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new aswp(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new aswq(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new aswr(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new asws(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(new aswt(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(new aswu(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new aswv(this));
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    this.jdField_a_of_type_JavaLangString = paramString2;
    String str = asvt.a(paramString2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "shouq_hotpic_online_video");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    File localFile = new File(str);
    if (asvt.a(paramString2, paramLong2))
    {
      this.jdField_b_of_type_Boolean = true;
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      localTVK_PlayerVideoInfo.setPlayType(4);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), localFile.getAbsolutePath(), paramLong1, 0L, localTVK_PlayerVideoInfo);
      QLog.d("VideoBaseItem", 2, "huanxxiao test file have been cached");
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", str);
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    localTVK_PlayerVideoInfo.setVid(bflr.d(paramString1));
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), paramString1, paramLong1, 0L, localTVK_PlayerVideoInfo);
    QLog.d("VideoBaseItem", 2, "huanxxiao test open with url ok");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getBufferPercent();
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return -1L;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswm
 * JD-Core Version:    0.7.0.1
 */