import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyRsp;

final class ardv
  extends ardw
{
  private WeakReference<ardt> a;
  
  private ardv(ardt paramardt)
  {
    this.a = new WeakReference(paramardt);
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
        ((ardt)this.a.get()).a = (j * 1000);
      }
    }
    return;
    label84:
    QLog.d(ardt.a(), 1, "send input status fail : " + paramObject);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.get() != null))
    {
      if ((!ardt.a((ardt)this.a.get())) && (paramBoolean2))
      {
        if (ardt.a((ardt)this.a.get()) != null) {
          ardt.a((ardt)this.a.get()).a(ardt.a((ardt)this.a.get()));
        }
        ardt.a((ardt)this.a.get()).a.addTextChangedListener(ardt.a((ardt)this.a.get()));
      }
      ardt.a((ardt)this.a.get(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardv
 * JD-Core Version:    0.7.0.1
 */