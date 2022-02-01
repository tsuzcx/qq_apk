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

public abstract class atov
{
  protected Context a;
  protected View.OnClickListener a;
  protected blir a;
  protected QQAppInterface a;
  
  public atov(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new atow(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(aggl paramaggl, boolean paramBoolean)
  {
    paramaggl = a(paramaggl);
    if (paramBoolean) {
      if (paramaggl != null)
      {
        paramaggl.setVisibility(0);
        paramaggl.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramaggl == null) {
      return;
    }
    paramaggl.setVisibility(8);
    paramaggl.setOnClickListener(null);
  }
  
  protected abstract ImageView a(aggl paramaggl);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
      blji.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Blir);
    }
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramaggl);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838285);
        paramChatMessage.setId(2131364442);
        a(paramaggl, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364423);
        localLayoutParams.addRule(0, 2131364423);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramaggl, true);
        return;
        paramChatMessage.setImageResource(2130838285);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramaggl);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838269);
        paramChatMessage.setId(2131364442);
        a(paramaggl, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364423);
        localLayoutParams.addRule(0, 2131364423);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramaggl, true);
        return;
        paramChatMessage.setImageResource(2130838269);
      }
    }
    a(paramaggl, false);
  }
  
  protected abstract void a(aggl paramaggl, ImageView paramImageView);
  
  protected void a(View paramView, aggl paramaggl, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bliz parambliz)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bliq(0, blji.a(this.jdField_a_of_type_AndroidContentContext, 2131717462), 0, 0, 2));
    this.jdField_a_of_type_Blir = blji.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambliz);
    this.jdField_a_of_type_Blir.c(2131690580);
    blji.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Blir);
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
 * Qualified Name:     atov
 * JD-Core Version:    0.7.0.1
 */