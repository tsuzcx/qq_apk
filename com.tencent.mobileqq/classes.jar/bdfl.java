import QC.GetConciseThemeRsp;
import QC.ItemDisDetail;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.List;

final class bdfl
  implements BusinessObserver
{
  bdfl(String paramString, AppInterface paramAppInterface, boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
    {
      paramObject = (GetConciseThemeRsp)paramObject;
      bdfk.a.clear();
      paramInt = 0;
      while (paramInt < paramObject.vItems.size())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)paramObject.vItems.get(paramInt);
        bdfk.a.add(localItemDisDetail.itemId + "");
        if (TextUtils.equals("2920", localItemDisDetail.itemId + "")) {
          bdfk.c = paramInt;
        }
        paramInt += 1;
      }
      paramInt = bdfk.a(this.jdField_a_of_type_JavaLangString);
      bdfk.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Boolean, 1);
      bdfk.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfl
 * JD-Core Version:    0.7.0.1
 */