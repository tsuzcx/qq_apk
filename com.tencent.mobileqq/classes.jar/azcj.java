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

public class azcj
{
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private OnlineStatusPanel jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel;
  
  @SuppressLint({"UseSparseArrays"})
  public azcj(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, azbz paramazbz, int paramInt1, int paramInt2)
  {
    this(paramContext, paramViewGroup, paramazbz, paramInt1, paramInt2, null, false);
  }
  
  public azcj(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, azbz paramazbz, int paramInt1, int paramInt2, azca paramazca, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel = ((OnlineStatusPanel)View.inflate(paramContext, 2131558965, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.findViewById(2131368404));
    c();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.setListener(paramazca);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a(paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(paramazbz);
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel);
  }
  
  public azbu a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.size() <= 0) {
      return null;
    }
    return (azbu)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0);
  }
  
  public ArrayList<azbu> a()
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
      localQQViewPager.disableGesture(bool);
      return;
      bool = false;
    }
  }
  
  public void a(ArrayList<azbu> paramArrayList)
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
  
  public void a(AppRuntime.Status paramStatus, long paramLong, azck paramazck)
  {
    azbu localazbu = azbj.a().a(paramStatus, paramLong);
    if ((!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.isEmpty()) && (OnlineStatusListLayout.a(localazbu, (azbu)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0)))) {}
    do
    {
      do
      {
        return;
      } while (localazbu == null);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.add(localazbu);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
    } while (paramazck == null);
    paramStatus = new azbu(paramStatus);
    paramStatus.a = paramLong;
    paramazck.a(paramStatus);
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    AppRuntime.Status localStatus = paramQQAppInterface.getOnlineStatus();
    long l = azbj.a().a(paramQQAppInterface);
    paramQQAppInterface = azbj.a().a(localStatus, l);
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
    if (blfw.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841504);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcj
 * JD-Core Version:    0.7.0.1
 */