import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.AppRuntime;

public class asxc
  extends RecyclerView.ViewHolder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asxe jdField_a_of_type_Asxe;
  private ViewGroup b;
  
  public asxc(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131376925));
    this.b = ((ViewGroup)paramView.findViewById(2131365046));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378678));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131371038));
    int i = agej.a(4.0F, paramActivity.getResources());
    paramView = new bdor(-1, i * 3, i * 3, i);
    this.b.setBackgroundDrawable(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_Asxe = new asxe(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Asxe);
    paramView = new atfc(paramActivity, 0, false);
    paramView.setAutoMeasureEnabled(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    bnwr localbnwr = new bnwr();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbnwr.b = (str + "_" + l);
    localbnwr.jdField_a_of_type_Int = 1;
    localbnwr.jdField_e_of_type_JavaLangString = "tianshu.78";
    localbnwr.jdField_f_of_type_JavaLangString = "tianshu.78";
    localbnwr.g = Integer.toString(paramInt3);
    localbnwr.h = "";
    localbnwr.jdField_a_of_type_Long = l;
    localbnwr.d = paramInt1;
    localbnwr.k = Integer.toString(paramInt2);
    localbnwr.jdField_e_of_type_Int = 1;
    localbnwr.jdField_f_of_type_Int = 1;
    bnwq.a().a(localbnwr);
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo, int paramInt)
  {
    if (paramMiniAppRecommInfo == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramInt, this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMiniAppRecommInfo.headDesc);
    this.jdField_a_of_type_Asxe.a(paramMiniAppRecommInfo.appInfoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxc
 * JD-Core Version:    0.7.0.1
 */