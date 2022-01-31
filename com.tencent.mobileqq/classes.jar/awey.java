import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.widget.QQViewPager;
import mqq.app.AppRuntime.Status;

public class awey
{
  private OnlineStatusPanel a;
  
  @SuppressLint({"UseSparseArrays"})
  public awey(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, awew paramawew, int paramInt)
  {
    this.a = ((OnlineStatusPanel)View.inflate(paramContext, 2131558859, null));
    this.a.a(paramInt);
    this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(paramawew);
    paramViewGroup.addView(this.a);
  }
  
  public awev a()
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
  
  public void a(AppRuntime.Status paramStatus, long paramLong, awez paramawez)
  {
    awev localawev = aweo.a().a(paramStatus, paramLong);
    if (localawev != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a = localawev;
      this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
      if (paramawez != null)
      {
        paramStatus = new awev(paramStatus);
        paramStatus.a = paramLong;
        paramawez.a(paramStatus);
      }
    }
  }
  
  void b()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awey
 * JD-Core Version:    0.7.0.1
 */