package com.tencent.biz.troop;

import aabc;
import acjx;
import ajek;
import amop;
import ampm;
import amsu;
import amua;
import amuf;
import amuv;
import amzb;
import amzs;
import andd;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anej;
import aqmf;
import aszt;
import awkv;
import bcef;
import becp;
import bfbb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
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
import nma;
import nmj;
import nmq;
import nmy;
import nng;
import nnk;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import pkp;
import pkt;
import pxu;
import tencent.im.group.nearbybanner.nearbybanner.ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import uee;
import zov;
import zow;
import zox;
import zoy;
import zoz;
import zpa;
import zpb;
import zpc;
import zpd;
import zpe;
import zpf;

public class TroopMemberApiService
  extends AppService
{
  public int a;
  public acjx a;
  amop jdField_a_of_type_Amop = new zoz(this);
  public ampm a;
  public amsu a;
  amua jdField_a_of_type_Amua = new zov(this);
  public amuf a;
  public amuv a;
  public amzb a;
  andd jdField_a_of_type_Andd = new zoy(this);
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new zpf(this));
  anej jdField_a_of_type_Anej = new zox(this);
  public awkv a;
  public TransProcessorHandler a;
  public String a;
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap<String, Messenger> a;
  nng jdField_a_of_type_Nng;
  nnk jdField_a_of_type_Nnk;
  public pkt a;
  public pxu a;
  public uee a;
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
    this.jdField_a_of_type_Acjx = null;
    this.jdField_a_of_type_Amuf = null;
    this.jdField_a_of_type_Pxu = null;
    this.jdField_a_of_type_Amuv = new zpa(this);
    this.jdField_a_of_type_Amsu = new zpb(this);
    this.jdField_a_of_type_Awkv = new zpc(this);
    this.jdField_a_of_type_Pkt = new zpd(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new zpe(this);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, HWTroopFileStatusInfo paramHWTroopFileStatusInfo, Bundle paramBundle)
  {
    if (paramHWTroopFileStatusInfo == null) {
      return;
    }
    FileInfo localFileInfo = new FileInfo();
    if (!FileUtil.isFileExists(paramHWTroopFileStatusInfo.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong).b();
    }
    String str = "";
    if (!TextUtils.isEmpty(paramHWTroopFileStatusInfo.FileName)) {
      str = paramHWTroopFileStatusInfo.FileName;
    }
    bfbb.a(paramQQAppInterface, paramLong).a(paramHWTroopFileStatusInfo.Id);
    localFileInfo.d(str);
    localFileInfo.e(paramHWTroopFileStatusInfo.LocalFile);
    localFileInfo.a(paramHWTroopFileStatusInfo.ProgressTotal);
    paramQQAppInterface = new becp();
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
    paramBundle.putLong("sessionId", aszt.a(paramQQAppInterface).nSessionId);
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
    aqmf localaqmf = ajek.a().a(paramLong);
    if ((localaqmf == null) || (localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
      return false;
    }
    boolean bool;
    if (localaqmf.jdField_a_of_type_Byte == 0)
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
      localaqmf.jdField_a_of_type_Byte = b1;
      if (!(this.app instanceof QQAppInterface)) {
        break;
      }
      ajek.a().a((QQAppInterface)this.app, localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      amzs localamzs = (amzs)((QQAppInterface)this.app).getBusinessHandler(31);
      if (localamzs != null) {
        localamzs.a(String.valueOf(localaqmf.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, paramLong);
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
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.4.8.4810"));
      ((nearbybanner.ClientInfo)localObject).uint32_os.set(0);
      localReqBody.msg_client_info.set((MessageMicro)localObject);
      localObject = new NewIntent(paramAppRuntime.getApplication(), nma.class);
      ((NewIntent)localObject).putExtra("cmd", "nearby_group_banner.get_banner_info");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return true;
    }
    catch (Exception paramAppRuntime) {}
    return false;
  }
  
  public nng a()
  {
    if (this.jdField_a_of_type_Nng == null) {
      this.jdField_a_of_type_Nng = new nng(this);
    }
    return this.jdField_a_of_type_Nng;
  }
  
  public nnk a()
  {
    if (this.jdField_a_of_type_Nnk == null) {
      this.jdField_a_of_type_Nnk = new nnk(this);
    }
    return this.jdField_a_of_type_Nnk;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    String str = null;
    Message localMessage = Message.obtain(null, paramInt);
    Messenger localMessenger2 = this.jdField_b_of_type_AndroidOsMessenger;
    if (paramBundle != null) {
      str = paramBundle.getString("processName");
    }
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
      Object localObject2 = (nmq)((QQAppInterface)localObject1).getManager(70);
      i = j;
      if (localObject2 != null)
      {
        localObject2 = ((nmq)localObject2).a(7);
        i = j;
        if (localObject2 != null)
        {
          nmj.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (nmj)((QQAppInterface)this.app).getBusinessHandler(43);
          i = j;
          if (localObject1 != null) {
            ((nmj)localObject1).notifyUI(105, true, null);
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
      bcef.b(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext());
    localWtloginHelper.SetListener(new zow(this, localWtloginHelper));
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
      l = nmy.a;
    } while (l == -1L);
    localObject = new Bundle();
    ((Bundle)localObject).putLong("anonymousseq", l);
    if (BaseActivity.sTopActivity != null) {}
    for (paramString4 = BaseActivity.sTopActivity;; paramString4 = getApplicationContext())
    {
      aabc.a((BaseActivity)paramString4, paramString2, null, null, paramString1, paramString3, 25029, null, (Bundle)localObject);
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
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Amop, true);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Amuv);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Amsu);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Andd);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Amua);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Awkv);
      this.app.registObserver(this.jdField_a_of_type_Anej);
    }
    pkp.a().a(this.jdField_a_of_type_Pkt);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Amop);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Amuv);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Amsu);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Andd);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Amua);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Awkv);
      if (((QQAppInterface)this.app).isTransFileControllerNotNull()) {
        ((QQAppInterface)this.app).getTransFileController().removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      }
      this.app.unRegistObserver(this.jdField_a_of_type_Anej);
    }
    pkp.a().b(this.jdField_a_of_type_Pkt);
    if ((TextUtils.isEmpty(this.d)) || (this.jdField_a_of_type_Pxu != null)) {
      this.jdField_a_of_type_Pxu.a();
    }
    this.app = null;
    this.jdField_b_of_type_AndroidOsMessenger = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_Ampm != null) {
      this.jdField_a_of_type_Ampm.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */