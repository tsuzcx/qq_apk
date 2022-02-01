import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import java.util.Comparator;

class anyy
  implements Comparator<SpecialCareInfo>
{
  anyy(anyw paramanyw) {}
  
  private String a(SpecialCareInfo paramSpecialCareInfo)
  {
    Friends localFriends = this.a.b(paramSpecialCareInfo.uin);
    if (localFriends == null) {
      return paramSpecialCareInfo.uin;
    }
    return bhlg.a(localFriends) + localFriends.uin;
  }
  
  public int a(SpecialCareInfo paramSpecialCareInfo1, SpecialCareInfo paramSpecialCareInfo2)
  {
    return anvp.a(a(paramSpecialCareInfo1), a(paramSpecialCareInfo2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyy
 * JD-Core Version:    0.7.0.1
 */