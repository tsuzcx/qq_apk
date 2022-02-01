import com.tencent.mobileqq.apollo.ApolloResManager.5;
import java.util.HashMap;

public class amoa
  implements anfg
{
  public amoa(ApolloResManager.5 param5, HashMap paramHashMap) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((paramBoolean) && (paramArrayOfInt != null))
    {
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt.length)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramArrayOfInt[paramInt1]), "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + paramArrayOfInt[paramInt1]);
        paramInt1 += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloResManager$5.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloResManager$5.a.onGetApolloDressInfo(this.jdField_a_of_type_JavaUtilHashMap, "success", 0);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloResManager$5.a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloResManager$5.a.onGetApolloDressInfo(null, "download error", -5003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoa
 * JD-Core Version:    0.7.0.1
 */