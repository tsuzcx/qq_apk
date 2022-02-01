import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ayvo
  extends RecyclerView.Adapter<ayvp>
  implements ayvt
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private List<ayvx> jdField_a_of_type_JavaUtilList;
  
  public ayvo(FragmentActivity paramFragmentActivity, List<ayvx> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    ayvw.a().a(this);
  }
  
  public ayvp a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ayvp(View.inflate(paramViewGroup.getContext(), 2131559532, null));
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(ayvp paramayvp, int paramInt)
  {
    ayvx localayvx = (ayvx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramayvp.jdField_a_of_type_AndroidWidgetTextView.setText(localayvx.b());
    ayej.a().a(paramayvp.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView, localayvx.c(), new ColorDrawable(0), new ColorDrawable(0), 80, 80, null, false);
    paramayvp.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.setAnimationRes(2130841425);
    paramayvp.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.a();
    ayxc.b(String.valueOf(localayvx.a()));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramayvp, paramInt, getItemId(paramInt));
  }
  
  public void a(List<ayvx> paramList)
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
 * Qualified Name:     ayvo
 * JD-Core Version:    0.7.0.1
 */