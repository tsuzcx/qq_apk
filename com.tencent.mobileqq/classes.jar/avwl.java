import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntRspBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;

public class avwl
{
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    byte[] arrayOfByte = new byte[paramMsfSocketInputBuffer.getBufferlen()];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 0, arrayOfByte, 0, arrayOfByte.length);
    a(arrayOfByte);
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length > 60))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler", 2, "decodeS2CData data error");
      }
      return false;
    }
    Object localObject = null;
    for (;;)
    {
      try
      {
        for (;;)
        {
          paramArrayOfByte = lgv.a(paramArrayOfByte);
          localObject = paramArrayOfByte.a;
          paramArrayOfByte = paramArrayOfByte.b;
          AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
          try
          {
            localObject = (AudioTransClientTransInfo.IntHead)localIntHead.mergeFrom((byte[])localObject);
            if (!((AudioTransClientTransInfo.IntHead)localObject).uint32_error_no.has()) {
              break label353;
            }
            i = ((AudioTransClientTransInfo.IntHead)localObject).uint32_error_no.get();
            if (((AudioTransClientTransInfo.IntHead)localObject).enum_body_type.has())
            {
              j = ((AudioTransClientTransInfo.IntHead)localObject).enum_body_type.get();
              long l = 0L;
              if (((AudioTransClientTransInfo.IntHead)localObject).str_session_id.has()) {
                l = Long.valueOf(((AudioTransClientTransInfo.IntHead)localObject).str_session_id.get()).longValue();
              }
              QLog.d("SubTitleProtocoDataCodec", 2, "onReceive result:" + i + " sessionid:" + l + " bodyType:" + j);
              paramArrayOfByte = (AudioTransClientTransInfo.IntRspBody)new AudioTransClientTransInfo.IntRspBody().mergeFrom(paramArrayOfByte);
              if (i == 0)
              {
                if ((j != 10) || (!QLog.isColorLevel())) {
                  break;
                }
                QLog.d("PeakAudioTransHandler", 2, "decodeS2CData INT_C2S_HEART_BEAT_RSP heartbeat !");
                return false;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
            QLog.e("SubTitleProtocoDataCodec", 2, "decodeS2CData exception = " + paramArrayOfByte.getMessage(), paramArrayOfByte);
            return false;
          }
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        QLog.e("SubTitleProtocoDataCodec", 2, "decodeS2CData OOM!!");
        paramArrayOfByte = (byte[])localObject;
        continue;
        paramArrayOfByte = (AudioTransClientTransInfo.IntC2SFailedRsp)paramArrayOfByte.msg_failed_rsp.get();
        QLog.d("SubTitleProtocoDataCodec", 2, "create session rsp fail msg: " + ((AudioTransClientTransInfo.IntHead)localObject).uint32_error_no.get() + " uint32_errcode = " + paramArrayOfByte.uint32_errcode.get() + " str_errmsg = " + paramArrayOfByte.str_errmsg.get());
        return false;
      }
      int j = 0;
      continue;
      label353:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avwl
 * JD-Core Version:    0.7.0.1
 */