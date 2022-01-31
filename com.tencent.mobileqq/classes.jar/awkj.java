import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

public class awkj
  extends avfa
{
  FriendProfilePicBrowserActivity a;
  
  public awkj(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, zec paramzec)
  {
    super(paramFriendProfilePicBrowserActivity, paramzec);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity = paramFriendProfilePicBrowserActivity;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Avfg != null) {
      return this.jdField_a_of_type_Avfg.b();
    }
    return -1;
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561200, null);
  }
  
  public PicInfo a()
  {
    PicInfo localPicInfo = null;
    if (this.jdField_a_of_type_Avfg.a() != null) {
      localPicInfo = this.jdField_a_of_type_Avfg.a().a;
    }
    return localPicInfo;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if (this.jdField_a_of_type_Avez != null) {
      this.jdField_a_of_type_Avez.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.b();
    }
  }
  
  protected void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.c();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Avez != null) {
      this.jdField_a_of_type_Avez.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awkj
 * JD-Core Version:    0.7.0.1
 */