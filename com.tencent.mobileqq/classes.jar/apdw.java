import com.tencent.mobileqq.data.CardProfile;
import java.util.Comparator;

public class apdw
  implements Comparator<CardProfile>
{
  public int a(CardProfile paramCardProfile1, CardProfile paramCardProfile2)
  {
    return paramCardProfile2.lTime - paramCardProfile1.lTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdw
 * JD-Core Version:    0.7.0.1
 */