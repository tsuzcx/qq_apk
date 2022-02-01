import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import java.util.List;

public class avnl
  implements RichProtoProc.RichProtoCallback
{
  public avnl(HotVideoData paramHotVideoData, avnn paramavnn, avnm paramavnm) {}
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null) {
      if (paramRichProtoResp.resps.size() > 0)
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.resps.get(0);
        this.jdField_a_of_type_Avnn.a(paramRichProtoReq);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Avnm.a(this.jdField_a_of_type_Avnn);
      return;
      this.jdField_a_of_type_Avnn.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Avnn.jdField_a_of_type_JavaLangString = "Unknown error！";
      continue;
      this.jdField_a_of_type_Avnn.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Avnn.jdField_a_of_type_JavaLangString = "Unknown error！";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avnl
 * JD-Core Version:    0.7.0.1
 */