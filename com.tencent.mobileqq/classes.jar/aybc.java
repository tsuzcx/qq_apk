import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.widget.presseffect.PressEffectTextView;
import java.util.ArrayList;

public class aybc
  extends BaseAdapter
{
  aybq jdField_a_of_type_Aybq;
  ArrayList<aybo> jdField_a_of_type_JavaUtilArrayList;
  
  protected aybc(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void a(ArrayList<aybo> paramArrayList, aybq paramaybq)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Aybq = paramaybq;
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity()).inflate(2131494712, paramViewGroup, false);
    }
    for (;;)
    {
      paramViewGroup = (PressEffectTextView)paramView;
      if (TextUtils.isEmpty(((aybo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a))
      {
        paramViewGroup.setVisibility(8);
        return paramView;
      }
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a(this.jdField_a_of_type_JavaUtilArrayList.size(), ((aybo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a));
      paramViewGroup.setOnClickListener(new aybd(this, paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybc
 * JD-Core Version:    0.7.0.1
 */