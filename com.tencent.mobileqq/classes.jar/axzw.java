import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class axzw
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private aycb jdField_a_of_type_Aycb;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private boolean jdField_b_of_type_Boolean;
  
  public axzw(ListView paramListView, aycb paramaycb, List<aycg> paramList)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Aycb = paramaycb;
    this.jdField_a_of_type_Aycb.a(paramList);
    a(this.jdField_a_of_type_AndroidWidgetListView);
    paramaycb = this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams();
    paramaycb.height = this.jdField_a_of_type_Int;
    paramaycb.width = this.jdField_b_of_type_Int;
    paramListView.setLayoutParams(paramaycb);
    this.jdField_a_of_type_AndroidWidgetListView.setPadding(azvv.a(this.jdField_a_of_type_AndroidWidgetListView.getContext(), 8.0F), -this.jdField_a_of_type_Int, 0, 0);
  }
  
  public static List<aycg> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TribePostTitlePrefixPanelController", 2, "prefixJArray is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        aycg localaycg = new aycg();
        try
        {
          localaycg.a(localJSONObject);
          if (localaycg.a()) {
            localArrayList.add(localaycg);
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("TribePostTitlePrefixPanelController", 2, "analyze error , " + localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { -this.jdField_a_of_type_Int, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(100L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new axzx(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new axzy(this));
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.jdField_a_of_type_Int });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(100L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new axzz(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new ayaa(this));
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
        d();
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new BounceInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void a(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int k = localListAdapter.getCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      View localView = localListAdapter.getView(i, null, paramListView);
      localView.measure(0, 0);
      j += localView.getMeasuredHeight();
      int m = localView.getMeasuredWidth();
      if (m > this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = m;
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
    this.jdField_b_of_type_Int += azvv.a(this.jdField_a_of_type_AndroidWidgetListView.getContext(), 8.0F);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0;
  }
  
  public void b()
  {
    if ((a()) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null) {
        e();
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidWidgetListView.getVisibility() != 0) || (this.jdField_b_of_type_Boolean);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axzw
 * JD-Core Version:    0.7.0.1
 */