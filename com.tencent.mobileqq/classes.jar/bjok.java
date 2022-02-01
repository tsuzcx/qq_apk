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

public class bjok
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<bjom> jdField_a_of_type_JavaUtilList;
  
  public bjok(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bjnw a(Context paramContext, bjok parambjok, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, bjoe parambjoe, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambjok == null) {
        return null;
      }
      bjnw localbjnw = (bjnw)bjon.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131562948, null);
      paramContext.setBackgroundResource(2130837588);
      paramContext.setAdapter(parambjok);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localbjnw.a(paramContext);
      localbjnw.c(2131690620);
      if (paramBoolean) {
        localbjnw.setOnDismissListener(new bjol(paramOnDismissListener));
      }
      for (;;)
      {
        localbjnw.a(parambjoe);
        return localbjnw;
        localbjnw.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static bjom a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new bjom();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((bjom)localObject1).a = 3;
      ((bjom)localObject1).b = 2131718403;
      ((bjom)localObject1).c = 2130839124;
      ((bjom)localObject1).d = 2131718795;
      return localObject1;
    case 2: 
      ((bjom)localObject1).a = 2;
      ((bjom)localObject1).b = 2131718412;
      ((bjom)localObject1).c = 2130839130;
      ((bjom)localObject1).d = 2131718812;
      return localObject1;
    case 0: 
      ((bjom)localObject1).a = 0;
      ((bjom)localObject1).b = 2131692467;
      ((bjom)localObject1).c = 2130839126;
      ((bjom)localObject1).d = 2131718804;
      return localObject1;
    case 1: 
      ((bjom)localObject1).a = 1;
      ((bjom)localObject1).b = 2131718407;
      ((bjom)localObject1).c = 2130839127;
      ((bjom)localObject1).d = 2131718805;
      return localObject1;
    case 5: 
      ((bjom)localObject1).a = 5;
      ((bjom)localObject1).b = 2131716154;
      ((bjom)localObject1).c = 2130842473;
      ((bjom)localObject1).d = 2131691958;
      return localObject1;
    case 4: 
      ((bjom)localObject1).a = 4;
      ((bjom)localObject1).c = 2130839122;
      ((bjom)localObject1).b = 2131718391;
      ((bjom)localObject1).d = 2131718788;
      return localObject1;
    case 6: 
      ((bjom)localObject1).a = 4;
      ((bjom)localObject1).c = 2130839122;
      ((bjom)localObject1).b = 2131718389;
      ((bjom)localObject1).d = 2131718794;
      return localObject1;
    }
    ((bjom)localObject1).a = 7;
    ((bjom)localObject1).c = 2130839123;
    ((bjom)localObject1).b = 2131718379;
    ((bjom)localObject1).d = 2131718791;
    return localObject1;
  }
  
  public void a(List<bjom> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bjom localbjom = (bjom)paramList.next();
        if ((localbjom != null) && (localbjom.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbjom);
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
    bjom localbjom = (bjom)getItem(paramInt);
    if (localbjom != null) {
      return localbjom.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bjom localbjom = (bjom)getItem(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562913, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131362830);
      TextView localTextView = (TextView)paramView.findViewById(2131362842);
      if (localbjom != null)
      {
        localImageView.setImageResource(localbjom.c);
        localTextView.setText(localbjom.b);
        if (AppSetting.c)
        {
          if (localbjom == null) {
            break label135;
          }
          paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbjom.d));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageResource(2130848133);
        localTextView.setText("");
        break;
        label135:
        paramView.setContentDescription("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjok
 * JD-Core Version:    0.7.0.1
 */