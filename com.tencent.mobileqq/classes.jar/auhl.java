import com.tencent.mobileqq.data.SubAccountInfo;
import java.util.Comparator;

class auhl
  implements Comparator<SubAccountInfo>
{
  auhl(auhk paramauhk, akpb paramakpb) {}
  
  public int a(SubAccountInfo paramSubAccountInfo1, SubAccountInfo paramSubAccountInfo2)
  {
    int i = this.jdField_a_of_type_Akpb.a(paramSubAccountInfo1.subuin, 7000);
    int j = this.jdField_a_of_type_Akpb.a(paramSubAccountInfo2.subuin, 7000);
    if ((i > 0) && (j == 0)) {}
    do
    {
      return 1;
      if ((i == 0) && (j > 0)) {
        return -1;
      }
    } while (paramSubAccountInfo1.lasttime > paramSubAccountInfo2.lasttime);
    if (paramSubAccountInfo1.lasttime < paramSubAccountInfo2.lasttime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhl
 * JD-Core Version:    0.7.0.1
 */