import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.widget.QQViewPager;
import mqq.app.AppRuntime.Status;

public class atlm
{
  private OnlineStatusPanel a;
  
  @SuppressLint({"UseSparseArrays"})
  public atlm(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, atlk paramatlk, int paramInt)
  {
    this.a = ((OnlineStatusPanel)View.inflate(paramContext, 2131493266, null));
    this.a.a(paramInt);
    this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(paramatlk);
    paramViewGroup.addView(this.a);
  }
  
  public atlj a()
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
  
  public void a(AppRuntime.Status paramStatus, long paramLong, atln paramatln)
  {
    atlj localatlj = atlb.a().a(paramStatus, paramLong);
    if (localatlj != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a = localatlj;
      this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
      if (paramatln != null)
      {
        paramStatus = new atlj(paramStatus);
        paramStatus.a = paramLong;
        paramatln.a(paramStatus);
      }
    }
  }
  
  void b()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atlm
 * JD-Core Version:    0.7.0.1
 */