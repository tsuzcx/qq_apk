import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyRsp;

final class asys
  extends asyt
{
  private WeakReference<asyq> a;
  
  private asys(asyq paramasyq)
  {
    this.a = new WeakReference(paramasyq);
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
        ((asyq)this.a.get()).a = (j * 1000);
      }
    }
    return;
    label84:
    QLog.d(asyq.a(), 1, "send input status fail : " + paramObject);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.get() != null))
    {
      if ((!asyq.a((asyq)this.a.get())) && (paramBoolean2))
      {
        if (asyq.a((asyq)this.a.get()) != null) {
          asyq.a((asyq)this.a.get()).a(asyq.a((asyq)this.a.get()));
        }
        asyq.a((asyq)this.a.get()).a.addTextChangedListener(asyq.a((asyq)this.a.get()));
      }
      asyq.a((asyq)this.a.get(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asys
 * JD-Core Version:    0.7.0.1
 */