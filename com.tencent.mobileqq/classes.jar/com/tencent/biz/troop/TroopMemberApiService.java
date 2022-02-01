package com.tencent.biz.troop;

import aasj;
import aask;
import aasl;
import aasm;
import aasn;
import aaso;
import aasp;
import aasq;
import aasr;
import aass;
import aast;
import aber;
import adne;
import akgr;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anua;
import anve;
import anyu;
import aoaa;
import aoaf;
import aoau;
import aofl;
import aogd;
import aojs;
import aoky;
import arsh;
import aunj;
import auog;
import axxn;
import bdll;
import beyb;
import beyf;
import bftf;
import bgrn;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import nkl;
import nku;
import nlb;
import nlj;
import nlr;
import nlv;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import pfd;
import pfh;
import psb;
import tencent.im.group.nearbybanner.nearbybanner.ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import txp;

public class TroopMemberApiService
  extends AppService
{
  public int a;
  public adne a;
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new aast(this));
  anua jdField_a_of_type_Anua = new aasn(this);
  public anve a;
  public anyu a;
  aoaa jdField_a_of_type_Aoaa = new aasj(this);
  public aoaf a;
  public aoau a;
  public aofl a;
  aojs jdField_a_of_type_Aojs = new aasm(this);
  aoky jdField_a_of_type_Aoky = new aasl(this);
  public axxn a;
  public beyf a;
  public String a;
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap<String, Messenger> a;
  nlr jdField_a_of_type_Nlr;
  nlv jdField_a_of_type_Nlv;
  public pfh a;
  public psb a;
  public txp a;
  public boolean a;
  public int b;
  public Messenger b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  String d;
  public int e;
  public int f;
  public int g;
  
  public TroopMemberApiService()
  {
    this.jdField_b_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Adne = null;
    this.jdField_a_of_type_Aoaf = null;
    this.jdField_a_of_type_Psb = null;
    this.jdField_a_of_type_Aoau = new aaso(this);
    this.jdField_a_of_type_Anyu = new aasp(this);
    this.jdField_a_of_type_Axxn = new aasq(this);
    this.jdField_a_of_type_Pfh = new aasr(this);
    this.jdField_a_of_type_Beyf = new aass(this);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, HWTroopFileStatusInfo paramHWTroopFileStatusInfo, Bundle paramBundle)
  {
    if (paramHWTroopFileStatusInfo == null) {
      return;
    }
    FileInfo localFileInfo = new FileInfo();
    if (!auog.a(paramHWTroopFileStatusInfo.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong).b();
    }
    String str = "";
    if (!TextUtils.isEmpty(paramHWTroopFileStatusInfo.FileName)) {
      str = paramHWTroopFileStatusInfo.FileName;
    }
    bgrn.a(paramQQAppInterface, paramLong).a(paramHWTroopFileStatusInfo.Id);
    localFileInfo.d(str);
    localFileInfo.e(paramHWTroopFileStatusInfo.LocalFile);
    localFileInfo.a(paramHWTroopFileStatusInfo.ProgressTotal);
    paramQQAppInterface = new bftf();
    paramQQAppInterface.g = str;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramHWTroopFileStatusInfo.LocalFile;
    paramQQAppInterface.jdField_c_of_type_Long = paramHWTroopFileStatusInfo.ProgressTotal;
    paramQQAppInterface.jdField_a_of_type_JavaUtilUUID = paramHWTroopFileStatusInfo.Id;
    paramQQAppInterface.jdField_b_of_type_Long = paramLong;
    paramQQAppInterface.h = paramHWTroopFileStatusInfo.BusId;
    paramQQAppInterface.e = paramHWTroopFileStatusInfo.FilePath;
    paramQQAppInterface.f = paramHWTroopFileStatusInfo.sha1;
    paramQQAppInterface.jdField_b_of_type_JavaLangString = paramHWTroopFileStatusInfo.ThumbnailFile_Small;
    paramQQAppInterface.jdField_c_of_type_JavaLangString = paramHWTroopFileStatusInfo.ThumbnailFile_Large;
    paramQQAppInterface.jdField_b_of_type_Int = paramHWTroopFileStatusInfo.Status;
    paramBundle.putLong("sessionId", aunj.a(paramQQAppInterface).nSessionId);
    paramBundle.putInt("cloudType", 4);
    paramBundle.putInt("type", 10006);
    paramBundle.putString("filePath", localFileInfo.c());
    paramBundle.putString("fileName", localFileInfo.d());
    paramBundle.putLong("fileSize", localFileInfo.a());
    paramBundle.putLong("troopCode", paramLong);
    a(20, paramBundle);
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    arsh localarsh = akgr.a().a(paramLong);
    if ((localarsh == null) || (localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
      return false;
    }
    boolean bool;
    if (localarsh.jdField_a_of_type_Byte == 0)
    {
      bool = true;
      label35:
      if (paramBoolean == bool) {
        break label143;
      }
      if (!paramBoolean) {
        break label145;
      }
    }
    label143:
    label145:
    for (byte b1 = 0;; b1 = 1)
    {
      localarsh.jdField_a_of_type_Byte = b1;
      if (!(this.app instanceof QQAppInterface)) {
        break;
      }
      akgr.a().a((QQAppInterface)this.app, localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      aogd localaogd = (aogd)((QQAppInterface)this.app).a(31);
      if (localaogd != null) {
        localaogd.a(String.valueOf(localarsh.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, paramLong);
      }
      return true;
      bool = false;
      break label35;
      break;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    nearbybanner.ReqBody localReqBody = new nearbybanner.ReqBody();
    try
    {
      Object localObject = paramAppRuntime.getApplication().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = new nearbybanner.ClientInfo();
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_height.set(j);
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_width.set(i);
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.4.5.4745"));
      ((nearbybanner.ClientInfo)localObject).uint32_os.set(0);
      localReqBody.msg_client_info.set((MessageMicro)localObject);
      localObject = new NewIntent(paramAppRuntime.getApplication(), nkl.class);
      ((NewIntent)localObject).putExtra("cmd", "nearby_group_banner.get_banner_info");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return true;
    }
    catch (Exception paramAppRuntime) {}
    return false;
  }
  
  public nlr a()
  {
    if (this.jdField_a_of_type_Nlr == null) {
      this.jdField_a_of_type_Nlr = new nlr(this);
    }
    return this.jdField_a_of_type_Nlr;
  }
  
  public nlv a()
  {
    if (this.jdField_a_of_type_Nlv == null) {
      this.jdField_a_of_type_Nlv = new nlv(this);
    }
    return this.jdField_a_of_type_Nlv;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    Messenger localMessenger2 = this.jdField_b_of_type_AndroidOsMessenger;
    String str = paramBundle.getString("processName");
    Messenger localMessenger1 = localMessenger2;
    if (str != null)
    {
      localMessenger1 = localMessenger2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localMessenger1 = localMessenger2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) {
          localMessenger1 = (Messenger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        }
      }
    }
    localMessage.setData(paramBundle);
    if (localMessenger1 != null) {}
    try
    {
      localMessenger1.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("com.tencent.biz.troop.TroopMemberApiService", 2, "messeage not sent:" + paramBundle.getMessage());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int j = 0;
    Object localObject1;
    if ((this.app instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (nlb)((QQAppInterface)localObject1).getManager(70);
      i = j;
      if (localObject2 != null)
      {
        localObject2 = ((nlb)localObject2).a(7);
        i = j;
        if (localObject2 != null)
        {
          nku.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (nku)((QQAppInterface)this.app).a(43);
          i = j;
          if (localObject1 != null) {
            ((nku)localObject1).notifyUI(105, true, null);
          }
        }
      }
    }
    for (int i = j;; i = 1)
    {
      localObject1 = new Bundle();
      if (paramBundle != null)
      {
        ((Bundle)localObject1).putInt("seq", paramBundle.getInt("seq", -1));
        if (!TextUtils.isEmpty(paramBundle.getString("callback"))) {
          ((Bundle)localObject1).putString("callback", paramBundle.getString("callback"));
        }
      }
      ((Bundle)localObject1).putString("data", "{code:\"" + i + "\"}");
      ((Bundle)localObject1).putString("method", "cleanDynamicRedPoint");
      a(15, (Bundle)localObject1);
      return;
      bdll.b(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext());
    localWtloginHelper.SetListener(new aask(this, localWtloginHelper));
    String str = this.app.getAccount();
    paramString1 = paramString1.getBytes();
    long l = Long.valueOf(paramString2).longValue();
    paramString2 = "5.2".getBytes();
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    WFastLoginInfo localWFastLoginInfo = new WFastLoginInfo();
    if (localWtloginHelper.GetA1WithA1(str, 16L, 16L, paramString1, 1L, l, 1L, paramString2, new byte[] { -51, 50, 114, -105, -54, -19, 112, -124, -125, -52, -72, -101, -27, 33, 65, -128 }, localWUserSigInfo, localWFastLoginInfo) != -1001) {
      a(61, null);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = this.app;
    if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    long l;
    do
    {
      do
      {
        return;
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport param null");
      return;
      l = nlj.a;
    } while (l == -1L);
    localObject = new Bundle();
    ((Bundle)localObject).putLong("anonymousseq", l);
    if (BaseActivity.sTopActivity != null) {}
    for (paramString4 = BaseActivity.sTopActivity;; paramString4 = getApplicationContext())
    {
      aber.a((BaseActivity)paramString4, paramString2, null, null, paramString1, paramString3, 25029, null, (Bundle)localObject);
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onBind");
    }
    return this.jdField_a_of_type_AndroidOsMessenger.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onCreate");
    }
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Anua, true);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Aoau);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Anyu);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Aojs);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Aoaa);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Axxn);
      this.app.registObserver(this.jdField_a_of_type_Aoky);
    }
    pfd.a().a(this.jdField_a_of_type_Pfh);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Anua);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Aoau);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Anyu);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Aojs);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Aoaa);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Axxn);
      if (((QQAppInterface)this.app).a()) {
        ((QQAppInterface)this.app).a().b(this.jdField_a_of_type_Beyf);
      }
      this.app.unRegistObserver(this.jdField_a_of_type_Aoky);
    }
    pfd.a().b(this.jdField_a_of_type_Pfh);
    if ((TextUtils.isEmpty(this.d)) || (this.jdField_a_of_type_Psb != null)) {
      this.jdField_a_of_type_Psb.a();
    }
    this.app = null;
    this.jdField_b_of_type_AndroidOsMessenger = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_Anve != null) {
      this.jdField_a_of_type_Anve.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */