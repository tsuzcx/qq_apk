package com.dataline.activities;

import aany;
import actj;
import acur;
import acxs;
import adic;
import aefz;
import aehw;
import aejy;
import aekc;
import agpk;
import ajsd;
import ajum;
import ajut;
import ajxl;
import ajya;
import akfl;
import akpf;
import aksy;
import akwf;
import anbp;
import anbq;
import ancf;
import ancg;
import ancu;
import ancv;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
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
import android.os.Message;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
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
import anfe;
import anoy;
import aoun;
import aouu;
import aoze;
import aozg;
import apei;
import aper;
import aptt;
import aptx;
import apug;
import aqau;
import aqbe;
import aqdm;
import aqfd;
import aqyf;
import asek;
import avet;
import awzy;
import axqy;
import axrm;
import axva;
import ayfx;
import aykk;
import ayku;
import aywm;
import bbbw;
import bbbx;
import bbcc;
import bbcq;
import bbdj;
import bbdx;
import bbea;
import bbef;
import bbfj;
import bbft;
import bbgu;
import bbkk;
import bbmf;
import bbvj;
import bcql;
import bfnk;
import bfpc;
import bfpp;
import bfxu;
import bgky;
import bgpg;
import bgph;
import bv;
import bw;
import bx;
import by;
import bz;
import ca;
import cb;
import cc;
import cd;
import ce;
import cf;
import cg;
import ch;
import ci;
import cj;
import ck;
import cl;
import cm;
import com.dataline.util.file.SendInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import cr;
import cs;
import ct;
import cu;
import cv;
import cw;
import cx;
import cy;
import cz;
import da;
import db;
import de;
import df;
import dg;
import dh;
import di;
import dj;
import dk;
import dl;
import dm;
import dn;
import do;
import dp;
import dq;
import dr;
import ds;
import dt;
import du;
import dv;
import eo;
import fk;
import fq;
import fw;
import fx;
import fz;
import ga;
import gb;
import gc;
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
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lkj;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ynt;

