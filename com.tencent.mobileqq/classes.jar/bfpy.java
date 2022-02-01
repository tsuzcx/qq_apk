import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

public class bfpy
  extends bfpd
{
  public long a;
  protected GestureDetector a;
  bfpf jdField_a_of_type_Bfpf = new bfpf();
  bfpj jdField_a_of_type_Bfpj = new bfpj();
  bfpv jdField_a_of_type_Bfpv = new bfpv();
  bfpx jdField_a_of_type_Bfpx = new bfpx();
  bgia jdField_a_of_type_Bgia = new bgia();
  public long b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bfpv.a();
    }
    return 0;
  }
  
  public bfpj a()
  {
    return this.jdField_a_of_type_Bfpj;
  }
  
  public bgia a()
  {
    return this.jdField_a_of_type_Bgia;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bgia.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((d()) && (this.jdField_a_of_type_Aggs != null) && (!a().a.get()))
    {
      if ((!bgiy.a(b())) || (paramInt2 <= 0)) {
        break label181;
      }
      List localList = this.jdField_a_of_type_Aggs.a();
      int i = localList.size();
      int j = paramInt1 + paramInt2 - paramInt5 - paramInt4;
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + paramInt4 + ",headerCnt = " + paramInt5 + ", listSize = " + i);
      }
      if ((paramInt1 >= 0) && (paramInt1 <= j) && (j < i)) {
        b(localList.subList(paramInt1, j));
      }
    }
    return;
    label181:
    b(0);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bgia.a(paramLong);
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
    this.jdField_a_of_type_Bfpx.a(paramList);
  }
  
  public void a(Observer paramObserver)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bfpv.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Bgia.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Bfpx.jdField_b_of_type_JavaUtilObserver = paramObserver;
      this.jdField_a_of_type_Bfpf.jdField_b_of_type_JavaUtilObserver = paramObserver;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = null;
      if (!this.jdField_a_of_type_Bgia.a()) {
        break label65;
      }
      localObject = this.jdField_a_of_type_Bgia;
      if (localObject != null)
      {
        localObject = ((bfpd)localObject).a();
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (!paramBoolean) {
            break label101;
          }
          localLayoutParams.addRule(3, 2131379496);
        }
      }
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(localLayoutParams);
      return;
      label65:
      if (this.jdField_a_of_type_Bfpx.a())
      {
        localObject = this.jdField_a_of_type_Bfpx;
        break;
      }
      if (!this.jdField_a_of_type_Bfpj.a()) {
        break;
      }
      localObject = this.jdField_a_of_type_Bfpj;
      break;
      label101:
      int i = bgia.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new int[] { 2131374287, 2131374373, 2131374368 });
      if (i > 0) {
        localLayoutParams.addRule(3, i);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bgia.b();
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bgia.a(paramInt);
    }
    return false;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bgia != null)) {
      return this.jdField_a_of_type_Bgia.a();
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bgia.e();
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Bgia.a(paramList);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bgia.c();
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Bfpv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aggs, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bgia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aggs, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bfpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aggs, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bfpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aggs, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bfpj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Aggs, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_Bfpj.a(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new bfpz(this));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.c = false;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bfpv.a(paramInt);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bfpv.a();
    }
    return false;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_Bfpv.a();
    this.jdField_a_of_type_Bgia.a();
    this.jdField_a_of_type_Bfpx.a();
    this.jdField_a_of_type_Bfpf.a();
    this.jdField_a_of_type_Bfpj.a();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.c = false;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bgia.a();
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Bgia.f();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bfpx.a();
    }
    return false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_Bfpx.e();
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Bfpj.a();
    }
    return false;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bgia.k();
    }
  }
  
  public boolean g()
  {
    return (d()) || (e()) || (f());
  }
  
  public void h()
  {
    this.jdField_a_of_type_Bfpv.jdField_b_of_type_Boolean = true;
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean) {
      if ((!d()) && (!c()) && (!this.jdField_a_of_type_Bfpx.a()))
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Bfpf.a()) {}
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
    this.jdField_a_of_type_Bfpv.jdField_b_of_type_Boolean = false;
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void k()
  {
    this.jdField_a_of_type_Bfpf.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpy
 * JD-Core Version:    0.7.0.1
 */