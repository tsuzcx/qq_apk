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

public class aofh
  extends BaseBubbleBuilder
{
  private int c;
  
  public aofh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.A + aekt.a(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new aofj();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    aofj localaofj = (aofj)paramaelt;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558793, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      aofj.a(localaofj, (TextView)paramChatMessage.findViewById(2131379141));
      aofj.b(localaofj, (TextView)paramChatMessage.findViewById(2131379132));
      aofj.c(localaofj, (TextView)paramChatMessage.findViewById(2131379156));
      aofj.a(localaofj, (ConfessNewsBgView)paramChatMessage.findViewById(2131379424));
      aofj.a(localaofj).setPressMask(true);
      aofj.a(localaofj, paramChatMessage.findViewById(2131369672));
    }
    aofj.a(localaofj).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    aofj.a(localaofj).setOnLongClickListener(paramaeov);
    aofj.a(localaofj).setOnTouchListener(paramaeov);
    localaofj.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new aofi(this, paramBaseChatItemLayout));
    if (e)
    {
      ((aofj)paramaelt).b.append(aofj.b(localaofj).getText()).append(aofj.a(localaofj).getText());
      if (aofj.c(localaofj).getVisibility() == 0) {
        ((aofj)paramaelt).b.append(aofj.c(localaofj).getText());
      }
      paramChatMessage.setContentDescription(((aofj)paramaelt).b.toString());
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
    acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public bdlb[] a(View paramView)
  {
    paramView = new bdkz();
    acex.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofh
 * JD-Core Version:    0.7.0.1
 */