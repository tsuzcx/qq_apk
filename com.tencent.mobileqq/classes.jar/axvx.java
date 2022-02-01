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

public class axvx
{
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private OnlineStatusPanel jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel;
  
  @SuppressLint({"UseSparseArrays"})
  public axvx(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, axvn paramaxvn, int paramInt1, int paramInt2)
  {
    this(paramContext, paramViewGroup, paramaxvn, paramInt1, paramInt2, null, false);
  }
  
  public axvx(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, axvn paramaxvn, int paramInt1, int paramInt2, axvo paramaxvo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel = ((OnlineStatusPanel)View.inflate(paramContext, 2131558938, null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.findViewById(2131368259));
    c();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.setListener(paramaxvo);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.a(paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(paramaxvn);
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel);
  }
  
  public axvj a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.size() <= 0) {
      return null;
    }
    return (axvj)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0);
  }
  
  public ArrayList<axvj> a()
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
  
  public void a(ArrayList<axvj> paramArrayList)
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
  
  public void a(AppRuntime.Status paramStatus, long paramLong, axvy paramaxvy)
  {
    axvj localaxvj = axuy.a().a(paramStatus, paramLong);
    if ((!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.isEmpty()) && (OnlineStatusListLayout.a(localaxvj, (axvj)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.get(0)))) {}
    do
    {
      do
      {
        return;
      } while (localaxvj == null);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a.add(localaxvj);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
    } while (paramaxvy == null);
    paramStatus = new axvj(paramStatus);
    paramStatus.a = paramLong;
    paramaxvy.a(paramStatus);
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    AppRuntime.Status localStatus = paramQQAppInterface.getOnlineStatus();
    long l = axuy.a().a(paramQQAppInterface);
    paramQQAppInterface = axuy.a().a(localStatus, l);
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
    if (bjuk.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841497);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setIndicatorDrawable(2130841496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvx
 * JD-Core Version:    0.7.0.1
 */