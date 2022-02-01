import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aney
  implements anfg
{
  aney(int[] paramArrayOfInt, amme paramamme, int paramInt, AppInterface paramAppInterface, anfg paramanfg, boolean paramBoolean) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    File localFile;
    if (paramBoolean) {
      if (BaseApplicationImpl.sProcessId == 1)
      {
        paramArrayOfInt = new File(anex.a(1, paramInt1), "dress.zip");
        localFile = new File(anex.a(1, paramInt1), System.currentTimeMillis() + "dress.zip");
        FileUtils.copyFile(paramArrayOfInt, localFile);
        if (localFile.exists()) {
          if (paramInt1 != 0) {
            paramArrayOfInt = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/";
          }
        }
      }
    }
    do
    {
      for (;;)
      {
        try
        {
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
          if (this.jdField_a_of_type_Anfg == null) {
            continue;
          }
          this.jdField_a_of_type_Anfg.onDownLoadFinish(true, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
          return;
        }
        try
        {
          new File(paramArrayOfInt).mkdirs();
          arrayOfInt = anex.a(paramInt1);
          j = nwp.a(localFile, paramArrayOfInt, new anez(this, localStringBuilder, paramArrayOfInt));
          if ((arrayOfInt != null) && (arrayOfInt.length > 0))
          {
            int k = arrayOfInt.length;
            int i = 0;
            if (i < k)
            {
              int m = arrayOfInt[i];
              anex.a(this.jdField_a_of_type_Amme, 2, m);
              i += 1;
              continue;
              paramArrayOfInt = anka.a + "/def/dress/";
              continue;
            }
          }
          FileUtils.deleteFile(localFile);
          localStringBuilder.append(", unzipRet: ").append(j);
          QLog.d("ApolloResDownloader", 1, "downloadApolloResOrder succ roleId: " + this.jdField_a_of_type_Int + ", unzipRoleDress: " + localStringBuilder.toString() + ", uin: " + paramString);
          if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
          {
            anex.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_Anfg, -1, this.jdField_a_of_type_ArrayOfInt, -1, -1, this.jdField_a_of_type_Boolean);
            return;
          }
        }
        finally {}
      }
      if (this.jdField_a_of_type_Anfg != null) {
        this.jdField_a_of_type_Anfg.onDownLoadFinish(false, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role fail id: " + this.jdField_a_of_type_Int + ", uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aney
 * JD-Core Version:    0.7.0.1
 */