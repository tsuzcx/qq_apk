import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.ae.view.AEDownLoadingView;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;

public class bpic
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AEDownLoadingView jdField_a_of_type_DovComQqImAeViewAEDownLoadingView;
  ImageView b;
  ImageView c;
  ImageView d;
  ImageView e;
  ImageView f;
  
  public bpic(bphy parambphy, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380585);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378617));
    this.b = ((ImageView)paramView.findViewById(2131377262));
    this.c = ((ImageView)paramView.findViewById(2131365706));
    this.d = ((ImageView)paramView.findViewById(2131365702));
    this.e = ((ImageView)paramView.findViewById(2131370309));
    this.f = ((ImageView)paramView.findViewById(2131370310));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373074));
    int i = agej.a(6.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int j = agej.a(2.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int k = agej.a(16.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
  
  public void a(AEEditorFilterBean paramAEEditorFilterBean)
  {
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(paramAEEditorFilterBean.getProgress());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpic
 * JD-Core Version:    0.7.0.1
 */