import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import com.qq.jce.wup.UniPacket;
import java.util.ArrayList;

public abstract class bfqv
  implements bfqy
{
  private bfqw jdField_a_of_type_Bfqw;
  private bfra jdField_a_of_type_Bfra;
  
  private void a(MultiVideoMsg paramMultiVideoMsg)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("MultiVideo");
    localUniPacket.setFuncName("MultiVideos2cack");
    localUniPacket.put("MultiVideoMsg", paramMultiVideoMsg);
    j(localUniPacket.encode());
  }
  
  private void a(SharpVideoMsg paramSharpVideoMsg)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("SharpSvr");
    localUniPacket.setFuncName("s2cack");
    localUniPacket.put("SharpVideoMsg", paramSharpVideoMsg);
    h(localUniPacket.encode());
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Bfra != null) {
      bool = this.jdField_a_of_type_Bfra.isSharpVideoMsgSupport(paramInt);
    }
    return bool;
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Bfra != null) {
      bool = this.jdField_a_of_type_Bfra.isMultiVideoMsgSupport(paramInt);
    }
    return bool;
  }
  
  protected abstract long a();
  
  public void a()
  {
    b();
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    long l = a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong1));
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = 0;
    localMultiVideoMsg.type = 1;
    localMultiVideoMsg.csCmd = ((short)(int)paramLong2);
    localMultiVideoMsg.from_uin = l;
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.video_buff = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("MultiVideo");
    paramArrayOfByte.setFuncName("MultiVideoMsg");
    paramArrayOfByte.put("MultiVideoMsg", localMultiVideoMsg);
    i(paramArrayOfByte.encode());
  }
  
  public void a(bfqw parambfqw)
  {
    this.jdField_a_of_type_Bfqw = parambfqw;
  }
  
  public void a(bfra parambfra)
  {
    this.jdField_a_of_type_Bfra = parambfra;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Bfqw != null) {
      this.jdField_a_of_type_Bfqw.a(paramString, paramInt);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    long l = a();
    VideoCallMsg localVideoCallMsg = new VideoCallMsg();
    localVideoCallMsg.ver = 1;
    localVideoCallMsg.type = 1;
    localVideoCallMsg.lUin = l;
    localVideoCallMsg.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
    localVideoCallMsg.vMsg = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("VideoSvc");
    paramArrayOfByte.setFuncName("SendVideoMsg");
    paramArrayOfByte.put("VideoCallMsg", localVideoCallMsg);
    g(paramArrayOfByte.encode());
  }
  
  protected abstract void b();
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bfqw != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (SharpVideoMsg)localUniPacket.getByClass("SharpVideoMsg", new SharpVideoMsg());
      if (a(paramArrayOfByte.type))
      {
        a(paramArrayOfByte);
        this.jdField_a_of_type_Bfqw.b(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bfqw != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (SharpVideoMsg)localUniPacket.getByClass("SharpVideoMsg", new SharpVideoMsg());
      if (a(paramArrayOfByte.type)) {
        this.jdField_a_of_type_Bfqw.c(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bfqw != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (MultiVideoMsg)localUniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
      bfrg.c("VideoChannelBase", String.format("receiveMultiVideoMsg type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramArrayOfByte.type), Short.valueOf(paramArrayOfByte.csCmd) }));
      if (b(paramArrayOfByte.type))
      {
        a(paramArrayOfByte);
        this.jdField_a_of_type_Bfqw.d(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bfqw != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (MultiVideoMsg)localUniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
      bfrg.c("VideoChannelBase", String.format("receiveMultiVideoAck type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramArrayOfByte.type), Short.valueOf(paramArrayOfByte.csCmd) }));
      if (b(paramArrayOfByte.type)) {
        this.jdField_a_of_type_Bfqw.e(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bfqw != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (VideoCallMsg)localUniPacket.getByClass("VideoCallMsg", new VideoCallMsg());
      this.jdField_a_of_type_Bfqw.a(paramArrayOfByte.vMsg);
    }
  }
  
  protected abstract void g(byte[] paramArrayOfByte);
  
  protected abstract void h(byte[] paramArrayOfByte);
  
  protected abstract void i(byte[] paramArrayOfByte);
  
  protected abstract void j(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfqv
 * JD-Core Version:    0.7.0.1
 */