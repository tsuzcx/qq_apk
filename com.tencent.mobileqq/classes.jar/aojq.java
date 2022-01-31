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

public class aojq
  extends BaseBubbleBuilder
{
  private int c;
  
  public aojq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.A + aepi.a(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqi a()
  {
    return new aojs();
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    aojs localaojs = (aojs)paramaeqi;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558792, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      aojs.a(localaojs, (TextView)paramChatMessage.findViewById(2131379199));
      aojs.b(localaojs, (TextView)paramChatMessage.findViewById(2131379190));
      aojs.c(localaojs, (TextView)paramChatMessage.findViewById(2131379214));
      aojs.a(localaojs, (ConfessNewsBgView)paramChatMessage.findViewById(2131379482));
      aojs.a(localaojs).setPressMask(true);
      aojs.a(localaojs, paramChatMessage.findViewById(2131369691));
    }
    aojs.a(localaojs).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    aojs.a(localaojs).setOnLongClickListener(paramaetk);
    aojs.a(localaojs).setOnTouchListener(paramaetk);
    localaojs.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new aojr(this, paramBaseChatItemLayout));
    if (e)
    {
      ((aojs)paramaeqi).b.append(aojs.b(localaojs).getText()).append(aojs.a(localaojs).getText());
      if (aojs.c(localaojs).getVisibility() == 0) {
        ((aojs)paramaeqi).b.append(aojs.c(localaojs).getText());
      }
      paramChatMessage.setContentDescription(((aojs)paramaeqi).b.toString());
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
    acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public bdpk[] a(View paramView)
  {
    paramView = new bdpi();
    acjm.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojq
 * JD-Core Version:    0.7.0.1
 */