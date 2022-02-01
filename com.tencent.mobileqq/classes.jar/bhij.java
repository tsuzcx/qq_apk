import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.MedalList.Info;
import java.util.ArrayList;

public class bhij
{
  private MedalList a;
  
  public int a()
  {
    if (this.a != null) {
      return this.a.infoList.size();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    if ((this.a != null) && (this.a.infoList.size() > paramInt)) {
      return ((MedalList.Info)this.a.infoList.get(paramInt)).type;
    }
    return 0;
  }
  
  public String a(int paramInt)
  {
    if ((this.a != null) && (this.a.infoList.size() > paramInt)) {
      return ((MedalList.Info)this.a.infoList.get(paramInt)).value;
    }
    return null;
  }
  
  public void a(MedalList paramMedalList)
  {
    this.a = paramMedalList;
  }
  
  public int b(int paramInt)
  {
    if ((this.a != null) && (this.a.infoList.size() > paramInt)) {
      return ((MedalList.Info)this.a.infoList.get(paramInt)).isRemind;
    }
    return 0;
  }
  
  public int c(int paramInt)
  {
    if ((this.a != null) && (this.a.infoList.size() > paramInt)) {
      return ((MedalList.Info)this.a.infoList.get(paramInt)).tipsTimes;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhij
 * JD-Core Version:    0.7.0.1
 */