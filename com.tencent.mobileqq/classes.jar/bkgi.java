import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.util.List;

public class bkgi
  extends bkfw<bkfp>
  implements View.OnClickListener
{
  public bkgi(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Bkfi == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new bkgj(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((bkfp)this.jdField_a_of_type_Bkfi).a(), ((bkfp)this.jdField_a_of_type_Bkfi).a(), this);; paramView = (bkgj)paramView)
    {
      paramView.a((bkfp)this.jdField_a_of_type_Bkfi, paramInt, getCount(), a());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131369540);
    int i = ((Integer)((ImageView)localObject1).getTag(2131376871)).intValue();
    paramView = (bkfq)((bkfp)this.jdField_a_of_type_Bkfi).jdField_a_of_type_JavaUtilList.get(i);
    Object localObject2 = (Boolean)((ImageView)localObject1).getTag(2131376849);
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
        f = (float)(f * ((bkfp)this.jdField_a_of_type_Bkfi).jdField_a_of_type_Double);
        localObject1 = bjiw.a();
        this.jdField_a_of_type_Bjcd.a(paramView, ((bjix)localObject1).a, ((bjix)localObject1).b, f);
        return;
      }
    }
    veg.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkgi
 * JD-Core Version:    0.7.0.1
 */