import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class bikc
  extends bioy
{
  public bikc(BindGroupActivity paramBindGroupActivity) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (bikd)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      localObject = (bikb)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((bikb)localObject).b);
      paramView.jdField_a_of_type_JavaLangString = ((bikb)localObject).c;
      Bitmap localBitmap = bipe.a().a(((bikb)localObject).c);
      if (localBitmap == null) {
        break label171;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562866, paramViewGroup, false);
      paramView = new bikd();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366164));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379323));
      localView.setTag(paramView);
      break;
      label171:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840492);
      bipe.a().a(((bikb)localObject).c, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bikc
 * JD-Core Version:    0.7.0.1
 */