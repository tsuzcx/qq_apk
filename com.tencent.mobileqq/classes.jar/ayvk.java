import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;
import com.tencent.mobileqq.now.widget.CircleImageView;

public class ayvk
{
  public static void a(FragmentActivity paramFragmentActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (ayvl)paramViewHolder;
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(ayvy.a());
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView.setImageDrawable(ayvy.a(paramFragmentActivity));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramFragmentActivity);
    localLinearLayoutManager.setOrientation(0);
    paramViewHolder.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    paramFragmentActivity = new ayvo(paramFragmentActivity, ayvw.a().a());
    paramViewHolder.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(paramFragmentActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvk
 * JD-Core Version:    0.7.0.1
 */