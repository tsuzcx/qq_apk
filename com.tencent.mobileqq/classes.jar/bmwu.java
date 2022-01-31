import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;

public class bmwu
  extends bmwj<bmwb>
{
  private ImageView a;
  private ImageView b;
  
  public bmwu(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = null;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561441, null);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131380093));
      this.b = ((ImageView)localView.findViewById(2131375215));
      if ((this.jdField_a_of_type_AndroidContentContext instanceof EditVideoActivity)) {
        paramView = ((EditVideoActivity)this.jdField_a_of_type_AndroidContentContext).a();
      }
      for (;;)
      {
        if (paramView != null)
        {
          paramView = paramView.a;
          if (paramView != null)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramView);
            this.b.setOnClickListener(paramView);
            paramInt = xsm.c * 54 / 750;
            ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).setMargins(paramInt, 0, paramInt, 0);
            ((LinearLayout.LayoutParams)this.b.getLayoutParams()).setMargins(paramInt, 0, paramInt, 0);
          }
        }
        localView.setLayoutParams(new AbsListView.LayoutParams(paramViewGroup.getWidth(), paramViewGroup.getHeight()));
        return localView;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
          paramView = ((EditPicActivity)this.jdField_a_of_type_AndroidContentContext).a();
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwu
 * JD-Core Version:    0.7.0.1
 */