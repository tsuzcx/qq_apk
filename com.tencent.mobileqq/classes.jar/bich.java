import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.data.GameNoticeInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.pb.gamecenter.MonitReport.MonitReportReq;
import com.tencent.pb.gamecenter.MonitReport.PublicAccountReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.sso.WadlCmdUtil.1;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bich
{
  private static volatile bich jdField_a_of_type_Bich;
  public static String a;
  public static HashSet<String> a;
  static byte[] jdField_a_of_type_ArrayOfByte;
  private static String jdField_b_of_type_JavaLangString;
  private static String c;
  private long jdField_a_of_type_Long = -1L;
  private CopyOnWriteArrayList<WeakReference<bicg>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private short jdField_a_of_type_Short;
  private long jdField_b_of_type_Long = -1L;
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlCmdUtil";
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_a_of_type_JavaUtilHashSet.add("13169");
    jdField_a_of_type_JavaUtilHashSet.add("13032");
    jdField_a_of_type_JavaUtilHashSet.add("12820");
  }
  
  public static bich a()
  {
    if (jdField_a_of_type_Bich == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bich == null) {
        jdField_a_of_type_Bich = new bich();
      }
      return jdField_a_of_type_Bich;
    }
  }
  
  public static File a()
  {
    return new File(b(), "conf.json");
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    if ((TextUtils.isEmpty(c)) && (paramAppInterface != null))
    {
      paramAppInterface = paramAppInterface.getApp();
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.getResources().getDisplayMetrics();
        c = paramAppInterface.widthPixels + "*" + paramAppInterface.heightPixels;
      }
    }
    return c;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[reportGamePubAccountMsgList] status:" + paramInt + ",msg:" + paramString1 + ",url:" + paramString2);
    }
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.2.8");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localObject = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject).type.set(1);
    MonitReport.PublicAccountReq localPublicAccountReq = new MonitReport.PublicAccountReq();
    localPublicAccountReq.action.set(paramInt);
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = Long.valueOf(0L);; paramString1 = Long.valueOf(Long.parseLong(paramString1)))
    {
      localPublicAccountReq.msgid.set(paramString1.longValue());
      localPublicAccountReq.url.set(paramString2);
      localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
      ((MonitReport.MonitReportReq)localObject).public_acct_req.add(localPublicAccountReq);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject).toByteArray()));
      paramString1 = new NewIntent(BaseApplicationImpl.getApplication(), bicf.class);
      paramString1.putExtra("cmd", "gc_monitor_report.report_public_acct_info");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if (paramString2 != null) {
        break;
      }
      return;
    }
    paramString2.startServlet(paramString1);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestConfig currVersion=" + paramLong);
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("op_version", paramLong);
      localJSONObject1.put("req", localJSONObject2);
      a("13136", localJSONObject1, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listeners size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      bicg localbicg = (bicg)((WeakReference)localObject).get();
      if (localbicg != null)
      {
        localObject = localbicg.getFilterCmds();
        if ((localObject == null) || (((HashSet)localObject).contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listener=" + localbicg);
          }
          localbicg.onCmdRsp(paramIntent, paramString, paramLong, paramJSONObject);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
      }
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeConfig...newVersion=" + paramLong + ",content=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new WadlCmdUtil.1(this, paramString, paramLong));
  }
  
  public static File b()
  {
    File localFile = new File(BaseApplicationImpl.getContext().getFilesDir(), "gc_conf");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public long a()
  {
    long l2 = 0L;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    long l1;
    if (localObject != null) {
      l1 = ((AppRuntime)localObject).getLongAccountUin();
    }
    do
    {
      do
      {
        do
        {
          return l1;
          bica.a().a();
          localObject = new Bundle();
          localObject = QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.getUin", (Bundle)localObject);
          l1 = l2;
        } while (localObject == null);
        l1 = l2;
      } while (!((EIPCResult)localObject).isSuccess());
      l1 = l2;
    } while (((EIPCResult)localObject).data == null);
    return ((EIPCResult)localObject).data.getLong("uin");
  }
  
  public String a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      return ((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(((QQAppInterface)localObject).getCurrentAccountUin());
    }
    bica.a().a();
    localObject = new Bundle();
    localObject = QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.getSkey", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()) && (((EIPCResult)localObject).data != null)) {
      return ((EIPCResult)localObject).data.getString("skey");
    }
    return "";
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_b_of_type_Long + 604800000L < l) || (this.jdField_b_of_type_Long > l))
    {
      this.jdField_b_of_type_Long = l;
      Object localObject = bdiw.a(BaseApplicationImpl.getApplication());
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        try
        {
          localJSONObject1 = new JSONObject();
          localJSONArray = new JSONArray();
          l = NetConnInfoCenter.getServerTime();
          i = 0;
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject1;
          JSONArray localJSONArray;
          int i;
          PackageInfo localPackageInfo;
          JSONObject localJSONObject2;
          JSONObject localJSONObject3;
          while (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "reportPkgInfoToDC: " + QLog.getStackTraceString(localException));
            return;
            i += 1;
          }
        }
        if (i < ((List)localObject).size())
        {
          localPackageInfo = (PackageInfo)((List)localObject).get(i);
          if ((localPackageInfo.applicationInfo.flags & 0x1) <= 0)
          {
            localJSONObject2 = new JSONObject();
            localJSONObject3 = new JSONObject();
            localJSONObject3.put("itimestamp", String.valueOf(l));
            localJSONObject3.put("sq_ver", "8.2.8");
            localJSONObject3.put("ext33", localPackageInfo.packageName);
            localJSONObject3.put("ext34", localPackageInfo.versionName);
            localJSONObject3.put("ext35", String.valueOf(localPackageInfo.versionCode));
            localJSONObject3.put("oper_id", "777777");
            localJSONObject3.put("ext4", "777777");
            localJSONObject2.put("data", localJSONObject3);
            localJSONObject2.put("dc_id", "dc00087");
            localJSONArray.put(localJSONObject2);
          }
        }
        else
        {
          localJSONObject1.put("report_list", localJSONArray);
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if (localObject != null)
          {
            a((AppRuntime)localObject, "dc05076", localJSONObject1.toString());
            return;
          }
          axpw.a(null, "dc05076", localJSONObject1.toString());
          return;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestRedPoint scene_id=" + paramInt);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("scene_id", paramInt);
      localJSONObject2.put("uin", a());
      localJSONObject2.put("tt", 1);
      localJSONObject1.put("req", localJSONObject2);
      a("13325", localJSONObject1, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "requestRedPoint exception=", localException);
    }
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramIntent == null) {}
    long l2;
    do
    {
      return;
      localObject3 = null;
      l2 = -1L;
      localObject1 = paramIntent.getStringExtra("webssoCmdId");
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = localObject3;
      l1 = l2;
      if (paramBoolean)
      {
        localObject1 = localObject3;
        l1 = l2;
        if (paramArrayOfByte != null) {
          l1 = l2;
        }
      }
      try
      {
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
        l1 = l2;
        localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
        l1 = l2;
        l2 = localUniSsoServerRsp.ret.get();
        localObject1 = localObject3;
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = l2;
          paramArrayOfByte = new JSONObject(localUniSsoServerRsp.rspdata.get());
          localObject1 = localObject3;
          l1 = l2;
          if (paramArrayOfByte != null)
          {
            l1 = l2;
            paramArrayOfByte = paramArrayOfByte.optJSONObject((String)localObject2);
            localObject1 = localObject3;
            l1 = l2;
            if (paramArrayOfByte != null)
            {
              l1 = l2;
              paramArrayOfByte = paramArrayOfByte.optJSONObject("data");
              localObject1 = localObject3;
              l1 = l2;
              if (paramArrayOfByte != null)
              {
                l1 = l2;
                localObject1 = paramArrayOfByte.optJSONObject("rsp");
                l1 = l2;
              }
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "onRespWebSso err:" + paramArrayOfByte.getMessage());
          localObject1 = localObject3;
          continue;
          this.jdField_a_of_type_Short = ((short)(this.jdField_a_of_type_Short + 1));
          continue;
          if (("12829".equals(localObject2)) && (l1 == 0L) && (localObject1 != null))
          {
            GameNoticeInfo.saveTipInfo(paramIntent.getExtras().getString("appId"), (JSONObject)localObject1);
            continue;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRespWebSso webssoCmd=" + (String)localObject2 + ",isSucc=" + paramBoolean + ",ret=" + l1 + ",rspJson=" + localObject1);
      }
    } while (("12934".equals(localObject2)) || ("13325".equals(localObject2)));
    if ("13136".equals(localObject2)) {
      if ((paramBoolean) && (localObject1 != null))
      {
        this.jdField_a_of_type_Short = 0;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        l2 = ((JSONObject)localObject1).optLong("version", -1L);
        if (l2 > -1L) {
          a(((JSONObject)localObject1).optString("content"), l2);
        }
        if (localObject1 != null) {
          break label482;
        }
        paramArrayOfByte = new JSONObject();
        a(paramIntent, (String)localObject2, l1, paramArrayOfByte);
        return;
      }
    }
  }
  
  public void a(bicg parambicg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "addListener listener=" + parambicg);
    }
    if (parambicg == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      bicg localbicg = (bicg)((WeakReference)localIterator.next()).get();
      if ((localbicg != null) && (localbicg == parambicg)) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "addListener listener=" + parambicg + " succ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(parambicg));
  }
  
  public void a(WadlParams paramWadlParams, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkGameDownload wadlParams=" + paramWadlParams);
    }
    if (paramWadlParams == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("ad_tag", paramWadlParams.o);
      localJSONObject2.put("appid", paramWadlParams.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("channel_id", paramWadlParams.jdField_d_of_type_JavaLangString);
      localJSONObject2.put("download_url", paramWadlParams.jdField_b_of_type_JavaLangString);
      localJSONObject2.put("source_url", paramWadlParams.n);
      localJSONObject2.put("refer", paramWadlParams.p);
      localJSONObject2.put("version_code", String.valueOf(paramWadlParams.f));
      localJSONObject1.put("req", localJSONObject2);
      a("12829", localJSONObject1, paramBundle);
      return;
    }
    catch (Exception paramWadlParams)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "checkGameDownload exception=", paramWadlParams);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getFloadWindowInfo appid=" + paramString);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString);
      localJSONObject2.put("tt", 1);
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
      {
        localJSONObject2.put("uin", localObject);
        localJSONObject2.put("skey", a());
        localJSONObject1.put("req", localJSONObject2);
        localObject = new Bundle();
        ((Bundle)localObject).putString("appid", paramString);
        a("13126", localJSONObject1, (Bundle)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getFloadWindowInfo exception=", paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setPreloadStatus appId=" + paramString + ",status=" + paramInt);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("appid", paramString);
      ((JSONObject)localObject).put("platform", 1);
      ((JSONObject)localObject).put("channel", 1);
      ((JSONObject)localObject).put("op", paramInt);
      localJSONObject.put("req", localObject);
      localJSONObject.put("subscribe_type", 1);
      localObject = new Bundle();
      ((Bundle)localObject).putString("appid", paramString);
      a("13032", localJSONObject, (Bundle)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "setPreloadStatus exception=", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "preloadGame appId=" + paramString1 + ",channelId=" + paramString2);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString1);
      localJSONObject2.put("platform", 1);
      localJSONObject2.put("need_ark", 1);
      localJSONObject2.put("channel_id", paramString2);
      localJSONObject2.put("skey", a());
      localJSONObject1.put("req", localJSONObject2);
      localJSONObject1.put("subscribe_type", 1);
      paramString2 = new Bundle();
      paramString2.putString("appid", paramString1);
      a("12820", localJSONObject1, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "preloadGame exception=", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, bdou parambdou)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "reportDC05076 appRuntime=" + localAppRuntime + ",oper_id=" + paramString1 + ",operType=" + paramString2 + ",reportInfo=" + parambdou);
    }
    if (parambdou == null) {
      return;
    }
    for (;;)
    {
      WadlParams localWadlParams;
      JSONObject localJSONObject1;
      try
      {
        localWadlParams = parambdou.jdField_a_of_type_CooperationWadlIpcWadlParams;
        if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
          jdField_b_of_type_JavaLangString = String.valueOf(bbct.e());
        }
        String str = parambdou.a();
        localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("itimestamp", String.valueOf(NetConnInfoCenter.getServerTime()));
        localJSONObject3.put("domain", "1");
        localJSONObject3.put("sq_ver", "8.2.8");
        localJSONObject3.put("gamecenter_ver", "");
        localJSONObject3.put("gamecenter_ver_type", "2");
        localJSONObject3.put("device_type", Build.BRAND);
        localJSONObject3.put("apk_volume", String.valueOf(parambdou.jdField_a_of_type_Long));
        int j = nam.a();
        if (j < 0) {
          break label810;
        }
        i = j;
        if (j >= ajsf.c.length) {
          break label810;
        }
        localJSONObject3.put("net_type", ajsf.c[i]);
        localJSONObject3.put("resolution", a(null));
        localJSONObject3.put("is_red_point", "0");
        localJSONObject3.put("is_new_status", "0");
        localJSONObject3.put("gamecenter_src", "1");
        localJSONObject3.put("oper_moudle", "558");
        localJSONObject3.put("oper_id", paramString1);
        localJSONObject3.put("ret_id", String.valueOf(parambdou.jdField_a_of_type_Int));
        if (localWadlParams != null)
        {
          paramString1 = localWadlParams.jdField_a_of_type_JavaLangString;
          localJSONObject3.put("gameappid", paramString1);
          localJSONObject3.put("ext1", "55801");
          localJSONObject3.put("ext3", "1");
          localJSONObject3.put("ext4", paramString2);
          localJSONObject3.put("ext11", "4");
          localJSONObject3.put("ext12", "430");
          localJSONObject3.put("ext14", Build.MODEL);
          localJSONObject3.put("ext15", Build.VERSION.RELEASE);
          localJSONObject3.put("ext16", jdField_b_of_type_JavaLangString);
          localJSONObject3.put("ext32", parambdou.jdField_d_of_type_JavaLangString);
          localJSONObject3.put("ext36", parambdou.b());
          localJSONObject3.put("ext37", bdou.jdField_a_of_type_JavaLangString);
          if (localWadlParams != null)
          {
            localJSONObject3.put("ext2", String.valueOf(localWadlParams.jdField_d_of_type_Int));
            localJSONObject3.put("ext18", localWadlParams.m);
            if (TextUtils.isEmpty(parambdou.c)) {
              break label788;
            }
            paramString1 = parambdou.c;
            localJSONObject3.put("ext33", paramString1);
            localJSONObject3.put("ext34", localWadlParams.jdField_b_of_type_JavaLangString);
            localJSONObject3.put("ext35", localWadlParams.jdField_d_of_type_JavaLangString);
            localJSONObject3.put("ext38", String.valueOf(localWadlParams.c));
            localJSONObject3.put("ext39", localWadlParams.o);
            localJSONObject3.put("ext40", localWadlParams.p);
          }
          if (!TextUtils.isEmpty(str)) {
            localJSONObject3.put("ext45", str);
          }
          if (!TextUtils.isEmpty(parambdou.g)) {
            localJSONObject3.put("ext42", parambdou.g);
          }
          if (!TextUtils.isEmpty(parambdou.h)) {
            localJSONObject3.put("ext43", parambdou.h);
          }
          localJSONObject2.put("data", localJSONObject3);
          localJSONObject2.put("dc_id", "dc05076");
          localJSONArray.put(localJSONObject2);
          localJSONObject1.put("report_list", localJSONArray);
          if (localAppRuntime == null) {
            break label797;
          }
          a(localAppRuntime, "dc05076", localJSONObject1.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      paramString1 = "";
      continue;
      label788:
      paramString1 = localWadlParams.j;
      continue;
      label797:
      axpw.a(null, "dc05076", localJSONObject1.toString());
      return;
      label810:
      int i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, bdou parambdou, String paramString3)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "reportDC appRuntime=" + localAppRuntime + ",dcId=" + paramString3 + ",oper_id=" + paramString1 + ",operType=" + paramString2 + ",reportInfo=" + parambdou);
    }
    if (parambdou == null) {
      return;
    }
    for (;;)
    {
      WadlParams localWadlParams;
      JSONObject localJSONObject1;
      try
      {
        localWadlParams = parambdou.jdField_a_of_type_CooperationWadlIpcWadlParams;
        if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
          jdField_b_of_type_JavaLangString = String.valueOf(bbct.e());
        }
        String str = parambdou.a();
        localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("itimestamp", String.valueOf(NetConnInfoCenter.getServerTime()));
        localJSONObject3.put("domain", "1");
        localJSONObject3.put("sq_ver", "8.2.8");
        localJSONObject3.put("gamecenter_ver", "");
        localJSONObject3.put("gamecenter_ver_type", "2");
        localJSONObject3.put("device_type", Build.BRAND);
        localJSONObject3.put("apk_volume", String.valueOf(parambdou.jdField_a_of_type_Long));
        int j = nam.a();
        if (j < 0) {
          break label833;
        }
        i = j;
        if (j >= ajsf.c.length) {
          break label833;
        }
        localJSONObject3.put("net_type", ajsf.c[i]);
        localJSONObject3.put("resolution", a(null));
        localJSONObject3.put("is_red_point", "0");
        localJSONObject3.put("is_new_status", "0");
        localJSONObject3.put("gamecenter_src", "1");
        localJSONObject3.put("oper_moudle", "558");
        localJSONObject3.put("oper_id", paramString1);
        localJSONObject3.put("ret_id", String.valueOf(parambdou.jdField_a_of_type_Int));
        if (localWadlParams != null)
        {
          paramString1 = localWadlParams.jdField_a_of_type_JavaLangString;
          localJSONObject3.put("gameappid", paramString1);
          localJSONObject3.put("ext1", "55801");
          localJSONObject3.put("ext3", "1");
          localJSONObject3.put("ext4", paramString2);
          localJSONObject3.put("ext11", "4");
          localJSONObject3.put("ext12", "430");
          localJSONObject3.put("ext14", Build.MODEL);
          localJSONObject3.put("ext15", Build.VERSION.RELEASE);
          localJSONObject3.put("ext16", jdField_b_of_type_JavaLangString);
          localJSONObject3.put("ext31", parambdou.jdField_b_of_type_JavaLangString);
          localJSONObject3.put("ext32", parambdou.jdField_d_of_type_JavaLangString);
          localJSONObject3.put("ext36", parambdou.b());
          localJSONObject3.put("ext37", bdou.jdField_a_of_type_JavaLangString);
          if (localWadlParams != null)
          {
            localJSONObject3.put("ext2", String.valueOf(localWadlParams.jdField_d_of_type_Int));
            localJSONObject3.put("ext18", localWadlParams.m);
            if (TextUtils.isEmpty(parambdou.c)) {
              break label811;
            }
            paramString1 = parambdou.c;
            localJSONObject3.put("ext33", paramString1);
            localJSONObject3.put("ext34", localWadlParams.jdField_b_of_type_JavaLangString);
            localJSONObject3.put("ext35", localWadlParams.jdField_d_of_type_JavaLangString);
            localJSONObject3.put("ext38", String.valueOf(localWadlParams.c));
            localJSONObject3.put("ext39", localWadlParams.o);
            localJSONObject3.put("ext40", localWadlParams.p);
          }
          if (!TextUtils.isEmpty(str)) {
            localJSONObject3.put("ext45", str);
          }
          if (!TextUtils.isEmpty(parambdou.g)) {
            localJSONObject3.put("ext42", parambdou.g);
          }
          if (!TextUtils.isEmpty(parambdou.h)) {
            localJSONObject3.put("ext43", parambdou.h);
          }
          localJSONObject2.put("data", localJSONObject3);
          localJSONObject2.put("dc_id", paramString3);
          localJSONArray.put(localJSONObject2);
          localJSONObject1.put("report_list", localJSONArray);
          if (localAppRuntime == null) {
            break label820;
          }
          a(localAppRuntime, "dc05076", localJSONObject1.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      paramString1 = "";
      continue;
      label811:
      paramString1 = localWadlParams.j;
      continue;
      label820:
      axpw.a(null, "dc05076", localJSONObject1.toString());
      return;
      label833:
      int i = 0;
    }
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject;
    if (paramArrayList != null)
    {
      localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put((String)((Iterator)localObject).next());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getApkDownloadInfo channelId=" + paramString + ",appIds=" + localJSONArray);
    }
    try
    {
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", paramString);
      localJSONObject.put("v_appid", localJSONArray);
      ((JSONObject)localObject).put("req", localJSONObject);
      paramString = new Bundle();
      paramString.putStringArrayList("appids", paramArrayList);
      a("13169", (JSONObject)localObject, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getApkDownloadInfo exception=", paramString);
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "requestWebSso webssoCmd=" + paramString + ",reqData=" + paramJSONObject);
    }
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {}
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.2.8.4440");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put(paramString, paramJSONObject);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), bicf.class);
      paramJSONObject = paramBundle;
      if (paramBundle == null) {
        paramJSONObject = new Bundle();
      }
      paramJSONObject.putString("webssoCmdId", paramString);
      paramJSONObject.putByteArray("webssoReq", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtras(paramJSONObject);
      localAppRuntime.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "requestWebSso exception=", paramString);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramAppRuntime == null) {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "reportDC05076 fail,appRuntime is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reportDC05076 reportData=" + paramString2);
      }
    } while (TextUtils.isEmpty(paramString2));
    try
    {
      paramAppRuntime = new JSONObject(paramString2);
      paramString1 = new JSONObject();
      paramString1.put("req", paramAppRuntime);
      a("12934", paramString1, null);
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reportDownloadStart...");
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      if (paramJSONArray1 != null) {
        localJSONObject2.put("appid_list", paramJSONArray1);
      }
      if (paramJSONArray2 != null) {
        localJSONObject2.put("res_list", paramJSONArray2);
      }
      localJSONObject1.put("req", localJSONObject2);
      a("12952", localJSONObject1, null);
      return;
    }
    catch (Exception paramJSONArray1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "reportDownloadStart exception=", paramJSONArray1);
    }
  }
  
  public void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAutoDownloadRes...");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.2.8.4440");
      new WebSSOAgent.UniSsoServerReq().comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tgpa_games", paramJSONObject1);
      localJSONObject.put("pkg_to_appids", paramJSONObject2);
      ((JSONObject)localObject).put("req", localJSONObject);
      a("12942", (JSONObject)localObject, null);
      return;
    }
    catch (Exception paramJSONObject1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getAutoDownloadRes exception=", paramJSONObject1);
    }
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    long l = yod.a("LAST_GET_CONF_VERSION");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkConfigUpdate bForce=" + paramBoolean + ",newVersion=" + paramLong + ",currVersion=" + l);
    }
    if ((paramLong > -1L) && (paramLong == l) && (a().exists())) {}
    do
    {
      return false;
      if (paramBoolean)
      {
        a(l);
        return true;
      }
      if (this.jdField_a_of_type_Short >= 3)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Short = 0;
        return true;
      }
      if (this.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_Long = yod.a("LAST_GET_CONF_TIME");
      }
      paramLong = System.currentTimeMillis();
    } while ((this.jdField_a_of_type_Long + 86400000L >= paramLong) && (this.jdField_a_of_type_Long <= paramLong));
    a(l);
    return true;
  }
  
  public void b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAutoDownloadApk...");
    }
    for (;;)
    {
      boolean bool2;
      boolean bool1;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        JSONObject localJSONObject4 = new JSONObject();
        localJSONObject4.put("left", ynz.jdField_a_of_type_Int);
        localJSONObject4.put("status", 1);
        localJSONObject3.put("battery", localJSONObject4);
        localJSONObject4 = new JSONObject();
        bool2 = bbev.h(BaseApplicationImpl.getContext());
        if (bbwc.a() == 1)
        {
          bool1 = true;
          break label287;
          localJSONObject4.put("type", i);
          localJSONObject3.put("netinfo", localJSONObject4);
          localJSONObject4 = new JSONObject();
          localJSONObject4.put("status", bbab.a(BaseApplicationImpl.getContext()));
          localJSONObject3.put("screen", localJSONObject4);
          localJSONObject4 = new JSONObject();
          long[] arrayOfLong = bbct.b();
          localJSONObject4.put("total", arrayOfLong[0]);
          localJSONObject4.put("left", arrayOfLong[1]);
          localJSONObject3.put("storage", localJSONObject4);
          localJSONObject2.put("context_info", localJSONObject3);
          localJSONObject2.put("qq_version", AppSetting.f());
          localJSONObject1.put("req", localJSONObject2);
          a("12933", localJSONObject1, null);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getAutoDownloadApk exception=", localException);
        return;
      }
      label287:
      if ((bool1 | bool2)) {
        i = 1;
      }
    }
  }
  
  public void b(bicg parambicg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "removeListener listener=" + parambicg);
    }
    if (parambicg == null) {
      return;
    }
    boolean bool;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      } while (!localIterator.hasNext());
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      bicg localbicg = (bicg)localWeakReference.get();
      if ((localbicg == null) || (localbicg != parambicg)) {
        break;
      }
      bool = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 1, "removeListener listener=" + parambicg + " " + bool);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroy listeners size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bich
 * JD-Core Version:    0.7.0.1
 */