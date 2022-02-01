import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.2.1;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.2.2;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class anoo
  extends anml
{
  public anoo(ApolloPanel paramApolloPanel) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "tab download Done");
    }
    amme localamme = (amme)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (localamme != null) {
      ApolloPanel.a(this.a, localamme);
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "action res done. action=" + paramApolloActionData.actionId);
    }
    this.a.b(paramApolloActionData);
    if (ApolloPanel.a(this.a) != null) {
      ApolloPanel.a(this.a).a(paramApolloActionData);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        do
        {
          return;
          localMqqHandler = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getHandler(ChatActivity.class);
        } while (localMqqHandler == null);
        localMqqHandler.post(new ApolloPanel.2.1(this));
        if (!paramBoolean.booleanValue()) {
          break;
        }
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin());
      } while (this.a.c == null);
      this.a.c.clear();
      this.a.d(this.a.a(ApolloPanel.jdField_a_of_type_Int));
      return;
    } while ((this.a.jdField_a_of_type_Anqe == null) || (this.a.jdField_a_of_type_Anqe.b != 3));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onJsonDone in panel fail refresh panel");
    }
    localMqqHandler.post(new ApolloPanel.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anoo
 * JD-Core Version:    0.7.0.1
 */