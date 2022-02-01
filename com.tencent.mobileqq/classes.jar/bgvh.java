import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager.RollViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;

public class bgvh
  extends Handler
{
  public bgvh(AvatarWallViewPager paramAvatarWallViewPager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((AvatarWallViewPager.a(this.a)) || (!AvatarWallViewPager.b(this.a))) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.getCount() <= 1) {
      return;
    }
    paramMessage = this.a;
    paramMessage.b += 1;
    this.a.b %= this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.getCount();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(this.a.b, true);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvh
 * JD-Core Version:    0.7.0.1
 */