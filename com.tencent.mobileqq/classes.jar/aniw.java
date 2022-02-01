import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aniw
  implements anje
{
  aniw(int[] paramArrayOfInt, amsx paramamsx, int paramInt, AppInterface paramAppInterface, anje paramanje, boolean paramBoolean) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    File localFile;
    if (paramBoolean) {
      if (BaseApplicationImpl.sProcessId == 1)
      {
        paramArrayOfInt = new File(aniv.a(1, paramInt1), "dress.zip");
        localFile = new File(aniv.a(1, paramInt1), System.currentTimeMillis() + "dress.zip");
        bhmi.a(paramArrayOfInt, localFile);
        if ((localFile.exists()) && (paramInt1 == 0)) {}
      }
    }
    do
    {
      for (;;)
      {
        try
        {
          paramArrayOfInt = annv.f;
          localStringBuilder = new StringBuilder();
        }
        catch (Exception paramArrayOfInt)
        {
          StringBuilder localStringBuilder;
          int[] arrayOfInt;
          int j;
          bhmi.a(localFile);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage(), paramArrayOfInt);
          continue;
        }
        catch (OutOfMemoryError paramArrayOfInt)
        {
          bhmi.a(localFile);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder unZipFile file error resType->" + paramInt1 + " error->" + paramArrayOfInt.getMessage());
          continue;
          if (this.jdField_a_of_type_Anje == null) {
            continue;
          }
          this.jdField_a_of_type_Anje.onDownLoadFinish(true, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
          return;
        }
        try
        {
          new File(paramArrayOfInt).mkdirs();
          arrayOfInt = aniv.a(paramInt1);
          j = nof.a(localFile, paramArrayOfInt, new anix(this, localStringBuilder, paramArrayOfInt));
          if ((arrayOfInt != null) && (arrayOfInt.length > 0))
          {
            int k = arrayOfInt.length;
            int i = 0;
            if (i < k)
            {
              int m = arrayOfInt[i];
              aniv.a(this.jdField_a_of_type_Amsx, 2, m);
              i += 1;
              continue;
              paramArrayOfInt = annv.c + "/def/dress/";
              continue;
            }
          }
          bhmi.a(localFile);
          localStringBuilder.append(", unzipRet: ").append(j);
          QLog.d("ApolloResDownloader", 1, "downloadApolloResOrder succ roleId: " + this.jdField_a_of_type_Int + ", unzipRoleDress: " + localStringBuilder.toString() + ", uin: " + paramString);
          if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
          {
            aniv.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_Anje, -1, this.jdField_a_of_type_ArrayOfInt, -1, -1, this.jdField_a_of_type_Boolean);
            return;
          }
        }
        finally {}
      }
      if (this.jdField_a_of_type_Anje != null) {
        this.jdField_a_of_type_Anje.onDownLoadFinish(false, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloResOrder down load role fail id: " + this.jdField_a_of_type_Int + ", uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aniw
 * JD-Core Version:    0.7.0.1
 */