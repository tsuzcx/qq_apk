import android.content.Context;
import android.util.Log;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterProxy.1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbpey;>;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class bpff
  extends bpeu
{
  private static final String jdField_a_of_type_JavaLangString = bpff.class.getSimpleName();
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private final int b = 250;
  
  public bpff(TAVCutVideoSession paramTAVCutVideoSession)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = paramTAVCutVideoSession;
  }
  
  private List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration() != null))
    {
      long l1 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L;
      int i = 3000;
      if (l1 > 30000L) {
        i = 6000;
      }
      int j = 0;
      while ((j <= l1 / i) && (j < 10))
      {
        long l2 = j * i;
        if (l2 < l1) {
          localArrayList.add(Long.valueOf(l2));
        }
        j += 1;
      }
    }
    return localArrayList;
  }
  
  protected bpez a(List<bpey> paramList)
  {
    bpfg localbpfg = new bpfg();
    if (a(this.jdField_a_of_type_JavaUtilList)) {}
    try
    {
      localbpfg.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData = PhotoAIFilter.preprocessImages(this.jdField_a_of_type_JavaUtilList);
      localbpfg.jdField_a_of_type_ArrayOfFloat = bpdx.a(localbpfg.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
      localbpfg.jdField_a_of_type_JavaUtilHashMap = bpdx.a(localbpfg.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
      localObject2 = new ArrayList();
      if ((paramList == null) || (paramList.size() == 0))
      {
        String str = NewEnhanceCategories.COMMON.serverLabel;
        paramList = (List<bpey>)localObject2;
        bpam.b(jdField_a_of_type_JavaLangString, "sceneLabel: " + str);
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (YoutuResultItem)((Iterator)localObject2).next();
          bpam.b(jdField_a_of_type_JavaLangString, "label: " + ((YoutuResultItem)localObject3).Label + ", confidence: " + ((YoutuResultItem)localObject3).Confidence);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      for (;;)
      {
        Object localObject2;
        bpam.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(localException));
        continue;
        Object localObject3 = a(paramList);
        Iterator localIterator = paramList.iterator();
        do
        {
          paramList = (List<bpey>)localObject2;
          localObject1 = localObject3;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (bpey)localIterator.next();
        } while (!paramList.jdField_a_of_type_JavaLangString.equals(localObject3));
        paramList = paramList.jdField_a_of_type_JavaUtilList;
        localObject1 = localObject3;
      }
      localbpfg.jdField_a_of_type_JavaLangString = localObject1;
      localbpfg.jdField_a_of_type_JavaUtilList = paramList;
      localbpfg.b = b(localbpfg.jdField_a_of_type_JavaLangString);
    }
    return localbpfg;
  }
  
  protected void a(Context paramContext, bpex parambpex)
  {
    List localList = a();
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    localExecutorService.submit(new VideoAIFilterProxy.1(this, localList, paramContext, parambpex));
    localExecutorService.shutdown();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpff
 * JD-Core Version:    0.7.0.1
 */