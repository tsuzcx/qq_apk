package com.tencent.mobileqq.activity.history.link;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopLinkHandler
  implements INetEngineListener
{
  private long jdField_a_of_type_Long = 0L;
  private final ChatHistoryTroopLinkFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment;
  @NonNull
  private TroopLinkCallBack jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkCallBack;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  
  public TroopLinkHandler(QQAppInterface paramQQAppInterface, ChatHistoryTroopLinkFragment paramChatHistoryTroopLinkFragment, @NonNull TroopLinkCallBack paramTroopLinkCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment = paramChatHistoryTroopLinkFragment;
    paramQQAppInterface = (NetEngineFactory)paramQQAppInterface.getManager(QQManagerFactory.MGR_NET_ENGINE);
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkCallBack = paramTroopLinkCallBack;
  }
  
  private ArrayList<TroopLinkElement> a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("url_list");
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      localArrayList.add(TroopLinkElement.mergeFromJson(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopLinkFragment.a(), localJSONObject));
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(NetResp paramNetResp)
  {
    try
    {
      paramNetResp = new JSONObject(new String(paramNetResp.mRespData));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resolveResponse: invoked.  json: ");
        localStringBuilder.append(paramNetResp);
        QLog.i("TroopLinkHandler", 2, localStringBuilder.toString());
      }
      a(true, a(paramNetResp));
      a(paramNetResp);
      return;
    }
    catch (Exception paramNetResp)
    {
      QLog.e("TroopLinkHandler", 1, "resolveResponse: failed. ", paramNetResp);
      a(false, new ArrayList());
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = "https://qun.qq.com/cgi-bin/groupchat_url_collect/get_url_collect";
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mCallback = this;
    String str = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    paramString = String.format("bkn=%s&gc=%s&seq=%s&n=%s&noui=1", new Object[] { Integer.valueOf(TroopUtils.a(str)), paramString, Long.valueOf(paramLong), Integer.valueOf(200) });
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("send: invoked.  postData: ");
      localStringBuilder.append(paramString);
      QLog.i("TroopLinkHandler", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localHttpNetReq.mSendData = paramString.getBytes();
    localHttpNetReq.mReqProperties = new HashMap();
    localHttpNetReq.mReqProperties.put("Cookie", str);
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq(localHttpNetReq);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Long = paramJSONObject.optLong("seq");
    long l = paramJSONObject.optLong("n_all", -1L);
    if ((this.jdField_a_of_type_Long == 0L) || (l == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkCallBack.r();
    }
  }
  
  @UiThread
  private void a(boolean paramBoolean, @NonNull List<TroopLinkElement> paramList)
  {
    paramList = new TroopLinkHandler.1(this, paramBoolean, paramList);
    ThreadManager.getUIHandler().post(paramList);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramString, this.jdField_a_of_type_Long);
      return;
    }
    a(paramString, 0L);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mHttpCode == 200)
    {
      a(paramNetResp);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResp: invoked.  resp: ");
      localStringBuilder.append(paramNetResp);
      QLog.i("TroopLinkHandler", 2, localStringBuilder.toString());
    }
    a(false, new ArrayList());
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.TroopLinkHandler
 * JD-Core Version:    0.7.0.1
 */