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

public class behb
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<behd> jdField_a_of_type_JavaUtilList;
  
  public behb(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static begr a(Context paramContext, behb parambehb, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, begw parambegw, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambehb == null) {
        return null;
      }
      begr localbegr = (begr)behe.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131496974, null);
      paramContext.setBackgroundResource(2130837567);
      paramContext.setAdapter(parambehb);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localbegr.a(paramContext);
      localbegr.c(2131625035);
      if (paramBoolean) {
        localbegr.setOnDismissListener(new behc(paramOnDismissListener));
      }
      for (;;)
      {
        localbegr.a(parambegw);
        return localbegr;
        localbegr.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static behd a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new behd();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((behd)localObject1).a = 3;
      ((behd)localObject1).b = 2131653617;
      ((behd)localObject1).c = 2130838730;
      ((behd)localObject1).d = 2131654164;
      return localObject1;
    case 2: 
      ((behd)localObject1).a = 2;
      ((behd)localObject1).b = 2131653628;
      ((behd)localObject1).c = 2130838736;
      ((behd)localObject1).d = 2131654181;
      return localObject1;
    case 0: 
      ((behd)localObject1).a = 0;
      ((behd)localObject1).b = 2131627157;
      ((behd)localObject1).c = 2130838732;
      ((behd)localObject1).d = 2131654173;
      return localObject1;
    case 1: 
      ((behd)localObject1).a = 1;
      ((behd)localObject1).b = 2131653622;
      ((behd)localObject1).c = 2130838733;
      ((behd)localObject1).d = 2131654174;
      return localObject1;
    case 5: 
      ((behd)localObject1).a = 5;
      ((behd)localObject1).b = 2131651399;
      ((behd)localObject1).c = 2130841846;
      ((behd)localObject1).d = 2131626640;
      return localObject1;
    case 4: 
      ((behd)localObject1).a = 4;
      ((behd)localObject1).c = 2130838728;
      ((behd)localObject1).b = 2131653605;
      ((behd)localObject1).d = 2131654157;
      return localObject1;
    case 6: 
      ((behd)localObject1).a = 4;
      ((behd)localObject1).c = 2130838728;
      ((behd)localObject1).b = 2131653603;
      ((behd)localObject1).d = 2131654163;
      return localObject1;
    }
    ((behd)localObject1).a = 7;
    ((behd)localObject1).c = 2130838729;
    ((behd)localObject1).b = 2131653594;
    ((behd)localObject1).d = 2131654160;
    return localObject1;
  }
  
  public void a(List<behd> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        behd localbehd = (behd)paramList.next();
        if ((localbehd != null) && (localbehd.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbehd);
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
    behd localbehd = (behd)getItem(paramInt);
    if (localbehd != null) {
      return localbehd.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    behd localbehd = (behd)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496938, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131297128);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131297140);
    if (localbehd != null)
    {
      paramView.setImageResource(localbehd.c);
      localTextView.setText(localbehd.b);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        if (localbehd == null) {
          break;
        }
        paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbehd.d));
      }
      return paramViewGroup;
      paramView.setImageResource(2130847074);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     behb
 * JD-Core Version:    0.7.0.1
 */