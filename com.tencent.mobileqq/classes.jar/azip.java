import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.onlinestatus.OnlineStatusListLayout;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;
import mqq.app.AppRuntime.Status;

public class azip
{
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private OnlineStatusPanel jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel;
  
  @SuppressLint({"UseSparseArrays"})
  public azip(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, azif paramazif, int paramInt1, int paramInt2)
  {
    this(paramContext, paramViewGroup, paramazif, paramInt1, paramInt2, null, false);
  }
  
  public azip(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, azif paramazif, int paramInt1, int paramInt2, azig paramazig, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel = ((OnlineStatusPanel)View.inflate(paramContext, 2131558930, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.findViewById(2131368235));
    c();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.setListener(paramazig);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a(paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(paramazif);
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel);
  }
  
  public azib a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.size() <= 0) {
      return null;
    }
    return (azib)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0);
  }
  
  public ArrayList<azib> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a;
  }
  
  public void a()
  {
    boolean bool = true;
    QQViewPager localQQViewPager = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      localQQViewPager.b(bool);
      return;
      bool = false;
    }
  }
  
  public void a(ArrayList<azib> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.addAll(paramArrayList);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong)
  {
    a(paramStatus, paramLong, null);
  }
  
  public void a(AppRuntime.Status paramStatus, long paramLong, aziq paramaziq)
  {
    azib localazib = azhq.a().a(paramStatus, paramLong);
    if ((!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.isEmpty()) && (OnlineStatusListLayout.a(localazib, (azib)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0)))) {}
    do
    {
      do
      {
        return;
      } while (localazib == null);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.add(localazib);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
    } while (paramaziq == null);
    paramStatus = new azib(paramStatus);
    paramStatus.a = paramLong;
    paramaziq.a(paramStatus);
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    AppRuntime.Status localStatus = paramQQAppInterface.getOnlineStatus();
    long l = azhq.a().a(paramQQAppInterface);
    paramQQAppInterface = azhq.a().a(localStatus, l);
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.add(paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a();
  }
  
  public void c()
  {
    if (blqj.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841461);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azip
 * JD-Core Version:    0.7.0.1
 */