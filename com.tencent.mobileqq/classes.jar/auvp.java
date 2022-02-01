import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class auvp
  extends BaseAdapter
{
  public auvp(BottomTabSettingFragment paramBottomTabSettingFragment) {}
  
  private View.OnClickListener a(int paramInt)
  {
    return new auvq(this, paramInt);
  }
  
  public int getCount()
  {
    return BottomTabSettingFragment.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FormSimpleItem localFormSimpleItem = new FormSimpleItem(this.a.getActivity());
    if (paramInt == BottomTabSettingFragment.a(this.a)) {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130844669));
    }
    for (;;)
    {
      if (paramInt < BottomTabSettingFragment.a(this.a).size()) {
        localFormSimpleItem.setLeftText((CharSequence)BottomTabSettingFragment.a(this.a).get(Integer.valueOf(paramInt)));
      }
      localFormSimpleItem.setTag(Integer.valueOf(paramInt));
      localFormSimpleItem.setOnClickListener(a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localFormSimpleItem;
      localFormSimpleItem.setRightIcon(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvp
 * JD-Core Version:    0.7.0.1
 */