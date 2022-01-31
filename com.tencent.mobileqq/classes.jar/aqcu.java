import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.ArrayList;
import java.util.List;

public class aqcu
  extends RecyclerView.Adapter<aqct>
{
  private List<MiniAppRecommInfo.MiniApp> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aqcu(aqcs paramaqcs) {}
  
  public aqct a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(aqcs.a(this.jdField_a_of_type_Aqcs)).inflate(2131559363, null, false);
    return new aqct(aqcs.a(this.jdField_a_of_type_Aqcs), paramViewGroup);
  }
  
  public void a(aqct paramaqct, int paramInt)
  {
    MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramaqct.a(localMiniApp);
    paramaqct.a(paramInt);
    if ((localMiniApp != null) && (localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo != null))
    {
      paramaqct = new MiniAppConfig(localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo);
      paramaqct.launchParam.scene = 2065;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new MiniAppExposureManager.MiniAppExposureData(paramaqct, paramInt));
      MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo");
      aqcs.a(101, paramInt, localMiniApp.jdField_a_of_type_Int);
    }
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
 * Qualified Name:     aqcu
 * JD-Core Version:    0.7.0.1
 */