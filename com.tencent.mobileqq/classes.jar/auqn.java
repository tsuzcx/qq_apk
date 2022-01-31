import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.ProgressViewRed;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;

class auqn
  implements bfsk
{
  private int jdField_a_of_type_Int;
  
  auqn(auqk paramauqk) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "tryCountdown" + this.jdField_a_of_type_Auqk.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int == 3) {
      this.jdField_a_of_type_Auqk.b(-1L);
    }
    if (this.jdField_a_of_type_Auqk.jdField_e_of_type_Boolean) {
      b(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int != 0) && (paramInt2 == 0)) {
      a(false);
    }
    this.jdField_a_of_type_Int = paramInt2;
    paramInt1 = -paramInt2;
    switch (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int)
    {
    default: 
      if ((this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.m) && (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int != 4)) {
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.k = true;
      }
      break;
    }
    do
    {
      return;
      if ((paramInt1 > 0) || (goto 60) || (paramInt1 > 0)) {
        break;
      }
      if (this.jdField_a_of_type_Auqk.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.q();
      }
      this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
      break;
      if (paramInt1 <= 0)
      {
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
        break;
      }
      this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(true);
      break;
      if (paramInt1 <= this.jdField_a_of_type_Auqk.jdField_b_of_type_Int)
      {
        auqk.a(this.jdField_a_of_type_Auqk).setAlpha(255);
        auqk.a(this.jdField_a_of_type_Auqk).setVisibility(0);
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
        break;
      }
      paramInt1 = this.jdField_a_of_type_Auqk.jdField_b_of_type_Int * 2;
      if (-paramInt2 <= paramInt1)
      {
        paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / this.jdField_a_of_type_Auqk.jdField_b_of_type_Int * 255.0F);
        auqk.a(this.jdField_a_of_type_Auqk).setAlpha(paramInt1);
      }
      for (;;)
      {
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(true);
        break;
        auqk.a(this.jdField_a_of_type_Auqk).setAlpha(0);
      }
      paramInt1 = this.jdField_a_of_type_Auqk.jdField_b_of_type_Int * 2;
      switch (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int)
      {
      case 4: 
      default: 
        return;
      case 2: 
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.k = true;
        return;
      case 5: 
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.k = this.jdField_a_of_type_Auqk.jdField_b_of_type_Boolean;
        return;
      }
    } while ((paramInt2 >= 0) || (paramInt2 < -paramInt1));
    paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / paramInt1 * 255.0F);
  }
  
  public void a(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onTouchDown, " + this.jdField_a_of_type_Auqk.jdField_d_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Auqk.a(paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onHongBaoPendantClick" + this.jdField_a_of_type_Auqk.jdField_d_of_type_Int);
    }
    auqk.a(this.jdField_a_of_type_Auqk);
    PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(79);
    if (localPortalManager != null) {}
    try
    {
      localPortalManager.g();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(HongBaoListView paramHongBaoListView)
  {
    this.jdField_a_of_type_Auqk.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Auqk.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Auqk.b(paramBoolean);
  }
  
  public void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int == 4)
    {
      localObject = this.jdField_a_of_type_Auqk;
      ((auqk)localObject).c += 1;
      localObject = (PortalManager)this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(79);
      ((PortalManager)localObject).a();
      l1 = System.currentTimeMillis();
      if (this.jdField_a_of_type_Auqk.c == 1)
      {
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(this.jdField_a_of_type_Auqk.c, auqk.a(this.jdField_a_of_type_Auqk), true);
        this.jdField_a_of_type_Auqk.jdField_b_of_type_Long = l1;
        ((PortalManager)localObject).a(this.jdField_a_of_type_Auqk.c);
      }
    }
    label165:
    while (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int != 5)
    {
      Object localObject;
      long l1;
      return;
      long l2 = l1 - this.jdField_a_of_type_Auqk.jdField_b_of_type_Long;
      this.jdField_a_of_type_Auqk.jdField_b_of_type_Long = l1;
      FormalView localFormalView;
      int i;
      String str;
      if (l2 > 600L)
      {
        this.jdField_a_of_type_Auqk.c = 1;
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
        localFormalView = this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView;
        i = this.jdField_a_of_type_Auqk.c;
        str = auqk.a(this.jdField_a_of_type_Auqk);
        if (this.jdField_a_of_type_Auqk.jdField_b_of_type_Long - this.jdField_a_of_type_Auqk.jdField_a_of_type_Long <= 500L) {
          break label268;
        }
      }
      for (;;)
      {
        localFormalView.a(i, str, bool);
        ((PortalManager)localObject).b(0);
        break;
        if (l2 > 400L)
        {
          this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
          break label165;
        }
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(3);
        break label165;
        bool = false;
      }
    }
    label268:
  }
  
  public void c(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onTouchRelease, " + this.jdField_a_of_type_Auqk.jdField_d_of_type_Int);
    }
    int i = paramHongBaoListView.getScrollY();
    this.jdField_a_of_type_Auqk.jdField_e_of_type_Int = 0;
    if (-i >= this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2)
    {
      paramHongBaoListView = (PortalManager)this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getAppInterface().getManager(79);
      if (paramHongBaoListView != null) {
        paramHongBaoListView.e();
      }
      if ((this.jdField_a_of_type_Auqk.jdField_d_of_type_Int == 2) && (System.currentTimeMillis() - this.jdField_a_of_type_Auqk.jdField_d_of_type_Long > 500L))
      {
        this.jdField_a_of_type_Auqk.jdField_d_of_type_Long = System.currentTimeMillis();
        auqk.b(this.jdField_a_of_type_Auqk);
      }
      if (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int == 5) {
        this.jdField_a_of_type_Auqk.jdField_e_of_type_Int = 1;
      }
    }
    switch (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int)
    {
    default: 
      if ((-i < this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) && (-i > 0))
      {
        if (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int == 5) {
          this.jdField_a_of_type_Auqk.jdField_e_of_type_Int = 2;
        }
        this.jdField_a_of_type_Auqk.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Auqk.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
        this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.c);
      }
      if ((-i < this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) && (!this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.m)) {
        a(false);
      }
      this.jdField_a_of_type_Auqk.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Auqk.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Auqk.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Auqk.jdField_a_of_type_JavaLangRunnable, 2000L);
      if (this.jdField_a_of_type_Auqk.jdField_d_of_type_Int == 5)
      {
        this.jdField_a_of_type_Auqk.jdField_a_of_type_AndroidOsHandler.removeMessages(1005);
        if (this.jdField_a_of_type_Auqk.jdField_e_of_type_Int != 0)
        {
          paramHongBaoListView = this.jdField_a_of_type_Auqk.jdField_a_of_type_AndroidOsHandler;
          if (this.jdField_a_of_type_Auqk.jdField_e_of_type_Int != 2) {
            break label497;
          }
        }
      }
      break;
    }
    label497:
    for (long l = 200L;; l = 2500L)
    {
      paramHongBaoListView.sendEmptyMessageDelayed(1005, l);
      return;
      if ((-i >= this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.jdField_e_of_type_Int / 2) || (-i <= 0)) {
        break;
      }
      this.jdField_a_of_type_Auqk.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Auqk.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.jdField_a_of_type_Auqk.jdField_b_of_type_Int);
      this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(this.jdField_a_of_type_Auqk.jdField_a_of_type_ComTencentWidgetHongBaoListView.c);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auqn
 * JD-Core Version:    0.7.0.1
 */