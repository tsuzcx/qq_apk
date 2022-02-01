import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

public class azvs
  extends ayjn
{
  FriendProfilePicBrowserActivity a;
  
  public azvs(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, abjt paramabjt)
  {
    super(paramFriendProfilePicBrowserActivity, paramabjt);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity = paramFriendProfilePicBrowserActivity;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Ayjt != null) {
      return this.jdField_a_of_type_Ayjt.b();
    }
    return -1;
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561482, null);
  }
  
  public PicInfo a()
  {
    PicInfo localPicInfo = null;
    if (this.jdField_a_of_type_Ayjt.a() != null) {
      localPicInfo = this.jdField_a_of_type_Ayjt.a().a;
    }
    return localPicInfo;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    if (this.jdField_a_of_type_Ayjm != null) {
      this.jdField_a_of_type_Ayjm.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.c();
    }
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.b();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Ayjm != null) {
      this.jdField_a_of_type_Ayjm.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvs
 * JD-Core Version:    0.7.0.1
 */