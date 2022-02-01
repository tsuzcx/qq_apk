package com.tencent.biz.troop;

import aaeg;
import aaeh;
import aaei;
import aaej;
import aaek;
import aael;
import aaem;
import aaen;
import aaeo;
import aaep;
import aaeq;
import aaqo;
import adag;
import ajzy;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anrc;
import anrz;
import anvi;
import anwo;
import anwt;
import anxj;
import aobq;
import aoch;
import aofu;
import aogz;
import arpq;
import auea;
import axqx;
import bdla;
import bfjs;
import bgjh;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import nta;
import ntj;
import ntq;
import nty;
import nug;
import nuk;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import pvm;
import pvq;
import qjy;
import tencent.im.group.nearbybanner.nearbybanner.ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import usb;

public class TroopMemberApiService
  extends AppService
{
  public int a;
  public adag a;
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new aaeq(this));
  anrc jdField_a_of_type_Anrc = new aaek(this);
  public anrz a;
  public anvi a;
  anwo jdField_a_of_type_Anwo = new aaeg(this);
  public anwt a;
  public anxj a;
  public aobq a;
  aofu jdField_a_of_type_Aofu = new aaej(this);
  aogz jdField_a_of_type_Aogz = new aaei(this);
  public axqx a;
  public TransProcessorHandler a;
  public String a;
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap<String, Messenger> a;
  nug jdField_a_of_type_Nug;
  nuk jdField_a_of_type_Nuk;
  public pvq a;
  public qjy a;
  public usb a;
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
    this.jdField_a_of_type_Adag = null;
    this.jdField_a_of_type_Anwt = null;
    this.jdField_a_of_type_Qjy = null;
    this.jdField_a_of_type_Anxj = new aael(this);
    this.jdField_a_of_type_Anvi = new aaem(this);
    this.jdField_a_of_type_Axqx = new aaen(this);
    this.jdField_a_of_type_Pvq = new aaeo(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new aaep(this);
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
    bgjh.a(paramQQAppInterface, paramLong).a(paramHWTroopFileStatusInfo.Id);
    localFileInfo.d(str);
    localFileInfo.e(paramHWTroopFileStatusInfo.LocalFile);
    localFileInfo.a(paramHWTroopFileStatusInfo.ProgressTotal);
    paramQQAppInterface = new bfjs();
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
    paramBundle.putLong("sessionId", auea.a(paramQQAppInterface).nSessionId);
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
    arpq localarpq = ajzy.a().a(paramLong);
    if ((localarpq == null) || (localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
      return false;
    }
    boolean bool;
    if (localarpq.jdField_a_of_type_Byte == 0)
    {
      bool = true;
      label35:
      if (paramBoolean == bool) {
        break label144;
      }
      if (!paramBoolean) {
        break label146;
      }
    }
    label144:
    label146:
    for (byte b1 = 0;; b1 = 1)
    {
      localarpq.jdField_a_of_type_Byte = b1;
      if (!(this.app instanceof QQAppInterface)) {
        break;
      }
      ajzy.a().a((QQAppInterface)this.app, localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      aoch localaoch = (aoch)((QQAppInterface)this.app).getBusinessHandler(BusinessHandlerFactory.RED_TOUCH_HANDLER);
      if (localaoch != null) {
        localaoch.a(String.valueOf(localarpq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, paramLong);
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
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.4.10.4875"));
      ((nearbybanner.ClientInfo)localObject).uint32_os.set(0);
      localReqBody.msg_client_info.set((MessageMicro)localObject);
      localObject = new NewIntent(paramAppRuntime.getApplication(), nta.class);
      ((NewIntent)localObject).putExtra("cmd", "nearby_group_banner.get_banner_info");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return true;
    }
    catch (Exception paramAppRuntime) {}
    return false;
  }
  
  public nug a()
  {
    if (this.jdField_a_of_type_Nug == null) {
      this.jdField_a_of_type_Nug = new nug(this);
    }
    return this.jdField_a_of_type_Nug;
  }
  
  public nuk a()
  {
    if (this.jdField_a_of_type_Nuk == null) {
      this.jdField_a_of_type_Nuk = new nuk(this);
    }
    return this.jdField_a_of_type_Nuk;
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
      Object localObject2 = (ntq)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
      i = j;
      if (localObject2 != null)
      {
        localObject2 = ((ntq)localObject2).a(7);
        i = j;
        if (localObject2 != null)
        {
          ntj.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (ntj)((QQAppInterface)this.app).getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
          i = j;
          if (localObject1 != null) {
            ((ntj)localObject1).notifyUI(105, true, null);
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
      bdla.b(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext());
    localWtloginHelper.SetListener(new aaeh(this, localWtloginHelper));
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
      l = nty.a;
    } while (l == -1L);
    localObject = new Bundle();
    ((Bundle)localObject).putLong("anonymousseq", l);
    if (BaseActivity.sTopActivity != null) {}
    for (paramString4 = BaseActivity.sTopActivity;; paramString4 = getApplicationContext())
    {
      aaqo.a((BaseActivity)paramString4, paramString2, null, null, paramString1, paramString3, 25029, null, (Bundle)localObject);
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
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Anrc, true);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Anxj);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Anvi);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Aofu);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Anwo);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Axqx);
      this.app.registObserver(this.jdField_a_of_type_Aogz);
    }
    pvm.a().a(this.jdField_a_of_type_Pvq);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Anrc);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Anxj);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Anvi);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Aofu);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Anwo);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Axqx);
      if (((QQAppInterface)this.app).isTransFileControllerNotNull()) {
        ((QQAppInterface)this.app).getTransFileController().removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      }
      this.app.unRegistObserver(this.jdField_a_of_type_Aogz);
    }
    pvm.a().b(this.jdField_a_of_type_Pvq);
    if ((TextUtils.isEmpty(this.d)) || (this.jdField_a_of_type_Qjy != null)) {
      this.jdField_a_of_type_Qjy.a();
    }
    this.app = null;
    this.jdField_b_of_type_AndroidOsMessenger = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_Anrz != null) {
      this.jdField_a_of_type_Anrz.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */