import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class avem
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private avep jdField_a_of_type_Avep;
  private avfk jdField_a_of_type_Avfk;
  private List<LocationRoom.Venue> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = -1;
  
  avem(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  LocationRoom.Venue a()
  {
    if (this.jdField_a_of_type_Int < 0) {
      return null;
    }
    return a(this.jdField_a_of_type_Int);
  }
  
  public LocationRoom.Venue a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (LocationRoom.Venue)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_Avfk.a()) && (this.jdField_a_of_type_Avep != null)) {
      this.jdField_a_of_type_Avep.a(1);
    }
  }
  
  void a(int paramInt)
  {
    LocationRoom.Venue localVenue1 = (LocationRoom.Venue)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (this.b > 0)
    {
      LocationRoom.Venue localVenue2 = (LocationRoom.Venue)this.jdField_a_of_type_JavaUtilList.remove(0);
      this.jdField_a_of_type_JavaUtilList.add(this.b, localVenue2);
    }
    this.jdField_a_of_type_JavaUtilList.remove(localVenue1);
    this.jdField_a_of_type_JavaUtilList.add(0, localVenue1);
    this.b = paramInt;
    this.jdField_a_of_type_Int = 0;
    notifyDataSetChanged();
    if (this.jdField_a_of_type_Avep != null) {
      this.jdField_a_of_type_Avep.a(4);
    }
  }
  
  void a(avep paramavep)
  {
    this.jdField_a_of_type_Avep = paramavep;
  }
  
  public void a(BaseActivity paramBaseActivity, TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.jdField_a_of_type_Avfk = new avfk(paramBaseActivity, paramTencentMap, paramLatLng, paramString);
    this.jdField_a_of_type_Avfk.a(new aven(this, paramString));
    if ((this.jdField_a_of_type_Avfk.a()) && (this.jdField_a_of_type_Avep != null)) {
      this.jdField_a_of_type_Avep.a(0);
    }
    this.b = -1;
    this.jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_Avfk.b()) {
        i = this.jdField_a_of_type_JavaUtilList.size() + 1;
      }
    }
    else {
      return i;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"InflateParams"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      localObject = new aveo();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559288, null);
      ((aveo)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365469);
      ((aveo)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371627));
      ((aveo)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362208));
      ((aveo)localObject).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377028);
      ((aveo)localObject).jdField_b_of_type_AndroidViewView.setVisibility(4);
      ((aveo)localObject).c = paramView.findViewById(2131371377);
      paramView.setTag(localObject);
    }
    while ((this.jdField_a_of_type_Avfk.b()) && (paramInt == this.jdField_a_of_type_JavaUtilList.size()))
    {
      ((aveo)localObject).c.setVisibility(0);
      ((aveo)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (aveo)paramView.getTag();
    }
    ((aveo)localObject).c.setVisibility(8);
    ((aveo)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = a(paramInt);
    String str;
    if (localVenue != null)
    {
      ((aveo)localObject).c.setVisibility(8);
      ((aveo)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((aveo)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
      str = localVenue.b + localVenue.c;
      if (paramInt != this.jdField_a_of_type_Int) {
        break label387;
      }
      ((aveo)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693514), new Object[] { localVenue.b }));
      ((aveo)localObject).jdField_b_of_type_AndroidViewView.setVisibility(0);
      localObject = ((aveo)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString() + localVenue.c;
    }
    for (Object localObject = (String)localObject + this.jdField_a_of_type_AndroidContentContext.getString(2131694514);; localObject = str + this.jdField_a_of_type_AndroidContentContext.getString(2131694515))
    {
      paramView.setContentDescription((CharSequence)localObject);
      break;
      label387:
      ((aveo)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
      ((aveo)localObject).jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avem
 * JD-Core Version:    0.7.0.1
 */