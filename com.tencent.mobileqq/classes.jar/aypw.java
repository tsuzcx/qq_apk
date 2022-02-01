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

public class aypw
{
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private OnlineStatusPanel jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel;
  
  @SuppressLint({"UseSparseArrays"})
  public aypw(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, aypm paramaypm, int paramInt1, int paramInt2)
  {
    this(paramContext, paramViewGroup, paramaypm, paramInt1, paramInt2, null, false);
  }
  
  public aypw(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, aypm paramaypm, int paramInt1, int paramInt2, aypn paramaypn, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel = ((OnlineStatusPanel)View.inflate(paramContext, 2131558931, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.findViewById(2131368161));
    c();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.setListener(paramaypn);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a(paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(paramaypm);
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel);
  }
  
  public aypi a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.size() <= 0) {
      return null;
    }
    return (aypi)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0);
  }
  
  public ArrayList<aypi> a()
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
  
  public void a(ArrayList<aypi> paramArrayList)
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
  
  public void a(AppRuntime.Status paramStatus, long paramLong, aypx paramaypx)
  {
    aypi localaypi = ayox.a().a(paramStatus, paramLong);
    if ((!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.isEmpty()) && (OnlineStatusListLayout.a(localaypi, (aypi)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0)))) {}
    do
    {
      do
      {
        return;
      } while (localaypi == null);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.add(localaypi);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
    } while (paramaypx == null);
    paramStatus = new aypi(paramStatus);
    paramStatus.a = paramLong;
    paramaypx.a(paramStatus);
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    AppRuntime.Status localStatus = paramQQAppInterface.getOnlineStatus();
    long l = ayox.a().a(paramQQAppInterface);
    paramQQAppInterface = ayox.a().a(localStatus, l);
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
    if (bkpg.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841451);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypw
 * JD-Core Version:    0.7.0.1
 */