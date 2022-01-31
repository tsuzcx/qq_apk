package com.tencent.biz.qrcode.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.Callback;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.CallBack;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PcmPlayer;
import com.tencent.chirp.PcmPlayer.QQPlayerListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.Callback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import osz;
import ota;
import otd;
import ote;
import otf;
import otg;
import oth;
import oti;
import otj;
import otk;
import otm;
import oto;
import otp;
import otq;
import ots;
import ott;
import otw;
import otx;
import oty;
import otz;
import oua;
import oub;
import oud;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, CodeMaskManager.Callback, CustomAccessibilityDelegate.CallBack, PcmPlayer.QQPlayerListener, ChirpSoHandler.Callback
{
  public int a;
  protected long a;
  public Bitmap a;
  public Bundle a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer = new ots(this, 1000L, 200L);
  protected Handler a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new otx(this);
  protected View a;
  public ImageView a;
  protected TextView a;
  public BitMatrix a;
  protected CodeMaskManager a;
  QRDisplayActivity.GetNicknameObserver jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver = new osz(this);
  private PcmPlayer jdField_a_of_type_ComTencentChirpPcmPlayer;
  public DiscussionHandler a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new oto(this);
  private ChirpSoHandler jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public Runnable a;
  public String a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  protected int b;
  public long b;
  public Bitmap b;
  private Handler b;
  public View b;
  public ImageView b;
  protected TextView b;
  public ActionSheet b;
  public Runnable b;
  public String b;
  public List b;
  public boolean b;
  public int c;
  protected long c;
  public View c;
  public ImageView c;
  protected TextView c;
  protected Runnable c;
  public String c;
  protected boolean c;
  public int d;
  public View d;
  public ImageView d;
  public String d;
  public boolean d;
  public int e;
  View jdField_e_of_type_AndroidViewView;
  public String e;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  protected View f;
  protected String f;
  private volatile boolean jdField_f_of_type_Boolean;
  public int g;
  protected View g;
  public String g;
  private boolean g;
  public int h;
  protected View h;
  
  public QRDisplayActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new ott(this);
    this.jdField_b_of_type_JavaLangRunnable = new otw(this);
    this.jdField_c_of_type_JavaLangRunnable = new oty(this);
    this.jdField_h_of_type_Int = -1;
  }
  
  private static void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfByte[(i * 2)] = ((byte)(paramArrayOfShort[i] & 0xFF));
      paramArrayOfByte[(i * 2 + 1)] = ((byte)(paramArrayOfShort[i] >> 8 & 0xFF));
      i += 1;
    }
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int j = arrayOfInt[1];
    int k = paramView.getHeight();
    int m = arrayOfInt[0];
    int n = arrayOfInt[0];
    int i1 = paramView.getWidth();
    return (paramFloat2 >= i) && (paramFloat2 < j + k) && (paramFloat1 > m) && (paramFloat1 < n + i1);
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 153	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 160	java/io/File:exists	()Z
    //   13: ifne +183 -> 196
    //   16: new 162	com/tencent/chirp/ChirpWrapper
    //   19: dup
    //   20: invokespecial 163	com/tencent/chirp/ChirpWrapper:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 165	com/tencent/chirp/ChirpWrapper:a	()I
    //   30: ifne +290 -> 320
    //   33: aload_0
    //   34: getfield 169	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 175	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: astore_3
    //   41: new 177	java/lang/String
    //   44: dup
    //   45: ldc 179
    //   47: invokespecial 180	java/lang/String:<init>	(Ljava/lang/String;)V
    //   50: astore 4
    //   52: new 182	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   59: ldc 185
    //   61: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 4
    //   66: iconst_0
    //   67: bipush 14
    //   69: aload_3
    //   70: invokevirtual 192	java/lang/String:length	()I
    //   73: isub
    //   74: invokevirtual 196	java/lang/String:substring	(II)Ljava/lang/String;
    //   77: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_3
    //   81: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_3
    //   88: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +28 -> 119
    //   94: ldc 206
    //   96: iconst_2
    //   97: new 182	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   104: ldc 208
    //   106: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload 5
    //   121: aload_3
    //   122: invokevirtual 214	com/tencent/chirp/ChirpWrapper:a	(Ljava/lang/String;)Landroid/util/Pair;
    //   125: astore_3
    //   126: aload_3
    //   127: getfield 220	android/util/Pair:first	Ljava/lang/Object;
    //   130: checkcast 222	java/lang/Integer
    //   133: invokevirtual 225	java/lang/Integer:intValue	()I
    //   136: istore_2
    //   137: aload_3
    //   138: getfield 228	android/util/Pair:second	Ljava/lang/Object;
    //   141: checkcast 230	[S
    //   144: astore 4
    //   146: iload_2
    //   147: ifne +135 -> 282
    //   150: aload 4
    //   152: ifnull +130 -> 282
    //   155: new 232	java/io/FileOutputStream
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 235	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   163: astore_3
    //   164: aload 4
    //   166: arraylength
    //   167: iconst_2
    //   168: imul
    //   169: newarray byte
    //   171: astore_1
    //   172: aload 4
    //   174: aload_1
    //   175: invokestatic 237	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   178: aload_3
    //   179: aload_1
    //   180: invokevirtual 241	java/io/FileOutputStream:write	([B)V
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   191: aload 5
    //   193: invokevirtual 246	com/tencent/chirp/ChirpWrapper:a	()V
    //   196: iconst_1
    //   197: ireturn
    //   198: astore_1
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: aload 5
    //   204: invokevirtual 246	com/tencent/chirp/ChirpWrapper:a	()V
    //   207: aload_1
    //   208: athrow
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_1
    //   212: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +12 -> 227
    //   218: ldc 206
    //   220: iconst_2
    //   221: ldc 248
    //   223: aload_3
    //   224: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_1
    //   228: astore_3
    //   229: aload_1
    //   230: ifnull +9 -> 239
    //   233: aload_1
    //   234: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   237: aconst_null
    //   238: astore_3
    //   239: aload_3
    //   240: ifnull +7 -> 247
    //   243: aload_3
    //   244: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   247: aload 5
    //   249: invokevirtual 246	com/tencent/chirp/ChirpWrapper:a	()V
    //   252: iconst_0
    //   253: ireturn
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_3
    //   257: goto -18 -> 239
    //   260: astore_1
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_3
    //   266: aload_3
    //   267: ifnull +7 -> 274
    //   270: aload_3
    //   271: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   274: aload_1
    //   275: athrow
    //   276: astore_1
    //   277: aload_1
    //   278: athrow
    //   279: astore_1
    //   280: aload_1
    //   281: athrow
    //   282: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +28 -> 313
    //   288: ldc 206
    //   290: iconst_4
    //   291: new 182	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   298: ldc 253
    //   300: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload_2
    //   304: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 5
    //   315: invokevirtual 246	com/tencent/chirp/ChirpWrapper:a	()V
    //   318: iconst_0
    //   319: ireturn
    //   320: aload 5
    //   322: invokevirtual 246	com/tencent/chirp/ChirpWrapper:a	()V
    //   325: iconst_0
    //   326: ireturn
    //   327: astore_1
    //   328: goto -137 -> 191
    //   331: astore_1
    //   332: goto -85 -> 247
    //   335: astore_3
    //   336: goto -62 -> 274
    //   339: astore_1
    //   340: goto -74 -> 266
    //   343: astore 4
    //   345: aload_1
    //   346: astore_3
    //   347: aload 4
    //   349: astore_1
    //   350: goto -84 -> 266
    //   353: astore 4
    //   355: aload_3
    //   356: astore_1
    //   357: aload 4
    //   359: astore_3
    //   360: goto -148 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	QRDisplayActivity
    //   0	363	1	paramString	String
    //   136	168	2	i	int
    //   40	148	3	localObject1	Object
    //   209	15	3	localException1	Exception
    //   228	43	3	str	String
    //   335	1	3	localIOException	java.io.IOException
    //   346	14	3	localObject2	Object
    //   50	123	4	localObject3	Object
    //   343	5	4	localObject4	Object
    //   353	5	4	localException2	Exception
    //   23	298	5	localChirpWrapper	ChirpWrapper
    // Exception table:
    //   from	to	target	type
    //   187	191	198	finally
    //   33	119	201	finally
    //   119	146	201	finally
    //   199	201	201	finally
    //   274	276	201	finally
    //   277	279	201	finally
    //   280	282	201	finally
    //   282	313	201	finally
    //   155	164	209	java/lang/Exception
    //   233	237	254	java/io/IOException
    //   233	237	260	finally
    //   155	164	263	finally
    //   261	263	263	finally
    //   243	247	276	finally
    //   270	274	279	finally
    //   187	191	327	java/io/IOException
    //   243	247	331	java/io/IOException
    //   270	274	335	java/io/IOException
    //   164	183	339	finally
    //   212	227	343	finally
    //   164	183	353	java/lang/Exception
  }
  
  public static List[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430108);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_c_of_type_Int = 0;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430114);
    localActionSheetItem.jdField_b_of_type_Int = 2130838337;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_c_of_type_Int = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
    localActionSheetItem.jdField_b_of_type_Int = 2130838340;
    localActionSheetItem.jdField_c_of_type_Int = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430127);
    localActionSheetItem.jdField_b_of_type_Int = 2130838334;
    localActionSheetItem.jdField_c_of_type_Int = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void l()
  {
    String str1;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131433009), 0).b(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        str1 = "";
        switch (this.jdField_h_of_type_Int)
        {
        default: 
          if (!TextUtils.isEmpty(str1)) {
            break;
          }
        }
      }
    }
    label474:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str1 = "qr_circle";
            break;
            str1 = "qr_qq";
            break;
            str1 = "qr_qzone";
            break;
            str1 = "qr_wechat";
            break;
            TroopReportor.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
            this.jdField_h_of_type_Int = -1;
            return;
            switch (this.jdField_h_of_type_Int)
            {
            default: 
              return;
            case 0: 
            case 2: 
            case 3: 
              try
              {
                ThreadManager.post(new otm(this, "temp_qrcode_share_" + this.jdField_c_of_type_JavaLangString + ".png"), 8, null, true);
                if (this.jdField_c_of_type_Int != 2) {
                  break label474;
                }
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError2)
              {
                String str2;
                QRUtils.a(1, 2131430003);
              }
              try
              {
                if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new otj(this);
                  WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
                }
                ThreadManager.post(new otk(this), 8, null, true);
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError1)
              {
                QRUtils.a(1, 2131430003);
              }
            }
          } while (this.jdField_c_of_type_Int != 2);
          if (this.jdField_h_of_type_Int == 2) {}
          for (str2 = "qr_wechat";; str2 = "qr_circle")
          {
            TroopReportor.a("Grp_share", "grpData_admin", str2, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
            return;
          }
        } while (this.jdField_c_of_type_Int != 2);
        TroopReportor.a("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "1" });
        return;
      } while (this.jdField_c_of_type_Int != 5);
      ReportController.b(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
      return;
      e();
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
    } while (this.jdField_c_of_type_Int != 5);
    ReportController.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
  }
  
  private void m()
  {
    if ((this.app.c()) || (!AppSetting.jdField_b_of_type_Boolean)) {
      return;
    }
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1000, 5, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void n()
  {
    if ((this.app.c()) || (!AppSetting.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1001, 5, 0).sendToTarget();
  }
  
  public BitMatrix a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      paramString = "user" + paramString;
    }
    for (;;)
    {
      paramString = getSharedPreferences("qrcode", 0).getString(paramString, null);
      if (paramString != null) {
        break label108;
      }
      return null;
      if (paramInt1 == 2)
      {
        paramString = "group" + paramString;
      }
      else
      {
        if (paramInt1 != 5) {
          break;
        }
        paramString = "discussion" + paramString;
      }
    }
    return null;
    label108:
    return QRUtils.a(paramString, paramInt2);
  }
  
  public String a()
  {
    String str;
    if (this.jdField_c_of_type_Int == 1) {
      str = "user" + this.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      return getSharedPreferences("qrcode", 0).getString(str, null);
      if (this.jdField_c_of_type_Int == 2)
      {
        str = "group" + this.jdField_c_of_type_JavaLangString;
      }
      else
      {
        if (this.jdField_c_of_type_Int != 5) {
          break;
        }
        str = "discussion" + this.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    paramString = "discussionnick_name" + paramString;
    return getSharedPreferences("qrcode", 0).getString(paramString, null);
  }
  
  public String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuffer.append("、");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus, " + this.app.c());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    String str;
    switch (paramInt)
    {
    default: 
      str = "获取多人聊天链接失败";
    }
    for (;;)
    {
      a(2130838739, str);
      finish();
      return;
      str = "多人聊天不存在";
      continue;
      str = "你已不在此多人聊天";
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "template ready, draw qrcode");
    }
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
    int m = paramBundle.getInt("B");
    int n = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      i = paramBundle.getInt("qrsz");
      localObject = a();
      if (localObject != null) {
        this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a((String)localObject, i);
      }
    }
    int i1 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a();
    Object localObject = new int[i1 * i1];
    int i = 0;
    while (i < i1)
    {
      j = 0;
      if (j < i1)
      {
        if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(j, i)) {}
        for (int k = m;; k = n)
        {
          localObject[(i * i1 + j)] = k;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    Bitmap localBitmap3 = Bitmap.createBitmap(i1, i1, Bitmap.Config.ARGB_8888);
    localBitmap3.setPixels((int[])localObject, 0, i1, 0, 0, i1, i1);
    int j = 0;
    i = j;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      if (this.jdField_b_of_type_Int == 2) {
        i = 2130841430;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = QRUtils.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.jdField_a_of_type_JavaLangString, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.jdField_b_of_type_JavaLangString, localRect, localArrayList, i);
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label412;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      i = j;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      i = 2130841430;
      break;
      label412:
      if (super.isResume())
      {
        paramBundle = DialogUtil.a(this, 230);
        paramBundle.setMessage(2131429915);
        paramBundle.setPositiveButton(2131433016, new otd(this));
        paramBundle.show();
      }
      else
      {
        super.finish();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 1) {}
    for (paramString1 = "user" + paramString1;; paramString1 = "group" + paramString1)
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      do
      {
        return;
      } while (paramInt != 2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = "discussionnick_name" + paramString1;
    SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus_clear");
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1001, 3, 0).sendToTarget();
  }
  
  public void b(int paramInt)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "1", 0, null);
    Intent localIntent = new Intent(this, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=1&seq=" + l));
    startActivityForResult(localIntent, -1);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131430006, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131430008, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131430009, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131433015);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new otz(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new oua(this));
    }
    if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void c(int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramInt != 0)) {
      QLog.d("QRDisplayActivity", 2, "onPlayStop, " + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1003, 500L);
      return;
    } while (this.jdField_b_of_type_AndroidOsHandler.hasMessages(1001));
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 1000L);
  }
  
  public void d()
  {
    ThreadManager.executeOnFileThread(new oub(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_c_of_type_Int == 2) {
        str = "saveGroupQRcard";
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (this.jdField_c_of_type_Int == 2) {
      localObject1 = "";
    }
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (paramInt2 == -1)
        {
          localObject2 = "0";
          label57:
          TroopReportor.a("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.jdField_c_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), localObject2 });
        }
      }
      else if (paramInt2 == -1)
      {
        if (paramInt1 != 1) {
          break label205;
        }
        a(0, getString(2131430007));
        if (QLog.isColorLevel()) {
          QLog.i("QRDisplayActivity", 2, "shareQRCode success");
        }
        if ((this.jdField_g_of_type_Int & 0x1) != 0) {
          ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
        }
      }
      break;
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      localObject1 = "qr_qzone";
      break;
      localObject1 = "qr_qq";
      break;
      localObject2 = "1";
      break label57;
      label205:
      if (paramInt1 == 2)
      {
        localObject1 = new Intent(this, SplashActivity.class);
        ((Intent)localObject1).putExtras(paramIntent);
        localObject2 = ForwardUtils.a((Intent)localObject1);
        ForwardUtils.a(this.app, this, (SessionInfo)localObject2, (Intent)localObject1);
      }
      else if (paramInt1 == 21)
      {
        localObject1 = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        startActivity((Intent)localObject1);
        finish();
      }
      else if (paramInt1 != 3) {}
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    super.setContentView(2130969705);
    paramBundle = super.getIntent();
    this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("from");
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("reportFlag", 0);
    super.setTitle(paramBundle.getStringExtra("title"));
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("nick");
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)paramBundle.getParcelableExtra("face"));
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("type", 1);
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("adminLevel", 2);
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("GroupFlagExt", 0L);
    this.jdField_b_of_type_Int = ((int)paramBundle.getLongExtra("AuthGroupType", 0L));
    int i;
    Object localObject1;
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_b_of_type_JavaLangString = getString(2131429992);
      paramBundle = findViewById(2131367546);
      paramBundle.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131367547);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367548));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367549));
      this.jdField_g_of_type_AndroidViewView = findViewById(2131367550);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367551));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367552));
      this.jdField_h_of_type_AndroidViewView = findViewById(2131367553);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367554));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367555));
      i = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131558694) * 3) / 8;
      localObject1 = (ViewGroup.MarginLayoutParams)paramBundle.getLayoutParams();
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i;
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131367541);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367544));
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131367540);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131367563);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131367545);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131367556);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131429921));
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.jdField_c_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != 5) {
        break label1396;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      if (this.app != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
        this.app.registObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
      }
      this.leftView.setContentDescription(getString(2131430205));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131430206));
      setResult(-1, getIntent());
      paramBundle = (FriendsManager)this.app.getManager(50);
      localObject2 = (DiscussionManager)this.app.getManager(52);
      localObject1 = ((DiscussionManager)localObject2).a(this.jdField_c_of_type_JavaLangString);
      if (localObject1 != null) {
        break;
      }
      g();
      i = 1;
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 60000L);
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_g_of_type_Int & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 1, 0).sendToTarget();
      return true;
      if (this.jdField_c_of_type_Int == 2)
      {
        findViewById(2131367542).setVisibility(0);
        findViewById(2131367560).setVisibility(0);
        findViewById(2131367561).setOnClickListener(this);
        findViewById(2131367562).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131429993);
        paramBundle = getString(2131430613);
        this.leftView.setText(paramBundle);
        this.leftView.setContentDescription(paramBundle);
      }
      else if (this.jdField_c_of_type_Int == 5)
      {
        findViewById(2131367542).setVisibility(0);
        findViewById(2131367560).setVisibility(0);
        findViewById(2131367561).setOnClickListener(this);
        findViewById(2131367562).setOnClickListener(this);
        this.jdField_b_of_type_JavaLangString = getString(2131429997);
      }
    }
    Object localObject2 = ((DiscussionManager)localObject2).a(this.jdField_c_of_type_JavaLangString);
    if (localObject2 != null)
    {
      this.jdField_f_of_type_Int = ((List)localObject2).size();
      if (!((DiscussionInfo)localObject1).hasRenamed())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QRDisplayActivity", 4, "title not defined, join by nicks");
        }
        if (localObject2 != null) {
          localObject1 = ((List)localObject2).iterator();
        }
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1226;
        }
        localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
        {
          this.jdField_b_of_type_JavaUtilList.add(ContactUtils.j(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
          continue;
          this.jdField_f_of_type_Int = 0;
          break;
        }
        Friends localFriends = paramBundle.c(((DiscussionMemberInfo)localObject2).memberUin);
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
          this.jdField_b_of_type_JavaUtilList.add(localFriends.name);
        } else if (a(((DiscussionMemberInfo)localObject2).memberUin) != null) {
          this.jdField_b_of_type_JavaUtilList.add(a(((DiscussionMemberInfo)localObject2).memberUin));
        } else {
          this.jdField_a_of_type_JavaUtilList.add(((DiscussionMemberInfo)localObject2).memberUin);
        }
      }
      label1226:
      if ((this.jdField_b_of_type_JavaUtilList.size() >= 5) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label1441;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "fetch nicks from server");
      }
      paramBundle = new String[this.jdField_a_of_type_JavaUtilList.size()];
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramBundle[i] = ((String)((Iterator)localObject1).next());
        i += 1;
      }
      ((DiscussionHandler)this.app.a(6)).a(new String[] { "20002" }, paramBundle);
    }
    label1441:
    for (int j = 0;; j = 1)
    {
      i = j;
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilList, new oud(this));
      this.jdField_a_of_type_JavaLangString = a(this.jdField_b_of_type_JavaUtilList);
      i = j;
      break;
      label1396:
      if (this.jdField_c_of_type_Int == 2) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131429995, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      }
      i = 1;
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a();
    if (this.jdField_c_of_type_Int == 5)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.b(this);
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 2, 0).sendToTarget();
  }
  
  public void e()
  {
    ThreadManager.executeOnFileThread(new ota(this));
    String str = null;
    if (this.jdField_c_of_type_Int == 1) {
      str = "shareConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_c_of_type_Int == 2) {
        str = "shareGroupQRcard";
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "get code template");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager;
    boolean bool2 = this.jdField_c_of_type_Boolean;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool2, bool1, this.jdField_b_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (this.jdField_c_of_type_Int == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
      return;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage(2131429914);
      localQQCustomDialog.setPositiveButton(2131433016, new ote(this));
      localQQCustomDialog.show();
      return;
    }
    finish();
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      otg localotg = new otg(this);
      oth localoth = new oth(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(getString(2131433100));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(localoth);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(new oti(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(localotg);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a()))
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  @TargetApi(14)
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1004: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.app.D();
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "talkback value " + AppSetting.jdField_b_of_type_Boolean);
        }
        if ((AppSetting.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Int == 1))
        {
          bool1 = ChirpWrapper.a();
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "isSoLoaded " + bool1);
          }
          if (!bool1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler == null) {
              this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler = ((ChirpSoHandler)((EarlyDownloadManager)this.app.getManager(76)).a("qq.android.system.chirp"));
            }
            this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(this);
            this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(true);
            bool1 = false;
          }
        }
      }
      break;
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new otq(this, bool1));
      break;
      boolean bool2 = true;
      bool1 = bool2;
      if (!this.jdField_g_of_type_Boolean)
      {
        BaseApplicationImpl.sUiHandler.post(new otp(this));
        this.jdField_g_of_type_Boolean = true;
        bool1 = bool2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_f_of_type_Boolean);
        }
        if (this.jdField_f_of_type_Boolean) {
          break;
        }
        String str = getFilesDir() + this.app.getCurrentAccountUin() + "_vqr.dat";
        File localFile = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "voiceFile.exists = " + localFile.exists());
        }
        if (!localFile.exists()) {
          if (a(str)) {
            break label519;
          }
        }
        label519:
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_f_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_f_of_type_Boolean);
          }
          if (this.jdField_f_of_type_Boolean) {
            break label524;
          }
          if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null)
          {
            this.jdField_a_of_type_ComTencentChirpPcmPlayer = new PcmPlayer(this, this, 44100, str);
            this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
            AudioUtil.a(this, true);
          }
          if (paramMessage.arg1 != 5) {
            break;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
          break;
        }
        label524:
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.b();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer = null;
        if (paramMessage.arg1 == 5) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        AudioUtil.a(this, false);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
        break;
        QQAppInterface.f("声波播放失败，请重新打开二维码页面重试");
        break;
        bool1 = false;
      }
    }
  }
  
  public void i()
  {
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.jdField_f_of_type_JavaLangString))
    {
      if (isInMultiWindow()) {
        QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      return;
    }
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("from", "QRDisplayActivity");
    startActivityForResult(localIntent, 3);
  }
  
  public void j() {}
  
  public void k()
  {
    if (isResume()) {
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 4, 0).sendToTarget();
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_c_of_type_Long) <= 1000L) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Long = l;
      if (paramView.getId() == 2131367545)
      {
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        if (this.jdField_c_of_type_Int == 2)
        {
          f();
          if ((this.jdField_g_of_type_Int & 0x1) == 0) {
            continue;
          }
          ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_c_of_type_Int == 5)
        {
          f();
          ReportController.b(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          return;
        }
        c();
        return;
      }
      if (paramView.getId() == 2131367559) {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet = new LinkShareActionSheetBuilder(this).a(this);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        label184:
        ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        return;
        if (paramView.getId() == 2131367561)
        {
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          d();
          if ((this.jdField_g_of_type_Int & 0x1) != 0) {
            ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int == 5) {
            ReportController.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.jdField_c_of_type_Int != 2) {
            continue;
          }
          new ReportTask(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.jdField_c_of_type_JavaLangString, "", String.valueOf(this.jdField_a_of_type_Int) }).a();
          return;
        }
        if (paramView.getId() == 2131367562)
        {
          h();
          if (this.jdField_c_of_type_Int != 5) {
            continue;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
          return;
        }
        if ((paramView.getId() == 2131367554) || (paramView.getId() == 2131367555))
        {
          i();
          return;
        }
        if (paramView.getId() == 2131367547)
        {
          b(7);
          return;
        }
        if (paramView.getId() == 2131367550)
        {
          b(8);
          ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "fukuanTCclick", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() != 2131367553) {
          continue;
        }
        i();
        return;
      }
      catch (Exception paramView)
      {
        break label184;
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      int i = -1;
      if (!WXShareHelper.a().a()) {
        i = 2131435319;
      }
      for (;;)
      {
        if (i == -1) {
          break label93;
        }
        QRUtils.a(1, i);
        break;
        if (!WXShareHelper.a().b()) {
          i = 2131435320;
        }
      }
      label93:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new otf(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      paramView = this.app;
      label136:
      String str1;
      Bitmap localBitmap;
      String str2;
      if (paramInt == 2)
      {
        paramAdapterView = "1";
        ReportController.b(paramView, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, paramAdapterView, "", "", "");
        this.jdField_g_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        paramAdapterView = WXShareHelper.a();
        paramView = this.jdField_g_of_type_JavaLangString;
        str1 = String.format(getString(2131435931), new Object[] { this.jdField_a_of_type_JavaLangString });
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        str2 = this.jdField_d_of_type_JavaLangString;
        if (paramInt != 2) {
          break label246;
        }
      }
      label246:
      for (paramInt = 0;; paramInt = 1)
      {
        paramAdapterView.b(paramView, str1, localBitmap, "", str2, paramInt);
        break;
        paramAdapterView = "0";
        break label136;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435070);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      continue;
      DiscussionInfoCardActivity.a(this.app, this, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */