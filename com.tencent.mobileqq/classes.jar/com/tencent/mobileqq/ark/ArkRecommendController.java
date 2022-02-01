package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
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
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private ArkAiAppPanel jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel;
  protected WeakReference<QQAppInterface> a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Int = 5;
    jdField_b_of_type_Int = 3;
  }
  
  public ArkRecommendController(AIOContext paramAIOContext)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    if (paramAIOContext != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAIOContext.a());
    }
    ArkMultiProcUtil.a();
  }
  
  public static boolean a(Node paramNode, JSONObject paramJSONObject)
  {
    if (paramNode == null) {
      return false;
    }
    for (;;)
    {
      int i;
      int k;
      try
      {
        String str = paramNode.getNodeName();
        NodeList localNodeList = paramNode.getChildNodes();
        JSONObject localJSONObject = new JSONObject();
        i = 0;
        j = 0;
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
          if (j != 0) {
            paramJSONObject.put(str, localJSONObject);
          }
          return true;
        }
      }
      catch (Exception paramNode)
      {
        return false;
      }
      i += 1;
      int j = k;
    }
  }
  
  public ArkAppRootLayout a()
  {
    ArkAiAppPanel localArkAiAppPanel = this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel;
    if (localArkAiAppPanel != null) {
      return localArkAiAppPanel.a();
    }
    return null;
  }
  
  public void a()
  {
    ArkAiAppPanel localArkAiAppPanel = this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel;
    if (localArkAiAppPanel != null) {
      localArkAiAppPanel.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ArkAiAppPanel localArkAiAppPanel = this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel;
    if (localArkAiAppPanel != null)
    {
      if ((paramInt2 != 22) && (paramInt1 == 22))
      {
        localArkAiAppPanel.a();
        return;
      }
      if ((paramInt2 == 22) && (paramInt1 != 22)) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.b();
      }
    }
  }
  
  public void a(List<ArkAiInfo> paramList, int paramInt)
  {
    AIOContext localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    if (localAIOContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkRecommendController", 2, "showAppPanel.aioContext is null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel == null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = new ArkAiAppPanel(localAIOContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a();
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.a(paramList, paramInt, null);
  }
  
  public void b()
  {
    ArkAiAppPanel localArkAiAppPanel = this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel;
    if (localArkAiAppPanel != null)
    {
      localArkAiAppPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = null;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendController
 * JD-Core Version:    0.7.0.1
 */