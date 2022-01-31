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

public abstract class aqng
{
  protected Context a;
  protected View.OnClickListener a;
  protected bhpy a;
  protected QQAppInterface a;
  
  public aqng(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aqnh(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(aelt paramaelt, boolean paramBoolean)
  {
    paramaelt = a(paramaelt);
    if (paramBoolean) {
      if (paramaelt != null)
      {
        paramaelt.setVisibility(0);
        paramaelt.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramaelt == null) {
      return;
    }
    paramaelt.setVisibility(8);
    paramaelt.setOnClickListener(null);
  }
  
  protected abstract ImageView a(aelt paramaelt);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing())) {
      bhql.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhpy);
    }
  }
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramaelt);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838161);
        paramChatMessage.setId(2131364190);
        a(paramaelt, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aekt.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364171);
        localLayoutParams.addRule(0, 2131364171);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramaelt, true);
        return;
        paramChatMessage.setImageResource(2130838161);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramaelt);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838156);
        paramChatMessage.setId(2131364190);
        a(paramaelt, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aekt.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364171);
        localLayoutParams.addRule(0, 2131364171);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramaelt, true);
        return;
        paramChatMessage.setImageResource(2130838156);
      }
    }
    a(paramaelt, false);
  }
  
  protected abstract void a(aelt paramaelt, ImageView paramImageView);
  
  protected void a(View paramView, aelt paramaelt, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bhqd parambhqd)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bhpx(0, bhql.a(this.jdField_a_of_type_AndroidContentContext, 2131719234), 0, 0, 2));
    this.jdField_a_of_type_Bhpy = bhql.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambhqd);
    this.jdField_a_of_type_Bhpy.c(2131690648);
    bhql.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhpy);
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
 * Qualified Name:     aqng
 * JD-Core Version:    0.7.0.1
 */