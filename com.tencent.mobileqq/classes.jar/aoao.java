import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;

class aoao
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  MusicDanceDrawable jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable;
  View b;
  
  public aoao(aoam paramaoam, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramaoam = paramView.getContext().getResources();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370895));
    this.b = paramView.findViewById(2131371244);
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable = new MusicDanceDrawable();
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(paramView.getContext(), aekt.a(15.0F, paramaoam), aekt.a(9.5F, paramaoam), paramaoam.getColor(2131165478));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoao
 * JD-Core Version:    0.7.0.1
 */