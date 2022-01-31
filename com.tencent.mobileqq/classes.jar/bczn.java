import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.BindGroupActivity;
import java.util.List;

public class bczn
  extends bdei
{
  public bczn(BindGroupActivity paramBindGroupActivity) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (bczo)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = (bczm)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((bczm)localObject).b);
      paramView.jdField_a_of_type_JavaLangString = ((bczm)localObject).c;
      Bitmap localBitmap = bdeo.a().a(((bczm)localObject).c);
      if (localBitmap == null) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return paramViewGroup;
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562406, paramViewGroup, false);
      paramView = new bczo();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365824));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377869));
      paramViewGroup.setTag(paramView);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840209);
    bdeo.a().a(((bczm)localObject).c, this.a);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bczn
 * JD-Core Version:    0.7.0.1
 */