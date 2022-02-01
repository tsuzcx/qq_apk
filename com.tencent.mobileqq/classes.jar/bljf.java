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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bljf
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<bljh> jdField_a_of_type_JavaUtilList;
  
  public bljf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static blir a(Context paramContext, bljf parambljf, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, bliz parambliz, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambljf == null) {
        return null;
      }
      blir localblir = (blir)blji.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131563067, null);
      paramContext.setBackgroundResource(2130837588);
      paramContext.setAdapter(parambljf);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localblir.a(paramContext);
      localblir.c(2131690580);
      if (paramBoolean) {
        localblir.setOnDismissListener(new bljg(paramOnDismissListener));
      }
      for (;;)
      {
        localblir.a(parambliz);
        return localblir;
        localblir.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static bljh a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new bljh();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((bljh)localObject1).a = 3;
      ((bljh)localObject1).b = 2131718162;
      ((bljh)localObject1).c = 2130839089;
      ((bljh)localObject1).d = 2131718547;
      return localObject1;
    case 2: 
      ((bljh)localObject1).a = 2;
      ((bljh)localObject1).b = 2131718171;
      ((bljh)localObject1).c = 2130839095;
      ((bljh)localObject1).d = 2131718564;
      return localObject1;
    case 0: 
      ((bljh)localObject1).a = 0;
      ((bljh)localObject1).b = 2131692419;
      ((bljh)localObject1).c = 2130839091;
      ((bljh)localObject1).d = 2131718556;
      return localObject1;
    case 1: 
      ((bljh)localObject1).a = 1;
      ((bljh)localObject1).b = 2131718166;
      ((bljh)localObject1).c = 2130839092;
      ((bljh)localObject1).d = 2131718557;
      return localObject1;
    case 5: 
      ((bljh)localObject1).a = 5;
      ((bljh)localObject1).b = 2131715920;
      ((bljh)localObject1).c = 2130842427;
      ((bljh)localObject1).d = 2131691912;
      return localObject1;
    case 4: 
      ((bljh)localObject1).a = 4;
      ((bljh)localObject1).c = 2130839087;
      ((bljh)localObject1).b = 2131718150;
      ((bljh)localObject1).d = 2131718540;
      return localObject1;
    case 6: 
      ((bljh)localObject1).a = 4;
      ((bljh)localObject1).c = 2130839087;
      ((bljh)localObject1).b = 2131718148;
      ((bljh)localObject1).d = 2131718546;
      return localObject1;
    }
    ((bljh)localObject1).a = 7;
    ((bljh)localObject1).c = 2130839088;
    ((bljh)localObject1).b = 2131718138;
    ((bljh)localObject1).d = 2131718543;
    return localObject1;
  }
  
  public void a(List<bljh> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bljh localbljh = (bljh)paramList.next();
        if ((localbljh != null) && (localbljh.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbljh);
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
    bljh localbljh = (bljh)getItem(paramInt);
    if (localbljh != null) {
      return localbljh.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bljh localbljh = (bljh)getItem(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563032, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131362822);
      TextView localTextView = (TextView)paramView.findViewById(2131362834);
      if (localbljh != null)
      {
        localImageView.setImageResource(localbljh.c);
        localTextView.setText(localbljh.b);
        if (AppSetting.c)
        {
          if (localbljh == null) {
            break label135;
          }
          paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbljh.d));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageResource(2130848222);
        localTextView.setText("");
        break;
        label135:
        paramView.setContentDescription("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljf
 * JD-Core Version:    0.7.0.1
 */