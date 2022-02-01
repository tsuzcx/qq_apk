import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class axiw
  extends RecyclerView.Adapter<axix>
  implements axjb
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private List<axjf> jdField_a_of_type_JavaUtilList;
  
  public axiw(FragmentActivity paramFragmentActivity, List<axjf> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    axje.a().a(this);
  }
  
  public axix a(ViewGroup paramViewGroup, int paramInt)
  {
    return new axix(View.inflate(paramViewGroup.getContext(), 2131559534, null));
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(axix paramaxix, int paramInt)
  {
    axjf localaxjf = (axjf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramaxix.jdField_a_of_type_AndroidWidgetTextView.setText(localaxjf.b());
    awrr.a().a(paramaxix.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView, localaxjf.c(), new ColorDrawable(0), new ColorDrawable(0), 80, 80, null, false);
    paramaxix.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.setAnimationRes(2130841461);
    paramaxix.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.a();
    axkk.b(String.valueOf(localaxjf.a()));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramaxix, paramInt, getItemId(paramInt));
  }
  
  public void a(List<axjf> paramList)
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
 * Qualified Name:     axiw
 * JD-Core Version:    0.7.0.1
 */