import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhqi
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<bhqk> jdField_a_of_type_JavaUtilList;
  
  public bhqi(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bhpy a(Context paramContext, bhqi parambhqi, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, bhqd parambhqd, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambhqi == null) {
        return null;
      }
      bhpy localbhpy = (bhpy)bhql.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131562775, null);
      paramContext.setBackgroundResource(2130837573);
      paramContext.setAdapter(parambhqi);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localbhpy.a(paramContext);
      localbhpy.c(2131690648);
      if (paramBoolean) {
        localbhpy.setOnDismissListener(new bhqj(paramOnDismissListener));
      }
      for (;;)
      {
        localbhpy.a(parambhqd);
        return localbhpy;
        localbhpy.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static bhqk a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new bhqk();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((bhqk)localObject1).a = 3;
      ((bhqk)localObject1).b = 2131720043;
      ((bhqk)localObject1).c = 2130838914;
      ((bhqk)localObject1).d = 2131720601;
      return localObject1;
    case 2: 
      ((bhqk)localObject1).a = 2;
      ((bhqk)localObject1).b = 2131720054;
      ((bhqk)localObject1).c = 2130838920;
      ((bhqk)localObject1).d = 2131720618;
      return localObject1;
    case 0: 
      ((bhqk)localObject1).a = 0;
      ((bhqk)localObject1).b = 2131692878;
      ((bhqk)localObject1).c = 2130838916;
      ((bhqk)localObject1).d = 2131720610;
      return localObject1;
    case 1: 
      ((bhqk)localObject1).a = 1;
      ((bhqk)localObject1).b = 2131720048;
      ((bhqk)localObject1).c = 2130838917;
      ((bhqk)localObject1).d = 2131720611;
      return localObject1;
    case 5: 
      ((bhqk)localObject1).a = 5;
      ((bhqk)localObject1).b = 2131717574;
      ((bhqk)localObject1).c = 2130842092;
      ((bhqk)localObject1).d = 2131692302;
      return localObject1;
    case 4: 
      ((bhqk)localObject1).a = 4;
      ((bhqk)localObject1).c = 2130838912;
      ((bhqk)localObject1).b = 2131720031;
      ((bhqk)localObject1).d = 2131720594;
      return localObject1;
    case 6: 
      ((bhqk)localObject1).a = 4;
      ((bhqk)localObject1).c = 2130838912;
      ((bhqk)localObject1).b = 2131720029;
      ((bhqk)localObject1).d = 2131720600;
      return localObject1;
    }
    ((bhqk)localObject1).a = 7;
    ((bhqk)localObject1).c = 2130838913;
    ((bhqk)localObject1).b = 2131720018;
    ((bhqk)localObject1).d = 2131720597;
    return localObject1;
  }
  
  public void a(List<bhqk> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bhqk localbhqk = (bhqk)paramList.next();
        if ((localbhqk != null) && (localbhqk.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbhqk);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    bhqk localbhqk = (bhqk)getItem(paramInt);
    if (localbhqk != null) {
      return localbhqk.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bhqk localbhqk = (bhqk)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562740, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131362695);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131362707);
    if (localbhqk != null)
    {
      paramView.setImageResource(localbhqk.c);
      localTextView.setText(localbhqk.b);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        if (localbhqk == null) {
          break;
        }
        paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbhqk.d));
      }
      return paramViewGroup;
      paramView.setImageResource(2130847670);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhqi
 * JD-Core Version:    0.7.0.1
 */