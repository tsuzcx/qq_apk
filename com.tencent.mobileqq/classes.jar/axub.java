import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axub
  implements View.OnClickListener
{
  axub(axtp paramaxtp, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      axtp.a(this.jdField_a_of_type_Axtp, 1);
      new bcsy(this.jdField_a_of_type_Axtp.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Axtp.a.a.a).a();
    }
    for (;;)
    {
      axtp.b(this.jdField_a_of_type_Axtp);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.b)
      {
        axtp.a(this.jdField_a_of_type_Axtp, 2);
        new bcsy(this.jdField_a_of_type_Axtp.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Axtp.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        axtp.a(this.jdField_a_of_type_Axtp, 3);
        new bcsy(this.jdField_a_of_type_Axtp.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Axtp.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axub
 * JD-Core Version:    0.7.0.1
 */