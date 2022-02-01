import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;

public class bpoa
  extends bpnp<bpnh>
{
  private ImageView a;
  private ImageView b;
  
  public bpoa(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    View localView;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561677, null);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131381054));
      this.b = ((ImageView)localView.findViewById(2131375941));
      if ((this.jdField_a_of_type_AndroidContentContext instanceof EditVideoActivity))
      {
        localObject = ((EditVideoActivity)this.jdField_a_of_type_AndroidContentContext).a();
        if (localObject != null)
        {
          localObject = ((bpep)localObject).a;
          if (localObject != null)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject);
            this.b.setOnClickListener((View.OnClickListener)localObject);
            int i = zlx.c * 54 / 750;
            ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).setMargins(i, 0, i, 0);
            ((LinearLayout.LayoutParams)this.b.getLayoutParams()).setMargins(i, 0, i, 0);
          }
        }
        localView.setLayoutParams(new AbsListView.LayoutParams(paramViewGroup.getWidth(), paramViewGroup.getHeight()));
      }
    }
    for (localObject = localView;; localObject = null)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity)) {
        break;
      }
      localObject = ((EditPicActivity)this.jdField_a_of_type_AndroidContentContext).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpoa
 * JD-Core Version:    0.7.0.1
 */