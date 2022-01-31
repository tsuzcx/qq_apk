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

public class arnb
  extends armd
  implements aqxm, arko
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new arnh(this);
  protected AudioManager a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new arnj(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new arni(this);
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new arnm(this);
  public aron a;
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
  
  public arnb(arki paramarki, Activity paramActivity)
  {
    super(paramarki, paramActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new VideoFilePresenter.18(this);
    this.jdField_a_of_type_Aron = new aron(paramActivity);
    a(this.jdField_a_of_type_Aron);
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
              azqs.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_Aron.f();
  }
  
  private void q()
  {
    if ((!arrr.c(this.jdField_a_of_type_Arki.d())) && (this.jdField_a_of_type_Arki.d() == 1))
    {
      this.jdField_a_of_type_Aron.h(true);
      if (this.jdField_a_of_type_Arki.b() == 16)
      {
        this.jdField_a_of_type_Aron.a(this.jdField_a_of_type_Arki.d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692973));
        this.jdField_a_of_type_Arki.a(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
        }
        return;
      }
      r();
      this.jdField_a_of_type_Aron.b(true);
      b(this.jdField_a_of_type_Arki.a());
      return;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Arki.d();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_video_file");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setPlayType(4);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Arki.d(), 0L, 0L, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
  
  private void r()
  {
    arit localarit = this.jdField_a_of_type_Arki.a();
    if (localarit == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "get video biz, data is null!");
      return;
    }
    aqxi.a(localarit.a()).a(localarit, new arnf(this));
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
    this.jdField_a_of_type_Aron.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Aron.d(10000);
    this.jdField_a_of_type_Aron.a(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_Aron.d();
    this.jdField_a_of_type_Arki.a(this);
    this.jdField_a_of_type_Aron.f(false);
    aqxi.a(this.jdField_a_of_type_AndroidAppActivity, new arnc(this));
    if (this.jdField_a_of_type_Arhx != null) {
      this.jdField_a_of_type_Arhx.a(true);
    }
    if ((arrr.c(this.jdField_a_of_type_Arki.d())) && (this.jdField_a_of_type_Arki.i() == 2)) {
      this.jdField_a_of_type_Aron.f(true);
    }
    int i = this.jdField_a_of_type_Arki.i();
    int j = this.jdField_a_of_type_Arki.h();
    if ((i == 6) && (j == 1))
    {
      this.jdField_a_of_type_Aron.b(false);
      this.jdField_a_of_type_Aron.f(false);
      this.jdField_a_of_type_Aron.c(true);
    }
    this.jdField_a_of_type_Aron.e(this.jdField_a_of_type_Arki.k());
    bexu.a(this.jdField_a_of_type_AndroidAppActivity, 53);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new arnk(this));
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
        paramString = this.jdField_a_of_type_Arki.a();
        localObject2 = this.jdField_a_of_type_Arki.a();
        if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          break label260;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(paramArrayOfArrayList, (List)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new arnl(this));
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
  
  public void aG_()
  {
    n();
  }
  
  public void aH_()
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
      arrp.a("0X8007426");
      arrp.a("0X8007427");
      this.jdField_a_of_type_Aron.a(this.jdField_a_of_type_Arki.k(), this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = aqxi.a(this.jdField_a_of_type_Arki.k()).a();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = aqxi.a(this.jdField_a_of_type_Arki.k()).a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_Aron.b(), this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new arnn(this));
      this.jdField_a_of_type_Aron.h(true);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new arno(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new arnp(this));
      q();
      this.jdField_a_of_type_Aron.d(d());
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new arnd(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCaptureImageListener(new arne(this));
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
    this.jdField_a_of_type_Aron.f(false);
    this.jdField_a_of_type_Aron.b(true);
    this.jdField_a_of_type_Aron.c(false);
    b(this.jdField_a_of_type_Arki.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aron.f(true);
    this.jdField_a_of_type_Aron.b(false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aron.f(true);
    this.jdField_a_of_type_Aron.b(false);
    if ((this.jdField_a_of_type_Arki != null) && ((this.jdField_a_of_type_Arki instanceof arka))) {
      q();
    }
  }
  
  public void g()
  {
    if (!arso.b(this.jdField_a_of_type_Arki.d())) {
      return;
    }
    this.jdField_a_of_type_Aron.b(false);
    this.jdField_a_of_type_Aron.f(false);
    this.jdField_a_of_type_Aron.c(true);
  }
  
  public void i()
  {
    int i = 5;
    this.jdField_a_of_type_Aron.c();
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
    int j = this.jdField_a_of_type_Arki.k();
    String str3;
    if ((j == 3) || (j == 4))
    {
      str3 = this.jdField_a_of_type_Arki.b();
      str1 = "3";
      i = 2;
      Object localObject = new DecimalFormat("0.00");
      str4 = ((DecimalFormat)localObject).format(this.jdField_a_of_type_Long / 1000.0D);
      localObject = ((DecimalFormat)localObject).format(this.jdField_b_of_type_Long / 1000.0D);
      azqs.b(null, "dc00898", "", str2, "0X8009AA6", "0X8009AA6", i, 0, str1, "3", str4 + ";" + (String)localObject, str3);
      if (!arrr.c(this.jdField_a_of_type_Arki.d())) {
        break label319;
      }
      aqxi.a(this.jdField_a_of_type_Arki.k());
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
      str2 = this.jdField_a_of_type_Arki.b();
      i = 1;
      str3 = str4;
      break;
      label319:
      aqxi.b(this.jdField_a_of_type_Arki.k());
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
    aron localaron = this.jdField_a_of_type_Aron;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      localaron.d(bool);
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
    int i = this.jdField_a_of_type_Arki.h();
    if (i == 2) {
      if (this.jdField_a_of_type_Arki.a() != null) {
        this.jdField_a_of_type_Arki.a().b();
      }
    }
    for (;;)
    {
      n();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Arki.a() != null) {
          this.jdField_a_of_type_Arki.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 1, "Video stop transform, but status unknown!");
      }
    }
  }
  
  protected void n()
  {
    this.jdField_a_of_type_Arki.a("0X8009D60", null);
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
      arrayOfArrayList = this.jdField_a_of_type_Arki.b();
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
 * Qualified Name:     arnb
 * JD-Core Version:    0.7.0.1
 */