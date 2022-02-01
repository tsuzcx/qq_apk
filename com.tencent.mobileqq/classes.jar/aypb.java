import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aypb
  extends RecyclerView.Adapter<aypc>
  implements aypg
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private List<aypk> jdField_a_of_type_JavaUtilList;
  
  public aypb(FragmentActivity paramFragmentActivity, List<aypk> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    aypj.a().a(this);
  }
  
  public aypc a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aypc(View.inflate(paramViewGroup.getContext(), 2131559567, null));
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(aypc paramaypc, int paramInt)
  {
    aypk localaypk = (aypk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramaypc.jdField_a_of_type_AndroidWidgetTextView.setText(localaypk.b());
    axxt.a().a(paramaypc.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView, localaypk.c(), new ColorDrawable(0), new ColorDrawable(0), 80, 80, null, false);
    paramaypc.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.setAnimationRes(2130841467);
    paramaypc.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.a();
    ayqp.b(String.valueOf(localaypk.a()));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramaypc, paramInt, getItemId(paramInt));
  }
  
  public void a(List<aypk> paramList)
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
 * Qualified Name:     aypb
 * JD-Core Version:    0.7.0.1
 */