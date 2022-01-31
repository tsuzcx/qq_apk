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

public class bfpm
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  final List<bfpo> jdField_a_of_type_JavaUtilList;
  
  public bfpm(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static bfpc a(Context paramContext, bfpm parambfpm, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, bfph parambfph, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (parambfpm == null) {
        return null;
      }
      bfpc localbfpc = (bfpc)bfpp.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131562573, null);
      paramContext.setBackgroundResource(2130837572);
      paramContext.setAdapter(parambfpm);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localbfpc.a(paramContext);
      localbfpc.c(2131690596);
      if (paramBoolean) {
        localbfpc.setOnDismissListener(new bfpn(paramOnDismissListener));
      }
      for (;;)
      {
        localbfpc.a(parambfph);
        return localbfpc;
        localbfpc.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static bfpo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new bfpo();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((bfpo)localObject1).a = 3;
      ((bfpo)localObject1).b = 2131719511;
      ((bfpo)localObject1).c = 2130838752;
      ((bfpo)localObject1).d = 2131720065;
      return localObject1;
    case 2: 
      ((bfpo)localObject1).a = 2;
      ((bfpo)localObject1).b = 2131719522;
      ((bfpo)localObject1).c = 2130838758;
      ((bfpo)localObject1).d = 2131720082;
      return localObject1;
    case 0: 
      ((bfpo)localObject1).a = 0;
      ((bfpo)localObject1).b = 2131692796;
      ((bfpo)localObject1).c = 2130838754;
      ((bfpo)localObject1).d = 2131720074;
      return localObject1;
    case 1: 
      ((bfpo)localObject1).a = 1;
      ((bfpo)localObject1).b = 2131719516;
      ((bfpo)localObject1).c = 2130838755;
      ((bfpo)localObject1).d = 2131720075;
      return localObject1;
    case 5: 
      ((bfpo)localObject1).a = 5;
      ((bfpo)localObject1).b = 2131717202;
      ((bfpo)localObject1).c = 2130841940;
      ((bfpo)localObject1).d = 2131692226;
      return localObject1;
    case 4: 
      ((bfpo)localObject1).a = 4;
      ((bfpo)localObject1).c = 2130838750;
      ((bfpo)localObject1).b = 2131719499;
      ((bfpo)localObject1).d = 2131720058;
      return localObject1;
    case 6: 
      ((bfpo)localObject1).a = 4;
      ((bfpo)localObject1).c = 2130838750;
      ((bfpo)localObject1).b = 2131719497;
      ((bfpo)localObject1).d = 2131720064;
      return localObject1;
    }
    ((bfpo)localObject1).a = 7;
    ((bfpo)localObject1).c = 2130838751;
    ((bfpo)localObject1).b = 2131719486;
    ((bfpo)localObject1).d = 2131720061;
    return localObject1;
  }
  
  public void a(List<bfpo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bfpo localbfpo = (bfpo)paramList.next();
        if ((localbfpo != null) && (localbfpo.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localbfpo);
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
    bfpo localbfpo = (bfpo)getItem(paramInt);
    if (localbfpo != null) {
      return localbfpo.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bfpo localbfpo = (bfpo)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562537, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131362667);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131362679);
    if (localbfpo != null)
    {
      paramView.setImageResource(localbfpo.c);
      localTextView.setText(localbfpo.b);
    }
    for (;;)
    {
      if (AppSetting.d)
      {
        if (localbfpo == null) {
          break;
        }
        paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localbfpo.d));
      }
      return paramViewGroup;
      paramView.setImageResource(2130847289);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfpm
 * JD-Core Version:    0.7.0.1
 */