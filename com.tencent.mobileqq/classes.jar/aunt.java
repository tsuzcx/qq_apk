import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class aunt
  implements Comparable<aunt>
{
  public int a;
  public aejj a;
  public aunl a;
  public aunn a;
  public auob a;
  public auol a;
  public MessageForPic a;
  public PicMessageExtraData a;
  public CompressInfo a;
  public String a;
  public ArrayList<aunn> a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 1;
  public int f = this.e;
  
  public aunt()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(aunt paramaunt)
  {
    if (this.e < paramaunt.e) {
      return -1;
    }
    if (this.e > paramaunt.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(auol paramauol)
  {
    this.jdField_a_of_type_Auol = paramauol;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Auob != null) {
      this.jdField_a_of_type_Auob.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Aunl != null) {
      this.jdField_a_of_type_Aunl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList<aunn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      aune.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      aunn localaunn = (aunn)localIterator.next();
      if (localaunn != null)
      {
        if (localaunn.jdField_a_of_type_Auob != null)
        {
          localaunn.jdField_a_of_type_Auob.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localaunn.jdField_a_of_type_Auob.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        if (localaunn.jdField_a_of_type_Aunl != null)
        {
          localaunn.jdField_a_of_type_Aunl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localaunn.jdField_a_of_type_Aunl.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = aune.a(((aunn)paramArrayList.get(0)).jdField_a_of_type_Auob.jdField_b_of_type_Int, 2, 1);
  }
  
  public boolean a(aunn paramaunn)
  {
    if (paramaunn == null)
    {
      aune.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramaunn.jdField_a_of_type_Auob != null)
    {
      paramaunn.jdField_a_of_type_Auob.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaunn.jdField_a_of_type_Auob.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (paramaunn.jdField_a_of_type_Aunl != null)
    {
      paramaunn.jdField_a_of_type_Aunl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaunn.jdField_a_of_type_Aunl.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Aunn = paramaunn;
    int i = -1;
    if (paramaunn.jdField_a_of_type_Auob != null) {
      i = paramaunn.jdField_a_of_type_Auob.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = aune.a(i, 2, 1);
    return true;
  }
  
  public boolean a(auob paramauob)
  {
    if (paramauob == null)
    {
      aune.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramauob.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramauob.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Auob = paramauob;
    this.jdField_b_of_type_JavaLangString = aune.a(this.jdField_a_of_type_Auob.jdField_b_of_type_Int, 1, 1);
    return true;
  }
  
  public boolean a(MessageForPic paramMessageForPic, aunl paramaunl)
  {
    if (paramaunl == null)
    {
      aune.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramaunl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramaunl.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramaunl.c = paramMessageForPic.time;
    paramaunl.d = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_Aunl = paramaunl;
    int i;
    if (this.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_Aunl.e = "chatthumb";
      i = 65537;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = aune.a(this.jdField_a_of_type_Aunl.jdField_b_of_type_Int, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
      return true;
      if (this.jdField_a_of_type_Int == 7)
      {
        i = 131075;
        this.jdField_a_of_type_Aunl.e = "chatraw";
      }
      else
      {
        if (this.jdField_a_of_type_Int == 6) {
          this.jdField_a_of_type_Aunl.e = "chatimg";
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
 * Qualified Name:     aunt
 * JD-Core Version:    0.7.0.1
 */