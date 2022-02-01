import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axsn
  implements View.OnClickListener
{
  axsn(axsd paramaxsd, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      axsd.a(this.jdField_a_of_type_Axsd, 1);
      new bcsy(this.jdField_a_of_type_Axsd.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Axsd.a.a.a).a();
    }
    for (;;)
    {
      axsd.b(this.jdField_a_of_type_Axsd);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.b)
      {
        axsd.a(this.jdField_a_of_type_Axsd, 2);
        new bcsy(this.jdField_a_of_type_Axsd.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Axsd.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        axsd.a(this.jdField_a_of_type_Axsd, 3);
        new bcsy(this.jdField_a_of_type_Axsd.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Axsd.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsn
 * JD-Core Version:    0.7.0.1
 */