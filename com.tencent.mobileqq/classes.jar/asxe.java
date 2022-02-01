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

public class asxe
  extends RecyclerView.Adapter<asxd>
{
  private List<MiniAppRecommInfo.MiniApp> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public asxe(asxc paramasxc) {}
  
  public asxd a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(asxc.a(this.jdField_a_of_type_Asxc)).inflate(2131559484, null, false);
    return new asxd(asxc.a(this.jdField_a_of_type_Asxc), paramViewGroup);
  }
  
  public void a(asxd paramasxd, int paramInt)
  {
    MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramasxd.a(localMiniApp);
    paramasxd.a(paramInt);
    if ((localMiniApp != null) && (localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo != null))
    {
      MiniAppConfig localMiniAppConfig = new MiniAppConfig(localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo);
      localMiniAppConfig.launchParam.scene = 2065;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new MiniAppExposureManager.MiniAppExposureData(localMiniAppConfig, paramInt));
      MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo");
      asxc.a(101, paramInt, localMiniApp.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramasxd, paramInt, getItemId(paramInt));
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
 * Qualified Name:     asxe
 * JD-Core Version:    0.7.0.1
 */