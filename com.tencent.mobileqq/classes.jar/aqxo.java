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

public class aqxo
{
  public int a;
  long jdField_a_of_type_Long;
  public arit a;
  public TVK_IDownloadMgr a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  String jdField_a_of_type_JavaLangString = "";
  WeakReference<aqxm> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  public int c;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  String d;
  
  public aqxo()
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
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "]" + this.jdField_a_of_type_Arit.a() + "]initDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "]");
      }
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "set new Download Callback");
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, new aqxq(this));
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCookie(20160714, this.jdField_d_of_type_JavaLangString);
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arit.a() + "]##########DownloadComplete########### bDownloading = false");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (aqxm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ((aqxm)localObject).aH_();
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
    aqxi.a(this);
  }
  
  private void e()
  {
    if ((aqxi.a != null) && (aqxi.a(aqxi.a) != null) && (aqxi.a(aqxi.a).size() > 0))
    {
      Iterator localIterator = aqxi.a(aqxi.a).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if ((this.jdField_a_of_type_Arit != null) && (!this.jdField_a_of_type_Arit.a().equals(localObject)))
        {
          localObject = (aqxo)aqxi.a(aqxi.a).get(localObject);
          if (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
          {
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
            ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
          }
          if (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
          {
            if (((aqxo)localObject).jdField_a_of_type_Int > 0)
            {
              ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).jdField_a_of_type_Int);
              ((aqxo)localObject).jdField_a_of_type_Int = -1;
              if (QLog.isColorLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "] stop playId[" + ((aqxo)localObject).jdField_a_of_type_Int + "]");
              }
            }
            if (((aqxo)localObject).jdField_c_of_type_Int > 0)
            {
              ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).jdField_c_of_type_Int);
              ((aqxo)localObject).jdField_c_of_type_Int = -1;
              if (QLog.isColorLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "] stop downloadId[" + ((aqxo)localObject).jdField_c_of_type_Int + "]");
              }
            }
            if (((aqxo)localObject).jdField_d_of_type_Int > 0)
            {
              ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).jdField_d_of_type_Int);
              ((aqxo)localObject).jdField_d_of_type_Int = -1;
              if (QLog.isColorLevel()) {
                QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "] stop blockId[" + ((aqxo)localObject).jdField_c_of_type_Int + "]");
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
    localObject = arrr.b(arqx.a().b() + this.jdField_a_of_type_Arit.c());
    if (!arso.b(this.jdField_c_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_Arit.a() + "],File rename faild mybe renamed");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arit.a((String)localObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_Arit.a() + "],File download over rename[" + (String)localObject + "],src[" + this.jdField_c_of_type_JavaLangString + "]");
      }
      if (!bdhb.b(new File(this.jdField_c_of_type_JavaLangString), new File((String)localObject)))
      {
        this.jdField_a_of_type_Arit.a(false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + this.jdField_a_of_type_Arit.a() + "],File download over. rename success!");
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
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]mDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + this.jdField_a_of_type_Arit.a() + "]video control free, stop download playid[" + this.jdField_a_of_type_Int + "]");
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]mDownloadMgr[" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + this.jdField_a_of_type_Arit.a() + "]video control free, stop download downloadId[" + this.jdField_c_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "][" + this.jdField_a_of_type_Arit.a() + "]##########Free########### bDownloading = false");
      }
    }
    try
    {
      aqxi.a(aqxi.a).remove(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_JavaLangString + "]removed for map");
        Iterator localIterator = aqxi.a(aqxi.a).keySet().iterator();
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
  
  public TVK_IMediaPlayer a(Context paramContext, View paramView, aqxm paramaqxm)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaqxm);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)paramView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new aqxp(this));
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
  
  public void a(arit paramarit, aqxm paramaqxm)
  {
    e();
    this.jdField_a_of_type_Arit = paramarit;
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arit.a() + "]getPlayUrl");
    }
    this.jdField_c_of_type_JavaLangString = paramarit.b();
    c();
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arit.a() + "]##########getPlayUrl########### bDownloading = false");
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int >= 0)
    {
      paramarit = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.buildPlayURLMp4(this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 2, "[" + this.jdField_a_of_type_Arit.a() + "]getPlayUrl:" + paramarit);
      }
      if (paramaqxm != null) {
        paramaqxm.a(paramarit, this.jdField_d_of_type_JavaLangString);
      }
      return;
    }
    paramarit.a(new aqxs(this, paramaqxm));
  }
  
  public void a(arit paramarit, boolean paramBoolean)
  {
    if (paramarit == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "StartDownload,videobiz is null");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Arit = paramarit;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + hashCode() + "[" + this.jdField_a_of_type_Arit.a() + "]StartDownload");
      }
      if (this.jdField_a_of_type_Arit.a())
      {
        aqxi.a(this.jdField_a_of_type_Arit.a());
        return;
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Arit.b();
      if (arrr.a(this.jdField_c_of_type_JavaLangString) != this.jdField_a_of_type_Arit.a()) {
        break;
      }
      d();
    } while (!QLog.isColorLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arit.a() + "]download success return");
    return;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arit.a() + "]url is null ,get it!");
      }
      a(this.jdField_a_of_type_Arit, new aqxr(this, paramBoolean));
      return;
    }
    c();
    int i;
    if (paramBoolean)
    {
      if (this.jdField_d_of_type_Int > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_Arit.a() + "],startDownloadBlock stop first!downloadId[" + this.jdField_d_of_type_Int + "]");
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_d_of_type_Int);
        this.jdField_d_of_type_Int = -1;
      }
      i = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.startPreLoadWithSavePath(20160714, this.jdField_b_of_type_JavaLangString, arrr.a(this.jdField_c_of_type_JavaLangString), 0L, 0, this.jdField_c_of_type_JavaLangString, 0);
      if (!paramBoolean) {
        break label589;
      }
      this.jdField_d_of_type_Int = i;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>.FVBlock", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_Arit.a() + "]@@@@@startDownloadBlockId downloadId[" + this.jdField_d_of_type_Int + "]");
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
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_Arit.a() + "],startDownload stop first!downloadId[" + this.jdField_c_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
      break;
      label589:
      this.jdField_c_of_type_Int = i;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 4, "[" + hashCode() + "]" + this.jdField_a_of_type_Arit.a() + "]@@@@@startDownloadId downloadId[" + this.jdField_c_of_type_Int + "]");
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
      localbdjz = bdgm.a(BaseActivity.sTopActivity, 230, "", alud.a(2131704985), null, alud.a(2131704979), new aqxt(this), null);
      if (!localbdjz.isShowing()) {
        localbdjz.show();
      }
    }
    while (this.jdField_a_of_type_Arit == null)
    {
      bdjz localbdjz;
      return;
    }
    this.jdField_a_of_type_Arit.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxo
 * JD-Core Version:    0.7.0.1
 */