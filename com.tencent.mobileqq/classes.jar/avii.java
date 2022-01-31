import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avii
  implements View.OnClickListener
{
  avii(avhw paramavhw, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      avhw.a(this.jdField_a_of_type_Avhw, 1);
      new azmo(this.jdField_a_of_type_Avhw.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Avhw.a.a.a).a();
    }
    for (;;)
    {
      avhw.b(this.jdField_a_of_type_Avhw);
      return;
      if (paramView == this.b)
      {
        avhw.a(this.jdField_a_of_type_Avhw, 2);
        new azmo(this.jdField_a_of_type_Avhw.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Avhw.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        avhw.a(this.jdField_a_of_type_Avhw, 3);
        new azmo(this.jdField_a_of_type_Avhw.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Avhw.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avii
 * JD-Core Version:    0.7.0.1
 */