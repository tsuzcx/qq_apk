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

public abstract class asbe
{
  protected Context a;
  protected View.OnClickListener a;
  protected bjnw a;
  protected QQAppInterface a;
  
  public asbe(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new asbf(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(aezf paramaezf, boolean paramBoolean)
  {
    paramaezf = a(paramaezf);
    if (paramBoolean) {
      if (paramaezf != null)
      {
        paramaezf.setVisibility(0);
        paramaezf.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramaezf == null) {
      return;
    }
    paramaezf.setVisibility(8);
    paramaezf.setOnClickListener(null);
  }
  
  protected abstract ImageView a(aezf paramaezf);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bjnw != null) && (this.jdField_a_of_type_Bjnw.isShowing())) {
      bjon.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjnw);
    }
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramaezf);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838310);
        paramChatMessage.setId(2131364460);
        a(paramaezf, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364441);
        localLayoutParams.addRule(0, 2131364441);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramaezf, true);
        return;
        paramChatMessage.setImageResource(2130838310);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramaezf);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838305);
        paramChatMessage.setId(2131364460);
        a(paramaezf, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364441);
        localLayoutParams.addRule(0, 2131364441);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramaezf, true);
        return;
        paramChatMessage.setImageResource(2130838305);
      }
    }
    a(paramaezf, false);
  }
  
  protected abstract void a(aezf paramaezf, ImageView paramImageView);
  
  protected void a(View paramView, aezf paramaezf, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bjoe parambjoe)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bjnv(0, bjon.a(this.jdField_a_of_type_AndroidContentContext, 2131717694), 0, 0, 2));
    this.jdField_a_of_type_Bjnw = bjon.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, parambjoe);
    if (this.jdField_a_of_type_Bjnw != null)
    {
      this.jdField_a_of_type_Bjnw.c(2131690620);
      bjon.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjnw);
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
 * Qualified Name:     asbe
 * JD-Core Version:    0.7.0.1
 */