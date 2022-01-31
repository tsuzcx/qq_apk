import android.app.Activity;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View.OnClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.11;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.12;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.14;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.15;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.9;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class aoyb
  extends aoxe
  implements aojh, aovo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new aoye(this);
  protected AudioManager a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aoyf(this);
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new aoyg(this);
  public aozd a;
  public TVK_IMediaPlayer a;
  protected TVK_IProxyFactory a;
  public TVK_PlayerVideoInfo a;
  public final Runnable a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private long jdField_b_of_type_Long;
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoFilePresenter.15(this);
  private boolean d;
  private boolean e;
  
  public aoyb(aovk paramaovk, Activity paramActivity)
  {
    super(paramaovk, paramActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new VideoFilePresenter.14(this);
    this.jdField_a_of_type_Aozd = new aozd(paramActivity);
    a(this.jdField_a_of_type_Aozd);
    r();
  }
  
  private int a(int paramInt)
  {
    long l2 = this.jdField_a_of_type_Long;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    float f = paramInt / 10000.0F;
    return (int)((float)l1 * f);
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Aozd.f();
  }
  
  private void p()
  {
    if ((!apck.c(this.jdField_a_of_type_Aovk.c())) && (this.jdField_a_of_type_Aovk.d() == 1))
    {
      this.jdField_a_of_type_Aozd.i(true);
      if (this.jdField_a_of_type_Aovk.b() == 16)
      {
        this.jdField_a_of_type_Aozd.a(this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131627250));
        this.jdField_a_of_type_Aovk.a(true);
        this.jdField_a_of_type_Aozd.e(false);
        return;
      }
      q();
      this.jdField_a_of_type_Aozd.b(true);
      b(this.jdField_a_of_type_Aovk.a());
      return;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aovk.c();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_video_file");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setPlayType(4);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aovk.c(), 0L, 0L, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
  
  private void q()
  {
    aotv localaotv = this.jdField_a_of_type_Aovk.a();
    if (localaotv == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "get video biz, data is null!");
      return;
    }
    aojd.a(localaotv.a()).a(localaotv, new aoyl(this));
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(-1);
    if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null))
    {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("power")).newWakeLock(536870922, "FileBrowserPresenter<FileAssistant>");
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("RawVideoPlay", "true");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.9(this));
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.10(this));
  }
  
  private void u()
  {
    if (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = video");
    }
    this.jdField_a_of_type_Aozd.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Aozd.d(10000);
    this.jdField_a_of_type_Aozd.a(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_Aozd.d();
    this.jdField_a_of_type_Aovk.a(this);
    this.jdField_a_of_type_Aozd.g(false);
    aojd.a(this.jdField_a_of_type_AndroidAppActivity, new aoyc(this));
    if (this.jdField_a_of_type_Aotd != null) {
      this.jdField_a_of_type_Aotd.a(true);
    }
    if ((apck.c(this.jdField_a_of_type_Aovk.c())) && (this.jdField_a_of_type_Aovk.i() == 2)) {
      this.jdField_a_of_type_Aozd.g(true);
    }
    int i = this.jdField_a_of_type_Aovk.i();
    int j = this.jdField_a_of_type_Aovk.h();
    if ((i == 6) && (j == 1))
    {
      this.jdField_a_of_type_Aozd.b(false);
      this.jdField_a_of_type_Aozd.g(false);
      this.jdField_a_of_type_Aozd.c(true);
    }
    this.jdField_a_of_type_Aozd.f(this.jdField_a_of_type_Aovk.k());
    bbqo.a(this.jdField_a_of_type_AndroidAppActivity, 53);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.11(this, paramInt, paramString));
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void aF_()
  {
    n();
  }
  
  public void aG_()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.12(this));
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    try
    {
      apci.a("0X8007426");
      apci.a("0X8007427");
      this.jdField_a_of_type_Aozd.b(this.jdField_a_of_type_Aovk.i(), this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = aojd.a(this.jdField_a_of_type_Aovk.i()).a();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = aojd.a(this.jdField_a_of_type_Aovk.i()).a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_Aozd.b(), this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new aoyh(this));
      this.jdField_a_of_type_Aozd.i(true);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new aoyi(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new aoyj(this));
      p();
      this.jdField_a_of_type_Aozd.d(d());
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new aoyk(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1) == 1;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aozd.g(false);
    this.jdField_a_of_type_Aozd.b(true);
    this.jdField_a_of_type_Aozd.c(false);
    b(this.jdField_a_of_type_Aovk.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aozd.g(true);
    this.jdField_a_of_type_Aozd.b(false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aozd.g(true);
    this.jdField_a_of_type_Aozd.b(false);
    if ((this.jdField_a_of_type_Aovk != null) && ((this.jdField_a_of_type_Aovk instanceof aovc))) {
      p();
    }
  }
  
  public void g()
  {
    if (!apdh.b(this.jdField_a_of_type_Aovk.c())) {
      return;
    }
    this.jdField_a_of_type_Aozd.b(false);
    this.jdField_a_of_type_Aozd.g(false);
    this.jdField_a_of_type_Aozd.c(true);
  }
  
  public void i()
  {
    int i = 5;
    this.jdField_a_of_type_Aozd.c();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    String str2 = "";
    String str1 = "4";
    String str4 = "";
    int j = this.jdField_a_of_type_Aovk.k();
    String str3;
    if ((j == 3) || (j == 4))
    {
      str3 = this.jdField_a_of_type_Aovk.a();
      str1 = "3";
      i = 2;
      Object localObject = new DecimalFormat("0.00");
      str4 = ((DecimalFormat)localObject).format(this.jdField_a_of_type_Long / 1000.0D);
      localObject = ((DecimalFormat)localObject).format(this.jdField_b_of_type_Long / 1000.0D);
      awqx.b(null, "dc00898", "", str2, "0X8009AA6", "0X8009AA6", i, 0, str1, "3", str4 + ";" + (String)localObject, str3);
      if (!apck.c(this.jdField_a_of_type_Aovk.c())) {
        break label323;
      }
      aojd.a(this.jdField_a_of_type_Aovk.i());
    }
    for (;;)
    {
      super.i();
      return;
      if ((j == 5) || (j == 6))
      {
        str1 = "3";
        i = 2;
        str3 = str4;
        break;
      }
      if (j != 1)
      {
        str3 = str4;
        if (j != 2) {
          break;
        }
      }
      str1 = "3";
      str2 = this.jdField_a_of_type_Aovk.a();
      i = 1;
      str3 = str4;
      break;
      label323:
      aojd.b(this.jdField_a_of_type_Aovk.i());
    }
  }
  
  public void j()
  {
    super.j();
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    s();
  }
  
  public void k()
  {
    super.k();
    aozd localaozd = this.jdField_a_of_type_Aozd;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      localaozd.d(bool);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(17432576, 17432577);
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Aovk.h();
    if (i == 2) {
      if (this.jdField_a_of_type_Aovk.a() != null) {
        this.jdField_a_of_type_Aovk.a().b();
      }
    }
    for (;;)
    {
      n();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Aovk.a() != null) {
          this.jdField_a_of_type_Aovk.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 1, "Video stop transform, but status unknown!");
      }
    }
  }
  
  protected void n()
  {
    this.jdField_a_of_type_Aovk.a("0X8009D60", null);
    super.n();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(17432576, 17432577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoyb
 * JD-Core Version:    0.7.0.1
 */