import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.ArrayList;
import java.util.List;

public class anpu
  extends RecyclerView.Adapter<anpt>
{
  private List<MiniAppRecommInfo.MiniApp> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public anpu(anps paramanps) {}
  
  public anpt a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(anps.a(this.jdField_a_of_type_Anps)).inflate(2131493741, null, false);
    return new anpt(anps.a(this.jdField_a_of_type_Anps), paramViewGroup);
  }
  
  public void a(anpt paramanpt, int paramInt)
  {
    MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramanpt.a(localMiniApp);
    paramanpt.a(paramInt);
    if ((localMiniApp != null) && (localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo != null))
    {
      paramanpt = new MiniAppConfig(localMiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo);
      paramanpt.launchParam.scene = 2065;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new MiniAppExposureManager.MiniAppExposureData(paramanpt, paramInt));
      MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo");
      anps.a(101, paramInt, localMiniApp.jdField_a_of_type_Int);
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
 * Qualified Name:     anpu
 * JD-Core Version:    0.7.0.1
 */