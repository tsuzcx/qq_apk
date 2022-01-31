import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.util.List;

public class aqhu
  extends BaseAdapter
{
  public aqhu(LangSettingFragment paramLangSettingFragment) {}
  
  private View.OnClickListener a(int paramInt)
  {
    return new aqhv(this, paramInt);
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
    paramView = new FormSimpleItem(this.a.getActivity());
    if (paramInt == LangSettingFragment.a(this.a)) {
      paramView.setRightIcon(this.a.getResources().getDrawable(2130843904));
    }
    for (;;)
    {
      if (paramInt < LangSettingFragment.a().size()) {
        paramView.setLeftText(LangSettingFragment.a(this.a, paramInt, false));
      }
      paramView.setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(a(paramInt));
      return paramView;
      paramView.setRightIcon(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqhu
 * JD-Core Version:    0.7.0.1
 */