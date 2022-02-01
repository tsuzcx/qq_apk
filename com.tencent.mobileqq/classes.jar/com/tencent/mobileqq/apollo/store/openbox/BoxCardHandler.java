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
  private BoxCardHandler.OnBoxCardHandlerListener a;
  private String b;
  private String c;
  private LRULinkedHashMap<String, String> d;
  
  public BoxCardHandler(BoxCardHandler.OnBoxCardHandlerListener paramOnBoxCardHandlerListener)
  {
    this.a = paramOnBoxCardHandlerListener;
    this.d = new LRULinkedHashMap(32);
  }
  
  private int a(List<ApolloBoxData.ApolloBoxDataItem> paramList, JSONArray paramJSONArray, int paramInt, ApolloBoxData paramApolloBoxData)
  {
    int i = paramInt;
    if (paramJSONArray != null)
    {
      i = paramInt;
      if (paramJSONArray.length() > 0)
      {
        int j = 0;
        while (j < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
          ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = new ApolloBoxData.ApolloBoxDataItem();
          localApolloBoxDataItem.a = localJSONObject.optLong("uin");
          localApolloBoxDataItem.e = localJSONObject.optLong("ts");
          localApolloBoxDataItem.f = ((short)localJSONObject.optInt("giftType"));
          if (localApolloBoxDataItem.f == 7) {
            localApolloBoxDataItem.t = 2;
          } else if (localApolloBoxDataItem.f == 15) {
            localApolloBoxDataItem.t = 3;
          }
          if (localJSONObject.has("layoutStyle")) {
            localApolloBoxDataItem.t = localJSONObject.optInt("layoutStyle");
          }
          ApolloBoxData.BoxCardListSummary localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)paramApolloBoxData.l.get(Short.valueOf(localApolloBoxDataItem.f));
          if ((localBoxCardListSummary == null) || (localBoxCardListSummary.a))
          {
            localApolloBoxDataItem.s = localJSONObject.optInt("giftNum");
            localApolloBoxDataItem.j = localJSONObject.optString("nick");
            localApolloBoxDataItem.l = localJSONObject.optString("head");
            localApolloBoxDataItem.i = localJSONObject.optString("grade");
            localApolloBoxDataItem.w = localJSONObject.optString("gradeUrl");
            i = paramInt;
            if (!TextUtils.isEmpty(this.c))
            {
              i = paramInt;
              if (this.c.equals(String.valueOf(localApolloBoxDataItem.a)))
              {
                i = paramInt;
                if (localJSONObject.optInt("zanmark") == 0) {
                  i = 0;
                }
              }
            }
            localApolloBoxDataItem.c = localApolloBoxDataItem.a(this.c);
            if (localApolloBoxDataItem.c)
            {
              paramList.add(0, localApolloBoxDataItem);
              paramInt = i;
            }
            else
            {
              paramList.add(localApolloBoxDataItem);
              paramInt = i;
            }
          }
          j += 1;
        }
        i = paramInt;
      }
    }
    return i;
  }
  
  private int a(List<ApolloBoxData.ApolloBoxDataItem> paramList, JSONArray paramJSONArray, String paramString1, short paramShort, long paramLong, boolean paramBoolean, String paramString2)
  {
    int j = -1;
    int i = j;
    if (paramJSONArray != null)
    {
      i = j;
      if (paramJSONArray.length() > 0)
      {
        j = 0;
        int k;
        for (i = -1; j < paramJSONArray.length(); i = k)
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(j);
          ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = new ApolloBoxData.ApolloBoxDataItem();
          localApolloBoxDataItem.h = localJSONObject.optString("name");
          localApolloBoxDataItem.a = localJSONObject.optLong("uin");
          localApolloBoxDataItem.r = localJSONObject.optLong("finishts");
          localApolloBoxDataItem.q = localJSONObject.optLong("redeemts");
          localApolloBoxDataItem.g = localJSONObject.optInt("id");
          localApolloBoxDataItem.e = localJSONObject.optLong("ts");
          localApolloBoxDataItem.i = localJSONObject.optString("grade");
          localApolloBoxDataItem.w = localJSONObject.optString("gradeUrl");
          localApolloBoxDataItem.j = localJSONObject.optString("nick");
          localApolloBoxDataItem.l = localJSONObject.optString("head");
          localApolloBoxDataItem.m = localJSONObject.optInt("viplevel");
          localApolloBoxDataItem.n = localJSONObject.optInt("chiptotal");
          localApolloBoxDataItem.o = localJSONObject.optInt("minenum");
          localApolloBoxDataItem.u = localJSONObject.optString("picUrl");
          localApolloBoxDataItem.v = localJSONObject.optString("picDesc");
          localApolloBoxDataItem.x = localJSONObject.optInt("isSquare");
          localApolloBoxDataItem.s = localJSONObject.optInt("giftNum", 1);
          if ((localApolloBoxDataItem.b == localApolloBoxDataItem.a) && (TextUtils.isEmpty(localApolloBoxDataItem.j))) {
            localApolloBoxDataItem.j = paramString1;
          }
          if (TextUtils.isEmpty(localApolloBoxDataItem.j)) {
            localApolloBoxDataItem.j = "TA";
          }
          localApolloBoxDataItem.f = ((short)localJSONObject.optInt("type"));
          localApolloBoxDataItem.k = paramShort;
          localApolloBoxDataItem.b = paramLong;
          localApolloBoxDataItem.d = paramBoolean;
          localApolloBoxDataItem.p = ApolloUtilImpl.colorParse(paramString2);
          k = i;
          if (!TextUtils.isEmpty(this.c))
          {
            k = i;
            if (this.c.equals(String.valueOf(localApolloBoxDataItem.a)))
            {
              k = i;
              if (localJSONObject.optInt("zanmark") == 0) {
                k = 0;
              }
            }
          }
          localApolloBoxDataItem.t = 0;
          if (localJSONObject.has("layoutStyle")) {
            localApolloBoxDataItem.t = localJSONObject.optInt("layoutStyle");
          }
          localApolloBoxDataItem.c = localApolloBoxDataItem.a(this.c);
          if (localApolloBoxDataItem.c) {
            paramList.add(0, localApolloBoxDataItem);
          } else {
            paramList.add(localApolloBoxDataItem);
          }
          j += 1;
        }
      }
    }
    return i;
  }
  
  private void a(long paramLong, String paramString)
  {
    BoxCardHandler.OnBoxCardHandlerListener localOnBoxCardHandlerListener = this.a;
    if (localOnBoxCardHandlerListener != null) {
      localOnBoxCardHandlerListener.a("apollo_interact.thank_zan", true, paramLong, null, paramString);
    }
  }
  
  private void a(ApolloBoxData paramApolloBoxData, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          ApolloBoxData.BoxCardListSummary localBoxCardListSummary = new ApolloBoxData.BoxCardListSummary();
          localBoxCardListSummary.b = localJSONObject.optInt("giftType");
          localBoxCardListSummary.c = localJSONObject.optInt("giftTotal");
          localBoxCardListSummary.e = localJSONObject.optString("iconUrl");
          localBoxCardListSummary.f = localJSONObject.optString("jumpUrl");
          int k = localJSONObject.optInt("isShow");
          boolean bool = true;
          if (k != 1) {
            bool = false;
          }
          localBoxCardListSummary.a = bool;
          if (localBoxCardListSummary.a)
          {
            paramApolloBoxData.l.put(Integer.valueOf(localBoxCardListSummary.b), localBoxCardListSummary);
            paramApolloBoxData.m.add(localBoxCardListSummary);
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(WebSSOAgent.UniSsoServerRsp paramUniSsoServerRsp, long paramLong, String paramString)
  {
    paramUniSsoServerRsp = paramUniSsoServerRsp.rspdata.get();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get Url onReceive retCode->");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" respStr->");
      ((StringBuilder)localObject).append(paramUniSsoServerRsp);
      QLog.d("[cmshow]BoxCardHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramUniSsoServerRsp = new JSONObject(paramUniSsoServerRsp).optJSONObject("data").optString("qq_head");
    if (!TextUtils.isEmpty(paramUniSsoServerRsp)) {
      this.d.put(paramString, paramUniSsoServerRsp);
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((BoxCardHandler.OnBoxCardHandlerListener)localObject).a("apollo_core.get_user_info_v2", true, 0L, paramUniSsoServerRsp, paramString);
    }
  }
  
  private void b(WebSSOAgent.UniSsoServerRsp paramUniSsoServerRsp, long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(this.b)) && (!this.b.equals(paramString))) {
      return;
    }
    if (paramLong == -501028L)
    {
      paramUniSsoServerRsp = this.a;
      if (paramUniSsoServerRsp != null) {
        paramUniSsoServerRsp.a("apollo_interact.take_chips", true, paramLong, null, paramString);
      }
      return;
    }
    paramUniSsoServerRsp = paramUniSsoServerRsp.rspdata.get();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive retCode->");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" respStr->");
      ((StringBuilder)localObject1).append(paramUniSsoServerRsp);
      QLog.d("[cmshow]BoxCardHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new JSONObject(paramUniSsoServerRsp).optJSONObject("data");
    ((JSONObject)localObject2).optLong("checkpoint");
    long l = ((JSONObject)localObject2).optLong("master");
    short s = (short)((JSONObject)localObject2).optInt("chipnum");
    int i = ((JSONObject)localObject2).optInt("mine_chipnum");
    int j = ((JSONObject)localObject2).optInt("goldNum");
    String str = ((JSONObject)localObject2).optString("card_mask_color");
    Object localObject1 = ((JSONObject)localObject2).optString("nick");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramUniSsoServerRsp = "TA";
    }
    else
    {
      paramUniSsoServerRsp = (WebSSOAgent.UniSsoServerRsp)localObject1;
      if (CharacterUtil.a((String)localObject1) > 20)
      {
        paramUniSsoServerRsp = CharacterUtil.a((String)localObject1, 0, 20);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramUniSsoServerRsp);
        ((StringBuilder)localObject1).append("...");
        paramUniSsoServerRsp = ((StringBuilder)localObject1).toString();
      }
    }
    localObject1 = new ApolloBoxData();
    ((ApolloBoxData)localObject1).d = paramUniSsoServerRsp;
    ((ApolloBoxData)localObject1).f = ((JSONObject)localObject2).optLong("firstcode");
    ArrayList localArrayList = new ArrayList(4);
    ((ApolloBoxData)localObject1).b = paramString;
    ((ApolloBoxData)localObject1).g = ((JSONObject)localObject2).optLong("chestid");
    ((ApolloBoxData)localObject1).a = this.c;
    ((ApolloBoxData)localObject1).e = paramLong;
    ((ApolloBoxData)localObject1).j = ApolloUtilImpl.colorParse(((JSONObject)localObject2).optString("back_color"));
    ((ApolloBoxData)localObject1).h = ((JSONObject)localObject2).optString("topUrl");
    ((ApolloBoxData)localObject1).i = ((JSONObject)localObject2).optString("bottomUrl");
    a((ApolloBoxData)localObject1, ((JSONObject)localObject2).optJSONArray("giftTotalList"));
    Object localObject3 = (ApolloBoxData.BoxCardListSummary)((ApolloBoxData)localObject1).l.get(Integer.valueOf(3));
    if ((localObject3 != null) && (((ApolloBoxData.BoxCardListSummary)localObject3).c == 0)) {
      ((ApolloBoxData.BoxCardListSummary)localObject3).c = i;
    }
    localObject3 = (ApolloBoxData.BoxCardListSummary)((ApolloBoxData)localObject1).l.get(Integer.valueOf(7));
    if ((localObject3 != null) && (((ApolloBoxData.BoxCardListSummary)localObject3).c == 0)) {
      ((ApolloBoxData.BoxCardListSummary)localObject3).c = j;
    }
    localObject3 = ((JSONObject)localObject2).optJSONArray("tooklist");
    localObject2 = ((JSONObject)localObject2).optJSONArray("tookGiftList");
    boolean bool;
    if ((((ApolloBoxData)localObject1).f == 0L) && (((ApolloBoxData)localObject1).e != -501031L)) {
      bool = false;
    } else {
      bool = true;
    }
    if (paramLong != -501040L) {
      i = a(localArrayList, (JSONArray)localObject2, a(localArrayList, (JSONArray)localObject3, paramUniSsoServerRsp, s, l, bool, str), (ApolloBoxData)localObject1);
    } else {
      i = -1;
    }
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ApolloBoxData)localObject1).c = bool;
    Collections.sort(localArrayList);
    ((ApolloBoxData)localObject1).n = localArrayList;
    ((ApolloBoxData)localObject1).a();
    paramUniSsoServerRsp = this.a;
    if (paramUniSsoServerRsp != null) {
      paramUniSsoServerRsp.a("apollo_interact.take_chips", true, paramLong, localObject1, paramString);
    }
  }
  
  public void a()
  {
    this.a = null;
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
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
      this.b = paramString1;
      this.c = paramAppInterface.getCurrentAccountUin();
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
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
        ((JSONObject)localObject).put("skey", ((TicketManager)paramAppInterface.getManager(2)).getSkey(this.c));
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
    if (paramBundle == null) {
      return;
    }
    int i = paramBundle.getInt("extra_result_code");
    String str1 = paramBundle.getString("extra_callbackid");
    String str2 = paramBundle.getString("extra_cmd");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OpenPandora onReceive type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", svrRet: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", uin:");
      ((StringBuilder)localObject).append(str1);
      QLog.d("[cmshow]BoxCardHandler", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = -9223372036854775808L;
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        localObject = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramBundle);
        long l2 = ((WebSSOAgent.UniSsoServerRsp)localObject).ret.get();
        try
        {
          if ("apollo_interact.thank_zan".equals(str2))
          {
            a(l2, str1);
            return;
          }
          if ("apollo_core.get_user_info_v2".equals(str2))
          {
            a((WebSSOAgent.UniSsoServerRsp)localObject, l2, str1);
            return;
          }
          if (!"apollo_interact.take_chips".equals(str2)) {
            return;
          }
          b((WebSSOAgent.UniSsoServerRsp)localObject, l2, str1);
          return;
        }
        catch (Exception paramBundle)
        {
          l1 = l2;
        }
        localObject = this.a;
      }
      catch (Exception paramBundle) {}
      if (localObject != null) {
        ((BoxCardHandler.OnBoxCardHandlerListener)localObject).a(str2, false, l1, null, str1);
      }
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]BoxCardHandler", 2, paramBundle.getMessage());
      }
    }
    else
    {
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.a(str2, false, -9223372036854775808L, null, str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.BoxCardHandler
 * JD-Core Version:    0.7.0.1
 */