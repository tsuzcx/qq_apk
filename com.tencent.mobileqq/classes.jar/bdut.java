import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.VasMonitorHandler.1;
import com.tencent.mobileqq.vas.VasMonitorHandler.2;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.vasreporter.VasReporter.ReqBody;
import com.tencent.pb.vasreporter.VasReporter.StatisInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class bdut
  extends alpd
{
  public CopyOnWriteArrayList<String> a;
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  public bdut(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static <T> ArrayList<T> a(T... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList<String> paramArrayList, ArrayList<Float> paramArrayList1, String paramString2)
  {
    try
    {
      paramString2 = "uip:" + abuk.k() + ", " + paramString2;
      if (QLog.isColorLevel()) {
        QLog.e("VasMonitorHandler", 2, "reportOrg appid=" + paramString1 + ", keys=" + paramArrayList + ", values=" + paramArrayList1 + ", log=" + paramString2);
      }
      if (paramQQAppInterface == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("VasMonitorHandler", 2, "report args0 Error appInterface=null, appid=" + paramString1 + ", keys=" + paramArrayList + ", values=" + paramArrayList1 + ", log=" + paramString2);
        return;
      }
      if ((TextUtils.isEmpty(paramString1)) || (paramArrayList == null) || (paramArrayList1 == null))
      {
        QLog.e("VasMonitorHandler", 2, "report args Error appid=" + paramString1 + ", keys=" + paramArrayList + ", values=" + paramArrayList1 + ", log=" + paramString2);
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("VasMonitorHandler", 2, "reportOrg err:" + paramQQAppInterface.toString());
      return;
    }
    VasReporter.StatisInfo localStatisInfo = new VasReporter.StatisInfo();
    localStatisInfo.appid.set(paramString1);
    localStatisInfo.key_list.set(paramArrayList);
    localStatisInfo.value_list.set(paramArrayList1);
    localStatisInfo.ts.set(System.currentTimeMillis() / 1000L);
    localStatisInfo.msg.set(paramString2);
    paramArrayList = new VasReporter.ReqBody();
    paramArrayList.cmd.set(1);
    paramArrayList.plat.set(109);
    paramArrayList.qqversion.set("8.3.5.4555");
    paramArrayList.osversion.set(Build.VERSION.RELEASE);
    paramArrayList.statis_list.set(a(new VasReporter.StatisInfo[] { localStatisInfo }));
    paramArrayList.setHasFlag(true);
    paramArrayList1 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "gxhreport.report");
    paramArrayList1.putWupBuffer(paramArrayList.toByteArray());
    ((bdut)paramQQAppInterface.a(103)).sendPbReq(paramArrayList1);
    if (QLog.isColorLevel()) {
      QLog.e("VasMonitorHandler", 2, "send reportOrg appid=" + paramString1 + ", log=" + paramString2);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat)
  {
    a(paramAppRuntime, paramString1, paramString2, paramString3, paramString4, null, null, paramFloat, 0.0F);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, float paramFloat1, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      label24:
      if ((paramAppRuntime != null) || (BaseApplicationImpl.getApplication() == null) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))) {
        break label588;
      }
      paramAppRuntime = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    label588:
    for (;;)
    {
      if (paramAppRuntime == null)
      {
        paramAppRuntime = new Bundle();
        paramAppRuntime.putString("key_appid", paramString1);
        paramAppRuntime.putString("key_err_code", paramString2);
        paramAppRuntime.putString("key_log", paramString3);
        paramAppRuntime.putString("key_key4", paramString4);
        paramAppRuntime.putString("key_key5", paramString5);
        paramAppRuntime.putString("key_key6", paramString6);
        paramAppRuntime.putFloat("key_value2", paramFloat1);
        paramAppRuntime.putFloat("key_value3", paramFloat2);
        QIPCClientHelper.getInstance().getClient().callServer("VasMonitorIPCModule", "action_vas_monitor", paramAppRuntime);
        return;
        paramAppRuntime = null;
        break label24;
      }
      Object localObject = (bdut)paramAppRuntime.a(103);
      if (!((bdut)localObject).b.get()) {
        ((bdut)localObject).a(paramAppRuntime, false);
      }
      if (((bdut)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VasMonitorHandler", 2, "report stop all report appid=" + paramString1 + ", errCode=" + paramString2 + ", log=" + paramString3 + ", key4=" + paramString4 + ", value2=" + paramFloat1);
        return;
      }
      if (((bdut)localObject).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString1))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VasMonitorHandler", 2, "report appid in appidBlackList appid=" + paramString1 + ", errCode=" + paramString2 + ", log=" + paramString3 + ", key4=" + paramString4 + ", value2=" + paramFloat1);
        return;
      }
      VasWebviewUtil.reportCommercialDrainage(paramAppRuntime.getCurrentAccountUin(), "MIGReport", paramString1, "", 1, 0, 0, paramString2, paramString3, paramString4, paramString5, paramString6, String.valueOf(paramFloat1), String.valueOf(paramFloat2), 0, 0, 0, 0);
      localObject = paramString4;
      if (paramString4 == null) {
        localObject = "";
      }
      paramString4 = paramString5;
      if (paramString5 == null) {
        paramString4 = "";
      }
      paramString5 = paramString6;
      if (paramString6 == null) {
        paramString5 = "";
      }
      ThreadManager.post(new VasMonitorHandler.1(paramAppRuntime, paramString1, a(new String[] { "109", "8.3.5", paramString2, localObject, paramString4, paramString5 }), a(new Float[] { Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }), paramString3), 5, null, false);
      QLog.e("VasMonitorHandler", 1, "report err appid=" + paramString1 + ", errCode=" + paramString2 + ", log=" + paramString3 + ", key4=" + (String)localObject + ", value2=" + paramFloat1);
      return;
    }
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    this.b.set(true);
    ThreadManager.post(new VasMonitorHandler.2(this, paramAppRuntime, paramBoolean), 8, null, true);
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"gxhreport.report".equals(paramFromServiceMsg.getServiceCmd())) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("VasMonitorHandler", 2, "onReceive res.isSuccess=" + paramFromServiceMsg.isSuccess() + ",data=" + bdqa.a((byte[])paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdut
 * JD-Core Version:    0.7.0.1
 */