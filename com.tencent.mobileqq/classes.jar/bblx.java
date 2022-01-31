import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import java.util.List;
import java.util.Observer;

public class bblx
  extends bbkz
{
  public long a;
  protected GestureDetector a;
  bblb jdField_a_of_type_Bblb = new bblb();
  bblf jdField_a_of_type_Bblf = new bblf();
  bblr jdField_a_of_type_Bblr = new bblr();
  bblu jdField_a_of_type_Bblu = new bblu();
  bblw jdField_a_of_type_Bblw = new bblw();
  public long b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bblu.a();
    }
    return 0;
  }
  
  public bblf a()
  {
    return this.jdField_a_of_type_Bblf;
  }
  
  public bblr a()
  {
    return this.jdField_a_of_type_Bblr;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bblr.a(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bblr.a(paramLong);
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
    this.jdField_a_of_type_Bblw.a(paramList);
  }
  
  public void a(Observer paramObserver)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bblu.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Bblr.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Bblw.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Bblb.jdField_b_of_type_JavaUtilObserver = paramObserver;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = null;
      if (!this.jdField_a_of_type_Bblr.a()) {
        break label65;
      }
      localObject = this.jdField_a_of_type_Bblr;
      if (localObject != null)
      {
        localObject = ((bbkz)localObject).a();
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (!paramBoolean) {
            break label101;
          }
          localLayoutParams.addRule(3, 2131378420);
        }
      }
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(localLayoutParams);
      return;
      label65:
      if (this.jdField_a_of_type_Bblw.a())
      {
        localObject = this.jdField_a_of_type_Bblw;
        break;
      }
      if (!this.jdField_a_of_type_Bblf.a()) {
        break;
      }
      localObject = this.jdField_a_of_type_Bblf;
      break;
      label101:
      int i = bblr.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131373393, 2131373478, 2131373473 });
      if (i > 0) {
        localLayoutParams.addRule(3, i);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bblr.b();
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bblr != null)) {
      return this.jdField_a_of_type_Bblr.a();
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bblr.e();
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Bblr.a(paramList);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bblr.c();
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Bblu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aelz, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bblr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aelz, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bblw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aelz, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bblb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aelz, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bblf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aelz, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bblf.a(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new bbly(this));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.c = false;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bblu.a(paramInt);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bblu.a();
    }
    return false;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_Bblu.a();
    this.jdField_a_of_type_Bblr.a();
    this.jdField_a_of_type_Bblw.a();
    this.jdField_a_of_type_Bblb.a();
    this.jdField_a_of_type_Bblf.a();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.c = false;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bblr.a();
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Bblr.f();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bblw.a();
    }
    return false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Bblw.e();
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bblf.a();
    }
    return false;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bblr.i();
    }
  }
  
  public boolean g()
  {
    return (d()) || (e()) || (f());
  }
  
  public void h()
  {
    this.jdField_a_of_type_Bblu.jdField_b_of_type_Boolean = true;
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean) {
      if ((!d()) && (!c()) && (!this.jdField_a_of_type_Bblw.a()))
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Bblb.a()) {}
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
    this.jdField_a_of_type_Bblu.jdField_b_of_type_Boolean = false;
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void k()
  {
    this.jdField_a_of_type_Bblb.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblx
 * JD-Core Version:    0.7.0.1
 */