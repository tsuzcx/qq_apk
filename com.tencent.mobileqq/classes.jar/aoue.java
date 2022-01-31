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

public abstract class aoue
{
  protected Context a;
  protected View.OnClickListener a;
  protected bfol a;
  protected QQAppInterface a;
  
  public aoue(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aouf(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(acun paramacun, boolean paramBoolean)
  {
    paramacun = a(paramacun);
    if (paramBoolean) {
      if (paramacun != null)
      {
        paramacun.setVisibility(0);
        paramacun.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramacun == null) {
      return;
    }
    paramacun.setVisibility(8);
    paramacun.setOnClickListener(null);
  }
  
  protected abstract ImageView a(acun paramacun);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing())) {
      bfoy.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfol);
    }
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramacun);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838105);
        paramChatMessage.setId(2131364129);
        a(paramacun, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = actn.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364110);
        localLayoutParams.addRule(0, 2131364110);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramacun, true);
        return;
        paramChatMessage.setImageResource(2130838105);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramacun);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838100);
        paramChatMessage.setId(2131364129);
        a(paramacun, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = actn.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364110);
        localLayoutParams.addRule(0, 2131364110);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramacun, true);
        return;
        paramChatMessage.setImageResource(2130838100);
      }
    }
    a(paramacun, false);
  }
  
  protected abstract void a(acun paramacun, ImageView paramImageView);
  
  protected void a(View paramView, acun paramacun, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bfoq parambfoq)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bfok(0, bfoy.a(this.jdField_a_of_type_AndroidContentContext, 2131718750), 0, 0, 2));
    this.jdField_a_of_type_Bfol = bfoy.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambfoq);
    this.jdField_a_of_type_Bfol.c(2131690596);
    bfoy.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfol);
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
 * Qualified Name:     aoue
 * JD-Core Version:    0.7.0.1
 */