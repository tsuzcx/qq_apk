import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class bfcu
  implements BasicMessageChannel.MessageHandler<ByteBuffer>
{
  bfcu(bfcr parambfcr) {}
  
  public void a(ByteBuffer paramByteBuffer, BasicMessageChannel.Reply<ByteBuffer> paramReply)
  {
    betc.c("miniapp-TISSUE", new String(paramByteBuffer.array(), Charset.forName("utf8")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcu
 * JD-Core Version:    0.7.0.1
 */