import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import cooperation.qzone.share.QZoneShareActivity;

public class angu
  implements Runnable
{
  public angu(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    QQToast.a(this.a, this.a.a.msg.get(), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angu
 * JD-Core Version:    0.7.0.1
 */