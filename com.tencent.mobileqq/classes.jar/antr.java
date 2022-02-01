import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class antr
  extends MSFServlet
{
  private byte[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1274);
    localOIDBSSOPkg.uint32_service_type.set(7);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfString1.length * 2 + 4 + paramArrayOfString2.length * 4);
    int n = paramArrayOfString1.length;
    int i = (byte)(n >> 8 & 0xFF);
    int j = (byte)(n & 0xFF);
    byte[] arrayOfByte = new byte[paramArrayOfString1.length * 2];
    int i1 = 0;
    int i2 = paramArrayOfString1.length;
    n = 0;
    long l;
    while (n < i2)
    {
      l = Long.parseLong(paramArrayOfString1[n]);
      arrayOfByte[i1] = ((byte)(int)(l >> 8 & 0xFF));
      arrayOfByte[(i1 + 1)] = ((byte)(int)(l & 0xFF));
      i1 += 2;
      n += 1;
    }
    n = paramArrayOfString2.length;
    int k = (byte)(n >> 8 & 0xFF);
    int m = (byte)(n & 0xFF);
    i1 = 0;
    paramArrayOfString1 = new byte[n * 4];
    i2 = paramArrayOfString2.length;
    n = 0;
    while (n < i2)
    {
      l = Long.parseLong(paramArrayOfString2[n]);
      paramArrayOfString1[(i1 + 3)] = ((byte)(int)(0xFF & l));
      paramArrayOfString1[(i1 + 2)] = ((byte)(int)(l >> 8 & 0xFF));
      paramArrayOfString1[(i1 + 1)] = ((byte)(int)(l >> 16 & 0xFF));
      paramArrayOfString1[i1] = ((byte)(int)(l >> 24 & 0xFF));
      i1 += 4;
      n += 1;
    }
    localByteBuffer.put(new byte[] { i, j }).put(arrayOfByte).put(new byte[] { k, m }).put(paramArrayOfString1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfString1 = localOIDBSSOPkg.toByteArray();
    paramArrayOfString2 = ByteBuffer.allocate(paramArrayOfString1.length + 4);
    paramArrayOfString2.putInt(paramArrayOfString1.length + 4);
    paramArrayOfString2.put(paramArrayOfString1);
    return paramArrayOfString2.array();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramIntent.getIntExtra("key_cmd", -1);
    paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    switch (j)
    {
    default: 
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(arrayOfByte);
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(arrayOfByte);
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          bool = true;
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (bool)
          {
            arrayOfByte = new byte[2];
            paramFromServiceMsg.get(arrayOfByte);
            int k = bhbx.a(arrayOfByte, 0);
            int i = 0;
            if (i < k)
            {
              arrayOfByte = new byte[4];
              paramFromServiceMsg.get(arrayOfByte);
              localArrayList2.add(String.valueOf(bhbx.a(arrayOfByte, 0)));
              arrayOfByte = new byte[2];
              paramFromServiceMsg.get(arrayOfByte);
              long l = bhbx.a(arrayOfByte, 0);
              arrayOfByte = new byte[2];
              paramFromServiceMsg.get(arrayOfByte);
              l = bhbx.a(arrayOfByte, 0);
              arrayOfByte = new byte[2];
              paramFromServiceMsg.get(arrayOfByte);
              arrayOfByte = new byte[bhbx.a(arrayOfByte, 0)];
              paramFromServiceMsg.get(arrayOfByte);
              localArrayList1.add(new String(arrayOfByte, "utf-8"));
              i += 1;
              continue;
            }
          }
          localBundle.putStringArrayList("nickname_list", (ArrayList)localArrayList1);
          localBundle.putStringArrayList("uin_list", (ArrayList)localArrayList2);
          notifyObserver(paramIntent, j, bool, localBundle, zle.class);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_cmd", -1);
    String str = null;
    switch (i)
    {
    }
    for (paramIntent = str;; paramIntent = str)
    {
      if (paramIntent != null) {
        paramPacket.setSSOCommand(paramIntent);
      }
      return;
      str = "OidbSvc.0x4fa_7";
      paramPacket.putSendData(a(paramIntent.getStringArrayExtra("field_id"), paramIntent.getStringArrayExtra("uin_list")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antr
 * JD-Core Version:    0.7.0.1
 */