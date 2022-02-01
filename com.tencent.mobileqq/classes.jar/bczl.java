import android.os.Handler;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import java.util.ArrayList;
import java.util.List;

class bczl
  extends bcyn
{
  bczl(bczc parambczc) {}
  
  public void a(boolean paramBoolean1, int paramInt1, String arg3, List<GPadInfo> paramList, int paramInt2, boolean paramBoolean2)
  {
    ??? = this.a;
    ???.jdField_a_of_type_Int -= 1;
    if ((paramBoolean1) && (paramInt1 == 0)) {
      for (;;)
      {
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          if (this.a.jdField_a_of_type_JavaUtilList != null)
          {
            this.a.jdField_a_of_type_JavaUtilList.clear();
            this.a.c = paramInt2;
            this.a.e = paramBoolean2;
            if (paramList == null) {
              break;
            }
            this.a.jdField_b_of_type_Int = paramList.size();
          }
        }
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
          ??? = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(???);
          return;
          this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
          continue;
          paramList = finally;
          throw paramList;
        }
      }
    }
    if (this.a.jdField_b_of_type_Boolean) {}
    for (??? = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);; ??? = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczl
 * JD-Core Version:    0.7.0.1
 */