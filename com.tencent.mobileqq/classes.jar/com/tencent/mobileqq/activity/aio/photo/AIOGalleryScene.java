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
import vmq;
import vmr;
import vmu;
import vmw;
import vmx;
import vmy;
import vmz;
import vna;
import vnb;
import vnc;
import vnd;
import vne;
import vnf;
import vni;
import vnk;
import vnn;
import vno;
import vnq;

public class AIOGalleryScene
  extends AbstractGalleryScene
  implements View.OnClickListener, View.OnTouchListener
{
  protected static Drawable a;
  final int jdField_a_of_type_Int = -3321;
  long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected BroadcastReceiver a;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new vnd(this);
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
  public vnq a;
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
    this.jdField_a_of_type_MqqOsMqqHandler = new vnf(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vnb(this);
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
    localProgressPieDrawable.a(new vna(this));
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
    if (QLog.isColorLevel()) {
      if ("showEditPicBtn: editPhotoBtn is " + this.jdField_a_of_type_AndroidWidgetImageButton != null + " editPhotoBtn is " + this.s) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AIOGalleryScene", 2, new Object[] { Boolean.valueOf(bool) });
      if ((this.jdField_a_of_type_AndroidWidgetImageButton != null) && (this.s)) {
        break;
      }
      return;
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
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130970526, null);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a = new vmu(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(new vmw(this));
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
      i1 = 0;
      break;
    }
  }
  
  /* Error */
  public Boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_2
    //   7: iconst_0
    //   8: ldc_w 586
    //   11: ldc_w 588
    //   14: invokestatic 593	com/tencent/qbar/QbarNativeImpl:a	(IILjava/lang/String;Ljava/lang/String;)I
    //   17: pop
    //   18: iconst_2
    //   19: newarray int
    //   21: astore 4
    //   23: aload 4
    //   25: iconst_0
    //   26: iconst_2
    //   27: iastore
    //   28: aload 4
    //   30: iconst_1
    //   31: iconst_0
    //   32: iastore
    //   33: aload 4
    //   35: aload 4
    //   37: arraylength
    //   38: invokestatic 596	com/tencent/qbar/QbarNativeImpl:a	([II)I
    //   41: pop
    //   42: new 187	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 598
    //   52: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 405	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 604	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   68: astore 8
    //   70: aload 6
    //   72: astore 4
    //   74: aload 7
    //   76: astore 5
    //   78: aload_0
    //   79: getfield 177	com/tencent/mobileqq/activity/aio/photo/AIOGalleryScene:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   82: invokevirtual 608	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   85: astore 10
    //   87: aload 6
    //   89: astore 4
    //   91: aload 7
    //   93: astore 5
    //   95: new 610	android/graphics/BitmapFactory$Options
    //   98: dup
    //   99: invokespecial 611	android/graphics/BitmapFactory$Options:<init>	()V
    //   102: astore 9
    //   104: aload 6
    //   106: astore 4
    //   108: aload 7
    //   110: astore 5
    //   112: aload 9
    //   114: iconst_1
    //   115: putfield 614	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   118: aload 6
    //   120: astore 4
    //   122: aload 7
    //   124: astore 5
    //   126: aload 10
    //   128: aload 8
    //   130: invokevirtual 620	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   133: astore_1
    //   134: aload_1
    //   135: astore 4
    //   137: aload_1
    //   138: astore 5
    //   140: aload_1
    //   141: aconst_null
    //   142: aload 9
    //   144: invokestatic 626	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   147: pop
    //   148: aload_1
    //   149: ifnull +13 -> 162
    //   152: aload_1
    //   153: astore 4
    //   155: aload_1
    //   156: astore 5
    //   158: aload_1
    //   159: invokevirtual 631	java/io/InputStream:close	()V
    //   162: aload_1
    //   163: astore 4
    //   165: aload_1
    //   166: astore 5
    //   168: aload 9
    //   170: getfield 634	android/graphics/BitmapFactory$Options:outWidth	I
    //   173: istore_2
    //   174: aload_1
    //   175: astore 4
    //   177: aload_1
    //   178: astore 5
    //   180: aload 9
    //   182: getfield 637	android/graphics/BitmapFactory$Options:outHeight	I
    //   185: istore_3
    //   186: aload_1
    //   187: astore 4
    //   189: aload_1
    //   190: astore 5
    //   192: aload 9
    //   194: iconst_0
    //   195: putfield 614	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   198: iload_2
    //   199: iload_3
    //   200: imul
    //   201: ldc_w 638
    //   204: if_icmple +244 -> 448
    //   207: aload_1
    //   208: astore 4
    //   210: aload_1
    //   211: astore 5
    //   213: aload 9
    //   215: iload_2
    //   216: iload_3
    //   217: imul
    //   218: i2d
    //   219: invokestatic 644	java/lang/Math:sqrt	(D)D
    //   222: ldc2_w 645
    //   225: ddiv
    //   226: invokestatic 649	java/lang/Math:ceil	(D)D
    //   229: d2i
    //   230: putfield 652	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   233: aload_1
    //   234: astore 4
    //   236: aload_1
    //   237: astore 5
    //   239: aload 10
    //   241: aload 8
    //   243: invokevirtual 620	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   246: astore 6
    //   248: aload 6
    //   250: astore_1
    //   251: aload_1
    //   252: astore 4
    //   254: aload_1
    //   255: astore 5
    //   257: aload_1
    //   258: aconst_null
    //   259: aload 9
    //   261: invokestatic 626	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   264: astore 7
    //   266: aload_1
    //   267: ifnull +13 -> 280
    //   270: aload_1
    //   271: astore 4
    //   273: aload_1
    //   274: astore 5
    //   276: aload_1
    //   277: invokevirtual 631	java/io/InputStream:close	()V
    //   280: aload_1
    //   281: astore 4
    //   283: aload_1
    //   284: astore 5
    //   286: aload 7
    //   288: invokevirtual 657	android/graphics/Bitmap:getWidth	()I
    //   291: istore_2
    //   292: aload_1
    //   293: astore 4
    //   295: aload_1
    //   296: astore 5
    //   298: aload 7
    //   300: invokevirtual 660	android/graphics/Bitmap:getHeight	()I
    //   303: istore_3
    //   304: aload_1
    //   305: astore 4
    //   307: aload_1
    //   308: astore 5
    //   310: iload_2
    //   311: iload_3
    //   312: imul
    //   313: newarray int
    //   315: astore 6
    //   317: aload_1
    //   318: astore 4
    //   320: aload_1
    //   321: astore 5
    //   323: aload 7
    //   325: aload 6
    //   327: iconst_0
    //   328: iload_2
    //   329: iconst_0
    //   330: iconst_0
    //   331: iload_2
    //   332: iload_3
    //   333: invokevirtual 664	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   336: aload_1
    //   337: astore 4
    //   339: aload_1
    //   340: astore 5
    //   342: aload 7
    //   344: invokevirtual 667	android/graphics/Bitmap:recycle	()V
    //   347: aload_1
    //   348: astore 4
    //   350: aload_1
    //   351: astore 5
    //   353: iload_2
    //   354: iload_3
    //   355: imul
    //   356: newarray byte
    //   358: astore 7
    //   360: aload_1
    //   361: astore 4
    //   363: aload_1
    //   364: astore 5
    //   366: aload 6
    //   368: aload 7
    //   370: iload_2
    //   371: iload_3
    //   372: invokestatic 672	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   375: pop
    //   376: aload_1
    //   377: astore 4
    //   379: aload_1
    //   380: astore 5
    //   382: aload 7
    //   384: iload_2
    //   385: iload_3
    //   386: iconst_0
    //   387: invokestatic 675	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   390: istore_3
    //   391: iload_3
    //   392: istore_2
    //   393: aload_1
    //   394: ifnull +9 -> 403
    //   397: aload_1
    //   398: invokevirtual 631	java/io/InputStream:close	()V
    //   401: iload_3
    //   402: istore_2
    //   403: invokestatic 677	com/tencent/qbar/QbarNativeImpl:a	()I
    //   406: pop
    //   407: iload_2
    //   408: iconst_1
    //   409: if_icmpne +138 -> 547
    //   412: aload_0
    //   413: aload 8
    //   415: invokevirtual 680	android/net/Uri:getPath	()Ljava/lang/String;
    //   418: putfield 681	com/tencent/mobileqq/activity/aio/photo/AIOGalleryScene:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   421: iconst_1
    //   422: invokestatic 523	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   425: areturn
    //   426: astore_1
    //   427: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +13 -> 443
    //   433: ldc 185
    //   435: iconst_2
    //   436: aload_1
    //   437: invokevirtual 682	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   440: invokestatic 684	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: iconst_0
    //   444: invokestatic 523	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   447: areturn
    //   448: aload_1
    //   449: astore 4
    //   451: aload_1
    //   452: astore 5
    //   454: aload 9
    //   456: iconst_1
    //   457: putfield 652	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   460: goto -227 -> 233
    //   463: astore_1
    //   464: aload 4
    //   466: astore 5
    //   468: aload 5
    //   470: astore 4
    //   472: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +17 -> 492
    //   478: aload 5
    //   480: astore 4
    //   482: ldc 185
    //   484: iconst_2
    //   485: ldc_w 258
    //   488: aload_1
    //   489: invokestatic 687	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   492: aload 5
    //   494: ifnull +86 -> 580
    //   497: aload 5
    //   499: invokevirtual 631	java/io/InputStream:close	()V
    //   502: iconst_m1
    //   503: istore_2
    //   504: goto -101 -> 403
    //   507: astore 4
    //   509: aload_1
    //   510: ifnull +13 -> 523
    //   513: aload_1
    //   514: astore 4
    //   516: aload_1
    //   517: astore 5
    //   519: aload_1
    //   520: invokevirtual 631	java/io/InputStream:close	()V
    //   523: iconst_m1
    //   524: istore_3
    //   525: goto -134 -> 391
    //   528: astore_1
    //   529: iconst_m1
    //   530: istore_2
    //   531: goto -128 -> 403
    //   534: astore_1
    //   535: aload 4
    //   537: ifnull +8 -> 545
    //   540: aload 4
    //   542: invokevirtual 631	java/io/InputStream:close	()V
    //   545: aload_1
    //   546: athrow
    //   547: iconst_0
    //   548: invokestatic 523	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   551: areturn
    //   552: astore_1
    //   553: iload_3
    //   554: istore_2
    //   555: goto -152 -> 403
    //   558: astore 4
    //   560: goto -15 -> 545
    //   563: astore_1
    //   564: aload 5
    //   566: astore 4
    //   568: goto -33 -> 535
    //   571: astore_1
    //   572: goto -104 -> 468
    //   575: astore 4
    //   577: goto -68 -> 509
    //   580: iconst_m1
    //   581: istore_2
    //   582: goto -179 -> 403
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	AIOGalleryScene
    //   0	585	1	paramFile	File
    //   173	409	2	i1	int
    //   185	369	3	i2	int
    //   21	460	4	localObject1	Object
    //   507	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   514	27	4	localFile	File
    //   558	1	4	localIOException	java.io.IOException
    //   566	1	4	localObject2	Object
    //   575	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   76	489	5	localObject3	Object
    //   4	363	6	localObject4	Object
    //   1	382	7	localObject5	Object
    //   68	346	8	localUri	android.net.Uri
    //   102	353	9	localOptions	android.graphics.BitmapFactory.Options
    //   85	155	10	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   6	23	426	java/lang/UnsatisfiedLinkError
    //   33	42	426	java/lang/UnsatisfiedLinkError
    //   140	148	463	java/lang/Exception
    //   158	162	463	java/lang/Exception
    //   168	174	463	java/lang/Exception
    //   180	186	463	java/lang/Exception
    //   192	198	463	java/lang/Exception
    //   213	233	463	java/lang/Exception
    //   239	248	463	java/lang/Exception
    //   454	460	463	java/lang/Exception
    //   519	523	463	java/lang/Exception
    //   239	248	507	java/lang/OutOfMemoryError
    //   497	502	528	java/io/IOException
    //   78	87	534	finally
    //   95	104	534	finally
    //   112	118	534	finally
    //   126	134	534	finally
    //   257	266	534	finally
    //   276	280	534	finally
    //   286	292	534	finally
    //   298	304	534	finally
    //   310	317	534	finally
    //   323	336	534	finally
    //   342	347	534	finally
    //   353	360	534	finally
    //   366	376	534	finally
    //   382	391	534	finally
    //   472	478	534	finally
    //   482	492	534	finally
    //   397	401	552	java/io/IOException
    //   540	545	558	java/io/IOException
    //   140	148	563	finally
    //   158	162	563	finally
    //   168	174	563	finally
    //   180	186	563	finally
    //   192	198	563	finally
    //   213	233	563	finally
    //   239	248	563	finally
    //   454	460	563	finally
    //   519	523	563	finally
    //   78	87	571	java/lang/Exception
    //   95	104	571	java/lang/Exception
    //   112	118	571	java/lang/Exception
    //   126	134	571	java/lang/Exception
    //   257	266	571	java/lang/Exception
    //   276	280	571	java/lang/Exception
    //   286	292	571	java/lang/Exception
    //   298	304	571	java/lang/Exception
    //   310	317	571	java/lang/Exception
    //   323	336	571	java/lang/Exception
    //   342	347	571	java/lang/Exception
    //   353	360	571	java/lang/Exception
    //   366	376	571	java/lang/Exception
    //   382	391	571	java/lang/Exception
    //   257	266	575	java/lang/OutOfMemoryError
    //   276	280	575	java/lang/OutOfMemoryError
    //   286	292	575	java/lang/OutOfMemoryError
    //   298	304	575	java/lang/OutOfMemoryError
    //   310	317	575	java/lang/OutOfMemoryError
    //   323	336	575	java/lang/OutOfMemoryError
    //   342	347	575	java/lang/OutOfMemoryError
    //   353	360	575	java/lang/OutOfMemoryError
    //   366	376	575	java/lang/OutOfMemoryError
    //   382	391	575	java/lang/OutOfMemoryError
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
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131435896);
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
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131437360, 0).a();
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
          if ((this.jdField_a_of_type_Vnq != null) && (this.jdField_a_of_type_Vnq.jdField_a_of_type_Long == paramLong1) && (this.jdField_a_of_type_Vnq.jdField_a_of_type_Int == paramInt1) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
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
    } while ((paramInt2 != 20) || (this.jdField_a_of_type_Vnq == null) || (this.jdField_a_of_type_Vnq.jdField_a_of_type_Long != paramLong1) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
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
    label530:
    do
    {
      return;
      if ((paramInt2 == 4) && (this.jdField_a_of_type_Vnq != null) && (this.jdField_a_of_type_Vnq.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_Vnq.jdField_a_of_type_Int == paramInt1))
      {
        localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 == 1)
        {
          localObject = paramString;
          localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
          if (paramInt3 != 1) {
            break label530;
          }
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mPlayGifImage = true;
          paramString.mUseExifOrientation = false;
          paramString = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), paramString);
          switch (paramString.getStatus())
          {
          }
        }
        for (;;)
        {
          paramString.setTag(Integer.valueOf(1));
          paramString.setURLDrawableListener(this.jdField_a_of_type_Vnq);
          paramString.startDownload();
          this.jdField_a_of_type_Vnq.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
          return;
          localObject = "I:E";
          break;
          this.jdField_a_of_type_Vnq.onLoadSuccessed(paramString);
          return;
          this.jdField_a_of_type_Vnq.onLoadFialed(paramString, null);
          return;
          this.jdField_a_of_type_Vnq.onLoadCanceled(paramString);
        }
        if (!"TroopFileError".equals(paramString)) {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131436119), 0).a();
        }
        c(true);
        a(false);
        this.jdField_a_of_type_Vnq = null;
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
              this.jdField_a_of_type_Vnq = null;
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
    } while ((paramInt2 != 20) || (this.jdField_a_of_type_Vnq == null) || (this.jdField_a_of_type_Vnq.jdField_a_of_type_Long != paramLong));
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 == 1) {}
    for (Object localObject = paramString;; localObject = "I:E")
    {
      localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
      QLog.d("AIOGalleryScene", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
      if (paramInt3 != 1) {
        break label1134;
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
      paramString.setURLDrawableListener(this.jdField_a_of_type_Vnq);
      paramString.startDownload();
      this.jdField_a_of_type_Vnq.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
      return;
      this.jdField_a_of_type_Vnq.onLoadSuccessed(paramString);
      return;
      this.jdField_a_of_type_Vnq.onLoadFialed(paramString, null);
      return;
      this.jdField_a_of_type_Vnq.onLoadCanceled(paramString);
    }
    label1134:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.jdField_a_of_type_AndroidAppActivity.getString(2131428188).equals(paramString)) {
        break label1193;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 0).a();
    }
    for (;;)
    {
      a(false);
      c(true);
      this.jdField_a_of_type_Vnq = null;
      return;
      label1193:
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131436119), 0).a();
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130970895);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363005);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a(paramActivity);
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366642)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new vmx(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new vmy(this), paramInt);
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
      new vne(this, paramView, paramInt2).execute(new Void[0]);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131494025));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131493242));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131436111);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131436111));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841220));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription("查看聊天图片/视频");
    this.jdField_d_of_type_AndroidWidgetImageButton.setId(2131362281);
    this.jdField_d_of_type_AndroidWidgetImageButton.setImageResource(2130837598);
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
      this.jdField_c_of_type_AndroidWidgetImageButton.setImageResource(2130837596);
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
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837591);
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
        this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130841442);
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130970528, null);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, paramViewGroup);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131363005));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371001));
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
            this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131436112), new Object[] { FileUtil.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i) }));
            label220:
            c(true);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
              localObject = a().findViewById(2131370997);
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
        paramAdapterView = a().findViewById(2131370997);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131436111);
      break label220;
      label615:
      if ((!((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) && (localDrawable != null) && ((localDrawable instanceof SkinnableBitmapDrawable)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
        if ((localObject != null) && ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131436112), new Object[] { FileUtil.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i) }));
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
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131436112), new Object[] { FileUtil.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i) }));
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
                  localActionSheet.b(2131435870);
                  VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                }
                int i1 = 0;
                localActionSheet.b(2131435871);
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
                  localActionSheet.b(2131435881);
                }
                if ((this.jdField_j_of_type_Boolean) && (((AIOImageData)localObject3).jdField_e_of_type_JavaLangString != null)) {
                  localActionSheet.b(2131435890);
                }
                localActionSheet.b(2131435877);
                if ((this.jdField_g_of_type_Boolean) && (paramInt == 0)) {
                  localActionSheet.c(this.jdField_a_of_type_JavaLangString);
                }
                ThreadManager.getFileThreadHandler().post(new vni(this, (File)localObject1, localActionSheet));
                if (!this.jdField_i_of_type_Boolean) {
                  localActionSheet.b(2131435875);
                }
                if (this.jdField_i_of_type_Boolean) {
                  localActionSheet.b(2131430136);
                }
              }
              if (((!this.q) && (!this.jdField_c_of_type_Boolean) && (this.jdField_g_of_type_Int != 3000) && (this.jdField_g_of_type_Int != 0)) && ((this.q) || (this.jdField_c_of_type_Boolean) || (this.jdField_g_of_type_Int == 3000) || (this.jdField_g_of_type_Int != 0))) {}
            }
            for (;;)
            {
              localActionSheet.c(2131433015);
              localActionSheet.a(new vnk(this, localActionSheet, (AIOImageData)localObject3, (File)localObject1, (AIORichMediaInfo)localObject2));
              localActionSheet.show();
              return;
              if ((this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
                localActionSheet.b(2131435871);
              }
              localActionSheet.b(2131435877);
              break;
              if ((MsgProxyUtils.a(this.jdField_g_of_type_Int) == 1032) && (localObject1 != null)) {
                localActionSheet.b(2131435877);
              }
            }
            if (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
              break;
            }
            localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            localObject2 = ((AIOShortVideoData)localObject1).a(1);
          } while ((localObject2 == null) || (!((File)localObject2).exists()));
          localObject3 = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
          ((ActionSheet)localObject3).b(2131435871);
          ((ActionSheet)localObject3).b(2131437383);
          if (VersionUtils.d()) {
            ((ActionSheet)localObject3).b(2131435895);
          }
          ((ActionSheet)localObject3).b(2131435875);
          if (((this.jdField_g_of_type_Int == 3000) || (this.jdField_g_of_type_Int == 0)) || ((this.jdField_g_of_type_Int != 3000) && (this.jdField_g_of_type_Int == 0))) {}
          ((ActionSheet)localObject3).c(2131433015);
          ((ActionSheet)localObject3).a(new vnn(this, (ActionSheet)localObject3, (AIOShortVideoData)localObject1, (File)localObject2, paramInt));
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
            ((ActionSheet)localObject1).b(2131435871);
            ((ActionSheet)localObject1).b(2131428294);
          }
          if (localObject2 != null) {
            ((ActionSheet)localObject1).b(2131435877);
          }
          if (this.jdField_g_of_type_Boolean) {
            ((ActionSheet)localObject1).c(this.jdField_a_of_type_JavaLangString);
          }
          ThreadManager.getFileThreadHandler().post(new vno(this, (File)localObject2, (ActionSheet)localObject1));
          ((ActionSheet)localObject1).b(2131435875);
          if (((this.q) || (this.jdField_c_of_type_Boolean) || (this.jdField_g_of_type_Int == 3000) || (this.jdField_g_of_type_Int == 0)) || ((!this.q) && (!this.jdField_c_of_type_Boolean) && ((this.jdField_g_of_type_Int == 3000) || (this.jdField_g_of_type_Int == 0)))) {
            ((ActionSheet)localObject1).b(2131435883);
          }
        }
      }
      for (;;)
      {
        ((ActionSheet)localObject1).c(2131433015);
        ((ActionSheet)localObject1).a(new vmr(this, (ActionSheet)localObject1, (AIOFilePicData)localObject3, (File)localObject2));
        ((ActionSheet)localObject1).show();
        return;
        ((ActionSheet)localObject1).b(2131435877);
        break;
        if (MsgProxyUtils.a(this.jdField_g_of_type_Int) == 1032) {
          ((ActionSheet)localObject1).b(2131435877);
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
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131434937));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    }
  }
  
  public boolean e()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Vnq != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_Vnq.jdField_a_of_type_Long, this.jdField_a_of_type_Vnq.jdField_a_of_type_Int, 4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_Vnq.jdField_a_of_type_Long, this.jdField_a_of_type_Vnq.jdField_a_of_type_Int, 20);
      this.jdField_a_of_type_Vnq = null;
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
      Object localObject = a().findViewById(2131370997);
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
            return;
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
          } while ((paramView == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()));
          a(true);
          this.jdField_a_of_type_Vnq = new vnq(this);
          this.jdField_a_of_type_Vnq.jdField_a_of_type_Long = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g;
          this.jdField_a_of_type_Vnq.jdField_a_of_type_Int = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
          if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Vnq.jdField_a_of_type_Long, this.jdField_a_of_type_Vnq.jdField_a_of_type_Int, 4);
            return;
          }
        } while (!AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
        if (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131427563), 0).a();
          a(false);
          this.jdField_a_of_type_Vnq = null;
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
          this.jdField_a_of_type_Vnq = null;
          return;
        }
        if (((AIOFilePicData)localObject).jdField_e_of_type_Boolean) {
          c(false);
        }
        long l1 = FMConfig.a();
        if ((((AIOFilePicData)localObject).jdField_a_of_type_Long > l1) && (FileManagerUtil.a())) {
          try
          {
            FileManagerUtil.a(false, this.jdField_a_of_type_AndroidAppActivity, new vmq(this, paramView));
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
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Vnq.jdField_a_of_type_Long, this.jdField_a_of_type_Vnq.jdField_a_of_type_Int, 20);
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
      } while ((paramView == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)) || (this.jdField_a_of_type_Vnq == null));
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
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidWidgetRelativeLayout, localAIOImageData.jdField_b_of_type_Int, localAIOImageData.jdField_g_of_type_JavaLangString, localAIOImageData.jdField_e_of_type_Long, localAIOImageData.jdField_f_of_type_Int, (Drawable)localObject, new vnc(this, paramView), false, 0, i1 - i2);
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
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131434500, 0).a();
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
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131434937));
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
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131435888, 0).a();
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
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new vmz(this), 1000L);
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