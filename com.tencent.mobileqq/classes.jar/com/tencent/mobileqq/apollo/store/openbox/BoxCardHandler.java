package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
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

public class BoxCardHandler
  implements BusinessObserver
{
  private BoxCardHandler.OnBoxCardHandlerListener jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener;
  private LRULinkedHashMap<String, String> jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public BoxCardHandler(BoxCardHandler.OnBoxCardHandlerListener paramOnBoxCardHandlerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener = paramOnBoxCardHandlerListener;
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(32);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener = null;
  }
  
  public void a(Context paramContext, long paramLong, AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.thank_zan");
        if (TextUtils.isEmpty(paramString1))
        {
          paramString1 = "android";
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("android.");
          localStringBuilder.append(paramString1);
          paramString1 = localStringBuilder.toString();
        }
        ((JSONObject)localObject).put("from", paramString1);
        ((JSONObject)localObject).put("touin", Long.parseLong(paramString2));
        ((JSONObject)localObject).put("chestid", paramLong);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramContext = new NewIntent(paramContext, WebSSOAgentServlet.class);
        paramContext.putExtra("extra_cmd", "apollo_interact.thank_zan");
        paramContext.putExtra("extra_callbackid", paramString2);
        paramContext.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramContext.setObserver(this);
        paramAppInterface.startServlet(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]BoxCardHandler", 2, "addFlower failed ", paramContext);
        }
      }
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    if ((paramContext != null) && (paramAppInterface != null))
    {
      if (paramString1 == null) {
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.take_chips");
        if (TextUtils.isEmpty(paramString2))
        {
          paramString2 = "android";
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("android.");
          localStringBuilder.append(paramString2);
          paramString2 = localStringBuilder.toString();
        }
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("dstuin", Long.parseLong(paramString1));
        ((JSONObject)localObject).put("skey", ((TicketManager)paramAppInterface.getManager(2)).getSkey(this.jdField_b_of_type_JavaLangString));
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramContext = new NewIntent(paramContext, WebSSOAgentServlet.class);
        paramContext.putExtra("extra_cmd", "apollo_interact.take_chips");
        paramContext.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramContext.putExtra("extra_callbackid", paramString1);
        paramContext.setObserver(this);
        paramAppInterface.startServlet(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("[cmshow]BoxCardHandler", 2, "OpenPandora failed ", paramContext);
        }
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = "nick";
    if (paramBundle == null) {
      return;
    }
    i = paramBundle.getInt("extra_result_code");
    String str2 = paramBundle.getString("extra_callbackid");
    String str3 = paramBundle.getString("extra_cmd");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OpenPandora onReceive type:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", isSuccess: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", svrRet: ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", uin:");
      ((StringBuilder)localObject1).append(str2);
      QLog.d("[cmshow]BoxCardHandler", 2, ((StringBuilder)localObject1).toString());
    }
    long l1 = -9223372036854775808L;
    long l3;
    long l2;
    if (paramBoolean)
    {
      l3 = l1;
      for (;;)
      {
        try
        {
          paramBundle = paramBundle.getByteArray("extra_data");
          l3 = l1;
          localObject1 = new WebSSOAgent.UniSsoServerRsp();
          l3 = l1;
          ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramBundle);
          l3 = l1;
          l1 = ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get();
          l2 = l1;
          try
          {
            bool1 = "apollo_interact.thank_zan".equals(str3);
            if (bool1)
            {
              l3 = l2;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener != null)
              {
                l3 = l2;
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener.a("apollo_interact.thank_zan", paramBoolean, l2, null, str2);
              }
              return;
            }
            bool1 = "apollo_core.get_user_info_v2".equals(str3);
            if (bool1) {
              try
              {
                paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get();
                paramBoolean = QLog.isColorLevel();
                if (paramBoolean)
                {
                  l3 = l2;
                  localObject1 = new StringBuilder();
                  l3 = l2;
                  ((StringBuilder)localObject1).append("get Url onReceive retCode->");
                  l3 = l2;
                  ((StringBuilder)localObject1).append(l2);
                  l3 = l2;
                  ((StringBuilder)localObject1).append(" respStr->");
                  l3 = l2;
                  ((StringBuilder)localObject1).append(paramBundle);
                  l3 = l2;
                  QLog.d("[cmshow]BoxCardHandler", 2, ((StringBuilder)localObject1).toString());
                }
                paramBundle = new JSONObject(paramBundle).optJSONObject("data").optString("qq_head");
                paramBoolean = TextUtils.isEmpty(paramBundle);
                if (!paramBoolean)
                {
                  l3 = l2;
                  this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(str2, paramBundle);
                }
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener == null) {
                  continue;
                }
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener;
                try
                {
                  ((BoxCardHandler.OnBoxCardHandlerListener)localObject1).a("apollo_core.get_user_info_v2", true, 0L, paramBundle, str2);
                }
                catch (Exception paramBundle)
                {
                  continue;
                }
                short s;
                int k;
                Object localObject7;
                try
                {
                  if (!"apollo_interact.take_chips".equals(str3)) {
                    continue;
                  }
                  bool1 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
                  if (bool1) {}
                }
                catch (Exception paramBundle) {}
              }
              catch (Exception paramBundle) {}
            }
          }
          catch (Exception paramBundle) {}
        }
        catch (Exception paramBundle)
        {
          l2 = l3;
        }
        try
        {
          if (!this.jdField_a_of_type_JavaLangString.equals(str2)) {
            return;
          }
          if (l2 == -501028L)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener != null)
            {
              paramBundle = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener;
              l3 = l2;
              paramBundle.a("apollo_interact.take_chips", paramBoolean, l2, null, str2);
            }
            return;
          }
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get();
          bool1 = QLog.isColorLevel();
          if (bool1)
          {
            l3 = l2;
            localObject1 = new StringBuilder();
            l3 = l2;
            ((StringBuilder)localObject1).append("onReceive retCode->");
            l3 = l2;
            ((StringBuilder)localObject1).append(l2);
            l3 = l2;
            ((StringBuilder)localObject1).append(" respStr->");
            l3 = l2;
            ((StringBuilder)localObject1).append(paramBundle);
            l3 = l2;
            QLog.d("[cmshow]BoxCardHandler", 2, ((StringBuilder)localObject1).toString());
          }
          localObject4 = new JSONObject(paramBundle).optJSONObject("data");
          ((JSONObject)localObject4).optLong("checkpoint");
          l3 = ((JSONObject)localObject4).optLong("master");
          s = (short)((JSONObject)localObject4).optInt("chipnum");
          j = ((JSONObject)localObject4).optInt("mine_chipnum");
          k = ((JSONObject)localObject4).optInt("goldNum");
          localObject7 = ((JSONObject)localObject4).optString("card_mask_color");
          paramBundle = ((JSONObject)localObject4).optString("nick");
          bool1 = TextUtils.isEmpty(paramBundle);
          if (bool1) {
            localObject1 = "TA";
          }
        }
        catch (Exception paramBundle)
        {
          continue;
          bool1 = false;
          continue;
          continue;
          continue;
          i = paramInt;
          continue;
          j += 1;
          continue;
          break label2386;
          i = -1;
          localObject4 = localObject2;
          localObject1 = paramBundle;
          paramBundle = this;
          bool1 = false;
          if (i != 0) {
            break label2402;
          }
          bool1 = true;
          continue;
          continue;
        }
        try
        {
          paramInt = CharacterUtil.a(paramBundle);
          localObject1 = paramBundle;
          if (paramInt > 20) {
            try
            {
              paramBundle = CharacterUtil.a(paramBundle, 0, 20);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramBundle);
              ((StringBuilder)localObject1).append("...");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            catch (Exception paramBundle)
            {
              continue;
            }
          }
          try
          {
            localObject2 = new ApolloBoxData();
            ((ApolloBoxData)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
            ((ApolloBoxData)localObject2).jdField_b_of_type_Long = ((JSONObject)localObject4).optLong("firstcode");
            paramBundle = new ArrayList(4);
            ((ApolloBoxData)localObject2).jdField_b_of_type_JavaLangString = str2;
            ((ApolloBoxData)localObject2).jdField_c_of_type_Long = ((JSONObject)localObject4).optLong("chestid");
            ((ApolloBoxData)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            ((ApolloBoxData)localObject2).jdField_a_of_type_Long = l2;
            ((ApolloBoxData)localObject2).jdField_a_of_type_Int = ApolloUtilImpl.colorParse(((JSONObject)localObject4).optString("back_color"));
            ((ApolloBoxData)localObject2).jdField_d_of_type_JavaLangString = ((JSONObject)localObject4).optString("topUrl");
            ((ApolloBoxData)localObject2).jdField_e_of_type_JavaLangString = ((JSONObject)localObject4).optString("bottomUrl");
            Object localObject3 = ((JSONObject)localObject4).optJSONArray("giftTotalList");
            Object localObject5;
            Object localObject6;
            if (localObject3 != null) {
              try
              {
                paramInt = ((JSONArray)localObject3).length();
                i = 0;
                if (i < paramInt) {
                  try
                  {
                    localObject5 = ((JSONArray)localObject3).optJSONObject(i);
                    if (localObject5 != null)
                    {
                      localObject6 = new ApolloBoxData.BoxCardListSummary();
                      ((ApolloBoxData.BoxCardListSummary)localObject6).jdField_a_of_type_Int = ((JSONObject)localObject5).optInt("giftType");
                      ((ApolloBoxData.BoxCardListSummary)localObject6).jdField_b_of_type_Int = ((JSONObject)localObject5).optInt("giftTotal");
                      ((ApolloBoxData.BoxCardListSummary)localObject6).jdField_a_of_type_JavaLangString = ((JSONObject)localObject5).optString("iconUrl");
                      ((ApolloBoxData.BoxCardListSummary)localObject6).jdField_b_of_type_JavaLangString = ((JSONObject)localObject5).optString("jumpUrl");
                      if (((JSONObject)localObject5).optInt("isShow") != 1) {
                        break label2342;
                      }
                      bool1 = true;
                      ((ApolloBoxData.BoxCardListSummary)localObject6).jdField_a_of_type_Boolean = bool1;
                      if (((ApolloBoxData.BoxCardListSummary)localObject6).jdField_a_of_type_Boolean)
                      {
                        ((ApolloBoxData)localObject2).jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((ApolloBoxData.BoxCardListSummary)localObject6).jdField_a_of_type_Int), localObject6);
                        ((ApolloBoxData)localObject2).jdField_a_of_type_JavaUtilList.add(localObject6);
                      }
                    }
                    i += 1;
                  }
                  catch (Exception paramBundle) {}
                }
              }
              catch (Exception paramBundle) {}
            }
            try
            {
              localObject3 = (ApolloBoxData.BoxCardListSummary)((ApolloBoxData)localObject2).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
              if ((localObject3 != null) && (((ApolloBoxData.BoxCardListSummary)localObject3).jdField_b_of_type_Int == 0)) {
                ((ApolloBoxData.BoxCardListSummary)localObject3).jdField_b_of_type_Int = j;
              }
              localObject3 = (ApolloBoxData.BoxCardListSummary)((ApolloBoxData)localObject2).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(7));
              if ((localObject3 != null) && (((ApolloBoxData.BoxCardListSummary)localObject3).jdField_b_of_type_Int == 0)) {
                ((ApolloBoxData.BoxCardListSummary)localObject3).jdField_b_of_type_Int = k;
              }
              localObject5 = ((JSONObject)localObject4).optJSONArray("tooklist");
              localObject4 = ((JSONObject)localObject4).optJSONArray("tookGiftList");
              long l4 = ((ApolloBoxData)localObject2).jdField_b_of_type_Long;
              if (l4 == 0L)
              {
                l4 = ((ApolloBoxData)localObject2).jdField_a_of_type_Long;
                if (l4 != -501031L)
                {
                  bool1 = false;
                  continue;
                }
              }
              bool1 = true;
              if (l2 == -501040L) {
                break label2376;
              }
              localObject6 = "uin";
              if (localObject5 != null)
              {
                try
                {
                  paramInt = ((JSONArray)localObject5).length();
                  if (paramInt <= 0) {
                    continue;
                  }
                  i = 0;
                  paramInt = -1;
                  localObject3 = paramBundle;
                  paramBundle = (Bundle)localObject2;
                  localObject2 = localObject6;
                  try
                  {
                    if (i < ((JSONArray)localObject5).length())
                    {
                      JSONObject localJSONObject = (JSONObject)((JSONArray)localObject5).get(i);
                      ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = new ApolloBoxData.ApolloBoxDataItem();
                      localApolloBoxDataItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
                      localApolloBoxDataItem.jdField_a_of_type_Long = localJSONObject.optLong((String)localObject2);
                      localApolloBoxDataItem.jdField_e_of_type_Long = localJSONObject.optLong("finishts");
                      localApolloBoxDataItem.jdField_d_of_type_Long = localJSONObject.optLong("redeemts");
                      localApolloBoxDataItem.jdField_a_of_type_Int = localJSONObject.optInt("id");
                      localApolloBoxDataItem.jdField_c_of_type_Long = localJSONObject.optLong("ts");
                      localApolloBoxDataItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("grade");
                      localApolloBoxDataItem.jdField_g_of_type_JavaLangString = localJSONObject.optString("gradeUrl");
                      localApolloBoxDataItem.jdField_c_of_type_JavaLangString = localJSONObject.optString(str1);
                      localApolloBoxDataItem.jdField_d_of_type_JavaLangString = localJSONObject.optString("head");
                      localApolloBoxDataItem.jdField_b_of_type_Int = localJSONObject.optInt("viplevel");
                      localApolloBoxDataItem.jdField_c_of_type_Int = localJSONObject.optInt("chiptotal");
                      localApolloBoxDataItem.jdField_d_of_type_Int = localJSONObject.optInt("minenum");
                      localApolloBoxDataItem.jdField_e_of_type_JavaLangString = localJSONObject.optString("picUrl");
                      localApolloBoxDataItem.jdField_f_of_type_JavaLangString = localJSONObject.optString("picDesc");
                      localApolloBoxDataItem.h = localJSONObject.optInt("isSquare");
                      localApolloBoxDataItem.jdField_f_of_type_Int = localJSONObject.optInt("giftNum", 1);
                      l2 = localApolloBoxDataItem.jdField_b_of_type_Long;
                      l4 = localApolloBoxDataItem.jdField_a_of_type_Long;
                      if (l2 == l4) {
                        try
                        {
                          if (TextUtils.isEmpty(localApolloBoxDataItem.jdField_c_of_type_JavaLangString)) {
                            localApolloBoxDataItem.jdField_c_of_type_JavaLangString = ((String)localObject1);
                          }
                        }
                        catch (Exception paramBundle)
                        {
                          continue;
                        }
                      }
                      boolean bool2 = TextUtils.isEmpty(localApolloBoxDataItem.jdField_c_of_type_JavaLangString);
                      if (bool2) {
                        localApolloBoxDataItem.jdField_c_of_type_JavaLangString = "TA";
                      }
                      localApolloBoxDataItem.jdField_a_of_type_Short = ((short)localJSONObject.optInt("type"));
                      localApolloBoxDataItem.jdField_b_of_type_Short = s;
                      localApolloBoxDataItem.jdField_b_of_type_Long = l3;
                      localApolloBoxDataItem.jdField_b_of_type_Boolean = bool1;
                      localApolloBoxDataItem.jdField_e_of_type_Int = ApolloUtilImpl.colorParse((String)localObject7);
                      localObject6 = this;
                      try
                      {
                        if ((TextUtils.isEmpty(((BoxCardHandler)localObject6).jdField_b_of_type_JavaLangString)) || (!((BoxCardHandler)localObject6).jdField_b_of_type_JavaLangString.equals(String.valueOf(localApolloBoxDataItem.jdField_a_of_type_Long))) || (localJSONObject.optInt("zanmark") != 0)) {
                          break label2348;
                        }
                        paramInt = 0;
                        localApolloBoxDataItem.jdField_g_of_type_Int = 0;
                        if (localJSONObject.has("layoutStyle")) {
                          localApolloBoxDataItem.jdField_g_of_type_Int = localJSONObject.optInt("layoutStyle");
                        }
                        localApolloBoxDataItem.jdField_a_of_type_Boolean = localApolloBoxDataItem.a(((BoxCardHandler)localObject6).jdField_b_of_type_JavaLangString);
                        if (localApolloBoxDataItem.jdField_a_of_type_Boolean) {
                          ((List)localObject3).add(0, localApolloBoxDataItem);
                        } else {
                          ((List)localObject3).add(localApolloBoxDataItem);
                        }
                        i += 1;
                      }
                      catch (Exception paramBundle)
                      {
                        continue;
                      }
                    }
                    localObject5 = localObject2;
                    localObject1 = localObject3;
                    localObject2 = localObject4;
                    localObject3 = localObject5;
                  }
                  catch (Exception paramBundle) {}
                }
                catch (Exception paramBundle) {}
                l2 = l1;
                break label2267;
              }
              str1 = "nick";
              localObject3 = "uin";
              localObject1 = paramBundle;
              paramInt = -1;
              paramBundle = (Bundle)localObject2;
              localObject2 = localObject4;
              localObject5 = this;
              i = paramInt;
              localObject4 = paramBundle;
              if (localObject2 != null)
              {
                i = paramInt;
                localObject4 = paramBundle;
              }
            }
            catch (Exception paramBundle) {}
          }
          catch (Exception paramBundle) {}
        }
        catch (Exception paramBundle) {}
      }
    }
    try
    {
      if (((JSONArray)localObject2).length() <= 0) {
        break label2369;
      }
      j = 0;
      i = paramInt;
      localObject4 = paramBundle;
      if (j >= ((JSONArray)localObject2).length()) {
        break label2369;
      }
      localObject4 = ((JSONArray)localObject2).getJSONObject(j);
      localObject6 = new ApolloBoxData.ApolloBoxDataItem();
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_a_of_type_Long = ((JSONObject)localObject4).optLong((String)localObject3);
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_c_of_type_Long = ((JSONObject)localObject4).optLong("ts");
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_a_of_type_Short = ((short)((JSONObject)localObject4).optInt("giftType"));
      i = ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_a_of_type_Short;
      if (i == 7) {}
      try
      {
        ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_g_of_type_Int = 2;
      }
      catch (Exception paramBundle) {}
      if (((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_a_of_type_Short != 15) {
        break label2351;
      }
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_g_of_type_Int = 3;
      if (((JSONObject)localObject4).has("layoutStyle")) {
        ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_g_of_type_Int = ((JSONObject)localObject4).optInt("layoutStyle");
      }
      localObject7 = (ApolloBoxData.BoxCardListSummary)paramBundle.jdField_a_of_type_JavaUtilHashMap.get(Short.valueOf(((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_a_of_type_Short));
      if ((localObject7 != null) && (!((ApolloBoxData.BoxCardListSummary)localObject7).jdField_a_of_type_Boolean)) {
        break label2360;
      }
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_f_of_type_Int = ((JSONObject)localObject4).optInt("giftNum");
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_c_of_type_JavaLangString = ((JSONObject)localObject4).optString(str1);
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_d_of_type_JavaLangString = ((JSONObject)localObject4).optString("head");
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("grade");
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_g_of_type_JavaLangString = ((JSONObject)localObject4).optString("gradeUrl");
      if (TextUtils.isEmpty(((BoxCardHandler)localObject5).jdField_b_of_type_JavaLangString)) {
        break label2354;
      }
      i = paramInt;
      if (((BoxCardHandler)localObject5).jdField_b_of_type_JavaLangString.equals(String.valueOf(((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_a_of_type_Long)))
      {
        i = paramInt;
        if (((JSONObject)localObject4).optInt("zanmark") == 0) {
          i = 0;
        }
      }
      ((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_a_of_type_Boolean = ((ApolloBoxData.ApolloBoxDataItem)localObject6).a(((BoxCardHandler)localObject5).jdField_b_of_type_JavaLangString);
      if (((ApolloBoxData.ApolloBoxDataItem)localObject6).jdField_a_of_type_Boolean)
      {
        ((List)localObject1).add(0, localObject6);
        paramInt = i;
      }
      else
      {
        ((List)localObject1).add(localObject6);
        paramInt = i;
      }
    }
    catch (Exception paramBundle)
    {
      break label2231;
    }
    ((ApolloBoxData)localObject4).jdField_a_of_type_Boolean = bool1;
    Collections.sort((List)localObject1);
    ((ApolloBoxData)localObject4).jdField_b_of_type_JavaUtilList = ((List)localObject1);
    ((ApolloBoxData)localObject4).a();
    if (paramBundle.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener != null)
    {
      paramBundle.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener.a("apollo_interact.take_chips", paramBoolean, l1, localObject4, str2);
      return;
      label2231:
      l2 = l1;
      break label2267;
      l2 = l1;
      label2267:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener;
      if (localObject1 != null) {
        ((BoxCardHandler.OnBoxCardHandlerListener)localObject1).a(str3, false, l2, null, str2);
      }
      if (QLog.isColorLevel())
      {
        QLog.e("[cmshow]BoxCardHandler", 2, paramBundle.getMessage());
        return;
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler$OnBoxCardHandlerListener;
        if (paramBundle != null) {
          paramBundle.a(str3, false, -9223372036854775808L, null, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.BoxCardHandler
 * JD-Core Version:    0.7.0.1
 */