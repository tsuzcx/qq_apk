import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl.3;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl.6;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class aqtf
{
  public int a;
  long jdField_a_of_type_Long;
  public arek a;
  public TVK_IDownloadMgr a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  String jdField_a_of_type_JavaLangString = "";
  WeakReference<aqtd> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  public int c;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  String d;
  
  public aqtf()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private int a(long paramLong)
  {
    int i = 32;
    if (paramLong <= 2097152) {}
    for (;;)
    {
      return i * 1024;
      if (paramLong > 20971520) {
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
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "initDownloadMgr");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getDownloadMgr(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadInit(BaseApplicationImpl.getApplication().getBaseContext(), 20160714, "");
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "]" + this.jdField_a_of_type_Arek.a() + "]initDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "]");
      }
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "set new Download Callback");
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, new aqth(this));
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCookie(20160714, this.jdField_d_of_type_JavaLangString);
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arek.a() + "]##########DownloadComplete########### bDownloading = false");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (aqtd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ((aqtd)localObject).aK_();
      }
    }
    Object localObject = Looper.getMainLooper();
    if (((Looper)localObject).getThread() != Thread.currentThread())
    {
      new Handler((Looper)localObject).post(new FileVideoManager.VideoControl.3(this, localQQAppInterface));
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      f();
      a();
      localQQAppInterface.a().a(true, 3, null);
    }
    aqsz.a(this);
  }
  
  private void e()
  {
    if ((aqsz.a != null) && (aqsz.a(aqsz.a) != null) && (aqsz.a(aqsz.a).size() > 0))
    {
      Iterator localIterator = aqsz.a(aqsz.a).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if ((this.jdField_a_of_type_Arek != null) && (!this.jdField_a_of_type_Arek.a().equals(localObject)))
        {
          localObject = (aqtf)aqsz.a(aqsz.a).get(localObject);
          if (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
          {
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
            ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
          }
          if (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
          {
            if (((aqtf)localObject).jdField_a_of_type_Int > 0)
            {
              ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).jdField_a_of_type_Int);
              ((aqtf)localObject).jdField_a_of_type_Int = -1;
              if (QLog.isColorLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "] stop playId[" + ((aqtf)localObject).jdField_a_of_type_Int + "]");
              }
            }
            if (((aqtf)localObject).jdField_c_of_type_Int > 0)
            {
              ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).jdField_c_of_type_Int);
              ((aqtf)localObject).jdField_c_of_type_Int = -1;
              if (QLog.isColorLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "] stop downloadId[" + ((aqtf)localObject).jdField_c_of_type_Int + "]");
              }
            }
            if (((aqtf)localObject).jdField_d_of_type_Int > 0)
            {
              ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).jdField_d_of_type_Int);
              ((aqtf)localObject).jdField_d_of_type_Int = -1;
              if (QLog.isColorLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "] stop blockId[" + ((aqtf)localObject).jdField_c_of_type_Int + "]");
              }
            }
          }
        }
      }
    }
  }
  
  private void f()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localObject = arni.b(armo.a().b() + this.jdField_a_of_type_Arek.c());
    if (!arof.b(this.jdField_c_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_Arek.a() + "],File rename faild mybe renamed");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arek.a((String)localObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_Arek.a() + "],File download over rename[" + (String)localObject + "],src[" + this.jdField_c_of_type_JavaLangString + "]");
      }
      if (!bdcs.b(new File(this.jdField_c_of_type_JavaLangString), new File((String)localObject)))
      {
        this.jdField_a_of_type_Arek.a(false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_Arek.a() + "],File download over. rename success!");
      }
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "VC Free");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "internalFree stop and release MediaPlayer");
      }
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
    {
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel())
      {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]mDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + this.jdField_a_of_type_Arek.a() + "]video control free, stop download playid[" + this.jdField_a_of_type_Int + "]");
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]mDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + this.jdField_a_of_type_Arek.a() + "]video control free, stop download downloadId[" + this.jdField_c_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "][" + this.jdField_a_of_type_Arek.a() + "]##########Free########### bDownloading = false");
      }
    }
    try
    {
      aqsz.a(aqsz.a).remove(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_JavaLangString + "]removed for map");
        Iterator localIterator = aqsz.a(aqsz.a).keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + str + "]in map");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
        f();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public View a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(paramContext);
    }
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(paramContext);
  }
  
  public TVK_IMediaPlayer a(Context paramContext, View paramView, aqtd paramaqtd)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaqtd);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)paramView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new aqtg(this));
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  }
  
  public TVK_IProxyFactory a()
  {
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  }
  
  public void a()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileVideoManager.VideoControl.6(this));
      return;
    }
    g();
  }
  
  public void a(arek paramarek, aqtd paramaqtd)
  {
    e();
    this.jdField_a_of_type_Arek = paramarek;
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arek.a() + "]getPlayUrl");
    }
    this.jdField_c_of_type_JavaLangString = paramarek.b();
    c();
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arek.a() + "]##########getPlayUrl########### bDownloading = false");
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int >= 0)
    {
      paramarek = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 2, "[" + this.jdField_a_of_type_Arek.a() + "]getPlayUrl:" + paramarek);
      }
      if (paramaqtd != null) {
        paramaqtd.a(paramarek, this.jdField_d_of_type_JavaLangString);
      }
      return;
    }
    paramarek.a(new aqtj(this, paramaqtd));
  }
  
  public void a(arek paramarek, boolean paramBoolean)
  {
    if (paramarek == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "StartDownload,videobiz is null");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Arek = paramarek;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "[" + this.jdField_a_of_type_Arek.a() + "]StartDownload");
      }
      if (this.jdField_a_of_type_Arek.a())
      {
        aqsz.a(this.jdField_a_of_type_Arek.a());
        return;
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Arek.b();
      if (arni.a(this.jdField_c_of_type_JavaLangString) != this.jdField_a_of_type_Arek.a()) {
        break;
      }
      d();
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arek.a() + "]download success return");
    return;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arek.a() + "]url is null ,get it!");
      }
      a(this.jdField_a_of_type_Arek, new aqti(this, paramBoolean));
      return;
    }
    c();
    int i;
    if (paramBoolean)
    {
      if (this.jdField_d_of_type_Int > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_Arek.a() + "],startDownloadBlock stop first!downloadId[" + this.jdField_d_of_type_Int + "]");
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_d_of_type_Int);
        this.jdField_d_of_type_Int = -1;
      }
      i = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPreLoadWithSavePath(20160714, this.jdField_b_of_type_JavaLangString, arni.a(this.jdField_c_of_type_JavaLangString), 0L, 0, this.jdField_c_of_type_JavaLangString, 0);
      if (!paramBoolean) {
        break label589;
      }
      this.jdField_d_of_type_Int = i;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_Arek.a() + "]@@@@@startDownloadBlockId downloadId[" + this.jdField_d_of_type_Int + "]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, i, 6);
      return;
      if (this.jdField_c_of_type_Int <= 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_Arek.a() + "],startDownload stop first!downloadId[" + this.jdField_c_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
      break;
      label589:
      this.jdField_c_of_type_Int = i;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_Arek.a() + "]@@@@@startDownloadId downloadId[" + this.jdField_c_of_type_Int + "]");
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      localbdfq = bdcd.a(BaseActivity.sTopActivity, 230, "", alpo.a(2131704973), null, alpo.a(2131704967), new aqtk(this), null);
      if (!localbdfq.isShowing()) {
        localbdfq.show();
      }
    }
    while (this.jdField_a_of_type_Arek == null)
    {
      bdfq localbdfq;
      return;
    }
    this.jdField_a_of_type_Arek.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtf
 * JD-Core Version:    0.7.0.1
 */