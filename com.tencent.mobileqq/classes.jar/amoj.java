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

public class amoj
  extends BaseBubbleBuilder
{
  private int c;
  
  public amoj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.A + actj.a(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new amol();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    amol localamol = (amol)paramacuj;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558757, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      amol.a(localamol, (TextView)paramChatMessage.findViewById(2131378529));
      amol.b(localamol, (TextView)paramChatMessage.findViewById(2131378520));
      amol.c(localamol, (TextView)paramChatMessage.findViewById(2131378544));
      amol.a(localamol, (ConfessNewsBgView)paramChatMessage.findViewById(2131378805));
      amol.a(localamol).setPressMask(true);
      amol.a(localamol, paramChatMessage.findViewById(2131369420));
    }
    amol.a(localamol).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    amol.a(localamol).setOnLongClickListener(paramacxj);
    amol.a(localamol).setOnTouchListener(paramacxj);
    localamol.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new amok(this, paramBaseChatItemLayout));
    if (e)
    {
      ((amol)paramacuj).b.append(amol.b(localamol).getText()).append(amol.a(localamol).getText());
      if (amol.c(localamol).getVisibility() == 0) {
        ((amol)paramacuj).b.append(amol.c(localamol).getText());
      }
      paramChatMessage.setContentDescription(((amol)paramacuj).b.toString());
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
    aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public bbmh[] a(View paramView)
  {
    paramView = new bbmf();
    aanz.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amoj
 * JD-Core Version:    0.7.0.1
 */