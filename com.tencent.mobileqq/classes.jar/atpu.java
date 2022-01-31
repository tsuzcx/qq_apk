import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atpu
  implements View.OnClickListener
{
  atpu(atpk paramatpk, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      atpk.a(this.jdField_a_of_type_Atpk, 1);
      new axrc(this.jdField_a_of_type_Atpk.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.jdField_a_of_type_Atpk.a.a.a).a();
    }
    for (;;)
    {
      atpk.b(this.jdField_a_of_type_Atpk);
      return;
      if (paramView == this.b)
      {
        atpk.a(this.jdField_a_of_type_Atpk, 2);
        new axrc(this.jdField_a_of_type_Atpk.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.jdField_a_of_type_Atpk.a.a.a).a();
      }
      else if (paramView == this.c)
      {
        atpk.a(this.jdField_a_of_type_Atpk, 3);
        new axrc(this.jdField_a_of_type_Atpk.a.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.jdField_a_of_type_Atpk.a.a.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpu
 * JD-Core Version:    0.7.0.1
 */