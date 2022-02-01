import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class azke
  implements Comparable<azke>
{
  public int a;
  public ahtv a;
  public azjx a;
  public azjz a;
  public azkn a;
  public azkx a;
  public MessageForPic a;
  public PicMessageExtraData a;
  public CompressInfo a;
  public String a;
  public ArrayList<azjz> a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 1;
  public int f = this.e;
  
  public azke()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(azke paramazke)
  {
    if (this.e < paramazke.e) {
      return -1;
    }
    if (this.e > paramazke.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(azkx paramazkx)
  {
    this.jdField_a_of_type_Azkx = paramazkx;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Azkn != null) {
      this.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Azjx != null) {
      this.jdField_a_of_type_Azjx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList<azjz> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      azjq.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      azjz localazjz = (azjz)localIterator.next();
      if (localazjz != null)
      {
        if (localazjz.jdField_a_of_type_Azkn != null)
        {
          localazjz.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localazjz.jdField_a_of_type_Azkn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        if (localazjz.jdField_a_of_type_Azjx != null)
        {
          localazjz.jdField_a_of_type_Azjx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localazjz.jdField_a_of_type_Azjx.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = azjq.a(((azjz)paramArrayList.get(0)).jdField_a_of_type_Azkn.jdField_b_of_type_Int, 2, 1);
  }
  
  public boolean a(azjz paramazjz)
  {
    if (paramazjz == null)
    {
      azjq.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramazjz.jdField_a_of_type_Azkn != null)
    {
      paramazjz.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramazjz.jdField_a_of_type_Azkn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (paramazjz.jdField_a_of_type_Azjx != null)
    {
      paramazjz.jdField_a_of_type_Azjx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramazjz.jdField_a_of_type_Azjx.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Azjz = paramazjz;
    int i = -1;
    if (paramazjz.jdField_a_of_type_Azkn != null) {
      i = paramazjz.jdField_a_of_type_Azkn.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = azjq.a(i, 2, 1);
    return true;
  }
  
  public boolean a(azkn paramazkn)
  {
    if (paramazkn == null)
    {
      azjq.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramazkn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramazkn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Azkn = paramazkn;
    this.jdField_b_of_type_JavaLangString = azjq.a(this.jdField_a_of_type_Azkn.jdField_b_of_type_Int, 1, 1);
    return true;
  }
  
  public boolean a(MessageForPic paramMessageForPic, azjx paramazjx)
  {
    if (paramazjx == null)
    {
      azjq.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramazjx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramazjx.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramazjx.c = paramMessageForPic.time;
    paramazjx.d = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_Azjx = paramazjx;
    int i;
    if (this.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_Azjx.e = "chatthumb";
      i = 65537;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = azjq.a(this.jdField_a_of_type_Azjx.jdField_b_of_type_Int, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
      return true;
      if (this.jdField_a_of_type_Int == 7)
      {
        i = 131075;
        this.jdField_a_of_type_Azjx.e = "chatraw";
      }
      else
      {
        if (this.jdField_a_of_type_Int == 6) {
          this.jdField_a_of_type_Azjx.e = "chatimg";
        }
        i = 1;
      }
    }
  }
  
  public boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {}
    do
    {
      return false;
      paramCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    } while (paramCompressInfo.c == null);
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azke
 * JD-Core Version:    0.7.0.1
 */