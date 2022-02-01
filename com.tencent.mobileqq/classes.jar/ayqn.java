import com.tencent.mobileqq.nearby.now.model.MedalItem;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.MedalInfo;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RichTitleElement;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class ayqn
{
  public int a;
  public long a;
  public MedalItem a;
  public String a;
  public List<NowQQLiveHomepageProto.RichTitleElement> a;
  public boolean a;
  public int b;
  private long b = -1L;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e = -16711936;
  public String e;
  public int f = -16711936;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l = "NOW达人";
  public String m;
  public String n;
  public String o;
  private String p;
  
  public ayqn()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public String a()
  {
    if (this.p == null) {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break label37;
      }
    }
    label37:
    String str;
    for (this.p = "";; this.p = str)
    {
      return this.p;
      str = "";
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      if (i1 < i2)
      {
        NowQQLiveHomepageProto.RichTitleElement localRichTitleElement = (NowQQLiveHomepageProto.RichTitleElement)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localRichTitleElement.uint32_type.get() == 2) {}
        for (;;)
        {
          i1 += 1;
          break;
          str = localRichTitleElement.string_text.get();
        }
      }
    }
  }
  
  public void a(List<NowQQLiveHomepageProto.MedalInfo> paramList)
  {
    paramList = (NowQQLiveHomepageProto.MedalInfo)paramList.get(0);
    if (paramList.medal_type.get() != 3)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem == null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem = new MedalItem();
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem.jdField_a_of_type_Int = paramList.medal_id.get();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem.b = paramList.medal_version.get();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem.c = paramList.medal_type.get();
      if (paramList.medal_name.has()) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem.jdField_a_of_type_JavaLangString = paramList.medal_name.get().toStringUtf8();
      }
      if (paramList.medal_bg.has()) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem.e = paramList.medal_bg.get();
      }
      if (paramList.medal_frame.has()) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem.f = paramList.medal_frame.get();
      }
      if (paramList.medal_level.has()) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalItem.g = paramList.medal_level.get();
      }
    }
  }
  
  public String b()
  {
    if ((a() != null) && (this.p.length() > 0)) {
      return this.p;
    }
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqn
 * JD-Core Version:    0.7.0.1
 */