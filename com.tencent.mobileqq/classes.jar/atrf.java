import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class atrf
  extends BaseAdapter
{
  public atrf(LangSettingFragment paramLangSettingFragment) {}
  
  private View.OnClickListener a(int paramInt)
  {
    return new atrg(this, paramInt);
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= LangSettingFragment.a().size()) || (paramInt < 0)) {
      return false;
    }
    return ((Integer)LangSettingFragment.a().get(paramInt)).intValue() == 1033;
  }
  
  public int getCount()
  {
    return LangSettingFragment.a().size();
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
    if (paramInt == LangSettingFragment.a(this.a)) {
      localFormSimpleItem.setRightIcon(this.a.getResources().getDrawable(2130844603));
    }
    for (;;)
    {
      if (paramInt < LangSettingFragment.a().size()) {
        localFormSimpleItem.setLeftText(LangSettingFragment.a(this.a, paramInt, false));
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
 * Qualified Name:     atrf
 * JD-Core Version:    0.7.0.1
 */