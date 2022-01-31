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

public class bhup
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<bhur> jdField_a_of_type_JavaUtilList;
  
  public bhup(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bhuf a(Context paramContext, bhup parambhup, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, bhuk parambhuk, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambhup == null) {
        return null;
      }
      bhuf localbhuf = (bhuf)bhus.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131562793, null);
      paramContext.setBackgroundResource(2130837573);
      paramContext.setAdapter(parambhup);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localbhuf.a(paramContext);
      localbhuf.c(2131690648);
      if (paramBoolean) {
        localbhuf.setOnDismissListener(new bhuq(paramOnDismissListener));
      }
      for (;;)
      {
        localbhuf.a(parambhuk);
        return localbhuf;
        localbhuf.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static bhur a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new bhur();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((bhur)localObject1).a = 3;
      ((bhur)localObject1).b = 2131720055;
      ((bhur)localObject1).c = 2130838915;
      ((bhur)localObject1).d = 2131720613;
      return localObject1;
    case 2: 
      ((bhur)localObject1).a = 2;
      ((bhur)localObject1).b = 2131720066;
      ((bhur)localObject1).c = 2130838921;
      ((bhur)localObject1).d = 2131720630;
      return localObject1;
    case 0: 
      ((bhur)localObject1).a = 0;
      ((bhur)localObject1).b = 2131692880;
      ((bhur)localObject1).c = 2130838917;
      ((bhur)localObject1).d = 2131720622;
      return localObject1;
    case 1: 
      ((bhur)localObject1).a = 1;
      ((bhur)localObject1).b = 2131720060;
      ((bhur)localObject1).c = 2130838918;
      ((bhur)localObject1).d = 2131720623;
      return localObject1;
    case 5: 
      ((bhur)localObject1).a = 5;
      ((bhur)localObject1).b = 2131717586;
      ((bhur)localObject1).c = 2130842105;
      ((bhur)localObject1).d = 2131692303;
      return localObject1;
    case 4: 
      ((bhur)localObject1).a = 4;
      ((bhur)localObject1).c = 2130838913;
      ((bhur)localObject1).b = 2131720043;
      ((bhur)localObject1).d = 2131720606;
      return localObject1;
    case 6: 
      ((bhur)localObject1).a = 4;
      ((bhur)localObject1).c = 2130838913;
      ((bhur)localObject1).b = 2131720041;
      ((bhur)localObject1).d = 2131720612;
      return localObject1;
    }
    ((bhur)localObject1).a = 7;
    ((bhur)localObject1).c = 2130838914;
    ((bhur)localObject1).b = 2131720030;
    ((bhur)localObject1).d = 2131720609;
    return localObject1;
  }
  
  public void a(List<bhur> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bhur localbhur = (bhur)paramList.next();
        if ((localbhur != null) && (localbhur.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbhur);
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
    bhur localbhur = (bhur)getItem(paramInt);
    if (localbhur != null) {
      return localbhur.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bhur localbhur = (bhur)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562758, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131362695);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131362707);
    if (localbhur != null)
    {
      paramView.setImageResource(localbhur.c);
      localTextView.setText(localbhur.b);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        if (localbhur == null) {
          break;
        }
        paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbhur.d));
      }
      return paramViewGroup;
      paramView.setImageResource(2130847743);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhup
 * JD-Core Version:    0.7.0.1
 */