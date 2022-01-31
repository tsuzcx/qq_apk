import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.BindGroupActivity;
import java.util.List;

public class beyp
  extends bfdg
{
  public beyp(BindGroupActivity paramBindGroupActivity) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (beyq)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = (beyo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((beyo)localObject).b);
      paramView.jdField_a_of_type_JavaLangString = ((beyo)localObject).c;
      Bitmap localBitmap = bfdm.a().a(((beyo)localObject).c);
      if (localBitmap == null) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return paramViewGroup;
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562610, paramViewGroup, false);
      paramView = new beyq();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365910));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378414));
      paramViewGroup.setTag(paramView);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840312);
    bfdm.a().a(((beyo)localObject).c, this.a);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyp
 * JD-Core Version:    0.7.0.1
 */