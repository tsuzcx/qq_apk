package com.tencent.mobileqq.activity;

import Override;
import afjl;
import afjm;
import afjn;
import afjo;
import afjp;
import afjq;
import afjr;
import afjs;
import afjt;
import afju;
import afjv;
import afjw;
import afjx;
import afjy;
import afjz;
import afka;
import afkb;
import afkc;
import afkd;
import afke;
import afkf;
import afkg;
import afkh;
import afki;
import afkj;
import afur;
import akeh;
import akgn;
import akgq;
import akgw;
import akgy;
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
import anie;
import anif;
import anmu;
import anmw;
import anni;
import anwd;
import anxa;
import anxg;
import aobu;
import aobv;
import aqxg;
import bclx;
import bcst;
import bdnt;
import bdzx;
import bfpi;
import bfqt;
import bfum;
import bfup;
import bgao;
import bgap;
import bgey;
import bgjt;
import bgju;
import bglp;
import bgmc;
import bgmo;
import bgnt;
import bgpa;
import biau;
import bkqn;
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
import niq;
import nlh;
import nnt;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import zlx;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements akgw, View.OnClickListener, aobv
{
  public static String c;
  public int a;
  public long a;
  private akgn jdField_a_of_type_Akgn;
  private akgq jdField_a_of_type_Akgq;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new afjl(this);
  public Handler a;
  protected View a;
  protected Button a;
  protected LinearLayout a;
  anif jdField_a_of_type_Anif = new afjx(this);
  anmu jdField_a_of_type_Anmu = new afjw(this);
  public anwd a;
  anxg jdField_a_of_type_Anxg = new afjy(this);
  protected aobu a;
  public bfqt a;
  protected biau a;
  protected FriendListHandler a;
  public TroopInfo a;
  public TroopInfoData a;
  protected XListView a;
  public String a;
  protected ArrayList<String> a;
  public List<Integer> a;
  Observer jdField_a_of_type_JavaUtilObserver = new afke(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new afjv(this);
  }
  
  private void A()
  {
    nnt.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new afkb(this));
  }
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_Aobu != null)
    {
      localObject2 = this.jdField_a_of_type_Aobu.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Aobu.a())
        {
          this.jdField_a_of_type_Aobu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bgmo.a();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(this.app)) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, long paramLong1, short paramShort, String paramString6, String paramString7, boolean paramBoolean, String paramString8, long paramLong2, long paramLong3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    localBundle.putString("troop_code", paramString2);
    localBundle.putString("troop_info_name", paramString3);
    localBundle.putString("troop_info_owner", paramString4);
    localBundle.putString("troop_info_admi", paramString5);
    localBundle.putByte("troop_info_opt", paramByte);
    localBundle.putLong("troop_info_classext", paramLong1);
    localBundle.putShort("troop_info_faceid", paramShort);
    localBundle.putString("troop_info_fingermemo", paramString6);
    localBundle.putString("troop_info_loca", paramString7);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString8);
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
    localTextView.setTextColor(getResources().getColor(2131167060));
    localTextView.setPadding(getResources().getDimensionPixelSize(2131299041), zlx.a(this, 20.0F), 0, zlx.a(this, 10.0F));
    localTextView.setFocusable(true);
    return localTextView;
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
    paramContext = bgap.a(paramContext).a(paramContext, (String)localObject);
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
              if (paramContext.jdField_a_of_type_JavaLangString.equals(anni.a(2131714127)))
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
      paramView = paramView.findViewById(2131376274);
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        bfup.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt, false);
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
        if (!bfup.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
          m = 0;
        }
      }
      if ((m != 0) && (bfup.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt))) {
        b(paramInt, paramBoolean);
      }
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755823);
    localReportDialog.setContentView(2131561111);
    ((TextView)localReportDialog.findViewById(2131365514)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365502);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365500);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365506);
    localTextView1.setText(String.format(getString(2131693020), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694081);
    localTextView3.setText(2131693001);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new afjq(this, localReportDialog, paramLong1, paramInt2, paramLong2, paramLong3, paramString));
    localTextView3.setOnClickListener(new afjr(this, localReportDialog));
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
    this.jdField_b_of_type_AndroidViewView = super.getLayoutInflater().inflate(2131560575, paramXListView, false);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378750);
    ((ImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364539)).setOnClickListener(new afjz(this, paramXListView));
    paramXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    k();
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
        bcst.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, str2, (String)localObject, str1, "");
        QQToast.a(this, 1, paramString, 1).b(getTitleBarHeight());
        if (paramBoolean)
        {
          ((anwd)this.app.a(20)).notifyUI(111, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
          this.k = true;
          finish();
        }
        return;
        switch ((int)paramLong1)
        {
        default: 
          paramString = getString(2131693015);
          break;
        case 1281: 
          paramString = getString(2131693016);
          break;
        case 1282: 
          paramString = getString(2131693017);
          break;
        case 1283: 
          paramString = getString(2131693018);
          break;
        case 1793: 
          paramString = getString(2131693019);
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
      bcst.b((QQAppInterface)localObject, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, str1, str2, paramString, "");
      if (this.jdField_h_of_type_Boolean) {
        break;
      }
      QQToast.a(this, 2, getString(2131693022), 1).b(getTitleBarHeight());
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
      bcst.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
      return getString(2131696795);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
    {
      bcst.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
      return getString(2131696793);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15))
    {
      bcst.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      return getString(2131696794);
    }
    if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption)
    {
      bcst.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "3", "", "");
      return getString(2131696792);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131696791);
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
        localView = ((View)localObject).findViewById(2131376274);
        if (paramInt != 8) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = ((View)localObject).findViewById(2131378453);; localObject = ((View)localObject).findViewById(2131364999))
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
        m = getResources().getDimensionPixelSize(2131298377);
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
      if ((!aqxg.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
        break label192;
      }
      bool = anxa.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
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
      String str3 = anni.a(2131714129);
      afju localafju = new afju(this, bool);
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
      VipUtils.a(this, str1, str2, str3, localafju, (String)localObject, paramInt, bool);
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
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
      bcst.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label319;
      }
    }
    label319:
    for (localObject = "1";; localObject = "0")
    {
      bgjt.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { str1, localObject });
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
        localView = localView.findViewById(2131376273);
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
          w();
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
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.jdField_c_of_type_Long != 0L))
    {
      d();
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
    {
    default: 
      return;
    case 0: 
    case 1: 
      j();
      return;
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long) && (this.jdField_b_of_type_Int == 0))
    {
      localObject = bglp.a(this, 230);
      ((bgpa)localObject).setTitle(null);
      ((bgpa)localObject).setMessage(getString(2131693005, new Object[] { this.jdField_a_of_type_Long + "" }));
      ((bgpa)localObject).setPositiveButton(getString(2131693003), new bgmc());
      ((bgpa)localObject).setPositiveButtonContentDescription(getString(2131693003));
      ((bgpa)localObject).show();
      return;
    }
    Object localObject = b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      a((String)localObject);
      return;
    }
    t();
  }
  
  private void r()
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
        localDrawable.setBounds(0, 0, bclx.a(32.0F), bclx.a(32.0F));
        localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
        a(11, 2, localView, getString(2131698389), localSpannableString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        a(11, false);
      }
    }
    while (this.jdField_h_of_type_Boolean)
    {
      c(11, true);
      return;
      label125:
      a(11, 2, localView, getString(2131698389), anni.a(2131714126), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(11, true);
    }
    c(11, false);
  }
  
  private void s()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    ArrayList localArrayList = new ArrayList();
    akgy.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
    if (localArrayList.size() == 0)
    {
      a(12, 2, localView, getString(2131718886), anni.a(2131714130), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(12, true);
    }
    for (;;)
    {
      localView.setTag(2131718886, Integer.valueOf(localArrayList.size()));
      return;
      String str = bfpi.b(bfpi.a(((akeh)localArrayList.get(0)).jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1));
      URLDrawable localURLDrawable = null;
      Object localObject1 = null;
      int m = bclx.a(30.0F);
      localObject3 = localURLDrawable;
      try
      {
        URL localURL = akgy.a(str);
        if (localURL != null)
        {
          localObject3 = localURLDrawable;
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = bdzx.a;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = m;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = m;
          localObject3 = localURLDrawable;
          localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject1);
          localObject3 = localURLDrawable;
          localURLDrawable.setTag(new int[] { m, m, 0 });
          localObject3 = localURLDrawable;
          localURLDrawable.setDecodeHandler(bgey.d);
          localObject1 = localURLDrawable;
          localObject3 = localURLDrawable;
          if (localURLDrawable.getStatus() != 1)
          {
            localObject3 = localURLDrawable;
            localURLDrawable.setURLDrawableListener(new afkg(this));
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
      a(12, 2, localView, getString(2131718886), (CharSequence)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(12, false);
    }
  }
  
  private void t()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject = bglp.a(this, 230);
      ((bgpa)localObject).setTitle(null);
      long l2 = this.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      ((bgpa)localObject).setMessage(getString(2131693023, new Object[] { l1 + "" }));
      ((bgpa)localObject).setNegativeButton(getString(2131693003), new afkj(this));
      ((bgpa)localObject).setPositiveButton(getString(2131692981), new afjm(this));
      ((bgpa)localObject).show();
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (localObject = "0";; localObject = "1")
      {
        bcst.b(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_exp", 0, 0, str, (String)localObject, "", "");
        return;
      }
    }
    j();
  }
  
  private void u()
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
    a(2131718791, 1);
  }
  
  private void v()
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
        if (((anmw)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
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
  
  private void w()
  {
    ThreadManager.post(new TroopInfoActivity.24(this), 5, null, true);
  }
  
  private void x()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.post(new TroopInfoActivity.25(this), 5, null, true);
  }
  
  private void y()
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378487);
      if ((2 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) && (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)) {
        break label520;
      }
    }
    label520:
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
          m = 2131696800;
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
            m = 2131696801;
            localSharedPreferences.edit().putBoolean("has_shown_tips", true).commit();
            continue;
            if (a(m, 1))
            {
              if (a(m, 2))
              {
                if ((a(m, 4)) || (a(m, 8)) || (a(m, 16)))
                {
                  m = 2131696814;
                  continue;
                }
                m = 2131696813;
                continue;
              }
              if (a(m, 8))
              {
                m = 2131696807;
                continue;
              }
              if (a(m, 4))
              {
                m = 2131696806;
                continue;
              }
              m = 2131696805;
              continue;
            }
            if (a(m, 2))
            {
              if (a(m, 4))
              {
                m = 2131696812;
                continue;
              }
              if ((a(m, 8)) || (a(m, 16)))
              {
                m = 2131696811;
                continue;
              }
              m = 2131696810;
              continue;
            }
            if ((a(m, 8)) && (a(m, 4)))
            {
              m = 2131696802;
              continue;
            }
            if (a(m, 8))
            {
              m = 2131696804;
              continue;
            }
            if (a(m, 4)) {
              m = 2131696803;
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
  
  private void z()
  {
    startTitleProgress();
    nnt.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new afka(this));
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {
      return getString(2131696809);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      return getString(2131696808);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2) {
      return getString(2131696795);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15) {
      return getString(2131696794);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131696791);
    }
    return "";
  }
  
  protected void a()
  {
    long l = System.currentTimeMillis();
    View localView = View.inflate(this, 2131561596, null);
    Object localObject1 = (ListView)localView.findViewById(2131363986);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(anni.a(2131714124));
    ((ArrayList)localObject2).add(anni.a(2131714123));
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364860));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[13];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
    localObject1 = new bkqn(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838758);
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
        localObject1 = getString(2131718866);
      }
    }
    else
    {
      setTitle((CharSequence)localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
      {
        localObject1 = View.inflate(this, 2131561602, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        a(7, 0, (View)localObject1, getString(2131692972), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
        localObject1 = View.inflate(this, 2131561617, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      if (this.jdField_h_of_type_Boolean)
      {
        localObject1 = a(anni.a(2131718835));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject1 = View.inflate(this, 2131561602, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      ((View)localObject1).setTag(Integer.valueOf(10));
      a(10, 2, (View)localObject1, getString(2131691622), "", true);
      b();
      a((View)localObject1);
      localObject1 = View.inflate(this, 2131561602, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[11] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      r();
      ((View)localObject1).setOnClickListener(this);
      if (this.jdField_h_of_type_Boolean)
      {
        localObject1 = a(anni.a(2131718716));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject1 = View.inflate(this, 2131561602, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      s();
      ((View)localObject1).setOnClickListener(this);
      localObject1 = View.inflate(this, 2131561602, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(5, 2, (View)localObject1, getString(2131718887), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      l();
      localObject1 = View.inflate(this, 2131561602, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(4, 2, (View)localObject1, getString(2131718717), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      localObject1 = View.inflate(this, 2131561601, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(8, 3, (View)localObject1, getString(2131718718), null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim(), 1);
      if (this.jdField_h_of_type_Boolean) {
        ((View)localObject1).setBackgroundResource(2130839442);
      }
      ThreadManager.post(new TroopInfoActivity.2(this), 8, null, true);
      if (!this.jdField_h_of_type_Boolean)
      {
        localObject1 = View.inflate(this, 2131561617, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      localObject2 = View.inflate(this, 2131561608, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label1116;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      label873:
      a(6, 3, (View)localObject2, getString(2131693048), (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      if (!this.jdField_h_of_type_Boolean)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.mDensity));
        localObject2 = View.inflate(this, 2131561617, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363750);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363667));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label1139;
      }
      if (!this.jdField_h_of_type_Boolean) {
        break label1130;
      }
      b(17);
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
      this.leftView.setOnClickListener(new afkd(this));
      this.rightViewText.setOnClickListener(new afkf(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l));
      }
      return;
      localObject1 = getString(2131718774);
      break;
      label1116:
      localObject1 = getResources().getString(2131695464);
      break label873;
      label1130:
      b(13);
      continue;
      label1139:
      b(14);
    }
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    bgpa localbgpa = bglp.a(this, 230);
    localbgpa.setTitle(str);
    localbgpa.setMessage(null);
    localbgpa.setPositiveButton(getString(2131693010), new afjn(this, localbgpa));
    localbgpa.setPositiveButtonContentDescription(getString(2131693010));
    localbgpa.setNegativeButton(getString(2131692981), new bgmc());
    localbgpa.setNegativeButtonContentDescription(getString(2131692981));
    localbgpa.show();
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
        TextView localTextView1 = (TextView)paramView.findViewById(2131378776);
        localTextView2 = (TextView)paramView.findViewById(2131368563);
        localView = paramView.findViewById(2131362936);
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
      paramView.setBackgroundResource(2130839432);
      break label48;
      paramView.setBackgroundResource(2130839448);
      break label48;
      paramView.setBackgroundResource(2130839442);
      break label48;
      paramView.setBackgroundResource(2130839439);
      break label48;
      localTextView2.setVisibility(0);
      localTextView2.setText(new bdnt(paramCharSequence, 11, 20));
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
    TextView localTextView = (TextView)paramView.findViewById(2131378776);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131362936);
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
    paramView.setBackgroundResource(2130839432);
    return;
    paramView.setBackgroundResource(2130839448);
    return;
    paramView.setBackgroundResource(2130839442);
    return;
    paramView.setBackgroundResource(2130839439);
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
        localTextView = (TextView)localView1.findViewById(2131368563);
        localView2 = localView1.findViewById(2131362936);
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
        localTextView.setText(new bdnt(paramString, 11, 20));
      }
      label189:
      String str = paramString;
      if (paramInt == 4)
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label228;
        }
        str = anni.a(2131714132);
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
        localLinearLayout = (LinearLayout)localView.findViewById(2131364588);
        localLinearLayout.removeAllViews();
        localObject1 = (LinearLayout)localView.findViewById(2131378453);
        localObject2 = (TextView)localView.findViewById(2131368563);
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          localLinearLayout.setVisibility(8);
          ((TextView)localObject2).setText(anni.a(2131714133));
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
          ((TextView)localObject1).setId(2131373761);
          int m = 2130843789;
          if (paramInt2 == 1) {
            m = 2130843790;
          }
          for (;;)
          {
            localObject2 = getResources().getDrawable(m);
            ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject2);
            ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
            ((TextView)localObject1).setTextSize(2, 15.0F);
            if (paramBoolean2) {
              ((TextView)localObject1).setMaxWidth(afur.a(77.0F, getResources()));
            }
            ((TextView)localObject1).setSingleLine();
            ((TextView)localObject1).setTextColor(getResources().getColor(2131167143));
            ((TextView)localObject1).setPadding(afur.a(6.0F, getResources()), afur.a(2.0F, getResources()), afur.a(8.0F, getResources()), afur.a(2.0F, getResources()));
            ((TextView)localObject1).setGravity(17);
            ((TextView)localObject1).setText((CharSequence)paramArrayList.get(n));
            ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).leftMargin = afur.a(5.0F, getResources());
            localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break;
            if (paramInt2 == 2) {
              m = 2130843789;
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131362936);
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
        break label184;
      }
    }
    label184:
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
      localTextView = (TextView)paramView.findViewById(2131378776);
      paramView = (LinearLayout)paramView.findViewById(2131364999);
    } while ((localTextView == null) || (paramView == null) || (TextUtils.isEmpty(localTextView.getText())));
    int m = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_h_of_type_Boolean)
    {
      paramView.leftMargin = (afur.a(100.0F, getResources()) + m);
      return;
    }
    paramView.leftMargin = (afur.a(90.0F, getResources()) + m);
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
    bcst.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
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
      w();
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
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)((Bundle)localObject).getByte("troop_info_opt"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = bgju.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = bgju.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    String str;
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
        break label106;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      ((TextView)localView.findViewById(2131368563)).setText(str);
      if (!str.equals(anni.a(2131700566))) {
        break label116;
      }
      a(10, true);
      label64:
      if (!this.jdField_h_of_type_Boolean) {
        break label126;
      }
      c(10, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("updateTroopNameEntry %s", new Object[] { str }));
      }
      return;
      label106:
      str = anni.a(2131700566);
      break;
      label116:
      a(10, false);
      break label64;
      label126:
      c(10, false);
    }
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 15: 
    case 16: 
    default: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    case 13: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setEnabled(true);
      this.rightViewText.setText(2131693029);
      return;
    case 14: 
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693153);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(14));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131718853);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(17));
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
    k();
    biau localbiau = new biau(this, getTitleBarHeight());
    localbiau.a(paramString);
    localbiau.setCancelable(false);
    localbiau.setOnDismissListener(new afjs(this));
    this.jdField_a_of_type_AndroidAppDialog = localbiau;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
      }
      ThreadManager.post(new TroopInfoActivity.6(this), 5, null, false);
    }
  }
  
  protected void d()
  {
    if (((this.jdField_c_of_type_Long != 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L)) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount <= 0)
      {
        localObject = bglp.a(this, 230);
        ((bgpa)localObject).setTitle(null);
        ((bgpa)localObject).setMessage(getString(2131696790));
        ((bgpa)localObject).setPositiveButton(getString(2131693003), new bgmc());
        ((bgpa)localObject).setPositiveButtonContentDescription(getString(2131693003));
        ((bgpa)localObject).show();
        return;
      }
      if (this.jdField_e_of_type_Boolean)
      {
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bglp.a(this, 230);
          ((bgpa)localObject).setTitle(null);
          ((bgpa)localObject).setMessage(getString(2131696789, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount) }));
          ((bgpa)localObject).setPositiveButton(getString(2131693003), new afkh(this));
          ((bgpa)localObject).setNegativeButton(getString(2131692981), new afki(this));
          ((bgpa)localObject).show();
          return;
        }
        a((String)localObject);
        return;
      }
      j();
      return;
    }
    j();
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
    //   0: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 520
    //   9: iconst_2
    //   10: new 351	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1834
    //   20: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc_w 1836
    //   30: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 1838
    //   40: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_3
    //   44: invokevirtual 1404	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 523	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iconst_m1
    //   54: iload_2
    //   55: if_icmpne +77 -> 132
    //   58: iload_1
    //   59: lookupswitch	default:+73->132, 5:+468->527, 7:+130->189, 8:+652->711, 9:+831->890, 11:+561->620, 16:+201->260, 18:+987->1046, 257:+946->1005
    //   133: sipush 258
    //   136: if_icmpne +1100 -> 1236
    //   139: aload_3
    //   140: ifnull +44 -> 184
    //   143: aload_3
    //   144: ldc_w 1840
    //   147: invokevirtual 1844	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   150: astore_3
    //   151: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +30 -> 184
    //   157: aload_3
    //   158: ifnonnull +1065 -> 1223
    //   161: aconst_null
    //   162: astore_3
    //   163: ldc_w 520
    //   166: iconst_2
    //   167: ldc_w 1846
    //   170: iconst_1
    //   171: anewarray 326	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload_3
    //   177: aastore
    //   178: invokestatic 342	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   181: invokestatic 523	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_0
    //   185: invokespecial 697	com/tencent/mobileqq/activity/TroopInfoActivity:s	()V
    //   188: return
    //   189: aload_3
    //   190: ifnull -58 -> 132
    //   193: aload_3
    //   194: invokevirtual 1264	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   197: ifnull -65 -> 132
    //   200: aload_3
    //   201: invokevirtual 1264	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   204: astore 10
    //   206: aload_0
    //   207: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   210: aload 10
    //   212: ldc_w 1848
    //   215: invokevirtual 1268	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   218: putfield 653	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   221: aload_0
    //   222: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   225: aload 10
    //   227: ldc_w 1850
    //   230: iconst_0
    //   231: invokevirtual 1679	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   234: putfield 1603	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLat	I
    //   237: aload_0
    //   238: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   241: aload 10
    //   243: ldc_w 1852
    //   246: iconst_0
    //   247: invokevirtual 1679	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   250: putfield 1609	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLon	I
    //   253: aload_0
    //   254: invokevirtual 1294	com/tencent/mobileqq/activity/TroopInfoActivity:l	()V
    //   257: goto -125 -> 132
    //   260: aload_3
    //   261: ifnull -129 -> 132
    //   264: aload_3
    //   265: invokevirtual 1264	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   268: ifnull -136 -> 132
    //   271: aload_3
    //   272: invokevirtual 1264	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   275: astore 10
    //   277: aload_0
    //   278: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   281: getfield 653	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   284: aload 10
    //   286: ldc_w 1848
    //   289: invokevirtual 1268	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   292: invokestatic 1857	bgjw:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   295: ifne +8 -> 303
    //   298: aload_0
    //   299: iconst_1
    //   300: putfield 998	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   303: aload_0
    //   304: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   307: aload 10
    //   309: ldc_w 1859
    //   312: invokevirtual 1268	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   315: putfield 1703	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   318: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +36 -> 357
    //   324: ldc_w 349
    //   327: iconst_2
    //   328: new 351	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 1861
    //   338: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   345: getfield 1703	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   348: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 1742	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload_0
    //   358: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   361: getfield 1703	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   364: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   367: ifne +39 -> 406
    //   370: aload_0
    //   371: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   374: getfield 1703	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   377: ldc_w 1863
    //   380: invokevirtual 1867	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   383: astore 11
    //   385: aload 11
    //   387: arraylength
    //   388: iconst_5
    //   389: if_icmplt +96 -> 485
    //   392: aload_0
    //   393: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   396: aload 11
    //   398: iconst_4
    //   399: aaload
    //   400: invokestatic 1667	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   403: putfield 1870	com/tencent/mobileqq/troopinfo/TroopInfoData:mPoiId	J
    //   406: aload_0
    //   407: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   410: aload 10
    //   412: ldc_w 1848
    //   415: invokevirtual 1268	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   418: putfield 653	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   421: aload_0
    //   422: invokevirtual 1294	com/tencent/mobileqq/activity/TroopInfoActivity:l	()V
    //   425: goto -293 -> 132
    //   428: astore 12
    //   430: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq -27 -> 406
    //   436: ldc_w 520
    //   439: iconst_2
    //   440: new 351	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 1872
    //   450: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload 11
    //   455: iconst_4
    //   456: aaload
    //   457: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc_w 1874
    //   463: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   470: getfield 1703	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   473: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 1742	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: goto -76 -> 406
    //   485: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq -82 -> 406
    //   491: ldc_w 520
    //   494: iconst_2
    //   495: new 351	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 1876
    //   505: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_0
    //   509: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   512: getfield 1703	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   515: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 1878	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: goto -118 -> 406
    //   527: aload_3
    //   528: ldc_w 1880
    //   531: invokevirtual 1883	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   534: astore 10
    //   536: aload 10
    //   538: aload_0
    //   539: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   542: getfield 657	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   545: invokestatic 1886	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   548: ifne -416 -> 132
    //   551: aload_0
    //   552: iconst_1
    //   553: putfield 998	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   556: aload_0
    //   557: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   560: aload 10
    //   562: putfield 657	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   565: aload_0
    //   566: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   569: getfield 657	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   572: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   575: ifne +30 -> 605
    //   578: aload_0
    //   579: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   582: getfield 657	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   585: astore 10
    //   587: aload_0
    //   588: bipush 6
    //   590: aload 10
    //   592: aload_0
    //   593: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   596: invokevirtual 713	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   599: invokevirtual 798	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILjava/lang/String;Z)V
    //   602: goto -470 -> 132
    //   605: aload_0
    //   606: invokevirtual 286	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   609: ldc_w 1354
    //   612: invokevirtual 1355	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   615: astore 10
    //   617: goto -30 -> 587
    //   620: ldc2_w 1887
    //   623: lstore 7
    //   625: aload_3
    //   626: ldc_w 1890
    //   629: invokevirtual 1883	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   632: invokestatic 1667	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   635: lstore 5
    //   637: aload_0
    //   638: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   641: getfield 369	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   644: lload 5
    //   646: lcmp
    //   647: ifeq -515 -> 132
    //   650: lload 5
    //   652: ldc2_w 1887
    //   655: lcmp
    //   656: ifeq -524 -> 132
    //   659: aload_0
    //   660: iconst_1
    //   661: putfield 998	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   664: aload_0
    //   665: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   668: lload 5
    //   670: putfield 369	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   673: aload_0
    //   674: invokespecial 792	com/tencent/mobileqq/activity/TroopInfoActivity:w	()V
    //   677: goto -545 -> 132
    //   680: astore 10
    //   682: lload 7
    //   684: lstore 5
    //   686: invokestatic 347	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   689: ifeq -52 -> 637
    //   692: ldc_w 520
    //   695: iconst_2
    //   696: aload 10
    //   698: invokevirtual 521	java/lang/Exception:toString	()Ljava/lang/String;
    //   701: invokestatic 523	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: lload 7
    //   706: lstore 5
    //   708: goto -71 -> 637
    //   711: aload_0
    //   712: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   715: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   718: iconst_2
    //   719: if_icmpeq +159 -> 878
    //   722: aload_0
    //   723: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   726: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   729: bipush 6
    //   731: if_icmpeq +147 -> 878
    //   734: aload_0
    //   735: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   738: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   741: bipush 15
    //   743: if_icmpeq +135 -> 878
    //   746: aload_0
    //   747: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   750: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   753: bipush 10
    //   755: if_icmpeq +123 -> 878
    //   758: aload_0
    //   759: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   762: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   765: bipush 11
    //   767: if_icmpeq +111 -> 878
    //   770: aload_0
    //   771: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   774: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   777: bipush 19
    //   779: if_icmpeq +99 -> 878
    //   782: aload_0
    //   783: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   786: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   789: bipush 101
    //   791: if_icmpeq +87 -> 878
    //   794: aload_0
    //   795: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   798: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   801: bipush 102
    //   803: if_icmpeq +75 -> 878
    //   806: aload_0
    //   807: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   810: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   813: bipush 103
    //   815: if_icmpeq +63 -> 878
    //   818: aload_0
    //   819: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   822: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   825: bipush 104
    //   827: if_icmpeq +51 -> 878
    //   830: aload_0
    //   831: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   834: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   837: bipush 105
    //   839: if_icmpeq +39 -> 878
    //   842: aload_0
    //   843: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   846: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   849: bipush 106
    //   851: if_icmpeq +27 -> 878
    //   854: aload_0
    //   855: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   858: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   861: bipush 112
    //   863: if_icmpne +15 -> 878
    //   866: aload_0
    //   867: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   870: getfield 1674	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   873: bipush 113
    //   875: if_icmpeq -743 -> 132
    //   878: aload_0
    //   879: iconst_m1
    //   880: invokevirtual 1893	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   883: aload_0
    //   884: invokevirtual 627	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   887: goto -755 -> 132
    //   890: aload_3
    //   891: ldc_w 1895
    //   894: invokevirtual 1883	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   897: astore 11
    //   899: aload 11
    //   901: ifnull -769 -> 132
    //   904: aload 11
    //   906: invokevirtual 649	java/lang/String:length	()I
    //   909: ifle -777 -> 132
    //   912: new 69	java/util/ArrayList
    //   915: dup
    //   916: invokespecial 70	java/util/ArrayList:<init>	()V
    //   919: astore 10
    //   921: new 1897	org/json/JSONArray
    //   924: dup
    //   925: invokespecial 1898	org/json/JSONArray:<init>	()V
    //   928: pop
    //   929: new 1897	org/json/JSONArray
    //   932: dup
    //   933: aload 11
    //   935: invokespecial 1900	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   938: astore 11
    //   940: iconst_0
    //   941: istore_2
    //   942: aload 11
    //   944: invokevirtual 1901	org/json/JSONArray:length	()I
    //   947: istore 4
    //   949: iload_2
    //   950: iload 4
    //   952: if_icmpge +26 -> 978
    //   955: aload 10
    //   957: aload 11
    //   959: iload_2
    //   960: invokevirtual 1902	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   963: invokeinterface 1650 2 0
    //   968: pop
    //   969: iload_2
    //   970: iconst_1
    //   971: iadd
    //   972: istore_2
    //   973: goto -31 -> 942
    //   976: astore 11
    //   978: aload_0
    //   979: iconst_1
    //   980: putfield 998	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   983: aload_0
    //   984: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   987: aload 10
    //   989: putfield 390	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   992: aload_0
    //   993: getfield 104	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   996: bipush 6
    //   998: invokevirtual 1661	android/os/Handler:sendEmptyMessage	(I)Z
    //   1001: pop
    //   1002: goto -870 -> 132
    //   1005: aload_0
    //   1006: getfield 1904	com/tencent/mobileqq/activity/TroopInfoActivity:j	Z
    //   1009: ifeq +20 -> 1029
    //   1012: aload_0
    //   1013: getfield 1906	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Akgn	Lakgn;
    //   1016: ifnull -884 -> 132
    //   1019: aload_0
    //   1020: getfield 1906	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Akgn	Lakgn;
    //   1023: invokevirtual 1909	akgn:d	()V
    //   1026: goto -894 -> 132
    //   1029: aload_0
    //   1030: getfield 1911	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Akgq	Lakgq;
    //   1033: ifnull -901 -> 132
    //   1036: aload_0
    //   1037: getfield 1911	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Akgq	Lakgq;
    //   1040: invokevirtual 1914	akgq:d	()V
    //   1043: goto -911 -> 132
    //   1046: iload_2
    //   1047: iconst_m1
    //   1048: if_icmpne -916 -> 132
    //   1051: aload_3
    //   1052: ifnull -920 -> 132
    //   1055: aload_0
    //   1056: invokestatic 1919	bgnt:g	(Landroid/content/Context;)Z
    //   1059: ifne +21 -> 1080
    //   1062: aload_0
    //   1063: iconst_1
    //   1064: ldc_w 1920
    //   1067: iconst_0
    //   1068: invokestatic 1373	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   1071: aload_0
    //   1072: invokevirtual 605	com/tencent/mobileqq/activity/TroopInfoActivity:getTitleBarHeight	()I
    //   1075: invokevirtual 608	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   1078: pop
    //   1079: return
    //   1080: aload_3
    //   1081: ldc_w 1880
    //   1084: invokevirtual 1883	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1087: astore 10
    //   1089: aload 10
    //   1091: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1094: ifne -962 -> 132
    //   1097: aload_0
    //   1098: getfield 667	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1101: ifnull -969 -> 132
    //   1104: aload 10
    //   1106: aload_0
    //   1107: getfield 667	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1110: getfield 1923	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   1113: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1116: ifne -984 -> 132
    //   1119: aload_0
    //   1120: getfield 129	com/tencent/mobileqq/activity/TroopInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: bipush 22
    //   1125: invokevirtual 613	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanii;
    //   1128: checkcast 1925	anie
    //   1131: astore 11
    //   1133: aload_0
    //   1134: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1137: invokevirtual 713	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   1140: ifne +77 -> 1217
    //   1143: aload_0
    //   1144: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1147: getfield 1928	com/tencent/mobileqq/troopinfo/TroopInfoData:allowMemberModifTroopName	I
    //   1150: iconst_1
    //   1151: if_icmpne +66 -> 1217
    //   1154: iconst_1
    //   1155: istore 9
    //   1157: aload 11
    //   1159: aload_0
    //   1160: getfield 667	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1163: getfield 925	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1166: aload 10
    //   1168: iload 9
    //   1170: invokevirtual 1931	anie:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1173: aload_0
    //   1174: getfield 667	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1177: aload_0
    //   1178: getfield 667	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1181: getfield 1923	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   1184: putfield 1934	com/tencent/mobileqq/data/TroopInfo:oldTroopName	Ljava/lang/String;
    //   1187: aload_0
    //   1188: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1191: aload 10
    //   1193: putfield 646	com/tencent/mobileqq/troopinfo/TroopInfoData:troopName	Ljava/lang/String;
    //   1196: aload_0
    //   1197: getfield 65	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1200: aload_0
    //   1201: getfield 667	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1204: invokevirtual 1937	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   1207: putfield 1694	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   1210: aload_0
    //   1211: invokevirtual 1287	com/tencent/mobileqq/activity/TroopInfoActivity:b	()V
    //   1214: goto -1082 -> 132
    //   1217: iconst_0
    //   1218: istore 9
    //   1220: goto -63 -> 1157
    //   1223: aload_3
    //   1224: invokeinterface 1941 1 0
    //   1229: invokestatic 1946	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   1232: astore_3
    //   1233: goto -1070 -> 163
    //   1236: iload_1
    //   1237: sipush 260
    //   1240: if_icmpne -1052 -> 188
    //   1243: aload_0
    //   1244: invokespecial 815	com/tencent/mobileqq/activity/TroopInfoActivity:r	()V
    //   1247: return
    //   1248: astore 12
    //   1250: goto -281 -> 969
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1253	0	this	TroopInfoActivity
    //   0	1253	1	paramInt1	int
    //   0	1253	2	paramInt2	int
    //   0	1253	3	paramIntent	Intent
    //   947	6	4	m	int
    //   635	72	5	l1	long
    //   623	82	7	l2	long
    //   1155	64	9	bool	boolean
    //   204	412	10	localObject1	Object
    //   680	17	10	localException	Exception
    //   919	273	10	localObject2	Object
    //   383	575	11	localObject3	Object
    //   976	1	11	localJSONException1	org.json.JSONException
    //   1131	27	11	localanie	anie
    //   428	1	12	localNumberFormatException	NumberFormatException
    //   1248	1	12	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   392	406	428	java/lang/NumberFormatException
    //   625	637	680	java/lang/Exception
    //   929	940	976	org/json/JSONException
    //   942	949	976	org/json/JSONException
    //   955	969	1248	org/json/JSONException
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
        p();
      }
      this.jdField_a_of_type_Aobu = new aobu(this, this.app);
      this.jdField_a_of_type_Aobu.a(this);
      a();
      addObserver(this.jdField_a_of_type_Anif);
      paramBundle = (anie)this.app.a(22);
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
      nlh.a(this.app, 78);
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      int m = this.jdField_g_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (paramBundle = "0";; paramBundle = "1")
      {
        bcst.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str, String.valueOf(m), paramBundle, "");
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
    bgap.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_Anxg);
    removeObserver(this.jdField_a_of_type_Anmu);
    removeObserver(this.jdField_a_of_type_Anif);
    if (this.jdField_g_of_type_Boolean) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_g_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bfqt != null) {
        this.jdField_a_of_type_Bfqt.b(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (this.jdField_a_of_type_Akgq != null) {
        this.jdField_a_of_type_Akgq.f();
      }
      if (this.jdField_a_of_type_Akgn != null) {
        this.jdField_a_of_type_Akgn.f();
      }
      if (this.jdField_a_of_type_Aobu != null) {
        this.jdField_a_of_type_Aobu.d();
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
      if (this.jdField_a_of_type_Akgn != null) {
        this.jdField_a_of_type_Akgn.a(str, paramIntent);
      }
    }
    label94:
    while (this.jdField_a_of_type_Akgq == null) {
      return;
    }
    this.jdField_a_of_type_Akgq.a(str, paramIntent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void e()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.i = true;
      finish();
      return;
    }
    a(2131693011);
  }
  
  public void f()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
  }
  
  public void finish()
  {
    k();
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 28) {
      setResult(-1, getIntent());
    }
    if (this.jdField_f_of_type_Boolean) {
      m();
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_Anwd = ((anwd)this.app.a(20));
    addObserver(this.jdField_a_of_type_Anxg);
    addObserver(this.jdField_a_of_type_Anmu);
    addObserver(this.jdField_a_of_type_Anif);
    ThreadManager.post(new TroopInfoActivity.12(this), 5, null, true);
  }
  
  protected void h()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    Object localObject3 = bgap.a(getApplicationContext()).a(this, (String)localObject1);
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
            if ((localObject3 == null) || (TextUtils.isEmpty(((bgao)localObject3).jdField_a_of_type_JavaLangString))) {
              break label311;
            }
            if (((bgao)localObject3).jdField_a_of_type_JavaLangString.equals(anni.a(2131714134)))
            {
              m = 0;
              break;
            }
            localObject1 = ((bgao)localObject3).jdField_a_of_type_JavaLangString;
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
  
  public void i()
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
      bcst.b(localQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, str2, str1, "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 16);
      return;
    }
  }
  
  public void j()
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
    Object localObject3 = this.app;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    Object localObject2;
    String str1;
    if (this.jdField_h_of_type_Boolean)
    {
      localObject2 = "2";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label142;
      }
      str1 = "0";
    }
    for (;;)
    {
      bcst.b((QQAppInterface)localObject3, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, str2, (String)localObject2, str1, "");
      localObject2 = (anie)this.app.a(22);
      if (localObject2 != null) {
        break label168;
      }
      this.k = true;
      finish();
      return;
      localObject2 = "1";
      break;
      label142:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        str1 = "1";
      } else {
        str1 = "2";
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
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.currentTroopLocationStruct;
    int i2 = 0;
    int i1 = 0;
    long l1 = 0L;
    long l4 = 0L;
    Object localObject1 = "";
    int m;
    long l2;
    int n;
    long l3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
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
        localObject3 = ((String)localObject3).split("\\|");
        m = i1;
        l2 = l1;
        n = i2;
        l3 = l1;
        i1 = Integer.valueOf(localObject3[0]).intValue();
        m = i1;
        l2 = l1;
        n = i1;
        l3 = l1;
        l1 = (Double.valueOf(localObject3[1]).doubleValue() * 1000000.0D);
        m = i1;
        l2 = l1;
        n = i1;
        l3 = l1;
        long l5 = (Double.valueOf(localObject3[2]).doubleValue() * 1000000.0D);
        localObject1 = localObject3[3];
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
      b(getString(2131693021));
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
          bcst.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        }
        if (((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) && ((i1 == 0) || (1 == i1))) {
          bcst.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) {
          break label795;
        }
        k();
        if (this.jdField_e_of_type_Int <= 0) {
          break label707;
        }
        a(l6, i1, m, l1, l2, (String)localObject1);
        bcst.b(this.app, "dc00899", "Grp_certified", "", "data", "exp_edit_data", 4, 0, "" + l6, "", "", "");
        return;
      }
      label707:
      if (this.jdField_d_of_type_Int <= 0) {
        break;
      }
      localObject1 = bglp.a(this, 230);
      ((bgpa)localObject1).setTitle(null);
      ((bgpa)localObject1).setMessage(getString(2131693013, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
      ((bgpa)localObject1).setPositiveButton(getString(2131693003), new bgmc());
      ((bgpa)localObject1).setPositiveButtonContentDescription(getString(2131693003));
      ((bgpa)localObject1).show();
      return;
      label795:
      if (((2 == this.jdField_a_of_type_Int) || (4 == this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4)))
      {
        localObject2 = localObject1;
        l4 = l1;
        l3 = l2;
        if (0L == l1)
        {
          localObject2 = localObject1;
          l4 = l1;
          l3 = l2;
          if (0L == l2)
          {
            l4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat;
            l3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
          }
        }
        bcst.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        nnt.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, m, l4, l3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, n, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new afjo(this));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.jdField_c_of_type_Long != 0L))
      {
        nnt.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, m, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, n, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new afjp(this));
        return;
      }
      ((anie)localObject2).a(l6, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, m, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      return;
      m = 0;
      l2 = l4;
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void l()
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
        a(5, anni.a(2131714125), true);
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
  
  public void m()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    startActivity(localIntent);
  }
  
  public void n()
  {
    try
    {
      if (this.jdField_a_of_type_Biau == null)
      {
        this.jdField_a_of_type_Biau = new biau(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Biau.c(2131694158);
        this.jdField_a_of_type_Biau.c(false);
      }
      this.jdField_a_of_type_Biau.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void o()
  {
    try
    {
      if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
        this.jdField_a_of_type_Biau.dismiss();
      }
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
    e();
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
    label176:
    label327:
    label747:
    Object localObject2;
    label274:
    label917:
    label923:
    label1182:
    switch (i1)
    {
    case 3: 
    case 7: 
    case 13: 
    case 15: 
    case 16: 
    default: 
    case 4: 
    case 8: 
    case 9: 
    case 5: 
    case 6: 
    case 14: 
    case 2: 
    case 10: 
    case 17: 
    case 12: 
      label820:
      label860:
      label865:
      label994:
      label1136:
      label1266:
      label1272:
      label1279:
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_f_of_type_Int == 1)
          {
            QQToast.a(getApplicationContext(), 1, anni.a(2131714128), 0).a();
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
                break label274;
              }
              localObject1 = "0";
            }
            for (;;)
            {
              bcst.b((QQAppInterface)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_category", 0, 0, str, (String)localObject3, (String)localObject1, "");
              localObject1 = new Intent(getActivity(), TroopClassChoiceActivity.class);
              ((Intent)localObject1).putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
              startActivityForResult((Intent)localObject1, 11);
              break;
              localObject3 = "1";
              break label176;
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
                break label393;
              }
              localObject1 = "0";
            }
            for (;;)
            {
              bcst.b((QQAppInterface)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_tag", 0, 0, str, (String)localObject3, (String)localObject1, "");
              h();
              a(i1, paramView);
              break;
              localObject3 = "1";
              break label327;
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
            i();
            a(i1, paramView);
            continue;
            localObject1 = new Intent(this, EditInfoActivity.class);
            ((Intent)localObject1).putExtra("edit_type", 1);
            ((Intent)localObject1).putExtra("title", getString(2131693048));
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
            if (!bgnt.d(this))
            {
              a(2131693946, 0);
            }
            else if (this.jdField_a_of_type_Anwd != null)
            {
              try
              {
                long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                n();
                this.jdField_a_of_type_Anwd.a(l, 8390784);
              }
              catch (Exception localException) {}
              if (QLog.isColorLevel())
              {
                QLog.i("Q.troopinfo", 2, localException.toString());
                continue;
                v();
                continue;
                boolean bool;
                int n;
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
                  {
                    m = 1;
                    if ((m == 0) || (!aqxg.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
                      break label943;
                    }
                    bool = anxa.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
                    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                      break label934;
                    }
                    localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                    if (!bool) {
                      break label917;
                    }
                    m = 15;
                    localObject4 = VipUtils.a(0, m).toString();
                    str = anni.a(2131700525);
                    afjt localafjt = new afjt(this, bool);
                    if (!bool) {
                      break label923;
                    }
                    localObject2 = "0X800A57F";
                    if (!bool) {
                      break label931;
                    }
                    VipUtils.a(this, (String)localObject3, (String)localObject4, str, localafjt, (String)localObject2, 1, bool);
                  }
                  for (;;)
                  {
                    bcst.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
                    break;
                    m = 0;
                    break label747;
                    m = 8;
                    break label820;
                    localObject2 = "0X8009E38";
                    break label860;
                    break label865;
                    VipUtils.a(this, bool);
                  }
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
                    break label1236;
                  }
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
                  localObject3 = localObject2;
                  if (localObject2 == null) {
                    localObject3 = "";
                  }
                  if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
                    break label1243;
                  }
                  n = 1;
                  localObject4 = new Intent(this, EditInfoActivity.class);
                  ((Intent)localObject4).putExtra("edit_type", 2);
                  if (m == 0) {
                    break label1248;
                  }
                  localObject2 = anni.a(2131700544);
                  ((Intent)localObject4).putExtra("title", (String)localObject2);
                  ((Intent)localObject4).putExtra("default_text", (String)localObject3);
                  ((Intent)localObject4).putExtra("max_num", 96);
                  ((Intent)localObject4).putExtra("canPostNull", false);
                  if (m == 0) {
                    break label1259;
                  }
                  localObject2 = anni.a(2131700529);
                  ((Intent)localObject4).putExtra("right_btn", (String)localObject2);
                  ((Intent)localObject4).putExtra("isTroopName", true);
                  if (m == 0) {
                    break label1266;
                  }
                  bool = true;
                  ((Intent)localObject4).putExtra("edit_mode", bool);
                  if (n == 0) {
                    break label1272;
                  }
                  localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                  ((Intent)localObject4).putExtra("troopUin", (String)localObject2);
                  startActivityForResult((Intent)localObject4, 18);
                  localObject4 = this.app;
                  str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                  if (!this.jdField_h_of_type_Boolean) {
                    break label1279;
                  }
                  localObject3 = "2";
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                    break label1287;
                  }
                  localObject2 = "0";
                }
                for (;;)
                {
                  bcst.b((QQAppInterface)localObject4, "dc00899", "Grp_set", "", "Grp_data", "add_name", 0, 0, str, (String)localObject3, (String)localObject2, "");
                  a(i1, paramView);
                  break;
                  localObject2 = "";
                  break label962;
                  n = 0;
                  break label994;
                  localObject2 = anni.a(2131700543);
                  break label1029;
                  localObject2 = "";
                  break label1084;
                  bool = false;
                  break label1112;
                  localObject2 = "";
                  break label1136;
                  localObject3 = "1";
                  break label1182;
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                    localObject2 = "1";
                  } else {
                    localObject2 = "2";
                  }
                }
                if (!bgnt.g(this))
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName)) {
                    QQToast.a(this, 1, 2131693949, 0).b(getTitleBarHeight());
                  } else if (!this.jdField_e_of_type_Boolean) {
                    q();
                  } else {
                    QQToast.a(this, 1, 2131693949, 0).b(getTitleBarHeight());
                  }
                }
                else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName)) {
                  a(2131718856);
                } else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead)) {
                  a(2131718854);
                } else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName)) {
                  a(2131718855);
                } else {
                  q();
                }
              }
            }
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
      label931:
      label934:
      label943:
      label962:
      label1112:
      label1243:
      label1248:
      label1259:
      localObject2 = paramView.getTag(2131718886);
      label1084:
      label1236:
      if ((localObject2 == null) || (!(localObject2 instanceof Integer))) {
        break;
      }
    }
    label393:
    for (int m = ((Integer)localObject2).intValue();; m = 0)
    {
      if (m > 0)
      {
        c(12);
        label1559:
        if (this.jdField_a_of_type_Bfqt == null)
        {
          this.jdField_a_of_type_Bfqt = new bfqt(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bfum.class, this.jdField_a_of_type_Anwd);
          this.jdField_a_of_type_Bfqt.a(this.jdField_a_of_type_JavaUtilObserver);
        }
        a(i1, paramView);
        localObject3 = this.app;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_h_of_type_Boolean) {
          break label1722;
        }
      }
      label1722:
      for (localObject2 = "2";; localObject2 = "1")
      {
        bcst.b((QQAppInterface)localObject3, "dc00899", "Grp_create_new", "", "edit_data", "cover", 0, 0, (String)localObject4, (String)localObject2, "", "");
        break;
        if (this.jdField_a_of_type_Akgq == null)
        {
          this.jdField_a_of_type_Akgq = new akgq(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_Akgq.a(this);
        }
        this.j = false;
        this.jdField_a_of_type_Akgq.c();
        break label1559;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        c(11);
        label1746:
        a(i1, paramView);
        localObject4 = this.app;
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_h_of_type_Boolean) {
          break label1934;
        }
        localObject3 = "2";
        label1780:
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label1942;
        }
        localObject2 = "0";
      }
      for (;;)
      {
        bcst.b((QQAppInterface)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, (String)localObject3, (String)localObject2, "");
        break;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          break label1746;
        }
        if (this.jdField_a_of_type_Akgn == null)
        {
          this.jdField_a_of_type_Akgn = new akgn(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_Akgn.a(this);
        }
        this.j = true;
        this.jdField_a_of_type_Akgn.c();
        if (this.jdField_a_of_type_Bfqt != null) {
          break label1746;
        }
        this.jdField_a_of_type_Bfqt = new bfqt(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bfum.class, this.jdField_a_of_type_Anwd);
        this.jdField_a_of_type_Bfqt.a(this.jdField_a_of_type_JavaUtilObserver);
        break label1746;
        label1934:
        localObject3 = "1";
        break label1780;
        label1942:
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
        r();
      }
    }
  }
  
  public void p()
  {
    GCBindGroup.GCBindGroupSsoServerReq localGCBindGroupSsoServerReq = new GCBindGroup.GCBindGroupSsoServerReq();
    localGCBindGroupSsoServerReq.cmd.set("get_appid");
    Object localObject = new GCBindGroup.QQGroupBind();
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((GCBindGroup.QQGroupBind)localObject).group_code.set(l);
      localGCBindGroupSsoServerReq.bind_req.set((MessageMicro)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), niq.class);
      afkc localafkc = new afkc(this);
      localafkc.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.app);
      localafkc.jdField_b_of_type_Int = 2;
      ((NewIntent)localObject).setObserver(localafkc);
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