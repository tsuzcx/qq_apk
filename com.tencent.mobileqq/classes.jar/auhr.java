import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import java.util.List;

public class auhr
  implements RichProtoProc.RichProtoCallback
{
  public auhr(HotVideoData paramHotVideoData, auht paramauht, auhs paramauhs) {}
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null) {
      if (paramRichProtoResp.resps.size() > 0)
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.resps.get(0);
        this.jdField_a_of_type_Auht.a(paramRichProtoReq);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Auhs.a(this.jdField_a_of_type_Auht);
      return;
      this.jdField_a_of_type_Auht.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Auht.jdField_a_of_type_JavaLangString = "Unknown error！";
      continue;
      this.jdField_a_of_type_Auht.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Auht.jdField_a_of_type_JavaLangString = "Unknown error！";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhr
 * JD-Core Version:    0.7.0.1
 */