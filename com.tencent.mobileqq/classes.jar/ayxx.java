import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class ayxx
  implements Comparable<ayxx>
{
  public int a;
  public ahur a;
  public ayxp a;
  public ayxr a;
  public ayyg a;
  public ayyq a;
  public MessageForPic a;
  public PicMessageExtraData a;
  public CompressInfo a;
  public String a;
  public ArrayList<ayxr> a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 1;
  public int f = this.e;
  
  public ayxx()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(ayxx paramayxx)
  {
    if (this.e < paramayxx.e) {
      return -1;
    }
    if (this.e > paramayxx.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(ayyq paramayyq)
  {
    this.jdField_a_of_type_Ayyq = paramayyq;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Ayyg != null) {
      this.jdField_a_of_type_Ayyg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Ayxp != null) {
      this.jdField_a_of_type_Ayxp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList<ayxr> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ayxi.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      ayxr localayxr = (ayxr)localIterator.next();
      if (localayxr != null)
      {
        if (localayxr.jdField_a_of_type_Ayyg != null)
        {
          localayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        if (localayxr.jdField_a_of_type_Ayxp != null)
        {
          localayxr.jdField_a_of_type_Ayxp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localayxr.jdField_a_of_type_Ayxp.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = ayxi.a(((ayxr)paramArrayList.get(0)).jdField_a_of_type_Ayyg.jdField_b_of_type_Int, 2, 1);
  }
  
  public boolean a(ayxr paramayxr)
  {
    if (paramayxr == null)
    {
      ayxi.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramayxr.jdField_a_of_type_Ayyg != null)
    {
      paramayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (paramayxr.jdField_a_of_type_Ayxp != null)
    {
      paramayxr.jdField_a_of_type_Ayxp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramayxr.jdField_a_of_type_Ayxp.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Ayxr = paramayxr;
    int i = -1;
    if (paramayxr.jdField_a_of_type_Ayyg != null) {
      i = paramayxr.jdField_a_of_type_Ayyg.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = ayxi.a(i, 2, 1);
    return true;
  }
  
  public boolean a(ayyg paramayyg)
  {
    if (paramayyg == null)
    {
      ayxi.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramayyg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramayyg.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ayyg = paramayyg;
    this.jdField_b_of_type_JavaLangString = ayxi.a(this.jdField_a_of_type_Ayyg.jdField_b_of_type_Int, 1, 1);
    return true;
  }
  
  public boolean a(MessageForPic paramMessageForPic, ayxp paramayxp)
  {
    if (paramayxp == null)
    {
      ayxi.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramayxp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramayxp.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramayxp.c = paramMessageForPic.time;
    paramayxp.d = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_Ayxp = paramayxp;
    int i;
    if (this.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_Ayxp.e = "chatthumb";
      i = 65537;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = ayxi.a(this.jdField_a_of_type_Ayxp.jdField_b_of_type_Int, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
      return true;
      if (this.jdField_a_of_type_Int == 7)
      {
        i = 131075;
        this.jdField_a_of_type_Ayxp.e = "chatraw";
      }
      else
      {
        if (this.jdField_a_of_type_Int == 6) {
          this.jdField_a_of_type_Ayxp.e = "chatimg";
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
 * Qualified Name:     ayxx
 * JD-Core Version:    0.7.0.1
 */