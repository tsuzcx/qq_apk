import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import java.util.ArrayList;

class aybd
  implements View.OnClickListener
{
  aybd(aybc paramaybc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Aybc.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", ((aybo)this.jdField_a_of_type_Aybc.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b);
    this.jdField_a_of_type_Aybc.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity(paramView);
    if (this.jdField_a_of_type_Aybc.jdField_a_of_type_Aybq.c == 31) {}
    for (paramView = "1";; paramView = "2")
    {
      awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_tribe", 0, 0, this.jdField_a_of_type_Aybc.jdField_a_of_type_Aybq.d, ((aybo)this.jdField_a_of_type_Aybc.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a + "", "", paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybd
 * JD-Core Version:    0.7.0.1
 */