import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.11;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.6;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.7;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;>;
import java.util.Iterator;
import java.util.List;

public class asvt
  extends asuu
  implements asid, asie, assz, VideoPlayerCallback
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new aswa(this);
  protected AudioManager a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new asvv(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new asvu(this);
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new asvy(this);
  private asif jdField_a_of_type_Asif;
  private asrm jdField_a_of_type_Asrm;
  public aswz a;
  private BaseVideoView jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  public final Runnable a;
  boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoFilePresenter.11(this);
  private long c = aszt.a().longValue();
  private boolean d;
  private boolean e;
  private boolean f;
  
  public asvt(asst paramasst, Activity paramActivity)
  {
    super(paramasst, paramActivity);
    this.jdField_a_of_type_JavaLangRunnable = new VideoFilePresenter.10(this);
    this.jdField_a_of_type_Aswz = new aswz(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    a(this.jdField_a_of_type_Aswz);
    s();
  }
  
  private int a(int paramInt)
  {
    long l2 = this.jdField_a_of_type_Long;
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = l2;
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs();
      }
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
              bcef.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private String b()
  {
    Object localObject;
    if (aszt.c(this.jdField_a_of_type_Asst.d())) {
      localObject = this.jdField_a_of_type_Asst.d();
    }
    String str;
    do
    {
      return localObject;
      if (this.jdField_a_of_type_Asrm == null) {
        break;
      }
      str = this.jdField_a_of_type_Asrm.b();
      localObject = str;
    } while (aszt.c(str));
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Aswz.f();
  }
  
  private void q()
  {
    String str = b();
    if ((str == null) && (this.jdField_a_of_type_Asst.d() == 1))
    {
      this.jdField_a_of_type_Aswz.h(true);
      if (this.jdField_a_of_type_Asst.b() == 16)
      {
        this.jdField_a_of_type_Aswz.a(this.jdField_a_of_type_Asst.d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692553));
        this.jdField_a_of_type_Asst.a(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)
    {
      return;
      r();
      this.jdField_a_of_type_Aswz.b(true);
      b(this.jdField_a_of_type_Asst.a());
      return;
    }
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mVideoPath = str;
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mSceneName = azjn.a(109);
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mCallback = this;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(localVideoPlayParam);
  }
  
  private void r()
  {
    this.jdField_a_of_type_Asrm = this.jdField_a_of_type_Asst.a();
    if (this.jdField_a_of_type_Asrm == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "get video biz, data is null!");
      return;
    }
    this.jdField_a_of_type_Asif = ashu.a(this.jdField_a_of_type_Asrm);
    this.jdField_a_of_type_Asif.a(this);
    this.jdField_a_of_type_Asif.a(this);
    this.jdField_a_of_type_Asif.a(true);
    this.jdField_a_of_type_Asif.a();
    this.jdField_a_of_type_Aswz.f(false);
    this.jdField_a_of_type_Aswz.b(true);
  }
  
  @SuppressLint({"InvalidWakeLockTag"})
  private void s()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(-1);
    if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null))
    {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("power")).newWakeLock(536870922, "FileBrowserPresenter<FileAssistant>");
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.6(this));
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.7(this));
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
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
    this.jdField_a_of_type_Aswz.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Aswz.d(10000);
    this.jdField_a_of_type_Aswz.a(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_Aswz.d();
    this.jdField_a_of_type_Asst.a(this);
    this.jdField_a_of_type_Aswz.f(false);
    b();
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = this.jdField_a_of_type_Aswz.a();
    q();
    if (this.jdField_a_of_type_Asqq != null) {
      this.jdField_a_of_type_Asqq.a(true);
    }
    if ((aszt.c(this.jdField_a_of_type_Asst.d())) && (this.jdField_a_of_type_Asst.i() == 2)) {
      this.jdField_a_of_type_Aswz.f(true);
    }
    int i = this.jdField_a_of_type_Asst.i();
    int j = this.jdField_a_of_type_Asst.h();
    if ((i == 6) && (j == 1))
    {
      this.jdField_a_of_type_Aswz.b(false);
      this.jdField_a_of_type_Aswz.f(false);
      this.jdField_a_of_type_Aswz.c(false);
    }
    this.jdField_a_of_type_Aswz.e(this.jdField_a_of_type_Asst.l());
    u();
    bhlx.a(this.jdField_a_of_type_AndroidAppActivity, 53);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "!!!! onDownloadInfoSucc mVideoViwe null !!!!");
      return;
    }
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLocal = false;
    localVideoPlayParam.mSavePath = paramSuperPlayerVideoInfo.getLocalSavePath();
    localVideoPlayParam.mFileID = paramSuperPlayerVideoInfo.getFileId();
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mSceneName = azjn.a(109);
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mCallback = this;
    localVideoPlayParam.mUrls = paramSuperPlayerVideoInfo.getPlayUrls();
    localVideoPlayParam.mCookies = paramSuperPlayerVideoInfo.getCookie();
    localVideoPlayParam.mVideoFormat = 104;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(localVideoPlayParam);
    u();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Aswz.f(true);
    this.jdField_a_of_type_Aswz.b(false);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new asvw(this));
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
        paramString = this.jdField_a_of_type_Asst.a();
        localObject2 = this.jdField_a_of_type_Asst.a();
        if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          break label217;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(paramArrayOfArrayList, (List)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new asvx(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
        this.f = true;
        return;
        if (paramArrayOfArrayList.length != 2) {
          break label246;
        }
        localObject2 = paramArrayOfArrayList[0];
        localObject1 = paramArrayOfArrayList[1];
        paramArrayOfArrayList = (ArrayList<ShareActionSheetBuilder.ActionSheetItem>[])localObject2;
        break;
        label217:
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramString);
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", (String)localObject2);
      }
      label246:
      paramArrayOfArrayList = null;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    try
    {
      aszr.a("0X8007426");
      aszr.a("0X8007427");
      this.jdField_a_of_type_Aswz.a(this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      this.jdField_a_of_type_Aswz.h(true);
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
      {
        this.jdField_a_of_type_Aswz.d(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying());
        return;
      }
      this.jdField_a_of_type_Aswz.d(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1) == 1;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.jdField_a_of_type_Aswz.f(true);
    this.jdField_a_of_type_Aswz.b(false);
    if ((this.jdField_a_of_type_Asst != null) && ((this.jdField_a_of_type_Asst instanceof atfo))) {
      q();
    }
  }
  
  public void g()
  {
    if (!FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_Asst.d())) {
      return;
    }
    this.jdField_a_of_type_Aswz.b(false);
    this.jdField_a_of_type_Aswz.f(true);
    this.jdField_a_of_type_Aswz.c(false);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Aswz.c();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(true);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = null;
    }
    if (this.jdField_a_of_type_Asif != null) {
      this.jdField_a_of_type_Asif.a(null);
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
    if (this.jdField_a_of_type_Asif != null) {
      this.jdField_a_of_type_Asif.a(false);
    }
    int i = 5;
    String str2 = "";
    String str1 = "4";
    String str4 = "";
    int j = this.jdField_a_of_type_Asst.l();
    String str3;
    if ((j == 3) || (j == 4))
    {
      str3 = this.jdField_a_of_type_Asst.b();
      str1 = "3";
      i = 2;
    }
    for (;;)
    {
      Object localObject = new DecimalFormat("0.00");
      str4 = ((DecimalFormat)localObject).format(this.jdField_a_of_type_Long / 1000.0D);
      localObject = ((DecimalFormat)localObject).format(this.jdField_b_of_type_Long / 1000.0D);
      bcef.b(null, "dc00898", "", str2, "0X8009AA6", "0X8009AA6", i, 0, str1, "3", str4 + ";" + (String)localObject, str3);
      super.i();
      return;
      if ((j == 5) || (j == 6))
      {
        str1 = "3";
        i = 2;
        str3 = str4;
      }
      else if (j != 1)
      {
        str3 = str4;
        if (j != 2) {}
      }
      else
      {
        str1 = "3";
        str2 = this.jdField_a_of_type_Asst.b();
        i = 1;
        str3 = str4;
      }
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
    aswz localaswz;
    if ((this.jdField_a_of_type_Aswz != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null))
    {
      localaswz = this.jdField_a_of_type_Aswz;
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localaswz.d(bool);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
      return;
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(17432576, 17432577);
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Asst.h();
    if (i == 2) {
      if (this.jdField_a_of_type_Asst.a() != null) {
        this.jdField_a_of_type_Asst.a().b();
      }
    }
    for (;;)
    {
      n();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Asst.a() != null) {
          this.jdField_a_of_type_Asst.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 1, "Video stop transform, but status unknown!");
      }
    }
  }
  
  protected void n()
  {
    this.jdField_a_of_type_Asst.a("0X8009D60", null);
    super.n();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(17432576, 17432577);
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    QLog.i("FileBrowserPresenter<FileAssistant>", 1, "@@@@@@@@@@@ videoView Download Success:" + paramLong);
    this.jdField_a_of_type_Asif.c();
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
    case 3: 
    case 5: 
      this.jdField_a_of_type_Aswz.h(true);
      return;
    case 4: 
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs();
      }
      this.jdField_a_of_type_Aswz.a(this.jdField_a_of_type_Long);
      if (b() != null)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label130;
        }
        this.jdField_a_of_type_Aswz.b(false);
        this.jdField_a_of_type_Aswz.f(true);
      }
      for (;;)
      {
        this.jdField_a_of_type_Aswz.h(false);
        return;
        paramInt = 0;
        break;
        label130:
        this.jdField_a_of_type_Aswz.b(true);
        this.jdField_a_of_type_Aswz.f(false);
      }
    }
    this.d = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    this.jdField_a_of_type_Aswz.c(0);
    this.jdField_a_of_type_Aswz.b(0L);
    this.jdField_a_of_type_Aswz.d(false);
  }
  
  public void p()
  {
    List localList = null;
    ArrayList[] arrayOfArrayList;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      arrayOfArrayList = this.jdField_a_of_type_Asst.b();
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
 * Qualified Name:     asvt
 * JD-Core Version:    0.7.0.1
 */