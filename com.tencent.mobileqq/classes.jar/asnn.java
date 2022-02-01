import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class asnn
  extends RecyclerView.Adapter<asnm>
{
  private List<MiniAppRecommInfo.MiniApp> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public asnn(asnl paramasnl) {}
  
  public asnm a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(asnl.a(this.jdField_a_of_type_Asnl)).inflate(2131559519, null, false);
    return new asnm(asnl.a(this.jdField_a_of_type_Asnl), paramViewGroup);
  }
  
  public void a(asnm paramasnm, int paramInt)
  {
    MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramasnm.a(localMiniApp);
    paramasnm.a(paramInt);
    if ((localMiniApp != null) && (localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo != null))
    {
      MiniAppConfig localMiniAppConfig = new MiniAppConfig(localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo);
      localMiniAppConfig.launchParam.scene = 2065;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new MiniAppExposureManager.MiniAppExposureData(localMiniAppConfig, paramInt));
      MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo");
      asnl.a(101, paramInt, localMiniApp.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramasnm, paramInt, getItemId(paramInt));
  }
  
  public void a(List<MiniAppRecommInfo.MiniApp> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnn
 * JD-Core Version:    0.7.0.1
 */