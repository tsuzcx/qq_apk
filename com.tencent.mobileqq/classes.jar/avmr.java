import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avmr
  implements View.OnClickListener
{
  avmr(avmf paramavmf, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      avmf.a(this.jdField_a_of_type_Avmf, 1);
      new azqx(this.jdField_a_of_type_Avmf.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Avmf.a.a.a).a();
    }
    for (;;)
    {
      avmf.b(this.jdField_a_of_type_Avmf);
      return;
      if (paramView == this.b)
      {
        avmf.a(this.jdField_a_of_type_Avmf, 2);
        new azqx(this.jdField_a_of_type_Avmf.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Avmf.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        avmf.a(this.jdField_a_of_type_Avmf, 3);
        new azqx(this.jdField_a_of_type_Avmf.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Avmf.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmr
 * JD-Core Version:    0.7.0.1
 */