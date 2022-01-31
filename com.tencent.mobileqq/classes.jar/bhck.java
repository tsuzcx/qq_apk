import com.tencent.qqmini.sdk.log.QMLog;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class bhck
  implements BasicMessageChannel.MessageHandler<ByteBuffer>
{
  bhck(bhch parambhch) {}
  
  public void a(ByteBuffer paramByteBuffer, BasicMessageChannel.Reply<ByteBuffer> paramReply)
  {
    QMLog.w("miniapp-TISSUE", new String(paramByteBuffer.array(), Charset.forName("utf8")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhck
 * JD-Core Version:    0.7.0.1
 */