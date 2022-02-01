import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;

class bogn
  extends RecyclerView.ViewHolder
{
  final GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  final LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  bogn(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380426);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368415));
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = ((LayerDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131362252));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogn
 * JD-Core Version:    0.7.0.1
 */