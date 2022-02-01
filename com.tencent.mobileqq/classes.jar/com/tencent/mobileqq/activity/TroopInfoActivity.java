package com.tencent.mobileqq.activity;

import Override;
import afsp;
import afsq;
import afsr;
import afss;
import afst;
import afsu;
import afsv;
import afsw;
import afsx;
import afsy;
import afsz;
import afta;
import aftb;
import aftc;
import aftd;
import afte;
import aftf;
import aftg;
import afth;
import afti;
import aftj;
import aftk;
import aftl;
import aftm;
import aftn;
import agej;
import akps;
import akry;
import aksb;
import aksh;
import aksj;
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
import antz;
import anua;
import anyu;
import anyw;
import anzj;
import aoip;
import aojn;
import aojs;
import aoof;
import aoog;
import armu;
import bdep;
import bdll;
import begp;
import beyq;
import bgpj;
import bgpk;
import bgqu;
import bgun;
import bguq;
import bhap;
import bhaq;
import bhez;
import bhju;
import bhjv;
import bhlq;
import bhme;
import bhmq;
import bhnv;
import bhpc;
import bjbs;
import blrq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import nkl;
import nnc;
import npo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import zps;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements aksh, View.OnClickListener, aoog
{
  public static String c;
  public int a;
  public long a;
  private akry jdField_a_of_type_Akry;
  private aksb jdField_a_of_type_Aksb;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new afsp(this);
  public Handler a;
  protected View a;
  protected Button a;
  protected LinearLayout a;
  anua jdField_a_of_type_Anua = new aftb(this);
  anyu jdField_a_of_type_Anyu = new afta(this);
  public aoip a;
  aojs jdField_a_of_type_Aojs = new aftc(this);
  protected aoof a;
  public bgqu a;
  protected bjbs a;
  protected FriendListHandler a;
  public TroopInfo a;
  public TroopInfoData a;
  protected XListView a;
  public String a;
  protected ArrayList<String> a;
  public List<Integer> a;
  Observer jdField_a_of_type_JavaUtilObserver = new afti(this);
  protected boolean a;
  protected View[] a;
  public int b;
  public long b;
  public View b;
  public String b;
  protected boolean b;
  public int c;
  public long c;
  protected View c;
  public boolean c;
  public int d;
  boolean d;
  public int e;
  public boolean e;
  protected int f;
  public boolean f;
  private int g;
  protected boolean g;
  private int h;
  protected boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  static
  {
    jdField_c_of_type_JavaLangString = "key_from_upgrade_search_way";
  }
  
  public TroopInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new afsz(this);
  }
  
  private void A()
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378646);
      if ((2 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) && (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)) {
        break label503;
      }
    }
    label503:
    for (int n = 1;; n = 0)
    {
      int m = n;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) {
        m = n | 0x2;
      }
      if (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
      {
        n = m;
        if (3 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {}
      }
      else
      {
        n = m | 0x4;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 2)
      {
        m = n;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 3) {}
      }
      else
      {
        m = n | 0x8;
      }
      n = m;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 1) {
        n = m | 0x10;
      }
      m = n;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
        m = n | 0x20;
      }
      SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4);
      boolean bool = localSharedPreferences.getBoolean("has_shown_tips", false);
      if (a(m, 32)) {
        if (this.jdField_c_of_type_Int == 2) {
          m = 2131696849;
        }
      }
      for (;;)
      {
        if (m != 0)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          localTextView.setText(m);
          localTextView.setContentDescription(getString(m));
          return;
          if ((this.jdField_c_of_type_Int == 3) && (!bool))
          {
            m = 2131696850;
            localSharedPreferences.edit().putBoolean("has_shown_tips", true).commit();
            continue;
            if (a(m, 1))
            {
              if (a(m, 2))
              {
                if ((a(m, 4)) || (a(m, 8)) || (a(m, 16)))
                {
                  m = 2131696863;
                  continue;
                }
                m = 2131696862;
                continue;
              }
              if (a(m, 8))
              {
                m = 2131696856;
                continue;
              }
              if (a(m, 4))
              {
                m = 2131696855;
                continue;
              }
              m = 2131696854;
              continue;
            }
            if (a(m, 2))
            {
              if (a(m, 4))
              {
                m = 2131696861;
                continue;
              }
              if ((a(m, 8)) || (a(m, 16)))
              {
                m = 2131696860;
                continue;
              }
              m = 2131696859;
              continue;
            }
            if ((a(m, 8)) && (a(m, 4)))
            {
              m = 2131696851;
              continue;
            }
            if (a(m, 8))
            {
              m = 2131696853;
              continue;
            }
            if (a(m, 4)) {
              m = 2131696852;
            }
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        m = 0;
      }
    }
  }
  
  private void B()
  {
    startTitleProgress();
    npo.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new afte(this));
  }
  
  private void C()
  {
    npo.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new aftf(this));
  }
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_Aoof != null)
    {
      localObject2 = this.jdField_a_of_type_Aoof.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Aoof.a())
        {
          this.jdField_a_of_type_Aoof.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bhmq.a();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(this.app)) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, long paramLong1, short paramShort, String paramString6, String paramString7, int paramInt2, String paramString8, String paramString9, boolean paramBoolean, String paramString10, long paramLong2, long paramLong3, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putInt("troop_info_from_ex", paramInt3);
    localBundle.putString("troop_code", paramString2);
    localBundle.putString("troop_info_name", paramString3);
    localBundle.putString("troop_info_owner", paramString4);
    localBundle.putString("troop_info_admi", paramString5);
    localBundle.putByte("troop_info_opt", paramByte);
    localBundle.putLong("troop_info_classext", paramLong1);
    localBundle.putShort("troop_info_faceid", paramShort);
    localBundle.putString("troop_info_fingermemo", paramString6);
    localBundle.putString("troop_info_school_location", paramString7);
    localBundle.putString("troop_info_school_schoolid", paramString8);
    localBundle.putInt("troop_info_school_grade", paramInt2);
    localBundle.putString("troop_info_loca", paramString9);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString10);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramLong2);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramLong3);
    return localBundle;
  }
  
  public static Bundle a(String paramString, int paramInt)
  {
    return a(paramString, "", paramInt);
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("troop_info_loca", paramString2);
    }
    localBundle.putInt("troop_info_lat", paramInt2);
    localBundle.putInt("troop_info_lon", paramInt3);
    localBundle.putInt("troop_info_cityid", paramInt4);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt);
    localBundle.putString("authSig", paramString2);
    return localBundle;
  }
  
  private View a(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextColor(getResources().getColor(2131167070));
    localTextView.setPadding(getResources().getDimensionPixelSize(2131299054), zps.a(this, 20.0F), 0, zps.a(this, 10.0F));
    localTextView.setFocusable(true);
    return localTextView;
  }
  
  /* Error */
  private String a(int paramInt)
  {
    // Byte code:
    //   0: new 430	org/json/JSONObject
    //   3: dup
    //   4: ldc_w 432
    //   7: invokespecial 435	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: ldc_w 437
    //   13: invokevirtual 441	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   16: ldc_w 443
    //   19: invokevirtual 447	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   22: astore 6
    //   24: iconst_0
    //   25: istore_2
    //   26: ldc 88
    //   28: astore 4
    //   30: iload_2
    //   31: aload 6
    //   33: invokevirtual 453	org/json/JSONArray:length	()I
    //   36: if_icmpge +124 -> 160
    //   39: aload 6
    //   41: iload_2
    //   42: invokevirtual 456	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   45: astore 5
    //   47: iload_1
    //   48: aload 5
    //   50: ldc_w 458
    //   53: invokevirtual 462	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   56: if_icmpne +12 -> 68
    //   59: aload 5
    //   61: ldc_w 464
    //   64: invokevirtual 467	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: areturn
    //   68: aload 5
    //   70: ldc_w 469
    //   73: invokevirtual 447	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   76: astore 7
    //   78: iconst_0
    //   79: istore_3
    //   80: aload 4
    //   82: astore 5
    //   84: iload_3
    //   85: aload 7
    //   87: invokevirtual 453	org/json/JSONArray:length	()I
    //   90: if_icmpge +33 -> 123
    //   93: aload 7
    //   95: iload_3
    //   96: invokevirtual 456	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   99: astore 5
    //   101: iload_1
    //   102: aload 5
    //   104: ldc_w 458
    //   107: invokevirtual 462	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   110: if_icmpne +24 -> 134
    //   113: aload 5
    //   115: ldc_w 464
    //   118: invokevirtual 467	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   143: ldc 88
    //   145: astore 4
    //   147: aload 5
    //   149: invokevirtual 472	org/json/JSONException:printStackTrace	()V
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
    //   25	102	2	m	int
    //   79	59	3	n	int
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
      int m = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId;
      double d1 = paramInt1 / 1000000.0D;
      double d2 = paramInt2 / 1000000.0D;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      paramString = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(m), Double.valueOf(d1), Double.valueOf(d2), str });
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
    int n = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    Object localObject = Long.toString(paramTroopInfoData.dwGroupClassExt);
    paramContext = bhaq.a(paramContext).a(paramContext, (String)localObject);
    if (!TextUtils.isEmpty(paramTroopInfoData.mTroopClassExtText)) {
      paramContext = paramTroopInfoData.mTroopClassExtText;
    }
    for (;;)
    {
      localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramContext)) {
        ((ArrayList)localObject).add(paramContext);
      }
      for (int m = 1;; m = 0)
      {
        if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
        {
          int i1 = paramTroopInfoData.troopTags.size();
          for (;;)
          {
            if (n < i1)
            {
              if ((m == 0) || (!((String)paramTroopInfoData.troopTags.get(n)).equals(paramContext))) {
                ((ArrayList)localObject).add(paramTroopInfoData.troopTags.get(n));
              }
              n += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString))) {
                break label203;
              }
              if (paramContext.jdField_a_of_type_JavaLangString.equals(anzj.a(2131714236)))
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      paramView = paramView.findViewById(2131376414);
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        bguq.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt, false);
        b(paramInt, false);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) && (!this.jdField_h_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop))
    {
      int n = 1;
      int m = n;
      if (paramInt == 8)
      {
        m = n;
        if (!bguq.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
          m = 0;
        }
      }
      if ((m != 0) && (bguq.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt))) {
        b(paramInt, paramBoolean);
      }
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755824);
    localReportDialog.setContentView(2131561147);
    ((TextView)localReportDialog.findViewById(2131365556)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365544);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365542);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365548);
    localTextView1.setText(String.format(getString(2131693029), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694098);
    localTextView3.setText(2131693010);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new afsu(this, localReportDialog, paramLong1, paramInt2, paramLong2, paramLong3, paramString));
    localTextView3.setOnClickListener(new afsv(this, localReportDialog));
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
    this.jdField_b_of_type_AndroidViewView = super.getLayoutInflater().inflate(2131560590, paramXListView, false);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378910);
    ((ImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364584)).setOnClickListener(new aftd(this, paramXListView));
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
          break label276;
        }
        str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_h_of_type_Boolean) {
          break label283;
        }
        localObject = "2";
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label291;
        }
        str1 = "0";
      }
      for (;;)
      {
        bdll.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, str2, (String)localObject, str1, "");
        QQToast.a(this, 1, paramString, 1).b(getTitleBarHeight());
        if (paramBoolean)
        {
          ((aoip)this.app.a(20)).notifyUI(111, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
          this.k = true;
          finish();
        }
        return;
        switch ((int)paramLong1)
        {
        default: 
          paramString = getString(2131693024);
          break;
        case 1281: 
          paramString = getString(2131693025);
          break;
        case 1282: 
          paramString = getString(2131693026);
          break;
        case 1283: 
          paramString = getString(2131693027);
          break;
        case 1793: 
          paramString = getString(2131693028);
          break;
          label276:
          str2 = "";
          break label38;
          label283:
          localObject = "1";
          break label50;
          label291:
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
            str1 = "1";
          } else {
            str1 = "2";
          }
          break;
        }
      }
    }
    Object localObject = this.app;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      label339:
      if (!this.jdField_h_of_type_Boolean) {
        break label433;
      }
      str2 = "2";
      label351:
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label441;
      }
      paramString = "0";
    }
    for (;;)
    {
      bdll.b((QQAppInterface)localObject, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, str1, str2, paramString, "");
      if (this.jdField_h_of_type_Boolean) {
        break;
      }
      QQToast.a(this, 2, getString(2131693031), 1).b(getTitleBarHeight());
      break;
      str1 = "";
      break label339;
      label433:
      str2 = "1";
      break label351;
      label441:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        paramString = "1";
      } else {
        paramString = "2";
      }
    }
  }
  
  private String b()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2))
    {
      bdll.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
      return getString(2131696844);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
    {
      bdll.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
      return getString(2131696842);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15))
    {
      bdll.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      return getString(2131696843);
    }
    if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption)
    {
      bdll.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "3", "", "");
      return getString(2131696841);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131696840);
    }
    return "";
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int m = 8;
    View localView;
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
      if (localObject != null)
      {
        localView = ((View)localObject).findViewById(2131376414);
        if (paramInt != 8) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = ((View)localObject).findViewById(2131378611);; localObject = ((View)localObject).findViewById(2131365046))
    {
      if (localView != null)
      {
        paramInt = m;
        if (paramBoolean) {
          paramInt = 0;
        }
        localView.setVisibility(paramInt);
      }
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        m = getResources().getDimensionPixelSize(2131298390);
        paramInt = m;
        if (paramBoolean) {
          paramInt = m * 2;
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
      if ((!armu.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
        break label192;
      }
      bool = aojn.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
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
      String str3 = anzj.a(2131714238);
      afsy localafsy = new afsy(this, bool);
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
      VipUtils.a(this, str1, str2, str3, localafsy, (String)localObject, paramInt, bool);
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
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
      a((Bundle)localObject);
      bdll.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label319;
      }
    }
    label319:
    for (localObject = "1";; localObject = "0")
    {
      bhju.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { str1, localObject });
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
        localView = localView.findViewById(2131376413);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null) {
        break label104;
      }
    }
    label104:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if ((paramInt & 0x2) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
          y();
        }
        if ((paramInt & 0x20) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo;
          a(6, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
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
      localObject = bhlq.a(this, 230);
      ((bhpc)localObject).setTitle(null);
      ((bhpc)localObject).setMessage(getString(2131693014, new Object[] { this.jdField_a_of_type_Long + "" }));
      ((bhpc)localObject).setPositiveButton(getString(2131693012), new bhme());
      ((bhpc)localObject).setPositiveButtonContentDescription(getString(2131693012));
      ((bhpc)localObject).show();
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
        localDrawable.setBounds(0, 0, bdep.a(32.0F), bdep.a(32.0F));
        localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
        a(11, 2, localView, getString(2131698491), localSpannableString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        a(11, false);
      }
    }
    while (this.jdField_h_of_type_Boolean)
    {
      c(11, true);
      return;
      label125:
      a(11, 2, localView, getString(2131698491), anzj.a(2131714235), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(11, true);
    }
    c(11, false);
  }
  
  private void t()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    ArrayList localArrayList = new ArrayList();
    aksj.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
    if (localArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "updateCoverEntry infoList is empty.");
      }
      a(12, 2, localView, getString(2131719036), anzj.a(2131714239), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(12, true);
    }
    for (;;)
    {
      localView.setTag(2131719036, Integer.valueOf(localArrayList.size()));
      return;
      String str = bgpj.b(bgpj.a(((akps)localArrayList.get(0)).jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1));
      URLDrawable localURLDrawable = null;
      Object localObject1 = null;
      int m = bdep.a(30.0F);
      localObject3 = localURLDrawable;
      try
      {
        URL localURL = aksj.a(str);
        if (localURL != null)
        {
          localObject3 = localURLDrawable;
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = beyq.a;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = m;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = m;
          localObject3 = localURLDrawable;
          localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject1);
          localObject3 = localURLDrawable;
          localURLDrawable.setTag(new int[] { m, m, 0 });
          localObject3 = localURLDrawable;
          localURLDrawable.setDecodeHandler(bhez.d);
          localObject1 = localURLDrawable;
          localObject3 = localURLDrawable;
          if (localURLDrawable.getStatus() != 1)
          {
            localObject3 = localURLDrawable;
            localURLDrawable.setURLDrawableListener(new aftk(this));
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
        ((URLDrawable)localObject1).setBounds(0, 0, m, m);
        ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject1, 0), 0, ((SpannableString)localObject3).length(), 17);
      }
      a(12, 2, localView, getString(2131719036), (CharSequence)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(12, false);
    }
  }
  
  private void u()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject = bhlq.a(this, 230);
      ((bhpc)localObject).setTitle(null);
      long l2 = this.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      ((bhpc)localObject).setMessage(getString(2131693032, new Object[] { l1 + "" }));
      ((bhpc)localObject).setNegativeButton(getString(2131693012), new aftn(this));
      ((bhpc)localObject).setPositiveButton(getString(2131692990), new afsq(this));
      ((bhpc)localObject).show();
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (localObject = "0";; localObject = "1")
      {
        bdll.b(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_exp", 0, 0, str, (String)localObject, "", "");
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
    a(2131718941, 1);
  }
  
  private void w()
  {
    Object localObject = this.app.getCurrentAccountUin();
    int m;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin).equals(localObject)) {
      m = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, m);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) {
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      ((ProfileActivity.AllInOne)localObject).d = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      if (m == 21) {
        ((ProfileActivity.AllInOne)localObject).l = 11;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
      {
        if (((anyw)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
        {
          m = 20;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          m = 21;
          continue;
        }
      }
      m = 19;
    }
  }
  
  private void x()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev4/classinfo?gc=%1$s&from=%2$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bgpk.d }));
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult(localIntent, 19);
  }
  
  private void y()
  {
    ThreadManager.post(new TroopInfoActivity.24(this), 5, null, true);
  }
  
  private void z()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.post(new TroopInfoActivity.25(this), 5, null, true);
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {
      return getString(2131696858);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      return getString(2131696857);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2) {
      return getString(2131696844);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15) {
      return getString(2131696843);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131696840);
    }
    return "";
  }
  
  protected void a()
  {
    long l = System.currentTimeMillis();
    View localView = View.inflate(this, 2131561637, null);
    Object localObject1 = (ListView)localView.findViewById(2131364012);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(anzj.a(2131714233));
    ((ArrayList)localObject2).add(anzj.a(2131714232));
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364907));
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
    localObject1 = new blrq(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838778);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setClickable(false);
    this.jdField_a_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopinfo", 2, "mIsQidianPrivateTroop : " + this.jdField_a_of_type_Boolean + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    super.setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (this.jdField_h_of_type_Boolean) {
        localObject1 = getString(2131719016);
      }
    }
    else
    {
      setTitle((CharSequence)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
      {
        localObject1 = View.inflate(this, 2131561643, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        a(7, 0, (View)localObject1, getString(2131692981), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
        localObject1 = View.inflate(this, 2131561658, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      if (this.jdField_h_of_type_Boolean)
      {
        localObject1 = a(anzj.a(2131718985));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject1 = View.inflate(this, 2131561643, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      ((View)localObject1).setTag(Integer.valueOf(10));
      a(10, 2, (View)localObject1, getString(2131691625), "", true);
      c();
      a((View)localObject1);
      localObject1 = View.inflate(this, 2131561643, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[11] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      s();
      ((View)localObject1).setOnClickListener(this);
      if (this.jdField_h_of_type_Boolean)
      {
        localObject1 = a(anzj.a(2131718852));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject1 = View.inflate(this, 2131561643, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      t();
      ((View)localObject1).setOnClickListener(this);
      localObject1 = View.inflate(this, 2131561643, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(5, 2, (View)localObject1, getString(2131719037), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      m();
      localObject1 = View.inflate(this, 2131561643, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(4, 2, (View)localObject1, getString(2131718853), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()))
      {
        localObject1 = View.inflate(this, 2131561643, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).setTag(Integer.valueOf(13));
        a(13, 2, (View)localObject1, getString(2131718854), "", true);
        b();
      }
      localObject1 = View.inflate(this, 2131561642, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(8, 3, (View)localObject1, getString(2131718855), null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim(), 1);
      if (this.jdField_h_of_type_Boolean) {
        ((View)localObject1).setBackgroundResource(2130839450);
      }
      ThreadManager.post(new TroopInfoActivity.2(this), 8, null, true);
      if (!this.jdField_h_of_type_Boolean)
      {
        localObject1 = View.inflate(this, 2131561658, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject2 = View.inflate(this, 2131561649, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label1189;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      label946:
      a(6, 3, (View)localObject2, getString(2131693057), (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      if (!this.jdField_h_of_type_Boolean)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.mDensity));
        localObject2 = View.inflate(this, 2131561658, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363774);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363692));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label1212;
      }
      if (!this.jdField_h_of_type_Boolean) {
        break label1203;
      }
      b(18);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_h_of_type_Boolean)
      {
        this.leftView.setText("取消");
        this.leftView.setBackgroundDrawable(null);
        this.leftView.setPadding(0, 5, 52, 5);
      }
      this.leftView.setOnClickListener(new afth(this));
      this.rightViewText.setOnClickListener(new aftj(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l));
      }
      return;
      localObject1 = getString(2131718924);
      break;
      label1189:
      localObject1 = getResources().getString(2131695507);
      break label946;
      label1203:
      b(14);
      continue;
      label1212:
      b(15);
    }
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    bhpc localbhpc = bhlq.a(this, 230);
    localbhpc.setTitle(str);
    localbhpc.setMessage(null);
    localbhpc.setPositiveButton(getString(2131693019), new afsr(this, localbhpc));
    localbhpc.setPositiveButtonContentDescription(getString(2131693019));
    localbhpc.setNegativeButton(getString(2131692990), new bhme());
    localbhpc.setNegativeButtonContentDescription(getString(2131692990));
    localbhpc.show();
  }
  
  public void a(int paramInt1, int paramInt2)
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
        TextView localTextView1 = (TextView)paramView.findViewById(2131378936);
        localTextView2 = (TextView)paramView.findViewById(2131368636);
        localView = paramView.findViewById(2131362954);
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
      paramView.setBackgroundResource(2130839440);
      break label48;
      paramView.setBackgroundResource(2130839456);
      break label48;
      paramView.setBackgroundResource(2130839450);
      break label48;
      paramView.setBackgroundResource(2130839447);
      break label48;
      localTextView2.setVisibility(0);
      localTextView2.setText(new begp(paramCharSequence, 11, 20));
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
    TextView localTextView = (TextView)paramView.findViewById(2131378936);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131362954);
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
    paramView.setBackgroundResource(2130839440);
    return;
    paramView.setBackgroundResource(2130839456);
    return;
    paramView.setBackgroundResource(2130839450);
    return;
    paramView.setBackgroundResource(2130839447);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
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
        localTextView = (TextView)localView1.findViewById(2131368636);
        localView2 = localView1.findViewById(2131362954);
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
        localTextView.setText(new begp(paramString, 11, 20));
      }
      label189:
      String str = paramString;
      if (paramInt == 4)
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label228;
        }
        str = anzj.a(2131714241);
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
  
  public void a(int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
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
        localLinearLayout = (LinearLayout)localView.findViewById(2131364633);
        localLinearLayout.removeAllViews();
        localObject1 = (LinearLayout)localView.findViewById(2131378611);
        localObject2 = (TextView)localView.findViewById(2131368636);
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          localLinearLayout.setVisibility(8);
          ((TextView)localObject2).setText(anzj.a(2131714242));
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
      int n = 0;
      while ((n < paramArrayList.size()) && (n < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(n)))
        {
          n += 1;
        }
        else
        {
          localObject1 = new TextView(this);
          ((TextView)localObject1).setId(2131373880);
          int m = 2130843807;
          if (paramInt2 == 1) {
            m = 2130843808;
          }
          for (;;)
          {
            localObject2 = getResources().getDrawable(m);
            ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject2);
            ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
            ((TextView)localObject1).setTextSize(2, 15.0F);
            if (paramBoolean2) {
              ((TextView)localObject1).setMaxWidth(agej.a(77.0F, getResources()));
            }
            ((TextView)localObject1).setSingleLine();
            ((TextView)localObject1).setTextColor(getResources().getColor(2131167153));
            ((TextView)localObject1).setPadding(agej.a(6.0F, getResources()), agej.a(2.0F, getResources()), agej.a(8.0F, getResources()), agej.a(2.0F, getResources()));
            ((TextView)localObject1).setGravity(17);
            ((TextView)localObject1).setText((CharSequence)paramArrayList.get(n));
            ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).leftMargin = agej.a(5.0F, getResources());
            localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break;
            if (paramInt2 == 2) {
              m = 2130843807;
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131362954);
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
  
  public void a(Bundle paramBundle)
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
      m = 1;
      if (m == 0) {
        break label186;
      }
    }
    label186:
    for (int m = 260;; m = 258)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(m), localBundle }));
      }
      startActivityForResult(paramBundle, m);
      return;
      m = 0;
      break;
    }
  }
  
  protected void a(View paramView)
  {
    if (paramView == null) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)paramView.findViewById(2131378936);
      paramView = (LinearLayout)paramView.findViewById(2131365046);
    } while ((localTextView == null) || (paramView == null) || (TextUtils.isEmpty(localTextView.getText())));
    int m = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_h_of_type_Boolean)
    {
      paramView.leftMargin = (agej.a(100.0F, getResources()) + m);
      return;
    }
    paramView.leftMargin = (agej.a(90.0F, getResources()) + m);
  }
  
  public void a(GCBindGroup.GCBindGroupSsoServerRsp paramGCBindGroupSsoServerRsp)
  {
    int m = paramGCBindGroupSsoServerRsp.ret.get();
    Object localObject = null;
    if (m == -3000005) {
      this.jdField_f_of_type_Int = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopinfo", 2, "onGetGameBindStatus ret=" + m + ", status=" + this.jdField_f_of_type_Int + ", name=" + (String)localObject);
      }
      return;
      if (m == 0)
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
    bdll.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  public void a(oidb_0x88d.GroupInfo paramGroupInfo)
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
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = bhjv.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = bhjv.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM");
        this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("troop_auth_submit_time");
        this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("PARAM_EXIT_ANIMATION", 0);
        this.jdField_h_of_type_Boolean = ((Bundle)localObject).getBoolean(jdField_c_of_type_JavaLangString, false);
        localObject = (TroopManager)this.app.getManager(52);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
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
  
  public void b()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    String str;
    if (localView != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location)) {
        break label130;
      }
      str = anzj.a(2131706229);
      bdll.b(this.app, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      ((TextView)localView.findViewById(2131368636)).setText(str);
      if (!str.equals(anzj.a(2131706229))) {
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
      bdll.b(this.app, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
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
      this.rightViewText.setText(2131693038);
      return;
    case 15: 
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693162);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(15));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131719003);
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
    bjbs localbjbs = new bjbs(this, getTitleBarHeight());
    localbjbs.a(paramString);
    localbjbs.setCancelable(false);
    localbjbs.setOnDismissListener(new afsw(this));
    this.jdField_a_of_type_AndroidAppDialog = localbjbs;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    String str;
    if (localObject != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
        break label112;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      localObject = (TextView)((View)localObject).findViewById(2131368636);
      if (localObject != null) {
        ((TextView)localObject).setText(str);
      }
      if (!str.equals(anzj.a(2131700673))) {
        break label122;
      }
      a(10, true);
      label70:
      if (!this.jdField_h_of_type_Boolean) {
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
      str = anzj.a(2131700673);
      break;
      label122:
      a(10, false);
      break label70;
      label132:
      c(10, false);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  /* Error */
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 661
    //   9: iconst_2
    //   10: new 507	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1901
    //   20: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc_w 1903
    //   30: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 1905
    //   40: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_3
    //   44: invokevirtual 1476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iconst_m1
    //   54: iload_2
    //   55: if_icmpne +85 -> 140
    //   58: iload_1
    //   59: lookupswitch	default:+81->140, 5:+476->535, 7:+138->197, 8:+763->822, 9:+942->1001, 11:+672->731, 16:+209->268, 18:+1098->1157, 19:+569->628, 257:+1057->1116
    //   141: sipush 258
    //   144: if_icmpne +1203 -> 1347
    //   147: aload_3
    //   148: ifnull +44 -> 192
    //   151: aload_3
    //   152: ldc_w 1907
    //   155: invokevirtual 1911	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   158: astore_3
    //   159: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +30 -> 192
    //   165: aload_3
    //   166: ifnonnull +1168 -> 1334
    //   169: aconst_null
    //   170: astore_3
    //   171: ldc_w 661
    //   174: iconst_2
    //   175: ldc_w 1913
    //   178: iconst_1
    //   179: anewarray 482	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_3
    //   185: aastore
    //   186: invokestatic 498	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   189: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_0
    //   193: invokespecial 822	com/tencent/mobileqq/activity/TroopInfoActivity:t	()V
    //   196: return
    //   197: aload_3
    //   198: ifnull -58 -> 140
    //   201: aload_3
    //   202: invokevirtual 1330	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   205: ifnull -65 -> 140
    //   208: aload_3
    //   209: invokevirtual 1330	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   212: astore 10
    //   214: aload_0
    //   215: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   218: aload 10
    //   220: ldc_w 1914
    //   223: invokevirtual 1333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: putfield 784	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   229: aload_0
    //   230: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   233: aload 10
    //   235: ldc_w 1916
    //   238: iconst_0
    //   239: invokevirtual 1748	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   242: putfield 1675	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLat	I
    //   245: aload_0
    //   246: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   249: aload 10
    //   251: ldc_w 1918
    //   254: iconst_0
    //   255: invokevirtual 1748	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   258: putfield 1681	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLon	I
    //   261: aload_0
    //   262: invokevirtual 1360	com/tencent/mobileqq/activity/TroopInfoActivity:m	()V
    //   265: goto -125 -> 140
    //   268: aload_3
    //   269: ifnull -129 -> 140
    //   272: aload_3
    //   273: invokevirtual 1330	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   276: ifnull -136 -> 140
    //   279: aload_3
    //   280: invokevirtual 1330	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   283: astore 10
    //   285: aload_0
    //   286: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   289: getfield 784	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   292: aload 10
    //   294: ldc_w 1914
    //   297: invokevirtual 1333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   300: invokestatic 1923	bhjx:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   303: ifne +8 -> 311
    //   306: aload_0
    //   307: iconst_1
    //   308: putfield 1116	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   311: aload_0
    //   312: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   315: aload 10
    //   317: ldc_w 1925
    //   320: invokevirtual 1333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   323: putfield 1772	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   326: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +36 -> 365
    //   332: ldc_w 505
    //   335: iconst_2
    //   336: new 507	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 1927
    //   346: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_0
    //   350: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   353: getfield 1772	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   356: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 1820	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload_0
    //   366: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   369: getfield 1772	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   372: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +39 -> 414
    //   378: aload_0
    //   379: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: getfield 1772	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   385: ldc_w 1929
    //   388: invokevirtual 1933	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   391: astore 11
    //   393: aload 11
    //   395: arraylength
    //   396: iconst_5
    //   397: if_icmplt +96 -> 493
    //   400: aload_0
    //   401: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   404: aload 11
    //   406: iconst_4
    //   407: aaload
    //   408: invokestatic 1739	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   411: putfield 1936	com/tencent/mobileqq/troopinfo/TroopInfoData:mPoiId	J
    //   414: aload_0
    //   415: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   418: aload 10
    //   420: ldc_w 1914
    //   423: invokevirtual 1333	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 784	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   429: aload_0
    //   430: invokevirtual 1360	com/tencent/mobileqq/activity/TroopInfoActivity:m	()V
    //   433: goto -293 -> 140
    //   436: astore 12
    //   438: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq -27 -> 414
    //   444: ldc_w 661
    //   447: iconst_2
    //   448: new 507	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 1938
    //   458: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 11
    //   463: iconst_4
    //   464: aaload
    //   465: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc_w 1940
    //   471: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_0
    //   475: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   478: getfield 1772	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   481: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 1820	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: goto -76 -> 414
    //   493: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq -82 -> 414
    //   499: ldc_w 661
    //   502: iconst_2
    //   503: new 507	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 1942
    //   513: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   520: getfield 1772	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   523: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 1944	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: goto -118 -> 414
    //   535: aload_3
    //   536: ldc_w 1946
    //   539: invokevirtual 1949	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   542: astore 10
    //   544: aload 10
    //   546: aload_0
    //   547: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   550: getfield 788	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   553: invokestatic 1952	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   556: ifne -416 -> 140
    //   559: aload_0
    //   560: iconst_1
    //   561: putfield 1116	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   564: aload_0
    //   565: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   568: aload 10
    //   570: putfield 788	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   573: aload_0
    //   574: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   577: getfield 788	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   580: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifne +30 -> 613
    //   586: aload_0
    //   587: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   590: getfield 788	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   593: astore 10
    //   595: aload_0
    //   596: bipush 6
    //   598: aload 10
    //   600: aload_0
    //   601: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   604: invokevirtual 838	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   607: invokevirtual 923	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILjava/lang/String;Z)V
    //   610: goto -470 -> 140
    //   613: aload_0
    //   614: invokevirtual 397	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   617: ldc_w 1426
    //   620: invokevirtual 1427	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   623: astore 10
    //   625: goto -30 -> 595
    //   628: aload_3
    //   629: ifnull -489 -> 140
    //   632: iload_2
    //   633: iconst_m1
    //   634: if_icmpne -494 -> 140
    //   637: aload_3
    //   638: ldc_w 1954
    //   641: invokevirtual 1949	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   644: astore 10
    //   646: new 430	org/json/JSONObject
    //   649: dup
    //   650: aload 10
    //   652: invokespecial 435	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   655: astore 10
    //   657: aload 10
    //   659: ldc_w 1914
    //   662: invokevirtual 441	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   665: astore 11
    //   667: aload_0
    //   668: iconst_1
    //   669: putfield 1116	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   672: aload_0
    //   673: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   676: aload 10
    //   678: ldc_w 1955
    //   681: invokevirtual 1958	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   684: putfield 1781	com/tencent/mobileqq/troopinfo/TroopInfoData:grade	I
    //   687: aload_0
    //   688: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   691: aload 11
    //   693: invokevirtual 1959	org/json/JSONObject:toString	()Ljava/lang/String;
    //   696: putfield 1775	com/tencent/mobileqq/troopinfo/TroopInfoData:location	Ljava/lang/String;
    //   699: aload_0
    //   700: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   703: aload 10
    //   705: ldc_w 1960
    //   708: invokevirtual 467	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   711: putfield 1778	com/tencent/mobileqq/troopinfo/TroopInfoData:school	Ljava/lang/String;
    //   714: aload_0
    //   715: invokevirtual 1370	com/tencent/mobileqq/activity/TroopInfoActivity:b	()V
    //   718: goto -578 -> 140
    //   721: astore 10
    //   723: aload 10
    //   725: invokevirtual 472	org/json/JSONException:printStackTrace	()V
    //   728: goto -14 -> 714
    //   731: ldc2_w 1961
    //   734: lstore 7
    //   736: aload_3
    //   737: ldc_w 458
    //   740: invokevirtual 1949	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   743: invokestatic 1739	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   746: lstore 5
    //   748: aload_0
    //   749: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   752: getfield 525	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   755: lload 5
    //   757: lcmp
    //   758: ifeq -618 -> 140
    //   761: lload 5
    //   763: ldc2_w 1961
    //   766: lcmp
    //   767: ifeq -627 -> 140
    //   770: aload_0
    //   771: iconst_1
    //   772: putfield 1116	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   775: aload_0
    //   776: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   779: lload 5
    //   781: putfield 525	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   784: aload_0
    //   785: invokespecial 917	com/tencent/mobileqq/activity/TroopInfoActivity:y	()V
    //   788: goto -648 -> 140
    //   791: astore 10
    //   793: lload 7
    //   795: lstore 5
    //   797: invokestatic 503	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   800: ifeq -52 -> 748
    //   803: ldc_w 661
    //   806: iconst_2
    //   807: aload 10
    //   809: invokevirtual 662	java/lang/Exception:toString	()Ljava/lang/String;
    //   812: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: lload 7
    //   817: lstore 5
    //   819: goto -71 -> 748
    //   822: aload_0
    //   823: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   826: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   829: iconst_2
    //   830: if_icmpeq +159 -> 989
    //   833: aload_0
    //   834: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   837: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   840: bipush 6
    //   842: if_icmpeq +147 -> 989
    //   845: aload_0
    //   846: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   849: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   852: bipush 15
    //   854: if_icmpeq +135 -> 989
    //   857: aload_0
    //   858: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   861: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   864: bipush 10
    //   866: if_icmpeq +123 -> 989
    //   869: aload_0
    //   870: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   873: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   876: bipush 11
    //   878: if_icmpeq +111 -> 989
    //   881: aload_0
    //   882: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   885: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   888: bipush 19
    //   890: if_icmpeq +99 -> 989
    //   893: aload_0
    //   894: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   897: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   900: bipush 101
    //   902: if_icmpeq +87 -> 989
    //   905: aload_0
    //   906: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   909: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   912: bipush 102
    //   914: if_icmpeq +75 -> 989
    //   917: aload_0
    //   918: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   921: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   924: bipush 103
    //   926: if_icmpeq +63 -> 989
    //   929: aload_0
    //   930: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   933: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   936: bipush 104
    //   938: if_icmpeq +51 -> 989
    //   941: aload_0
    //   942: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   945: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   948: bipush 105
    //   950: if_icmpeq +39 -> 989
    //   953: aload_0
    //   954: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   957: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   960: bipush 106
    //   962: if_icmpeq +27 -> 989
    //   965: aload_0
    //   966: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   969: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   972: bipush 112
    //   974: if_icmpne +15 -> 989
    //   977: aload_0
    //   978: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   981: getfield 1743	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   984: bipush 113
    //   986: if_icmpeq -846 -> 140
    //   989: aload_0
    //   990: iconst_m1
    //   991: invokevirtual 1965	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   994: aload_0
    //   995: invokevirtual 760	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   998: goto -858 -> 140
    //   1001: aload_3
    //   1002: ldc_w 1967
    //   1005: invokevirtual 1949	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1008: astore 11
    //   1010: aload 11
    //   1012: ifnull -872 -> 140
    //   1015: aload 11
    //   1017: invokevirtual 780	java/lang/String:length	()I
    //   1020: ifle -880 -> 140
    //   1023: new 69	java/util/ArrayList
    //   1026: dup
    //   1027: invokespecial 70	java/util/ArrayList:<init>	()V
    //   1030: astore 10
    //   1032: new 449	org/json/JSONArray
    //   1035: dup
    //   1036: invokespecial 1968	org/json/JSONArray:<init>	()V
    //   1039: pop
    //   1040: new 449	org/json/JSONArray
    //   1043: dup
    //   1044: aload 11
    //   1046: invokespecial 1969	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1049: astore 11
    //   1051: iconst_0
    //   1052: istore_2
    //   1053: aload 11
    //   1055: invokevirtual 453	org/json/JSONArray:length	()I
    //   1058: istore 4
    //   1060: iload_2
    //   1061: iload 4
    //   1063: if_icmpge +26 -> 1089
    //   1066: aload 10
    //   1068: aload 11
    //   1070: iload_2
    //   1071: invokevirtual 1970	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1074: invokeinterface 1722 2 0
    //   1079: pop
    //   1080: iload_2
    //   1081: iconst_1
    //   1082: iadd
    //   1083: istore_2
    //   1084: goto -31 -> 1053
    //   1087: astore 11
    //   1089: aload_0
    //   1090: iconst_1
    //   1091: putfield 1116	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   1094: aload_0
    //   1095: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1098: aload 10
    //   1100: putfield 546	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   1103: aload_0
    //   1104: getfield 104	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1107: bipush 6
    //   1109: invokevirtual 1733	android/os/Handler:sendEmptyMessage	(I)Z
    //   1112: pop
    //   1113: goto -973 -> 140
    //   1116: aload_0
    //   1117: getfield 1972	com/tencent/mobileqq/activity/TroopInfoActivity:j	Z
    //   1120: ifeq +20 -> 1140
    //   1123: aload_0
    //   1124: getfield 1974	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Akry	Lakry;
    //   1127: ifnull -987 -> 140
    //   1130: aload_0
    //   1131: getfield 1974	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Akry	Lakry;
    //   1134: invokevirtual 1978	akry:d	()V
    //   1137: goto -997 -> 140
    //   1140: aload_0
    //   1141: getfield 1980	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Aksb	Laksb;
    //   1144: ifnull -1004 -> 140
    //   1147: aload_0
    //   1148: getfield 1980	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Aksb	Laksb;
    //   1151: invokevirtual 1983	aksb:d	()V
    //   1154: goto -1014 -> 140
    //   1157: iload_2
    //   1158: iconst_m1
    //   1159: if_icmpne -1019 -> 140
    //   1162: aload_3
    //   1163: ifnull -1023 -> 140
    //   1166: aload_0
    //   1167: invokestatic 1988	bhnv:g	(Landroid/content/Context;)Z
    //   1170: ifne +21 -> 1191
    //   1173: aload_0
    //   1174: iconst_1
    //   1175: ldc_w 1989
    //   1178: iconst_0
    //   1179: invokestatic 1445	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   1182: aload_0
    //   1183: invokevirtual 740	com/tencent/mobileqq/activity/TroopInfoActivity:getTitleBarHeight	()I
    //   1186: invokevirtual 743	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   1189: pop
    //   1190: return
    //   1191: aload_3
    //   1192: ldc_w 1946
    //   1195: invokevirtual 1949	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1198: astore 10
    //   1200: aload 10
    //   1202: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1205: ifne -1065 -> 140
    //   1208: aload_0
    //   1209: getfield 141	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1212: ifnull -1072 -> 140
    //   1215: aload 10
    //   1217: aload_0
    //   1218: getfield 141	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1221: getfield 1992	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   1224: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1227: ifne -1087 -> 140
    //   1230: aload_0
    //   1231: getfield 160	com/tencent/mobileqq/activity/TroopInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1234: bipush 22
    //   1236: invokevirtual 746	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   1239: checkcast 1994	antz
    //   1242: astore 11
    //   1244: aload_0
    //   1245: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1248: invokevirtual 838	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   1251: ifne +77 -> 1328
    //   1254: aload_0
    //   1255: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1258: getfield 1997	com/tencent/mobileqq/troopinfo/TroopInfoData:allowMemberModifTroopName	I
    //   1261: iconst_1
    //   1262: if_icmpne +66 -> 1328
    //   1265: iconst_1
    //   1266: istore 9
    //   1268: aload 11
    //   1270: aload_0
    //   1271: getfield 141	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1274: getfield 1046	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1277: aload 10
    //   1279: iload 9
    //   1281: invokevirtual 2000	antz:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1284: aload_0
    //   1285: getfield 141	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1288: aload_0
    //   1289: getfield 141	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1292: getfield 1992	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   1295: putfield 2003	com/tencent/mobileqq/data/TroopInfo:oldTroopName	Ljava/lang/String;
    //   1298: aload_0
    //   1299: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1302: aload 10
    //   1304: putfield 779	com/tencent/mobileqq/troopinfo/TroopInfoData:troopName	Ljava/lang/String;
    //   1307: aload_0
    //   1308: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1311: aload_0
    //   1312: getfield 141	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1315: invokevirtual 2006	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   1318: putfield 1763	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   1321: aload_0
    //   1322: invokevirtual 1352	com/tencent/mobileqq/activity/TroopInfoActivity:c	()V
    //   1325: goto -1185 -> 140
    //   1328: iconst_0
    //   1329: istore 9
    //   1331: goto -63 -> 1268
    //   1334: aload_3
    //   1335: invokeinterface 2010 1 0
    //   1340: invokestatic 2015	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   1343: astore_3
    //   1344: goto -1173 -> 171
    //   1347: iload_1
    //   1348: sipush 260
    //   1351: if_icmpne -1155 -> 196
    //   1354: aload_0
    //   1355: invokespecial 938	com/tencent/mobileqq/activity/TroopInfoActivity:s	()V
    //   1358: return
    //   1359: astore 12
    //   1361: goto -281 -> 1080
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1364	0	this	TroopInfoActivity
    //   0	1364	1	paramInt1	int
    //   0	1364	2	paramInt2	int
    //   0	1364	3	paramIntent	Intent
    //   1058	6	4	m	int
    //   746	72	5	l1	long
    //   734	82	7	l2	long
    //   1266	64	9	bool	boolean
    //   212	492	10	localObject1	Object
    //   721	3	10	localJSONException1	org.json.JSONException
    //   791	17	10	localException	Exception
    //   1030	273	10	localObject2	Object
    //   391	678	11	localObject3	Object
    //   1087	1	11	localJSONException2	org.json.JSONException
    //   1242	27	11	localantz	antz
    //   436	1	12	localNumberFormatException	NumberFormatException
    //   1359	1	12	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   400	414	436	java/lang/NumberFormatException
    //   646	714	721	org/json/JSONException
    //   736	748	791	java/lang/Exception
    //   1040	1051	1087	org/json/JSONException
    //   1053	1060	1087	org/json/JSONException
    //   1066	1080	1359	org/json/JSONException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.jdField_f_of_type_Boolean = getIntent().getExtras().getBoolean("returnMsgList", false);
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
      this.jdField_a_of_type_Aoof = new aoof(this, this.app);
      this.jdField_a_of_type_Aoof.a(this);
      a();
      addObserver(this.jdField_a_of_type_Anua);
      paramBundle = (antz)this.app.a(22);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "");
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
      this.jdField_g_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l));
      }
      nnc.a(this.app, 78);
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      int m = this.jdField_g_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (paramBundle = "0";; paramBundle = "1")
      {
        bdll.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str, String.valueOf(m), paramBundle, "");
        return true;
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_d_of_type_Boolean = true;
    long l = 0L;
    if (QLog.isColorLevel()) {
      l = System.currentTimeMillis();
    }
    bhaq.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_Aojs);
    removeObserver(this.jdField_a_of_type_Anyu);
    removeObserver(this.jdField_a_of_type_Anua);
    if (this.jdField_g_of_type_Boolean) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_g_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bgqu != null) {
        this.jdField_a_of_type_Bgqu.b(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (this.jdField_a_of_type_Aksb != null) {
        this.jdField_a_of_type_Aksb.f();
      }
      if (this.jdField_a_of_type_Akry != null) {
        this.jdField_a_of_type_Akry.f();
      }
      if (this.jdField_a_of_type_Aoof != null) {
        this.jdField_a_of_type_Aoof.d();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onDestroy(), time = " + (System.currentTimeMillis() - l));
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
        QLog.i("Q.troopinfo", 2, String.format("doOnNewIntent bAvatarEdit=%b clip=%s path=%s", new Object[] { Boolean.valueOf(this.j), paramIntent, str }));
      }
      if (!this.j) {
        break label94;
      }
      if (this.jdField_a_of_type_Akry != null) {
        this.jdField_a_of_type_Akry.a(str, paramIntent);
      }
    }
    label94:
    while (this.jdField_a_of_type_Aksb == null) {
      return;
    }
    this.jdField_a_of_type_Aksb.a(str, paramIntent);
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
        localObject = bhlq.a(this, 230);
        ((bhpc)localObject).setTitle(null);
        ((bhpc)localObject).setMessage(getString(2131696839));
        ((bhpc)localObject).setPositiveButton(getString(2131693012), new bhme());
        ((bhpc)localObject).setPositiveButtonContentDescription(getString(2131693012));
        ((bhpc)localObject).show();
        return;
      }
      if (this.jdField_e_of_type_Boolean)
      {
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bhlq.a(this, 230);
          ((bhpc)localObject).setTitle(null);
          ((bhpc)localObject).setMessage(getString(2131696838, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount) }));
          ((bhpc)localObject).setPositiveButton(getString(2131693012), new aftl(this));
          ((bhpc)localObject).setNegativeButton(getString(2131692990), new aftm(this));
          ((bhpc)localObject).show();
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
    if (!this.jdField_e_of_type_Boolean)
    {
      this.i = true;
      finish();
      return;
    }
    a(2131693020);
  }
  
  public void finish()
  {
    l();
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 28) {
      setResult(-1, getIntent());
    }
    if (this.jdField_f_of_type_Boolean) {
      n();
    }
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (this.k))
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
      overridePendingTransition(0, 2130771978);
      return;
    }
    overridePendingTransition(0, 2130772012);
  }
  
  public void g()
  {
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
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_Aoip = ((aoip)this.app.a(20));
    addObserver(this.jdField_a_of_type_Aojs);
    addObserver(this.jdField_a_of_type_Anyu);
    addObserver(this.jdField_a_of_type_Anua);
    ThreadManager.post(new TroopInfoActivity.12(this), 5, null, true);
  }
  
  protected void i()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    Object localObject3 = bhaq.a(getApplicationContext()).a(this, (String)localObject1);
    localObject1 = "";
    int m;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      m = 1;
    }
    for (;;)
    {
      if (m != 0) {
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
            if ((localObject3 == null) || (TextUtils.isEmpty(((bhap)localObject3).jdField_a_of_type_JavaLangString))) {
              break label311;
            }
            if (((bhap)localObject3).jdField_a_of_type_JavaLangString.equals(anzj.a(2131714243)))
            {
              m = 0;
              break;
            }
            localObject1 = ((bhap)localObject3).jdField_a_of_type_JavaLangString;
            m = 1;
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
      m = 0;
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
      if (!this.jdField_h_of_type_Boolean) {
        break label81;
      }
    }
    label81:
    for (String str1 = "2";; str1 = "1")
    {
      bdll.b(localQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, str2, str1, "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 16);
      return;
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {
      setResult(-1);
    }
    if (!this.jdField_e_of_type_Boolean)
    {
      this.k = true;
      finish();
      return;
    }
    Object localObject4 = this.app;
    Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str;
    if (this.jdField_h_of_type_Boolean)
    {
      localObject2 = "2";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label142;
      }
      str = "0";
    }
    for (;;)
    {
      bdll.b((QQAppInterface)localObject4, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, (String)localObject5, (String)localObject2, str, "");
      localObject5 = (antz)this.app.a(22);
      if (localObject5 != null) {
        break label168;
      }
      this.k = true;
      finish();
      return;
      localObject2 = "1";
      break;
      label142:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        str = "1";
      } else {
        str = "2";
      }
    }
    label168:
    long l6;
    try
    {
      l6 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == -1)
      {
        this.k = true;
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
    int i2 = 0;
    int i1 = 0;
    long l1 = 0L;
    long l4 = 0L;
    Object localObject1 = "";
    int m;
    long l2;
    int n;
    long l3;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      m = i1;
      l2 = l1;
      n = i2;
      l3 = l1;
    }
    for (;;)
    {
      try
      {
        localObject2 = ((String)localObject2).split("\\|");
        m = i1;
        l2 = l1;
        n = i2;
        l3 = l1;
        i1 = Integer.valueOf(localObject2[0]).intValue();
        m = i1;
        l2 = l1;
        n = i1;
        l3 = l1;
        l1 = (Double.valueOf(localObject2[1]).doubleValue() * 1000000.0D);
        m = i1;
        l2 = l1;
        n = i1;
        l3 = l1;
        long l5 = (Double.valueOf(localObject2[2]).doubleValue() * 1000000.0D);
        localObject1 = localObject2[3];
        m = i1;
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
        m = n;
        l1 = l3;
        l2 = l4;
        continue;
        i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) {
          continue;
        }
        n = 4;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == 0L) {
          continue;
        }
        n = 2;
        continue;
      }
      b(getString(2131693030));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        i1 = 3;
        if (i1 == -1) {
          break;
        }
        n = 1;
        if (this.jdField_c_of_type_Long == 0L) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == this.jdField_c_of_type_Long) {
          continue;
        }
        n = 3;
        if (((this.jdField_a_of_type_Int == 0) || (1 == this.jdField_a_of_type_Int)) && (i1 == 3)) {
          bdll.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        }
        if (((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) && ((i1 == 0) || (1 == i1))) {
          bdll.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) {
          break label795;
        }
        l();
        if (this.jdField_e_of_type_Int <= 0) {
          break label707;
        }
        a(l6, i1, m, l1, l2, (String)localObject1);
        bdll.b(this.app, "dc00899", "Grp_certified", "", "data", "exp_edit_data", 4, 0, "" + l6, "", "", "");
        return;
      }
      label707:
      if (this.jdField_d_of_type_Int <= 0) {
        break;
      }
      localObject1 = bhlq.a(this, 230);
      ((bhpc)localObject1).setTitle(null);
      ((bhpc)localObject1).setMessage(getString(2131693022, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
      ((bhpc)localObject1).setPositiveButton(getString(2131693012), new bhme());
      ((bhpc)localObject1).setPositiveButtonContentDescription(getString(2131693012));
      ((bhpc)localObject1).show();
      return;
      label795:
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
        bdll.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        npo.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, m, l4, l3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, n, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new afss(this));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.jdField_c_of_type_Long != 0L))
      {
        npo.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, m, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, n, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new afst(this));
        return;
      }
      Object localObject3 = "";
      n = 0;
      localObject4 = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location)) {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.grade != 0) {
        n = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.grade;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.school)) {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.school;
      }
      ((antz)localObject5).a(l6, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, m, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, (String)localObject3, n, (String)localObject4);
      return;
      m = 0;
      l2 = l4;
    }
  }
  
  public void l()
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
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0))
    {
      a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
      a(5, false);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
        {
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
          a(5, false);
          return;
        }
        a(5, anzj.a(2131714234), true);
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
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    startActivity(localIntent);
  }
  
  public void o()
  {
    try
    {
      if (this.jdField_a_of_type_Bjbs == null)
      {
        this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bjbs.c(2131694176);
        this.jdField_a_of_type_Bjbs.c(false);
      }
      this.jdField_a_of_type_Bjbs.show();
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
    int i1;
    if ((localObject1 instanceof Integer)) {
      i1 = ((Integer)localObject1).intValue();
    }
    Object localObject4;
    String str;
    Object localObject3;
    label180:
    label331:
    label751:
    Object localObject2;
    label278:
    label921:
    label927:
    label1186:
    switch (i1)
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
      label869:
      label998:
      label1140:
      label1270:
      label1276:
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_f_of_type_Int == 1)
          {
            QQToast.a(getApplicationContext(), 1, anzj.a(2131714237), 0).a();
            a(i1, paramView);
          }
          else
          {
            localObject4 = this.app;
            str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (this.jdField_h_of_type_Boolean)
            {
              localObject3 = "2";
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                break label278;
              }
              localObject1 = "0";
            }
            for (;;)
            {
              bdll.b((QQAppInterface)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_category", 0, 0, str, (String)localObject3, (String)localObject1, "");
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
            if (this.jdField_h_of_type_Boolean)
            {
              localObject3 = "2";
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                break label397;
              }
              localObject1 = "0";
            }
            for (;;)
            {
              bdll.b((QQAppInterface)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_tag", 0, 0, str, (String)localObject3, (String)localObject1, "");
              i();
              a(i1, paramView);
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
            a(i1, paramView);
            continue;
            localObject1 = new Intent(this, EditInfoActivity.class);
            ((Intent)localObject1).putExtra("edit_type", 1);
            ((Intent)localObject1).putExtra("title", getString(2131693057));
            ((Intent)localObject1).putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
            ((Intent)localObject1).putExtra("max_num", 900);
            ((Intent)localObject1).putExtra("canPostNull", true);
            ((Intent)localObject1).putExtra("support_emotion", true);
            ((Intent)localObject1).putExtra("full_screen", true);
            startActivityForResult((Intent)localObject1, 5);
            if (this.jdField_h_of_type_Boolean) {}
            for (localObject1 = "2";; localObject1 = "1")
            {
              a("Grp_moredata", "Clk_brief", (String)localObject1);
              a(i1, paramView);
              break;
            }
            if (!bhnv.d(this))
            {
              a(2131693963, 0);
            }
            else if (this.jdField_a_of_type_Aoip != null)
            {
              try
              {
                long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                o();
                this.jdField_a_of_type_Aoip.a(l, 8390784);
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel())
              {
                QLog.i("Q.troopinfo", 2, localException.toString());
                continue;
                w();
                continue;
                boolean bool;
                int n;
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
                  {
                    m = 1;
                    if ((m == 0) || (!armu.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
                      break label947;
                    }
                    bool = aojn.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
                    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                      break label938;
                    }
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                    if (!bool) {
                      break label921;
                    }
                    m = 15;
                    localObject4 = VipUtils.a(0, m).toString();
                    str = anzj.a(2131700632);
                    afsx localafsx = new afsx(this, bool);
                    if (!bool) {
                      break label927;
                    }
                    localObject2 = "0X800A57F";
                    if (!bool) {
                      break label935;
                    }
                    VipUtils.a(this, (String)localObject3, (String)localObject4, str, localafsx, (String)localObject2, 1, bool);
                  }
                  for (;;)
                  {
                    bdll.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
                    break;
                    m = 0;
                    break label751;
                    m = 8;
                    break label824;
                    localObject2 = "0X8009E38";
                    break label864;
                    break label869;
                    VipUtils.a(this, bool);
                  }
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
                    break label1240;
                  }
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
                  localObject3 = localObject2;
                  if (localObject2 == null) {
                    localObject3 = "";
                  }
                  if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
                    break label1247;
                  }
                  n = 1;
                  localObject4 = new Intent(this, EditInfoActivity.class);
                  ((Intent)localObject4).putExtra("edit_type", 2);
                  if (m == 0) {
                    break label1252;
                  }
                  localObject2 = anzj.a(2131700651);
                  ((Intent)localObject4).putExtra("title", (String)localObject2);
                  ((Intent)localObject4).putExtra("default_text", (String)localObject3);
                  ((Intent)localObject4).putExtra("max_num", 96);
                  ((Intent)localObject4).putExtra("canPostNull", false);
                  if (m == 0) {
                    break label1263;
                  }
                  localObject2 = anzj.a(2131700636);
                  ((Intent)localObject4).putExtra("right_btn", (String)localObject2);
                  ((Intent)localObject4).putExtra("isTroopName", true);
                  if (m == 0) {
                    break label1270;
                  }
                  bool = true;
                  ((Intent)localObject4).putExtra("edit_mode", bool);
                  if (n == 0) {
                    break label1276;
                  }
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                  ((Intent)localObject4).putExtra("troopUin", (String)localObject2);
                  startActivityForResult((Intent)localObject4, 18);
                  localObject4 = this.app;
                  str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                  if (!this.jdField_h_of_type_Boolean) {
                    break label1283;
                  }
                  localObject3 = "2";
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                    break label1291;
                  }
                  localObject2 = "0";
                }
                for (;;)
                {
                  bdll.b((QQAppInterface)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_name", 0, 0, str, (String)localObject3, (String)localObject2, "");
                  a(i1, paramView);
                  break;
                  localObject2 = "";
                  break label966;
                  n = 0;
                  break label998;
                  localObject2 = anzj.a(2131700650);
                  break label1033;
                  localObject2 = "";
                  break label1088;
                  bool = false;
                  break label1116;
                  localObject2 = "";
                  break label1140;
                  localObject3 = "1";
                  break label1186;
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                    localObject2 = "1";
                  } else {
                    localObject2 = "2";
                  }
                }
                bdll.b(null, "dc00898", "", "", "0X800B282", "0X800B282", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
                {
                  x();
                  continue;
                  if (!bhnv.g(this))
                  {
                    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName)) {
                      QQToast.a(this, 1, 2131693966, 0).b(getTitleBarHeight());
                    } else if (!this.jdField_e_of_type_Boolean) {
                      r();
                    } else {
                      QQToast.a(this, 1, 2131693966, 0).b(getTitleBarHeight());
                    }
                  }
                  else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName)) {
                    a(2131719006);
                  } else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead)) {
                    a(2131719004);
                  } else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName)) {
                    a(2131719005);
                  } else {
                    r();
                  }
                }
              }
            }
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
      label935:
      label938:
      label947:
      label966:
      label1116:
      label1247:
      label1252:
      label1263:
      localObject2 = paramView.getTag(2131719036);
      label1088:
      label1240:
      if ((localObject2 == null) || (!(localObject2 instanceof Integer))) {
        break;
      }
    }
    label397:
    for (int m = ((Integer)localObject2).intValue();; m = 0)
    {
      if (m > 0)
      {
        c(12);
        label1612:
        if (this.jdField_a_of_type_Bgqu == null)
        {
          this.jdField_a_of_type_Bgqu = new bgqu(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bgun.class, this.jdField_a_of_type_Aoip);
          this.jdField_a_of_type_Bgqu.a(this.jdField_a_of_type_JavaUtilObserver);
        }
        a(i1, paramView);
        localObject3 = this.app;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_h_of_type_Boolean) {
          break label1775;
        }
      }
      label1775:
      for (localObject2 = "2";; localObject2 = "1")
      {
        bdll.b((QQAppInterface)localObject3, "dc00899", "Grp_create_new", "", "edit_data", "cover", 0, 0, (String)localObject4, (String)localObject2, "", "");
        break;
        if (this.jdField_a_of_type_Aksb == null)
        {
          this.jdField_a_of_type_Aksb = new aksb(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_Aksb.a(this);
        }
        this.j = false;
        this.jdField_a_of_type_Aksb.c();
        break label1612;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        c(11);
        a(i1, paramView);
        localObject4 = this.app;
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_h_of_type_Boolean) {
          break label1987;
        }
        localObject3 = "2";
        label1833:
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label1995;
        }
        localObject2 = "0";
      }
      for (;;)
      {
        bdll.b((QQAppInterface)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, (String)localObject3, (String)localObject2, "");
        break;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          break label1799;
        }
        if (this.jdField_a_of_type_Akry == null)
        {
          this.jdField_a_of_type_Akry = new akry(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_Akry.a(this);
        }
        this.j = true;
        this.jdField_a_of_type_Akry.c();
        if (this.jdField_a_of_type_Bgqu != null) {
          break label1799;
        }
        this.jdField_a_of_type_Bgqu = new bgqu(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bgun.class, this.jdField_a_of_type_Aoip);
        this.jdField_a_of_type_Bgqu.a(this.jdField_a_of_type_JavaUtilObserver);
        break label1799;
        label1987:
        localObject3 = "1";
        break label1833;
        label1995:
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
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
        this.jdField_a_of_type_Bjbs.dismiss();
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
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((GCBindGroup.QQGroupBind)localObject).group_code.set(l);
      localGCBindGroupSsoServerReq.bind_req.set((MessageMicro)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), nkl.class);
      aftg localaftg = new aftg(this);
      localaftg.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.app);
      localaftg.jdField_b_of_type_Int = 2;
      ((NewIntent)localObject).setObserver(localaftg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */