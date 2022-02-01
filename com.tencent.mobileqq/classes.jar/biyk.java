import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;

public class biyk
  extends BaseAdapter
{
  public biyk(GridListView paramGridListView) {}
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.a.getContext());
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new biyi(null));
    return paramViewGroup;
  }
  
  public int getCount()
  {
    if (this.a.c == 0)
    {
      if (this.a.jdField_a_of_type_AndroidViewView != null) {
        return 1;
      }
      return 0;
    }
    return this.a.c;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.a.c == 0) {
      return 0;
    }
    if (this.a.jdField_a_of_type_Int == 0) {
      return this.a.jdField_a_of_type_Biyj.getItemViewType(paramInt) + 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    Object localObject1;
    if (this.a.c == 0)
    {
      this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(this.a.getWidth(), this.a.getHeight()));
      localObject2 = this.a.jdField_a_of_type_AndroidViewView;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    int i;
    if (this.a.jdField_a_of_type_Int == 1)
    {
      paramView = (LinearLayout)paramView;
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = a(paramViewGroup);
      }
      ((LinearLayout)localObject1).removeAllViews();
      i = this.a.d - this.a.b * paramInt;
      if (i < this.a.b) {
        break label577;
      }
      i = this.a.b;
    }
    label574:
    label577:
    for (;;)
    {
      biyi localbiyi = (biyi)((LinearLayout)localObject1).getTag();
      int k = paramInt * this.a.b;
      int j = 0;
      paramView = (View)localObject1;
      int m;
      if (j < i)
      {
        paramView = localbiyi.a[j];
        m = this.a.jdField_a_of_type_Biyj.b(k + j);
        if ((paramView == null) || (((Integer)paramView.getTag(2131361856)).intValue() == m)) {
          break label574;
        }
        paramView = null;
      }
      for (;;)
      {
        View localView = this.a.jdField_a_of_type_Biyj.getView(k + j, paramView, (ViewGroup)localObject1);
        localView.setTag(2131361856, Integer.valueOf(m));
        localbiyi.a[j] = localView;
        localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          paramView = new LinearLayout.LayoutParams(this.a.g, this.a.h);
          localView.setLayoutParams(paramView);
        }
        paramView.width = this.a.g;
        paramView.height = this.a.h;
        paramView.leftMargin = this.a.e;
        paramView.topMargin = this.a.f;
        ((LinearLayout)localObject1).addView(localView);
        if ((this.a.jdField_a_of_type_Bljm != null) && (this.a.jdField_a_of_type_Biyj.isEnabled(k + j)))
        {
          localView.setTag(2131361809, Integer.valueOf(k + j));
          localView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        for (;;)
        {
          j += 1;
          break;
          localView.setOnClickListener(null);
        }
        i = this.a.jdField_a_of_type_Biyj.a(paramInt) + 2;
        localObject1 = paramView;
        if (paramView != null)
        {
          localObject1 = paramView;
          if (((Integer)paramView.getTag(2131361856)).intValue() != i) {
            localObject1 = null;
          }
        }
        paramView = this.a.jdField_a_of_type_Biyj.getView(paramInt, (View)localObject1, paramViewGroup);
        paramView.setTag(2131361856, Integer.valueOf(i));
        if ((this.a.jdField_a_of_type_Bljm != null) && (this.a.jdField_a_of_type_Biyj.isEnabled(paramInt)))
        {
          paramView.setTag(2131361809, Integer.valueOf(paramInt));
          paramView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        for (;;)
        {
          localObject1 = paramView;
          localObject2 = paramView;
          break;
          paramView.setOnClickListener(null);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return this.a.i + 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if ((this.a.c == 0) || (this.a.jdField_a_of_type_Int == 1)) {
      return false;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyk
 * JD-Core Version:    0.7.0.1
 */