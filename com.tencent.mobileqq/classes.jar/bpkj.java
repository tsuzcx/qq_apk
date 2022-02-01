import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class bpkj
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  AEDownLoadingView jdField_a_of_type_DovComQqImAeViewAEDownLoadingView;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  View c;
  View d;
  
  public bpkj(bpkf parambpkf, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364546);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377262));
    this.c = paramView.findViewById(2131380586);
    this.d = paramView.findViewById(2131380587);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373074));
    int i = agej.a(6.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int j = agej.a(2.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int k = agej.a(16.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(1.0F * k / 2.0F);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkj
 * JD-Core Version:    0.7.0.1
 */