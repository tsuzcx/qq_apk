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
import android.os.SystemClock;
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
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
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
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationDataline;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationDataline;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
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
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
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
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
  public static String a = "dataline.LiteActivity";
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
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByLiteActivity(this, 2);
    overridePendingTransition(2130771993, 2130771994);
    ReportController.b(this.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
  }
  
  private void B()
  {
    DataLineMsgSetList localDataLineMsgSetList = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
    int k;
    if (localDataLineMsgSetList != null) {
      k = localDataLineMsgSetList.size();
    } else {
      k = 0;
    }
    if (k == 0)
    {
      if (!this.e)
      {
        d(true);
        return;
      }
      d(false);
      return;
    }
    d(false);
  }
  
  private void C()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  private void D()
  {
    LiteActivity.LiteJumpAction localLiteJumpAction = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction;
    if (localLiteJumpAction == null) {
      return;
    }
    localLiteJumpAction.a();
  }
  
  private int a()
  {
    int k = this.jdField_a_of_type_Int;
    if (k == 0) {
      return 1;
    }
    if (k == 1) {
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
    Bitmap localBitmap = null;
    try
    {
      paramString = Shader.TileMode.REPEAT;
      int k = 119;
      Drawable localDrawable = paramContext.getResources().getDrawable(2130839075);
      if ((localDrawable instanceof BitmapDrawable))
      {
        localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
        paramString = ((BitmapDrawable)localDrawable).getTileModeX();
        k = ((BitmapDrawable)localDrawable).getGravity();
      }
      else if ((localDrawable instanceof SkinnableBitmapDrawable))
      {
        localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
        paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
        k = ((SkinnableBitmapDrawable)localDrawable).getGravity();
      }
      if ((localBitmap != null) && (paramString != Shader.TileMode.REPEAT) && (k == 48))
      {
        paramString = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
        paramString.setGravity(k);
        return paramString;
      }
      paramString = paramContext.getResources().getDrawable(2130839075);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiteActivity setAIOBackgroundBmp 2", 2, paramString.getMessage());
      }
      return paramContext.getResources().getDrawable(2130850373);
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiteActivity setAIOBackgroundBmp 1", 2, paramString.getMessage());
      }
    }
    return paramContext.getResources().getDrawable(2130850373);
  }
  
  private View a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = ((PhotoListPanel)View.inflate(this, 2131560943, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setCustomOnClickListener(this);
    Intent localIntent = new Intent();
    String str = this.app.getAccount();
    Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str);
    if (localObject2 != null) {
      localObject1 = ((Friends)localObject2).name;
    }
    localObject2 = this.app.getCustomFaceFilePath(1, str, 0);
    localIntent.putExtra("key_my_uin", str);
    localIntent.putExtra("key_my_nick", (String)localObject1);
    localIntent.putExtra("key_my_head_dir", (String)localObject2);
    localIntent.putExtra("key_disable_presend", true);
    localIntent.putExtra("key_disable_quality_cb", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 50);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 100000002432L);
    localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005F28");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(new LiteActivity.42(this));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OpenPhotolistPanel:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, ((StringBuilder)localObject1).toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  }
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 454	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 460	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +41 -> 61
    //   23: aload 7
    //   25: astore 6
    //   27: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +17 -> 47
    //   33: aload 7
    //   35: astore 6
    //   37: getstatic 462	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   40: iconst_2
    //   41: ldc_w 464
    //   44: invokestatic 467	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload 7
    //   49: ifnull +10 -> 59
    //   52: aload 7
    //   54: invokeinterface 472 1 0
    //   59: aconst_null
    //   60: areturn
    //   61: aload 7
    //   63: astore 6
    //   65: aload 7
    //   67: ldc_w 474
    //   70: invokeinterface 477 2 0
    //   75: istore_2
    //   76: aload 7
    //   78: astore 6
    //   80: aload 7
    //   82: ldc_w 479
    //   85: invokeinterface 482 2 0
    //   90: istore_3
    //   91: aload 7
    //   93: astore 6
    //   95: aload 7
    //   97: invokeinterface 485 1 0
    //   102: pop
    //   103: aload 7
    //   105: astore 6
    //   107: aload 7
    //   109: iload_3
    //   110: invokeinterface 489 2 0
    //   115: lstore 4
    //   117: aload 7
    //   119: astore 6
    //   121: lload 4
    //   123: l2f
    //   124: invokestatic 495	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   127: fcmpl
    //   128: ifle +31 -> 159
    //   131: aload 7
    //   133: astore 6
    //   135: aload_0
    //   136: ldc_w 496
    //   139: invokevirtual 500	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   142: putstatic 502	com/dataline/activities/LiteActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   145: aload 7
    //   147: ifnull +10 -> 157
    //   150: aload 7
    //   152: invokeinterface 472 1 0
    //   157: aconst_null
    //   158: areturn
    //   159: aload 7
    //   161: astore 6
    //   163: aload 7
    //   165: iload_2
    //   166: invokeinterface 503 2 0
    //   171: astore 9
    //   173: aload 7
    //   175: astore 6
    //   177: new 429	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 430	java/lang/StringBuilder:<init>	()V
    //   184: astore 10
    //   186: aload 7
    //   188: astore 6
    //   190: aload 10
    //   192: aload_0
    //   193: invokevirtual 507	com/dataline/activities/LiteActivity:getExternalCacheDir	()Ljava/io/File;
    //   196: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 7
    //   202: astore 6
    //   204: aload 10
    //   206: ldc_w 512
    //   209: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 7
    //   215: astore 6
    //   217: aload 10
    //   219: ldc_w 514
    //   222: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 7
    //   228: astore 6
    //   230: aload 10
    //   232: ldc_w 512
    //   235: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 7
    //   241: astore 6
    //   243: aload 10
    //   245: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: astore 10
    //   250: aload 7
    //   252: astore 6
    //   254: aload 10
    //   256: invokestatic 517	com/dataline/activities/LiteActivity:e	(Ljava/lang/String;)V
    //   259: aload 7
    //   261: astore 6
    //   263: new 429	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 430	java/lang/StringBuilder:<init>	()V
    //   270: astore 11
    //   272: aload 7
    //   274: astore 6
    //   276: aload 11
    //   278: aload 10
    //   280: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 7
    //   286: astore 6
    //   288: aload 11
    //   290: aload 10
    //   292: iconst_1
    //   293: anewarray 519	java/lang/String
    //   296: dup
    //   297: iconst_0
    //   298: aload 9
    //   300: aastore
    //   301: iconst_0
    //   302: aaload
    //   303: invokestatic 523	com/tencent/mobileqq/utils/FileUtils:getUnitFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 436	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 7
    //   312: astore 6
    //   314: aload 11
    //   316: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore 9
    //   321: aload 7
    //   323: astore 6
    //   325: new 525	com/tencent/mm/vfs/VFSFile
    //   328: dup
    //   329: aload 10
    //   331: invokespecial 527	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   334: astore 10
    //   336: aload 7
    //   338: astore 6
    //   340: aload 10
    //   342: invokevirtual 530	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   345: ifne +43 -> 388
    //   348: aload 7
    //   350: astore 6
    //   352: aload 10
    //   354: invokevirtual 533	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   357: ifne +31 -> 388
    //   360: aload 7
    //   362: astore 6
    //   364: aload_0
    //   365: ldc_w 534
    //   368: invokestatic 538	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   371: invokespecial 540	com/dataline/activities/LiteActivity:d	(Ljava/lang/String;)V
    //   374: aload 7
    //   376: ifnull +10 -> 386
    //   379: aload 7
    //   381: invokeinterface 472 1 0
    //   386: aconst_null
    //   387: areturn
    //   388: aload 7
    //   390: astore 6
    //   392: aload 8
    //   394: aload_1
    //   395: invokevirtual 544	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   398: astore_1
    //   399: aload_1
    //   400: ifnonnull +41 -> 441
    //   403: aload 7
    //   405: astore 6
    //   407: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +17 -> 427
    //   413: aload 7
    //   415: astore 6
    //   417: getstatic 462	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   420: iconst_2
    //   421: ldc_w 546
    //   424: invokestatic 467	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: aload 7
    //   429: ifnull +10 -> 439
    //   432: aload 7
    //   434: invokeinterface 472 1 0
    //   439: aconst_null
    //   440: areturn
    //   441: lload 4
    //   443: ldc2_w 547
    //   446: lcmp
    //   447: ifle +163 -> 610
    //   450: aload 7
    //   452: astore 6
    //   454: aload_0
    //   455: iconst_1
    //   456: putfield 550	com/dataline/activities/LiteActivity:h	Z
    //   459: aload 7
    //   461: astore 6
    //   463: new 224	com/tencent/mobileqq/utils/QQCustomDialog
    //   466: dup
    //   467: aload_0
    //   468: ldc_w 551
    //   471: invokespecial 554	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   474: astore 8
    //   476: aload 7
    //   478: astore 6
    //   480: aload 8
    //   482: ldc_w 555
    //   485: invokevirtual 558	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   488: aload 7
    //   490: astore 6
    //   492: aload 8
    //   494: aload_0
    //   495: ldc_w 559
    //   498: invokevirtual 500	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   501: invokevirtual 563	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   504: pop
    //   505: aload 7
    //   507: astore 6
    //   509: aload 8
    //   511: aload_0
    //   512: ldc_w 564
    //   515: invokevirtual 500	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   518: invokevirtual 568	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   521: pop
    //   522: aload 7
    //   524: astore 6
    //   526: aload 8
    //   528: iconst_0
    //   529: invokevirtual 571	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   532: aload 7
    //   534: astore 6
    //   536: aload 8
    //   538: iconst_0
    //   539: invokevirtual 574	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   542: aload 7
    //   544: astore 6
    //   546: aload 8
    //   548: aload_0
    //   549: ldc_w 575
    //   552: invokevirtual 500	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   555: new 577	com/dataline/activities/LiteActivity$44
    //   558: dup
    //   559: aload_0
    //   560: aload_1
    //   561: invokespecial 580	com/dataline/activities/LiteActivity$44:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/io/InputStream;)V
    //   564: invokevirtual 584	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   567: pop
    //   568: aload 7
    //   570: astore 6
    //   572: aload 8
    //   574: aload_0
    //   575: ldc_w 585
    //   578: invokevirtual 500	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   581: new 587	com/dataline/activities/LiteActivity$45
    //   584: dup
    //   585: aload_0
    //   586: aload 9
    //   588: aload_1
    //   589: lload 4
    //   591: invokespecial 590	com/dataline/activities/LiteActivity$45:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   594: invokevirtual 593	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   597: pop
    //   598: aload 7
    //   600: astore 6
    //   602: aload 8
    //   604: invokevirtual 596	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   607: goto +16 -> 623
    //   610: aload 7
    //   612: astore 6
    //   614: aload_0
    //   615: aload 9
    //   617: aload_1
    //   618: lload 4
    //   620: invokespecial 599	com/dataline/activities/LiteActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   623: aload 7
    //   625: ifnull +10 -> 635
    //   628: aload 7
    //   630: invokeinterface 472 1 0
    //   635: aload 9
    //   637: areturn
    //   638: astore 8
    //   640: aload 7
    //   642: astore_1
    //   643: goto +14 -> 657
    //   646: astore_1
    //   647: aconst_null
    //   648: astore 6
    //   650: goto +52 -> 702
    //   653: astore 8
    //   655: aconst_null
    //   656: astore_1
    //   657: aload_1
    //   658: astore 6
    //   660: aload_0
    //   661: iconst_0
    //   662: putfield 601	com/dataline/activities/LiteActivity:g	Z
    //   665: aload_1
    //   666: astore 6
    //   668: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq +18 -> 689
    //   674: aload_1
    //   675: astore 6
    //   677: getstatic 462	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   680: iconst_2
    //   681: ldc_w 603
    //   684: aload 8
    //   686: invokestatic 606	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   689: aload_1
    //   690: ifnull +9 -> 699
    //   693: aload_1
    //   694: invokeinterface 472 1 0
    //   699: aconst_null
    //   700: areturn
    //   701: astore_1
    //   702: aload 6
    //   704: ifnull +10 -> 714
    //   707: aload 6
    //   709: invokeinterface 472 1 0
    //   714: aload_1
    //   715: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	LiteActivity
    //   0	716	1	paramUri	Uri
    //   75	91	2	k	int
    //   90	20	3	m	int
    //   115	504	4	l	long
    //   25	683	6	localObject1	Object
    //   16	625	7	localCursor	android.database.Cursor
    //   4	599	8	localObject2	Object
    //   638	1	8	localException1	Exception
    //   653	32	8	localException2	Exception
    //   171	465	9	str	String
    //   184	169	10	localObject3	Object
    //   270	45	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   27	33	638	java/lang/Exception
    //   37	47	638	java/lang/Exception
    //   65	76	638	java/lang/Exception
    //   80	91	638	java/lang/Exception
    //   95	103	638	java/lang/Exception
    //   107	117	638	java/lang/Exception
    //   121	131	638	java/lang/Exception
    //   135	145	638	java/lang/Exception
    //   163	173	638	java/lang/Exception
    //   177	186	638	java/lang/Exception
    //   190	200	638	java/lang/Exception
    //   204	213	638	java/lang/Exception
    //   217	226	638	java/lang/Exception
    //   230	239	638	java/lang/Exception
    //   243	250	638	java/lang/Exception
    //   254	259	638	java/lang/Exception
    //   263	272	638	java/lang/Exception
    //   276	284	638	java/lang/Exception
    //   288	310	638	java/lang/Exception
    //   314	321	638	java/lang/Exception
    //   325	336	638	java/lang/Exception
    //   340	348	638	java/lang/Exception
    //   352	360	638	java/lang/Exception
    //   364	374	638	java/lang/Exception
    //   392	399	638	java/lang/Exception
    //   407	413	638	java/lang/Exception
    //   417	427	638	java/lang/Exception
    //   454	459	638	java/lang/Exception
    //   463	476	638	java/lang/Exception
    //   480	488	638	java/lang/Exception
    //   492	505	638	java/lang/Exception
    //   509	522	638	java/lang/Exception
    //   526	532	638	java/lang/Exception
    //   536	542	638	java/lang/Exception
    //   546	568	638	java/lang/Exception
    //   572	598	638	java/lang/Exception
    //   602	607	638	java/lang/Exception
    //   614	623	638	java/lang/Exception
    //   6	18	646	finally
    //   6	18	653	java/lang/Exception
    //   27	33	701	finally
    //   37	47	701	finally
    //   65	76	701	finally
    //   80	91	701	finally
    //   95	103	701	finally
    //   107	117	701	finally
    //   121	131	701	finally
    //   135	145	701	finally
    //   163	173	701	finally
    //   177	186	701	finally
    //   190	200	701	finally
    //   204	213	701	finally
    //   217	226	701	finally
    //   230	239	701	finally
    //   243	250	701	finally
    //   254	259	701	finally
    //   263	272	701	finally
    //   276	284	701	finally
    //   288	310	701	finally
    //   314	321	701	finally
    //   325	336	701	finally
    //   340	348	701	finally
    //   352	360	701	finally
    //   364	374	701	finally
    //   392	399	701	finally
    //   407	413	701	finally
    //   417	427	701	finally
    //   454	459	701	finally
    //   463	476	701	finally
    //   480	488	701	finally
    //   492	505	701	finally
    //   509	522	701	finally
    //   526	532	701	finally
    //   536	542	701	finally
    //   546	568	701	finally
    //   572	598	701	finally
    //   602	607	701	finally
    //   614	623	701	finally
    //   660	665	701	finally
    //   668	674	701	finally
    //   677	689	701	finally
  }
  
  private String a(String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyForwardImageFile:error. filePath[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return paramString;
    }
    Object localObject1 = FileManagerUtil.a(paramString);
    long l = FileUtils.getFileSizes(paramString);
    if (l > 3145728L)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyForwardImageFile:error. fileSize[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return paramString;
    }
    if ((float)l > FileUtils.getAvailableExternalMemorySize())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "copyForwardImageFile:error. file space not enough");
      return paramString;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FMSettings.a().getDefaultRecvPath());
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = FileManagerUtil.b(((StringBuilder)localObject2).toString());
    localObject1 = paramString;
    if (FileUtils.copyFile(paramString, (String)localObject2)) {
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public static void a(Context paramContext)
  {
    LiteActivity.18 local18 = new LiteActivity.18();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131719632), paramContext.getString(2131693716), 2131693700, 2131693700, local18, null).show();
  }
  
  private void a(View paramView)
  {
    VideoReport.setPageId(paramView, "pg_aio");
    HashMap localHashMap = new HashMap();
    VideoReport.resetPageParams(paramView);
    localHashMap.put("type_aio_pg", String.valueOf(5));
    VideoReport.setPageParams(paramView, new PageParams(localHashMap));
    VideoReport.setPageContentId(paramView, String.valueOf(SystemClock.elapsedRealtime()), true);
  }
  
  static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131370180);
    if (ThemeUtil.isInNightMode(paramIphoneTitleBarActivity.app))
    {
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup)
  {
    Object localObject = paramIphoneTitleBarActivity.app.getCurrentAccountUin();
    int k = 0;
    localObject = ChatBackgroundUtil.a(paramIphoneTitleBarActivity, (String)localObject, 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.DATALINE_PC_UIN;
    arrayOfString[1] = "chat_uniform_bg";
    if ((((SharedPreferences)localObject).getString(arrayOfString[0], null) == null) && (((SharedPreferences)localObject).getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int m = arrayOfString.length;
    while (k < m)
    {
      String str = ((SharedPreferences)localObject).getString(arrayOfString[k], null);
      if (str != null) {
        if ((!"".equals(str)) && (!"null".equals(str)) && (!"none".equals(str)))
        {
          if (!new VFSFile(str).exists())
          {
            a(paramIphoneTitleBarActivity, paramViewGroup, "null");
            return;
          }
          if (!a(paramIphoneTitleBarActivity, paramViewGroup, str)) {}
        }
        else
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, str);
          return;
        }
      }
      k += 1;
    }
    a(paramIphoneTitleBarActivity, paramViewGroup, "null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    a(paramString, paramContext, new LiteActivity.19(paramQQAppInterface, paramString));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt, String paramString)
  {
    StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_save2weiyun");
    long l = FileUtils.getFileSizes(paramString);
    String str = FileManagerUtil.a(paramString);
    Object localObject;
    if (paramDataLineMsgRecord.nWeiyunSessionId != 0L) {
      localObject = this.app.getFileManagerDataCenter().a(paramDataLineMsgRecord.nWeiyunSessionId);
    } else {
      localObject = null;
    }
    if ((FileManagerUtil.a()) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      if (FreeWifiHelper.a(getActivity(), 5, new LiteActivity.55(this, paramDataLineMsgRecord, (FileManagerEntity)localObject, str, paramString))) {
        FMDialogUtil.a(getActivity(), 2131692561, 2131692564, new LiteActivity.56(this, paramDataLineMsgRecord, (FileManagerEntity)localObject, str, paramString));
      }
    }
    else if (localObject == null)
    {
      k = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileManagerUtil.c(str));
      ((StringBuilder)localObject).append(getString(2131692688));
      FMToastUtil.b(((StringBuilder)localObject).toString());
      paramDataLineMsgRecord.nWeiyunSessionId = this.app.getFileManagerEngine().a(paramString, null, this.app.getAccount(), 0, false).nSessionId;
      this.app.getMessageFacade().a(k).d(paramDataLineMsgRecord.msgId);
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append(FileManagerUtil.c(str));
      paramString.append(getString(2131692688));
      FMToastUtil.b(paramString.toString());
      this.app.getFileManagerEngine().a(paramDataLineMsgRecord.nWeiyunSessionId);
    }
    int k = 4;
    if (paramInt == -2000)
    {
      paramInt = 1;
    }
    else if (paramInt == -2005)
    {
      int m = FileManagerUtil.a(paramDataLineMsgRecord.filename);
      if (m == 0)
      {
        paramInt = 2;
      }
      else
      {
        paramInt = k;
        if (m == 2) {
          paramInt = 3;
        }
      }
    }
    else
    {
      paramInt = 4;
    }
    k = a();
    paramDataLineMsgRecord = this.app;
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(k);
    ReportController.b(paramDataLineMsgRecord, "dc00898", "", "", "0X800AD60", "0X800AD60", paramInt, 0, paramString.toString(), "", "", "");
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet)
  {
    String str = null;
    Object localObject1;
    if (paramDataLineMsgSet == null) {
      localObject1 = str;
    }
    do
    {
      for (;;)
      {
        k = 1;
        break label57;
        localObject2 = paramDataLineMsgSet.values();
        localObject1 = str;
        if (localObject2 != null)
        {
          if (((ArrayList)localObject2).size() != 0) {
            break;
          }
          localObject1 = str;
        }
      }
      localObject1 = paramDataLineMsgSet.getFirstItem();
    } while (localObject1 == null);
    int k = 0;
    label57:
    if (k != 0)
    {
      QQToast.a(getApplicationContext(), getString(2131694906), 0).b(getResources().getDimensionPixelSize(2131299168));
      return;
    }
    paramDataLineMsgSet = new MessageForPic();
    paramDataLineMsgSet.size = ((DataLineMsgRecord)localObject1).filesize;
    paramDataLineMsgSet.senderuin = ((DataLineMsgRecord)localObject1).senderuin;
    paramDataLineMsgSet.selfuin = this.app.getAccount();
    paramDataLineMsgSet.frienduin = ((DataLineMsgRecord)localObject1).frienduin;
    paramDataLineMsgSet.time = ((DataLineMsgRecord)localObject1).time;
    paramDataLineMsgSet.issend = ((DataLineMsgRecord)localObject1).issend;
    paramDataLineMsgSet.uuid = ((DataLineMsgRecord)localObject1).serverPath;
    paramDataLineMsgSet.busiType = ((DataLineMsgRecord)localObject1).busId;
    paramDataLineMsgSet.istroop = 7;
    paramDataLineMsgSet.subVersion = 5;
    paramDataLineMsgSet.path = ((DataLineMsgRecord)localObject1).path;
    str = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("savePicsAsCustomFace, path:");
    ((StringBuilder)localObject2).append(paramDataLineMsgSet.path);
    ((StringBuilder)localObject2).append(" uuid:");
    ((StringBuilder)localObject2).append(paramDataLineMsgSet.uuid);
    ((StringBuilder)localObject2).append(" size:");
    ((StringBuilder)localObject2).append(paramDataLineMsgSet.size);
    QLog.i(str, 1, ((StringBuilder)localObject2).toString());
    if ((FileUtils.fileExists(paramDataLineMsgSet.path)) && (((DataLineMsgRecord)localObject1).md5 == null))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "savePicsAsCustomFace, calc md5!");
      ThreadManager.executeOnSubThread(new LiteActivity.30(this, paramDataLineMsgSet));
      return;
    }
    paramDataLineMsgSet.md5 = HexUtil.bytes2HexStr(((DataLineMsgRecord)localObject1).md5);
    a(paramDataLineMsgSet);
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet, DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    a(paramDataLineMsgSet);
    if ((paramInt != -2000) && (paramInt == -2005))
    {
      if (FileManagerUtil.a(paramDataLineMsgRecord.filename) == 0) {
        paramInt = 3;
      } else {
        paramInt = 2;
      }
    }
    else {
      paramInt = 1;
    }
    int k = a();
    paramDataLineMsgSet = this.app;
    paramDataLineMsgRecord = new StringBuilder();
    paramDataLineMsgRecord.append("");
    paramDataLineMsgRecord.append(k);
    ReportController.b(paramDataLineMsgSet, "dc00898", "", "", "0X800AD61", "0X800AD61", paramInt, 0, paramDataLineMsgRecord.toString(), "", "", "");
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null)
    {
      QQToast.a(getApplicationContext(), getString(2131694906), 0).b(getResources().getDimensionPixelSize(2131299168));
      return;
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePicsAsCustomFace, md5:");
    localStringBuilder.append(paramMessageForPic.md5);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(paramMessageForPic, 1, "datalineface"), -1, -1, null, null, false);
    ((URLDrawable)localObject).setTag(paramMessageForPic);
    AIOGalleryUtils.a(this, this.app, (URLDrawable)localObject, paramMessageForPic.frienduin, getResources().getDimensionPixelSize(2131299168), null, paramMessageForPic.picExtraData);
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
      paramScrollerRunnable.a(paramInt, -1, null, 3, false);
    }
    catch (SecurityException paramScrollerRunnable)
    {
      break label24;
    }
    catch (IllegalArgumentException paramScrollerRunnable)
    {
      label16:
      break label16;
    }
    paramXListView.setSelection(paramInt);
    break label29;
    label24:
    paramXListView.setSelection(paramInt);
    label29:
    paramXListView.setTranscriptMode(1);
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
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131691299), HardCodeUtil.a(2131706267), new LiteActivity.47(this));
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new LiteActivity.48(this));
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    String str = (String)paramViewGroup.getTag(2131361813);
    if ((paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString)))
    {
      if ("none".equals(paramString))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131361813, "null");
      }
      else if (!paramString.equals(str))
      {
        a(paramString, new LiteActivity.14(paramIphoneTitleBarActivity, paramString, paramViewGroup));
      }
    }
    else if (!"null".equals(str))
    {
      paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
      paramViewGroup.setTag(2131361813, "null");
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong == 0L) {
      return true;
    }
    paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramLong);
    if (paramQQAppInterface == null) {
      return true;
    }
    if ((paramQQAppInterface.getCloudType() != 2) && (paramQQAppInterface.status == 1)) {
      return false;
    }
    if (paramQQAppInterface.nOpType != 6) {
      return false;
    }
    return paramQQAppInterface.status != 1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    return a(paramQQAppInterface, paramDataLineMsgRecord.nWeiyunSessionId);
  }
  
  public static void b(Context paramContext)
  {
    LiteActivity.50 local50 = new LiteActivity.50();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131719632), paramContext.getString(2131693725), 2131693700, 2131693700, local50, null).show();
  }
  
  private boolean c()
  {
    int k = Build.VERSION.SDK_INT;
    boolean bool1 = true;
    boolean bool2 = true;
    if (k >= 23) {}
    for (;;)
    {
      try
      {
        k = checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        if (k == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool1) {
          try
          {
            k = checkSelfPermission("android.permission.CAMERA");
            if (k == 0) {
              bool1 = true;
            }
          }
          catch (Exception localException1)
          {
            continue;
          }
        }
        bool1 = false;
        if ((!bool1) || (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)) {
          break label170;
        }
        bool2 = true;
        if (!bool2)
        {
          bool1 = bool2;
          requestPermissions(this, 100, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE" });
        }
        return bool2;
      }
      catch (Exception localException2)
      {
        bool1 = bool2;
        localException2.printStackTrace();
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkPermissions exception:");
        localStringBuilder.append(localException2);
        QLog.e(str, 2, localStringBuilder.toString());
      }
      return bool1;
      label170:
      bool2 = false;
    }
  }
  
  private void d(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    localQQCustomDialog.setTitle(getString(2131719632));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(getString(2131690706), new LiteActivity.49(this));
    localQQCustomDialog.show();
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691375);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839551);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  private static void e(String paramString)
  {
    paramString = new VFSFile(paramString);
    if (!paramString.exists()) {
      return;
    }
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
  
  private void w()
  {
    VideoReport.addToDetectionWhitelist(this);
    a(getWindow().getDecorView());
  }
  
  @TargetApi(19)
  private void x()
  {
    this.i = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131380356));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if (!this.i) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.mContentView);
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    localQQBlurView.b(localQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDirtyListener(new LiteActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new LiteActivity.3(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void y()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(QQToast.a(1));
    localQQToast.b(1);
    localQQToast.d(2000);
    localQQToast.c(2131693908);
    localQQToast.a();
  }
  
  private void z()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktxt");
      a(new QQText(str, 13, 32, 6000).toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    }
  }
  
  public float a()
  {
    return this.mDensity;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 4)
    {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 23) {
        bool = PermissionUtils.isStorePermissionEnable(this);
      } else {
        bool = true;
      }
      if (!bool) {
        requestPermissions(new LiteActivity.41(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      } else {
        return a();
      }
    }
    return null;
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
    if (localFileManagerEntity == null) {
      return null;
    }
    int n = DataLineHandler.a(localFileManagerEntity);
    if (!DataLineHandler.d(n)) {
      return null;
    }
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
    if (TextUtils.isEmpty(paramForwardFileInfo.a()))
    {
      localDataLineMsgRecord.path = paramForwardFileInfo.d();
      return localDataLineMsgRecord;
    }
    localDataLineMsgRecord.path = paramForwardFileInfo.a();
    return localDataLineMsgRecord;
  }
  
  String a()
  {
    String str;
    int k;
    if (this.jdField_a_of_type_Int == 1)
    {
      str = AppConstants.DATALINE_IPAD_UIN;
      k = 6003;
    }
    else
    {
      str = AppConstants.DATALINE_PC_UIN;
      k = 6000;
    }
    return DraftTextManager.a(this.app).a(this.app, str, k);
  }
  
  public void a()
  {
    Object localObject;
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377646);
      ((View)localObject).setBackgroundResource(2130839086);
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(true, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377646).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.j) {
      b(true);
    }
    AIOUtils.o = true;
    paramInt = Integer.valueOf(paramInt).intValue();
    if (paramInt == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 16)
        {
          if (paramInt != 17) {
            return;
          }
          if (!a())
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
            }
          }
          else
          {
            f();
            ReportController.b(null, "CliOper", "", "", MpFileConstant.i, MpFileConstant.i, 0, 0, "", "", "", "");
            localObject = new Bundle();
            ((Bundle)localObject).putBoolean("string_from", false);
            ((Bundle)localObject).putBoolean("string_uin", false);
            ((Bundle)localObject).putLong("device_din", 0L);
            ((Bundle)localObject).putInt("sTitleID", 0);
            QQProxyForDataline.a(this, (Bundle)localObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
          }
          ReportController.b(this.app, "dc00898", "", "", "0X800AD67", "0X800AD67", 0, 0, "", "", "", "");
          return;
        }
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckfile");
        if (!CheckPermission.isHasStoragePermission(this))
        {
          CheckPermission.requestSDCardPermission(this, new LiteActivity.40(this));
          return;
        }
        A();
        ReportController.b(this.app, "dc00898", "", "", "0X800AD66", "0X800AD66", 0, 0, "", "", "", "");
        return;
      }
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktkphoto");
      i();
      ReportController.b(this.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00898", "", "", "0X800AD65", "0X800AD65", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    if ((localObject != null) && (((PhotoListPanel)localObject).getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X800AD64", "0X800AD64", 0, 0, "", "", "", "");
    getIntent().putExtra("qq_sub_business_id", 107);
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject1 != null)
    {
      ((QQCustomDialog)localObject1).show();
      return;
    }
    Object localObject2 = getString(2131718866);
    localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramString = new LiteActivity.12(this, paramLong);
    localObject2 = new LiteActivity.13(this, paramLong, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 232, null, this.app.getApplication().getString(2131718872), (String)localObject1, this.app.getApplication().getString(2131718867), paramString, (DialogInterface.OnClickListener)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramIntent.getAction())) {
        return;
      }
      if ((!paramIntent.getAction().equals("android.intent.action.SEND")) && (!paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))
      {
        if ((paramIntent.getAction().equals("android.intent.action.MAIN")) && (paramIntent.getBooleanExtra("system_share_multi_send", false))) {
          this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
        }
      }
      else {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
      }
    }
  }
  
  void a(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      FMToastUtil.a(2131694475);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      localObject1 = getString(2131692566);
    }
    else if (localDataLineMsgSet.getGroupType() == -1000)
    {
      localObject1 = getString(2131693769);
    }
    else if ((localDataLineMsgSet.getGroupType() == -2000) && (!localDataLineMsgSet.isSingle()))
    {
      localObject1 = localDataLineMsgSet.values().iterator();
      int k = 0;
      while (((Iterator)localObject1).hasNext()) {
        if (DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
          k += 1;
        }
      }
      localObject1 = String.format(getString(2131693741), new Object[] { Integer.valueOf(k) });
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (((String)localObject1).equals("")) {
      localObject2 = getString(2131693768);
    }
    Object localObject1 = (ActionSheet)ActionSheetHelper.a(this, null);
    ((ActionSheet)localObject1).setMainTitle((CharSequence)localObject2);
    ((ActionSheet)localObject1).addButton(getResources().getString(2131692734), 1);
    ((ActionSheet)localObject1).addCancelButton(2131690728);
    ((ActionSheet)localObject1).setOnButtonClickListener(new LiteActivity.24(this, localDataLineMsgSet, paramItemHolder, (ActionSheet)localObject1));
    ((ActionSheet)localObject1).show();
  }
  
  void a(com.tencent.imcore.message.Message paramMessage)
  {
    if ((paramMessage != null) && (!paramMessage.isread) && (!paramMessage.isSendFromLocal()) && (!this.app.isTroopMark(paramMessage)) && (!this.j))
    {
      if (HiddenChatHelper.a(paramMessage.frienduin, paramMessage.istroop, this.app)) {
        return;
      }
      Intent localIntent = this.app.getIntentByMessage(this, paramMessage, false);
      if (9002 == paramMessage.istroop) {
        localIntent.putExtra("af_key_from", 2);
      }
      runOnUiThread(new LiteActivity.36(this, paramMessage, localIntent));
    }
  }
  
  void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.length() > 4500)
    {
      QQToast.a(this, HardCodeUtil.a(2131706264), 1).b(getTitleBarHeight());
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
    if (!b())
    {
      b(null);
      return;
    }
    int k = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.app.getMessageFacade().a(k).a(paramLong);
    if (localDataLineMsgRecord == null) {
      return;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          this.app.getMessageFacade().a(k).a(paramLong);
          a(paramString);
        }
        else
        {
          if (FileUtils.fileExists(paramString)) {
            localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 0, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
          }
          if (localDataLineMsgRecord.nOpType == 35) {
            localDataLineHandler.b(localDataLineMsgRecord);
          } else {
            localDataLineHandler.a().a(localDataLineMsgRecord, k, 2);
          }
        }
      }
      else {
        localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 2, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      }
    }
    else {
      localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 1, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
    }
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putExtra("peakconstant.request_code", 55);
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent.putExtra("PhotoConst.is_troop_send_mixed_msg", false);
    localIntent.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
    localIntent.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", true);
    localIntent.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("enter_from", 40);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationDataline.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationDataline.jdField_a_of_type_JavaLangString);
    int k = PlusPanelUtils.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, localIntent, localActivityURIRequest);
    localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "");
    localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "");
    localActivityURIRequest.extra().putInt(AlbumConstants.h, 55);
    localActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localActivityURIRequest.extra().putBoolean("PhotoConst.original_button", true);
    if (k != -1)
    {
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.a();
        if (paramArrayList != null) {
          localActivityURIRequest.extra().putSerializable("PhotoConst.editPathMap", paramArrayList);
        }
      }
      localActivityURIRequest.setRequestCode(k);
    }
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this, false, true);
    if (PeakUtils.a != null) {
      PeakUtils.a.b();
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
        l += new VFSFile(str).length();
      }
    }
    if (l == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.isNetworkAvailable(this)) && (!NetworkUtil.isWifiConnected(this)) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this, 2131692561, 2131692566, new LiteActivity.17(this, local16, paramInt));
      return;
    }
    local16.execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
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
    if (!localArrayList1.isEmpty())
    {
      paramList = new Bundle();
      paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList1);
      new LiteActivity.SendVideoAsyncTask(this).execute(new Bundle[] { paramList });
    }
  }
  
  void a(Observable paramObservable, Object paramObject)
  {
    j();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      int k = DataLineMsgRecord.getDevTypeBySeId(paramObservable.sessionid);
      DataLineMsgSet localDataLineMsgSet = this.app.getDataLineMsgProxy(k).a(paramObservable.sessionid);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SessionID:");
        localStringBuilder.append(paramObservable.sessionid);
        localStringBuilder.append(", Show:");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("AutoTest_Xandy", 4, localStringBuilder.toString());
      }
      if ((!DataLineMsgSet.isSingle(paramObservable)) && (localDataLineMsgSet != null) && (localDataLineMsgSet.getComeCount() > 1))
      {
        if (!this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(paramObservable.sessionid, this.jdField_a_of_type_ComTencentWidgetXListView)) {
          this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
        }
      }
      else {
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    else if ((paramObject instanceof com.tencent.imcore.message.Message))
    {
      paramObservable = (com.tencent.imcore.message.Message)paramObject;
      if (paramObservable.frienduin == null) {
        return;
      }
      if (paramObservable.frienduin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    else if ((paramObject instanceof RecentUser))
    {
      paramObservable = (RecentUser)paramObject;
      if (paramObservable.uin == null) {
        return;
      }
      if (paramObservable.uin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      }
    }
    if ((paramObject instanceof ChatMessage))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal())
      {
        if (paramObservable.msgtype == -1004) {
          return;
        }
        paramObject = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((!paramObservable.isread) && (!paramObject.b(paramObservable.frienduin))) {
          a(this.app.getMessageFacade().a());
        }
      }
    }
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
    long l;
    if (Build.VERSION.SDK_INT >= 18) {
      l = new StatFs(AppConstants.SDCARD_ROOT).getAvailableBytes();
    } else {
      l = new StatFs(AppConstants.SDCARD_ROOT).getAvailableBlocks() * new StatFs(AppConstants.SDCARD_ROOT).getBlockSize();
    }
    if (l < paramLong)
    {
      m();
      return false;
    }
    return true;
  }
  
  boolean a(Intent paramIntent, int paramInt)
  {
    paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (paramIntent == null) {
      return false;
    }
    Object localObject = this.app.getFileManagerDataCenter().a(paramIntent.b());
    if (localObject == null) {
      return false;
    }
    int k = DataLineHandler.a((FileManagerEntity)localObject);
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            paramIntent = jdField_a_of_type_JavaLangString;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("forwardFile fileFrom ");
            ((StringBuilder)localObject).append(k);
            ((StringBuilder)localObject).append(" is not handled");
            QLog.w(paramIntent, 1, ((StringBuilder)localObject).toString());
            return false;
          }
          boolean bool;
          if (paramInt == 101) {
            bool = true;
          } else {
            bool = false;
          }
          paramIntent = a(paramIntent, bool, this.jdField_a_of_type_Int);
          if (paramIntent == null) {
            return false;
          }
          ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramIntent, false);
          return true;
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          this.app.getFileManagerEngine().a(paramIntent.b(), paramIntent.e(), paramIntent.a(), Long.parseLong(this.app.getCurrentAccountUin()), 7, paramIntent.a());
          return true;
        }
        this.app.getFileManagerEngine().a(paramIntent.b(), paramIntent.e(), paramIntent.a(), Long.parseLong(this.app.getCurrentAccountUin()), 6003, paramIntent.a());
        return true;
      }
      this.app.getFileManagerEngine().a(3, paramIntent.b(), this.jdField_a_of_type_Int);
      return true;
    }
    return false;
  }
  
  boolean a(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localObject1 != null) && (((BubblePopupWindow)localObject1).isShowing())) {
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
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    int k = localDataLineMsgSet.getGroupType();
    boolean bool;
    if (localDataLineMsgSet.isSingle())
    {
      m = localDataLineMsgSet.getGroupType();
      Object localObject3;
      String str;
      if ((m != -2335) && (m != -2009) && (m != -2005))
      {
        if (m != -2000)
        {
          if (m != -1000)
          {
            localObject2 = "";
            localObject1 = null;
          }
          else
          {
            localObject1 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
            localQQCustomMenu.a(2131365254, paramView.getContext().getString(2131691294), 2130838903);
            localQQCustomMenu.a(2131367180, paramView.getContext().getString(2131692644), 2130838912);
            localQQCustomMenu.a(2131366494, paramView.getContext().getString(2131692184), 2130838911);
            localObject2 = "";
          }
        }
        else
        {
          localObject3 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
          str = localDataLineMsgRecord.path;
          localObject1 = localObject3;
          localObject2 = str;
          if (AIOUtils.a(1) == 1)
          {
            localObject1 = localObject3;
            localObject2 = str;
            if (FileUtils.fileExistsAndNotEmpty(localDataLineMsgRecord.path))
            {
              localObject1 = localObject3;
              localObject2 = str;
              if (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0)
              {
                localQQCustomMenu.a(2131362241, getString(2131693248), 2130838910);
                localObject1 = localObject3;
                localObject2 = str;
              }
            }
          }
        }
      }
      else
      {
        if (localDataLineMsgRecord.bIsMoloImage)
        {
          localObject1 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        else
        {
          localObject2 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = (RelativeLayout)localItemHolder.a().jdField_a_of_type_AndroidViewView;
          }
        }
        localObject2 = localDataLineMsgRecord.path;
      }
      if (localObject1 == null) {
        return false;
      }
      Context localContext = ((RelativeLayout)localObject1).getContext();
      if (localDataLineMsgRecord.canForward()) {
        localQQCustomMenu.a(2131367180, localContext.getString(2131693726), 2130838912);
      }
      if ((FileUtils.fileExistsAndNotEmpty((String)localObject2)) && (localDataLineMsgRecord.strMoloKey == null))
      {
        if (localDataLineMsgSet.getGroupType() == -2005)
        {
          bool = TencentDocConvertConfigProcessor.a().c();
          long l = FileManagerUtil.b(localDataLineMsgRecord.filename);
          str = TencentDocImportFileInfoProcessor.a().c();
          localObject3 = str;
          if (TextUtils.isEmpty(str)) {
            localObject3 = ".doc|.docx|.xls|.xlsx|";
          }
          if ((bool) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport((String)localObject2, localDataLineMsgRecord.filename, (String)localObject3)) && (localDataLineMsgRecord.filesize <= l))
          {
            ReportController.b(this.app, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
            localQQCustomMenu.a(2131378344, paramView.getContext().getString(2131719531), 2130838924);
          }
        }
        if (localDataLineMsgSet.getGroupType() == -2000) {
          localQQCustomMenu.a(2131366494, paramView.getContext().getString(2131692184), 2130838911);
        } else if ((localDataLineMsgSet.getGroupType() == -2009) && (FileUtils.fileExistsAndNotEmpty((String)localObject2))) {
          localQQCustomMenu.a(2131366494, paramView.getContext().getString(2131692184), 2130838911);
        } else if ((localDataLineMsgSet.getGroupType() == -2005) && (FileUtils.fileExistsAndNotEmpty((String)localObject2))) {
          localQQCustomMenu.a(2131366494, paramView.getContext().getString(2131692184), 2130838911);
        }
        if (a(this.app, localDataLineMsgRecord)) {
          localQQCustomMenu.a(2131380274, localContext.getString(2131692339), 2130838925);
        }
      }
      paramView = (View)localObject2;
    }
    else
    {
      m = localDataLineMsgSet.getGroupType();
      if ((m != -2335) && (m != -2009) && (m != -2005))
      {
        if (m != -2000) {
          paramView = null;
        } else {
          paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
      }
      else if (localDataLineMsgRecord.bIsMoloImage) {
        paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      } else {
        paramView = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      }
      if (paramView == null) {
        return false;
      }
      localObject2 = "";
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    localObject1 = ((RelativeLayout)localObject1).getContext();
    localQQCustomMenu.a(2131365489, ((Context)localObject1).getString(2131693709), 2130838907);
    if ((localDataLineMsgSet.getGroupType() != -2000) && ((localDataLineMsgSet.getGroupType() != -2335) || (!localDataLineMsgRecord.bIsMoloImage))) {
      bool = false;
    } else {
      bool = true;
    }
    localObject1 = new LiteActivity.29(this, localDataLineMsgRecord, localDataLineMsgSet, (Context)localObject1, k, paramView, bool);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
    if (localObject2 != null)
    {
      paramView = new int[2];
      ((InputLinearLayout)localObject2).getLocationInWindow(paramView);
    }
    else
    {
      paramView = null;
    }
    localObject2 = localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
    k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x;
    int m = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
    if (paramView == null) {
      paramView = null;
    } else {
      paramView = Integer.valueOf(paramView[1]);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a((View)localObject2, k, m, localQQCustomMenu, (View.OnClickListener)localObject1, paramView);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setOnDismissListener(new LiteActivity.1DissmissListener(this));
    return true;
  }
  
  public boolean a(PhotoListPanel paramPhotoListPanel)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAlbumBtnClicked");
    }
    ArrayList localArrayList = null;
    if (!paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      localArrayList = new ArrayList(paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList);
    }
    a(localArrayList);
    paramPhotoListPanel.h();
    ReportController.b(null, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
    return true;
  }
  
  public boolean a(Object paramObject)
  {
    int k = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onPanelIconLongClick panelID=");
      paramObject.append(k);
      QLog.d("XPanel", 2, paramObject.toString());
    }
    if (k != 4) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      k = 0;
    } else {
      k = 1;
    }
    if (k == 0)
    {
      requestPermissions(new LiteActivity.39(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return true;
    }
    r();
    return true;
  }
  
  protected String b()
  {
    String str2 = jdField_c_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = getString(2131719013);
    }
    return str1;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370176));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter);
    View localView = LayoutInflater.from(this).inflate(2131558901, null);
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
    } else if (1 == paramInt2) {
      this.e = true;
    }
    B();
  }
  
  protected void b(Intent paramIntent)
  {
    int k = this.jdField_a_of_type_Int;
    String str1 = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("targetUin");
    String str2 = this.jdField_b_of_type_JavaLangString;
    if ((str2 != null) && (str2.length() != 0))
    {
      if (this.jdField_b_of_type_JavaLangString.equals(AppConstants.DATALINE_IPAD_UIN))
      {
        setTitle(2131693780);
        this.jdField_a_of_type_Int = 1;
      }
      else
      {
        setTitle(2131693779);
        this.jdField_a_of_type_Int = 0;
      }
    }
    else if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("device_type", -1);
      if (this.jdField_a_of_type_Int == 1)
      {
        setTitle(2131693780);
        this.jdField_b_of_type_JavaLangString = AppConstants.DATALINE_IPAD_UIN;
      }
      else
      {
        setTitle(2131693779);
        this.jdField_b_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
        this.jdField_a_of_type_Int = 0;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = k;
      this.jdField_b_of_type_JavaLangString = str1;
    }
    paramIntent = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    paramIntent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramIntent.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  void b(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      FMToastUtil.a(2131694475);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 3145728L)) {
      paramItemHolder = getString(2131692563);
    } else {
      paramItemHolder = "";
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = localDataLineMsgSet.values().iterator();
    long l = 0L;
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
      if ((localDataLineMsgSet.getGroupType() != -2000) && ((localDataLineMsgSet.getGroupType() != -2335) || (!localDataLineMsgSet.getFirstItem().bIsMoloImage))) {
        paramItemHolder = String.format(getString(2131693750), new Object[] { Integer.valueOf(k) });
      } else {
        paramItemHolder = String.format(getString(2131693738), new Object[] { Integer.valueOf(k) });
      }
      localObject = new LiteActivity.25(this);
      DialogUtil.a(this, 230, getString(2131693728), paramItemHolder, 2131694583, 2131694583, null, (DialogInterface.OnClickListener)localObject).show();
      return;
    }
    localObject = paramItemHolder;
    if (paramItemHolder.equals(""))
    {
      localObject = paramItemHolder;
      if (localDataLineMsgSet.getGroupType() == -2000)
      {
        localObject = paramItemHolder;
        if (!localDataLineMsgSet.isSingle()) {
          localObject = String.format(getString(2131693740), new Object[] { Integer.valueOf(localArrayList.size()) });
        }
      }
    }
    paramItemHolder = (ItemHolder)localObject;
    if (((String)localObject).equals("")) {
      paramItemHolder = getString(2131693766);
    }
    localObject = (ActionSheet)ActionSheetHelper.a(this, null);
    ((ActionSheet)localObject).setMainTitle(paramItemHolder);
    ((ActionSheet)localObject).addButton(getResources().getString(2131692733), 1);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new LiteActivity.26(this, l, localDataLineMsgSet, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
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
    if (paramArrayList == null) {
      return;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    for (;;)
    {
      int m = paramArrayList.size();
      if (m <= 3)
      {
        k = 0;
        while (k < m)
        {
          localObject1 = a(localDataLineHandler, (SendInfo)paramArrayList.get(k), paramInt, 0, 0, 0);
          if (localObject1 != null) {
            localDataLineHandler.a((DataLineMsgRecord)localObject1, false);
          }
          k += 1;
        }
      }
      DataLineMsgRecord localDataLineMsgRecord;
      Object localObject2;
      if ((m > 3) && (m < 50))
      {
        localObject1 = new ArrayList();
        int n = localDataLineHandler.a();
        k = 0;
        while (k < m)
        {
          localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(k), paramInt, n, m, k);
          if (localDataLineMsgRecord != null) {
            ((ArrayList)localObject1).add(localDataLineMsgRecord);
          }
          localObject2 = localObject1;
          if (DataLineMsgSet.isSingle(paramInt, n))
          {
            if (localDataLineMsgRecord != null)
            {
              localDataLineMsgRecord.groupId = 0;
              localDataLineMsgRecord.groupIndex = 0;
              localDataLineMsgRecord.groupSize = 0;
            }
            if (((ArrayList)localObject1).size() > 0) {
              localDataLineHandler.a((ArrayList)localObject1, false);
            }
            localObject2 = new ArrayList();
          }
          k += 1;
          localObject1 = localObject2;
        }
        if (((ArrayList)localObject1).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject1, false);
        }
        return;
      }
      Object localObject1 = new ArrayList();
      m = localDataLineHandler.a();
      int k = 0;
      while (k < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(k), paramInt, m, 50, k);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject1).add(localDataLineMsgRecord);
        }
        localObject2 = localObject1;
        if (DataLineMsgSet.isSingle(paramInt, m))
        {
          if (localDataLineMsgRecord != null)
          {
            localDataLineMsgRecord.groupId = 0;
            localDataLineMsgRecord.groupIndex = 0;
            localDataLineMsgRecord.groupSize = 0;
          }
          if (((ArrayList)localObject1).size() > 0) {
            localDataLineHandler.a((ArrayList)localObject1, false);
          }
          localObject2 = new ArrayList();
        }
        k += 1;
        localObject1 = localObject2;
      }
      if (((ArrayList)localObject1).size() > 0) {
        localDataLineHandler.a((ArrayList)localObject1, false);
      }
      k = 0;
      while (k < 50)
      {
        paramArrayList.remove(0);
        k += 1;
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, AIOUtils.b(8.0F, this.app.getApplication().getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(AIOUtils.b(14.0F, this.app.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130850178);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(AIOUtils.b(11.0F, this.app.getApplication().getResources()), AIOUtils.b(6.0F, this.app.getApplication().getResources()), AIOUtils.b(11.0F, this.app.getApplication().getResources()), AIOUtils.b(6.0F, this.app.getApplication().getResources()));
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight(), AIOUtils.b(100.0F, this.app.getApplication().getResources()) });
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
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
    String str;
    for (long l = 0L; ((Iterator)localObject3).hasNext(); l += new VFSFile(str).length())
    {
      str = (String)((Iterator)localObject3).next();
      int k = paramPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(str);
      if (1 == k) {
        ((ArrayList)localObject1).add(str);
      } else if (k == 0) {
        ((ArrayList)localObject2).add(str);
      }
    }
    if (l == 0L)
    {
      a(this);
      return true;
    }
    if ((NetworkUtil.isNetworkAvailable(this)) && (!NetworkUtil.isWifiConnected(this)) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this, 2131692561, 2131692566, new LiteActivity.43(this, (ArrayList)localObject2, (ArrayList)localObject1));
    }
    else
    {
      if (!((ArrayList)localObject2).isEmpty())
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        new LiteActivity.SendPhotoAsyncTask(this).execute(new Bundle[] { localObject3 });
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
        new LiteActivity.SendVideoAsyncTask(this).execute(new Bundle[] { localObject2 });
      }
    }
    paramPhotoListPanel.h();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size());
    ((StringBuilder)localObject1).append("");
    ReportController.b(null, "CliOper", "", "", "0X8005A2F", "0X8005A2F", 0, 0, ((StringBuilder)localObject1).toString(), "", "", "");
    return true;
  }
  
  void c()
  {
    this.app.getMessageFacade().a(this.jdField_a_of_type_Int).a(15, new LiteActivity.6(this));
  }
  
  void c(Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("aio_msg_source", 999);
    boolean bool = true;
    if (k != 1) {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    if (this.jdField_c_of_type_Boolean)
    {
      AIOUtils.o = false;
      this.d = false;
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
      localObject = localViewGroup;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131368874));
    TextWatcher localTextWatcher = this.jdField_a_of_type_AndroidTextTextWatcher;
    if (localTextWatcher != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(localTextWatcher);
    } else {
      this.jdField_a_of_type_AndroidTextTextWatcher = new LiteActivity.7(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "input set error", localException);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new LiteActivity.8(this) });
    DeviceLib.a(this, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    h();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new LiteActivity.9(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(new LiteActivity.10(this));
  }
  
  void d(Intent paramIntent)
  {
    paramIntent = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!paramIntent.equalsIgnoreCase(""))
    {
      PlusPanelUtils.jdField_a_of_type_JavaLangString = paramIntent;
      paramIntent = Uri.fromFile(new File(paramIntent));
    }
    else
    {
      paramIntent = null;
    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = ImageUtil.b(this, paramIntent);
    if (paramIntent != null)
    {
      ImageUtil.a(this, paramIntent);
      if (!FileUtils.isPicFile(paramIntent))
      {
        QQToast.a(this, getString(2131692416), 0).b(getTitleBarHeight());
        return;
      }
      if (!new VFSFile(paramIntent).exists())
      {
        QQToast.a(this, getString(2131694908), 0).b(getTitleBarHeight());
        return;
      }
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localIntent.setClass(this, CameraPreviewActivity.class);
      localArrayList.add(paramIntent);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      localIntent.putExtra(AlbumConstants.h, 55);
      localIntent.putExtra("uin", AppConstants.DATALINE_PC_UIN);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("LASTFROM", this.leftView.getText().toString());
      startActivity(localIntent);
      return;
    }
    QQToast.a(this, getString(2131694908), 0).b(getTitleBarHeight());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (!b())
    {
      b(null);
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4) {
              if (paramInt1 != 5)
              {
                if (paramInt1 != 7)
                {
                  if (paramInt1 != 10004)
                  {
                    if (paramInt1 != 101)
                    {
                      if (paramInt1 != 102) {
                        return;
                      }
                      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
                      return;
                    }
                    if (paramInt2 == -1) {
                      a(false);
                    }
                  }
                  else if (paramInt2 == -1)
                  {
                    PhotoListPanel localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
                    if (localPhotoListPanel != null) {
                      localPhotoListPanel.a(paramInt1, paramIntent);
                    }
                  }
                }
                else {
                  B();
                }
              }
              else if (paramInt2 == -1) {
                d(paramIntent);
              }
            }
          }
          else if ((paramInt2 == -1) && (paramIntent != null))
          {
            paramIntent = paramIntent.getExtras().getString("textMsg");
            if (paramIntent.length() > 0) {
              a(paramIntent);
            }
          }
        }
        else if (paramInt2 == -1) {
          a(false);
        }
      }
      else if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          b(paramIntent, 2);
          paramIntent.clear();
          a(false);
        }
      }
    }
    else if ((paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("sendInfo");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        b(paramIntent, 1);
        paramIntent.clear();
        a(false);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131165419);
    setContentView(2131559004);
    setStatusBarBlue();
    boolean bool = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376636));
    if (bool) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850434);
    } else {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850433);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)findViewById(2131368875));
    Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369563);
    if (localObject1 != null) {
      ViewCompat.setImportantForAccessibility((View)localObject1, 2);
    }
    setTitle(2131693779);
    getWindow().setBackgroundDrawable(null);
    b(getIntent());
    c(getIntent());
    k();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131381107));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370179));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370178));
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364587));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131376809));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)findViewById(2131372306));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconLongListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(null);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377187));
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
    if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.isEmpty())
    {
      paramBundle = getSharedPreferences("first_enter_dataline", 0);
      int k = paramBundle.getInt("year", -1);
      int m = paramBundle.getInt("month", -1);
      int n = paramBundle.getInt("day", -1);
      Object localObject2 = Calendar.getInstance();
      int i1 = ((Calendar)localObject2).get(1);
      int i2 = ((Calendar)localObject2).get(2);
      int i3 = ((Calendar)localObject2).get(5);
      if ((i1 != k) || (i2 != m) || (i3 != n))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
        localObject2 = ((DataLineMsgSetList)localObject2).get(((DataLineMsgSetList)localObject2).size() - 1);
        if (localObject2 != null)
        {
          localObject2 = ((DataLineMsgSet)localObject2).getFirstItem();
          if ((localObject2 != null) && (((DataLineMsgRecord)localObject2).msgtype != -5000))
          {
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
            localObject1 = ((DataLineHandler)localObject1).a(0, this.jdField_a_of_type_Int);
            localObject2 = new DataLineMsgRecord();
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
          }
        }
      }
    }
    x();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367405);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131367403));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368177));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367418));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)findViewById(2131367404));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131706262));
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131706261));
    }
    this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper = new LiteCopyPromptHelper(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.app, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper.a();
    w();
    AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
    if (localObject != null) {
      ((ScrollerRunnable)localObject).b();
    }
    if (this.app.getMessageFacade() != null)
    {
      this.app.getMessageFacade().a(this.jdField_a_of_type_Int).e();
      this.app.getMessageFacade().a(this.jdField_a_of_type_Int).d();
      this.app.getMessageFacade().deleteObserver(this);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    this.jdField_a_of_type_Int = -1;
    if (this.app.getFileManagerProxy() != null) {
      this.app.getFileManagerProxy().b();
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    if (localObject != null) {
      ((PhotoListPanel)localObject).setSelectLimitListener(null);
    }
    FileManagerUtil.a(this);
    if (this.i)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper.b();
    QLog.d(jdField_a_of_type_JavaLangString, 1, "doOnDestroy");
    if ((this.jdField_b_of_type_Boolean) && (!getIntent().getBooleanExtra("isMigSdkShare", false))) {
      com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    i(paramIntent);
    g();
    h(paramIntent);
    e(paramIntent);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    QLog.d(jdField_a_of_type_JavaLangString, 1, "doOnPause");
    ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).d();
    if (this.i) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    PhotoListPanel localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    if ((localPhotoListPanel != null) && (localPhotoListPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
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
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(a());
    int k = paramIntent.getIntExtra(AlbumConstants.h, -1);
    Object localObject;
    if (55 == k)
    {
      if (paramIntent.getExtras().containsKey("PhotoConst.PHOTO_PATHS"))
      {
        localObject = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
        if (((List)localObject).size() > 0)
        {
          a((List)localObject);
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
          if (paramIntent != null) {
            paramIntent.h();
          }
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
          if (paramIntent != null) {
            paramIntent.setAllUnSelected();
          }
          paramIntent = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
          if (paramIntent != null) {
            paramIntent.a();
          }
          return;
        }
      }
      if (paramIntent.getExtras().containsKey("file_send_path"))
      {
        c(paramIntent.getExtras().getString("file_send_path"));
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
        if (localObject != null) {
          ((PhotoListPanel)localObject).h();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
        if (localObject != null) {
          ((PanelIconLinearLayout)localObject).setAllUnSelected();
        }
        localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
        if (localObject != null) {
          ((XPanelContainer)localObject).a();
        }
      }
    }
    else if (56 == k)
    {
      c(paramIntent.getExtras().getString("file_send_path"));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      if (localObject != null) {
        ((PhotoListPanel)localObject).h();
      }
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      getIntent().removeExtra("PhotoConst.SEND_FLAG");
      a(paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS"));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      if (localObject != null) {
        ((PhotoListPanel)localObject).h();
      }
    }
    if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
      getIntent().putExtra("isMigSdkShare", true);
    }
    g(paramIntent);
    f(paramIntent);
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
    if (this.jdField_a_of_type_Int == 1)
    {
      str = AppConstants.DATALINE_IPAD_UIN;
      k = 6003;
    }
    else
    {
      str = AppConstants.DATALINE_PC_UIN;
      k = 6000;
    }
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if (localObject2 != null) {
      localObject1 = ((XEditTextEx)localObject2).getText();
    }
    localObject2 = a();
    Object localObject3;
    if (StringUtil.a((String)localObject2))
    {
      localObject3 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if ((localObject3 != null) && (StringUtil.a(String.valueOf(((XEditTextEx)localObject3).getText())))) {
        return;
      }
    }
    if (!StringUtil.a((String)localObject2))
    {
      localObject3 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if ((localObject3 != null) && (((String)localObject2).equals(String.valueOf(((XEditTextEx)localObject3).getText())))) {
        return;
      }
    }
    localObject2 = DraftTextManager.a(this.app);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      localObject3 = new DraftTextInfo();
      ((DraftTextInfo)localObject3).uin = str;
      ((DraftTextInfo)localObject3).type = k;
      ((DraftTextInfo)localObject3).text = ((CharSequence)localObject1).toString();
      ((DraftTextInfo)localObject3).time = NetConnInfoCenter.getServerTimeMillis();
      ((DraftTextManager)localObject2).a(this.app, (DraftTextInfo)localObject3);
    }
    else
    {
      ((DraftTextManager)localObject2).a(this.app, str, k);
    }
    localObject1 = this.app.getMessageFacade();
    localObject2 = ((DraftTextManager)localObject2).a(this.app, str, k);
    if (localObject2 != null)
    {
      ((QQMessageFacade)localObject1).a(str, k, "", ((DraftSummaryInfo)localObject2).getSummary(), ((DraftSummaryInfo)localObject2).getTime());
      return;
    }
    ((QQMessageFacade)localObject1).a(str, k, "", "", 0L);
  }
  
  void g(Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("dataline_forward_type", -1);
    if (k == -1) {
      return;
    }
    paramIntent.getIntExtra("dataline_forward_type", -1);
    long l2 = paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false))
    {
      if (k == 100) {
        k = 0;
      } else {
        k = 1;
      }
      localObject1 = paramIntent.getStringArrayListExtra("dataline_forward_pathlist");
      if (localObject1 == null)
      {
        localObject1 = paramIntent.getExtras();
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getParcelableArrayList("fileinfo_array");
          if (localObject1 == null) {}
        }
      }
    }
    try
    {
      localObject1 = (ArrayList)localObject1;
    }
    catch (ClassCastException localClassCastException)
    {
      label108:
      Object localObject2;
      Object localObject3;
      Object localObject4;
      int m;
      int n;
      break label108;
    }
    Object localObject1 = null;
    if (localObject1 == null)
    {
      o();
      return;
    }
    localObject2 = new ArrayList();
    localObject3 = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localObject1 = ((ArrayList)localObject1).iterator();
    k = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = a((ForwardFileInfo)((Iterator)localObject1).next(), false, this.jdField_a_of_type_Int);
      if (localObject4 != null) {
        if (DataLineMsgSet.isSingle((DataLineMsgRecord)localObject4))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject4);
          ((DataLineHandler)localObject3).a(localArrayList, false);
          k = 1;
        }
        else
        {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      ((DataLineHandler)localObject3).a((ArrayList)localObject2, false);
    }
    else if (k == 0)
    {
      o();
      break label1426;
      localObject2 = ((ArrayList)localObject1).iterator();
      for (m = 0; ((Iterator)localObject2).hasNext(); m = n)
      {
        label278:
        localObject3 = (String)((Iterator)localObject2).next();
        if ((localObject3 != null) && (!((String)localObject3).equals("/"))) {
          break label278;
        }
        n = m;
        if (m == 0)
        {
          o();
          n = 1;
        }
        ((Iterator)localObject2).remove();
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        a((ArrayList)localObject1, k);
      }
      else if (m == 0)
      {
        o();
        break label1426;
        localObject2 = new ArrayList();
        if (a(paramIntent, k)) {
          return;
        }
        switch (k)
        {
        default: 
          StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_other");
          break;
        case 102: 
          localObject1 = paramIntent.getStringExtra("dataline_forward_text");
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            if (Patterns.d.matcher((CharSequence)localObject1).find()) {
              StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_link");
            } else {
              StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_text");
            }
            a((String)localObject1);
          }
          break;
        case 101: 
          StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_image");
          localObject1 = paramIntent.getStringExtra("dataline_forward_path");
          if (localObject1 == null)
          {
            localObject1 = jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleForwardRequest forward image, extras: ");
            ((StringBuilder)localObject2).append(paramIntent.getExtras().toString());
            QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject3 = ((String)localObject1).split(";");
            ((ArrayList)localObject2).clear();
            k = 0;
            while (k < localObject3.length)
            {
              try
              {
                if (FileUtils.fileExists(localObject3[k])) {
                  localObject1 = localObject3[k];
                } else {
                  localObject1 = URLDecoder.decode(localObject3[k], "UTF-8");
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                boolean bool;
                long l1;
                break label840;
              }
              catch (IllegalArgumentException localIllegalArgumentException1)
              {
                break label685;
              }
              localObject1 = localObject3[k];
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://")))
                {
                  ((ArrayList)localObject2).add(localObject1);
                }
                else
                {
                  a((String)localObject1);
                  ReportController.b(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("gotoQfavShareMsg|file path invalid. path=");
                ((StringBuilder)localObject4).append((String)localObject1);
                QLog.e("qqdataline", 2, ((StringBuilder)localObject4).toString());
              }
              k += 1;
              continue;
              if (QLog.isColorLevel())
              {
                paramIntent = new StringBuilder();
                paramIntent.append("shareFromMigSdk|decode exp. imageUrls[i]=");
                paramIntent.append(localObject3[k]);
                QLog.e("qqdataline", 2, paramIntent.toString());
              }
              return;
            }
            if (!((ArrayList)localObject2).isEmpty())
            {
              a((ArrayList)localObject2, 1);
              if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
                if (((ArrayList)localObject2).size() > 1)
                {
                  ReportController.b(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
                  }
                }
                else if (((ArrayList)localObject2).size() == 1)
                {
                  ReportController.b(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
                  }
                }
              }
            }
          }
          break;
        case 100: 
          label685:
          label840:
          StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_file");
          localObject1 = QfavHelper.a(paramIntent.getExtras(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (localObject1 != null)
          {
            paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
            if (paramIntent != null) {
              k = paramIntent.jdField_a_of_type_Int;
            } else {
              k = 0;
            }
            this.app.getFileManagerEngine().a((FileManagerEntity)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, k);
            return;
          }
          localObject1 = paramIntent.getStringExtra("dataline_forward_path");
          if ((localObject1 != null) && (!((String)localObject1).equals("")))
          {
            localObject3 = ((String)localObject1).split(";");
            ((ArrayList)localObject2).clear();
            k = 0;
            label1172:
            while (k < localObject3.length) {}
          }
          break;
        }
      }
    }
    try
    {
      localObject1 = URLDecoder.decode(localObject3[k], "UTF-8");
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      break label1304;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      label1194:
      break label1194;
    }
    localObject1 = localObject3[k];
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://"))) {
        ((ArrayList)localObject2).add(localObject1);
      } else {
        a((String)localObject1);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("shareFromMigSdk|file path invalid. path=");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.e("qqdataline", 2, ((StringBuilder)localObject4).toString());
    }
    k += 1;
    break label1172;
    label1304:
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("shareFromMigSdk|decode exp. imageUrls[i]=");
      paramIntent.append(localObject3[k]);
      QLog.e("qqdataline", 2, paramIntent.toString());
    }
    return;
    if (!((ArrayList)localObject2).isEmpty())
    {
      a((ArrayList)localObject2, 0);
      if (paramIntent.getBooleanExtra("isMigSdkShare", false))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
        if (QLog.isColorLevel())
        {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
          break label1426;
          o();
          return;
        }
      }
    }
    label1426:
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
    }
    bool = paramIntent.getExtras().getBoolean("refuse_show_share_result_dialog", false);
    if ((this.jdField_b_of_type_Boolean) && (!bool))
    {
      paramIntent = paramIntent.getExtras();
      localObject1 = paramIntent.getString("app_name");
      l1 = l2;
      if (l2 == 0L)
      {
        paramIntent = StructMsgFactory.a(paramIntent);
        if ((paramIntent != null) && ((paramIntent instanceof AbsShareMsg))) {
          paramIntent = (AbsShareMsg)paramIntent;
        } else {
          paramIntent = null;
        }
        l1 = l2;
        if (paramIntent != null) {
          l1 = paramIntent.mSourceAppid;
        }
      }
      a(l1, (String)localObject1);
    }
  }
  
  void h()
  {
    int n = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this);
    int m = 6;
    int k;
    if (n != 0)
    {
      k = m;
      if (n != 2)
      {
        k = m;
        if (n == 3) {}
      }
    }
    else
    {
      k = 8;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(k);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_b_of_type_Int);
  }
  
  protected void h(Intent paramIntent)
  {
    c(paramIntent);
    int k = this.jdField_a_of_type_Int;
    b(paramIntent);
    if (k != this.jdField_a_of_type_Int)
    {
      paramIntent = this.app.getDataLineMsgProxy(this.jdField_a_of_type_Int);
      if (paramIntent == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramIntent.a(true);
        this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
      }
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    }
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 14)
          {
            if (k == 15) {
              B();
            }
          }
          else {
            b(paramMessage.arg1, paramMessage.arg2);
          }
        }
        else
        {
          String str = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("progress: ");
          localStringBuilder.append(paramMessage.arg1);
          QLog.i(str, 2, localStringBuilder.toString());
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgress(paramMessage.arg1);
        }
      }
      else
      {
        C();
        D();
      }
    }
    else
    {
      C();
      d(b());
    }
    return false;
  }
  
  void i()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("photo/");
    localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    Object localObject2 = new File((String)localObject1);
    if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
    {
      QQToast.a(this, 2131718574, 0).a();
      return;
    }
    if (!c()) {
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".jpg");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new Intent();
    FileProvider7Helper.setSystemCapture(this, new File((String)localObject1), (Intent)localObject2);
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", (String)localObject1).commit();
    startActivityForResult((Intent)localObject2, 5);
  }
  
  void i(Intent paramIntent)
  {
    setLeftViewName(paramIntent);
    String str = this.leftView.getText().toString();
    if (str.contains(getString(2131719442)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4recent");
      j();
    }
    else if (str.contains(getString(2131693874)))
    {
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4buddylist");
    }
    else if (str.contains(getString(2131692363)))
    {
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4dongtai");
    }
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
      this.leftView.setText(getString(2131719442));
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
        this.leftView.setText(getString(2131719442));
        this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
        j();
      }
    }
    if (ChatActivityConstants.jdField_a_of_type_Boolean)
    {
      str = this.leftView.getText().toString();
      paramIntent = str;
      if (!getString(2131690529).equals(str))
      {
        paramIntent = new StringBuilder();
        paramIntent.append(HardCodeUtil.a(2131706263));
        paramIntent.append(str);
        paramIntent.append(HardCodeUtil.a(2131706266));
        paramIntent = paramIntent.toString();
      }
      this.leftView.setContentDescription(paramIntent);
    }
  }
  
  void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      localObject = ((TextView)localObject).getText().toString();
      if ((localObject != null) && (!((String)localObject).startsWith(getString(2131719442)))) {
        return;
      }
      int k = 0;
      int m = QCallFacade.a(this.app);
      localObject = this.app.getMessageFacade();
      if (localObject != null) {
        k = ((QQMessageFacade)localObject).b();
      }
      k += m;
      if (k > 0)
      {
        if (k > 99)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131719442));
          localStringBuilder.append("(99+)");
          ((TextView)localObject).setText(localStringBuilder.toString());
          return;
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131719442));
        localStringBuilder.append("(");
        localStringBuilder.append(k);
        localStringBuilder.append(")");
        ((TextView)localObject).setText(localStringBuilder.toString());
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131719442));
    }
  }
  
  void k()
  {
    Object localObject = this.rightViewImg;
    ((ImageView)localObject).setContentDescription(getResources().getText(2131693690));
    ((ImageView)localObject).setVisibility(0);
    ((ImageView)localObject).setImageResource(2130850473);
    ((ImageView)localObject).setOnClickListener(new LiteActivity.21(this));
    if (ChatActivityConstants.jdField_a_of_type_Boolean) {
      this.rightViewImg.setContentDescription(HardCodeUtil.a(2131706269));
    }
    i(getIntent());
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.mLeftBackIcon.setVisibility(0);
      this.leftView.setBackgroundDrawable(null);
      localObject = getResources().getColorStateList(2131167054);
    }
    else
    {
      this.mLeftBackIcon.setVisibility(8);
      localObject = getResources().getColorStateList(2131167053);
    }
    this.centerView.setTextColor((ColorStateList)localObject);
    this.leftView.setTextColor((ColorStateList)localObject);
  }
  
  void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.app.getMessageFacade().a(this.jdField_a_of_type_Int).c(localLong.longValue());
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMsgFailedWhenQuesting: session = ");
        localStringBuilder.append(localLong.longValue());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  void m()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130839548);
    localQQToast.d(2000);
    localQQToast.c(2131693770);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void n()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130839548);
    localQQToast.d(2000);
    localQQToast.c(2131693771);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void o()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130839548);
    localQQToast.d(2000);
    localQQToast.c(2131693764);
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
    default: 
      break;
    case 2131377187: 
      z();
      break;
    case 2131371574: 
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
      break;
    case 2131368177: 
      ReportController.b(this.app, "dc00898", "", "", "0X8009F36", "0X8009F36", 4, 0, "", "", "", "");
      b(false);
      break;
    case 2131367404: 
      if (this.j) {
        b(false);
      }
      z();
      break;
    case 2131367403: 
      ReportController.b(this.app, "dc00898", "", "", "0X8009F27", "0X8009F27", 4, 0, "", "", "", "");
      v();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt != 100)
    {
      paramArrayOfString = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestPermissionsResult error, requestcode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" grantresult:");
      localStringBuilder.append(paramArrayOfInt);
      QLog.e(paramArrayOfString, 2, localStringBuilder.toString());
      return;
    }
    int k = 0;
    paramInt = 0;
    while (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] != 0)
      {
        DialogUtil.a(this, paramArrayOfString, paramArrayOfInt);
        paramInt = k;
        break label108;
      }
      paramInt += 1;
    }
    paramInt = 1;
    label108:
    if (paramInt != 0) {
      i();
    }
  }
  
  void p()
  {
    Object localObject = new ArrayList();
    LiteActivity.33 local33 = new LiteActivity.33(this, (List)localObject);
    LiteActivity.34 local34 = new LiteActivity.34(this);
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int i2 = 0;
    int n = 0;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      int i1 = 0;
      int k = n;
      int m = i2;
      for (;;)
      {
        i2 = m;
        n = k;
        if (!localIterator2.hasNext()) {
          break;
        }
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
        if ((DataLineMsgSet.isFileType(localDataLineMsgRecord)) && (!localDataLineMsgRecord.isread) && (localDataLineMsgRecord.fileMsgStatus == 1L))
        {
          i2 = m;
          n = i1;
          if (i1 == 0)
          {
            i2 = m + 1;
            n = 1;
          }
          ((List)localObject).add(localDataLineMsgRecord);
          k += 1;
          m = i2;
          i1 = n;
        }
      }
    }
    if (i2 >= 3)
    {
      localObject = String.format(getString(2131693782), new Object[] { Integer.valueOf(i2), Integer.valueOf(n) });
      ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(115);
      DialogUtil.a(this, 230, getString(2131693728), (String)localObject, 2131690728, 2131693691, local33, local34).show();
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
    PhotoListPanel localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    if (localPhotoListPanel != null)
    {
      a(localPhotoListPanel);
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
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
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
    localObject = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBottom() });
    ((ValueAnimator)localObject).addUpdateListener(new LiteActivity.53(this));
    ((ValueAnimator)localObject).addListener(new LiteActivity.54(this));
    ((ValueAnimator)localObject).setDuration(100L).setRepeatCount(0);
    ((ValueAnimator)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */