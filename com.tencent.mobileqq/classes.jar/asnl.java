import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import mqq.app.AppRuntime;

public class asnl
  extends RecyclerView.ViewHolder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asnn jdField_a_of_type_Asnn;
  private ViewGroup b;
  
  public asnl(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131376947));
    this.b = ((ViewGroup)paramView.findViewById(2131365157));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378734));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131371199));
    int i = AIOUtils.dp2px(4.0F, paramActivity.getResources());
    paramView = new bdoa(-1, i * 3, i * 3, i);
    this.b.setBackgroundDrawable(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_Asnn = new asnn(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Asnn);
    paramView = new asvq(paramActivity, 0, false);
    paramView.setAutoMeasureEnabled(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.mTraceId = (str + "_" + l);
    localTianShuReportData.mTraceNum = 1;
    localTianShuReportData.mAppId = "tianshu.78";
    localTianShuReportData.mPageId = "tianshu.78";
    localTianShuReportData.mItemId = Integer.toString(paramInt3);
    localTianShuReportData.mSubItemId = "";
    localTianShuReportData.mOperTime = l;
    localTianShuReportData.mActionId = paramInt1;
    localTianShuReportData.mPositionId = Integer.toString(paramInt2);
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mActionAttr = 1;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo, int paramInt)
  {
    if (paramMiniAppRecommInfo == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramInt, this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMiniAppRecommInfo.headDesc);
    this.jdField_a_of_type_Asnn.a(paramMiniAppRecommInfo.appInfoList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnl
 * JD-Core Version:    0.7.0.1
 */