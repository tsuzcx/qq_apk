import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class beuf
  implements bexj
{
  beuf(boolean paramBoolean, String paramString, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          bcef.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B448", "0X800B448", 0, 0, String.valueOf(beue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString)), String.valueOf(this.jdField_a_of_type_Long), "1", "");
          if ((paramInt != 0) && (BaseActivity.sTopActivity != null))
          {
            if (paramInt != 41005) {
              break label171;
            }
            if (this.jdField_a_of_type_Boolean) {
              QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131719297), 0).a();
            }
          }
          paramString = (bety)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(171);
          if (paramString != null) {
            break;
          }
        }
        else
        {
          bcef.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B448", "0X800B448", 0, 0, String.valueOf(beue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString)), String.valueOf(this.jdField_a_of_type_Long), "2", "");
          continue;
        }
        if (paramInt != 41020) {
          break label203;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label171:
      QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131719298), 0).a();
      continue;
      label203:
      if ((paramInt != 41004) && (paramInt != 41005) && (paramInt != 41012)) {
        QQToast.a(BaseActivity.sTopActivity, 1, BaseApplicationImpl.getContext().getResources().getString(2131719299), 0).a();
      }
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        paramString.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), (int)((TroopInfo)localObject).dwGroupClassExt, new Long(this.jdField_a_of_type_Long));
      }
    }
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    a(paramInt, paramString);
  }
  
  public void a(Object paramObject)
  {
    a(0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beuf
 * JD-Core Version:    0.7.0.1
 */