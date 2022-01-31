import com.tencent.mobileqq.data.CardProfile;
import java.util.Comparator;

public class anig
  implements Comparator<CardProfile>
{
  public int a(CardProfile paramCardProfile1, CardProfile paramCardProfile2)
  {
    return paramCardProfile2.lTime - paramCardProfile1.lTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anig
 * JD-Core Version:    0.7.0.1
 */