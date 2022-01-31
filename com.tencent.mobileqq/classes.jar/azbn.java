import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import java.util.ArrayList;

class azbn
  implements View.OnClickListener
{
  azbn(azbm paramazbm, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Azbm.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", ((azbz)this.jdField_a_of_type_Azbm.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b);
    this.jdField_a_of_type_Azbm.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity(paramView);
    if (this.jdField_a_of_type_Azbm.jdField_a_of_type_Azcb.c == 31) {}
    for (paramView = "1";; paramView = "2")
    {
      axqy.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_tribe", 0, 0, this.jdField_a_of_type_Azbm.jdField_a_of_type_Azcb.d, ((azbz)this.jdField_a_of_type_Azbm.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a + "", "", paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azbn
 * JD-Core Version:    0.7.0.1
 */