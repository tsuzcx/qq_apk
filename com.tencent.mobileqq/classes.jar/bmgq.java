import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.SilentBatchImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bmgq
  extends bmgg
{
  private List<String> c;
  private List<bmde> d;
  
  public bmgq(@NonNull List<String> paramList, @NonNull List<bmde> paramList1)
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
  
  private bmgu b(bmgk parambmgk)
  {
    bmgu localbmgu = new bmgu();
    ArrayList localArrayList = new ArrayList();
    if (parambmgk == null)
    {
      localbmgu.jdField_a_of_type_Boolean = true;
      bmbx.a("SilentBatchImageAIFilterProxy", "[buildImageResult] exception");
    }
    for (parambmgk = localArrayList;; parambmgk = parambmgk.jdField_a_of_type_JavaUtilList)
    {
      localbmgu.jdField_a_of_type_JavaUtilList = parambmgk;
      return localbmgu;
    }
  }
  
  protected bmgl a(List<bmgk> paramList)
  {
    int j = 0;
    bmgn localbmgn = new bmgn();
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
            localbmgn.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.b.size()) {
              break label188;
            }
            bmbx.d("SilentBatchImageAIFilterProxy", "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localbmgn.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        return localbmgn;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (bmgk)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.b.get(i));
          localObject = b((bmgk)localObject);
          localbmgn.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label188:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, bmgj parambmgj)
  {
    ThreadManager.getSubThreadHandler().post(new SilentBatchImageAIFilterProxy.1(this, paramContext, parambmgj));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgq
 * JD-Core Version:    0.7.0.1
 */