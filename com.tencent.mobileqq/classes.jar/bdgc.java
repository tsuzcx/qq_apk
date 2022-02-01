import QC.GetConciseThemeRsp;
import QC.ItemDisDetail;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.List;

final class bdgc
  implements anui
{
  bdgc(String paramString, AppInterface paramAppInterface, boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
    {
      paramObject = (GetConciseThemeRsp)paramObject;
      bdgb.a.clear();
      paramInt = 0;
      while (paramInt < paramObject.vItems.size())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)paramObject.vItems.get(paramInt);
        bdgb.a.add(localItemDisDetail.itemId + "");
        if (TextUtils.equals("2920", localItemDisDetail.itemId + "")) {
          bdgb.c = paramInt;
        }
        paramInt += 1;
      }
      paramInt = bdgb.a(this.jdField_a_of_type_JavaLangString);
      bdgb.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Boolean, 1);
      bdgb.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgc
 * JD-Core Version:    0.7.0.1
 */