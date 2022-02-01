package com.tencent.mobileqq.app;

import android.os.Bundle;
import anum;
import anur;
import anyw;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CardHandler$2
  implements Runnable
{
  public CardHandler$2(anum paramanum, Bundle paramBundle) {}
  
  public void run()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1279);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject = ((anyw)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
    anur localanur = new anur(this.this$0, null);
    anum.a(this.this$0, localanur, this.a);
    anum.b(this.this$0, localanur, this.a);
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "set detail card, field count = " + localanur.jdField_a_of_type_Int);
    }
    if (localanur.jdField_a_of_type_Int == 0)
    {
      this.this$0.notifyUI(31, true, new Object[] { Integer.valueOf(0), localObject });
      return;
    }
    localObject = ByteBuffer.allocate(localanur.b + 7);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.this$0.app.getCurrentAccountUin()));
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)localanur.jdField_a_of_type_Int);
    ((ByteBuffer)localObject).put(localanur.jdField_a_of_type_JavaNioByteBuffer.array(), 0, localanur.b);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = this.this$0.createToServiceMsg("OidbSvc.0x4ff_9");
    ((ToServiceMsg)localObject).extraData.putAll(this.a);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("isSetLoginDays", false);
    ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
    ((ToServiceMsg)localObject).extraData.putLong("fieldFlag", localanur.jdField_a_of_type_Long);
    ((ToServiceMsg)localObject).setTimeout(20000L);
    this.this$0.sendPbReq((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.2
 * JD-Core Version:    0.7.0.1
 */