package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

class ArkAiAppPanel$4$1
  implements Runnable
{
  ArkAiAppPanel$4$1(ArkAiAppPanel.4 param4, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((ArkAiAppPanel.d(this.b.a) != null) && (ArkAiAppPanel.d(this.b.a).size() > 0) && (ArkAiAppPanel.c(this.b.a) < ArkAiAppPanel.d(this.b.a).size()))
      {
        if (ArkAiAppPanel.d(this.b.a).get(ArkAiAppPanel.c(this.b.a)) == null) {
          return;
        }
        Object localObject1 = ((ArkAioContainerWrapper)ArkAiAppPanel.d(this.b.a).get(ArkAiAppPanel.c(this.b.a))).getViewShare();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
        localObject1 = ((Document)localObject2).getElementsByTagName("View").item(0);
        if ((localObject1 != null) && (((Node)localObject1).getChildNodes().getLength() > 0))
        {
          if (!(((Node)localObject1).getFirstChild() instanceof Text)) {
            return;
          }
          Object localObject3 = ((Node)localObject1).getFirstChild().getNodeValue();
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            return;
          }
          localObject1 = ((Document)localObject2).getElementsByTagName("Metadata").item(0);
          if (localObject1 != null)
          {
            if (((Node)localObject1).getChildNodes().getLength() <= 0) {
              return;
            }
            JSONObject localJSONObject = new JSONObject();
            if (!ArkRecommendController.a(((Node)localObject1).getFirstChild(), localJSONObject)) {
              return;
            }
            localObject1 = new ArkAppMessage();
            ((ArkAppMessage)localObject1).appMinVersion = "0.0.0.1";
            ((ArkAppMessage)localObject1).appName = ((ArkAioContainerWrapper)ArkAiAppPanel.d(this.b.a).get(ArkAiAppPanel.c(this.b.a))).getAppName();
            if (TextUtils.isEmpty(((ArkAppMessage)localObject1).appName)) {
              return;
            }
            ((ArkAppMessage)localObject1).appView = ((String)localObject3);
            if (TextUtils.isEmpty(((ArkAppMessage)localObject1).appView)) {
              return;
            }
            localObject3 = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject1).appName, ((ArkAppMessage)localObject1).appMinVersion);
            if (localObject3 != null)
            {
              ((ArkAppMessage)localObject1).appDesc = ((String)((Map)localObject3).get("desc"));
              ((ArkAppMessage)localObject1).appMinVersion = ((String)((Map)localObject3).get("version"));
            }
            if (TextUtils.isEmpty(((ArkAppMessage)localObject1).appDesc)) {
              ((ArkAppMessage)localObject1).appDesc = ((ArkAppMessage)localObject1).appName;
            }
            ((ArkAppMessage)localObject1).promptText = String.format(HardCodeUtil.a(2131898888), new Object[] { ((ArkAppMessage)localObject1).appDesc });
            localObject2 = MessageForArkApp.getConfigFromXml((Document)localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              ((ArkAppMessage)localObject1).config = ((String)localObject2);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("ArkAIAppPanel send get shareView config:");
                ((StringBuilder)localObject2).append(((ArkAppMessage)localObject1).config);
                QLog.i("ArkApp", 2, ((StringBuilder)localObject2).toString());
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.i("ArkApp", 2, "ArkAIAppPanel send get shareView no config");
              }
              ((ArkAppMessage)localObject1).metaList = localJSONObject.toString();
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("forward", 1);
              ((JSONObject)localObject2).put("autosize", 1);
              ((JSONObject)localObject2).put("type", "card");
              ((ArkAppMessage)localObject1).config = ((JSONObject)localObject2).toString();
            }
            if (ArkAiAppPanel.a(this.b.a) != null)
            {
              localObject2 = (SessionInfo)ArkAiAppPanel.a(this.b.a).O();
              if (localObject2 != null) {
                ChatActivityFacade.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject2, (ArkAppMessage)localObject1);
              }
            }
            ArkAppDataReport.a(null, this.a, "AIOInputSendMessage", 0, 0, 0L, 0L, 0L, ((ArkAppMessage)localObject1).appName, "");
            return;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ArkAIAppPanel send message parameter error: ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.i("ArkApp", 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.4.1
 * JD-Core Version:    0.7.0.1
 */