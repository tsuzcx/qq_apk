import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class asfv
  extends mzz
{
  asfv(NearbyAppInterface paramNearbyAppInterface) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      auwq.b(this.a.getCurrentAccountUin(), false);
    }
    for (boolean bool1 = false;; bool1 = auwq.b(this.a.getCurrentAccountUin()))
    {
      paramArrayOfByte = new HashMap();
      paramArrayOfByte.put("param_reason", String.valueOf(paramInt));
      paramBundle = azri.a(BaseApplicationImpl.getContext());
      String str = this.a.getCurrentAccountUin();
      if (paramInt == 0) {
        bool2 = true;
      }
      paramBundle.a(str, "oidb_0x91f", bool2, 0L, 0L, paramArrayOfByte, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "oidb_0x91f| visible:" + bool1 + "replyCode:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfv
 * JD-Core Version:    0.7.0.1
 */