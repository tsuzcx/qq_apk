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

public class bkic
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<bkie> jdField_a_of_type_JavaUtilList;
  
  public bkic(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bkho a(Context paramContext, bkic parambkic, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, bkhw parambkhw, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambkic == null) {
        return null;
      }
      bkho localbkho = (bkho)bkif.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131563032, null);
      paramContext.setBackgroundResource(2130837588);
      paramContext.setAdapter(parambkic);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localbkho.a(paramContext);
      localbkho.c(2131690582);
      if (paramBoolean) {
        localbkho.setOnDismissListener(new bkid(paramOnDismissListener));
      }
      for (;;)
      {
        localbkho.a(parambkhw);
        return localbkho;
        localbkho.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static bkie a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new bkie();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((bkie)localObject1).a = 3;
      ((bkie)localObject1).b = 2131718030;
      ((bkie)localObject1).c = 2130839081;
      ((bkie)localObject1).d = 2131718411;
      return localObject1;
    case 2: 
      ((bkie)localObject1).a = 2;
      ((bkie)localObject1).b = 2131718038;
      ((bkie)localObject1).c = 2130839087;
      ((bkie)localObject1).d = 2131718428;
      return localObject1;
    case 0: 
      ((bkie)localObject1).a = 0;
      ((bkie)localObject1).b = 2131692413;
      ((bkie)localObject1).c = 2130839083;
      ((bkie)localObject1).d = 2131718420;
      return localObject1;
    case 1: 
      ((bkie)localObject1).a = 1;
      ((bkie)localObject1).b = 2131718034;
      ((bkie)localObject1).c = 2130839084;
      ((bkie)localObject1).d = 2131718421;
      return localObject1;
    case 5: 
      ((bkie)localObject1).a = 5;
      ((bkie)localObject1).b = 2131715811;
      ((bkie)localObject1).c = 2130842415;
      ((bkie)localObject1).d = 2131691908;
      return localObject1;
    case 4: 
      ((bkie)localObject1).a = 4;
      ((bkie)localObject1).c = 2130839079;
      ((bkie)localObject1).b = 2131718018;
      ((bkie)localObject1).d = 2131718404;
      return localObject1;
    case 6: 
      ((bkie)localObject1).a = 4;
      ((bkie)localObject1).c = 2130839079;
      ((bkie)localObject1).b = 2131718016;
      ((bkie)localObject1).d = 2131718410;
      return localObject1;
    }
    ((bkie)localObject1).a = 7;
    ((bkie)localObject1).c = 2130839080;
    ((bkie)localObject1).b = 2131718006;
    ((bkie)localObject1).d = 2131718407;
    return localObject1;
  }
  
  public void a(List<bkie> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bkie localbkie = (bkie)paramList.next();
        if ((localbkie != null) && (localbkie.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbkie);
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
    bkie localbkie = (bkie)getItem(paramInt);
    if (localbkie != null) {
      return localbkie.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bkie localbkie = (bkie)getItem(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562997, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131362804);
      TextView localTextView = (TextView)paramView.findViewById(2131362816);
      if (localbkie != null)
      {
        localImageView.setImageResource(localbkie.c);
        localTextView.setText(localbkie.b);
        if (AppSetting.c)
        {
          if (localbkie == null) {
            break label135;
          }
          paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbkie.d));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageResource(2130848203);
        localTextView.setText("");
        break;
        label135:
        paramView.setContentDescription("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkic
 * JD-Core Version:    0.7.0.1
 */