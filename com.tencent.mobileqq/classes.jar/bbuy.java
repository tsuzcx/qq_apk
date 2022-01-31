import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.BindGroupActivity;
import java.util.List;

public class bbuy
  extends bbzt
{
  public bbuy(BindGroupActivity paramBindGroupActivity) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (bbuz)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = (bbux)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((bbux)localObject).b);
      paramView.jdField_a_of_type_JavaLangString = ((bbux)localObject).c;
      Bitmap localBitmap = bbzz.a().a(((bbux)localObject).c);
      if (localBitmap == null) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return paramViewGroup;
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496807, paramViewGroup, false);
      paramView = new bbuz();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300226));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312041));
      paramViewGroup.setTag(paramView);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840165);
    bbzz.a().a(((bbux)localObject).c, this.a);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbuy
 * JD-Core Version:    0.7.0.1
 */