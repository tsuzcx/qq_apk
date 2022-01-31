import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.util.List;

public class bmwv
  extends bmwj<bmwc>
  implements View.OnClickListener
{
  public bmwv(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Bmvv == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new bmww(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bmwc)this.jdField_a_of_type_Bmvv).a(), ((bmwc)this.jdField_a_of_type_Bmvv).a(), this);; paramView = (bmww)paramView)
    {
      paramView.a((bmwc)this.jdField_a_of_type_Bmvv, paramInt, getCount(), a());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131369820);
    int i = ((Integer)((ImageView)localObject1).getTag(2131377441)).intValue();
    paramView = (bmwd)((bmwc)this.jdField_a_of_type_Bmvv).jdField_a_of_type_JavaUtilList.get(i);
    Object localObject2 = (Boolean)((ImageView)localObject1).getTag(2131377419);
    if ((localObject2 != null) && (((Boolean)localObject2).booleanValue()))
    {
      paramView.a = ((ImageView)localObject1).getDrawable();
      localObject2 = paramView.a;
      int j;
      int k;
      if (localObject2 != null)
      {
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        i = ((Drawable)localObject2).getIntrinsicWidth();
        j = ((ImageView)localObject1).getWidth();
        k = ((ImageView)localObject1).getPaddingLeft();
        if (j <= i) {
          break label195;
        }
      }
      label195:
      for (float f = (((j - i) / 2 - k) * 2 + i) / i;; f = (i - (k + (i - j) / 2) * 2) / i)
      {
        f = (float)(f * ((bmwc)this.jdField_a_of_type_Bmvv).jdField_a_of_type_Double);
        localObject1 = blzk.a();
        this.jdField_a_of_type_Blsr.a(paramView, ((blzl)localObject1).a, ((blzl)localObject1).b, f);
        return;
      }
    }
    wxe.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwv
 * JD-Core Version:    0.7.0.1
 */