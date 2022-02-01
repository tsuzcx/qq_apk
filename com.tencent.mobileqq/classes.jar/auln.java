import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyRsp;

final class auln
  extends aulo
{
  private WeakReference<aull> a;
  
  private auln(aull paramaull)
  {
    this.a = new WeakReference(paramaull);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (((paramObject instanceof cmd0xcd4.InputNotifyRsp)) && (paramBoolean))
    {
      paramObject = (cmd0xcd4.InputNotifyRsp)paramObject;
      int i = paramObject.sint32_result.get();
      int j = paramObject.uint32_interval.get();
      paramObject = paramObject.bytes_err_msg.get().toStringUtf8();
      if (i != 0) {
        break label84;
      }
      if ((j > 0) && (this.a.get() != null)) {
        ((aull)this.a.get()).a = (j * 1000);
      }
    }
    return;
    label84:
    QLog.d(aull.a(), 1, "send input status fail : " + paramObject);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.get() != null))
    {
      if ((!aull.a((aull)this.a.get())) && (paramBoolean2))
      {
        if (aull.a((aull)this.a.get()) != null) {
          aull.a((aull)this.a.get()).a(aull.a((aull)this.a.get()));
        }
        aull.a((aull)this.a.get()).input.addTextChangedListener(aull.a((aull)this.a.get()));
      }
      aull.a((aull)this.a.get(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auln
 * JD-Core Version:    0.7.0.1
 */