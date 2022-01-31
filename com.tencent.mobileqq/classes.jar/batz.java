import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;

public class batz
  extends BaseAdapter
{
  public batz(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public int getCount()
  {
    return this.a.a.length;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.a[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return this.a.a[paramInt].jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new bauc();
      Object localObject = LayoutInflater.from(this.a).inflate(2131562566, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131377878));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131377880));
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131377879);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable(this.a.a[paramInt].jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bavw.b(190, 270, baxn.a(this.a, 3.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bavw.i);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a[paramInt].jdField_a_of_type_JavaLangString);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, baxn.a(this.a, 5.0F), baxn.a(this.a, 5.0F), baxn.a(this.a, 5.0F), baxn.a(this.a, 5.0F) });
      ((GradientDrawable)localObject).setColor(this.a.a[paramInt].jdField_b_of_type_Int);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
      paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (!this.a.a[paramInt].jdField_a_of_type_Boolean) {
        break label345;
      }
    }
    label345:
    for (paramInt = 0;; paramInt = 8)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (bauc)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batz
 * JD-Core Version:    0.7.0.1
 */