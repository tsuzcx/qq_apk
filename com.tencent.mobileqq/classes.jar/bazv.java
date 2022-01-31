import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import mqq.app.AppActivity;

public class bazv
  implements View.OnClickListener
{
  public bazv(TribeVideoPreviewFragment paramTribeVideoPreviewFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.getActivity();
    if (paramView.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.a(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.getActivity().app, "dc00899", "Grp_tribe", "", "post", "save_video", 0, 0, "", "", "", "");
      return;
      paramView.requestPermissions(new bazw(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazv
 * JD-Core Version:    0.7.0.1
 */