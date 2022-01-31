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

public class bfov
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<bfox> jdField_a_of_type_JavaUtilList;
  
  public bfov(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bfol a(Context paramContext, bfov parambfov, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, bfoq parambfoq, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambfov == null) {
        return null;
      }
      bfol localbfol = (bfol)bfoy.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131562574, null);
      paramContext.setBackgroundResource(2130837572);
      paramContext.setAdapter(parambfov);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localbfol.a(paramContext);
      localbfol.c(2131690596);
      if (paramBoolean) {
        localbfol.setOnDismissListener(new bfow(paramOnDismissListener));
      }
      for (;;)
      {
        localbfol.a(parambfoq);
        return localbfol;
        localbfol.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static bfox a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new bfox();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((bfox)localObject1).a = 3;
      ((bfox)localObject1).b = 2131719500;
      ((bfox)localObject1).c = 2130838752;
      ((bfox)localObject1).d = 2131720054;
      return localObject1;
    case 2: 
      ((bfox)localObject1).a = 2;
      ((bfox)localObject1).b = 2131719511;
      ((bfox)localObject1).c = 2130838758;
      ((bfox)localObject1).d = 2131720071;
      return localObject1;
    case 0: 
      ((bfox)localObject1).a = 0;
      ((bfox)localObject1).b = 2131692795;
      ((bfox)localObject1).c = 2130838754;
      ((bfox)localObject1).d = 2131720063;
      return localObject1;
    case 1: 
      ((bfox)localObject1).a = 1;
      ((bfox)localObject1).b = 2131719505;
      ((bfox)localObject1).c = 2130838755;
      ((bfox)localObject1).d = 2131720064;
      return localObject1;
    case 5: 
      ((bfox)localObject1).a = 5;
      ((bfox)localObject1).b = 2131717191;
      ((bfox)localObject1).c = 2130841940;
      ((bfox)localObject1).d = 2131692226;
      return localObject1;
    case 4: 
      ((bfox)localObject1).a = 4;
      ((bfox)localObject1).c = 2130838750;
      ((bfox)localObject1).b = 2131719488;
      ((bfox)localObject1).d = 2131720047;
      return localObject1;
    case 6: 
      ((bfox)localObject1).a = 4;
      ((bfox)localObject1).c = 2130838750;
      ((bfox)localObject1).b = 2131719486;
      ((bfox)localObject1).d = 2131720053;
      return localObject1;
    }
    ((bfox)localObject1).a = 7;
    ((bfox)localObject1).c = 2130838751;
    ((bfox)localObject1).b = 2131719475;
    ((bfox)localObject1).d = 2131720050;
    return localObject1;
  }
  
  public void a(List<bfox> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bfox localbfox = (bfox)paramList.next();
        if ((localbfox != null) && (localbfox.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbfox);
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
    bfox localbfox = (bfox)getItem(paramInt);
    if (localbfox != null) {
      return localbfox.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bfox localbfox = (bfox)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562538, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131362668);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131362680);
    if (localbfox != null)
    {
      paramView.setImageResource(localbfox.c);
      localTextView.setText(localbfox.b);
    }
    for (;;)
    {
      if (AppSetting.d)
      {
        if (localbfox == null) {
          break;
        }
        paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbfox.d));
      }
      return paramViewGroup;
      paramView.setImageResource(2130847283);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfov
 * JD-Core Version:    0.7.0.1
 */