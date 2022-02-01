import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class bfek
  extends BaseAdapter
{
  List<bfxy> jdField_a_of_type_JavaUtilList;
  
  bfek(List<bfxy> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bfel localbfel;
    bfxy localbfxy;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Bfej.getContext()).inflate(2131560660, null);
      localbfel = new bfel(this.jdField_a_of_type_Bfej);
      localbfel.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371803));
      localbfel.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368115));
      localbfel.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369774));
      localbfel.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370108);
      paramView.setOnClickListener(this.jdField_a_of_type_Bfej);
      paramView.setTag(localbfel);
      localbfxy = (bfxy)getItem(paramInt);
      localbfel.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbfxy.a.getTroopName());
      if (localbfxy.a.lastMsgTime == 0L) {
        break label298;
      }
      localbfel.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbfel.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131707028) + TimeManager.getInstance().getMsgDisplayTime(localbfxy.a.troopuin, localbfxy.a.lastMsgTime));
      label200:
      if (!localbfxy.a.hasSetTroopHead()) {
        break label387;
      }
    }
    label387:
    for (int i = 4;; i = 113)
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_Bfej.a, i, localbfxy.a.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
      localbfel.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      localbfel.jdField_a_of_type_JavaLangString = localbfxy.a.troopuin;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbfel = (bfel)paramView.getTag();
      break;
      label298:
      if (localbfxy.a.troopCreateTime != 0L)
      {
        localbfel.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localbfel.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131707033) + TimeManager.getInstance().getMsgDisplayTime(localbfxy.a.troopuin, localbfxy.a.troopCreateTime));
        break label200;
      }
      localbfel.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label200;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfek
 * JD-Core Version:    0.7.0.1
 */