public class LiteActivity
  extends IphoneTitleBarActivity
  implements aefz, aejy, Handler.Callback, View.OnClickListener, bfxu, Observer
{
  public static String a;
  protected static String c;
  public int a;
  ajut jdField_a_of_type_Ajut = new cl(this);
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
  private anfe jdField_a_of_type_Anfe;
  aoun jdField_a_of_type_Aoun = new cw(this);
  aqbe jdField_a_of_type_Aqbe = null;
  bbgu jdField_a_of_type_Bbgu = null;
  private InputLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
  public SessionInfo a;
  PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  protected TopGestureLayout a;
  public DataLineMsgSetList a;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public BubblePopupWindow a;
  public PatchedButton a;
  public XEditTextEx a;
  public XListView a;
  public XPanelContainer a;
  dt jdField_a_of_type_Dt;
  public fk a;
  Runnable jdField_a_of_type_JavaLangRunnable = new LiteActivity.37(this);
  List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public View.OnClickListener b;
  public ImageButton b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private bbgu jdField_b_of_type_Bbgu;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  TextView c;
  protected boolean c;
  protected boolean d;
  boolean e = false;
  boolean f = true;
  boolean g = true;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.LiteActivity";
  }
  
  public LiteActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = ajsd.z;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = null;
    this.jdField_a_of_type_Fk = null;
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new cg(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ch(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new cs(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ct(this);
  }
  
  private void A()
  {
    if (this.jdField_b_of_type_Bbgu != null) {
      this.jdField_b_of_type_Bbgu.dismiss();
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_Dt == null) {
      return;
    }
    this.jdField_a_of_type_Dt.a();
  }
  
  static Drawable a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = Shader.TileMode.REPEAT;
        Drawable localDrawable = paramContext.getResources().getDrawable(2130838762);
        if ((localDrawable instanceof BitmapDrawable))
        {
          localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
          paramString = ((BitmapDrawable)localDrawable).getTileModeX();
          m = ((BitmapDrawable)localDrawable).getGravity();
          if ((localBitmap == null) || (paramString == Shader.TileMode.REPEAT) || (m != 48)) {
            return paramContext.getResources().getDrawable(2130838762);
          }
        }
        else
        {
          if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
            break label192;
          }
          localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
          paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
          m = ((SkinnableBitmapDrawable)localDrawable).getGravity();
          continue;
        }
        paramString = new anoy(paramContext.getResources(), localBitmap);
        paramString.setGravity(m);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 1", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130848971);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteActivity setAIOBackgroundBmp 2", 2, paramString.getMessage());
        }
        return paramContext.getResources().getDrawable(2130848971);
      }
      label192:
      int m = 119;
      Bitmap localBitmap = null;
    }
  }
  
  private View a()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = ((PhotoListPanel)View.inflate(this, 2131560629, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setCustomOnClickListener(this);
    Intent localIntent = new Intent();
    String str1 = this.app.getAccount();
    Object localObject = ((ajxl)this.app.getManager(51)).e(str1);
    if (localObject != null) {}
    for (localObject = ((Friends)localObject).name;; localObject = null)
    {
      String str2 = this.app.a(1, str1, 0);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(new da(this));
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
    //   1: invokevirtual 387	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aload 8
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 393	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +35 -> 55
    //   23: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +13 -> 39
    //   29: getstatic 74	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   32: iconst_2
    //   33: ldc_w 395
    //   36: invokestatic 398	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload 6
    //   41: ifnull +10 -> 51
    //   44: aload 6
    //   46: invokeinterface 403 1 0
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: areturn
    //   55: aload 6
    //   57: ldc_w 405
    //   60: invokeinterface 409 2 0
    //   65: istore_2
    //   66: aload 6
    //   68: ldc_w 411
    //   71: invokeinterface 414 2 0
    //   76: istore_3
    //   77: aload 6
    //   79: invokeinterface 417 1 0
    //   84: pop
    //   85: aload 6
    //   87: iload_3
    //   88: invokeinterface 421 2 0
    //   93: lstore 4
    //   95: lload 4
    //   97: l2f
    //   98: invokestatic 426	bbdx:c	()F
    //   101: fcmpl
    //   102: ifle +27 -> 129
    //   105: aload_0
    //   106: ldc_w 427
    //   109: invokevirtual 431	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   112: putstatic 433	com/dataline/activities/LiteActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   115: aload 6
    //   117: ifnull +10 -> 127
    //   120: aload 6
    //   122: invokeinterface 403 1 0
    //   127: aconst_null
    //   128: areturn
    //   129: aload 6
    //   131: iload_2
    //   132: invokeinterface 434 2 0
    //   137: astore 7
    //   139: new 364	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   146: aload_0
    //   147: invokevirtual 438	com/dataline/activities/LiteActivity:getExternalCacheDir	()Ljava/io/File;
    //   150: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: ldc_w 443
    //   156: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 445
    //   162: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 443
    //   168: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 9
    //   176: aload 9
    //   178: invokestatic 448	com/dataline/activities/LiteActivity:e	(Ljava/lang/String;)V
    //   181: new 364	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   188: aload 9
    //   190: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 9
    //   195: iconst_1
    //   196: anewarray 450	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: aload 7
    //   203: aastore
    //   204: iconst_0
    //   205: aaload
    //   206: invokestatic 453	bbdx:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   209: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore 7
    //   217: new 455	com/tencent/mm/vfs/VFSFile
    //   220: dup
    //   221: aload 9
    //   223: invokespecial 457	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   226: astore 9
    //   228: aload 9
    //   230: invokevirtual 460	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   233: ifne +35 -> 268
    //   236: aload 9
    //   238: invokevirtual 463	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   241: ifne +27 -> 268
    //   244: aload_0
    //   245: ldc_w 464
    //   248: invokestatic 468	ajya:a	(I)Ljava/lang/String;
    //   251: invokespecial 470	com/dataline/activities/LiteActivity:d	(Ljava/lang/String;)V
    //   254: aload 6
    //   256: ifnull +10 -> 266
    //   259: aload 6
    //   261: invokeinterface 403 1 0
    //   266: aconst_null
    //   267: areturn
    //   268: aload 8
    //   270: aload_1
    //   271: invokevirtual 474	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   274: astore_1
    //   275: aload_1
    //   276: ifnonnull +33 -> 309
    //   279: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +13 -> 295
    //   285: getstatic 74	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   288: iconst_2
    //   289: ldc_w 476
    //   292: invokestatic 398	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload 6
    //   297: ifnull +10 -> 307
    //   300: aload 6
    //   302: invokeinterface 403 1 0
    //   307: aconst_null
    //   308: areturn
    //   309: lload 4
    //   311: ldc2_w 477
    //   314: lcmp
    //   315: ifle +138 -> 453
    //   318: aload_0
    //   319: iconst_1
    //   320: putfield 480	com/dataline/activities/LiteActivity:i	Z
    //   323: new 175	bbgu
    //   326: dup
    //   327: aload_0
    //   328: ldc_w 481
    //   331: invokespecial 484	bbgu:<init>	(Landroid/content/Context;I)V
    //   334: astore 8
    //   336: aload 8
    //   338: ldc_w 485
    //   341: invokevirtual 488	bbgu:setContentView	(I)V
    //   344: aload 8
    //   346: aload_0
    //   347: ldc_w 489
    //   350: invokevirtual 431	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   353: invokevirtual 493	bbgu:setTitle	(Ljava/lang/String;)Lbbgu;
    //   356: pop
    //   357: aload 8
    //   359: aload_0
    //   360: ldc_w 494
    //   363: invokevirtual 431	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   366: invokevirtual 498	bbgu:setMessage	(Ljava/lang/CharSequence;)Lbbgu;
    //   369: pop
    //   370: aload 8
    //   372: iconst_0
    //   373: invokevirtual 502	bbgu:setCanceledOnTouchOutside	(Z)V
    //   376: aload 8
    //   378: iconst_0
    //   379: invokevirtual 505	bbgu:setCancelable	(Z)V
    //   382: aload 8
    //   384: aload_0
    //   385: ldc_w 506
    //   388: invokevirtual 431	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   391: new 508	dc
    //   394: dup
    //   395: aload_0
    //   396: aload_1
    //   397: invokespecial 511	dc:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/io/InputStream;)V
    //   400: invokevirtual 515	bbgu:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbbgu;
    //   403: pop
    //   404: aload 8
    //   406: aload_0
    //   407: ldc_w 516
    //   410: invokevirtual 431	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   413: new 518	dd
    //   416: dup
    //   417: aload_0
    //   418: aload 7
    //   420: aload_1
    //   421: lload 4
    //   423: invokespecial 521	dd:<init>	(Lcom/dataline/activities/LiteActivity;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   426: invokevirtual 524	bbgu:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbbgu;
    //   429: pop
    //   430: aload 8
    //   432: invokevirtual 527	bbgu:show	()V
    //   435: aload 7
    //   437: astore_1
    //   438: aload 6
    //   440: ifnull -387 -> 53
    //   443: aload 6
    //   445: invokeinterface 403 1 0
    //   450: aload 7
    //   452: areturn
    //   453: aload_0
    //   454: aload 7
    //   456: aload_1
    //   457: lload 4
    //   459: invokespecial 530	com/dataline/activities/LiteActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   462: goto -27 -> 435
    //   465: astore 7
    //   467: aload 6
    //   469: astore_1
    //   470: aload 7
    //   472: astore 6
    //   474: aload_0
    //   475: iconst_0
    //   476: putfield 532	com/dataline/activities/LiteActivity:h	Z
    //   479: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +15 -> 497
    //   485: getstatic 74	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   488: iconst_2
    //   489: ldc_w 534
    //   492: aload 6
    //   494: invokestatic 537	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   497: aload_1
    //   498: ifnull +9 -> 507
    //   501: aload_1
    //   502: invokeinterface 403 1 0
    //   507: aconst_null
    //   508: areturn
    //   509: astore_1
    //   510: aconst_null
    //   511: astore 6
    //   513: aload 6
    //   515: ifnull +10 -> 525
    //   518: aload 6
    //   520: invokeinterface 403 1 0
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
    //   65	67	2	m	int
    //   76	12	3	n	int
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
  
  public static void a(Context paramContext)
  {
    cb localcb = new cb();
    bbdj.a(paramContext, 233, paramContext.getString(2131720260), paramContext.getString(2131693902), 2131693887, 2131693887, localcb, null).show();
  }
  
  static void a(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    View localView = paramIphoneTitleBarActivity.findViewById(2131369331);
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
    int m = 0;
    SharedPreferences localSharedPreferences = acur.a(paramIphoneTitleBarActivity, paramIphoneTitleBarActivity.app.getCurrentAccountUin(), 0);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = ajsd.z;
    arrayOfString[1] = "chat_uniform_bg";
    if ((localSharedPreferences.getString(arrayOfString[0], null) == null) && (localSharedPreferences.getString(arrayOfString[1], null) == null))
    {
      a(paramIphoneTitleBarActivity, paramViewGroup, "null");
      return;
    }
    int n = arrayOfString.length;
    for (;;)
    {
      if (m >= n) {
        break label188;
      }
      String str = localSharedPreferences.getString(arrayOfString[m], null);
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
      m += 1;
    }
    label188:
    a(paramIphoneTitleBarActivity, paramViewGroup, "null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    a(paramString, paramContext, new cc(paramQQAppInterface, paramString));
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet)
  {
    MessageForPic localMessageForPic = null;
    int m;
    if (paramDataLineMsgSet == null)
    {
      m = 1;
      paramDataLineMsgSet = localMessageForPic;
    }
    for (;;)
    {
      if (m != 0)
      {
        bcql.a(getApplicationContext(), getString(2131695182), 0).b(getResources().getDimensionPixelSize(2131298865));
        return;
        ArrayList localArrayList = paramDataLineMsgSet.values();
        if ((localArrayList == null) || (localArrayList.size() == 0))
        {
          m = 1;
          paramDataLineMsgSet = localMessageForPic;
          continue;
        }
        paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
        if (paramDataLineMsgSet == null) {
          m = 1;
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
        if ((bbdx.a(localMessageForPic.path)) && (paramDataLineMsgSet.md5 == null))
        {
          QLog.i(jdField_a_of_type_JavaLangString, 1, "savePicsAsCustomFace, calc md5!");
          ThreadManager.executeOnSubThread(new LiteActivity.30(this, localMessageForPic));
          return;
        }
        localMessageForPic.md5 = bbea.a(paramDataLineMsgSet.md5);
        a(localMessageForPic);
        return;
      }
      m = 0;
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null)
    {
      bcql.a(getApplicationContext(), getString(2131695182), 0).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "savePicsAsCustomFace, md5:" + paramMessageForPic.md5);
    URLDrawable localURLDrawable = aywm.a(aywm.a(paramMessageForPic, 1, "datalineface"), -1, -1, null, null, false);
    localURLDrawable.setTag(paramMessageForPic);
    aehw.a(this, this.app, localURLDrawable, paramMessageForPic.frienduin, getResources().getDimensionPixelSize(2131298865), null, paramMessageForPic.picExtraData);
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
  
  static void a(String paramString, Context paramContext, dr paramdr)
  {
    ThreadManager.executeOnSubThread(new LiteActivity.20(paramContext, paramString, paramdr));
  }
  
  static void a(String paramString, ds paramds)
  {
    ThreadManager.executeOnSubThread(new LiteActivity.15(paramString, paramds));
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.h = true;
    ThreadManager.post(new LiteActivity.45(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.jdField_b_of_type_Bbgu == null)
    {
      this.jdField_b_of_type_Bbgu = bbdj.a(this, getString(2131691312), ajya.a(2131706190), new de(this));
      this.jdField_b_of_type_Bbgu.setOnDismissListener(new df(this));
    }
    this.jdField_b_of_type_Bbgu.show();
  }
  
  static boolean a(IphoneTitleBarActivity paramIphoneTitleBarActivity, ViewGroup paramViewGroup, String paramString)
  {
    String str = (String)paramViewGroup.getTag(2131361806);
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString))) {
      if (!"null".equals(str))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131361806, "null");
      }
    }
    for (;;)
    {
      return true;
      if ("none".equals(paramString))
      {
        paramViewGroup.setBackgroundDrawable(a(paramIphoneTitleBarActivity, paramString));
        paramViewGroup.setTag(2131361806, "null");
      }
      else if (!paramString.equals(str))
      {
        a(paramString, new by(paramIphoneTitleBarActivity, paramString, paramViewGroup));
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
  
  public static void b(Context paramContext)
  {
    dh localdh = new dh();
    bbdj.a(paramContext, 233, paramContext.getString(2131720260), paramContext.getString(2131693911), 2131693887, 2131693887, localdh, null).show();
  }
  
  @Deprecated
  private void b(ArrayList<String> paramArrayList)
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
    localIntent.putExtra(bbbw.h, 55);
    localIntent.putExtra("uin", ajsd.z);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("LASTFROM", this.leftView.getText().toString());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = getBaseContext().getSharedPreferences("album_file", 0);
    paramArrayList = ((SharedPreferences)localObject).getString("album_key_name", null);
    localObject = ((SharedPreferences)localObject).getString("album_key_id", null);
    localIntent.putExtra("ALBUM_NAME", paramArrayList);
    localIntent.putExtra("ALBUM_ID", (String)localObject);
    localIntent.setClass(this, PhotoListActivity.class);
    localIntent.addFlags(603979776);
    startActivity(localIntent);
    bbbx.a(this, true, false);
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
    //   7: getstatic 994	android/os/Build$VERSION:SDK_INT	I
    //   10: bipush 23
    //   12: if_icmplt +93 -> 105
    //   15: iload_2
    //   16: istore_3
    //   17: aload_0
    //   18: ldc_w 996
    //   21: invokevirtual 999	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   24: istore_1
    //   25: iload_1
    //   26: ifne +81 -> 107
    //   29: iconst_1
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +80 -> 112
    //   35: aload_0
    //   36: ldc_w 1001
    //   39: invokevirtual 999	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
    //   42: ifne +70 -> 112
    //   45: iconst_1
    //   46: istore_2
    //   47: iload_2
    //   48: ifeq +69 -> 117
    //   51: aload_0
    //   52: ldc_w 1003
    //   55: invokevirtual 999	com/dataline/activities/LiteActivity:checkSelfPermission	(Ljava/lang/String;)I
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
    //   79: anewarray 450	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 996
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: ldc_w 1001
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: ldc_w 1003
    //   99: aastore
    //   100: invokevirtual 1007	com/dataline/activities/LiteActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
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
    //   126: invokevirtual 1010	java/lang/Exception:printStackTrace	()V
    //   129: getstatic 74	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   132: iconst_2
    //   133: new 364	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 1012
    //   143: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 5
    //   148: invokevirtual 441	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: iload_3
    //   158: ireturn
    //   159: astore 5
    //   161: iload_2
    //   162: istore_3
    //   163: goto -39 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	LiteActivity
    //   24	36	1	m	int
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
    bbgu localbbgu = new bbgu(this, 2131755791);
    localbbgu.setContentView(2131558906);
    localbbgu.setTitle(getString(2131720260));
    localbbgu.setMessage(paramString);
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.setCancelable(false);
    localbbgu.setNegativeButton(getString(2131690572), new dg(this));
    localbbgu.show();
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691382);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839280);
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
      int n = paramString.length;
      int m = 0;
      while (m < n)
      {
        Object localObject = paramString[m];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        m += 1;
      }
    }
  }
  
  @TargetApi(19)
  private void v()
  {
    this.j = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131378798));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if (!this.j) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.mContentView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDirtyListener(new ce(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new cr(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void w()
  {
    bcql localbcql = new bcql(this);
    localbcql.a(bcql.a(1));
    localbcql.b(1);
    localbcql.d(2000);
    localbcql.c(2131694118);
    localbcql.a();
  }
  
  private void x()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktxt");
      a(new aykk(str, 13, 32, 6000).toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    }
  }
  
  private void y()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", ajsd.z);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qfile_entrance_type_key", 11);
    localIntent.putExtra("select_file_support_send_docs_file", ancv.a().a());
    startActivityForResult(localIntent, 2);
    overridePendingTransition(2130771979, 2130771980);
    axqy.b(this.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
  }
  
  private void z()
  {
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList != null) {
      m = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    }
    while (m == 0) {
      if (!this.e)
      {
        d(true);
        return;
        m = 0;
      }
      else
      {
        d(false);
        return;
      }
    }
    d(false);
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
    for (boolean bool = akwf.a(this);; bool = true)
    {
      if (!bool)
      {
        requestPermissions(new cz(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return null;
      }
      return a();
    }
  }
  
  DataLineMsgRecord a(ajum paramajum, SendInfo paramSendInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSendInfo == null) {
      return null;
    }
    paramajum = new DataLineMsgRecord();
    String str1 = paramSendInfo.a();
    String str2 = paramSendInfo.b();
    paramajum.sessionid = paramSendInfo.a();
    paramajum.path = str1;
    paramajum.thumbPath = str2;
    paramajum.msgtype = ajum.a(paramInt1);
    paramajum.groupId = paramInt2;
    paramajum.groupSize = paramInt3;
    paramajum.groupIndex = paramInt4;
    return paramajum;
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().a(paramForwardFileInfo.b());
    if (localFileManagerEntity == null) {}
    int i1;
    do
    {
      return null;
      i1 = ajum.a(localFileManagerEntity);
    } while (!ajum.c(i1));
    int n = ajum.a(paramForwardFileInfo.d(), paramBoolean);
    int m = n;
    if (!paramBoolean)
    {
      m = n;
      if (n == 1) {
        m = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = ajum.a(m);
    localDataLineMsgRecord.sessionid = ((ajum)this.app.a(8)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.d();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.d();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.b();
    localDataLineMsgRecord.fileFrom = i1;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.f();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = bbea.a(localFileManagerEntity.strFileMd5);
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
      str = ajsd.A;
    }
    for (int m = 6003;; m = 6000)
    {
      return asek.a(this.app).a(this.app, str, m);
      str = ajsd.z;
    }
  }
  
  public void a()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131376255);
      ((View)localObject).setBackgroundResource(2130838772);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131376255).setVisibility(8);
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
    if (this.jdField_a_of_type_Bbgu != null)
    {
      this.jdField_a_of_type_Bbgu.show();
      return;
    }
    Object localObject2 = getString(2131719421);
    Object localObject1 = localObject2;
    if (paramString != null) {
      localObject1 = (String)localObject2 + paramString;
    }
    paramString = new bw(this, paramLong);
    localObject2 = new bx(this, paramLong, this);
    this.jdField_a_of_type_Bbgu = bbdj.a(this, 232, null, this.app.getApplication().getString(2131719427), (String)localObject1, this.app.getApplication().getString(2131719422), paramString, (DialogInterface.OnClickListener)localObject2);
    this.jdField_a_of_type_Bbgu.show();
  }
  
  void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && ((paramIntent.getAction().equals("android.intent.action.SEND")) || (paramIntent.getAction().equals("android.intent.action.SEND_MULTIPLE")))) {
      this.jdField_a_of_type_Dt.a(paramIntent);
    }
  }
  
  void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.app.a(paramMessage)) || (this.k) || (adic.a(paramMessage.frienduin, paramMessage.istroop, this.app))) {
      return;
    }
    Intent localIntent = this.app.a(this, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    runOnUiThread(new LiteActivity.36(this, paramMessage, localIntent));
  }
  
  public void a(fw paramfw)
  {
    if (!bbfj.d(getActivity()))
    {
      aptx.a(2131694673);
      return;
    }
    Object localObject2 = "";
    DataLineMsgSet localDataLineMsgSet = paramfw.a();
    Object localObject1;
    if ((apug.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > apei.a())) {
      localObject1 = getString(2131692678);
    }
    label80:
    int m;
    for (;;)
    {
      if (((String)localObject1).equals(""))
      {
        localObject1 = getString(2131693954);
        localObject2 = (bfpc)bfpp.a(this, null);
        ((bfpc)localObject2).a((CharSequence)localObject1);
        ((bfpc)localObject2).a(getResources().getString(2131692872), 1);
        ((bfpc)localObject2).c(2131690596);
        ((bfpc)localObject2).a(new ci(this, localDataLineMsgSet, paramfw, (bfpc)localObject2));
        ((bfpc)localObject2).show();
        return;
        if (localDataLineMsgSet.getGroupType() == -1000)
        {
          localObject1 = getString(2131693955);
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
              m = 0;
              label202:
              if (((Iterator)localObject1).hasNext())
              {
                if (!DataLineMsgSet.isCanReciveOrResend((DataLineMsgRecord)((Iterator)localObject1).next())) {
                  break label261;
                }
                m += 1;
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
      localObject1 = String.format(getString(2131693927), new Object[] { Integer.valueOf(m) });
      break;
      break label80;
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.k) {
      b(true);
    }
    actj.n = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {}
    do
    {
      return;
      int m = ((Integer)paramObject).intValue();
      if (m == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        return;
      }
      switch (m)
      {
      default: 
        return;
      case 4: 
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
        }
        axqy.b(this.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
        getIntent().putExtra("qq_sub_business_id", 107);
        return;
      case 5: 
        axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktkphoto");
        i();
        axqy.b(this.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
        return;
      case 16: 
        axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_ckfile");
        if (!CheckPermission.isHasStoragePermission(this))
        {
          CheckPermission.requestSDCardPermission(this, new cx(this));
          return;
        }
        y();
        return;
      }
      if (a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    f();
    axqy.b(null, "CliOper", "", "", bgpg.i, bgpg.i, 0, 0, "", "", "", "");
    paramObject = new Bundle();
    paramObject.putBoolean("string_from", false);
    paramObject.putBoolean("string_uin", false);
    paramObject.putLong("device_din", 0L);
    paramObject.putInt("sTitleID", 0);
    bgph.a(this, paramObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.length() > 4500)
    {
      bcql.a(this, ajya.a(2131706187), 1).b(getTitleBarHeight());
      return;
    }
    if (getIntent().getBooleanExtra("isMigSdkShare", false))
    {
      axqy.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((ajum)this.app.a(8)).a(paramString, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Fk.notifyDataSetChanged();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (!b()) {
      b(null);
    }
    int m;
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return;
      m = DataLineMsgRecord.getDevTypeBySeId(paramLong);
      localDataLineMsgRecord = this.app.a().a(m).a(paramLong);
    } while (localDataLineMsgRecord == null);
    ajum localajum = (ajum)this.app.a(8);
    localDataLineMsgRecord.bIsResendOrRecvFile = true;
    switch (paramInt)
    {
    default: 
      this.app.a().a(m).a(paramLong);
      a(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Fk.notifyDataSetChanged();
      return;
      localajum.a(paramString, localDataLineMsgRecord.thumbPath, 1, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      localajum.a(paramString, localDataLineMsgRecord.thumbPath, 2, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      continue;
      if (bbdx.a(paramString)) {
        localajum.a(paramString, localDataLineMsgRecord.thumbPath, 0, paramLong, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      }
      if (localDataLineMsgRecord.nOpType == 35) {
        localajum.b(localDataLineMsgRecord);
      } else {
        localajum.a().a(localDataLineMsgRecord, m, 2);
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent1.putExtra("peakconstant.request_code", 55);
    localIntent1.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent1.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent1.putExtra("PhotoConst.is_troop_send_mixed_msg", false);
    localIntent1.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
    localIntent1.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", true);
    localIntent1.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
    localIntent1.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
    localIntent1.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    Intent localIntent2 = new Intent(this, NewPhotoListActivity.class);
    localIntent2.putExtra("enter_from", 40);
    int m = acxs.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramArrayList, localIntent1, localIntent2);
    localIntent2.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "");
    localIntent2.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "");
    localIntent2.putExtra(bbbw.h, 55);
    localIntent2.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent2.putExtra("PhotoConst.original_button", true);
    if (m == -1) {
      startActivity(localIntent2);
    }
    for (;;)
    {
      bbbx.a(this, false, true);
      if (bgky.a != null) {
        bgky.a.b();
      }
      return;
      localIntent2.putExtra("PhotoConst.editPathMap", agpk.a(new HashMap()));
      startActivityForResult(localIntent2, m);
    }
  }
  
  public void a(ArrayList<String> paramArrayList, int paramInt)
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
      int m = 0;
      while (m < paramArrayList.size())
      {
        axqy.b(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
        }
        m += 1;
      }
    }
    bz localbz = new bz(this, paramArrayList);
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
    if ((bbfj.g(this)) && (!bbfj.h(this)) && (l > apei.a()))
    {
      aptt.a(this, 2131692673, 2131692678, new ca(this, localbz, paramInt));
      return;
    }
    localbz.execute(new Integer[] { Integer.valueOf(paramInt) });
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
        int m = apug.a(str);
        if (2 == m) {
          localArrayList1.add(str);
        } else if (m == 0) {
          localArrayList2.add(str);
        }
      }
      if (!localArrayList2.isEmpty())
      {
        paramList = new Bundle();
        paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList2);
        new du(this).execute(new Bundle[] { paramList });
      }
    } while (localArrayList1.isEmpty());
    paramList = new Bundle();
    paramList.putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList1);
    new dv(this).execute(new Bundle[] { paramList });
  }
  
  void a(Observable paramObservable, Object paramObject)
  {
    j();
    if ((paramObject instanceof DataLineMsgRecord))
    {
      paramObservable = (DataLineMsgRecord)paramObject;
      int m = DataLineMsgRecord.getDevTypeBySeId(paramObservable.sessionid);
      DataLineMsgSet localDataLineMsgSet = this.app.a(m).a(paramObservable.sessionid);
      if (QLog.isDevelopLevel()) {
        QLog.d("AutoTest_Xandy", 4, "SessionID:" + paramObservable.sessionid + ", Show:" + System.currentTimeMillis());
      }
      if ((DataLineMsgSet.isSingle(paramObservable)) || (localDataLineMsgSet == null) || (localDataLineMsgSet.getComeCount() <= 1)) {
        this.jdField_a_of_type_Fk.notifyDataSetChanged();
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
        if (!this.jdField_a_of_type_Fk.a(paramObservable.sessionid, this.jdField_a_of_type_ComTencentWidgetXListView))
        {
          this.jdField_a_of_type_Fk.notifyDataSetChanged();
          continue;
          if ((paramObject instanceof QQMessageFacade.Message))
          {
            paramObservable = (QQMessageFacade.Message)paramObject;
            if (paramObservable.frienduin == null) {
              break;
            }
            if (!paramObservable.frienduin.endsWith(String.valueOf(ajsd.z))) {
              continue;
            }
            this.jdField_a_of_type_Fk.notifyDataSetChanged();
            continue;
          }
          if ((paramObject instanceof RecentUser))
          {
            paramObservable = (RecentUser)paramObject;
            if (paramObservable.uin == null) {
              break;
            }
            if (paramObservable.uin.endsWith(String.valueOf(ajsd.z))) {
              this.jdField_a_of_type_Fk.notifyDataSetChanged();
            }
          }
        }
      }
      paramObject = (HotChatManager)this.app.getManager(60);
    } while ((paramObservable.isread) || (paramObject.b(paramObservable.frienduin)));
    label265:
    a(this.app.a().a());
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Fk.notifyDataSetChanged();
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
      n();
      return false;
    }
    if (Build.VERSION.SDK_INT >= 18) {}
    for (long l = new StatFs(ajsd.aV).getAvailableBytes(); l < paramLong; l = new StatFs(ajsd.aV).getAvailableBlocks() * new StatFs(ajsd.aV).getBlockSize())
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
        localFileManagerEntity = this.app.a().a(paramIntent.b());
      } while (localFileManagerEntity == null);
      int m = ajum.a(localFileManagerEntity);
      switch (m)
      {
      case 0: 
      default: 
        QLog.w(jdField_a_of_type_JavaLangString, 1, "forwardFile fileFrom " + m + " is not handled");
        return false;
      case 3: 
        if (paramInt != 101) {
          break label155;
        }
        bool = true;
        paramIntent = a(paramIntent, bool, this.jdField_a_of_type_Int);
      }
    } while (paramIntent == null);
    ((ajum)this.app.a(8)).a(paramIntent, false);
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
    bbmf localbbmf = new bbmf();
    fw localfw = (fw)paramView.getTag();
    DataLineMsgSet localDataLineMsgSet = localfw.a();
    Object localObject1 = "";
    DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
    int m = localDataLineMsgSet.getGroupType();
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
        localObject2 = localfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localbbmf.a(2131364776, paramView.getContext().getString(2131691307), 2130838597);
        localbbmf.a(2131366632, paramView.getContext().getString(2131692753), 2130838606);
        localbbmf.a(2131365928, paramView.getContext().getString(2131692324), 2130838605);
        localObject1 = "";
        continue;
        localObject2 = localfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
        localObject1 = localDataLineMsgRecord.path;
        if ((actj.a(1) == 1) && (bbdx.b(localDataLineMsgRecord.path)) && (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0))
        {
          localbbmf.a(2131362121, getString(2131693374), 2130838604);
          continue;
          if (localDataLineMsgRecord.bIsMoloImage) {
            localObject1 = localfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
          }
          for (;;)
          {
            localObject3 = localDataLineMsgRecord.path;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            localObject2 = localfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = (RelativeLayout)localfw.a().jdField_a_of_type_AndroidViewView;
            }
          }
        }
      }
      else
      {
        Context localContext = ((RelativeLayout)localObject2).getContext();
        if (localDataLineMsgRecord.canForward()) {
          localbbmf.a(2131366632, localContext.getString(2131693912), 2130838606);
        }
        if ((bbdx.b((String)localObject1)) && (localDataLineMsgRecord.strMoloKey == null))
        {
          if (localDataLineMsgSet.getGroupType() == -2005)
          {
            bool = anbq.a().c();
            long l = apug.a(this.app, localDataLineMsgRecord.filename);
            String str = ancg.a().c();
            localObject3 = str;
            if (TextUtils.isEmpty(str)) {
              localObject3 = ayfx.jdField_a_of_type_JavaLangString;
            }
            if ((bool) && (ayfx.a((String)localObject1, localDataLineMsgRecord.filename, (String)localObject3)) && (localDataLineMsgRecord.filesize <= l))
            {
              axqy.b(this.app, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
              localbbmf.a(2131376912, paramView.getContext().getString(2131720132), 2130838617);
            }
          }
          if (localDataLineMsgSet.getGroupType() == -2000) {
            localbbmf.a(2131365928, paramView.getContext().getString(2131692324), 2130838605);
          }
          if (a(this.app, localDataLineMsgRecord)) {
            localbbmf.a(2131378716, localContext.getString(2131693969), 2130838619);
          }
        }
        paramView = ((RelativeLayout)localObject2).getContext();
        localbbmf.a(2131364990, paramView.getString(2131693895), 2130838601);
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsMoloImage))) {}
        for (boolean bool = true;; bool = false)
        {
          paramView = new cm(this, localDataLineMsgRecord, localDataLineMsgSet, paramView, m, (String)localObject1, bool);
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcq.a(localfw.jdField_a_of_type_AndroidWidgetRelativeLayout, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, (int)this.jdField_a_of_type_AndroidGraphicsPointF.y, localbbmf, paramView);
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new cd(this));
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
            paramView = localfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
            continue;
            if (localDataLineMsgRecord.bIsMoloImage) {
              paramView = localfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
            } else {
              paramView = localfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
            }
          }
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
      if (this.g) {
        a(localArrayList);
      }
      for (;;)
      {
        paramPhotoListPanel.g();
        axqy.b(null, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
        return true;
        b(localArrayList);
      }
    }
  }
  
  public String b()
  {
    if (jdField_c_of_type_JavaLangString == null) {
      return getString(2131719492);
    }
    return jdField_c_of_type_JavaLangString;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131369327));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Fk);
    View localView = LayoutInflater.from(this).inflate(2131558825, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(localView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_Fk.getCount());
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new cy(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new di(this));
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    s();
    if (paramInt2 == 0) {
      this.e = false;
    }
    for (;;)
    {
      z();
      return;
      if (1 == paramInt2) {
        this.e = true;
      }
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int m = this.jdField_a_of_type_Int;
    String str = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("targetUin");
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() != 0)) {
      if (this.jdField_b_of_type_JavaLangString.equals(ajsd.A))
      {
        setTitle(2131693966);
        this.jdField_a_of_type_Int = 1;
      }
    }
    for (;;)
    {
      paramIntent = (ajum)this.app.a(8);
      paramIntent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramIntent.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return;
      setTitle(2131693965);
      this.jdField_a_of_type_Int = 0;
      continue;
      if (this.jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int = paramIntent.getIntExtra("device_type", -1);
        if (this.jdField_a_of_type_Int == 1)
        {
          setTitle(2131693966);
          this.jdField_b_of_type_JavaLangString = ajsd.A;
        }
        else
        {
          setTitle(2131693965);
          this.jdField_b_of_type_JavaLangString = ajsd.z;
          this.jdField_a_of_type_Int = 0;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = m;
        this.jdField_b_of_type_JavaLangString = str;
      }
    }
  }
  
  public void b(fw paramfw)
  {
    if (!bbfj.d(getActivity()))
    {
      aptx.a(2131694673);
      return;
    }
    DataLineMsgSet localDataLineMsgSet = paramfw.a();
    if ((apug.a()) && (localDataLineMsgSet.isFileType()) && (localDataLineMsgSet.getFileTotalSize() > 3145728L)) {}
    for (paramfw = getString(2131692675);; paramfw = "")
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
        int m = localDataLineMsgSet.getTotalCount() - localDataLineMsgSet.getComeCount();
        if ((localDataLineMsgSet.getGroupType() == -2000) || ((localDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgSet.getFirstItem().bIsMoloImage))) {}
        for (paramfw = String.format(getString(2131693924), new Object[] { Integer.valueOf(m) });; paramfw = String.format(getString(2131693936), new Object[] { Integer.valueOf(m) }))
        {
          localObject = new cj(this);
          bbdj.a(this, 230, getString(2131693914), paramfw, 2131694794, 2131694794, null, (DialogInterface.OnClickListener)localObject).show();
          return;
        }
      }
      localObject = paramfw;
      if (paramfw.equals(""))
      {
        localObject = paramfw;
        if (localDataLineMsgSet.getGroupType() == -2000)
        {
          localObject = paramfw;
          if (!localDataLineMsgSet.isSingle()) {
            localObject = String.format(getString(2131693926), new Object[] { Integer.valueOf(localArrayList.size()) });
          }
        }
      }
      paramfw = (fw)localObject;
      if (((String)localObject).equals("")) {
        paramfw = getString(2131693952);
      }
      localObject = (bfpc)bfpp.a(this, null);
      ((bfpc)localObject).a(paramfw);
      ((bfpc)localObject).a(getResources().getString(2131692871), 1);
      ((bfpc)localObject).c(2131690596);
      ((bfpc)localObject).a(new ck(this, l, localDataLineMsgSet, localArrayList, (bfpc)localObject));
      ((bfpc)localObject).show();
      return;
    }
  }
  
  void b(String paramString)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.time = awzy.a();
    localDataLineMsgRecord.msgtype = -2334;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    localDataLineMsgRecord.issend = 255;
    localDataLineMsgRecord.msg = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.appendToList(localDataLineMsgRecord);
    this.jdField_a_of_type_Fk.notifyDataSetChanged();
  }
  
  void b(ArrayList<SendInfo> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    ajum localajum;
    int n;
    int m;
    Object localObject;
    for (;;)
    {
      return;
      localajum = (ajum)this.app.a(8);
      n = paramArrayList.size();
      if (n > 3) {
        break;
      }
      m = 0;
      while (m < n)
      {
        localObject = a(localajum, (SendInfo)paramArrayList.get(m), paramInt, 0, 0, 0);
        if (localObject != null) {
          localajum.a((DataLineMsgRecord)localObject, false);
        }
        m += 1;
      }
    }
    label110:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((n > 3) && (n < 50))
    {
      localObject = new ArrayList();
      int i1 = localajum.a();
      m = 0;
      if (m < n)
      {
        localDataLineMsgRecord = a(localajum, (SendInfo)paramArrayList.get(m), paramInt, i1, n, m);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, i1)) {
          break label395;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localajum.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label392:
    label395:
    for (;;)
    {
      m += 1;
      break label110;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localajum.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      n = localajum.a();
      m = 0;
      label250:
      if (m < 50)
      {
        localDataLineMsgRecord = a(localajum, (SendInfo)paramArrayList.get(m), paramInt, n, 50, m);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, n)) {
          break label392;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localajum.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        m += 1;
        break label250;
        if (((ArrayList)localObject).size() > 0) {
          localajum.a((ArrayList)localObject, false);
        }
        m = 0;
        while (m < 50)
        {
          paramArrayList.remove(0);
          m += 1;
        }
        break;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = false;
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, actj.a(8.0F, this.app.getApplication().getResources()), 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams().height = -2;
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams()).setMargins(actj.a(14.0F, this.app.getApplication().getResources()), 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130848777);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(16);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(actj.a(11.0F, this.app.getApplication().getResources()), actj.a(6.0F, this.app.getApplication().getResources()), actj.a(11.0F, this.app.getApplication().getResources()), actj.a(6.0F, this.app.getApplication().getResources()));
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight(), actj.a(100.0F, this.app.getApplication().getResources()) });
    localValueAnimator.addUpdateListener(new dj(this));
    localValueAnimator.addListener(new dk(this));
    localValueAnimator.setDuration(100L).setRepeatCount(0);
    localValueAnimator.start();
  }
  
  boolean b()
  {
    akfl localakfl = (akfl)this.app.a(10);
    return (localakfl.a() == 0) || (localakfl.d() != 0);
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
      int m = paramPhotoListPanel.jdField_a_of_type_Aekc.a(str);
      if (1 == m) {
        localArrayList.add(str);
      }
      for (;;)
      {
        l = new VFSFile(str).length() + l;
        break;
        if (m == 0) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    if (l == 0L)
    {
      a(this);
      return true;
    }
    if ((bbfj.g(this)) && (!bbfj.h(this)) && (l > apei.a())) {
      aptt.a(this, 2131692673, 2131692678, new db(this, (ArrayList)localObject1, localArrayList));
    }
    for (;;)
    {
      paramPhotoListPanel.g();
      axqy.b(null, "CliOper", "", "", "0X8005A2F", "0X8005A2F", 0, 0, paramPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() + "", "", "", "");
      return true;
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
        new du(this).execute(new Bundle[] { localObject2 });
      }
      if (!localArrayList.isEmpty())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", localArrayList);
        new dv(this).execute(new Bundle[] { localObject1 });
      }
    }
  }
  
  public void c()
  {
    this.app.a().a(this.jdField_a_of_type_Int).a(15, new dn(this));
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
        actj.n = false;
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
    ajum localajum = (ajum)this.app.a(8);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.msgtype = -2009;
    localajum.a(localDataLineMsgRecord, false);
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
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131368186));
    if (this.jdField_a_of_type_AndroidTextTextWatcher != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(ayku.a);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFilters(new InputFilter[] { new dp(this) });
        ynt.a(this, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        h();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new dq(this));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(new bv(this));
        return;
        this.jdField_a_of_type_AndroidTextTextWatcher = new do(this);
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
      acxs.jdField_a_of_type_JavaLangString = (String)localObject;
      paramIntent = Uri.fromFile(new File((String)localObject));
    }
    PreferenceManager.getDefaultSharedPreferences(this).edit().remove("camera_photo_path").commit();
    if (paramIntent == null) {
      return;
    }
    paramIntent = bbef.b(this, paramIntent);
    if (paramIntent != null)
    {
      bbef.a(this, paramIntent);
      if (!bbdx.f(paramIntent))
      {
        bcql.a(this, getString(2131692541), 0).b(getTitleBarHeight());
        return;
      }
      if (!new VFSFile(paramIntent).exists()) {
        bcql.a(this, getString(2131695185), 0).b(getTitleBarHeight());
      }
    }
    else
    {
      bcql.a(this, getString(2131695185), 0).b(getTitleBarHeight());
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
    ((Intent)localObject).putExtra(bbbw.h, 55);
    ((Intent)localObject).putExtra("uin", ajsd.z);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    ((Intent)localObject).putExtra("LASTFROM", this.leftView.getText().toString());
    startActivity((Intent)localObject);
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
        z();
      } while ((paramInt2 != -1) || (paramIntent == null));
      return;
      this.jdField_a_of_type_Fk.notifyDataSetChanged();
      return;
    } while ((paramInt2 != -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramInt1, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131165360);
    setContentView(2131558930);
    setStatusBarBlue();
    boolean bool = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375329));
    if (bool) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130849033);
    }
    int i2;
    int i3;
    int i4;
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)findViewById(2131368187));
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368742);
      if (localObject1 != null) {
        ViewCompat.setImportantForAccessibility((View)localObject1, 2);
      }
      setTitle(2131693965);
      getWindow().setBackgroundDrawable(null);
      b(getIntent());
      c(getIntent());
      k();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379431));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369330));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369329));
      if (this.jdField_a_of_type_Int == 1)
      {
        axqy.b(this.app, "CliOper", "", "", "0X8005D19", "0X8005D19", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "=== dataline report event into ipad 0X8005D19 ");
        }
      }
      this.jdField_a_of_type_Dt = new dt(this, this);
      this.app.a().addObserver(this.jdField_a_of_type_Aoun);
      localObject1 = this.app.a();
      if (localObject1 != null) {
        ((QQMessageFacade)localObject1).addObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = this.app.a(this.jdField_a_of_type_Int).a(true);
      this.jdField_a_of_type_Fk = new fq(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList, this, this.app);
      b();
      d();
      localObject1 = (ajum)this.app.a(8);
      ((ajum)localObject1).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364169));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131375493));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
      e();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)findViewById(2131371243));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375832));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      q();
      addObserver(this.jdField_a_of_type_Ajut);
      p();
      this.app.a().a(this.jdField_a_of_type_Int).e();
      if (paramBundle == null) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new LiteActivity.1(this), 200L);
      }
      a(getIntent());
      paramBundle = (akfl)this.app.a(10);
      if ((paramBundle.a() == 0) && (!paramBundle.a()))
      {
        paramBundle.a();
        paramBundle.b(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.isEmpty()) {
        break label973;
      }
      paramBundle = getSharedPreferences("first_enter_dataline", 0);
      int m = paramBundle.getInt("year", -1);
      int n = paramBundle.getInt("month", -1);
      int i1 = paramBundle.getInt("day", -1);
      localObject2 = Calendar.getInstance();
      i2 = ((Calendar)localObject2).get(1);
      i3 = ((Calendar)localObject2).get(2);
      i4 = ((Calendar)localObject2).get(5);
      if ((i2 == m) && (i3 == n) && (i4 == i1)) {
        break label973;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() - 1);
      if (localObject2 == null) {
        break label973;
      }
      localObject2 = ((DataLineMsgSet)localObject2).getFirstItem();
      if ((localObject2 == null) || (((DataLineMsgRecord)localObject2).msgtype == -5000)) {
        break label973;
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
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130849032);
    }
    Object localObject1 = ((ajum)localObject1).a(0, this.jdField_a_of_type_Int);
    Object localObject2 = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject2).msgId = ((Long)localObject1).longValue();
    ((DataLineMsgRecord)localObject2).sessionid = ((Long)localObject1).longValue();
    ((DataLineMsgRecord)localObject2).msgtype = -5000;
    ((DataLineMsgRecord)localObject2).time = awzy.a();
    ((DataLineMsgRecord)localObject2).isread = true;
    this.app.a(this.jdField_a_of_type_Int).a((DataLineMsgRecord)localObject2);
    paramBundle = paramBundle.edit();
    paramBundle.putInt("year", i2);
    paramBundle.putInt("month", i3);
    paramBundle.putInt("day", i4);
    paramBundle.commit();
    label973:
    v();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366871);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131366868));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131367518));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366884));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)findViewById(2131366869));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(ajya.a(2131706185));
      this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(ajya.a(2131706184));
    }
    this.jdField_a_of_type_Anfe = new anfe(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.app, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_Anfe.a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    if (this.app.a() != null)
    {
      this.app.a().a(this.jdField_a_of_type_Int).e();
      this.app.a().a(this.jdField_a_of_type_Int).d();
      this.app.a().deleteObserver(this);
      this.jdField_a_of_type_Fk.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_Ajut != null) {
      removeObserver(this.jdField_a_of_type_Ajut);
    }
    if (this.jdField_a_of_type_Aoun != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aoun);
    }
    if (this.jdField_a_of_type_Bbgu != null)
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      this.jdField_a_of_type_Bbgu = null;
    }
    this.jdField_a_of_type_Int = -1;
    if (this.app.a() != null) {
      this.app.a().e();
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(null);
    }
    apug.b(this);
    if (this.j)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
    this.jdField_a_of_type_Anfe.b();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    i(paramIntent);
    g();
    h(paramIntent);
    e(paramIntent);
    this.jdField_a_of_type_Fk.notifyDataSetChanged();
    a(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ((ajum)this.app.a(8)).d();
    boolean bool = getIntent().getBooleanExtra("isMigSdkShare", false);
    if ((this.jdField_b_of_type_Boolean) && (!bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finishing LiteActivity (ask ippan)");
      }
      finish();
      com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
    }
    if (this.j) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a(this, this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_Fk.notifyDataSetChanged();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
    }
    ApngImage.playByTag(0);
    a();
    if (this.j) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ajsd.A;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 6003;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ajsd.z;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 6000;
  }
  
  public void e(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("MigSdkShareNotDone", false))
    {
      this.jdField_a_of_type_Aqbe = aqdm.a(paramIntent, this.app, this);
      paramIntent = new Bundle();
      paramIntent.putString("uin", String.valueOf(ajsd.z));
      paramIntent.putInt("uintype", -1);
      this.jdField_a_of_type_Aqbe.a(aqau.f.intValue(), paramIntent);
    }
    int m;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(a());
      m = paramIntent.getIntExtra(bbbw.h, -1);
      if (55 != m) {
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
      if (56 == m)
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
    ((ajum)this.app.a(8)).jdField_a_of_type_Boolean = false;
    l();
    if ((this.jdField_c_of_type_Boolean) && (actj.n) && (!this.d))
    {
      super.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      this.d = true;
    }
  }
  
  void g()
  {
    String str;
    int m;
    Object localObject1;
    if (this.jdField_a_of_type_Int == 1)
    {
      str = ajsd.A;
      m = 6003;
      localObject1 = null;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      }
      localObject2 = a();
      if ((!bbkk.a((String)localObject2)) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (!bbkk.a(String.valueOf(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText())))) {
        break label82;
      }
    }
    label82:
    while ((!bbkk.a((String)localObject2)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (((String)localObject2).equals(String.valueOf(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))))
    {
      return;
      str = ajsd.z;
      m = 6000;
      break;
    }
    Object localObject2 = asek.a(this.app);
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = str;
      localDraftTextInfo.type = m;
      localDraftTextInfo.text = ((CharSequence)localObject1).toString();
      localDraftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
      ((asek)localObject2).a(this.app, localDraftTextInfo);
    }
    for (;;)
    {
      localObject1 = this.app.a();
      localObject2 = ((asek)localObject2).a(this.app, str, m);
      if (localObject2 == null) {
        break;
      }
      ((QQMessageFacade)localObject1).a(str, m, "", ((DraftSummaryInfo)localObject2).getSummary(), ((DraftSummaryInfo)localObject2).getTime());
      return;
      ((asek)localObject2).a(this.app, str, m);
    }
    ((QQMessageFacade)localObject1).a(str, m, "", "", 0L);
  }
  
  void g(Intent paramIntent)
  {
    int n = paramIntent.getIntExtra("dataline_forward_type", -1);
    int m = 0;
    if (n == -1) {
      label16:
      return;
    }
    paramIntent.getIntExtra("dataline_forward_type", -1);
    long l = paramIntent.getLongExtra("req_share_id", 0L);
    if (paramIntent.getBooleanExtra("sendMultiple", false)) {
      if (n != 100) {
        break label1421;
      }
    }
    label263:
    label1416:
    label1421:
    for (int i1 = 0;; i1 = 1)
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
          localObject6 = (ajum)this.app.a(8);
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = a((ForwardFileInfo)((Iterator)localObject2).next(), false, this.jdField_a_of_type_Int);
            if (localDataLineMsgRecord != null) {
              if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
              {
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(localDataLineMsgRecord);
                ((ajum)localObject6).a(localArrayList, false);
                m = 1;
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
        ((ajum)localObject6).a((ArrayList)localObject5, false);
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
        paramIntent = axva.a(paramIntent);
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
              if (m != 0) {
                break label263;
              }
              o();
              break label263;
              localObject5 = ((ArrayList)localObject2).iterator();
              for (m = 0; ((Iterator)localObject5).hasNext(); m = n)
              {
                localObject6 = (String)((Iterator)localObject5).next();
                if (localObject6 != null)
                {
                  n = m;
                  if (!((String)localObject6).equals("/")) {}
                }
                else
                {
                  n = m;
                  if (m == 0)
                  {
                    n = 1;
                    o();
                  }
                  ((Iterator)localObject5).remove();
                }
              }
              if (!((ArrayList)localObject2).isEmpty())
              {
                a((ArrayList)localObject2, i1);
                break label263;
              }
              if (m != 0) {
                break label263;
              }
              o();
              break label263;
              localObject5 = new ArrayList();
              if (a(paramIntent, n)) {
                break;
              }
              switch (n)
              {
              default: 
                axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_other");
                break;
              case 101: 
                axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_image");
                localObject2 = paramIntent.getStringExtra("dataline_forward_path");
                if (localObject2 == null)
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "handleForwardRequest forward image, extras: " + paramIntent.getExtras().toString());
                  break;
                }
                localObject6 = ((String)localObject2).split(";");
                ((ArrayList)localObject5).clear();
                m = 0;
                if (m < localObject6.length) {
                  try
                  {
                    localObject2 = URLDecoder.decode(localObject6[m], "UTF-8");
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      if ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
                      {
                        a((String)localObject2);
                        axqy.b(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                          QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                        }
                        m += 1;
                      }
                    }
                  }
                  catch (UnsupportedEncodingException paramIntent)
                  {
                    if (!QLog.isColorLevel()) {
                      break label16;
                    }
                    QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[m]);
                    return;
                  }
                  catch (IllegalArgumentException localIllegalArgumentException1)
                  {
                    for (;;)
                    {
                      localObject3 = localObject6[m];
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
              axqy.b(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
              if (!QLog.isColorLevel()) {
                break label263;
              }
              QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
              break label263;
            }
            if (((ArrayList)localObject5).size() != 1) {
              break label263;
            }
            axqy.b(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break label263;
            }
            QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
            break label263;
            axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_file");
            Object localObject3 = paramIntent.getStringExtra("dataline_forward_path");
            if ((localObject3 == null) || (((String)localObject3).equals("")))
            {
              o();
              return;
            }
            localObject6 = ((String)localObject3).split(";");
            ((ArrayList)localObject5).clear();
            m = 0;
            if (m < localObject6.length) {
              try
              {
                localObject3 = URLDecoder.decode(localObject6[m], "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                  {
                    a((String)localObject3);
                    m += 1;
                  }
                }
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + localObject6[m]);
                return;
              }
              catch (IllegalArgumentException localIllegalArgumentException2)
              {
                for (;;)
                {
                  localObject4 = localObject6[m];
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
          axqy.b(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break label263;
          }
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
          break label263;
          Object localObject4 = paramIntent.getStringExtra("dataline_forward_text");
          if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
            break label263;
          }
          if (bbft.d.matcher((CharSequence)localObject4).find()) {
            axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_link");
          }
          for (;;)
          {
            a((String)localObject4);
            break;
            axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_text");
          }
        }
      }
    }
  }
  
  void h()
  {
    int n = 8;
    int i1 = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this);
    int m = n;
    switch (i1)
    {
    default: 
      m = n;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(m);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_b_of_type_Int);
      return;
      m = 6;
      continue;
      m = 6;
    }
  }
  
  protected void h(Intent paramIntent)
  {
    c(paramIntent);
    int m = this.jdField_a_of_type_Int;
    b(paramIntent);
    if (m != this.jdField_a_of_type_Int)
    {
      paramIntent = this.app.a(this.jdField_a_of_type_Int);
      if (paramIntent != null) {
        break label85;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = new DataLineMsgSetList();
      this.jdField_a_of_type_Fk.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Fk.notifyDataSetChanged();
      return;
      label85:
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramIntent.a(true);
      this.jdField_a_of_type_Fk.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList);
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
      z();
      continue;
      A();
      d(b());
      continue;
      A();
      B();
      continue;
      QLog.i(jdField_a_of_type_JavaLangString, 2, "progress: " + paramMessage.arg1);
      this.jdField_b_of_type_Bbgu.setProgress(paramMessage.arg1);
    }
  }
  
  void i()
  {
    if (lkj.b(BaseApplicationImpl.getContext())) {}
    do
    {
      return;
      str = bbvj.a(ajsd.aW + "photo/");
      localObject = new File(str);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        bcql.a(this, 2131719055, 0).a();
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
    if (str.contains(getString(2131720034)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
      axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4recent");
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
        this.leftView.setText(getString(2131720034));
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
          this.leftView.setText(getString(2131720034));
          this.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
          j();
        }
      }
      if (aany.S)
      {
        str = this.leftView.getText().toString();
        paramIntent = str;
        if (!getString(2131690331).equals(str)) {
          paramIntent = ajya.a(2131706186) + str + ajya.a(2131706189);
        }
        this.leftView.setContentDescription(paramIntent);
      }
      return;
      if (str.contains(getString(2131694069))) {
        axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4buddylist");
      } else if (str.contains(getString(2131692492))) {
        axrm.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4dongtai");
      }
    }
  }
  
  void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((localObject == null) || (((String)localObject).startsWith(getString(2131720034)))) {}
    }
    else
    {
      return;
    }
    int m = 0;
    int n = avet.a(this.app);
    Object localObject = this.app.a();
    if (localObject != null) {
      m = ((QQMessageFacade)localObject).b();
    }
    m += n;
    if (m > 0)
    {
      if (m > 99)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131720034) + "(99+)");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131720034) + "(" + m + ")");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131720034));
  }
  
  void k()
  {
    Object localObject = this.rightViewImg;
    ((ImageView)localObject).setContentDescription(getResources().getText(2131693879));
    ((ImageView)localObject).setVisibility(0);
    ((ImageView)localObject).setImageResource(2130849072);
    ((ImageView)localObject).setOnClickListener(new cf(this));
    if (aany.S) {
      this.rightViewImg.setContentDescription(ajya.a(2131706192));
    }
    i(getIntent());
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.mLeftBackIcon.setVisibility(0);
      this.leftView.setBackgroundDrawable(null);
    }
    for (localObject = getResources().getColorStateList(2131166852);; localObject = getResources().getColorStateList(2131166851))
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
      this.app.a().a(this.jdField_a_of_type_Int).b(localLong.longValue());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setMsgFailedWhenQuesting: session = " + localLong.longValue());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  void m()
  {
    bcql localbcql = new bcql(this);
    localbcql.a(2130839277);
    localbcql.d(2000);
    localbcql.c(2131693956);
    localbcql.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void n()
  {
    bcql localbcql = new bcql(this);
    localbcql.a(2130839277);
    localbcql.d(2000);
    localbcql.c(2131693957);
    localbcql.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
  }
  
  void o()
  {
    bcql localbcql = new bcql(this);
    localbcql.a(2130839277);
    localbcql.d(2000);
    localbcql.c(2131693950);
    localbcql.b(this.jdField_a_of_type_ComTencentWidgetXListView.getHeight() / 2);
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
          aqfd.a(this, true, "sendToMyComputer", l);
        }
        return super.onBackEvent();
      }
      long l = getIntent().getLongExtra("res_share_id", 0L);
      if (l > 0L) {
        aqfd.a(this, true, "shareToQQ", bbcc.b(l));
      }
      return super.onBackEvent();
    }
    ApngImage.pauseAll();
    if ((this.jdField_a_of_type_Boolean) || (bool))
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    actj.n = true;
    int m = paramView.getId();
    axqy.b(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
    switch (m)
    {
    default: 
      return;
    case 2131375832: 
      x();
      return;
    case 2131370506: 
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
      return;
    case 2131367518: 
      axqy.b(this.app, "dc00898", "", "", "0X8009F36", "0X8009F36", 4, 0, "", "", "", "");
      b(false);
      return;
    case 2131366868: 
      axqy.b(this.app, "dc00898", "", "", "0X8009F27", "0X8009F27", 4, 0, "", "", "", "");
      u();
      return;
    }
    if (this.k) {
      b(false);
    }
    x();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    int m = 0;
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
          bbdj.a(this, paramArrayOfString, paramArrayOfInt);
        }
      }
      for (paramInt = m;; paramInt = 1)
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
    cu localcu = new cu(this, (List)localObject1);
    cv localcv = new cv(this);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.iterator();
    int i1 = 0;
    int i2 = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (DataLineMsgSet)localIterator.next();
      int m = 0;
      localObject2 = ((DataLineMsgSet)localObject2).values().iterator();
      int n = i1;
      int i3 = i2;
      i2 = i3;
      i1 = n;
      if (((Iterator)localObject2).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject2).next();
        if ((!DataLineMsgSet.isFileType(localDataLineMsgRecord)) || (localDataLineMsgRecord.isread) || (localDataLineMsgRecord.fileMsgStatus != 1L)) {
          break label262;
        }
        i1 = n;
        i2 = m;
        if (m == 0)
        {
          i2 = 1;
          i1 = n + 1;
        }
        ((List)localObject1).add(localDataLineMsgRecord);
        i3 += 1;
        m = i2;
        n = i1;
      }
    }
    label262:
    for (;;)
    {
      break;
      if (i1 >= 3)
      {
        localObject1 = String.format(getString(2131693968), new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
        ((ajum)this.app.a(8)).a(115);
        bbdj.a(this, 230, getString(2131693914), (String)localObject1, 2131690596, 2131693880, localcu, localcv).show();
      }
      return;
    }
  }
  
  public void q()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((str != null) && (str.length() > 0))
    {
      if (this.k)
      {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if (this.k)
    {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
  }
  
  protected void s()
  {
    int m = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (m == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(m);
  }
  
  public void t()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(15, 0, 0).sendToTarget();
  }
  
  public void u()
  {
    this.k = true;
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
    localValueAnimator.addUpdateListener(new dl(this));
    localValueAnimator.addListener(new dm(this));
    localValueAnimator.setDuration(100L).setRepeatCount(0);
    localValueAnimator.start();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.LiteActivity
 * JD-Core Version:    0.7.0.1
 */