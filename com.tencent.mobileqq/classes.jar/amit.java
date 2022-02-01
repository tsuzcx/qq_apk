import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloResponseManager.1.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class amit
  implements View.OnClickListener
{
  amit(amis paramamis) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localBaseChatPie != null)
      {
        Object localObject1 = paramView.getTag(2131362770);
        Object localObject2 = paramView.getTag(2131362771);
        if ((localObject1 != null) && (localObject2 != null))
        {
          int i = ((Integer)localObject1).intValue();
          int j = ((Integer)localObject2).intValue();
          Object localObject3 = ((ancd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(i);
          if (localObject3 == null)
          {
            QLog.e("ApolloResponseManager", 1, "on click action is null!");
          }
          else
          {
            VipUtils.a(null, "cmshow", "Apollo", "quickresponseclick", String.valueOf(this.a.jdField_a_of_type_JavaLangString), ApolloUtil.b(this.a.jdField_a_of_type_Int), j, new String[] { String.valueOf(i), String.valueOf(((ApolloActionData)localObject3).feeType) });
            if (!ApolloUtil.a(((ApolloActionData)localObject3).actionId, ((ApolloActionData)localObject3).personNum))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResponseManager", 2, "download action data");
              }
              ThreadManager.post(new ApolloResponseManager.1.1(this, (ApolloActionData)localObject3), 5, null, false);
            }
            localObject1 = new anfl(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((anff)localObject1).h = 1;
            ((anff)localObject1).a = ((ApolloActionData)localObject3);
            ((ApolloActionData)localObject3).atNickName = "";
            ((ApolloActionData)localObject3).inputText = "";
            localObject2 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            if (((SessionInfo)localObject2).jdField_a_of_type_Int == 0)
            {
              ((ApolloActionData)localObject3).peerUin = ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString;
              if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
                ((ApolloActionData)localObject3).inputText = bdol.b(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
              }
            }
            for (;;)
            {
              if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
              {
                localObject3 = localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
                if ((localObject3 != null) && (((String)localObject3).length() > 99) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                {
                  ChatActivityUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131717764, 1);
                  break;
                  if (((((SessionInfo)localObject2).jdField_a_of_type_Int != 1) && (((SessionInfo)localObject2).jdField_a_of_type_Int != 3000)) || (localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
                    continue;
                  }
                  ArrayList localArrayList = new ArrayList();
                  if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                    bfmd.a(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
                  }
                  if (((ApolloActionData)localObject3).personNum == 1)
                  {
                    if ((localArrayList.size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).uin) && (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).startPos == 0))
                    {
                      String str = bdol.b(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                      try
                      {
                        ((ApolloActionData)localObject3).atNickName = str.substring(0, ((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen);
                        if (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen >= localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1) {}
                        for (((ApolloActionData)localObject3).inputText = "";; ((ApolloActionData)localObject3).inputText = str.substring(((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).textLen))
                        {
                          ((ApolloActionData)localObject3).peerUin = (((MessageForText.AtTroopMemberInfo)localArrayList.get(0)).uin + "");
                          localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                          break;
                        }
                      }
                      catch (Exception localException)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("ApolloResponseManager", 2, "inputText err:" + localException.getMessage());
                          }
                          ((ApolloActionData)localObject3).inputText = "";
                        }
                      }
                    }
                    if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
                      continue;
                    }
                    localObject2 = bglf.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, true);
                    localObject2 = new StringBuilder("@").append((String)localObject2);
                    ((anff)localObject1).a.peerUin = this.a.jdField_a_of_type_JavaLangString;
                    ((anff)localObject1).a.atNickName = ((StringBuilder)localObject2).toString();
                    ((anff)localObject1).a.inputText = bdol.b(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                    localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                    localBaseChatPie.a((anff)localObject1);
                    localBaseChatPie.jdField_a_of_type_Anff = ((anff)localObject1);
                    this.a.a();
                    break;
                  }
                  if ((((ApolloActionData)localObject3).personNum != 0) || (localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
                    continue;
                  }
                  ((ApolloActionData)localObject3).inputText = bdol.b(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                  localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                  continue;
                }
                if ((((SessionInfo)localObject2).jdField_a_of_type_Int != 1) && (((SessionInfo)localObject2).jdField_a_of_type_Int != 3000)) {
                  localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                }
              }
            }
            if (localBaseChatPie != null) {
              localBaseChatPie.a((anff)localObject1);
            }
            this.a.a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amit
 * JD-Core Version:    0.7.0.1
 */