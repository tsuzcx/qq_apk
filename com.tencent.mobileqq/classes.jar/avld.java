import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avld
  implements View.OnClickListener
{
  avld(avkt paramavkt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      avkt.a(this.jdField_a_of_type_Avkt, 1);
      new azqx(this.jdField_a_of_type_Avkt.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Avkt.a.a.a).a();
    }
    for (;;)
    {
      avkt.b(this.jdField_a_of_type_Avkt);
      return;
      if (paramView == this.b)
      {
        avkt.a(this.jdField_a_of_type_Avkt, 2);
        new azqx(this.jdField_a_of_type_Avkt.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Avkt.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        avkt.a(this.jdField_a_of_type_Avkt, 3);
        new azqx(this.jdField_a_of_type_Avkt.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Avkt.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avld
 * JD-Core Version:    0.7.0.1
 */