import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;

public abstract class aodk
{
  protected Context a;
  protected View.OnClickListener a;
  protected begr a;
  protected QQAppInterface a;
  
  public aodk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aodl(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(acju paramacju, boolean paramBoolean)
  {
    paramacju = a(paramacju);
    if (paramBoolean) {
      if (paramacju != null)
      {
        paramacju.setVisibility(0);
        paramacju.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramacju == null) {
      return;
    }
    paramacju.setVisibility(8);
    paramacju.setOnClickListener(null);
  }
  
  protected abstract ImageView a(acju paramacju);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
      behe.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Begr);
    }
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramacju);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838098);
        paramChatMessage.setId(2131298571);
        a(paramacju, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aciy.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131298552);
        localLayoutParams.addRule(0, 2131298552);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramacju, true);
        return;
        paramChatMessage.setImageResource(2130838098);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramacju);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838093);
        paramChatMessage.setId(2131298571);
        a(paramacju, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aciy.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131298552);
        localLayoutParams.addRule(0, 2131298552);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramacju, true);
        return;
        paramChatMessage.setImageResource(2130838093);
      }
    }
    a(paramacju, false);
  }
  
  protected abstract void a(acju paramacju, ImageView paramImageView);
  
  protected void a(View paramView, acju paramacju, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(begw parambegw)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new begq(0, behe.a(this.jdField_a_of_type_AndroidContentContext, 2131652925), 0, 0, 2));
    this.jdField_a_of_type_Begr = behe.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambegw);
    this.jdField_a_of_type_Begr.c(2131625035);
    behe.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Begr);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    return false;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aodk
 * JD-Core Version:    0.7.0.1
 */