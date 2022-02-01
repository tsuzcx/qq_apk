import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;

public abstract class atfk
{
  protected Context a;
  protected View.OnClickListener a;
  protected bkzi a;
  protected QQAppInterface a;
  
  public atfk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new atfl(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(afqr paramafqr, boolean paramBoolean)
  {
    paramafqr = a(paramafqr);
    if (paramBoolean) {
      if (paramafqr != null)
      {
        paramafqr.setVisibility(0);
        paramafqr.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramafqr == null) {
      return;
    }
    paramafqr.setVisibility(8);
    paramafqr.setOnClickListener(null);
  }
  
  protected abstract ImageView a(afqr paramafqr);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      bkzz.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bkzi);
    }
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramafqr);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838323);
        paramChatMessage.setId(2131364541);
        a(paramafqr, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364522);
        localLayoutParams.addRule(0, 2131364522);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramafqr, true);
        return;
        paramChatMessage.setImageResource(2130838323);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramafqr);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838318);
        paramChatMessage.setId(2131364541);
        a(paramafqr, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364522);
        localLayoutParams.addRule(0, 2131364522);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramafqr, true);
        return;
        paramChatMessage.setImageResource(2130838318);
      }
    }
    a(paramafqr, false);
  }
  
  protected abstract void a(afqr paramafqr, ImageView paramImageView);
  
  protected void a(View paramView, afqr paramafqr, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bkzq parambkzq)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bkzh(0, bkzz.a(this.jdField_a_of_type_AndroidContentContext, 2131718065), 0, 0, 2));
    this.jdField_a_of_type_Bkzi = bkzz.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambkzq);
    if (this.jdField_a_of_type_Bkzi != null)
    {
      this.jdField_a_of_type_Bkzi.c(2131690697);
      bkzz.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bkzi);
    }
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
 * Qualified Name:     atfk
 * JD-Core Version:    0.7.0.1
 */