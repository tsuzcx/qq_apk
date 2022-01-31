import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.13;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.14;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.15;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.16;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.18;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.19;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aris
  extends arhu
  implements aqtd, argf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new ariy(this);
  protected AudioManager a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new arja(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new ariz(this);
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new arjd(this);
  public arke a;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  public TVK_IMediaPlayer a;
  protected TVK_IProxyFactory a;
  public TVK_PlayerVideoInfo a;
  public final Runnable a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private long jdField_b_of_type_Long;
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoFilePresenter.19(this);
  private boolean d;
  private boolean e;
  private boolean f;
  
  public aris(arfz paramarfz, Activity paramActivity)
  {
    super(paramarfz, paramActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new VideoFilePresenter.18(this);
    this.jdField_a_of_type_Arke = new arke(paramActivity);
    a(this.jdField_a_of_type_Arke);
    s();
  }
  
  private int a(int paramInt)
  {
    long l2 = this.jdField_a_of_type_Long;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    float f1 = paramInt / 10000.0F;
    return (int)((float)l1 * f1);
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList)
  {
    if ((paramArrayOfArrayList != null) && (paramArrayOfArrayList.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfArrayList.length)
      {
        Object localObject = paramArrayOfArrayList[i];
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).action == 26) {
              azmj.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Arke.f();
  }
  
  private void q()
  {
    if ((!arni.c(this.jdField_a_of_type_Arfz.d())) && (this.jdField_a_of_type_Arfz.d() == 1))
    {
      this.jdField_a_of_type_Arke.h(true);
      if (this.jdField_a_of_type_Arfz.b() == 16)
      {
        this.jdField_a_of_type_Arke.a(this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692971));
        this.jdField_a_of_type_Arfz.a(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
        }
        return;
      }
      r();
      this.jdField_a_of_type_Arke.b(true);
      b(this.jdField_a_of_type_Arfz.a());
      return;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Arfz.d();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_video_file");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setPlayType(4);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Arfz.d(), 0L, 0L, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
  
  private void r()
  {
    arek localarek = this.jdField_a_of_type_Arfz.a();
    if (localarek == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "get video biz, data is null!");
      return;
    }
    aqsz.a(localarek.a()).a(localarek, new ariw(this));
  }
  
  private void s()
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
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.13(this));
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.14(this));
  }
  
  private void v()
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
    this.jdField_a_of_type_Arke.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Arke.d(10000);
    this.jdField_a_of_type_Arke.a(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_Arke.d();
    this.jdField_a_of_type_Arfz.a(this);
    this.jdField_a_of_type_Arke.f(false);
    aqsz.a(this.jdField_a_of_type_AndroidAppActivity, new arit(this));
    if (this.jdField_a_of_type_Ardo != null) {
      this.jdField_a_of_type_Ardo.a(true);
    }
    if ((arni.c(this.jdField_a_of_type_Arfz.d())) && (this.jdField_a_of_type_Arfz.i() == 2)) {
      this.jdField_a_of_type_Arke.f(true);
    }
    int i = this.jdField_a_of_type_Arfz.i();
    int j = this.jdField_a_of_type_Arfz.h();
    if ((i == 6) && (j == 1))
    {
      this.jdField_a_of_type_Arke.b(false);
      this.jdField_a_of_type_Arke.f(false);
      this.jdField_a_of_type_Arke.c(true);
    }
    this.jdField_a_of_type_Arke.e(this.jdField_a_of_type_Arfz.k());
    betl.a(this.jdField_a_of_type_AndroidAppActivity, 53);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.15(this, paramInt, paramString));
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localObject2 = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject2).context = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new arjb(this));
    if (paramArrayOfArrayList != null) {
      if (paramArrayOfArrayList.length == 1) {
        paramArrayOfArrayList = paramArrayOfArrayList[0];
      }
    }
    for (;;)
    {
      if (((paramArrayOfArrayList != null) && (!paramArrayOfArrayList.isEmpty())) || ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(paramString);
        paramString = this.jdField_a_of_type_Arfz.a();
        localObject2 = this.jdField_a_of_type_Arfz.a();
        if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          break label260;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(paramArrayOfArrayList, (List)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new arjc(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
        this.f = true;
        if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing()) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))) {}
        try
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.captureImageInTime(0, 0);
          return;
        }
        catch (IllegalAccessException paramArrayOfArrayList)
        {
          paramArrayOfArrayList.printStackTrace();
          return;
        }
        if (paramArrayOfArrayList.length != 2) {
          break label295;
        }
        localObject2 = paramArrayOfArrayList[0];
        localObject1 = paramArrayOfArrayList[1];
        paramArrayOfArrayList = (ArrayList<ShareActionSheetBuilder.ActionSheetItem>[])localObject2;
        break;
        label260:
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramString);
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", (String)localObject2);
      }
      label295:
      paramArrayOfArrayList = null;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void aJ_()
  {
    n();
  }
  
  public void aK_()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.16(this));
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    try
    {
      arng.a("0X8007426");
      arng.a("0X8007427");
      this.jdField_a_of_type_Arke.a(this.jdField_a_of_type_Arfz.k(), this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = aqsz.a(this.jdField_a_of_type_Arfz.k()).a();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = aqsz.a(this.jdField_a_of_type_Arfz.k()).a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_Arke.b(), this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new arje(this));
      this.jdField_a_of_type_Arke.h(true);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new arjf(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new arjg(this));
      q();
      this.jdField_a_of_type_Arke.d(d());
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new ariu(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCaptureImageListener(new ariv(this));
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
    this.jdField_a_of_type_Arke.f(false);
    this.jdField_a_of_type_Arke.b(true);
    this.jdField_a_of_type_Arke.c(false);
    b(this.jdField_a_of_type_Arfz.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Arke.f(true);
    this.jdField_a_of_type_Arke.b(false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Arke.f(true);
    this.jdField_a_of_type_Arke.b(false);
    if ((this.jdField_a_of_type_Arfz != null) && ((this.jdField_a_of_type_Arfz instanceof arfr))) {
      q();
    }
  }
  
  public void g()
  {
    if (!arof.b(this.jdField_a_of_type_Arfz.d())) {
      return;
    }
    this.jdField_a_of_type_Arke.b(false);
    this.jdField_a_of_type_Arke.f(false);
    this.jdField_a_of_type_Arke.c(true);
  }
  
  public void i()
  {
    int i = 5;
    this.jdField_a_of_type_Arke.c();
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
    int j = this.jdField_a_of_type_Arfz.k();
    String str3;
    if ((j == 3) || (j == 4))
    {
      str3 = this.jdField_a_of_type_Arfz.b();
      str1 = "3";
      i = 2;
      Object localObject = new DecimalFormat("0.00");
      str4 = ((DecimalFormat)localObject).format(this.jdField_a_of_type_Long / 1000.0D);
      localObject = ((DecimalFormat)localObject).format(this.jdField_b_of_type_Long / 1000.0D);
      azmj.b(null, "dc00898", "", str2, "0X8009AA6", "0X8009AA6", i, 0, str1, "3", str4 + ";" + (String)localObject, str3);
      if (!arni.c(this.jdField_a_of_type_Arfz.d())) {
        break label319;
      }
      aqsz.a(this.jdField_a_of_type_Arfz.k());
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
      str2 = this.jdField_a_of_type_Arfz.b();
      i = 1;
      str3 = str4;
      break;
      label319:
      aqsz.b(this.jdField_a_of_type_Arfz.k());
    }
  }
  
  public void j()
  {
    super.j();
    if (this.f)
    {
      this.f = false;
      return;
    }
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    t();
  }
  
  public void k()
  {
    super.k();
    arke localarke = this.jdField_a_of_type_Arke;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      localarke.d(bool);
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
    int i = this.jdField_a_of_type_Arfz.h();
    if (i == 2) {
      if (this.jdField_a_of_type_Arfz.a() != null) {
        this.jdField_a_of_type_Arfz.a().b();
      }
    }
    for (;;)
    {
      n();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Arfz.a() != null) {
          this.jdField_a_of_type_Arfz.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 1, "Video stop transform, but status unknown!");
      }
    }
  }
  
  protected void n()
  {
    this.jdField_a_of_type_Arfz.a("0X8009D60", null);
    super.n();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(17432576, 17432577);
  }
  
  public void p()
  {
    List localList = null;
    ArrayList[] arrayOfArrayList;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      arrayOfArrayList = this.jdField_a_of_type_Arfz.b();
      if (arrayOfArrayList == null) {
        break label103;
      }
      if (arrayOfArrayList.length != 1) {
        break label86;
      }
      localArrayList = arrayOfArrayList[0];
    }
    for (;;)
    {
      if (((localArrayList != null) && (!localArrayList.isEmpty())) || ((localList != null) && (!localList.isEmpty()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList, localList);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
      }
      return;
      label86:
      if (arrayOfArrayList.length == 2)
      {
        localArrayList = arrayOfArrayList[0];
        localList = arrayOfArrayList[1];
      }
      else
      {
        label103:
        localArrayList = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aris
 * JD-Core Version:    0.7.0.1
 */