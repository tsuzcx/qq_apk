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
import java.util.List<Lblli;>;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class bllp
  extends blle
{
  private static final String jdField_a_of_type_JavaLangString = bllp.class.getSimpleName();
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private final int b = 250;
  
  public bllp(TAVCutVideoSession paramTAVCutVideoSession)
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
  
  protected bllj a(List<blli> paramList)
  {
    bllq localbllq = new bllq();
    if (a(this.jdField_a_of_type_JavaUtilList)) {}
    try
    {
      localbllq.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData = PhotoAIFilter.preprocessImages(this.jdField_a_of_type_JavaUtilList);
      localbllq.jdField_a_of_type_ArrayOfFloat = blkl.a(localbllq.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
      localbllq.jdField_a_of_type_JavaUtilHashMap = blkl.a(localbllq.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
      localObject2 = new ArrayList();
      if ((paramList == null) || (paramList.size() == 0))
      {
        String str = NewEnhanceCategories.COMMON.serverLabel;
        paramList = (List<blli>)localObject2;
        bljn.b(jdField_a_of_type_JavaLangString, "sceneLabel: " + str);
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (YoutuResultItem)((Iterator)localObject2).next();
          bljn.b(jdField_a_of_type_JavaLangString, "label: " + ((YoutuResultItem)localObject3).Label + ", confidence: " + ((YoutuResultItem)localObject3).Confidence);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      for (;;)
      {
        Object localObject2;
        bljn.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(localException));
        continue;
        Object localObject3 = a(paramList);
        Iterator localIterator = paramList.iterator();
        do
        {
          paramList = (List<blli>)localObject2;
          localObject1 = localObject3;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (blli)localIterator.next();
        } while (!paramList.jdField_a_of_type_JavaLangString.equals(localObject3));
        paramList = paramList.jdField_a_of_type_JavaUtilList;
        localObject1 = localObject3;
      }
      localbllq.jdField_a_of_type_JavaLangString = localObject1;
      localbllq.jdField_a_of_type_JavaUtilList = paramList;
      localbllq.b = b(localbllq.jdField_a_of_type_JavaLangString);
    }
    return localbllq;
  }
  
  protected void a(Context paramContext, bllh parambllh)
  {
    List localList = a();
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    localExecutorService.submit(new VideoAIFilterProxy.1(this, localList, paramContext, parambllh));
    localExecutorService.shutdown();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllp
 * JD-Core Version:    0.7.0.1
 */