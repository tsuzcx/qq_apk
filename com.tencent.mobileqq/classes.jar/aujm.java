import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.widget.QQViewPager;
import mqq.app.AppRuntime.Status;

public class aujm
{
  private OnlineStatusPanel a;
  
  @SuppressLint({"UseSparseArrays"})
  public aujm(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, aujk paramaujk, int paramInt)
  {
    this.a = ((OnlineStatusPanel)View.inflate(paramContext, 2131558824, null));
    this.a.a(paramInt);
    this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(paramaujk);
    paramViewGroup.addView(this.a);
  }
  
  public aujj a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a;
  }
  
  public void a()
  {
    boolean bool = true;
    QQViewPager localQQViewPager = this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    if (this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      localQQViewPager.b(bool);
      return;
      bool = false;
    }
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    a(paramStatus, paramLong, null);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong, aujn paramaujn)
  {
    aujj localaujj = aujc.a().a(paramStatus, paramLong);
    if (localaujj != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a = localaujj;
      this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
      if (paramaujn != null)
      {
        paramStatus = new aujj(paramStatus);
        paramStatus.a = paramLong;
        paramaujn.a(paramStatus);
      }
    }
  }
  
  void b()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aujm
 * JD-Core Version:    0.7.0.1
 */