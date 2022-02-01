import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.10;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.13;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.3;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.4;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.util.VersionUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class bbrz
  extends bbqx
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public long a;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public bbqi a;
  private bixb jdField_a_of_type_Bixb;
  public BaseVideoView a;
  public GalleryUrlImageView a;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout b;
  public SeekBar b;
  public TextView b;
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ImageView c;
  public RelativeLayout c;
  public TextView c;
  public ImageButton d;
  public TextView d;
  public ImageButton e;
  public TextView e;
  
  public bbrz(Activity paramActivity, bbqi parambbqi)
  {
    super(paramActivity, parambbqi);
    this.jdField_a_of_type_Bbqi = parambbqi;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "drawable2Bitmap, drawable is null");
      }
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  private VideoPlayParam a(aklw paramaklw)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    MessageForShortVideo localMessageForShortVideo = paramaklw.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    localVideoPlayParam.mSceneId = 101;
    localVideoPlayParam.mSceneName = (bapv.a(101) + "_FulScr");
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (localAIOVideoData.jdField_d_of_type_Int == 1))
    {
      localVideoPlayParam.mSceneId = 100;
      localVideoPlayParam.mSceneName = (bapv.a(100) + "_FulScr");
    }
    if (this.jdField_a_of_type_Bbqi != null) {
      localVideoPlayParam.mIsMute = this.jdField_a_of_type_Bbqi.b(paramaklw.jdField_a_of_type_Long);
    }
    if (!localVideoPlayParam.mIsMute) {
      k();
    }
    if (paramaklw.jdField_a_of_type_Boolean)
    {
      localVideoPlayParam.mUrls = paramaklw.jdField_a_of_type_ArrayOfJavaLangString;
      localVideoPlayParam.mSavePath = paramaklw.jdField_a_of_type_JavaLangString;
      if (paramaklw.jdField_a_of_type_Boolean) {
        break label332;
      }
    }
    label332:
    for (boolean bool = true;; bool = false)
    {
      localVideoPlayParam.mIsLocal = bool;
      if (localMessageForShortVideo != null)
      {
        long l = localMessageForShortVideo.videoFileTime * 1000;
        localVideoPlayParam.mVideoFileTimeMs = l;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo, videoDuration = " + l);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(l));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
        localVideoPlayParam.mFileID = (localMessageForShortVideo.md5 + localMessageForShortVideo.uniseq);
        localVideoPlayParam.mFileSize = localMessageForShortVideo.videoFileSize;
      }
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      a(localVideoPlayParam);
      return localVideoPlayParam;
      localVideoPlayParam.mVideoPath = paramaklw.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    String str1 = null;
    if (paramInt1 == 2)
    {
      localObject = this.jdField_a_of_type_Bbqi.a(a());
      if ((localObject != null) && (((aklw)localObject).jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.isEmpty(((aklw)localObject).jdField_b_of_type_JavaLangString)))
      {
        String[] arrayOfString = ((aklw)localObject).jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (!StringUtil.isEmpty(str2)) {
            InnerDns.getInstance().reportBadIp(((aklw)localObject).jdField_b_of_type_JavaLangString, InnerDns.getHostFromUrl(str2), 1005);
          }
          i += 1;
        }
        bbqt.a().a();
      }
    }
    if (paramInt1 == 1) {
      str1 = this.mContext.getString(2131718849);
    }
    if (paramInt2 == 14011001)
    {
      str1 = this.mContext.getString(2131718121);
      this.jdField_a_of_type_Bbqi.a(5002, 0L);
    }
    Object localObject = a();
    if (localObject != null) {
      if (str1 == null) {
        break label300;
      }
    }
    for (;;)
    {
      ((AIOVideoData)localObject).jdField_f_of_type_JavaLangString = str1;
      ((AIOVideoData)localObject).l += 1;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "handlePlayError, videoData.mPlayErrTimes = " + ((AIOVideoData)localObject).l);
      if ((!bapw.a(paramInt2, paramVideoPlayParam)) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) || (localObject == null) || (((AIOVideoData)localObject).l >= 2)) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "handlePlayError, auto replay video.");
      ThreadManager.getUIHandler().post(new AIOVideoView.3(this, (AIOVideoData)localObject));
      return;
      label300:
      str1 = this.mContext.getString(2131718852);
    }
    ThreadManager.getUIHandler().post(new AIOVideoView.4(this));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt);
    }
    Object localObject1 = this.jdField_a_of_type_Bbqi.getItem(paramInt);
    Object localObject2;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localObject1 = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt + " , msgId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Long);
      }
      ((AIOVideoData)localObject1).m = paramInt;
      ((AIOVideoData)localObject1).i = paramBoolean;
      localObject2 = this.jdField_a_of_type_Bbqi;
      long l = ((AIOVideoData)localObject1).jdField_a_of_type_Long;
      if (!paramBoolean) {
        bool = true;
      }
      ((bbqi)localObject2).b(l, bool);
      localObject2 = this.jdField_a_of_type_Bbqi.a((AIOVideoData)localObject1);
      if (localObject2 == null)
      {
        this.jdField_a_of_type_Bbqi.b((AIOVideoData)localObject1);
        this.jdField_a_of_type_Bbqi.a(((AIOVideoData)localObject1).jdField_a_of_type_Long, ((AIOVideoData)localObject1).jdField_a_of_type_Int, 4);
        updateUI();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateItemStatus VIDEO_GETTING_URL , shortVideoData.msgId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Long + ", shortVideoData.subId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Int);
      }
    }
    else
    {
      return;
    }
    a((aklw)localObject2);
  }
  
  private void a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    HashMap localHashMap;
    if (!this.jdField_a_of_type_Bbqi.a(paramLong))
    {
      long l = this.jdField_a_of_type_Bbqi.a(paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "reportForVideoStartPlayCost, id:" + paramLong + ", clickBubbleTime = " + l);
      }
      if (l > 0L)
      {
        paramLong = System.currentTimeMillis() - l;
        localHashMap = new HashMap();
        localHashMap.put("timeCost", String.valueOf(paramLong));
        localHashMap.put("busiType", paramVideoPlayParam.mSceneName);
        if (!paramVideoPlayParam.mIsLocal) {
          break label203;
        }
      }
    }
    label203:
    for (String str = "actVideoFSPlayCost";; str = "acVideoFSPlayCost_Online")
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "report video start play cost , reportName = " + str + " , timeCost = " + paramLong + " , busiType = " + paramVideoPlayParam.mSceneName);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(aklw paramaklw)
  {
    if (paramaklw == null) {}
    do
    {
      return;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo id = " + paramaklw.jdField_a_of_type_Long);
      this.jdField_a_of_type_Bbqi.a(paramaklw.jdField_a_of_type_Long, paramaklw.jdField_b_of_type_Int, 5);
      updateUI();
      this.jdField_a_of_type_Bbqi.a(0L, 0L, bbph.a().c());
      paramaklw = a(paramaklw);
    } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(paramaklw);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, videoFrame null");
      }
    }
    do
    {
      return;
      try
      {
        localObject = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath();
        localObject = new File((String)localObject + File.separator + "tmpaiovideoframe.jpg");
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        this.jdField_a_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, write tmp file:" + this.jdField_a_of_type_JavaLangString);
        }
        FileUtil.writeBitmapToFile(paramBitmap, this.jdField_a_of_type_JavaLangString);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Object localObject;
          localIOException.printStackTrace();
          continue;
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "detectQQCodeFromBmp scannerResult is null");
        }
        ThreadManager.getUIHandler().post(new AIOVideoView.13(this, localIOException));
      }
      localObject = new ArrayList();
      paramBitmap = zmk.a(paramBitmap, 3);
      if (paramBitmap == null) {
        break;
      }
      if (paramBitmap.d())
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, detected QRCode, build item");
        }
        bhhh.a(126, (ArrayList)localObject, this.jdField_a_of_type_JavaLangString, 0);
      }
      if (paramBitmap.c())
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, detected MiniCode, build item");
        }
        bhhh.a(127, (ArrayList)localObject, this.jdField_a_of_type_JavaLangString, 0);
      }
      if (!((ArrayList)localObject).isEmpty()) {
        break label265;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, detected nothing");
    return;
    label265:
  }
  
  private void a(AIOVideoData paramAIOVideoData)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, bbph.a().a());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_a_of_type_Bbqi.getSelectedItem() != null)
        {
          Object localObject = this.jdField_a_of_type_Bbqi.getSelectedItem().baseData;
          if ((localObject instanceof AIOVideoData))
          {
            localObject = (AIOVideoData)localObject;
            int i = ((AIOVideoData)localObject).jdField_g_of_type_Int;
            AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
            if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOVideoData)localObject).jdField_d_of_type_JavaLangString)))
            {
              paramAIOVideoData.putExtra("param_key_redbag_type", i);
              paramAIOVideoData.putExtra("param_key_redbag_video_id", ((AIOVideoData)localObject).jdField_c_of_type_JavaLangString);
              paramAIOVideoData.putExtra("from_session_uin", ((AIOVideoData)localObject).jdField_e_of_type_JavaLangString);
            }
            if (((AIOVideoData)localObject).k == 2) {
              paramAIOVideoData.putExtra("special_video_type", ((AIOVideoData)localObject).k);
            }
            if (!TextUtils.isEmpty(((AIOVideoData)localObject).jdField_g_of_type_JavaLangString))
            {
              paramAIOVideoData.putExtra("widgetinfo", ((AIOVideoData)localObject).jdField_g_of_type_JavaLangString);
              paramAIOVideoData.putExtra("key_camera_material_name", ((AIOVideoData)localObject).h);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOVideoData);
      }
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    int j = 0;
    File localFile = new bbpy().a(paramAIOVideoData, 1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqi.getSelectedItem();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    long l;
    int i;
    if ((localFile != null) && (localFile.exists()))
    {
      l = localFile.length();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showActionSheetForShortVideo, file.getPath()=" + localFile.getPath() + ", mTransferredSize = " + l + ", data.size = " + paramAIOVideoData.jdField_c_of_type_Long);
      if (paramAIOVideoData.jdField_d_of_type_Int == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      if ((paramAIOVideoData.jdField_d_of_type_Int != 1) || (i == 0)) {
        j = 1;
      }
      if (j != 0) {
        bhhh.a(2, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((VersionUtils.isIceScreamSandwich()) && ((paramAIOVideoData.jdField_d_of_type_Int != 1) || (i == 0))) {
        bhhh.a(39, this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (i == 0)
      {
        bhhh.a(6, this.jdField_b_of_type_JavaUtilArrayList);
        bhhh.a(3, this.jdField_a_of_type_JavaUtilArrayList);
        bhhh.a(27, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((bbph.a().g()) && (!TextUtils.isEmpty(bbph.a().c())) && (bbph.a().a() != -1)) {
        bhhh.a(54, this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (i == 0) {
        bhhh.a(64, this.jdField_a_of_type_JavaUtilArrayList);
      }
      a(paramAIOVideoData, localFile, paramInt, localRichMediaBrowserInfo);
      if (this.mContext != null) {
        this.mContext.getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList);
      if (j != 0) {
        a(paramAIOVideoData);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
      if (l < paramAIOVideoData.jdField_c_of_type_Long)
      {
        i = 1;
        continue;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, bbph.a().a());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_a_of_type_Bbqi.getSelectedItem() != null)
        {
          Object localObject = this.jdField_a_of_type_Bbqi.getSelectedItem().baseData;
          if ((localObject instanceof AIOVideoData))
          {
            localObject = (AIOVideoData)localObject;
            int i = ((AIOVideoData)localObject).jdField_g_of_type_Int;
            AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
            if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOVideoData)localObject).jdField_d_of_type_JavaLangString)))
            {
              paramAIOVideoData.putExtra("param_key_redbag_type", i);
              paramAIOVideoData.putExtra("param_key_redbag_video_id", ((AIOVideoData)localObject).jdField_c_of_type_JavaLangString);
              paramAIOVideoData.putExtra("from_session_uin", ((AIOVideoData)localObject).jdField_e_of_type_JavaLangString);
            }
            if (((AIOVideoData)localObject).k == 2) {
              paramAIOVideoData.putExtra("special_video_type", ((AIOVideoData)localObject).k);
            }
            if (!TextUtils.isEmpty(((AIOVideoData)localObject).jdField_g_of_type_JavaLangString))
            {
              paramAIOVideoData.putExtra("widgetinfo", ((AIOVideoData)localObject).jdField_g_of_type_JavaLangString);
              paramAIOVideoData.putExtra("key_camera_material_name", ((AIOVideoData)localObject).h);
            }
          }
        }
        if (paramInt != 72) {
          break label310;
        }
        paramAIOVideoData.putExtra("key_req", ForwardRecentActivity.jdField_f_of_type_Int);
        paramAIOVideoData.putExtra("key_direct_show_uin_type", paramActionSheetItem.uinType);
        paramAIOVideoData.putExtra("key_direct_show_uin", paramActionSheetItem.uin);
        aupt.a(this.mContext, paramAIOVideoData, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
      }
    }
    for (;;)
    {
      if (bbph.a().c()) {
        axiv.a("0X8009ABC");
      }
      return;
      label310:
      aupt.a(this.mContext, paramAIOVideoData, 100500, " biz_src_jc_video");
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new bbsd(this, paramVideoPlayParam);
  }
  
  private void a(String paramString, int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "0", "0", "");
      return;
      if (paramInt == 1) {
        paramInt = 2;
      } else if (paramInt == 3000) {
        paramInt = 3;
      } else if (paramInt == 6000) {
        paramInt = 4;
      } else {
        paramInt = -1;
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqi.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (this.jdField_a_of_type_Bbqi.a((AIOVideoData)localRichMediaBrowserInfo.baseData) != null))
      {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null) {
      this.jdField_a_of_type_Bbqi.a(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, paramInt);
    }
  }
  
  private void b(AIOVideoData paramAIOVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + paramAIOVideoData.jdField_b_of_type_JavaLangString), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.mContext.startActivity(localIntent);
    int i = paramAIOVideoData.jdField_b_of_type_Int;
    if (i == 0)
    {
      bdla.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      return;
    }
    if (i == 3000)
    {
      bdla.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      return;
    }
    if (i == 1)
    {
      bdla.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      return;
    }
    bdla.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
  }
  
  private void b(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (paramAIOVideoData.j == 5002)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
      QQToast.a(this.mContext, 1, anvx.a(2131699534), 0).a();
    }
    do
    {
      return;
      if (!CheckPermission.isHasStoragePermission(this.mContext))
      {
        CheckPermission.requestStorePermission(this.mContext, null);
        return;
      }
      if (paramAIOVideoData.jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_Bbqi.a(paramInt, paramFile);
        return;
      }
      if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOVideoData.jdField_c_of_type_Long))
      {
        paramAIOVideoData = new StringBuilder().append(paramFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramFile.getAbsolutePath(), this.jdField_a_of_type_Bbqi.jdField_a_of_type_MqqOsMqqHandler, paramAIOVideoData, false));
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        this.jdField_a_of_type_Bbqi.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
        return;
      }
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOVideoData.jdField_c_of_type_Long > 29360128L))
      {
        a(3, paramAIOVideoData, paramRichMediaBrowserInfo);
        return;
      }
      this.jdField_a_of_type_Bbqi.a(paramAIOVideoData);
      this.jdField_a_of_type_Bbqi.a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, 2);
      updateUI();
    } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
  }
  
  private void c(AIOVideoData paramAIOVideoData)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, bbph.a().a());
      if (localIntent != null)
      {
        bmad.a(localIntent).a(this.mContext, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        bman.a(null, 3, 0, paramAIOVideoData.jdField_b_of_type_Int);
        bman.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void i()
  {
    if (this.mBrowserItemView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131380854));
      Object localObject = (RelativeLayout)this.mBrowserItemView.findViewById(2131372303);
      this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)localObject).findViewById(2131372047);
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377267));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372304));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373226));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379301));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new bbsa(this));
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374355));
      this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(anvx.a(2131699548));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131380526));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380528));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380527));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364700));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131364110));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131376092));
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374354));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374356));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374362));
      this.jdField_e_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131364246));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131364247));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = this.mBrowserItemView.findViewById(2131381061);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374357));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mBrowserItemView.findViewById(2131373141));
      this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131373143));
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
      }
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  private void i(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
    l();
    if (this.jdField_a_of_type_Bbqi.a(this.jdField_a_of_type_Bbqi.getCurrentPosition())) {
      this.jdField_a_of_type_Bbqi.a(true);
    }
  }
  
  private void k()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  private void l()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void m()
  {
    AIOVideoData localAIOVideoData = this.jdField_a_of_type_Bbqi.a();
    if (localAIOVideoData != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
        break label90;
      }
    }
    label90:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();; l = 0L)
    {
      MiniChatActivity.a(this.mContext, bbph.a().a(), bbph.a().a(), false, 26, localAIOVideoData.jdField_d_of_type_Long, l);
      if ((localAIOVideoData != null) && (localAIOVideoData.status == 5))
      {
        this.jdField_a_of_type_Bbqi.a(localAIOVideoData.jdField_a_of_type_Long, true);
        j();
      }
      this.jdField_a_of_type_Bbqi.l();
      return;
    }
  }
  
  private void n()
  {
    if ((this.mContext instanceof AIOGalleryActivity))
    {
      AIOGalleryActivity localAIOGalleryActivity = (AIOGalleryActivity)this.mContext;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!PermissionUtils.isStorePermissionEnable(this.mContext))
        {
          localAIOGalleryActivity.requestPermissions(new bbse(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return;
        }
        o();
        return;
      }
      o();
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onClick, activity:" + this.mContext);
  }
  
  private void o()
  {
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (!TextUtils.isEmpty(localAIOVideoData.jdField_g_of_type_JavaLangString)))
    {
      bpnk.a(this.mContext, localAIOVideoData.jdField_g_of_type_JavaLangString);
      bdla.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", localAIOVideoData.jdField_g_of_type_JavaLangString, "");
    }
  }
  
  private void p()
  {
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      if (this.jdField_a_of_type_Bixb != null) {
        this.jdField_a_of_type_Bixb.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
        break label131;
      }
    }
    label131:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();; l = 0L)
    {
      this.jdField_a_of_type_Bixb = new bixb(this.mContext);
      aklw localaklw = this.jdField_a_of_type_Bbqi.a(localAIOVideoData);
      if (localaklw == null) {
        break;
      }
      this.jdField_a_of_type_Bixb.a(localaklw, localAIOVideoData.jdField_e_of_type_Long, l);
      this.jdField_a_of_type_Bixb.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int);
      if (this.jdField_a_of_type_Bixb.a(localAIOVideoData.jdField_b_of_type_Int, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int)) {
        this.jdField_a_of_type_Bbqi.back();
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
  }
  
  public AIOVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqi.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return (AIOVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isLocalPlay()) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()))
    {
      Object localObject = this.mContext.getString(2131718844);
      localObject = bhdj.a(this.mContext, 230, null, (String)localObject, 2131694291, 2131720187, new bbsh(this), new bbsi(this));
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      a((Dialog)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) {
        break label94;
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "showActionSheet, captureCurFrame, from:" + paramInt + ", pos:" + l);
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.captureCurFrame(l, 0, 0);
    }
    for (;;)
    {
      a(localAIOVideoData, paramInt);
      return;
      label94:
      if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "showActionSheet, captureCurFrame, from:" + paramInt + ", pos:" + this.jdField_b_of_type_Long);
        }
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.captureCurFrame(this.jdField_b_of_type_Long, 0, 0);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "showActionSheet, video is not playing, recognize thumbnail");
        }
        ThreadManager.getSubThreadHandler().post(new AIOVideoView.10(this));
      }
    }
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(bhdj.a(this.mContext, 230, this.mContext.getString(2131718160), this.mContext.getString(2131718159), new bbsb(this, paramInt, paramObject), new bbsc(this)));
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      int i = RichMediaBrowserManager.getInstance().getProvider().getSaveFileProgress(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int);
      if ((i < 0) || (i >= 100)) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg isSaving:" + bool);
      if (bool)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg cancelDownloadMedia");
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, 256);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "notifyVideoUrl ");
    this.jdField_a_of_type_Bbqi.a(paramLong, paramInt1, paramInt2, paramString1);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData == null) {}
    label160:
    label295:
    label305:
    for (;;)
    {
      return;
      bbqt.a().a(localAIOVideoData.jdField_a_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt3, paramString2);
      paramString2 = new aklw();
      paramString2.jdField_a_of_type_Boolean = true;
      paramString2.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      paramString2.jdField_a_of_type_Int = paramInt3;
      paramString2.jdField_a_of_type_Long = localAIOVideoData.jdField_a_of_type_Long;
      paramString2.jdField_b_of_type_Int = localAIOVideoData.jdField_a_of_type_Int;
      paramString1 = new File(localAIOVideoData.jdField_b_of_type_JavaLangString);
      if (paramString1.exists())
      {
        paramString2.jdField_d_of_type_Long = paramString1.length();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  " + paramString2.e);
        if (!this.jdField_a_of_type_Bbqi.b(this.jdField_a_of_type_Bbqi.getCurrentPosition())) {
          break label295;
        }
        a(paramString2);
      }
      for (;;)
      {
        if (new bbpy().a(localAIOVideoData, 0) != null) {
          break label305;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
        if (RichMediaBrowserManager.getInstance().getProvider() == null) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, 0);
        return;
        paramString2.jdField_d_of_type_Long = 0L;
        break label160;
        b(0);
        updateUI();
      }
    }
  }
  
  public void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.mContext != null) && (!this.mContext.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  public void a(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new bbsf(this, paramAIOVideoData, paramFile, paramInt, paramRichMediaBrowserInfo));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new bbsg(this));
  }
  
  public void bindView(int paramInt)
  {
    super.bindView(paramInt);
    Object localObject1 = this.jdField_a_of_type_Bbqi.getItem(paramInt);
    AIOVideoData localAIOVideoData;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnLongClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setID(localAIOVideoData.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setId(2131374324);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnLongClickListener(this);
      localObject1 = new bbpy();
      this.mBrowserItemView.setTag(2131296433, Boolean.valueOf(true));
      Object localObject2 = (URLDrawable)this.jdField_a_of_type_Bbqi.b.get(Integer.valueOf(paramInt));
      if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)) {
        break label316;
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.showCover((Drawable)localObject2);
      localObject1 = "0X8009EF2";
      if (localAIOVideoData.jdField_d_of_type_Int == 1) {
        localObject1 = "0X8009EF1";
      }
      this.mBrowserItemView.setContentDescription(this.mContext.getString(2131691561));
      localObject2 = this.jdField_a_of_type_Bbqi.a();
      if ((localObject2 == null) || (((RichMediaBrowserInfo)localObject2).baseData == null) || (((RichMediaBrowserInfo)localObject2).baseData.getType() != 101) || (((AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long) || (((RichMediaBrowserInfo)localObject2).isReport)) {
        break label355;
      }
      bdla.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 1, 0, "", "", "", "");
      ((RichMediaBrowserInfo)localObject2).isReport = true;
    }
    for (;;)
    {
      localObject1 = new bbsj(this);
      ((bbsj)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      this.mBrowserItemView.setTag(localObject1);
      return;
      label316:
      if (((bbpy)localObject1).a(localAIOVideoData, 0) == null) {
        break;
      }
      this.jdField_a_of_type_Bbqi.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCoverImage(), paramInt);
      break;
      label355:
      bdla.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 2, 0, "", "", "", "");
    }
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void clearTheOuchCache()
  {
    this.jdField_a_of_type_Bbqi.b.clear();
  }
  
  public void e(boolean paramBoolean)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "doEnterImmersion, isClick:" + paramBoolean + ", hasDanmaku:" + this.jdField_a_of_type_Bbqi.c());
    super.e(paramBoolean);
    if (paramBoolean)
    {
      showContentView(false);
      b(false);
      this.jdField_a_of_type_Bbqi.b(false);
      return;
    }
    if (this.jdField_a_of_type_Bbqi.c())
    {
      this.jdField_a_of_type_Bbqi.a().jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bbqi.d();
      this.jdField_a_of_type_Bbqi.e();
      i(false);
      return;
    }
    showContentView(false);
    b(false);
    this.jdField_a_of_type_Bbqi.a().e();
  }
  
  public void f()
  {
    i(true);
  }
  
  public void f(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof bbsj)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((bbsj)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    }
    for (;;)
    {
      return this.mBrowserItemView;
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558620, paramViewGroup, false));
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView = ((GalleryUrlImageView)this.mBrowserItemView.findViewById(2131373142));
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)bapu.b(this.mContext, 0L, null, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView));
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      paramView.addRule(13);
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
        ((RelativeLayout)this.mBrowserItemView.findViewById(2131380850)).addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, paramView);
      }
      i();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      Object localObject = this.jdField_a_of_type_Bbqi.getSelectedItem();
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((RichMediaBrowserInfo)localObject).baseData != null)
          {
            i = j;
            if (!bbph.a().f())
            {
              i = j;
              if (!bbph.a().c())
              {
                i = j;
                if (bbhm.a())
                {
                  i = j;
                  if (ShortVideoUtils.isAEPituTakeSameOpen())
                  {
                    i = j;
                    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
                    {
                      AIOVideoData localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
                      i = j;
                      if (!TextUtils.isEmpty(localAIOVideoData.jdField_g_of_type_JavaLangString))
                      {
                        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                        localObject = this.mContext.getString(2131692665);
                        if (!TextUtils.isEmpty(localAIOVideoData.h)) {
                          localObject = localAIOVideoData.h;
                        }
                        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                        if (this.jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long)
                        {
                          bdla.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", localAIOVideoData.jdField_g_of_type_JavaLangString, "");
                          this.jdField_a_of_type_Long = localAIOVideoData.jdField_a_of_type_Long;
                        }
                        i = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "playBar is visible");
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_AndroidWidgetSeekBar.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if (new Rect(i, j, this.jdField_a_of_type_AndroidWidgetSeekBar.getWidth() + i, this.jdField_a_of_type_AndroidWidgetSeekBar.getHeight() + j).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "playBar deal event");
        h();
        return true;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "recyclerView deal event");
    }
    return super.isNeedDisallowInterceptEvent(paramMotionEvent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
        j();
      }
      for (;;)
      {
        this.jdField_a_of_type_Bbqi.i();
        g();
        break;
        a(this.jdField_a_of_type_Bbqi.getCurrentPosition(), false);
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, handle immersion.");
      if (this.jdField_a_of_type_Bbqi.b())
      {
        if (this.jdField_a_of_type_Bbqi.a().jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Bbqi.a().jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Bbqi.a().a();
          e();
        }
        for (;;)
        {
          this.jdField_a_of_type_Bbqi.a().f();
          break;
          this.jdField_a_of_type_Bbqi.a().b();
          this.jdField_a_of_type_Bbqi.a().jdField_a_of_type_Boolean = true;
          e(true);
        }
      }
      this.jdField_a_of_type_Bbqi.back();
      continue;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, play button click.");
      Object localObject = this.jdField_a_of_type_Bbqi.a();
      if ((localObject != null) && (((AIOVideoData)localObject).status != 2)) {
        a(this.jdField_a_of_type_Bbqi.getCurrentPosition(), false);
      }
      h();
      continue;
      localObject = this.jdField_a_of_type_Bbqi.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
      {
        localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 256);
        }
        this.jdField_a_of_type_Bbqi.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
        updateUI();
        continue;
        p();
        this.jdField_a_of_type_Bbqi.k();
        continue;
        d();
        continue;
        c();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOVideoView", 0, "onClick qq_gallery_danmaku_view ");
        }
        m();
        continue;
        if (this.basePresenter != null)
        {
          this.basePresenter.back();
          continue;
          n();
        }
      }
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
    }
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Bbqi.b.remove(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
    }
  }
  
  public void onEnterAnimationEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onEnterAnimationEnd");
    }
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onEnterAnimationStart");
    }
    showContentView(false);
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    bindView(paramInt);
    Object localObject = this.jdField_a_of_type_Bbqi.getItem(paramInt);
    if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
    {
      localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_Bbqi.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
      if (this.jdField_a_of_type_Bbqi.b(paramInt)) {
        a(paramInt, true);
      }
    }
    else
    {
      return;
    }
    updateUI();
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPause");
    j();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs());
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.seekTo(paramInt);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(paramInt));
      }
      this.jdField_a_of_type_Bbqi.j();
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
    if ((this.jdField_a_of_type_Bbqi.b(this.jdField_a_of_type_Bbqi.getCurrentPosition())) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null))
    {
      AIOVideoData localAIOVideoData = a();
      if ((localAIOVideoData != null) && (localAIOVideoData.status == 6)) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
      }
    }
  }
  
  public void onScrollEnd()
  {
    super.onScrollEnd();
    if (this.jdField_a_of_type_Bbqi.a(this.jdField_a_of_type_Bbqi.getCurrentPosition()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
        this.jdField_a_of_type_Bbqi.a();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bbqi.a(false);
  }
  
  public void onScrollHalfScreenWidth()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onScrollHalfScreenWidth");
    }
    super.onScrollHalfScreenWidth();
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.mIsPlayVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStop");
    clearTheOuchCache();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(true);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStopTrackingTouch");
    if ((this.jdField_a_of_type_Bbqi.a() != null) && (this.jdField_a_of_type_Bbqi.a(this.jdField_a_of_type_Bbqi.getCurrentPosition())) && (paramSeekBar != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "seek danmaku");
      this.jdField_a_of_type_Bbqi.a().a(paramSeekBar.getProgress());
      AIOVideoData localAIOVideoData = this.jdField_a_of_type_Bbqi.a();
      if (localAIOVideoData != null) {
        this.jdField_a_of_type_Bbqi.a().a(bbpf.a(localAIOVideoData.jdField_d_of_type_Long, paramSeekBar.getProgress(), this.jdField_a_of_type_Bbqi.a(), this.jdField_a_of_type_Bbqi.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void updateUI()
  {
    int i = 8;
    super.updateUI();
    Object localObject1 = a();
    c(b());
    d(a(this.jdField_a_of_type_Bbqi.getSelectedItem()));
    h(true);
    if (localObject1 != null) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI id = " + ((AIOVideoData)localObject1).id + ", status = " + ((AIOVideoData)localObject1).status);
    }
    switch (((AIOVideoData)localObject1).status)
    {
    case 7: 
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI status is error, status = " + ((AIOVideoData)localObject1).status);
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 5: 
    case 6: 
    case 8: 
      label506:
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Bbqi.onLoadStart(this.jdField_a_of_type_Bbqi.getSelectedIndex(), ((AIOVideoData)localObject1).progress);
          g(false);
          f(false);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          a(false);
          return;
          this.jdField_a_of_type_Bbqi.onLoadFinish(this.jdField_a_of_type_Bbqi.getSelectedIndex(), true);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131699575) + ((AIOVideoData)localObject1).progress + "%");
          this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(((AIOVideoData)localObject1).progress * 100);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          g(false);
          f(true);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          a(true);
          return;
          this.jdField_a_of_type_Bbqi.onLoadStart(this.jdField_a_of_type_Bbqi.getSelectedIndex(), ((AIOVideoData)localObject1).progress);
          f(false);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          g(false);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          a(false);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) {
              break label506;
            }
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
          for (;;)
          {
            this.jdField_a_of_type_Bbqi.onLoadFinish(this.jdField_a_of_type_Bbqi.getSelectedIndex(), true);
            g(true);
            f(false);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            a(true);
            return;
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          this.jdField_a_of_type_Bbqi.onLoadFinish(this.jdField_a_of_type_Bbqi.getSelectedIndex(), true);
          g(true);
          f(false);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846111);
          a(true);
        } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
        long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "videoDuration = " + l);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(l));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
        return;
        this.jdField_a_of_type_Bbqi.onLoadFinish(this.jdField_a_of_type_Bbqi.getSelectedIndex(), true);
        g(true);
        f(false);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846110);
        a(true);
        return;
        this.jdField_a_of_type_Bbqi.onLoadFinish(this.jdField_a_of_type_Bbqi.getSelectedIndex(), true);
        g(false);
        f(false);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846110);
        a(false);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366253);
      } while (localObject2 == null);
      if (!TextUtils.isEmpty(((AIOVideoData)localObject1).jdField_f_of_type_JavaLangString)) {}
      for (localObject1 = ((AIOVideoData)localObject1).jdField_f_of_type_JavaLangString;; localObject1 = this.mContext.getString(2131718852))
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        return;
      }
    }
    this.jdField_a_of_type_Bbqi.onLoadFinish(this.jdField_a_of_type_Bbqi.getSelectedIndex(), true);
    g(false);
    f(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
    if (((AIOVideoData)localObject1).jdField_f_of_type_Boolean) {}
    for (;;)
    {
      ((ImageView)localObject2).setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846110);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      a(true);
      return;
      i = 0;
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_Bbqi.getItem(paramInt);
    if ((localObject2 == null) || (((RichMediaBrowserInfo)localObject2).baseData == null) || (paramView == null)) {
      return;
    }
    if ((paramView.getTag() instanceof bbsj))
    {
      Object localObject1 = ((bbsj)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (((RichMediaBrowserInfo)localObject2).baseData.getType() == 101)
      {
        localObject2 = (AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateView loadShortVideoCover");
        this.jdField_a_of_type_Bbqi.a(((AIOVideoData)localObject2).jdField_a_of_type_JavaLangString, ((AIOVideoData)localObject2).jdField_e_of_type_Int, ((AIOVideoData)localObject2).jdField_f_of_type_Int, ((BaseVideoView)localObject1).getCoverImage(), paramInt);
        if (this.jdField_a_of_type_Bbqi.b(paramInt))
        {
          localObject1 = this.jdField_a_of_type_Bbqi.a((AIOVideoData)localObject2);
          if (localObject1 != null) {
            a((aklw)localObject1);
          }
        }
      }
    }
    super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrz
 * JD-Core Version:    0.7.0.1
 */