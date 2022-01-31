import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class bdvv
  implements BasicMessageChannel.MessageHandler<ByteBuffer>
{
  bdvv(bdvs parambdvs) {}
  
  public void a(ByteBuffer paramByteBuffer, BasicMessageChannel.Reply<ByteBuffer> paramReply)
  {
    bdnw.c("miniapp-TISSUE", new String(paramByteBuffer.array(), Charset.forName("utf8")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdvv
 * JD-Core Version:    0.7.0.1
 */