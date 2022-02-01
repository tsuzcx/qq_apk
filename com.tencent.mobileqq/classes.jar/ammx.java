import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import org.jetbrains.annotations.Nullable;

public class ammx
  implements amvj
{
  private long jdField_a_of_type_Long;
  private amvj jdField_a_of_type_Amvj;
  private ApolloActionData jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
  
  public ammx(ApolloActionData paramApolloActionData, amvj paramamvj, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
    this.jdField_a_of_type_Amvj = paramamvj;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable Error paramError)
  {
    QLog.d("ApolloManager", 1, "ApolloManager onComplete success:" + paramBoolean + ", path:" + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      String str = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, 10);
      if (FileUtils.copyFile(paramString, str))
      {
        QLog.d("ApolloManager", 1, "handleCMSPlayerGetFrame save success : " + str + "; const : " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        if (this.jdField_a_of_type_Amvj != null) {
          this.jdField_a_of_type_Amvj.a(true, paramString, paramError);
        }
        return;
      }
      QLog.d("ApolloManager", 1, "handleCMSPlayerGetFrame copyFile failed.");
    }
    for (;;)
    {
      amme.a().remove(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId));
      if (this.jdField_a_of_type_Amvj == null) {
        break;
      }
      this.jdField_a_of_type_Amvj.a(false, paramString, paramError);
      return;
      QLog.d("ApolloManager", 1, "handleCMSPlayerGetFrame file not exists.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammx
 * JD-Core Version:    0.7.0.1
 */