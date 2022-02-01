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

public class aqvz
  extends BaseBubbleBuilder
{
  private int c;
  
  public aqvz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.B + AIOUtils.dp2px(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new aqwb();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    aqwb localaqwb = (aqwb)paramafqr;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558898, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      aqwb.a(localaqwb, (TextView)paramChatMessage.findViewById(2131380370));
      aqwb.b(localaqwb, (TextView)paramChatMessage.findViewById(2131380361));
      aqwb.c(localaqwb, (TextView)paramChatMessage.findViewById(2131380385));
      aqwb.a(localaqwb, (ConfessNewsBgView)paramChatMessage.findViewById(2131380657));
      aqwb.a(localaqwb).setPressMask(true);
      aqwb.a(localaqwb, paramChatMessage.findViewById(2131370365));
    }
    aqwb.a(localaqwb).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    aqwb.a(localaqwb).setOnLongClickListener(paramaftk);
    aqwb.a(localaqwb).setOnTouchListener(paramaftk);
    localaqwb.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new aqwa(this, paramBaseChatItemLayout));
    if (e)
    {
      ((aqwb)paramafqr).b.append(aqwb.b(localaqwb).getText()).append(aqwb.a(localaqwb).getText());
      if (aqwb.c(localaqwb).getVisibility() == 0) {
        ((aqwb)paramafqr).b.append(aqwb.c(localaqwb).getText());
      }
      paramChatMessage.setContentDescription(((aqwb)paramafqr).b.toString());
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
    admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    admh.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvz
 * JD-Core Version:    0.7.0.1
 */