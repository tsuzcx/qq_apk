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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgbn
  extends BaseAdapter
{
  public bgbn(TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
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
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new bgbq();
      paramView = LayoutInflater.from(this.a).inflate(2131563025, paramViewGroup, false);
      ((bgbq)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379332));
      ((bgbq)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379334));
      ((bgbq)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379333);
      paramView.setTag(localObject1);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localColorDrawable;
      localObject2 = URLDrawable.getDrawable(this.a.a[paramInt].jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setTag(bgey.b(190, 270, bggq.a(this.a, 3.0F)));
      ((URLDrawable)localObject2).setDecodeHandler(bgey.j);
      ((bgbq)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      ((bgbq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a[paramInt].jdField_a_of_type_JavaLangString);
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setShape(0);
      ((GradientDrawable)localObject2).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, bggq.a(this.a, 5.0F), bggq.a(this.a, 5.0F), bggq.a(this.a, 5.0F), bggq.a(this.a, 5.0F) });
      ((GradientDrawable)localObject2).setColor(this.a.a[paramInt].jdField_b_of_type_Int);
      ((bgbq)localObject1).jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
      localObject1 = ((bgbq)localObject1).jdField_a_of_type_AndroidViewView;
      if (!this.a.a[paramInt].jdField_a_of_type_Boolean) {
        break label363;
      }
    }
    label363:
    for (int i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (bgbq)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbn
 * JD-Core Version:    0.7.0.1
 */