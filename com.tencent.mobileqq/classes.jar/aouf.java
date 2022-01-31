import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.CircleFileStateView;

public abstract class aouf
{
  protected Context a;
  protected View.OnClickListener a;
  protected aouh a;
  protected QQAppInterface a;
  
  public aouf(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aoug(this);
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
  
  protected abstract CircleFileStateView a(acuj paramacuj);
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage)
  {
    a(paramacuj, false);
    CircleFileStateView localCircleFileStateView;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      localObject = a(paramacuj);
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
        localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
        localCircleFileStateView.setState(2);
        localCircleFileStateView.setId(2131364113);
        localCircleFileStateView.setProgressRingWidth(0.0F);
        localCircleFileStateView.setCenterBgColor(-1);
        a(paramacuj, localCircleFileStateView);
        i = actj.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i, i);
        localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296289);
        localLayoutParams.addRule(8, 2131364109);
        if (paramChatMessage.isSend())
        {
          localLayoutParams.addRule(0, 2131364109);
          localLayoutParams.addRule(1, 0);
          if ((paramView instanceof ViewGroup)) {
            ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
          }
          a(paramacuj, true);
        }
      }
    }
    while (!b(paramChatMessage))
    {
      for (;;)
      {
        return;
        localLayoutParams.addRule(1, 2131364109);
        localLayoutParams.addRule(0, 0);
      }
      ((CircleFileStateView)localObject).setState(2);
      paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
      if (paramView == null)
      {
        i = actj.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramView = new RelativeLayout.LayoutParams(i, i);
        if (paramChatMessage.isSend())
        {
          paramView.addRule(0, 2131364109);
          paramView.addRule(1, 0);
        }
        for (;;)
        {
          ((CircleFileStateView)localObject).setLayoutParams(paramView);
          break;
          paramView.addRule(1, 2131364109);
          paramView.addRule(0, 0);
        }
      }
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364109);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364109);
        paramView.addRule(0, 0);
      }
    }
    Object localObject = a(paramacuj);
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
      localCircleFileStateView.setState(1);
      localCircleFileStateView.setId(2131364113);
      localCircleFileStateView.setCenterBgColor(-1);
      a(paramacuj, localCircleFileStateView);
      localCircleFileStateView.setProgressRingWidth(0.0F);
      i = actj.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296289);
      localLayoutParams.addRule(8, 2131364109);
      if (paramChatMessage.isSend())
      {
        localLayoutParams.addRule(0, 2131364109);
        localLayoutParams.addRule(1, 0);
      }
      for (;;)
      {
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
        }
        a(paramacuj, true);
        return;
        localLayoutParams.addRule(1, 2131364109);
        localLayoutParams.addRule(0, 0);
      }
    }
    ((CircleFileStateView)localObject).setState(1);
    paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
    if (paramView == null)
    {
      i = actj.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView = new RelativeLayout.LayoutParams(i, i);
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364109);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364109);
        paramView.addRule(0, 0);
      }
    }
    if (paramChatMessage.isSend())
    {
      paramView.addRule(0, 2131364109);
      paramView.addRule(1, 0);
    }
    for (;;)
    {
      ((CircleFileStateView)localObject).setLayoutParams(paramView);
      break;
      paramView.addRule(1, 2131364109);
      paramView.addRule(0, 0);
    }
  }
  
  protected abstract void a(acuj paramacuj, CircleFileStateView paramCircleFileStateView);
  
  protected void a(View paramView, acuj paramacuj, ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(aouh paramaouh)
  {
    this.jdField_a_of_type_Aouh = paramaouh;
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
 * Qualified Name:     aouf
 * JD-Core Version:    0.7.0.1
 */