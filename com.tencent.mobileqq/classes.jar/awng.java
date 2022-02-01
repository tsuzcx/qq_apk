import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class awng
{
  public static long a;
  private static final String jdField_a_of_type_JavaLangString = awng.class.getName() + "Q.nearby.video_chat.gift";
  public static long[] a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TroopGiftPanel jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[2];
  }
  
  public awng(AppInterface paramAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopGiftPanel paramTroopGiftPanel, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = paramTroopGiftPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = 3;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
    zsz localzsz = zsz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    if (localzsz != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData(localzsz, true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("mTroopGiftPanel") != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = System.currentTimeMillis();
    beyh localbeyh = (beyh)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(223);
    bfci localbfci = (bfci)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(113);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      localbfci.a("OidbSvc.0x7f8", 2040, paramInt2, str, 2, i, 0, new awnh(this, localbfci, l, localbeyh, paramInt1));
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
      Object localObject;
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(TroopGiftPanel.e);
        localObject = zsz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
        if (localObject == null) {
          break label172;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData((zsz)localObject, true);
        a(0, paramBoolean2, paramInt);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("mTroopGiftPanel") == null)
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(8);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setTag("mTroopGiftPanel");
      }
    }
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_AndroidContentContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        SosoInterface.startLocation(new awnj(3, true, true, 60000L, true, false, "NearbyTroopsView"));
      }
      return;
      label172:
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d();
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awng
 * JD-Core Version:    0.7.0.1
 */