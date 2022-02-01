import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bhzp
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<bmnd> jdField_a_of_type_JavaUtilList;
  
  private bhzp(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bhzp a(@NonNull Activity paramActivity)
  {
    return new bhzp(paramActivity);
  }
  
  private bmnd a(@NonNull JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("type");
    Object localObject = new bmne();
    View localView = ((bmne)localObject).a(this.jdField_a_of_type_AndroidAppActivity, str);
    if (localView == null)
    {
      zdl.a("type=" + str + " is illegal json=" + paramJSONObject, new Object[0]);
      return null;
    }
    localObject = ((bmne)localObject).a(str, localView);
    if (localObject == null)
    {
      zdl.a("type=" + str + " create null view model json=" + paramJSONObject, new Object[0]);
      return null;
    }
    ((bmnd)localObject).a(paramJSONObject);
    return localObject;
  }
  
  public bhzp a(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    return this;
  }
  
  public bhzp a(@NonNull JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    }
    a();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = a((JSONObject)localObject);
        if (localObject != null)
        {
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          this.jdField_a_of_type_AndroidViewViewGroup.addView(((bmnd)localObject).a(), localLayoutParams);
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
      }
    }
    return this;
  }
  
  public bhzp a(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = a(paramJSONObject);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    }
    a();
    if (paramJSONObject == null) {
      return this;
    }
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramJSONObject.a(), localLayoutParams);
    this.jdField_a_of_type_JavaUtilList.add(paramJSONObject);
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmnd)localIterator.next()).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzp
 * JD-Core Version:    0.7.0.1
 */