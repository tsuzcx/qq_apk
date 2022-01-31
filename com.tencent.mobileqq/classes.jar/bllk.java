import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class bllk
  extends blle
{
  private static final String jdField_a_of_type_JavaLangString = bllk.class.getSimpleName();
  private bllj jdField_a_of_type_Bllj;
  private int b;
  private List<String> c;
  private List<blki> d;
  
  public bllk(List<String> paramList, List<blki> paramList1, int paramInt, bllj parambllj)
  {
    this.c = paramList;
    this.d = paramList1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Bllj = parambllj;
    this.jdField_a_of_type_Int = (paramList.size() - 1);
  }
  
  protected bllj a(List<blli> paramList)
  {
    int j = 0;
    blll localblll = new blll();
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
            localblll.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.jdField_b_of_type_JavaUtilList.size()) {
              break label210;
            }
            bljn.d(jdField_a_of_type_JavaLangString, "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localblll.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        localblll.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, (bllo)this.jdField_a_of_type_Bllj);
        return localblll;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (blli)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
          localObject = a((blli)localObject);
          localblll.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label210:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, bllh parambllh)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    localArrayList.remove(this.jdField_b_of_type_Int);
    ThreadManager.excute(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, parambllh), 128, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllk
 * JD-Core Version:    0.7.0.1
 */