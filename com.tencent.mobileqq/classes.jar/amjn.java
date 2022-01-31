import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;

class amjn
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  MusicDanceDrawable jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable;
  View b;
  
  public amjn(amjl paramamjl, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramamjl = paramView.getContext().getResources();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370590));
    this.b = paramView.findViewById(2131370933);
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable = new MusicDanceDrawable();
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(paramView.getContext(), actj.a(15.0F, paramamjl), actj.a(9.5F, paramamjl), paramamjl.getColor(2131165443));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjn
 * JD-Core Version:    0.7.0.1
 */