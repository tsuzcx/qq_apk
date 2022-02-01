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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.10;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.3;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.4;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class bbrp
  extends bbqn
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public long a;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public bbpy a;
  private bjgf jdField_a_of_type_Bjgf;
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
  
  public bbrp(Activity paramActivity, bbpy parambbpy)
  {
    super(paramActivity, parambbpy);
    this.jdField_a_of_type_Bbpy = parambbpy;
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
  
  private VideoPlayParam a(akss paramakss)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    MessageForShortVideo localMessageForShortVideo = paramakss.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    localVideoPlayParam.mSceneId = 101;
    localVideoPlayParam.mSceneName = (bapi.a(101) + "_FulScr");
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (localAIOVideoData.jdField_d_of_type_Int == 1))
    {
      localVideoPlayParam.mSceneId = 100;
      localVideoPlayParam.mSceneName = (bapi.a(100) + "_FulScr");
    }
    if (this.jdField_a_of_type_Bbpy != null) {
      localVideoPlayParam.mIsMute = this.jdField_a_of_type_Bbpy.b(paramakss.jdField_a_of_type_Long);
    }
    if (!localVideoPlayParam.mIsMute) {
      k();
    }
    if (paramakss.jdField_a_of_type_Boolean)
    {
      localVideoPlayParam.mUrls = paramakss.jdField_a_of_type_ArrayOfJavaLangString;
      localVideoPlayParam.mSavePath = paramakss.jdField_a_of_type_JavaLangString;
      if (paramakss.jdField_a_of_type_Boolean) {
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
        localVideoPlayParam.mFileID = (localMessageForShortVideo.md5 + localMessageForShortVideo.uniseq);
        localVideoPlayParam.mFileSize = localMessageForShortVideo.videoFileSize;
      }
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      a(localVideoPlayParam);
      return localVideoPlayParam;
      localVideoPlayParam.mVideoPath = paramakss.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    String str1 = null;
    if (paramInt1 == 2)
    {
      localObject = this.jdField_a_of_type_Bbpy.a(a());
      if ((localObject != null) && (((akss)localObject).jdField_a_of_type_ArrayOfJavaLangString != null) && (!bhsr.a(((akss)localObject).jdField_b_of_type_JavaLangString)))
      {
        String[] arrayOfString = ((akss)localObject).jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (!bhsr.a(str2)) {
            InnerDns.getInstance().reportBadIp(((akss)localObject).jdField_b_of_type_JavaLangString, InnerDns.getHostFromUrl(str2), 1005);
          }
          i += 1;
        }
        bbqj.a().a();
      }
    }
    if (paramInt1 == 1) {
      str1 = this.mContext.getString(2131718222);
    }
    if (paramInt2 == 14011001)
    {
      str1 = this.mContext.getString(2131717503);
      this.jdField_a_of_type_Bbpy.a(5002, 0L);
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
      if ((!bapj.a(paramInt2, paramVideoPlayParam)) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) || (localObject == null) || (((AIOVideoData)localObject).l >= 2)) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "handlePlayError, auto replay video.");
      ThreadManager.getUIHandler().post(new AIOVideoView.3(this, (AIOVideoData)localObject));
      return;
      label300:
      str1 = this.mContext.getString(2131718225);
    }
    ThreadManager.getUIHandler().post(new AIOVideoView.4(this));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt);
    }
    Object localObject1 = this.jdField_a_of_type_Bbpy.getItem(paramInt);
    Object localObject2;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localObject1 = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt + " , msgId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Long);
      }
      ((AIOVideoData)localObject1).m = paramInt;
      ((AIOVideoData)localObject1).i = paramBoolean;
      localObject2 = this.jdField_a_of_type_Bbpy;
      long l = ((AIOVideoData)localObject1).jdField_a_of_type_Long;
      if (!paramBoolean) {
        bool = true;
      }
      ((bbpy)localObject2).b(l, bool);
      localObject2 = this.jdField_a_of_type_Bbpy.a((AIOVideoData)localObject1);
      if (localObject2 == null)
      {
        this.jdField_a_of_type_Bbpy.b((AIOVideoData)localObject1);
        this.jdField_a_of_type_Bbpy.a(((AIOVideoData)localObject1).jdField_a_of_type_Long, ((AIOVideoData)localObject1).jdField_a_of_type_Int, 4);
        updateUI();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateItemStatus VIDEO_GETTING_URL , shortVideoData.msgId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Long + ", shortVideoData.subId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Int);
      }
    }
    else
    {
      return;
    }
    a((akss)localObject2);
  }
  
  private void a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    HashMap localHashMap;
    if (!this.jdField_a_of_type_Bbpy.a(paramLong))
    {
      long l = this.jdField_a_of_type_Bbpy.a(paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "reportForVideoStartPlayCost, id:" + paramLong + ", clickBubbleTime = " + l);
      }
      if ((this.jdField_a_of_type_Bbpy != null) && (l > 0L))
      {
        paramLong = System.currentTimeMillis() - l;
        localHashMap = new HashMap();
        localHashMap.put("timeCost", String.valueOf(paramLong));
        localHashMap.put("busiType", paramVideoPlayParam.mSceneName);
        if (!paramVideoPlayParam.mIsLocal) {
          break label210;
        }
      }
    }
    label210:
    for (String str = "actVideoFSPlayCost";; str = "acVideoFSPlayCost_Online")
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "report video start play cost , reportName = " + str + " , timeCost = " + paramLong + " , busiType = " + paramVideoPlayParam.mSceneName);
      bdmc.a(BaseApplication.getContext()).a(null, str, true, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(akss paramakss)
  {
    if (paramakss == null) {}
    do
    {
      return;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo id = " + paramakss.jdField_a_of_type_Long);
      this.jdField_a_of_type_Bbpy.a(paramakss.jdField_a_of_type_Long, paramakss.jdField_b_of_type_Int, 5);
      updateUI();
      this.jdField_a_of_type_Bbpy.a(0L, 0L, bbox.a().c());
      paramakss = a(paramakss);
    } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(paramakss);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
  }
  
  /* Error */
  private void a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: ifnonnull +19 -> 26
    //   10: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   13: ifeq +12 -> 25
    //   16: ldc 63
    //   18: iconst_0
    //   19: ldc_w 482
    //   22: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: return
    //   26: invokestatic 488	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   29: invokevirtual 492	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   32: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: astore_3
    //   36: new 494	java/io/File
    //   39: dup
    //   40: new 133	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   47: aload_3
    //   48: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 500	java/io/File:separator	Ljava/lang/String;
    //   54: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 502
    //   60: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 505	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 508	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_3
    //   78: invokevirtual 511	java/io/File:createNewFile	()Z
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 497	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: putfield 46	bbrp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   93: ifeq +32 -> 125
    //   96: ldc 63
    //   98: iconst_0
    //   99: new 133	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 513
    //   109: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 46	bbrp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   116: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 46	bbrp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   130: invokestatic 518	auog:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   133: pop
    //   134: new 35	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 38	java/util/ArrayList:<init>	()V
    //   141: astore 6
    //   143: new 520	android/util/SparseArray
    //   146: dup
    //   147: iconst_2
    //   148: invokespecial 523	android/util/SparseArray:<init>	(I)V
    //   151: astore 7
    //   153: aload_1
    //   154: iconst_1
    //   155: iconst_3
    //   156: aload 7
    //   158: invokestatic 528	zxx:a	(Landroid/graphics/Bitmap;ZILandroid/util/SparseArray;)I
    //   161: istore_2
    //   162: iload_2
    //   163: invokestatic 531	zxx:a	(I)Z
    //   166: ifeq +98 -> 264
    //   169: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   172: ifeq +12 -> 184
    //   175: ldc 63
    //   177: iconst_0
    //   178: ldc_w 533
    //   181: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 7
    //   186: iconst_1
    //   187: invokevirtual 537	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   190: astore_1
    //   191: aload_1
    //   192: instanceof 539
    //   195: ifeq +242 -> 437
    //   198: aload_1
    //   199: checkcast 539	android/util/Pair
    //   202: astore_3
    //   203: new 541	org/json/JSONObject
    //   206: dup
    //   207: invokespecial 542	org/json/JSONObject:<init>	()V
    //   210: astore_1
    //   211: aload_1
    //   212: ldc_w 544
    //   215: aload_3
    //   216: getfield 548	android/util/Pair:second	Ljava/lang/Object;
    //   219: invokestatic 551	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokevirtual 554	java/lang/String:trim	()Ljava/lang/String;
    //   225: invokevirtual 557	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload_1
    //   230: ldc_w 559
    //   233: aload_3
    //   234: getfield 562	android/util/Pair:first	Ljava/lang/Object;
    //   237: invokestatic 551	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 554	java/lang/String:trim	()Ljava/lang/String;
    //   243: invokevirtual 557	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload_1
    //   248: ifnonnull +136 -> 384
    //   251: ldc 44
    //   253: astore_1
    //   254: bipush 126
    //   256: aload 6
    //   258: aload_1
    //   259: iconst_0
    //   260: invokestatic 567	bhrt:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   263: pop
    //   264: iload_2
    //   265: invokestatic 569	zxx:b	(I)Z
    //   268: ifeq +74 -> 342
    //   271: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   274: ifeq +12 -> 286
    //   277: ldc 63
    //   279: iconst_0
    //   280: ldc_w 571
    //   283: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload 7
    //   288: iconst_2
    //   289: invokevirtual 537	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   292: astore_3
    //   293: aload 5
    //   295: astore_1
    //   296: aload_3
    //   297: instanceof 419
    //   300: ifeq +25 -> 325
    //   303: aload_3
    //   304: checkcast 419	java/lang/String
    //   307: astore_3
    //   308: new 541	org/json/JSONObject
    //   311: dup
    //   312: invokespecial 542	org/json/JSONObject:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: ldc_w 573
    //   320: aload_3
    //   321: invokevirtual 557	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload_1
    //   326: ifnonnull +77 -> 403
    //   329: ldc 44
    //   331: astore_1
    //   332: bipush 127
    //   334: aload 6
    //   336: aload_1
    //   337: iconst_0
    //   338: invokestatic 567	bhrt:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   341: pop
    //   342: aload 6
    //   344: invokevirtual 576	java/util/ArrayList:isEmpty	()Z
    //   347: ifeq +64 -> 411
    //   350: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   353: ifeq -328 -> 25
    //   356: ldc 63
    //   358: iconst_0
    //   359: ldc_w 578
    //   362: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: return
    //   366: astore_3
    //   367: aload_3
    //   368: invokevirtual 581	java/io/IOException:printStackTrace	()V
    //   371: goto -237 -> 134
    //   374: astore_3
    //   375: aconst_null
    //   376: astore_1
    //   377: aload_3
    //   378: invokevirtual 582	org/json/JSONException:printStackTrace	()V
    //   381: goto -134 -> 247
    //   384: aload_1
    //   385: invokevirtual 583	org/json/JSONObject:toString	()Ljava/lang/String;
    //   388: astore_1
    //   389: goto -135 -> 254
    //   392: astore_3
    //   393: aload 4
    //   395: astore_1
    //   396: aload_3
    //   397: invokevirtual 582	org/json/JSONException:printStackTrace	()V
    //   400: goto -75 -> 325
    //   403: aload_1
    //   404: invokevirtual 583	org/json/JSONObject:toString	()Ljava/lang/String;
    //   407: astore_1
    //   408: goto -76 -> 332
    //   411: invokestatic 331	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   414: new 585	com/tencent/mobileqq/richmediabrowser/view/AIOVideoView$13
    //   417: dup
    //   418: aload_0
    //   419: aload 6
    //   421: invokespecial 588	com/tencent/mobileqq/richmediabrowser/view/AIOVideoView$13:<init>	(Lbbrp;Ljava/util/ArrayList;)V
    //   424: invokevirtual 342	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   427: pop
    //   428: return
    //   429: astore_3
    //   430: goto -34 -> 396
    //   433: astore_3
    //   434: goto -57 -> 377
    //   437: aconst_null
    //   438: astore_1
    //   439: goto -192 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	bbrp
    //   0	442	1	paramBitmap	Bitmap
    //   161	104	2	i	int
    //   35	286	3	localObject1	Object
    //   366	2	3	localIOException	java.io.IOException
    //   374	4	3	localJSONException1	org.json.JSONException
    //   392	5	3	localJSONException2	org.json.JSONException
    //   429	1	3	localJSONException3	org.json.JSONException
    //   433	1	3	localJSONException4	org.json.JSONException
    //   1	393	4	localObject2	Object
    //   4	290	5	localObject3	Object
    //   141	279	6	localArrayList	ArrayList
    //   151	136	7	localSparseArray	android.util.SparseArray
    // Exception table:
    //   from	to	target	type
    //   26	82	366	java/io/IOException
    //   82	125	366	java/io/IOException
    //   125	134	366	java/io/IOException
    //   203	211	374	org/json/JSONException
    //   303	316	392	org/json/JSONException
    //   316	325	429	org/json/JSONException
    //   211	247	433	org/json/JSONException
  }
  
  private void a(AIOVideoData paramAIOVideoData)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, bbox.a().a());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_a_of_type_Bbpy.getSelectedItem() != null)
        {
          Object localObject = this.jdField_a_of_type_Bbpy.getSelectedItem().baseData;
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
    File localFile = new bbpo().a(paramAIOVideoData, 1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpy.getSelectedItem();
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
        bhrt.a(2, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((VersionUtils.isIceScreamSandwich()) && ((paramAIOVideoData.jdField_d_of_type_Int != 1) || (i == 0))) {
        bhrt.a(39, this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (i == 0)
      {
        bhrt.a(6, this.jdField_b_of_type_JavaUtilArrayList);
        bhrt.a(3, this.jdField_a_of_type_JavaUtilArrayList);
        bhrt.a(27, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((bbox.a().g()) && (!TextUtils.isEmpty(bbox.a().c())) && (bbox.a().a() != -1)) {
        bhrt.a(54, this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (i == 0) {
        bhrt.a(64, this.jdField_a_of_type_JavaUtilArrayList);
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
      paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, bbox.a().a());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_a_of_type_Bbpy.getSelectedItem() != null)
        {
          Object localObject = this.jdField_a_of_type_Bbpy.getSelectedItem().baseData;
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
        auxu.a(this.mContext, paramAIOVideoData, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
      }
    }
    for (;;)
    {
      if (bbox.a().c()) {
        axpm.a("0X8009ABC");
      }
      return;
      label310:
      auxu.a(this.mContext, paramAIOVideoData, 100500, " biz_src_jc_video");
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new bbrt(this, paramVideoPlayParam);
  }
  
  private void a(String paramString, int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "0", "0", "");
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
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpy.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (this.jdField_a_of_type_Bbpy.a((AIOVideoData)localRichMediaBrowserInfo.baseData) != null))
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
      this.jdField_a_of_type_Bbpy.a(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, paramInt);
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
      bdll.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      return;
    }
    if (i == 3000)
    {
      bdll.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      return;
    }
    if (i == 1)
    {
      bdll.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      return;
    }
    bdll.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
  }
  
  private void b(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (paramAIOVideoData.j == 5002)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
      QQToast.a(this.mContext, 1, anzj.a(2131698948), 0).a();
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
        this.jdField_a_of_type_Bbpy.a(paramInt, paramFile);
        return;
      }
      if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOVideoData.jdField_c_of_type_Long))
      {
        paramAIOVideoData = new StringBuilder().append(paramFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramFile.getAbsolutePath(), this.jdField_a_of_type_Bbpy.jdField_a_of_type_MqqOsMqqHandler, paramAIOVideoData, false));
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        this.jdField_a_of_type_Bbpy.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
        return;
      }
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOVideoData.jdField_c_of_type_Long > 29360128L))
      {
        a(3, paramAIOVideoData, paramRichMediaBrowserInfo);
        return;
      }
      this.jdField_a_of_type_Bbpy.a(paramAIOVideoData);
      this.jdField_a_of_type_Bbpy.a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, 2);
      updateUI();
    } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
  }
  
  private void c(AIOVideoData paramAIOVideoData)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, bbox.a().a());
      if (localIntent != null)
      {
        bmko.a(localIntent).a(this.mContext, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        bmky.a(null, 3, 0, paramAIOVideoData.jdField_b_of_type_Int);
        bmky.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void i()
  {
    if (this.mBrowserItemView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131380788));
      Object localObject = (RelativeLayout)this.mBrowserItemView.findViewById(2131372145);
      this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)localObject).findViewById(2131371891);
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377245));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372146));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373046));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379238));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new bbrq(this));
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374353));
      this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(anzj.a(2131698962));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131380467));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380469));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380468));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364585));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131364011));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131376077));
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374352));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374354));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374360));
      this.jdField_e_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131364149));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131364150));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = this.mBrowserItemView.findViewById(2131380983);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374355));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mBrowserItemView.findViewById(2131372960));
      this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131372962));
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
    if (this.jdField_a_of_type_Bbpy.a(this.jdField_a_of_type_Bbpy.getCurrentPosition())) {
      this.jdField_a_of_type_Bbpy.a(true);
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
    AIOVideoData localAIOVideoData = this.jdField_a_of_type_Bbpy.a();
    if (localAIOVideoData != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
        break label86;
      }
    }
    label86:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();; l = 0L)
    {
      MiniChatActivity.a(this.mContext, bbox.a().a(), bbox.a().a(), false, 26, localAIOVideoData.jdField_d_of_type_Long, l);
      if (localAIOVideoData.status == 5)
      {
        this.jdField_a_of_type_Bbpy.a(localAIOVideoData.jdField_a_of_type_Long, true);
        j();
      }
      this.jdField_a_of_type_Bbpy.l();
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
        if (!apdr.a(this.mContext))
        {
          localAIOGalleryActivity.requestPermissions(new bbru(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
      brdx.a(this.mContext, localAIOVideoData.jdField_g_of_type_JavaLangString);
      bdll.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", localAIOVideoData.jdField_g_of_type_JavaLangString, "");
    }
  }
  
  private void p()
  {
    AIOVideoData localAIOVideoData = a();
    long l;
    if (localAIOVideoData != null)
    {
      if (this.jdField_a_of_type_Bjgf != null) {
        this.jdField_a_of_type_Bjgf.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
        break label147;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();
      this.jdField_a_of_type_Bjgf = new bjgf(this.mContext);
      akss localakss = this.jdField_a_of_type_Bbpy.a(localAIOVideoData);
      if (localakss == null) {
        break label157;
      }
      this.jdField_a_of_type_Bjgf.a(localakss, localAIOVideoData.jdField_e_of_type_Long, l);
      this.jdField_a_of_type_Bjgf.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int);
      if (localAIOVideoData.jdField_e_of_type_Int <= localAIOVideoData.jdField_f_of_type_Int) {
        break label152;
      }
    }
    label147:
    label152:
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Bjgf.a(bool, localAIOVideoData.jdField_b_of_type_Int)) {
        this.jdField_a_of_type_Bbpy.back();
      }
      return;
      l = 0L;
      break;
    }
    label157:
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
  }
  
  public AIOVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbpy.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return (AIOVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isLocalPlay()) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()))
    {
      Object localObject = this.mContext.getString(2131718217);
      localObject = bhlq.a(this.mContext, 230, null, (String)localObject, 2131693994, 2131719410, new bbrx(this), new bbry(this));
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
    a(bhlq.a(this.mContext, 230, this.mContext.getString(2131717542), this.mContext.getString(2131717541), new bbrr(this, paramInt, paramObject), new bbrs(this)));
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
    this.jdField_a_of_type_Bbpy.a(paramLong, paramInt1, paramInt2, paramString1);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData == null) {}
    label160:
    label295:
    label305:
    for (;;)
    {
      return;
      bbqj.a().a(localAIOVideoData.jdField_a_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt3, paramString2);
      paramString2 = new akss();
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
        if (!this.jdField_a_of_type_Bbpy.b(this.jdField_a_of_type_Bbpy.getCurrentPosition())) {
          break label295;
        }
        a(paramString2);
      }
      for (;;)
      {
        if (new bbpo().a(localAIOVideoData, 0) != null) {
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new bbrv(this, paramAIOVideoData, paramFile, paramInt, paramRichMediaBrowserInfo));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new bbrw(this));
  }
  
  public void bindView(int paramInt)
  {
    super.bindView(paramInt);
    Object localObject1 = this.jdField_a_of_type_Bbpy.getItem(paramInt);
    AIOVideoData localAIOVideoData;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnLongClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setID(localAIOVideoData.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setId(2131374322);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnLongClickListener(this);
      localObject1 = new bbpo();
      this.mBrowserItemView.setTag(2131296433, Boolean.valueOf(true));
      Object localObject2 = (URLDrawable)this.jdField_a_of_type_Bbpy.b.get(Integer.valueOf(paramInt));
      if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)) {
        break label316;
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.showCover((Drawable)localObject2);
      localObject1 = "0X8009EF2";
      if (localAIOVideoData.jdField_d_of_type_Int == 1) {
        localObject1 = "0X8009EF1";
      }
      this.mBrowserItemView.setContentDescription(this.mContext.getString(2131691436));
      localObject2 = this.jdField_a_of_type_Bbpy.a();
      if ((localObject2 == null) || (((RichMediaBrowserInfo)localObject2).baseData == null) || (((RichMediaBrowserInfo)localObject2).baseData.getType() != 101) || (((AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long) || (((RichMediaBrowserInfo)localObject2).isReport)) {
        break label355;
      }
      bdll.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 1, 0, "", "", "", "");
      ((RichMediaBrowserInfo)localObject2).isReport = true;
    }
    for (;;)
    {
      localObject1 = new bbrz(this);
      ((bbrz)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      this.mBrowserItemView.setTag(localObject1);
      return;
      label316:
      if (((bbpo)localObject1).a(localAIOVideoData, 0) == null) {
        break;
      }
      this.jdField_a_of_type_Bbpy.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCoverImage(), paramInt);
      break;
      label355:
      bdll.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 2, 0, "", "", "", "");
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
    this.jdField_a_of_type_Bbpy.b.clear();
  }
  
  public void e(boolean paramBoolean)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "doEnterImmersion, isClick:" + paramBoolean + ", hasDanmaku:" + this.jdField_a_of_type_Bbpy.c());
    super.e(paramBoolean);
    if (paramBoolean)
    {
      showContentView(false);
      b(false);
      this.jdField_a_of_type_Bbpy.b(false);
      return;
    }
    if (this.jdField_a_of_type_Bbpy.c())
    {
      this.jdField_a_of_type_Bbpy.a().jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bbpy.d();
      this.jdField_a_of_type_Bbpy.e();
      i(false);
      return;
    }
    showContentView(false);
    b(false);
    this.jdField_a_of_type_Bbpy.a().e();
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
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof bbrz)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((bbrz)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    }
    for (;;)
    {
      return this.mBrowserItemView;
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558605, paramViewGroup, false));
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView = ((GalleryUrlImageView)this.mBrowserItemView.findViewById(2131372961));
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)baph.b(this.mContext, 0L, null, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView));
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      paramView.addRule(13);
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
        ((RelativeLayout)this.mBrowserItemView.findViewById(2131380784)).addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, paramView);
      }
      i();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      Object localObject = this.jdField_a_of_type_Bbpy.getSelectedItem();
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
            if (!bbox.a().f())
            {
              i = j;
              if (!bbox.a().c())
              {
                i = j;
                if (bbgg.a())
                {
                  i = j;
                  if (ShortVideoUtils.g())
                  {
                    i = j;
                    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
                    {
                      AIOVideoData localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
                      i = j;
                      if (!TextUtils.isEmpty(localAIOVideoData.jdField_g_of_type_JavaLangString))
                      {
                        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                        localObject = this.mContext.getString(2131692515);
                        if (!TextUtils.isEmpty(localAIOVideoData.h)) {
                          localObject = localAIOVideoData.h;
                        }
                        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                        if (this.jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long)
                        {
                          bdll.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", localAIOVideoData.jdField_g_of_type_JavaLangString, "");
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
        this.jdField_a_of_type_Bbpy.i();
        g();
        break;
        a(this.jdField_a_of_type_Bbpy.getCurrentPosition(), false);
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, handle immersion.");
      if (this.jdField_a_of_type_Bbpy.b())
      {
        if (this.jdField_a_of_type_Bbpy.a().jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Bbpy.a().jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Bbpy.a().a();
          e();
        }
        for (;;)
        {
          this.jdField_a_of_type_Bbpy.a().f();
          break;
          this.jdField_a_of_type_Bbpy.a().b();
          this.jdField_a_of_type_Bbpy.a().jdField_a_of_type_Boolean = true;
          e(true);
        }
      }
      this.jdField_a_of_type_Bbpy.back();
      continue;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, play button click.");
      if (this.jdField_a_of_type_Bbpy.a().status != 2) {
        a(this.jdField_a_of_type_Bbpy.getCurrentPosition(), false);
      }
      h();
      continue;
      Object localObject = this.jdField_a_of_type_Bbpy.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
      {
        localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 256);
        }
        this.jdField_a_of_type_Bbpy.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
        updateUI();
        continue;
        p();
        this.jdField_a_of_type_Bbpy.k();
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
    this.jdField_a_of_type_Bbpy.b.remove(Integer.valueOf(paramInt));
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
    Object localObject = this.jdField_a_of_type_Bbpy.getItem(paramInt);
    if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
    {
      localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_Bbpy.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
      if (this.jdField_a_of_type_Bbpy.b(paramInt)) {
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramInt));
      }
      this.jdField_a_of_type_Bbpy.j();
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
    if ((this.jdField_a_of_type_Bbpy.b(this.jdField_a_of_type_Bbpy.getCurrentPosition())) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null))
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
    if (this.jdField_a_of_type_Bbpy.a(this.jdField_a_of_type_Bbpy.getCurrentPosition()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
        this.jdField_a_of_type_Bbpy.a();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bbpy.a(false);
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
    if ((this.jdField_a_of_type_Bbpy.a() != null) && (this.jdField_a_of_type_Bbpy.a(this.jdField_a_of_type_Bbpy.getCurrentPosition())) && (paramSeekBar != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "seek danmaku");
      this.jdField_a_of_type_Bbpy.a().a(paramSeekBar.getProgress());
      AIOVideoData localAIOVideoData = this.jdField_a_of_type_Bbpy.a();
      if (localAIOVideoData != null) {
        this.jdField_a_of_type_Bbpy.a().a(bbov.a(localAIOVideoData.jdField_d_of_type_Long, paramSeekBar.getProgress(), this.jdField_a_of_type_Bbpy.a(), this.jdField_a_of_type_Bbpy.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
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
    d(a(this.jdField_a_of_type_Bbpy.getSelectedItem()));
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
          this.jdField_a_of_type_Bbpy.onLoadStart(this.jdField_a_of_type_Bbpy.getSelectedIndex(), ((AIOVideoData)localObject1).progress);
          g(false);
          f(false);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          a(false);
          return;
          this.jdField_a_of_type_Bbpy.onLoadFinish(this.jdField_a_of_type_Bbpy.getSelectedIndex(), true);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(anzj.a(2131698989) + ((AIOVideoData)localObject1).progress + "%");
          this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(((AIOVideoData)localObject1).progress * 100);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          g(false);
          f(true);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          a(true);
          return;
          this.jdField_a_of_type_Bbpy.onLoadStart(this.jdField_a_of_type_Bbpy.getSelectedIndex(), ((AIOVideoData)localObject1).progress);
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
            this.jdField_a_of_type_Bbpy.onLoadFinish(this.jdField_a_of_type_Bbpy.getSelectedIndex(), true);
            g(true);
            f(false);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            a(true);
            return;
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          this.jdField_a_of_type_Bbpy.onLoadFinish(this.jdField_a_of_type_Bbpy.getSelectedIndex(), true);
          g(true);
          f(false);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846132);
          a(true);
        } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
        long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "videoDuration = " + l);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
        return;
        this.jdField_a_of_type_Bbpy.onLoadFinish(this.jdField_a_of_type_Bbpy.getSelectedIndex(), true);
        g(true);
        f(false);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846131);
        a(true);
        return;
        this.jdField_a_of_type_Bbpy.onLoadFinish(this.jdField_a_of_type_Bbpy.getSelectedIndex(), true);
        g(false);
        f(false);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846131);
        a(false);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366123);
      } while (localObject2 == null);
      if (!TextUtils.isEmpty(((AIOVideoData)localObject1).jdField_f_of_type_JavaLangString)) {}
      for (localObject1 = ((AIOVideoData)localObject1).jdField_f_of_type_JavaLangString;; localObject1 = this.mContext.getString(2131718225))
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        return;
      }
    }
    this.jdField_a_of_type_Bbpy.onLoadFinish(this.jdField_a_of_type_Bbpy.getSelectedIndex(), true);
    g(false);
    f(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
    if (((AIOVideoData)localObject1).jdField_f_of_type_Boolean) {}
    for (;;)
    {
      ((ImageView)localObject2).setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846131);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      a(true);
      return;
      i = 0;
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_Bbpy.getItem(paramInt);
    if ((localObject2 == null) || (((RichMediaBrowserInfo)localObject2).baseData == null) || (paramView == null)) {
      return;
    }
    if ((paramView.getTag() instanceof bbrz))
    {
      Object localObject1 = ((bbrz)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (((RichMediaBrowserInfo)localObject2).baseData.getType() == 101)
      {
        localObject2 = (AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateView loadShortVideoCover");
        this.jdField_a_of_type_Bbpy.a(((AIOVideoData)localObject2).jdField_a_of_type_JavaLangString, ((AIOVideoData)localObject2).jdField_e_of_type_Int, ((AIOVideoData)localObject2).jdField_f_of_type_Int, ((BaseVideoView)localObject1).getCoverImage(), paramInt);
        if (this.jdField_a_of_type_Bbpy.b(paramInt))
        {
          localObject1 = this.jdField_a_of_type_Bbpy.a((AIOVideoData)localObject2);
          if (localObject1 != null) {
            a((akss)localObject1);
          }
        }
      }
    }
    super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrp
 * JD-Core Version:    0.7.0.1
 */