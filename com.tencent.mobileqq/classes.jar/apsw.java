import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopConfess;

public class apsw
  extends BaseBubbleBuilder
{
  private int c;
  
  public apsw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.B + AIOUtils.dp2px(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aezf a()
  {
    return new apsy();
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    apsy localapsy = (apsy)paramaezf;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558871, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      apsy.a(localapsy, (TextView)paramChatMessage.findViewById(2131380035));
      apsy.b(localapsy, (TextView)paramChatMessage.findViewById(2131380026));
      apsy.c(localapsy, (TextView)paramChatMessage.findViewById(2131380050));
      apsy.a(localapsy, (ConfessNewsBgView)paramChatMessage.findViewById(2131380322));
      apsy.a(localapsy).setPressMask(true);
      apsy.a(localapsy, paramChatMessage.findViewById(2131370191));
    }
    apsy.a(localapsy).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    apsy.a(localapsy).setOnLongClickListener(paramafce);
    apsy.a(localapsy).setOnTouchListener(paramafce);
    localapsy.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new apsx(this, paramBaseChatItemLayout));
    if (e)
    {
      ((apsy)paramaezf).b.append(apsy.b(localapsy).getText()).append(apsy.a(localapsy).getText());
      if (apsy.c(localapsy).getVisibility() == 0) {
        ((apsy)paramaezf).b.append(apsy.c(localapsy).getText());
      }
      paramChatMessage.setContentDescription(((apsy)paramaezf).b.toString());
    }
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopConfess))) {
      return;
    }
    MessageForTroopConfess localMessageForTroopConfess = (MessageForTroopConfess)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public bgbb[] a(View paramView)
  {
    paramView = new bgaz();
    acvv.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsw
 * JD-Core Version:    0.7.0.1
 */