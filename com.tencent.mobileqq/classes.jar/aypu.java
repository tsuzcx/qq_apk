import android.os.Bundle;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aypu
  extends nkq
{
  public aypu(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramArrayOfByte = (oidb_sso.OIDBSSOPkg)paramBundle.mergeFrom((byte[])paramArrayOfByte);
        if (paramArrayOfByte != null)
        {
          paramInt = paramArrayOfByte.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.d("NearbyProfileFragment", 2, "handle_oidb_0x66b_0|oidb_sso.OIDBSSOPkg.result " + paramInt);
          }
        }
        paramBundle = new Oidb_0x66b.RspBody();
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
          paramArrayOfByte = new NearbyMyTabCard();
          if (!paramBundle.rpt_msg_vistor_info.has()) {
            break label307;
          }
          paramArrayOfByte.visitors.clear();
          paramBundle = paramBundle.rpt_msg_vistor_info.get().iterator();
          while (paramBundle.hasNext())
          {
            Object localObject = (appoint_define.PublisherInfo)paramBundle.next();
            if (localObject != null)
            {
              localObject = StrangerInfo.convertFrom((appoint_define.PublisherInfo)localObject);
              if (localObject != null) {
                paramArrayOfByte.visitors.add(localObject);
              }
            }
          }
          paramArrayOfByte = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("NearbyProfileFragment", 2, "handle_oidb_0x66b_0|oidb_sso parseFrom byte " + paramArrayOfByte.toString());
          }
          paramArrayOfByte = paramBundle;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NearbyProfileFragment", 2, "handle_oidb_0x66b_0|oidb_sso parseFrom byte " + paramArrayOfByte.toString());
          }
        }
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileFragment", 2, "handleGetNearbyMyTab visitor info is: " + paramArrayOfByte.visitors.toString());
    }
    for (;;)
    {
      NearbyProfileFragment.a(this.a, paramArrayOfByte.visitors);
      return;
      label307:
      if (QLog.isColorLevel()) {
        QLog.i("NearbyProfileFragment", 2, "handleGetNearbyMyTay has no visitor info.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypu
 * JD-Core Version:    0.7.0.1
 */