import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

final class amkg
  implements amdy
{
  amkg(String paramString, String[] paramArrayOfString, amkd paramamkd, int paramInt) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloHttpUtil", 2, "fakeResource3DUrlRequest onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramArrayOfInt = new File(this.jdField_a_of_type_JavaLangString);
      if (paramArrayOfInt.exists()) {
        try
        {
          paramString = amke.a(this.jdField_a_of_type_ArrayOfJavaLangString);
          if (amke.a(this.jdField_a_of_type_JavaLangString))
          {
            paramArrayOfInt = amke.a(paramArrayOfInt, paramString);
            this.jdField_a_of_type_Amkd.a(0, paramString, paramArrayOfInt);
          }
          while (QLog.isColorLevel())
          {
            QLog.d("ApolloHttpUtil", 2, new Object[] { "fakeResource3DUrlRequest onDownLoadFinish retHeader:", paramString + " id:" + this.jdField_a_of_type_Int });
            return;
            this.jdField_a_of_type_Amkd.a(0, paramString, ApolloRender.readStream(new FileInputStream(paramArrayOfInt)));
          }
          this.jdField_a_of_type_Amkd.a(-1, null, null);
        }
        catch (Exception paramString)
        {
          QLog.e("ApolloHttpUtil", 1, paramString, new Object[0]);
          return;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Amkd.a(-1, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkg
 * JD-Core Version:    0.7.0.1
 */