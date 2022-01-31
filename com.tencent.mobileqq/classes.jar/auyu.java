import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.FeedsProtocol.TopicCfg;
import com.tencent.pb.now.ilive_feeds_read.TopicCfg;
import java.util.List;

public class auyu
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public static avnx a(List<ilive_feeds_read.TopicCfg> paramList, avnx paramavnx)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (ilive_feeds_read.TopicCfg)paramList.get(0);
      paramavnx.a = new auyu();
      paramavnx.a.d(paramList.jump_url.get());
      paramavnx.a.b(paramList.topic_name.get());
      paramavnx.a.a(paramList.topic_desc.get());
      paramavnx.a.b(paramList.topic_parti_num.get());
      paramavnx.a.c(paramList.topic_pic_url.get());
      paramavnx.a.a(paramList.topic_tag.get());
      paramavnx.a.c(paramList.topic_type.get());
    }
    return paramavnx;
  }
  
  public static VideoData a(List<FeedsProtocol.TopicCfg> paramList, VideoData paramVideoData)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (FeedsProtocol.TopicCfg)paramList.get(0);
      paramVideoData.a = new auyu();
      paramVideoData.a.d(paramList.jump_url.get());
      paramVideoData.a.b(paramList.topic_name.get());
      paramVideoData.a.a(paramList.topic_desc.get());
      paramVideoData.a.b(paramList.topic_parti_num.get());
      paramVideoData.a.c(paramList.topic_pic_url.get());
      paramVideoData.a.a(paramList.topic_tag.get());
      paramVideoData.a.c(paramList.topic_type.get());
    }
    return paramVideoData;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auyu
 * JD-Core Version:    0.7.0.1
 */