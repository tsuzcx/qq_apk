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
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
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
import com.tencent.mobileqq.app.utils.RouteUtils;
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
import com.tencent.mobileqq.utils.QQTheme;
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
import java.lang.ref.WeakReference;
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
  protected static String G;
  public static String a = "dataline.LiteActivity";
  protected boolean A = false;
  RelativeLayout B;
  TextView C;
  ImageView D;
  boolean E = false;
  boolean F = true;
  public View H;
  public ImageButton I;
  public ImageButton J;
  public PatchedButton K;
  public LinearLayout L;
  protected TopGestureLayout M;
  public View.OnClickListener N = new LiteActivity.22(this);
  public View.OnClickListener O = new LiteActivity.23(this);
  DataLineObserver P = new LiteActivity.27(this);
  BubblePopupWindow Q;
  public View.OnLongClickListener R = new LiteActivity.31(this);
  public View.OnTouchListener S = new LiteActivity.32(this);
  FMObserver T = new LiteActivity.35(this);
  Runnable U = new LiteActivity.37(this);
  private boolean V;
  private boolean W;
  private QQCustomDialog X;
  private QQBlurView Y;
  private boolean Z = false;
  private ViewTreeObserver.OnGlobalLayoutListener aa;
  private LiteCopyPromptHelper ab;
  private boolean ac = false;
  private ViewGroup ad;
  private InputLinearLayout ae;
  private PointF af = new PointF();
  public XPanelContainer b;
  PhotoListPanel c;
  SessionInfo d = new SessionInfo();
  TextView e;
  XListView f;
  ScrollerRunnable g;
  TextView h;
  protected RelativeLayout i;
  public int j = -1;
  protected String k = AppConstants.DATALINE_PC_UIN;
  DataLineMsgSetList l = null;
  DatalineSessionAdapter m = null;
  List<Long> n = new ArrayList();
  boolean o = false;
  int p;
  XEditTextEx q;
  TextWatcher r;
  Button s;
  LiteActivity.LiteJumpAction t;
  QQCustomDialog u = null;
  boolean v = false;
  ForwardBaseOption w = null;
  PanelIconLinearLayout x;
  MqqHandler y = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  protected boolean z = false;
  
  private void C()
  {
    VideoReport.addToDetectionWhitelist(this);
    b(getWindow().getDecorView());
  }
  
  @TargetApi(19)
  private void D()
  {
    this.Z = ThemeUtil.isDefaultOrDIYTheme(false);
    this.Y = ((QQBlurView)findViewById(2131449300));
    this.Y.setVisibility(0);
    if (!this.Z) {
      return;
    }
    this.Y.a(this.mContentView);
    QQBlurView localQQBlurView = this.Y;
    localQQBlurView.b(localQQBlurView);
    this.Y.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.Y.a(8.0F);
    this.Y.a(8);
    this.Y.setDirtyListener(new LiteActivity.2(this));
    this.Y.d();
    this.aa = new LiteActivity.3(this);
    this.f.getViewTreeObserver().addOnGlobalLayoutListener(this.aa);
  }
  
  private void E()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(QQToast.getIconRes(1));
    localQQToast.setType(1);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(2131891533);
    localQQToast.show();
  }
  
  private void F()
  {
    if ((this.v) && (!G())) {
      RouteUtils.a(this, new Intent(), "/base/start/splash");
    }
  }
  
  private boolean G()
  {
    return (SplashActivity.sWeakInstance != null) && (SplashActivity.sWeakInstance.get() != null);
  }
  
  private static int H()
  {
    return 2130839229;
  }
  
  private void I()
  {
    String str = this.q.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktxt");
      a(new QQText(str, 13, 32, 6000).toString());
      this.q.setText("");
    }
  }
  
  private void J()
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByLiteActivity(this, 2);
    overridePendingTransition(2130771996, 2130771997);
    ReportController.b(this.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
  }
  
  private View K()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    this.c = ((PhotoListPanel)View.inflate(this, 2131627284, null));
    this.c.setCustomOnClickListener(this);
    Intent localIntent = new Intent();
    String str = this.app.getAccount();
    Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(str);
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
    this.c.a(this.app, this, this.d, localIntent);
    this.c.setSelectLimitListener(new LiteActivity.44(this));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OpenPhotolistPanel:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.d("OpenPanel", 2, ((StringBuilder)localObject1).toString());
    }
    return this.c;
  }
  
  private void L()
  {
    DataLineMsgSetList localDataLineMsgSetList = this.l;
    int i1;
    if (localDataLineMsgSetList != null) {
      i1 = localDataLineMsgSetList.size();
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      if ((!this.E) && (TextUtils.isEmpty(h())))
      {
        d(true);
        return;
      }
      d(false);
      return;
    }
    d(false);
  }
  
  private void M()
  {
    QQCustomDialog localQQCustomDialog = this.X;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  private void N()
  {
    LiteActivity.LiteJumpAction localLiteJumpAction = this.t;
    if (localLiteJumpAction == null) {
      return;
    }
    localLiteJumpAction.a();
  }
  
  private boolean O()
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool1 = true;
    boolean bool2 = true;
    if (i1 >= 23) {}
    for (;;)
    {
      try
      {
        i1 = checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        if (i1 == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool1) {
          try
          {
            i1 = checkSelfPermission("android.permission.CAMERA");
            if (i1 == 0) {
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
        String str = a;
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
  
  private int P()
  {
    int i1 = this.j;
    if (i1 == 0) {
      return 1;
    }
    if (i1 == 1) {
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
    paramInt = FileManagerUtil.c(paramDataLineMsgRecord.filename);
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
      int i1 = 119;
      Drawable localDrawable = paramContext.getResources().getDrawable(H());
      if ((localDrawable instanceof BitmapDrawable))
      {
        localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
        paramString = ((BitmapDrawable)localDrawable).getTileModeX();
        i1 = ((BitmapDrawable)localDrawable).getGravity();
      }
      else if ((localDrawable instanceof SkinnableBitmapDrawable))
      {
        localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
        paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
        i1 = ((SkinnableBitmapDrawable)localDrawable).getGravity();
      }
      if ((localBitmap != null) && (paramString != Shader.TileMode.REPEAT) && (i1 == 48))
      {
        paramString = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
        paramString.setGravity(i1);
        return paramString;
      }
      paramString = paramContext.getResources().getDrawable(H());
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiteActivity setAIOBackgroundBmp 2", 2, paramString.getMessage());
      }
      return paramContext.getResources().getDrawable(2130852164);
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LiteActivity setAIOBackgroundBmp 1", 2, paramString.getMessage());
      }
    }
    return paramContext.getResources().getDrawable(2130852164);
  }
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 715	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 721	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +41 -> 61
    //   23: aload 7
    //   25: astore 6
    //   27: invokestatic 559	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +17 -> 47
    //   33: aload 7
    //   35: astore 6
    //   37: getstatic 631	com/dataline/activities/LiteActivity:a	Ljava/lang/String;
    //   40: iconst_2
    //   41: ldc_w 723
    //   44: invokestatic 725	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload 7
    //   49: ifnull +10 -> 59
    //   52: aload 7
    //   54: invokeinterface 730 1 0
    //   59: aconst_null
    //   60: areturn
    //   61: aload 7
    //   63: astore 6
    //   65: aload 7
    //   67: ldc_w 732
    //   70: invokeinterface 735 2 0
    //   75: istore_2
    //   76: aload 7
    //   78: astore 6
    //   80: aload 7
    //   82: ldc_w 737
    //   85: invokeinterface 740 2 0
    //   90: istore_3
    //   91: aload 7
    //   93: astore 6
    //   95: aload 7
    //   97: invokeinterface 743 1 0
    //   102: pop
    //   103: aload 7
    //   105: astore 6
    //   107: aload 7
    //   109: iload_3
    //   110: invokeinterface 747 2 0
    //   115: lstore 4
    //   117: aload 7
    //   119: astore 6
    //   121: lload 4
    //   123: l2f
    //   124: invokestatic 753	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   127: fcmpl
    //   128: ifle +31 -> 159
    //   131: aload 7
    //   133: astore 6
    //   135: aload_0
    //   136: ldc_w 754
    //   139: invokevirtual 758	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   142: putstatic 760	com/dataline/activities/LiteActivity:G	Ljava/lang/String;
    //   145: aload 7
    //   147: ifnull +10 -> 157
    //   150: aload 7
    //   152: invokeinterface 730 1 0
    //   157: aconst_null
    //   158: areturn
    //   159: aload 7
    //   161: astore 6
    //   163: aload 7
    //   165: iload_2
    //   166: invokeinterface 761 2 0
    //   171: astore 9
    //   173: aload 7
    //   175: astore 6
    //   177: new 561	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 562	java/lang/StringBuilder:<init>	()V
    //   184: astore 10
    //   186: aload 7
    //   188: astore 6
    //   190: aload 10
    //   192: aload_0
    //   193: invokevirtual 765	com/dataline/activities/LiteActivity:getExternalCacheDir	()Ljava/io/File;
    //   196: invokevirtual 636	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 7
    //   202: astore 6
    //   204: aload 10
    //   206: ldc_w 767
    //   209: invokevirtual 568	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 7
    //   215: astore 6
    //   217: aload 10
    //   219: ldc_w 769
    //   222: invokevirtual 568	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 7
    //   228: astore 6
    //   230: aload 10
    //   232: ldc_w 767
    //   235: invokevirtual 568	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 7
    //   241: astore 6
    //   243: aload 10
    //   245: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: astore 10
    //   250: aload 7
    //   252: astore 6
    //   254: aload 10
    //   256: invokestatic 771	com/dataline/activities/LiteActivity:f	(Ljava/lang/String;)V
    //   259: aload 7
    //   261: astore 6
    //   263: new 561	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 562	java/lang/StringBuilder:<init>	()V
    //   270: astore 11
    //   272: aload 7
    //   274: astore 6
    //   276: aload 11
    //   278: aload 10
    //   280: invokevirtual 568	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 7
    //   286: astore 6
    //   288: aload 11
    //   290: aload 10
    //   292: iconst_1
    //   293: anewarray 389	java/lang/String
    //   296: dup
    //   297: iconst_0
    //   298: aload 9
    //   300: aastore
    //   301: iconst_0
    //   302: aaload
    //   303: invokestatic 775	com/tencent/mobileqq/utils/FileUtils:getUnitFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 568	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 7
    //   312: astore 6
    //   314: aload 11
    //   316: invokevirtual 574	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore 9
    //   321: aload 7
    //   323: astore 6
    //   325: new 777	com/tencent/mm/vfs/VFSFile
    //   328: dup
    //   329: aload 10
    //   331: invokespecial 779	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   334: astore 10
    //   336: aload 7
    //   338: astore 6
    //   340: aload 10
    //   342: invokevirtual 782	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   345: ifne +43 -> 388
    //   348: aload 7
    //   350: astore 6
    //   352: aload 10
    //   354: invokevirtual 785	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   357: ifne +31 -> 388
    //   360: aload 7
    //   362: astore 6
    //   364: aload_0
    //   365: ldc_w 786
    //   368: invokestatic 790	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   371: invokespecial 792	com/dataline/activities/LiteActivity:e	(Ljava/lang/String;)V
    //   374: aload 7
    //   376: ifnull +10 -> 386
    //   379: aload 7
    //   381: invokeinterface 730 1 0
    //   386: aconst_null
    //   387: areturn
    //   388: aload 7
    //   390: astore 6
    //   392: aload 8
    //   394: aload_1
    //   395: invokevirtual 796	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   398: astore_1
    //   399: aload_1
    //   400: ifnonnull +41 -> 441
    //   403: aload 7
    //   405: astore 6
    //   407: invokestatic 559	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +17 -> 427
    //   413: aload 7
    //   415: astore 6
    //   417: getstatic 631	com/dataline/activities/LiteActivity:a	Ljava/lang/String;
    //   420: iconst_2
    //   421: ldc_w 798
    //   424: invokestatic 725	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: aload 7
    //   429: ifnull +10 -> 439
    //   432: aload 7
    //   434: invokeinterface 730 1 0
    //   439: aconst_null
    //   440: areturn
    //   441: lload 4
    //   443: ldc2_w 799
    //   446: lcmp
    //   447: ifle +163 -> 610
    //   450: aload 7
    //   452: astore 6
    //   454: aload_0
    //   455: iconst_1
    //   456: putfield 802	com/dataline/activities/LiteActivity:W	Z
    //   459: aload 7
    //   461: astore 6
    //   463: new 597	com/tencent/mobileqq/utils/QQCustomDialog
    //   466: dup
    //   467: aload_0
    //   468: ldc_w 803
    //   471: invokespecial 806	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   474: astore 8
    //   476: aload 7
    //   478: astore 6
    //   480: aload 8
    //   482: ldc_w 807
    //   485: invokevirtual 810	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   488: aload 7
    //   490: astore 6
    //   492: aload 8
    //   494: aload_0
    //   495: ldc_w 811
    //   498: invokevirtual 758	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   501: invokevirtual 815	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   504: pop
    //   505: aload 7
    //   507: astore 6
    //   509: aload 8
    //   511: aload_0
    //   512: ldc_w 816
    //   515: invokevirtual 758	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   518: invokevirtual 820	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   521: pop
    //   522: aload 7
    //   524: astore 6
    //   526: aload 8
    //   528: iconst_0
    //   529: invokevirtual 823	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   532: aload 7
    //   534: astore 6
    //   536: aload 8
    //   538: iconst_0
    //   539: invokevirtual 826	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   542: aload 7
    //   544: astore 6
    //   546: aload 8
    //   548: aload_0
    //   549: ldc_w 827
    //   552: invokevirtual 758	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   555: new 829	com/dataline/activities/LiteActivity$46
    //   558: dup
    //   559: aload_0
    //   560: aload_1
    //   561: invokespecial 832	com/dataline/activities/LiteActivity$46:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/io/InputStream;)V
    //   564: invokevirtual 836	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   567: pop
    //   568: aload 7
    //   570: astore 6
    //   572: aload 8
    //   574: aload_0
    //   575: ldc_w 837
    //   578: invokevirtual 758	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   581: new 839	com/dataline/activities/LiteActivity$47
    //   584: dup
    //   585: aload_0
    //   586: aload 9
    //   588: aload_1
    //   589: lload 4
    //   591: invokespecial 842	com/dataline/activities/LiteActivity$47:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   594: invokevirtual 845	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   597: pop
    //   598: aload 7
    //   600: astore 6
    //   602: aload 8
    //   604: invokevirtual 847	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   607: goto +16 -> 623
    //   610: aload 7
    //   612: astore 6
    //   614: aload_0
    //   615: aload 9
    //   617: aload_1
    //   618: lload 4
    //   620: invokespecial 850	com/dataline/activities/LiteActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   623: aload 7
    //   625: ifnull +10 -> 635
    //   628: aload 7
    //   630: invokeinterface 730 1 0
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
    //   662: putfield 852	com/dataline/activities/LiteActivity:V	Z
    //   665: aload_1
    //   666: astore 6
    //   668: invokestatic 559	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq +18 -> 689
    //   674: aload_1
    //   675: astore 6
    //   677: getstatic 631	com/dataline/activities/LiteActivity:a	Ljava/lang/String;
    //   680: iconst_2
    //   681: ldc_w 854
    //   684: aload 8
    //   686: invokestatic 857	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   689: aload_1
    //   690: ifnull +9 -> 699
    //   693: aload_1
    //   694: invokeinterface 730 1 0
    //   699: aconst_null
    //   700: areturn
    //   701: astore_1
    //   702: aload 6
    //   704: ifnull +10 -> 714
    //   707: aload 6
    //   709: invokeinterface 730 1 0
    //   714: aload_1
    //   715: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	LiteActivity
    //   0	716	1	paramUri	Uri
    //   75	91	2	i1	int
    //   90	20	3	i2	int
    //   115	504	4	l1	long
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
  
  public static void a(Context paramContext)
  {
    LiteActivity.18 local18 = new LiteActivity.18();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131917233), paramContext.getString(2131891291), 2131891275, 2131891275, local18, null).show();
  }
  
  static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131437346);
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
    int i1 = 0;
    localObject = ChatBackgroundUtil.a(paramIphoneTitleBarActivity, (String)localObject, 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.DATALINE_PC_UIN;
    arrayOfString[1] = "chat_uniform_bg";
    if ((((SharedPreferences)localObject).getString(arrayOfString[0], null) == null) && (((SharedPreferences)localObject).getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int i2 = arrayOfString.length;
    while (i1 < i2)
    {
      String str = ((SharedPreferences)localObject).getString(arrayOfString[i1], null);
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
      i1 += 1;
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
    long l1 = FileUtils.getFileSizes(paramString);
    String str = FileManagerUtil.a(paramString);
    Object localObject;
    if (paramDataLineMsgRecord.nWeiyunSessionId != 0L) {
      localObject = this.app.getFileManagerDataCenter().a(paramDataLineMsgRecord.nWeiyunSessionId);
    } else {
      localObject = null;
    }
    if ((FileManagerUtil.b()) && (l1 > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      if (FreeWifiHelper.a(getActivity(), 5, new LiteActivity.57(this, paramDataLineMsgRecord, (FileManagerEntity)localObject, str, paramString))) {
        FMDialogUtil.a(getActivity(), 2131889584, 2131889587, new LiteActivity.58(this, paramDataLineMsgRecord, (FileManagerEntity)localObject, str, paramString));
      }
    }
    else if (localObject == null)
    {
      i1 = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileManagerUtil.j(str));
      ((StringBuilder)localObject).append(getString(2131889759));
      FMToastUtil.b(((StringBuilder)localObject).toString());
      paramDataLineMsgRecord.nWeiyunSessionId = this.app.getFileManagerEngine().a(paramString, null, this.app.getAccount(), 0, false).nSessionId;
      this.app.getMessageFacade().d(i1).f(paramDataLineMsgRecord.msgId);
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append(FileManagerUtil.j(str));
      paramString.append(getString(2131889759));
      FMToastUtil.b(paramString.toString());
      this.app.getFileManagerEngine().b(paramDataLineMsgRecord.nWeiyunSessionId);
    }
    int i1 = 4;
    if (paramInt == -2000)
    {
      paramInt = 1;
    }
    else if (paramInt == -2005)
    {
      int i2 = FileManagerUtil.c(paramDataLineMsgRecord.filename);
      if (i2 == 0)
      {
        paramInt = 2;
      }
      else
      {
        paramInt = i1;
        if (i2 == 2) {
          paramInt = 3;
        }
      }
    }
    else
    {
      paramInt = 4;
    }
    i1 = P();
    paramDataLineMsgRecord = this.app;
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(i1);
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
        i1 = 1;
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
    int i1 = 0;
    label57:
    if (i1 != 0)
    {
      QQToast.makeText(getApplicationContext(), getString(2131892632), 0).show(getResources().getDimensionPixelSize(2131299920));
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
    str = a;
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
      QLog.i(a, 1, "savePicsAsCustomFace, calc md5!");
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
      if (FileManagerUtil.c(paramDataLineMsgRecord.filename) == 0) {
        paramInt = 3;
      } else {
        paramInt = 2;
      }
    }
    else {
      paramInt = 1;
    }
    int i1 = P();
    paramDataLineMsgSet = this.app;
    paramDataLineMsgRecord = new StringBuilder();
    paramDataLineMsgRecord.append("");
    paramDataLineMsgRecord.append(i1);
    ReportController.b(paramDataLineMsgSet, "dc00898", "", "", "0X800AD61", "0X800AD61", paramInt, 0, paramDataLineMsgRecord.toString(), "", "", "");
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null)
    {
      QQToast.makeText(getApplicationContext(), getString(2131892632), 0).show(getResources().getDimensionPixelSize(2131299920));
      return;
    }
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePicsAsCustomFace, md5:");
    localStringBuilder.append(paramMessageForPic.md5);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(paramMessageForPic, 1, "datalineface"), -1, -1, null, null, false);
    ((URLDrawable)localObject).setTag(paramMessageForPic);
    AIOGalleryUtils.a(this, this.app, (URLDrawable)localObject, paramMessageForPic.frienduin, getResources().getDimensionPixelSize(2131299920), null, paramMessageForPic.picExtraData);
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
  
  private void a(Runnable paramRunnable)
  {
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && ((checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      requestPermissions(new LiteActivity.40(this, paramRunnable), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    paramRunnable.run();
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
    this.V = true;
    ThreadManager.post(new LiteActivity.48(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.X == null)
    {
      this.X = DialogUtil.a(this, getString(2131888250), HardCodeUtil.a(2131898212), new LiteActivity.49(this));
      this.X.setOnDismissListener(new LiteActivity.50(this));
    }
    this.X.show();
  }
  
  static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    String str = (String)paramViewGroup.getTag(2131427359);
    if ((paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString)))
    {
      if ("none".equals(paramString))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131427359, "null");
      }
      else if (!paramString.equals(str))
      {
        a(paramString, new LiteActivity.14(paramIphoneTitleBarActivity, paramString, paramViewGroup));
      }
    }
    else if (!"null".equals(str))
    {
      paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
      paramViewGroup.setTag(2131427359, "null");
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
    LiteActivity.52 local52 = new LiteActivity.52();
    DialogUtil.a(paramContext, 233, paramContext.getString(2131917233), paramContext.getString(2131891300), 2131891275, 2131891275, local52, null).show();
  }
  
  private void b(View paramView)
  {
    VideoReport.setPageId(paramView, "pg_aio");
    HashMap localHashMap = new HashMap();
    VideoReport.resetPageParams(paramView);
    localHashMap.put("type_aio_pg", String.valueOf(5));
    VideoReport.setPageParams(paramView, new PageParams(localHashMap));
    VideoReport.setPageContentId(paramView, String.valueOf(SystemClock.elapsedRealtime()), true);
  }
  
  private String d(String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyForwardImageFile:error. filePath[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return paramString;
    }
    Object localObject1 = FileManagerUtil.a(paramString);
    long l1 = FileUtils.getFileSizes(paramString);
    if (l1 > 3145728L)
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyForwardImageFile:error. fileSize[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return paramString;
    }
    if ((float)l1 > FileUtils.getAvailableExternalMemorySize())
    {
      QLog.i(a, 1, "copyForwardImageFile:error. file space not enough");
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
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.B.setVisibility(0);
      if (this.j == 1)
      {
        this.C.setText(2131888330);
        this.D.setImageResource(2130839755);
      }
    }
    else
    {
      this.B.setVisibility(4);
    }
  }
  
  private void e(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    localQQCustomDialog.setTitle(getString(2131917233));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(getString(2131887625), new LiteActivity.51(this));
    localQQCustomDialog.show();
  }
  
  private static void f(String paramString)
  {
    paramString = new VFSFile(paramString);
    if (!paramString.exists()) {
      return;
    }
    paramString = paramString.listFiles();
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = paramString[i1];
      if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
        localObject.delete();
      }
      i1 += 1;
    }
  }
  
  public void A()
  {
    this.ac = true;
    c(false);
    Object localObject = this.h;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.ad.setVisibility(8);
    this.L.setVisibility(8);
    this.I.setVisibility(8);
    this.J.setVisibility(0);
    this.K.setVisibility(0);
    this.K.setEnabled(this.s.isEnabled());
    this.H.getLayoutParams().height = -1;
    this.q.getLayoutParams().height = -1;
    this.q.getLayoutParams().width = -1;
    this.q.setMaxLines(100);
    this.q.setGravity(48);
    localObject = ValueAnimator.ofInt(new int[] { this.ae.getHeight(), this.ae.getBottom() });
    ((ValueAnimator)localObject).addUpdateListener(new LiteActivity.55(this));
    ((ValueAnimator)localObject).addListener(new LiteActivity.56(this));
    ((ValueAnimator)localObject).setDuration(100L).setRepeatCount(0);
    ((ValueAnimator)localObject).start();
  }
  
  DataLineMsgRecord a(DataLineHandler paramDataLineHandler, SendInfo paramSendInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSendInfo == null) {
      return null;
    }
    paramDataLineHandler = new DataLineMsgRecord();
    String str1 = paramSendInfo.a();
    String str2 = paramSendInfo.b();
    paramDataLineHandler.sessionid = paramSendInfo.c();
    paramDataLineHandler.path = str1;
    paramDataLineHandler.thumbPath = str2;
    paramDataLineHandler.msgtype = DataLineHandler.b(paramInt1);
    paramDataLineHandler.groupId = paramInt2;
    paramDataLineHandler.groupSize = paramInt3;
    paramDataLineHandler.groupIndex = paramInt4;
    return paramDataLineHandler;
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.app.getFileManagerDataCenter().a(paramForwardFileInfo.e());
    if (localFileManagerEntity == null) {
      return null;
    }
    int i3 = DataLineHandler.a(localFileManagerEntity);
    if (!DataLineHandler.l(i3)) {
      return null;
    }
    int i2 = DataLineHandler.a(paramForwardFileInfo.i(), paramBoolean);
    int i1 = i2;
    if (!paramBoolean)
    {
      i1 = i2;
      if (i2 == 1) {
        i1 = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.b(i1);
    localDataLineMsgRecord.sessionid = ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.i();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.j();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.g();
    localDataLineMsgRecord.fileFrom = i3;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.p();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = HexUtil.hexStr2Bytes(localFileManagerEntity.strFileMd5);
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
    }
    if (TextUtils.isEmpty(paramForwardFileInfo.d()))
    {
      localDataLineMsgRecord.path = paramForwardFileInfo.i();
      return localDataLineMsgRecord;
    }
    localDataLineMsgRecord.path = paramForwardFileInfo.d();
    return localDataLineMsgRecord;
  }
  
  public void a()
  {
    Object localObject;
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.ae.findViewById(2131446058);
      ((View)localObject).setBackgroundResource(2130839241);
      ((View)localObject).setVisibility(0);
      localObject = this.ae.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
    }
    else
    {
      localObject = this.ae.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(true, false);
      }
      this.ae.findViewById(2131446058).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.ac) {
      b(true);
    }
    AIOUtils.q = true;
    paramInt = Integer.valueOf(paramInt).intValue();
    if (paramInt == this.b.getCurrentPanel())
    {
      this.b.b();
      return;
    }
    Object localObject;
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 16)
        {
          if (paramInt != 17) {
            return;
          }
          if (!f())
          {
            if (QLog.isColorLevel()) {
              QLog.i(a, 2, "click too fast , wait a minute.");
            }
          }
          else
          {
            g();
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
          CheckPermission.requestSDCardPermission(this, new LiteActivity.42(this));
          return;
        }
        J();
        ReportController.b(this.app, "dc00898", "", "", "0X800AD66", "0X800AD66", 0, 0, "", "", "", "");
        return;
      }
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktkphoto");
      k();
      ReportController.b(this.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00898", "", "", "0X800AD65", "0X800AD65", 0, 0, "", "", "", "");
      return;
    }
    if (QQTheme.isNowSimpleUI())
    {
      a(new LiteActivity.41(this));
    }
    else
    {
      this.b.a(4);
      localObject = this.c;
      if ((localObject != null) && (((PhotoListPanel)localObject).getVisibility() == 0)) {
        this.c.c();
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X800AD64", "0X800AD64", 0, 0, "", "", "", "");
    getIntent().putExtra("qq_sub_business_id", 107);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.y.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
  }
  
  void a(long paramLong, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    Object localObject1 = this.u;
    if (localObject1 != null)
    {
      ((QQCustomDialog)localObject1).show();
      return;
    }
    Object localObject2 = getString(2131916399);
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
    this.u = DialogUtil.a(this, 232, null, this.app.getApplication().getString(2131916405), (String)localObject1, this.app.getApplication().getString(2131916400), paramString, (DialogInterface.OnClickListener)localObject2);
    this.u.show();
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
          this.t.a(paramIntent);
        }
      }
      else {
        this.t.a(paramIntent);
      }
    }
  }
  
  void a(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      FMToastUtil.a(2131892157);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.b()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      localObject1 = getString(2131889589);
    }
    else if (localDataLineMsgSet.getGroupType() == -1000)
    {
      localObject1 = getString(2131891344);
    }
    else if ((localDataLineMsgSet.getGroupType() == -2000) && (!localDataLineMsgSet.isSingle()))
    {
      localObject1 = localDataLineMsgSet.values().iterator();
      int i1 = 0;
      while (((Iterator)localObject1).hasNext()) {
        if (DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
          i1 += 1;
        }
      }
      localObject1 = String.format(getString(2131891316), new Object[] { Integer.valueOf(i1) });
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (((String)localObject1).equals("")) {
      localObject2 = getString(2131891343);
    }
    Object localObject1 = (ActionSheet)ActionSheetHelper.b(this, null);
    ((ActionSheet)localObject1).setMainTitle((CharSequence)localObject2);
    ((ActionSheet)localObject1).addButton(getResources().getString(2131889805), 1);
    ((ActionSheet)localObject1).addCancelButton(2131887648);
    ((ActionSheet)localObject1).setOnButtonClickListener(new LiteActivity.24(this, localDataLineMsgSet, paramItemHolder, (ActionSheet)localObject1));
    ((ActionSheet)localObject1).show();
  }
  
  void a(com.tencent.imcore.message.Message paramMessage)
  {
    if ((paramMessage != null) && (!paramMessage.isread) && (!paramMessage.isSendFromLocal()) && (!this.app.isTroopMark(paramMessage)) && (!this.ac))
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
      QQToast.makeText(this, HardCodeUtil.a(2131904127), 1).show(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramString, this.j);
    ReportController.b(this.app, "dc00898", "", "", "0X800AD68", "0X800AD68", 0, 0, "", "", "", "");
    this.m.notifyDataSetChanged();
    a(this.g, this.f);
    a(this.f);
  }
  
  void a(String paramString, long paramLong, int paramInt)
  {
    if (!s())
    {
      b(null);
      return;
    }
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.app.getMessageFacade().d(i1).a(paramLong);
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
          this.app.getMessageFacade().d(i1).h(paramLong);
          a(paramString);
        }
        else
        {
          if (FileUtils.fileExists(paramString)) {
            localDataLineHandler.a(paramString, localDataLineMsgRecord.thumbPath, 0, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
          }
          if (localDataLineMsgRecord.nOpType == 35) {
            localDataLineHandler.c(localDataLineMsgRecord);
          } else {
            localDataLineHandler.n().a(localDataLineMsgRecord, i1, 2);
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
    this.m.notifyDataSetChanged();
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
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationDataline.a);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationDataline.a);
    int i1 = PlusPanelUtils.a(this.app, this, this.d, paramArrayList, localIntent, localActivityURIRequest);
    localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "");
    localActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "");
    localActivityURIRequest.extra().putInt(AlbumConstants.h, 55);
    localActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localActivityURIRequest.extra().putBoolean("PhotoConst.original_button", true);
    if (i1 != -1)
    {
      paramArrayList = this.c;
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.s();
        if (paramArrayList != null) {
          localActivityURIRequest.extra().putSerializable("PhotoConst.editPathMap", paramArrayList);
        }
      }
      localActivityURIRequest.setRequestCode(i1);
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
        QLog.d(a, 2, "sendMultipleFile paths is null !!!!!!");
      }
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        i1 += 1;
      }
    }
    LiteActivity.16 local16 = new LiteActivity.16(this, paramArrayList);
    paramArrayList = paramArrayList.iterator();
    long l1 = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l1 += new VFSFile(str).length();
      }
    }
    if (l1 == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.isNetworkAvailable(this)) && (!NetworkUtil.isWifiConnected(this)) && (l1 > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this, 2131889584, 2131889589, new LiteActivity.17(this, local16, paramInt));
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
      int i1 = FileManagerUtil.c(str);
      if (2 == i1) {
        localArrayList1.add(str);
      } else if (i1 == 0) {
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
    l();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      int i1 = DataLineMsgRecord.getDevTypeBySeId(paramObservable.sessionid);
      DataLineMsgSet localDataLineMsgSet = this.app.getDataLineMsgProxy(i1).c(paramObservable.sessionid);
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
        if (!this.m.a(paramObservable.sessionid, this.f)) {
          this.m.notifyDataSetChanged();
        }
      }
      else {
        this.m.notifyDataSetChanged();
      }
    }
    else if ((paramObject instanceof com.tencent.imcore.message.Message))
    {
      paramObservable = (com.tencent.imcore.message.Message)paramObject;
      if (paramObservable.frienduin == null) {
        return;
      }
      if (paramObservable.frienduin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
        this.m.notifyDataSetChanged();
      }
    }
    else if ((paramObject instanceof RecentUser))
    {
      paramObservable = (RecentUser)paramObject;
      if (paramObservable.uin == null) {
        return;
      }
      if (paramObservable.uin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
        this.m.notifyDataSetChanged();
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
          a(this.app.getMessageFacade().B());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.m.notifyDataSetChanged();
    this.app.getMessageFacade().d(this.j).g();
    if (!paramBoolean)
    {
      a(this.g, this.f);
      a(this.f);
    }
  }
  
  @TargetApi(18)
  boolean a(long paramLong)
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      p();
      return false;
    }
    long l1;
    if (Build.VERSION.SDK_INT >= 18) {
      l1 = new StatFs(AppConstants.SDCARD_ROOT).getAvailableBytes();
    } else {
      l1 = new StatFs(AppConstants.SDCARD_ROOT).getAvailableBlocks() * new StatFs(AppConstants.SDCARD_ROOT).getBlockSize();
    }
    if (l1 < paramLong)
    {
      o();
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
    Object localObject = this.app.getFileManagerDataCenter().a(paramIntent.e());
    if (localObject == null) {
      return false;
    }
    int i1 = DataLineHandler.a((FileManagerEntity)localObject);
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            paramIntent = a;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("forwardFile fileFrom ");
            ((StringBuilder)localObject).append(i1);
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
          paramIntent = a(paramIntent, bool, this.j);
          if (paramIntent == null) {
            return false;
          }
          ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramIntent, false);
          return true;
        }
        if (this.j == 0)
        {
          this.app.getFileManagerEngine().a(paramIntent.e(), paramIntent.k(), paramIntent.b(), Long.parseLong(this.app.getCurrentAccountUin()), 7, paramIntent.a());
          return true;
        }
        this.app.getFileManagerEngine().a(paramIntent.e(), paramIntent.k(), paramIntent.b(), Long.parseLong(this.app.getCurrentAccountUin()), 6003, paramIntent.a());
        return true;
      }
      this.app.getFileManagerEngine().a(3, paramIntent.e(), this.j);
      return true;
    }
    return false;
  }
  
  boolean a(View paramView)
  {
    Object localObject1 = this.Q;
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
    int i1 = localDataLineMsgSet.getGroupType();
    boolean bool;
    if (localDataLineMsgSet.isSingle())
    {
      i2 = localDataLineMsgSet.getGroupType();
      Object localObject3;
      String str;
      if ((i2 != -2335) && (i2 != -2009) && (i2 != -2005))
      {
        if (i2 != -2000)
        {
          if (i2 != -1000)
          {
            localObject2 = "";
            localObject1 = null;
          }
          else
          {
            localObject1 = localItemHolder.f().b;
            localQQCustomMenu.a(2131431423, paramView.getContext().getString(2131888244), 2130839057);
            localQQCustomMenu.a(2131433636, paramView.getContext().getString(2131889668), 2130839066);
            localQQCustomMenu.a(2131432813, paramView.getContext().getString(2131889171), 2130839065);
            localObject2 = "";
          }
        }
        else
        {
          localObject3 = localItemHolder.d().d;
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
                localQQCustomMenu.a(2131427822, getString(2131890796), 2130839064);
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
          localObject1 = localItemHolder.d().d;
        }
        else
        {
          localObject2 = localItemHolder.c().m;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = (RelativeLayout)localItemHolder.i().a;
          }
        }
        localObject2 = localDataLineMsgRecord.path;
      }
      if (localObject1 == null) {
        return false;
      }
      Context localContext = ((RelativeLayout)localObject1).getContext();
      if (localDataLineMsgRecord.canForward()) {
        localQQCustomMenu.a(2131433636, localContext.getString(2131891301), 2130839066);
      }
      if ((FileUtils.fileExistsAndNotEmpty((String)localObject2)) && (localDataLineMsgRecord.strMoloKey == null))
      {
        if (localDataLineMsgSet.getGroupType() == -2005)
        {
          bool = TencentDocConvertConfigProcessor.a().c();
          long l1 = FileManagerUtil.v(localDataLineMsgRecord.filename);
          str = TencentDocImportFileInfoProcessor.a().d();
          localObject3 = str;
          if (TextUtils.isEmpty(str)) {
            localObject3 = ".doc|.docx|.xls|.xlsx|";
          }
          if ((bool) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport((String)localObject2, localDataLineMsgRecord.filename, (String)localObject3)) && (localDataLineMsgRecord.filesize <= l1))
          {
            ReportController.b(this.app, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
            localQQCustomMenu.a(2131446941, paramView.getContext().getString(2131917094), 2130839078);
          }
        }
        if (localDataLineMsgSet.getGroupType() == -2000) {
          localQQCustomMenu.a(2131432813, paramView.getContext().getString(2131889171), 2130839065);
        } else if ((localDataLineMsgSet.getGroupType() == -2009) && (FileUtils.fileExistsAndNotEmpty((String)localObject2))) {
          localQQCustomMenu.a(2131432813, paramView.getContext().getString(2131889171), 2130839065);
        } else if ((localDataLineMsgSet.getGroupType() == -2005) && (FileUtils.fileExistsAndNotEmpty((String)localObject2))) {
          localQQCustomMenu.a(2131432813, paramView.getContext().getString(2131889171), 2130839065);
        }
        if (a(this.app, localDataLineMsgRecord)) {
          localQQCustomMenu.a(2131449192, localContext.getString(2131889327), 2130839079);
        }
      }
      paramView = (View)localObject2;
    }
    else
    {
      i2 = localDataLineMsgSet.getGroupType();
      if ((i2 != -2335) && (i2 != -2009) && (i2 != -2005))
      {
        if (i2 != -2000) {
          paramView = null;
        } else {
          paramView = localItemHolder.e().d;
        }
      }
      else if (localDataLineMsgRecord.bIsMoloImage) {
        paramView = localItemHolder.e().d;
      } else {
        paramView = localItemHolder.c().m;
      }
      if (paramView == null) {
        return false;
      }
      localObject2 = "";
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    localObject1 = ((RelativeLayout)localObject1).getContext();
    localQQCustomMenu.a(2131431703, ((Context)localObject1).getString(2131891284), 2130839061);
    if ((localDataLineMsgSet.getGroupType() != -2000) && ((localDataLineMsgSet.getGroupType() != -2335) || (!localDataLineMsgRecord.bIsMoloImage))) {
      bool = false;
    } else {
      bool = true;
    }
    localObject1 = new LiteActivity.29(this, localDataLineMsgRecord, localDataLineMsgSet, (Context)localObject1, i1, paramView, bool);
    Object localObject2 = this.ae;
    if (localObject2 != null)
    {
      paramView = new int[2];
      ((InputLinearLayout)localObject2).getLocationInWindow(paramView);
    }
    else
    {
      paramView = null;
    }
    localObject2 = localItemHolder.b;
    i1 = (int)this.af.x;
    int i2 = (int)this.af.y;
    if (paramView == null) {
      paramView = null;
    } else {
      paramView = Integer.valueOf(paramView[1]);
    }
    this.Q = BubbleContextMenu.a((View)localObject2, i1, i2, localQQCustomMenu, (View.OnClickListener)localObject1, paramView);
    this.Q.setOnDismissListener(new LiteActivity.1DissmissListener(this));
    return true;
  }
  
  public boolean a(PhotoListPanel paramPhotoListPanel)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onAlbumBtnClicked");
    }
    ArrayList localArrayList = null;
    if (!paramPhotoListPanel.d.isEmpty()) {
      localArrayList = new ArrayList(paramPhotoListPanel.d);
    }
    a(localArrayList);
    paramPhotoListPanel.l();
    ReportController.b(null, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
    return true;
  }
  
  public boolean a(Object paramObject)
  {
    int i1 = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onPanelIconLongClick panelID=");
      paramObject.append(i1);
      QLog.d("XPanel", 2, paramObject.toString());
    }
    if (i1 != 4) {
      return false;
    }
    if (!QQTheme.isNowSimpleUI()) {
      a(new LiteActivity.39(this));
    }
    return true;
  }
  
  public View b(int paramInt)
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
        requestPermissions(new LiteActivity.43(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      } else {
        return K();
      }
    }
    return null;
  }
  
  void b()
  {
    this.f = ((XListView)findViewById(2131437342));
    this.f.setStackFromBottom(true);
    this.f.setAdapter(this.m);
    View localView = LayoutInflater.from(this).inflate(2131624523, null);
    this.f.setOverScrollHeader(localView);
    this.f.setSelection(this.m.getCount());
    this.f.setOnTouchListener(new LiteActivity.4(this));
    this.f.setOverScrollListener(new LiteActivity.5(this));
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    w();
    if (paramInt2 == 0) {
      this.E = false;
    } else if (1 == paramInt2) {
      this.E = true;
    }
    L();
  }
  
  protected void b(Intent paramIntent)
  {
    int i1 = this.j;
    String str1 = this.k;
    this.k = paramIntent.getStringExtra("targetUin");
    String str2 = this.k;
    if ((str2 != null) && (str2.length() != 0))
    {
      if (this.k.equals(AppConstants.DATALINE_IPAD_UIN))
      {
        setTitle(2131891355);
        this.j = 1;
      }
      else
      {
        setTitle(2131891354);
        this.j = 0;
      }
    }
    else if (this.j == -1)
    {
      this.j = paramIntent.getIntExtra("device_type", -1);
      if (this.j == 1)
      {
        setTitle(2131891355);
        this.k = AppConstants.DATALINE_IPAD_UIN;
      }
      else
      {
        setTitle(2131891354);
        this.k = AppConstants.DATALINE_PC_UIN;
        this.j = 0;
      }
    }
    else
    {
      this.j = i1;
      this.k = str1;
    }
    paramIntent = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    paramIntent.b = this.k;
    paramIntent.c = this.j;
  }
  
  void b(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      FMToastUtil.a(2131892157);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.b()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 3145728L)) {
      paramItemHolder = getString(2131889586);
    } else {
      paramItemHolder = "";
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = localDataLineMsgSet.values().iterator();
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
      if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
      {
        l1 += localDataLineMsgRecord.filesize;
        localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      }
    }
    if ((localArrayList.size() == 0) && (!localDataLineMsgSet.isSingle()))
    {
      int i1 = localDataLineMsgSet.getTotalCount() - localDataLineMsgSet.getComeCount();
      if ((localDataLineMsgSet.getGroupType() != -2000) && ((localDataLineMsgSet.getGroupType() != -2335) || (!localDataLineMsgSet.getFirstItem().bIsMoloImage))) {
        paramItemHolder = String.format(getString(2131891325), new Object[] { Integer.valueOf(i1) });
      } else {
        paramItemHolder = String.format(getString(2131891313), new Object[] { Integer.valueOf(i1) });
      }
      localObject = new LiteActivity.25(this);
      DialogUtil.a(this, 230, getString(2131891303), paramItemHolder, 2131892267, 2131892267, null, (DialogInterface.OnClickListener)localObject).show();
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
          localObject = String.format(getString(2131891315), new Object[] { Integer.valueOf(localArrayList.size()) });
        }
      }
    }
    paramItemHolder = (ItemHolder)localObject;
    if (((String)localObject).equals("")) {
      paramItemHolder = getString(2131891341);
    }
    localObject = (ActionSheet)ActionSheetHelper.b(this, null);
    ((ActionSheet)localObject).setMainTitle(paramItemHolder);
    ((ActionSheet)localObject).addButton(getResources().getString(2131889804), 1);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new LiteActivity.26(this, l1, localDataLineMsgSet, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  void b(String paramString)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.time = MessageCache.c();
    localDataLineMsgRecord.msgtype = -2334;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.issend = 255;
    localDataLineMsgRecord.msg = paramString;
    this.l.appendToList(localDataLineMsgRecord);
    this.m.notifyDataSetChanged();
  }
  
  void b(ArrayList<SendInfo> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    for (;;)
    {
      int i2 = paramArrayList.size();
      if (i2 <= 3)
      {
        i1 = 0;
        while (i1 < i2)
        {
          localObject1 = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, 0, 0, 0);
          if (localObject1 != null) {
            localDataLineHandler.a((DataLineMsgRecord)localObject1, false);
          }
          i1 += 1;
        }
      }
      DataLineMsgRecord localDataLineMsgRecord;
      Object localObject2;
      if ((i2 > 3) && (i2 < 50))
      {
        localObject1 = new ArrayList();
        int i3 = localDataLineHandler.g();
        i1 = 0;
        while (i1 < i2)
        {
          localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, i3, i2, i1);
          if (localDataLineMsgRecord != null) {
            ((ArrayList)localObject1).add(localDataLineMsgRecord);
          }
          localObject2 = localObject1;
          if (DataLineMsgSet.isSingle(paramInt, i3))
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
          i1 += 1;
          localObject1 = localObject2;
        }
        if (((ArrayList)localObject1).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject1, false);
        }
        return;
      }
      Object localObject1 = new ArrayList();
      i2 = localDataLineHandler.g();
      int i1 = 0;
      while (i1 < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i1), paramInt, i2, 50, i1);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject1).add(localDataLineMsgRecord);
        }
        localObject2 = localObject1;
        if (DataLineMsgSet.isSingle(paramInt, i2))
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
        i1 += 1;
        localObject1 = localObject2;
      }
      if (((ArrayList)localObject1).size() > 0) {
        localDataLineHandler.a((ArrayList)localObject1, false);
      }
      i1 = 0;
      while (i1 < 50)
      {
        paramArrayList.remove(0);
        i1 += 1;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.ac = false;
    c(true);
    this.ad.setVisibility(0);
    this.L.setVisibility(0);
    this.s.setEnabled(this.K.isEnabled());
    this.K.setVisibility(8);
    this.J.setVisibility(8);
    this.ae.getLayoutParams().height = -2;
    this.H.getLayoutParams().height = -2;
    if (paramBoolean)
    {
      this.ae.setPadding(0, AIOUtils.b(8.0F, this.app.getApplication().getResources()), 0, 0);
      this.q.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.q.getLayoutParams()).setMargins(AIOUtils.b(14.0F, this.app.getApplication().getResources()), 0, 0, 0);
      this.q.setMaxLines(6);
      this.q.setBackgroundResource(2130851969);
      this.q.setGravity(16);
      this.q.setPadding(AIOUtils.b(11.0F, this.app.getApplication().getResources()), AIOUtils.b(6.0F, this.app.getApplication().getResources()), AIOUtils.b(11.0F, this.app.getApplication().getResources()), AIOUtils.b(6.0F, this.app.getApplication().getResources()));
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.q.getHeight(), AIOUtils.b(100.0F, this.app.getApplication().getResources()) });
    localValueAnimator.addUpdateListener(new LiteActivity.53(this));
    localValueAnimator.addListener(new LiteActivity.54(this));
    localValueAnimator.setDuration(100L).setRepeatCount(0);
    localValueAnimator.start();
  }
  
  public boolean b(PhotoListPanel paramPhotoListPanel)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = paramPhotoListPanel.d.iterator();
    String str;
    for (long l1 = 0L; ((Iterator)localObject3).hasNext(); l1 += new VFSFile(str).length())
    {
      str = (String)((Iterator)localObject3).next();
      int i1 = paramPhotoListPanel.f.a(str);
      if (1 == i1) {
        ((ArrayList)localObject1).add(str);
      } else if (i1 == 0) {
        ((ArrayList)localObject2).add(str);
      }
    }
    if (l1 == 0L)
    {
      a(this);
      return true;
    }
    if ((NetworkUtil.isNetworkAvailable(this)) && (!NetworkUtil.isWifiConnected(this)) && (l1 > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this, 2131889584, 2131889589, new LiteActivity.45(this, (ArrayList)localObject2, (ArrayList)localObject1));
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
    paramPhotoListPanel.l();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramPhotoListPanel.d.size());
    ((StringBuilder)localObject1).append("");
    ReportController.b(null, "CliOper", "", "", "0X8005A2F", "0X8005A2F", 0, 0, ((StringBuilder)localObject1).toString(), "", "", "");
    return true;
  }
  
  void c()
  {
    this.app.getMessageFacade().d(this.j).a(15, new LiteActivity.6(this));
  }
  
  void c(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("aio_msg_source", 999);
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    this.z = bool;
    if (this.z)
    {
      AIOUtils.q = false;
      this.A = false;
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
    if (this.M == null)
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
        this.M = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.M;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public boolean c(int paramInt)
  {
    return false;
  }
  
  void d()
  {
    this.q = ((XEditTextEx)findViewById(2131435808));
    TextWatcher localTextWatcher = this.r;
    if (localTextWatcher != null) {
      this.q.removeTextChangedListener(localTextWatcher);
    } else {
      this.r = new LiteActivity.7(this);
    }
    try
    {
      this.q.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    }
    catch (Exception localException)
    {
      QLog.e(a, 1, "input set error", localException);
    }
    this.q.addTextChangedListener(this.r);
    this.q.setFilters(new InputFilter[] { new LiteActivity.8(this) });
    DeviceLib.a(this, this.q);
    j();
    this.q.setOnTouchListener(new LiteActivity.9(this));
    this.q.getViewTreeObserver().addOnGlobalLayoutListener(new LiteActivity.10(this));
  }
  
  void d(Intent paramIntent)
  {
    paramIntent = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!paramIntent.equalsIgnoreCase(""))
    {
      PlusPanelUtils.a = paramIntent;
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
      ImageUtil.b(this, paramIntent);
      if (!FileUtils.isPicFile(paramIntent))
      {
        QQToast.makeText(this, getString(2131889404), 0).show(getTitleBarHeight());
        return;
      }
      if (!new VFSFile(paramIntent).exists())
      {
        QQToast.makeText(this, getString(2131892634), 0).show(getTitleBarHeight());
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
    QQToast.makeText(this, getString(2131892634), 0).show(getTitleBarHeight());
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
    if (!s())
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
                      this.m.notifyDataSetChanged();
                      return;
                    }
                    if (paramInt2 == -1) {
                      a(false);
                    }
                  }
                  else if (paramInt2 == -1)
                  {
                    PhotoListPanel localPhotoListPanel = this.c;
                    if (localPhotoListPanel != null) {
                      localPhotoListPanel.a(paramInt1, paramIntent);
                    }
                  }
                }
                else {
                  L();
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
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    F();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131165716);
    setContentView(2131624638);
    setStatusBarBlue();
    boolean bool = ThemeUtil.isDefaultOrDIYTheme(false);
    this.ad = ((ViewGroup)findViewById(2131444897));
    if (bool) {
      this.ad.setBackgroundResource(2130852229);
    } else {
      this.ad.setBackgroundResource(2130852228);
    }
    this.ae = ((InputLinearLayout)findViewById(2131435809));
    Object localObject1 = (ImageView)this.ad.findViewById(2131436666);
    if (localObject1 != null) {
      ViewCompat.setImportantForAccessibility((View)localObject1, 2);
    }
    setTitle(2131891354);
    getWindow().setBackgroundDrawable(null);
    b(getIntent());
    c(getIntent());
    m();
    this.B = ((RelativeLayout)findViewById(2131450123));
    this.C = ((TextView)findViewById(2131437345));
    this.D = ((ImageView)findViewById(2131437344));
    if (this.j == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8005D19", "0X8005D19", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "=== dataline report event into ipad 0X8005D19 ");
      }
    }
    this.t = new LiteActivity.LiteJumpAction(this, this);
    this.app.getFileManagerNotifyCenter().addObserver(this.T);
    localObject1 = this.app.getMessageFacade();
    if (localObject1 != null) {
      ((QQMessageFacade)localObject1).addObserver(this);
    }
    this.l = this.app.getDataLineMsgProxy(this.j).a(true);
    this.m = new DatalineSessionAdapterUseNewFileBubble(this, this.l, this, this.app);
    b();
    d();
    localObject1 = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    ((DataLineHandler)localObject1).f = true;
    this.g = new ScrollerRunnable(this.f);
    this.g.a();
    this.i = ((RelativeLayout)findViewById(2131430649));
    this.b = ((XPanelContainer)findViewById(2131445137));
    this.b.setOnPanelChangeListener(this);
    e();
    this.x = ((PanelIconLinearLayout)findViewById(2131439817));
    this.x.setPanelIconListener(this);
    this.x.setPanelIconLongListener(this);
    this.x.a(this.app, this.d, null);
    this.x.a(null);
    this.b.a(this.q);
    this.s = ((Button)findViewById(2131445568));
    this.s.setOnClickListener(this);
    t();
    addObserver(this.P);
    r();
    this.app.getMessageFacade().d(this.j).g();
    if (paramBundle == null) {
      this.y.postDelayed(new LiteActivity.1(this), 200L);
    }
    a(getIntent());
    paramBundle = (RegisterProxySvcPackHandler)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    if ((paramBundle.d() == 0) && (!paramBundle.j()))
    {
      paramBundle.a();
      paramBundle.b(true);
    }
    if (!this.l.isEmpty())
    {
      paramBundle = getSharedPreferences("first_enter_dataline", 0);
      int i1 = paramBundle.getInt("year", -1);
      int i2 = paramBundle.getInt("month", -1);
      int i3 = paramBundle.getInt("day", -1);
      Object localObject2 = Calendar.getInstance();
      int i4 = ((Calendar)localObject2).get(1);
      int i5 = ((Calendar)localObject2).get(2);
      int i6 = ((Calendar)localObject2).get(5);
      if ((i4 != i1) || (i5 != i2) || (i6 != i3))
      {
        localObject2 = this.l;
        localObject2 = ((DataLineMsgSetList)localObject2).get(((DataLineMsgSetList)localObject2).size() - 1);
        if (localObject2 != null)
        {
          localObject2 = ((DataLineMsgSet)localObject2).getFirstItem();
          if ((localObject2 != null) && (((DataLineMsgRecord)localObject2).msgtype != -5000))
          {
            localObject2 = this.l.iterator();
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
                    this.app.getDataLineMsgProxy(this.j).a(localDataLineMsgSet);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                  }
                }
              }
            }
            localObject1 = ((DataLineHandler)localObject1).a(0, this.j);
            localObject2 = new DataLineMsgRecord();
            ((DataLineMsgRecord)localObject2).msgId = ((Long)localObject1).longValue();
            ((DataLineMsgRecord)localObject2).sessionid = ((Long)localObject1).longValue();
            ((DataLineMsgRecord)localObject2).msgtype = -5000;
            ((DataLineMsgRecord)localObject2).time = MessageCache.c();
            ((DataLineMsgRecord)localObject2).isread = true;
            this.app.getDataLineMsgProxy(this.j).a((DataLineMsgRecord)localObject2);
            paramBundle = paramBundle.edit();
            paramBundle.putInt("year", i4);
            paramBundle.putInt("month", i5);
            paramBundle.putInt("day", i6);
            paramBundle.commit();
          }
        }
      }
    }
    D();
    this.H = findViewById(2131433906);
    this.I = ((ImageButton)findViewById(2131433904));
    this.J = ((ImageButton)findViewById(2131435038));
    this.L = ((LinearLayout)findViewById(2131433921));
    this.K = ((PatchedButton)findViewById(2131433905));
    this.I.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.K.setOnClickListener(this);
    if (AppSetting.e)
    {
      this.I.setContentDescription(HardCodeUtil.a(2131904126));
      this.J.setContentDescription(HardCodeUtil.a(2131904125));
    }
    this.ab = new LiteCopyPromptHelper(this, this.b, this.app, this.q);
    this.ab.a();
    C();
    AIODtReportHelper.a(this.x);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.g;
    if (localObject != null) {
      ((ScrollerRunnable)localObject).b();
    }
    if (this.app.getMessageFacade() != null)
    {
      this.app.getMessageFacade().d(this.j).g();
      this.app.getMessageFacade().d(this.j).f();
      this.app.getMessageFacade().deleteObserver(this);
      this.m.notifyDataSetChanged();
    }
    localObject = this.P;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    if (this.T != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.T);
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.u = null;
    }
    this.j = -1;
    if (this.app.getFileManagerProxy() != null) {
      this.app.getFileManagerProxy().e();
    }
    this.q.setVisibility(8);
    localObject = this.c;
    if (localObject != null) {
      ((PhotoListPanel)localObject).setSelectLimitListener(null);
    }
    FileManagerUtil.a(this);
    if (this.Z)
    {
      this.f.getViewTreeObserver().removeGlobalOnLayoutListener(this.aa);
      this.Y.c();
    }
    this.ab.b();
    QLog.d(a, 1, "doOnDestroy");
    if ((this.v) && (!getIntent().getBooleanExtra("isMigSdkShare", false))) {
      com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = false;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    i(paramIntent);
    i();
    h(paramIntent);
    e(paramIntent);
    this.m.notifyDataSetChanged();
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    QLog.d(a, 1, "doOnPause");
    ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).e();
    if (this.Z) {
      this.Y.b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(this, this.b);
    this.m.notifyDataSetChanged();
    PhotoListPanel localPhotoListPanel = this.c;
    if ((localPhotoListPanel != null) && (localPhotoListPanel.getVisibility() == 0)) {
      this.c.c();
    }
    ApngImage.playByTag(0);
    a();
    if (this.Z) {
      this.Y.a();
    }
  }
  
  void e()
  {
    if (this.j == 1)
    {
      this.d.b = AppConstants.DATALINE_IPAD_UIN;
      this.d.a = 6003;
      return;
    }
    this.d.b = AppConstants.DATALINE_PC_UIN;
    this.d.a = 6000;
  }
  
  public void e(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.w = ForwardOptionBuilder.a(paramIntent, this.app, this);
      paramIntent = new Bundle();
      paramIntent.putString("uin", String.valueOf(AppConstants.DATALINE_PC_UIN));
      paramIntent.putInt("uintype", -1);
      this.w.a(ForwardAbility.ForwardAbilityType.g.intValue(), paramIntent);
      return;
    }
    Object localObject = h();
    this.q.setText((CharSequence)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      BaseAIOUtils.c(this.q);
      this.q.setSelection(((String)localObject).length());
    }
    int i1 = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if (55 == i1)
    {
      if (paramIntent.getExtras().containsKey("PhotoConst.PHOTO_PATHS"))
      {
        localObject = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
        if (((List)localObject).size() > 0)
        {
          a((List)localObject);
          paramIntent = this.c;
          if (paramIntent != null) {
            paramIntent.l();
          }
          paramIntent = this.x;
          if (paramIntent != null) {
            paramIntent.setAllUnSelected();
          }
          paramIntent = this.b;
          if (paramIntent != null) {
            paramIntent.b();
          }
          return;
        }
      }
      if (paramIntent.getExtras().containsKey("file_send_path"))
      {
        c(paramIntent.getExtras().getString("file_send_path"));
        localObject = this.c;
        if (localObject != null) {
          ((PhotoListPanel)localObject).l();
        }
        localObject = this.x;
        if (localObject != null) {
          ((PanelIconLinearLayout)localObject).setAllUnSelected();
        }
        localObject = this.b;
        if (localObject != null) {
          ((XPanelContainer)localObject).b();
        }
      }
    }
    else if (56 == i1)
    {
      c(paramIntent.getExtras().getString("file_send_path"));
      localObject = this.c;
      if (localObject != null) {
        ((PhotoListPanel)localObject).l();
      }
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      getIntent().removeExtra("PhotoConst.SEND_FLAG");
      a(paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS"));
      localObject = this.c;
      if (localObject != null) {
        ((PhotoListPanel)localObject).l();
      }
    }
    if (paramIntent.getBooleanExtra("isMigSdkShare", false)) {
      getIntent().putExtra("isMigSdkShare", true);
    }
    g(paramIntent);
    f(paramIntent);
  }
  
  void f(Intent paramIntent)
  {
    if (paramIntent.hasExtra("JumpAction.Text"))
    {
      paramIntent = paramIntent.getStringExtra("JumpAction.Text");
      if ((paramIntent != null) && (paramIntent.length() > 0))
      {
        this.q.setText(paramIntent);
        this.q.requestFocus();
        this.q.setSelection(paramIntent.length());
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.q, 0);
      }
    }
  }
  
  protected boolean f()
  {
    return this.F;
  }
  
  public void finish()
  {
    super.finish();
    i();
    ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).f = false;
    n();
    if ((this.z) && (AIOUtils.q) && (!this.A))
    {
      super.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      this.A = true;
    }
  }
  
  protected void g()
  {
    this.F = false;
    new Handler().postDelayed(new LiteActivity.11(this), 1500L);
  }
  
  void g(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("dataline_forward_type", -1);
    if (i1 == -1) {
      return;
    }
    paramIntent.getIntExtra("dataline_forward_type", -1);
    long l2 = paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false))
    {
      if (i1 == 100) {
        i1 = 0;
      } else {
        i1 = 1;
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
      int i2;
      int i3;
      break label108;
    }
    Object localObject1 = null;
    if (localObject1 == null)
    {
      q();
      return;
    }
    localObject2 = new ArrayList();
    localObject3 = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localObject1 = ((ArrayList)localObject1).iterator();
    i1 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = a((ForwardFileInfo)((Iterator)localObject1).next(), false, this.j);
      if (localObject4 != null) {
        if (DataLineMsgSet.isSingle((DataLineMsgRecord)localObject4))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject4);
          ((DataLineHandler)localObject3).a(localArrayList, false);
          i1 = 1;
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
    else if (i1 == 0)
    {
      q();
      break label1455;
      localObject2 = ((ArrayList)localObject1).iterator();
      for (i2 = 0; ((Iterator)localObject2).hasNext(); i2 = i3)
      {
        label278:
        localObject3 = (String)((Iterator)localObject2).next();
        if ((localObject3 != null) && (!((String)localObject3).equals("/"))) {
          break label278;
        }
        i3 = i2;
        if (i2 == 0)
        {
          q();
          i3 = 1;
        }
        ((Iterator)localObject2).remove();
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        a((ArrayList)localObject1, i1);
      }
      else if (i2 == 0)
      {
        q();
        break label1455;
        localObject2 = new ArrayList();
        if (a(paramIntent, i1)) {
          return;
        }
        switch (i1)
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
            localObject1 = a;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleForwardRequest forward image, extras: ");
            ((StringBuilder)localObject2).append(paramIntent.getExtras().toString());
            QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject3 = ((String)localObject1).split(";");
            ((ArrayList)localObject2).clear();
            i1 = 0;
            while (i1 < localObject3.length)
            {
              try
              {
                if (FileUtils.fileExists(localObject3[i1])) {
                  localObject1 = localObject3[i1];
                } else {
                  localObject1 = URLDecoder.decode(localObject3[i1], "UTF-8");
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                boolean bool;
                long l1;
                break label847;
              }
              catch (IllegalArgumentException localIllegalArgumentException1)
              {
                break label685;
              }
              localObject1 = localObject3[i1];
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
              i1 += 1;
              continue;
              if (QLog.isColorLevel())
              {
                paramIntent = new StringBuilder();
                paramIntent.append("shareFromMigSdk|decode exp. imageUrls[i]=");
                paramIntent.append(localObject3[i1]);
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
          label847:
          StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_file");
          localObject1 = QfavHelper.a(paramIntent.getExtras(), this.d.b, this.d.a);
          if (localObject1 != null)
          {
            paramIntent = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
            if (paramIntent != null) {
              i1 = paramIntent.a;
            } else {
              i1 = 0;
            }
            this.app.getFileManagerEngine().a((FileManagerEntity)localObject1, this.d.b, this.d.a, i1);
            return;
          }
          localObject1 = paramIntent.getStringExtra("dataline_forward_path");
          if ((localObject1 != null) && (!((String)localObject1).equals("")))
          {
            localObject3 = ((String)localObject1).split(";");
            ((ArrayList)localObject2).clear();
            i1 = 0;
            label1194:
            while (i1 < localObject3.length) {}
          }
          break;
        }
      }
    }
    try
    {
      localObject1 = URLDecoder.decode(localObject3[i1], "UTF-8");
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      break label1326;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      label1216:
      break label1216;
    }
    localObject1 = localObject3[i1];
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
    i1 += 1;
    break label1194;
    label1326:
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("shareFromMigSdk|decode exp. imageUrls[i]=");
      paramIntent.append(localObject3[i1]);
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
          break label1455;
          q();
          return;
        }
      }
    }
    label1455:
    if (!this.v) {
      this.v = paramIntent.getExtras().getBoolean("is_share_flag");
    }
    bool = paramIntent.getExtras().getBoolean("refuse_show_share_result_dialog", false);
    if ((this.v) && (!bool))
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
  
  String h()
  {
    String str;
    int i1;
    if (this.j == 1)
    {
      str = AppConstants.DATALINE_IPAD_UIN;
      i1 = 6003;
    }
    else
    {
      str = AppConstants.DATALINE_PC_UIN;
      i1 = 6000;
    }
    return DraftTextManager.a(this.app).a(this.app, str, i1);
  }
  
  protected void h(Intent paramIntent)
  {
    c(paramIntent);
    int i1 = this.j;
    b(paramIntent);
    if (i1 != this.j)
    {
      paramIntent = this.app.getDataLineMsgProxy(this.j);
      if (paramIntent == null)
      {
        this.l = new DataLineMsgSetList();
        this.m.a(this.l);
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
        }
      }
      else
      {
        this.l = paramIntent.a(true);
        this.m.a(this.l);
      }
      this.m.notifyDataSetChanged();
    }
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 14)
          {
            if (i1 == 15) {
              L();
            }
          }
          else {
            b(paramMessage.arg1, paramMessage.arg2);
          }
        }
        else
        {
          String str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("progress: ");
          localStringBuilder.append(paramMessage.arg1);
          QLog.i(str, 2, localStringBuilder.toString());
          this.X.setProgress(paramMessage.arg1);
        }
      }
      else
      {
        M();
        N();
      }
    }
    else
    {
      M();
      e(z());
    }
    return false;
  }
  
  void i()
  {
    String str;
    int i1;
    if (this.j == 1)
    {
      str = AppConstants.DATALINE_IPAD_UIN;
      i1 = 6003;
    }
    else
    {
      str = AppConstants.DATALINE_PC_UIN;
      i1 = 6000;
    }
    Object localObject1 = null;
    Object localObject2 = this.q;
    if (localObject2 != null) {
      localObject1 = ((XEditTextEx)localObject2).getText();
    }
    localObject2 = h();
    Object localObject3;
    if (StringUtil.isEmpty((String)localObject2))
    {
      localObject3 = this.q;
      if ((localObject3 != null) && (StringUtil.isEmpty(String.valueOf(((XEditTextEx)localObject3).getText())))) {
        return;
      }
    }
    if (!StringUtil.isEmpty((String)localObject2))
    {
      localObject3 = this.q;
      if ((localObject3 != null) && (((String)localObject2).equals(String.valueOf(((XEditTextEx)localObject3).getText())))) {
        return;
      }
    }
    localObject2 = DraftTextManager.a(this.app);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      localObject3 = new DraftTextInfo();
      ((DraftTextInfo)localObject3).uin = str;
      ((DraftTextInfo)localObject3).type = i1;
      ((DraftTextInfo)localObject3).text = ((CharSequence)localObject1).toString();
      ((DraftTextInfo)localObject3).time = NetConnInfoCenter.getServerTimeMillis();
      ((DraftTextManager)localObject2).a(this.app, (DraftTextInfo)localObject3);
    }
    else
    {
      ((DraftTextManager)localObject2).c(this.app, str, i1);
    }
    localObject1 = this.app.getMessageFacade();
    localObject2 = ((DraftTextManager)localObject2).b(this.app, str, i1);
    if (localObject2 != null)
    {
      ((QQMessageFacade)localObject1).a(str, i1, "", ((DraftSummaryInfo)localObject2).getSummary(), ((DraftSummaryInfo)localObject2).getTime());
      return;
    }
    ((QQMessageFacade)localObject1).a(str, i1, "", "", 0L);
  }
  
  void i(Intent paramIntent)
  {
    setLeftViewName(paramIntent);
    String str = this.leftView.getText().toString();
    if (str.contains(getString(2131917002)))
    {
      this.e = this.leftView;
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4recent");
      l();
    }
    else if (str.contains(getString(2131891479)))
    {
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4buddylist");
    }
    else if (str.contains(getString(2131889351)))
    {
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4dongtai");
    }
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.o = paramIntent.getExtras().getBoolean("isBack2Root");
      paramIntent.getExtras().putBoolean("isBack2Root", false);
    }
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("LASTFROM");
      if (str != null)
      {
        this.leftView.setText(str);
        this.e = this.leftView;
      }
    }
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
    {
      this.o = true;
      this.leftView.setText(getString(2131917002));
      this.e = this.leftView;
      l();
    }
    if ((paramIntent != null) && (paramIntent.getIntExtra("dataline_forward_type", -1) != -1))
    {
      if (!this.v) {
        this.v = paramIntent.getExtras().getBoolean("is_share_flag");
      }
      if (!this.v)
      {
        this.o = true;
        this.leftView.setText(getString(2131917002));
        this.e = this.leftView;
        l();
      }
    }
    if (ChatActivityConstants.b)
    {
      str = this.leftView.getText().toString();
      paramIntent = str;
      if (!getString(2131887440).equals(str))
      {
        paramIntent = new StringBuilder();
        paramIntent.append(HardCodeUtil.a(2131901576));
        paramIntent.append(str);
        paramIntent.append(HardCodeUtil.a(2131904129));
        paramIntent = paramIntent.toString();
      }
      this.leftView.setContentDescription(paramIntent);
    }
  }
  
  void j()
  {
    int i3 = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.p = ChatTextSizeSettingActivity.a(this);
    int i2 = 6;
    int i1;
    if (i3 != 0)
    {
      i1 = i2;
      if (i3 != 2)
      {
        i1 = i2;
        if (i3 == 3) {}
      }
    }
    else
    {
      i1 = 8;
    }
    this.q.setMaxLines(i1);
    this.q.setTextSize(0, this.p);
  }
  
  void k()
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
      QQToast.makeText(this, 2131916075, 0).show();
      return;
    }
    if (!O()) {
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
  
  void l()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((TextView)localObject).getText().toString();
      if ((localObject != null) && (!((String)localObject).startsWith(getString(2131917002)))) {
        return;
      }
      int i1 = 0;
      int i2 = QCallFacade.a(this.app);
      localObject = this.app.getMessageFacade();
      if (localObject != null) {
        i1 = ((QQMessageFacade)localObject).w();
      }
      i1 += i2;
      if (i1 > 0)
      {
        if (i1 > 99)
        {
          localObject = this.e;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131917002));
          localStringBuilder.append("(99+)");
          ((TextView)localObject).setText(localStringBuilder.toString());
          return;
        }
        localObject = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131917002));
        localStringBuilder.append("(");
        localStringBuilder.append(i1);
        localStringBuilder.append(")");
        ((TextView)localObject).setText(localStringBuilder.toString());
        return;
      }
      this.e.setText(getString(2131917002));
    }
  }
  
  void m()
  {
    Object localObject = this.rightViewImg;
    ((ImageView)localObject).setContentDescription(getResources().getText(2131891265));
    ((ImageView)localObject).setVisibility(0);
    ((ImageView)localObject).setImageResource(2130852269);
    ((ImageView)localObject).setOnClickListener(new LiteActivity.21(this));
    if (ChatActivityConstants.b) {
      this.rightViewImg.setContentDescription(HardCodeUtil.a(2131904131));
    }
    i(getIntent());
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.mLeftBackIcon.setVisibility(0);
      this.leftView.setBackgroundDrawable(null);
      localObject = getResources().getColorStateList(2131167991);
    }
    else
    {
      this.mLeftBackIcon.setVisibility(8);
      localObject = getResources().getColorStateList(2131167990);
    }
    this.centerView.setTextColor((ColorStateList)localObject);
    this.leftView.setTextColor((ColorStateList)localObject);
  }
  
  void n()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.app.getMessageFacade().d(this.j).e(localLong.longValue());
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMsgFailedWhenQuesting: session = ");
        localStringBuilder.append(localLong.longValue());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    this.n.clear();
  }
  
  void o()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(2130839752);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(2131891345);
    localQQToast.show(this.f.getHeight() / 2);
  }
  
  public boolean onBackEvent()
  {
    if (this.q != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.q.getWindowToken(), 0);
    }
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if (this.v)
    {
      if (bool)
      {
        l1 = getIntent().getLongExtra("req_share_id", 0L);
        if (l1 > 0L) {
          ForwardSdkShareOption.a(this, true, "sendToMyComputer", l1);
        }
        return super.onBackEvent();
      }
      long l1 = getIntent().getLongExtra("res_share_id", 0L);
      if (l1 > 0L) {
        ForwardSdkShareOption.a(this, true, "shareToQQ", AppShareIDUtil.d(l1));
      }
      F();
      return super.onBackEvent();
    }
    ApngImage.pauseAll();
    if ((this.o) || (bool))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    int i1 = paramView.getId();
    ReportController.b(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    switch (i1)
    {
    default: 
      break;
    case 2131445568: 
      I();
      break;
    case 2131438955: 
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
    case 2131435038: 
      ReportController.b(this.app, "dc00898", "", "", "0X8009F36", "0X8009F36", 4, 0, "", "", "", "");
      b(false);
      break;
    case 2131433905: 
      if (this.ac) {
        b(false);
      }
      I();
      break;
    case 2131433904: 
      ReportController.b(this.app, "dc00898", "", "", "0X8009F27", "0X8009F27", 4, 0, "", "", "", "");
      A();
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
      paramArrayOfString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestPermissionsResult error, requestcode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" grantresult:");
      localStringBuilder.append(paramArrayOfInt);
      QLog.e(paramArrayOfString, 2, localStringBuilder.toString());
      return;
    }
    int i1 = 0;
    paramInt = 0;
    while (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] != 0)
      {
        DialogUtil.a(this, paramArrayOfString, paramArrayOfInt);
        paramInt = i1;
        break label108;
      }
      paramInt += 1;
    }
    paramInt = 1;
    label108:
    if (paramInt != 0) {
      k();
    }
  }
  
  void p()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(2130839752);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(2131891346);
    localQQToast.show(this.f.getHeight() / 2);
  }
  
  void q()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(2130839752);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(2131891339);
    localQQToast.show(this.f.getHeight() / 2);
  }
  
  void r()
  {
    Object localObject = new ArrayList();
    LiteActivity.33 local33 = new LiteActivity.33(this, (List)localObject);
    LiteActivity.34 local34 = new LiteActivity.34(this);
    Iterator localIterator1 = this.l.iterator();
    int i5 = 0;
    int i3 = 0;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((DataLineMsgSet)localIterator1.next()).values().iterator();
      int i4 = 0;
      int i1 = i3;
      int i2 = i5;
      for (;;)
      {
        i5 = i2;
        i3 = i1;
        if (!localIterator2.hasNext()) {
          break;
        }
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator2.next();
        if ((DataLineMsgSet.isFileType(localDataLineMsgRecord)) && (!localDataLineMsgRecord.isread) && (localDataLineMsgRecord.fileMsgStatus == 1L))
        {
          i5 = i2;
          i3 = i4;
          if (i4 == 0)
          {
            i5 = i2 + 1;
            i3 = 1;
          }
          ((List)localObject).add(localDataLineMsgRecord);
          i1 += 1;
          i2 = i5;
          i4 = i3;
        }
      }
    }
    if (i5 >= 3)
    {
      localObject = String.format(getString(2131891357), new Object[] { Integer.valueOf(i5), Integer.valueOf(i3) });
      ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).d(115);
      DialogUtil.a(this, 230, getString(2131891303), (String)localObject, 2131887648, 2131891266, local33, local34).show();
    }
  }
  
  boolean s()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    return (localRegisterProxySvcPackHandler.d() == 0) || (localRegisterProxySvcPackHandler.g() != 0);
  }
  
  void t()
  {
    String str = this.q.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      if (this.ac)
      {
        this.K.setEnabled(true);
        return;
      }
      this.s.setEnabled(true);
      return;
    }
    if (this.ac)
    {
      this.K.setEnabled(false);
      return;
    }
    this.s.setEnabled(false);
  }
  
  public void u()
  {
    PhotoListPanel localPhotoListPanel = this.c;
    if (localPhotoListPanel != null)
    {
      a(localPhotoListPanel);
      ReportController.b(this.app, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 2, 0, "", "", "", "");
      return;
    }
    a(new ArrayList());
    ReportController.b(this.app, "dc00898", "", "", "0X800AC2E", "0X800AC2E", 1, 0, "", "", "", "");
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
    this.x.setAllUnSelected();
  }
  
  protected void w()
  {
    int i1 = this.b.getCurrentPanel();
    if (i1 == 1)
    {
      this.x.setAllUnSelected();
      return;
    }
    this.x.setSelected(i1);
  }
  
  public void x()
  {
    this.y.obtainMessage(15, 0, 0).sendToTarget();
  }
  
  public float y()
  {
    return this.mDensity;
  }
  
  protected String z()
  {
    String str2 = G;
    String str1 = str2;
    if (str2 == null) {
      str1 = getString(2131916548);
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */