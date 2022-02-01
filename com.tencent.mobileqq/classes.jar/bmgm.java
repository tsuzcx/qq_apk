import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bmgm
  extends bmgg
{
  private static final String jdField_a_of_type_JavaLangString = bmgm.class.getSimpleName();
  private bmgl jdField_a_of_type_Bmgl;
  private int b;
  private List<String> c;
  private List<bmde> d;
  
  public bmgm(List<String> paramList, List<bmde> paramList1, int paramInt, bmgl parambmgl)
  {
    this.c = paramList;
    this.d = paramList1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Bmgl = parambmgl;
    this.jdField_a_of_type_Int = (paramList.size() - 1);
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
            paramList = a(null);
            paramList.jdField_a_of_type_Boolean = true;
            localbmgn.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.jdField_b_of_type_JavaUtilList.size()) {
              break label210;
            }
            bmbx.d(jdField_a_of_type_JavaLangString, "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localbmgn.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        localbmgn.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, (bmgu)this.jdField_a_of_type_Bmgl);
        return localbmgn;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (bmgk)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
          localObject = a((bmgk)localObject);
          localbmgn.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label210:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, bmgj parambmgj)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    localArrayList.remove(this.jdField_b_of_type_Int);
    ThreadManager.getSubThreadHandler().post(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, parambmgj));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgm
 * JD-Core Version:    0.7.0.1
 */