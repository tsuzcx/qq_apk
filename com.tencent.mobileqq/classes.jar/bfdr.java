import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.widget.presseffect.PressEffectTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bfdr
  extends BaseAdapter
{
  bfeg jdField_a_of_type_Bfeg;
  ArrayList<bfee> jdField_a_of_type_JavaUtilArrayList;
  
  protected bfdr(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void a(ArrayList<bfee> paramArrayList, bfeg parambfeg)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Bfeg = parambfeg;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity()).inflate(2131560561, paramViewGroup, false);
    }
    for (;;)
    {
      PressEffectTextView localPressEffectTextView = (PressEffectTextView)paramView;
      if (TextUtils.isEmpty(((bfee)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a)) {
        localPressEffectTextView.setVisibility(8);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localPressEffectTextView.setVisibility(0);
        localPressEffectTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a(this.jdField_a_of_type_JavaUtilArrayList.size(), ((bfee)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a));
        localPressEffectTextView.setOnClickListener(new bfds(this, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdr
 * JD-Core Version:    0.7.0.1
 */