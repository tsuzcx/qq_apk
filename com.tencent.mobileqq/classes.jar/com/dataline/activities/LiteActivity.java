package com.dataline.activities;

import aa;
import ab;
import am;
import an;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ar;
import at;
import au;
import av;
import aw;
import ax;
import ay;
import az;
import ba;
import bb;
import bc;
import bd;
import bg;
import bh;
import bi;
import bj;
import bk;
import bl;
import bm;
import bo;
import bp;
import bq;
import bs;
import bt;
import bu;
import bv;
import com.dataline.core.DirectForwarder;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.ItemHolder;
import com.dataline.util.ItemHolder.FileItemHolder;
import com.dataline.util.ItemHolder.ImageItemHolder;
import com.dataline.util.ItemHolder.MutiImageItemHolder;
import com.dataline.util.ItemHolder.TextItemHolder;
import com.dataline.util.file.SendInfo;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.devicelib.DeviceLib;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.BottomBtnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
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
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.QQProxyForDataline;
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
import l;
import m;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import n;
import o;
import p;
import q;
import s;
import t;
import u;
import v;
import w;
import x;
import y;
import z;

public class LiteActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, PanelIconLinearLayout.PanelIconCallback, PhotoListPanel.BottomBtnClickListener, XPanelContainer.PanelCallback, Observer
{
  public static String a;
  public static String c;
  public int a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  public View.OnTouchListener a;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  LiteActivity.LiteJumpAction jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction;
  public DatalineSessionAdapter a;
  public ShareAioResultDialog a;
  public SessionInfo a;
  PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new ab(this);
  DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ay(this);
  ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public ScrollerRunnable a;
  public BubblePopupWindow a;
  public XEditTextEx a;
  public XListView a;
  public XPanelContainer a;
  public Runnable a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public View.OnClickListener b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  public String b;
  public boolean b;
  TextView c;
  protected boolean c;
  protected boolean d;
  boolean e = false;
  public boolean f = true;
  private boolean g;
  private boolean h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.LiteActivity";
  }
  
  public LiteActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = AppConstants.y;
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = null;
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new u(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new v(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new at(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new au(this);
    this.jdField_a_of_type_JavaLangRunnable = new ba(this);
  }
  
  static Drawable a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = Shader.TileMode.REPEAT;
        Drawable localDrawable = paramContext.getResources().getDrawable(2130838348);
        if ((localDrawable instanceof BitmapDrawable))
        {
          localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
          paramString = ((BitmapDrawable)localDrawable).getTileModeX();
          i = ((BitmapDrawable)localDrawable).getGravity();
          if ((localBitmap == null) || (paramString == Shader.TileMode.REPEAT) || (i != 48)) {
            return paramContext.getResources().getDrawable(2130838348);
          }
        }
        else
        {
          if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
            break label189;
          }
          localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
          paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
          i = ((SkinnableBitmapDrawable)localDrawable).getGravity();
          continue;
        }
        paramString = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
        paramString.setGravity(i);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 1", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130845899);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 2", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130845899);
      }
      label189:
      int i = 119;
      Bitmap localBitmap = null;
    }
  }
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 237	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 243	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +34 -> 54
    //   23: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +12 -> 38
    //   29: getstatic 61	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   32: iconst_2
    //   33: ldc 245
    //   35: invokestatic 248	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload 6
    //   40: ifnull +10 -> 50
    //   43: aload 6
    //   45: invokeinterface 253 1 0
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: areturn
    //   54: aload 6
    //   56: ldc 255
    //   58: invokeinterface 259 2 0
    //   63: istore_2
    //   64: aload 6
    //   66: ldc_w 261
    //   69: invokeinterface 264 2 0
    //   74: istore_3
    //   75: aload 6
    //   77: invokeinterface 267 1 0
    //   82: pop
    //   83: aload 6
    //   85: iload_3
    //   86: invokeinterface 271 2 0
    //   91: lstore 4
    //   93: lload 4
    //   95: l2f
    //   96: invokestatic 276	com/tencent/mobileqq/utils/FileUtils:c	()F
    //   99: fcmpl
    //   100: ifle +27 -> 127
    //   103: aload_0
    //   104: ldc_w 277
    //   107: invokevirtual 281	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   110: putstatic 283	com/dataline/activities/LiteActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   113: aload 6
    //   115: ifnull +10 -> 125
    //   118: aload 6
    //   120: invokeinterface 253 1 0
    //   125: aconst_null
    //   126: areturn
    //   127: aload 6
    //   129: iload_2
    //   130: invokeinterface 284 2 0
    //   135: astore 7
    //   137: new 286	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   144: aload_0
    //   145: invokevirtual 291	com/dataline/activities/LiteActivity:getExternalCacheDir	()Ljava/io/File;
    //   148: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: ldc_w 297
    //   154: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 302
    //   160: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 297
    //   166: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore 9
    //   174: aload 9
    //   176: invokestatic 308	com/dataline/activities/LiteActivity:e	(Ljava/lang/String;)V
    //   179: new 286	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   186: aload 9
    //   188: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 9
    //   193: iconst_1
    //   194: anewarray 310	java/lang/String
    //   197: dup
    //   198: iconst_0
    //   199: aload 7
    //   201: aastore
    //   202: iconst_0
    //   203: aaload
    //   204: invokestatic 313	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   207: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore 7
    //   215: new 315	java/io/File
    //   218: dup
    //   219: aload 9
    //   221: invokespecial 317	java/io/File:<init>	(Ljava/lang/String;)V
    //   224: astore 9
    //   226: aload 9
    //   228: invokevirtual 320	java/io/File:exists	()Z
    //   231: ifne +32 -> 263
    //   234: aload 9
    //   236: invokevirtual 323	java/io/File:mkdirs	()Z
    //   239: ifne +24 -> 263
    //   242: aload_0
    //   243: ldc_w 325
    //   246: invokespecial 327	com/dataline/activities/LiteActivity:d	(Ljava/lang/String;)V
    //   249: aload 6
    //   251: ifnull +10 -> 261
    //   254: aload 6
    //   256: invokeinterface 253 1 0
    //   261: aconst_null
    //   262: areturn
    //   263: aload 8
    //   265: aload_1
    //   266: invokevirtual 331	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   269: astore_1
    //   270: aload_1
    //   271: ifnonnull +33 -> 304
    //   274: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +13 -> 290
    //   280: getstatic 61	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   283: iconst_2
    //   284: ldc_w 333
    //   287: invokestatic 248	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload 6
    //   292: ifnull +10 -> 302
    //   295: aload 6
    //   297: invokeinterface 253 1 0
    //   302: aconst_null
    //   303: areturn
    //   304: lload 4
    //   306: ldc2_w 334
    //   309: lcmp
    //   310: ifle +138 -> 448
    //   313: aload_0
    //   314: iconst_1
    //   315: putfield 337	com/dataline/activities/LiteActivity:h	Z
    //   318: new 339	com/tencent/mobileqq/utils/QQCustomDialog
    //   321: dup
    //   322: aload_0
    //   323: ldc_w 340
    //   326: invokespecial 343	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   329: astore 8
    //   331: aload 8
    //   333: ldc_w 344
    //   336: invokevirtual 347	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   339: aload 8
    //   341: aload_0
    //   342: ldc_w 348
    //   345: invokevirtual 281	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   348: invokevirtual 352	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   351: pop
    //   352: aload 8
    //   354: aload_0
    //   355: ldc_w 353
    //   358: invokevirtual 281	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   361: invokevirtual 357	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   364: pop
    //   365: aload 8
    //   367: iconst_0
    //   368: invokevirtual 361	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   371: aload 8
    //   373: iconst_0
    //   374: invokevirtual 364	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   377: aload 8
    //   379: aload_0
    //   380: ldc_w 365
    //   383: invokevirtual 281	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   386: new 367	be
    //   389: dup
    //   390: aload_0
    //   391: aload_1
    //   392: invokespecial 370	be:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/io/InputStream;)V
    //   395: invokevirtual 374	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   398: pop
    //   399: aload 8
    //   401: aload_0
    //   402: ldc_w 375
    //   405: invokevirtual 281	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   408: new 377	bf
    //   411: dup
    //   412: aload_0
    //   413: aload 7
    //   415: aload_1
    //   416: lload 4
    //   418: invokespecial 380	bf:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   421: invokevirtual 383	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   424: pop
    //   425: aload 8
    //   427: invokevirtual 386	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   430: aload 7
    //   432: astore_1
    //   433: aload 6
    //   435: ifnull -383 -> 52
    //   438: aload 6
    //   440: invokeinterface 253 1 0
    //   445: aload 7
    //   447: areturn
    //   448: aload_0
    //   449: aload 7
    //   451: aload_1
    //   452: lload 4
    //   454: invokespecial 389	com/dataline/activities/LiteActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   457: goto -27 -> 430
    //   460: astore 7
    //   462: aload 6
    //   464: astore_1
    //   465: aload 7
    //   467: astore 6
    //   469: aload_0
    //   470: iconst_0
    //   471: putfield 391	com/dataline/activities/LiteActivity:g	Z
    //   474: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +15 -> 492
    //   480: getstatic 61	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   483: iconst_2
    //   484: ldc_w 393
    //   487: aload 6
    //   489: invokestatic 396	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   492: aload_1
    //   493: ifnull +9 -> 502
    //   496: aload_1
    //   497: invokeinterface 253 1 0
    //   502: aconst_null
    //   503: areturn
    //   504: astore_1
    //   505: aconst_null
    //   506: astore 6
    //   508: aload 6
    //   510: ifnull +10 -> 520
    //   513: aload 6
    //   515: invokeinterface 253 1 0
    //   520: aload_1
    //   521: athrow
    //   522: astore_1
    //   523: goto -15 -> 508
    //   526: astore 7
    //   528: aload_1
    //   529: astore 6
    //   531: aload 7
    //   533: astore_1
    //   534: goto -26 -> 508
    //   537: astore 6
    //   539: aconst_null
    //   540: astore_1
    //   541: goto -72 -> 469
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	LiteActivity
    //   0	544	1	paramUri	Uri
    //   63	67	2	i	int
    //   74	12	3	j	int
    //   91	362	4	l	long
    //   16	514	6	localObject1	Object
    //   537	1	6	localException1	Exception
    //   135	315	7	str	String
    //   460	6	7	localException2	Exception
    //   526	6	7	localObject2	Object
    //   4	422	8	localObject3	Object
    //   172	63	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   23	38	460	java/lang/Exception
    //   54	113	460	java/lang/Exception
    //   127	249	460	java/lang/Exception
    //   263	270	460	java/lang/Exception
    //   274	290	460	java/lang/Exception
    //   313	430	460	java/lang/Exception
    //   448	457	460	java/lang/Exception
    //   6	18	504	finally
    //   23	38	522	finally
    //   54	113	522	finally
    //   127	249	522	finally
    //   263	270	522	finally
    //   274	290	522	finally
    //   313	430	522	finally
    //   448	457	522	finally
    //   469	492	526	finally
    //   6	18	537	java/lang/Exception
  }
  
  public static void a(Context paramContext)
  {
    p localp = new p();
    DialogUtil.b(paramContext, 233, paramContext.getString(2131434797), paramContext.getString(2131427569), 2131427487, 2131427487, localp, null).show();
  }
  
  public static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131364176);
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
    int i = 0;
    SharedPreferences localSharedPreferences = paramIphoneTitleBarActivity.getSharedPreferences("chat_background_path_" + paramIphoneTitleBarActivity.app.getCurrentAccountUin(), 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = AppConstants.y;
    arrayOfString[1] = "chat_uniform_bg";
    if ((localSharedPreferences.getString(arrayOfString[0], null) == null) && (localSharedPreferences.getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int j = arrayOfString.length;
    for (;;)
    {
      if (i >= j) {
        break label207;
      }
      String str = localSharedPreferences.getString(arrayOfString[i], null);
      if (str != null)
      {
        if (("".equals(str)) || ("null".equals(str)) || ("none".equals(str)))
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, str);
          return;
        }
        if (!new File(str).exists())
        {
          a(paramIphoneTitleBarActivity, paramViewGroup, "null");
          return;
        }
        if (a(paramIphoneTitleBarActivity, paramViewGroup, str)) {
          break;
        }
      }
      i += 1;
    }
    label207:
    a(paramIphoneTitleBarActivity, paramViewGroup, "null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    a(paramString, paramContext, new q(paramQQAppInterface, paramString));
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet)
  {
    MessageForPic localMessageForPic = null;
    int i;
    if (paramDataLineMsgSet == null)
    {
      i = 1;
      paramDataLineMsgSet = localMessageForPic;
    }
    for (;;)
    {
      if (i != 0)
      {
        QQToast.a(getApplicationContext(), getString(2131434600), 0).b(getResources().getDimensionPixelSize(2131558448));
        return;
        ArrayList localArrayList = paramDataLineMsgSet.values();
        if ((localArrayList == null) || (localArrayList.size() == 0))
        {
          i = 1;
          paramDataLineMsgSet = localMessageForPic;
          continue;
        }
        paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
        if (paramDataLineMsgSet == null) {
          i = 1;
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
          ThreadManager.executeOnSubThread(new ar(this, localMessageForPic));
          return;
        }
        localMessageForPic.md5 = HexUtil.a(paramDataLineMsgSet.md5);
        a(localMessageForPic);
        return;
      }
      i = 0;
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null)
    {
      QQToast.a(getApplicationContext(), getString(2131434600), 0).b(getResources().getDimensionPixelSize(2131558448));
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "savePicsAsCustomFace, md5:" + paramMessageForPic.md5);
    URLDrawable localURLDrawable = URLDrawableHelper.a(URLDrawableHelper.a(paramMessageForPic, 1, "datalineface"), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    AIOGalleryUtils.a(this, this.app, localURLDrawable, paramMessageForPic.frienduin, getResources().getDimensionPixelSize(2131558448), null, paramMessageForPic.picExtraData);
  }
  
  public static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView)
  {
    if (paramXListView != null) {
      paramXListView.postDelayed(new am(paramXListView, paramScrollerRunnable), 200L);
    }
  }
  
  public static void a(ScrollerRunnable paramScrollerRunnable, XListView paramXListView, int paramInt)
  {
    if (paramXListView != null) {}
    try
    {
      paramScrollerRunnable.a(paramInt, -1, null);
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
  
  static void a(String paramString, Context paramContext, bs parambs)
  {
    ThreadManager.executeOnSubThread(new s(paramContext, paramString, parambs));
  }
  
  static void a(String paramString, bt parambt)
  {
    ThreadManager.executeOnSubThread(new m(paramString, parambt));
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.g = true;
    ThreadManager.post(new bg(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131436315), "取消", new bh(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new bj(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(ArrayList paramArrayList)
  {
    Intent localIntent = new Intent();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      localIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    }
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent.putExtra("peak.myUin", this.app.getAccount());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
    localIntent.putExtra(AlbumConstants.h, 55);
    localIntent.putExtra("uin", AppConstants.y);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", this.leftView.getText().toString());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = getBaseContext().getSharedPreferences("album_file", 0);
    paramArrayList = ((SharedPreferences)localObject).getString("album_key_name", null);
    localObject = ((SharedPreferences)localObject).getString("album_key_id", null);
    localIntent.putExtra("ALBUM_NAME", paramArrayList);
    localIntent.putExtra("ALBUM_ID", (String)localObject);
    localIntent.setClass(this, AlbumListActivity.class);
    localIntent.addFlags(603979776);
    startActivity(localIntent);
    AlbumUtil.a(this, true, false);
  }
  
  static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    String str = (String)paramViewGroup.getTag(2131362036);
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      if (!"null".equals(str))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131362036, "null");
      }
    }
    for (;;)
    {
      return true;
      if ("none".equals(paramString))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131362036, "null");
      }
      else if (!paramString.equals(str))
      {
        a(paramString, new bq(paramIphoneTitleBarActivity, paramString, paramViewGroup));
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
        paramQQAppInterface = paramQQAppInterface.a().a(paramLong);
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
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131427535);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838726);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  private void d(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131624516);
    localQQCustomDialog.setContentView(2130968855);
    localQQCustomDialog.setTitle(getString(2131434797));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(getString(2131433712), new bk(this));
    localQQCustomDialog.show();
  }
  
  private static void e(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  private void t()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    }
    while (i == 0) {
      if (!this.e)
      {
        b(true);
        return;
        i = 0;
      }
      else
      {
        b(false);
        return;
      }
    }
    b(false);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction == null) {
      return;
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a();
  }
  
  public float a()
  {
    return this.mDensity;
  }
  
  public View a(int paramInt)
  {
    Object localObject = null;
    long l;
    Intent localIntent;
    String str1;
    if (paramInt == 4)
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = ((PhotoListPanel)View.inflate(this, 2130970204, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setCustomOnClickListener(this);
      localIntent = new Intent();
      str1 = this.app.getAccount();
      localObject = ((FriendsManager)this.app.getManager(50)).c(str1);
      if (localObject == null) {
        break label285;
      }
    }
    label285:
    for (localObject = ((Friends)localObject).name;; localObject = null)
    {
      String str2 = this.app.a(1, str1, 0);
      localIntent.putExtra("key_my_uin", str1);
      localIntent.putExtra("key_my_nick", (String)localObject);
      localIntent.putExtra("key_my_head_dir", str2);
      localIntent.putExtra("key_disable_presend", true);
      localIntent.putExtra("key_disable_quality_cb", true);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 50);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 100000002432L);
      localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005F28");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(new bc(this));
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
      return localObject;
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
    paramDataLineHandler.msgtype = DataLineHandler.c(paramInt1);
    paramDataLineHandler.groupId = paramInt2;
    paramDataLineHandler.groupSize = paramInt3;
    paramDataLineHandler.groupIndex = paramInt4;
    return paramDataLineHandler;
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().a(paramForwardFileInfo.b());
    if (localFileManagerEntity == null) {}
    int k;
    do
    {
      return null;
      k = DataLineHandler.a(localFileManagerEntity);
    } while (!DataLineHandler.c(k));
    int j = DataLineHandler.a(paramForwardFileInfo.d(), paramBoolean);
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (j == 1) {
        i = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.c(i);
    localDataLineMsgRecord.sessionid = ((DataLineHandler)this.app.a(8)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.d();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.d();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.b();
    localDataLineMsgRecord.fileFrom = k;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.f();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = HexUtil.a(localFileManagerEntity.strFileMd5);
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
      str = AppConstants.z;
    }
    for (int i = 6003;; i = 6000)
    {
      return DraftTextManager.a(this.app).a(this.app, str, i);
      str = AppConstants.y;
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131364135));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter);
    View localView = LayoutInflater.from(this).inflate(2130968800, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.getCount());
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new y(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new ax(this));
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
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a("已发送");
    String str2 = getString(2131430155);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new bp(this, paramLong, this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))) {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction.a(paramIntent);
    }
  }
  
  public void a(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.d(getActivity()))
    {
      FMToastUtil.a(2131434629);
      return;
    }
    Object localObject2 = "";
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    Object localObject1;
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > FMConfig.a())) {
      localObject1 = getString(2131428237);
    }
    label80:
    int i;
    for (;;)
    {
      if (((String)localObject1).equals(""))
      {
        localObject1 = getString(2131427496);
        localObject2 = (ActionSheet)ActionSheetHelper.a(this, null);
        ((ActionSheet)localObject2).a((CharSequence)localObject1);
        ((ActionSheet)localObject2).a(getResources().getString(2131428177), 1);
        ((ActionSheet)localObject2).c(2131433029);
        ((ActionSheet)localObject2).a(new w(this, localDataLineMsgSet, paramItemHolder, (ActionSheet)localObject2));
        ((ActionSheet)localObject2).show();
        return;
        if (localDataLineMsgSet.getGroupType() == -1000)
        {
          localObject1 = getString(2131427497);
        }
        else
        {
          localObject1 = localObject2;
          if (localDataLineMsgSet.getGroupType() == -2000)
          {
            localObject1 = localObject2;
            if (!localDataLineMsgSet.isSingle())
            {
              localObject1 = localDataLineMsgSet.values().iterator();
              i = 0;
              label202:
              if (((Iterator)localObject1).hasNext())
              {
                if (!DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
                  break label261;
                }
                i += 1;
              }
            }
          }
        }
      }
    }
    label261:
    for (;;)
    {
      break label202;
      localObject1 = String.format(getString(2131427596), new Object[] { Integer.valueOf(i) });
      break;
      break label80;
    }
  }
  
  public void a(PhotoListPanel paramPhotoListPanel)
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
      return;
    }
  }
  
  void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.app.a(paramMessage))) {
      return;
    }
    Intent localIntent = this.app.a(this, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    runOnUiThread(new az(this, paramMessage, localIntent));
  }
  
  public void a(Object paramObject)
  {
    AIOUtils.m = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {}
    do
    {
      return;
      int i = ((Integer)paramObject).intValue();
      if (i == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        return;
      }
      switch (i)
      {
      default: 
        return;
      case 4: 
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
        return;
      case 5: 
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktkphoto");
        h();
        ReportController.b(this.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
        return;
      case 16: 
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckfile");
        paramObject = new Intent(getApplicationContext(), FMActivity.class);
        paramObject.putExtra("category", 6);
        paramObject.putExtra("selectMode", true);
        paramObject.putExtra("targetUin", AppConstants.y);
        paramObject.putExtra("tab_tab_type", 5);
        paramObject.putExtra("max_select_count", 50);
        startActivityForResult(paramObject, 2);
        overridePendingTransition(2131034123, 2131034124);
        ReportController.b(this.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
        return;
      }
      if (a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    e();
    ReportController.b(null, "CliOper", "", "", MpFileConstant.i, MpFileConstant.i, 0, 0, "", "", "", "");
    paramObject = new Bundle();
    paramObject.putBoolean("string_from", false);
    paramObject.putBoolean("string_uin", false);
    paramObject.putLong("device_din", 0L);
    paramObject.putInt("sTitleID", 0);
    QQProxyForDataline.a(this, paramObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
  }
  
  void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.length() > 3478)
    {
      QQToast.a(this, "字数超出限制", 1).b(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.app.a(8)).a(paramString, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (!b()) {
      b(null);
    }
    int i;
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return;
      i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
      localDataLineMsgRecord = this.app.a().a(i).a(paramLong);
    } while (localDataLineMsgRecord == null);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    switch (paramInt)
    {
    default: 
      this.app.a().a(i).a(paramLong);
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
      } else {
        localDataLineHandler.a().a(localDataLineMsgRecord, i, 2);
      }
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
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
      int i = 0;
      while (i < paramArrayList.size())
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        i += 1;
      }
    }
    n localn = new n(this, paramArrayList);
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l = new File(str).length() + l;
      }
    }
    if (l == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.g(this)) && (!NetworkUtil.h(this)) && (l > FMConfig.a()))
    {
      FMDialogUtil.a(this, 2131428241, 2131428237, new o(this, localn, paramInt));
      return;
    }
    localn.execute(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  void a(List paramList)
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
        int i = FileManagerUtil.a(str);
        if (2 == i) {
          localArrayList1.add(str);
        } else if (i == 0) {
          localArrayList2.add(str);
        }
      }
      if (!localArrayList2.isEmpty())
      {
        paramList = new Bundle();
        paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList2);
        new bu(this).execute(new Bundle[] { paramList });
      }
    } while (localArrayList1.isEmpty());
    paramList = new Bundle();
    paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList1);
    new bv(this).execute(new Bundle[] { paramList });
  }
  
  public void a(Observable paramObservable, Object paramObject)
  {
    i();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      int i = DataLineMsgRecord.getDevTypeBySeId(paramObservable.sessionid);
      DataLineMsgSet localDataLineMsgSet = this.app.a(i).a(paramObservable.sessionid);
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
          if ((paramObject instanceof QQMessageFacade.Message))
          {
            paramObservable = (QQMessageFacade.Message)paramObject;
            if (paramObservable.frienduin == null) {
              break;
            }
            if (!paramObservable.frienduin.endsWith(String.valueOf(AppConstants.y))) {
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
            if (paramObservable.uin.endsWith(String.valueOf(AppConstants.y))) {
              this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
            }
          }
        }
      }
      paramObject = (HotChatManager)this.app.getManager(59);
    } while ((paramObservable.isread) || (paramObject.b(paramObservable.frienduin)));
    label265:
    a(this.app.a().a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    this.app.a().a(this.jdField_a_of_type_Int).e();
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
  public boolean a(long paramLong)
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      m();
      return false;
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    for (long l = new StatFs(AppConstants.aJ).getAvailableBytes(); l < paramLong; l = new StatFs(AppConstants.aJ).getAvailableBlocks() * new StatFs(AppConstants.aJ).getBlockSize())
    {
      l();
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
        localFileManagerEntity = this.app.a().a(paramIntent.b());
      } while (localFileManagerEntity == null);
      int i = DataLineHandler.a(localFileManagerEntity);
      switch (i)
      {
      case 0: 
      default: 
        QLog.w(jdField_a_of_type_JavaLangString, 1, "forwardFile fileFrom " + i + " is not handled");
        return false;
      case 3: 
        if (paramInt != 101) {
          break label155;
        }
        bool = true;
        paramIntent = a(paramIntent, bool, this.jdField_a_of_type_Int);
      }
    } while (paramIntent == null);
    ((DataLineHandler)this.app.a(8)).a(paramIntent, false);
    for (;;)
    {
      return true;
      label155:
      bool = false;
      break;
      this.app.a().a(3, paramIntent.b(), this.jdField_a_of_type_Int);
      continue;
      if (this.jdField_a_of_type_Int == 0) {
        this.app.a().a(paramIntent.b(), paramIntent.e(), paramIntent.a(), Long.parseLong(this.app.getCurrentAccountUin()), 7, paramIntent.a());
      } else {
        this.app.a().a(paramIntent.b(), paramIntent.e(), paramIntent.a(), Long.parseLong(this.app.getCurrentAccountUin()), 6003, paramIntent.a());
      }
    }
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return true;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ItemHolder localItemHolder = (ItemHolder)paramView.getTag();
    DataLineMsgSet localDataLineMsgSet = localItemHolder.a();
    Object localObject1 = "";
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    int i = localDataLineMsgSet.getGroupType();
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
        localQQCustomMenu.a(2131375647, paramView.getContext().getString(2131435109), 2130838310);
        localQQCustomMenu.a(2131363536, paramView.getContext().getString(2131435099), 2130838318);
        localQQCustomMenu.a(2131366774, paramView.getContext().getString(2131431574), 2130838317);
        localObject1 = "";
        continue;
        localObject2 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localObject1 = localDataLineMsgRecord.path;
        if ((AIOUtils.a(1) == 1) && (FileUtils.b(localDataLineMsgRecord.path)) && (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0))
        {
          localQQCustomMenu.a(2131361852, getString(2131435889), 2130838316);
          continue;
          if (localDataLineMsgRecord.bIsMoloImage) {}
          for (localObject1 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout;; localObject1 = localItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout)
          {
            localObject3 = localDataLineMsgRecord.path;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
          }
        }
      }
      else
      {
        localObject3 = ((RelativeLayout)localObject2).getContext();
        if (localDataLineMsgRecord.canForward()) {
          localQQCustomMenu.a(2131363536, ((Context)localObject3).getString(2131427525), 2130838318);
        }
        if ((FileUtils.b((String)localObject1)) && (localDataLineMsgRecord.strMoloKey == null))
        {
          if ((localDataLineMsgSet.getGroupType() == -2005) && (this.app.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + this.app.c(), 4).getBoolean("tim_convert_teamwork_show_aio_menu", false)) && (TeamWorkUtils.a((String)localObject1, localDataLineMsgRecord.filename)))
          {
            ReportController.b(this.app, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
            localQQCustomMenu.a(2131375679, paramView.getContext().getString(2131439163), 2130838327);
          }
          if (localDataLineMsgSet.getGroupType() == -2000) {
            localQQCustomMenu.a(2131366774, paramView.getContext().getString(2131431574), 2130838317);
          }
          if (a(this.app, localDataLineMsgRecord)) {
            localQQCustomMenu.a(2131375648, ((Context)localObject3).getString(2131427524), 2130838329);
          }
        }
        paramView = ((RelativeLayout)localObject2).getContext();
        localQQCustomMenu.a(2131375638, paramView.getString(2131427523), 2130838314);
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsMoloImage))) {}
        for (boolean bool = true;; bool = false)
        {
          paramView = new an(this, localDataLineMsgRecord, localDataLineMsgSet, paramView, i, (String)localObject1, bool);
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(localItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, (int)this.jdField_a_of_type_AndroidGraphicsPointF.y, localQQCustomMenu, paramView);
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new x(this));
          return true;
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
        }
      }
    }
  }
  
  public String b()
  {
    if (jdField_c_of_type_JavaLangString == null) {
      return getString(2131436306);
    }
    return jdField_c_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.app.a().a(this.jdField_a_of_type_Int).a(15, new bi(this));
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    r();
    if (paramInt2 == 0) {
      this.e = false;
    }
    for (;;)
    {
      t();
      return;
      if (1 == paramInt2) {
        this.e = true;
      }
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int i = this.jdField_a_of_type_Int;
    String str = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("targetUin");
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() != 0)) {
      if (this.jdField_b_of_type_JavaLangString.equals(AppConstants.z))
      {
        setTitle(2131427486);
        this.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      paramIntent = (DataLineHandler)this.app.a(8);
      paramIntent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramIntent.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return;
      setTitle(2131427485);
      this.jdField_a_of_type_Int = 0;
      continue;
      if (this.jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int = paramIntent.getIntExtra("device_type", -1);
        if (this.jdField_a_of_type_Int == 1)
        {
          setTitle(2131427486);
          this.jdField_b_of_type_JavaLangString = AppConstants.z;
        }
        else
        {
          setTitle(2131427485);
          this.jdField_b_of_type_JavaLangString = AppConstants.y;
          this.jdField_a_of_type_Int = 0;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = i;
        this.jdField_b_of_type_JavaLangString = str;
      }
    }
  }
  
  public void b(ItemHolder paramItemHolder)
  {
    if (!NetworkUtil.d(getActivity()))
    {
      FMToastUtil.a(2131434629);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramItemHolder.a();
    if ((FileManagerUtil.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 3145728L)) {}
    for (paramItemHolder = getString(2131428239);; paramItemHolder = "")
    {
      ArrayList localArrayList = new ArrayList();
      long l = 0L;
      Object localObject = localDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
        {
          localDataLineMsgRecord.bIsResendOrRecvFile = true;
          localDataLineMsgRecord.fileMsgStatus = 0L;
          localDataLineMsgRecord.progress = 0.0F;
          l += localDataLineMsgRecord.filesize;
          localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
        }
      }
      if ((localArrayList.size() == 0) && (!localDataLineMsgSet.isSingle()))
      {
        int i = localDataLineMsgSet.getTotalCount() - localDataLineMsgSet.getComeCount();
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgSet.getFirstItem().bIsMoloImage))) {}
        for (paramItemHolder = String.format(getString(2131427598), new Object[] { Integer.valueOf(i) });; paramItemHolder = String.format(getString(2131427597), new Object[] { Integer.valueOf(i) }))
        {
          localObject = new z(this);
          DialogUtil.b(this, 230, getString(2131427500), paramItemHolder, 2131433030, 2131433030, null, (DialogInterface.OnClickListener)localObject).show();
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
            localObject = String.format(getString(2131427595), new Object[] { Integer.valueOf(localArrayList.size()) });
          }
        }
      }
      paramItemHolder = (ItemHolder)localObject;
      if (((String)localObject).equals("")) {
        paramItemHolder = getString(2131427499);
      }
      localObject = (ActionSheet)ActionSheetHelper.a(this, null);
      ((ActionSheet)localObject).a(paramItemHolder);
      ((ActionSheet)localObject).a(getResources().getString(2131428175), 1);
      ((ActionSheet)localObject).c(2131433029);
      ((ActionSheet)localObject).a(new aa(this, l, localDataLineMsgSet, localArrayList, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
  }
  
  public void b(PhotoListPanel paramPhotoListPanel)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
    long l = 0L;
    if (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      int i = paramPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(str);
      if (1 == i) {
        localArrayList.add(str);
      }
      for (;;)
      {
        l = new File(str).length() + l;
        break;
        if (i == 0) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    if (l == 0L)
    {
      a(this);
      return;
    }
    if ((NetworkUtil.g(this)) && (!NetworkUtil.h(this)) && (l > FMConfig.a())) {
      FMDialogUtil.a(this, 2131428241, 2131428237, new bd(this, (ArrayList)localObject1, localArrayList));
    }
    for (;;)
    {
      paramPhotoListPanel.g();
      ReportController.b(null, "CliOper", "", "", "0X8005A2F", "0X8005A2F", 0, 0, paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() + "", "", "", "");
      return;
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
        new bu(this).execute(new Bundle[] { localObject2 });
      }
      if (!localArrayList.isEmpty())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
        new bv(this).execute(new Bundle[] { localObject1 });
      }
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
  
  void b(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    DataLineHandler localDataLineHandler;
    int j;
    int i;
    Object localObject;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.app.a(8);
      j = paramArrayList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localObject = a(localDataLineHandler, (SendInfo)paramArrayList.get(i), paramInt, 0, 0, 0);
        if (localObject != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject, false);
        }
        i += 1;
      }
    }
    label110:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((j > 3) && (j < 50))
    {
      localObject = new ArrayList();
      int k = localDataLineHandler.a();
      i = 0;
      if (i < j)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i), paramInt, k, j, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, k)) {
          break label395;
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
    label392:
    label395:
    for (;;)
    {
      i += 1;
      break label110;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      j = localDataLineHandler.a();
      i = 0;
      label250:
      if (i < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (SendInfo)paramArrayList.get(i), paramInt, j, 50, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, j)) {
          break label392;
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
        i += 1;
        break label250;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        i = 0;
        while (i < 50)
        {
          paramArrayList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
  
  boolean b()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.a(10);
    return (localRegisterProxySvcPackHandler.a() == 0) || (localRegisterProxySvcPackHandler.g() != 0);
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131363516));
    if (this.jdField_a_of_type_AndroidTextTextWatcher != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(QQTextBuilder.a);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        DeviceLib.a(this, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        g();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new bm(this));
        return;
        this.jdField_a_of_type_AndroidTextTextWatcher = new bl(this);
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
  
  void c(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent.getIntExtra("aio_msg_source", 999) == 1) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (this.jdField_c_of_type_Boolean)
      {
        AIOUtils.m = false;
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
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.msgtype = -2009;
    localDataLineHandler.a(localDataLineMsgRecord, false);
  }
  
  void d()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.z;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 6003;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.y;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 6000;
  }
  
  void d(Intent paramIntent)
  {
    paramIntent = null;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("camera_photo_path", "");
    if (!((String)localObject).equalsIgnoreCase(""))
    {
      com.tencent.mobileqq.activity.aio.PlusPanelUtils.jdField_a_of_type_JavaLangString = (String)localObject;
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
      if (!FileUtils.e(paramIntent))
      {
        QQToast.a(this, getString(2131434520), 0).b(getTitleBarHeight());
        return;
      }
      if (!new File(paramIntent).exists()) {
        QQToast.a(this, getString(2131434521), 0).b(getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(this, getString(2131434521), 0).b(getTitleBarHeight());
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
    ((Intent)localObject).putExtra("uin", AppConstants.y);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.leftView.getText().toString());
    startActivity((Intent)localObject);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        t();
      } while ((paramInt2 != -1) || (paramIntent == null));
      return;
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
      return;
    } while ((paramInt2 != -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramInt1, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131492895);
    setContentView(2130968875);
    setStatusBarBlue();
    boolean bool = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = (ViewGroup)findViewById(2131363261);
    if (bool) {
      ((ViewGroup)localObject1).setBackgroundResource(2130845952);
    }
    int m;
    int n;
    int i1;
    for (;;)
    {
      localObject1 = (ImageView)((ViewGroup)localObject1).findViewById(2131364019);
      if (localObject1 != null) {
        ViewCompat.setImportantForAccessibility((View)localObject1, 2);
      }
      setTitle(2131427485);
      getWindow().setBackgroundDrawable(null);
      b(getIntent());
      c(getIntent());
      j();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364133));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364224));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364223));
      if (this.jdField_a_of_type_Int == 1)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8005D19", "0X8005D19", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "=== dataline report event into ipad 0X8005D19 ");
        }
      }
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$LiteJumpAction = new LiteActivity.LiteJumpAction(this, this);
      this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      localObject1 = this.app.a();
      if (localObject1 != null) {
        ((QQMessageFacade)localObject1).addObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = this.app.a(this.jdField_a_of_type_Int).a(true);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter = new DatalineSessionAdapter(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList, this, this.app);
      a();
      c();
      localObject1 = (DataLineHandler)this.app.a(8);
      ((DataLineHandler)localObject1).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363529));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131362845));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)findViewById(2131363512));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364132));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      p();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      o();
      this.app.a().a(this.jdField_a_of_type_Int).e();
      if (paramBundle == null) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new l(this), 200L);
      }
      a(getIntent());
      paramBundle = (RegisterProxySvcPackHandler)this.app.a(10);
      if ((paramBundle.a() == 0) && (!paramBundle.a()))
      {
        paramBundle.b();
        paramBundle.a(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.isEmpty()) {
        break label955;
      }
      paramBundle = getSharedPreferences("first_enter_dataline", 0);
      int i = paramBundle.getInt("year", -1);
      int j = paramBundle.getInt("month", -1);
      int k = paramBundle.getInt("day", -1);
      localObject2 = Calendar.getInstance();
      m = ((Calendar)localObject2).get(1);
      n = ((Calendar)localObject2).get(2);
      i1 = ((Calendar)localObject2).get(5);
      if ((m == i) && (n == j) && (i1 == k)) {
        break label955;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() - 1);
      if (localObject2 == null) {
        break label955;
      }
      localObject2 = ((DataLineMsgSet)localObject2).getFirstItem();
      if ((localObject2 == null) || (((DataLineMsgRecord)localObject2).msgtype == -5000) || (((DataLineMsgRecord)localObject2).msgtype == -1000)) {
        break label955;
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
              this.app.a(this.jdField_a_of_type_Int).a(localDataLineMsgSet);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      ((ViewGroup)localObject1).setBackgroundResource(2130845951);
    }
    localObject1 = ((DataLineHandler)localObject1).a(0, this.jdField_a_of_type_Int);
    Object localObject2 = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject2).msgId = ((Long)localObject1).longValue();
    ((DataLineMsgRecord)localObject2).sessionid = ((Long)localObject1).longValue();
    ((DataLineMsgRecord)localObject2).msgtype = -5000;
    ((DataLineMsgRecord)localObject2).time = MessageCache.a();
    ((DataLineMsgRecord)localObject2).isread = true;
    this.app.a(this.jdField_a_of_type_Int).a((DataLineMsgRecord)localObject2);
    paramBundle = paramBundle.edit();
    paramBundle.putInt("year", m);
    paramBundle.putInt("month", n);
    paramBundle.putInt("day", i1);
    paramBundle.commit();
    label955:
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    if (this.app.a() != null)
    {
      this.app.a().a(this.jdField_a_of_type_Int).e();
      this.app.a().a(this.jdField_a_of_type_Int).d();
      this.app.a().deleteObserver(this);
      this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    this.jdField_a_of_type_Int = -1;
    if (this.app.a() != null) {
      this.app.a().e();
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(null);
    }
    FileManagerUtil.b(this);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    i(paramIntent);
    f();
    h(paramIntent);
    e(paramIntent);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ((DataLineHandler)this.app.a(8)).e();
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.jdField_b_of_type_Boolean) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finishing LiteActivity (ask ippan)");
      }
      finish();
      com.tencent.mobileqq.app.PhoneContactManagerImp.g = false;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter.notifyDataSetChanged();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
    }
    ApngImage.playByTag(0);
  }
  
  protected void e()
  {
    this.f = false;
    new Handler().postDelayed(new bo(this), 1500L);
  }
  
  public void e(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(paramIntent, this.app, this);
      paramIntent = new Bundle();
      paramIntent.putString("uin", String.valueOf(AppConstants.y));
      paramIntent.putInt("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f.intValue(), paramIntent);
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(a());
      i = paramIntent.getIntExtra(AlbumConstants.h, -1);
      if (55 != i) {
        break label271;
      }
      if (!paramIntent.getExtras().containsKey("PhotoConst.PHOTO_PATHS")) {
        break;
      }
      ArrayList localArrayList = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      if (localArrayList.size() <= 0) {
        break;
      }
      a(localArrayList);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
    return;
    if (paramIntent.getExtras().containsKey("file_send_path"))
    {
      c(paramIntent.getExtras().getString("file_send_path"));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
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
      label271:
      if (56 == i)
      {
        c(paramIntent.getExtras().getString("file_send_path"));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
        }
      }
    }
  }
  
  void f()
  {
    String str;
    int i;
    Object localObject1;
    if (this.jdField_a_of_type_Int == 1)
    {
      str = AppConstants.z;
      i = 6003;
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
      str = AppConstants.y;
      i = 6000;
      break;
    }
    Object localObject2 = DraftTextManager.a(this.app);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = str;
      localDraftTextInfo.type = i;
      localDraftTextInfo.text = ((CharSequence)localObject1).toString();
      localDraftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
      ((DraftTextManager)localObject2).a(this.app, localDraftTextInfo);
    }
    for (;;)
    {
      localObject1 = this.app.a();
      localObject2 = ((DraftTextManager)localObject2).a(this.app, str, i);
      if (localObject2 == null) {
        break;
      }
      ((QQMessageFacade)localObject1).a(str, i, "", ((DraftSummaryInfo)localObject2).getSummary(), ((DraftSummaryInfo)localObject2).getTime());
      return;
      ((DraftTextManager)localObject2).a(this.app, str, i);
    }
    ((QQMessageFacade)localObject1).a(str, i, "", "", 0L);
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
    f();
    ((DataLineHandler)this.app.a(8)).jdField_a_of_type_Boolean = false;
    k();
    if ((this.jdField_c_of_type_Boolean) && (AIOUtils.m) && (!this.d))
    {
      super.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      this.d = true;
    }
  }
  
  void g()
  {
    int j = 8;
    int k = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this);
    int i = j;
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(i);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_b_of_type_Int);
      return;
      i = 6;
      continue;
      i = 6;
    }
  }
  
  void g(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("dataline_forward_type", -1);
    int i = 0;
    if (j == -1) {
      label16:
      return;
    }
    paramIntent.getIntExtra("dataline_forward_type", -1);
    long l = paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false)) {
      if (j != 100) {
        break label1421;
      }
    }
    label263:
    label1416:
    label1421:
    for (int k = 0;; k = 1)
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
            n();
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
          localObject6 = (DataLineHandler)this.app.a(8);
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
                i = 1;
              }
            }
            for (;;)
            {
              break;
              ((ArrayList)localObject5).add(localDataLineMsgRecord);
            }
          }
          if (((ArrayList)localObject5).size() <= 0) {
            break label370;
          }
        }
        ((DataLineHandler)localObject6).a((ArrayList)localObject5, false);
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
          break label1413;
        }
        paramIntent = StructMsgFactory.a(paramIntent);
        if ((paramIntent == null) || (!(paramIntent instanceof AbsShareMsg))) {
          break label1416;
        }
      }
      for (paramIntent = (AbsShareMsg)paramIntent;; paramIntent = null)
      {
        if (paramIntent != null) {
          l = paramIntent.mSourceAppid;
        }
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              a(l, (String)localObject2);
              return;
              label370:
              if (i != 0) {
                break label263;
              }
              n();
              break label263;
              localObject5 = ((ArrayList)localObject2).iterator();
              for (i = 0; ((Iterator)localObject5).hasNext(); i = j)
              {
                localObject6 = (String)((Iterator)localObject5).next();
                if (localObject6 != null)
                {
                  j = i;
                  if (!((String)localObject6).equals("/")) {}
                }
                else
                {
                  j = i;
                  if (i == 0)
                  {
                    j = 1;
                    n();
                  }
                  ((Iterator)localObject5).remove();
                }
              }
              if (!((ArrayList)localObject2).isEmpty())
              {
                a((ArrayList)localObject2, k);
                break label263;
              }
              if (i != 0) {
                break label263;
              }
              n();
              break label263;
              localObject5 = new ArrayList();
              if (a(paramIntent, j)) {
                break;
              }
              switch (j)
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
                  break;
                }
                localObject6 = ((String)localObject2).split(";");
                ((ArrayList)localObject5).clear();
                i = 0;
                if (i < localObject6.length) {
                  try
                  {
                    localObject2 = URLDecoder.decode(localObject6[i], "UTF-8");
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
                      {
                        a((String)localObject2);
                        ReportController.b(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                          QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                        }
                        i += 1;
                      }
                    }
                  }
                  catch (UnsupportedEncodingException paramIntent)
                  {
                    if (!QLog.isColorLevel()) {
                      break label16;
                    }
                    QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[i]);
                    return;
                  }
                  catch (IllegalArgumentException localIllegalArgumentException1)
                  {
                    for (;;)
                    {
                      localObject3 = localObject6[i];
                      continue;
                      ((ArrayList)localObject5).add(localObject3);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + (String)localObject3);
                      }
                    }
                  }
                }
                break;
              }
            }
            if (((ArrayList)localObject5).isEmpty()) {
              break label263;
            }
            a((ArrayList)localObject5, 1);
            if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
              break label263;
            }
            if (((ArrayList)localObject5).size() > 1)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
              if (!QLog.isColorLevel()) {
                break label263;
              }
              QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
              break label263;
            }
            if (((ArrayList)localObject5).size() != 1) {
              break label263;
            }
            ReportController.b(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break label263;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
            break label263;
            StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_file");
            Object localObject3 = paramIntent.getStringExtra("dataline_forward_path");
            if ((localObject3 == null) || (((String)localObject3).equals("")))
            {
              n();
              return;
            }
            localObject6 = ((String)localObject3).split(";");
            ((ArrayList)localObject5).clear();
            i = 0;
            if (i < localObject6.length) {
              try
              {
                localObject3 = URLDecoder.decode(localObject6[i], "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                  {
                    a((String)localObject3);
                    i += 1;
                  }
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[i]);
                return;
              }
              catch (IllegalArgumentException localIllegalArgumentException2)
              {
                for (;;)
                {
                  localObject4 = localObject6[i];
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
            break label263;
          }
          a((ArrayList)localObject5, 0);
          if (!paramIntent.getBooleanExtra("isMigSdkShare", false)) {
            break label263;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break label263;
          }
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
          break label263;
          Object localObject4 = paramIntent.getStringExtra("dataline_forward_text");
          if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
            break label263;
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
        }
      }
    }
  }
  
  void h()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    Object localObject1 = new File(AppConstants.aK + "photo/");
    if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdirs()))
    {
      QQToast.a(this, 2131434786, 0).a();
      return;
    }
    Object localObject2 = AppConstants.aK + "photo/" + System.currentTimeMillis() + ".jpg";
    localObject1 = Uri.fromFile(new File((String)localObject2));
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString("camera_photo_path", (String)localObject2).commit();
    localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject2).putExtra("output", (Parcelable)localObject1);
    ((Intent)localObject2).putExtra("android.intent.extra.videoQuality", 100);
    startActivityForResult((Intent)localObject2, 5);
  }
  
  protected void h(Intent paramIntent)
  {
    c(paramIntent);
    int i = this.jdField_a_of_type_Int;
    b(paramIntent);
    if (i != this.jdField_a_of_type_Int)
    {
      paramIntent = this.app.a(this.jdField_a_of_type_Int);
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
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b(paramMessage.arg1, paramMessage.arg2);
      continue;
      t();
      continue;
      u();
      d(b());
      continue;
      u();
      v();
      continue;
      QLog.i(jdField_a_of_type_JavaLangString, 2, "progress: " + paramMessage.arg1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgress(paramMessage.arg1);
    }
  }
  
  void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((localObject == null) || (((String)localObject).startsWith(getString(2131433311)))) {}
    }
    else
    {
      return;
    }
    int i = 0;
    int j = QCallFacade.a(this.app);
    Object localObject = this.app.a();
    if (localObject != null) {
      i = ((QQMessageFacade)localObject).b();
    }
    i += j;
    if (i > 0)
    {
      if (i > 99)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131433311) + "(99+)");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131433311) + "(" + i + ")");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131433311));
  }
  
  void i(Intent paramIntent)
  {
    setLeftViewName(paramIntent);
    String str = this.leftView.getText().toString();
    if (str.contains(getString(2131433311)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4recent");
      i();
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
        this.leftView.setText(getString(2131433311));
        this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
        i();
      }
      if ((paramIntent != null) && (paramIntent.getIntExtra("dataline_forward_type", -1) != -1))
      {
        if (!this.jdField_b_of_type_Boolean) {
          this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.leftView.setText(getString(2131433311));
          this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
          i();
        }
      }
      if (ChatActivityConstants.N)
      {
        str = this.leftView.getText().toString();
        paramIntent = str;
        if (!getString(2131432425).equals(str)) {
          paramIntent = "返回" + str + "界面";
        }
        this.leftView.setContentDescription(paramIntent);
      }
      return;
      if (str.contains(getString(2131433285))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4buddylist");
      } else if (str.contains(getString(2131428087))) {
        StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4dongtai");
      }
    }
  }
  
  void j()
  {
    Object localObject = this.rightViewImg;
    ((ImageView)localObject).setContentDescription(getResources().getText(2131427502));
    ((ImageView)localObject).setVisibility(0);
    ((ImageView)localObject).setImageResource(2130845980);
    ((ImageView)localObject).setOnClickListener(new t(this));
    if (ChatActivityConstants.N) {
      this.rightViewImg.setContentDescription("进入我的电脑高级设置界面");
    }
    i(getIntent());
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.mLeftBackIcon.setVisibility(0);
      this.leftView.setBackgroundDrawable(null);
    }
    for (localObject = getResources().getColorStateList(2131494219);; localObject = getResources().getColorStateList(2131494218))
    {
      this.centerView.setTextColor((ColorStateList)localObject);
      this.leftView.setTextColor((ColorStateList)localObject);
      return;
      this.mLeftBackIcon.setVisibility(8);
    }
  }
  
  void k()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.app.a().a(this.jdField_a_of_type_Int).b(localLong.longValue());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgFailedWhenQuesting: session = " + localLong.longValue());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  void l()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838723);
    localQQToast.d(2000);
    localQQToast.c(2131427517);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void m()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838723);
    localQQToast.d(2000);
    localQQToast.c(2131427518);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void n()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838723);
    localQQToast.d(2000);
    localQQToast.c(2131427549);
    localQQToast.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void o()
  {
    Object localObject1 = new ArrayList();
    av localav = new av(this, (List)localObject1);
    aw localaw = new aw(this);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int k = 0;
    int m = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (DataLineMsgSet)localIterator.next();
      int i = 0;
      localObject2 = ((DataLineMsgSet)localObject2).values().iterator();
      int j = k;
      int n = m;
      m = n;
      k = j;
      if (((Iterator)localObject2).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject2).next();
        if ((!DataLineMsgSet.isFileType(localDataLineMsgRecord)) || (localDataLineMsgRecord.isread) || (localDataLineMsgRecord.fileMsgStatus != 1L)) {
          break label262;
        }
        k = j;
        m = i;
        if (i == 0)
        {
          m = 1;
          k = j + 1;
        }
        ((List)localObject1).add(localDataLineMsgRecord);
        n += 1;
        i = m;
        j = k;
      }
    }
    label262:
    for (;;)
    {
      break;
      if (k >= 3)
      {
        localObject1 = String.format(getString(2131427585), new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        ((DataLineHandler)this.app.a(8)).a(115);
        DialogUtil.b(this, 230, getString(2131427500), (String)localObject1, 2131433029, 2131427586, localav, localaw).show();
      }
      return;
    }
  }
  
  public boolean onBackEvent()
  {
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
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    int i = paramView.getId();
    ReportController.b(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    switch (i)
    {
    default: 
    case 2131364132: 
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      } while ((paramView == null) || (paramView.length() <= 0));
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktxt");
      a(new QQText(paramView, 13, 32, 6000).toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      return;
    }
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
  }
  
  public void p()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
  }
  
  protected void r()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (i == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(i);
  }
  
  public void s()
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
    new Handler(localLooper).post(new bb(this, paramObservable, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */