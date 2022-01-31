import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class blhc
  extends blgw
{
  private static final String jdField_a_of_type_JavaLangString = blhc.class.getSimpleName();
  private blhb jdField_a_of_type_Blhb;
  private int b;
  private List<String> c;
  private List<blgb> d;
  
  public blhc(List<String> paramList, List<blgb> paramList1, int paramInt, blhb paramblhb)
  {
    this.c = paramList;
    this.d = paramList1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Blhb = paramblhb;
    this.jdField_a_of_type_Int = (paramList.size() - 1);
  }
  
  protected blhb a(List<blha> paramList)
  {
    int j = 0;
    blhd localblhd = new blhd();
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
            localblhd.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.jdField_b_of_type_JavaUtilList.size()) {
              break label210;
            }
            blfg.d(jdField_a_of_type_JavaLangString, "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localblhd.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        localblhd.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, (blhf)this.jdField_a_of_type_Blhb);
        return localblhd;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (blha)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
          localObject = a((blha)localObject);
          localblhd.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label210:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, blgz paramblgz)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    localArrayList.remove(this.jdField_b_of_type_Int);
    ThreadManager.excute(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, paramblgz), 128, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhc
 * JD-Core Version:    0.7.0.1
 */