package com.tencent.mobileqq.ark;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
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
    }
    catch (Exception localException)
    {
      ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
      if (QLog.isColorLevel())
      {
        QLog.d("ArkAdapterItemForTextMsg", 2, "setSendClick parse ark app exception=" + localException);
        return;
        Object localObject1 = ArkAppCacheMgr.getApplicationFromManifest(localException.appName, localException.appMinVersion);
        if (localObject1 != null)
        {
          localException.appDesc = ((String)((Map)localObject1).get("desc"));
          localException.appMinVersion = ((String)((Map)localObject1).get("version"));
        }
        if (TextUtils.isEmpty(localException.appDesc)) {
          localException.appDesc = localException.appName;
        }
        localException.promptText = String.format(HardCodeUtil.a(2131700719), new Object[] { localException.appDesc });
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("forward", 1);
        ((JSONObject)localObject1).put("autosize", 1);
        ((JSONObject)localObject1).put("type", "card");
        localException.config = ((JSONObject)localObject1).toString();
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.mArkContainer.getViewShare();
        Object localObject2;
        int i;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
          localObject2 = ((Document)localObject1).getElementsByTagName("View").item(0);
          if ((localObject2 != null) && (((Node)localObject2).getChildNodes().getLength() > 0) && ((((Node)localObject2).getFirstChild() instanceof Text)))
          {
            localObject2 = ((Node)localObject2).getFirstChild().getNodeValue();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localException.appView = ((String)localObject2);
              if (!TextUtils.isEmpty(localException.appView))
              {
                localObject2 = ((Document)localObject1).getElementsByTagName("Metadata").item(0);
                if ((localObject2 != null) && (((Node)localObject2).getChildNodes().getLength() > 0))
                {
                  JSONObject localJSONObject = new JSONObject();
                  if (ArkRecommendController.a(((Node)localObject2).getFirstChild(), localJSONObject))
                  {
                    localException.metaList = localJSONObject.toString();
                    i = 1;
                    localObject1 = MessageForArkApp.getConfigFromXml((Document)localObject1);
                    j = i;
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      localException.config = ((String)localObject1);
                      j = i;
                      if (QLog.isColorLevel()) {
                        QLog.i("ArkApp", 2, "ArkAIAppMsfFlow send get shareView config:" + localException.config);
                      }
                    }
                  }
                }
              }
            }
          }
        }
        for (int j = i;; j = 0)
        {
          if (j == 0)
          {
            if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.appView)) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.meta)))
            {
              localException.appView = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.appView;
              localException.metaList = this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.meta;
            }
          }
          else
          {
            localObject1 = ((FragmentActivity)this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a).getChatFragment().a();
            if (localObject1 == null) {
              break label744;
            }
            localObject2 = ((BaseChatPie)localObject1).a();
            if ((localObject2 == null) || (((BaseChatPie)localObject1).a == null)) {
              break label744;
            }
            ChatActivityFacade.b(((BaseChatPie)localObject1).a, (SessionInfo)localObject2, localException);
            ArkAppDataReport.a(((BaseChatPie)localObject1).a, localException.appName, "AIOCardSendMessage", 0, 0, 0L, 0L, 0L, "", "");
            return;
          }
          ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
          return;
          label744:
          ArkAdapterItemForTextMsg.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg, this.a.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a);
          return;
          i = 0;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg.2.1
 * JD-Core Version:    0.7.0.1
 */