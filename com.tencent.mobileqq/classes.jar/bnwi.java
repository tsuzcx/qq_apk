import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.SilentBatchImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bnwi
  extends bnvy
{
  private List<String> c;
  private List<bnsw> d;
  
  public bnwi(@NonNull List<String> paramList, @NonNull List<bnsw> paramList1)
  {
    if (paramList.size() > 3) {
      this.c = paramList.subList(0, 3);
    }
    for (this.d = paramList1.subList(0, 3);; this.d = new LinkedList(paramList1))
    {
      this.jdField_a_of_type_Int = this.c.size();
      return;
      this.c = new LinkedList(paramList);
    }
  }
  
  private bnwm b(bnwc parambnwc)
  {
    bnwm localbnwm = new bnwm();
    ArrayList localArrayList = new ArrayList();
    if (parambnwc == null)
    {
      localbnwm.jdField_a_of_type_Boolean = true;
      bnrh.a("SilentBatchImageAIFilterProxy", "[buildImageResult] exception");
    }
    for (parambnwc = localArrayList;; parambnwc = parambnwc.jdField_a_of_type_JavaUtilList)
    {
      localbnwm.jdField_a_of_type_JavaUtilList = parambnwc;
      return localbnwm;
    }
  }
  
  protected bnwd a(List<bnwc> paramList)
  {
    int j = 0;
    bnwf localbnwf = new bnwf();
    int i;
    if ((paramList == null) || (paramList.size() == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        i = j;
        for (;;)
        {
          if (i < this.jdField_a_of_type_Int)
          {
            paramList = b(null);
            paramList.jdField_a_of_type_Boolean = true;
            localbnwf.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.b.size()) {
              break label188;
            }
            bnrh.d("SilentBatchImageAIFilterProxy", "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localbnwf.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        return localbnwf;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (bnwc)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.b.get(i));
          localObject = b((bnwc)localObject);
          localbnwf.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label188:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, bnwb parambnwb)
  {
    ThreadManager.getSubThreadHandler().post(new SilentBatchImageAIFilterProxy.1(this, paramContext, parambnwb));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwi
 * JD-Core Version:    0.7.0.1
 */