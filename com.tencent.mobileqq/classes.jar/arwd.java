import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class arwd
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private arwg jdField_a_of_type_Arwg;
  private arxb jdField_a_of_type_Arxb;
  private List<LocationRoom.Venue> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = -1;
  
  arwd(Context paramContext)
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
    if ((this.jdField_a_of_type_Arxb.a()) && (this.jdField_a_of_type_Arwg != null)) {
      this.jdField_a_of_type_Arwg.a(1);
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
    if (this.jdField_a_of_type_Arwg != null) {
      this.jdField_a_of_type_Arwg.a(4);
    }
  }
  
  void a(arwg paramarwg)
  {
    this.jdField_a_of_type_Arwg = paramarwg;
  }
  
  public void a(BaseActivity paramBaseActivity, TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.jdField_a_of_type_Arxb = new arxb(paramBaseActivity, paramTencentMap, paramLatLng, paramString);
    this.jdField_a_of_type_Arxb.a(new arwe(this, paramString));
    if ((this.jdField_a_of_type_Arxb.a()) && (this.jdField_a_of_type_Arwg != null)) {
      this.jdField_a_of_type_Arwg.a(0);
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
      if (this.jdField_a_of_type_Arxb.b()) {
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
      paramViewGroup = new arwf();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559160, null);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365066);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370660));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362129));
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131375797);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(4);
      paramViewGroup.c = paramView.findViewById(2131370422);
      paramView.setTag(paramViewGroup);
      if ((!this.jdField_a_of_type_Arxb.b()) || (paramInt != this.jdField_a_of_type_JavaUtilList.size())) {
        break label148;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label148:
    LocationRoom.Venue localVenue;
    do
    {
      return paramView;
      paramViewGroup = (arwf)paramView.getTag();
      break;
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localVenue = a(paramInt);
    } while (localVenue == null);
    paramViewGroup.c.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    String str = localVenue.b + localVenue.c;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693998), new Object[] { localVenue.b }));
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + localVenue.c;
    }
    for (paramViewGroup = paramViewGroup + this.jdField_a_of_type_AndroidContentContext.getString(2131695229);; paramViewGroup = str + this.jdField_a_of_type_AndroidContentContext.getString(2131695230))
    {
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwd
 * JD-Core Version:    0.7.0.1
 */