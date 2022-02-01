import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.CircleFileStateView;

public abstract class atos
{
  protected Context a;
  protected View.OnClickListener a;
  protected atou a;
  protected QQAppInterface a;
  
  public atos(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new atot(this);
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
  
  protected abstract CircleFileStateView a(aggl paramaggl);
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage)
  {
    a(paramaggl, false);
    CircleFileStateView localCircleFileStateView;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      localObject = a(paramaggl);
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
        localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
        localCircleFileStateView.setState(2);
        localCircleFileStateView.setId(2131364427);
        localCircleFileStateView.setProgressRingWidth(0.0F);
        localCircleFileStateView.setCenterBgColor(-1);
        a(paramaggl, localCircleFileStateView);
        i = agej.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i, i);
        localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296333);
        localLayoutParams.addRule(8, 2131364423);
        if (paramChatMessage.isSend())
        {
          localLayoutParams.addRule(0, 2131364423);
          localLayoutParams.addRule(1, 0);
          if ((paramView instanceof ViewGroup)) {
            ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
          }
          a(paramaggl, true);
        }
      }
    }
    while (!b(paramChatMessage))
    {
      for (;;)
      {
        return;
        localLayoutParams.addRule(1, 2131364423);
        localLayoutParams.addRule(0, 0);
      }
      ((CircleFileStateView)localObject).setState(2);
      paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
      if (paramView == null)
      {
        i = agej.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramView = new RelativeLayout.LayoutParams(i, i);
        if (paramChatMessage.isSend())
        {
          paramView.addRule(0, 2131364423);
          paramView.addRule(1, 0);
        }
        for (;;)
        {
          ((CircleFileStateView)localObject).setLayoutParams(paramView);
          break;
          paramView.addRule(1, 2131364423);
          paramView.addRule(0, 0);
        }
      }
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364423);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364423);
        paramView.addRule(0, 0);
      }
    }
    Object localObject = a(paramaggl);
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
      localCircleFileStateView.setState(1);
      localCircleFileStateView.setId(2131364427);
      localCircleFileStateView.setCenterBgColor(-1);
      a(paramaggl, localCircleFileStateView);
      localCircleFileStateView.setProgressRingWidth(0.0F);
      i = agej.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296333);
      localLayoutParams.addRule(8, 2131364423);
      if (paramChatMessage.isSend())
      {
        localLayoutParams.addRule(0, 2131364423);
        localLayoutParams.addRule(1, 0);
      }
      for (;;)
      {
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
        }
        a(paramaggl, true);
        return;
        localLayoutParams.addRule(1, 2131364423);
        localLayoutParams.addRule(0, 0);
      }
    }
    ((CircleFileStateView)localObject).setState(1);
    paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
    if (paramView == null)
    {
      i = agej.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView = new RelativeLayout.LayoutParams(i, i);
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364423);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364423);
        paramView.addRule(0, 0);
      }
    }
    if (paramChatMessage.isSend())
    {
      paramView.addRule(0, 2131364423);
      paramView.addRule(1, 0);
    }
    for (;;)
    {
      ((CircleFileStateView)localObject).setLayoutParams(paramView);
      break;
      paramView.addRule(1, 2131364423);
      paramView.addRule(0, 0);
    }
  }
  
  protected abstract void a(aggl paramaggl, CircleFileStateView paramCircleFileStateView);
  
  protected void a(View paramView, aggl paramaggl, ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(atou paramatou)
  {
    this.jdField_a_of_type_Atou = paramatou;
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
 * Qualified Name:     atos
 * JD-Core Version:    0.7.0.1
 */