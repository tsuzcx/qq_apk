package com.tencent.mobileqq.ark;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.List;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class ArkRecommendController
{
  public static int a;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
  public static int b;
  public static int c = 1;
  public static int d = 3;
  public static int e = 3;
  public static int f = 10;
  public static int g = 1;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ArkAiAppPanel jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel;
  protected WeakReference<QQAppInterface> a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Int = 5;
    jdField_b_of_type_Int = 3;
  }
  
  public ArkRecommendController(BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a);
    }
    ArkAppCenter.b(false);
  }
  
  public static boolean a(Node paramNode, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramNode == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        String str = paramNode.getNodeName();
        NodeList localNodeList = paramNode.getChildNodes();
        JSONObject localJSONObject = new JSONObject();
        int i = 0;
        int k;
        for (int j = 0;; j = k)
        {
          if (i < localNodeList.getLength())
          {
            Node localNode = localNodeList.item(i);
            if ((localNode instanceof Element))
            {
              a(localNode, localJSONObject);
              k = 1;
            }
            else
            {
              k = j;
              if ((localNode instanceof Text))
              {
                paramJSONObject.put(str, paramNode.getFirstChild().getNodeValue());
                k = j;
              }
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            paramJSONObject.put(str, localJSONObject);
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramNode) {}
    }
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a();
    }
    return null;
  }
  
  BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null)
    {
      if ((paramInt2 == 22) || (paramInt1 != 22)) {
        break label27;
      }
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a();
    }
    label27:
    while ((paramInt2 != 22) || (paramInt1 == 22)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.b();
  }
  
  public void a(List<ArkAiInfo> paramList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkRecommendController", 2, "showAppPanel.mChatPie is null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel == null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = new ArkAiAppPanel(a());
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a();
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a(paramList, paramInt, null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendController
 * JD-Core Version:    0.7.0.1
 */