import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigCorpSimpleInfo;

public class binm
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  
  public binm(mobileqq_qidian.ConfigCorpSimpleInfo paramConfigCorpSimpleInfo)
  {
    if (paramConfigCorpSimpleInfo.str_corp_name.has()) {
      this.a = paramConfigCorpSimpleInfo.str_corp_name.get();
    }
    if (paramConfigCorpSimpleInfo.str_short_name.has()) {
      this.b = paramConfigCorpSimpleInfo.str_short_name.get();
    }
    if (paramConfigCorpSimpleInfo.str_detail_desc.has()) {
      this.c = paramConfigCorpSimpleInfo.str_detail_desc.get();
    }
    if (paramConfigCorpSimpleInfo.str_click_url.has()) {
      this.d = paramConfigCorpSimpleInfo.str_click_url.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     binm
 * JD-Core Version:    0.7.0.1
 */