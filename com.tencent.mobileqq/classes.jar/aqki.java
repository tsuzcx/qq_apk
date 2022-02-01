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

public class aqki
  extends BaseBubbleBuilder
{
  private int c;
  
  public aqki(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.B + afur.a(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afwr a()
  {
    return new aqkk();
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    aqkk localaqkk = (aqkk)paramafwr;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558865, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      aqkk.a(localaqkk, (TextView)paramChatMessage.findViewById(2131380124));
      aqkk.b(localaqkk, (TextView)paramChatMessage.findViewById(2131380115));
      aqkk.c(localaqkk, (TextView)paramChatMessage.findViewById(2131380139));
      aqkk.a(localaqkk, (ConfessNewsBgView)paramChatMessage.findViewById(2131380411));
      aqkk.a(localaqkk).setPressMask(true);
      aqkk.a(localaqkk, paramChatMessage.findViewById(2131370115));
    }
    aqkk.a(localaqkk).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    aqkk.a(localaqkk).setOnLongClickListener(paramafzq);
    aqkk.a(localaqkk).setOnTouchListener(paramafzq);
    localaqkk.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new aqkj(this, paramBaseChatItemLayout));
    if (e)
    {
      ((aqkk)paramafwr).b.append(aqkk.b(localaqkk).getText()).append(aqkk.a(localaqkk).getText());
      if (aqkk.c(localaqkk).getVisibility() == 0) {
        ((aqkk)paramafwr).b.append(aqkk.c(localaqkk).getText());
      }
      paramChatMessage.setContentDescription(((aqkk)paramafwr).b.toString());
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
    adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public bguj[] a(View paramView)
  {
    paramView = new bguh();
    adrm.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqki
 * JD-Core Version:    0.7.0.1
 */