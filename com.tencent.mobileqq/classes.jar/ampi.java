import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ClubContentUpdateHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ampi
  extends BusinessHandler
{
  bgod jdField_a_of_type_Bgod = new ampj(this);
  private bgog jdField_a_of_type_Bgog;
  public QQAppInterface a;
  
  ampi(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramString, paramInt1, "", paramInt2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "small emotion has update info.");
    }
    bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + paramString, paramInt1);
  }
  
  private void a(int paramInt, bgda parambgda)
  {
    if (Math.abs(paramInt - bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), parambgda.d)) > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "New version json found!");
      }
      if (this.jdField_a_of_type_Bgog == null) {
        this.jdField_a_of_type_Bgog = ((bgog)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47));
      }
      File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getFilesDir(), parambgda.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("version", paramInt);
      localBundle.putString("json_name", parambgda.d);
      parambgda = new bgoe(parambgda.b, localFile);
      this.jdField_a_of_type_Bgog.a(1).a(parambgda, this.jdField_a_of_type_Bgod, localBundle);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("8.4.8.4810");
      localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
      ArrayList localArrayList1 = new ArrayList();
      int i = paramQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0).getInt("sigTplCfgVer", 0);
      ArrayList localArrayList2 = new ArrayList();
      Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("signature_json");
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
      localArrayList2.add(localObject2);
      localObject2 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).uint_appid.set(8);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).rpt_msg_reqiteminfo.set(localArrayList2);
      localArrayList1.add(localObject2);
      localReqBody.rpt_msg_reqappinfo.set(localArrayList1);
      localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "ClubContentUpdate.Req");
      ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.sendToService((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i("ClubContentUpdateHandler", 2, "checkUpdateSigTpl called.");
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, Map<String, Integer> paramMap, boolean paramBoolean)
  {
    if (paramString1.equals(bgcw.d.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEmoticonWordingTask!");
      }
      a(paramInt1, bgcw.d, paramBoolean);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramString1.equals(bgcw.a.e)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEPPromotionTask!");
          }
          paramInt2 = bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bgcw.a.d);
        } while (paramInt1 <= paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        bgcw.a(MobileQQ.getContext(), bgcw.a.d, paramInt2);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("recommendEmotion_sp_name", 0);
        ((amrg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(12)).a();
        paramString1.edit().putLong("last_get_recommendemotion_time_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), System.currentTimeMillis()).commit();
        return;
        if (!paramString1.contains("_json")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, name.contains(EmosmConstant.EMOTICON_JSON_UPDATE_REQUEST_SUFFIX!");
        }
      } while (!EmoticonUtils.isEmoticonPkgUpdateBitSet(paramInt2));
      ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).b(paramString1.replace("_json", "").trim(), paramInt1, paramString2, paramInt2, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, update emoji package!");
      }
      ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramString1, paramInt1, paramString2, paramInt2, 0);
      paramMap.put(paramString1, Integer.valueOf(paramInt2));
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentUpdateHandler", 2, "emotion has update info.");
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("group_domain")) && (paramJSONObject.has("group_strategy"))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        String str = paramJSONObject.getString("group_domain");
        paramJSONObject = paramJSONObject.getString("group_strategy");
        if (QLog.isColorLevel()) {
          QLog.i("ClubContentUpdateHandler", 2, "cdnCacheConfig, domain: " + str + ", strategys: " + paramJSONObject);
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        do
        {
          paramJSONObject.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.w("ClubContentUpdateHandler", 2, "", paramJSONObject);
        return;
      }
    }
    QLog.w("ClubContentUpdateHandler", 2, "no cdnCacheConfig!");
  }
  
  private boolean a(int paramInt, bgda parambgda, boolean paramBoolean)
  {
    int i = bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), parambgda.d);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "updateResJson name = " + parambgda.e + " localVersion = " + i + " version = " + paramInt);
    }
    if (paramInt > i)
    {
      bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambgda, paramInt, paramBoolean);
      return true;
    }
    return false;
  }
  
  private void b() {}
  
  private void b(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    case 204: 
    default: 
    case 201: 
      do
      {
        return;
        QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update panel id: " + paramString + ", version: " + paramInt2);
        alnr localalnr = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((!alnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) || (localalnr == null) || (1 != localalnr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
          break;
        }
      } while (!TextUtils.equals("tab_list_android_json_v665", paramString));
      a(paramString, paramInt2);
      return;
      QLog.i("ClubContentUpdateHandler", 1, "panel update cancel, apollo not available.");
      return;
    case 205: 
      QLog.i("ClubContentUpdateHandler", 1, "saveQVIPResConfigContent apollo_client realtime update apolloWebView config name: " + paramString + ", version: " + paramInt2);
      amfn.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2, false);
      return;
    case 202: 
      c(paramString, paramInt2);
      return;
    case 203: 
      b(paramString, paramInt2);
      return;
    }
    d(paramString, paramInt2);
  }
  
  private void b(String paramString, int paramInt)
  {
    try
    {
      QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update dress id: " + paramString + ", ver: " + paramInt);
      alnr localalnr = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((alnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (localalnr != null) && (1 == localalnr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))
      {
        int i = Integer.parseInt(paramString);
        long l = localalnr.a(2, i) / 1000L;
        if (l != paramInt)
        {
          amdp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, -1, new int[] { i }, -1, -1, true);
          QLog.i("ClubContentUpdateHandler", 1, "download apollo dress id: " + i + ", loc ver: " + l);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 2, "apollo dress real time update id:" + paramString, localException);
    }
  }
  
  private void c(String paramString, int paramInt)
  {
    try
    {
      QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update role id: " + paramString + ", ver: " + paramInt);
      alnr localalnr = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((alnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (localalnr != null) && (1 == localalnr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))
      {
        int i = Integer.parseInt(paramString);
        long l = localalnr.a(1, i) / 1000L;
        if (l != paramInt)
        {
          amdp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, i, null, -1, -1, true);
          QLog.i("ClubContentUpdateHandler", 1, "download apollo role id: " + paramString + ", loc ver: " + l);
        }
      }
      else
      {
        QLog.i("ClubContentUpdateHandler", 1, "apollo role res ");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 2, "apollo: update role res realTime failed name:" + paramString, localException);
    }
  }
  
  private void d(String paramString, int paramInt)
  {
    if (anwk.a().equals(paramString))
    {
      paramString = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((!alnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) || (paramString == null) || (1 != paramString.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
        break label180;
      }
      if ((anwk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(115) != null)
      {
        long l = anwk.b();
        if (l != paramInt)
        {
          paramString = amip.av + "base.zip";
          Bundle localBundle = new Bundle();
          localBundle.putLong("version", paramInt);
          amdp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, amip.at, localBundle, new anwm());
        }
        QLog.i("ClubContentUpdateHandler", 1, "apollo_base_script login push version: " + paramInt + ", old version: " + l);
      }
    }
    return;
    label180:
    QLog.i("ClubContentUpdateHandler", 1, "apollo_base_script login push");
  }
  
  private void g(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleGetIndividuationUrlsResponse, name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (!str1.equals(bgcw.b.e)) {}
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    Object localObject = ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(0);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "SmallEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag);
        }
        if ((localEmoticonPackage.jobType == 4) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.isEmoticonPkgNeverUpdateBitSet(localEmoticonPackage.updateFlag)))
        {
          ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
        }
      }
    }
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(10);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return localObject;
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a(bgda parambgda, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(parambgda.e);
    localReqItemInfo.uint_version.set(bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), parambgda.d));
    localArrayList.add(localReqItemInfo);
    parambgda = new ClubContentUpdateInfoPb.ReqAppInfo();
    parambgda.uint_appid.set(paramInt);
    parambgda.rpt_msg_reqiteminfo.set(localArrayList);
    parambgda.setHasFlag(true);
    return parambgda;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("8.4.8.4810");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b());
    localArrayList.add(a());
    localArrayList.add(c());
    localArrayList.add(b(bgcw.c, 7));
    localArrayList.add(a(bgcw.e, 105));
    localArrayList.add(b(bgcw.f, 11));
    localArrayList.add(b(bgcw.h, 113));
    localArrayList.add(b(bgcw.i, 5));
    localReqBody.rpt_msg_reqappinfo.set(localArrayList);
    localReqBody.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - l) + "ms");
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramInt1 = bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + paramString);
                if (QLog.isColorLevel()) {
                  QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + paramString + ",version" + paramInt2 + ",localVersion:" + paramInt1);
                }
              } while (paramInt1 >= paramInt2);
              a(paramInt2, 1, paramString);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "func handleSmallEmosmResponse, bigEmoji and magicEmoji");
              }
              a(paramString, paramInt2, "", 1, new HashMap(), true);
              return;
            } while (!bgcw.c.e.equals(paramString));
            a(paramInt2, bgcw.c, true);
            return;
          } while ((!bgcw.b.e.equals(paramString)) || (!QLog.isColorLevel()));
          QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, update json for individuation url config");
          return;
        } while (!bgcw.h.e.equals(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent UrlInterceptJson");
        }
        a(paramInt2, bgcw.h, true);
        return;
      } while (!bgcw.i.e.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent FontInfoList");
      }
      a(paramInt2, bgcw.i, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, individuation mainpage, name=" + paramString);
      }
    } while (!paramString.equals("individuation_mainpage_config2"));
  }
  
  public void a(Context paramContext)
  {
    int i = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getString("qvip_res_push_cfg_txt.", "");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).getJSONArray("data");
        if (i >= ((JSONArray)localObject).length()) {
          continue;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        String str = localJSONObject.getString("filename");
        if (!bgcw.e.a.equals(str)) {
          break label168;
        }
        localObject = localJSONObject.getString("version");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        i = Integer.parseInt((String)localObject);
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("ClubContentUpdateHandler", 2, "Parse QVIP_RES_PUSH_CFG_TXT failed:" + paramContext.toString());
        return;
        i = -1;
        if (i != -1) {
          continue;
        }
      }
      if (bgcw.a(paramContext, bgcw.e.d) != i)
      {
        a(i, bgcw.e);
        return;
      }
      label167:
      return;
      label168:
      i += 1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "func saveQVIPResConfigContent invoked!");
    }
    BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putString("qvip_res_push_cfg_txt.", paramString).commit();
    for (;;)
    {
      try
      {
        paramQQAppInterface = new JSONObject(paramString).getJSONArray("data");
        j = paramQQAppInterface.length();
        if (i >= j) {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ClubContentUpdateHandler", 2, "name= saveQVIPResConfigContent ", paramQQAppInterface);
        return;
      }
      try
      {
        paramString = paramQQAppInterface.getJSONObject(i);
        j = paramString.getInt("version");
        k = paramString.getInt("id");
        paramString = paramString.getString("filename");
        if (paramString == null) {
          return;
        }
        a(k, paramString, j);
        b(k, paramString, j);
        if (bgcw.e.e.equals(paramString)) {
          a(j, bgcw.e);
        }
      }
      catch (Exception paramString)
      {
        continue;
      }
      i += 1;
    }
  }
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleUrlInterceptJSONResponse name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (str1.equals(bgcw.h.e)) {
        a(i, bgcw.h, false);
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        paramToServiceMsg = new ClubContentUpdateInfoPb.RspBody();
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.int_result.get() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          b();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label326;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 2: 
        case 3: 
        case 9: 
        case 18: 
        case 1: 
          e(paramFromServiceMsg);
          break;
        case 10: 
          d(paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      continue;
      c(paramFromServiceMsg);
      continue;
      b(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      g(paramFromServiceMsg);
      continue;
      a(paramFromServiceMsg);
      continue;
      f(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      label326:
      return;
      i = 0;
      break;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ClubContentUpdateHandler.1(this, paramInt, paramString));
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
  {
    Object localObject = ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(0);
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "BigEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        }
        if ((localEmoticonPackage.jobType == 0) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.isEmoticonPkgNeverUpdateBitSet(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label378;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label378:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(bgcw.d.e);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bgcw.d.d));
      localArrayList.add(localObject);
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b(bgda parambgda, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(parambgda.e);
    localReqItemInfo.uint_version.set(bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), parambgda.d));
    localArrayList.add(localReqItemInfo);
    parambgda = new ClubContentUpdateInfoPb.ReqAppInfo();
    parambgda.uint_appid.set(paramInt);
    parambgda.rpt_msg_reqiteminfo.set(localArrayList);
    parambgda.setHasFlag(true);
    return parambgda;
  }
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    paramRspAppInfo = new StringBuilder(((ArrayList)localObject).size() * 64);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)((Iterator)localObject).next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        paramRspAppInfo.append("name=").append(str1).append(", version=").append(i).append(", updateFlag=").append(j).append(", extStr=").append(str2);
      }
      if ((str1.equals(bgcw.e.e)) && (i > bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bgcw.e.d))) {
        a(i, bgcw.e);
      }
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramRspAppInfo.toString()))) {
      QLog.d("ClubContentUpdateHandler", 2, paramRspAppInfo.toString());
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject = ((avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(0);
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        QLog.d("ClubContentUpdateHandler", 2, "MagicEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        if ((localEmoticonPackage.jobType == 3) && (localEmoticonPackage.status == 2) && (!EmoticonUtils.isEmoticonPkgNeverUpdateBitSet(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label320;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label320:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (!TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
        }
        if (str1.equals(bgcw.c.e))
        {
          if (i > bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bgcw.c.d)) {
            bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bgcw.c, i, false);
          }
        }
        else if (str1.equals(bgcw.f.e))
        {
          if (i > bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bgcw.f.d)) {
            bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bgcw.f, i, false);
          }
        }
        else if (str1.equals(bgcw.i.e))
        {
          j = bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bgcw.i.d);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "FontInfoList_json remoteVersion = " + i + " localVersion = " + j);
          }
          if (i > j) {
            bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bgcw.i, i, false);
          }
        }
      }
    }
  }
  
  protected void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse begins");
    }
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      int j = localRspItemInfo.uint_update_flag.get();
      int k = bgcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + str);
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + str + ",updateFlag:" + j + ",version" + i + ",localVersion:" + k);
      }
      if (k < i) {
        a(i, j, str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse ends");
    }
  }
  
  protected void e(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    QLog.d("ClubContentUpdateHandler", 2, "handleEmosmResponse begins");
    paramRspAppInfo = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramRspAppInfo.iterator();
    while (localIterator.hasNext())
    {
      paramRspAppInfo = (ClubContentUpdateInfoPb.RspItemInfo)localIterator.next();
      String str1 = paramRspAppInfo.str_name.get();
      int i = paramRspAppInfo.uint_version.get();
      String str2 = paramRspAppInfo.str_extend.get();
      int j = paramRspAppInfo.uint_update_flag.get();
      String[] arrayOfString = str2.split("\\|\\|");
      paramRspAppInfo = "";
      if (arrayOfString.length > 0) {
        paramRspAppInfo = arrayOfString[0];
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", tip=" + paramRspAppInfo + ", updateFlag=" + j + ",extStr=" + str2);
      }
      a(str1, i, paramRspAppInfo, j, localHashMap, false);
    }
  }
  
  protected void f(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleIndividuationMainpageConfigResponse, name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (!str1.equals("individuation_mainpage_config2")) {}
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ClubContentUpdate.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampi
 * JD-Core Version:    0.7.0.1
 */