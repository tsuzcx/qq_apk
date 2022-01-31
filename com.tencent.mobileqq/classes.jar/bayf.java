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

public class bayf
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private bbam jdField_a_of_type_Bbam;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private boolean jdField_b_of_type_Boolean;
  
  public bayf(ListView paramListView, bbam parambbam, List<bbar> paramList)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Bbam = parambbam;
    this.jdField_a_of_type_Bbam.a(paramList);
    a(this.jdField_a_of_type_AndroidWidgetListView);
    parambbam = this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams();
    parambbam.height = this.jdField_a_of_type_Int;
    parambbam.width = this.jdField_b_of_type_Int;
    paramListView.setLayoutParams(parambbam);
    this.jdField_a_of_type_AndroidWidgetListView.setPadding(bcwh.a(this.jdField_a_of_type_AndroidWidgetListView.getContext(), 8.0F), -this.jdField_a_of_type_Int, 0, 0);
  }
  
  public static List<bbar> a(JSONArray paramJSONArray)
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
        bbar localbbar = new bbar();
        try
        {
          localbbar.a(localJSONObject);
          if (localbbar.a()) {
            localArrayList.add(localbbar);
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
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bayg(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bayh(this));
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, -this.jdField_a_of_type_Int });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(100L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bayi(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new bayj(this));
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
    this.jdField_b_of_type_Int += bcwh.a(this.jdField_a_of_type_AndroidWidgetListView.getContext(), 8.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayf
 * JD-Core Version:    0.7.0.1
 */