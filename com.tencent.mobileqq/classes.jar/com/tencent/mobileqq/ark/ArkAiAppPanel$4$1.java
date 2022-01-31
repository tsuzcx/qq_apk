package com.tencent.mobileqq.ark;

import acjm;
import afih;
import alud;
import android.text.TextUtils;
import anma;
import anmd;
import anoe;
import anpc;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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

public class ArkAiAppPanel$4$1
  implements Runnable
{
  public ArkAiAppPanel$4$1(anmd paramanmd, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((anma.a(this.jdField_a_of_type_Anmd.a) == null) || (anma.a(this.jdField_a_of_type_Anmd.a).size() <= 0) || (anma.a(this.jdField_a_of_type_Anmd.a) >= anma.a(this.jdField_a_of_type_Anmd.a).size())) {
        return;
      }
      if (anma.a(this.jdField_a_of_type_Anmd.a).get(anma.a(this.jdField_a_of_type_Anmd.a)) == null) {
        return;
      }
      localObject1 = ((afih)anma.a(this.jdField_a_of_type_Anmd.a).get(anma.a(this.jdField_a_of_type_Anmd.a))).getViewShare();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes()));
      localObject1 = ((Document)localObject2).getElementsByTagName("View").item(0);
      if ((localObject1 == null) || (((Node)localObject1).getChildNodes().getLength() <= 0) || (!(((Node)localObject1).getFirstChild() instanceof Text))) {
        return;
      }
      Object localObject3 = ((Node)localObject1).getFirstChild().getNodeValue();
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        return;
      }
      localObject1 = ((Document)localObject2).getElementsByTagName("Metadata").item(0);
      if ((localObject1 == null) || (((Node)localObject1).getChildNodes().getLength() <= 0)) {
        return;
      }
      localJSONObject = new JSONObject();
      if (!anpc.a(((Node)localObject1).getFirstChild(), localJSONObject)) {
        return;
      }
      localObject1 = new ArkAppMessage();
      ((ArkAppMessage)localObject1).appMinVersion = "0.0.0.1";
      ((ArkAppMessage)localObject1).appName = ((afih)anma.a(this.jdField_a_of_type_Anmd.a).get(anma.a(this.jdField_a_of_type_Anmd.a))).getAppName();
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
      ((ArkAppMessage)localObject1).promptText = String.format(alud.a(2131701024), new Object[] { ((ArkAppMessage)localObject1).appDesc });
      localObject2 = MessageForArkApp.getConfigFromXml((Document)localObject2);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label579;
      }
      ((ArkAppMessage)localObject1).config = ((String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 2, "ArkAIAppPanel send get shareView config:" + ((ArkAppMessage)localObject1).config);
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      JSONObject localJSONObject;
      while (QLog.isColorLevel())
      {
        QLog.i("ArkApp", 1, "ArkAIAppPanel send message parameter error: " + localException.getMessage());
        return;
        label579:
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp", 2, "ArkAIAppPanel send get shareView no config");
        }
        localException.metaList = localJSONObject.toString();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("forward", 1);
        ((JSONObject)localObject2).put("autosize", 1);
        ((JSONObject)localObject2).put("type", "card");
        localException.config = ((JSONObject)localObject2).toString();
      }
    }
    if (anma.a(this.jdField_a_of_type_Anmd.a) != null)
    {
      localObject2 = anma.a(this.jdField_a_of_type_Anmd.a).a();
      if (localObject2 != null) {
        acjm.b((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), (SessionInfo)localObject2, (ArkAppMessage)localObject1);
      }
    }
    anoe.a(null, this.jdField_a_of_type_JavaLangString, "AIOInputSendMessage", 0, 0, 0L, 0L, 0L, ((ArkAppMessage)localObject1).appName, "");
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.4.1
 * JD-Core Version:    0.7.0.1
 */