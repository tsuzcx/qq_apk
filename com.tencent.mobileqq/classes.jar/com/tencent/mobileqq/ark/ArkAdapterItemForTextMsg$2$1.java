package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

class ArkAdapterItemForTextMsg$2$1
  implements Runnable
{
  ArkAdapterItemForTextMsg$2$1(ArkAdapterItemForTextMsg.2 param2) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.mArkContainer == null)
      {
        ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
        return;
      }
      ArkAppMessage localArkAppMessage = new ArkAppMessage();
      localArkAppMessage.appMinVersion = "0.0.0.1";
      localArkAppMessage.appName = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.mArkContainer.getAppName();
      if (TextUtils.isEmpty(localArkAppMessage.appName))
      {
        ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
        return;
      }
      localObject1 = ArkAppCacheMgr.getApplicationFromManifest(localArkAppMessage.appName, localArkAppMessage.appMinVersion);
      if (localObject1 != null)
      {
        localArkAppMessage.appDesc = ((String)((Map)localObject1).get("desc"));
        localArkAppMessage.appMinVersion = ((String)((Map)localObject1).get("version"));
      }
      if (TextUtils.isEmpty(localArkAppMessage.appDesc)) {
        localArkAppMessage.appDesc = localArkAppMessage.appName;
      }
      localObject1 = HardCodeUtil.a(2131700863);
      Object localObject2 = localArkAppMessage.appDesc;
      int j = 0;
      int k = 0;
      localArkAppMessage.promptText = String.format((String)localObject1, new Object[] { localObject2 });
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("forward", 1);
      ((JSONObject)localObject1).put("autosize", 1);
      ((JSONObject)localObject1).put("type", "card");
      localArkAppMessage.config = ((JSONObject)localObject1).toString();
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.mArkContainer.getViewShare();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
        localObject2 = ((Document)localObject1).getElementsByTagName("View").item(0);
        int i = k;
        if (localObject2 != null)
        {
          i = k;
          if (((Node)localObject2).getChildNodes().getLength() > 0)
          {
            i = k;
            if ((((Node)localObject2).getFirstChild() instanceof Text))
            {
              localObject2 = ((Node)localObject2).getFirstChild().getNodeValue();
              i = k;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localArkAppMessage.appView = ((String)localObject2);
                i = k;
                if (!TextUtils.isEmpty(localArkAppMessage.appView))
                {
                  localObject2 = ((Document)localObject1).getElementsByTagName("Metadata").item(0);
                  i = k;
                  if (localObject2 != null)
                  {
                    i = k;
                    if (((Node)localObject2).getChildNodes().getLength() > 0)
                    {
                      JSONObject localJSONObject = new JSONObject();
                      i = k;
                      if (ArkRecommendController.a(((Node)localObject2).getFirstChild(), localJSONObject))
                      {
                        localArkAppMessage.metaList = localJSONObject.toString();
                        i = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        localObject1 = MessageForArkApp.getConfigFromXml((Document)localObject1);
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localArkAppMessage.config = ((String)localObject1);
          j = i;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ArkAIAppMsfFlow send get shareView config:");
            ((StringBuilder)localObject1).append(localArkAppMessage.config);
            QLog.i("ArkApp", 2, ((StringBuilder)localObject1).toString());
            j = i;
          }
        }
      }
      if (j == 0) {
        if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.appView)) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.meta)))
        {
          localArkAppMessage.appView = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.appView;
          localArkAppMessage.metaList = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.meta;
        }
        else
        {
          ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
          return;
        }
      }
      localObject1 = ((BaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a).getChatFragment().a();
      if (localObject1 != null)
      {
        localObject2 = ((BaseChatPie)localObject1).a();
        if ((localObject2 != null) && (((BaseChatPie)localObject1).a != null))
        {
          ChatActivityFacade.b(((BaseChatPie)localObject1).a, (SessionInfo)localObject2, localArkAppMessage);
          ArkAppDataReport.a(((BaseChatPie)localObject1).a, localArkAppMessage.appName, "AIOCardSendMessage", 0, 0, 0L, 0L, 0L, "", "");
          return;
        }
      }
      ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setSendClick parse ark app exception=");
        ((StringBuilder)localObject1).append(localException);
        QLog.d("ArkAdapterItemForTextMsg", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg.2.1
 * JD-Core Version:    0.7.0.1
 */