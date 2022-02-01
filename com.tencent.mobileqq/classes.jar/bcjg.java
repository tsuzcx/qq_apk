import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcjg
  implements View.OnClickListener
{
  bcjg(bcje parambcje, bcfo parambcfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bcfo.a(paramView);
    Object localObject = new MiniAppInfo();
    ((MiniAppInfo)localObject).appId = this.jdField_a_of_type_Bcfo.a.appId;
    MiniAppConfig localMiniAppConfig = new MiniAppConfig((MiniAppInfo)localObject);
    if (this.jdField_a_of_type_Bcfo.a.showMask == 1) {}
    for (localObject = "used";; localObject = "unused")
    {
      MiniProgramLpReportDC04239.reportAsync(localMiniAppConfig, "search", "result_click", (String)localObject, this.jdField_a_of_type_Bcfo.a());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjg
 * JD-Core Version:    0.7.0.1
 */