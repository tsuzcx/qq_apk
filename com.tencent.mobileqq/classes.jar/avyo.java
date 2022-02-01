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

public class avyo
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private avyr jdField_a_of_type_Avyr;
  private avzm jdField_a_of_type_Avzm;
  private List<LocationRoom.Venue> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = -1;
  
  avyo(Context paramContext)
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
    if ((this.jdField_a_of_type_Avzm.a()) && (this.jdField_a_of_type_Avyr != null)) {
      this.jdField_a_of_type_Avyr.a(1);
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
    if (this.jdField_a_of_type_Avyr != null) {
      this.jdField_a_of_type_Avyr.a(4);
    }
  }
  
  void a(avyr paramavyr)
  {
    this.jdField_a_of_type_Avyr = paramavyr;
  }
  
  public void a(BaseActivity paramBaseActivity, TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.jdField_a_of_type_Avzm = new avzm(paramBaseActivity, paramTencentMap, paramLatLng, paramString);
    this.jdField_a_of_type_Avzm.a(new avyp(this, paramString));
    if ((this.jdField_a_of_type_Avzm.a()) && (this.jdField_a_of_type_Avyr != null)) {
      this.jdField_a_of_type_Avyr.a(0);
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
      if (this.jdField_a_of_type_Avzm.b()) {
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
      localObject = new avyq();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559282, null);
      ((avyq)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365393);
      ((avyq)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371551));
      ((avyq)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362197));
      ((avyq)localObject).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377138);
      ((avyq)localObject).jdField_b_of_type_AndroidViewView.setVisibility(4);
      ((avyq)localObject).c = paramView.findViewById(2131371302);
      paramView.setTag(localObject);
    }
    while ((this.jdField_a_of_type_Avzm.b()) && (paramInt == this.jdField_a_of_type_JavaUtilList.size()))
    {
      ((avyq)localObject).c.setVisibility(0);
      ((avyq)localObject).jdField_a_of_type_AndroidViewView.setVisibility(8);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (avyq)paramView.getTag();
    }
    ((avyq)localObject).c.setVisibility(8);
    ((avyq)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = a(paramInt);
    String str;
    if (localVenue != null)
    {
      ((avyq)localObject).c.setVisibility(8);
      ((avyq)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((avyq)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
      str = localVenue.b + localVenue.c;
      if (paramInt != this.jdField_a_of_type_Int) {
        break label387;
      }
      ((avyq)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693407), new Object[] { localVenue.b }));
      ((avyq)localObject).jdField_b_of_type_AndroidViewView.setVisibility(0);
      localObject = ((avyq)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString() + localVenue.c;
    }
    for (Object localObject = (String)localObject + this.jdField_a_of_type_AndroidContentContext.getString(2131694358);; localObject = str + this.jdField_a_of_type_AndroidContentContext.getString(2131694359))
    {
      paramView.setContentDescription((CharSequence)localObject);
      break;
      label387:
      ((avyq)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
      ((avyq)localObject).jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyo
 * JD-Core Version:    0.7.0.1
 */