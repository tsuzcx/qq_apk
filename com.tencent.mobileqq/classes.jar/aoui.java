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

public abstract class aoui
{
  protected Context a;
  protected View.OnClickListener a;
  protected bfpc a;
  protected QQAppInterface a;
  
  public aoui(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aouj(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(acuj paramacuj, boolean paramBoolean)
  {
    paramacuj = a(paramacuj);
    if (paramBoolean) {
      if (paramacuj != null)
      {
        paramacuj.setVisibility(0);
        paramacuj.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramacuj == null) {
      return;
    }
    paramacuj.setVisibility(8);
    paramacuj.setOnClickListener(null);
  }
  
  protected abstract ImageView a(acuj paramacuj);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
      bfpp.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfpc);
    }
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramacuj);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838105);
        paramChatMessage.setId(2131364128);
        a(paramacuj, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = actj.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364109);
        localLayoutParams.addRule(0, 2131364109);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramacuj, true);
        return;
        paramChatMessage.setImageResource(2130838105);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramacuj);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838100);
        paramChatMessage.setId(2131364128);
        a(paramacuj, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = actj.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364109);
        localLayoutParams.addRule(0, 2131364109);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramacuj, true);
        return;
        paramChatMessage.setImageResource(2130838100);
      }
    }
    a(paramacuj, false);
  }
  
  protected abstract void a(acuj paramacuj, ImageView paramImageView);
  
  protected void a(View paramView, acuj paramacuj, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bfph parambfph)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bfpb(0, bfpp.a(this.jdField_a_of_type_AndroidContentContext, 2131718761), 0, 0, 2));
    this.jdField_a_of_type_Bfpc = bfpp.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambfph);
    this.jdField_a_of_type_Bfpc.c(2131690596);
    bfpp.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfpc);
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
 * Qualified Name:     aoui
 * JD-Core Version:    0.7.0.1
 */