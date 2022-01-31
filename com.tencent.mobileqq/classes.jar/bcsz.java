import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;
import tencent.im.troop.activity.troopactivity.ActSSORsp;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

public class bcsz
  implements BusinessObserver
{
  private final WeakReference<TroopMoreDetailView> a;
  
  public bcsz(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.a.get();
    if (localTroopMoreDetailView == null) {}
    label99:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: !isSuccess || mTroopInfoData == null");
            }
          }
          else {
            try
            {
              paramBundle = paramBundle.getByteArray("data");
              if (paramBundle != null) {
                break label99;
              }
              if (QLog.isColorLevel())
              {
                QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: data == null");
                return;
              }
            }
            catch (InvalidProtocolBufferMicroException paramBundle) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: InvalidProtocolBufferMicroException:" + paramBundle.getMessage());
      return;
      localObject = new troopactivity.ActSSORsp();
      ((troopactivity.ActSSORsp)localObject).mergeFrom(paramBundle);
      if (((troopactivity.ActSSORsp)localObject).err_code.get() == 10000) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("TroopMoreDetailView", 2, "mGetTroopActivityObserver: errorcode:" + ((troopactivity.ActSSORsp)localObject).err_code.get() + ", msg:" + ((troopactivity.ActSSORsp)localObject).err_msg.get());
    return;
    paramBundle = ((troopactivity.ActSSORsp)localObject).body.get().toByteArray();
    Object localObject = new troopactivity.GroupInfoCardResp();
    ((troopactivity.GroupInfoCardResp)localObject).mergeFrom(paramBundle);
    TroopMoreDetailView.a(localTroopMoreDetailView, (troopactivity.GroupInfoCardResp)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsz
 * JD-Core Version:    0.7.0.1
 */