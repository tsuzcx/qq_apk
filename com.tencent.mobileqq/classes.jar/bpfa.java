import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class bpfa
  extends bpeu
{
  private static final String jdField_a_of_type_JavaLangString = bpfa.class.getSimpleName();
  private bpez jdField_a_of_type_Bpez;
  private int b;
  private List<String> c;
  private List<bpbu> d;
  
  public bpfa(List<String> paramList, List<bpbu> paramList1, int paramInt, bpez parambpez)
  {
    this.c = paramList;
    this.d = paramList1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Bpez = parambpez;
    this.jdField_a_of_type_Int = (paramList.size() - 1);
  }
  
  protected bpez a(List<bpey> paramList)
  {
    int j = 0;
    bpfb localbpfb = new bpfb();
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
            localbpfb.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.jdField_b_of_type_JavaUtilList.size()) {
              break label210;
            }
            bpam.d(jdField_a_of_type_JavaLangString, "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localbpfb.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        localbpfb.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, (bpfe)this.jdField_a_of_type_Bpez);
        return localbpfb;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (bpey)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
          localObject = a((bpey)localObject);
          localbpfb.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label210:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, bpex parambpex)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    localArrayList.remove(this.jdField_b_of_type_Int);
    ThreadManager.excute(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, parambpex), 128, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfa
 * JD-Core Version:    0.7.0.1
 */