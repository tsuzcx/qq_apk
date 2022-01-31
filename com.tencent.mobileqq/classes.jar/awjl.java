import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class awjl
  implements Comparable<awjl>
{
  public int a;
  public agko a;
  public awjd a;
  public awjf a;
  public awju a;
  public awke a;
  public MessageForPic a;
  public PicMessageExtraData a;
  public CompressInfo a;
  public String a;
  public ArrayList<awjf> a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 1;
  public int f = this.e;
  
  public awjl()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(awjl paramawjl)
  {
    if (this.e < paramawjl.e) {
      return -1;
    }
    if (this.e > paramawjl.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(awke paramawke)
  {
    this.jdField_a_of_type_Awke = paramawke;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Awju != null) {
      this.jdField_a_of_type_Awju.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Awjd != null) {
      this.jdField_a_of_type_Awjd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList<awjf> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      awiw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      awjf localawjf = (awjf)localIterator.next();
      if (localawjf != null)
      {
        if (localawjf.jdField_a_of_type_Awju != null)
        {
          localawjf.jdField_a_of_type_Awju.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localawjf.jdField_a_of_type_Awju.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        if (localawjf.jdField_a_of_type_Awjd != null)
        {
          localawjf.jdField_a_of_type_Awjd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localawjf.jdField_a_of_type_Awjd.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = awiw.a(((awjf)paramArrayList.get(0)).jdField_a_of_type_Awju.jdField_b_of_type_Int, 2, 1);
  }
  
  public boolean a(awjf paramawjf)
  {
    if (paramawjf == null)
    {
      awiw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramawjf.jdField_a_of_type_Awju != null)
    {
      paramawjf.jdField_a_of_type_Awju.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramawjf.jdField_a_of_type_Awju.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (paramawjf.jdField_a_of_type_Awjd != null)
    {
      paramawjf.jdField_a_of_type_Awjd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramawjf.jdField_a_of_type_Awjd.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Awjf = paramawjf;
    int i = -1;
    if (paramawjf.jdField_a_of_type_Awju != null) {
      i = paramawjf.jdField_a_of_type_Awju.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = awiw.a(i, 2, 1);
    return true;
  }
  
  public boolean a(awju paramawju)
  {
    if (paramawju == null)
    {
      awiw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramawju.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramawju.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Awju = paramawju;
    this.jdField_b_of_type_JavaLangString = awiw.a(this.jdField_a_of_type_Awju.jdField_b_of_type_Int, 1, 1);
    return true;
  }
  
  public boolean a(MessageForPic paramMessageForPic, awjd paramawjd)
  {
    if (paramawjd == null)
    {
      awiw.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramawjd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramawjd.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramawjd.c = paramMessageForPic.time;
    paramawjd.d = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_Awjd = paramawjd;
    int i;
    if (this.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_Awjd.e = "chatthumb";
      i = 65537;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = awiw.a(this.jdField_a_of_type_Awjd.jdField_b_of_type_Int, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
      return true;
      if (this.jdField_a_of_type_Int == 7)
      {
        i = 131075;
        this.jdField_a_of_type_Awjd.e = "chatraw";
      }
      else
      {
        if (this.jdField_a_of_type_Int == 6) {
          this.jdField_a_of_type_Awjd.e = "chatimg";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjl
 * JD-Core Version:    0.7.0.1
 */