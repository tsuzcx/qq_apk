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

public abstract class asyr
{
  protected Context a;
  protected View.OnClickListener a;
  protected bkho a;
  protected QQAppInterface a;
  
  public asyr(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new asys(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(afwr paramafwr, boolean paramBoolean)
  {
    paramafwr = a(paramafwr);
    if (paramBoolean) {
      if (paramafwr != null)
      {
        paramafwr.setVisibility(0);
        paramafwr.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramafwr == null) {
      return;
    }
    paramafwr.setVisibility(8);
    paramafwr.setOnClickListener(null);
  }
  
  protected abstract ImageView a(afwr paramafwr);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing())) {
      bkif.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bkho);
    }
  }
  
  public void a(afwr paramafwr, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramafwr);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838264);
        paramChatMessage.setId(2131364398);
        a(paramafwr, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = afur.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364379);
        localLayoutParams.addRule(0, 2131364379);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramafwr, true);
        return;
        paramChatMessage.setImageResource(2130838264);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramafwr);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838259);
        paramChatMessage.setId(2131364398);
        a(paramafwr, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = afur.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364379);
        localLayoutParams.addRule(0, 2131364379);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramafwr, true);
        return;
        paramChatMessage.setImageResource(2130838259);
      }
    }
    a(paramafwr, false);
  }
  
  protected abstract void a(afwr paramafwr, ImageView paramImageView);
  
  protected void a(View paramView, afwr paramafwr, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bkhw parambkhw)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bkhn(0, bkif.a(this.jdField_a_of_type_AndroidContentContext, 2131717334), 0, 0, 2));
    this.jdField_a_of_type_Bkho = bkif.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambkhw);
    this.jdField_a_of_type_Bkho.c(2131690582);
    bkif.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bkho);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyr
 * JD-Core Version:    0.7.0.1
 */