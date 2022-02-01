import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class amdq
  implements amdy
{
  amdq(int[] paramArrayOfInt, alnr paramalnr, int paramInt, AppInterface paramAppInterface, amdy paramamdy, boolean paramBoolean) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    File localFile;
    if (paramBoolean) {
      if (BaseApplicationImpl.sProcessId == 1)
      {
        paramArrayOfInt = new File(amdp.a(1, paramInt1), "dress.zip");
        localFile = new File(amdp.a(1, paramInt1), System.currentTimeMillis() + "dress.zip");
        FileUtils.copyFile(paramArrayOfInt, localFile);
        if ((localFile.exists()) && (paramInt1 == 0)) {}
      }
    }
    do
    {
      for (;;)
      {
        try
        {
          paramArrayOfInt = amip.f;
          localStringBuilder = new StringBuilder();
        }
        catch (Exception paramArrayOfInt)
        {
          StringBuilder localStringBuilder;
          int[] arrayOfInt;
          int j;
          FileUtils.deleteFile(localFile);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage(), paramArrayOfInt);
          continue;
        }
        catch (OutOfMemoryError paramArrayOfInt)
        {
          FileUtils.deleteFile(localFile);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage());
          continue;
          if (this.jdField_a_of_type_Amdy == null) {
            continue;
          }
          this.jdField_a_of_type_Amdy.onDownLoadFinish(true, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
          return;
        }
        try
        {
          new File(paramArrayOfInt).mkdirs();
          arrayOfInt = amdp.a(paramInt1);
          j = npo.a(localFile, paramArrayOfInt, new amdr(this, localStringBuilder, paramArrayOfInt));
          if ((arrayOfInt != null) && (arrayOfInt.length > 0))
          {
            int k = arrayOfInt.length;
            int i = 0;
            if (i < k)
            {
              int m = arrayOfInt[i];
              amdp.a(this.jdField_a_of_type_Alnr, 2, m);
              i += 1;
              continue;
              paramArrayOfInt = amip.c + "/def/dress/";
              continue;
            }
          }
          FileUtils.deleteFile(localFile);
          localStringBuilder.append(", unzipRet: ").append(j);
          QLog.d("ApolloResDownloader", 1, "downloadApolloResOrder succ roleId: " + this.jdField_a_of_type_Int + ", unzipRoleDress: " + localStringBuilder.toString() + ", uin: " + paramString);
          if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
          {
            amdp.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_Amdy, -1, this.jdField_a_of_type_ArrayOfInt, -1, -1, this.jdField_a_of_type_Boolean);
            return;
          }
        }
        finally {}
      }
      if (this.jdField_a_of_type_Amdy != null) {
        this.jdField_a_of_type_Amdy.onDownLoadFinish(false, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role fail id: " + this.jdField_a_of_type_Int + ", uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdq
 * JD-Core Version:    0.7.0.1
 */