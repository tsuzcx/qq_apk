import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axad
  implements View.OnClickListener
{
  axad(awzr paramawzr, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      awzr.a(this.jdField_a_of_type_Awzr, 1);
      new bcek(this.jdField_a_of_type_Awzr.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Awzr.a.a.a).a();
    }
    for (;;)
    {
      awzr.b(this.jdField_a_of_type_Awzr);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.b)
      {
        awzr.a(this.jdField_a_of_type_Awzr, 2);
        new bcek(this.jdField_a_of_type_Awzr.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Awzr.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        awzr.a(this.jdField_a_of_type_Awzr, 3);
        new bcek(this.jdField_a_of_type_Awzr.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Awzr.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axad
 * JD-Core Version:    0.7.0.1
 */