import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class atpv
  implements Comparable<atpv>
{
  public int a;
  public adyk a;
  public atpn a;
  public atpp a;
  public atqd a;
  public atqn a;
  public MessageForPic a;
  public PicMessageExtraData a;
  public CompressInfo a;
  public String a;
  public ArrayList<atpp> a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 1;
  public int f = this.e;
  
  public atpv()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(atpv paramatpv)
  {
    if (this.e < paramatpv.e) {
      return -1;
    }
    if (this.e > paramatpv.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(atqn paramatqn)
  {
    this.jdField_a_of_type_Atqn = paramatqn;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Atqd != null) {
      this.jdField_a_of_type_Atqd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Atpn != null) {
      this.jdField_a_of_type_Atpn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList<atpp> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      atpg.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      atpp localatpp = (atpp)localIterator.next();
      if (localatpp != null)
      {
        if (localatpp.jdField_a_of_type_Atqd != null)
        {
          localatpp.jdField_a_of_type_Atqd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localatpp.jdField_a_of_type_Atqd.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        if (localatpp.jdField_a_of_type_Atpn != null)
        {
          localatpp.jdField_a_of_type_Atpn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localatpp.jdField_a_of_type_Atpn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = atpg.a(((atpp)paramArrayList.get(0)).jdField_a_of_type_Atqd.jdField_b_of_type_Int, 2, 1);
  }
  
  public boolean a(atpp paramatpp)
  {
    if (paramatpp == null)
    {
      atpg.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramatpp.jdField_a_of_type_Atqd != null)
    {
      paramatpp.jdField_a_of_type_Atqd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramatpp.jdField_a_of_type_Atqd.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (paramatpp.jdField_a_of_type_Atpn != null)
    {
      paramatpp.jdField_a_of_type_Atpn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramatpp.jdField_a_of_type_Atpn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Atpp = paramatpp;
    int i = -1;
    if (paramatpp.jdField_a_of_type_Atqd != null) {
      i = paramatpp.jdField_a_of_type_Atqd.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = atpg.a(i, 2, 1);
    return true;
  }
  
  public boolean a(atqd paramatqd)
  {
    if (paramatqd == null)
    {
      atpg.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramatqd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramatqd.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Atqd = paramatqd;
    this.jdField_b_of_type_JavaLangString = atpg.a(this.jdField_a_of_type_Atqd.jdField_b_of_type_Int, 1, 1);
    return true;
  }
  
  public boolean a(MessageForPic paramMessageForPic, atpn paramatpn)
  {
    if (paramatpn == null)
    {
      atpg.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramatpn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramatpn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramatpn.c = paramMessageForPic.time;
    paramatpn.d = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_Atpn = paramatpn;
    int i;
    if (this.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_Atpn.e = "chatthumb";
      i = 65537;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = atpg.a(this.jdField_a_of_type_Atpn.jdField_b_of_type_Int, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
      return true;
      if (this.jdField_a_of_type_Int == 7)
      {
        i = 131075;
        this.jdField_a_of_type_Atpn.e = "chatraw";
      }
      else
      {
        if (this.jdField_a_of_type_Int == 6) {
          this.jdField_a_of_type_Atpn.e = "chatimg";
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
 * Qualified Name:     atpv
 * JD-Core Version:    0.7.0.1
 */