import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.CircleFileStateView;

public abstract class atfh
{
  protected Context a;
  protected View.OnClickListener a;
  protected atfj a;
  protected QQAppInterface a;
  
  public atfh(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new atfi(this);
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
  
  protected abstract CircleFileStateView a(afqr paramafqr);
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage)
  {
    a(paramafqr, false);
    CircleFileStateView localCircleFileStateView;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      localObject = a(paramafqr);
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
        localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
        localCircleFileStateView.setState(2);
        localCircleFileStateView.setId(2131364526);
        localCircleFileStateView.setProgressRingWidth(0.0F);
        localCircleFileStateView.setCenterBgColor(-1);
        a(paramafqr, localCircleFileStateView);
        i = AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i, i);
        localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296386);
        localLayoutParams.addRule(8, 2131364522);
        if (paramChatMessage.isSend())
        {
          localLayoutParams.addRule(0, 2131364522);
          localLayoutParams.addRule(1, 0);
          if ((paramView instanceof ViewGroup)) {
            ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
          }
          a(paramafqr, true);
        }
      }
    }
    while (!b(paramChatMessage))
    {
      for (;;)
      {
        return;
        localLayoutParams.addRule(1, 2131364522);
        localLayoutParams.addRule(0, 0);
      }
      ((CircleFileStateView)localObject).setState(2);
      paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
      if (paramView == null)
      {
        i = AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramView = new RelativeLayout.LayoutParams(i, i);
        if (paramChatMessage.isSend())
        {
          paramView.addRule(0, 2131364522);
          paramView.addRule(1, 0);
        }
        for (;;)
        {
          ((CircleFileStateView)localObject).setLayoutParams(paramView);
          break;
          paramView.addRule(1, 2131364522);
          paramView.addRule(0, 0);
        }
      }
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364522);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364522);
        paramView.addRule(0, 0);
      }
    }
    Object localObject = a(paramafqr);
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
      localCircleFileStateView.setState(1);
      localCircleFileStateView.setId(2131364526);
      localCircleFileStateView.setCenterBgColor(-1);
      a(paramafqr, localCircleFileStateView);
      localCircleFileStateView.setProgressRingWidth(0.0F);
      i = AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296386);
      localLayoutParams.addRule(8, 2131364522);
      if (paramChatMessage.isSend())
      {
        localLayoutParams.addRule(0, 2131364522);
        localLayoutParams.addRule(1, 0);
      }
      for (;;)
      {
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
        }
        a(paramafqr, true);
        return;
        localLayoutParams.addRule(1, 2131364522);
        localLayoutParams.addRule(0, 0);
      }
    }
    ((CircleFileStateView)localObject).setState(1);
    paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
    if (paramView == null)
    {
      i = AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView = new RelativeLayout.LayoutParams(i, i);
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364522);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364522);
        paramView.addRule(0, 0);
      }
    }
    if (paramChatMessage.isSend())
    {
      paramView.addRule(0, 2131364522);
      paramView.addRule(1, 0);
    }
    for (;;)
    {
      ((CircleFileStateView)localObject).setLayoutParams(paramView);
      break;
      paramView.addRule(1, 2131364522);
      paramView.addRule(0, 0);
    }
  }
  
  protected abstract void a(afqr paramafqr, CircleFileStateView paramCircleFileStateView);
  
  protected void a(View paramView, afqr paramafqr, ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(atfj paramatfj)
  {
    this.jdField_a_of_type_Atfj = paramatfj;
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
 * Qualified Name:     atfh
 * JD-Core Version:    0.7.0.1
 */