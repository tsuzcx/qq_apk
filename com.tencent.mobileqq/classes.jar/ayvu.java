import android.text.TextUtils;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.GetAnchorOnline1Req;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class ayvu
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public void a(ayvt paramayvt)
  {
    NowQQLiveFocusProto.GetAnchorOnline1Req localGetAnchorOnline1Req = new NowQQLiveFocusProto.GetAnchorOnline1Req();
    String str = aywr.a();
    if (TextUtils.isEmpty(str)) {}
    while (this.b) {
      return;
    }
    this.b = true;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= 3)
      {
        paramayvt.a(-1, "retry fail");
        return;
      }
    }
    localGetAnchorOnline1Req.uin.set(Long.parseLong(str));
    localGetAnchorOnline1Req.is_uid.set(1);
    localGetAnchorOnline1Req.source.set(1);
    localGetAnchorOnline1Req.need_kroom.set(0);
    aywi.a().a(28679, 2, localGetAnchorOnline1Req.toByteArray(), new ayvv(this, paramayvt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvu
 * JD-Core Version:    0.7.0.1
 */