import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class amxc
  implements amxk
{
  amxc(int[] paramArrayOfInt, amhd paramamhd, int paramInt, AppInterface paramAppInterface, amxk paramamxk, boolean paramBoolean) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    File localFile;
    if (paramBoolean) {
      if (BaseApplicationImpl.sProcessId == 1)
      {
        localFile = new File(amxb.a(1, paramInt1), "dress.zip");
        if ((localFile.exists()) && (paramInt1 == 0)) {}
      }
    }
    do
    {
      for (;;)
      {
        try
        {
          paramArrayOfInt = ancb.f;
          localStringBuilder = new StringBuilder();
        }
        catch (Exception paramArrayOfInt)
        {
          StringBuilder localStringBuilder;
          int[] arrayOfInt;
          int j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage(), paramArrayOfInt);
          continue;
        }
        catch (OutOfMemoryError paramArrayOfInt)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage());
          continue;
          if (this.jdField_a_of_type_Amxk == null) {
            continue;
          }
          this.jdField_a_of_type_Amxk.onDownLoadFinish(true, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
          return;
        }
        try
        {
          new File(paramArrayOfInt).mkdirs();
          arrayOfInt = amxb.a(paramInt1);
          j = nmk.a(localFile, paramArrayOfInt, new amxd(this, localStringBuilder, paramArrayOfInt));
          if ((arrayOfInt != null) && (arrayOfInt.length > 0))
          {
            int k = arrayOfInt.length;
            int i = 0;
            if (i < k)
            {
              int m = arrayOfInt[i];
              amxb.a(this.jdField_a_of_type_Amhd, 2, m);
              i += 1;
              continue;
              paramArrayOfInt = ancb.c + "/def/dress/";
              continue;
            }
          }
          localStringBuilder.append(", unzipRet: ").append(j);
          QLog.d("ApolloResDownloader", 1, "downloadApolloResOrder succ roleId: " + this.jdField_a_of_type_Int + ", unzipRoleDress: " + localStringBuilder.toString() + ", uin: " + paramString);
          if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
          {
            amxb.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_Amxk, -1, this.jdField_a_of_type_ArrayOfInt, -1, -1, this.jdField_a_of_type_Boolean);
            return;
          }
        }
        finally {}
      }
      if (this.jdField_a_of_type_Amxk != null) {
        this.jdField_a_of_type_Amxk.onDownLoadFinish(false, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role fail id: " + this.jdField_a_of_type_Int + ", uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxc
 * JD-Core Version:    0.7.0.1
 */