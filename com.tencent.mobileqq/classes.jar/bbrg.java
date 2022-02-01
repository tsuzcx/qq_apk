import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.4;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.5;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.7;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bbrg
  extends bbqx
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public SeekBar a;
  public TextView a;
  public bbqd a;
  private bixb jdField_a_of_type_Bixb;
  public BaseVideoView a;
  public GalleryUrlImageView a;
  public String a;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> a;
  public ImageView b;
  public RelativeLayout b;
  public SeekBar b;
  public TextView b;
  private String b;
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> b;
  private ImageView c;
  public RelativeLayout c;
  public TextView c;
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> c;
  public ImageButton d;
  public RelativeLayout d;
  public TextView d;
  public ImageButton e;
  
  public bbrg(Activity paramActivity, bbqd parambbqd)
  {
    super(paramActivity, parambbqd);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Bbqd = parambbqd;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      return 3;
    }
    return 9;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "drawable2Bitmap, drawable is null");
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
    boolean bool;
    if (!paramaklw.jdField_a_of_type_Boolean)
    {
      bool = true;
      localVideoPlayParam.mIsLocal = bool;
      if (localVideoPlayParam.mIsLocal) {
        break label127;
      }
      localVideoPlayParam.mSavePath = paramaklw.jdField_a_of_type_AndroidOsBundle.getString("savepath");
      localVideoPlayParam.mFileID = paramaklw.jdField_a_of_type_AndroidOsBundle.getString("fileid");
      localVideoPlayParam.mUrls = paramaklw.jdField_a_of_type_ArrayOfJavaLangString;
      localVideoPlayParam.mCookies = paramaklw.jdField_a_of_type_JavaUtilArrayList;
      localVideoPlayParam.mVideoFormat = 104;
      b(1);
    }
    for (;;)
    {
      localVideoPlayParam.mIsMute = paramaklw.jdField_e_of_type_Boolean;
      localVideoPlayParam.mSceneId = 109;
      localVideoPlayParam.mSceneName = bapv.a(109);
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      a(localVideoPlayParam);
      return localVideoPlayParam;
      bool = false;
      break;
      label127:
      localVideoPlayParam.mVideoPath = paramaklw.jdField_a_of_type_JavaLangString;
      b(5);
    }
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return "undefine";
    case 0: 
      return "Nomal";
    case 3: 
      return "Buffering";
    case 1: 
      return "Downloading";
    case 8: 
      return "Error";
    case 4: 
      return "Get URL";
    case 6: 
      return "Pause";
    case 5: 
      return "Playing";
    }
    return "Saving";
  }
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    String str1 = null;
    AIOFileVideoData localAIOFileVideoData = a();
    if (paramInt1 == 2)
    {
      aklw localaklw = new bbpu().a(localAIOFileVideoData, localAIOFileVideoData.i);
      if ((localaklw != null) && (localaklw.jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.isEmpty(localaklw.jdField_b_of_type_JavaLangString)))
      {
        String[] arrayOfString = localaklw.jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (!StringUtil.isEmpty(str2)) {
            InnerDns.getInstance().reportBadIp(localaklw.jdField_b_of_type_JavaLangString, InnerDns.getHostFromUrl(str2), 1005);
          }
          i += 1;
        }
        bbqt.a().a();
      }
    }
    if (paramInt1 == 1) {
      str1 = this.mContext.getString(2131718849);
    }
    if (localAIOFileVideoData != null) {
      if (str1 == null) {
        break label276;
      }
    }
    for (;;)
    {
      localAIOFileVideoData.jdField_f_of_type_JavaLangString = str1;
      localAIOFileVideoData.jdField_g_of_type_Int += 1;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 2, "handlePlayError, videoData.mPlayErrTimes = " + localAIOFileVideoData.jdField_g_of_type_Int);
      if ((!bapw.a(paramInt2, paramVideoPlayParam)) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) || (localAIOFileVideoData == null) || (localAIOFileVideoData.jdField_g_of_type_Int >= 2)) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 2, "handlePlayError, auto replay video.");
      ThreadManager.getUIHandler().post(new AIOFileVideoView.4(this, localAIOFileVideoData));
      return;
      label276:
      str1 = this.mContext.getString(2131718852);
    }
    ThreadManager.getUIHandler().post(new AIOFileVideoView.5(this));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "tryPlayVideo, position = " + paramInt);
    }
    Object localObject = this.jdField_a_of_type_Bbqd.getItem(paramInt);
    bbpu localbbpu;
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 103))
    {
      localObject = (AIOFileVideoData)((RichMediaBrowserInfo)localObject).baseData;
      if (QLog.isColorLevel()) {
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, String.format("tryPlayVideo, position:%d , msgId:%s request:%b ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(((AIOFileVideoData)localObject).jdField_a_of_type_Long), Boolean.valueOf(((AIOFileVideoData)localObject).jdField_d_of_type_Boolean) }));
      }
      ((AIOFileVideoData)localObject).h = paramBoolean;
      localbbpu = new bbpu();
      if ((!localbbpu.a((AIOFileVideoData)localObject)) && (!((AIOFileVideoData)localObject).jdField_d_of_type_Boolean))
      {
        localbbpu.a((AIOFileVideoData)localObject, (bbpk)RichMediaBrowserManager.getInstance().getProvider());
        this.jdField_a_of_type_Bbqd.a((AIOFileVideoData)localObject);
        this.jdField_a_of_type_Bbqd.a(((AIOFileVideoData)localObject).jdField_a_of_type_Long, ((AIOFileVideoData)localObject).jdField_a_of_type_Int, 4);
        updateUI();
      }
    }
    else
    {
      return;
    }
    a(localbbpu.a((AIOFileVideoData)localObject, ((AIOFileVideoData)localObject).i));
    if ((((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) && (((AIOFileVideoData)localObject).jdField_d_of_type_JavaLangString != null)) {
      b(5);
    }
    updateUI();
  }
  
  private void a(aklw paramaklw)
  {
    paramaklw = a(paramaklw);
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(paramaklw);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
    }
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
    //   10: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +12 -> 25
    //   16: ldc 68
    //   18: iconst_2
    //   19: ldc_w 442
    //   22: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: return
    //   26: invokestatic 448	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   29: invokevirtual 452	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   32: invokevirtual 457	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: astore_3
    //   36: new 454	java/io/File
    //   39: dup
    //   40: new 288	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   47: aload_3
    //   48: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 460	java/io/File:separator	Ljava/lang/String;
    //   54: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 462
    //   60: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 465	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 468	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_3
    //   78: invokevirtual 471	java/io/File:createNewFile	()Z
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 457	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: putfield 42	bbrg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   90: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +32 -> 125
    //   96: ldc 68
    //   98: iconst_2
    //   99: new 288	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 473
    //   109: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 42	bbrg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   116: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 42	bbrg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   130: invokestatic 479	com/tencent/mobileqq/filemanager/util/FileUtil:writeBitmapToFile	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   133: pop
    //   134: new 44	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 47	java/util/ArrayList:<init>	()V
    //   141: astore 6
    //   143: new 481	android/util/SparseArray
    //   146: dup
    //   147: iconst_2
    //   148: invokespecial 483	android/util/SparseArray:<init>	(I)V
    //   151: astore 7
    //   153: aload_1
    //   154: iconst_1
    //   155: iconst_3
    //   156: aload 7
    //   158: invokestatic 488	zmk:a	(Landroid/graphics/Bitmap;ZILandroid/util/SparseArray;)I
    //   161: istore_2
    //   162: iload_2
    //   163: invokestatic 491	zmk:a	(I)Z
    //   166: ifeq +98 -> 264
    //   169: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +12 -> 184
    //   175: ldc 68
    //   177: iconst_2
    //   178: ldc_w 493
    //   181: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 7
    //   186: iconst_1
    //   187: invokevirtual 497	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   190: astore_1
    //   191: aload_1
    //   192: instanceof 499
    //   195: ifeq +242 -> 437
    //   198: aload_1
    //   199: checkcast 499	android/util/Pair
    //   202: astore_3
    //   203: new 501	org/json/JSONObject
    //   206: dup
    //   207: invokespecial 502	org/json/JSONObject:<init>	()V
    //   210: astore_1
    //   211: aload_1
    //   212: ldc_w 504
    //   215: aload_3
    //   216: getfield 508	android/util/Pair:second	Ljava/lang/Object;
    //   219: invokestatic 511	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokevirtual 514	java/lang/String:trim	()Ljava/lang/String;
    //   225: invokevirtual 518	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload_1
    //   230: ldc_w 520
    //   233: aload_3
    //   234: getfield 523	android/util/Pair:first	Ljava/lang/Object;
    //   237: invokestatic 511	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 514	java/lang/String:trim	()Ljava/lang/String;
    //   243: invokevirtual 518	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload_1
    //   248: ifnonnull +136 -> 384
    //   251: ldc 40
    //   253: astore_1
    //   254: bipush 126
    //   256: aload 6
    //   258: aload_1
    //   259: iconst_0
    //   260: invokestatic 528	bhhh:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   263: pop
    //   264: iload_2
    //   265: invokestatic 530	zmk:b	(I)Z
    //   268: ifeq +74 -> 342
    //   271: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +12 -> 286
    //   277: ldc 68
    //   279: iconst_2
    //   280: ldc_w 532
    //   283: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload 7
    //   288: iconst_2
    //   289: invokevirtual 497	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   292: astore_3
    //   293: aload 5
    //   295: astore_1
    //   296: aload_3
    //   297: instanceof 384
    //   300: ifeq +25 -> 325
    //   303: aload_3
    //   304: checkcast 384	java/lang/String
    //   307: astore_3
    //   308: new 501	org/json/JSONObject
    //   311: dup
    //   312: invokespecial 502	org/json/JSONObject:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: ldc_w 534
    //   320: aload_3
    //   321: invokevirtual 518	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload_1
    //   326: ifnonnull +77 -> 403
    //   329: ldc 40
    //   331: astore_1
    //   332: bipush 127
    //   334: aload 6
    //   336: aload_1
    //   337: iconst_0
    //   338: invokestatic 528	bhhh:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   341: pop
    //   342: aload 6
    //   344: invokevirtual 536	java/util/ArrayList:isEmpty	()Z
    //   347: ifeq +64 -> 411
    //   350: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq -328 -> 25
    //   356: ldc 68
    //   358: iconst_2
    //   359: ldc_w 538
    //   362: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: return
    //   366: astore_3
    //   367: aload_3
    //   368: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   371: goto -237 -> 134
    //   374: astore_3
    //   375: aconst_null
    //   376: astore_1
    //   377: aload_3
    //   378: invokevirtual 542	org/json/JSONException:printStackTrace	()V
    //   381: goto -134 -> 247
    //   384: aload_1
    //   385: invokevirtual 543	org/json/JSONObject:toString	()Ljava/lang/String;
    //   388: astore_1
    //   389: goto -135 -> 254
    //   392: astore_3
    //   393: aload 4
    //   395: astore_1
    //   396: aload_3
    //   397: invokevirtual 542	org/json/JSONException:printStackTrace	()V
    //   400: goto -75 -> 325
    //   403: aload_1
    //   404: invokevirtual 543	org/json/JSONObject:toString	()Ljava/lang/String;
    //   407: astore_1
    //   408: goto -76 -> 332
    //   411: invokestatic 321	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   414: new 545	com/tencent/mobileqq/richmediabrowser/view/AIOFileVideoView$6
    //   417: dup
    //   418: aload_0
    //   419: aload 6
    //   421: invokespecial 548	com/tencent/mobileqq/richmediabrowser/view/AIOFileVideoView$6:<init>	(Lbbrg;Ljava/util/ArrayList;)V
    //   424: invokevirtual 332	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
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
    //   0	442	0	this	bbrg
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
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new bbri(this, paramVideoPlayParam);
  }
  
  private boolean a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    if ((paramAIOFileVideoData.jdField_f_of_type_Long == -7003L) || (paramAIOFileVideoData.jdField_f_of_type_Long == -6101L) || (paramAIOFileVideoData.jdField_f_of_type_Long == -103L) || (paramAIOFileVideoData.jdField_f_of_type_Long == -301L)) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqd.getSelectedItem();
      if ((localRichMediaBrowserInfo == null) || (!(localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData))) {
        break label74;
      }
      if (!FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_c_of_type_JavaLangString)) {
        return false;
      }
      this.e.setVisibility(0);
    }
    label74:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      this.e.setVisibility(4);
    }
  }
  
  private void b(int paramInt)
  {
    AIOFileVideoData localAIOFileVideoData = a();
    if (localAIOFileVideoData != null) {
      this.jdField_a_of_type_Bbqd.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, paramInt);
    }
  }
  
  private void b(AIOFileVideoData paramAIOFileVideoData)
  {
    if (!CheckPermission.isHasStoragePermission(this.mContext))
    {
      CheckPermission.requestStorePermission(this.mContext, null);
      return;
    }
    if (new bbpu().a(paramAIOFileVideoData))
    {
      auea.a(this.mContext, paramAIOFileVideoData.jdField_c_of_type_JavaLangString);
      return;
    }
    Bundle localBundle = new Bundle();
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().onFileVideoStatusChange(paramAIOFileVideoData.jdField_a_of_type_Long, 13, localBundle);
    }
    paramAIOFileVideoData.j = true;
    a(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int);
    updateUI();
  }
  
  private boolean c()
  {
    return (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder());
  }
  
  private void i(boolean paramBoolean)
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
  
  private void j()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
    j();
    if (this.jdField_a_of_type_Bbqd.a(this.jdField_a_of_type_Bbqd.getCurrentPosition())) {
      this.jdField_a_of_type_Bbqd.a(true);
    }
  }
  
  private void l()
  {
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
    if ((localAIOFileVideoData == null) || (!FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString))) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bixb != null) {
        this.jdField_a_of_type_Bixb.b();
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();
      this.jdField_a_of_type_Bixb = new bixb(this.mContext);
      this.jdField_a_of_type_Bixb.a(localAIOFileVideoData.jdField_c_of_type_JavaLangString, localAIOFileVideoData.jdField_a_of_type_Long, l);
      if (FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_Bixb.a(localAIOFileVideoData.jdField_b_of_type_JavaLangString, localAIOFileVideoData.jdField_c_of_type_Int, localAIOFileVideoData.jdField_d_of_type_Int);
      }
    } while (!this.jdField_a_of_type_Bixb.a(localAIOFileVideoData.jdField_b_of_type_Int, localAIOFileVideoData.jdField_c_of_type_Int, localAIOFileVideoData.jdField_d_of_type_Int));
    this.jdField_a_of_type_Bbqd.back();
  }
  
  public AIOFileVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqd.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103)) {
      return (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a()
  {
    if (this.mBrowserItemView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131380854));
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView = ((GalleryUrlImageView)this.mBrowserItemView.findViewById(2131373142));
      Object localObject = (RelativeLayout)this.mBrowserItemView.findViewById(2131372303);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131372047));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131377267));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131372304));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373226));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379301));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.e = ((ImageButton)this.mBrowserItemView.findViewById(2131374355));
      this.e.setContentDescription(anvx.a(2131699533));
      this.e.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131380526));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131380528));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131380527));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131364700));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131364110));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131376092));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374354));
      if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
        this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374356));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374362));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.mBrowserItemView.findViewById(2131381061);
      this.mBrowserItemView.findViewById(2131373141).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374357));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mBrowserItemView.findViewById(2131373141));
      this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131373143));
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
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
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
    if (localAIOFileVideoData != null) {
      a(localAIOFileVideoData, paramInt);
    }
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2, Bundle paramBundle)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "setVideoDrawableWithUrls position = " + paramInt1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqd.getItem(paramInt1);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {}
    boolean bool;
    for (;;)
    {
      return;
      if (localRichMediaBrowserInfo.baseData.getType() == 103)
      {
        paramString2 = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
        paramString2.jdField_a_of_type_AndroidOsBundle = paramBundle;
        paramMessageForShortVideo = new bbpu();
        if (paramString2.jdField_d_of_type_Boolean)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "fileVideo is playing:" + paramString2.id);
          return;
        }
        paramString2.jdField_c_of_type_JavaLangString = paramString1;
        paramString2.jdField_d_of_type_Boolean = true;
        if ("I:E".equals(paramString1)) {
          try
          {
            paramString2.jdField_f_of_type_Long = Long.parseLong(paramArrayOfString[0]);
            paramString1 = paramArrayOfString[1];
            ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_f_of_type_JavaLangString = paramString1;
            this.jdField_a_of_type_Bbqd.a(paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int, 8);
            if (paramString2.jdField_f_of_type_Long == -134L)
            {
              paramString1 = this.mContext.getString(2131718860);
              bool = true;
              if (bool)
              {
                paramString1 = bhdj.a(this.mContext, 230, "", paramString1, null, anvx.a(2131699570), new bbrh(this), null);
                if (paramString1.isShowing()) {
                  continue;
                }
                paramString1.show();
                return;
              }
            }
          }
          catch (NumberFormatException paramString1)
          {
            paramString2.jdField_f_of_type_Long = -1L;
            paramString2.jdField_e_of_type_JavaLangString = paramArrayOfString[1];
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbqd.a(paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int, 0);
      paramString1 = paramMessageForShortVideo.a(paramString2, paramString2.i);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "setVideoDrawableWithUrls autoPlay id = " + paramString2.id);
      this.jdField_a_of_type_Bbqd.a(paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int, 5);
      a(paramString1);
      return;
      bool = a(paramString2, false);
      break;
      paramString2.jdField_d_of_type_JavaLangString = paramArrayOfString[0];
      paramString2.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("cookies");
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqd.getSelectedItem();
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null) || (localRichMediaBrowserInfo.baseData.getType() != 103)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onRevokeMsg exp!");
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) || (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Bbqd.a(paramLong, paramInt, 2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bbqd.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_Bbqd.getSelectedIndex(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new bbrj(this, paramAIOFileVideoData));
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    if ((this.mContext != null) && (this.mContext.getIntent() != null)) {
      this.mContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    bhhh.a(2, this.jdField_b_of_type_JavaUtilArrayList);
    bhhh.a(27, this.jdField_b_of_type_JavaUtilArrayList);
    bhhh.a(39, this.jdField_c_of_type_JavaUtilArrayList);
    bhhh.a(6, this.jdField_c_of_type_JavaUtilArrayList);
    if ((bbph.a().g()) && (!TextUtils.isEmpty(bbph.a().c()))) {
      bhhh.a(54, this.jdField_c_of_type_JavaUtilArrayList);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.captureCurFrame(l, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_c_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_JavaLangString = null;
      a(paramAIOFileVideoData);
      paramAIOFileVideoData = this.jdField_a_of_type_Bbqd.a(paramAIOFileVideoData, this.mContext);
      if (paramAIOFileVideoData != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOFileVideoData);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
      if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "showActionSheet, captureCurFrame, from:" + paramInt + ", pos:" + this.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.captureCurFrame(this.jdField_a_of_type_Long, 0, 0);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "showActionSheet, video is not playing, recognize thumbnail");
        }
        ThreadManager.getSubThreadHandler().post(new AIOFileVideoView.7(this));
      }
    }
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.a(paramRichMediaBrowserInfo);
  }
  
  public boolean b()
  {
    if (super.b())
    {
      AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
      if ((localAIOFileVideoData != null) && (!bbph.a().c()) && (FileUtil.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public void bindView(int paramInt)
  {
    super.bindView(paramInt);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqd.getItem(paramInt);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {
      return;
    }
    Object localObject;
    AIOFileVideoData localAIOFileVideoData;
    bbpu localbbpu;
    if (localRichMediaBrowserInfo.baseData.getType() == 103)
    {
      localObject = this.jdField_a_of_type_Bbqd.a();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null) || (((RichMediaBrowserInfo)localObject).baseData.getType() != 103) || (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).jdField_a_of_type_Long != ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long) || (((RichMediaBrowserInfo)localObject).isReport)) {
        break label316;
      }
      bdla.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      ((RichMediaBrowserInfo)localObject).isReport = true;
      localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      localbbpu = new bbpu();
      localObject = (Drawable)this.jdField_a_of_type_Bbqd.mActiveDrawable.get(Integer.valueOf(paramInt));
      if (!localbbpu.b(localAIOFileVideoData)) {
        break label346;
      }
    }
    for (;;)
    {
      this.mBrowserItemView.setTag(2131296433, Boolean.valueOf(true));
      this.mBrowserItemView.setId(2131374323);
      this.mBrowserItemView.setOnClickListener(this);
      this.mBrowserItemView.setOnLongClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnLongClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setContentDescription(this.mContext.getString(2131691561));
      if (localbbpu.b(localAIOFileVideoData)) {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setImageDrawable(null);
      }
      if (localRichMediaBrowserInfo.isEnterImage) {
        localAIOFileVideoData.jdField_g_of_type_Boolean = true;
      }
      localObject = new bbrk(this);
      ((bbrk)localObject).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      this.mBrowserItemView.setTag(localObject);
      return;
      label316:
      bdla.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
      break;
      label346:
      if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 1)) {
        break label373;
      }
      this.jdField_a_of_type_Bbqd.onLoadFinish(paramInt, true);
    }
    label373:
    if (!TextUtils.isEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString))
    {
      File localFile = new File(localAIOFileVideoData.jdField_b_of_type_JavaLangString);
      if (!localFile.exists()) {
        break label499;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.mScreenWidthPx;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.mScreenHeightPx;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      localObject = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(Integer.valueOf(1));
      this.jdField_a_of_type_Bbqd.mActiveDrawable.put(Integer.valueOf(paramInt), (URLDrawable)localObject);
    }
    label499:
    for (;;)
    {
      break;
      localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111);
      break;
    }
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.jdField_a_of_type_Int = (bdgt.a(this.mContext) / 2);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void e(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doEnterImmersion, isClick = ").append(paramBoolean).append(" ,  isShowingDanmaku =");
      if (this.jdField_a_of_type_Bbqd.a() == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = this.jdField_a_of_type_Bbqd.a().b();; bool = false)
    {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, bool);
      super.e(paramBoolean);
      if (!paramBoolean) {
        break;
      }
      showContentView(false);
      b(false);
      this.jdField_a_of_type_Bbqd.b(false);
      return;
    }
    if ((this.jdField_a_of_type_Bbqd.a() != null) && (this.jdField_a_of_type_Bbqd.a().b()))
    {
      this.jdField_a_of_type_Bbqd.a().jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bbqd.d();
      this.jdField_a_of_type_Bbqd.e();
      i(false);
      return;
    }
    showContentView(false);
    b(false);
  }
  
  public void f()
  {
    i(true);
  }
  
  public void f(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      h(b());
      return;
    }
  }
  
  public void g(boolean paramBoolean)
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
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof bbrk)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((bbrk)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
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
      a();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      if (paramBoolean) {
        localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 49.0F, localDisplayMetrics));
      }
    }
    else
    {
      return;
    }
    localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 10.0F, localDisplayMetrics));
  }
  
  public void i()
  {
    a(this.jdField_a_of_type_Bbqd.getCurrentPosition(), true);
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "playBar is visible");
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_AndroidWidgetSeekBar.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if (new Rect(i, j, this.jdField_a_of_type_AndroidWidgetSeekBar.getWidth() + i, this.jdField_a_of_type_AndroidWidgetSeekBar.getHeight() + j).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "playBar deal event");
        h();
        return true;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "recyclerView deal event");
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
      AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()))
      {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "video playing, try PAUSE!");
        k();
      }
      for (;;)
      {
        this.jdField_a_of_type_Bbqd.i();
        g();
        break;
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "video pause, try PLAY!");
        new bbpu().a(localAIOFileVideoData, this.mContext, this);
      }
      if (this.jdField_a_of_type_Bbqd.b())
      {
        if (this.jdField_a_of_type_Bbqd.a().jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Bbqd.a().f();
          this.jdField_a_of_type_Bbqd.a().jdField_a_of_type_Boolean = false;
          e();
          this.jdField_a_of_type_Bbqd.a().a();
        }
        else
        {
          this.jdField_a_of_type_Bbqd.a().f();
          this.jdField_a_of_type_Bbqd.a().b();
          this.jdField_a_of_type_Bbqd.a().jdField_a_of_type_Boolean = true;
          e(true);
        }
      }
      else
      {
        this.jdField_a_of_type_Bbqd.back();
        continue;
        localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
        if (localAIOFileVideoData == null)
        {
          BrowserLogHelper.getInstance().getGalleryLog().e("AIOFileVideoView<FileAssistant>XOXO", 1, "presenter get data is null");
        }
        else
        {
          bbpu localbbpu = new bbpu();
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onItemClick id = " + localAIOFileVideoData.id);
          if (localbbpu.a(localAIOFileVideoData)) {
            this.jdField_a_of_type_Bbqd.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, 5);
          }
          for (;;)
          {
            a(this.jdField_a_of_type_Bbqd.getCurrentPosition(), false);
            h();
            updateUI();
            break;
            this.jdField_a_of_type_Bbqd.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, 1);
          }
          localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
          if (localAIOFileVideoData != null)
          {
            localAIOFileVideoData.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_Bbqd.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, 0);
            this.jdField_a_of_type_Bbqd.b(localAIOFileVideoData);
            this.jdField_a_of_type_Bbqd.back();
            continue;
            l();
            this.jdField_a_of_type_Bbqd.k();
            continue;
            d();
            continue;
            c();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onClick qq_gallery_danmaku_view ");
            }
            localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
            if (localAIOFileVideoData != null)
            {
              long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();
              MiniChatActivity.a(this.mContext, bbph.a().a(), bbph.a().a(), false, 26, localAIOFileVideoData.jdField_d_of_type_Long, l);
            }
            this.jdField_a_of_type_Bbqd.l();
            continue;
            if (this.basePresenter != null) {
              this.basePresenter.back();
            }
          }
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
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
      this.jdField_a_of_type_Bbqd.c(a());
    }
    this.jdField_a_of_type_Bbqd.getSelectedItem();
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_Bbqd.mActiveDrawable != null) {
      this.jdField_a_of_type_Bbqd.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    showContentView(false);
  }
  
  public void onExitAnimationStart() {}
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    bindView(paramInt);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onItemSelected position = " + paramInt);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Bbqd.getItem(paramInt);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {}
    while (localRichMediaBrowserInfo.baseData.getType() != 103) {
      return;
    }
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
    bbpu localbbpu = new bbpu();
    if ((localAIOFileVideoData.h) && (localbbpu.a(localAIOFileVideoData)))
    {
      a(paramInt, true);
      return;
    }
    this.jdField_a_of_type_Bbqd.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, 0);
    if (localRichMediaBrowserInfo.isEnterImage) {
      localAIOFileVideoData.jdField_g_of_type_Boolean = true;
    }
    if (RichMediaBrowserManager.getInstance().getProvider() != null)
    {
      if (localAIOFileVideoData.h)
      {
        this.jdField_a_of_type_Bbqd.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, 1);
        localbbpu.a(localAIOFileVideoData, (bbpk)RichMediaBrowserManager.getInstance().getProvider());
      }
      if ((!FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Bbqd.a(this.jdField_a_of_type_Bbqd.getCurrentPosition()))) {
        this.jdField_a_of_type_Bbqd.a(false);
      }
      updateUI();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "FileVideo_AP onItemSelected needUrl return");
      return;
    }
    if ((this.jdField_a_of_type_Bbqd.b(paramInt)) && (localRichMediaBrowserInfo.isEnterImage)) {
      a(localbbpu.a(localAIOFileVideoData, localAIOFileVideoData.i));
    }
    if ((!FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Bbqd.a(this.jdField_a_of_type_Bbqd.getCurrentPosition()))) {
      this.jdField_a_of_type_Bbqd.a(false);
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangString = null;
    updateUI();
  }
  
  public void onPause()
  {
    k();
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
      this.jdField_a_of_type_Bbqd.j();
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onResume");
    if ((this.jdField_a_of_type_Bbqd.b(this.jdField_a_of_type_Bbqd.getCurrentPosition())) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null))
    {
      AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
      if ((localAIOFileVideoData != null) && (localAIOFileVideoData.status == 6)) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
      }
    }
  }
  
  public void onScrollEnd()
  {
    super.onScrollEnd();
    AIOFileVideoData localAIOFileVideoData;
    if (this.jdField_a_of_type_Bbqd.a(this.jdField_a_of_type_Bbqd.getCurrentPosition()))
    {
      localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
      if (localAIOFileVideoData == null) {
        break label79;
      }
    }
    label79:
    for (boolean bool = FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString);; bool = false)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) && (bool))
      {
        this.jdField_a_of_type_Bbqd.a();
        return;
      }
      this.jdField_a_of_type_Bbqd.a(false);
      return;
    }
  }
  
  public void onScrollHalfScreenWidth()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onScrollHalfScreenWidth");
    }
    super.onScrollHalfScreenWidth();
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.mIsPlayVideo))
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      this.jdField_a_of_type_Bbqd.c(a());
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(true);
      this.jdField_a_of_type_Bbqd.c(a());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onStopTrackingTouch");
    if ((this.jdField_a_of_type_Bbqd.a() != null) && (this.jdField_a_of_type_Bbqd.a(this.jdField_a_of_type_Bbqd.getCurrentPosition())) && (paramSeekBar != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "seek danmaku");
      this.jdField_a_of_type_Bbqd.a().a(paramSeekBar.getProgress());
      AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Bbqd.a();
      if (localAIOFileVideoData != null) {
        this.jdField_a_of_type_Bbqd.a().a(bbpf.a(localAIOFileVideoData.jdField_d_of_type_Long, paramSeekBar.getProgress(), this.jdField_a_of_type_Bbqd.a(), this.jdField_a_of_type_Bbqd.a));
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void updateUI()
  {
    int i = 8;
    super.updateUI();
    Object localObject1 = this.jdField_a_of_type_Bbqd.a();
    if (localObject1 != null)
    {
      c(b());
      d(a(this.jdField_a_of_type_Bbqd.getSelectedItem()));
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "updateUI id = " + ((AIOFileVideoData)localObject1).id + ", status = " + ((AIOFileVideoData)localObject1).a());
    }
    float f;
    switch (((AIOFileVideoData)localObject1).status)
    {
    case 7: 
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "updateUI status is error, status = " + ((AIOFileVideoData)localObject1).status);
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 5: 
      do
      {
        return;
        this.jdField_a_of_type_Bbqd.onLoadFinish(this.jdField_a_of_type_Bbqd.getSelectedIndex(), true);
        g(false);
        localObject2 = this.mContext.getString(2131692612) + "(" + FileUtil.filesizeToString(((AIOFileVideoData)localObject1).jdField_g_of_type_Long) + "/" + FileUtil.filesizeToString(((AIOFileVideoData)localObject1).jdField_c_of_type_Long) + ")";
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long;
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(f * 100.0F) * 100);
        f(true);
        d(false);
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        a(false);
        return;
        this.jdField_a_of_type_Bbqd.onLoadFinish(this.jdField_a_of_type_Bbqd.getSelectedIndex(), true);
        f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long * 100.0F;
        localObject1 = new DecimalFormat("0.00").format(f);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(anvx.a(2131699539) + (String)localObject1 + "%");
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)f * 100);
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        g(false);
        f(true);
        d(false);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        a(false);
        return;
        localObject1 = this.mContext.getString(2131692612) + "(0/" + FileUtil.filesizeToString(((AIOFileVideoData)localObject1).jdField_c_of_type_Long) + ")";
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
        f(true);
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        g(false);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        d(false);
        a(false);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())
        {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_Bbqd.onLoadFinish(this.jdField_a_of_type_Bbqd.getSelectedIndex(), true);
          if (!((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean) {
            break label709;
          }
          g(true);
          f(false);
        }
        for (;;)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          a(true);
          return;
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          break;
          f(true);
          g(false);
          d(false);
        }
        this.jdField_a_of_type_Bbqd.onLoadFinish(this.jdField_a_of_type_Bbqd.getSelectedIndex(), true);
        g(true);
        f(false);
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846111);
        a(true);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setVisibility(8);
      } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "videoDuration = " + l);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(l));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
      return;
    case 6: 
      this.jdField_a_of_type_Bbqd.onLoadFinish(this.jdField_a_of_type_Bbqd.getSelectedIndex(), true);
      g(false);
      f(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846110);
      a(true);
      return;
    case 8: 
      label709:
      this.jdField_a_of_type_Bbqd.onLoadFinish(this.jdField_a_of_type_Bbqd.getSelectedIndex(), true);
      g(false);
      if (((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean) {
        f(false);
      }
      for (;;)
      {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846110);
        a(false);
        return;
        localObject2 = this.mContext.getString(2131692612) + "(" + FileUtil.filesizeToString(((AIOFileVideoData)localObject1).jdField_g_of_type_Long) + "/" + FileUtil.filesizeToString(((AIOFileVideoData)localObject1).jdField_c_of_type_Long) + ")";
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long;
        this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(f * 100.0F) * 100);
        f(true);
      }
    }
    this.jdField_a_of_type_Bbqd.onLoadFinish(this.jdField_a_of_type_Bbqd.getSelectedIndex(), true);
    g(false);
    f(false);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
    if (((AIOFileVideoData)localObject1).h)
    {
      ((ImageView)localObject2).setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846110);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      if (!((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean) {
        break label1252;
      }
      a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setVisibility(0);
      return;
      i = 0;
      break;
      label1252:
      a(false);
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_Bbqd.getItem(paramInt);
    if ((localObject1 == null) || (((RichMediaBrowserInfo)localObject1).baseData == null) || (paramView == null)) {
      return;
    }
    BaseVideoView localBaseVideoView;
    if ((paramView.getTag() instanceof bbrk))
    {
      localBaseVideoView = ((bbrk)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (((RichMediaBrowserInfo)localObject1).baseData.getType() == 103)
      {
        Object localObject2 = (AIOFileVideoData)((RichMediaBrowserInfo)localObject1).baseData;
        bbpu localbbpu = new bbpu();
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        localObject2 = localbbpu.a((AIOFileVideoData)localObject2);
        if (localObject2 == null) {
          break label196;
        }
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1) {
          break label172;
        }
        localBaseVideoView.setCoverDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Bbqd.onLoadFinish(paramInt, true);
        this.jdField_a_of_type_Bbqd.a().c();
      }
    }
    for (;;)
    {
      super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
      return;
      label172:
      ((URLDrawable)localObject1).setTag(Integer.valueOf(1));
      ((URLDrawable)localObject1).startDownload();
      localBaseVideoView.setCoverDrawable((Drawable)localObject1);
      break;
      label196:
      localBaseVideoView.setCoverDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838111));
      this.jdField_a_of_type_Bbqd.onLoadFinish(paramInt, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrg
 * JD-Core Version:    0.7.0.1
 */