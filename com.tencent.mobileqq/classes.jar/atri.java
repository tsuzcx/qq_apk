import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atri
  implements View.OnClickListener
{
  atri(atqw paramatqw, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      atqw.a(this.jdField_a_of_type_Atqw, 1);
      new axrc(this.jdField_a_of_type_Atqw.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Atqw.a.a.a).a();
    }
    for (;;)
    {
      atqw.b(this.jdField_a_of_type_Atqw);
      return;
      if (paramView == this.b)
      {
        atqw.a(this.jdField_a_of_type_Atqw, 2);
        new axrc(this.jdField_a_of_type_Atqw.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Atqw.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        atqw.a(this.jdField_a_of_type_Atqw, 3);
        new axrc(this.jdField_a_of_type_Atqw.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Atqw.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atri
 * JD-Core Version:    0.7.0.1
 */