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

public abstract class aqrp
{
  protected Context a;
  protected View.OnClickListener a;
  protected bhuf a;
  protected QQAppInterface a;
  
  public aqrp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aqrq(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(aeqi paramaeqi, boolean paramBoolean)
  {
    paramaeqi = a(paramaeqi);
    if (paramBoolean) {
      if (paramaeqi != null)
      {
        paramaeqi.setVisibility(0);
        paramaeqi.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramaeqi == null) {
      return;
    }
    paramaeqi.setVisibility(8);
    paramaeqi.setOnClickListener(null);
  }
  
  protected abstract ImageView a(aeqi paramaeqi);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing())) {
      bhus.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhuf);
    }
  }
  
  public void a(aeqi paramaeqi, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramaeqi);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838162);
        paramChatMessage.setId(2131364192);
        a(paramaeqi, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aepi.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364173);
        localLayoutParams.addRule(0, 2131364173);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramaeqi, true);
        return;
        paramChatMessage.setImageResource(2130838162);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramaeqi);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838157);
        paramChatMessage.setId(2131364192);
        a(paramaeqi, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aepi.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364173);
        localLayoutParams.addRule(0, 2131364173);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramaeqi, true);
        return;
        paramChatMessage.setImageResource(2130838157);
      }
    }
    a(paramaeqi, false);
  }
  
  protected abstract void a(aeqi paramaeqi, ImageView paramImageView);
  
  protected void a(View paramView, aeqi paramaeqi, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bhuk parambhuk)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bhue(0, bhus.a(this.jdField_a_of_type_AndroidContentContext, 2131719246), 0, 0, 2));
    this.jdField_a_of_type_Bhuf = bhus.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambhuk);
    this.jdField_a_of_type_Bhuf.c(2131690648);
    bhus.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhuf);
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
 * Qualified Name:     aqrp
 * JD-Core Version:    0.7.0.1
 */