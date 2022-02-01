import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class anrb
  extends bhzs
{
  public anrb(ApolloLinearLayout paramApolloLinearLayout) {}
  
  protected void onAuthResponse(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    label596:
    for (;;)
    {
      return;
      Object localObject = new ApolloActionData();
      paramObject = (HashMap)paramObject;
      String str = (String)paramObject.get("optFrom");
      if ((!TextUtils.isEmpty(str)) && ("actionPanel".equals(str)))
      {
        int i = Integer.parseInt((String)paramObject.get("id"));
        ((ApolloActionData)localObject).actionId = i;
        localObject = this.a.a((ApolloActionData)localObject);
        if (localObject != null)
        {
          ((ImageView)((View)localObject).findViewById(2131378932)).setVisibility(8);
          ((View)localObject).setClickable(true);
          if (this.a.b.incrementAndGet() == this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
          {
            this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            this.a.b.set(0);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_Bhzs);
          }
          if (paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloLinearLayout", 2, "action auth success actionid=" + i);
            }
            paramObject.put("APOLLO_POP_TYPE", "toast");
            paramObject.put("tips", this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690014));
            ((VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "obtained action");
          }
          for (;;)
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
              break label596;
            }
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
            if (localObject == null) {
              break;
            }
            VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_show", ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + i, "0" });
            localObject = ((MqqHandler)localObject).obtainMessage(45);
            ((Message)localObject).obj = paramObject;
            ((Message)localObject).sendToTarget();
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloLinearLayout", 2, "action auth fail actionid=" + i);
            }
            paramObject.put("APOLLO_POP_TYPE", "dialog");
            paramObject.put("feeType", String.valueOf(6));
            paramObject.put("title", anzj.a(2131699375));
            if (TextUtils.isEmpty((String)paramObject.get("content"))) {
              paramObject.put("content", anzj.a(2131699374));
            }
            paramObject.put("rightString", anzj.a(2131699376));
            paramObject.put("isActionBack", "true");
            paramObject.put("actionId", "" + i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrb
 * JD-Core Version:    0.7.0.1
 */