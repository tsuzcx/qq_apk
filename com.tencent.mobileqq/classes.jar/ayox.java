import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;
import com.tencent.mobileqq.now.widget.CircleImageView;

public class ayox
{
  public static void a(FragmentActivity paramFragmentActivity, RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (ayoy)paramViewHolder;
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(aypl.a());
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView.setImageDrawable(aypl.a(paramFragmentActivity));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramFragmentActivity);
    localLinearLayoutManager.setOrientation(0);
    paramViewHolder.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    paramFragmentActivity = new aypb(paramFragmentActivity, aypj.a().a());
    paramViewHolder.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(paramFragmentActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayox
 * JD-Core Version:    0.7.0.1
 */