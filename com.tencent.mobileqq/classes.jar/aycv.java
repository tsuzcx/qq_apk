import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aycv
  extends RecyclerView.Adapter<aycw>
  implements ayda
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private List<ayde> jdField_a_of_type_JavaUtilList;
  
  public aycv(FragmentActivity paramFragmentActivity, List<ayde> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    aydd.a().a(this);
  }
  
  public aycw a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aycw(View.inflate(paramViewGroup.getContext(), 2131559527, null));
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(aycw paramaycw, int paramInt)
  {
    ayde localayde = (ayde)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramaycw.jdField_a_of_type_AndroidWidgetTextView.setText(localayde.b());
    axlp.a().a(paramaycw.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView, localayde.c(), new ColorDrawable(0), new ColorDrawable(0), 80, 80, null, false);
    paramaycw.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.setAnimationRes(2130841415);
    paramaycw.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.a();
    ayej.b(String.valueOf(localayde.a()));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramaycw, paramInt, getItemId(paramInt));
  }
  
  public void a(List<ayde> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycv
 * JD-Core Version:    0.7.0.1
 */