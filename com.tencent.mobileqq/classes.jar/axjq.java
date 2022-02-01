import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.2;
import com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO;
import com.tencent.mobileqq.now.wnsilivehead.WnsHeadProto.ForwardReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class axjq
{
  private static axjq jdField_a_of_type_Axjq;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WebServiceSSO jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static axjq a()
  {
    if (jdField_a_of_type_Axjq == null)
    {
      jdField_a_of_type_Axjq = new axjq();
      jdField_a_of_type_Axjq.a(false);
    }
    return jdField_a_of_type_Axjq;
  }
  
  private WnsHeadProto.ForwardReq a(byte[] paramArrayOfByte)
  {
    WnsHeadProto.ForwardReq localForwardReq = new WnsHeadProto.ForwardReq();
    localForwardReq.platform.set(16130);
    localForwardReq.busi_buf.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardReq.version.set(axjs.a());
    localForwardReq.version_code.set(axjs.a());
    localForwardReq.a2.set(axjz.a().d());
    localForwardReq.uid.set(axjz.a().b());
    localForwardReq.tinyid.set(axjz.a().c());
    localForwardReq.stream_type.set(1);
    localForwardReq.original_id.set(String.valueOf(axjz.a()));
    localForwardReq.original_id_type.set(1);
    localForwardReq.original_key.set(axjz.b());
    if (this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO.a()) {
      localForwardReq.target_env.set(1);
    }
    return localForwardReq;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Axjq != null)
    {
      jdField_a_of_type_Axjq.a();
      jdField_a_of_type_Axjq = null;
    }
  }
  
  protected void a()
  {
    c();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, axjt paramaxjt)
  {
    String str = String.format("0x%x_0x%x", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramArrayOfByte = a(paramArrayOfByte);
    Log.i("ChannelCenter", "WebServiceSSO--start send cmd=" + paramInt1);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO.a(str, paramArrayOfByte.toByteArray(), new axjr(this, paramInt1, paramaxjt));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte.getMessage();
      Log.i("ChannelCenter", paramArrayOfByte);
      this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCenter.2(this, paramInt1, paramaxjt, paramArrayOfByte));
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 1400015341;
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int j = 7747;; j = 3256)
    {
      axjz.a();
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO = new WebServiceSSO(i, j, String.valueOf(i), axjz.a(), "", 0);
      b(paramBoolean);
      return;
      i = 1400005918;
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO.a(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjq
 * JD-Core Version:    0.7.0.1
 */