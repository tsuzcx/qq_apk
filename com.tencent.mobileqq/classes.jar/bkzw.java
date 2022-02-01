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

public class bkzw
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<bkzy> jdField_a_of_type_JavaUtilList;
  
  public bkzw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bkzi a(Context paramContext, bkzw parambkzw, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, bkzq parambkzq, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambkzw == null) {
        return null;
      }
      bkzi localbkzi = (bkzi)bkzz.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131563022, null);
      paramContext.setBackgroundResource(2130837588);
      paramContext.setAdapter(parambkzw);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localbkzi.a(paramContext);
      localbkzi.c(2131690697);
      if (paramBoolean) {
        localbkzi.setOnDismissListener(new bkzx(paramOnDismissListener));
      }
      for (;;)
      {
        localbkzi.a(parambkzq);
        return localbkzi;
        localbkzi.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static bkzy a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new bkzy();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((bkzy)localObject1).a = 3;
      ((bkzy)localObject1).b = 2131718789;
      ((bkzy)localObject1).c = 2130839144;
      ((bkzy)localObject1).d = 2131719185;
      return localObject1;
    case 2: 
      ((bkzy)localObject1).a = 2;
      ((bkzy)localObject1).b = 2131718798;
      ((bkzy)localObject1).c = 2130839150;
      ((bkzy)localObject1).d = 2131719205;
      return localObject1;
    case 0: 
      ((bkzy)localObject1).a = 0;
      ((bkzy)localObject1).b = 2131692569;
      ((bkzy)localObject1).c = 2130839146;
      ((bkzy)localObject1).d = 2131719197;
      return localObject1;
    case 1: 
      ((bkzy)localObject1).a = 1;
      ((bkzy)localObject1).b = 2131718793;
      ((bkzy)localObject1).c = 2130839147;
      ((bkzy)localObject1).d = 2131719198;
      return localObject1;
    case 5: 
      ((bkzy)localObject1).a = 5;
      ((bkzy)localObject1).b = 2131716510;
      ((bkzy)localObject1).c = 2130842503;
      ((bkzy)localObject1).d = 2131692048;
      return localObject1;
    case 4: 
      ((bkzy)localObject1).a = 4;
      ((bkzy)localObject1).c = 2130839142;
      ((bkzy)localObject1).b = 2131718777;
      ((bkzy)localObject1).d = 2131719178;
      return localObject1;
    case 6: 
      ((bkzy)localObject1).a = 4;
      ((bkzy)localObject1).c = 2130839142;
      ((bkzy)localObject1).b = 2131718775;
      ((bkzy)localObject1).d = 2131719184;
      return localObject1;
    }
    ((bkzy)localObject1).a = 7;
    ((bkzy)localObject1).c = 2130839143;
    ((bkzy)localObject1).b = 2131718765;
    ((bkzy)localObject1).d = 2131719181;
    return localObject1;
  }
  
  public void a(List<bkzy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bkzy localbkzy = (bkzy)paramList.next();
        if ((localbkzy != null) && (localbkzy.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbkzy);
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
    bkzy localbkzy = (bkzy)getItem(paramInt);
    if (localbkzy != null) {
      return localbkzy.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bkzy localbkzy = (bkzy)getItem(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562987, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131362846);
      TextView localTextView = (TextView)paramView.findViewById(2131362858);
      if (localbkzy != null)
      {
        localImageView.setImageResource(localbkzy.c);
        localTextView.setText(localbkzy.b);
        if (AppSetting.c)
        {
          if (localbkzy == null) {
            break label135;
          }
          paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbkzy.d));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageResource(2130848224);
        localTextView.setText("");
        break;
        label135:
        paramView.setContentDescription("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzw
 * JD-Core Version:    0.7.0.1
 */