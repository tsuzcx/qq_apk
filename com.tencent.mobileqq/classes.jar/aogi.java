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

public class aogi
  extends RecyclerView.ViewHolder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aogk jdField_a_of_type_Aogk;
  private ViewGroup b;
  
  public aogi(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131375493));
    this.b = ((ViewGroup)paramView.findViewById(2131364691));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377104));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131370180));
    int i = actj.a(4.0F, paramActivity.getResources());
    paramView = new axuv(-1, i * 3, i * 3, i);
    this.b.setBackgroundDrawable(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_Aogk = new aogk(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aogk);
    paramView = new aolr(paramActivity, 0, false);
    paramView.setAutoMeasureEnabled(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    bian localbian = new bian();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localbian.b = (str + "_" + l);
    localbian.jdField_a_of_type_Int = 1;
    localbian.jdField_e_of_type_JavaLangString = "tianshu.78";
    localbian.jdField_f_of_type_JavaLangString = "tianshu.78";
    localbian.g = Integer.toString(paramInt3);
    localbian.h = "";
    localbian.jdField_a_of_type_Long = l;
    localbian.d = paramInt1;
    localbian.k = Integer.toString(paramInt2);
    localbian.jdField_e_of_type_Int = 1;
    localbian.jdField_f_of_type_Int = 1;
    biam.a().a(localbian);
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo, int paramInt)
  {
    if (paramMiniAppRecommInfo == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramInt, this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMiniAppRecommInfo.headDesc);
    this.jdField_a_of_type_Aogk.a(paramMiniAppRecommInfo.appInfoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogi
 * JD-Core Version:    0.7.0.1
 */