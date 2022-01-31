import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.ArrayList;
import java.util.List;

public class aogk
  extends RecyclerView.Adapter<aogj>
{
  private List<MiniAppRecommInfo.MiniApp> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aogk(aogi paramaogi) {}
  
  public aogj a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(aogi.a(this.jdField_a_of_type_Aogi)).inflate(2131559313, null, false);
    return new aogj(aogi.a(this.jdField_a_of_type_Aogi), paramViewGroup);
  }
  
  public void a(aogj paramaogj, int paramInt)
  {
    MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramaogj.a(localMiniApp);
    paramaogj.a(paramInt);
    if ((localMiniApp != null) && (localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo != null))
    {
      paramaogj = new MiniAppConfig(localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo);
      paramaogj.launchParam.scene = 2065;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new MiniAppExposureManager.MiniAppExposureData(paramaogj, paramInt));
      MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo");
      aogi.a(101, paramInt, localMiniApp.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogk
 * JD-Core Version:    0.7.0.1
 */