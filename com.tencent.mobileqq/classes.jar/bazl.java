import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.widget.presseffect.PressEffectTextView;
import java.util.ArrayList;

public class bazl
  extends BaseAdapter
{
  bbaa jdField_a_of_type_Bbaa;
  ArrayList<bazy> jdField_a_of_type_JavaUtilArrayList;
  
  protected bazl(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void a(ArrayList<bazy> paramArrayList, bbaa parambbaa)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Bbaa = parambbaa;
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity()).inflate(2131560392, paramViewGroup, false);
    }
    for (;;)
    {
      paramViewGroup = (PressEffectTextView)paramView;
      if (TextUtils.isEmpty(((bazy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a))
      {
        paramViewGroup.setVisibility(8);
        return paramView;
      }
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a(this.jdField_a_of_type_JavaUtilArrayList.size(), ((bazy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a));
      paramViewGroup.setOnClickListener(new bazm(this, paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazl
 * JD-Core Version:    0.7.0.1
 */