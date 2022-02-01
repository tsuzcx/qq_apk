import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopGameInfo;
import com.tencent.mobileqq.troop.widget.TroopGameCardView;
import com.tencent.qphone.base.util.QLog;

public class bgpm
  extends aofu
{
  public bgpm(TroopGameCardView paramTroopGameCardView) {}
  
  protected void onGetTroopGameGameCard(boolean paramBoolean, String paramString, TroopGameInfo paramTroopGameInfo)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onGetTroopGameGameCard. isSuccess = ").append(paramBoolean).append(", hasGameInfo = ");
      if (paramTroopGameInfo != null)
      {
        bool = true;
        QLog.d("TroopGameCardView", 2, bool);
      }
    }
    else
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        ((QQAppInterface)localObject).removeObserver(this.a.jdField_a_of_type_Aofu);
      }
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        break label103;
      }
    }
    label103:
    do
    {
      return;
      bool = false;
      break;
      if (this.a.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        this.a.a(paramBoolean, paramTroopGameInfo);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopGameCardView", 2, "onGetTroopGameGameCard. troopUin doesn't match.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpm
 * JD-Core Version:    0.7.0.1
 */