import android.content.Context;
import android.util.Log;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterProxy.1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbnwc;>;
import mqq.os.MqqHandler;

public class bnwn
  extends bnvy
{
  private static final String a;
  public TAVCutVideoSession a;
  protected final int b = 250;
  
  static
  {
    jdField_a_of_type_JavaLangString = bnwn.class.getSimpleName();
  }
  
  public bnwn(TAVCutVideoSession paramTAVCutVideoSession)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = paramTAVCutVideoSession;
  }
  
  protected bnwd a(List<bnwc> paramList)
  {
    bnwo localbnwo = new bnwo();
    if (a(this.jdField_a_of_type_JavaUtilList)) {}
    try
    {
      localbnwo.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData = PhotoAIFilter.preprocessImages(this.jdField_a_of_type_JavaUtilList);
      localbnwo.jdField_a_of_type_ArrayOfFloat = bnuz.a(localbnwo.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
      localbnwo.jdField_a_of_type_JavaUtilHashMap = bnuz.a(localbnwo.jdField_a_of_type_ComMicrorapidOpencvImageStatisticsData);
      localObject2 = new ArrayList();
      if ((paramList == null) || (paramList.size() == 0))
      {
        String str = NewEnhanceCategories.COMMON.serverLabel;
        paramList = (List<bnwc>)localObject2;
        bnrh.b(jdField_a_of_type_JavaLangString, "sceneLabel: " + str);
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (YoutuResultItem)((Iterator)localObject2).next();
          bnrh.b(jdField_a_of_type_JavaLangString, "label: " + ((YoutuResultItem)localObject3).Label + ", confidence: " + ((YoutuResultItem)localObject3).Confidence);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      for (;;)
      {
        Object localObject2;
        bnrh.d(jdField_a_of_type_JavaLangString, Log.getStackTraceString(localException));
        continue;
        Object localObject3 = a(paramList);
        Iterator localIterator = paramList.iterator();
        do
        {
          paramList = (List<bnwc>)localObject2;
          localObject1 = localObject3;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (bnwc)localIterator.next();
        } while (!paramList.jdField_a_of_type_JavaLangString.equals(localObject3));
        paramList = paramList.jdField_a_of_type_JavaUtilList;
        localObject1 = localObject3;
      }
      localbnwo.jdField_a_of_type_JavaLangString = localObject1;
      localbnwo.jdField_a_of_type_JavaUtilList = paramList;
      localbnwo.b = b(localbnwo.jdField_a_of_type_JavaLangString);
    }
    return localbnwo;
  }
  
  protected List<Long> a()
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
  
  protected void a(Context paramContext, bnwb parambnwb)
  {
    List localList = a();
    ThreadManager.getSubThreadHandler().post(new VideoAIFilterProxy.1(this, localList, paramContext, parambnwb));
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwn
 * JD-Core Version:    0.7.0.1
 */