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
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.7;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.DragGallery;
import com.tencent.richmediabrowser.view.page.Gallery.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ayao
  extends axzm
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public long a;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public SeekBar a;
  public TextView a;
  public axyy a;
  private beyi jdField_a_of_type_Beyi;
  public BaseVideoView a;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout b;
  public SeekBar b;
  public TextView b;
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ImageView c;
  public TextView c;
  public ImageButton d;
  public TextView d;
  public ImageButton e;
  public TextView e;
  
  public ayao(Activity paramActivity, axyy paramaxyy)
  {
    super(paramActivity, paramaxyy);
    this.jdField_a_of_type_Axyy = paramaxyy;
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
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "mVideoView != null, releasePlayer.");
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
    }
    paramViewGroup = this.jdField_a_of_type_Axyy.getItem(paramInt);
    AIOVideoData localAIOVideoData;
    if ((paramViewGroup != null) && (paramViewGroup.baseData != null) && (paramViewGroup.baseData.getType() == 101))
    {
      localAIOVideoData = (AIOVideoData)paramViewGroup.baseData;
      if ((!(paramView instanceof RelativeLayout)) || (!(paramView.getTag() instanceof ayax))) {
        break label380;
      }
      this.galleryView = ((RelativeLayout)paramView);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((ayax)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      paramView = null;
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.galleryView.findViewById(2131372257));
      this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.galleryView.findViewById(2131372259));
      paramViewGroup = new axyo();
      this.galleryView.setTag(2131296400, Boolean.valueOf(true));
      this.galleryView.setTag(2131296433, Boolean.valueOf(true));
      Object localObject = (URLDrawable)this.jdField_a_of_type_Axyy.b.get(Integer.valueOf(paramInt));
      if ((localObject == null) || (paramView == null)) {
        break label481;
      }
      paramView.setCoverDrawable((Drawable)localObject);
      label221:
      paramViewGroup = "0X8009EF2";
      if (localAIOVideoData.jdField_d_of_type_Int == 1) {
        paramViewGroup = "0X8009EF1";
      }
      this.galleryView.setContentDescription(this.mContext.getString(2131691692));
      localObject = this.jdField_a_of_type_Axyy.a();
      if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null) || (((RichMediaBrowserInfo)localObject).baseData.getType() != 101) || (((AIOVideoData)((RichMediaBrowserInfo)localObject).baseData).jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long) || (((RichMediaBrowserInfo)localObject).isReport)) {
        break label521;
      }
      azqs.b(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 1, 0, "", "", "", "");
      ((RichMediaBrowserInfo)localObject).isReport = true;
    }
    for (;;)
    {
      paramViewGroup = new ayax(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = paramView;
      this.galleryView.setTag(paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = paramView;
      return this.galleryView;
      return null;
      label380:
      this.galleryView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558576, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.galleryView.setLayoutParams(paramView);
      paramView = new GalleryUrlImageView(this.mContext);
      paramView = (BaseVideoView)axaz.a(this.mContext, localAIOVideoData.jdField_a_of_type_Long, null, paramView);
      paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramViewGroup.addRule(13);
      if (paramView != null) {
        this.galleryView.addView(paramView, paramViewGroup);
      }
      break;
      label481:
      if (paramViewGroup.a(localAIOVideoData, 0) == null) {
        break label221;
      }
      this.jdField_a_of_type_Axyy.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int, paramView.getCoverImage(), paramInt);
      break label221;
      label521:
      azqs.b(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 2, 0, "", "", "", "");
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt);
    }
    this.jdField_a_of_type_Boolean = true;
    f(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845707);
    a(true);
    Object localObject = this.jdField_a_of_type_Axyy.getItem(paramInt);
    aiqo localaiqo;
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 101))
    {
      localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_Axyy.a(((AIOVideoData)localObject).jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt + " , aioVideoPresenter.dealVideoAutoPlay , msgId = " + ((AIOVideoData)localObject).jdField_a_of_type_Long);
      }
      localaiqo = this.jdField_a_of_type_Axyy.a((AIOVideoData)localObject);
      if (localaiqo != null) {
        break label264;
      }
      this.jdField_a_of_type_Axyy.b((AIOVideoData)localObject);
      this.jdField_a_of_type_Axyy.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 4);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateItemStatus VIDEO_GETTING_URL , shortVideoData.msgId = " + ((AIOVideoData)localObject).jdField_a_of_type_Long + ", shortVideoData.subId = " + ((AIOVideoData)localObject).jdField_a_of_type_Int);
    }
    for (;;)
    {
      updateUI();
      return;
      label264:
      a(localaiqo);
      this.jdField_a_of_type_Axyy.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 5);
    }
  }
  
  private void a(aiqo paramaiqo)
  {
    if (paramaiqo == null) {
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo id = " + paramaiqo.jdField_a_of_type_Long);
    this.jdField_a_of_type_Axyy.a(paramaiqo.jdField_a_of_type_Long, paramaiqo.jdField_b_of_type_Int, 5);
    this.jdField_a_of_type_Axyy.a(0L, 0L, axyd.a().c());
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mSceneId = 101;
    localVideoPlayParam.mSceneName = (axba.a(101) + "_FulScr");
    if (this.jdField_a_of_type_Axyy != null) {
      localVideoPlayParam.mIsMute = this.jdField_a_of_type_Axyy.a(paramaiqo.jdField_a_of_type_Long);
    }
    if (!localVideoPlayParam.mIsMute) {
      j();
    }
    if (paramaiqo.jdField_a_of_type_Boolean)
    {
      localVideoPlayParam.mUrls = paramaiqo.jdField_a_of_type_ArrayOfJavaLangString;
      localVideoPlayParam.mSavePath = paramaiqo.jdField_a_of_type_JavaLangString;
      label178:
      if (paramaiqo.jdField_a_of_type_Boolean) {
        break label384;
      }
    }
    label384:
    for (boolean bool = true;; bool = false)
    {
      localVideoPlayParam.mIsLocal = bool;
      if (paramaiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        long l = paramaiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime * 1000;
        localVideoPlayParam.mVideoFileTimeMs = l;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo, videoDuration = " + l);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
      }
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      paramaiqo = paramaiqo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (paramaiqo != null)
      {
        localVideoPlayParam.mFileID = (paramaiqo.md5 + paramaiqo.uniseq);
        localVideoPlayParam.mFileSize = paramaiqo.videoFileSize;
      }
      localVideoPlayParam.mCallback = new ayap(this);
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(localVideoPlayParam);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
      return;
      localVideoPlayParam.mVideoPath = paramaiqo.jdField_a_of_type_JavaLangString;
      break label178;
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
    //   10: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   13: ifeq +12 -> 25
    //   16: ldc 63
    //   18: iconst_0
    //   19: ldc_w 521
    //   22: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: return
    //   26: invokestatic 527	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   29: invokevirtual 531	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   32: invokevirtual 536	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: astore_3
    //   36: new 533	java/io/File
    //   39: dup
    //   40: new 322	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   47: aload_3
    //   48: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 539	java/io/File:separator	Ljava/lang/String;
    //   54: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 541
    //   60: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 544	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 547	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_3
    //   78: invokevirtual 550	java/io/File:createNewFile	()Z
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 536	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: putfield 46	ayao:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   93: ifeq +32 -> 125
    //   96: ldc 63
    //   98: iconst_0
    //   99: new 322	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 552
    //   109: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 46	ayao:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   116: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 46	ayao:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   130: invokestatic 557	arso:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   133: pop
    //   134: new 35	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 38	java/util/ArrayList:<init>	()V
    //   141: astore 6
    //   143: new 559	android/util/SparseArray
    //   146: dup
    //   147: iconst_2
    //   148: invokespecial 561	android/util/SparseArray:<init>	(I)V
    //   151: astore 7
    //   153: aload_1
    //   154: iconst_1
    //   155: iconst_3
    //   156: aload 7
    //   158: invokestatic 566	yak:a	(Landroid/graphics/Bitmap;ZILandroid/util/SparseArray;)I
    //   161: istore_2
    //   162: iload_2
    //   163: invokestatic 569	yak:a	(I)Z
    //   166: ifeq +98 -> 264
    //   169: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   172: ifeq +12 -> 184
    //   175: ldc 63
    //   177: iconst_0
    //   178: ldc_w 571
    //   181: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 7
    //   186: iconst_1
    //   187: invokevirtual 574	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   190: astore_1
    //   191: aload_1
    //   192: instanceof 576
    //   195: ifeq +242 -> 437
    //   198: aload_1
    //   199: checkcast 576	android/util/Pair
    //   202: astore_3
    //   203: new 578	org/json/JSONObject
    //   206: dup
    //   207: invokespecial 579	org/json/JSONObject:<init>	()V
    //   210: astore_1
    //   211: aload_1
    //   212: ldc_w 581
    //   215: aload_3
    //   216: getfield 585	android/util/Pair:second	Ljava/lang/Object;
    //   219: invokestatic 590	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokevirtual 593	java/lang/String:trim	()Ljava/lang/String;
    //   225: invokevirtual 597	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload_1
    //   230: ldc_w 599
    //   233: aload_3
    //   234: getfield 602	android/util/Pair:first	Ljava/lang/Object;
    //   237: invokestatic 590	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 593	java/lang/String:trim	()Ljava/lang/String;
    //   243: invokevirtual 597	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload_1
    //   248: ifnonnull +136 -> 384
    //   251: ldc 44
    //   253: astore_1
    //   254: bipush 126
    //   256: aload 6
    //   258: aload_1
    //   259: iconst_0
    //   260: invokestatic 607	bdmp:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   263: pop
    //   264: iload_2
    //   265: invokestatic 609	yak:b	(I)Z
    //   268: ifeq +74 -> 342
    //   271: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   274: ifeq +12 -> 286
    //   277: ldc 63
    //   279: iconst_0
    //   280: ldc_w 611
    //   283: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload 7
    //   288: iconst_2
    //   289: invokevirtual 574	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   292: astore_3
    //   293: aload 5
    //   295: astore_1
    //   296: aload_3
    //   297: instanceof 587
    //   300: ifeq +25 -> 325
    //   303: aload_3
    //   304: checkcast 587	java/lang/String
    //   307: astore_3
    //   308: new 578	org/json/JSONObject
    //   311: dup
    //   312: invokespecial 579	org/json/JSONObject:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: ldc_w 613
    //   320: aload_3
    //   321: invokevirtual 597	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload_1
    //   326: ifnonnull +77 -> 403
    //   329: ldc 44
    //   331: astore_1
    //   332: bipush 127
    //   334: aload 6
    //   336: aload_1
    //   337: iconst_0
    //   338: invokestatic 607	bdmp:a	(ILjava/util/ArrayList;Ljava/lang/String;I)Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;
    //   341: pop
    //   342: aload 6
    //   344: invokevirtual 616	java/util/ArrayList:isEmpty	()Z
    //   347: ifeq +64 -> 411
    //   350: invokestatic 61	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   353: ifeq -328 -> 25
    //   356: ldc 63
    //   358: iconst_0
    //   359: ldc_w 618
    //   362: invokestatic 69	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: return
    //   366: astore_3
    //   367: aload_3
    //   368: invokevirtual 621	java/io/IOException:printStackTrace	()V
    //   371: goto -237 -> 134
    //   374: astore_3
    //   375: aconst_null
    //   376: astore_1
    //   377: aload_3
    //   378: invokevirtual 622	org/json/JSONException:printStackTrace	()V
    //   381: goto -134 -> 247
    //   384: aload_1
    //   385: invokevirtual 623	org/json/JSONObject:toString	()Ljava/lang/String;
    //   388: astore_1
    //   389: goto -135 -> 254
    //   392: astore_3
    //   393: aload 4
    //   395: astore_1
    //   396: aload_3
    //   397: invokevirtual 622	org/json/JSONException:printStackTrace	()V
    //   400: goto -75 -> 325
    //   403: aload_1
    //   404: invokevirtual 623	org/json/JSONObject:toString	()Ljava/lang/String;
    //   407: astore_1
    //   408: goto -76 -> 332
    //   411: invokestatic 629	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   414: new 631	com/tencent/mobileqq/richmediabrowser/view/AIOVideoView$10
    //   417: dup
    //   418: aload_0
    //   419: aload 6
    //   421: invokespecial 634	com/tencent/mobileqq/richmediabrowser/view/AIOVideoView$10:<init>	(Layao;Ljava/util/ArrayList;)V
    //   424: invokevirtual 640	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
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
    //   0	442	0	this	ayao
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
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    Object localObject1 = new axyo().a(paramAIOVideoData, 1);
    Object localObject2 = this.jdField_a_of_type_Axyy.getSelectedItem();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int i = 0;
    long l;
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      l = ((File)localObject1).length();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showActionSheetForShortVideo, file.getPath()=" + ((File)localObject1).getPath() + ", mTransferredSize = " + l + ", data.size = " + paramAIOVideoData.jdField_c_of_type_Long);
      if (paramAIOVideoData.jdField_d_of_type_Int == 1) {
        if ((paramAIOVideoData.jdField_d_of_type_Int == 1) && (i != 0)) {
          break label617;
        }
      }
    }
    label617:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        bdmp.a(2, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((bhtb.d()) && ((paramAIOVideoData.jdField_d_of_type_Int != 1) || (i == 0))) {
        bdmp.a(39, this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (i == 0)
      {
        bdmp.a(6, this.jdField_b_of_type_JavaUtilArrayList);
        bdmp.a(3, this.jdField_a_of_type_JavaUtilArrayList);
        bdmp.a(27, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((axyd.a().g()) && (!TextUtils.isEmpty(axyd.a().c())) && (axyd.a().a() != -1)) {
        bdmp.a(54, this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (i == 0) {
        bdmp.a(64, this.jdField_b_of_type_JavaUtilArrayList);
      }
      a(paramAIOVideoData, (File)localObject1, paramInt, (RichMediaBrowserInfo)localObject2);
      if (this.mContext != null) {
        this.mContext.getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList);
      if ((j != 0) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
      {
        paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, axyd.a().a());
        if (paramAIOVideoData != null)
        {
          paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
          if (this.jdField_a_of_type_Axyy.getSelectedItem() != null)
          {
            localObject1 = this.jdField_a_of_type_Axyy.getSelectedItem().baseData;
            if ((localObject1 instanceof AIOVideoData))
            {
              localObject1 = (AIOVideoData)localObject1;
              paramInt = ((AIOVideoData)localObject1).jdField_g_of_type_Int;
              localObject2 = BaseApplicationImpl.sApplication.getRuntime();
              if ((paramInt == LocalMediaInfo.REDBAG_TYPE_GET) && (((AppRuntime)localObject2).getAccount().equals(((AIOVideoData)localObject1).jdField_d_of_type_JavaLangString)))
              {
                paramAIOVideoData.putExtra("param_key_redbag_type", paramInt);
                paramAIOVideoData.putExtra("param_key_redbag_video_id", ((AIOVideoData)localObject1).jdField_c_of_type_JavaLangString);
                paramAIOVideoData.putExtra("from_session_uin", ((AIOVideoData)localObject1).jdField_e_of_type_JavaLangString);
              }
              if (((AIOVideoData)localObject1).k == 2) {
                paramAIOVideoData.putExtra("special_video_type", ((AIOVideoData)localObject1).k);
              }
              if (!TextUtils.isEmpty(((AIOVideoData)localObject1).jdField_f_of_type_JavaLangString))
              {
                paramAIOVideoData.putExtra("widgetinfo", ((AIOVideoData)localObject1).jdField_f_of_type_JavaLangString);
                paramAIOVideoData.putExtra("key_camera_material_name", ((AIOVideoData)localObject1).jdField_g_of_type_JavaLangString);
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOVideoData);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
      if (l >= paramAIOVideoData.jdField_c_of_type_Long) {
        break;
      }
      i = 1;
      break;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
      i = 1;
      break;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "0", "0", "");
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
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyy.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (this.jdField_a_of_type_Axyy.a((AIOVideoData)localRichMediaBrowserInfo.baseData) != null))
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
      this.jdField_a_of_type_Axyy.a(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, paramInt);
    }
  }
  
  private void h(boolean paramBoolean)
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
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
    k();
    b(6);
    this.jdField_a_of_type_Axyy.onLoadFinish(this.jdField_a_of_type_Axyy.getSelectedIndex(), true);
    f(true);
    e(false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845706);
    a(true);
    if (this.jdField_a_of_type_Axyy.a(this.jdField_a_of_type_Axyy.getCurrentPosition())) {
      this.jdField_a_of_type_Axyy.a(true);
    }
  }
  
  private void j()
  {
    if ((bhtb.b()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  private void k()
  {
    if ((bhtb.b()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void l()
  {
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (!TextUtils.isEmpty(localAIOVideoData.jdField_f_of_type_JavaLangString)))
    {
      bnld.a(this.mContext, localAIOVideoData.jdField_f_of_type_JavaLangString);
      azqs.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", localAIOVideoData.jdField_f_of_type_JavaLangString, "");
    }
  }
  
  private void m()
  {
    AIOVideoData localAIOVideoData = a();
    long l;
    if (localAIOVideoData != null)
    {
      if (this.jdField_a_of_type_Beyi != null) {
        this.jdField_a_of_type_Beyi.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
        break label147;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();
      this.jdField_a_of_type_Beyi = new beyi(this.mContext);
      aiqo localaiqo = this.jdField_a_of_type_Axyy.a(localAIOVideoData);
      if (localaiqo == null) {
        break label157;
      }
      this.jdField_a_of_type_Beyi.a(localaiqo, localAIOVideoData.jdField_e_of_type_Long, l);
      this.jdField_a_of_type_Beyi.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int);
      if (localAIOVideoData.jdField_e_of_type_Int <= localAIOVideoData.jdField_f_of_type_Int) {
        break label152;
      }
    }
    label147:
    label152:
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Beyi.a(bool, localAIOVideoData.jdField_b_of_type_Int)) {
        this.jdField_a_of_type_Axyy.back();
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
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axyy.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return (AIOVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a()
  {
    if (this.contentView == null)
    {
      this.contentView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559119, null));
      Object localObject = (RelativeLayout)this.contentView.findViewById(2131371460);
      this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)localObject).findViewById(2131371220);
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376325));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371461));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372339));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378220));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373509));
      this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(alud.a(2131700429));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131379355));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379357));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379356));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364328));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.contentView.findViewById(2131363779));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131375207));
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373508));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373510));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373516));
      this.jdField_e_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.contentView.findViewById(2131363905));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131363906));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = this.contentView.findViewById(2131379849);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373511));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (bnle.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bnle.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bnle.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bnle.jdField_a_of_type_Int;
      }
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(bdgm.a(this.mContext, 230, this.mContext.getString(2131719324), this.mContext.getString(2131719323), new ayav(this, paramInt, paramObject), new ayaw(this)));
  }
  
  public void a(long paramLong)
  {
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      int i = RichMediaBrowserManager.getInstance().getProvider().getSaveFileProgress(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int);
      if ((i < 0) || (i >= 100)) {
        break label151;
      }
    }
    label151:
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
    this.jdField_a_of_type_Axyy.a(paramLong, paramInt1, paramInt2, paramString1);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData == null) {
      return;
    }
    axzi.a().a(localAIOVideoData.jdField_a_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt3, paramString2);
    paramString2 = new aiqo();
    paramString2.jdField_a_of_type_Boolean = true;
    paramString2.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString2.jdField_a_of_type_JavaLangString = paramString1;
    paramString2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    paramString2.jdField_a_of_type_Int = paramInt3;
    paramString2.jdField_a_of_type_Long = localAIOVideoData.jdField_a_of_type_Long;
    paramString2.jdField_b_of_type_Int = localAIOVideoData.jdField_a_of_type_Int;
    paramString1 = new File(localAIOVideoData.jdField_b_of_type_JavaLangString);
    if (paramString1.exists()) {}
    for (paramString2.jdField_d_of_type_Long = paramString1.length();; paramString2.jdField_d_of_type_Long = 0L)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  " + paramString2.e);
      if (this.jdField_a_of_type_Boolean)
      {
        f(true);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845707);
        a(true);
        a(paramString2);
      }
      if (new axyo().a(localAIOVideoData, 0) != null) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
      if (RichMediaBrowserManager.getInstance().getProvider() == null) {
        break;
      }
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, 0);
      return;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new ayar(this, paramAIOVideoData, paramFile, paramInt, paramRichMediaBrowserInfo));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new ayas(this));
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "onItemClick, mCenterPlayBtn is null.");
      }
    }
    do
    {
      do
      {
        return false;
        if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOVideoView", 0, "onItemClick, event.getRawX() = " + paramMotionEvent.getRawX() + " , event.getRawY() = " + paramMotionEvent.getRawY() + " , mCenterPlayBtn left = " + this.jdField_c_of_type_AndroidWidgetImageView.getLeft() + " , top = " + this.jdField_c_of_type_AndroidWidgetImageView.getTop() + " , right = " + this.jdField_c_of_type_AndroidWidgetImageView.getRight() + ", bottom = " + this.jdField_c_of_type_AndroidWidgetImageView.getBottom());
        }
      } while (!new Rect(this.jdField_c_of_type_AndroidWidgetImageView.getLeft(), this.jdField_c_of_type_AndroidWidgetImageView.getTop(), this.jdField_c_of_type_AndroidWidgetImageView.getRight(), this.jdField_c_of_type_AndroidWidgetImageView.getBottom()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "onItemClick, playbtn contains event");
      }
      return true;
    } while (!QLog.isColorLevel());
    QLog.d("AIOVideoView", 0, "onItemClick, mCenterPlayBtn is not visible.");
    return false;
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
    this.jdField_a_of_type_Axyy.b.clear();
  }
  
  public void d(boolean paramBoolean)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "doEnterImmersion, isClick:" + paramBoolean + ", hasDanmaku:" + this.jdField_a_of_type_Axyy.c());
    super.d(paramBoolean);
    if (paramBoolean)
    {
      showContentView(false);
      this.jdField_a_of_type_Axyy.b(false);
      return;
    }
    if (this.jdField_a_of_type_Axyy.c())
    {
      this.jdField_a_of_type_Axyy.a().jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Axyy.d();
      h(false);
      return;
    }
    showContentView(false);
    this.jdField_a_of_type_Axyy.a().e();
  }
  
  public void e(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
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
  
  public void f()
  {
    h(true);
  }
  
  public void f(boolean paramBoolean)
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
  
  public void g()
  {
    clearTheOuchCache();
  }
  
  public void g(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      Object localObject = this.jdField_a_of_type_Axyy.getSelectedItem();
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
            if (!axyd.a().f())
            {
              i = j;
              if (!axyd.a().c())
              {
                i = j;
                if (axpm.a())
                {
                  i = j;
                  if (ShortVideoUtils.g())
                  {
                    AIOVideoData localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
                    i = j;
                    if (!TextUtils.isEmpty(localAIOVideoData.jdField_f_of_type_JavaLangString))
                    {
                      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                      localObject = this.mContext.getString(2131692983);
                      if (!TextUtils.isEmpty(localAIOVideoData.jdField_g_of_type_JavaLangString)) {
                        localObject = localAIOVideoData.jdField_g_of_type_JavaLangString;
                      }
                      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                      if (this.jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long)
                      {
                        azqs.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", localAIOVideoData.jdField_f_of_type_JavaLangString, "");
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
      if (i == 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "getView, position = " + paramInt);
    }
    this.jdField_a_of_type_Boolean = false;
    a();
    return a(paramInt, paramView, paramViewGroup);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isLocalPlay()) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()))
    {
      Object localObject = this.mContext.getString(2131720121);
      localObject = bdgm.a(this.mContext, 230, null, (String)localObject, 2131694806, 2131721503, new ayat(this), new ayau(this));
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      a((Dialog)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131371461: 
    case 2131364328: 
    case 2131373509: 
    case 2131373511: 
    case 2131373510: 
    case 2131373508: 
    case 2131373516: 
      label328:
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Boolean)
          {
            i();
            this.jdField_a_of_type_Boolean = false;
          }
          for (;;)
          {
            this.jdField_a_of_type_Axyy.g();
            this.jdField_a_of_type_Axyy.a().b();
            this.jdField_a_of_type_Axyy.a().jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Axyy.a().a();
            return;
            a(this.jdField_a_of_type_Axyy.getCurrentPosition());
          }
          paramView = this.jdField_a_of_type_Axyy.getSelectedItem();
        } while ((paramView == null) || (paramView.baseData == null));
        paramView = (AIOVideoData)paramView.baseData;
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 256);
        }
        this.jdField_a_of_type_Axyy.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
        updateUI();
        return;
        m();
        this.jdField_a_of_type_Axyy.i();
        return;
        d();
        return;
        c();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AIOVideoView", 0, "onClick qq_gallery_danmaku_view ");
        }
        paramView = this.jdField_a_of_type_Axyy.a();
        if (paramView != null) {
          if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
            break label328;
          }
        }
        for (long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();; l = 0L)
        {
          MiniChatActivity.a(this.mContext, axyd.a().a(), axyd.a().a(), false, 26, paramView.jdField_d_of_type_Long, l);
          this.jdField_a_of_type_Axyy.j();
          return;
        }
      } while (this.basePresenter == null);
      this.basePresenter.back();
      return;
    }
    if ((this.mContext instanceof AIOGalleryActivity))
    {
      paramView = (AIOGalleryActivity)this.mContext;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!amrk.a(this.mContext))
        {
          paramView.requestPermissions(new ayaq(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return;
        }
        l();
        return;
      }
      l();
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onClick, activity:" + this.mContext);
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (paramRichMediaBrowserInfo.baseData.getType() == 101))
    {
      localObject = (AIOVideoData)paramRichMediaBrowserInfo.baseData;
      paramRichMediaBrowserInfo = new axyo().a((AIOVideoData)localObject, 0);
      if (paramRichMediaBrowserInfo == null) {
        break label128;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bayu.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bayu.a;
      paramRichMediaBrowserInfo = URLDrawable.getDrawable(paramRichMediaBrowserInfo, (URLDrawable.URLDrawableOptions)localObject);
      paramRichMediaBrowserInfo.startDownload();
      this.jdField_a_of_type_Axyy.b.put(Integer.valueOf(paramInt), paramRichMediaBrowserInfo);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onCreateView(): preload thumb, position=" + paramInt);
    }
    for (;;)
    {
      return null;
      label128:
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onCreateView downloadMedia AIOShortVideoData.TYPE_THUMB");
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().downloadMedia(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Axyy.b.remove(Integer.valueOf(paramInt));
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
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Axyy.getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.baseData == null)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onItemClick data is null，position = " + paramInt);
    }
    do
    {
      do
      {
        return;
      } while (paramAdapterView.baseData.getType() != 101);
      if (!a(((DragGallery)this.jdField_a_of_type_Axyy.getGallery()).getSingleTapConfirmedEvent())) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, play button click.");
    } while (((AIOVideoData)paramAdapterView.baseData).status == 2);
    a(paramInt);
    return;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, handle immersion.");
    if (this.jdField_a_of_type_Axyy.b())
    {
      if (this.jdField_a_of_type_Axyy.a().jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Axyy.a().jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Axyy.a().a();
        e();
      }
      for (;;)
      {
        this.jdField_a_of_type_Axyy.a().f();
        return;
        this.jdField_a_of_type_Axyy.a().b();
        this.jdField_a_of_type_Axyy.a().jdField_a_of_type_Boolean = true;
        d(true);
      }
    }
    this.jdField_a_of_type_Axyy.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onItemSelected, position = " + paramInt + " ,  , basePresenter.getCurrentPosition() = " + this.basePresenter.getCurrentPosition() + " ,id = " + paramLong);
    }
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if ((this.jdField_a_of_type_Axyy != null) && (this.jdField_a_of_type_Axyy.b(paramInt))) {
      a(paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      return;
      f(false);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845706);
      }
      a(true);
      g(true);
    }
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPause");
    i();
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
      this.jdField_a_of_type_Axyy.h();
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
      f(true);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845707);
      return;
    }
    f(false);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845706);
  }
  
  public void onScrollEnd(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_Axyy.getCurrentPosition()) && (this.jdField_a_of_type_Axyy.a(paramInt)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
        this.jdField_a_of_type_Axyy.a();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Axyy.a(false);
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
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(true);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStopTrackingTouch");
    if ((this.jdField_a_of_type_Axyy.a() != null) && (this.jdField_a_of_type_Axyy.a(this.jdField_a_of_type_Axyy.getCurrentPosition())) && (paramSeekBar != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "seek danmaku");
      this.jdField_a_of_type_Axyy.a().a(paramSeekBar.getProgress());
      AIOVideoData localAIOVideoData = this.jdField_a_of_type_Axyy.a();
      if (localAIOVideoData != null) {
        this.jdField_a_of_type_Axyy.a().a(axyb.a(localAIOVideoData.jdField_d_of_type_Long, paramSeekBar.getProgress(), this.jdField_a_of_type_Axyy.a(), this.jdField_a_of_type_Axyy.a));
      }
    }
  }
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ayax)))
    {
      paramView = ((ayax)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      paramRichMediaBrowserInfo = (URLDrawable)this.jdField_a_of_type_Axyy.mActiveDrawable.get(Integer.valueOf(paramInt));
      if (paramRichMediaBrowserInfo != null)
      {
        paramView.setCoverDrawable(paramRichMediaBrowserInfo);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onViewDetached(): Use thumb cache replace video.");
      }
    }
    else
    {
      return;
    }
    paramView.setCoverDrawable(bayu.a);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void showActionSheet(int paramInt)
  {
    super.showActionSheet(paramInt);
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
        ThreadManager.getSubThreadHandler().post(new AIOVideoView.7(this));
      }
    }
  }
  
  public void updateUI()
  {
    int i = 8;
    super.updateUI();
    AIOVideoData localAIOVideoData = a();
    b(b());
    c(a(this.jdField_a_of_type_Axyy.getSelectedItem()));
    g(true);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI id = " + localAIOVideoData.id + ", status = " + localAIOVideoData.status);
    switch (localAIOVideoData.status)
    {
    case 1: 
    case 3: 
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI status is error, status = " + localAIOVideoData.status);
      return;
    case 2: 
      this.jdField_a_of_type_Axyy.onLoadFinish(this.jdField_a_of_type_Axyy.getSelectedIndex(), true);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(alud.a(2131700456) + localAIOVideoData.progress + "%");
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(localAIOVideoData.progress * 100);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      e(true);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      a(true);
      c(false);
      return;
    case 4: 
      this.jdField_a_of_type_Axyy.onLoadStart(this.jdField_a_of_type_Axyy.getSelectedIndex(), localAIOVideoData.progress);
      e(false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      a(false);
      c(false);
      return;
    }
    this.jdField_a_of_type_Axyy.onLoadFinish(this.jdField_a_of_type_Axyy.getSelectedIndex(), true);
    f(false);
    e(false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localAIOVideoData.jdField_f_of_type_Boolean) {}
    for (;;)
    {
      localImageView.setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845706);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      a(true);
      return;
      i = 0;
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_Axyy.getItem(paramInt);
    if ((localObject2 == null) || (((RichMediaBrowserInfo)localObject2).baseData == null) || (paramView == null)) {
      return;
    }
    if ((paramView.getTag() instanceof ayax))
    {
      Object localObject1 = ((ayax)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (((RichMediaBrowserInfo)localObject2).baseData.getType() == 101)
      {
        localObject2 = (AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateView loadShortVideoCover");
        this.jdField_a_of_type_Axyy.a(((AIOVideoData)localObject2).jdField_a_of_type_JavaLangString, ((AIOVideoData)localObject2).jdField_e_of_type_Int, ((AIOVideoData)localObject2).jdField_f_of_type_Int, ((BaseVideoView)localObject1).getCoverImage(), paramInt);
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = this.jdField_a_of_type_Axyy.a((AIOVideoData)localObject2);
          if (localObject1 != null) {
            a((aiqo)localObject1);
          }
        }
      }
    }
    super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayao
 * JD-Core Version:    0.7.0.1
 */