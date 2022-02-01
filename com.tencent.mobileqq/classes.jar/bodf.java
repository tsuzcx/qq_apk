import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class bodf
  extends bocz
{
  private static final String jdField_a_of_type_JavaLangString = bodf.class.getSimpleName();
  private bode jdField_a_of_type_Bode;
  private int b;
  private List<String> c;
  private List<bnzz> d;
  
  public bodf(List<String> paramList, List<bnzz> paramList1, int paramInt, bode parambode)
  {
    this.c = paramList;
    this.d = paramList1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Bode = parambode;
    this.jdField_a_of_type_Int = (paramList.size() - 1);
  }
  
  protected bode a(List<bodd> paramList)
  {
    int j = 0;
    bodg localbodg = new bodg();
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
            localbodg.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.jdField_b_of_type_JavaUtilList.size()) {
              break label210;
            }
            bnzb.d(jdField_a_of_type_JavaLangString, "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localbodg.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        localbodg.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, (bodj)this.jdField_a_of_type_Bode);
        return localbodg;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (bodd)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
          localObject = a((bodd)localObject);
          localbodg.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label210:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, bodc parambodc)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    localArrayList.remove(this.jdField_b_of_type_Int);
    ThreadManager.excute(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, parambodc), 128, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodf
 * JD-Core Version:    0.7.0.1
 */