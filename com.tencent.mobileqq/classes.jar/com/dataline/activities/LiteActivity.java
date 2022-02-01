package com.dataline.activities;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.core.DirectForwarder;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.DatalineSessionAdapterUseNewFileBubble;
import com.dataline.util.ItemHolder;
import com.dataline.util.ItemHolder.FileItemHolder;
import com.dataline.util.ItemHolder.ImageItemHolder;
import com.dataline.util.ItemHolder.MutiImageItemHolder;
import com.dataline.util.ItemHolder.NewFileItemHolder;
import com.dataline.util.ItemHolder.TextItemHolder;
import com.dataline.util.file.SendInfo;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.devicelib.DeviceLib;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconLongCallback;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.BottomBtnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsProcessor;
import com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import cooperation.peak.PeakUtils;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.qqfav.QfavHelper;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LiteActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, PanelIconLinearLayout.PanelIconCallback, PanelIconLinearLayout.PanelIconLongCallback, PhotoListPanel.BottomBtnClickListener, XPanelContainer.PanelCallback, Observer
{
  public static String a;
  protected static String c;
  public int a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  public View.OnTouchListener a;
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  protected RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  LiteActivity.LiteJumpAction jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction;
  DatalineSessionAdapter jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = null;
  private InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  protected TopGestureLayout a;
  DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new LiteActivity.27(this);
  private LiteCopyPromptHelper jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper;
  DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new LiteActivity.35(this);
  ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public PatchedButton a;
  XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public XPanelContainer a;
  Runnable jdField_a_of_type_JavaLangRunnable = new LiteActivity.37(this);
  List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public View.OnClickListener b;
  public ImageButton b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected String b;
  boolean jdField_b_of_type_Boolean = false;
  TextView c;
  protected boolean c;
  protected boolean d = false;
  boolean e = false;
  boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = false;
  private boolean j = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.LiteActivity";
  }
  
  public LiteActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new LiteActivity.22(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new LiteActivity.23(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new LiteActivity.31(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new LiteActivity.32(this);
  }
  
  private void A()
  {
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null) {
      k = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    }
    while (k == 0) {
      if (!this.e)
      {
        d(true);
        return;
        k = 0;
      }
      else
      {
        d(false);
        return;
      }
    }
    d(false);
  }
  
  private void B()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction == null) {
      return;
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a();
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if (this.jdField_a_of_type_Int == 1) {
      return 2;
    }
    return 0;
  }
  
  private int a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    if (paramInt == -1000) {}
    do
    {
      return 1;
      if (paramInt == -2000) {
        return 2;
      }
      if (paramInt == -2009) {
        return 4;
      }
    } while (paramInt != -2005);
    paramInt = FileManagerUtil.a(paramDataLineMsgRecord.filename);
    if (paramInt == 0) {
      return 3;
    }
    if (paramInt == 2) {
      return 6;
    }
    return 7;
  }
  
  static Drawable a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = Shader.TileMode.REPEAT;
        Drawable localDrawable = paramContext.getResources().getDrawable(2130839222);
        if ((localDrawable instanceof BitmapDrawable))
        {
          localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
          paramString = ((BitmapDrawable)localDrawable).getTileModeX();
          k = ((BitmapDrawable)localDrawable).getGravity();
          if ((localBitmap == null) || (paramString == Shader.TileMode.REPEAT) || (k != 48)) {
            return paramContext.getResources().getDrawable(2130839222);
          }
        }
        else
        {
          if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
            break label193;
          }
          localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
          paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
          k = ((SkinnableBitmapDrawable)localDrawable).getGravity();
          continue;
        }
        paramString = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
        paramString.setGravity(k);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 1", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130850446);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 2", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130850446);
      }
      label193:
      int k = 119;
      Bitmap localBitmap = null;
    }
  }
  
  private View a()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = ((PhotoListPanel)View.inflate(this, 2131561079, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setCustomOnClickListener(this);
    Intent localIntent = new Intent();
    String str1 = this.app.getAccount();
    Object localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str1);
    if (localObject != null) {}
    for (localObject = ((Friends)localObject).name;; localObject = null)
    {
      String str2 = this.app.getCustomFaceFilePath(1, str1, 0);
      localIntent.putExtra("key_my_uin", str1);
      localIntent.putExtra("key_my_nick", (String)localObject);
      localIntent.putExtra("key_my_head_dir", str2);
      localIntent.putExtra("key_disable_presend", true);
      localIntent.putExtra("key_disable_quality_cb", true);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 50);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 100000002432L);
      localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005F28");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(new LiteActivity.42(this));
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
  }
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 426	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 432	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +35 -> 55
    //   23: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +13 -> 39
    //   29: getstatic 75	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   32: iconst_2
    //   33: ldc_w 434
    //   36: invokestatic 437	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload 6
    //   41: ifnull +10 -> 51
    //   44: aload 6
    //   46: invokeinterface 442 1 0
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: areturn
    //   55: aload 6
    //   57: ldc_w 444
    //   60: invokeinterface 447 2 0
    //   65: istore_2
    //   66: aload 6
    //   68: ldc_w 449
    //   71: invokeinterface 452 2 0
    //   76: istore_3
    //   77: aload 6
    //   79: invokeinterface 455 1 0
    //   84: pop
    //   85: aload 6
    //   87: iload_3
    //   88: invokeinterface 459 2 0
    //   93: lstore 4
    //   95: lload 4
    //   97: l2f
    //   98: invokestatic 464	com/tencent/mobileqq/utils/FileUtils:c	()F
    //   101: fcmpl
    //   102: ifle +27 -> 129
    //   105: aload_0
    //   106: ldc_w 465
    //   109: invokevirtual 469	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   112: putstatic 471	com/dataline/activities/LiteActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   115: aload 6
    //   117: ifnull +10 -> 127
    //   120: aload 6
    //   122: invokeinterface 442 1 0
    //   127: aconst_null
    //   128: areturn
    //   129: aload 6
    //   131: iload_2
    //   132: invokeinterface 472 2 0
    //   137: astore 7
    //   139: new 403	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   146: aload_0
    //   147: invokevirtual 476	com/dataline/activities/LiteActivity:getExternalCacheDir	()Ljava/io/File;
    //   150: invokevirtual 479	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: ldc_w 481
    //   156: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 483
    //   162: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 481
    //   168: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 9
    //   176: aload 9
    //   178: invokestatic 486	com/dataline/activities/LiteActivity:e	(Ljava/lang/String;)V
    //   181: new 403	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   188: aload 9
    //   190: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 9
    //   195: iconst_1
    //   196: anewarray 488	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: aload 7
    //   203: aastore
    //   204: iconst_0
    //   205: aaload
    //   206: invokestatic 491	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   209: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore 7
    //   217: new 493	com/tencent/mm/vfs/VFSFile
    //   220: dup
    //   221: aload 9
    //   223: invokespecial 495	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   226: astore 9
    //   228: aload 9
    //   230: invokevirtual 498	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   233: ifne +35 -> 268
    //   236: aload 9
    //   238: invokevirtual 501	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   241: ifne +27 -> 268
    //   244: aload_0
    //   245: ldc_w 502
    //   248: invokestatic 506	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   251: invokespecial 508	com/dataline/activities/LiteActivity:d	(Ljava/lang/String;)V
    //   254: aload 6
    //   256: ifnull +10 -> 266
    //   259: aload 6
    //   261: invokeinterface 442 1 0
    //   266: aconst_null
    //   267: areturn
    //   268: aload 8
    //   270: aload_1
    //   271: invokevirtual 512	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   274: astore_1
    //   275: aload_1
    //   276: ifnonnull +33 -> 309
    //   279: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +13 -> 295
    //   285: getstatic 75	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   288: iconst_2
    //   289: ldc_w 514
    //   292: invokestatic 437	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload 6
    //   297: ifnull +10 -> 307
    //   300: aload 6
    //   302: invokeinterface 442 1 0
    //   307: aconst_null
    //   308: areturn
    //   309: lload 4
    //   311: ldc2_w 515
    //   314: lcmp
    //   315: ifle +138 -> 453
    //   318: aload_0
    //   319: iconst_1
    //   320: putfield 518	com/dataline/activities/LiteActivity:h	Z
    //   323: new 192	com/tencent/mobileqq/utils/QQCustomDialog
    //   326: dup
    //   327: aload_0
    //   328: ldc_w 519
    //   331: invokespecial 522	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   334: astore 8
    //   336: aload 8
    //   338: ldc_w 523
    //   341: invokevirtual 526	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   344: aload 8
    //   346: aload_0
    //   347: ldc_w 527
    //   350: invokevirtual 469	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   353: invokevirtual 531	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   356: pop
    //   357: aload 8
    //   359: aload_0
    //   360: ldc_w 532
    //   363: invokevirtual 469	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   366: invokevirtual 536	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   369: pop
    //   370: aload 8
    //   372: iconst_0
    //   373: invokevirtual 539	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   376: aload 8
    //   378: iconst_0
    //   379: invokevirtual 542	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   382: aload 8
    //   384: aload_0
    //   385: ldc_w 543
    //   388: invokevirtual 469	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   391: new 545	com/dataline/activities/LiteActivity$44
    //   394: dup
    //   395: aload_0
    //   396: aload_1
    //   397: invokespecial 548	com/dataline/activities/LiteActivity$44:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/io/InputStream;)V
    //   400: invokevirtual 552	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   403: pop
    //   404: aload 8
    //   406: aload_0
    //   407: ldc_w 553
    //   410: invokevirtual 469	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   413: new 555	com/dataline/activities/LiteActivity$45
    //   416: dup
    //   417: aload_0
    //   418: aload 7
    //   420: aload_1
    //   421: lload 4
    //   423: invokespecial 558	com/dataline/activities/LiteActivity$45:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   426: invokevirtual 561	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   429: pop
    //   430: aload 8
    //   432: invokevirtual 564	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   435: aload 7
    //   437: astore_1
    //   438: aload 6
    //   440: ifnull -387 -> 53
    //   443: aload 6
    //   445: invokeinterface 442 1 0
    //   450: aload 7
    //   452: areturn
    //   453: aload_0
    //   454: aload 7
    //   456: aload_1
    //   457: lload 4
    //   459: invokespecial 567	com/dataline/activities/LiteActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   462: goto -27 -> 435
    //   465: astore 7
    //   467: aload 6
    //   469: astore_1
    //   470: aload 7
    //   472: astore 6
    //   474: aload_0
    //   475: iconst_0
    //   476: putfield 569	com/dataline/activities/LiteActivity:g	Z
    //   479: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +15 -> 497
    //   485: getstatic 75	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   488: iconst_2
    //   489: ldc_w 571
    //   492: aload 6
    //   494: invokestatic 574	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   497: aload_1
    //   498: ifnull +9 -> 507
    //   501: aload_1
    //   502: invokeinterface 442 1 0
    //   507: aconst_null
    //   508: areturn
    //   509: astore_1
    //   510: aconst_null
    //   511: astore 6
    //   513: aload 6
    //   515: ifnull +10 -> 525
    //   518: aload 6
    //   520: invokeinterface 442 1 0
    //   525: aload_1
    //   526: athrow
    //   527: astore_1
    //   528: goto -15 -> 513
    //   531: astore 7
    //   533: aload_1
    //   534: astore 6
    //   536: aload 7
    //   538: astore_1
    //   539: goto -26 -> 513
    //   542: astore 6
    //   544: aconst_null
    //   545: astore_1
    //   546: goto -72 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	LiteActivity
    //   0	549	1	paramUri	Uri
    //   65	67	2	k	int
    //   76	12	3	m	int
    //   93	365	4	l	long
    //   16	519	6	localObject1	Object
    //   542	1	6	localException1	Exception
    //   137	318	7	str	String
    //   465	6	7	localException2	Exception
    //   531	6	7	localObject2	Object
    //   4	427	8	localObject3	Object
    //   174	63	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   23	39	465	java/lang/Exception
    //   55	115	465	java/lang/Exception
    //   129	254	465	java/lang/Exception
    //   268	275	465	java/lang/Exception
    //   279	295	465	java/lang/Exception
    //   318	435	465	java/lang/Exception
    //   453	462	465	java/lang/Exception
    //   6	18	509	finally
    //   23	39	527	finally
    //   55	115	527	finally
    //   129	254	527	finally
    //   268	275	527	finally
    //   279	295	527	finally
    //   318	435	527	finally
    //   453	462	527	finally
    //   474	497	531	finally
    //   6	18	542	java/lang/Exception
  }
  
  private String a(String paramString)
  {
    if (!FileUtils.b(paramString)) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "copyForwardImageFile:error. filePath[" + paramString + "]");
    }
    String str;
    do
    {
      return paramString;
      str = FileManagerUtil.a(paramString);
      long l = FileUtils.a(paramString);
      if (l > 3145728L)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "copyForwardImageFile:error. fileSize[" + l + "]");
        return paramString;
      }
      if ((float)l > FileUtils.c())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "copyForwardImageFile:error. file space not enough");
        return paramString;
      }
      str = FileManagerUtil.b(FMSettings.a().b() + str);
    } while (!FileUtils.d(paramString, str));
    return str;
  }
  
  public static void a(Context paramContext)
  {
    LiteActivity.18 local18 = new LiteActivity.18();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131719900), paramContext.getString(2131693763), 2131693747, 2131693747, local18, null).show();
  }
  
  static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131370520);
    if (ThemeUtil.isInNightMode(paramIphoneTitleBarActivity.app)) {
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    while (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  public static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup)
  {
    int k = 0;
    SharedPreferences localSharedPreferences = ChatBackground.a(paramIphoneTitleBarActivity, paramIphoneTitleBarActivity.app.getCurrentAccountUin(), 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.DATALINE_PC_UIN;
    arrayOfString[1] = "chat_uniform_bg";
    if ((localSharedPreferences.getString(arrayOfString[0], null) == null) && (localSharedPreferences.getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int m = arrayOfString.length;
    for (;;)
    {
      if (k >= m) {
        break label188;
      }
      String str = localSharedPreferences.getString(arrayOfString[k], null);
      if (str != null)
      {
        if (("".equals(str)) || ("null".equals(str)) || ("none".equals(str)))
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, str);
          return;
        }
        if (!new VFSFile(str).exists())
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, "null");
          return;
        }
        if (a(paramIphoneTitleBarActivity, paramViewGroup, str)) {
          break;
        }
      }
      k += 1;
    }
    label188:
    a(paramIphoneTitleBarActivity, paramViewGroup, "null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    a(paramString, paramContext, new LiteActivity.19(paramQQAppInterface, paramString));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt, String paramString)
  {
    StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_save2weiyun");
    long l = FileUtils.a(paramString);
    String str = FileManagerUtil.a(paramString);
    FileManagerEntity localFileManagerEntity = null;
    if (paramDataLineMsgRecord.nWeiyunSessionId != 0L) {
      localFileManagerEntity = this.app.getFileManagerDataCenter().a(paramDataLineMsgRecord.nWeiyunSessionId);
    }
    if ((FileManagerUtil.a()) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      if (FreeWifiHelper.a(getActivity(), 5, new LiteActivity.55(this, paramDataLineMsgRecord, localFileManagerEntity, str, paramString))) {
        FMDialogUtil.a(getActivity(), 2131692609, 2131692612, new LiteActivity.56(this, paramDataLineMsgRecord, localFileManagerEntity, str, paramString));
      }
      if (paramInt != -2000) {
        break label354;
      }
      paramInt = 1;
    }
    for (;;)
    {
      int k = a();
      ReportController.b(this.app, "dc00898", "", "", "0X800AD60", "0X800AD60", paramInt, 0, "" + k, "", "", "");
      return;
      if (localFileManagerEntity == null)
      {
        k = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
        FMToastUtil.b(FileManagerUtil.d(str) + getString(2131692731));
        paramDataLineMsgRecord.nWeiyunSessionId = this.app.getFileManagerEngine().a(paramString, null, this.app.getAccount(), 0, false).nSessionId;
        this.app.getMessageFacade().a(k).d(paramDataLineMsgRecord.msgId);
        break;
      }
      FMToastUtil.b(FileManagerUtil.d(str) + getString(2131692731));
      this.app.getFileManagerEngine().a(paramDataLineMsgRecord.nWeiyunSessionId);
      break;
      label354:
      if (paramInt == -2005)
      {
        paramInt = FileManagerUtil.a(paramDataLineMsgRecord.filename);
        if (paramInt == 0) {
          paramInt = 2;
        }
        for (;;)
        {
          break;
          if (paramInt == 2) {
            paramInt = 3;
          } else {
            paramInt = 4;
          }
        }
      }
      paramInt = 4;
    }
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet)
  {
    MessageForPic localMessageForPic = null;
    int k;
    if (paramDataLineMsgSet == null)
    {
      k = 1;
      paramDataLineMsgSet = localMessageForPic;
    }
    for (;;)
    {
      if (k != 0)
      {
        QQToast.a(getApplicationContext(), getString(2131694916), 0).b(getResources().getDimensionPixelSize(2131299166));
        return;
        ArrayList localArrayList = paramDataLineMsgSet.values();
        if ((localArrayList == null) || (localArrayList.size() == 0))
        {
          k = 1;
          paramDataLineMsgSet = localMessageForPic;
          continue;
        }
        paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
        if (paramDataLineMsgSet == null) {
          k = 1;
        }
      }
      else
      {
        localMessageForPic = new MessageForPic();
        localMessageForPic.size = paramDataLineMsgSet.filesize;
        localMessageForPic.senderuin = paramDataLineMsgSet.senderuin;
        localMessageForPic.selfuin = this.app.getAccount();
        localMessageForPic.frienduin = paramDataLineMsgSet.frienduin;
        localMessageForPic.time = paramDataLineMsgSet.time;
        localMessageForPic.issend = paramDataLineMsgSet.issend;
        localMessageForPic.uuid = paramDataLineMsgSet.serverPath;
        localMessageForPic.busiType = paramDataLineMsgSet.busId;
        localMessageForPic.istroop = 7;
        localMessageForPic.subVersion = 5;
        localMessageForPic.path = paramDataLineMsgSet.path;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "savePicsAsCustomFace, path:" + localMessageForPic.path + " uuid:" + localMessageForPic.uuid + " size:" + localMessageForPic.size);
        if ((FileUtils.a(localMessageForPic.path)) && (paramDataLineMsgSet.md5 == null))
        {
          QLog.i(jdField_a_of_type_JavaLangString, 1, "savePicsAsCustomFace, calc md5!");
          ThreadManager.executeOnSubThread(new LiteActivity.30(this, localMessageForPic));
          return;
        }
        localMessageForPic.md5 = HexUtil.bytes2HexStr(paramDataLineMsgSet.md5);
        a(localMessageForPic);
        return;
      }
      k = 0;
    }
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet, DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    int k = 1;
    a(paramDataLineMsgSet);
    if (paramInt == -2000) {}
    for (;;)
    {
      paramInt = a();
      ReportController.b(this.app, "dc00898", "", "", "0X800AD61", "0X800AD61", k, 0, "" + paramInt, "", "", "");
      return;
      if (paramInt == -2005) {
        if (FileManagerUtil.a(paramDataLineMsgRecord.filename) == 0) {
          k = 3;
        } else {
          k = 2;
        }
      }
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null)
    {
      QQToast.a(getApplicationContext(), getString(2131694916), 0).b(getResources().getDimensionPixelSize(2131299166));
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "savePicsAsCustomFace, md5:" + paramMessageForPic.md5);
    URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(paramMessageForPic, 1, "datalineface"), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    AIOGalleryUtils.a(this, this.app, localURLDrawable, paramMessageForPic.frienduin, getResources().getDimensionPixelSize(2131299166), null, paramMessageForPic.picExtraData);
  }
  
  public static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.postDelayed(new LiteActivity.28(paramXListView, paramScrollerRunnable), 200L);
    }
  }
  
  static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView, int paramInt)
  {
    if (paramXListView != null) {}
    try
    {
      paramScrollerRunnable.a(paramInt, -1, null, 3);
      paramXListView.setTranscriptMode(1);
      return;
    }
    catch (SecurityException paramScrollerRunnable)
    {
      for (;;)
      {
        paramXListView.setSelection(paramInt);
      }
    }
    catch (IllegalArgumentException paramScrollerRunnable)
    {
      for (;;)
      {
        paramXListView.setSelection(paramInt);
      }
    }
  }
  
  public static void a(XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.setSelection(paramXListView.getCount());
    }
  }
  
  static void a(String paramString, Context paramContext, LiteActivity.CreateThumbCB paramCreateThumbCB)
  {
    ThreadManager.executeOnSubThread(new LiteActivity.20(paramContext, paramString, paramCreateThumbCB));
  }
  
  static void a(String paramString, LiteActivity.GetBackgroundCB paramGetBackgroundCB)
  {
    ThreadManager.executeOnSubThread(new LiteActivity.15(paramString, paramGetBackgroundCB));
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.g = true;
    ThreadManager.post(new LiteActivity.46(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131691377), HardCodeUtil.a(2131706216), new LiteActivity.47(this));
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new LiteActivity.48(this));
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    String str = (String)paramViewGroup.getTag(2131361807);
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      if (!"null".equals(str))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131361807, "null");
      }
    }
    for (;;)
    {
      return true;
      if ("none".equals(paramString))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131361807, "null");
      }
      else if (!paramString.equals(str))
      {
        a(paramString, new LiteActivity.14(paramIphoneTitleBarActivity, paramString, paramViewGroup));
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      do
      {
        return true;
        paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramLong);
      } while (paramQQAppInterface == null);
      if ((paramQQAppInterface.getCloudType() != 2) && (paramQQAppInterface.status == 1)) {
        return false;
      }
      if (paramQQAppInterface.nOpType != 6) {
        return false;
      }
    } while (paramQQAppInterface.status != 1);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    return a(paramQQAppInterface, paramDataLineMsgRecord.nWeiyunSessionId);
  }
  
  public static void b(Context paramContext)
  {
    LiteActivity.50 local50 = new LiteActivity.50();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131719900), paramContext.getString(2131693772), 2131693747, 2131693747, local50, null).show();
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: iconst_1
    //   5: istore 4
    //   7: getstatic 1077	android/os/Build$VERSION:SDK_INT	I
    //   10: bipush 23
    //   12: if_icmplt +93 -> 105
    //   15: iload_2
    //   16: istore_3
    //   17: aload_0
    //   18: ldc_w 1079
    //   21: invokevirtual 1082	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   24: istore_1
    //   25: iload_1
    //   26: ifne +81 -> 107
    //   29: iconst_1
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +80 -> 112
    //   35: aload_0
    //   36: ldc_w 1084
    //   39: invokevirtual 1082	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   42: ifne +70 -> 112
    //   45: iconst_1
    //   46: istore_2
    //   47: iload_2
    //   48: ifeq +69 -> 117
    //   51: aload_0
    //   52: ldc_w 1086
    //   55: invokevirtual 1082	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   58: istore_1
    //   59: iload_1
    //   60: ifne +57 -> 117
    //   63: iload 4
    //   65: istore_2
    //   66: iload_2
    //   67: istore_3
    //   68: iload_2
    //   69: ifne +36 -> 105
    //   72: iload_2
    //   73: istore_3
    //   74: aload_0
    //   75: aload_0
    //   76: bipush 100
    //   78: iconst_3
    //   79: anewarray 488	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 1079
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: ldc_w 1084
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: ldc_w 1086
    //   99: aastore
    //   100: invokevirtual 1090	com/dataline/activities/LiteActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   103: iload_2
    //   104: istore_3
    //   105: iload_3
    //   106: ireturn
    //   107: iconst_0
    //   108: istore_2
    //   109: goto -78 -> 31
    //   112: iconst_0
    //   113: istore_2
    //   114: goto -67 -> 47
    //   117: iconst_0
    //   118: istore_2
    //   119: goto -53 -> 66
    //   122: astore 5
    //   124: aload 5
    //   126: invokevirtual 1093	java/lang/Exception:printStackTrace	()V
    //   129: getstatic 75	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   132: iconst_2
    //   133: new 403	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 1095
    //   143: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 5
    //   148: invokevirtual 479	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: iload_3
    //   158: ireturn
    //   159: astore 5
    //   161: iload_2
    //   162: istore_3
    //   163: goto -39 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	LiteActivity
    //   24	36	1	k	int
    //   3	159	2	bool1	boolean
    //   1	162	3	bool2	boolean
    //   5	59	4	bool3	boolean
    //   122	25	5	localException1	Exception
    //   159	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   17	25	122	java/lang/Exception
    //   74	103	122	java/lang/Exception
    //   35	45	159	java/lang/Exception
    //   51	59	159	java/lang/Exception
  }
  
  private void d(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131755842);
    localQQCustomDialog.setContentView(2131559084);
    localQQCustomDialog.setTitle(getString(2131719900));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(getString(2131690778), new LiteActivity.49(this));
    localQQCustomDialog.show();
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691453);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839693);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  private static void e(String paramString)
  {
    paramString = new VFSFile(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int m = paramString.length;
      int k = 0;
      while (k < m)
      {
        Object localObject = paramString[k];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        k += 1;
      }
    }
  }
  
  @TargetApi(19)
  private void w()
  {
    this.i = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131381097));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if (!this.i) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.mContentView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDirtyListener(new LiteActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new LiteActivity.3(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void x()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(QQToast.a(1));
    localQQToast.b(1);
    localQQToast.d(2000);
    localQQToast.c(2131693953);
    localQQToast.a();
  }
  
  private void y()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktxt");
      a(new QQText(str, 13, 32, 6000).toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    }
  }
  
  private void z()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qfile_entrance_type_key", 11);
    localIntent.putExtra("select_file_support_send_docs_file", TencentDocSelectAddDocsProcessor.a().a());
    startActivityForResult(localIntent, 2);
    overridePendingTransition(2130771981, 2130771982);
    ReportController.b(this.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
  }
  
  public float a()
  {
    return this.mDensity;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 4) {
      if (Build.VERSION.SDK_INT < 23) {
        break label58;
      }
    }
    label58:
    for (boolean bool = PermissionUtils.isStorePermissionEnable(this);; bool = true)
    {
      if (!bool)
      {
        requestPermissions(new LiteActivity.41(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return null;
      }
      return a();
    }
  }
  
  DataLineMsgRecord a(DataLineHandler paramDataLineHandler, SendInfo paramSendInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSendInfo == null) {
      return null;
    }
    paramDataLineHandler = new DataLineMsgRecord();
    String str1 = paramSendInfo.a();
    String str2 = paramSendInfo.b();
    paramDataLineHandler.sessionid = paramSendInfo.a();
    paramDataLineHandler.path = str1;
    paramDataLineHandler.thumbPath = str2;
    paramDataLineHandler.msgtype = DataLineHandler.a(paramInt1);
    paramDataLineHandler.groupId = paramInt2;
    paramDataLineHandler.groupSize = paramInt3;
    paramDataLineHandler.groupIndex = paramInt4;
    return paramDataLineHandler;
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.app.getFileManagerDataCenter().a(paramForwardFileInfo.b());
    if (localFileManagerEntity == null) {}
    int n;
    do
    {
      return null;
      n = DataLineHandler.a(localFileManagerEntity);
    } while (!DataLineHandler.d(n));
    int m = DataLineHandler.a(paramForwardFileInfo.d(), paramBoolean);
    int k = m;
    if (!paramBoolean)
    {
      k = m;
      if (m == 1) {
        k = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.a(k);
    localDataLineMsgRecord.sessionid = ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.d();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.d();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.b();
    localDataLineMsgRecord.fileFrom = n;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.f();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = HexUtil.hexStr2Bytes(localFileManagerEntity.strFileMd5);
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
    }
    if (TextUtils.isEmpty(paramForwardFileInfo.a())) {}
    for (localDataLineMsgRecord.path = paramForwardFileInfo.d();; localDataLineMsgRecord.path = paramForwardFileInfo.a()) {
      return localDataLineMsgRecord;
    }
  }
  
  String a()
  {
    String str;
    if (this.jdField_a_of_type_Int == 1) {
      str = AppConstants.DATALINE_IPAD_UIN;
    }
    for (int k = 6003;; k = 6000)
    {
      return DraftTextManager.a(this.app).a(this.app, str, k);
      str = AppConstants.DATALINE_PC_UIN;
    }
  }
  
  public void a()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378232);
      ((View)localObject).setBackgroundResource(2130839232);
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setVisible(true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378232).setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
  }
  
  void a(long paramLong, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    Object localObject2 = getString(2131719148);
    Object localObject1 = localObject2;
    if (paramString != null) {
      localObject1 = (String)localObject2 + paramString;
    }
    paramString = new LiteActivity.12(this, paramLong);
    localObject2 = new LiteActivity.13(this, paramLong, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 232, null, this.app.getApplication().getString(2131719154), (String)localObject1, this.app.getApplication().getString(2131719149), paramString, (DialogInterface.OnClickListener)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.getAction()))) {}
    do
    {
      return;
      if ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))
      {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
        return;
      }
    } while ((!paramIntent.getAction().equals("android.intent.action.MAIN")) || (!paramIntent.getBooleanExtra("system_share_multi_send", false)));
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
  }
  
  void a(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.d(getActivity()))
    {
      FMToastUtil.a(2131694510);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    Object localObject;
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize())) {
      localObject = getString(2131692614);
    }
    for (;;)
    {
      label86:
      int k;
      if (((String)localObject).equals(""))
      {
        localObject = getString(2131693815);
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
        localActionSheet.setMainTitle((CharSequence)localObject);
        localActionSheet.addButton(getResources().getString(2131692776), 1);
        localActionSheet.addCancelButton(2131690800);
        localActionSheet.setOnButtonClickListener(new LiteActivity.24(this, localDataLineMsgSet, paramItemHolder, localActionSheet));
        localActionSheet.show();
        return;
        if (localDataLineMsgSet.getGroupType() == -1000)
        {
          localObject = getString(2131693816);
          continue;
        }
        if ((localDataLineMsgSet.getGroupType() != -2000) || (localDataLineMsgSet.isSingle())) {
          break label264;
        }
        localObject = localDataLineMsgSet.values().iterator();
        k = 0;
        label202:
        if (((Iterator)localObject).hasNext())
        {
          if (!DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject).next())) {
            break label261;
          }
          k += 1;
        }
      }
      label261:
      for (;;)
      {
        break label202;
        localObject = String.format(getString(2131693788), new Object[] { Integer.valueOf(k) });
        break;
        break label86;
      }
      label264:
      localObject = "";
    }
  }
  
  void a(com.tencent.imcore.message.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.app.isTroopMark(paramMessage)) || (this.j) || (HiddenChatHelper.a(paramMessage.frienduin, paramMessage.istroop, this.app))) {
      return;
    }
    Intent localIntent = this.app.getIntentByMessage(this, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    runOnUiThread(new LiteActivity.36(this, paramMessage, localIntent));
  }
  
  public void a(Object paramObject)
  {
    if (this.j) {
      b(true);
    }
    AIOUtils.o = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int k = ((Integer)paramObject).intValue();
    if (k == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    switch (k)
    {
    default: 
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00898", "", "", "0X800AD64", "0X800AD64", 0, 0, "", "", "", "");
      getIntent().putExtra("qq_sub_business_id", 107);
      return;
    case 5: 
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktkphoto");
      i();
      ReportController.b(this.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00898", "", "", "0X800AD65", "0X800AD65", 0, 0, "", "", "", "");
      return;
    case 16: 
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckfile");
      if (!CheckPermission.isHasStoragePermission(this))
      {
        CheckPermission.requestSDCardPermission(this, new LiteActivity.40(this));
        return;
      }
      z();
      ReportController.b(this.app, "dc00898", "", "", "0X800AD66", "0X800AD66", 0, 0, "", "", "", "");
      return;
    }
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      }
    }
    for (;;)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X800AD67", "0X800AD67", 0, 0, "", "", "", "");
      return;
      f();
      ReportController.b(null, "CliOper", "", "", MpFileConstant.i, MpFileConstant.i, 0, 0, "", "", "", "");
      paramObject = new Bundle();
      paramObject.putBoolean("string_from", false);
      paramObject.putBoolean("string_uin", false);
      paramObject.putLong("device_din", 0L);
      paramObject.putInt("sTitleID", 0);
      QQProxyForDataline.a(this, paramObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
    }
  }
  
  void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.length() > 4500)
    {
      QQToast.a(this, HardCodeUtil.a(2131706213), 1).b(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramString, this.jdField_a_of_type_Int);
    ReportController.b(this.app, "dc00898", "", "", "0X800AD68", "0X800AD68", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
  }
  
  void a(String paramString, long paramLong, int paramInt)
  {
    if (!b()) {
      b(null);
    }
    int k;
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return;
      k = DataLineMsgRecord.getDevTypeBySeId(paramLong);
      localDataLineMsgRecord = this.app.getMessageFacade().a(k).a(paramLong);
    } while (localDataLineMsgRecord == null);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    switch (paramInt)
    {
    default: 
      this.app.getMessageFacade().a(k).a(paramLong);
      a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 1, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 2, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      if (FileUtils.a(paramString)) {
        localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 0, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      }
      if (localDataLineMsgRecord.nOpType == 35) {
        localDataLineHandler.b(localDataLineMsgRecord);
      } else {
        localDataLineHandler.a().a(localDataLineMsgRecord, k, 2);
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent2.putExtra("peakconstant.request_code", 55);
    localIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent2.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent2.putExtra("PhotoConst.is_troop_send_mixed_msg", false);
    localIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
    localIntent2.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", true);
    localIntent2.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
    localIntent2.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
    localIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    Intent localIntent1 = new Intent(this, NewPhotoListActivity.class);
    localIntent1.putExtra("enter_from", 40);
    int k = PlusPanelUtils.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, localIntent2, localIntent1);
    localIntent1.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "");
    localIntent1.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "");
    localIntent1.putExtra(AlbumConstants.h, 55);
    localIntent1.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent1.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent1.putExtra("PhotoConst.original_button", true);
    if (k == -1) {
      startActivity(localIntent1);
    }
    for (;;)
    {
      AlbumUtil.anim(this, false, true);
      if (PeakUtils.a != null) {
        PeakUtils.a.b();
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
      {
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
        if (paramArrayList != null) {
          localIntent1.putExtra("PhotoConst.editPathMap", paramArrayList);
        }
      }
      startActivityForResult(localIntent1, k);
    }
  }
  
  void a(ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMultipleFile paths is null !!!!!!");
      }
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      int k = 0;
      while (k < paramArrayList.size())
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        k += 1;
      }
    }
    LiteActivity.16 local16 = new LiteActivity.16(this, paramArrayList);
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l = new VFSFile(str).length() + l;
      }
    }
    if (l == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.g(this)) && (!NetworkUtil.h(this)) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this, 2131692609, 2131692614, new LiteActivity.17(this, local16, paramInt));
      return;
    }
    local16.execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  void a(List<String> paramList)
  {
    if (paramList == null) {}
    ArrayList localArrayList1;
    do
    {
      return;
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        int k = FileManagerUtil.a(str);
        if (2 == k) {
          localArrayList1.add(str);
        } else if (k == 0) {
          localArrayList2.add(str);
        }
      }
      if (!localArrayList2.isEmpty())
      {
        paramList = new Bundle();
        paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList2);
        new LiteActivity.SendPhotoAsyncTask(this).execute(new Bundle[] { paramList });
      }
    } while (localArrayList1.isEmpty());
    paramList = new Bundle();
    paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList1);
    new LiteActivity.SendVideoAsyncTask(this).execute(new Bundle[] { paramList });
  }
  
  void a(Observable paramObservable, Object paramObject)
  {
    j();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      int k = DataLineMsgRecord.getDevTypeBySeId(paramObservable.sessionid);
      DataLineMsgSet localDataLineMsgSet = this.app.getDataLineMsgProxy(k).a(paramObservable.sessionid);
      if (QLog.isDevelopLevel()) {
        QLog.d("AutoTest_Xandy", 4, "SessionID:" + paramObservable.sessionid + ", Show:" + System.currentTimeMillis());
      }
      if ((DataLineMsgSet.isSingle(paramObservable)) || (localDataLineMsgSet == null) || (localDataLineMsgSet.getComeCount() <= 1)) {
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    label146:
    do
    {
      break label146;
      for (;;)
      {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          if ((!paramObservable.isSendFromLocal()) && (paramObservable.msgtype != -1004)) {
            break label265;
          }
        }
        return;
        if (!this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(paramObservable.sessionid, this.jdField_a_of_type_ComTencentWidgetXListView))
        {
          this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
          continue;
          if ((paramObject instanceof com.tencent.imcore.message.Message))
          {
            paramObservable = (com.tencent.imcore.message.Message)paramObject;
            if (paramObservable.frienduin == null) {
              break;
            }
            if (!paramObservable.frienduin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
              continue;
            }
            this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
            continue;
          }
          if ((paramObject instanceof RecentUser))
          {
            paramObservable = (RecentUser)paramObject;
            if (paramObservable.uin == null) {
              break;
            }
            if (paramObservable.uin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
              this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
            }
          }
        }
      }
      paramObject = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    } while ((paramObservable.isread) || (paramObject.b(paramObservable.frienduin)));
    label265:
    a(this.app.getMessageFacade().a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    this.app.getMessageFacade().a(this.jdField_a_of_type_Int).e();
    if (!paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
      a(this.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
  
  protected boolean a()
  {
    return this.f;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  @TargetApi(18)
  boolean a(long paramLong)
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      n();
      return false;
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    for (long l = new StatFs(AppConstants.SDCARD_ROOT).getAvailableBytes(); l < paramLong; l = new StatFs(AppConstants.SDCARD_ROOT).getAvailableBlocks() * new StatFs(AppConstants.SDCARD_ROOT).getBlockSize())
    {
      m();
      return false;
    }
    return true;
  }
  
  boolean a(Intent paramIntent, int paramInt)
  {
    paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return false;
        localFileManagerEntity = this.app.getFileManagerDataCenter().a(paramIntent.b());
      } while (localFileManagerEntity == null);
      int k = DataLineHandler.a(localFileManagerEntity);
      switch (k)
      {
      case 0: 
      default: 
        QLog.w(jdField_a_of_type_JavaLangString, 1, "forwardFile fileFrom " + k + " is not handled");
        return false;
      case 3: 
        if (paramInt != 101) {
          break label156;
        }
        bool = true;
        paramIntent = a(paramIntent, bool, this.jdField_a_of_type_Int);
      }
    } while (paramIntent == null);
    ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramIntent, false);
    for (;;)
    {
      return true;
      label156:
      bool = false;
      break;
      this.app.getFileManagerEngine().a(3, paramIntent.b(), this.jdField_a_of_type_Int);
      continue;
      if (this.jdField_a_of_type_Int == 0) {
        this.app.getFileManagerEngine().a(paramIntent.b(), paramIntent.e(), paramIntent.a(), Long.parseLong(this.app.getCurrentAccountUin()), 7, paramIntent.a());
      } else {
        this.app.getFileManagerEngine().a(paramIntent.b(), paramIntent.e(), paramIntent.a(), Long.parseLong(this.app.getCurrentAccountUin()), 6003, paramIntent.a());
      }
    }
  }
  
  boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return true;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ItemHolder localItemHolder = (ItemHolder)paramView.getTag();
    if (localItemHolder == null) {
      return false;
    }
    DataLineMsgSet localDataLineMsgSet = localItemHolder.a();
    if (localDataLineMsgSet == null) {
      return false;
    }
    Object localObject1 = "";
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    int k = localDataLineMsgSet.getGroupType();
    Object localObject2;
    if (localDataLineMsgSet.isSingle()) {
      switch (localDataLineMsgSet.getGroupType())
      {
      default: 
        localObject1 = "";
        localObject2 = null;
      }
    }
    for (;;)
    {
      Object localObject3;
      if (localObject2 == null)
      {
        return false;
        localObject2 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localQQCustomMenu.a(2131365389, paramView.getContext().getString(2131691372), 2130839050);
        localQQCustomMenu.a(2131367398, paramView.getContext().getString(2131692687), 2130839059);
        localQQCustomMenu.a(2131366625, paramView.getContext().getString(2131692258), 2130839058);
        localObject1 = "";
        continue;
        localObject2 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localObject1 = localDataLineMsgRecord.path;
        if ((AIOUtils.a(1) == 1) && (FileUtils.b(localDataLineMsgRecord.path)) && (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0))
        {
          localQQCustomMenu.a(2131362218, getString(2131693294), 2130839057);
          continue;
          if (localDataLineMsgRecord.bIsMoloImage) {
            localObject1 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
          }
          for (;;)
          {
            localObject3 = localDataLineMsgRecord.path;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            localObject2 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = (RelativeLayout)localItemHolder.a().jdField_a_of_type_AndroidViewView;
            }
          }
        }
      }
      else
      {
        Context localContext = ((RelativeLayout)localObject2).getContext();
        if (localDataLineMsgRecord.canForward()) {
          localQQCustomMenu.a(2131367398, localContext.getString(2131693773), 2130839059);
        }
        boolean bool;
        if ((FileUtils.b((String)localObject1)) && (localDataLineMsgRecord.strMoloKey == null))
        {
          if (localDataLineMsgSet.getGroupType() == -2005)
          {
            bool = TencentDocConvertConfigProcessor.a().c();
            long l = FileManagerUtil.a(this.app, localDataLineMsgRecord.filename);
            String str = TencentDocImportFileInfoProcessor.a().c();
            localObject3 = str;
            if (TextUtils.isEmpty(str)) {
              localObject3 = TeamWorkUtils.jdField_a_of_type_JavaLangString;
            }
            if ((bool) && (TeamWorkUtils.a((String)localObject1, localDataLineMsgRecord.filename, (String)localObject3)) && (localDataLineMsgRecord.filesize <= l))
            {
              ReportController.b(this.app, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
              localQQCustomMenu.a(2131378967, paramView.getContext().getString(2131719807), 2130839071);
            }
          }
          if (localDataLineMsgSet.getGroupType() != -2000) {
            break label803;
          }
          localQQCustomMenu.a(2131366625, paramView.getContext().getString(2131692258), 2130839058);
          if (a(this.app, localDataLineMsgRecord)) {
            localQQCustomMenu.a(2131381009, localContext.getString(2131692411), 2130839072);
          }
        }
        paramView = ((RelativeLayout)localObject2).getContext();
        localQQCustomMenu.a(2131365645, paramView.getString(2131693756), 2130839054);
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsMoloImage)))
        {
          bool = true;
          label700:
          localObject1 = new LiteActivity.29(this, localDataLineMsgRecord, localDataLineMsgSet, paramView, k, (String)localObject1, bool);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) {
            break label1007;
          }
          paramView = new int[2];
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLocationInWindow(paramView);
        }
        for (;;)
        {
          localObject2 = localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
          k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x;
          int m = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
          if (paramView == null) {}
          for (paramView = null;; paramView = Integer.valueOf(paramView[1]))
          {
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a((View)localObject2, k, m, localQQCustomMenu, (View.OnClickListener)localObject1, paramView);
            this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new LiteActivity.1DissmissListener(this));
            return true;
            label803:
            if ((localDataLineMsgSet.getGroupType() == -2009) && (FileUtils.b((String)localObject1)))
            {
              localQQCustomMenu.a(2131366625, paramView.getContext().getString(2131692258), 2130839058);
              break;
            }
            if ((localDataLineMsgSet.getGroupType() != -2005) || (!FileUtils.b((String)localObject1))) {
              break;
            }
            localQQCustomMenu.a(2131366625, paramView.getContext().getString(2131692258), 2130839058);
            break;
            switch (localDataLineMsgSet.getGroupType())
            {
            default: 
              paramView = null;
            }
            for (;;)
            {
              localObject2 = paramView;
              if (paramView != null) {
                break;
              }
              return false;
              paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
              continue;
              if (localDataLineMsgRecord.bIsMoloImage) {
                paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
              } else {
                paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
              }
            }
            bool = false;
            break label700;
          }
          label1007:
          paramView = null;
        }
      }
    }
  }
  
  public boolean a(PhotoListPanel paramPhotoListPanel)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAlbumBtnClicked");
    }
    if (!paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {}
    for (ArrayList localArrayList = new ArrayList(paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList);; localArrayList = null)
    {
      a(localArrayList);
      paramPhotoListPanel.g();
      ReportController.b(null, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
      return true;
    }
  }
  
  public boolean a(Object paramObject)
  {
    int k = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconLongClick panelID=" + k);
    }
    switch (k)
    {
    default: 
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      if ((checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        k = 1;
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        requestPermissions(new LiteActivity.39(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return true;
        k = 0;
      }
      else
      {
        r();
        return true;
        k = 1;
      }
    }
  }
  
  protected String b()
  {
    if (jdField_c_of_type_JavaLangString == null) {
      return getString(2131719295);
    }
    return jdField_c_of_type_JavaLangString;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370516));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter);
    View localView = LayoutInflater.from(this).inflate(2131559007, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.getCount());
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new LiteActivity.4(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new LiteActivity.5(this));
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    t();
    if (paramInt2 == 0) {
      this.e = false;
    }
    for (;;)
    {
      A();
      return;
      if (1 == paramInt2) {
        this.e = true;
      }
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int k = this.jdField_a_of_type_Int;
    String str = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("targetUin");
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() != 0)) {
      if (this.jdField_b_of_type_JavaLangString.equals(AppConstants.DATALINE_IPAD_UIN))
      {
        setTitle(2131693827);
        this.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      paramIntent = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      paramIntent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramIntent.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return;
      setTitle(2131693826);
      this.jdField_a_of_type_Int = 0;
      continue;
      if (this.jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int = paramIntent.getIntExtra("device_type", -1);
        if (this.jdField_a_of_type_Int == 1)
        {
          setTitle(2131693827);
          this.jdField_b_of_type_JavaLangString = AppConstants.DATALINE_IPAD_UIN;
        }
        else
        {
          setTitle(2131693826);
          this.jdField_b_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
          this.jdField_a_of_type_Int = 0;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = k;
        this.jdField_b_of_type_JavaLangString = str;
      }
    }
  }
  
  void b(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.d(getActivity()))
    {
      FMToastUtil.a(2131694510);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 3145728L)) {}
    for (paramItemHolder = getString(2131692611);; paramItemHolder = "")
    {
      ArrayList localArrayList = new ArrayList();
      long l = 0L;
      Object localObject = localDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
        {
          l += localDataLineMsgRecord.filesize;
          localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
        }
      }
      if ((localArrayList.size() == 0) && (!localDataLineMsgSet.isSingle()))
      {
        int k = localDataLineMsgSet.getTotalCount() - localDataLineMsgSet.getComeCount();
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgSet.getFirstItem().bIsMoloImage))) {}
        for (paramItemHolder = String.format(getString(2131693785), new Object[] { Integer.valueOf(k) });; paramItemHolder = String.format(getString(2131693797), new Object[] { Integer.valueOf(k) }))
        {
          localObject = new LiteActivity.25(this);
          DialogUtil.a(this, 230, getString(2131693775), paramItemHolder, 2131694615, 2131694615, null, (DialogInterface.OnClickListener)localObject).show();
          return;
        }
      }
      localObject = paramItemHolder;
      if (paramItemHolder.equals(""))
      {
        localObject = paramItemHolder;
        if (localDataLineMsgSet.getGroupType() == -2000)
        {
          localObject = paramItemHolder;
          if (!localDataLineMsgSet.isSingle()) {
            localObject = String.format(getString(2131693787), new Object[] { Integer.valueOf(localArrayList.size()) });
          }
        }
      }
      paramItemHolder = (ItemHolder)localObject;
      if (((String)localObject).equals("")) {
        paramItemHolder = getString(2131693813);
      }
      localObject = (ActionSheet)ActionSheetHelper.a(this, null);
      ((ActionSheet)localObject).setMainTitle(paramItemHolder);
      ((ActionSheet)localObject).addButton(getResources().getString(2131692775), 1);
      ((ActionSheet)localObject).addCancelButton(2131690800);
      ((ActionSheet)localObject).setOnButtonClickListener(new LiteActivity.26(this, l, localDataLineMsgSet, localArrayList, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
  }
  
  void b(String paramString)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.msgtype = -2334;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.issend = 255;
    localDataLineMsgRecord.msg = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.appendToList(localDataLineMsgRecord);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  void b(ArrayList<SendInfo> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    DataLineHandler localDataLineHandler;
    int m;
    int k;
    Object localObject;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      m = paramArrayList.size();
      if (m > 3) {
        break;
      }
      k = 0;
      while (k < m)
      {
        localObject = a(localDataLineHandler, (SendInfo)paramArrayList.get(k), paramInt, 0, 0, 0);
        if (localObject != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject, false);
        }
        k += 1;
      }
    }
    label111:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((m > 3) && (m < 50))
    {
      localObject = new ArrayList();
      int n = localDataLineHandler.a();
      k = 0;
      if (k < m)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(k), paramInt, n, m, k);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, n)) {
          break label396;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label393:
    label396:
    for (;;)
    {
      k += 1;
      break label111;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      m = localDataLineHandler.a();
      k = 0;
      label251:
      if (k < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(k), paramInt, m, 50, k);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, m)) {
          break label393;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        k += 1;
        break label251;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        k = 0;
        while (k < 50)
        {
          paramArrayList.remove(0);
          k += 1;
        }
        break;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = false;
    c(true);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled());
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams().height = -2;
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, AIOUtils.a(8.0F, this.app.getApplication().getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(AIOUtils.a(14.0F, this.app.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130850251);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(AIOUtils.a(11.0F, this.app.getApplication().getResources()), AIOUtils.a(6.0F, this.app.getApplication().getResources()), AIOUtils.a(11.0F, this.app.getApplication().getResources()), AIOUtils.a(6.0F, this.app.getApplication().getResources()));
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight(), AIOUtils.a(100.0F, this.app.getApplication().getResources()) });
    localValueAnimator.addUpdateListener(new LiteActivity.51(this));
    localValueAnimator.addListener(new LiteActivity.52(this));
    localValueAnimator.setDuration(100L).setRepeatCount(0);
    localValueAnimator.start();
  }
  
  boolean b()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    return (localRegisterProxySvcPackHandler.a() == 0) || (localRegisterProxySvcPackHandler.d() != 0);
  }
  
  public boolean b(PhotoListPanel paramPhotoListPanel)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
    long l = 0L;
    if (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      int k = paramPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(str);
      if (1 == k) {
        localArrayList.add(str);
      }
      for (;;)
      {
        l = new VFSFile(str).length() + l;
        break;
        if (k == 0) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    if (l == 0L)
    {
      a(this);
      return true;
    }
    if ((NetworkUtil.g(this)) && (!NetworkUtil.h(this)) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize())) {
      FMDialogUtil.a(this, 2131692609, 2131692614, new LiteActivity.43(this, (ArrayList)localObject1, localArrayList));
    }
    for (;;)
    {
      paramPhotoListPanel.g();
      ReportController.b(null, "CliOper", "", "", "0X8005A2F", "0X8005A2F", 0, 0, paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() + "", "", "", "");
      return true;
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
        new LiteActivity.SendPhotoAsyncTask(this).execute(new Bundle[] { localObject2 });
      }
      if (!localArrayList.isEmpty())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
        new LiteActivity.SendVideoAsyncTask(this).execute(new Bundle[] { localObject1 });
      }
    }
  }
  
  void c()
  {
    this.app.getMessageFacade().a(this.jdField_a_of_type_Int).a(15, new LiteActivity.6(this));
  }
  
  void c(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent.getIntExtra("aio_msg_source", 999) == 1) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (this.jdField_c_of_type_Boolean)
      {
        AIOUtils.o = false;
        this.d = false;
      }
      return;
      bool = false;
    }
  }
  
  void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.msgtype = -2009;
    localDataLineHandler.a(localDataLineMsgRecord, false);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131369141));
    if (this.jdField_a_of_type_AndroidTextTextWatcher != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new LiteActivity.8(this) });
        DeviceLib.a(this, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        h();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new LiteActivity.9(this));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(new LiteActivity.10(this));
        return;
        this.jdField_a_of_type_AndroidTextTextWatcher = new LiteActivity.7(this);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "input set error", localException);
      }
    }
  }
  
  void d(Intent paramIntent)
  {
    paramIntent = null;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase(""))
    {
      PlusPanelUtils.jdField_a_of_type_JavaLangString = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = ImageUtil.b(this, paramIntent);
    if (paramIntent != null)
    {
      ImageUtil.a(this, paramIntent);
      if (!FileUtils.f(paramIntent))
      {
        QQToast.a(this, getString(2131692480), 0).b(getTitleBarHeight());
        return;
      }
      if (!new VFSFile(paramIntent).exists()) {
        QQToast.a(this, getString(2131694918), 0).b(getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(this, getString(2131694918), 0).b(getTitleBarHeight());
      return;
    }
    localObject = new Intent();
    ArrayList localArrayList = new ArrayList();
    ((Intent)localObject).setClass(this, CameraPreviewActivity.class);
    localArrayList.add(paramIntent);
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    ((Intent)localObject).putExtra(AlbumConstants.h, 55);
    ((Intent)localObject).putExtra("uin", AppConstants.DATALINE_PC_UIN);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.leftView.getText().toString());
    startActivity((Intent)localObject);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (!b()) {
      b(null);
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
                        do
                        {
                          return;
                          switch (paramInt1)
                          {
                          case 4: 
                          default: 
                            return;
                          }
                        } while ((paramInt2 != -1) || (paramIntent == null));
                        paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
                      } while ((paramIntent == null) || (paramIntent.size() <= 0));
                      b(paramIntent, 1);
                      paramIntent.clear();
                      a(false);
                      return;
                    } while (paramInt2 != -1);
                    d(paramIntent);
                    return;
                  } while ((paramInt2 != -1) || (paramIntent == null));
                  paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
                } while ((paramIntent == null) || (paramIntent.size() <= 0));
                b(paramIntent, 2);
                paramIntent.clear();
                a(false);
                return;
              } while (paramInt2 != -1);
              a(false);
              return;
            } while ((paramInt2 != -1) || (paramIntent == null));
            paramIntent = paramIntent.getExtras().getString("textMsg");
          } while (paramIntent.length() <= 0);
          a(paramIntent);
          return;
        } while (paramInt2 != -1);
        a(false);
        return;
        A();
      } while ((paramInt2 != -1) || (paramIntent == null));
      return;
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
    } while ((paramInt2 != -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramInt1, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131165443);
    setContentView(2131559110);
    setStatusBarBlue();
    boolean bool = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377159));
    if (bool) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850508);
    }
    int i1;
    int i2;
    int i3;
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)findViewById(2131369142));
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369878);
      if (localObject1 != null) {
        ViewCompat.setImportantForAccessibility((View)localObject1, 2);
      }
      setTitle(2131693826);
      getWindow().setBackgroundDrawable(null);
      b(getIntent());
      c(getIntent());
      k();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131381895));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370519));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370518));
      if (this.jdField_a_of_type_Int == 1)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8005D19", "0X8005D19", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "=== dataline report event into ipad 0X8005D19 ");
        }
      }
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction = new LiteActivity.LiteJumpAction(this, this);
      this.app.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      localObject1 = this.app.getMessageFacade();
      if (localObject1 != null) {
        ((QQMessageFacade)localObject1).addObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = this.app.getDataLineMsgProxy(this.jdField_a_of_type_Int).a(true);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = new DatalineSessionAdapterUseNewFileBubble(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList, this, this.app);
      b();
      d();
      localObject1 = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      ((DataLineHandler)localObject1).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364700));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131377356));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
      e();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)findViewById(2131372729));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconLongListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(null);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377759));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      q();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      p();
      this.app.getMessageFacade().a(this.jdField_a_of_type_Int).e();
      if (paramBundle == null) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new LiteActivity.1(this), 200L);
      }
      a(getIntent());
      paramBundle = (RegisterProxySvcPackHandler)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
      if ((paramBundle.a() == 0) && (!paramBundle.a()))
      {
        paramBundle.a();
        paramBundle.b(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.isEmpty()) {
        break label991;
      }
      paramBundle = getSharedPreferences("first_enter_dataline", 0);
      int k = paramBundle.getInt("year", -1);
      int m = paramBundle.getInt("month", -1);
      int n = paramBundle.getInt("day", -1);
      localObject2 = Calendar.getInstance();
      i1 = ((Calendar)localObject2).get(1);
      i2 = ((Calendar)localObject2).get(2);
      i3 = ((Calendar)localObject2).get(5);
      if ((i1 == k) && (i2 == m) && (i3 == n)) {
        break label991;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() - 1);
      if (localObject2 == null) {
        break label991;
      }
      localObject2 = ((DataLineMsgSet)localObject2).getFirstItem();
      if ((localObject2 == null) || (((DataLineMsgRecord)localObject2).msgtype == -5000)) {
        break label991;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DataLineMsgSet localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject2).next();
        if (localDataLineMsgSet != null)
        {
          DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
          if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.msgtype == -5000)) {
            try
            {
              ((Iterator)localObject2).remove();
              this.app.getDataLineMsgProxy(this.jdField_a_of_type_Int).a(localDataLineMsgSet);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850507);
    }
    Object localObject1 = ((DataLineHandler)localObject1).a(0, this.jdField_a_of_type_Int);
    Object localObject2 = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject2).msgId = ((Long)localObject1).longValue();
    ((DataLineMsgRecord)localObject2).sessionid = ((Long)localObject1).longValue();
    ((DataLineMsgRecord)localObject2).msgtype = -5000;
    ((DataLineMsgRecord)localObject2).time = MessageCache.a();
    ((DataLineMsgRecord)localObject2).isread = true;
    this.app.getDataLineMsgProxy(this.jdField_a_of_type_Int).a((DataLineMsgRecord)localObject2);
    paramBundle = paramBundle.edit();
    paramBundle.putInt("year", i1);
    paramBundle.putInt("month", i2);
    paramBundle.putInt("day", i3);
    paramBundle.commit();
    label991:
    w();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367651);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131367648));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368426));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367664));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)findViewById(2131367649));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131706211));
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131706210));
    }
    this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper = new LiteCopyPromptHelper(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.app, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper.a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    if (this.app.getMessageFacade() != null)
    {
      this.app.getMessageFacade().a(this.jdField_a_of_type_Int).e();
      this.app.getMessageFacade().a(this.jdField_a_of_type_Int).d();
      this.app.getMessageFacade().deleteObserver(this);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    this.jdField_a_of_type_Int = -1;
    if (this.app.getFileManagerProxy() != null) {
      this.app.getFileManagerProxy().c();
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(null);
    }
    FileManagerUtil.b(this);
    if (this.i)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper.b();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    i(paramIntent);
    g();
    h(paramIntent);
    e(paramIntent);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).d();
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.jdField_b_of_type_Boolean) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finishing LiteActivity (ask ippan)");
      }
      finish();
      com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = false;
    }
    if (this.i) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
    }
    ApngImage.playByTag(0);
    a();
    if (this.i) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_IPAD_UIN;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 6003;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 6000;
  }
  
  public void e(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(paramIntent, this.app, this);
      paramIntent = new Bundle();
      paramIntent.putString("uin", String.valueOf(AppConstants.DATALINE_PC_UIN));
      paramIntent.putInt("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f.intValue(), paramIntent);
    }
    int k;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(a());
      k = paramIntent.getIntExtra(AlbumConstants.h, -1);
      if (55 != k) {
        break label329;
      }
      if (!paramIntent.getExtras().containsKey("PhotoConst.PHOTO_PATHS")) {
        break;
      }
      ArrayList localArrayList = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      if (localArrayList.size() <= 0) {
        break;
      }
      a(localArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    return;
    if (paramIntent.getExtras().containsKey("file_send_path"))
    {
      c(paramIntent.getExtras().getString("file_send_path"));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
    for (;;)
    {
      if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
      {
        getIntent().removeExtra("PhotoConst.SEND_FLAG");
        a(paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS"));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
        }
      }
      if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
        getIntent().putExtra("isMigSdkShare", true);
      }
      g(paramIntent);
      f(paramIntent);
      return;
      label329:
      if (56 == k)
      {
        c(paramIntent.getExtras().getString("file_send_path"));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
        }
      }
    }
  }
  
  protected void f()
  {
    this.f = false;
    new Handler().postDelayed(new LiteActivity.11(this), 1500L);
  }
  
  void f(Intent paramIntent)
  {
    if (paramIntent.hasExtra("JumpAction.Text"))
    {
      paramIntent = paramIntent.getStringExtra("JumpAction.Text");
      if ((paramIntent != null) && (paramIntent.length() > 0))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramIntent);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramIntent.length());
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 0);
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    g();
    ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).jdField_a_of_type_Boolean = false;
    l();
    if ((this.jdField_c_of_type_Boolean) && (AIOUtils.o) && (!this.d))
    {
      super.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      this.d = true;
    }
  }
  
  void g()
  {
    String str;
    int k;
    Object localObject1;
    if (this.jdField_a_of_type_Int == 1)
    {
      str = AppConstants.DATALINE_IPAD_UIN;
      k = 6003;
      localObject1 = null;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      }
      localObject2 = a();
      if ((!StringUtil.a((String)localObject2)) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (!StringUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText())))) {
        break label82;
      }
    }
    label82:
    while ((!StringUtil.a((String)localObject2)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (((String)localObject2).equals(String.valueOf(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))))
    {
      return;
      str = AppConstants.DATALINE_PC_UIN;
      k = 6000;
      break;
    }
    Object localObject2 = DraftTextManager.a(this.app);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = str;
      localDraftTextInfo.type = k;
      localDraftTextInfo.text = ((CharSequence)localObject1).toString();
      localDraftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
      ((DraftTextManager)localObject2).a(this.app, localDraftTextInfo);
    }
    for (;;)
    {
      localObject1 = this.app.getMessageFacade();
      localObject2 = ((DraftTextManager)localObject2).a(this.app, str, k);
      if (localObject2 == null) {
        break;
      }
      ((QQMessageFacade)localObject1).a(str, k, "", ((DraftSummaryInfo)localObject2).getSummary(), ((DraftSummaryInfo)localObject2).getTime());
      return;
      ((DraftTextManager)localObject2).a(this.app, str, k);
    }
    ((QQMessageFacade)localObject1).a(str, k, "", "", 0L);
  }
  
  void g(Intent paramIntent)
  {
    int m = paramIntent.getIntExtra("dataline_forward_type", -1);
    int k = 0;
    if (m == -1) {
      label16:
      return;
    }
    paramIntent.getIntExtra("dataline_forward_type", -1);
    long l = paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false)) {
      if (m != 100) {
        break label1526;
      }
    }
    label264:
    label352:
    label362:
    label371:
    label1526:
    for (int n = 0;; n = 1)
    {
      Object localObject1 = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
      Object localObject6;
      Object localObject5;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject6 = paramIntent.getExtras();
        localObject5 = null;
        localObject1 = localObject5;
        if (localObject6 != null)
        {
          localObject6 = ((Bundle)localObject6).getParcelableArrayList("fileinfo_array");
          localObject1 = localObject5;
          if (localObject6 == null) {}
        }
        try
        {
          localObject1 = (ArrayList)localObject6;
          if (localObject1 == null)
          {
            o();
            return;
          }
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            localObject2 = null;
          }
          localObject5 = new ArrayList();
          localObject6 = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = a((ForwardFileInfo)((Iterator)localObject2).next(), false, this.jdField_a_of_type_Int);
            if (localDataLineMsgRecord != null) {
              if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
              {
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(localDataLineMsgRecord);
                ((DataLineHandler)localObject6).a(localArrayList, false);
                k = 1;
              }
            }
            for (;;)
            {
              break;
              ((ArrayList)localObject5).add(localDataLineMsgRecord);
            }
          }
          if (((ArrayList)localObject5).size() <= 0) {
            break label371;
          }
        }
        ((DataLineHandler)localObject6).a((ArrayList)localObject5, false);
      }
      for (;;)
      {
        for (;;)
        {
          if (!this.jdField_b_of_type_Boolean) {
            this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
          }
          boolean bool = paramIntent.getExtras().getBoolean("refuse_show_share_result_dialog", false);
          if ((!this.jdField_b_of_type_Boolean) || (bool)) {
            break;
          }
          paramIntent = paramIntent.getExtras();
          localObject2 = paramIntent.getString("app_name");
          if (l != 0L) {
            break label1513;
          }
          paramIntent = StructMsgFactory.a(paramIntent);
          if ((paramIntent == null) || (!(paramIntent instanceof AbsShareMsg))) {
            break label1516;
          }
          paramIntent = (AbsShareMsg)paramIntent;
          if (paramIntent == null) {
            break label1513;
          }
          l = paramIntent.mSourceAppid;
          a(l, (String)localObject2);
          return;
          if (k == 0)
          {
            o();
            continue;
            localObject5 = ((ArrayList)localObject2).iterator();
            for (k = 0; ((Iterator)localObject5).hasNext(); k = m)
            {
              localObject6 = (String)((Iterator)localObject5).next();
              if (localObject6 != null)
              {
                m = k;
                if (!((String)localObject6).equals("/")) {}
              }
              else
              {
                m = k;
                if (k == 0)
                {
                  m = 1;
                  o();
                }
                ((Iterator)localObject5).remove();
              }
            }
            if (!((ArrayList)localObject2).isEmpty())
            {
              a((ArrayList)localObject2, n);
            }
            else if (k == 0)
            {
              o();
              continue;
              localObject5 = new ArrayList();
              if (a(paramIntent, m)) {
                break;
              }
              switch (m)
              {
              default: 
                StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_other");
                break;
              case 101: 
                StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_image");
                localObject2 = paramIntent.getStringExtra("dataline_forward_path");
                if (localObject2 == null)
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "handleForwardRequest forward image, extras: " + paramIntent.getExtras().toString());
                }
                else
                {
                  localObject6 = ((String)localObject2).split(";");
                  ((ArrayList)localObject5).clear();
                  k = 0;
                  if (k < localObject6.length) {
                    try
                    {
                      if (FileUtils.a(localObject6[k])) {}
                      for (localObject2 = localObject6[k];; localObject2 = URLDecoder.decode(localObject6[k], "UTF-8"))
                      {
                        if (TextUtils.isEmpty((CharSequence)localObject2)) {
                          break label841;
                        }
                        if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://"))) {
                          break label830;
                        }
                        a((String)localObject2);
                        ReportController.b(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                          QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                        }
                        k += 1;
                        break;
                      }
                    }
                    catch (UnsupportedEncodingException paramIntent)
                    {
                      if (!QLog.isColorLevel()) {
                        break label16;
                      }
                      QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[k]);
                      return;
                    }
                    catch (IllegalArgumentException localIllegalArgumentException1)
                    {
                      for (;;)
                      {
                        localObject3 = localObject6[k];
                        continue;
                        ((ArrayList)localObject5).add(localObject3);
                        continue;
                        if (QLog.isColorLevel()) {
                          QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject3);
                        }
                      }
                    }
                  }
                }
                break;
              }
            }
          }
        }
        if (!((ArrayList)localObject5).isEmpty())
        {
          a((ArrayList)localObject5, 1);
          if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
            if (((ArrayList)localObject5).size() > 1)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
              if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
              }
            }
            else if (((ArrayList)localObject5).size() == 1)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
              if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
              }
            }
          }
        }
      }
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_file");
      Object localObject3 = QfavHelper.a(paramIntent.getExtras(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (localObject3 != null)
      {
        paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
        if (paramIntent == null) {
          break label1521;
        }
      }
      for (k = paramIntent.jdField_a_of_type_Int;; k = 0)
      {
        for (;;)
        {
          this.app.getFileManagerEngine().a((FileManagerEntity)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, k);
          return;
          localObject3 = paramIntent.getStringExtra("dataline_forward_path");
          if ((localObject3 == null) || (((String)localObject3).equals("")))
          {
            o();
            return;
          }
          localObject6 = ((String)localObject3).split(";");
          ((ArrayList)localObject5).clear();
          k = 0;
          if (k < localObject6.length) {
            try
            {
              localObject3 = URLDecoder.decode(localObject6[k], "UTF-8");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                {
                  a((String)localObject3);
                  k += 1;
                }
              }
            }
            catch (UnsupportedEncodingException paramIntent)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[k]);
              return;
            }
            catch (IllegalArgumentException localIllegalArgumentException2)
            {
              for (;;)
              {
                localObject4 = localObject6[k];
                continue;
                ((ArrayList)localObject5).add(localObject4);
                continue;
                if (QLog.isColorLevel()) {
                  QLog.e("qqdataline", 2, "shareFromMigSdk|file path invalid. path=" + (String)localObject4);
                }
              }
            }
          }
        }
        if (((ArrayList)localObject5).isEmpty()) {
          break label264;
        }
        a((ArrayList)localObject5, 0);
        if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
          break label264;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
        if (!QLog.isColorLevel()) {
          break label264;
        }
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
        break label264;
        Object localObject4 = paramIntent.getStringExtra("dataline_forward_text");
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          break label264;
        }
        if (Patterns.d.matcher((CharSequence)localObject4).find()) {
          StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_link");
        }
        for (;;)
        {
          a((String)localObject4);
          break;
          StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_text");
        }
        break label362;
        paramIntent = null;
        break label352;
      }
    }
  }
  
  void h()
  {
    int m = 8;
    int n = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this);
    int k = m;
    switch (n)
    {
    default: 
      k = m;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(k);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_b_of_type_Int);
      return;
      k = 6;
      continue;
      k = 6;
    }
  }
  
  protected void h(Intent paramIntent)
  {
    c(paramIntent);
    int k = this.jdField_a_of_type_Int;
    b(paramIntent);
    if (k != this.jdField_a_of_type_Int)
    {
      paramIntent = this.app.getDataLineMsgProxy(this.jdField_a_of_type_Int);
      if (paramIntent != null) {
        break label85;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
      label85:
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramIntent.a(true);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
    }
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b(paramMessage.arg1, paramMessage.arg2);
      continue;
      A();
      continue;
      B();
      d(b());
      continue;
      B();
      C();
      continue;
      QLog.i(jdField_a_of_type_JavaLangString, 2, "progress: " + paramMessage.arg1);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgress(paramMessage.arg1);
    }
  }
  
  void i()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    do
    {
      return;
      str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "photo/");
      localObject = new File(str);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        QQToast.a(this, 2131718859, 0).a();
        return;
      }
    } while (!c());
    String str = str + System.currentTimeMillis() + ".jpg";
    Object localObject = new Intent();
    FileProvider7Helper.setSystemCapture(this, new File(str), (Intent)localObject);
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", str).commit();
    startActivityForResult((Intent)localObject, 5);
  }
  
  void i(Intent paramIntent)
  {
    setLeftViewName(paramIntent);
    String str = this.leftView.getText().toString();
    if (str.contains(getString(2131719718)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4recent");
      j();
    }
    for (;;)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("isBack2Root");
        paramIntent.getExtras().putBoolean("isBack2Root", false);
      }
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("LASTFROM");
        if (str != null)
        {
          this.leftView.setText(str);
          this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
        }
      }
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
      {
        this.jdField_a_of_type_Boolean = true;
        this.leftView.setText(getString(2131719718));
        this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
        j();
      }
      if ((paramIntent != null) && (paramIntent.getIntExtra("dataline_forward_type", -1) != -1))
      {
        if (!this.jdField_b_of_type_Boolean) {
          this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.leftView.setText(getString(2131719718));
          this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
          j();
        }
      }
      if (ChatActivityConstants.jdField_a_of_type_Boolean)
      {
        str = this.leftView.getText().toString();
        paramIntent = str;
        if (!getString(2131690601).equals(str)) {
          paramIntent = HardCodeUtil.a(2131706212) + str + HardCodeUtil.a(2131706215);
        }
        this.leftView.setContentDescription(paramIntent);
      }
      return;
      if (str.contains(getString(2131693918))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4buddylist");
      } else if (str.contains(getString(2131692430))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4dongtai");
      }
    }
  }
  
  void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((localObject == null) || (((String)localObject).startsWith(getString(2131719718)))) {}
    }
    else
    {
      return;
    }
    int k = 0;
    int m = QCallFacade.a(this.app);
    Object localObject = this.app.getMessageFacade();
    if (localObject != null) {
      k = ((QQMessageFacade)localObject).b();
    }
    k += m;
    if (k > 0)
    {
      if (k > 99)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131719718) + "(99+)");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131719718) + "(" + k + ")");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131719718));
  }
  
  void k()
  {
    Object localObject = this.rightViewImg;
    ((ImageView)localObject).setContentDescription(getResources().getText(2131693737));
    ((ImageView)localObject).setVisibility(0);
    ((ImageView)localObject).setImageResource(2130850547);
    ((ImageView)localObject).setOnClickListener(new LiteActivity.21(this));
    if (ChatActivityConstants.jdField_a_of_type_Boolean) {
      this.rightViewImg.setContentDescription(HardCodeUtil.a(2131706218));
    }
    i(getIntent());
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.mLeftBackIcon.setVisibility(0);
      this.leftView.setBackgroundDrawable(null);
    }
    for (localObject = getResources().getColorStateList(2131167031);; localObject = getResources().getColorStateList(2131167030))
    {
      this.centerView.setTextColor((ColorStateList)localObject);
      this.leftView.setTextColor((ColorStateList)localObject);
      return;
      this.mLeftBackIcon.setVisibility(8);
    }
  }
  
  void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.app.getMessageFacade().a(this.jdField_a_of_type_Int).c(localLong.longValue());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgFailedWhenQuesting: session = " + localLong.longValue());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  void m()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130839690);
    localQQToast.d(2000);
    localQQToast.c(2131693817);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void n()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130839690);
    localQQToast.d(2000);
    localQQToast.c(2131693818);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void o()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130839690);
    localQQToast.d(2000);
    localQQToast.c(2131693811);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if (this.jdField_b_of_type_Boolean)
    {
      if (bool)
      {
        l = getIntent().getLongExtra("req_share_id", 0L);
        if (l > 0L) {
          ForwardSdkShareOption.a(this, true, "sendToMyComputer", l);
        }
        return super.onBackEvent();
      }
      long l = getIntent().getLongExtra("res_share_id", 0L);
      if (l > 0L) {
        ForwardSdkShareOption.a(this, true, "shareToQQ", AppShareIDUtil.b(l));
      }
      return super.onBackEvent();
    }
    ApngImage.pauseAll();
    if ((this.jdField_a_of_type_Boolean) || (bool))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    int k = paramView.getId();
    ReportController.b(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    switch (k)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      y();
      continue;
      Intent localIntent = (Intent)paramView.getTag();
      if (localIntent.getExtras().getInt("uintype") == 0)
      {
        String str = localIntent.getExtras().getString("uin");
        if (!ChatActivityUtils.a(this.app, str))
        {
          localIntent.removeExtra("uintype");
          localIntent.putExtra("uintype", 1003);
        }
      }
      localIntent.putExtra("message_box_click", true);
      MediaPlayerManager.a(this.app).a(false);
      startActivity(localIntent);
      paramView.setVisibility(8);
      finish();
      continue;
      ReportController.b(this.app, "dc00898", "", "", "0X8009F36", "0X8009F36", 4, 0, "", "", "", "");
      b(false);
      continue;
      ReportController.b(this.app, "dc00898", "", "", "0X8009F27", "0X8009F27", 4, 0, "", "", "", "");
      v();
      continue;
      if (this.j) {
        b(false);
      }
      y();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    int k = 0;
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt != 100) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "onRequestPermissionsResult error, requestcode:" + paramInt + " grantresult:" + paramArrayOfInt);
    }
    label97:
    for (;;)
    {
      return;
      paramInt = 0;
      if (paramInt < paramArrayOfInt.length) {
        if (paramArrayOfInt[paramInt] != 0) {
          DialogUtil.a(this, paramArrayOfString, paramArrayOfInt);
        }
      }
      for (paramInt = k;; paramInt = 1)
      {
        if (paramInt == 0) {
          break label97;
        }
        i();
        return;
        paramInt += 1;
        break;
      }
    }
  }
  
  void p()
  {
    Object localObject1 = new ArrayList();
    LiteActivity.33 local33 = new LiteActivity.33(this, (List)localObject1);
    LiteActivity.34 local34 = new LiteActivity.34(this);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int n = 0;
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (DataLineMsgSet)localIterator.next();
      int k = 0;
      localObject2 = ((DataLineMsgSet)localObject2).values().iterator();
      int m = n;
      int i2 = i1;
      i1 = i2;
      n = m;
      if (((Iterator)localObject2).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject2).next();
        if ((!DataLineMsgSet.isFileType(localDataLineMsgRecord)) || (localDataLineMsgRecord.isread) || (localDataLineMsgRecord.fileMsgStatus != 1L)) {
          break label263;
        }
        n = m;
        i1 = k;
        if (k == 0)
        {
          i1 = 1;
          n = m + 1;
        }
        ((List)localObject1).add(localDataLineMsgRecord);
        i2 += 1;
        k = i1;
        m = n;
      }
    }
    label263:
    for (;;)
    {
      break;
      if (n >= 3)
      {
        localObject1 = String.format(getString(2131693829), new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
        ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(115);
        DialogUtil.a(this, 230, getString(2131693775), (String)localObject1, 2131690800, 2131693738, local33, local34).show();
      }
      return;
    }
  }
  
  void q()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      if (this.j)
      {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if (this.j)
    {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      ReportController.b(this.app, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 2, 0, "", "", "", "");
      return;
    }
    a(new ArrayList());
    ReportController.b(this.app, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 1, 0, "", "", "", "");
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
  }
  
  protected void t()
  {
    int k = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (k == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(k);
  }
  
  public void u()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(15, 0, 0).sendToTarget();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramObservable, paramObject);
      return;
    }
    new Handler(localLooper).post(new LiteActivity.38(this, paramObservable, paramObject));
  }
  
  public void v()
  {
    this.j = true;
    c(false);
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(this.jdField_a_of_type_AndroidWidgetButton.isEnabled());
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -1;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().width = -1;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(100);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(48);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBottom() });
    localValueAnimator.addUpdateListener(new LiteActivity.53(this));
    localValueAnimator.addListener(new LiteActivity.54(this));
    localValueAnimator.setDuration(100L).setRepeatCount(0);
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */