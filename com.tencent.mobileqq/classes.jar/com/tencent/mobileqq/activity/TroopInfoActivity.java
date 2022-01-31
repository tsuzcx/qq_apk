package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingTask;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerReq;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerRsp;
import com.tencent.pb.troop.bindgame.GCBindGroup.QQBindInfo;
import com.tencent.pb.troop.bindgame.GCBindGroup.QQGroupBind;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.AccountManager;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import txo;
import txp;
import txq;
import txr;
import txs;
import txt;
import txu;
import txv;
import txw;
import txx;
import txy;
import txz;
import tyb;
import tyc;
import tyf;
import tyg;
import tyh;
import tyj;
import tyl;
import tym;
import tyn;
import tyo;
import typ;
import tyq;
import tyr;
import tys;
import tyt;
import tyu;
import tyv;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  public long a;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new txo(this);
  public Uri a;
  public Handler a;
  protected View a;
  protected Button a;
  protected LinearLayout a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new tyb(this);
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new txy(this);
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new tyc(this);
  public TroopInfo a;
  public AvatarWallViewPager a;
  public AvatarWallViewPagerAdapter a;
  public TroopInfoData a;
  protected QQProgressDialog a;
  protected XListView a;
  public String a;
  protected ArrayList a;
  public List a;
  private Observer jdField_a_of_type_JavaUtilObserver;
  protected boolean a;
  public View[] a;
  public int b;
  public long b;
  public View b;
  public LinearLayout b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  protected View c;
  public boolean c;
  public int d;
  protected boolean d;
  public int e;
  public boolean e;
  protected int f;
  public boolean f;
  private int g;
  public boolean g;
  private int h;
  protected boolean h;
  private boolean i;
  
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
    this.jdField_a_of_type_AndroidOsHandler = new txx(this);
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
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString);
    localBundle.putInt("troop_info_from", paramInt);
    return localBundle;
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
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId;
      double d1 = paramInt1 / 1000000.0D;
      double d2 = paramInt2 / 1000000.0D;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      paramString = String.format("%d|%f|%f|%s", new Object[] { Integer.valueOf(j), Double.valueOf(d1), Double.valueOf(d2), str });
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.troopinfo.troop.location_info", 2, "initCurrentLocationStruct==>locationStruct:" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public static ArrayList a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    int k = 0;
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
      for (int j = 1;; j = 0)
      {
        if ((paramTroopInfoData.troopTags != null) && (paramTroopInfoData.troopTags.size() > 0))
        {
          int m = paramTroopInfoData.troopTags.size();
          for (;;)
          {
            if (k < m)
            {
              if ((j == 0) || (!((String)paramTroopInfoData.troopTags.get(k)).equals(paramContext))) {
                ((ArrayList)localObject).add(paramTroopInfoData.troopTags.get(k));
              }
              k += 1;
              continue;
              if ((paramContext == null) || (TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString))) {
                break label200;
              }
              if (paramContext.jdField_a_of_type_JavaLangString.equals("其他"))
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
      label200:
      paramContext = "";
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131624516);
    localDialog.setContentView(2130970302);
    ((TextView)localDialog.findViewById(2131369987)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131369988);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131369989);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131369990);
    localTextView1.setText(String.format(getString(2131435747), new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131433016);
    localTextView3.setText(2131435744);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new txt(this, localDialog, paramLong1, paramInt2, paramLong2, paramLong3, paramString));
    localTextView3.setOnClickListener(new txu(this, localDialog));
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
    this.jdField_b_of_type_AndroidViewView = super.getLayoutInflater().inflate(2130969872, paramXListView, false);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131367522);
    ((ImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131362868)).setOnClickListener(new tyl(this, paramXListView));
    paramXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt != 3) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt != 4)) {
          break;
        }
        localObject1 = new ArrayList();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(str, localOptions);
          if ((localOptions.outWidth < 100) || (localOptions.outHeight < 100)) {
            ((ArrayList)localObject1).add(str);
          }
        }
        if (((ArrayList)localObject1).size() > 0) {
          QQToast.a(this, 2131430583, 1).a();
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramArrayList.remove((String)((Iterator)localObject1).next());
        }
      } while (paramArrayList.size() == 0);
      n();
      localObject1 = new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler);
    } while (this.jdField_a_of_type_JavaUtilObserver != null);
    this.jdField_a_of_type_JavaUtilObserver = new tyh(this);
    Object localObject2 = TroopUtils.a(this.app);
    if (localObject2 == null)
    {
      ((AccountManager)this.app.getManager(0)).updateSKey(new tyj(this, (TroopAvatarManger)localObject1, paramArrayList));
      return;
    }
    ((TroopAvatarManger)localObject1).a(this.jdField_a_of_type_JavaUtilObserver);
    ((TroopAvatarManger)localObject1).a(TroopUploadingThread.class, this.app, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, (String)localObject2, this.app.getCurrentAccountUin(), null);
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
          break label216;
        }
      }
      label216:
      for (str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;; str = "")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, str, "5", "", "");
        QQToast.a(this, 1, paramString, 1).b(getTitleBarHeight());
        if (paramBoolean)
        {
          ((TroopHandler)this.app.a(20)).a(108, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
          finish();
        }
        return;
        switch ((int)paramLong1)
        {
        default: 
          paramString = getString(2131435752);
          break;
        case 1281: 
          paramString = getString(2131430542);
          break;
        case 1282: 
          paramString = getString(2131430543);
          break;
        case 1283: 
          paramString = getString(2131430544);
          break;
        }
      }
    }
    QQAppInterface localQQAppInterface = this.app;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      label245:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break label324;
      }
    }
    label324:
    for (String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa);; str = "")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, paramString, str, "", "");
      QQToast.a(this, 2, getString(2131435751), 1).b(getTitleBarHeight());
      break;
      paramString = "";
      break label245;
    }
  }
  
  private String b()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {
        return "还未编辑群名称";
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a() == 0) {
        return "还未上传群头像";
      }
    }
    return null;
  }
  
  private String c()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", "", "");
      return getString(2131430577);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "2", "", "");
      return getString(2131430578);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15))
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "1", "", "");
      return getString(2131430579);
    }
    if (3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "3", "", "");
      return getString(2131430580);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131430581);
    }
    return "";
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(51);
      if (localObject != null) {
        break label121;
      }
    }
    label121:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if ((paramInt & 0x4) > 0) {
          c(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname);
        }
        if ((paramInt & 0x2) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
          v();
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
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setTitle(null);
      long l2 = this.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 5L;
      }
      ((QQCustomDialog)localObject).setMessage(getString(2131430556, new Object[] { l1 + "" }));
      ((QQCustomDialog)localObject).setNegativeButton(getString(2131430555), new tyt(this));
      ((QQCustomDialog)localObject).setPositiveButton(getString(2131435754), new tyu(this));
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
    i();
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, setLastActivityName()));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, setLastActivityName()), 8);
      return;
    }
    a(2131434431, 1);
  }
  
  private void s()
  {
    Object localObject = this.app.getCurrentAccountUin();
    int j;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin).equals(localObject)) {
      j = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, j);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) {
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick;
      }
      if (j == 21)
      {
        ((ProfileActivity.AllInOne)localObject).c = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        ((ProfileActivity.AllInOne)localObject).d = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
      {
        if (((FriendsManager)this.app.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
        {
          j = 1;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          j = 21;
          continue;
        }
      }
      j = 19;
    }
  }
  
  private void t()
  {
    boolean bool2 = false;
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localIntent.setClass(this, TroopAvatarWallEditActivity.class);
    localBundle.putInt("index", 0);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead)) {
        break label117;
      }
    }
    ArrayList localArrayList;
    label117:
    for (boolean bool1 = true;; bool1 = false)
    {
      localBundle.putBoolean("is_new_troop_without_pic", bool1);
      localArrayList = new ArrayList();
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a();
      if (localObject != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troop_avatar_wall", 2, "avatarInfos == null on click");
      }
      return;
    }
    int j = ((List)localObject).size();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall", 2, "avatarInfos.size=" + j + " on click");
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AvatarWallAdapter.AvatarInfo localAvatarInfo = (AvatarWallAdapter.AvatarInfo)((Iterator)localObject).next();
      if (localAvatarInfo != null) {
        if (((localAvatarInfo.d.equals("AVATAR_URL_STR")) || (localAvatarInfo.d.equals("SYSTEM_PHOTO"))) && (localAvatarInfo.jdField_b_of_type_JavaLangString == null) && (localAvatarInfo.c != null)) {
          localArrayList.add(localAvatarInfo.c);
        } else if (localAvatarInfo.jdField_b_of_type_JavaLangString != null) {
          localArrayList.add(localAvatarInfo.jdField_b_of_type_JavaLangString);
        }
      }
    }
    localBundle.putBoolean("IS_EDIT", true);
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 28) {
      bool1 = true;
    }
    localBundle.putBoolean("can_add_image", bool1);
    localBundle.putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt);
    localBundle.putInt("troop_auth_submit_time", this.jdField_b_of_type_Int);
    localBundle.putStringArrayList("seqNum", localArrayList);
    localBundle.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localBundle.putBoolean("troop_info_is_member", true);
    localIntent.putExtras(localBundle);
    startActivityForResult(localIntent, 12);
  }
  
  private void u()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a("拍照", 1);
    localActionSheet.a("从相册选择", 1);
    localActionSheet.d("取消");
    localActionSheet.a(new txw(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void v()
  {
    ThreadManager.post(new tyf(this), 5, null, true);
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    ThreadManager.post(new tyg(this), 5, null, true);
  }
  
  private void x()
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368329);
      if ((2 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) && (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)) {
        break label520;
      }
    }
    label520:
    for (int k = 1;; k = 0)
    {
      int j = k;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) {
        j = k | 0x2;
      }
      if (4 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
      {
        k = j;
        if (3 != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {}
      }
      else
      {
        k = j | 0x4;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 2)
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus != 3) {}
      }
      else
      {
        j = k | 0x8;
      }
      k = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 1) {
        k = j | 0x10;
      }
      j = k;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
        j = k | 0x20;
      }
      SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4);
      boolean bool = localSharedPreferences.getBoolean("has_shown_tips", false);
      if (a(j, 32)) {
        if (this.jdField_c_of_type_Int == 2) {
          j = 2131430575;
        }
      }
      for (;;)
      {
        if (j != 0)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          localTextView.setText(j);
          localTextView.setContentDescription(getString(j));
          return;
          if ((this.jdField_c_of_type_Int == 3) && (!bool))
          {
            j = 2131430576;
            localSharedPreferences.edit().putBoolean("has_shown_tips", true).commit();
            continue;
            if (a(j, 1))
            {
              if (a(j, 2))
              {
                if ((a(j, 4)) || (a(j, 8)) || (a(j, 16)))
                {
                  j = 2131430564;
                  continue;
                }
                j = 2131430565;
                continue;
              }
              if (a(j, 8))
              {
                j = 2131430569;
                continue;
              }
              if (a(j, 4))
              {
                j = 2131430570;
                continue;
              }
              j = 2131430571;
              continue;
            }
            if (a(j, 2))
            {
              if (a(j, 4))
              {
                j = 2131430566;
                continue;
              }
              if ((a(j, 8)) || (a(j, 16)))
              {
                j = 2131430567;
                continue;
              }
              j = 2131430568;
              continue;
            }
            if ((a(j, 8)) && (a(j, 4)))
            {
              j = 2131430572;
              continue;
            }
            if (a(j, 8))
            {
              j = 2131430574;
              continue;
            }
            if (a(j, 4)) {
              j = 2131430573;
            }
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        j = 0;
      }
    }
  }
  
  private void y()
  {
    startTitleProgress();
    TroopInfoActivityHelper.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new tym(this));
  }
  
  private void z()
  {
    TroopInfoActivityHelper.a(this.app, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).longValue(), new tyn(this));
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {
      return getString(2131430584);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      return getString(2131430585);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName.length() < 2) {
      return getString(2131430577);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo.length() < 15) {
      return getString(2131430579);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlag & 0x400) == 0L) || (0L != (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x20000)))) {
      return getString(2131430581);
    }
    return "";
  }
  
  protected void a()
  {
    Object localObject1 = ((TroopManager)this.app.getManager(51)).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      Object localObject2 = ((TroopInfo)localObject1).mTroopPicList;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          if (str != null)
          {
            localAvatarInfo.c = str;
            if (localAvatarInfo.c.equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString)) {}
            for (localAvatarInfo.d = "SYSTEM_PHOTO";; localAvatarInfo.d = "AVATAR_URL_STR")
            {
              Set localSet = ((TroopInfo)localObject1).mTroopVerifyingPics;
              if (localSet != null) {
                localAvatarInfo.jdField_b_of_type_Boolean = localSet.contains(str);
              }
              localArrayList.add(localAvatarInfo);
              break;
            }
          }
        }
      }
    }
    if ((localArrayList.size() == 0) && ((!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead)))
    {
      localObject1 = new AvatarWallAdapter.AvatarInfo();
      ((AvatarWallAdapter.AvatarInfo)localObject1).c = AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
      ((AvatarWallAdapter.AvatarInfo)localObject1).d = "SYSTEM_PHOTO";
      localArrayList.add(localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a(localArrayList, false);
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(getString(2131435755), new txp(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131435755));
    localQQCustomDialog.setNegativeButton(getString(2131435754), new DialogUtil.DialogOnClickAdapter());
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131435754));
    localQQCustomDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    label48:
    TextView localTextView1;
    View localView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        TextView localTextView2 = (TextView)paramView.findViewById(2131363378);
        localTextView1 = (TextView)paramView.findViewById(2131364119);
        localView = paramView.findViewById(2131363443);
        paramView = paramString1;
        if (paramString1 == null) {
          paramView = "";
        }
        localTextView2.setText(paramView);
        if (6 == paramInt1)
        {
          localTextView1.setEditableFactory(QQTextBuilder.a);
          localTextView1.setMovementMethod(LinkMovementMethod.getInstance());
          if (TextUtils.isEmpty(paramString2))
          {
            localTextView1.setVisibility(8);
            label135:
            if (!paramBoolean) {
              break label259;
            }
          }
        }
        break;
      }
    }
    label259:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130838623);
      break label48;
      paramView.setBackgroundResource(2130838635);
      break label48;
      paramView.setBackgroundResource(2130838633);
      break label48;
      paramView.setBackgroundResource(2130838630);
      break label48;
      localTextView1.setVisibility(0);
      localTextView1.setText(new QQText(paramString2, 11));
      break label135;
      paramView = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramView = paramString2;
        if (3 == paramInt1) {
          paramView = "无";
        }
      }
      localTextView1.setText(paramView);
      break label135;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "initClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayOfString + ", bShowArrow = " + paramBoolean);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131363378);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131363443);
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
    paramView.setBackgroundResource(2130838623);
    return;
    paramView.setBackgroundResource(2130838635);
    return;
    paramView.setBackgroundResource(2130838633);
    return;
    paramView.setBackgroundResource(2130838630);
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
        localTextView = (TextView)localView1.findViewById(2131364119);
        localView2 = localView1.findViewById(2131363443);
        if (paramInt != 6) {
          break label205;
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label170;
        }
        localTextView.setVisibility(8);
        if (!paramString.equals(getString(2131433085))) {
          break label194;
        }
        localTextView.setTextColor(-3355444);
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label238;
        }
        localView1.setTag(Integer.valueOf(paramInt));
        localView1.setOnClickListener(this);
        localView2.setVisibility(0);
        return;
        label170:
        localTextView.setVisibility(0);
        localTextView.setText(new QQText(paramString, 11));
        break;
        label194:
        localTextView.setTextColor(-8355712);
        continue;
        label205:
        String str = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          str = paramString;
          if (3 == paramInt) {
            str = "无";
          }
        }
        localTextView.setText(str);
      }
      label238:
      localView1.setTag(null);
      localView1.setOnClickListener(null);
      localView2.setVisibility(8);
      return;
    }
  }
  
  public void a(int paramInt1, ArrayList paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1];; localView = null)
    {
      LinearLayout localLinearLayout;
      if (localView != null)
      {
        localLinearLayout = (LinearLayout)localView.findViewById(2131371575);
        localLinearLayout.removeAllViews();
        if (paramArrayList != null) {}
      }
      else
      {
        return;
      }
      int j = 0;
      while ((j < paramArrayList.size()) && (j < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(j)))
        {
          j += 1;
        }
        else
        {
          TextView localTextView = new TextView(this);
          localTextView.setId(2131362056);
          if (paramInt2 == 1) {
            localTextView.setBackgroundResource(2130841429);
          }
          for (;;)
          {
            localTextView.setTextSize(2, 15.0F);
            if (paramBoolean2) {
              localTextView.setMaxWidth(AIOUtils.a(77.0F, getResources()));
            }
            localTextView.setSingleLine();
            localTextView.setTextColor(-1);
            localTextView.setPadding(AIOUtils.a(6.0F, getResources()), AIOUtils.a(2.0F, getResources()), AIOUtils.a(8.0F, getResources()), AIOUtils.a(2.0F, getResources()));
            localTextView.setGravity(17);
            localTextView.setText((CharSequence)paramArrayList.get(j));
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.leftMargin = AIOUtils.a(5.0F, getResources());
            localLinearLayout.addView(localTextView, localLayoutParams);
            break;
            if (paramInt2 == 2) {
              localTextView.setBackgroundResource(2130841428);
            } else {
              localTextView.setBackgroundResource(2130841428);
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131363443);
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
  
  public void a(GCBindGroup.GCBindGroupSsoServerRsp paramGCBindGroupSsoServerRsp)
  {
    int j = paramGCBindGroupSsoServerRsp.ret.get();
    Object localObject = null;
    if (j == -3000005) {
      this.jdField_f_of_type_Int = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopinfo", 2, "onGetGameBindStatus ret=" + j + ", status=" + this.jdField_f_of_type_Int + ", name=" + (String)localObject);
      }
      return;
      if (j == 0)
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
      v();
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
        this.jdField_g_of_type_Boolean = ((Bundle)localObject).getBoolean("troop_info_perfect_info", false);
        if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) <= 0L) {
          break label624;
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
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = TroopSystemMsgUtil.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = TroopSystemMsgUtil.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("troop_type_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum = ((Bundle)localObject).getInt("TROOP_INFO_MEMBER_NUM");
        this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("troop_auth_submit_time");
        this.jdField_h_of_type_Int = ((Bundle)localObject).getInt("PARAM_EXIT_ANIMATION", 0);
        localObject = (TroopManager)this.app.getManager(51);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo((TroopInfo)localObject, this.app.getCurrentAccountUin());
            bool1 = true;
          }
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
          {
            this.jdField_b_of_type_JavaLangString = "0";
            bool2 = bool1;
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
          return bool1;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        boolean bool2;
        boolean bool1 = false;
        continue;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopinfo", 2, localException1.toString());
        return bool1;
      }
    }
    label624:
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  protected void b()
  {
    long l = System.currentTimeMillis();
    View localView = View.inflate(this, 2130970653, null);
    Object localObject1 = (ListView)localView.findViewById(2131371574);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add("貂蝉");
    ((ArrayList)localObject2).add("陈圆圆");
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    ((ListView)localObject1).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131363733));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[11];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    a(this.jdField_a_of_type_ComTencentWidgetXListView);
    localObject1 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838214);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setClickable(false);
    super.setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getString(2131433679);
    }
    setTitle((CharSequence)localObject1);
    if (this.jdField_g_of_type_Boolean)
    {
      localObject1 = new TextView(this);
      ((TextView)localObject1).setText("群头像和名称必填，其他可选填。");
      ((TextView)localObject1).setTextColor(getResources().getColor(2131494108));
      ((TextView)localObject1).setTextSize(1, 13.0F);
      ((TextView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      int j = AIOUtils.a(15.0F, getResources());
      ((TextView)localObject1).setPadding(j, j, j, j);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2130969429, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
    ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(this, 212.0F)));
    ((View)localObject1).findViewById(2131366467).setVisibility(8);
    localObject2 = (TextView)((View)localObject1).findViewById(2131366468);
    ((TextView)localObject2).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject1).findViewById(2131363114));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setTag(Integer.valueOf(10));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(this), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, UIUtils.a(this, 212.0F), this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_a_of_type_AndroidOsHandler, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838635);
      if ((localObject1 instanceof ViewGroup))
      {
        ((TextView)localObject2).setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this, 2130969427, null));
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ViewGroup)localObject1).addView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      localObject1 = View.inflate(this, 2130970656, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(7, 0, (View)localObject1, getString(2131433506), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
      localObject1 = View.inflate(this, 2130970668, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2130970656, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = "";
    }
    a(3, 1, (View)localObject1, getString(2131434487), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, bool);
    localObject1 = View.inflate(this, 2130970656, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(5, 2, (View)localObject1, getString(2131435553), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    k();
    localObject1 = View.inflate(this, 2130970656, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(4, 2, (View)localObject1, getString(2131433659), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    localObject1 = View.inflate(this, 2130970655, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    a(8, 3, (View)localObject1, getString(2131433660), null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim(), 1);
    ThreadManager.post(new txz(this), 8, null, true);
    localObject1 = View.inflate(this, 2130970668, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject2 = View.inflate(this, 2130970661, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      a(6, 3, (View)localObject2, getString(2131433498), (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.mDensity));
      localObject2 = View.inflate(this, 2130970668, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365767);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365810));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label1312;
      }
      b(10);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.leftView.setOnClickListener(new typ(this));
      this.rightViewText.setOnClickListener(new tyq(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l));
      }
      return;
      localObject1 = getResources().getString(2131433085);
      break;
      label1312:
      b(11);
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
    case 10: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setEnabled(true);
      this.rightViewText.setText(2131435742);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131433050);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(11));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  protected void b(String paramString)
  {
    j();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new txv(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c()
  {
    if (((this.jdField_c_of_type_Long != 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L)) && (this.jdField_b_of_type_Int == 0))
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount <= 0)
      {
        localObject = DialogUtil.a(this, 230);
        ((QQCustomDialog)localObject).setTitle(null);
        ((QQCustomDialog)localObject).setMessage(getString(2131430557));
        ((QQCustomDialog)localObject).setPositiveButton(getString(2131430555), new DialogUtil.DialogOnClickAdapter());
        ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131430555));
        ((QQCustomDialog)localObject).show();
        return;
      }
      if (this.jdField_e_of_type_Boolean)
      {
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject).setTitle(null);
          ((QQCustomDialog)localObject).setMessage(getString(2131430558, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount) }));
          ((QQCustomDialog)localObject).setPositiveButton(getString(2131430555), new tyr(this));
          ((QQCustomDialog)localObject).setNegativeButton(getString(2131435754), new tys(this));
          ((QQCustomDialog)localObject).show();
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
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    a(3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, bool);
  }
  
  public void d()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.i = true;
      finish();
      return;
    }
    a(2131435756);
  }
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +50 -> 56
    //   9: ldc_w 367
    //   12: iconst_2
    //   13: new 219	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 1645
    //   23: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_1
    //   27: invokevirtual 840	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc_w 1647
    //   33: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_2
    //   37: invokevirtual 840	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc_w 1649
    //   43: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_3
    //   47: invokevirtual 1090	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 370	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iconst_m1
    //   57: iload_2
    //   58: if_icmpne +66 -> 124
    //   61: iload_1
    //   62: tableswitch	default:+62 -> 124, 5:+388->450, 6:+473->535, 7:+63->125, 8:+601->663, 9:+682->744, 10:+62->124, 11:+514->576, 12:+62->124, 13:+791->853, 14:+62->124, 15:+62->124, 16:+128->190
    //   125: aload_3
    //   126: ifnull -2 -> 124
    //   129: aload_3
    //   130: invokevirtual 1309	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   133: ifnull -9 -> 124
    //   136: aload_3
    //   137: invokevirtual 1309	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   140: astore_3
    //   141: aload_0
    //   142: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   145: aload_3
    //   146: ldc_w 1651
    //   149: invokevirtual 1312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: putfield 623	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   155: aload_0
    //   156: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   159: aload_3
    //   160: ldc_w 1653
    //   163: iconst_0
    //   164: invokevirtual 1328	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   167: putfield 1255	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLat	I
    //   170: aload_0
    //   171: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   174: aload_3
    //   175: ldc_w 1655
    //   178: iconst_0
    //   179: invokevirtual 1328	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   182: putfield 1261	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLon	I
    //   185: aload_0
    //   186: invokevirtual 1546	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   189: return
    //   190: aload_3
    //   191: ifnull -67 -> 124
    //   194: aload_3
    //   195: invokevirtual 1309	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   198: ifnull -74 -> 124
    //   201: aload_3
    //   202: invokevirtual 1309	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   205: astore_3
    //   206: aload_0
    //   207: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   210: getfield 623	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   213: aload_3
    //   214: ldc_w 1651
    //   217: invokevirtual 1312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: invokestatic 1660	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   223: ifne +8 -> 231
    //   226: aload_0
    //   227: iconst_1
    //   228: putfield 691	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   231: aload_0
    //   232: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   235: aload_3
    //   236: ldc_w 1662
    //   239: invokevirtual 1312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: putfield 1354	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   245: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +35 -> 283
    //   251: ldc 217
    //   253: iconst_2
    //   254: new 219	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 1664
    //   264: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   271: getfield 1354	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   274: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 1388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   287: getfield 1354	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   290: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   293: ifne +39 -> 332
    //   296: aload_0
    //   297: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   300: getfield 1354	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   303: ldc_w 1666
    //   306: invokevirtual 1670	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   309: astore 9
    //   311: aload 9
    //   313: arraylength
    //   314: iconst_5
    //   315: if_icmplt +93 -> 408
    //   318: aload_0
    //   319: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   322: aload 9
    //   324: iconst_4
    //   325: aaload
    //   326: invokestatic 1319	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   329: putfield 1673	com/tencent/mobileqq/troopinfo/TroopInfoData:mPoiId	J
    //   332: aload_0
    //   333: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   336: aload_3
    //   337: ldc_w 1651
    //   340: invokevirtual 1312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   343: putfield 623	com/tencent/mobileqq/troopinfo/TroopInfoData:troopLocation	Ljava/lang/String;
    //   346: aload_0
    //   347: invokevirtual 1546	com/tencent/mobileqq/activity/TroopInfoActivity:k	()V
    //   350: return
    //   351: astore 10
    //   353: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -24 -> 332
    //   359: ldc_w 367
    //   362: iconst_2
    //   363: new 219	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 1675
    //   373: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload 9
    //   378: iconst_4
    //   379: aaload
    //   380: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 1677
    //   386: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_0
    //   390: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   393: getfield 1354	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   396: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 1388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: goto -73 -> 332
    //   408: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq -79 -> 332
    //   414: ldc_w 367
    //   417: iconst_2
    //   418: new 219	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   425: ldc_w 1679
    //   428: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_0
    //   432: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   435: getfield 1354	com/tencent/mobileqq/troopinfo/TroopInfoData:currentTroopLocationStruct	Ljava/lang/String;
    //   438: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 1681	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: goto -115 -> 332
    //   450: aload_3
    //   451: ldc_w 1683
    //   454: invokevirtual 1686	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   457: astore_3
    //   458: aload_3
    //   459: aload_0
    //   460: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   463: getfield 629	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   466: invokestatic 1689	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   469: ifne -345 -> 124
    //   472: aload_0
    //   473: iconst_1
    //   474: putfield 691	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   477: aload_0
    //   478: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   481: aload_3
    //   482: putfield 629	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   485: aload_0
    //   486: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   489: getfield 629	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   492: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne +26 -> 521
    //   498: aload_0
    //   499: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   502: getfield 629	com/tencent/mobileqq/troopinfo/TroopInfoData:mRichFingerMemo	Ljava/lang/String;
    //   505: astore_3
    //   506: aload_0
    //   507: bipush 6
    //   509: aload_3
    //   510: aload_0
    //   511: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   514: invokevirtual 668	com/tencent/mobileqq/troopinfo/TroopInfoData:isOwnerOrAdim	()Z
    //   517: invokevirtual 671	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILjava/lang/String;Z)V
    //   520: return
    //   521: aload_0
    //   522: invokevirtual 1136	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   525: ldc_w 1100
    //   528: invokevirtual 1590	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   531: astore_3
    //   532: goto -26 -> 506
    //   535: aload_3
    //   536: ldc_w 1683
    //   539: invokevirtual 1686	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   542: astore_3
    //   543: aload_3
    //   544: aload_0
    //   545: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   548: getfield 601	com/tencent/mobileqq/troopinfo/TroopInfoData:troopName	Ljava/lang/String;
    //   551: invokestatic 1660	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   554: ifne -430 -> 124
    //   557: aload_0
    //   558: iconst_1
    //   559: putfield 691	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   562: aload_0
    //   563: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   566: iconst_1
    //   567: putfield 1690	com/tencent/mobileqq/troopinfo/TroopInfoData:hasSetNewTroopName	Z
    //   570: aload_0
    //   571: aload_3
    //   572: invokevirtual 658	com/tencent/mobileqq/activity/TroopInfoActivity:c	(Ljava/lang/String;)V
    //   575: return
    //   576: ldc2_w 1691
    //   579: lstore 7
    //   581: aload_3
    //   582: ldc_w 1694
    //   585: invokevirtual 1686	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   588: invokestatic 1319	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   591: lstore 5
    //   593: aload_0
    //   594: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   597: getfield 240	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   600: lload 5
    //   602: lcmp
    //   603: ifeq -479 -> 124
    //   606: lload 5
    //   608: ldc2_w 1691
    //   611: lcmp
    //   612: ifeq -488 -> 124
    //   615: aload_0
    //   616: iconst_1
    //   617: putfield 691	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   620: aload_0
    //   621: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   624: lload 5
    //   626: putfield 240	com/tencent/mobileqq/troopinfo/TroopInfoData:dwGroupClassExt	J
    //   629: aload_0
    //   630: invokespecial 662	com/tencent/mobileqq/activity/TroopInfoActivity:v	()V
    //   633: return
    //   634: astore_3
    //   635: lload 7
    //   637: lstore 5
    //   639: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq -49 -> 593
    //   645: ldc_w 367
    //   648: iconst_2
    //   649: aload_3
    //   650: invokevirtual 368	java/lang/Exception:toString	()Ljava/lang/String;
    //   653: invokestatic 370	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: lload 7
    //   658: lstore 5
    //   660: goto -67 -> 593
    //   663: aload_0
    //   664: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   667: getfield 588	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   670: iconst_2
    //   671: if_icmpeq +63 -> 734
    //   674: aload_0
    //   675: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   678: getfield 588	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   681: bipush 6
    //   683: if_icmpeq +51 -> 734
    //   686: aload_0
    //   687: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   690: getfield 588	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   693: bipush 15
    //   695: if_icmpeq +39 -> 734
    //   698: aload_0
    //   699: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   702: getfield 588	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   705: bipush 10
    //   707: if_icmpeq +27 -> 734
    //   710: aload_0
    //   711: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   714: getfield 588	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   717: bipush 11
    //   719: if_icmpeq +15 -> 734
    //   722: aload_0
    //   723: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   726: getfield 588	com/tencent/mobileqq/troopinfo/TroopInfoData:pa	I
    //   729: bipush 19
    //   731: if_icmpne -607 -> 124
    //   734: aload_0
    //   735: iconst_m1
    //   736: invokevirtual 1697	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   739: aload_0
    //   740: invokevirtual 581	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   743: return
    //   744: aload_3
    //   745: ldc_w 1699
    //   748: invokevirtual 1686	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   751: astore 9
    //   753: aload 9
    //   755: ifnull -631 -> 124
    //   758: aload 9
    //   760: invokevirtual 617	java/lang/String:length	()I
    //   763: ifle -639 -> 124
    //   766: new 54	java/util/ArrayList
    //   769: dup
    //   770: invokespecial 55	java/util/ArrayList:<init>	()V
    //   773: astore_3
    //   774: new 1701	org/json/JSONArray
    //   777: dup
    //   778: invokespecial 1702	org/json/JSONArray:<init>	()V
    //   781: pop
    //   782: new 1701	org/json/JSONArray
    //   785: dup
    //   786: aload 9
    //   788: invokespecial 1704	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   791: astore 9
    //   793: iload 4
    //   795: istore_1
    //   796: aload 9
    //   798: invokevirtual 1705	org/json/JSONArray:length	()I
    //   801: istore_2
    //   802: iload_1
    //   803: iload_2
    //   804: if_icmpge +25 -> 829
    //   807: aload_3
    //   808: aload 9
    //   810: iload_1
    //   811: invokevirtual 1706	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   814: invokeinterface 1014 2 0
    //   819: pop
    //   820: iload_1
    //   821: iconst_1
    //   822: iadd
    //   823: istore_1
    //   824: goto -28 -> 796
    //   827: astore 9
    //   829: aload_0
    //   830: iconst_1
    //   831: putfield 691	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_e_of_type_Boolean	Z
    //   834: aload_0
    //   835: getfield 50	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   838: aload_3
    //   839: putfield 263	com/tencent/mobileqq/troopinfo/TroopInfoData:troopTags	Ljava/util/List;
    //   842: aload_0
    //   843: getfield 89	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   846: bipush 6
    //   848: invokevirtual 1299	android/os/Handler:sendEmptyMessage	(I)Z
    //   851: pop
    //   852: return
    //   853: aload_0
    //   854: getfield 1708	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   857: ifnull -733 -> 124
    //   860: aload_0
    //   861: aload_0
    //   862: getfield 1708	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   865: invokestatic 1713	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   868: astore_3
    //   869: aload_3
    //   870: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   873: ifne -749 -> 124
    //   876: new 54	java/util/ArrayList
    //   879: dup
    //   880: invokespecial 55	java/util/ArrayList:<init>	()V
    //   883: astore 9
    //   885: aload 9
    //   887: aload_3
    //   888: invokevirtual 260	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   891: pop
    //   892: aload_0
    //   893: aload 9
    //   895: invokespecial 1715	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Ljava/util/ArrayList;)V
    //   898: return
    //   899: astore 10
    //   901: goto -81 -> 820
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	904	0	this	TroopInfoActivity
    //   0	904	1	paramInt1	int
    //   0	904	2	paramInt2	int
    //   0	904	3	paramIntent	Intent
    //   1	793	4	j	int
    //   591	68	5	l1	long
    //   579	78	7	l2	long
    //   309	500	9	localObject	Object
    //   827	1	9	localJSONException1	org.json.JSONException
    //   883	11	9	localArrayList	ArrayList
    //   351	1	10	localNumberFormatException	NumberFormatException
    //   899	1	10	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   318	332	351	java/lang/NumberFormatException
    //   581	593	634	java/lang/Exception
    //   782	793	827	org/json/JSONException
    //   796	802	827	org/json/JSONException
    //   807	820	899	org/json/JSONException
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
      b();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      paramBundle = (BizTroopHandler)this.app.a(22);
      if (paramBundle != null) {
        paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "");
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle, "com.tencent.msg.permission.pushnotify", null);
      this.jdField_h_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l));
      }
      BnrReport.a(this.app, 78);
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      int j = this.jdField_g_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
      for (paramBundle = "0";; paramBundle = "1")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str, String.valueOf(j), paramBundle, "");
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
    GroupCatalogTool.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a();
    }
    if (this.jdField_h_of_type_Boolean) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_h_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilObserver != null) {
        new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler).b(this.jdField_a_of_type_JavaUtilObserver);
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
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    a(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("hasPic", bool);
      localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      return;
    }
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
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(20));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    ThreadManager.post(new txq(this), 5, null, true);
  }
  
  public void finish()
  {
    j();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 28) {
      setResult(-1, getIntent());
    }
    if (this.jdField_f_of_type_Boolean) {
      l();
    }
    if ((!this.i) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop))
    {
      TroopUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this, new tyv(this));
      return;
    }
    Intent localIntent;
    Bundle localBundle;
    if ((this.jdField_g_of_type_Boolean) && (!this.i))
    {
      localIntent = new Intent();
      localBundle = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3);
      localBundle.putInt("troop_type_ex", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt);
      localBundle.putString("leftViewText", getString(2131435350));
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)) {
        break label270;
      }
    }
    label270:
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("extra_default_open_search", bool);
      localIntent.putExtras(localBundle);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", "管理群", TroopManageProxyActivity.class, this, localIntent, TroopBaseProxyActivity.a(this), "com.tencent.mobileqq.activity.TroopSearchWayActivity", this.app.getCurrentAccountUin(), -1);
      super.finish();
      switch (this.jdField_h_of_type_Int)
      {
      default: 
        return;
      }
      overridePendingTransition(0, 2131034122);
      return;
    }
  }
  
  protected void g()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    Object localObject3 = GroupCatalogTool.a(getApplicationContext()).a(this, (String)localObject1);
    localObject1 = "";
    int j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {
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
              break label308;
            }
            if (((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString.equals("其他"))
            {
              j = 0;
              break;
            }
            localObject1 = ((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString;
            j = 1;
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
      label308:
      j = 0;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 16);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {
      setResult(-1);
    }
    if (!this.jdField_e_of_type_Boolean)
    {
      finish();
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa), "", "");
    Object localObject2 = (BizTroopHandler)this.app.a(22);
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
    int n = 0;
    int m = 0;
    long l1 = 0L;
    long l4 = 0L;
    Object localObject1 = "";
    int j;
    long l2;
    int k;
    long l3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      j = m;
      l2 = l1;
      k = n;
      l3 = l1;
    }
    for (;;)
    {
      try
      {
        localObject3 = ((String)localObject3).split("\\|");
        j = m;
        l2 = l1;
        k = n;
        l3 = l1;
        m = Integer.valueOf(localObject3[0]).intValue();
        j = m;
        l2 = l1;
        k = m;
        l3 = l1;
        l1 = (Double.valueOf(localObject3[1]).doubleValue() * 1000000.0D);
        j = m;
        l2 = l1;
        k = m;
        l3 = l1;
        long l5 = (Double.valueOf(localObject3[2]).doubleValue() * 1000000.0D);
        localObject1 = localObject3[3];
        j = m;
        l2 = l5;
        b(getString(2131435746));
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
        {
          m = 3;
          if (m == -1) {
            break;
          }
          k = 1;
          if (this.jdField_c_of_type_Long == 0L) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == this.jdField_c_of_type_Long) {
            continue;
          }
          k = 3;
          if (((this.jdField_a_of_type_Int == 0) || (1 == this.jdField_a_of_type_Int)) && (m == 3)) {
            ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
          }
          if (((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) && ((m == 0) || (1 == m))) {
            ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
          }
          if (((2 != this.jdField_a_of_type_Int) && (4 != this.jdField_a_of_type_Int)) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt != 4))) {
            continue;
          }
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
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "local_sub", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaLangString, "", "");
          TroopInfoActivityHelper.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, j, l4, l3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, k, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new txr(this));
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        l1 = l2;
        l2 = l4;
        continue;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        j = k;
        l1 = l3;
        l2 = l4;
        continue;
        m = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) {
          continue;
        }
        k = 4;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId == 0L) {
          continue;
        }
        k = 2;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId != 0L) || (this.jdField_c_of_type_Long != 0L))
        {
          TroopInfoActivityHelper.a(this.app, l6, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, j, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId, k, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName, new txs(this));
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
        {
          j();
          if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2))
          {
            k = 1;
            if ((this.jdField_b_of_type_Int > 0) && (k != 0)) {
              break;
            }
            if (this.jdField_e_of_type_Int <= 0) {
              continue;
            }
            a(l6, m, j, l1, l2, (String)localObject1);
            ReportController.b(this.app, "dc00899", "Grp_certified", "", "data", "exp_edit_data", 4, 0, "" + l6, "", "", "");
            return;
          }
          k = 0;
          continue;
          if (this.jdField_d_of_type_Int <= 0) {
            break;
          }
          localObject1 = DialogUtil.a(this, 230);
          ((QQCustomDialog)localObject1).setTitle(null);
          ((QQCustomDialog)localObject1).setMessage(getString(2131435748, new Object[] { Integer.valueOf(this.jdField_d_of_type_Int) }));
          ((QQCustomDialog)localObject1).setPositiveButton(getString(2131430555), new DialogUtil.DialogOnClickAdapter());
          ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131430555));
          ((QQCustomDialog)localObject1).show();
          return;
        }
        ((BizTroopHandler)localObject2).a(l6, m, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags, j, l1, l2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mPoiId, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
        return;
      }
      j = 0;
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
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0)) {
      a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
        {
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
          return;
        }
        a(5, "无", true);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))
      {
        a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, false);
        return;
      }
    } while (this.jdField_a_of_type_ArrayOfAndroidViewView[5] == null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5].setVisibility(8);
  }
  
  public void l()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
    startActivity(localIntent);
  }
  
  public void m()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if ((localTroopInfo != null) && ((localTroopInfo.troopTypeExt == 2) || (localTroopInfo.troopTypeExt == 4)) && (localTroopInfo.isAdmin()) && (!this.app.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false)))
    {
      DialogUtil.a(this, 230, null, getString(2131430236), null, getString(2131430237), new DialogUtil.DialogOnClickAdapter(), null).show();
      this.app.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
    }
    new TroopAvatarManger(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  public void n()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435070);
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
  
  public void o()
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
  
  public void onBackPressed()
  {
    d();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    case 7: 
    default: 
    case 3: 
    case 4: 
    case 8: 
    case 9: 
    case 5: 
    case 6: 
    case 11: 
      do
      {
        do
        {
          return;
          paramView = new Intent(this, EditInfoActivity.class);
          paramView.putExtra("edit_type", 0);
          paramView.putExtra("title", "编辑群聊名称");
          paramView.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName);
          paramView.putExtra("max_num", 30);
          paramView.putExtra("canPostNull", false);
          startActivityForResult(paramView, 6);
          return;
          if (this.jdField_f_of_type_Int == 1)
          {
            QQToast.a(getApplicationContext(), 1, "请先解除绑定游戏，再修改群分类", 0).a();
            return;
          }
          paramView = new Intent(getActivity(), TroopClassChoiceActivity.class);
          paramView.putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
          startActivityForResult(paramView, 11);
          return;
          g();
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", "https://buluo.qq.com/mobile/qunbindbuluo.html?_wv=1027");
          paramView.putExtra("bid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId);
          startActivityForResult(paramView, 17);
          return;
          h();
          return;
          paramView = new Intent(this, EditInfoActivity.class);
          paramView.putExtra("edit_type", 1);
          paramView.putExtra("title", getString(2131433498));
          paramView.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
          paramView.putExtra("max_num", 900);
          paramView.putExtra("canPostNull", true);
          paramView.putExtra("support_emotion", true);
          paramView.putExtra("full_screen", true);
          startActivityForResult(paramView, 5);
          a("Grp_moredata", "Clk_brief", "");
          return;
          if (!NetworkUtil.d(this))
          {
            a(2131433213, 0);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null);
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          n();
          this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 8390784);
          return;
        }
        catch (Exception paramView) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.troopinfo", 2, paramView.toString());
      return;
    case 2: 
      s();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead))
    {
      u();
      return;
    }
    t();
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), ProtoServlet.class);
      tyo localtyo = new tyo(this);
      localtyo.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.app);
      localtyo.jdField_b_of_type_Int = 2;
      ((NewIntent)localObject).setObserver(localtyo);
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