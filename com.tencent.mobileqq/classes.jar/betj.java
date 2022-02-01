import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class betj
  implements View.OnClickListener
{
  betj(beti parambeti, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_Beti.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", ((betv)this.jdField_a_of_type_Beti.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b);
    this.jdField_a_of_type_Beti.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity((Intent)localObject);
    if (this.jdField_a_of_type_Beti.jdField_a_of_type_Betx.c == 31) {}
    for (localObject = "1";; localObject = "2")
    {
      bdla.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_tribe", 0, 0, this.jdField_a_of_type_Beti.jdField_a_of_type_Betx.d, ((betv)this.jdField_a_of_type_Beti.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a + "", "", (String)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betj
 * JD-Core Version:    0.7.0.1
 */