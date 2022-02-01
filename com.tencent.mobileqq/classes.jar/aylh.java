import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aylh
  implements View.OnClickListener
{
  aylh(aykx paramaykx, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      aykx.a(this.jdField_a_of_type_Aykx, 1);
      new bdlq(this.jdField_a_of_type_Aykx.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Aykx.a.a.a).a();
    }
    for (;;)
    {
      aykx.b(this.jdField_a_of_type_Aykx);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.b)
      {
        aykx.a(this.jdField_a_of_type_Aykx, 2);
        new bdlq(this.jdField_a_of_type_Aykx.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Aykx.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        aykx.a(this.jdField_a_of_type_Aykx, 3);
        new bdlq(this.jdField_a_of_type_Aykx.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Aykx.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylh
 * JD-Core Version:    0.7.0.1
 */