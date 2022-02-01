package com.tencent.mobileqq.activity;

import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniGetRsp;
import QC.UniSetReq;
import QC.UniSetRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.PobingTemplateAdapter;
import com.tencent.mobileqq.activity.aio.item.PobingTemplateAdapter.Callback;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemView;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.QConfigLocalLoader;
import com.tencent.mobileqq.config.business.QConfLogBean;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.showexternal.api.ITroopShowExternalHandler;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.BitmapsCache;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeCallBack;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QzonePluginProxyActivity;
import friendlist.EAddFriendSourceID;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, PobingTemplateAdapter.Callback, HttpWebCgiAsyncTask.Callback
{
  private static int aO = (int)(System.currentTimeMillis() & 0xFFFFFFFF);
  public static final boolean n = AppSetting.e;
  int A;
  int B = 0;
  protected boolean C = false;
  Handler D = new AddFriendVerifyActivity.22(this);
  protected QQCustomDialog E = null;
  private ArrayList<EditText> F = new ArrayList();
  private LinearLayout G;
  private TextView H;
  private TextView I;
  private TextView J;
  private EditText K;
  private TextView L;
  private LinearLayout M;
  private FormItemRelativeLayout N = null;
  private FormItemRelativeLayout O = null;
  private TextView P;
  private View Q;
  private Switch R;
  private View S;
  private Switch T;
  private boolean U = true;
  private int V;
  private String W = "";
  private int X;
  private int Y;
  private FriendListHandler Z;
  QQProgressDialog a;
  private ProfileCardObserver aA = new AddFriendVerifyActivity.16(this);
  private final FriendObserver aB = new AddFriendVerifyActivity.17(this);
  private QidianBusinessObserver aC = new AddFriendVerifyActivity.18(this);
  private TroopObserver aD = new AddFriendVerifyActivity.19(this);
  private TroopMngObserver aE = new AddFriendVerifyActivity.20(this);
  private TroopShowExternalObserver aF = new AddFriendVerifyActivity.21(this);
  private View.OnClickListener aG = new AddFriendVerifyActivity.23(this);
  private String aH = null;
  private long aI = 0L;
  private int aJ = 0;
  private String aK = null;
  private int aL = 0;
  private boolean aM = false;
  private String aN = null;
  private PobingDecoder.DecodeCallBack aP = new AddFriendVerifyActivity.29(this);
  private ViewTreeObserver.OnGlobalLayoutListener aQ = new AddFriendVerifyActivity.34(this);
  private String aa;
  private int ab;
  private TextView ac;
  private TextView ad;
  private RelativeLayout ae;
  private LinearLayout af;
  private TextView ag;
  private ClearableEditText ah;
  private TextView ai;
  private URLImageView aj;
  private ImageView ak;
  private ImageView al;
  private ImageView am;
  private RecyclerView an;
  private PobingTemplateAdapter ao;
  private String ap;
  private String aq;
  private int ar = 2000;
  private ArrayList<PhoneContact> as = new ArrayList();
  private int at = -1;
  private Bundle au;
  private int av = 1000;
  private long aw;
  private boolean ax;
  private Uri ay;
  private TextWatcher az = new AddFriendVerifyActivity.15(this);
  EditText b;
  LinearLayout c;
  LinearLayout d;
  BounceScrollView e;
  EditText f = null;
  TextView g = null;
  TextView h;
  TextView i;
  Dialog j;
  protected FormSwitchItem k;
  TextView l = null;
  ImageView m = null;
  protected String o;
  protected String p;
  protected boolean q = false;
  protected boolean r = false;
  protected InputMethodManager s = null;
  AddFriendVerifyActivity.MaxBytesTextWatcher t;
  AddFriendVerifyActivity.MaxBytesTextWatcher u;
  KplRoleInfo.WZRYUIinfo v;
  String w = "";
  String x;
  TextView y;
  TextView z;
  
  private String a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_add_troop_verfity_");
      localStringBuilder.append(this.app.getAccount());
      return localSharedPreferences.getString(localStringBuilder.toString(), null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_add_friend_verify_");
    localStringBuilder.append(this.app.getAccount());
    return localSharedPreferences.getString(localStringBuilder.toString(), null);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.X == 3090) {
      try
      {
        ForwardSdkShareOption.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("feedBackToGameSDK error = ");
        localStringBuilder.append(paramString);
        QLog.e("AddFriendVerifyActivity", 1, localStringBuilder.toString());
      }
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.app != null))
    {
      if (this.m == null) {
        return;
      }
      Bitmap localBitmap = ImageUtil.a(paramURLDrawable);
      if (paramURLDrawable.getStatus() == 1)
      {
        paramURLDrawable = this.app;
        paramURLDrawable = QQAppInterface.getCircleFaceBitmap(localBitmap, 50, 50);
        this.m.setImageDrawable(new BitmapDrawable(paramURLDrawable));
        return;
      }
      paramURLDrawable.setURLDrawableListener(new AddFriendVerifyActivity.12(this));
    }
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: new 440	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 442	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 445	java/io/File:getPath	()Ljava/lang/String;
    //   15: sipush 640
    //   18: invokestatic 448	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   21: astore_2
    //   22: aload 5
    //   24: invokevirtual 445	java/io/File:getPath	()Ljava/lang/String;
    //   27: aload_2
    //   28: invokestatic 454	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore 4
    //   33: aload 4
    //   35: astore_2
    //   36: aload 4
    //   38: astore_3
    //   39: ldc_w 456
    //   42: invokestatic 462	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   45: checkcast 456	com/tencent/mobileqq/troop/utils/api/ITroopUtilsApi
    //   48: aload_0
    //   49: invokeinterface 466 2 0
    //   54: istore_1
    //   55: aload 4
    //   57: astore_2
    //   58: iload_1
    //   59: ifeq +35 -> 94
    //   62: aload 4
    //   64: astore_2
    //   65: aload 4
    //   67: astore_3
    //   68: aload 4
    //   70: iload_1
    //   71: i2f
    //   72: invokestatic 469	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   75: astore_0
    //   76: aload_0
    //   77: astore_2
    //   78: aload_0
    //   79: ifnull +15 -> 94
    //   82: aload_0
    //   83: astore_2
    //   84: aload_0
    //   85: astore_3
    //   86: aload_0
    //   87: aload 5
    //   89: invokestatic 472	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   92: aload_0
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 477	android/graphics/Bitmap:recycle	()V
    //   102: return
    //   103: astore_0
    //   104: goto +19 -> 123
    //   107: astore_0
    //   108: aload_3
    //   109: astore_2
    //   110: aload_0
    //   111: invokevirtual 480	java/io/IOException:printStackTrace	()V
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 477	android/graphics/Bitmap:recycle	()V
    //   122: return
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 477	android/graphics/Bitmap:recycle	()V
    //   131: aload_0
    //   132: athrow
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 481	java/lang/OutOfMemoryError:printStackTrace	()V
    //   138: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   54	17	1	i1	int
    //   21	107	2	localObject1	Object
    //   38	81	3	localObject2	Object
    //   31	38	4	localBitmap	Bitmap
    //   8	80	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   39	55	103	finally
    //   68	76	103	finally
    //   86	92	103	finally
    //   110	114	103	finally
    //   39	55	107	java/io/IOException
    //   68	76	107	java/io/IOException
    //   86	92	107	java/io/IOException
    //   22	33	133	java/lang/OutOfMemoryError
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.a.c(2131916272);
    this.a.show();
    ITroopMngHandler localITroopMngHandler = (ITroopMngHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
    long l1 = Long.parseLong(this.app.getCurrentAccountUin());
    long l2 = Long.parseLong(paramString1);
    localITroopMngHandler.a(paramString1, paramString2, paramInt1, this.ap, this.aq, a(this.aJ, this.aH, paramString2, l1, l2, paramInt2), this.aK);
    if (!TextUtils.isEmpty(paramString2))
    {
      if (!TextUtils.isEmpty(this.aH)) {
        paramString2 = "2";
      } else {
        paramString2 = "0";
      }
    }
    else if (!TextUtils.isEmpty(this.aH)) {
      paramString2 = "1";
    } else {
      paramString2 = "3";
    }
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, paramString1, paramString2, "", "");
    TroopReportor.a(this.o, 1, 0, paramInt1);
    if (this.r) {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
    } else {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
    if ((this.q == true) && (!this.r)) {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
    }
    if ((!this.q) && (this.r == true)) {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
    }
    this.av = 1001;
    ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).g(this.aa);
  }
  
  private void b()
  {
    if (this.X == 3094)
    {
      int i1 = getIntent().getIntExtra("sub_source_id", 8);
      HashMap localHashMap = new HashMap();
      localHashMap.put("frompage", String.valueOf(i1));
      localHashMap.put("to_uid", this.aa);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#send_request_all", true, -1L, -1L, localHashMap, true, true);
    }
  }
  
  private void b(int paramInt)
  {
    String str2 = HardCodeUtil.a(2131898139);
    String str1;
    if (paramInt != 4002)
    {
      if (paramInt != 5002)
      {
        if (paramInt != 12002)
        {
          if (paramInt != 16002)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("showPayDialog, UNKOWN errorCode: ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
            return;
          }
          QQToast.makeText(this, 1, HardCodeUtil.a(2131898125), 1).show();
          return;
        }
        localObject = HardCodeUtil.a(2131898107);
        paramInt = 3;
        str1 = "SVHHZLH";
      }
      else
      {
        localObject = HardCodeUtil.a(2131898108);
        str1 = "CJCLUBT";
        paramInt = 2;
      }
    }
    else
    {
      localObject = HardCodeUtil.a(2131898102);
      str1 = "LTMCLUB";
      paramInt = 1;
    }
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4FA", paramInt, 0, "", "", "", "");
    String str3 = String.format(HardCodeUtil.a(2131898123), new Object[] { localObject, localObject });
    Object localObject = String.format(HardCodeUtil.a(2131898127), new Object[] { localObject });
    DialogUtil.a(this, 230, str2, str3, HardCodeUtil.a(2131898138), (String)localObject, new AddFriendVerifyActivity.26(this, str1, paramInt), new AddFriendVerifyActivity.27(this)).show();
  }
  
  private void b(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    URLDrawable localURLDrawable = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", new ApngOptions(), paramBitmapsCache.a(2131449382));
    this.am.setVisibility(0);
    this.am.setBackgroundDrawable(localURLDrawable);
    localURLDrawable = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", new ApngOptions(), paramBitmapsCache.a(2131449377));
    this.K.setBackgroundDrawable(localURLDrawable);
    this.L.setTextColor(paramBitmapsCache.b);
    this.K.setTextColor(paramBitmapsCache.b);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.getSystemNetwork(this) == 0)
    {
      QQToast.makeText(this, 2131893961, 0).show(getTitleBarHeight());
      h();
      return;
    }
    if ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER) != null)
    {
      if (this.o == null) {
        return;
      }
      ((ITroopShowExternalHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_SHOW_EXTERNAL_HANDLER)).a(this.p, this.o, paramBoolean, true);
    }
  }
  
  private String c()
  {
    Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.app.getCurrentUin());
    String str = "";
    int i1;
    Object localObject1;
    int i2;
    Object localObject3;
    Object localObject5;
    Object localObject4;
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendVerifyActivity", 2, "initParams: mFriendCard != null");
      }
      i1 = ((Card)localObject2).shGender;
      if (((Card)localObject2).shGender == 0) {
        localObject1 = getString(2131891484);
      } else if (((Card)localObject2).shGender == 1) {
        localObject1 = getString(2131889246);
      } else {
        localObject1 = "";
      }
      i2 = ((Card)localObject2).age;
      localObject3 = ((Card)localObject2).strProvince;
      localObject5 = ((Card)localObject2).strCity;
      i2 = ((Card)localObject2).constellation;
      localObject2 = NearbyProfileUtil.e(((Card)localObject2).constellation);
      localObject4 = localObject1;
      localObject1 = localObject5;
    }
    else
    {
      i2 = 0;
      localObject5 = "";
      localObject2 = localObject5;
      localObject3 = localObject2;
      localObject1 = localObject3;
      i1 = -1;
      localObject4 = localObject2;
      localObject2 = localObject5;
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = str;
    }
    if ((bool) && (i2 == 0) && (i1 == -1))
    {
      localObject1 = HardCodeUtil.a(2131898106);
    }
    else if ((bool) && (i2 == 0))
    {
      localObject1 = HardCodeUtil.a(2131898124);
    }
    else if ((bool) && (i1 == -1))
    {
      localObject1 = HardCodeUtil.a(2131898121);
    }
    else if ((i2 == 0) && (i1 == -1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898112));
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else if (i2 == 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898133));
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else if (i1 == -1)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131898114));
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131898120));
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(HardCodeUtil.a(2131898109));
      localObject1 = ((StringBuilder)localObject4).toString();
    }
    else if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append((String)localObject4);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131898110));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131898126));
      ((StringBuilder)localObject5).append((String)localObject3);
      ((StringBuilder)localObject5).append((String)localObject1);
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131898105));
      ((StringBuilder)localObject5).append((String)localObject2);
      ((StringBuilder)localObject5).append((String)localObject4);
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131898129));
      localObject1 = ((StringBuilder)localObject5).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("~");
    return ((StringBuilder)localObject2).toString();
  }
  
  private boolean d()
  {
    int i1 = getIntent().getExtras().getInt("source_id", 3999);
    return (i1 == 3003) || (i1 == 3006) || (i1 == 3007) || (i1 == 3009) || (i1 == 3013);
  }
  
  private void e(String paramString)
  {
    Dialog localDialog = this.j;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.j.getWindow() != null)) {}
    try
    {
      this.j.dismiss();
      label33:
      this.j = DialogUtil.a(this, paramString, 0, 2131891969, null, new AddFriendVerifyActivity.31(this, paramString));
      try
      {
        this.j.show();
        return;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label33;
    }
  }
  
  private boolean e()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_friend_verify_msg_modify_flag");
    localStringBuilder.append(this.app.getAccount());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private void f()
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("last_verify_msg", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_friend_verify_msg_modify_flag");
    localStringBuilder.append(this.app.getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), true);
  }
  
  private void f(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B991", "0X800B991", 0, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showSecurityTipsDialog errorStr = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.j;
    if ((localObject != null) && (((Dialog)localObject).isShowing()) && (this.j.getWindow() != null)) {}
    try
    {
      this.j.dismiss();
    }
    catch (Throwable localThrowable)
    {
      label102:
      String str;
      break label102;
    }
    str = getString(2131916152);
    localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = getString(2131916149);
    }
    this.j = DialogUtil.a(this, 230, str, (String)localObject, 2131916150, 2131916151, new AddFriendVerifyActivity.32(this), new AddFriendVerifyActivity.33(this));
    try
    {
      this.j.show();
      return;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "showSecurityTipsDialog, tips dialog show failed", paramString);
      }
      return;
    }
  }
  
  private void g()
  {
    INewFriendVerificationService localINewFriendVerificationService = (INewFriendVerificationService)this.app.getRuntimeService(INewFriendVerificationService.class);
    if (localINewFriendVerificationService != null)
    {
      int i1 = getIntent().getIntExtra("friend_setting", 0);
      int i2 = getIntent().getIntExtra("source_id", 3999);
      String str = getIntent().getExtras().getString("extra");
      int i3 = getIntent().getIntExtra("sub_source_id", 0);
      localINewFriendVerificationService.reportAddFriendBlocked(this.aa, i1, i2, i3, str);
    }
  }
  
  private void g(String paramString)
  {
    runOnUiThread(new AddFriendVerifyActivity.35(this));
  }
  
  private void h()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      if (((FormSwitchItem)localObject).getVisibility() == 8) {
        return;
      }
      Switch localSwitch = this.k.getSwitch();
      localSwitch.setTag(Integer.valueOf(1));
      this.r = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).q(this.o);
      localSwitch.setChecked(this.r);
      if (this.r == true) {
        localObject = getString(2131893955);
      } else {
        localObject = getString(2131893959);
      }
      localSwitch.setContentDescription((CharSequence)localObject);
    }
  }
  
  private void i()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.addButton(2131916259, 5);
    localActionSheet.addButton(2131916249, 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new AddFriendVerifyActivity.24(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private boolean j()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.aw;
    this.aw = l1;
    boolean bool;
    if ((l2 > 1000L) && (this.av != 1001) && (!this.ax)) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("AddFriendVerifyActivity", 1, String.format("checkSendJoinTroop interval=%s mJoinTroopStatus=%s mHasReqJoinTroopWebInfo=%s result=%s", new Object[] { Long.valueOf(l2), Integer.valueOf(this.av), Boolean.valueOf(this.ax), Boolean.valueOf(bool) }));
    return bool;
  }
  
  void a()
  {
    Object localObject1;
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject1 = new Intent(this, SplashActivity.class);
      ((Intent)localObject1).putExtra("fragment_id", 1);
      ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.a);
      ((Intent)localObject1).setFlags(67108864);
      startActivity((Intent)localObject1);
      finish();
      return;
    }
    Object localObject2 = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("goBack | retAddr = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (localObject2 != null) {
      try
      {
        localObject1 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
        localObject2 = Class.forName((String)localObject2);
        Intent localIntent2 = new Intent();
        localIntent2.setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject2).getName()));
        if ((!localObject2.equals(localObject1)) && (!localObject2.equals(QidianProfileCardActivity.class)))
        {
          if (localObject2.equals(QQNearbyManager.b()))
          {
            localIntent2.putExtra("AllInOne", new AllInOne(this.aa, 41));
            localIntent2.putExtra("param_mode", 3);
          }
        }
        else {
          ProfileActivity.a(this, this.aa, localIntent2);
        }
        localIntent2.setFlags(67108864);
        localIntent2.putExtra("key_back_from_add_friend", true);
        startActivity(localIntent2);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "goBack | exception = ", localClassNotFoundException);
        }
        localClassNotFoundException.printStackTrace();
        setResult(-1);
        finish();
        return;
      }
    }
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.aa);
      setResult(-1, localIntent1);
    }
    else
    {
      a(0, "");
      setResult(-1);
    }
    finish();
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == 2000)
    {
      this.L.setTextColor(getResources().getColor(2131168118));
      this.am.setVisibility(8);
      this.K.setBackgroundResource(2130852507);
      int i1 = AIOUtils.b(10.0F, getResources());
      this.K.setPadding(i1, i1, i1, i1);
      this.K.setTextColor(getResources().getColor(2131167993));
    }
    else
    {
      localObject = PobingDecoder.a(PobingManager.b(paramInt));
      if (localObject == null) {
        new PobingDecoder(paramInt, TroopPobingItemView.b, this.aP);
      } else {
        a((PobingDecoder.BitmapsCache)localObject);
      }
      if (SimpleUIUtil.e()) {
        DialogUtil.a(this, 0, HardCodeUtil.a(2131898134), HardCodeUtil.a(2131898128), null, HardCodeUtil.a(2131899883), new AddFriendVerifyActivity.28(this), null).show();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" server: ");
      ((StringBuilder)localObject).append(this.ar);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.ar != paramInt)
    {
      localObject = (VipInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
      if (localObject != null)
      {
        UniSetReq localUniSetReq = new UniSetReq();
        localUniSetReq.stUniBusinessItem = new UniBusinessItem(40, paramInt, "");
        ((VipInfoHandler)localObject).a(localUniSetReq, new AddFriendVerifyActivity.PobingTemplateObserver(this, paramInt), false);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "set fail, VipInfoHandler is null");
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    boolean bool = getIntent().getBooleanExtra("select_multi_mode", false);
    String str = getIntent().getStringExtra("troop_uin");
    ThreadManager.post(new AddFriendVerifyActivity.36(this, paramInt1, getIntent().getIntExtra("sub_source_id", 0), bool, str, paramInt2), 5, null, true);
  }
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 2)
    {
      if (paramInt1 != 3) {
        return;
      }
      if ((paramBoolean) && ((paramObject instanceof UniGetRsp)))
      {
        paramObject = ((UniGetRsp)paramObject).uniBusinessItemList.iterator();
        while (paramObject.hasNext())
        {
          localObject = (UniBusinessItem)paramObject.next();
          if (((UniBusinessItem)localObject).appid == 40)
          {
            this.ar = ((UniBusinessItem)localObject).itemid;
            this.ao.b(((UniBusinessItem)localObject).itemid);
            paramObject = new StringBuilder();
            paramObject.append("TYPE_UNI_GET_RSP: ");
            paramObject.append(this.ar);
            QLog.e("AddFriendVerifyActivity", 1, paramObject.toString());
            return;
          }
        }
        paramObject = new StringBuilder();
        paramObject.append("TYPE_UNI_GET_RSP nothing: ");
        paramObject.append(this.ar);
        QLog.e("AddFriendVerifyActivity", 1, paramObject.toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TYPE_UNI_GET_RSP: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" data=");
      ((StringBuilder)localObject).append(paramObject);
      QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)))
    {
      paramObject = (UniSetRsp)paramObject;
      if (paramObject.ret == 0)
      {
        this.ar = paramInt2;
        paramObject = new StringBuilder();
        paramObject.append("TYPE_UNI_SET_RSP success: ");
        paramObject.append(this.ar);
        QLog.e("AddFriendVerifyActivity", 1, paramObject.toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TYPE_UNI_SET_RSP: ");
      ((StringBuilder)localObject).append(paramObject.ret);
      ((StringBuilder)localObject).append(" msg:");
      ((StringBuilder)localObject).append(paramObject.errmsg);
      QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
      b(paramObject.ret);
      this.ao.b(this.ar);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TYPE_UNI_SET_RSP: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" data=");
    ((StringBuilder)localObject).append(paramObject);
    QLog.e("AddFriendVerifyActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    if (paramBitmapsCache == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new AddFriendVerifyActivity.30(this, paramBitmapsCache));
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (this.v != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "saveVerifyMsg return from wzry");
      }
      return;
    }
    Object localObject = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_add_troop_verfity_");
      localStringBuilder.append(this.app.getAccount());
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_add_friend_verify_");
    localStringBuilder.append(this.app.getAccount());
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
  }
  
  void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this.app.getApp(), 1, getString(2131892157), 0).show(getTitleBarHeight());
      return;
    }
    if (isFinishing()) {
      return;
    }
    if (this.a == null)
    {
      this.a = new QQProgressDialog(this, getTitleBarHeight());
      this.a.setOnDismissListener(new AddFriendVerifyActivity.13(this));
    }
    this.a.c(2131916272);
    this.a.setCancelable(true);
    this.a.setCanceledOnTouchOutside(false);
    try
    {
      this.a.show();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, localException.toString());
      }
    }
    Intent localIntent = getIntent();
    int i2 = localIntent.getIntExtra("sub_source_id", 0);
    int i1 = localIntent.getIntExtra("friend_setting", 0);
    if (i1 == 3) {
      i1 = 100;
    }
    boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
    String str = localIntent.getStringExtra("src_name");
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriendWithMyCard(this.aa, localIntent.getStringExtra("extra"), i1, (byte)this.V, paramString1, this.X, i2, true, paramArrayOfByte, bool, this.f.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0), paramString2, localIntent.getBundleExtra("flc_extra_param"), false);
    if (!((IAddFriendApi)QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(i1, this.X, bool)) {
      ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.aa, true);
    }
    if (!this.f.getText().toString().equals(this.W)) {
      ReportController.b(this.app, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
    }
    if (localIntent.getIntExtra("sort_id", 0) == 3090) {
      ReportController.b(this.app, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
    }
    if ((this.X == 3050) && (this.Y == 3))
    {
      paramString1 = new HashMap();
      if (this.T != null)
      {
        bool = this.U;
        if (bool)
        {
          QCircleFollowView.a(this.aa, bool);
          paramString1.put("ext3", "1");
          break label497;
        }
      }
      paramString1.put("ext3", "2");
      label497:
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.aa).setActionType(79).setSubActionType(2).setThrActionType(0).setExtras(paramString1));
      if ((localIntent.getBooleanExtra("key_qcircle_stick", false)) && (TextUtils.isEmpty(paramString2))) {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.aa).setActionType(93).setSubActionType(2).setThrActionType(2));
      }
    }
    if (this.X == 3094)
    {
      if (i2 == 1)
      {
        ReportController.a(this.app, "dc00898", "", this.aa, "0X80092E3", "0X80092E3", 0, 0, "", ExtendFriendReport.d(), ExtendFriendReport.a(this.app), ExtendFriendReport.f());
        return;
      }
      if (i2 == 2)
      {
        ReportController.a(this.app, "dc00898", "", this.aa, "0X80092CC", "0X80092CC", 0, 0, "", "", ExtendFriendReport.a(this.app), "");
        return;
      }
      if (i2 == 8)
      {
        ReportController.a(this.app, "dc00898", "", this.aa, "0X800A69D", "0X800A69D", this.at, 0, "", "", "", "");
        return;
      }
      if (i2 == 9) {
        ReportController.a(this.app, "dc00898", "", this.aa, "0X800A69D", "0X800A69D", this.at, 0, "", "", "", "");
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramInt != 1003) {
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      Object localObject5;
      Object localObject3;
      Object localObject4;
      int i1;
      Object localObject2;
      Object localObject6;
      try
      {
        paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
        localObject5 = (JSONObject)paramJSONObject.get("result");
        if ((paramInt == 0) && (localObject5 != null))
        {
          boolean bool = QLog.isColorLevel();
          if (bool)
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("checkApiState onResult. retCode = ");
            paramJSONObject.append(paramInt);
            paramJSONObject.append("\n");
            QLog.i("AddFriendVerifyActivity", 2, paramJSONObject.toString());
          }
          localObject1 = (JSONObject)((JSONObject)localObject5).get("basics");
          paramJSONObject = "msg";
          localObject3 = "api";
          paramBundle = paramJSONObject;
          if (localObject1 != null)
          {
            localObject1 = (JSONArray)((JSONObject)localObject1).get("datas");
            paramBundle = paramJSONObject;
            if (localObject1 != null)
            {
              paramInt = 0;
              paramBundle = paramJSONObject;
              if (paramInt < ((JSONArray)localObject1).length())
              {
                localObject4 = (JSONObject)((JSONArray)localObject1).get(paramInt);
                paramBundle = (String)((JSONObject)localObject4).get("name");
                i1 = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject2 = (String)((JSONObject)localObject4).get("api");
                localObject4 = (String)((JSONObject)localObject4).get(paramJSONObject);
                if (!QLog.isColorLevel()) {
                  break label953;
                }
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("checkApiState onResult, basics name = ");
                ((StringBuilder)localObject6).append(paramBundle);
                ((StringBuilder)localObject6).append(" state = ");
                ((StringBuilder)localObject6).append(i1);
                ((StringBuilder)localObject6).append(" api = ");
                ((StringBuilder)localObject6).append((String)localObject2);
                ((StringBuilder)localObject6).append(" msg = ");
                ((StringBuilder)localObject6).append((String)localObject4);
                ((StringBuilder)localObject6).append("\n");
                QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject6).toString());
                break label953;
              }
            }
          }
          localObject1 = paramBundle;
          paramJSONObject = (JSONObject)((JSONObject)localObject5).get("friendlink");
          localObject2 = localObject3;
          paramBundle = (Bundle)localObject1;
          if (paramJSONObject != null)
          {
            localObject4 = (JSONArray)paramJSONObject.get("datas");
            localObject2 = localObject3;
            paramBundle = (Bundle)localObject1;
            if (localObject4 != null)
            {
              paramInt = 0;
              paramJSONObject = (JSONObject)localObject3;
              localObject3 = localObject4;
              localObject2 = paramJSONObject;
              paramBundle = (Bundle)localObject1;
              if (paramInt < ((JSONArray)localObject3).length())
              {
                localObject4 = (JSONObject)((JSONArray)localObject3).get(paramInt);
                paramBundle = (String)((JSONObject)localObject4).get("name");
                i1 = ((Integer)((JSONObject)localObject4).get("state")).intValue();
                localObject2 = (String)((JSONObject)localObject4).get(paramJSONObject);
                localObject4 = (String)((JSONObject)localObject4).get((String)localObject1);
                bool = "add_friend".equals(localObject2);
                if ((!bool) || (i1 == 1)) {
                  break label964;
                }
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject) {}
      try
      {
        localObject6 = getActivity().getResources().getString(2131917518);
        g((String)localObject6);
        if (!QLog.isColorLevel()) {
          break label967;
        }
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("checkApiState onResult, friendlink name = ");
        ((StringBuilder)localObject6).append(paramBundle);
        ((StringBuilder)localObject6).append(" state = ");
        ((StringBuilder)localObject6).append(i1);
        ((StringBuilder)localObject6).append(" api = ");
        ((StringBuilder)localObject6).append((String)localObject2);
        ((StringBuilder)localObject6).append(" msg= ");
        ((StringBuilder)localObject6).append((String)localObject4);
        ((StringBuilder)localObject6).append("\n");
        QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject6).toString());
      }
      catch (Exception paramJSONObject)
      {
        break label910;
      }
      paramJSONObject = (JSONObject)localObject2;
      paramInt = ((Integer)((JSONObject)localObject5).get("appid")).intValue();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkApiState onResult, appid =");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("\n");
        QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (JSONObject)((JSONObject)localObject5).get("qqpay");
      if (localObject1 != null)
      {
        localObject1 = (JSONArray)((JSONObject)localObject1).get("datas");
        if (localObject1 != null)
        {
          paramInt = 0;
          if (paramInt < ((JSONArray)localObject1).length())
          {
            localObject4 = (JSONObject)((JSONArray)localObject1).get(paramInt);
            localObject2 = (String)((JSONObject)localObject4).get("name");
            i1 = ((Integer)((JSONObject)localObject4).get("state")).intValue();
            localObject3 = (String)((JSONObject)localObject4).get(paramJSONObject);
            localObject4 = (String)((JSONObject)localObject4).get(paramBundle);
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("checkApiState onResult, qqpay name = ");
              ((StringBuilder)localObject5).append((String)localObject2);
              ((StringBuilder)localObject5).append(" state = ");
              ((StringBuilder)localObject5).append(i1);
              ((StringBuilder)localObject5).append(" api = ");
              ((StringBuilder)localObject5).append((String)localObject3);
              ((StringBuilder)localObject5).append(" msg= ");
              ((StringBuilder)localObject5).append((String)localObject4);
              ((StringBuilder)localObject5).append("\n");
              QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject5).toString());
            }
            paramInt += 1;
            continue;
            label910:
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("checkApiState onResult ");
              paramBundle.append(paramJSONObject.toString());
              QLog.d("AddFriendVerifyActivity", 2, paramBundle.toString());
            }
          }
        }
      }
      return;
      label953:
      paramInt += 1;
      continue;
      label964:
      continue;
      label967:
      paramInt += 1;
    }
  }
  
  /* Error */
  public byte[] a(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 526	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: aload_3
    //   8: invokestatic 526	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 1518	tencent/im/msg/im_msg_body$RichText
    //   19: dup
    //   20: invokespecial 1519	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokestatic 526	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +153 -> 181
    //   31: new 1521	tencent/im/msg/im_msg_body$Elem
    //   34: dup
    //   35: invokespecial 1522	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   38: astore 10
    //   40: new 1524	tencent/im/msg/im_msg_body$Text
    //   43: dup
    //   44: invokespecial 1525	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   47: astore 11
    //   49: aload 11
    //   51: getfield 1529	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: aload_3
    //   55: invokestatic 1535	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   58: invokevirtual 1541	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   61: aload 10
    //   63: getfield 1545	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   66: aload 11
    //   68: invokevirtual 1548	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   71: aload_2
    //   72: getfield 1552	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   75: aload 10
    //   77: invokevirtual 1557	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   80: new 1521	tencent/im/msg/im_msg_body$Elem
    //   83: dup
    //   84: invokespecial 1522	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   87: astore 10
    //   89: aload 10
    //   91: getfield 1561	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   94: aload_3
    //   95: iload 8
    //   97: invokestatic 1566	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Ljava/lang/String;I)Ltencent/im/msg/im_msg_body$RichMsg;
    //   100: invokevirtual 1569	tencent/im/msg/im_msg_body$RichMsg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   103: aload_2
    //   104: getfield 1552	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   107: aload 10
    //   109: invokevirtual 1557	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   112: new 1521	tencent/im/msg/im_msg_body$Elem
    //   115: dup
    //   116: invokespecial 1522	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   119: astore_3
    //   120: new 1571	tencent/im/msg/im_msg_body$GeneralFlags
    //   123: dup
    //   124: invokespecial 1572	tencent/im/msg/im_msg_body$GeneralFlags:<init>	()V
    //   127: astore 10
    //   129: new 1574	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   132: dup
    //   133: invokespecial 1575	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   136: astore 11
    //   138: aload 11
    //   140: getfield 1579	tencent/im/msg/hummer/resv/generalflags$ResvAttr:uint32_troop_pobing_template	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: iload 8
    //   145: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   148: aload 10
    //   150: getfield 1586	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   153: aload 11
    //   155: invokevirtual 1590	tencent/im/msg/hummer/resv/generalflags$ResvAttr:toByteArray	()[B
    //   158: invokestatic 1594	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: invokevirtual 1541	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   164: aload_3
    //   165: getfield 1598	tencent/im/msg/im_msg_body$Elem:general_flags	Ltencent/im/msg/im_msg_body$GeneralFlags;
    //   168: aload 10
    //   170: invokevirtual 1599	tencent/im/msg/im_msg_body$GeneralFlags:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   173: aload_2
    //   174: getfield 1552	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: aload_3
    //   178: invokevirtual 1557	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   181: new 1601	tencent/im/msg/im_msg_body$MsgBody
    //   184: dup
    //   185: invokespecial 1602	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   188: astore_3
    //   189: aload_3
    //   190: getfield 1606	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   193: aload_2
    //   194: invokevirtual 1607	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   197: new 1609	tencent/im/msg/im_msg$Msg
    //   200: dup
    //   201: invokespecial 1610	tencent/im/msg/im_msg$Msg:<init>	()V
    //   204: astore 10
    //   206: aload 10
    //   208: getfield 1614	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   211: aload_3
    //   212: invokevirtual 1615	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   215: new 1617	tencent/im/msg/im_msg$Group
    //   218: dup
    //   219: invokespecial 1618	tencent/im/msg/im_msg$Group:<init>	()V
    //   222: astore_3
    //   223: new 1620	tencent/im/msg/im_common$User
    //   226: dup
    //   227: invokespecial 1621	tencent/im/msg/im_common$User:<init>	()V
    //   230: astore 11
    //   232: aload 11
    //   234: getfield 1624	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   237: lload 4
    //   239: invokevirtual 1629	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   242: aload 11
    //   244: getfield 1632	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   247: sipush 1001
    //   250: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   253: aload 11
    //   255: getfield 1635	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: iconst_1
    //   259: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   262: aload 11
    //   264: getfield 1639	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   267: invokestatic 1643	com/dataline/util/DatalineMathUtil:a	()J
    //   270: l2i
    //   271: invokevirtual 1646	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   274: aload 11
    //   276: getfield 1649	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   279: bipush 109
    //   281: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   284: aload 11
    //   286: getfield 1652	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokestatic 1654	com/tencent/common/config/AppSetting:d	()I
    //   292: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   295: aload_3
    //   296: getfield 1658	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   299: aload 11
    //   301: invokevirtual 1659	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   304: aload_3
    //   305: getfield 1658	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   308: getfield 1624	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   311: lload 4
    //   313: invokevirtual 1629	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   316: new 1661	tencent/im/msg/im_common$GroupInfo
    //   319: dup
    //   320: invokespecial 1662	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   323: astore_2
    //   324: aload_3
    //   325: getfield 1666	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   328: aload_2
    //   329: invokevirtual 1667	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   332: aload_3
    //   333: getfield 1666	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   336: getfield 1670	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   339: lload 6
    //   341: invokevirtual 1629	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   344: aload_3
    //   345: getfield 1666	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   348: getfield 1674	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   351: iconst_1
    //   352: invokevirtual 1677	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   355: new 1679	tencent/im/msg/im_msg$RoutingHead
    //   358: dup
    //   359: invokespecial 1680	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   362: astore_2
    //   363: aload_2
    //   364: getfield 1684	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   367: aload_3
    //   368: invokevirtual 1685	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   371: new 1687	tencent/im/msg/im_msg$ContentHead
    //   374: dup
    //   375: invokespecial 1688	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   378: astore_3
    //   379: aload_3
    //   380: getfield 1691	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: astore 12
    //   385: getstatic 167	com/tencent/mobileqq/activity/AddFriendVerifyActivity:aO	I
    //   388: istore_1
    //   389: iload_1
    //   390: iconst_1
    //   391: iadd
    //   392: putstatic 167	com/tencent/mobileqq/activity/AddFriendVerifyActivity:aO	I
    //   395: aload 12
    //   397: iload_1
    //   398: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   401: new 1693	tencent/im/msg/im_msg$MsgHead
    //   404: dup
    //   405: invokespecial 1694	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   408: astore 12
    //   410: aload 12
    //   412: getfield 1698	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   415: aload_3
    //   416: invokevirtual 1699	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   419: aload 12
    //   421: getfield 1703	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   424: aload_2
    //   425: invokevirtual 1704	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   428: aload 10
    //   430: getfield 1708	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   433: aload 12
    //   435: invokevirtual 1709	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   438: new 1711	tencent/im/msg/im_imagent$Signature
    //   441: dup
    //   442: invokespecial 1712	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   445: astore 12
    //   447: aload 12
    //   449: getfield 1715	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   452: iconst_1
    //   453: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   456: aload 12
    //   458: getfield 1718	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: sipush 256
    //   464: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   467: ldc 188
    //   469: astore_2
    //   470: aload_0
    //   471: getfield 323	com/tencent/mobileqq/activity/AddFriendVerifyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   474: invokestatic 1723	com/tencent/qqconnect/wtlogin/LoginHelper:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   477: astore_3
    //   478: aload_3
    //   479: astore_2
    //   480: aload_3
    //   481: invokestatic 526	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   484: istore 9
    //   486: iload 9
    //   488: ifeq +54 -> 542
    //   491: aconst_null
    //   492: areturn
    //   493: astore 13
    //   495: aload_2
    //   496: astore_3
    //   497: invokestatic 715	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +42 -> 542
    //   503: new 312	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   510: astore_3
    //   511: aload_3
    //   512: ldc_w 1725
    //   515: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_3
    //   520: aload 13
    //   522: invokevirtual 1728	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   525: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: ldc_w 380
    //   532: iconst_2
    //   533: aload_3
    //   534: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 1730	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: aload_2
    //   541: astore_3
    //   542: aload 12
    //   544: getfield 1733	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   547: aload_3
    //   548: invokestatic 1535	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   551: invokevirtual 1541	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   554: new 1735	tencent/im/msg/im_imagent$ImAgentHead
    //   557: dup
    //   558: invokespecial 1736	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   561: astore_2
    //   562: aload_2
    //   563: getfield 1739	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   566: iconst_3
    //   567: invokevirtual 1677	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   570: aload_2
    //   571: getfield 1743	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   574: aload 12
    //   576: invokevirtual 1744	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   579: aload_2
    //   580: getfield 1747	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   583: aload 11
    //   585: invokevirtual 1659	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   588: aload_2
    //   589: getfield 1748	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   592: astore_3
    //   593: getstatic 167	com/tencent/mobileqq/activity/AddFriendVerifyActivity:aO	I
    //   596: istore_1
    //   597: iload_1
    //   598: iconst_1
    //   599: iadd
    //   600: putstatic 167	com/tencent/mobileqq/activity/AddFriendVerifyActivity:aO	I
    //   603: aload_3
    //   604: iload_1
    //   605: invokevirtual 1583	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   608: new 1750	tencent/im/msg/im_msg$MsgSendReq
    //   611: dup
    //   612: invokespecial 1751	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   615: astore_3
    //   616: aload_3
    //   617: getfield 1754	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   620: aload 10
    //   622: invokevirtual 1755	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   625: new 1757	tencent/im/msg/im_imagent$ImAgentPackage
    //   628: dup
    //   629: invokespecial 1758	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   632: astore 10
    //   634: aload 10
    //   636: getfield 1761	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   639: aload_2
    //   640: invokevirtual 1762	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   643: aload 10
    //   645: getfield 1766	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   648: aload_3
    //   649: invokevirtual 1767	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   652: aload 10
    //   654: invokevirtual 1768	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   657: astore_2
    //   658: new 1770	java/io/ByteArrayOutputStream
    //   661: dup
    //   662: aload_2
    //   663: arraylength
    //   664: bipush 8
    //   666: iadd
    //   667: invokespecial 1772	java/io/ByteArrayOutputStream:<init>	(I)V
    //   670: astore_3
    //   671: new 1774	java/io/DataOutputStream
    //   674: dup
    //   675: aload_3
    //   676: invokespecial 1777	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   679: astore 10
    //   681: aload 10
    //   683: aload_2
    //   684: arraylength
    //   685: bipush 8
    //   687: iadd
    //   688: invokevirtual 1780	java/io/DataOutputStream:writeInt	(I)V
    //   691: aload 10
    //   693: bipush 123
    //   695: invokevirtual 1783	java/io/DataOutputStream:write	(I)V
    //   698: aload 10
    //   700: bipush 123
    //   702: invokevirtual 1783	java/io/DataOutputStream:write	(I)V
    //   705: aload 10
    //   707: aload_2
    //   708: invokevirtual 1786	java/io/DataOutputStream:write	([B)V
    //   711: aload 10
    //   713: bipush 125
    //   715: invokevirtual 1783	java/io/DataOutputStream:write	(I)V
    //   718: aload 10
    //   720: bipush 125
    //   722: invokevirtual 1783	java/io/DataOutputStream:write	(I)V
    //   725: aload_3
    //   726: invokevirtual 1787	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   729: astore 11
    //   731: new 312	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   738: astore 12
    //   740: aload 12
    //   742: ldc_w 1789
    //   745: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 11
    //   751: ifnonnull +10 -> 761
    //   754: ldc_w 1791
    //   757: astore_2
    //   758: goto +10 -> 768
    //   761: aload 11
    //   763: arraylength
    //   764: invokestatic 935	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   767: astore_2
    //   768: aload 12
    //   770: aload_2
    //   771: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: ldc_w 380
    //   778: iconst_1
    //   779: aload 12
    //   781: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 385	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: aload_3
    //   788: invokevirtual 1793	java/io/ByteArrayOutputStream:close	()V
    //   791: aload 10
    //   793: invokevirtual 1794	java/io/DataOutputStream:close	()V
    //   796: aload 11
    //   798: areturn
    //   799: astore_2
    //   800: goto +19 -> 819
    //   803: astore_2
    //   804: aload_2
    //   805: invokevirtual 1795	java/lang/Exception:printStackTrace	()V
    //   808: aload_3
    //   809: invokevirtual 1793	java/io/ByteArrayOutputStream:close	()V
    //   812: aload 10
    //   814: invokevirtual 1794	java/io/DataOutputStream:close	()V
    //   817: aconst_null
    //   818: areturn
    //   819: aload_3
    //   820: invokevirtual 1793	java/io/ByteArrayOutputStream:close	()V
    //   823: aload 10
    //   825: invokevirtual 1794	java/io/DataOutputStream:close	()V
    //   828: aload_2
    //   829: athrow
    //   830: astore_2
    //   831: aload 11
    //   833: areturn
    //   834: astore_2
    //   835: aconst_null
    //   836: areturn
    //   837: astore_3
    //   838: goto -10 -> 828
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	AddFriendVerifyActivity
    //   0	841	1	paramInt1	int
    //   0	841	2	paramString1	String
    //   0	841	3	paramString2	String
    //   0	841	4	paramLong1	long
    //   0	841	6	paramLong2	long
    //   0	841	8	paramInt2	int
    //   484	3	9	bool	boolean
    //   38	786	10	localObject1	Object
    //   47	785	11	localObject2	Object
    //   383	397	12	localObject3	Object
    //   493	28	13	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   470	478	493	java/lang/InterruptedException
    //   480	486	493	java/lang/InterruptedException
    //   681	749	799	finally
    //   761	768	799	finally
    //   768	787	799	finally
    //   804	808	799	finally
    //   681	749	803	java/lang/Exception
    //   761	768	803	java/lang/Exception
    //   768	787	803	java/lang/Exception
    //   787	796	830	java/lang/Exception
    //   808	817	834	java/lang/Exception
    //   819	828	837	java/lang/Exception
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.f.getText().toString();
    if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).countByByte(paramEditable) > 32)
    {
      int i1 = this.f.getSelectionStart();
      paramEditable = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getRemark(paramEditable);
      this.f.setText(paramEditable);
      if (i1 >= paramEditable.length()) {
        this.f.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.e)
    {
      paramEditable = this.N;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131890924));
      localStringBuilder.append(this.f.getText().toString());
      paramEditable.setContentDescription(localStringBuilder.toString());
    }
  }
  
  void b(String paramString)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this.app.getApp(), 1, getString(2131915702), 0).show(getTitleBarHeight());
      return;
    }
    if (getIntent().hasExtra("contacts"))
    {
      ArrayList localArrayList = (ArrayList)getIntent().getSerializableExtra("contacts");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        if (this.a == null)
        {
          this.a = new QQProgressDialog(this, getTitleBarHeight());
          this.a.setOnDismissListener(new AddFriendVerifyActivity.14(this));
        }
        this.a.setCancelable(true);
        this.a.setCanceledOnTouchOutside(false);
        this.a.c(2131916272);
        this.a.show();
        this.as.clear();
        this.as.addAll(localArrayList);
        ((IFriendHandlerService)this.Z.app.getRuntimeService(IFriendHandlerService.class, "")).requestAddBatchPhoneFriend(this.as, paramString, 0, this.X, new ArrayList());
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      if (!localFile.isFile()) {
        return;
      }
      if (!NetworkUtil.isNetworkAvailable(getApplicationContext()))
      {
        QQToast.makeText(getApplicationContext(), 1, 2131893831, 0).show(getTitleBarHeight());
        return;
      }
      ThreadManager.post(new AddFriendVerifyActivity.25(this, paramString), 5, null, false);
    }
  }
  
  protected void d(String paramString)
  {
    if (this.ab != 4)
    {
      this.L.setText("30");
    }
    else
    {
      int i2 = 0;
      int i1;
      try
      {
        i1 = paramString.getBytes("utf-8").length;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("AddFriendVerifyActivity", 2, "get intro length failed!");
          i1 = i2;
        }
      }
      TextView localTextView = this.L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(90 - i1);
      localStringBuilder.append("");
      localTextView.setText(localStringBuilder.toString());
    }
    this.K.setText(paramString);
    paramString = this.K;
    paramString.setSelection(paramString.getText().length());
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
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    Object localObject;
    if (bool1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult, requestCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",data=");
      if (paramIntent == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    if (paramInt1 != 1001)
    {
      if (paramInt1 != 1002)
      {
        if (paramInt1 != 1004) {
          return;
        }
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("ticket");
          localObject = this.au;
          if (localObject != null)
          {
            a(((Bundle)localObject).getString("msg", ""), this.au.getByteArray("sig"), paramIntent);
            bool1 = true;
          }
          else
          {
            paramIntent = this.a;
            if (paramIntent != null)
            {
              paramIntent.cancel();
              this.a = null;
            }
            e(getString(2131915702));
            g();
            bool1 = bool2;
          }
        }
        else
        {
          paramIntent = this.a;
          if (paramIntent != null)
          {
            paramIntent.cancel();
            this.a = null;
          }
          e(getString(2131915702));
          g();
          bool1 = bool2;
        }
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("REQUEST_CODE_SECCHECK_H5_PAGE, isSuccuss=");
          paramIntent.append(bool1);
          QLog.d("AddFriendVerifyActivity", 2, paramIntent.toString());
        }
      }
      else if (paramIntent != null)
      {
        paramInt1 = paramIntent.getByteExtra("result", (byte)0);
        this.V = paramInt1;
        this.g.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, paramInt1));
        paramIntent = this.O;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131898137));
        ((StringBuilder)localObject).append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, paramInt1));
        paramIntent.setContentDescription(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      paramIntent = this.ay.getPath();
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.aN = paramIntent;
        a(this.aN);
        c(this.aN);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = getIntent();
    this.aa = ((Intent)localObject1).getStringExtra("uin");
    this.ab = ((Intent)localObject1).getIntExtra("k_uin_type", 1);
    if (this.ab != 4) {
      setTheme(2131952010);
    }
    this.at = ((Intent)localObject1).getIntExtra("entrance", -1);
    super.doOnCreate(paramBundle);
    this.s = ((InputMethodManager)getSystemService("input_method"));
    int i1;
    Object localObject2;
    if (this.ab == 4)
    {
      setContentViewB(2131624060);
      this.G = ((LinearLayout)findViewById(2131449376));
      this.H = ((TextView)findViewById(2131449383));
      this.I = ((TextView)findViewById(2131449380));
      this.J = ((TextView)findViewById(2131449381));
      this.K = ((EditText)findViewById(2131449377));
      this.L = ((TextView)findViewById(2131449379));
      this.K.addTextChangedListener(this.az);
      this.ae = ((RelativeLayout)findViewById(2131447984));
      this.al = ((ImageView)this.ae.findViewById(2131427763));
      this.aj = ((URLImageView)this.ae.findViewById(2131435388));
      this.ak = ((ImageView)this.ae.findViewById(2131435466));
      this.ae.setVisibility(8);
      this.ad = ((TextView)findViewById(2131440985));
      this.af = ((LinearLayout)findViewById(2131441544));
      this.ag = ((TextView)findViewById(2131441546));
      this.ah = ((ClearableEditText)findViewById(2131441543));
      this.ai = ((TextView)findViewById(2131441545));
      this.an = ((RecyclerView)findViewById(2131440449));
      this.am = ((ImageView)findViewById(2131449382));
      this.y = ((TextView)findViewById(2131440983));
      this.z = ((TextView)findViewById(2131440984));
    }
    else
    {
      setContentViewB(2131624059);
      this.Z = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
      this.Y = getIntent().getIntExtra("sub_source_id", 0);
      this.X = ((Intent)localObject1).getIntExtra("source_id", 3999);
      if (((Intent)localObject1).hasExtra("param_wzry_data")) {
        this.v = ((KplRoleInfo.WZRYUIinfo)((Intent)localObject1).getSerializableExtra("param_wzry_data"));
      }
      if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(this.X))
      {
        this.W = ((Intent)localObject1).getStringExtra("nick_name");
      }
      else if (this.v != null)
      {
        this.W = ((Intent)localObject1).getStringExtra("nick_name");
      }
      else if (this.X == 3004)
      {
        i1 = this.Y;
        if ((i1 == 5) || (i1 == 6) || (i1 == 7) || (i1 == 8)) {
          this.W = ((Intent)localObject1).getStringExtra("nick_name");
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AddFriendVerifyActivity remark = ");
        ((StringBuilder)localObject2).append(this.W);
        ((StringBuilder)localObject2).append(", source id=");
        ((StringBuilder)localObject2).append(this.X);
        ((StringBuilder)localObject2).append(", mTargetGroupId = ");
        ((StringBuilder)localObject2).append(this.V);
        QLog.i("AddFriendVerifyActivity", 2, ((StringBuilder)localObject2).toString());
      }
      if ((paramBundle == null) && (NetworkUtil.isNetSupport(this)) && (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldReqAutoInfo(this.X, this.aa))) {
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.aa, this.X, ((Intent)localObject1).getIntExtra("sub_source_id", 0));
      }
      getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aQ);
      this.e = ((BounceScrollView)findViewById(2131429719));
      this.e.setOnTouchListener(new AddFriendVerifyActivity.1(this));
      this.b = ((EditText)findViewById(2131444679));
      this.h = ((TextView)findViewById(2131444680));
      this.t = new AddFriendVerifyActivity.MaxBytesTextWatcher(100, this.b);
      this.b.addTextChangedListener(this.t);
      this.i = ((TextView)findViewById(2131427894));
      this.i.setVisibility(0);
      paramBundle = getIntent().getStringExtra("key_param_age_area");
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.i.setText(paramBundle);
        if (AppSetting.e) {
          this.i.setContentDescription(paramBundle);
        }
      }
      this.b.setOnTouchListener(this);
      this.c = ((LinearLayout)findViewById(2131439178));
      this.d = ((LinearLayout)findViewById(2131428391));
      this.m = ((ImageView)findViewById(2131440523));
      this.ac = ((TextView)findViewById(2131439320));
      this.P = ((TextView)findViewById(2131447553));
      this.M = ((LinearLayout)findViewById(2131434404));
      this.N = ((FormItemRelativeLayout)findViewById(2131445011));
      this.N.setBGType(1);
      this.O = ((FormItemRelativeLayout)findViewById(2131444961));
      this.O.setBGType(3);
      this.f = ((EditText)findViewById(2131432631));
      this.g = ((TextView)findViewById(2131448505));
      this.f.addTextChangedListener(this);
      this.O.setOnClickListener(this);
      this.f.setText(this.W);
      if (!TextUtils.isEmpty(this.W)) {
        this.f.setSelection(this.W.length());
      }
      this.g.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.V));
      paramBundle = this.O;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898131));
      ((StringBuilder)localObject2).append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.V));
      paramBundle.setContentDescription(((StringBuilder)localObject2).toString());
      if (Utils.c(this.aa))
      {
        this.N.setVisibility(8);
        this.P.setText(getString(2131886225));
      }
      else
      {
        this.N.setVisibility(0);
        this.P.setText(getString(2131886224));
      }
      if ((!EAddFriendSourceID.a(this.X)) && (this.X != 3016)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 == 0)
      {
        this.Q = findViewById(2131443801);
        this.Q.setVisibility(0);
        this.R = ((Switch)findViewById(2131443802));
        this.R.setOnCheckedChangeListener(this);
      }
      if ((this.X == 3050) && (this.Y == 3))
      {
        paramBundle = new HashMap();
        if (!((Intent)localObject1).getBooleanExtra("qcircle_isfollow", false))
        {
          this.S = findViewById(2131441680);
          this.S.setVisibility(0);
          this.T = ((Switch)findViewById(2131441681));
          this.T.setOnCheckedChangeListener(this);
          paramBundle.put("ext3", "1");
        }
        else
        {
          paramBundle.put("ext3", "2");
        }
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.aa).setActionType(79).setSubActionType(1).setThrActionType(0).setExtras(paramBundle));
        if (((Intent)localObject1).getBooleanExtra("key_qcircle_stick", false)) {
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.aa).setActionType(93).setSubActionType(1).setThrActionType(1));
        }
      }
      if (AppSetting.e)
      {
        this.m.setContentDescription(getString(2131889121));
        if (!Utils.c(this.aa)) {
          this.P.setContentDescription(getString(2131915666));
        } else {
          this.P.setContentDescription(getString(2131915665));
        }
        this.N.setFocusable(true);
        paramBundle = this.N;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getResources().getString(2131890924));
        ((StringBuilder)localObject2).append(this.f.getText().toString());
        paramBundle.setContentDescription(((StringBuilder)localObject2).toString());
        this.f.setContentDescription(null);
        if (i1 == 0)
        {
          this.Q.setFocusable(true);
          this.Q.setContentDescription(getResources().getString(2131914894));
        }
      }
    }
    this.a = new QQProgressDialog(this, getTitleBarHeight());
    this.a.c(2131887707);
    this.ap = ((Intent)localObject1).getStringExtra("authKey");
    this.aq = ((Intent)localObject1).getStringExtra("authSig");
    paramBundle = this.ap;
    paramBundle = getIntent().getExtras().getString("nick_name");
    Object localObject3;
    int i2;
    Object localObject4;
    if (this.ab == 4)
    {
      setTitle(2131886314);
      localObject3 = (TextView)findViewById(2131436180);
      localObject2 = getIntent().getExtras().getString("leftViewText");
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null) {
        paramBundle = getString(2131887625);
      }
      ((TextView)localObject3).setText(paramBundle);
      this.o = this.aa;
      this.p = getIntent().getExtras().getString("troop_code");
      addObserver(this.aF);
      addObserver(this.aD);
      addObserver(this.aE);
      localObject2 = (ITroopMngHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      paramBundle = (ITroopInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
      this.x = getIntent().getExtras().getString("key_param_homework_intro_str");
      if (TextUtils.isEmpty(this.x)) {
        paramBundle.c(this.o);
      }
      this.A = getIntent().getExtras().getShort("group_option", (short)2);
      i1 = this.A;
      paramBundle = getIntent().getExtras().getString("troop_question");
      getIntent().getExtras().getString("troop_answer");
      i2 = getIntent().getIntExtra("stat_option", 0);
      TroopReportor.a(this.o, 1, 1, i2);
      ((ITroopMngHandler)localObject2).a(Long.valueOf(this.o).longValue(), Long.valueOf(this.app.getCurrentUin()).longValue(), null);
      if ((i1 != 1) && (i1 != 2))
      {
        if (i1 != 3) {
          if (i1 != 4)
          {
            if (i1 == 5)
            {
              this.af.setVisibility(0);
              this.J.setVisibility(8);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(getString(2131914209));
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(paramBundle);
              paramBundle = new QQText(((StringBuilder)localObject2).toString(), 13);
              this.ag.setText(paramBundle);
              this.ag.setTag(this.o);
              this.ag.setMovementMethod(LinkMovementMethod.getInstance());
              this.ag.setVisibility(0);
              this.ah.setFocusable(true);
              this.ah.setFocusableInTouchMode(true);
              if (n) {
                this.ah.setContentDescription(getString(2131888923));
              }
              setRightHighlightButton(2131887750, new AddFriendVerifyActivity.4(this));
              ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.o, "", "", "");
              if (paramBundle.mSpanCount > 0)
              {
                i2 = 0;
                while (i2 < paramBundle.mSpans.length)
                {
                  if ((paramBundle.mSpans[i2] instanceof LinkSpan))
                  {
                    localObject2 = ((LinkSpan)paramBundle.mSpans[i2]).b;
                    i1 = -1;
                    if (Patterns.d.matcher((CharSequence)localObject2).find()) {
                      i1 = 0;
                    }
                    if (QQTextParseLinkUtil.c.matcher((CharSequence)localObject2).find()) {
                      i1 = 1;
                    }
                    if (QQTextParseLinkUtil.f.matcher((CharSequence)localObject2).find()) {
                      i1 = 2;
                    }
                    localObject2 = this.app;
                    localObject3 = this.o;
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append("");
                    ((StringBuilder)localObject4).append(i1);
                    ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, (String)localObject3, ((StringBuilder)localObject4).toString(), "", "");
                  }
                  i2 += 1;
                }
              }
            }
          }
          else
          {
            this.af.setVisibility(0);
            this.J.setVisibility(8);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(getString(2131914209));
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(paramBundle);
            paramBundle = new QQText(((StringBuilder)localObject2).toString(), 13);
            this.ag.setText(paramBundle);
            this.ag.setTag(this.o);
            this.ag.setMovementMethod(LinkMovementMethod.getInstance());
            this.ah.setFocusable(true);
            this.ah.setFocusableInTouchMode(true);
            if (n) {
              this.ah.setContentDescription(getString(2131888923));
            }
            setRightHighlightButton(2131887750, new AddFriendVerifyActivity.3(this));
            ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.o, "", "", "");
            if (paramBundle.mSpanCount > 0) {
              i2 = 0;
            }
          }
        }
      }
      else {
        while (i2 < paramBundle.mSpans.length)
        {
          if ((paramBundle.mSpans[i2] instanceof LinkSpan))
          {
            localObject2 = ((LinkSpan)paramBundle.mSpans[i2]).b;
            i1 = -1;
            if (Patterns.d.matcher((CharSequence)localObject2).find()) {
              i1 = 0;
            }
            if (QQTextParseLinkUtil.c.matcher((CharSequence)localObject2).find()) {
              i1 = 1;
            }
            if (QQTextParseLinkUtil.f.matcher((CharSequence)localObject2).find()) {
              i1 = 2;
            }
            localObject2 = this.app;
            localObject3 = this.o;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(i1);
            ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, (String)localObject3, ((StringBuilder)localObject4).toString(), "", "");
          }
          i2 += 1;
          continue;
          this.G.setVisibility(0);
          this.H.setVisibility(8);
          this.I.setVisibility(8);
          this.ad.setVisibility(0);
          this.J.setVisibility(0);
          ((RelativeLayout.LayoutParams)this.G.getLayoutParams()).topMargin = 0;
          this.aj.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)1));
          this.aj.setOnClickListener(this.aG);
          this.al.setOnClickListener(this.aG);
          this.L.setVisibility(0);
          this.K.setHeight(AIOUtils.b(160.0F, getResources()));
          this.K.setSingleLine(false);
          this.K.setGravity(48);
          this.K.setHint("");
          i1 = AIOUtils.b(10.0F, getResources());
          this.K.setPadding(i1, i1, i1, i1);
          if (TextUtils.isEmpty(this.x)) {
            paramBundle = getString(2131895318, new Object[] { this.app.getCurrentNickname() });
          } else {
            paramBundle = this.x;
          }
          d(paramBundle);
          if (VasUpdateUtil.a())
          {
            ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F8", 0, 0, "", "", "", "");
            paramBundle = new GridLayoutManager(this, 2);
            this.ao = new PobingTemplateAdapter(this);
            this.an.setLayoutManager(paramBundle);
            this.an.setAdapter(this.ao);
            this.an.setVisibility(0);
            paramBundle = (VipInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
            if (paramBundle != null)
            {
              localObject2 = new UniGetReq();
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(Integer.valueOf(40));
              ((UniGetReq)localObject2).appidList = ((ArrayList)localObject3);
              paramBundle.a((UniGetReq)localObject2, new AddFriendVerifyActivity.PobingTemplateObserver(this, 0), false);
            }
            else
            {
              QLog.e("AddFriendVerifyActivity", 1, "get fail, VipInfoHandler is null");
            }
          }
          setRightHighlightButton(2131887750, new AddFriendVerifyActivity.2(this));
        }
      }
      getWindow().setSoftInputMode(5);
      paramBundle = (Bundle)localObject1;
    }
    for (;;)
    {
      break label5525;
      setTitle(2131886219);
      setLeftButton(HardCodeUtil.a(2131898103), null);
      localObject2 = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      int i3 = getIntent().getExtras().getInt("source_id", 3999);
      int i4 = getIntent().getIntExtra("sub_source_id", 0);
      if (EAddFriendSourceID.a(getIntent().getIntExtra("sort_id", 0)))
      {
        localObject3 = this.aa;
        ((CardHandler)localObject2).a(this.app.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, (String)localObject3, 0L, 10004, null, (byte)0);
      }
      else
      {
        ((CardHandler)localObject2).a(this.app.getCurrentAccountUin(), this.aa, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
      }
      addObserver(this.aA);
      addObserver(this.aB);
      addObserver(this.aC);
      i1 = this.ab;
      if (i1 == 2)
      {
        this.m.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 11, this.aa));
        localObject3 = this.ac;
        if (TextUtils.isEmpty(paramBundle)) {
          localObject2 = this.aa;
        } else {
          localObject2 = paramBundle;
        }
        ((TextView)localObject3).setText((CharSequence)localObject2);
        if (AppSetting.e)
        {
          localObject3 = this.ac;
          localObject2 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject2 = this.aa;
          }
          ((TextView)localObject3).setContentDescription((CharSequence)localObject2);
        }
      }
      else if (i1 == 3)
      {
        localObject2 = ((Intent)localObject1).getStringExtra("extra");
        localObject2 = URLDrawable.getDrawable(FaceDrawable.getOpenIdUrl(this.aa, (String)localObject2), URLDrawable.URLDrawableOptions.obtain());
        if (QQTheme.isNowSimpleUI()) {
          this.m.setImageDrawable((Drawable)localObject2);
        } else {
          a((URLDrawable)localObject2);
        }
        this.ac.setText(paramBundle);
        if (AppSetting.e) {
          this.ac.setContentDescription(paramBundle);
        }
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestInfoWithOpenId(this.aa, getIntent().getStringExtra("extra"));
      }
      else
      {
        if ((i3 != 3007) && (i3 != 2007) && (i3 != 4007) && (i3 != 3019) && (i3 != 2019)) {
          this.m.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.aa));
        } else {
          this.m.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.aa, true));
        }
        if (d())
        {
          if (paramBundle != null)
          {
            this.ac.setText(paramBundle);
            if (AppSetting.e) {
              this.ac.setContentDescription(paramBundle);
            }
          }
        }
        else {
          ThreadManager.getSubThreadHandler().post(new AddFriendVerifyActivity.5(this, paramBundle));
        }
      }
      int i5 = ((Intent)localObject1).getIntExtra("friend_setting", 0);
      localObject3 = getIntent().getExtras().getStringArrayList("user_question");
      localObject2 = "reportClickEvent action: 0X80077AF  sourceId = ";
      if (i5 != 0)
      {
        if (i5 == 1) {
          break label4918;
        }
        if (i5 != 2)
        {
          if (i5 != 3)
          {
            if (i5 != 4) {
              break;
            }
            this.d.setVisibility(0);
            localObject4 = new StringBuffer();
            if ((localObject3 != null) && (((ArrayList)localObject3).size() == 1)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            i2 = 0;
            while (i2 < ((ArrayList)localObject3).size())
            {
              if (i2 != 0)
              {
                if (i2 != 1)
                {
                  if (i2 != 2)
                  {
                    if (i2 != 3)
                    {
                      if (i2 != 4) {
                        paramBundle = getResources().getString(2131914209);
                      } else {
                        paramBundle = getResources().getString(2131914215);
                      }
                    }
                    else {
                      paramBundle = getResources().getString(2131914214);
                    }
                  }
                  else {
                    paramBundle = getResources().getString(2131914213);
                  }
                }
                else {
                  paramBundle = getResources().getString(2131914212);
                }
              }
              else if (i1 != 0) {
                paramBundle = getResources().getString(2131914210);
              } else {
                paramBundle = getResources().getString(2131914211);
              }
              Object localObject7 = getLayoutInflater().inflate(2131627238, this.d, false);
              Object localObject6 = getLayoutInflater().inflate(2131627237, this.d, false);
              if (i2 > 0)
              {
                localObject5 = (LinearLayout.LayoutParams)((View)localObject7).getLayoutParams();
                if (localObject5 != null)
                {
                  ((LinearLayout.LayoutParams)localObject5).topMargin = ((int)DisplayUtils.a(getApplication(), 19.0F));
                  ((View)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject5);
                }
              }
              this.d.addView((View)localObject7);
              this.d.addView((View)localObject6);
              Object localObject5 = (String)((ArrayList)localObject3).get(i2);
              localObject7 = (TextView)((View)localObject7).findViewById(2131447090);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramBundle);
              localStringBuilder.append((String)localObject5);
              ((TextView)localObject7).setText(localStringBuilder.toString());
              localObject6 = (EditText)((View)localObject6).findViewById(2131435831);
              ((EditText)localObject6).addTextChangedListener(new AddFriendVerifyActivity.MaxBytesTextWatcher(50, (EditText)localObject6));
              this.F.add(localObject6);
              if (n)
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append(paramBundle);
                ((StringBuilder)localObject6).append((String)localObject5);
                ((TextView)localObject7).setContentDescription(((StringBuilder)localObject6).toString());
                ((EditText)this.F.get(i2)).setContentDescription(getString(2131886223));
              }
              i2 += 1;
              paramBundle = new StringBuilder();
              paramBundle.append(getString(2131914209));
              paramBundle.append(i2);
              paramBundle.append(":");
              paramBundle.append((String)localObject5);
              ((StringBuffer)localObject4).append(paramBundle.toString());
              ((StringBuffer)localObject4).append("\n");
              paramBundle = new StringBuilder();
              paramBundle.append(getString(2131886663));
              paramBundle.append(":${answer}");
              ((StringBuffer)localObject4).append(paramBundle.toString());
              if (i2 != ((ArrayList)localObject3).size()) {
                ((StringBuffer)localObject4).append("\n");
              }
            }
            setRightHighlightButton(2131887750, new AddFriendVerifyActivity.10(this, (StringBuffer)localObject4, i3, i4, i5));
            findViewById(2131445015).setOnTouchListener(new AddFriendVerifyActivity.11(this));
            getWindow().setSoftInputMode(4);
            paramBundle = (RelativeLayout.LayoutParams)this.M.getLayoutParams();
            paramBundle.addRule(3, this.d.getId());
            paramBundle.topMargin = AIOUtils.b(20.0F, getResources());
            this.M.setLayoutParams(paramBundle);
            ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(i3), String.valueOf(i4), "", "");
            paramBundle = (Bundle)localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            paramBundle = new StringBuilder();
            paramBundle.append((String)localObject2);
            paramBundle.append(i3);
            paramBundle.append(" subSourceId = ");
            paramBundle.append(i4);
            QLog.d("AddFriendVerifyActivity", 2, paramBundle.toString());
            paramBundle = (Bundle)localObject1;
            continue;
          }
          this.c.setVisibility(0);
          paramBundle = (String)((ArrayList)localObject3).get(0);
          localObject2 = (TextView)this.c.findViewById(2131447090);
          localObject3 = (EditText)this.c.findViewById(2131435831);
          this.u = new AddFriendVerifyActivity.MaxBytesTextWatcher(50, (EditText)localObject3);
          ((EditText)localObject3).addTextChangedListener(this.u);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(getString(2131914209));
          ((StringBuilder)localObject4).append(":");
          ((StringBuilder)localObject4).append(paramBundle);
          ((TextView)localObject2).setText(((StringBuilder)localObject4).toString());
          ((EditText)localObject3).setSingleLine(true);
          if (n)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(getString(2131914209));
            ((StringBuilder)localObject4).append(":");
            ((StringBuilder)localObject4).append(paramBundle);
            ((TextView)localObject2).setContentDescription(((StringBuilder)localObject4).toString());
            ((EditText)localObject3).setContentDescription(getString(2131886223));
          }
          setRightHighlightButton(2131887750, new AddFriendVerifyActivity.9(this, (EditText)localObject3, i5, i3, i4));
          getWindow().setSoftInputMode(5);
          paramBundle = (RelativeLayout.LayoutParams)this.M.getLayoutParams();
          paramBundle.addRule(3, this.c.getId());
          paramBundle.topMargin = AIOUtils.b(20.0F, getResources());
          this.M.setLayoutParams(paramBundle);
          ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(i3), String.valueOf(i4), "", "");
          paramBundle = (Bundle)localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("reportClickEvent action: 0X80077AF  sourceId = ");
          paramBundle.append(i3);
          paramBundle.append(" subSourceId = ");
          paramBundle.append(i4);
          QLog.d("AddFriendVerifyActivity", 2, paramBundle.toString());
          paramBundle = (Bundle)localObject1;
          continue;
        }
      }
      paramBundle = (Bundle)localObject1;
      break label5136;
      label4918:
      this.b.setVisibility(0);
      this.h.setVisibility(0);
      if (AppSetting.e)
      {
        paramBundle = this.b;
        paramBundle.setContentDescription(paramBundle.getText().toString());
        this.h.setContentDescription(getString(2131886226));
      }
      setRightHighlightButton(2131887750, new AddFriendVerifyActivity.8(this, i3, i4, i5));
      paramBundle = (RelativeLayout.LayoutParams)this.M.getLayoutParams();
      paramBundle.addRule(3, this.b.getId());
      paramBundle.topMargin = AIOUtils.b(20.0F, getResources());
      this.M.setLayoutParams(paramBundle);
      ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(i3), String.valueOf(i4), "", "");
      paramBundle = (Bundle)localObject1;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("reportClickEvent action: 0X80077AF  sourceId = ");
        paramBundle.append(i3);
        paramBundle.append(" subSourceId = ");
        paramBundle.append(i4);
        QLog.d("AddFriendVerifyActivity", 2, paramBundle.toString());
        paramBundle = (Bundle)localObject1;
        continue;
        label5136:
        if ((i3 != 3078) && (i3 != 3079))
        {
          setRightHighlightButton(2131887750, new AddFriendVerifyActivity.7(this, i3, i4));
          localObject1 = (RelativeLayout.LayoutParams)this.M.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.m.getId());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(20.0F, getResources());
          this.M.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ReportController.b(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(i3), String.valueOf(i4), "", "");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("reportClickEvent action: 0X80077AF  sourceId = ");
            ((StringBuilder)localObject1).append(i3);
            ((StringBuilder)localObject1).append(" subSourceId = ");
            ((StringBuilder)localObject1).append(i4);
            QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject1).toString());
          }
          a(i3, i5);
        }
        else
        {
          this.b.setVisibility(0);
          this.h.setVisibility(0);
          this.h.setText(getString(2131886207));
          this.m.setVisibility(8);
          this.ac.setVisibility(8);
          this.i.setVisibility(8);
          if (AppSetting.e)
          {
            localObject1 = this.b;
            ((EditText)localObject1).setContentDescription(((EditText)localObject1).getText().toString());
            this.h.setContentDescription(getString(2131886226));
          }
          this.M.setVisibility(8);
          if (getIntent() != null) {
            i1 = getIntent().getIntExtra("contact_from_type", 1);
          } else {
            i1 = 1;
          }
          setRightHighlightButton(2131887750, new AddFriendVerifyActivity.6(this, i1));
          localObject1 = (RelativeLayout.LayoutParams)this.M.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.b.getId());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(20.0F, getResources());
          this.M.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    label5525:
    if (this.ab == 3)
    {
      localObject1 = paramBundle.getStringExtra("is_from_game");
      paramBundle = paramBundle.getStringExtra("extra");
      try
      {
        localObject2 = QConfigLocalLoader.a(BaseApplicationImpl.getApplication());
        if ((("true".equals(localObject1)) || (((QConfLogBean)localObject2).b())) && (!TextUtils.isEmpty(paramBundle)))
        {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), paramBundle, this, 1003, null);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("AddFriend enableCheckPermission = ");
            ((StringBuilder)localObject3).append(((QConfLogBean)localObject2).b());
            QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
      catch (Exception localException)
      {
        if (("true".equals(localObject1)) && (!TextUtils.isEmpty(paramBundle))) {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), paramBundle, this, 1003, null);
        }
        paramBundle = new StringBuilder();
        paramBundle.append("AddFriend loadConfig exception = ");
        paramBundle.append(localException);
        QLog.d("AddFriendVerifyActivity", 1, paramBundle.toString());
      }
      this.M.setVisibility(8);
    }
    enableRightHighlight(true);
    if (QidianManager.a(this.app, this.aa)) {
      this.i.setVisibility(8);
    }
    this.w = getIntent().getStringExtra("webImVisitId");
    return true;
  }
  
  protected void doOnDestroy()
  {
    Dialog localDialog = this.j;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.j.getWindow() != null)) {}
    try
    {
      this.j.dismiss();
    }
    catch (Throwable localThrowable)
    {
      label36:
      break label36;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.aQ);
    } else {
      getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aQ);
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      this.aN = ((String)paramIntent.get(0));
      c(this.aN);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject1;
    int i2;
    String str;
    Object localObject2;
    Object localObject3;
    if (this.ab != 4)
    {
      localObject1 = getIntent();
      i2 = 0;
      int i3 = 0;
      i1 = ((Intent)localObject1).getIntExtra("friend_setting", 0);
      if (i1 != 0)
      {
        if (i1 != 1) {
          return;
        }
        str = getString(2131888921);
        if (getIntent().getBooleanExtra("_FROM_QLINK_", false))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(getString(2131896325));
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(ContactUtils.a(this.app, this.app.getAccount()));
          localObject2 = ((StringBuilder)localObject1).toString();
          this.b.setHint((CharSequence)localObject2);
        }
        else
        {
          this.b.setHint("");
          localObject2 = str;
        }
        this.b.setVisibility(0);
        this.h.setVisibility(0);
        if (AppSetting.e)
        {
          localObject1 = this.b;
          ((EditText)localObject1).setContentDescription(((EditText)localObject1).getText().toString());
          this.h.setContentDescription(getString(2131886226));
        }
        localObject1 = null;
        if (this.ab == 3)
        {
          localObject1 = getIntent().getStringExtra("msg");
        }
        else
        {
          localObject3 = this.v;
          if (localObject3 != null)
          {
            localObject3 = ((KplRoleInfo.WZRYUIinfo)localObject3).verifyMsg;
            localObject1 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              i1 = 0;
              localObject1 = localObject3;
              break label278;
            }
          }
        }
        i1 = 1;
        label278:
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = a(false);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = localObject3;
        }
        i2 = i3;
        localObject1 = localObject2;
        if (i1 != 0)
        {
          i2 = i3;
          localObject1 = localObject2;
          if (str.equals(localObject2))
          {
            i2 = i3;
            localObject1 = localObject2;
            if (!e())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append(ContactUtils.a(this.app, this.app.getAccount()));
              localObject1 = ((StringBuilder)localObject1).toString();
              i2 = 1;
            }
          }
        }
        this.b.setText((CharSequence)localObject1);
        if (i2 == 0) {}
      }
    }
    try
    {
      this.b.setSelection(str.length(), ((String)localObject1).length());
    }
    catch (Throwable localThrowable1)
    {
      break label442;
    }
    this.b.setSelection(((String)localObject1).length());
    label442:
    getWindow().setSoftInputMode(5);
    return;
    int i1 = this.X;
    if ((i1 == 3078) || (i1 == 3079))
    {
      localObject3 = a(false);
      localObject2 = getString(2131888921);
      localObject1 = localObject3;
      i1 = i2;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        if (!e())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(ContactUtils.a(this.app, this.app.getAccount()));
          localObject1 = ((StringBuilder)localObject1).toString();
          i1 = 1;
        }
        else
        {
          localObject1 = localObject2;
          i1 = i2;
        }
      }
      this.b.setHint("");
      this.b.setText((CharSequence)localObject1);
      if (i1 == 0) {}
    }
    try
    {
      this.b.setSelection(((String)localObject2).length(), ((String)localObject1).length());
    }
    catch (Throwable localThrowable2)
    {
      break label624;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.b.setSelection(((String)localObject1).length());
    }
    label624:
    getWindow().setSoftInputMode(5);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    Object localObject = this.aB;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.aF;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.aD;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.aE;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.aA;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
    localObject = this.aC;
    if (localObject != null) {
      addObserver((BusinessObserver)localObject);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    Object localObject = this.aB;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.aF;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.aD;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.aE;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.aA;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.aC;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION");
    localIntent.setPackage(getPackageName());
    localIntent.putExtra("ret_action", this.av);
    sendBroadcast(localIntent);
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.leftView.getWindowToken(), 0);
    getWindow().setSoftInputMode(2);
    super.finish();
    if (this.ab != 4) {
      overridePendingTransition(0, 2130772018);
    }
  }
  
  protected boolean onBackEvent()
  {
    g();
    Object localObject = getIntent();
    boolean bool = false;
    if (((Intent)localObject).getBooleanExtra("need_jumpto_splash", false))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.a);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      return super.onBackEvent();
    }
    if (this.ab != 4)
    {
      localObject = this.b.getText().toString();
      if (4 == this.ab) {
        bool = true;
      }
      a((String)localObject, bool);
      if ((getString(2131888921).equals(localObject)) && (!e())) {
        f();
      }
    }
    if (!TextUtils.isEmpty(this.w)) {
      ReportController.b(this.app, "dc00899", "Qidian", this.aa, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, 1, 2131892104, 0).show(getTitleBarHeight());
      localObject = this.R;
      if (localObject != null)
      {
        ((Switch)localObject).setChecked(paramBoolean ^ true);
        this.R.setOnClickListener(null);
      }
      localObject = this.T;
      if (localObject != null)
      {
        ((Switch)localObject).setChecked(paramBoolean ^ true);
        this.T.setOnClickListener(null);
      }
    }
    else
    {
      localObject = this.R;
      if (localObject != null) {
        ((Switch)localObject).setOnClickListener(this);
      }
      localObject = this.T;
      if (localObject != null) {
        ((Switch)localObject).setOnClickListener(this);
      }
      if (paramCompoundButton == this.R)
      {
        if (AppSetting.e) {
          this.Q.setContentDescription(getResources().getString(2131914894));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.aa);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.g = "QQ空间";
        localPluginParams.d = QzonePluginProxyActivity.getQZonePluginName();
        localPluginParams.c = this.app.getCurrentAccountUin();
        localPluginParams.h = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        localPluginParams.j = ((Intent)localObject);
        IPluginManager.b(this.app.getApp(), localPluginParams);
        ReportController.b(this.app, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
      }
      else if (paramCompoundButton == this.T)
      {
        this.U = paramBoolean;
      }
      localObject = paramCompoundButton.getTag();
      if (((localObject instanceof Integer)) && ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER) != null) && (this.o != null) && (((Integer)localObject).intValue() == 1)) {
        b(paramBoolean);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131444961)
    {
      Object localObject = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.aa).putExtra("mgid", (byte)this.V);
      ((Intent)localObject).putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult((Intent)localObject, 1002);
      localObject = this.b;
      if (localObject != null) {
        a(((EditText)localObject).getText().toString(), false);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131435831)
    {
      int i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 != 0)
      {
        if ((i1 != 1) && (i1 != 3)) {
          return false;
        }
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
      }
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity
 * JD-Core Version:    0.7.0.1
 */