package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.helper.TroopInfoActivityHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.photo.AvatarInfo;
import com.tencent.mobileqq.activity.photo.TroopAvatarController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.OnGotoBigPicListener;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUploadingTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerReq;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerRsp;
import com.tencent.pb.troop.bindgame.GCBindGroup.QQBindInfo;
import com.tencent.pb.troop.bindgame.GCBindGroup.QQGroupBind;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, TroopPhotoController.OnGotoBigPicListener, DecodeTaskCompletionListener
{
  public static String c;
  public int a;
  public long a;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopInfoActivity.1(this);
  Handler jdField_a_of_type_AndroidOsHandler = new TroopInfoActivity.20(this);
  protected View a;
  protected Button a;
  protected LinearLayout a;
  private TroopAvatarController jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController;
  private TroopPhotoController jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopInfoActivity.23(this);
  protected FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopInfoActivity.22(this);
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopInfoActivity.25(this);
  protected TroopHandler a;
  protected IFaceDecoder a;
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopInfoActivity.21(this);
  protected TroopInfo a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopInfoActivity.24(this);
  public TroopAvatarManger a;
  protected TroopInfoData a;
  protected QQProgressDialog a;
  protected XListView a;
  public String a;
  protected ArrayList<String> a;
  protected List<Integer> a;
  Observer jdField_a_of_type_JavaUtilObserver = new TroopInfoActivity.32(this);
  protected boolean a;
  protected View[] a;
  public int b;
  public long b;
  protected View b;
  protected String b;
  protected boolean b;
  public int c;
  protected long c;
  protected View c;
  protected boolean c;
  public int d;
  boolean d;
  public int e;
  public boolean e;
  protected int f;
  protected boolean f;
  private int g;
  public boolean g;
  private int h;
  public boolean h;
  protected boolean i = false;
  protected boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  
  static
  {
    jdField_c_of_type_JavaLangString = "key_from_upgrade_search_way";
  }
  
  public TroopInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
  }
  
  private void A()
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379133);
      if ((2 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) && (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)) {
        break label513;
      }
    }
    label513:
    for (int i1 = 1;; i1 = 0)
    {
      int n = i1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) {
        n = i1 | 0x2;
      }
      if (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
      {
        i1 = n;
        if (3 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {}
      }
      else
      {
        i1 = n | 0x4;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 2)
      {
        n = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 3) {}
      }
      else
      {
        n = i1 | 0x8;
      }
      i1 = n;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 1) {
        i1 = n | 0x10;
      }
      n = i1;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
        n = i1 | 0x20;
      }
      SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4);
      boolean bool = localSharedPreferences.getBoolean("has_shown_tips", false);
      if (a(n, 32)) {
        if (this.jdField_c_of_type_Int == 2) {
          n = 2131697518;
        }
      }
      for (;;)
      {
        if (n != 0)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          localTextView.setText(n);
          localTextView.setContentDescription(getString(n));
          return;
          if ((this.jdField_c_of_type_Int == 3) && (!bool))
          {
            n = 2131697519;
            localSharedPreferences.edit().putBoolean("has_shown_tips", true).commit();
            continue;
            if (a(n, 1))
            {
              if (a(n, 2))
              {
                if ((a(n, 4)) || (a(n, 8)) || (a(n, 16)))
                {
                  n = 2131697532;
                  continue;
                }
                n = 2131697531;
                continue;
              }
              if (a(n, 8))
              {
                n = 2131697525;
                continue;
              }
              if (a(n, 4))
              {
                n = 2131697524;
                continue;
              }
              n = 2131697523;
              continue;
            }
            if (a(n, 2))
            {
              if (a(n, 4))
              {
                n = 2131697530;
                continue;
              }
              if ((a(n, 8)) || (a(n, 16)))
              {
                n = 2131697529;
                continue;
              }
              n = 2131697528;
              continue;
            }
            if ((a(n, 8)) && (a(n, 4)))
            {
              n = 2131697520;
              continue;
            }
            if (a(n, 8))
            {
              n = 2131697522;
              continue;
            }
            if (a(n, 4)) {
              n = 2131697521;
            }
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        n = 0;
      }
    }
  }
  
  private void B()
  {
    startTitleProgress();
    TroopInfoActivityHelper.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new TroopInfoActivity.29(this));
  }
  
  private void C()
  {
    TroopInfoActivityHelper.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new TroopInfoActivity.30(this));
  }
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ImageUtil.c();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(this.app)) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, long paramLong1, short paramShort, String paramString6, String paramString7, int paramInt2, String paramString8, String paramString9, boolean paramBoolean, String paramString10, long paramLong2, long paramLong3, int paramInt3)
  {
    return TroopInfoUIUtil.a(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramByte, paramLong1, paramShort, paramString6, paramString7, paramInt2, paramString8, paramString9, paramBoolean, paramString10, paramLong2, paramLong3, paramInt3);
  }
  
  public static Bundle a(String paramString, int paramInt)
  {
    return TroopInfoUIUtil.a(paramString, "", paramInt);
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    return TroopInfoUIUtil.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2);
  }
  
  public static Bundle a(String paramString1, String paramString2, int paramInt)
  {
    return TroopInfoUIUtil.a(paramString1, paramString2, paramInt);
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextColor(getResources().getColor(2131167113));
    localTextView.setPadding(getResources().getDimensionPixelSize(2131299211), UIUtils.a(this, 20.0F), 0, UIUtils.a(this, 10.0F));
    localTextView.setFocusable(true);
    return localTextView;
  }
  
  /* Error */
  private String a(int paramInt)
  {
    // Byte code:
    //   0: new 397	org/json/JSONObject
    //   3: dup
    //   4: ldc_w 399
    //   7: invokespecial 402	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: ldc_w 404
    //   13: invokevirtual 408	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   16: ldc_w 410
    //   19: invokevirtual 414	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   22: astore 6
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc 102
    //   28: astore 4
    //   30: iload_2
    //   31: aload 6
    //   33: invokevirtual 420	org/json/JSONArray:length	()I
    //   36: if_icmpge +124 -> 160
    //   39: aload 6
    //   41: iload_2
    //   42: invokevirtual 423	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   45: astore 5
    //   47: iload_1
    //   48: aload 5
    //   50: ldc_w 425
    //   53: invokevirtual 429	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   56: if_icmpne +12 -> 68
    //   59: aload 5
    //   61: ldc_w 431
    //   64: invokevirtual 434	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: areturn
    //   68: aload 5
    //   70: ldc_w 436
    //   73: invokevirtual 414	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   76: astore 7
    //   78: iconst_0
    //   79: istore_3
    //   80: aload 4
    //   82: astore 5
    //   84: iload_3
    //   85: aload 7
    //   87: invokevirtual 420	org/json/JSONArray:length	()I
    //   90: if_icmpge +33 -> 123
    //   93: aload 7
    //   95: iload_3
    //   96: invokevirtual 423	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   99: astore 5
    //   101: iload_1
    //   102: aload 5
    //   104: ldc_w 425
    //   107: invokevirtual 429	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   110: if_icmpne +24 -> 134
    //   113: aload 5
    //   115: ldc_w 431
    //   118: invokevirtual 434	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 5
    //   123: iload_2
    //   124: iconst_1
    //   125: iadd
    //   126: istore_2
    //   127: aload 5
    //   129: astore 4
    //   131: goto -101 -> 30
    //   134: iload_3
    //   135: iconst_1
    //   136: iadd
    //   137: istore_3
    //   138: goto -58 -> 80
    //   141: astore 5
    //   143: ldc 102
    //   145: astore 4
    //   147: aload 5
    //   149: invokevirtual 439	org/json/JSONException:printStackTrace	()V
    //   152: aload 4
    //   154: areturn
    //   155: astore 5
    //   157: goto -10 -> 147
    //   160: aload 4
    //   162: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	TroopInfoActivity
    //   0	163	1	paramInt	int
    //   25	102	2	n	int
    //   79	59	3	i1	int
    //   28	133	4	localObject1	Object
    //   45	83	5	localObject2	Object
    //   141	7	5	localJSONException1	org.json.JSONException
    //   155	1	5	localJSONException2	org.json.JSONException
    //   22	18	6	localJSONArray1	org.json.JSONArray
    //   76	18	7	localJSONArray2	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   0	24	141	org/json/JSONException
    //   30	68	155	org/json/JSONException
    //   68	78	155	org/json/JSONException
    //   84	123	155	org/json/JSONException
  }
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      int n = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId;
      double d1 = paramInt1 / 1000000.0D;
      double d2 = paramInt2 / 1000000.0D;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      paramString = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(n), Double.valueOf(d1), Double.valueOf(d2), str });
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.troopinfo.troop.location_info", 2, "initCurrentLocationStruct==>locationStruct:" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public static ArrayList<String> a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    int i1 = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    Object localObject = Long.toString(paramTroopInfoData.dwGroupClassExt);
    paramContext = GroupCatalogTool.a(paramContext).a(paramContext, (String)localObject);
    if (!TextUtils.isEmpty(paramTroopInfoData.mTroopClassExtText)) {
      paramContext = paramTroopInfoData.mTroopClassExtText;
    }
    for (;;)
    {
      localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramContext)) {
        ((ArrayList)localObject).add(paramContext);
      }
      for (int n = 1;; n = 0)
      {
        if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
        {
          int i2 = paramTroopInfoData.troopTags.size();
          for (;;)
          {
            if (i1 < i2)
            {
              if ((n == 0) || (!((String)paramTroopInfoData.troopTags.get(i1)).equals(paramContext))) {
                ((ArrayList)localObject).add(paramTroopInfoData.troopTags.get(i1));
              }
              i1 += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString))) {
                break label203;
              }
              if (paramContext.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131715310)))
              {
                paramContext = "";
                break;
              }
              paramContext = paramContext.jdField_a_of_type_JavaLangString;
              break;
            }
          }
        }
        return localObject;
      }
      label203:
      paramContext = "";
    }
  }
  
  private void a(int paramInt, View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner))
    {
      paramView = paramView.findViewById(2131376824);
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        TroopUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt, false);
        b(paramInt, false);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) && (!this.j) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop))
    {
      int i1 = 1;
      int n = i1;
      if (paramInt == 8)
      {
        n = i1;
        if (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
          n = 0;
        }
      }
      if ((n != 0) && (TroopUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt))) {
        b(paramInt, paramBoolean);
      }
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755842);
    localReportDialog.setContentView(2131561170);
    ((TextView)localReportDialog.findViewById(2131365845)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365832);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365830);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365836);
    localTextView1.setText(String.format(getString(2131693401), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694615);
    localTextView3.setText(2131693381);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new TroopInfoActivity.15(this, localReportDialog, paramLong1, paramInt2, paramLong2, paramLong3, paramString));
    localTextView3.setOnClickListener(new TroopInfoActivity.16(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramContext.toString());
    }
  }
  
  private void a(XListView paramXListView)
  {
    if (paramXListView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView = super.getLayoutInflater().inflate(2131560742, paramXListView, false);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379406);
    ((ImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364815)).setOnClickListener(new TroopInfoActivity.28(this, paramXListView));
    paramXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    l();
    String str2;
    label38:
    label50:
    String str1;
    if (!paramBoolean)
    {
      QQAppInterface localQQAppInterface;
      if (!TextUtils.isEmpty(paramString))
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label296;
        }
        str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.j) {
          break label303;
        }
        localObject = "2";
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)) {
          break label319;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          break label311;
        }
        str1 = "1";
      }
      for (;;)
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, str2, (String)localObject, str1, "");
        QQToast.a(this, 1, paramString, 1).b(getTitleBarHeight());
        if (paramBoolean)
        {
          ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(TroopNotificationConstants.bh, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
          this.m = true;
          finish();
        }
        return;
        switch ((int)paramLong1)
        {
        default: 
          paramString = getString(2131693396);
          break;
        case 1281: 
          paramString = getString(2131693397);
          break;
        case 1282: 
          paramString = getString(2131693398);
          break;
        case 1283: 
          paramString = getString(2131693399);
          break;
        case 1793: 
          paramString = getString(2131693400);
          break;
          label296:
          str2 = "";
          break label38;
          label303:
          localObject = "1";
          break label50;
          label311:
          str1 = "2";
          continue;
          label319:
          str1 = "0";
        }
      }
    }
    Object localObject = this.app;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      label349:
      if (!this.j) {
        break label460;
      }
      str2 = "2";
      label361:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)) {
        break label476;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        break label468;
      }
      paramString = "1";
    }
    for (;;)
    {
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, str1, str2, paramString, "");
      if (this.j) {
        break;
      }
      QQToast.a(this, 2, getString(2131693403), 1).b(getTitleBarHeight());
      break;
      str1 = "";
      break label349;
      label460:
      str2 = "1";
      break label361;
      label468:
      paramString = "2";
      continue;
      label476:
      paramString = "0";
    }
  }
  
  private String b()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
      return getString(2131697513);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
      return getString(2131697511);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      return getString(2131697512);
    }
    if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "3", "", "");
      return getString(2131697510);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131697509);
    }
    return "";
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int n = 8;
    View localView;
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
      if (localObject != null)
      {
        localView = ((View)localObject).findViewById(2131376824);
        if (paramInt != 8) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = ((View)localObject).findViewById(2131379099);; localObject = ((View)localObject).findViewById(2131365294))
    {
      if (localView != null)
      {
        paramInt = n;
        if (paramBoolean) {
          paramInt = 0;
        }
        localView.setVisibility(paramInt);
      }
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        n = getResources().getDimensionPixelSize(2131298547);
        paramInt = n;
        if (paramBoolean) {
          paramInt = n * 2;
        }
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt;
      }
      return;
    }
  }
  
  private void c(int paramInt)
  {
    boolean bool;
    String str1;
    if (paramInt == 11)
    {
      paramInt = 1;
      if ((!QVipBigTroopExpiredProcessor.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
        break label192;
      }
      bool = TroopManager.LiangGroupHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label184;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!bool) {
        break label166;
      }
      paramInt = 15;
      label75:
      String str2 = VipUtils.a(0, paramInt).toString();
      String str3 = HardCodeUtil.a(2131715312);
      TroopInfoActivity.19 local19 = new TroopInfoActivity.19(this, bool);
      if (!bool) {
        break label172;
      }
      localObject = "0X800A57F";
      label112:
      if (!bool) {
        break label179;
      }
      paramInt = 1;
      label118:
      VipUtils.a(this, str1, str2, str3, local19, (String)localObject, paramInt, bool);
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
      return;
      paramInt = 0;
      break;
      label166:
      paramInt = 8;
      break label75;
      label172:
      localObject = "0X8009E38";
      break label112;
      label179:
      paramInt = 2;
      break label118;
      label184:
      VipUtils.a(this, bool);
    }
    label192:
    Object localObject = new Bundle();
    if (paramInt == 0)
    {
      bool = true;
      ((Bundle)localObject).putBoolean("IS_COVER", bool);
      ((Bundle)localObject).putBoolean("IS_EDIT", true);
      gotoBigPic((Bundle)localObject);
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label319;
      }
    }
    label319:
    for (localObject = "1";; localObject = "0")
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { str1, localObject });
      return;
      bool = false;
      break;
    }
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    View localView;
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
      if (localView != null)
      {
        localView = localView.findViewById(2131376823);
        if (localView != null) {
          if (!paramBoolean) {
            break label44;
          }
        }
      }
    }
    label44:
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      return;
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null) {
        break label105;
      }
    }
    label105:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        if ((paramInt & 0x2) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
          y();
        }
        if ((paramInt & 0x20) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo;
          a(6, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        }
      }
      return;
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.jdField_c_of_type_Long != 0L))
    {
      e();
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
    {
    default: 
      return;
    case 0: 
    case 1: 
      k();
      return;
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long) && (this.jdField_b_of_type_Int == 0))
    {
      localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setTitle(null);
      ((QQCustomDialog)localObject).setMessage(getString(2131693386, new Object[] { this.jdField_a_of_type_Long + "" }));
      ((QQCustomDialog)localObject).setPositiveButton(getString(2131693384), new DialogUtil.DialogOnClickAdapter());
      ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131693384));
      ((QQCustomDialog)localObject).show();
      return;
    }
    Object localObject = b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      a((String)localObject);
      return;
    }
    u();
  }
  
  private void s()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label125;
      }
      SpannableString localSpannableString = new SpannableString("[Avatar]");
      Drawable localDrawable = a();
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, ScreenUtil.dip2px(32.0F), ScreenUtil.dip2px(32.0F));
        localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
        a(11, 2, localView, getString(2131699355), localSpannableString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        a(11, false);
      }
    }
    while (this.j)
    {
      c(11, true);
      return;
      label125:
      a(11, 2, localView, getString(2131699355), HardCodeUtil.a(2131715309), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(11, true);
    }
    c(11, false);
  }
  
  private void t()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    ArrayList localArrayList = new ArrayList();
    TroopPhotoUtil.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
    if (localArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "updateCoverEntry infoList is empty.");
      }
      a(12, 2, localView, getString(2131720322), HardCodeUtil.a(2131715313), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(12, true);
    }
    for (;;)
    {
      localView.setTag(2131720322, Integer.valueOf(localArrayList.size()));
      return;
      Object localObject1 = (AvatarInfo)localArrayList.get(0);
      localObject3 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      String str = ((ITroopAvatarUtilApi)localObject3).getArtWork(((ITroopAvatarUtilApi)localObject3).getAvatarAddress(((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1));
      URLDrawable localURLDrawable = null;
      localObject1 = null;
      int n = ScreenUtil.dip2px(30.0F);
      localObject3 = localURLDrawable;
      try
      {
        URL localURL = TroopPhotoUtil.a(str);
        if (localURL != null)
        {
          localObject3 = localURLDrawable;
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = n;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = n;
          localObject3 = localURLDrawable;
          localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject1);
          localObject3 = localURLDrawable;
          localURLDrawable.setTag(new int[] { n, n, 0 });
          localObject3 = localURLDrawable;
          localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.d);
          localObject1 = localURLDrawable;
          localObject3 = localURLDrawable;
          if (localURLDrawable.getStatus() != 1)
          {
            localObject3 = localURLDrawable;
            localURLDrawable.setURLDrawableListener(new TroopInfoActivity.5(this));
            localObject1 = localURLDrawable;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = localObject3;
          continue;
          boolean bool = false;
        }
      }
      if (QLog.isColorLevel())
      {
        if (localObject1 == null) {
          break;
        }
        bool = true;
        QLog.i("Q.troopinfo", 2, String.format("updateCoverEntry ud!=null?%b path=%s", new Object[] { Boolean.valueOf(bool), str }));
      }
      localObject3 = null;
      if (localObject1 != null)
      {
        localObject3 = new SpannableString("[Avatar]");
        ((URLDrawable)localObject1).setBounds(0, 0, n, n);
        ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject1, 0), 0, ((SpannableString)localObject3).length(), 17);
      }
      a(12, 2, localView, getString(2131720322), (CharSequence)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(12, false);
    }
  }
  
  private void u()
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setTitle(null);
      long l2 = this.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      ((QQCustomDialog)localObject).setMessage(getString(2131693404, new Object[] { l1 + "" }));
      ((QQCustomDialog)localObject).setNegativeButton(getString(2131693384), new TroopInfoActivity.9(this));
      ((QQCustomDialog)localObject).setPositiveButton(getString(2131693331), new TroopInfoActivity.10(this));
      ((QQCustomDialog)localObject).show();
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (localObject = "0";; localObject = "1")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_exp", 0, 0, str, (String)localObject, "", "");
        return;
      }
    }
    k();
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, setLastActivityName(), null));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, setLastActivityName(), null), 8);
      return;
    }
    a(2131720199, 1);
  }
  
  private void w()
  {
    Object localObject = this.app.getCurrentAccountUin();
    int n;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin).equals(localObject)) {
      n = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, n);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) {
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      ((ProfileActivity.AllInOne)localObject).d = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      if (n == 21) {
        ((ProfileActivity.AllInOne)localObject).l = 11;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
      {
        if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
        {
          n = 20;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          n = 21;
          continue;
        }
      }
      n = 19;
    }
  }
  
  private void x()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev4/classinfo?gc=%1$s&from=%2$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, HWTroopUtils.d }));
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult(localIntent, 19);
  }
  
  private void y()
  {
    ThreadManager.post(new TroopInfoActivity.26(this), 5, null, true);
  }
  
  private void z()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.post(new TroopInfoActivity.27(this), 5, null, true);
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {
      return getString(2131697527);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      return getString(2131697526);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2) {
      return getString(2131697513);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15) {
      return getString(2131697512);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131697509);
    }
    return "";
  }
  
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    View localView = View.inflate(this, 2131561696, null);
    Object localObject1 = (ListView)localView.findViewById(2131364214);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(HardCodeUtil.a(2131715307));
    ((ArrayList)localObject2).add(HardCodeUtil.a(2131715306));
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365157));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[14];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
    localObject1 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838979);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setClickable(false);
    this.jdField_a_of_type_Boolean = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopinfo", 2, "mIsQidianPrivateTroop : " + this.jdField_a_of_type_Boolean + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    super.setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (this.j) {
        localObject1 = getString(2131720291);
      }
    }
    else
    {
      setTitle((CharSequence)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
      {
        localObject1 = View.inflate(this, 2131561702, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        a(7, 0, (View)localObject1, getString(2131693322), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
        localObject1 = View.inflate(this, 2131561722, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      if (this.j)
      {
        localObject1 = a(HardCodeUtil.a(2131720245));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject1 = View.inflate(this, 2131561702, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      ((View)localObject1).setTag(Integer.valueOf(10));
      a(10, 2, (View)localObject1, getString(2131691870), "", true);
      c();
      a((View)localObject1);
      localObject1 = View.inflate(this, 2131561702, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[11] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      s();
      ((View)localObject1).setOnClickListener(this);
      if (this.j)
      {
        localObject1 = a(HardCodeUtil.a(2131720070));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject1 = View.inflate(this, 2131561702, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      t();
      ((View)localObject1).setOnClickListener(this);
      localObject1 = View.inflate(this, 2131561702, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(5, 2, (View)localObject1, getString(2131720323), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      m();
      localObject1 = View.inflate(this, 2131561702, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(4, 2, (View)localObject1, getString(2131720071), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop())
      {
        localObject1 = View.inflate(this, 2131561702, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).setTag(Integer.valueOf(13));
        a(13, 2, (View)localObject1, getString(2131720072), "", true);
        b();
      }
      localObject1 = View.inflate(this, 2131561701, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(8, 3, (View)localObject1, getString(2131720073), null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim(), 1);
      if (this.j) {
        ((View)localObject1).setBackgroundResource(2130839585);
      }
      ThreadManager.post(new TroopInfoActivity.2(this), 8, null, true);
      if (!this.j)
      {
        localObject1 = View.inflate(this, 2131561722, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject2 = View.inflate(this, 2131561709, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label1191;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      label948:
      a(6, 3, (View)localObject2, getString(2131693434), (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      if (!this.j)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.mDensity));
        localObject2 = View.inflate(this, 2131561722, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363973);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363891));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label1214;
      }
      if (!this.j) {
        break label1205;
      }
      b(18);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.j)
      {
        this.leftView.setText("取消");
        this.leftView.setBackgroundDrawable(null);
        this.leftView.setPadding(0, 5, 52, 5);
      }
      this.leftView.setOnClickListener(new TroopInfoActivity.3(this));
      this.rightViewText.setOnClickListener(new TroopInfoActivity.4(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
      }
      return;
      localObject1 = getString(2131720182);
      break;
      label1191:
      localObject1 = getResources().getString(2131696146);
      break label948;
      label1205:
      b(14);
      continue;
      label1214:
      b(15);
    }
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(getString(2131693391), new TroopInfoActivity.11(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131693391));
    localQQCustomDialog.setNegativeButton(getString(2131693331), new DialogUtil.DialogOnClickAdapter());
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131693331));
    localQQCustomDialog.show();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    label48:
    TextView localTextView2;
    View localView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        TextView localTextView1 = (TextView)paramView.findViewById(2131379432);
        localTextView2 = (TextView)paramView.findViewById(2131369051);
        localView = paramView.findViewById(2131363027);
        paramView = paramString;
        if (paramString == null) {
          paramView = "";
        }
        localTextView1.setText(paramView);
        if (6 == paramInt1)
        {
          localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
          if (TextUtils.isEmpty(paramCharSequence))
          {
            localTextView2.setVisibility(8);
            label127:
            if (!paramBoolean) {
              break label231;
            }
          }
        }
        break;
      }
    }
    label231:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130839575);
      break label48;
      paramView.setBackgroundResource(2130839591);
      break label48;
      paramView.setBackgroundResource(2130839585);
      break label48;
      paramView.setBackgroundResource(2130839582);
      break label48;
      localTextView2.setVisibility(0);
      localTextView2.setText(new QQText(paramCharSequence, 11, 20));
      break label127;
      localTextView2.setText(paramCharSequence);
      break label127;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "initClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayOfString + ", bShowArrow = " + paramBoolean);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131379432);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131363027);
    if (paramBoolean)
    {
      paramInt3 = 0;
      label104:
      paramString.setVisibility(paramInt3);
      if (!paramBoolean) {
        break label168;
      }
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return;
        paramInt3 = 8;
        break label104;
        label168:
        paramView.setTag(null);
        paramView.setOnClickListener(null);
      }
    }
    paramView.setBackgroundResource(2130839575);
    return;
    paramView.setBackgroundResource(2130839591);
    return;
    paramView.setBackgroundResource(2130839585);
    return;
    paramView.setBackgroundResource(2130839582);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateDefaultItemView(), tag = " + paramInt + ", info = " + paramString + ", bShowArrow = " + paramBoolean);
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];; localView1 = null)
    {
      TextView localTextView;
      View localView2;
      if (localView1 != null)
      {
        localTextView = (TextView)localView1.findViewById(2131369051);
        localView2 = localView1.findViewById(2131363027);
        if (paramInt != 6) {
          break label189;
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label163;
        }
        localTextView.setVisibility(8);
      }
      for (;;)
      {
        a(paramInt, TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo));
        if (!paramBoolean) {
          break;
        }
        localView1.setTag(Integer.valueOf(paramInt));
        localView1.setOnClickListener(this);
        localView2.setVisibility(0);
        return;
        label163:
        localTextView.setVisibility(0);
        localTextView.setText(new QQText(paramString, 11, 20));
      }
      label189:
      String str = paramString;
      if (paramInt == 4)
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label228;
        }
        str = HardCodeUtil.a(2131715315);
        a(paramInt, true);
      }
      for (;;)
      {
        localTextView.setText(str);
        break;
        label228:
        a(paramInt, false);
        str = paramString;
      }
      localView1.setTag(null);
      localView1.setOnClickListener(null);
      localView2.setVisibility(8);
      return;
    }
  }
  
  protected void a(int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1];; localView = null)
    {
      LinearLayout localLinearLayout;
      Object localObject1;
      Object localObject2;
      if (localView != null)
      {
        localLinearLayout = (LinearLayout)localView.findViewById(2131364866);
        localLinearLayout.removeAllViews();
        localObject1 = (LinearLayout)localView.findViewById(2131379099);
        localObject2 = (TextView)localView.findViewById(2131369051);
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          localLinearLayout.setVisibility(8);
          ((TextView)localObject2).setText(HardCodeUtil.a(2131715316));
          a(paramInt1, true);
        }
      }
      else
      {
        return;
      }
      a(paramInt1, false);
      ((LinearLayout)localObject1).setVisibility(8);
      localLinearLayout.setVisibility(0);
      int i1 = 0;
      while ((i1 < paramArrayList.size()) && (i1 < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(i1)))
        {
          i1 += 1;
        }
        else
        {
          localObject1 = new TextView(this);
          ((TextView)localObject1).setId(2131374334);
          int n = 2130844078;
          if (paramInt2 == 1) {
            n = 2130844080;
          }
          for (;;)
          {
            localObject2 = getResources().getDrawable(n);
            ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject2);
            ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
            ((TextView)localObject1).setTextSize(2, 15.0F);
            if (paramBoolean2) {
              ((TextView)localObject1).setMaxWidth(AIOUtils.a(77.0F, getResources()));
            }
            ((TextView)localObject1).setSingleLine();
            ((TextView)localObject1).setTextColor(getResources().getColor(2131167197));
            ((TextView)localObject1).setPadding(AIOUtils.a(6.0F, getResources()), AIOUtils.a(2.0F, getResources()), AIOUtils.a(8.0F, getResources()), AIOUtils.a(2.0F, getResources()));
            ((TextView)localObject1).setGravity(17);
            ((TextView)localObject1).setText((CharSequence)paramArrayList.get(i1));
            ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(5.0F, getResources());
            localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break;
            if (paramInt2 == 2) {
              n = 2130844078;
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131363027);
      if (paramBoolean1)
      {
        localView.setTag(Integer.valueOf(paramInt1));
        localView.setOnClickListener(this);
        paramArrayList.setVisibility(0);
        return;
      }
      localView.setTag(null);
      localView.setOnClickListener(null);
      paramArrayList.setVisibility(8);
      return;
    }
  }
  
  protected void a(View paramView)
  {
    if (paramView == null) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)paramView.findViewById(2131379432);
      paramView = (LinearLayout)paramView.findViewById(2131365294);
    } while ((localTextView == null) || (paramView == null) || (TextUtils.isEmpty(localTextView.getText())));
    int n = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (this.j)
    {
      paramView.leftMargin = (AIOUtils.a(100.0F, getResources()) + n);
      return;
    }
    paramView.leftMargin = (AIOUtils.a(90.0F, getResources()) + n);
  }
  
  public void a(GCBindGroup.GCBindGroupSsoServerRsp paramGCBindGroupSsoServerRsp)
  {
    int n = paramGCBindGroupSsoServerRsp.ret.get();
    Object localObject = null;
    if (n == -3000005) {
      this.jdField_f_of_type_Int = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopinfo", 2, "onGetGameBindStatus ret=" + n + ", status=" + this.jdField_f_of_type_Int + ", name=" + (String)localObject);
      }
      return;
      if (n == 0)
      {
        paramGCBindGroupSsoServerRsp = paramGCBindGroupSsoServerRsp.bind_info.app_name.get();
        localObject = paramGCBindGroupSsoServerRsp;
        if (!TextUtils.isEmpty(paramGCBindGroupSsoServerRsp))
        {
          this.jdField_f_of_type_Int = 1;
          localObject = paramGCBindGroupSsoServerRsp;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    QQToast.a(this, paramString, 0).a();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  protected void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null)
    {
      if (paramGroupInfo.string_group_name.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramGroupInfo.string_group_name.get().toStringUtf8();
      }
      Object localObject1;
      if (paramGroupInfo.group_geo_info.has())
      {
        localObject1 = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get());
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get());
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
      }
      if (paramGroupInfo.uint32_group_class_ext.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
      }
      if ((paramGroupInfo.rpt_tag_record.has()) && (paramGroupInfo.rpt_tag_record.size() > 0))
      {
        Object localObject2 = paramGroupInfo.rpt_tag_record.get();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((oidb_0x88d.TagRecord)((Iterator)localObject2).next()).bytes_tag_value.get().toStringUtf8());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = ((List)localObject1);
      }
      if (paramGroupInfo.string_group_finger_memo.has()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      y();
      c();
      b();
    }
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "checkParams");
    }
    for (;;)
    {
      try
      {
        Object localObject = getIntent().getExtras();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = ((Bundle)localObject).getString("troop_uin");
        if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) <= 0L) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa = ((Bundle)localObject).getInt("troop_info_from");
        this.jdField_g_of_type_Int = ((Bundle)localObject).getInt("troop_info_report_from", -1);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption = ((Bundle)localObject).getInt("troop_info_from_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark = ((Bundle)localObject).getString("param_return_addr");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = ((Bundle)localObject).getBoolean("troop_info_is_member");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopface = ((Bundle)localObject).getShort("troop_info_faceid");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = ((Bundle)localObject).getString("troop_info_name");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin = ((Bundle)localObject).getString("troop_info_owner");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = ((Bundle)localObject).getLong("troop_info_classext");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = ((Bundle)localObject).getString("troop_info_loca");
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = ((Bundle)localObject).getInt("troop_info_lat", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = ((Bundle)localObject).getInt("troop_info_lon", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId = ((Bundle)localObject).getInt("troop_info_cityid", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.currentTroopLocationStruct = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = ((Bundle)localObject).getString("troop_info_fingermemo");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location = ((Bundle)localObject).getString("troop_info_school_location");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.school = ((Bundle)localObject).getString("troop_info_school_schoolid");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.grade = ((Bundle)localObject).getInt("troop_info_school_grade");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)((Bundle)localObject).getByte("troop_info_opt"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = TroopSystemMsgUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = TroopSystemMsgUtil.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM");
        this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("troop_auth_submit_time");
        this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("PARAM_EXIT_ANIMATION", 0);
        this.j = ((Bundle)localObject).getBoolean(jdField_c_of_type_JavaLangString, false);
        localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo((TroopInfo)localObject, this.app.getCurrentAccountUin());
            bool1 = true;
          }
        }
      }
      catch (Exception localException2)
      {
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          this.jdField_b_of_type_JavaLangString = "0";
          bool2 = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopinfo", 2, String.format("checkParams troopUin: %s, classExt: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt) }));
          }
          return bool2;
          if (QLog.isColorLevel()) {
            QLog.e("Q.troopinfo", 2, "can't find troop info of :" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
          bool1 = false;
          continue;
        }
        bool2 = bool1;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          continue;
        }
        this.jdField_b_of_type_JavaLangString = "1";
        bool2 = bool1;
        continue;
        bool2 = bool1;
      }
      catch (Exception localException1) {}
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopinfo", 2, localException1.toString());
        bool2 = bool1;
      }
    }
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  protected void b()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    String str;
    if (localView != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location)) {
        break label130;
      }
      str = HardCodeUtil.a(2131707350);
      ReportController.b(this.app, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      ((TextView)localView.findViewById(2131369051)).setText(str);
      if (!str.equals(HardCodeUtil.a(2131707350))) {
        break label181;
      }
      a(13, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("updateTroopClassInfoEntry %s", new Object[] { str }));
      }
      return;
      label130:
      str = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.grade);
      ReportController.b(this.app, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
      break;
      label181:
      a(13, false);
    }
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    case 17: 
    default: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    case 14: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setEnabled(true);
      this.rightViewText.setText(2131693410);
      return;
    case 15: 
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693557);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(15));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131720270);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(18));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.addRule(12, 0);
    localLayoutParams.setMargins(0, 76, 0, 0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  protected void b(String paramString)
  {
    l();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new TroopInfoActivity.17(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    String str;
    if (localObject != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
        break label112;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      localObject = (TextView)((View)localObject).findViewById(2131369051);
      if (localObject != null) {
        ((TextView)localObject).setText(str);
      }
      if (!str.equals(HardCodeUtil.a(2131701834))) {
        break label122;
      }
      a(10, true);
      label70:
      if (!this.j) {
        break label132;
      }
      c(10, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("updateTroopNameEntry %s", new Object[] { str }));
      }
      return;
      label112:
      str = HardCodeUtil.a(2131701834);
      break;
      label122:
      a(10, false);
      break label70;
      label132:
      c(10, false);
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
      }
      ThreadManager.post(new TroopInfoActivity.6(this), 5, null, false);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  /* Error */
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 632
    //   9: iconst_2
    //   10: new 480	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1918
    //   20: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc_w 1920
    //   30: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 1922
    //   40: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_3
    //   44: invokevirtual 1473	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 635	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iconst_m1
    //   54: iload_2
    //   55: if_icmpne +85 -> 140
    //   58: iload_1
    //   59: lookupswitch	default:+81->140, 5:+476->535, 7:+138->197, 8:+763->822, 9:+942->1001, 11:+672->731, 16:+209->268, 18:+1098->1157, 19:+569->628, 257:+1057->1116
    //   141: sipush 258
    //   144: if_icmpne +1204 -> 1348
    //   147: aload_3
    //   148: ifnull +44 -> 192
    //   151: aload_3
    //   152: ldc_w 1924
    //   155: invokevirtual 1928	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   158: astore_3
    //   159: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +30 -> 192
    //   165: aload_3
    //   166: ifnonnull +1169 -> 1335
    //   169: aconst_null
    //   170: astore_3
    //   171: ldc_w 632
    //   174: iconst_2
    //   175: ldc_w 1930
    //   178: iconst_1
    //   179: anewarray 455	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_3
    //   185: aastore
    //   186: invokestatic 471	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   189: invokestatic 635	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_0
    //   193: invokespecial 799	com/tencent/mobileqq/activity/TroopInfoActivity:t	()V
    //   196: return
    //   197: aload_3
    //   198: ifnull -58 -> 140
    //   201: aload_3
    //   202: invokevirtual 1328	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   205: ifnull -65 -> 140
    //   208: aload_3
    //   209: invokevirtual 1328	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   212: astore 10
    //   214: aload_0
    //   215: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   218: aload 10
    //   220: ldc_w 1931
    //   223: invokevirtual 1331	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: putfield 761	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   229: aload_0
    //   230: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   233: aload 10
    //   235: ldc_w 1933
    //   238: iconst_0
    //   239: invokevirtual 1727	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   242: putfield 1650	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLat	I
    //   245: aload_0
    //   246: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   249: aload 10
    //   251: ldc_w 1935
    //   254: iconst_0
    //   255: invokevirtual 1727	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   258: putfield 1656	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLon	I
    //   261: aload_0
    //   262: invokevirtual 1357	com/tencent/mobileqq/activity/TroopInfoActivity:m	()V
    //   265: goto -125 -> 140
    //   268: aload_3
    //   269: ifnull -129 -> 140
    //   272: aload_3
    //   273: invokevirtual 1328	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   276: ifnull -136 -> 140
    //   279: aload_3
    //   280: invokevirtual 1328	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   283: astore 10
    //   285: aload_0
    //   286: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   289: getfield 761	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   292: aload 10
    //   294: ldc_w 1931
    //   297: invokevirtual 1331	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   300: invokestatic 1940	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   303: ifne +8 -> 311
    //   306: aload_0
    //   307: iconst_1
    //   308: putfield 84	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_g_of_type_Boolean	Z
    //   311: aload_0
    //   312: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   315: aload 10
    //   317: ldc_w 1942
    //   320: invokevirtual 1331	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   323: putfield 1775	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   326: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +36 -> 365
    //   332: ldc_w 478
    //   335: iconst_2
    //   336: new 480	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 1944
    //   346: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_0
    //   350: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   353: getfield 1775	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   356: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 1837	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload_0
    //   366: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   369: getfield 1775	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   372: invokestatic 451	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +39 -> 414
    //   378: aload_0
    //   379: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: getfield 1775	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   385: ldc_w 1946
    //   388: invokevirtual 1950	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   391: astore 11
    //   393: aload 11
    //   395: arraylength
    //   396: iconst_5
    //   397: if_icmplt +96 -> 493
    //   400: aload_0
    //   401: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   404: aload 11
    //   406: iconst_4
    //   407: aaload
    //   408: invokestatic 1716	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   411: putfield 1953	com/tencent/mobileqq/troopinfo/TroopInfoData:mPoiId	J
    //   414: aload_0
    //   415: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   418: aload 10
    //   420: ldc_w 1931
    //   423: invokevirtual 1331	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 761	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   429: aload_0
    //   430: invokevirtual 1357	com/tencent/mobileqq/activity/TroopInfoActivity:m	()V
    //   433: goto -293 -> 140
    //   436: astore 12
    //   438: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq -27 -> 414
    //   444: ldc_w 632
    //   447: iconst_2
    //   448: new 480	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 1955
    //   458: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 11
    //   463: iconst_4
    //   464: aaload
    //   465: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc_w 1957
    //   471: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_0
    //   475: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   478: getfield 1775	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   481: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 1837	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: goto -76 -> 414
    //   493: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq -82 -> 414
    //   499: ldc_w 632
    //   502: iconst_2
    //   503: new 480	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 1959
    //   513: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   520: getfield 1775	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   523: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 1961	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: goto -118 -> 414
    //   535: aload_3
    //   536: ldc_w 1963
    //   539: invokevirtual 1966	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   542: astore 10
    //   544: aload 10
    //   546: aload_0
    //   547: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   550: getfield 765	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   553: invokestatic 1969	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   556: ifne -416 -> 140
    //   559: aload_0
    //   560: iconst_1
    //   561: putfield 84	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_g_of_type_Boolean	Z
    //   564: aload_0
    //   565: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   568: aload 10
    //   570: putfield 765	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   577: getfield 765	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   580: invokestatic 451	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifne +30 -> 613
    //   586: aload_0
    //   587: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   590: getfield 765	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   593: astore 10
    //   595: aload_0
    //   596: bipush 6
    //   598: aload 10
    //   600: aload_0
    //   601: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   604: invokevirtual 815	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   607: invokevirtual 912	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILjava/lang/String;Z)V
    //   610: goto -470 -> 140
    //   613: aload_0
    //   614: invokevirtual 364	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   617: ldc_w 1423
    //   620: invokevirtual 1424	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   623: astore 10
    //   625: goto -30 -> 595
    //   628: aload_3
    //   629: ifnull -489 -> 140
    //   632: iload_2
    //   633: iconst_m1
    //   634: if_icmpne -494 -> 140
    //   637: aload_3
    //   638: ldc_w 1971
    //   641: invokevirtual 1966	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   644: astore 10
    //   646: new 397	org/json/JSONObject
    //   649: dup
    //   650: aload 10
    //   652: invokespecial 402	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   655: astore 10
    //   657: aload 10
    //   659: ldc_w 1931
    //   662: invokevirtual 408	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   665: astore 11
    //   667: aload_0
    //   668: iconst_1
    //   669: putfield 84	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_g_of_type_Boolean	Z
    //   672: aload_0
    //   673: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   676: aload 10
    //   678: ldc_w 1972
    //   681: invokevirtual 1975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   684: putfield 1792	com/tencent/mobileqq/troopinfo/TroopInfoData:grade	I
    //   687: aload_0
    //   688: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   691: aload 11
    //   693: invokevirtual 1976	org/json/JSONObject:toString	()Ljava/lang/String;
    //   696: putfield 1782	com/tencent/mobileqq/troopinfo/TroopInfoData:location	Ljava/lang/String;
    //   699: aload_0
    //   700: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   703: aload 10
    //   705: ldc_w 1977
    //   708: invokevirtual 434	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   711: putfield 1787	com/tencent/mobileqq/troopinfo/TroopInfoData:school	Ljava/lang/String;
    //   714: aload_0
    //   715: invokevirtual 1367	com/tencent/mobileqq/activity/TroopInfoActivity:b	()V
    //   718: goto -578 -> 140
    //   721: astore 10
    //   723: aload 10
    //   725: invokevirtual 439	org/json/JSONException:printStackTrace	()V
    //   728: goto -14 -> 714
    //   731: ldc2_w 1978
    //   734: lstore 7
    //   736: aload_3
    //   737: ldc_w 425
    //   740: invokevirtual 1966	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   743: invokestatic 1716	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   746: lstore 5
    //   748: aload_0
    //   749: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   752: getfield 498	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   755: lload 5
    //   757: lcmp
    //   758: ifeq -618 -> 140
    //   761: lload 5
    //   763: ldc2_w 1978
    //   766: lcmp
    //   767: ifeq -627 -> 140
    //   770: aload_0
    //   771: iconst_1
    //   772: putfield 84	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_g_of_type_Boolean	Z
    //   775: aload_0
    //   776: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   779: lload 5
    //   781: putfield 498	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   784: aload_0
    //   785: invokespecial 906	com/tencent/mobileqq/activity/TroopInfoActivity:y	()V
    //   788: goto -648 -> 140
    //   791: astore 10
    //   793: lload 7
    //   795: lstore 5
    //   797: invokestatic 476	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   800: ifeq -52 -> 748
    //   803: ldc_w 632
    //   806: iconst_2
    //   807: aload 10
    //   809: invokevirtual 633	java/lang/Exception:toString	()Ljava/lang/String;
    //   812: invokestatic 635	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: lload 7
    //   817: lstore 5
    //   819: goto -71 -> 748
    //   822: aload_0
    //   823: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   826: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   829: iconst_2
    //   830: if_icmpeq +159 -> 989
    //   833: aload_0
    //   834: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   837: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   840: bipush 6
    //   842: if_icmpeq +147 -> 989
    //   845: aload_0
    //   846: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   849: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   852: bipush 15
    //   854: if_icmpeq +135 -> 989
    //   857: aload_0
    //   858: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   861: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   864: bipush 10
    //   866: if_icmpeq +123 -> 989
    //   869: aload_0
    //   870: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   873: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   876: bipush 11
    //   878: if_icmpeq +111 -> 989
    //   881: aload_0
    //   882: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   885: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   888: bipush 19
    //   890: if_icmpeq +99 -> 989
    //   893: aload_0
    //   894: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   897: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   900: bipush 101
    //   902: if_icmpeq +87 -> 989
    //   905: aload_0
    //   906: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   909: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   912: bipush 102
    //   914: if_icmpeq +75 -> 989
    //   917: aload_0
    //   918: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   921: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   924: bipush 103
    //   926: if_icmpeq +63 -> 989
    //   929: aload_0
    //   930: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   933: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   936: bipush 104
    //   938: if_icmpeq +51 -> 989
    //   941: aload_0
    //   942: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   945: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   948: bipush 105
    //   950: if_icmpeq +39 -> 989
    //   953: aload_0
    //   954: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   957: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   960: bipush 106
    //   962: if_icmpeq +27 -> 989
    //   965: aload_0
    //   966: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   969: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   972: bipush 112
    //   974: if_icmpeq +15 -> 989
    //   977: aload_0
    //   978: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   981: getfield 1722	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   984: bipush 113
    //   986: if_icmpne -846 -> 140
    //   989: aload_0
    //   990: iconst_m1
    //   991: invokevirtual 1982	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   994: aload_0
    //   995: invokevirtual 744	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   998: goto -858 -> 140
    //   1001: aload_3
    //   1002: ldc_w 1984
    //   1005: invokevirtual 1966	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1008: astore 11
    //   1010: aload 11
    //   1012: ifnull -872 -> 140
    //   1015: aload 11
    //   1017: invokevirtual 757	java/lang/String:length	()I
    //   1020: ifle -880 -> 140
    //   1023: new 79	java/util/ArrayList
    //   1026: dup
    //   1027: invokespecial 80	java/util/ArrayList:<init>	()V
    //   1030: astore 10
    //   1032: new 416	org/json/JSONArray
    //   1035: dup
    //   1036: invokespecial 1985	org/json/JSONArray:<init>	()V
    //   1039: pop
    //   1040: new 416	org/json/JSONArray
    //   1043: dup
    //   1044: aload 11
    //   1046: invokespecial 1986	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1049: astore 11
    //   1051: iconst_0
    //   1052: istore_2
    //   1053: aload 11
    //   1055: invokevirtual 420	org/json/JSONArray:length	()I
    //   1058: istore 4
    //   1060: iload_2
    //   1061: iload 4
    //   1063: if_icmpge +26 -> 1089
    //   1066: aload 10
    //   1068: aload 11
    //   1070: iload_2
    //   1071: invokevirtual 1987	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1074: invokeinterface 1697 2 0
    //   1079: pop
    //   1080: iload_2
    //   1081: iconst_1
    //   1082: iadd
    //   1083: istore_2
    //   1084: goto -31 -> 1053
    //   1087: astore 11
    //   1089: aload_0
    //   1090: iconst_1
    //   1091: putfield 84	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_g_of_type_Boolean	Z
    //   1094: aload_0
    //   1095: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1098: aload 10
    //   1100: putfield 519	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   1103: aload_0
    //   1104: getfield 130	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1107: bipush 6
    //   1109: invokevirtual 1708	android/os/Handler:sendEmptyMessage	(I)Z
    //   1112: pop
    //   1113: goto -973 -> 140
    //   1116: aload_0
    //   1117: getfield 112	com/tencent/mobileqq/activity/TroopInfoActivity:l	Z
    //   1120: ifeq +20 -> 1140
    //   1123: aload_0
    //   1124: getfield 1989	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController	Lcom/tencent/mobileqq/activity/photo/TroopAvatarController;
    //   1127: ifnull -987 -> 140
    //   1130: aload_0
    //   1131: getfield 1989	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController	Lcom/tencent/mobileqq/activity/photo/TroopAvatarController;
    //   1134: invokevirtual 1994	com/tencent/mobileqq/activity/photo/TroopAvatarController:onSnapShotBack	()V
    //   1137: goto -997 -> 140
    //   1140: aload_0
    //   1141: getfield 1996	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController	Lcom/tencent/mobileqq/activity/photo/TroopPhotoController;
    //   1144: ifnull -1004 -> 140
    //   1147: aload_0
    //   1148: getfield 1996	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController	Lcom/tencent/mobileqq/activity/photo/TroopPhotoController;
    //   1151: invokevirtual 1999	com/tencent/mobileqq/activity/photo/TroopPhotoController:onSnapShotBack	()V
    //   1154: goto -1014 -> 140
    //   1157: iload_2
    //   1158: iconst_m1
    //   1159: if_icmpne -1019 -> 140
    //   1162: aload_3
    //   1163: ifnull -1023 -> 140
    //   1166: aload_0
    //   1167: invokestatic 2004	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   1170: ifne +21 -> 1191
    //   1173: aload_0
    //   1174: iconst_1
    //   1175: ldc_w 2005
    //   1178: iconst_0
    //   1179: invokestatic 1442	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   1182: aload_0
    //   1183: invokevirtual 715	com/tencent/mobileqq/activity/TroopInfoActivity:getTitleBarHeight	()I
    //   1186: invokevirtual 718	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   1189: pop
    //   1190: return
    //   1191: aload_3
    //   1192: ldc_w 1963
    //   1195: invokevirtual 1966	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1198: astore 10
    //   1200: aload 10
    //   1202: invokestatic 451	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1205: ifne -1065 -> 140
    //   1208: aload_0
    //   1209: getfield 177	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1212: ifnull -1072 -> 140
    //   1215: aload 10
    //   1217: aload_0
    //   1218: getfield 177	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1221: getfield 2008	com/tencent/mobileqq/data/troop/TroopInfo:troopname	Ljava/lang/String;
    //   1224: invokevirtual 531	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1227: ifne -1087 -> 140
    //   1230: aload_0
    //   1231: getfield 196	com/tencent/mobileqq/activity/TroopInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1234: getstatic 2011	com/tencent/mobileqq/app/BusinessHandlerFactory:BIZ_TROOP_HANDLER	Ljava/lang/String;
    //   1237: invokevirtual 727	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1240: checkcast 2013	com/tencent/mobileqq/app/BizTroopHandler
    //   1243: astore 11
    //   1245: aload_0
    //   1246: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1249: invokevirtual 815	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   1252: ifne +77 -> 1329
    //   1255: aload_0
    //   1256: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1259: getfield 2016	com/tencent/mobileqq/troopinfo/TroopInfoData:allowMemberModifTroopName	I
    //   1262: iconst_1
    //   1263: if_icmpne +66 -> 1329
    //   1266: iconst_1
    //   1267: istore 9
    //   1269: aload 11
    //   1271: aload_0
    //   1272: getfield 177	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1275: getfield 1042	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   1278: aload 10
    //   1280: iload 9
    //   1282: invokevirtual 2019	com/tencent/mobileqq/app/BizTroopHandler:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1285: aload_0
    //   1286: getfield 177	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1289: aload_0
    //   1290: getfield 177	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1293: getfield 2008	com/tencent/mobileqq/data/troop/TroopInfo:troopname	Ljava/lang/String;
    //   1296: putfield 2022	com/tencent/mobileqq/data/troop/TroopInfo:oldTroopName	Ljava/lang/String;
    //   1299: aload_0
    //   1300: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1303: aload 10
    //   1305: putfield 756	com/tencent/mobileqq/troopinfo/TroopInfoData:troopName	Ljava/lang/String;
    //   1308: aload_0
    //   1309: getfield 69	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1312: aload_0
    //   1313: getfield 177	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1316: invokevirtual 2025	com/tencent/mobileqq/data/troop/TroopInfo:getTroopDisplayName	()Ljava/lang/String;
    //   1319: putfield 1754	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   1322: aload_0
    //   1323: invokevirtual 1350	com/tencent/mobileqq/activity/TroopInfoActivity:c	()V
    //   1326: goto -1186 -> 140
    //   1329: iconst_0
    //   1330: istore 9
    //   1332: goto -63 -> 1269
    //   1335: aload_3
    //   1336: invokeinterface 2029 1 0
    //   1341: invokestatic 2034	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   1344: astore_3
    //   1345: goto -1174 -> 171
    //   1348: iload_1
    //   1349: sipush 260
    //   1352: if_icmpne -1156 -> 196
    //   1355: aload_0
    //   1356: invokespecial 927	com/tencent/mobileqq/activity/TroopInfoActivity:s	()V
    //   1359: return
    //   1360: astore 12
    //   1362: goto -282 -> 1080
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1365	0	this	TroopInfoActivity
    //   0	1365	1	paramInt1	int
    //   0	1365	2	paramInt2	int
    //   0	1365	3	paramIntent	Intent
    //   1058	6	4	n	int
    //   746	72	5	l1	long
    //   734	82	7	l2	long
    //   1267	64	9	bool	boolean
    //   212	492	10	localObject1	Object
    //   721	3	10	localJSONException1	org.json.JSONException
    //   791	17	10	localException	Exception
    //   1030	274	10	localObject2	Object
    //   391	678	11	localObject3	Object
    //   1087	1	11	localJSONException2	org.json.JSONException
    //   1243	27	11	localBizTroopHandler	BizTroopHandler
    //   436	1	12	localNumberFormatException	NumberFormatException
    //   1360	1	12	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   400	414	436	java/lang/NumberFormatException
    //   646	714	721	org/json/JSONException
    //   736	748	791	java/lang/Exception
    //   1040	1051	1087	org/json/JSONException
    //   1053	1060	1087	org/json/JSONException
    //   1066	1080	1360	org/json/JSONException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      this.jdField_h_of_type_Boolean = getIntent().getExtras().getBoolean("returnMsgList", false);
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isGameTroop()) {
        q();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      a();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      paramBundle = (BizTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "");
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
      this.i = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
      }
      BnrReport.a(this.app, 78);
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      int n = this.jdField_g_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (paramBundle = "0";; paramBundle = "1")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str, String.valueOf(n), paramBundle, "");
        return true;
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_d_of_type_Boolean = true;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    GroupCatalogTool.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.i) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.i = false;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onDestroy();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController.onDestroy();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onDestroy(), time = " + (System.currentTimeMillis() - l1));
      }
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.troopinfo", 2, "onDestroy(), unregisterReceiver Exception");
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("doOnNewIntent bAvatarEdit=%b clip=%s path=%s", new Object[] { Boolean.valueOf(this.l), paramIntent, str }));
      }
      if (!this.l) {
        break label94;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController.onPicPicked(str, paramIntent);
      }
    }
    label94:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPicPicked(str, paramIntent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    if (((this.jdField_c_of_type_Long != 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L)) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount <= 0)
      {
        localObject = DialogUtil.a(this, 230);
        ((QQCustomDialog)localObject).setTitle(null);
        ((QQCustomDialog)localObject).setMessage(getString(2131697508));
        ((QQCustomDialog)localObject).setPositiveButton(getString(2131693384), new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131693384));
        ((QQCustomDialog)localObject).show();
        return;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject).setTitle(null);
          ((QQCustomDialog)localObject).setMessage(getString(2131697507, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount) }));
          ((QQCustomDialog)localObject).setPositiveButton(getString(2131693384), new TroopInfoActivity.7(this));
          ((QQCustomDialog)localObject).setNegativeButton(getString(2131693331), new TroopInfoActivity.8(this));
          ((QQCustomDialog)localObject).show();
          return;
        }
        a((String)localObject);
        return;
      }
      k();
      return;
    }
    k();
  }
  
  public void f()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      this.k = true;
      finish();
      return;
    }
    a(2131693392);
  }
  
  public void finish()
  {
    l();
    g();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 28)) {
      setResult(-1, getIntent());
    }
    if (this.jdField_h_of_type_Boolean) {
      n();
    }
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (this.m))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("openSearchTroopWay", true);
      setResult(-1, localIntent);
    }
    super.finish();
    switch (this.jdField_h_of_type_Int)
    {
    default: 
      return;
    case 1: 
      overridePendingTransition(0, 2130771980);
      return;
    }
    overridePendingTransition(0, 2130772015);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      return;
    }
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location);
    localIntent.putExtra("grade", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.grade);
    localIntent.putExtra("school", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.school);
  }
  
  public void gotoBigPic(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent();
    paramBundle.setClass(this, TroopAvatarWallEditActivity.class);
    localBundle.putInt("index", 0);
    localBundle.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localBundle.putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.jdField_b_of_type_Int);
    localBundle.putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    localBundle.putBoolean("isUseClassAvatar", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isUseClassAvatar);
    paramBundle.putExtras(localBundle);
    paramBundle.addFlags(603979776);
    if (!localBundle.getBoolean("IS_COVER"))
    {
      n = 1;
      if (n == 0) {
        break label186;
      }
    }
    label186:
    for (int n = 260;; n = 258)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(n), localBundle }));
      }
      startActivityForResult(paramBundle, n);
      return;
      n = 0;
      break;
    }
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    ThreadManager.post(new TroopInfoActivity.12(this), 5, null, true);
  }
  
  protected void i()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    Object localObject3 = GroupCatalogTool.a(getApplicationContext()).a(this, (String)localObject1);
    localObject1 = "";
    int n;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      n = 1;
    }
    for (;;)
    {
      if (n != 0) {
        localIntent.putExtra("subclass", (String)localObject1);
      }
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            ((StringBuffer)localObject1).append((String)localObject3 + "\n");
            continue;
            if ((localObject3 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString))) {
              break label311;
            }
            if (((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131715317)))
            {
              n = 0;
              break;
            }
            localObject1 = ((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString;
            n = 1;
            break;
          }
        }
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
        localIntent.putExtra("tags", ((StringBuffer)localObject1).toString());
      }
      localIntent.putExtra("act_type", 1);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("modifyToSrv", 0);
      startActivityForResult(localIntent, 9);
      return;
      label311:
      n = 0;
    }
  }
  
  public void j()
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      localQQAppInterface = this.app;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.j) {
        break label81;
      }
    }
    label81:
    for (String str1 = "2";; str1 = "1")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, str2, str1, "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 16);
      return;
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {
      setResult(-1);
    }
    if (!this.jdField_g_of_type_Boolean)
    {
      this.m = true;
      finish();
      return;
    }
    Object localObject4 = this.app;
    Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str;
    if (this.j)
    {
      localObject2 = "2";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label143;
      }
      str = "0";
    }
    for (;;)
    {
      ReportController.b((AppRuntime)localObject4, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, (String)localObject5, (String)localObject2, str, "");
      localObject5 = (BizTroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if (localObject5 != null) {
        break label169;
      }
      this.m = true;
      finish();
      return;
      localObject2 = "1";
      break;
      label143:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        str = "1";
      } else {
        str = "2";
      }
    }
    label169:
    long l6;
    try
    {
      l6 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == -1)
      {
        this.m = true;
        finish();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      finish();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.currentTroopLocationStruct;
    int i3 = 0;
    int i2 = 0;
    long l1 = 0L;
    long l4 = 0L;
    Object localObject1 = "";
    int n;
    long l2;
    int i1;
    long l3;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      n = i2;
      l2 = l1;
      i1 = i3;
      l3 = l1;
    }
    for (;;)
    {
      try
      {
        localObject2 = ((String)localObject2).split("\\|");
        n = i2;
        l2 = l1;
        i1 = i3;
        l3 = l1;
        i2 = Integer.valueOf(localObject2[0]).intValue();
        n = i2;
        l2 = l1;
        i1 = i2;
        l3 = l1;
        l1 = (Double.valueOf(localObject2[1]).doubleValue() * 1000000.0D);
        n = i2;
        l2 = l1;
        i1 = i2;
        l3 = l1;
        long l5 = (Double.valueOf(localObject2[2]).doubleValue() * 1000000.0D);
        localObject1 = localObject2[3];
        n = i2;
        l2 = l5;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        l1 = l2;
        l2 = l4;
        continue;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        n = i1;
        l1 = l3;
        l2 = l4;
        continue;
        i2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) {
          continue;
        }
        i1 = 4;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == 0L) {
          continue;
        }
        i1 = 2;
        continue;
      }
      b(getString(2131693402));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        i2 = 3;
        if (i2 == -1) {
          break;
        }
        i1 = 1;
        if (this.jdField_c_of_type_Long == 0L) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == this.jdField_c_of_type_Long) {
          continue;
        }
        i1 = 3;
        if (((this.jdField_a_of_type_Int == 0) || (1 == this.jdField_a_of_type_Int)) && (i2 == 3)) {
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        }
        if (((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) && ((i2 == 0) || (1 == i2))) {
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) {
          break label796;
        }
        l();
        if (this.jdField_e_of_type_Int <= 0) {
          break label708;
        }
        a(l6, i2, n, l1, l2, (String)localObject1);
        ReportController.b(this.app, "dc00899", "Grp_certified", "", "data", "exp_edit_data", 4, 0, "" + l6, "", "", "");
        return;
      }
      label708:
      if (this.jdField_d_of_type_Int <= 0) {
        break;
      }
      localObject1 = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject1).setTitle(null);
      ((QQCustomDialog)localObject1).setMessage(getString(2131693394, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
      ((QQCustomDialog)localObject1).setPositiveButton(getString(2131693384), new DialogUtil.DialogOnClickAdapter());
      ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131693384));
      ((QQCustomDialog)localObject1).show();
      return;
      label796:
      if (((2 == this.jdField_a_of_type_Int) || (4 == this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4)))
      {
        localObject3 = localObject1;
        l4 = l1;
        l3 = l2;
        if (0L == l1)
        {
          localObject3 = localObject1;
          l4 = l1;
          l3 = l2;
          if (0L == l2)
          {
            l4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat;
            l3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon;
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
          }
        }
        ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        TroopInfoActivityHelper.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, n, l4, l3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new TroopInfoActivity.13(this));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.jdField_c_of_type_Long != 0L))
      {
        TroopInfoActivityHelper.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, n, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new TroopInfoActivity.14(this));
        return;
      }
      Object localObject3 = "";
      i1 = 0;
      localObject4 = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location)) {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.grade != 0) {
        i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.grade;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.school)) {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.school;
      }
      ((BizTroopHandler)localObject5).a(l6, i2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, n, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, (String)localObject3, i1, (String)localObject4);
      return;
      n = 0;
      l2 = l4;
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0))
      {
        a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
        a(5, false);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
        {
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
          a(5, false);
          return;
        }
        a(5, HardCodeUtil.a(2131715308), true);
        a(5, true);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
      {
        a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, false);
        a(5, false);
        return;
      }
    } while (this.jdField_a_of_type_ArrayOfAndroidViewView[5] == null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5].setVisibility(8);
  }
  
  public void n()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    startActivity(localIntent);
  }
  
  public void o()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void onBackPressed()
  {
    f();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    int i2;
    if ((localObject1 instanceof Integer)) {
      i2 = ((Integer)localObject1).intValue();
    }
    Object localObject4;
    String str;
    Object localObject3;
    label180:
    label331:
    label751:
    Object localObject2;
    label278:
    label923:
    label929:
    label1190:
    switch (i2)
    {
    case 3: 
    case 7: 
    case 14: 
    case 16: 
    case 17: 
    default: 
    case 4: 
    case 8: 
    case 9: 
    case 5: 
    case 6: 
    case 15: 
    case 2: 
    case 10: 
    case 13: 
    case 18: 
    case 12: 
      label824:
      label864:
      label871:
      label1002:
      label1144:
      label1274:
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_f_of_type_Int == 1)
          {
            QQToast.a(getApplicationContext(), 1, HardCodeUtil.a(2131715311), 0).a();
            a(i2, paramView);
          }
          else
          {
            localObject4 = this.app;
            str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (this.j)
            {
              localObject3 = "2";
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                break label278;
              }
              localObject1 = "0";
            }
            for (;;)
            {
              ReportController.b((AppRuntime)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_category", 0, 0, str, (String)localObject3, (String)localObject1, "");
              localObject1 = new Intent(getActivity(), TroopClassChoiceActivity.class);
              ((Intent)localObject1).putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
              startActivityForResult((Intent)localObject1, 11);
              break;
              localObject3 = "1";
              break label180;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                localObject1 = "1";
              } else {
                localObject1 = "2";
              }
            }
            localObject4 = this.app;
            str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (this.j)
            {
              localObject3 = "2";
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                break label397;
              }
              localObject1 = "0";
            }
            for (;;)
            {
              ReportController.b((AppRuntime)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_tag", 0, 0, str, (String)localObject3, (String)localObject1, "");
              i();
              a(i2, paramView);
              break;
              localObject3 = "1";
              break label331;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                localObject1 = "1";
              } else {
                localObject1 = "2";
              }
            }
            localObject1 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", "https://buluo.qq.com/mobile/qunbindbuluo.html?_wv=1027");
            ((Intent)localObject1).putExtra("bid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId);
            startActivityForResult((Intent)localObject1, 17);
            continue;
            j();
            a(i2, paramView);
            continue;
            localObject1 = new Intent(this, EditInfoActivity.class);
            ((Intent)localObject1).putExtra("edit_type", 1);
            ((Intent)localObject1).putExtra("title", getString(2131693434));
            ((Intent)localObject1).putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
            ((Intent)localObject1).putExtra("max_num", 900);
            ((Intent)localObject1).putExtra("canPostNull", true);
            ((Intent)localObject1).putExtra("support_emotion", true);
            ((Intent)localObject1).putExtra("full_screen", true);
            startActivityForResult((Intent)localObject1, 5);
            if (this.j) {}
            for (localObject1 = "2";; localObject1 = "1")
            {
              a("Grp_moredata", "Clk_brief", (String)localObject1);
              a(i2, paramView);
              break;
            }
            if (!NetworkUtil.d(this))
            {
              a(2131694457, 0);
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
            {
              try
              {
                long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                o();
                this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, 8390784);
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel())
              {
                QLog.i("Q.troopinfo", 2, localException.toString());
                continue;
                w();
                continue;
                boolean bool;
                int i1;
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
                  {
                    n = 1;
                    if ((n == 0) || (!QVipBigTroopExpiredProcessor.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
                      break label951;
                    }
                    bool = TroopManager.LiangGroupHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
                    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                      break label942;
                    }
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                    if (!bool) {
                      break label923;
                    }
                    n = 15;
                    localObject4 = VipUtils.a(0, n).toString();
                    str = HardCodeUtil.a(2131701793);
                    TroopInfoActivity.18 local18 = new TroopInfoActivity.18(this, bool);
                    if (!bool) {
                      break label929;
                    }
                    localObject2 = "0X800A57F";
                    if (!bool) {
                      break label937;
                    }
                    n = 1;
                    VipUtils.a(this, (String)localObject3, (String)localObject4, str, local18, (String)localObject2, n, bool);
                  }
                  for (;;)
                  {
                    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
                    break;
                    n = 0;
                    break label751;
                    n = 8;
                    break label824;
                    localObject2 = "0X8009E38";
                    break label864;
                    n = 2;
                    break label871;
                    VipUtils.a(this, bool);
                  }
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
                    break label1244;
                  }
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
                  localObject3 = localObject2;
                  if (localObject2 == null) {
                    localObject3 = "";
                  }
                  if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
                    break label1251;
                  }
                  i1 = 1;
                  localObject4 = new Intent(this, EditInfoActivity.class);
                  ((Intent)localObject4).putExtra("edit_type", 2);
                  if (n == 0) {
                    break label1256;
                  }
                  localObject2 = HardCodeUtil.a(2131701812);
                  ((Intent)localObject4).putExtra("title", (String)localObject2);
                  ((Intent)localObject4).putExtra("default_text", (String)localObject3);
                  ((Intent)localObject4).putExtra("max_num", 96);
                  ((Intent)localObject4).putExtra("canPostNull", false);
                  if (n == 0) {
                    break label1267;
                  }
                  localObject2 = HardCodeUtil.a(2131701797);
                  ((Intent)localObject4).putExtra("right_btn", (String)localObject2);
                  ((Intent)localObject4).putExtra("isTroopName", true);
                  if (n == 0) {
                    break label1274;
                  }
                  bool = true;
                  ((Intent)localObject4).putExtra("edit_mode", bool);
                  if (i1 == 0) {
                    break label1280;
                  }
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                  ((Intent)localObject4).putExtra("troopUin", (String)localObject2);
                  startActivityForResult((Intent)localObject4, 18);
                  localObject4 = this.app;
                  str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                  if (!this.j) {
                    break label1287;
                  }
                  localObject3 = "2";
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                    break label1295;
                  }
                  localObject2 = "0";
                }
                for (;;)
                {
                  ReportController.b((AppRuntime)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_name", 0, 0, str, (String)localObject3, (String)localObject2, "");
                  a(i2, paramView);
                  break;
                  localObject2 = "";
                  break label970;
                  i1 = 0;
                  break label1002;
                  localObject2 = HardCodeUtil.a(2131701811);
                  break label1037;
                  localObject2 = "";
                  break label1092;
                  bool = false;
                  break label1120;
                  localObject2 = "";
                  break label1144;
                  localObject3 = "1";
                  break label1190;
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                    localObject2 = "1";
                  } else {
                    localObject2 = "2";
                  }
                }
                ReportController.b(null, "dc00898", "", "", "0X800B282", "0X800B282", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
                {
                  x();
                  continue;
                  if (!NetworkUtil.g(this))
                  {
                    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName)) {
                      QQToast.a(this, 1, 2131694460, 0).b(getTitleBarHeight());
                    } else if (!this.jdField_g_of_type_Boolean) {
                      r();
                    } else {
                      QQToast.a(this, 1, 2131694460, 0).b(getTitleBarHeight());
                    }
                  }
                  else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName)) {
                    a(2131720281);
                  } else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead)) {
                    a(2131720279);
                  } else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName)) {
                    a(2131720280);
                  } else {
                    r();
                  }
                }
              }
            }
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
      label937:
      label942:
      label951:
      label970:
      label1120:
      label1251:
      label1256:
      label1267:
      localObject2 = paramView.getTag(2131720322);
      label1092:
      label1244:
      if ((localObject2 == null) || (!(localObject2 instanceof Integer))) {
        break;
      }
    }
    label397:
    label1037:
    label1295:
    for (int n = ((Integer)localObject2).intValue();; n = 0)
    {
      if (n > 0)
      {
        c(12);
        label1616:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
        }
        a(i2, paramView);
        localObject3 = this.app;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.j) {
          break label1779;
        }
      }
      label1779:
      for (localObject2 = "2";; localObject2 = "1")
      {
        ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_create_new", "", "edit_data", "cover", 0, 0, (String)localObject4, (String)localObject2, "", "");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController = new TroopPhotoController(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.setOnGotoBigPicListener(this);
        }
        this.l = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPickPic();
        break label1616;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        c(11);
        a(i2, paramView);
        localObject4 = this.app;
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.j) {
          break label1991;
        }
        localObject3 = "2";
        label1837:
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label1999;
        }
        localObject2 = "0";
      }
      for (;;)
      {
        ReportController.b((AppRuntime)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, (String)localObject3, (String)localObject2, "");
        break;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          break label1803;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController = new TroopAvatarController(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController.setOnGotoBigPicListener(this);
        }
        this.l = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopAvatarController.onPickPic();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger != null) {
          break label1803;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger = new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_JavaUtilObserver);
        break label1803;
        label1991:
        localObject3 = "1";
        break label1837;
        label1999:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject2 = "1";
        } else {
          localObject2 = "2";
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        s();
      }
    }
  }
  
  public void p()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void q()
  {
    GCBindGroup.GCBindGroupSsoServerReq localGCBindGroupSsoServerReq = new GCBindGroup.GCBindGroupSsoServerReq();
    localGCBindGroupSsoServerReq.cmd.set("get_appid");
    Object localObject = new GCBindGroup.QQGroupBind();
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((GCBindGroup.QQGroupBind)localObject).group_code.set(l1);
      localGCBindGroupSsoServerReq.bind_req.set((MessageMicro)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), ProtoServlet.class);
      TroopInfoActivity.31 local31 = new TroopInfoActivity.31(this);
      local31.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.app);
      local31.jdField_b_of_type_Int = 2;
      ((NewIntent)localObject).setObserver(local31);
      ((NewIntent)localObject).putExtra("cmd", "gcbindgroupsso.get_appid");
      ((NewIntent)localObject).putExtra("data", localGCBindGroupSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("Q.troopinfo", 1, "get game bind status failed, troop=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */