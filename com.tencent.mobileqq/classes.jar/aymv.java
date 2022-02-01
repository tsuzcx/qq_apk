import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aymv
  implements View.OnClickListener
{
  aymv(aymj paramaymj, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      aymj.a(this.jdField_a_of_type_Aymj, 1);
      new bdlq(this.jdField_a_of_type_Aymj.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Aymj.a.a.a).a();
    }
    for (;;)
    {
      aymj.b(this.jdField_a_of_type_Aymj);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.b)
      {
        aymj.a(this.jdField_a_of_type_Aymj, 2);
        new bdlq(this.jdField_a_of_type_Aymj.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Aymj.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        aymj.a(this.jdField_a_of_type_Aymj, 3);
        new bdlq(this.jdField_a_of_type_Aymj.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Aymj.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymv
 * JD-Core Version:    0.7.0.1
 */