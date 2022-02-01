import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class ayds
  implements Comparable<ayds>
{
  public int a;
  public ahav a;
  public aydl a;
  public aydn a;
  public ayeb a;
  public ayel a;
  public MessageForPic a;
  public PicMessageExtraData a;
  public CompressInfo a;
  public String a;
  public ArrayList<aydn> a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e = 1;
  public int f = this.e;
  
  public ayds()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public int a(ayds paramayds)
  {
    if (this.e < paramayds.e) {
      return -1;
    }
    if (this.e > paramayds.e) {
      return 1;
    }
    return 0;
  }
  
  public void a(ayel paramayel)
  {
    this.jdField_a_of_type_Ayel = paramayel;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Ayeb != null) {
      this.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Aydl != null) {
      this.jdField_a_of_type_Aydl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(ArrayList<aydn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ayde.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "fwInfoList is empty");
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      aydn localaydn = (aydn)localIterator.next();
      if (localaydn != null)
      {
        if (localaydn.jdField_a_of_type_Ayeb != null)
        {
          localaydn.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localaydn.jdField_a_of_type_Ayeb.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
        if (localaydn.jdField_a_of_type_Aydl != null)
        {
          localaydn.jdField_a_of_type_Aydl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          localaydn.jdField_a_of_type_Aydl.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaLangString = ayde.a(((aydn)paramArrayList.get(0)).jdField_a_of_type_Ayeb.jdField_b_of_type_Int, 2, 1);
  }
  
  public boolean a(aydn paramaydn)
  {
    if (paramaydn == null)
    {
      ayde.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "forwardInfo == null");
      return false;
    }
    if (paramaydn.jdField_a_of_type_Ayeb != null)
    {
      paramaydn.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaydn.jdField_a_of_type_Ayeb.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (paramaydn.jdField_a_of_type_Aydl != null)
    {
      paramaydn.jdField_a_of_type_Aydl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramaydn.jdField_a_of_type_Aydl.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Aydn = paramaydn;
    int i = -1;
    if (paramaydn.jdField_a_of_type_Ayeb != null) {
      i = paramaydn.jdField_a_of_type_Ayeb.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_JavaLangString = ayde.a(i, 2, 1);
    return true;
  }
  
  public boolean a(ayeb paramayeb)
  {
    if (paramayeb == null)
    {
      ayde.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "upInfo == null");
      return false;
    }
    paramayeb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramayeb.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ayeb = paramayeb;
    this.jdField_b_of_type_JavaLangString = ayde.a(this.jdField_a_of_type_Ayeb.jdField_b_of_type_Int, 1, 1);
    return true;
  }
  
  public boolean a(MessageForPic paramMessageForPic, aydl paramaydl)
  {
    if (paramaydl == null)
    {
      ayde.a("PIC_TAG_ERROR", this.jdField_a_of_type_JavaLangString, "bindReqObj", "downInfo == null");
      return false;
    }
    paramaydl.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramaydl.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramaydl.c = paramMessageForPic.time;
    paramaydl.d = paramMessageForPic.bEnableEnc;
    this.jdField_a_of_type_Aydl = paramaydl;
    int i;
    if (this.jdField_a_of_type_Int == 5)
    {
      this.jdField_a_of_type_Aydl.e = "chatthumb";
      i = 65537;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = ayde.a(this.jdField_a_of_type_Aydl.jdField_b_of_type_Int, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
      return true;
      if (this.jdField_a_of_type_Int == 7)
      {
        i = 131075;
        this.jdField_a_of_type_Aydl.e = "chatraw";
      }
      else
      {
        if (this.jdField_a_of_type_Int == 6) {
          this.jdField_a_of_type_Aydl.e = "chatimg";
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
 * Qualified Name:     ayds
 * JD-Core Version:    0.7.0.1
 */