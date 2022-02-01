import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopConfess;

public class aqzl
  extends BaseBubbleBuilder
{
  private int c;
  
  public aqzl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.B + agej.a(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new aqzn();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    aqzn localaqzn = (aqzn)paramaggl;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558863, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      aqzn.a(localaqzn, (TextView)paramChatMessage.findViewById(2131380309));
      aqzn.b(localaqzn, (TextView)paramChatMessage.findViewById(2131380300));
      aqzn.c(localaqzn, (TextView)paramChatMessage.findViewById(2131380324));
      aqzn.a(localaqzn, (ConfessNewsBgView)paramChatMessage.findViewById(2131380597));
      aqzn.a(localaqzn).setPressMask(true);
      aqzn.a(localaqzn, paramChatMessage.findViewById(2131370213));
    }
    aqzn.a(localaqzn).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    aqzn.a(localaqzn).setOnLongClickListener(paramagjk);
    aqzn.a(localaqzn).setOnTouchListener(paramagjk);
    localaqzn.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new aqzm(this, paramBaseChatItemLayout));
    if (e)
    {
      ((aqzn)paramaggl).b.append(aqzn.b(localaqzn).getText()).append(aqzn.a(localaqzn).getText());
      if (aqzn.c(localaqzn).getVisibility() == 0) {
        ((aqzn)paramaggl).b.append(aqzn.c(localaqzn).getText());
      }
      paramChatMessage.setContentDescription(((aqzn)paramaggl).b.toString());
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
    aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    aean.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzl
 * JD-Core Version:    0.7.0.1
 */