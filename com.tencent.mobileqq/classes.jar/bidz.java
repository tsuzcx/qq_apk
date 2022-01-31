import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

final class bidz
{
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final WeiyunPB.MsgHead jdField_a_of_type_CooperationWeiyunChannelPbWeiyunPB$MsgHead;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  bidz(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_CooperationWeiyunChannelPbWeiyunPB$MsgHead = a(paramInt);
  }
  
  bidz(WeiyunPB.MsgHead paramMsgHead, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_CooperationWeiyunChannelPbWeiyunPB$MsgHead = paramMsgHead;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  private WeiyunPB.MsgHead a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    WeiyunPB.MsgHead localMsgHead = new WeiyunPB.MsgHead();
    localMsgHead.uin.set(localAppRuntime.getLongAccountUin());
    localMsgHead.seq.set(a());
    localMsgHead.type.set(1);
    localMsgHead.cmd.set(paramInt);
    localMsgHead.emulator_flag.set(0);
    localMsgHead.appid.set(31532);
    localMsgHead.encrypt.set(0);
    localMsgHead.zip_flag.set(0);
    localMsgHead.version.set(bify.c());
    localMsgHead.fix_version.set(bify.d());
    localMsgHead.nettype.set(nao.a(localAppRuntime.getApplication()));
    localMsgHead.major_version.set(bify.a());
    localMsgHead.minor_version.set(bify.b());
    return localMsgHead;
  }
  
  public int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
  }
  
  public WeiyunPB.MsgHead a()
  {
    return this.jdField_a_of_type_CooperationWeiyunChannelPbWeiyunPB$MsgHead;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidz
 * JD-Core Version:    0.7.0.1
 */