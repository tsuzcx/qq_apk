import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;

public class axws
{
  public int a;
  public axwu a;
  public axwv a;
  public AppInterface a;
  public int b;
  
  public axws(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.4.10");
      paramReqBody.original_id.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public axws a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public axws a(axwu paramaxwu)
  {
    this.jdField_a_of_type_Axwu = paramaxwu;
    return this;
  }
  
  public axws a(axwv paramaxwv)
  {
    this.jdField_a_of_type_Axwv = paramaxwv;
    return this;
  }
  
  public axws a(byte[] paramArrayOfByte)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody))
    {
      localReqBody.cmd.set(this.jdField_a_of_type_Int);
      localReqBody.subcmd.set(this.b);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      ntb.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new axwt(this), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
    return this;
  }
  
  public axws b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axws
 * JD-Core Version:    0.7.0.1
 */