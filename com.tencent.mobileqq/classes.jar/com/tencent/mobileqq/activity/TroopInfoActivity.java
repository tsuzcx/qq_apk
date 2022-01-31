package com.tencent.mobileqq.activity;

import aeda;
import aedb;
import aedc;
import aedd;
import aede;
import aedf;
import aedg;
import aedh;
import aedi;
import aedj;
import aedk;
import aedl;
import aedm;
import aedn;
import aedo;
import aedp;
import aedq;
import aedr;
import aeds;
import aedt;
import aedu;
import aedv;
import aedw;
import aedx;
import aepi;
import ainn;
import aipt;
import aipw;
import aiqc;
import aiqe;
import aloz;
import alpa;
import altm;
import alto;
import alud;
import amdu;
import amel;
import ameq;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import aouu;
import azkz;
import azqs;
import bamp;
import bamz;
import bayu;
import bckq;
import bcmb;
import bcpv;
import bcpx;
import bcwd;
import bcwe;
import bcyz;
import bdbb;
import bdbc;
import bdes;
import bdet;
import bdgm;
import bdgx;
import bdhj;
import bdin;
import bdjz;
import bety;
import bidb;
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
import mzx;
import nco;
import nez;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements aiqc, View.OnClickListener, bdbc
{
  public int a;
  public long a;
  private aipt jdField_a_of_type_Aipt;
  private aipw jdField_a_of_type_Aipw;
  alpa jdField_a_of_type_Alpa = new aedl(this);
  altm jdField_a_of_type_Altm = new aedk(this);
  public amdu a;
  ameq jdField_a_of_type_Ameq = new aedm(this);
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aeda(this);
  public Handler a;
  protected View a;
  protected Button a;
  protected LinearLayout a;
  public bcmb a;
  protected bdbb a;
  protected bety a;
  protected FriendListHandler a;
  public TroopInfo a;
  public TroopInfoData a;
  protected XListView a;
  public String a;
  protected ArrayList<String> a;
  public List<Integer> a;
  Observer jdField_a_of_type_JavaUtilObserver = new aedr(this);
  protected boolean a;
  protected View[] a;
  public int b;
  public long b;
  public View b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  protected View c;
  boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  protected int f;
  protected boolean f;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  
  public TroopInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new aedj(this);
  }
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_Bdbb != null)
    {
      localObject2 = this.jdField_a_of_type_Bdbb.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Bdbb.a())
        {
          this.jdField_a_of_type_Bdbb.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bdhj.a();
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
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId;
      double d1 = paramInt1 / 1000000.0D;
      double d2 = paramInt2 / 1000000.0D;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      paramString = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(i), Double.valueOf(d1), Double.valueOf(d2), str });
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
    int j = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    Object localObject = Long.toString(paramTroopInfoData.dwGroupClassExt);
    paramContext = bcwe.a(paramContext).a(paramContext, (String)localObject);
    if (!TextUtils.isEmpty(paramTroopInfoData.mTroopClassExtText)) {
      paramContext = paramTroopInfoData.mTroopClassExtText;
    }
    for (;;)
    {
      localObject = new ArrayList();
      if (!TextUtils.isEmpty(paramContext)) {
        ((ArrayList)localObject).add(paramContext);
      }
      for (int i = 1;; i = 0)
      {
        if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
        {
          int k = paramTroopInfoData.troopTags.size();
          for (;;)
          {
            if (j < k)
            {
              if ((i == 0) || (!((String)paramTroopInfoData.troopTags.get(j)).equals(paramContext))) {
                ((ArrayList)localObject).add(paramTroopInfoData.troopTags.get(j));
              }
              j += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString))) {
                break label203;
              }
              if (paramContext.jdField_a_of_type_JavaLangString.equals(alud.a(2131715846)))
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
      paramView = paramView.findViewById(2131375548);
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        bcpx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt, false);
        b(paramInt, false);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      int j = 1;
      int i = j;
      if (paramInt == 8)
      {
        i = j;
        if (!bcpx.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
          i = 0;
        }
      }
      if ((i != 0) && (bcpx.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramInt))) {
        b(paramInt, paramBoolean);
      }
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131755801);
    localDialog.setContentView(2131560906);
    ((TextView)localDialog.findViewById(2131365271)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365260);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365258);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365264);
    localTextView1.setText(String.format(getString(2131693620), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694953);
    localTextView3.setText(2131693564);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new aedf(this, localDialog, paramLong1, paramInt2, paramLong2, paramLong3, paramString));
    localTextView3.setOnClickListener(new aedg(this, localDialog));
    try
    {
      localDialog.show();
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
    this.jdField_b_of_type_AndroidViewView = super.getLayoutInflater().inflate(2131560420, paramXListView, false);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377913);
    ((ImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131364327)).setOnClickListener(new aedn(this, paramXListView));
    paramXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    j();
    if (!paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label244;
        }
      }
      label244:
      for (str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;; str = "")
      {
        azqs.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, str, "5", "", "");
        QQToast.a(this, 1, paramString, 1).b(getTitleBarHeight());
        if (paramBoolean)
        {
          ((amdu)this.app.a(20)).notifyUI(111, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
          finish();
        }
        return;
        switch ((int)paramLong1)
        {
        default: 
          paramString = getString(2131693615);
          break;
        case 1281: 
          paramString = getString(2131693616);
          break;
        case 1282: 
          paramString = getString(2131693617);
          break;
        case 1283: 
          paramString = getString(2131693618);
          break;
        case 1793: 
          paramString = getString(2131693619);
          break;
        }
      }
    }
    QQAppInterface localQQAppInterface = this.app;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      label273:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break label352;
      }
    }
    label352:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa);; str = "")
    {
      azqs.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, paramString, str, "", "");
      QQToast.a(this, 2, getString(2131693622), 1).b(getTitleBarHeight());
      break;
      paramString = "";
      break label273;
    }
  }
  
  private String b()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2))
    {
      azqs.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
      return getString(2131697951);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
    {
      azqs.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
      return getString(2131697949);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15))
    {
      azqs.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      return getString(2131697950);
    }
    if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption)
    {
      azqs.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "3", "", "");
      return getString(2131697948);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131697947);
    }
    return "";
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    int i = 8;
    View localView;
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
      if (localObject != null)
      {
        localView = ((View)localObject).findViewById(2131375548);
        if (paramInt != 8) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = ((View)localObject).findViewById(2131377614);; localObject = ((View)localObject).findViewById(2131364771))
    {
      if (localView != null)
      {
        paramInt = i;
        if (paramBoolean) {
          paramInt = 0;
        }
        localView.setVisibility(paramInt);
      }
      if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        i = getResources().getDimensionPixelSize(2131298295);
        paramInt = i;
        if (paramBoolean) {
          paramInt = i * 2;
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
      if ((!aouu.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
        break label192;
      }
      bool = amel.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
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
      String str3 = alud.a(2131715848);
      aedi localaedi = new aedi(this, bool);
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
      VipUtils.a(this, str1, str2, str3, localaedi, (String)localObject, paramInt, bool);
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 2, 0, "", "", "", "");
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
      azqs.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label319;
      }
    }
    label319:
    for (localObject = "1";; localObject = "0")
    {
      bdes.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { str1, localObject });
      return;
      bool = false;
      break;
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
          u();
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
  
  private void p()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label111;
      }
      SpannableString localSpannableString = new SpannableString("[Avatar]");
      Drawable localDrawable = a();
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, azkz.a(32.0F), azkz.a(32.0F));
        localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
        a(11, 2, localView, getString(2131699965), localSpannableString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        a(11, false);
      }
    }
    return;
    label111:
    a(11, 2, localView, getString(2131699965), alud.a(2131715845), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    a(11, true);
  }
  
  private void q()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    ArrayList localArrayList = new ArrayList();
    aiqe.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
    if (localArrayList.size() == 0)
    {
      a(12, 2, localView, getString(2131721147), alud.a(2131715849), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(12, true);
    }
    for (;;)
    {
      localView.setTag(2131721147, Integer.valueOf(localArrayList.size()));
      return;
      String str = bckq.b(bckq.a(((ainn)localArrayList.get(0)).c, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1));
      URLDrawable localURLDrawable = null;
      Object localObject1 = null;
      int i = azkz.a(30.0F);
      localObject3 = localURLDrawable;
      try
      {
        URL localURL = aiqe.a(str);
        if (localURL != null)
        {
          localObject3 = localURLDrawable;
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = bayu.a;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
          localObject3 = localURLDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
          localObject3 = localURLDrawable;
          localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject1);
          localObject3 = localURLDrawable;
          localURLDrawable.setTag(new int[] { i, i, 0 });
          localObject3 = localURLDrawable;
          localURLDrawable.setDecodeHandler(bcyz.d);
          localObject1 = localURLDrawable;
          localObject3 = localURLDrawable;
          if (localURLDrawable.getStatus() != 1)
          {
            localObject3 = localURLDrawable;
            localURLDrawable.setURLDrawableListener(new aedu(this));
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
        ((URLDrawable)localObject1).setBounds(0, 0, i, i);
        ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject1, 0), 0, ((SpannableString)localObject3).length(), 17);
      }
      a(12, 2, localView, getString(2131721147), (CharSequence)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      a(12, false);
    }
  }
  
  private void r()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject = bdgm.a(this, 230);
      ((bdjz)localObject).setTitle(null);
      long l2 = this.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      ((bdjz)localObject).setMessage(getString(2131693624, new Object[] { l1 + "" }));
      ((bdjz)localObject).setNegativeButton(getString(2131693574), new aedx(this));
      ((bdjz)localObject).setPositiveButton(getString(2131693546), new aedb(this));
      ((bdjz)localObject).show();
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (localObject = "0";; localObject = "1")
      {
        azqs.b(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_exp", 0, 0, str, (String)localObject, "", "");
        return;
      }
    }
    i();
  }
  
  private void s()
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
    a(2131721057, 1);
  }
  
  private void t()
  {
    Object localObject = this.app.getCurrentAccountUin();
    int i;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin).equals(localObject)) {
      i = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, i);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) {
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick;
      }
      ((ProfileActivity.AllInOne)localObject).c = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      ((ProfileActivity.AllInOne)localObject).d = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      if (i == 21) {
        ((ProfileActivity.AllInOne)localObject).l = 11;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
      {
        if (((alto)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
        {
          i = 20;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          i = 21;
          continue;
        }
      }
      i = 19;
    }
  }
  
  private void u()
  {
    ThreadManager.post(new TroopInfoActivity.23(this), 5, null, true);
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.post(new TroopInfoActivity.24(this), 5, null, true);
  }
  
  private void w()
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377648);
      if ((2 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) && (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)) {
        break label520;
      }
    }
    label520:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) {
        i = j | 0x2;
      }
      if (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
      {
        j = i;
        if (3 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {}
      }
      else
      {
        j = i | 0x4;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 3) {}
      }
      else
      {
        i = j | 0x8;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 1) {
        j = i | 0x10;
      }
      i = j;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
        i = j | 0x20;
      }
      SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4);
      boolean bool = localSharedPreferences.getBoolean("has_shown_tips", false);
      if (a(i, 32)) {
        if (this.jdField_c_of_type_Int == 2) {
          i = 2131697956;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          localTextView.setText(i);
          localTextView.setContentDescription(getString(i));
          return;
          if ((this.jdField_c_of_type_Int == 3) && (!bool))
          {
            i = 2131697957;
            localSharedPreferences.edit().putBoolean("has_shown_tips", true).commit();
            continue;
            if (a(i, 1))
            {
              if (a(i, 2))
              {
                if ((a(i, 4)) || (a(i, 8)) || (a(i, 16)))
                {
                  i = 2131697970;
                  continue;
                }
                i = 2131697969;
                continue;
              }
              if (a(i, 8))
              {
                i = 2131697963;
                continue;
              }
              if (a(i, 4))
              {
                i = 2131697962;
                continue;
              }
              i = 2131697961;
              continue;
            }
            if (a(i, 2))
            {
              if (a(i, 4))
              {
                i = 2131697968;
                continue;
              }
              if ((a(i, 8)) || (a(i, 16)))
              {
                i = 2131697967;
                continue;
              }
              i = 2131697966;
              continue;
            }
            if ((a(i, 8)) && (a(i, 4)))
            {
              i = 2131697958;
              continue;
            }
            if (a(i, 8))
            {
              i = 2131697960;
              continue;
            }
            if (a(i, 4)) {
              i = 2131697959;
            }
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        i = 0;
      }
    }
  }
  
  private void x()
  {
    startTitleProgress();
    nez.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new aedo(this));
  }
  
  private void y()
  {
    nez.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new aedp(this));
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {
      return getString(2131697965);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      return getString(2131697964);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2) {
      return getString(2131697951);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15) {
      return getString(2131697950);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131697947);
    }
    return "";
  }
  
  protected void a()
  {
    long l = System.currentTimeMillis();
    View localView = View.inflate(this, 2131561363, null);
    Object localObject1 = (ListView)localView.findViewById(2131363780);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(alud.a(2131715843));
    ((ArrayList)localObject2).add(alud.a(2131715842));
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364645));
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
    localObject1 = new bidb(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838592);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setClickable(false);
    super.setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getString(2131721038);
    }
    setTitle((CharSequence)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      localObject1 = View.inflate(this, 2131561367, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(7, 0, (View)localObject1, getString(2131693524), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
      localObject1 = View.inflate(this, 2131561382, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2131561367, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[11] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    p();
    ((View)localObject1).setOnClickListener(this);
    localObject1 = View.inflate(this, 2131561367, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    q();
    ((View)localObject1).setOnClickListener(this);
    localObject1 = View.inflate(this, 2131561367, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(5, 2, (View)localObject1, getString(2131721148), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    k();
    localObject1 = View.inflate(this, 2131561367, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(4, 2, (View)localObject1, getString(2131720988), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    localObject1 = View.inflate(this, 2131561366, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(8, 3, (View)localObject1, getString(2131720990), null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim(), 1);
    ThreadManager.post(new TroopInfoActivity.2(this), 8, null, true);
    localObject1 = View.inflate(this, 2131561382, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject2 = View.inflate(this, 2131561373, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      a(6, 3, (View)localObject2, getString(2131693678), (CharSequence)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.mDensity));
      localObject2 = View.inflate(this, 2131561382, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363552);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363471));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label857;
      }
      b(13);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.leftView.setOnClickListener(new aeds(this));
      this.rightViewText.setOnClickListener(new aedt(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l));
      }
      return;
      localObject1 = getResources().getString(2131696639);
      break;
      label857:
      b(14);
    }
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    bdjz localbdjz = bdgm.a(this, 230);
    localbdjz.setTitle(str);
    localbdjz.setMessage(null);
    localbdjz.setPositiveButton(getString(2131693605), new aedc(this, localbdjz));
    localbdjz.setPositiveButtonContentDescription(getString(2131693605));
    localbdjz.setNegativeButton(getString(2131693546), new bdgx());
    localbdjz.setNegativeButtonContentDescription(getString(2131693546));
    localbdjz.show();
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
        TextView localTextView1 = (TextView)paramView.findViewById(2131377938);
        localTextView2 = (TextView)paramView.findViewById(2131368235);
        localView = paramView.findViewById(2131362823);
        paramView = paramString;
        if (paramString == null) {
          paramView = "";
        }
        localTextView1.setText(paramView);
        if (6 == paramInt1)
        {
          localTextView2.setEditableFactory(bamz.a);
          localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
          if (TextUtils.isEmpty(paramCharSequence))
          {
            localTextView2.setVisibility(8);
            label135:
            if (!paramBoolean) {
              break label237;
            }
          }
        }
        break;
      }
    }
    label237:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130839254);
      break label48;
      paramView.setBackgroundResource(2130839270);
      break label48;
      paramView.setBackgroundResource(2130839264);
      break label48;
      paramView.setBackgroundResource(2130839261);
      break label48;
      localTextView2.setVisibility(0);
      localTextView2.setText(new bamp(paramCharSequence, 11));
      break label135;
      localTextView2.setText(paramCharSequence);
      break label135;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "initClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayOfString + ", bShowArrow = " + paramBoolean);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131377938);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131362823);
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
    paramView.setBackgroundResource(2130839254);
    return;
    paramView.setBackgroundResource(2130839270);
    return;
    paramView.setBackgroundResource(2130839264);
    return;
    paramView.setBackgroundResource(2130839261);
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
        localTextView = (TextView)localView1.findViewById(2131368235);
        localView2 = localView1.findViewById(2131362823);
        if (paramInt != 6) {
          break label187;
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
        localTextView.setText(new bamp(paramString, 11));
      }
      label187:
      String str = paramString;
      if (paramInt == 4)
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label226;
        }
        str = alud.a(2131715851);
        a(paramInt, true);
      }
      for (;;)
      {
        localTextView.setText(str);
        break;
        label226:
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
        localLinearLayout = (LinearLayout)localView.findViewById(2131364377);
        localLinearLayout.removeAllViews();
        localObject1 = (LinearLayout)localView.findViewById(2131377614);
        localObject2 = (TextView)localView.findViewById(2131368235);
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          localLinearLayout.setVisibility(8);
          ((TextView)localObject2).setText(alud.a(2131715852));
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
      int j = 0;
      while ((j < paramArrayList.size()) && (j < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(j)))
        {
          j += 1;
        }
        else
        {
          localObject1 = new TextView(this);
          ((TextView)localObject1).setId(2131373135);
          int i = 2130843428;
          if (paramInt2 == 1) {
            i = 2130843429;
          }
          for (;;)
          {
            localObject2 = getResources().getDrawable(i);
            ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject2);
            ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
            ((TextView)localObject1).setTextSize(2, 15.0F);
            if (paramBoolean2) {
              ((TextView)localObject1).setMaxWidth(aepi.a(77.0F, getResources()));
            }
            ((TextView)localObject1).setSingleLine();
            ((TextView)localObject1).setTextColor(getResources().getColor(2131167059));
            ((TextView)localObject1).setPadding(aepi.a(6.0F, getResources()), aepi.a(2.0F, getResources()), aepi.a(8.0F, getResources()), aepi.a(2.0F, getResources()));
            ((TextView)localObject1).setGravity(17);
            ((TextView)localObject1).setText((CharSequence)paramArrayList.get(j));
            ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).leftMargin = aepi.a(5.0F, getResources());
            localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break;
            if (paramInt2 == 2) {
              i = 2130843428;
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131362823);
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
      i = 1;
      if (i == 0) {
        break label184;
      }
    }
    label184:
    for (int i = 260;; i = 258)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("gotoBigPic code=%d bundle=%s", new Object[] { Integer.valueOf(i), localBundle }));
      }
      startActivityForResult(paramBundle, i);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(GCBindGroup.GCBindGroupSsoServerRsp paramGCBindGroupSsoServerRsp)
  {
    int i = paramGCBindGroupSsoServerRsp.ret.get();
    Object localObject = null;
    if (i == -3000005) {
      this.jdField_f_of_type_Int = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopinfo", 2, "onGetGameBindStatus ret=" + i + ", status=" + this.jdField_f_of_type_Int + ", name=" + (String)localObject);
      }
      return;
      if (i == 0)
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
    azqs.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
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
      u();
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
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = bdet.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = bdet.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM");
        this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("troop_auth_submit_time");
        this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("PARAM_EXIT_ANIMATION", 0);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
      }
      ThreadManager.post(new TroopInfoActivity.6(this), 5, null, false);
    }
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    case 13: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setEnabled(true);
      this.rightViewText.setText(2131693639);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131693811);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(14));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  protected void b(String paramString)
  {
    j();
    bety localbety = new bety(this, getTitleBarHeight());
    localbety.a(paramString);
    localbety.setCancelable(false);
    localbety.setOnDismissListener(new aedh(this));
    this.jdField_a_of_type_AndroidAppDialog = localbety;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c()
  {
    if (((this.jdField_c_of_type_Long != 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L)) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount <= 0)
      {
        localObject = bdgm.a(this, 230);
        ((bdjz)localObject).setTitle(null);
        ((bdjz)localObject).setMessage(getString(2131697946));
        ((bdjz)localObject).setPositiveButton(getString(2131693574), new bdgx());
        ((bdjz)localObject).setPositiveButtonContentDescription(getString(2131693574));
        ((bdjz)localObject).show();
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bdgm.a(this, 230);
          ((bdjz)localObject).setTitle(null);
          ((bdjz)localObject).setMessage(getString(2131697945, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount) }));
          ((bdjz)localObject).setPositiveButton(getString(2131693574), new aedv(this));
          ((bdjz)localObject).setNegativeButton(getString(2131693546), new aedw(this));
          ((bdjz)localObject).show();
          return;
        }
        a((String)localObject);
        return;
      }
      i();
      return;
    }
    i();
  }
  
  public void d()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = true;
      finish();
      return;
    }
    a(2131693606);
  }
  
  /* Error */
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 456
    //   9: iconst_2
    //   10: new 281	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1735
    //   20: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc_w 1737
    //   30: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 1739
    //   40: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_3
    //   44: invokevirtual 1340	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 460	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iconst_m1
    //   54: iload_2
    //   55: if_icmpne +69 -> 124
    //   58: iload_1
    //   59: lookupswitch	default:+65->124, 5:+460->519, 7:+122->181, 8:+644->703, 9:+823->882, 11:+553->612, 16:+193->252, 257:+938->997
    //   125: sipush 258
    //   128: if_icmpne +923 -> 1051
    //   131: aload_3
    //   132: ifnull +44 -> 176
    //   135: aload_3
    //   136: ldc_w 1741
    //   139: invokevirtual 1745	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   142: astore_3
    //   143: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +30 -> 176
    //   149: aload_3
    //   150: ifnonnull +888 -> 1038
    //   153: aconst_null
    //   154: astore_3
    //   155: ldc_w 456
    //   158: iconst_2
    //   159: ldc_w 1747
    //   162: iconst_1
    //   163: anewarray 255	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_3
    //   169: aastore
    //   170: invokestatic 272	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 460	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: invokespecial 647	com/tencent/mobileqq/activity/TroopInfoActivity:q	()V
    //   180: return
    //   181: aload_3
    //   182: ifnull -58 -> 124
    //   185: aload_3
    //   186: invokevirtual 1198	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   189: ifnull -65 -> 124
    //   192: aload_3
    //   193: invokevirtual 1198	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   196: astore 9
    //   198: aload_0
    //   199: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   202: aload 9
    //   204: ldc_w 1749
    //   207: invokevirtual 1202	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: putfield 589	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   213: aload_0
    //   214: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   217: aload 9
    //   219: ldc_w 1751
    //   222: iconst_0
    //   223: invokevirtual 1607	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   226: putfield 1534	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLat	I
    //   229: aload_0
    //   230: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   233: aload 9
    //   235: ldc_w 1753
    //   238: iconst_0
    //   239: invokevirtual 1607	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   242: putfield 1540	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLon	I
    //   245: aload_0
    //   246: invokevirtual 1219	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   249: goto -125 -> 124
    //   252: aload_3
    //   253: ifnull -129 -> 124
    //   256: aload_3
    //   257: invokevirtual 1198	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   260: ifnull -136 -> 124
    //   263: aload_3
    //   264: invokevirtual 1198	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   267: astore 9
    //   269: aload_0
    //   270: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   273: getfield 589	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   276: aload 9
    //   278: ldc_w 1749
    //   281: invokevirtual 1202	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokestatic 1758	bdeu:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   287: ifne +8 -> 295
    //   290: aload_0
    //   291: iconst_1
    //   292: putfield 892	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_d_of_type_Boolean	Z
    //   295: aload_0
    //   296: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   299: aload 9
    //   301: ldc_w 1760
    //   304: invokevirtual 1202	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   307: putfield 1631	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   310: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +36 -> 349
    //   316: ldc_w 279
    //   319: iconst_2
    //   320: new 281	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 1762
    //   330: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   337: getfield 1631	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   340: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 1669	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_0
    //   350: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   353: getfield 1631	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   356: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   359: ifne +39 -> 398
    //   362: aload_0
    //   363: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   366: getfield 1631	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   369: ldc_w 1764
    //   372: invokevirtual 1768	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   375: astore 10
    //   377: aload 10
    //   379: arraylength
    //   380: iconst_5
    //   381: if_icmplt +96 -> 477
    //   384: aload_0
    //   385: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   388: aload 10
    //   390: iconst_4
    //   391: aaload
    //   392: invokestatic 1598	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   395: putfield 1771	com/tencent/mobileqq/troopinfo/TroopInfoData:mPoiId	J
    //   398: aload_0
    //   399: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   402: aload 9
    //   404: ldc_w 1749
    //   407: invokevirtual 1202	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: putfield 589	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   413: aload_0
    //   414: invokevirtual 1219	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   417: goto -293 -> 124
    //   420: astore 11
    //   422: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq -27 -> 398
    //   428: ldc_w 456
    //   431: iconst_2
    //   432: new 281	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 1773
    //   442: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 10
    //   447: iconst_4
    //   448: aaload
    //   449: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 1775
    //   455: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_0
    //   459: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   462: getfield 1631	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   465: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 1669	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: goto -76 -> 398
    //   477: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq -82 -> 398
    //   483: ldc_w 456
    //   486: iconst_2
    //   487: new 281	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   494: ldc_w 1777
    //   497: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_0
    //   501: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   504: getfield 1631	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   507: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 1779	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: goto -118 -> 398
    //   519: aload_3
    //   520: ldc_w 1781
    //   523: invokevirtual 1784	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   526: astore 9
    //   528: aload 9
    //   530: aload_0
    //   531: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   534: getfield 595	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   537: invokestatic 1787	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   540: ifne -416 -> 124
    //   543: aload_0
    //   544: iconst_1
    //   545: putfield 892	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_d_of_type_Boolean	Z
    //   548: aload_0
    //   549: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   552: aload 9
    //   554: putfield 595	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   557: aload_0
    //   558: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   561: getfield 595	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   564: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   567: ifne +30 -> 597
    //   570: aload_0
    //   571: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   574: getfield 595	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   577: astore 9
    //   579: aload_0
    //   580: bipush 6
    //   582: aload 9
    //   584: aload_0
    //   585: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   588: invokevirtual 663	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   591: invokevirtual 747	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILjava/lang/String;Z)V
    //   594: goto -470 -> 124
    //   597: aload_0
    //   598: invokevirtual 633	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   601: ldc_w 1271
    //   604: invokevirtual 1272	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   607: astore 9
    //   609: goto -30 -> 579
    //   612: ldc2_w 1788
    //   615: lstore 7
    //   617: aload_3
    //   618: ldc_w 1791
    //   621: invokevirtual 1784	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   624: invokestatic 1598	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   627: lstore 5
    //   629: aload_0
    //   630: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   633: getfield 302	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   636: lload 5
    //   638: lcmp
    //   639: ifeq -515 -> 124
    //   642: lload 5
    //   644: ldc2_w 1788
    //   647: lcmp
    //   648: ifeq -524 -> 124
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 892	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_d_of_type_Boolean	Z
    //   656: aload_0
    //   657: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   660: lload 5
    //   662: putfield 302	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   665: aload_0
    //   666: invokespecial 741	com/tencent/mobileqq/activity/TroopInfoActivity:u	()V
    //   669: goto -545 -> 124
    //   672: astore 9
    //   674: lload 7
    //   676: lstore 5
    //   678: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   681: ifeq -52 -> 629
    //   684: ldc_w 456
    //   687: iconst_2
    //   688: aload 9
    //   690: invokevirtual 457	java/lang/Exception:toString	()Ljava/lang/String;
    //   693: invokestatic 460	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: lload 7
    //   698: lstore 5
    //   700: goto -71 -> 629
    //   703: aload_0
    //   704: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   707: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   710: iconst_2
    //   711: if_icmpeq +159 -> 870
    //   714: aload_0
    //   715: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   718: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   721: bipush 6
    //   723: if_icmpeq +147 -> 870
    //   726: aload_0
    //   727: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   730: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   733: bipush 15
    //   735: if_icmpeq +135 -> 870
    //   738: aload_0
    //   739: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   742: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   745: bipush 10
    //   747: if_icmpeq +123 -> 870
    //   750: aload_0
    //   751: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   754: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   757: bipush 11
    //   759: if_icmpeq +111 -> 870
    //   762: aload_0
    //   763: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   766: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   769: bipush 19
    //   771: if_icmpeq +99 -> 870
    //   774: aload_0
    //   775: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   778: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   781: bipush 101
    //   783: if_icmpeq +87 -> 870
    //   786: aload_0
    //   787: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   790: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   793: bipush 102
    //   795: if_icmpeq +75 -> 870
    //   798: aload_0
    //   799: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   802: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   805: bipush 103
    //   807: if_icmpeq +63 -> 870
    //   810: aload_0
    //   811: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   814: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   817: bipush 104
    //   819: if_icmpeq +51 -> 870
    //   822: aload_0
    //   823: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   826: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   829: bipush 105
    //   831: if_icmpeq +39 -> 870
    //   834: aload_0
    //   835: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   838: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   841: bipush 106
    //   843: if_icmpeq +27 -> 870
    //   846: aload_0
    //   847: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   850: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   853: bipush 112
    //   855: if_icmpne +15 -> 870
    //   858: aload_0
    //   859: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   862: getfield 569	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   865: bipush 113
    //   867: if_icmpeq -743 -> 124
    //   870: aload_0
    //   871: iconst_m1
    //   872: invokevirtual 1794	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   875: aload_0
    //   876: invokevirtual 561	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   879: goto -755 -> 124
    //   882: aload_3
    //   883: ldc_w 1796
    //   886: invokevirtual 1784	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   889: astore 10
    //   891: aload 10
    //   893: ifnull -769 -> 124
    //   896: aload 10
    //   898: invokevirtual 583	java/lang/String:length	()I
    //   901: ifle -777 -> 124
    //   904: new 60	java/util/ArrayList
    //   907: dup
    //   908: invokespecial 61	java/util/ArrayList:<init>	()V
    //   911: astore 9
    //   913: new 1798	org/json/JSONArray
    //   916: dup
    //   917: invokespecial 1799	org/json/JSONArray:<init>	()V
    //   920: pop
    //   921: new 1798	org/json/JSONArray
    //   924: dup
    //   925: aload 10
    //   927: invokespecial 1801	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   930: astore 10
    //   932: iconst_0
    //   933: istore_2
    //   934: aload 10
    //   936: invokevirtual 1802	org/json/JSONArray:length	()I
    //   939: istore 4
    //   941: iload_2
    //   942: iload 4
    //   944: if_icmpge +26 -> 970
    //   947: aload 9
    //   949: aload 10
    //   951: iload_2
    //   952: invokevirtual 1803	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   955: invokeinterface 1581 2 0
    //   960: pop
    //   961: iload_2
    //   962: iconst_1
    //   963: iadd
    //   964: istore_2
    //   965: goto -31 -> 934
    //   968: astore 10
    //   970: aload_0
    //   971: iconst_1
    //   972: putfield 892	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_d_of_type_Boolean	Z
    //   975: aload_0
    //   976: getfield 56	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   979: aload 9
    //   981: putfield 325	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   984: aload_0
    //   985: getfield 95	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   988: bipush 6
    //   990: invokevirtual 1592	android/os/Handler:sendEmptyMessage	(I)Z
    //   993: pop
    //   994: goto -870 -> 124
    //   997: aload_0
    //   998: getfield 1805	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_h_of_type_Boolean	Z
    //   1001: ifeq +20 -> 1021
    //   1004: aload_0
    //   1005: getfield 1807	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Aipt	Laipt;
    //   1008: ifnull -884 -> 124
    //   1011: aload_0
    //   1012: getfield 1807	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Aipt	Laipt;
    //   1015: invokevirtual 1811	aipt:d	()V
    //   1018: goto -894 -> 124
    //   1021: aload_0
    //   1022: getfield 1813	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Aipw	Laipw;
    //   1025: ifnull -901 -> 124
    //   1028: aload_0
    //   1029: getfield 1813	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_Aipw	Laipw;
    //   1032: invokevirtual 1816	aipw:d	()V
    //   1035: goto -911 -> 124
    //   1038: aload_3
    //   1039: invokeinterface 1820 1 0
    //   1044: invokestatic 1825	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   1047: astore_3
    //   1048: goto -893 -> 155
    //   1051: iload_1
    //   1052: sipush 260
    //   1055: if_icmpne -875 -> 180
    //   1058: aload_0
    //   1059: invokespecial 765	com/tencent/mobileqq/activity/TroopInfoActivity:p	()V
    //   1062: return
    //   1063: astore 11
    //   1065: goto -104 -> 961
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1068	0	this	TroopInfoActivity
    //   0	1068	1	paramInt1	int
    //   0	1068	2	paramInt2	int
    //   0	1068	3	paramIntent	Intent
    //   939	6	4	i	int
    //   627	72	5	l1	long
    //   615	82	7	l2	long
    //   196	412	9	localObject1	Object
    //   672	17	9	localException	Exception
    //   911	69	9	localArrayList	ArrayList
    //   375	575	10	localObject2	Object
    //   968	1	10	localJSONException1	org.json.JSONException
    //   420	1	11	localNumberFormatException	NumberFormatException
    //   1063	1	11	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   384	398	420	java/lang/NumberFormatException
    //   617	629	672	java/lang/Exception
    //   921	932	968	org/json/JSONException
    //   934	941	968	org/json/JSONException
    //   947	961	1063	org/json/JSONException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.jdField_e_of_type_Boolean = getIntent().getExtras().getBoolean("returnMsgList", false);
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isGameTroop()) {
        o();
      }
      this.jdField_a_of_type_Bdbb = new bdbb(this, this.app);
      this.jdField_a_of_type_Bdbb.a(this);
      a();
      addObserver(this.jdField_a_of_type_Alpa);
      paramBundle = (aloz)this.app.a(22);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "");
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
      this.jdField_f_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l));
      }
      nco.a(this.app, 78);
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      int i = this.jdField_g_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (paramBundle = "0";; paramBundle = "1")
      {
        azqs.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str, String.valueOf(i), paramBundle, "");
        return true;
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    long l = 0L;
    if (QLog.isColorLevel()) {
      l = System.currentTimeMillis();
    }
    bcwe.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_Ameq);
    removeObserver(this.jdField_a_of_type_Altm);
    removeObserver(this.jdField_a_of_type_Alpa);
    if (this.jdField_f_of_type_Boolean) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bcmb != null) {
        this.jdField_a_of_type_Bcmb.b(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (this.jdField_a_of_type_Aipw != null) {
        this.jdField_a_of_type_Aipw.f();
      }
      if (this.jdField_a_of_type_Aipt != null) {
        this.jdField_a_of_type_Aipt.f();
      }
      if (this.jdField_a_of_type_Bdbb != null) {
        this.jdField_a_of_type_Bdbb.d();
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
        QLog.i("Q.troopinfo", 2, String.format("doOnNewIntent bAvatarEdit=%b clip=%s path=%s", new Object[] { Boolean.valueOf(this.jdField_h_of_type_Boolean), paramIntent, str }));
      }
      if (!this.jdField_h_of_type_Boolean) {
        break label94;
      }
      if (this.jdField_a_of_type_Aipt != null) {
        this.jdField_a_of_type_Aipt.a(str, paramIntent);
      }
    }
    label94:
    while (this.jdField_a_of_type_Aipw == null) {
      return;
    }
    this.jdField_a_of_type_Aipw.a(str, paramIntent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void e()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_Amdu = ((amdu)this.app.a(20));
    addObserver(this.jdField_a_of_type_Ameq);
    addObserver(this.jdField_a_of_type_Altm);
    addObserver(this.jdField_a_of_type_Alpa);
    ThreadManager.post(new TroopInfoActivity.12(this), 5, null, true);
  }
  
  public void finish()
  {
    j();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 28) {
      setResult(-1, getIntent());
    }
    if (this.jdField_e_of_type_Boolean) {
      l();
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
    overridePendingTransition(0, 2130772011);
  }
  
  protected void g()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    Object localObject3 = bcwe.a(getApplicationContext()).a(this, (String)localObject1);
    localObject1 = "";
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
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
            if ((localObject3 == null) || (TextUtils.isEmpty(((bcwd)localObject3).jdField_a_of_type_JavaLangString))) {
              break label311;
            }
            if (((bcwd)localObject3).jdField_a_of_type_JavaLangString.equals(alud.a(2131715853)))
            {
              i = 0;
              break;
            }
            localObject1 = ((bcwd)localObject3).jdField_a_of_type_JavaLangString;
            i = 1;
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
      i = 0;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      azqs.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 16);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {
      setResult(-1);
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      finish();
      return;
    }
    azqs.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa), "", "");
    Object localObject2 = (aloz)this.app.a(22);
    if (localObject2 == null)
    {
      finish();
      return;
    }
    long l6;
    try
    {
      l6 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == -1)
      {
        finish();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      finish();
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.currentTroopLocationStruct;
    int m = 0;
    int k = 0;
    long l1 = 0L;
    long l4 = 0L;
    Object localObject1 = "";
    int i;
    long l2;
    int j;
    long l3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      i = k;
      l2 = l1;
      j = m;
      l3 = l1;
    }
    for (;;)
    {
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        i = k;
        l2 = l1;
        j = m;
        l3 = l1;
        k = Integer.valueOf(localObject3[0]).intValue();
        i = k;
        l2 = l1;
        j = k;
        l3 = l1;
        l1 = (Double.valueOf(localObject3[1]).doubleValue() * 1000000.0D);
        i = k;
        l2 = l1;
        j = k;
        l3 = l1;
        long l5 = (Double.valueOf(localObject3[2]).doubleValue() * 1000000.0D);
        localObject1 = localObject3[3];
        i = k;
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
        i = j;
        l1 = l3;
        l2 = l4;
        continue;
        k = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) {
          continue;
        }
        j = 4;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == 0L) {
          continue;
        }
        j = 2;
        continue;
      }
      b(getString(2131693621));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        k = 3;
        if (k == -1) {
          break;
        }
        j = 1;
        if (this.jdField_c_of_type_Long == 0L) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == this.jdField_c_of_type_Long) {
          continue;
        }
        j = 3;
        if (((this.jdField_a_of_type_Int == 0) || (1 == this.jdField_a_of_type_Int)) && (k == 3)) {
          azqs.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        }
        if (((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) && ((k == 0) || (1 == k))) {
          azqs.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) {
          break label719;
        }
        j();
        if (this.jdField_e_of_type_Int <= 0) {
          break label631;
        }
        a(l6, k, i, l1, l2, (String)localObject1);
        azqs.b(this.app, "dc00899", "Grp_certified", "", "data", "exp_edit_data", 4, 0, "" + l6, "", "", "");
        return;
      }
      label631:
      if (this.jdField_d_of_type_Int <= 0) {
        break;
      }
      localObject1 = bdgm.a(this, 230);
      ((bdjz)localObject1).setTitle(null);
      ((bdjz)localObject1).setMessage(getString(2131693611, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
      ((bdjz)localObject1).setPositiveButton(getString(2131693574), new bdgx());
      ((bdjz)localObject1).setPositiveButtonContentDescription(getString(2131693574));
      ((bdjz)localObject1).show();
      return;
      label719:
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
        azqs.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
        nez.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, i, l4, l3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, j, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new aedd(this));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.jdField_c_of_type_Long != 0L))
      {
        nez.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, i, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, j, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new aede(this));
        return;
      }
      ((aloz)localObject2).a(l6, k, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, i, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      return;
      i = 0;
      l2 = l4;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void k()
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
        a(5, alud.a(2131715844), true);
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
  
  public void l()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    startActivity(localIntent);
  }
  
  public void m()
  {
    try
    {
      if (this.jdField_a_of_type_Bety == null)
      {
        this.jdField_a_of_type_Bety = new bety(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bety.c(2131695090);
        this.jdField_a_of_type_Bety.c(false);
      }
      this.jdField_a_of_type_Bety.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void n()
  {
    try
    {
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.dismiss();
      }
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
    GCBindGroup.GCBindGroupSsoServerReq localGCBindGroupSsoServerReq = new GCBindGroup.GCBindGroupSsoServerReq();
    localGCBindGroupSsoServerReq.cmd.set("get_appid");
    Object localObject = new GCBindGroup.QQGroupBind();
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((GCBindGroup.QQGroupBind)localObject).group_code.set(l);
      localGCBindGroupSsoServerReq.bind_req.set((MessageMicro)localObject);
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), mzx.class);
      aedq localaedq = new aedq(this);
      localaedq.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.app);
      localaedq.jdField_b_of_type_Int = 2;
      ((NewIntent)localObject).setObserver(localaedq);
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
  
  public void onBackPressed()
  {
    d();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int j;
    if ((localObject instanceof Integer)) {
      j = ((Integer)localObject).intValue();
    }
    switch (j)
    {
    case 3: 
    case 7: 
    case 10: 
    case 13: 
    default: 
    case 4: 
    case 8: 
    case 9: 
    case 5: 
    case 6: 
    case 14: 
    case 2: 
    case 12: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_f_of_type_Int == 1) {
              QQToast.a(getApplicationContext(), 1, alud.a(2131715847), 0).a();
            }
            for (;;)
            {
              a(j, paramView);
              return;
              localObject = new Intent(getActivity(), TroopClassChoiceActivity.class);
              ((Intent)localObject).putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
              startActivityForResult((Intent)localObject, 11);
            }
            g();
            a(j, paramView);
            return;
            paramView = new Intent(this, QQBrowserActivity.class);
            paramView.putExtra("url", "https://buluo.qq.com/mobile/qunbindbuluo.html?_wv=1027");
            paramView.putExtra("bid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId);
            startActivityForResult(paramView, 17);
            return;
            h();
            a(j, paramView);
            return;
            localObject = new Intent(this, EditInfoActivity.class);
            ((Intent)localObject).putExtra("edit_type", 1);
            ((Intent)localObject).putExtra("title", getString(2131693678));
            ((Intent)localObject).putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
            ((Intent)localObject).putExtra("max_num", 900);
            ((Intent)localObject).putExtra("canPostNull", true);
            ((Intent)localObject).putExtra("support_emotion", true);
            ((Intent)localObject).putExtra("full_screen", true);
            startActivityForResult((Intent)localObject, 5);
            a("Grp_moredata", "Clk_brief", "");
            a(j, paramView);
            return;
            if (!bdin.d(this))
            {
              a(2131694766, 0);
              return;
            }
          } while (this.jdField_a_of_type_Amdu == null);
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            m();
            this.jdField_a_of_type_Amdu.a(l, 8390784);
            return;
          }
          catch (Exception paramView) {}
        } while (!QLog.isColorLevel());
        QLog.i("Q.troopinfo", 2, paramView.toString());
        return;
        t();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
      localObject = paramView.getTag(2131721147);
      if ((localObject == null) || (!(localObject instanceof Integer))) {
        break;
      }
    }
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      if (i > 0) {
        c(12);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Bcmb == null)
        {
          this.jdField_a_of_type_Bcmb = new bcmb(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bcpv.class, this.jdField_a_of_type_Amdu);
          this.jdField_a_of_type_Bcmb.a(this.jdField_a_of_type_JavaUtilObserver);
        }
        a(j, paramView);
        azqs.b(this.app, "dc00899", "Grp_create_new", "", "edit_data", "cover", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
        return;
        if (this.jdField_a_of_type_Aipw == null)
        {
          this.jdField_a_of_type_Aipw = new aipw(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_Aipw.a(this);
        }
        this.jdField_h_of_type_Boolean = false;
        this.jdField_a_of_type_Aipw.c();
      }
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        c(11);
        a(j, paramView);
        localObject = this.app;
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label817;
        }
        paramView = "0";
      }
      for (;;)
      {
        azqs.b((QQAppInterface)localObject, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str, "0", paramView, "");
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          break;
        }
        if (this.jdField_a_of_type_Aipt == null)
        {
          this.jdField_a_of_type_Aipt = new aipt(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_Aipt.a(this);
        }
        this.jdField_h_of_type_Boolean = true;
        this.jdField_a_of_type_Aipt.c();
        if (this.jdField_a_of_type_Bcmb != null) {
          break;
        }
        this.jdField_a_of_type_Bcmb = new bcmb(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bcpv.class, this.jdField_a_of_type_Amdu);
        this.jdField_a_of_type_Bcmb.a(this.jdField_a_of_type_JavaUtilObserver);
        break;
        label817:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          paramView = "1";
        } else {
          paramView = "2";
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        p();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */