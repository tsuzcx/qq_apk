import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.CircleFileStateView;

public abstract class aqnd
{
  protected Context a;
  protected View.OnClickListener a;
  protected aqnf a;
  protected QQAppInterface a;
  
  public aqnd(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aqne(this);
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
  
  protected abstract CircleFileStateView a(aelt paramaelt);
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage)
  {
    a(paramaelt, false);
    CircleFileStateView localCircleFileStateView;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      localObject = a(paramaelt);
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
        localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
        localCircleFileStateView.setState(2);
        localCircleFileStateView.setId(2131364175);
        localCircleFileStateView.setProgressRingWidth(0.0F);
        localCircleFileStateView.setCenterBgColor(-1);
        a(paramaelt, localCircleFileStateView);
        i = aekt.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i, i);
        localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296295);
        localLayoutParams.addRule(8, 2131364171);
        if (paramChatMessage.isSend())
        {
          localLayoutParams.addRule(0, 2131364171);
          localLayoutParams.addRule(1, 0);
          if ((paramView instanceof ViewGroup)) {
            ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
          }
          a(paramaelt, true);
        }
      }
    }
    while (!b(paramChatMessage))
    {
      for (;;)
      {
        return;
        localLayoutParams.addRule(1, 2131364171);
        localLayoutParams.addRule(0, 0);
      }
      ((CircleFileStateView)localObject).setState(2);
      paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
      if (paramView == null)
      {
        i = aekt.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramView = new RelativeLayout.LayoutParams(i, i);
        if (paramChatMessage.isSend())
        {
          paramView.addRule(0, 2131364171);
          paramView.addRule(1, 0);
        }
        for (;;)
        {
          ((CircleFileStateView)localObject).setLayoutParams(paramView);
          break;
          paramView.addRule(1, 2131364171);
          paramView.addRule(0, 0);
        }
      }
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364171);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364171);
        paramView.addRule(0, 0);
      }
    }
    Object localObject = a(paramaelt);
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
      localCircleFileStateView.setState(1);
      localCircleFileStateView.setId(2131364175);
      localCircleFileStateView.setCenterBgColor(-1);
      a(paramaelt, localCircleFileStateView);
      localCircleFileStateView.setProgressRingWidth(0.0F);
      i = aekt.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296295);
      localLayoutParams.addRule(8, 2131364171);
      if (paramChatMessage.isSend())
      {
        localLayoutParams.addRule(0, 2131364171);
        localLayoutParams.addRule(1, 0);
      }
      for (;;)
      {
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
        }
        a(paramaelt, true);
        return;
        localLayoutParams.addRule(1, 2131364171);
        localLayoutParams.addRule(0, 0);
      }
    }
    ((CircleFileStateView)localObject).setState(1);
    paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
    if (paramView == null)
    {
      i = aekt.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView = new RelativeLayout.LayoutParams(i, i);
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364171);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364171);
        paramView.addRule(0, 0);
      }
    }
    if (paramChatMessage.isSend())
    {
      paramView.addRule(0, 2131364171);
      paramView.addRule(1, 0);
    }
    for (;;)
    {
      ((CircleFileStateView)localObject).setLayoutParams(paramView);
      break;
      paramView.addRule(1, 2131364171);
      paramView.addRule(0, 0);
    }
  }
  
  protected abstract void a(aelt paramaelt, CircleFileStateView paramCircleFileStateView);
  
  protected void a(View paramView, aelt paramaelt, ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(aqnf paramaqnf)
  {
    this.jdField_a_of_type_Aqnf = paramaqnf;
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
 * Qualified Name:     aqnd
 * JD-Core Version:    0.7.0.1
 */