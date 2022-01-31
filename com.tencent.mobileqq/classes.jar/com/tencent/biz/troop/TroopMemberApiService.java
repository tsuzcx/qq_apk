package com.tencent.biz.troop;

import absl;
import aiab;
import alkl;
import allj;
import alox;
import alqf;
import alqj;
import alqy;
import alwf;
import alwv;
import amab;
import ambg;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import aovj;
import arni;
import arof;
import autc;
import azmj;
import batw;
import baua;
import bbpe;
import bcil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mzx;
import nag;
import nan;
import nbd;
import nbh;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oxb;
import oxe;
import pif;
import swf;
import tencent.im.group.nearbybanner.nearbybanner.ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import yms;
import ymt;
import ymu;
import ymv;
import ymw;
import ymx;
import ymy;
import ymz;
import yna;
import ynb;
import ync;

public class TroopMemberApiService
  extends AppService
{
  public int a;
  public absl a;
  alkl jdField_a_of_type_Alkl = new ymw(this);
  public allj a;
  public alox a;
  alqf jdField_a_of_type_Alqf = new yms(this);
  public alqj a;
  public alqy a;
  public alwf a;
  amab jdField_a_of_type_Amab = new ymv(this);
  ambg jdField_a_of_type_Ambg = new ymu(this);
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new ync(this));
  public autc a;
  public baua a;
  public String a;
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap<String, Messenger> a;
  nbd jdField_a_of_type_Nbd;
  nbh jdField_a_of_type_Nbh;
  public oxe a;
  public pif a;
  public swf a;
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
    this.jdField_a_of_type_Absl = null;
    this.jdField_a_of_type_Alqj = null;
    this.jdField_a_of_type_Pif = null;
    this.jdField_a_of_type_Alqy = new ymx(this);
    this.jdField_a_of_type_Alox = new ymy(this);
    this.jdField_a_of_type_Autc = new ymz(this);
    this.jdField_a_of_type_Oxe = new yna(this);
    this.jdField_a_of_type_Baua = new ynb(this);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, HWTroopFileStatusInfo paramHWTroopFileStatusInfo, Bundle paramBundle)
  {
    if (paramHWTroopFileStatusInfo == null) {
      return;
    }
    FileInfo localFileInfo = new FileInfo();
    if (!arof.a(paramHWTroopFileStatusInfo.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong).b();
    }
    String str = "";
    if (!TextUtils.isEmpty(paramHWTroopFileStatusInfo.FileName)) {
      str = paramHWTroopFileStatusInfo.FileName;
    }
    bcil.a(paramQQAppInterface, paramLong).a(paramHWTroopFileStatusInfo.Id);
    localFileInfo.d(str);
    localFileInfo.e(paramHWTroopFileStatusInfo.LocalFile);
    localFileInfo.a(paramHWTroopFileStatusInfo.ProgressTotal);
    paramQQAppInterface = new bbpe();
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
    paramBundle.putLong("sessionId", arni.a(paramQQAppInterface).nSessionId);
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
    aovj localaovj = aiab.a().a(paramLong);
    if ((localaovj == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
      return false;
    }
    boolean bool;
    if (localaovj.jdField_a_of_type_Byte == 0)
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
      localaovj.jdField_a_of_type_Byte = b1;
      if (!(this.app instanceof QQAppInterface)) {
        break;
      }
      aiab.a().a((QQAppInterface)this.app, localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      alwv localalwv = (alwv)((QQAppInterface)this.app).a(31);
      if (localalwv != null) {
        localalwv.a(String.valueOf(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, paramLong);
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
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.3.3.4515"));
      ((nearbybanner.ClientInfo)localObject).uint32_os.set(0);
      localReqBody.msg_client_info.set((MessageMicro)localObject);
      localObject = new NewIntent(paramAppRuntime.getApplication(), mzx.class);
      ((NewIntent)localObject).putExtra("cmd", "nearby_group_banner.get_banner_info");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return true;
    }
    catch (Exception paramAppRuntime) {}
    return false;
  }
  
  public nbd a()
  {
    if (this.jdField_a_of_type_Nbd == null) {
      this.jdField_a_of_type_Nbd = new nbd(this);
    }
    return this.jdField_a_of_type_Nbd;
  }
  
  public nbh a()
  {
    if (this.jdField_a_of_type_Nbh == null) {
      this.jdField_a_of_type_Nbh = new nbh(this);
    }
    return this.jdField_a_of_type_Nbh;
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
      Object localObject2 = (nan)((QQAppInterface)localObject1).getManager(70);
      i = j;
      if (localObject2 != null)
      {
        localObject2 = ((nan)localObject2).a(7);
        i = j;
        if (localObject2 != null)
        {
          nag.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (nag)((QQAppInterface)this.app).a(43);
          i = j;
          if (localObject1 != null) {
            ((nag)localObject1).notifyUI(105, true, null);
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
      azmj.b(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext());
    localWtloginHelper.SetListener(new ymt(this, localWtloginHelper));
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
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport param null");
    return;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      paramString2 = URLEncoder.encode(paramString2);
      paramString1 = "groupuin=" + paramString1 + "&eviluin=0&anonyid=" + paramString2 + "&impeachuin=" + paramString3 + "&msglist=" + paramString4;
      paramString1 = paramString1 + "&uin_source=unfriend";
      paramString1 = "SourceID=401&appname=KQQ&jubaotype=uin&system=android&subapp=BusinessCard&" + paramString1;
      if (paramString1 == null) {
        paramString1 = null;
      }
      for (;;)
      {
        paramString2 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        paramString2.putExtra("BSafeReportPost", true);
        paramString2.putExtra("SafeReportData", paramString1);
        paramString2.putExtra("hide_more_button", true);
        paramString2.putExtra("ishiderefresh", true);
        paramString2.putExtra("ishidebackforward", true);
        paramString2.putExtra("url", "https://jubao.qq.com/cn/jubao");
        paramString2.addFlags(268435456);
        BaseApplication.getContext().startActivity(paramString2);
        return;
        try
        {
          paramString1 = paramString1.getBytes("utf-8");
        }
        catch (Exception paramString1) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport exception" + paramString1.getMessage());
      return;
      paramString1 = "0";
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
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Alkl, true);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Alqy);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Alox);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Amab);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Alqf);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Autc);
      this.app.registObserver(this.jdField_a_of_type_Ambg);
    }
    oxb.a().a(this.jdField_a_of_type_Oxe);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Alkl);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Alqy);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Alox);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Amab);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Alqf);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Autc);
      ((QQAppInterface)this.app).a().b(this.jdField_a_of_type_Baua);
      this.app.unRegistObserver(this.jdField_a_of_type_Ambg);
    }
    oxb.a().b(this.jdField_a_of_type_Oxe);
    if ((TextUtils.isEmpty(this.d)) || (this.jdField_a_of_type_Pif != null)) {
      this.jdField_a_of_type_Pif.a();
    }
    this.app = null;
    this.jdField_b_of_type_AndroidOsMessenger = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_Allj != null) {
      this.jdField_a_of_type_Allj.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */