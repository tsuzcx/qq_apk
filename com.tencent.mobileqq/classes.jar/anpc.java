import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.List;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class anpc
{
  public static int a;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
  public static int b = 3;
  public static int c = 1;
  public static int d = 3;
  public static int e = 3;
  public static int f = 10;
  public static int g = 1;
  private anma jdField_a_of_type_Anma;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  protected WeakReference<QQAppInterface> a;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 5;
  }
  
  public anpc(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
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
    if (this.jdField_a_of_type_Anma != null) {
      return this.jdField_a_of_type_Anma.a();
    }
    return null;
  }
  
  BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anma != null) {
      this.jdField_a_of_type_Anma.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Anma != null)
    {
      if ((paramInt2 == 22) || (paramInt1 != 22)) {
        break label27;
      }
      this.jdField_a_of_type_Anma.a();
    }
    label27:
    while ((paramInt2 != 22) || (paramInt1 == 22)) {
      return;
    }
    this.jdField_a_of_type_Anma.b();
  }
  
  public void a(List<annb> paramList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkRecommendController", 2, "showAppPanel.mChatPie is null");
      }
      return;
    }
    if (this.jdField_a_of_type_Anma == null) {
      this.jdField_a_of_type_Anma = new anma(a());
    }
    this.jdField_a_of_type_Anma.a();
    this.jdField_a_of_type_Anma.a(paramList, paramInt, null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anma != null)
    {
      this.jdField_a_of_type_Anma.c();
      this.jdField_a_of_type_Anma = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpc
 * JD-Core Version:    0.7.0.1
 */