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
  public static int a = 5;
  public static int b = 3;
  public static int c = 1;
  public static int d = 3;
  public static int e = 3;
  public static int f = 10;
  public static int g = 1;
  private static final SimpleDateFormat i = new SimpleDateFormat("yyyyMMdd");
  protected WeakReference<QQAppInterface> h;
  private AIOContext j;
  private ArkAiAppPanel k;
  private boolean l = false;
  private boolean m = false;
  
  public ArkRecommendController(AIOContext paramAIOContext)
  {
    this.j = paramAIOContext;
    if (paramAIOContext != null) {
      this.h = new WeakReference(paramAIOContext.a());
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
      int n;
      int i2;
      try
      {
        String str = paramNode.getNodeName();
        NodeList localNodeList = paramNode.getChildNodes();
        JSONObject localJSONObject = new JSONObject();
        n = 0;
        i1 = 0;
        if (n < localNodeList.getLength())
        {
          Node localNode = localNodeList.item(n);
          if ((localNode instanceof Element))
          {
            a(localNode, localJSONObject);
            i2 = 1;
          }
          else
          {
            i2 = i1;
            if ((localNode instanceof Text))
            {
              paramJSONObject.put(str, paramNode.getFirstChild().getNodeValue());
              i2 = i1;
            }
          }
        }
        else
        {
          if (i1 != 0) {
            paramJSONObject.put(str, localJSONObject);
          }
          return true;
        }
      }
      catch (Exception paramNode)
      {
        return false;
      }
      n += 1;
      int i1 = i2;
    }
  }
  
  public void a()
  {
    ArkAiAppPanel localArkAiAppPanel = this.k;
    if (localArkAiAppPanel != null) {
      localArkAiAppPanel.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ArkAiAppPanel localArkAiAppPanel = this.k;
    if (localArkAiAppPanel != null)
    {
      if ((paramInt2 != 22) && (paramInt1 == 22))
      {
        localArkAiAppPanel.b();
        return;
      }
      if ((paramInt2 == 22) && (paramInt1 != 22)) {
        this.k.c();
      }
    }
  }
  
  public void a(List<ArkAiInfo> paramList, int paramInt)
  {
    AIOContext localAIOContext = this.j;
    if (localAIOContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkRecommendController", 2, "showAppPanel.aioContext is null");
      }
      return;
    }
    if (this.k == null) {
      this.k = new ArkAiAppPanel(localAIOContext);
    }
    this.k.a();
    this.k.a(paramList, paramInt, null);
  }
  
  public void b()
  {
    ArkAiAppPanel localArkAiAppPanel = this.k;
    if (localArkAiAppPanel != null)
    {
      localArkAiAppPanel.d();
      this.k = null;
    }
    this.j = null;
  }
  
  public void c()
  {
    this.m = true;
  }
  
  public ArkAppRootLayout d()
  {
    ArkAiAppPanel localArkAiAppPanel = this.k;
    if (localArkAiAppPanel != null) {
      return localArkAiAppPanel.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendController
 * JD-Core Version:    0.7.0.1
 */