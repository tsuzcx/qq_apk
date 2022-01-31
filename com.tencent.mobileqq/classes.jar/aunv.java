import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class aunv
  implements Comparable<aunv>
{
  public int a;
  public aejh a;
  public aunn a;
  public aunp a;
  public auod a;
  public auon a;
  public MessageForPic a;
  public PicMessageExtraData a;
  public CompressInfo a;
  public String a;
  public ArrayList<aunp> a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 1;
  public int f = this.e;
  
  public aunv()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(aunv paramaunv)
  {
    if (this.e < paramaunv.e) {
      return -1;
    }
    if (this.e > paramaunv.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(auon paramauon)
  {
    this.jdField_a_of_type_Auon = paramauon;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Auod != null) {
      this.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Aunn != null) {
      this.jdField_a_of_type_Aunn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList<aunp> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      aung.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      aunp localaunp = (aunp)localIterator.next();
      if (localaunp != null)
      {
        if (localaunp.jdField_a_of_type_Auod != null)
        {
          localaunp.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localaunp.jdField_a_of_type_Auod.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        if (localaunp.jdField_a_of_type_Aunn != null)
        {
          localaunp.jdField_a_of_type_Aunn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localaunp.jdField_a_of_type_Aunn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = aung.a(((aunp)paramArrayList.get(0)).jdField_a_of_type_Auod.jdField_b_of_type_Int, 2, 1);
  }
  
  public boolean a(aunp paramaunp)
  {
    if (paramaunp == null)
    {
      aung.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramaunp.jdField_a_of_type_Auod != null)
    {
      paramaunp.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaunp.jdField_a_of_type_Auod.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (paramaunp.jdField_a_of_type_Aunn != null)
    {
      paramaunp.jdField_a_of_type_Aunn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaunp.jdField_a_of_type_Aunn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Aunp = paramaunp;
    int i = -1;
    if (paramaunp.jdField_a_of_type_Auod != null) {
      i = paramaunp.jdField_a_of_type_Auod.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = aung.a(i, 2, 1);
    return true;
  }
  
  public boolean a(auod paramauod)
  {
    if (paramauod == null)
    {
      aung.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramauod.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramauod.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Auod = paramauod;
    this.jdField_b_of_type_JavaLangString = aung.a(this.jdField_a_of_type_Auod.jdField_b_of_type_Int, 1, 1);
    return true;
  }
  
  public boolean a(MessageForPic paramMessageForPic, aunn paramaunn)
  {
    if (paramaunn == null)
    {
      aung.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramaunn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramaunn.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramaunn.c = paramMessageForPic.time;
    paramaunn.d = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_Aunn = paramaunn;
    int i;
    if (this.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_Aunn.e = "chatthumb";
      i = 65537;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = aung.a(this.jdField_a_of_type_Aunn.jdField_b_of_type_Int, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
      return true;
      if (this.jdField_a_of_type_Int == 7)
      {
        i = 131075;
        this.jdField_a_of_type_Aunn.e = "chatraw";
      }
      else
      {
        if (this.jdField_a_of_type_Int == 6) {
          this.jdField_a_of_type_Aunn.e = "chatimg";
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
 * Qualified Name:     aunv
 * JD-Core Version:    0.7.0.1
 */