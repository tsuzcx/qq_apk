import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ankw
{
  public String a;
  public final HashMap<String, String> a;
  public final List<anky> a;
  public String b;
  
  public ankw()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public String a(boolean paramBoolean)
  {
    if (!a()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i < j)
        {
          anky localanky = (anky)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localanky == null) || (TextUtils.isEmpty(localanky.jdField_a_of_type_JavaLangString))) {
            break label397;
          }
          if ((localanky.jdField_a_of_type_Int != 6) && (localanky.jdField_a_of_type_Int != 7)) {
            break label236;
          }
          if (TextUtils.isEmpty(Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter(localanky.b))) {
            break label397;
          }
          if (paramBoolean)
          {
            localStringBuilder.append(blhn.a(localanky.jdField_a_of_type_JavaLangString)).append("=").append(blhn.a(localanky.b));
            if (i == j - 1) {
              break label397;
            }
            localStringBuilder.append("&");
            break label397;
          }
          localStringBuilder.append(localanky.jdField_a_of_type_JavaLangString).append("=").append(localanky.b);
          continue;
        }
        if (localException.jdField_a_of_type_Int != 8) {
          break label318;
        }
      }
      catch (Exception localException)
      {
        QLog.e("apollo_client_ApolloSSOConfig", 1, localException, new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, new Object[] { "getParameterStr parameterBuilder:", localStringBuilder.toString() });
        }
        return localStringBuilder.toString();
      }
      label236:
      if (paramBoolean) {
        localStringBuilder.append(blhn.a(localException.jdField_a_of_type_JavaLangString)).append("=").append(System.currentTimeMillis());
      }
      while (i != j - 1)
      {
        localStringBuilder.append("&");
        break;
        localStringBuilder.append(localException.jdField_a_of_type_JavaLangString).append("=").append(System.currentTimeMillis());
        continue;
        label318:
        if (paramBoolean) {
          localStringBuilder.append(blhn.a(localException.jdField_a_of_type_JavaLangString)).append("=").append(blhn.a(localException.b));
        }
        while (i != j - 1)
        {
          localStringBuilder.append("&");
          break;
          localStringBuilder.append(localException.jdField_a_of_type_JavaLangString).append("=").append(localException.b);
        }
      }
      label397:
      i += 1;
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("CGIConfig{");
    localStringBuffer.append("mUrl='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mMethod='").append(this.b).append('\'');
    localStringBuffer.append(", mHeaders=").append(this.jdField_a_of_type_JavaUtilHashMap);
    localStringBuffer.append(", mParameters=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankw
 * JD-Core Version:    0.7.0.1
 */