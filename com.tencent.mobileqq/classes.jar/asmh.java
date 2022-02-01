import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.extendfriend.apollo.aio.ApolloVasAvatar;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;

public class asmh
{
  public static int a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseBubbleBuilder paramBaseBubbleBuilder, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = paramChatMessage.istroop;
    a(paramQQAppInterface, paramContext, asmj.b(paramQQAppInterface, a(paramChatMessage)), paramBaseChatItemLayout, paramSessionInfo);
    return i;
  }
  
  private static String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    return paramChatMessage.senderuin;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo == null) || (paramQQAppInterface == null) || (paramActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AioApolloHelper", 2, "checkAndAddDressUpGrayTip first failed");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramSessionInfo.curType == 1044) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("AioApolloHelper", 2, "checkAndAddDressUpGrayTip type failed");
            return;
            localObject1 = paramActivity.getIntent();
            if ((localObject1 != null) && (((Intent)localObject1).getBooleanExtra("need_check_apollo_dress_up", false))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("AioApolloHelper", 2, "checkAndAddDressUpGrayTip flag failed");
          return;
          if (amme.a(paramQQAppInterface) == 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("AioApolloHelper", 2, "checkAndAddDressUpGrayTip status failed");
        return;
        localObject1 = asrt.b(paramQQAppInterface);
      } while (localObject1 == null);
      i = ((SharedPreferences)localObject1).getInt("show_dress_up_gray_tip_day", 0);
      localObject2 = new Time();
      ((Time)localObject2).set(System.currentTimeMillis());
      if (QLog.isColorLevel()) {
        QLog.d("AioApolloHelper", 2, "checkAndAddDressUpGrayTip lastTipDay:" + i + " now.yearDay:" + ((Time)localObject2).yearDay);
      }
    } while (((Time)localObject2).yearDay == i);
    int i = ((Time)localObject2).yearDay;
    ((SharedPreferences)localObject1).edit().putInt("show_dress_up_gray_tip_day", i).apply();
    Object localObject1 = paramActivity.getString(2131698470);
    Object localObject2 = paramActivity.getString(2131698469);
    paramActivity = new avhz(paramSessionInfo.curFriendUin, paramQQAppInterface.getCurrentUin(), (String)localObject2, paramSessionInfo.curType, -5022, 459817, bcrg.a());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      i = ((String)localObject2).indexOf((String)localObject1);
      if (i >= 0)
      {
        int j = ((String)localObject1).length();
        paramSessionInfo = new Bundle();
        paramSessionInfo.putInt("key_action", 1);
        paramSessionInfo.putString("key_action_DATA", "https://cmshow.qq.com/act_apollo/h5_act/cmshow3dsite/dist/html/reserve.html?_wv=3&adtag=extendFriend");
        paramActivity.a(i, j + i, paramSessionInfo);
      }
    }
    paramSessionInfo = new MessageForUniteGrayTip();
    paramSessionInfo.initGrayTipMsg(paramQQAppInterface, paramActivity);
    avia.a(paramQQAppInterface, paramSessionInfo);
    bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B444", "0X800B444", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, BaseBubbleBuilder paramBaseBubbleBuilder, BaseChatItemLayout paramBaseChatItemLayout, View paramView)
  {
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ViewUtils.dip2px(12.0F);
    paramBaseChatItemLayout.setPadding(BaseChatItemLayout.t, 0, BaseChatItemLayout.u, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, afqr paramafqr)
  {
    a(paramQQAppInterface, paramContext, asmj.b(paramQQAppInterface, a(paramChatMessage)), paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ListView paramListView, Collection<String> paramCollection)
  {
    if (paramListView == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        Object localObject = paramListView.getChildAt(i);
        if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
        {
          localObject = (afqr)AIOUtils.getHolder((View)localObject);
          if ((localObject != null) && (((afqr)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (((afqr)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin != null) && (paramCollection.contains(((afqr)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin))) {
            a(paramQQAppInterface, paramContext, asmj.b(paramQQAppInterface, a(((afqr)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)), ((afqr)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramSessionInfo);
          }
        }
        i += 1;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, Object paramObject, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo)
  {
    int i = AIOUtils.dp2px(5.0F, paramBaseChatItemLayout.getContext().getResources());
    if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = new ApolloVasAvatar(paramBaseChatItemLayout.getContext());
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setId(2131364531);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
      paramQQAppInterface = new RelativeLayout.LayoutParams(ViewUtils.dip2px(45.0F), ViewUtils.dip2px(60.0F));
      paramQQAppInterface.topMargin = 0;
      paramQQAppInterface.addRule(3, 2131364530);
      if (paramBaseChatItemLayout.b() == 1)
      {
        paramQQAppInterface.addRule(11);
        paramQQAppInterface.addRule(9, 0);
        paramQQAppInterface.rightMargin = i;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(3, paramBaseChatItemLayout.a());
        paramBaseChatItemLayout.addView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, paramQQAppInterface);
        label140:
        if (!(paramObject instanceof Drawable)) {
          break label375;
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable((Drawable)paramObject);
      }
    }
    for (;;)
    {
      if (paramBaseChatItemLayout.b != null) {
        paramBaseChatItemLayout.b.setVisibility(8);
      }
      return;
      paramQQAppInterface.addRule(9);
      paramQQAppInterface.addRule(11, 0);
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (paramQQAppInterface.leftMargin = AIOUtils.dp2px(30.0F, paramBaseChatItemLayout.getContext().getResources());; paramQQAppInterface.leftMargin = i)
      {
        paramQQAppInterface.rightMargin = 0;
        break;
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      paramQQAppInterface.topMargin = 0;
      paramQQAppInterface.addRule(3, 2131364530);
      if (paramBaseChatItemLayout.b() == 1)
      {
        paramQQAppInterface.addRule(11);
        paramQQAppInterface.addRule(9, 0);
        paramQQAppInterface.rightMargin = i;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(3, paramBaseChatItemLayout.a());
        break label140;
      }
      paramQQAppInterface.addRule(9);
      paramQQAppInterface.addRule(11, 0);
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (paramQQAppInterface.leftMargin = AIOUtils.dp2px(30.0F, paramBaseChatItemLayout.getContext().getResources());; paramQQAppInterface.leftMargin = i)
      {
        paramQQAppInterface.rightMargin = 0;
        break;
      }
      label375:
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLoader(null, (bhqp)paramObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, avhz paramavhz)
  {
    if (paramavhz.b == 459817)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B445", "0X800B445", 0, 0, "", "", "", "");
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800B446", "0X800B446", 2, 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSessionInfo != null) {
      if (acnh.a(paramSessionInfo.curType) != 1044)
      {
        bool1 = bool2;
        if (paramSessionInfo.curType != 1037) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmh
 * JD-Core Version:    0.7.0.1
 */