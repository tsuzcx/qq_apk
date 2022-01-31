import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import java.util.List;
import java.util.Observer;

public class aymw
  extends ayly
{
  public long a;
  protected GestureDetector a;
  ayma jdField_a_of_type_Ayma = new ayma();
  ayme jdField_a_of_type_Ayme = new ayme();
  aymq jdField_a_of_type_Aymq = new aymq();
  aymt jdField_a_of_type_Aymt = new aymt();
  aymv jdField_a_of_type_Aymv = new aymv();
  public long b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Aymt.a();
    }
    return 0;
  }
  
  public ayme a()
  {
    return this.jdField_a_of_type_Ayme;
  }
  
  public aymq a()
  {
    return this.jdField_a_of_type_Aymq;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aymq.a(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aymq.a(paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramBoolean;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null)) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    k();
  }
  
  public void a(List<TroopAIONotifyItem> paramList)
  {
    this.jdField_a_of_type_Aymv.a(paramList);
  }
  
  public void a(Observer paramObserver)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aymt.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Aymq.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Aymv.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Ayma.jdField_b_of_type_JavaUtilObserver = paramObserver;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = null;
      if (!this.jdField_a_of_type_Aymq.a()) {
        break label65;
      }
      localObject = this.jdField_a_of_type_Aymq;
      if (localObject != null)
      {
        localObject = ((ayly)localObject).a();
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (!paramBoolean) {
            break label101;
          }
          localLayoutParams.addRule(3, 2131312048);
        }
      }
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(localLayoutParams);
      return;
      label65:
      if (this.jdField_a_of_type_Aymv.a())
      {
        localObject = this.jdField_a_of_type_Aymv;
        break;
      }
      if (!this.jdField_a_of_type_Ayme.a()) {
        break;
      }
      localObject = this.jdField_a_of_type_Ayme;
      break;
      label101:
      int i = aymq.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131307242, 2131307330, 2131307325 });
      if (i > 0) {
        localLayoutParams.addRule(3, i);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aymq.b();
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aymq != null)) {
      return this.jdField_a_of_type_Aymq.a();
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aymq.e();
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Aymq.a(paramList);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Aymq.c();
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Aymt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acka, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Aymq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acka, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Aymv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acka, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Ayma.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acka, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Ayme.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Acka, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Ayme.a(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new aymx(this));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.c = false;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aymt.a(paramInt);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Aymt.a();
    }
    return false;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_Aymt.a();
    this.jdField_a_of_type_Aymq.a();
    this.jdField_a_of_type_Aymv.a();
    this.jdField_a_of_type_Ayma.a();
    this.jdField_a_of_type_Ayme.a();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.c = false;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Aymq.a();
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Aymq.f();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Aymv.a();
    }
    return false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Aymv.e();
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Ayme.a();
    }
    return false;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aymq.h();
    }
  }
  
  public boolean g()
  {
    return (d()) || (e()) || (f());
  }
  
  public void h()
  {
    this.jdField_a_of_type_Aymt.jdField_b_of_type_Boolean = true;
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean) {
      if ((!d()) && (!c()) && (!this.jdField_a_of_type_Aymv.a()))
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Ayma.a()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void i()
  {
    this.jdField_a_of_type_Aymt.jdField_b_of_type_Boolean = false;
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void k()
  {
    this.jdField_a_of_type_Ayma.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aymw
 * JD-Core Version:    0.7.0.1
 */