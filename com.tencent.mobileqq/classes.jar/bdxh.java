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

class bdxh
  extends BaseAdapter
{
  List<beqw> jdField_a_of_type_JavaUtilList;
  
  bdxh(List<beqw> paramList)
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
    bdxi localbdxi;
    beqw localbeqw;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Bdxg.getContext()).inflate(2131560608, null);
      localbdxi = new bdxi(this.jdField_a_of_type_Bdxg);
      localbdxi.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371615));
      localbdxi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367979));
      localbdxi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369605));
      localbdxi.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369938);
      paramView.setOnClickListener(this.jdField_a_of_type_Bdxg);
      paramView.setTag(localbdxi);
      localbeqw = (beqw)getItem(paramInt);
      localbdxi.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbeqw.a.getTroopName());
      if (localbeqw.a.lastMsgTime == 0L) {
        break label298;
      }
      localbdxi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbdxi.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131706676) + TimeManager.getInstance().getMsgDisplayTime(localbeqw.a.troopuin, localbeqw.a.lastMsgTime));
      label200:
      if (!localbeqw.a.hasSetTroopHead()) {
        break label387;
      }
    }
    label387:
    for (int i = 4;; i = 113)
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_Bdxg.a, i, localbeqw.a.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
      localbdxi.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      localbdxi.jdField_a_of_type_JavaLangString = localbeqw.a.troopuin;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbdxi = (bdxi)paramView.getTag();
      break;
      label298:
      if (localbeqw.a.troopCreateTime != 0L)
      {
        localbdxi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localbdxi.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131706681) + TimeManager.getInstance().getMsgDisplayTime(localbeqw.a.troopuin, localbeqw.a.troopCreateTime));
        break label200;
      }
      localbdxi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label200;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxh
 * JD-Core Version:    0.7.0.1
 */