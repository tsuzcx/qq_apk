import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class anga
  implements BusinessObserver
{
  private angb jdField_a_of_type_Angb;
  private LRULinkedHashMap<String, String> jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public anga(angb paramangb)
  {
    this.jdField_a_of_type_Angb = paramangb;
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(32);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Angb = null;
  }
  
  public void a(Context paramContext, long paramLong, AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.thank_zan");
        if (!TextUtils.isEmpty(paramString1)) {
          break label232;
        }
        paramString1 = "android";
        ((JSONObject)localObject).put("from", paramString1);
        ((JSONObject)localObject).put("touin", Long.parseLong(paramString2));
        ((JSONObject)localObject).put("chestid", paramLong);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramContext = new NewIntent(paramContext, awcn.class);
        paramContext.putExtra("extra_cmd", "apollo_interact.thank_zan");
        paramContext.putExtra("extra_callbackid", paramString2);
        paramContext.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramContext.setObserver(this);
        paramAppInterface.startServlet(paramContext);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("BoxCardHandler", 2, "addFlower failed ", paramContext);
      return;
      label232:
      paramString1 = "android." + paramString1;
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    if ((paramContext == null) || (paramAppInterface == null) || (paramString1 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.take_chips");
        if (!TextUtils.isEmpty(paramString2)) {
          break label246;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("dstuin", Long.parseLong(paramString1));
        ((JSONObject)localObject).put("skey", ((TicketManager)paramAppInterface.getManager(2)).getSkey(this.jdField_b_of_type_JavaLangString));
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramContext = new NewIntent(paramContext, awcn.class);
        paramContext.putExtra("extra_cmd", "apollo_interact.take_chips");
        paramContext.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramContext.putExtra("extra_callbackid", paramString1);
        paramContext.setObserver(this);
        paramAppInterface.startServlet(paramContext);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("BoxCardHandler", 2, "OpenPandora failed ", paramContext);
      return;
      label246:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    long l2;
    label236:
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
              for (;;)
              {
                return;
                i = paramBundle.getInt("extra_result_code");
                str1 = paramBundle.getString("extra_callbackid");
                str2 = paramBundle.getString("extra_cmd");
                if (QLog.isColorLevel()) {
                  QLog.d("BoxCardHandler", 2, "OpenPandora onReceive type:" + paramInt + ", isSuccess: " + paramBoolean + ", svrRet: " + i + ", uin:" + str1);
                }
                l2 = -9223372036854775808L;
                if (!paramBoolean) {
                  break label2493;
                }
                l1 = l2;
                try
                {
                  paramBundle = paramBundle.getByteArray("extra_data");
                  l1 = l2;
                  localObject1 = new WebSSOAgent.UniSsoServerRsp();
                  l1 = l2;
                  ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramBundle);
                  l1 = l2;
                  l2 = ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get();
                  l1 = l2;
                  if (!"apollo_interact.thank_zan".equals(str2)) {
                    break label236;
                  }
                  l1 = l2;
                  if (this.jdField_a_of_type_Angb != null)
                  {
                    l1 = l2;
                    this.jdField_a_of_type_Angb.a("apollo_interact.thank_zan", paramBoolean, l2, null, str1);
                    return;
                  }
                }
                catch (Exception paramBundle)
                {
                  if (this.jdField_a_of_type_Angb != null) {
                    this.jdField_a_of_type_Angb.a(str2, false, l1, null, str1);
                  }
                }
              }
            } while (!QLog.isColorLevel());
            QLog.e("BoxCardHandler", 2, paramBundle.getMessage());
            return;
            l1 = l2;
            if (!"apollo_core.get_user_info".equals(str2)) {
              break;
            }
            l1 = l2;
            paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get();
            l1 = l2;
            if (QLog.isColorLevel())
            {
              l1 = l2;
              QLog.d("BoxCardHandler", 2, "get Url onReceive retCode->" + l2 + " respStr->" + paramBundle);
            }
            l1 = l2;
            paramBundle = new JSONObject(paramBundle).optJSONObject("data").optString("qq_head");
            l1 = l2;
            if (!TextUtils.isEmpty(paramBundle))
            {
              l1 = l2;
              this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(str1, paramBundle);
            }
            l1 = l2;
          } while (this.jdField_a_of_type_Angb == null);
          l1 = l2;
          this.jdField_a_of_type_Angb.a("apollo_core.get_user_info", true, 0L, paramBundle, str1);
          return;
          l1 = l2;
        } while (!"apollo_interact.take_chips".equals(str2));
        l1 = l2;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        l1 = l2;
      } while (!this.jdField_a_of_type_JavaLangString.equals(str1));
      if (l2 != -501028L) {
        break;
      }
      l1 = l2;
    } while (this.jdField_a_of_type_Angb == null);
    long l1 = l2;
    this.jdField_a_of_type_Angb.a("apollo_interact.take_chips", paramBoolean, l2, null, str1);
    return;
    l1 = l2;
    paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get();
    l1 = l2;
    if (QLog.isColorLevel())
    {
      l1 = l2;
      QLog.d("BoxCardHandler", 2, "onReceive retCode->" + l2 + " respStr->" + paramBundle);
    }
    l1 = l2;
    Object localObject2 = new JSONObject(paramBundle).optJSONObject("data");
    l1 = l2;
    ((JSONObject)localObject2).optLong("checkpoint");
    l1 = l2;
    long l3 = ((JSONObject)localObject2).optLong("master");
    l1 = l2;
    long l4 = ((JSONObject)localObject2).optLong("chestid");
    l1 = l2;
    short s = (short)((JSONObject)localObject2).optInt("chipnum");
    l1 = l2;
    int i = ((JSONObject)localObject2).optInt("mine_chipnum");
    l1 = l2;
    int j = ((JSONObject)localObject2).optInt("goldNum");
    l1 = l2;
    Object localObject3 = ((JSONObject)localObject2).optString("back_color");
    l1 = l2;
    Object localObject1 = ((JSONObject)localObject2).optString("card_mask_color");
    l1 = l2;
    paramBundle = ((JSONObject)localObject2).optString("nick");
    l1 = l2;
    if (TextUtils.isEmpty(paramBundle)) {}
    label708:
    anfu localanfu;
    ArrayList localArrayList;
    label888:
    JSONObject localJSONObject;
    for (paramBundle = "TA";; paramBundle = paramBundle + "...")
    {
      l1 = l2;
      localanfu = new anfu();
      l1 = l2;
      localanfu.jdField_c_of_type_JavaLangString = paramBundle;
      l1 = l2;
      localanfu.jdField_b_of_type_Long = ((JSONObject)localObject2).optLong("firstcode");
      l1 = l2;
      localArrayList = new ArrayList(4);
      l1 = l2;
      localanfu.jdField_b_of_type_JavaLangString = str1;
      l1 = l2;
      localanfu.jdField_c_of_type_Long = l4;
      l1 = l2;
      localanfu.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      l1 = l2;
      localanfu.jdField_a_of_type_Long = l2;
      l1 = l2;
      localanfu.jdField_a_of_type_Int = ApolloUtil.a((String)localObject3);
      l1 = l2;
      localanfu.jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("topUrl");
      l1 = l2;
      localanfu.jdField_e_of_type_JavaLangString = ((JSONObject)localObject2).optString("bottomUrl");
      l1 = l2;
      localObject3 = ((JSONObject)localObject2).optJSONArray("giftTotalList");
      if (localObject3 == null) {
        break label1133;
      }
      l1 = l2;
      int k = ((JSONArray)localObject3).length();
      paramInt = 0;
      if (paramInt >= k) {
        break label1133;
      }
      l1 = l2;
      localJSONObject = ((JSONArray)localObject3).optJSONObject(paramInt);
      if (localJSONObject != null) {
        break;
      }
      break label2525;
      l1 = l2;
      if (mry.a(paramBundle) <= 20) {
        break label2522;
      }
      l1 = l2;
      paramBundle = mry.a(paramBundle, 0, 20);
      l1 = l2;
    }
    l1 = l2;
    Object localObject4 = new anfw();
    l1 = l2;
    ((anfw)localObject4).jdField_a_of_type_Int = localJSONObject.optInt("giftType");
    l1 = l2;
    ((anfw)localObject4).jdField_b_of_type_Int = localJSONObject.optInt("giftTotal");
    l1 = l2;
    ((anfw)localObject4).jdField_a_of_type_JavaLangString = localJSONObject.optString("iconUrl");
    l1 = l2;
    ((anfw)localObject4).jdField_b_of_type_JavaLangString = localJSONObject.optString("jumpUrl");
    l1 = l2;
    boolean bool;
    if (localJSONObject.optInt("isShow") == 1)
    {
      bool = true;
      label1067:
      l1 = l2;
      ((anfw)localObject4).jdField_a_of_type_Boolean = bool;
      l1 = l2;
      if (((anfw)localObject4).jdField_a_of_type_Boolean)
      {
        l1 = l2;
        localanfu.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((anfw)localObject4).jdField_a_of_type_Int), localObject4);
        l1 = l2;
        localanfu.jdField_a_of_type_JavaUtilList.add(localObject4);
        break label2525;
        label1133:
        l1 = l2;
        localObject3 = (anfw)localanfu.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
        if (localObject3 != null)
        {
          l1 = l2;
          if (((anfw)localObject3).jdField_b_of_type_Int == 0)
          {
            l1 = l2;
            ((anfw)localObject3).jdField_b_of_type_Int = i;
          }
        }
        l1 = l2;
        localObject3 = (anfw)localanfu.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(7));
        if (localObject3 != null)
        {
          l1 = l2;
          if (((anfw)localObject3).jdField_b_of_type_Int == 0)
          {
            l1 = l2;
            ((anfw)localObject3).jdField_b_of_type_Int = j;
          }
        }
        l1 = l2;
        localObject3 = ((JSONObject)localObject2).optJSONArray("tooklist");
        l1 = l2;
        localObject2 = ((JSONObject)localObject2).optJSONArray("tookGiftList");
        i = -1;
        l1 = l2;
        if (localanfu.jdField_b_of_type_Long != 0L) {
          break label2538;
        }
        l1 = l2;
        if (localanfu.jdField_a_of_type_Long != -501031L) {
          break label2556;
        }
        break label2538;
        label1296:
        j = i;
        if (l2 == -501040L) {
          break label2571;
        }
        paramInt = i;
        if (localObject3 != null)
        {
          l1 = l2;
          paramInt = i;
          if (((JSONArray)localObject3).length() > 0)
          {
            j = 0;
            label1335:
            l1 = l2;
            paramInt = i;
            if (j < ((JSONArray)localObject3).length())
            {
              l1 = l2;
              localJSONObject = (JSONObject)((JSONArray)localObject3).get(j);
              l1 = l2;
              localObject4 = new anfv();
              l1 = l2;
              ((anfv)localObject4).jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
              l1 = l2;
              ((anfv)localObject4).jdField_a_of_type_Long = localJSONObject.optLong("uin");
              l1 = l2;
              ((anfv)localObject4).jdField_e_of_type_Long = localJSONObject.optLong("finishts");
              l1 = l2;
              ((anfv)localObject4).jdField_d_of_type_Long = localJSONObject.optLong("redeemts");
              l1 = l2;
              ((anfv)localObject4).jdField_a_of_type_Int = localJSONObject.optInt("id");
              l1 = l2;
              ((anfv)localObject4).jdField_c_of_type_Long = localJSONObject.optLong("ts");
              l1 = l2;
              ((anfv)localObject4).jdField_b_of_type_JavaLangString = localJSONObject.optString("grade");
              l1 = l2;
              ((anfv)localObject4).jdField_g_of_type_JavaLangString = localJSONObject.optString("gradeUrl");
              l1 = l2;
              ((anfv)localObject4).jdField_c_of_type_JavaLangString = localJSONObject.optString("nick");
              l1 = l2;
              ((anfv)localObject4).jdField_d_of_type_JavaLangString = localJSONObject.optString("head");
              l1 = l2;
              ((anfv)localObject4).jdField_b_of_type_Int = localJSONObject.optInt("viplevel");
              l1 = l2;
              ((anfv)localObject4).jdField_c_of_type_Int = localJSONObject.optInt("chiptotal");
              l1 = l2;
              ((anfv)localObject4).jdField_d_of_type_Int = localJSONObject.optInt("minenum");
              l1 = l2;
              ((anfv)localObject4).jdField_e_of_type_JavaLangString = localJSONObject.optString("picUrl");
              l1 = l2;
              ((anfv)localObject4).jdField_f_of_type_JavaLangString = localJSONObject.optString("picDesc");
              l1 = l2;
              ((anfv)localObject4).h = localJSONObject.optInt("isSquare");
              l1 = l2;
              ((anfv)localObject4).jdField_f_of_type_Int = localJSONObject.optInt("giftNum", 1);
              l1 = l2;
              if (((anfv)localObject4).jdField_b_of_type_Long == ((anfv)localObject4).jdField_a_of_type_Long)
              {
                l1 = l2;
                if (TextUtils.isEmpty(((anfv)localObject4).jdField_c_of_type_JavaLangString))
                {
                  l1 = l2;
                  ((anfv)localObject4).jdField_c_of_type_JavaLangString = paramBundle;
                }
              }
              l1 = l2;
              if (TextUtils.isEmpty(((anfv)localObject4).jdField_c_of_type_JavaLangString))
              {
                l1 = l2;
                ((anfv)localObject4).jdField_c_of_type_JavaLangString = "TA";
              }
              l1 = l2;
              ((anfv)localObject4).jdField_a_of_type_Short = ((short)localJSONObject.optInt("type"));
              l1 = l2;
              ((anfv)localObject4).jdField_b_of_type_Short = s;
              l1 = l2;
              ((anfv)localObject4).jdField_b_of_type_Long = l3;
              l1 = l2;
              ((anfv)localObject4).jdField_b_of_type_Boolean = bool;
              l1 = l2;
              ((anfv)localObject4).jdField_e_of_type_Int = ApolloUtil.a((String)localObject1);
              l1 = l2;
              paramInt = i;
              if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
              {
                l1 = l2;
                paramInt = i;
                if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(((anfv)localObject4).jdField_a_of_type_Long)))
                {
                  l1 = l2;
                  paramInt = i;
                  if (localJSONObject.optInt("zanmark") == 0) {
                    paramInt = 0;
                  }
                }
              }
              l1 = l2;
              ((anfv)localObject4).jdField_g_of_type_Int = 0;
              l1 = l2;
              if (localJSONObject.has("layoutStyle"))
              {
                l1 = l2;
                ((anfv)localObject4).jdField_g_of_type_Int = localJSONObject.optInt("layoutStyle");
              }
              l1 = l2;
              ((anfv)localObject4).jdField_a_of_type_Boolean = ((anfv)localObject4).a(this.jdField_b_of_type_JavaLangString);
              l1 = l2;
              if (((anfv)localObject4).jdField_a_of_type_Boolean)
              {
                l1 = l2;
                localArrayList.add(0, localObject4);
                break label2544;
              }
              l1 = l2;
              localArrayList.add(localObject4);
              break label2544;
            }
          }
        }
        j = paramInt;
        if (localObject2 == null) {
          break label2571;
        }
        l1 = l2;
        j = paramInt;
        if (((JSONArray)localObject2).length() <= 0) {
          break label2571;
        }
        i = 0;
        label2000:
        l1 = l2;
        j = paramInt;
        if (i >= ((JSONArray)localObject2).length()) {
          break label2571;
        }
        l1 = l2;
        paramBundle = ((JSONArray)localObject2).getJSONObject(i);
        l1 = l2;
        localObject1 = new anfv();
        l1 = l2;
        ((anfv)localObject1).jdField_a_of_type_Long = paramBundle.optLong("uin");
        l1 = l2;
        ((anfv)localObject1).jdField_c_of_type_Long = paramBundle.optLong("ts");
        l1 = l2;
        ((anfv)localObject1).jdField_a_of_type_Short = ((short)paramBundle.optInt("giftType"));
        l1 = l2;
        if (((anfv)localObject1).jdField_a_of_type_Short == 7)
        {
          l1 = l2;
          ((anfv)localObject1).jdField_g_of_type_Int = 2;
        }
        for (;;)
        {
          l1 = l2;
          if (paramBundle.has("layoutStyle"))
          {
            l1 = l2;
            ((anfv)localObject1).jdField_g_of_type_Int = paramBundle.optInt("layoutStyle");
          }
          l1 = l2;
          localObject3 = (anfw)localanfu.jdField_a_of_type_JavaUtilHashMap.get(Short.valueOf(((anfv)localObject1).jdField_a_of_type_Short));
          if (localObject3 == null) {
            break;
          }
          l1 = l2;
          if (((anfw)localObject3).jdField_a_of_type_Boolean) {
            break;
          }
          break label2562;
          l1 = l2;
          if (((anfv)localObject1).jdField_a_of_type_Short == 15)
          {
            l1 = l2;
            ((anfv)localObject1).jdField_g_of_type_Int = 3;
          }
        }
        l1 = l2;
        ((anfv)localObject1).jdField_f_of_type_Int = paramBundle.optInt("giftNum");
        l1 = l2;
        ((anfv)localObject1).jdField_c_of_type_JavaLangString = paramBundle.optString("nick");
        l1 = l2;
        ((anfv)localObject1).jdField_d_of_type_JavaLangString = paramBundle.optString("head");
        l1 = l2;
        ((anfv)localObject1).jdField_b_of_type_JavaLangString = paramBundle.optString("grade");
        l1 = l2;
        ((anfv)localObject1).jdField_g_of_type_JavaLangString = paramBundle.optString("gradeUrl");
        l1 = l2;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          l1 = l2;
          if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(((anfv)localObject1).jdField_a_of_type_Long)))
          {
            l1 = l2;
            if (paramBundle.optInt("zanmark") == 0)
            {
              paramInt = 0;
              label2349:
              l1 = l2;
              ((anfv)localObject1).jdField_a_of_type_Boolean = ((anfv)localObject1).a(this.jdField_b_of_type_JavaLangString);
              l1 = l2;
              if (((anfv)localObject1).jdField_a_of_type_Boolean)
              {
                l1 = l2;
                localArrayList.add(0, localObject1);
                break label2562;
              }
              l1 = l2;
              localArrayList.add(localObject1);
              break label2562;
            }
          }
        }
      }
    }
    for (;;)
    {
      label2413:
      l1 = l2;
      localanfu.jdField_a_of_type_Boolean = bool;
      l1 = l2;
      Collections.sort(localArrayList);
      l1 = l2;
      localanfu.jdField_b_of_type_JavaUtilList = localArrayList;
      l1 = l2;
      localanfu.a();
      l1 = l2;
      if (this.jdField_a_of_type_Angb == null) {
        break;
      }
      l1 = l2;
      this.jdField_a_of_type_Angb.a("apollo_interact.take_chips", paramBoolean, l2, localanfu, str1);
      return;
      label2493:
      label2522:
      label2525:
      label2538:
      label2544:
      label2556:
      do
      {
        bool = false;
        break label2413;
        if (this.jdField_a_of_type_Angb == null) {
          break;
        }
        this.jdField_a_of_type_Angb.a(str2, false, -9223372036854775808L, null, str1);
        return;
        break label2349;
        break label708;
        paramInt += 1;
        break label888;
        bool = false;
        break label1067;
        bool = true;
        break label1296;
        j += 1;
        i = paramInt;
        break label1335;
        bool = false;
        break label1296;
        i += 1;
        break label2000;
      } while (j != 0);
      label2562:
      label2571:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anga
 * JD-Core Version:    0.7.0.1
 */