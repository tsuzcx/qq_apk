import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class bbez
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bbex jdField_a_of_type_Bbex;
  private List<bbfa> jdField_a_of_type_JavaUtilList;
  private List<bbfa> b;
  
  public bbez(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_a_of_type_Bbex = new bbex(this);
  }
  
  private void a()
  {
    this.b.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_Int != i) {
        this.b.add(this.jdField_a_of_type_JavaUtilList.get(i));
      }
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
    notifyDataSetChanged();
  }
  
  private void a(View paramView)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(bdoo.a(17.0F));
    localGradientDrawable.setColor(Color.parseColor("#FBFBFB"));
    localGradientDrawable.setStroke(1, Color.parseColor("#E7E7EE"));
    paramView.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void a(bbey parambbey)
  {
    if (this.jdField_a_of_type_Bbex != null) {
      this.jdField_a_of_type_Bbex.a(parambbey);
    }
  }
  
  public void a(List<bbfa> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (QLog.isColorLevel()) {
      QLog.d(bbev.a(), 2, new Object[] { "mPrefixList size: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
    this.jdField_a_of_type_Int = 0;
    a();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      Object localObject = new bbfb(null);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559772, paramViewGroup, false);
      ((bbfb)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372229));
      ((bbfb)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372231));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      localObject = (bbfa)this.b.get(paramInt);
      if (localObject != null) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((bbfa)localObject).a + ((bbfa)localObject).b + ((bbfa)localObject).c);
      }
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout);
      if (paramInt >= this.jdField_a_of_type_Int) {
        break label178;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Bbex);
      return paramView;
      paramViewGroup = (bbfb)paramView.getTag();
      break;
      label178:
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbez
 * JD-Core Version:    0.7.0.1
 */