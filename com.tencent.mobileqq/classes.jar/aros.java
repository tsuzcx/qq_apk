import android.os.Bundle;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aros
  implements BusinessObserver
{
  public aros(UiApiPlugin paramUiApiPlugin) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    byte[] arrayOfByte;
    if (paramBoolean)
    {
      arrayOfByte = paramBundle.getByteArray("data");
      paramBundle.getString("openId");
      if (arrayOfByte != null) {
        paramBundle = new oidb_sso.OIDBSSOPkg();
      }
    }
    try
    {
      paramBundle = (oidb_sso.OIDBSSOPkg)paramBundle.mergeFrom((byte[])arrayOfByte);
      paramInt = paramBundle.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x716_48Rsp, resultCode:" + paramInt);
      }
      paramBundle = paramBundle.bytes_bodybuffer.get().toByteArray();
      if (paramInt == 0)
      {
        arrayOfByte = new byte[4];
        System.arraycopy(paramBundle, 0, arrayOfByte, 0, 4);
        paramBundle = TroopInfoActivity.a(String.valueOf(ByteBuffer.wrap(arrayOfByte).getInt() + ""), 32);
        bamn.a(this.a.a(), paramBundle, -1);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "pkg.mergeFrom:" + paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aros
 * JD-Core Version:    0.7.0.1
 */