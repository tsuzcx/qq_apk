import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import java.util.Observable;
import java.util.Observer;

public abstract class azmq
  extends Observable
{
  public static int a;
  public static int b;
  public static int c = 3;
  public acup a;
  public Context a;
  protected View a;
  public RelativeLayout a;
  public SessionInfo a;
  public QQAppInterface a;
  public ChatXListView a;
  public ScrollerRunnable a;
  public Observer a;
  public boolean a;
  public Observer b;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
  }
  
  public View a()
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = false;
    deleteObservers();
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, acup paramacup, ChatXListView paramChatXListView, ScrollerRunnable paramScrollerRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372955);
    }
    this.jdField_a_of_type_Acup = paramacup;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramChatXListView;
    this.jdField_a_of_type_JavaUtilObserver = paramObserver;
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = paramScrollerRunnable;
    deleteObservers();
    addObserver(paramObserver);
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(60);
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      this.jdField_a_of_type_Boolean = true;
      c();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_JavaUtilObserver != null) {
      this.jdField_b_of_type_JavaUtilObserver.update(null, null);
    }
  }
  
  protected abstract void c();
  
  protected abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmq
 * JD-Core Version:    0.7.0.1
 */