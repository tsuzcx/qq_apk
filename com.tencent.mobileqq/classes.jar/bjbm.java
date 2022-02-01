import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class bjbm
  extends bjgn
{
  public bjbm(BindGroupActivity paramBindGroupActivity) {}
  
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
      localObject = (bjbn)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      localObject = (bjbl)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((bjbl)localObject).b);
      paramView.jdField_a_of_type_JavaLangString = ((bjbl)localObject).c;
      Bitmap localBitmap = bjgt.a().a(((bjbl)localObject).c);
      if (localBitmap == null) {
        break label171;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562850, paramViewGroup, false);
      paramView = new bjbn();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366345));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379564));
      localView.setTag(paramView);
      break;
      label171:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840576);
      bjgt.a().a(((bjbl)localObject).c, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbm
 * JD-Core Version:    0.7.0.1
 */