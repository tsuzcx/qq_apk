import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.KandianConfigServlet.1;
import com.tencent.mobileqq.config.splashlogo.KandianConfigServlet.2;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class arpl
  extends MSFServlet
{
  private static Class<?> jdField_a_of_type_JavaLangClass;
  private static boolean jdField_a_of_type_Boolean;
  private static long b;
  private static long c;
  private static long d;
  private static long e;
  private long jdField_a_of_type_Long;
  
  private void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    e = l - paramLong;
    Object localObject;
    if (jdField_a_of_type_JavaLangClass != null)
    {
      localObject = paramQQAppInterface.getHandler(jdField_a_of_type_JavaLangClass);
      if ((localObject == null) || (e > 800L)) {
        break label194;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 20140326;
      ((MqqHandler)localObject).sendMessage(localMessage);
      QLog.d("KandianConfigServlet", 1, "send msg notify login activity!");
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangClass = null;
      QLog.d("KandianConfigServlet", 1, paramQQAppInterface.getAccount() + " notifyLoginNext, all cost:" + e + "  nowTime:" + l + "  startTime:" + paramLong);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("totalCost", String.valueOf(e));
        bmhv.a((JSONObject)localObject);
        olh.a(null, paramQQAppInterface.getAccount(), "0X800965D", "0X800965D", 0, 0, String.valueOf(b), String.valueOf(c), String.valueOf(d), ((JSONObject)localObject).toString(), false);
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        label194:
        QLog.d("KandianConfigServlet", 2, "only kandian tab switch, report error:" + paramQQAppInterface.toString());
      }
      QLog.d("KandianConfigServlet", 1, "give up send login next msg!");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, Packet paramPacket)
  {
    ConfigurationService.ReqGetConfig localReqGetConfig = new ConfigurationService.ReqGetConfig();
    int j = paramArrayOfInt.length;
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    if (i < j)
    {
      ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
      int k = paramArrayOfInt[i];
      localConfigSeq.type.set(k);
      switch (k)
      {
      }
      for (;;)
      {
        localArrayList.add(localConfigSeq);
        i += 1;
        break;
        String str = paramQQAppInterface.getCurrentAccountUin();
        k = bhhr.N(paramQQAppInterface.getApp(), str);
        localConfigSeq.version.set(k);
        if (paramIntent.getBooleanExtra("configkandiantab", false))
        {
          paramPacket.addAttribute("_attr_disable_merge", Boolean.valueOf(true));
          QLog.e("KandianConfigServlet", 1, "addAllConfigs version : " + k + "  mCurrentUin : " + str);
          a("1");
        }
      }
    }
    localReqGetConfig.setHasFlag(true);
    localReqGetConfig.seq_list.addAll(localArrayList);
    if (paramIntent != null)
    {
      boolean bool = paramIntent.getBooleanExtra("key_is_page_req", false);
      paramQQAppInterface = localReqGetConfig.is_page_req;
      if (!bool) {
        break label293;
      }
    }
    label293:
    for (i = 1;; i = 0)
    {
      paramQQAppInterface.set(i);
      paramQQAppInterface = paramIntent.getByteArrayExtra("key_cookies");
      if (paramQQAppInterface != null) {
        localReqGetConfig.cookies.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramQQAppInterface = a(localReqGetConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
        paramPacket.putSendData(paramQQAppInterface);
      }
      paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    long l = System.currentTimeMillis();
    paramQQAppInterface = (Boolean)bmhv.a("local_kd_tab_has_set");
    boolean bool = TextUtils.equals("1", paramString);
    int i;
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.booleanValue())) {
      if (bmhv.a(bool))
      {
        if (System.currentTimeMillis() - paramLong > 800L) {
          break label118;
        }
        if (!bool) {
          break label112;
        }
        i = 1;
        bmhv.d(i);
      }
    }
    for (;;)
    {
      paramLong = System.currentTimeMillis();
      QLog.d("KandianConfigServlet", 1, "updateKandianTabConfigSwitch, tabSwitch = " + bool + "write sp cost:" + (paramLong - l));
      return;
      label112:
      i = 0;
      break;
      label118:
      if ((!pkh.a()) && (!pkh.b()))
      {
        QLog.d("KandianConfigServlet", 1, "receive kandian tab config is delay, but not in kandian , update now !");
        bmhv.c();
        pvm.a().a(0, null);
        continue;
        QLog.d("KandianConfigServlet", 1, "updateKandianTabConfigSwitch user has set switch, give up !");
      }
    }
  }
  
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = 0;
    if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0) || (paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0))
    {
      if (!paramBoolean) {
        i = 1;
      }
      for (;;)
      {
        QLog.d("KandianConfigServlet", 1, "receiveAllConfig fail, errorType : " + i);
        if ((paramIntent.getBooleanExtra("configkandiantab", false)) && (paramIntent.getBooleanExtra("needNotifyNext", false))) {
          a(paramIntent.getLongExtra("startTime", 0L), paramQQAppInterface);
        }
        a("0X8009680", "1", String.valueOf(i));
        return;
        if (paramRespGetConfig.result.get() != 0)
        {
          i = 2;
        }
        else
        {
          if ((paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0)) {
            break;
          }
          i = 3;
        }
      }
    }
    long l1 = System.currentTimeMillis();
    int j = paramRespGetConfig.config_list.size();
    label171:
    if (i < j)
    {
      paramArrayOfInt = (ConfigurationService.Config)paramRespGetConfig.config_list.get(i);
      if (paramArrayOfInt != null) {}
    }
    for (;;)
    {
      i += 1;
      break label171;
      if (paramArrayOfInt.type.has())
      {
        Integer localInteger = Integer.valueOf(paramArrayOfInt.type.get());
        QLog.d("KandianConfigServlet", 1, "receiveAllConfigs|receive type: " + localInteger + ", length: " + j);
        try
        {
          switch (localInteger.intValue())
          {
          case 92: 
            l2 = paramIntent.getLongExtra("startTime", 0L);
            if (!paramIntent.getBooleanExtra("configkandiantab", false)) {
              continue;
            }
            a(paramArrayOfInt, l2);
            if (!paramIntent.getBooleanExtra("needNotifyNext", false)) {
              continue;
            }
            a(l2, paramQQAppInterface);
          }
        }
        catch (Exception paramArrayOfInt)
        {
          QLog.d("KandianConfigServlet", 1, "receiveAllConfig..parse error:" + paramArrayOfInt.getMessage());
        }
        continue;
        long l2 = System.currentTimeMillis();
        QLog.d("KandianConfigServlet", 1, "receiveAllConfigs|executeSpendTime: " + (l2 - l1));
        return;
        i = 0;
        break;
      }
    }
  }
  
  public static void a(String paramString)
  {
    a("0X800967F", paramString, null);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.executeOnSubThread(new KandianConfigServlet.2(paramString1, paramString2, paramString3));
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    int i;
    if (paramArrayOfInt != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i] == 92) {
          a("0X8009680", paramString, String.valueOf(paramInt));
        }
      }
      else
      {
        QLog.d("KandianConfigServlet", 1, "reportKDConfigNetFailed isOnly92:" + paramString + "  cmds:" + paramArrayOfInt + "   resultCode:" + paramInt);
        return;
      }
      i += 1;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, Class<?> paramClass, long paramLong)
  {
    QLog.d("KandianConfigServlet", 1, "getKandianTabConfig,need notify");
    return a(paramAppRuntime, paramClass, paramLong, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime, Class<?> paramClass, long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramAppRuntime != null)
    {
      bool1 = bool2;
      if ((paramAppRuntime instanceof AppInterface))
      {
        paramAppRuntime = (AppInterface)paramAppRuntime;
        BaseApplication localBaseApplication = paramAppRuntime.getApp();
        String str = paramAppRuntime.getAccount();
        bool1 = bool2;
        if (localBaseApplication != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(str))
          {
            i = bhhr.N(localBaseApplication, str);
            if (i != 0) {
              break label251;
            }
            jdField_a_of_type_JavaLangClass = paramClass;
            paramClass = new NewIntent(localBaseApplication, arpl.class);
            paramClass.putExtra("k_cmd_type", new int[] { 92 });
            paramClass.putExtra("configkandiantab", true);
            paramClass.putExtra("startTime", paramLong);
            paramClass.putExtra("needNotifyNext", paramBoolean);
            if (!StringUtil.isEmpty(str)) {
              paramClass.putExtra("key_uin", str);
            }
            b = System.currentTimeMillis() - paramLong;
            QLog.d("KandianConfigServlet", 1, "getKandianTabConfig, currentUin : " + str + "  cost time：" + b);
            paramAppRuntime.startServlet(paramClass);
          }
        }
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      QLog.d("KandianConfigServlet", 1, pkh.a() + " getKandianTabConfig executed:" + bool1 + "  startTime:" + paramLong);
      return bool1;
      label251:
      QLog.d("KandianConfigServlet", 1, "getKandianTabConfig local config exist, version : " + i);
    }
  }
  
  private static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    byte[] arrayOfByte = new byte[(int)l + 4];
    PkgTools.DWord2Byte(arrayOfByte, 0, 4L + l);
    PkgTools.copyData(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    PkgTools.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  public void a(ConfigurationService.Config paramConfig, long paramLong)
  {
    long l = System.currentTimeMillis();
    try
    {
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      if ((!paramConfig.content_list.has()) || (paramConfig.content_list.size() <= 0)) {
        break label328;
      }
      k = 0;
      i = 0;
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        QQAppInterface localQQAppInterface;
        int k;
        int j;
        QLog.e("KandianConfigServlet", 1, "handleReadTabConfig has exception : " + paramConfig);
        continue;
        int i = j;
        continue;
        k += 1;
      }
    }
    j = paramConfig.content_list.size();
    if (k < j) {}
    for (;;)
    {
      String str2;
      try
      {
        localObject = ((String)paramConfig.content_list.get(k)).trim();
        j = i;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        j = i;
        if (!((String)localObject).contains("kandian_tab_switch")) {
          break;
        }
        localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject).getBytes("utf-8"))).getElementsByTagName("configs").item(0).getFirstChild();
        j = i;
        if (localObject == null) {
          break;
        }
        if (((Node)localObject).getFirstChild() != null)
        {
          String str1 = ((Node)localObject).getNodeName();
          str2 = ((Node)localObject).getFirstChild().getNodeValue();
          if (TextUtils.equals(str1, "kandian_tab_switch")) {
            a(localQQAppInterface, str2, paramLong);
          }
        }
      }
      catch (Exception localException1) {}
      try
      {
        QLog.d("KandianConfigServlet", 1, "handleReadTabConfig receive config, value : " + str2);
        i = 1;
        if (i == 0) {
          break label385;
        }
        d = System.currentTimeMillis() - l;
        QLog.d("KandianConfigServlet", 1, "handleReadTabConfig parse cost : " + d);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          i = 1;
        }
      }
      Object localObject = ((Node)localObject).getNextSibling();
      continue;
      QLog.d("KandianConfigServlet", 1, "handleReadTabConfig parse has exception " + localException1);
      j = i;
      break;
      label328:
      QLog.d("KandianConfigServlet", 1, "handleReadTabConfig receive config is empty!");
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long l = System.currentTimeMillis();
    c = l - this.jdField_a_of_type_Long;
    QLog.i("KandianConfigServlet", 1, "onReceive  request cost:" + c);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    boolean bool = paramFromServiceMsg.isSuccess();
    QLog.d("KandianConfigServlet", 1, pkh.a() + " onReceive   nowTime:" + l + "   requestCost:" + c + " success:" + bool + "  code" + paramFromServiceMsg.getResultCode());
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      return;
    }
    Object localObject = paramFromServiceMsg.getWupBuffer();
    if ((localObject == null) || (localObject.length < 4))
    {
      QLog.d("KandianConfigServlet", 1, "wup buf is null!!!");
      a("1", arrayOfInt, paramFromServiceMsg.getResultCode());
      return;
    }
    paramFromServiceMsg.putWupBuffer(a((byte[])localObject));
    localObject = new ConfigurationService.RespGetConfig();
    try
    {
      ((ConfigurationService.RespGetConfig)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
      try
      {
        acma.a(((ConfigurationService.RespGetConfig)localObject).min_req_interval_for_reconnect.get());
        a((ConfigurationService.RespGetConfig)localObject, localQQAppInterface, paramIntent, arrayOfInt, bool);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.w("KandianConfigServlet", 1, paramIntent.toString());
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramIntent)
    {
      QLog.d("KandianConfigServlet", 1, "error: " + paramIntent.toString());
      paramIntent.printStackTrace();
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      return;
    }
    a(localQQAppInterface, paramIntent, arrayOfInt, paramPacket);
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = false;
    }
    try
    {
      ThreadManager.executeOnSubThread(new KandianConfigServlet.1(this));
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      QLog.d("KandianConfigServlet", 1, pkh.a() + " onSend   mRequestStartTime:" + this.jdField_a_of_type_Long + "  cmds:" + arrayOfInt);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        QLog.i("KandianConfigServlet", 1, "sSpHasRead error:" + paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpl
 * JD-Core Version:    0.7.0.1
 */