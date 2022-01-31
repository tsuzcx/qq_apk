import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.util.List;

public class bipn
  extends bipb<biou>
  implements View.OnClickListener
{
  public bipn(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Bion == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new bipo(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((biou)this.jdField_a_of_type_Bion).a(), ((biou)this.jdField_a_of_type_Bion).a(), this);; paramView = (bipo)paramView)
    {
      paramView.a((biou)this.jdField_a_of_type_Bion, paramInt, getCount(), a());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131303865);
    int i = ((Integer)((ImageView)localObject1).getTag(2131311062)).intValue();
    paramView = (biov)((biou)this.jdField_a_of_type_Bion).jdField_a_of_type_JavaUtilList.get(i);
    Object localObject2 = (Boolean)((ImageView)localObject1).getTag(2131311040);
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
        f = (float)(f * ((biou)this.jdField_a_of_type_Bion).jdField_a_of_type_Double);
        localObject1 = bhoe.a();
        this.jdField_a_of_type_Bhhl.a(paramView, ((bhof)localObject1).a, ((bhof)localObject1).b, f);
        return;
      }
    }
    urk.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipn
 * JD-Core Version:    0.7.0.1
 */