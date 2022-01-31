package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.lightReply.ImageExplodeLayout;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.WatermarkVideoRunnable;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.UnCompletedCode;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;
import vrs;
import vrt;
import vrw;
import vry;
import vrz;
import vsa;
import vsb;
import vsc;
import vsd;
import vse;
import vsf;
import vsg;
import vsh;
import vsk;
import vsm;
import vsp;
import vsq;
import vss;

public class AIOGalleryScene
  extends AbstractGalleryScene
  implements View.OnClickListener, View.OnTouchListener
{
  protected static Drawable a;
  final int jdField_a_of_type_Int = -3321;
  long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected BroadcastReceiver a;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new vsf(this);
  View jdField_a_of_type_AndroidViewView;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ProgressBar a;
  public TextView a;
  public AIOGalleryAdapter a;
  public AIOImageListModel a;
  public IAIOImageProvider a;
  LightReplyMenuManager jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager;
  private ShortVideoUtils.WatermarkVideoRunnable jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUtils$WatermarkVideoRunnable;
  public RedBagVideoManager a;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  public String a;
  public HashMap a;
  public final MqqHandler a;
  public vss a;
  boolean jdField_a_of_type_Boolean = false;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  public RelativeLayout b;
  public TextView b;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  ImageButton jdField_c_of_type_AndroidWidgetImageButton;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  final int jdField_d_of_type_Int = -2147483648;
  ImageButton jdField_d_of_type_AndroidWidgetImageButton;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  public String e;
  boolean jdField_e_of_type_Boolean = false;
  public int f;
  String f;
  public int g;
  public String g;
  boolean g;
  public int h;
  public String h;
  boolean h;
  public int i;
  public boolean i;
  protected int j;
  public boolean j;
  public int k;
  boolean k;
  private int jdField_l_of_type_Int;
  boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  boolean jdField_m_of_type_Boolean = false;
  boolean n;
  public boolean o;
  boolean p = false;
  boolean q = false;
  boolean r;
  boolean s;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
  }
  
  public AIOGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 1;
    this.jdField_i_of_type_Int = 5;
    this.jdField_j_of_type_Int = 300;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_MqqOsMqqHandler = new vsh(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vsd(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.jdField_b_of_type_JavaLangString = ((PeakActivity)paramActivity).a.getCurrentAccountUin();
    }
    this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager = LightReplyMenuManager.a();
    this.jdField_j_of_type_Int = AIOUtils.a(150.0F, paramActivity.getResources());
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "replyPhotoBtn: replyPhotoBtn is " + this.jdField_b_of_type_AndroidWidgetImageButton + " replyPhotoBtn is " + this.s);
    }
    if ((this.jdField_b_of_type_AndroidWidgetImageButton == null) || (!this.s) || (MsgProxyUtils.a(this.jdField_g_of_type_Int) == 1032)) {
      return;
    }
    AIORichMediaData localAIORichMediaData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (this.jdField_f_of_type_Boolean)
    {
      QLog.d("AIOGalleryScene", 2, "replyPhotoBtn: isFromImageList: true");
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    if ((localAIORichMediaData instanceof AIOImageData))
    {
      AIOImageData localAIOImageData = (AIOImageData)localAIORichMediaData;
      QLog.d("AIOGalleryScene", 2, "replyPhotoBtn: isAIOImageData true, isPicFile: " + localAIOImageData.jdField_g_of_type_Boolean + " isFromImageList: false");
      if ((localAIORichMediaData.a(2) != null) || (localAIORichMediaData.a(4) != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(true);
        ReportController.b(null, "dc00899", "Grp_replyPic", "", "picViewer", "exp_reply", 0, 0, localAIOImageData.jdField_g_of_type_JavaLangString, "", "", "");
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    if ((localAIORichMediaData instanceof AIOFilePicData))
    {
      QLog.d("AIOGalleryScene", 2, "replyPhotoBtn: isAIOFilePicData true  isFromImageList: false");
      if (((AIOFilePicData)localAIORichMediaData).jdField_a_of_type_Long > 10485760)
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
        return;
      }
      if ((localAIORichMediaData.a(18) != null) || (localAIORichMediaData.a(20) != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(true);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
  
  private ProgressPieDrawable a(Context paramContext)
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(paramContext);
    localProgressPieDrawable.a(AIOUtils.a(50.0F, paramContext.getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.f(-1);
    localProgressPieDrawable.e(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.g(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new vsc(this));
    return localProgressPieDrawable;
  }
  
  private String a(float paramFloat, int paramInt)
  {
    if (paramFloat > 0.0F)
    {
      String str1 = FileUtil.a(paramFloat);
      String str2 = FileUtil.a((paramInt * paramFloat / 10000.0F));
      return str2 + "/" + str1;
    }
    return paramInt / 100 + "%";
  }
  
  public static void a(AIORichMediaInfo paramAIORichMediaInfo, Activity paramActivity)
  {
    if (!AIOImageData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    File localFile = localAIOImageData.a(4);
    if (localFile == null) {
      localFile = localAIOImageData.a(2);
    }
    for (int i1 = 0;; i1 = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.a(1));
      paramAIORichMediaInfo = paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (i1 != 0) {}
      for (int i2 = 4;; i2 = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", paramAIORichMediaInfo.a(i2));
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (i1 != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
          if (localAIOImageData.jdField_c_of_type_Int == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramAIORichMediaInfo = new Intent();
          paramAIORichMediaInfo.putExtras(localBundle);
          ForwardBaseOption.a(paramActivity, paramAIORichMediaInfo, 0);
          return;
        }
        catch (NullPointerException paramAIORichMediaInfo) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,NullPointerException: " + paramAIORichMediaInfo);
      return;
    }
  }
  
  private void y()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
      if ((AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject)) && ((((AIOGalleryAdapter.GalleryImageStruct)localObject).a() instanceof URLDrawable)))
      {
        localObject = ((URLDrawable)((AIOGalleryAdapter.GalleryImageStruct)localObject).a()).getCurrDrawable();
        if ((localObject != null) && ((localObject instanceof VideoDrawable))) {
          ((VideoDrawable)localObject).resetAndPlayAudioCircle();
        }
      }
    }
  }
  
  private void z()
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      if ("showEditPicBtn: editPhotoBtn is " + this.jdField_a_of_type_AndroidWidgetImageButton == null + " editPhotoBtn is " + this.s)
      {
        bool = true;
        QLog.d("AIOGalleryScene", 2, new Object[] { Boolean.valueOf(bool) });
      }
    }
    else {
      if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.s)) {
        break label98;
      }
    }
    label98:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null))
    {
      return;
      bool = false;
      break;
    }
    AIORichMediaData localAIORichMediaData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (this.jdField_f_of_type_Boolean)
    {
      QLog.d("AIOGalleryScene", 2, "showEditPicBtn: isFromImageList: true");
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    if ((localAIORichMediaData instanceof AIOImageData))
    {
      QLog.d("AIOGalleryScene", 2, "showEditPicBtn: isAIOImageData true, isPicFile: " + ((AIOImageData)localAIORichMediaData).jdField_g_of_type_Boolean + " isFromImageList: false");
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if ((localAIORichMediaData.a(2) != null) || (localAIORichMediaData.a(4) != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      return;
    }
    if ((localAIORichMediaData instanceof AIOFilePicData))
    {
      QLog.d("AIOGalleryScene", 2, "showEditPicBtn: isAIOFilePicData true  isFromImageList: false");
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if (((AIOFilePicData)localAIORichMediaData).jdField_a_of_type_Long > 10485760)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
        return;
      }
      if ((localAIORichMediaData.a(18) != null) || (localAIORichMediaData.a(20) != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130970539, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    int i1;
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false))
    {
      i1 = 1;
      if (!this.jdField_e_of_type_Boolean) {
        break label95;
      }
    }
    label95:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, true, i1);; this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, false, i1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a = new vrw(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(new vry(this));
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
      i1 = 0;
      break;
    }
  }
  
  /* Error */
  public Boolean a(File paramFile)
  {
    // Byte code:
    //   0: iconst_2
    //   1: iconst_0
    //   2: ldc_w 586
    //   5: ldc_w 588
    //   8: invokestatic 593	com/tencent/qbar/QbarNativeImpl:a	(IILjava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: iconst_2
    //   13: newarray int
    //   15: astore 8
    //   17: aload 8
    //   19: iconst_0
    //   20: iconst_2
    //   21: iastore
    //   22: aload 8
    //   24: iconst_1
    //   25: iconst_0
    //   26: iastore
    //   27: aload 8
    //   29: aload 8
    //   31: arraylength
    //   32: invokestatic 596	com/tencent/qbar/QbarNativeImpl:a	([II)I
    //   35: pop
    //   36: new 187	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 598
    //   46: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 405	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 604	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   62: astore 11
    //   64: iconst_m1
    //   65: istore_2
    //   66: aconst_null
    //   67: astore 10
    //   69: aconst_null
    //   70: astore 8
    //   72: aload 8
    //   74: astore_1
    //   75: aload 10
    //   77: astore 9
    //   79: iload_2
    //   80: istore 4
    //   82: aload_0
    //   83: getfield 177	com/tencent/mobileqq/activity/aio/photo/AIOGalleryScene:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   86: invokevirtual 608	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   89: astore 13
    //   91: aload 8
    //   93: astore_1
    //   94: aload 10
    //   96: astore 9
    //   98: iload_2
    //   99: istore 4
    //   101: new 610	android/graphics/BitmapFactory$Options
    //   104: dup
    //   105: invokespecial 611	android/graphics/BitmapFactory$Options:<init>	()V
    //   108: astore 12
    //   110: aload 8
    //   112: astore_1
    //   113: aload 10
    //   115: astore 9
    //   117: iload_2
    //   118: istore 4
    //   120: aload 12
    //   122: iconst_1
    //   123: putfield 614	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   126: aload 8
    //   128: astore_1
    //   129: aload 10
    //   131: astore 9
    //   133: iload_2
    //   134: istore 4
    //   136: aload 13
    //   138: aload 11
    //   140: invokevirtual 620	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   143: astore 8
    //   145: aload 8
    //   147: astore_1
    //   148: aload_1
    //   149: astore 8
    //   151: aload_1
    //   152: astore 9
    //   154: aload_1
    //   155: aconst_null
    //   156: aload 12
    //   158: invokestatic 626	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   161: pop
    //   162: aload_1
    //   163: ifnull +13 -> 176
    //   166: aload_1
    //   167: astore 8
    //   169: aload_1
    //   170: astore 9
    //   172: aload_1
    //   173: invokevirtual 631	java/io/InputStream:close	()V
    //   176: aload_1
    //   177: astore 8
    //   179: aload_1
    //   180: astore 9
    //   182: aload 12
    //   184: getfield 634	android/graphics/BitmapFactory$Options:outWidth	I
    //   187: istore 6
    //   189: aload_1
    //   190: astore 8
    //   192: aload_1
    //   193: astore 9
    //   195: aload 12
    //   197: getfield 637	android/graphics/BitmapFactory$Options:outHeight	I
    //   200: istore 7
    //   202: aload_1
    //   203: astore 8
    //   205: aload_1
    //   206: astore 9
    //   208: aload 12
    //   210: iconst_0
    //   211: putfield 614	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   214: iload 6
    //   216: iload 7
    //   218: imul
    //   219: ldc_w 638
    //   222: if_icmple +970 -> 1192
    //   225: aload_1
    //   226: astore 8
    //   228: aload_1
    //   229: astore 9
    //   231: aload 12
    //   233: iload 6
    //   235: iload 7
    //   237: imul
    //   238: i2d
    //   239: invokestatic 644	java/lang/Math:sqrt	(D)D
    //   242: ldc2_w 645
    //   245: ddiv
    //   246: invokestatic 649	java/lang/Math:ceil	(D)D
    //   249: d2i
    //   250: putfield 652	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   253: aload_1
    //   254: astore 8
    //   256: aload_1
    //   257: astore 9
    //   259: aload 13
    //   261: aload 11
    //   263: invokevirtual 620	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   266: astore 10
    //   268: aload 10
    //   270: astore 8
    //   272: aload 8
    //   274: astore_1
    //   275: aload 8
    //   277: astore 9
    //   279: iload_2
    //   280: istore 4
    //   282: aload 8
    //   284: aconst_null
    //   285: aload 12
    //   287: invokestatic 626	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   290: astore 14
    //   292: aload 8
    //   294: ifnull +18 -> 312
    //   297: aload 8
    //   299: astore_1
    //   300: aload 8
    //   302: astore 9
    //   304: iload_2
    //   305: istore 4
    //   307: aload 8
    //   309: invokevirtual 631	java/io/InputStream:close	()V
    //   312: aload 8
    //   314: astore_1
    //   315: aload 8
    //   317: astore 9
    //   319: iload_2
    //   320: istore 4
    //   322: aload 14
    //   324: invokevirtual 657	android/graphics/Bitmap:getWidth	()I
    //   327: istore_3
    //   328: aload 8
    //   330: astore_1
    //   331: aload 8
    //   333: astore 9
    //   335: iload_2
    //   336: istore 4
    //   338: aload 14
    //   340: invokevirtual 660	android/graphics/Bitmap:getHeight	()I
    //   343: istore 5
    //   345: aload 8
    //   347: astore_1
    //   348: aload 8
    //   350: astore 9
    //   352: iload_2
    //   353: istore 4
    //   355: iload_3
    //   356: iload 5
    //   358: imul
    //   359: newarray int
    //   361: astore 10
    //   363: aload 8
    //   365: astore_1
    //   366: aload 8
    //   368: astore 9
    //   370: iload_2
    //   371: istore 4
    //   373: aload 14
    //   375: aload 10
    //   377: iconst_0
    //   378: iload_3
    //   379: iconst_0
    //   380: iconst_0
    //   381: iload_3
    //   382: iload 5
    //   384: invokevirtual 664	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   387: aload 8
    //   389: astore_1
    //   390: aload 8
    //   392: astore 9
    //   394: iload_2
    //   395: istore 4
    //   397: aload 14
    //   399: invokevirtual 667	android/graphics/Bitmap:recycle	()V
    //   402: aload 8
    //   404: astore_1
    //   405: aload 8
    //   407: astore 9
    //   409: iload_2
    //   410: istore 4
    //   412: iload_3
    //   413: iload 5
    //   415: imul
    //   416: newarray byte
    //   418: astore 14
    //   420: aload 8
    //   422: astore_1
    //   423: aload 8
    //   425: astore 9
    //   427: iload_2
    //   428: istore 4
    //   430: aload 10
    //   432: aload 14
    //   434: iload_3
    //   435: iload 5
    //   437: invokestatic 672	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   440: pop
    //   441: aload 8
    //   443: astore_1
    //   444: aload 8
    //   446: astore 9
    //   448: iload_2
    //   449: istore 4
    //   451: aload 14
    //   453: iload_3
    //   454: iload 5
    //   456: iconst_0
    //   457: invokestatic 675	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   460: istore_3
    //   461: iload_3
    //   462: istore_2
    //   463: aload 8
    //   465: astore_1
    //   466: iload_2
    //   467: istore_3
    //   468: iload_2
    //   469: iconst_1
    //   470: if_icmpeq +349 -> 819
    //   473: iload 6
    //   475: iconst_2
    //   476: imul
    //   477: iload 7
    //   479: if_icmpgt +829 -> 1308
    //   482: iload 6
    //   484: sipush 1024
    //   487: if_icmpge +821 -> 1308
    //   490: aload 8
    //   492: astore 9
    //   494: aload 8
    //   496: astore 10
    //   498: iload_2
    //   499: istore 4
    //   501: aload 13
    //   503: aload 11
    //   505: invokevirtual 620	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   508: astore_1
    //   509: aload_1
    //   510: astore 8
    //   512: aload 8
    //   514: astore_1
    //   515: aload 8
    //   517: astore 9
    //   519: iload_2
    //   520: istore 4
    //   522: iload_2
    //   523: istore_3
    //   524: aload 8
    //   526: invokestatic 678	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   529: astore 10
    //   531: aload 8
    //   533: astore_1
    //   534: aload 8
    //   536: astore 9
    //   538: iload_2
    //   539: istore 4
    //   541: iload_2
    //   542: istore_3
    //   543: invokestatic 681	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   546: ifeq +42 -> 588
    //   549: aload 8
    //   551: astore_1
    //   552: aload 8
    //   554: astore 9
    //   556: iload_2
    //   557: istore 4
    //   559: iload_2
    //   560: istore_3
    //   561: ldc 185
    //   563: iconst_4
    //   564: new 187	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 683
    //   574: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 10
    //   579: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: aload 8
    //   590: astore_1
    //   591: aload 8
    //   593: astore 9
    //   595: iload_2
    //   596: istore 4
    //   598: iload_2
    //   599: istore_3
    //   600: aload 8
    //   602: invokevirtual 631	java/io/InputStream:close	()V
    //   605: aload 8
    //   607: astore_1
    //   608: aload 8
    //   610: astore 9
    //   612: iload_2
    //   613: istore 4
    //   615: iload_2
    //   616: istore_3
    //   617: iload 6
    //   619: iload 6
    //   621: imul
    //   622: newarray int
    //   624: astore 14
    //   626: aload 8
    //   628: astore_1
    //   629: aload 8
    //   631: astore 9
    //   633: iload_2
    //   634: istore 4
    //   636: iload_2
    //   637: istore_3
    //   638: aload 10
    //   640: aload 14
    //   642: iconst_0
    //   643: iload 6
    //   645: iconst_0
    //   646: iconst_0
    //   647: iload 6
    //   649: iload 6
    //   651: invokevirtual 664	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   654: aload 8
    //   656: astore_1
    //   657: aload 8
    //   659: astore 9
    //   661: iload_2
    //   662: istore 4
    //   664: iload_2
    //   665: istore_3
    //   666: iload 6
    //   668: iload 6
    //   670: imul
    //   671: newarray byte
    //   673: astore 15
    //   675: aload 8
    //   677: astore_1
    //   678: aload 8
    //   680: astore 9
    //   682: iload_2
    //   683: istore 4
    //   685: iload_2
    //   686: istore_3
    //   687: aload 14
    //   689: aload 15
    //   691: iload 6
    //   693: iload 6
    //   695: invokestatic 672	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   698: pop
    //   699: aload 8
    //   701: astore_1
    //   702: aload 8
    //   704: astore 9
    //   706: iload_2
    //   707: istore 4
    //   709: iload_2
    //   710: istore_3
    //   711: aload 15
    //   713: iload 6
    //   715: iload 6
    //   717: iconst_0
    //   718: invokestatic 675	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   721: istore_2
    //   722: iload_2
    //   723: iconst_1
    //   724: if_icmpeq +1178 -> 1902
    //   727: aload 8
    //   729: astore_1
    //   730: aload 8
    //   732: astore 9
    //   734: iload_2
    //   735: istore 4
    //   737: iload_2
    //   738: istore_3
    //   739: aload 10
    //   741: aload 14
    //   743: iconst_0
    //   744: iload 6
    //   746: iconst_0
    //   747: iload 7
    //   749: iload 6
    //   751: isub
    //   752: iload 6
    //   754: iload 6
    //   756: invokevirtual 664	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   759: aload 8
    //   761: astore_1
    //   762: aload 8
    //   764: astore 9
    //   766: iload_2
    //   767: istore 4
    //   769: iload_2
    //   770: istore_3
    //   771: aload 14
    //   773: aload 15
    //   775: iload 6
    //   777: iload 6
    //   779: invokestatic 672	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   782: pop
    //   783: aload 8
    //   785: astore_1
    //   786: aload 8
    //   788: astore 9
    //   790: iload_2
    //   791: istore 4
    //   793: iload_2
    //   794: istore_3
    //   795: aload 15
    //   797: iload 6
    //   799: iload 6
    //   801: iconst_0
    //   802: invokestatic 675	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   805: istore_2
    //   806: aload 8
    //   808: astore_1
    //   809: aload 10
    //   811: invokevirtual 667	android/graphics/Bitmap:recycle	()V
    //   814: aload 8
    //   816: astore_1
    //   817: iload_2
    //   818: istore_3
    //   819: aload_1
    //   820: astore 8
    //   822: iload_3
    //   823: iconst_1
    //   824: if_icmpeq +936 -> 1760
    //   827: aload_1
    //   828: astore 9
    //   830: aload_1
    //   831: astore 10
    //   833: iload_3
    //   834: istore 4
    //   836: iload 6
    //   838: iload 7
    //   840: invokestatic 687	java/lang/Math:min	(II)I
    //   843: istore_2
    //   844: aload_1
    //   845: astore 8
    //   847: iload_2
    //   848: sipush 250
    //   851: if_icmple +909 -> 1760
    //   854: aload_1
    //   855: astore 9
    //   857: aload_1
    //   858: astore 10
    //   860: iload_3
    //   861: istore 4
    //   863: aload 12
    //   865: iload_2
    //   866: i2d
    //   867: ldc2_w 688
    //   870: ddiv
    //   871: invokestatic 649	java/lang/Math:ceil	(D)D
    //   874: d2i
    //   875: putfield 652	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   878: aload_1
    //   879: astore 9
    //   881: aload_1
    //   882: astore 10
    //   884: iload_3
    //   885: istore 4
    //   887: aload 13
    //   889: aload 11
    //   891: invokevirtual 620	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   894: astore 8
    //   896: aload 8
    //   898: astore_1
    //   899: aload 8
    //   901: astore 9
    //   903: iload_3
    //   904: istore 4
    //   906: aload 8
    //   908: aconst_null
    //   909: aload 12
    //   911: invokestatic 626	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   914: astore 12
    //   916: aload 8
    //   918: astore_1
    //   919: aload 8
    //   921: astore 9
    //   923: iload_3
    //   924: istore 4
    //   926: invokestatic 681	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   929: ifeq +40 -> 969
    //   932: aload 8
    //   934: astore_1
    //   935: aload 8
    //   937: astore 9
    //   939: iload_3
    //   940: istore 4
    //   942: ldc 185
    //   944: iconst_4
    //   945: new 187	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   952: ldc_w 691
    //   955: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: aload 12
    //   960: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   963: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   969: aload 8
    //   971: astore_1
    //   972: aload 8
    //   974: astore 9
    //   976: iload_3
    //   977: istore 4
    //   979: aload 8
    //   981: invokevirtual 631	java/io/InputStream:close	()V
    //   984: aload 8
    //   986: astore_1
    //   987: aload 8
    //   989: astore 9
    //   991: iload_3
    //   992: istore 4
    //   994: aload 12
    //   996: invokevirtual 657	android/graphics/Bitmap:getWidth	()I
    //   999: istore_2
    //   1000: aload 8
    //   1002: astore_1
    //   1003: aload 8
    //   1005: astore 9
    //   1007: iload_3
    //   1008: istore 4
    //   1010: aload 12
    //   1012: invokevirtual 660	android/graphics/Bitmap:getHeight	()I
    //   1015: istore 5
    //   1017: aload 8
    //   1019: astore_1
    //   1020: aload 8
    //   1022: astore 9
    //   1024: iload_3
    //   1025: istore 4
    //   1027: iload_2
    //   1028: iload 5
    //   1030: imul
    //   1031: newarray int
    //   1033: astore 10
    //   1035: aload 8
    //   1037: astore_1
    //   1038: aload 8
    //   1040: astore 9
    //   1042: iload_3
    //   1043: istore 4
    //   1045: aload 12
    //   1047: aload 10
    //   1049: iconst_0
    //   1050: iload_2
    //   1051: iconst_0
    //   1052: iconst_0
    //   1053: iload_2
    //   1054: iload 5
    //   1056: invokevirtual 664	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1059: aload 8
    //   1061: astore_1
    //   1062: aload 8
    //   1064: astore 9
    //   1066: iload_3
    //   1067: istore 4
    //   1069: aload 12
    //   1071: invokevirtual 667	android/graphics/Bitmap:recycle	()V
    //   1074: aload 8
    //   1076: astore_1
    //   1077: aload 8
    //   1079: astore 9
    //   1081: iload_3
    //   1082: istore 4
    //   1084: iload_2
    //   1085: iload 5
    //   1087: imul
    //   1088: newarray byte
    //   1090: astore 12
    //   1092: aload 8
    //   1094: astore_1
    //   1095: aload 8
    //   1097: astore 9
    //   1099: iload_3
    //   1100: istore 4
    //   1102: aload 10
    //   1104: aload 12
    //   1106: iload_2
    //   1107: iload 5
    //   1109: invokestatic 672	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   1112: pop
    //   1113: aload 8
    //   1115: astore_1
    //   1116: aload 8
    //   1118: astore 9
    //   1120: iload_3
    //   1121: istore 4
    //   1123: aload 12
    //   1125: iload_2
    //   1126: iload 5
    //   1128: iconst_0
    //   1129: invokestatic 675	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   1132: istore_2
    //   1133: iload_2
    //   1134: istore_3
    //   1135: aload 8
    //   1137: ifnull +10 -> 1147
    //   1140: aload 8
    //   1142: invokevirtual 631	java/io/InputStream:close	()V
    //   1145: iload_2
    //   1146: istore_3
    //   1147: invokestatic 693	com/tencent/qbar/QbarNativeImpl:a	()I
    //   1150: pop
    //   1151: iload_3
    //   1152: iconst_1
    //   1153: if_icmpne +632 -> 1785
    //   1156: aload_0
    //   1157: aload 11
    //   1159: invokevirtual 696	android/net/Uri:getPath	()Ljava/lang/String;
    //   1162: putfield 697	com/tencent/mobileqq/activity/aio/photo/AIOGalleryScene:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1165: iconst_1
    //   1166: invokestatic 523	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1169: areturn
    //   1170: astore_1
    //   1171: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +13 -> 1187
    //   1177: ldc 185
    //   1179: iconst_2
    //   1180: aload_1
    //   1181: invokevirtual 698	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   1184: invokestatic 700	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1187: iconst_0
    //   1188: invokestatic 523	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1191: areturn
    //   1192: aload_1
    //   1193: astore 8
    //   1195: aload_1
    //   1196: astore 9
    //   1198: aload 12
    //   1200: iconst_1
    //   1201: putfield 652	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1204: goto -951 -> 253
    //   1207: astore 10
    //   1209: iconst_m1
    //   1210: istore_2
    //   1211: aload 8
    //   1213: astore_1
    //   1214: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1217: ifeq +17 -> 1234
    //   1220: aload 8
    //   1222: astore_1
    //   1223: ldc 185
    //   1225: iconst_2
    //   1226: ldc_w 258
    //   1229: aload 10
    //   1231: invokestatic 703	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1234: iload_2
    //   1235: istore_3
    //   1236: aload 8
    //   1238: ifnull -91 -> 1147
    //   1241: aload 8
    //   1243: invokevirtual 631	java/io/InputStream:close	()V
    //   1246: iload_2
    //   1247: istore_3
    //   1248: goto -101 -> 1147
    //   1251: astore_1
    //   1252: iload_2
    //   1253: istore_3
    //   1254: goto -107 -> 1147
    //   1257: astore 8
    //   1259: aload_1
    //   1260: ifnull +13 -> 1273
    //   1263: aload_1
    //   1264: astore 8
    //   1266: aload_1
    //   1267: astore 9
    //   1269: aload_1
    //   1270: invokevirtual 631	java/io/InputStream:close	()V
    //   1273: aload_1
    //   1274: astore 8
    //   1276: goto -813 -> 463
    //   1279: astore 9
    //   1281: aload 8
    //   1283: astore_1
    //   1284: aload 9
    //   1286: astore 8
    //   1288: aload_1
    //   1289: astore 9
    //   1291: aload 8
    //   1293: invokevirtual 706	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1296: aload_1
    //   1297: astore 9
    //   1299: aload_1
    //   1300: invokevirtual 631	java/io/InputStream:close	()V
    //   1303: iload_2
    //   1304: istore_3
    //   1305: goto -486 -> 819
    //   1308: aload 8
    //   1310: astore_1
    //   1311: iload_2
    //   1312: istore_3
    //   1313: iload 6
    //   1315: iload 7
    //   1317: iconst_2
    //   1318: imul
    //   1319: if_icmplt -500 -> 819
    //   1322: aload 8
    //   1324: astore_1
    //   1325: iload_2
    //   1326: istore_3
    //   1327: iload 7
    //   1329: sipush 1024
    //   1332: if_icmpge -513 -> 819
    //   1335: aload 8
    //   1337: astore 9
    //   1339: aload 8
    //   1341: astore 10
    //   1343: iload_2
    //   1344: istore 4
    //   1346: aload 13
    //   1348: aload 11
    //   1350: invokevirtual 620	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1353: astore_1
    //   1354: aload_1
    //   1355: astore 8
    //   1357: aload 8
    //   1359: astore_1
    //   1360: aload 8
    //   1362: astore 9
    //   1364: iload_2
    //   1365: istore 4
    //   1367: iload_2
    //   1368: istore 5
    //   1370: aload 8
    //   1372: invokestatic 678	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1375: astore 10
    //   1377: aload 8
    //   1379: astore_1
    //   1380: aload 8
    //   1382: astore 9
    //   1384: iload_2
    //   1385: istore 4
    //   1387: iload_2
    //   1388: istore 5
    //   1390: invokestatic 681	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1393: ifeq +43 -> 1436
    //   1396: aload 8
    //   1398: astore_1
    //   1399: aload 8
    //   1401: astore 9
    //   1403: iload_2
    //   1404: istore 4
    //   1406: iload_2
    //   1407: istore 5
    //   1409: ldc 185
    //   1411: iconst_4
    //   1412: new 187	java/lang/StringBuilder
    //   1415: dup
    //   1416: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1419: ldc_w 708
    //   1422: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: aload 10
    //   1427: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1436: aload 8
    //   1438: astore_1
    //   1439: aload 8
    //   1441: astore 9
    //   1443: iload_2
    //   1444: istore 4
    //   1446: iload_2
    //   1447: istore 5
    //   1449: aload 8
    //   1451: invokevirtual 631	java/io/InputStream:close	()V
    //   1454: aload 8
    //   1456: astore_1
    //   1457: aload 8
    //   1459: astore 9
    //   1461: iload_2
    //   1462: istore 4
    //   1464: iload_2
    //   1465: istore 5
    //   1467: iload 7
    //   1469: iload 7
    //   1471: imul
    //   1472: newarray int
    //   1474: astore 14
    //   1476: aload 8
    //   1478: astore_1
    //   1479: aload 8
    //   1481: astore 9
    //   1483: iload_2
    //   1484: istore 4
    //   1486: iload_2
    //   1487: istore 5
    //   1489: aload 10
    //   1491: aload 14
    //   1493: iconst_0
    //   1494: iload 7
    //   1496: iconst_0
    //   1497: iconst_0
    //   1498: iload 7
    //   1500: iload 7
    //   1502: invokevirtual 664	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1505: aload 8
    //   1507: astore_1
    //   1508: aload 8
    //   1510: astore 9
    //   1512: iload_2
    //   1513: istore 4
    //   1515: iload_2
    //   1516: istore 5
    //   1518: iload 7
    //   1520: iload 7
    //   1522: imul
    //   1523: newarray byte
    //   1525: astore 15
    //   1527: aload 8
    //   1529: astore_1
    //   1530: aload 8
    //   1532: astore 9
    //   1534: iload_2
    //   1535: istore 4
    //   1537: iload_2
    //   1538: istore 5
    //   1540: aload 14
    //   1542: aload 15
    //   1544: iload 7
    //   1546: iload 7
    //   1548: invokestatic 672	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   1551: pop
    //   1552: aload 8
    //   1554: astore_1
    //   1555: aload 8
    //   1557: astore 9
    //   1559: iload_2
    //   1560: istore 4
    //   1562: iload_2
    //   1563: istore 5
    //   1565: aload 15
    //   1567: iload 7
    //   1569: iload 7
    //   1571: iconst_0
    //   1572: invokestatic 675	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   1575: istore_2
    //   1576: iload_2
    //   1577: istore_3
    //   1578: iload_2
    //   1579: iconst_1
    //   1580: if_icmpeq +85 -> 1665
    //   1583: aload 8
    //   1585: astore_1
    //   1586: aload 8
    //   1588: astore 9
    //   1590: iload_2
    //   1591: istore 4
    //   1593: iload_2
    //   1594: istore 5
    //   1596: aload 10
    //   1598: aload 14
    //   1600: iconst_0
    //   1601: iload 7
    //   1603: iload 6
    //   1605: iload 7
    //   1607: isub
    //   1608: iconst_0
    //   1609: iload 7
    //   1611: iload 7
    //   1613: invokevirtual 664	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1616: aload 8
    //   1618: astore_1
    //   1619: aload 8
    //   1621: astore 9
    //   1623: iload_2
    //   1624: istore 4
    //   1626: iload_2
    //   1627: istore 5
    //   1629: aload 14
    //   1631: aload 15
    //   1633: iload 7
    //   1635: iload 7
    //   1637: invokestatic 672	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   1640: pop
    //   1641: aload 8
    //   1643: astore_1
    //   1644: aload 8
    //   1646: astore 9
    //   1648: iload_2
    //   1649: istore 4
    //   1651: iload_2
    //   1652: istore 5
    //   1654: aload 15
    //   1656: iload 7
    //   1658: iload 7
    //   1660: iconst_0
    //   1661: invokestatic 675	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   1664: istore_3
    //   1665: aload 8
    //   1667: astore_1
    //   1668: aload 8
    //   1670: astore 9
    //   1672: iload_3
    //   1673: istore 4
    //   1675: iload_3
    //   1676: istore 5
    //   1678: aload 10
    //   1680: invokevirtual 667	android/graphics/Bitmap:recycle	()V
    //   1683: aload 8
    //   1685: astore_1
    //   1686: goto -867 -> 819
    //   1689: astore 9
    //   1691: aload 8
    //   1693: astore_1
    //   1694: aload 9
    //   1696: astore 8
    //   1698: aload_1
    //   1699: astore 9
    //   1701: aload_1
    //   1702: astore 10
    //   1704: iload_2
    //   1705: istore 4
    //   1707: aload 8
    //   1709: invokevirtual 706	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1712: aload_1
    //   1713: astore 9
    //   1715: aload_1
    //   1716: astore 10
    //   1718: iload_2
    //   1719: istore 4
    //   1721: aload_1
    //   1722: invokevirtual 631	java/io/InputStream:close	()V
    //   1725: iload_2
    //   1726: istore_3
    //   1727: goto -908 -> 819
    //   1730: aload_1
    //   1731: astore 9
    //   1733: aload_1
    //   1734: astore 10
    //   1736: iload_3
    //   1737: istore 4
    //   1739: aload 8
    //   1741: invokevirtual 706	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1744: aload_1
    //   1745: astore 9
    //   1747: aload_1
    //   1748: astore 10
    //   1750: iload_3
    //   1751: istore 4
    //   1753: aload_1
    //   1754: invokevirtual 631	java/io/InputStream:close	()V
    //   1757: aload_1
    //   1758: astore 8
    //   1760: iload_3
    //   1761: istore_2
    //   1762: goto -629 -> 1133
    //   1765: astore 9
    //   1767: aload_1
    //   1768: astore 8
    //   1770: aload 9
    //   1772: astore_1
    //   1773: aload 8
    //   1775: ifnull +8 -> 1783
    //   1778: aload 8
    //   1780: invokevirtual 631	java/io/InputStream:close	()V
    //   1783: aload_1
    //   1784: athrow
    //   1785: iconst_0
    //   1786: invokestatic 523	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1789: areturn
    //   1790: astore_1
    //   1791: iload_2
    //   1792: istore_3
    //   1793: goto -646 -> 1147
    //   1796: astore 8
    //   1798: goto -15 -> 1783
    //   1801: astore_1
    //   1802: aload 9
    //   1804: astore 8
    //   1806: goto -33 -> 1773
    //   1809: astore_1
    //   1810: aload 9
    //   1812: astore 8
    //   1814: goto -41 -> 1773
    //   1817: astore 10
    //   1819: iload 4
    //   1821: istore_2
    //   1822: aload 9
    //   1824: astore 8
    //   1826: goto -615 -> 1211
    //   1829: astore 10
    //   1831: goto -620 -> 1211
    //   1834: astore 10
    //   1836: aload_1
    //   1837: astore 8
    //   1839: goto -628 -> 1211
    //   1842: astore 9
    //   1844: aload 8
    //   1846: astore_1
    //   1847: aload 9
    //   1849: astore 8
    //   1851: goto -121 -> 1730
    //   1854: astore 9
    //   1856: aload 8
    //   1858: astore_1
    //   1859: aload 9
    //   1861: astore 8
    //   1863: iload 5
    //   1865: istore_2
    //   1866: goto -168 -> 1698
    //   1869: astore 9
    //   1871: aload 8
    //   1873: astore_1
    //   1874: iload_3
    //   1875: istore_2
    //   1876: aload 9
    //   1878: astore 8
    //   1880: goto -592 -> 1288
    //   1883: astore 9
    //   1885: aload 8
    //   1887: astore_1
    //   1888: aload 9
    //   1890: astore 8
    //   1892: goto -604 -> 1288
    //   1895: astore_1
    //   1896: aload 8
    //   1898: astore_1
    //   1899: goto -640 -> 1259
    //   1902: goto -1096 -> 806
    //   1905: astore_1
    //   1906: aload 10
    //   1908: astore 8
    //   1910: aload_1
    //   1911: astore 10
    //   1913: iload 4
    //   1915: istore_2
    //   1916: goto -705 -> 1211
    //   1919: astore 8
    //   1921: goto -191 -> 1730
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1924	0	this	AIOGalleryScene
    //   0	1924	1	paramFile	File
    //   65	1851	2	i1	int
    //   327	1548	3	i2	int
    //   80	1834	4	i3	int
    //   343	1521	5	i4	int
    //   187	1421	6	i5	int
    //   200	1459	7	i6	int
    //   15	1227	8	localObject1	Object
    //   1257	1	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1264	515	8	localObject2	Object
    //   1796	1	8	localIOException	java.io.IOException
    //   1804	105	8	localObject3	Object
    //   1919	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   77	1191	9	localObject4	Object
    //   1279	6	9	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1289	382	9	localObject5	Object
    //   1689	6	9	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1699	47	9	localFile1	File
    //   1765	58	9	localObject6	Object
    //   1842	6	9	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1854	6	9	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   1869	8	9	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   1883	6	9	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   67	1036	10	localObject7	Object
    //   1207	23	10	localException1	Exception
    //   1341	408	10	localObject8	Object
    //   1817	1	10	localException2	Exception
    //   1829	1	10	localException3	Exception
    //   1834	73	10	localException4	Exception
    //   1911	1	10	localFile2	File
    //   62	1287	11	localUri	android.net.Uri
    //   108	1091	12	localObject9	Object
    //   89	1258	13	localContentResolver	android.content.ContentResolver
    //   290	1340	14	localObject10	Object
    //   673	982	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	17	1170	java/lang/UnsatisfiedLinkError
    //   27	36	1170	java/lang/UnsatisfiedLinkError
    //   154	162	1207	java/lang/Exception
    //   172	176	1207	java/lang/Exception
    //   182	189	1207	java/lang/Exception
    //   195	202	1207	java/lang/Exception
    //   208	214	1207	java/lang/Exception
    //   231	253	1207	java/lang/Exception
    //   259	268	1207	java/lang/Exception
    //   1198	1204	1207	java/lang/Exception
    //   1269	1273	1207	java/lang/Exception
    //   1241	1246	1251	java/io/IOException
    //   259	268	1257	java/lang/OutOfMemoryError
    //   501	509	1279	java/lang/OutOfMemoryError
    //   1346	1354	1689	java/lang/OutOfMemoryError
    //   82	91	1765	finally
    //   101	110	1765	finally
    //   120	126	1765	finally
    //   136	145	1765	finally
    //   282	292	1765	finally
    //   307	312	1765	finally
    //   322	328	1765	finally
    //   338	345	1765	finally
    //   355	363	1765	finally
    //   373	387	1765	finally
    //   397	402	1765	finally
    //   412	420	1765	finally
    //   430	441	1765	finally
    //   451	461	1765	finally
    //   524	531	1765	finally
    //   543	549	1765	finally
    //   561	588	1765	finally
    //   600	605	1765	finally
    //   617	626	1765	finally
    //   638	654	1765	finally
    //   666	675	1765	finally
    //   687	699	1765	finally
    //   711	722	1765	finally
    //   739	759	1765	finally
    //   771	783	1765	finally
    //   795	806	1765	finally
    //   809	814	1765	finally
    //   906	916	1765	finally
    //   926	932	1765	finally
    //   942	969	1765	finally
    //   979	984	1765	finally
    //   994	1000	1765	finally
    //   1010	1017	1765	finally
    //   1027	1035	1765	finally
    //   1045	1059	1765	finally
    //   1069	1074	1765	finally
    //   1084	1092	1765	finally
    //   1102	1113	1765	finally
    //   1123	1133	1765	finally
    //   1214	1220	1765	finally
    //   1223	1234	1765	finally
    //   1370	1377	1765	finally
    //   1390	1396	1765	finally
    //   1409	1436	1765	finally
    //   1449	1454	1765	finally
    //   1467	1476	1765	finally
    //   1489	1505	1765	finally
    //   1518	1527	1765	finally
    //   1540	1552	1765	finally
    //   1565	1576	1765	finally
    //   1596	1616	1765	finally
    //   1629	1641	1765	finally
    //   1654	1665	1765	finally
    //   1678	1683	1765	finally
    //   1140	1145	1790	java/io/IOException
    //   1778	1783	1796	java/io/IOException
    //   154	162	1801	finally
    //   172	176	1801	finally
    //   182	189	1801	finally
    //   195	202	1801	finally
    //   208	214	1801	finally
    //   231	253	1801	finally
    //   259	268	1801	finally
    //   1198	1204	1801	finally
    //   1269	1273	1801	finally
    //   501	509	1809	finally
    //   836	844	1809	finally
    //   863	878	1809	finally
    //   887	896	1809	finally
    //   1291	1296	1809	finally
    //   1299	1303	1809	finally
    //   1346	1354	1809	finally
    //   1707	1712	1809	finally
    //   1721	1725	1809	finally
    //   1739	1744	1809	finally
    //   1753	1757	1809	finally
    //   82	91	1817	java/lang/Exception
    //   101	110	1817	java/lang/Exception
    //   120	126	1817	java/lang/Exception
    //   136	145	1817	java/lang/Exception
    //   282	292	1817	java/lang/Exception
    //   307	312	1817	java/lang/Exception
    //   322	328	1817	java/lang/Exception
    //   338	345	1817	java/lang/Exception
    //   355	363	1817	java/lang/Exception
    //   373	387	1817	java/lang/Exception
    //   397	402	1817	java/lang/Exception
    //   412	420	1817	java/lang/Exception
    //   430	441	1817	java/lang/Exception
    //   451	461	1817	java/lang/Exception
    //   524	531	1817	java/lang/Exception
    //   543	549	1817	java/lang/Exception
    //   561	588	1817	java/lang/Exception
    //   600	605	1817	java/lang/Exception
    //   617	626	1817	java/lang/Exception
    //   638	654	1817	java/lang/Exception
    //   666	675	1817	java/lang/Exception
    //   687	699	1817	java/lang/Exception
    //   711	722	1817	java/lang/Exception
    //   739	759	1817	java/lang/Exception
    //   771	783	1817	java/lang/Exception
    //   795	806	1817	java/lang/Exception
    //   906	916	1817	java/lang/Exception
    //   926	932	1817	java/lang/Exception
    //   942	969	1817	java/lang/Exception
    //   979	984	1817	java/lang/Exception
    //   994	1000	1817	java/lang/Exception
    //   1010	1017	1817	java/lang/Exception
    //   1027	1035	1817	java/lang/Exception
    //   1045	1059	1817	java/lang/Exception
    //   1069	1074	1817	java/lang/Exception
    //   1084	1092	1817	java/lang/Exception
    //   1102	1113	1817	java/lang/Exception
    //   1123	1133	1817	java/lang/Exception
    //   1370	1377	1817	java/lang/Exception
    //   1390	1396	1817	java/lang/Exception
    //   1409	1436	1817	java/lang/Exception
    //   1449	1454	1817	java/lang/Exception
    //   1467	1476	1817	java/lang/Exception
    //   1489	1505	1817	java/lang/Exception
    //   1518	1527	1817	java/lang/Exception
    //   1540	1552	1817	java/lang/Exception
    //   1565	1576	1817	java/lang/Exception
    //   1596	1616	1817	java/lang/Exception
    //   1629	1641	1817	java/lang/Exception
    //   1654	1665	1817	java/lang/Exception
    //   1678	1683	1817	java/lang/Exception
    //   809	814	1829	java/lang/Exception
    //   1291	1296	1834	java/lang/Exception
    //   1299	1303	1834	java/lang/Exception
    //   906	916	1842	java/lang/OutOfMemoryError
    //   926	932	1842	java/lang/OutOfMemoryError
    //   942	969	1842	java/lang/OutOfMemoryError
    //   979	984	1842	java/lang/OutOfMemoryError
    //   994	1000	1842	java/lang/OutOfMemoryError
    //   1010	1017	1842	java/lang/OutOfMemoryError
    //   1027	1035	1842	java/lang/OutOfMemoryError
    //   1045	1059	1842	java/lang/OutOfMemoryError
    //   1069	1074	1842	java/lang/OutOfMemoryError
    //   1084	1092	1842	java/lang/OutOfMemoryError
    //   1102	1113	1842	java/lang/OutOfMemoryError
    //   1123	1133	1842	java/lang/OutOfMemoryError
    //   1370	1377	1854	java/lang/OutOfMemoryError
    //   1390	1396	1854	java/lang/OutOfMemoryError
    //   1409	1436	1854	java/lang/OutOfMemoryError
    //   1449	1454	1854	java/lang/OutOfMemoryError
    //   1467	1476	1854	java/lang/OutOfMemoryError
    //   1489	1505	1854	java/lang/OutOfMemoryError
    //   1518	1527	1854	java/lang/OutOfMemoryError
    //   1540	1552	1854	java/lang/OutOfMemoryError
    //   1565	1576	1854	java/lang/OutOfMemoryError
    //   1596	1616	1854	java/lang/OutOfMemoryError
    //   1629	1641	1854	java/lang/OutOfMemoryError
    //   1654	1665	1854	java/lang/OutOfMemoryError
    //   1678	1683	1854	java/lang/OutOfMemoryError
    //   524	531	1869	java/lang/OutOfMemoryError
    //   543	549	1869	java/lang/OutOfMemoryError
    //   561	588	1869	java/lang/OutOfMemoryError
    //   600	605	1869	java/lang/OutOfMemoryError
    //   617	626	1869	java/lang/OutOfMemoryError
    //   638	654	1869	java/lang/OutOfMemoryError
    //   666	675	1869	java/lang/OutOfMemoryError
    //   687	699	1869	java/lang/OutOfMemoryError
    //   711	722	1869	java/lang/OutOfMemoryError
    //   739	759	1869	java/lang/OutOfMemoryError
    //   771	783	1869	java/lang/OutOfMemoryError
    //   795	806	1869	java/lang/OutOfMemoryError
    //   809	814	1883	java/lang/OutOfMemoryError
    //   282	292	1895	java/lang/OutOfMemoryError
    //   307	312	1895	java/lang/OutOfMemoryError
    //   322	328	1895	java/lang/OutOfMemoryError
    //   338	345	1895	java/lang/OutOfMemoryError
    //   355	363	1895	java/lang/OutOfMemoryError
    //   373	387	1895	java/lang/OutOfMemoryError
    //   397	402	1895	java/lang/OutOfMemoryError
    //   412	420	1895	java/lang/OutOfMemoryError
    //   430	441	1895	java/lang/OutOfMemoryError
    //   451	461	1895	java/lang/OutOfMemoryError
    //   501	509	1905	java/lang/Exception
    //   836	844	1905	java/lang/Exception
    //   863	878	1905	java/lang/Exception
    //   887	896	1905	java/lang/Exception
    //   1346	1354	1905	java/lang/Exception
    //   1707	1712	1905	java/lang/Exception
    //   1721	1725	1905	java/lang/Exception
    //   1739	1744	1905	java/lang/Exception
    //   1753	1757	1905	java/lang/Exception
    //   887	896	1919	java/lang/OutOfMemoryError
  }
  
  public void a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    Object localObject = (AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE");
    if ((localObject instanceof AIOShortVideoData))
    {
      int i1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
      if (i1 != -1) {
        ((AIOShortVideoData)localObject).h = i1;
      }
    }
    localObject = new AIORichMediaInfo((AIORichMediaData)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a((AIORichMediaInfo)localObject);
    ((AIORichMediaInfo)localObject).jdField_b_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.q = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.jdField_c_of_type_Int = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
    this.jdField_e_of_type_Int = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
    this.p = localBundle.getBoolean("extra.IS_HOT_CHAT", false);
    this.jdField_j_of_type_Boolean = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_d_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
      this.jdField_e_of_type_JavaLangString = localBundle.getString("extra.GROUP_CODE");
      this.jdField_a_of_type_Long = localBundle.getLong("extra.MESSAGE_SEQ");
      this.jdField_f_of_type_JavaLangString = localBundle.getString("extra.SENDER_UIN");
      if (((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null)) && (QLog.isColorLevel())) {
        QLog.i("AIOGalleryScene", 2, "mGroupUin=" + this.jdField_d_of_type_JavaLangString + ", mGroupCode=" + this.jdField_e_of_type_JavaLangString + ", mMyUin=" + this.jdField_b_of_type_JavaLangString);
      }
    }
    this.jdField_f_of_type_Int = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_e_of_type_Boolean = localBundle.getBoolean("extra.IS_APOLLO");
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
    this.jdField_d_of_type_Boolean = localBundle.getBoolean("extra.IS_RECEIPT_MSG");
    this.jdField_g_of_type_Int = localBundle.getInt("forward_source_uin_type", -1);
    this.jdField_c_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_k_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", false);
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(true);
      this.jdField_l_of_type_Boolean = true;
      if (!TextUtils.isEmpty(localBundle.getString("babyq_video_type"))) {
        break label479;
      }
    }
    label479:
    for (boolean bool = false;; bool = true)
    {
      this.n = bool;
      this.jdField_g_of_type_Boolean = localBundle.getBoolean("extra.OCR", false);
      this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.OCR_TEXT");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131435912);
      }
      this.jdField_i_of_type_Boolean = localBundle.getBoolean("group.emo.big.preview", false);
      return;
      ((AIORichMediaInfo)localObject).jdField_c_of_type_Boolean = false;
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0)) {
      a(paramIntent.getExtras());
    }
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 == 10001))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131437380, 0).a();
        return;
      }
    } while ((paramInt1 != 10002) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager == null));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.a(paramInt2);
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      paramInt2 = 0;
      if (paramInt2 < ((List)localObject1).size())
      {
        localObject2 = (AIORichMediaInfo)((List)localObject1).get(paramInt2);
        if ((((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g != paramLong1) || (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramInt1)) {
          break label156;
        }
        ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int = paramInt3;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramInt3 / 100);
        if (paramBoolean)
        {
          paramInt1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt2 >= paramInt1) && (paramInt2 <= paramInt3 + paramInt1 - 1))
          {
            localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - paramInt1);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt2, (View)localObject1, paramBoolean);
          }
        }
      }
    }
    label156:
    label589:
    label591:
    do
    {
      for (;;)
      {
        return;
        paramInt2 += 1;
        break;
        if (paramInt2 == 4)
        {
          if ((this.jdField_a_of_type_Vss != null) && (this.jdField_a_of_type_Vss.jdField_a_of_type_Long == paramLong1) && (this.jdField_a_of_type_Vss.jdField_a_of_type_Int == paramInt1) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
          {
            if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
            {
              this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
            if (paramLong2 > 0L)
            {
              localObject1 = FileUtil.a(paramLong2);
              localObject2 = FileUtil.a(((float)(paramInt3 * paramLong2) / 10000.0F));
              localObject1 = (String)localObject2 + "/" + (String)localObject1;
              this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
              return;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt3 / 100 + "%");
          }
        }
        else if (paramInt2 == 1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
          paramInt1 = 0;
          while (paramInt1 < ((List)localObject1).size())
          {
            localObject2 = (AIORichMediaInfo)((List)localObject1).get(paramInt1);
            if (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == paramLong1)
            {
              ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int = paramInt3;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramInt3 / 100);
              return;
            }
            paramInt1 += 1;
          }
        }
        else
        {
          if (paramInt2 != 18) {
            break label591;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= ((List)localObject1).size()) {
              break label589;
            }
            localObject2 = (AIORichMediaInfo)((List)localObject1).get(paramInt1);
            if (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == paramLong1)
            {
              ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int = paramInt3;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramInt3 / 100);
              if (!paramBoolean) {
                break;
              }
              paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
              paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
              if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1)) {
                break;
              }
              localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1, (View)localObject1, paramBoolean);
              return;
            }
            paramInt1 += 1;
          }
        }
      }
    } while ((paramInt2 != 20) || (this.jdField_a_of_type_Vss == null) || (this.jdField_a_of_type_Vss.jdField_a_of_type_Long != paramLong1) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
    if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a((float)paramLong2, paramInt3));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    int i1;
    if (paramInt2 == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
      if (paramInt3 == 1)
      {
        paramInt2 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
        i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
        int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        if ((paramInt2 >= i1) && (paramInt2 <= i2 + i1 - 1))
        {
          paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - i1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramString, paramBoolean);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt2);
        }
        paramInt2 = 0;
        label132:
        if (paramInt2 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a()) {
          break label308;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt2);
        if (paramString != null) {
          break label177;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label132;
        paramString = "I:E";
        break;
        label177:
        if ((paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == paramLong) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramInt1) && (paramInt3 == 1) && (AIOImageData.class.isInstance(paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
        {
          paramString = (AIOImageData)paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if ((!paramString.jdField_g_of_type_Boolean) && (new File(paramString.jdField_a_of_type_JavaLangString + "_hd").exists())) {
            paramString.jdField_a_of_type_JavaLangString += "_hd";
          }
        }
      }
      label308:
      z();
      A();
    }
    do
    {
      return;
      if ((paramInt2 == 4) && (this.jdField_a_of_type_Vss != null) && (this.jdField_a_of_type_Vss.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_Vss.jdField_a_of_type_Int == paramInt1))
      {
        localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 == 1)
        {
          localObject = paramString;
          localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
          if (paramInt3 == 1)
          {
            paramString = URLDrawable.URLDrawableOptions.obtain();
            paramString.mPlayGifImage = true;
            paramString.mUseExifOrientation = false;
          }
        }
        else
        {
          for (;;)
          {
            try
            {
              paramString = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), paramString);
              if (paramString == null) {
                break;
              }
              switch (paramString.getStatus())
              {
              default: 
                paramString.setTag(Integer.valueOf(1));
                paramString.setURLDrawableListener(this.jdField_a_of_type_Vss);
                paramString.startDownload();
                this.jdField_a_of_type_Vss.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
                return;
                localObject = "I:E";
              }
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              paramString = null;
              continue;
              this.jdField_a_of_type_Vss.onLoadSuccessed(paramString);
              return;
            }
            this.jdField_a_of_type_Vss.onLoadFialed(paramString, null);
            return;
            this.jdField_a_of_type_Vss.onLoadCanceled(paramString);
          }
        }
        if (!"TroopFileError".equals(paramString)) {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131436137), 0).a();
        }
        c(true);
        a(false);
        this.jdField_a_of_type_Vss = null;
        return;
      }
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 == 1) {}
        for (;;)
        {
          paramInt1 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
          {
            paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
          return;
          paramString = "I:E";
        }
      }
      if (paramInt2 == 18)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 == 1) {}
        for (;;)
        {
          paramInt1 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1))
          {
            paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
            if (paramInt3 == 2)
            {
              a(false);
              c(true);
              this.jdField_a_of_type_Vss = null;
            }
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
          return;
          paramString = "I:E";
        }
      }
    } while ((paramInt2 != 20) || (this.jdField_a_of_type_Vss == null) || (this.jdField_a_of_type_Vss.jdField_a_of_type_Long != paramLong));
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 == 1) {}
    for (Object localObject = paramString;; localObject = "I:E")
    {
      localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
      QLog.d("AIOGalleryScene", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
      if (paramInt3 != 1) {
        break label1158;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mPlayGifImage = true;
      paramString.mUseExifOrientation = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      QLog.e("AIOGalleryScene", 1, "null url");
      return;
    }
    paramString = URLDrawable.getDrawable((String)localObject, paramString);
    switch (paramString.getStatus())
    {
    }
    for (;;)
    {
      paramString.setTag(Integer.valueOf(1));
      paramString.setURLDrawableListener(this.jdField_a_of_type_Vss);
      paramString.startDownload();
      this.jdField_a_of_type_Vss.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
      return;
      this.jdField_a_of_type_Vss.onLoadSuccessed(paramString);
      return;
      this.jdField_a_of_type_Vss.onLoadFialed(paramString, null);
      return;
      this.jdField_a_of_type_Vss.onLoadCanceled(paramString);
    }
    label1158:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.jdField_a_of_type_AndroidAppActivity.getString(2131428188).equals(paramString)) {
        break label1217;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 0).a();
    }
    for (;;)
    {
      a(false);
      c(true);
      this.jdField_a_of_type_Vss = null;
      return;
      label1217:
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131436137), 0).a();
    }
  }
  
  @TargetApi(14)
  public void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramActivity);
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130970912);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363010);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a(paramActivity);
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366640)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new vrz(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new vsa(this), paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    paramIntent.putExtra("filepictest", true);
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    String str1 = paramIntent.getStringExtra("forward_filepath");
    boolean bool1 = paramIntent.getBooleanExtra("k_favorites", false);
    String str2 = paramIntent.getStringExtra("forward_text");
    boolean bool2 = paramIntent.getBooleanExtra("isFromShare", false);
    int i1 = paramIntent.getIntExtra("forward_type", 0);
    paramIntent = new Intent();
    paramIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", i1);
    localBundle.putParcelable("fileinfo", localForwardFileInfo);
    localBundle.putBoolean("not_forward", true);
    paramIntent.putExtras(localBundle);
    paramIntent.putExtra("forward_filepath", str1);
    paramIntent.putExtra("forward_text", str2);
    paramIntent.putExtra("k_favorites", bool1);
    paramIntent.putExtra("isFromShare", bool2);
    paramIntent.putExtra("isPic", true);
    paramIntent.putExtra("direct_send_if_dataline_forward", true);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent, 103);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramConfiguration);
  }
  
  void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    paramBundle = new Bundle(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    String str = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    int i1 = paramBundle.getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    if (this.jdField_g_of_type_Int == 9501)
    {
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, localArrayList, i1, true);
  }
  
  public void a(Bundle paramBundle, int paramInt, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {}
    int i1;
    String str1;
    String str2;
    long l1;
    String str3;
    int i2;
    do
    {
      return;
      if (paramBundle == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      i1 = paramBundle.getInt("istroop");
      str1 = paramBundle.getString("groupuin");
      str2 = paramBundle.getString("senderUin");
      l1 = paramBundle.getLong("shmsgseq");
      str3 = paramBundle.getString("uuid");
      i2 = paramBundle.getInt("replyCount");
    } while ((!Utils.a(str1, paramString1)) || (!Utils.a(str2, paramString2)) || (i1 != paramInt) || (l1 != paramLong) || (!Utils.a(str3, paramString3)));
    if (i2 > 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(i2));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    if (paramView == null) {}
    label29:
    do
    {
      return;
      if (!AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView)) {
        break;
      }
      paramView = (URLDrawable)((AIOGalleryAdapter.GalleryImageStruct)paramView).a();
    } while (paramView.getStatus() != 1);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
      if (localAIORichMediaInfo != null) {
        localAIORichMediaInfo.jdField_b_of_type_Int = i1;
      }
      paramView = new File(paramView.getURL().getFile());
      if (!paramView.exists()) {
        break;
      }
      new vsg(this, paramView, paramInt2).execute(new Void[0]);
      return;
      paramView = (URLDrawable)((ImageView)paramView).getDrawable();
      break label29;
      i1 = 3;
      continue;
      i1 = 8;
      continue;
      i1 = 6;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager = RedBagVideoManager.a(((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).a);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager != null) {
      this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    paramViewGroup = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, paramViewGroup));
    int i1 = (int)TypedValue.applyDimension(1, 5.0F, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131362273);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131494031));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131493242));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131436129);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131436129));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841246));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription("查看聊天图片/视频");
    this.jdField_d_of_type_AndroidWidgetImageButton.setId(2131362281);
    this.jdField_d_of_type_AndroidWidgetImageButton.setImageResource(2130837597);
    this.jdField_d_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)TypedValue.applyDimension(1, 25.0F, paramViewGroup));
    if ((f()) && (!(this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)))
    {
      i1 = 1;
      if (i1 != 0) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageButton, (ViewGroup.LayoutParams)localObject);
      }
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_c_of_type_AndroidWidgetImageButton.setContentDescription("更多操作");
      this.jdField_c_of_type_AndroidWidgetImageButton.setId(2131362274);
      this.jdField_c_of_type_AndroidWidgetImageButton.setImageResource(2130837595);
      this.jdField_c_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
      this.jdField_c_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)TypedValue.applyDimension(1, 24.0F, paramViewGroup));
      if (!((AIORichMediaData)this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageButton, (ViewGroup.LayoutParams)localObject);
      }
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "editPhotoBtn mContext.getIntent().getBooleanExtra: " + this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false));
      }
      if ((this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false)) && (MsgProxyUtils.a(this.jdField_g_of_type_Int) != 1032))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription("进入图片编辑");
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837590);
        this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetImageButton.setId(2131362276);
        this.jdField_a_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        if (i1 == 0) {
          break label1289;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131362274);
      }
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)TypedValue.applyDimension(1, 20.0F, paramViewGroup));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageButton, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      localObject = LightReplyMenuManager.a();
      boolean bool = this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.show_light_reply", false);
      if ((this.jdField_g_of_type_Int == 1) && (bool) && (!this.p) && (localObject != null) && (((LightReplyMenuManager)localObject).e()))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription("回复图片");
        this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130841469);
        this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
        this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetImageButton.setId(2131361956);
        this.jdField_b_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131362276);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)TypedValue.applyDimension(1, 20.0F, paramViewGroup));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageButton, (ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnTouchListener(this);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
        paramViewGroup = new IntentFilter("light_reply_count_changed");
        this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup);
        this.jdField_h_of_type_Boolean = true;
      }
      paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130970541, null);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, paramViewGroup);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363010));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370997));
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((ProGallery.OnProGalleryListener.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
        ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
      }
      return;
      i1 = 0;
      break;
      label1289:
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    }
  }
  
  public void a(ViewGroup paramViewGroup, LightReplyEmojs paramLightReplyEmojs)
  {
    ImageExplodeLayout localImageExplodeLayout = new ImageExplodeLayout(this.jdField_a_of_type_AndroidAppActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_j_of_type_Int * 7.0F / 3.0F), (int)(this.jdField_j_of_type_Int * 4.0F / 3.0F));
    localLayoutParams.addRule(13);
    localImageExplodeLayout.setLayoutParams(localLayoutParams);
    paramViewGroup.addView(localImageExplodeLayout);
    if ((paramLightReplyEmojs != null) && (!TextUtils.isEmpty(paramLightReplyEmojs.bigUrl))) {
      localImageExplodeLayout.setDrawble(URLDrawableHelper.a(paramLightReplyEmojs.bigUrl, this.jdField_j_of_type_Int, this.jdField_j_of_type_Int, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable, true, 0.0F), this.jdField_j_of_type_Int, this.jdField_j_of_type_Int);
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  @UnCompletedCode
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramString, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(false);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {
      try
      {
        if (!AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          c(3);
        }
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
          }
        }
      }
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    return false;
  }
  
  boolean a(ActionSheet paramActionSheet, AIOFilePicData paramAIOFilePicData)
  {
    return false;
  }
  
  boolean a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData)
  {
    return false;
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    try
    {
      if (!AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        c(1);
      }
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
        }
      }
    }
  }
  
  public boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    return false;
  }
  
  public void b()
  {
    g();
    this.s = true;
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = true;
    }
    if (!g()) {
      this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    if ((this.jdField_d_of_type_AndroidWidgetImageButton != null) && (MsgProxyUtils.a(this.jdField_g_of_type_Int) != 1032)) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    z();
    A();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.b(paramAdapterView, paramView, paramInt, paramLong);
    if ((this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.b())) {
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a();
    }
    Object localObject;
    Drawable localDrawable;
    if (!this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a()) {
        u();
      }
    }
    else
    {
      c(false);
      this.jdField_a_of_type_ComTencentWidgetGallery.b(true);
      this.jdField_a_of_type_ComTencentWidgetGallery.a(true);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
      {
        localObject = (AIOGalleryAdapter.GalleryImageStruct)paramView;
        localDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
        if ((((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) || (localDrawable == null) || (!(localDrawable instanceof URLDrawable))) {
          break label615;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
        if (localObject != null)
        {
          a((AIORichMediaInfo)localObject);
          if ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4)) || (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20)))
          {
            if (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i <= 0L) {
              break label602;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131436130), new Object[] { FileUtil.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i) }));
            label220:
            c(true);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
              localObject = a().findViewById(2131370993);
              if (localObject != null)
              {
                if (((View)localObject).getAnimation() != null)
                {
                  ((View)localObject).getAnimation().cancel();
                  ((View)localObject).setAnimation(null);
                }
                ((View)localObject).setVisibility(4);
              }
            }
          }
        }
      }
    }
    label578:
    label600:
    label602:
    label858:
    for (;;)
    {
      z();
      A();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = a().findViewById(2131370993);
        if (paramAdapterView != null)
        {
          if (paramAdapterView.getAnimation() != null)
          {
            paramAdapterView.getAnimation().cancel();
            paramAdapterView.setAnimation(null);
          }
          paramAdapterView.setVisibility(4);
        }
      }
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
      if ((paramAdapterView != null) && ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)) && (((AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt, -1);
        ((AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean = false;
      }
      if ((paramAdapterView != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager != null))
      {
        if (!(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
          break label866;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.a((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      return;
      int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      int i1 = 0;
      if (this.jdField_l_of_type_Boolean) {
        if (i2 - paramInt > 0)
        {
          if (paramInt <= i2 - 25) {
            break label578;
          }
          i1 = 1;
        }
      }
      for (;;)
      {
        if ((i2 == 1) || (i1 == 0) || (this.jdField_a_of_type_Boolean) || (this.jdField_m_of_type_Int == i2)) {
          break label600;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "[onItemSelected] loadMedias: mLastLoadCount=" + this.jdField_m_of_type_Int);
        }
        this.jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(0);
        break;
        i1 = 0;
        continue;
        if (paramInt < 25) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131436129);
      break label220;
      label615:
      if ((!((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) && (localDrawable != null) && ((localDrawable instanceof SkinnableBitmapDrawable)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
        if ((localObject != null) && ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131436130), new Object[] { FileUtil.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i) }));
          if (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i <= FMConfig.c()) {
            break label850;
          }
          c(true);
          this.jdField_a_of_type_ComTencentWidgetGallery.b(false);
          this.jdField_a_of_type_ComTencentWidgetGallery.a(false);
        }
        for (;;)
        {
          if ((localObject == null) || (!(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) || (((AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int != 1)) {
            break label856;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131436130), new Object[] { FileUtil.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i) }));
          if (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i <= FMConfig.c()) {
            break label858;
          }
          c(true);
          this.jdField_a_of_type_ComTencentWidgetGallery.b(false);
          this.jdField_a_of_type_ComTencentWidgetGallery.a(false);
          break;
          c(true);
        }
        continue;
        c(true);
      }
    }
    label850:
    label856:
    label866:
    this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.a(null);
  }
  
  protected boolean b()
  {
    boolean bool = true;
    if (this.jdField_c_of_type_Int == 1) {
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    this.s = false;
    c(this.r);
    if (!h()) {
      this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    Object localObject3;
    Object localObject1;
    if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject3 = (AIOImageData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localObject1 = ((AIOImageData)localObject3).a(4);
      if (localObject1 != null) {
        break label981;
      }
      localObject1 = ((AIOImageData)localObject3).a(2);
    }
    label429:
    label981:
    for (;;)
    {
      if ((localObject1 == null) && (this.q)) {}
      do
      {
        do
        {
          do
          {
            return;
            ActionSheet localActionSheet = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
            if (localObject1 != null) {
              this.jdField_h_of_type_JavaLangString = ((File)localObject1).getPath();
            }
            if ((!a(localActionSheet, (AIOImageData)localObject3)) && (MsgProxyUtils.a(this.jdField_g_of_type_Int) != 1032))
            {
              if (localObject1 != null)
              {
                if (this.jdField_c_of_type_Boolean) {
                  break label429;
                }
                if (this.jdField_i_of_type_Boolean)
                {
                  localActionSheet.b(2131435886);
                  VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                }
                int i1 = 0;
                localActionSheet.b(2131435887);
                paramInt = i1;
                if (this.jdField_g_of_type_Boolean)
                {
                  paramInt = i1;
                  if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
                  {
                    paramInt = 1;
                    localActionSheet.c(this.jdField_a_of_type_JavaLangString);
                  }
                }
                if (((AIOImageData)localObject3).jdField_e_of_type_JavaLangString != null) {
                  localActionSheet.b(2131435897);
                }
                if ((this.jdField_j_of_type_Boolean) && (((AIOImageData)localObject3).jdField_e_of_type_JavaLangString != null)) {
                  localActionSheet.b(2131435906);
                }
                localActionSheet.b(2131435893);
                if ((this.jdField_g_of_type_Boolean) && (paramInt == 0)) {
                  localActionSheet.c(this.jdField_a_of_type_JavaLangString);
                }
                ThreadManager.getFileThreadHandler().post(new vsk(this, (File)localObject1, localActionSheet));
                if (!this.jdField_i_of_type_Boolean) {
                  localActionSheet.b(2131435891);
                }
                if (this.jdField_i_of_type_Boolean) {
                  localActionSheet.b(2131430138);
                }
              }
              if (((!this.q) && (!this.jdField_c_of_type_Boolean) && (this.jdField_g_of_type_Int != 3000) && (this.jdField_g_of_type_Int != 0)) && ((this.q) || (this.jdField_c_of_type_Boolean) || (this.jdField_g_of_type_Int == 3000) || (this.jdField_g_of_type_Int != 0))) {}
            }
            for (;;)
            {
              localActionSheet.c(2131433029);
              localActionSheet.a(new vsm(this, localActionSheet, (AIOImageData)localObject3, (File)localObject1, (AIORichMediaInfo)localObject2));
              localActionSheet.show();
              return;
              if ((this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
                localActionSheet.b(2131435887);
              }
              localActionSheet.b(2131435893);
              break;
              if ((MsgProxyUtils.a(this.jdField_g_of_type_Int) == 1032) && (localObject1 != null)) {
                localActionSheet.b(2131435893);
              }
            }
            if (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              break;
            }
            localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            localObject2 = ((AIOShortVideoData)localObject1).a(1);
          } while ((localObject2 == null) || (!((File)localObject2).exists()));
          localObject3 = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
          ((ActionSheet)localObject3).b(2131435887);
          ((ActionSheet)localObject3).b(2131437403);
          if (VersionUtils.d()) {
            ((ActionSheet)localObject3).b(2131435911);
          }
          ((ActionSheet)localObject3).b(2131435891);
          if (((this.jdField_g_of_type_Int == 3000) || (this.jdField_g_of_type_Int == 0)) || ((this.jdField_g_of_type_Int != 3000) && (this.jdField_g_of_type_Int == 0))) {}
          ((ActionSheet)localObject3).c(2131433029);
          ((ActionSheet)localObject3).a(new vsp(this, (ActionSheet)localObject3, (AIOShortVideoData)localObject1, (File)localObject2, paramInt));
          ((ActionSheet)localObject3).show();
          return;
        } while (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
        localObject3 = (AIOFilePicData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject2 = ((AIOFilePicData)localObject3).a(20);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((AIOFilePicData)localObject3).a(18);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ((AIOFilePicData)localObject3).a(16);
        }
      } while ((localObject2 == null) && (this.q));
      localObject1 = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
      if (localObject2 != null) {
        this.jdField_h_of_type_JavaLangString = ((File)localObject2).getPath();
      }
      if ((!a((ActionSheet)localObject1, (AIOFilePicData)localObject3)) && (MsgProxyUtils.a(this.jdField_g_of_type_Int) != 1032)) {
        if (!this.jdField_c_of_type_Boolean)
        {
          if (!((AIOFilePicData)localObject3).jdField_e_of_type_Boolean)
          {
            ((ActionSheet)localObject1).b(2131435887);
            ((ActionSheet)localObject1).b(2131428294);
          }
          if (localObject2 != null) {
            ((ActionSheet)localObject1).b(2131435893);
          }
          if (this.jdField_g_of_type_Boolean) {
            ((ActionSheet)localObject1).c(this.jdField_a_of_type_JavaLangString);
          }
          ThreadManager.getFileThreadHandler().post(new vsq(this, (File)localObject2, (ActionSheet)localObject1));
          ((ActionSheet)localObject1).b(2131435891);
          if (((this.q) || (this.jdField_c_of_type_Boolean) || (this.jdField_g_of_type_Int == 3000) || (this.jdField_g_of_type_Int == 0)) || ((!this.q) && (!this.jdField_c_of_type_Boolean) && ((this.jdField_g_of_type_Int == 3000) || (this.jdField_g_of_type_Int == 0)))) {
            ((ActionSheet)localObject1).b(2131435899);
          }
        }
      }
      for (;;)
      {
        ((ActionSheet)localObject1).c(2131433029);
        ((ActionSheet)localObject1).a(new vrt(this, (ActionSheet)localObject1, (AIOFilePicData)localObject3, (File)localObject2));
        ((ActionSheet)localObject1).show();
        return;
        ((ActionSheet)localObject1).b(2131435893);
        break;
        if (MsgProxyUtils.a(this.jdField_g_of_type_Int) == 1032) {
          ((ActionSheet)localObject1).b(2131435893);
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.r = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((this.r) && (this.s)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected boolean c()
  {
    if (((this.jdField_c_of_type_Int == -3321) || (this.jdField_c_of_type_Int == 1)) && (!this.jdField_k_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_e_of_type_Int == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    for (int i1 = localRunningAppProcessInfo.pid;; i1 = -2147483648) {
      return i1 == this.jdField_e_of_type_Int;
    }
  }
  
  public void d()
  {
    if (!h()) {
      this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.b();
    }
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("AIOGalleryScene", 2, "[setProgress] current:" + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a(String.valueOf(paramInt) + "%");
  }
  
  public void e()
  {
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryFileActivity.class);
      localIntent.addFlags(603979776);
      AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if (localAIORichMediaInfo != null) {
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      localIntent.putExtra("tab_tab_type", 0);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_g_of_type_Int);
      localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131434953));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    }
  }
  
  public boolean e()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Vss != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_Vss.jdField_a_of_type_Long, this.jdField_a_of_type_Vss.jdField_a_of_type_Int, 4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_Vss.jdField_a_of_type_Long, this.jdField_a_of_type_Vss.jdField_a_of_type_Int, 20);
      this.jdField_a_of_type_Vss = null;
      a(false);
      c(true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.d();
      }
      return bool;
      c(false);
      bool = super.e();
      int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
      if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
        if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i3, (AIOGalleryAdapter.GalleryImageStruct)localObject);
        }
      }
      Object localObject = a().findViewById(2131370993);
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      if (this.jdField_k_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
        }
      }
      if (this.n) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidAppActivity.getIntent());
      }
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_k_of_type_Int > 0) {
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, "" + this.jdField_k_of_type_Int, "", "", "");
    }
    try
    {
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_h_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager = null;
      if (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.b();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("AIOGalleryScene", 1, "register error");
      }
    }
  }
  
  public boolean f()
  {
    if (MsgProxyUtils.a(this.jdField_g_of_type_Int) == 1032) {}
    label138:
    label139:
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
        if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localObject = localAIOImageData.a(4);
          if (localObject != null) {
            break label138;
          }
          localObject = localAIOImageData.a(2);
        }
        for (;;)
        {
          if ((localObject == null) && (this.q)) {
            break label139;
          }
          if ((!this.q) && (!this.jdField_c_of_type_Boolean)) {}
          for (boolean bool = true;; bool = false)
          {
            return bool;
            if (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              break;
            }
            localObject = ((AIOShortVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(1);
            if ((localObject == null) || (!((File)localObject).exists())) {
              break;
            }
            return true;
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    if ((this.q) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
    }
  }
  
  boolean g()
  {
    return false;
  }
  
  boolean h()
  {
    return false;
  }
  
  public void m()
  {
    super.m();
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void n()
  {
    super.n();
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
            } while ((paramView == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()));
            a(true);
            this.jdField_a_of_type_Vss = new vss(this);
            this.jdField_a_of_type_Vss.jdField_a_of_type_Long = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g;
            this.jdField_a_of_type_Vss.jdField_a_of_type_Int = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
            if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Vss.jdField_a_of_type_Long, this.jdField_a_of_type_Vss.jdField_a_of_type_Int, 4);
              return;
            }
          } while (!AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
          if (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity))
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131427563), 0).a();
            a(false);
            this.jdField_a_of_type_Vss = null;
            this.s = true;
            c(true);
            return;
          }
          localObject = (AIOFilePicData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (((AIOFilePicData)localObject).jdField_d_of_type_Boolean)
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131428188), 0).a();
            a(false);
            c(true);
            this.jdField_a_of_type_Vss = null;
            return;
          }
          if (((AIOFilePicData)localObject).jdField_e_of_type_Boolean) {
            c(false);
          }
          long l1 = FMConfig.a();
          if ((((AIOFilePicData)localObject).jdField_a_of_type_Long > l1) && (FileManagerUtil.a())) {
            try
            {
              FileManagerUtil.a(false, this.jdField_a_of_type_AndroidAppActivity, new vrs(this, paramView));
              return;
            }
            catch (Throwable paramView)
            {
              return;
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
            this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          }
          if (this.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(a((float)((AIOFilePicData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long, paramView.jdField_a_of_type_Int));
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Vss.jdField_a_of_type_Long, this.jdField_a_of_type_Vss.jdField_a_of_type_Int, 20);
          this.jdField_a_of_type_ComTencentWidgetGallery.b(true);
          this.jdField_a_of_type_ComTencentWidgetGallery.a(true);
          return;
          ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
          c(2);
          return;
          if ((this.jdField_g_of_type_Int != 3000) && (this.jdField_g_of_type_Int != 0))
          {
            s();
            return;
          }
          t();
          return;
          x();
          return;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
          if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData))) {
            break;
          }
        } while (this.jdField_a_of_type_Vss == null);
        e();
        e();
        return;
      } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) || (((AIOImageData)paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_Int != 3) || (this.jdField_a_of_type_Vss == null));
      e();
      e();
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.b()))
      {
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a();
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.e();
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    } while ((localObject == null) || (!(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)));
    AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    int[] arrayOfInt = null;
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    Object localObject = arrayOfInt;
    if (i3 >= i1)
    {
      localObject = arrayOfInt;
      if (i3 <= i2 + i1 - 1)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
        localObject = arrayOfInt;
        if ((localView instanceof AIOGalleryAdapter.GalleryImageStruct))
        {
          localObject = arrayOfInt;
          if ((((AIOGalleryAdapter.GalleryImageStruct)localView).a() instanceof URLDrawable)) {
            localObject = ((AIOGalleryAdapter.GalleryImageStruct)localView).a();
          }
        }
      }
    }
    arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    i1 = arrayOfInt[1];
    i2 = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    if ((this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a()))
    {
      paramView = TroopMemberApiClient.a();
      paramView.k();
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidWidgetRelativeLayout, localAIOImageData.jdField_b_of_type_Int, localAIOImageData.jdField_g_of_type_JavaLangString, localAIOImageData.jdField_e_of_type_Long, localAIOImageData.jdField_f_of_type_Int, (Drawable)localObject, new vse(this, paramView), false, 0, i1 - i2);
      ReportController.b(null, "dc00899", "Grp_replyPic", "", "picViewer", "clk_reply", 0, 0, localAIOImageData.jdField_g_of_type_JavaLangString, "", "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, "出错了，请稍后重试！", 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.e();
          this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a = new WeakReference(paramView);
          paramView.setAlpha(0.5F);
        }
      }
      else if (paramMotionEvent.getAction() == 3) {
        paramView.setAlpha(1.0F);
      }
    }
  }
  
  public void s()
  {
    if (!this.q)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
        int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
        if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
          if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i3, (AIOGalleryAdapter.GalleryImageStruct)localObject);
          }
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
        if (localObject != null) {
          ((AIORichMediaInfo)localObject).jdField_c_of_type_Boolean = true;
        }
        r();
        a("Pic_view", 0);
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131434516, 0).a();
  }
  
  public void t()
  {
    ReportController.b(null, "dc00898", "", "", "0X8007123", "0X8007123", 0, 0, "", "", "", "");
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAppActivity.onBackPressed();
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryFileActivity.class);
    localIntent.addFlags(603979776);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_g_of_type_Int);
    localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
    localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((AIORichMediaInfo)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a()).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131434953));
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2131034375, 2131034323);
  }
  
  public void u()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == 0)
    {
      PicReporter.b(false);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131435904, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
      if (i1 == this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition()) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(i1);
      return;
      PicReporter.b(true);
    }
  }
  
  public void v()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new vsb(this), 1000L);
  }
  
  public void w()
  {
    this.o = true;
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AIOGalleryScene", 2, localException, new Object[0]);
    }
  }
  
  void x()
  {
    for (;;)
    {
      AIORichMediaData localAIORichMediaData;
      Object localObject3;
      try
      {
        localAIORichMediaData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (((localAIORichMediaData instanceof AIOImageData)) || ((localAIORichMediaData instanceof AIOFilePicData)))
        {
          if ((localAIORichMediaData instanceof AIOImageData))
          {
            localObject3 = localAIORichMediaData.a(4);
            Object localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = localAIORichMediaData.a(2);
            }
            localObject3 = localObject1;
            if (localObject1 != null) {
              break label233;
            }
            localObject1 = localAIORichMediaData.a(1);
            if (localObject1 != null) {
              break label116;
            }
          }
        }
        else {
          return;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        return;
      }
      Object localObject2;
      if ((localAIORichMediaData instanceof AIOFilePicData))
      {
        localObject3 = localAIORichMediaData.a(20);
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = localAIORichMediaData.a(18);
        }
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = localAIORichMediaData.a(16);
          continue;
          label116:
          this.jdField_h_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
          localObject2 = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, ((File)localObject2).getAbsolutePath(), true, true, true, true, true, 2, 99, 7);
          ((Intent)localObject2).putExtra("uintype", this.jdField_g_of_type_Int);
          ((Intent)localObject2).putExtra("open_chatfragment", true);
          ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
          this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2131034165, 2131034167);
          ReportController.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
        }
        else
        {
          label233:
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene
 * JD-Core Version:    0.7.0.1
 */