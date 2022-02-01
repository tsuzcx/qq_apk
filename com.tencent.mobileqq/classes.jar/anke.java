import com.tencent.mobileqq.data.ApolloActionData;
import java.util.Comparator;

class anke
  implements Comparator<ApolloActionData>
{
  anke(ankc paramankc) {}
  
  public int a(ApolloActionData paramApolloActionData1, ApolloActionData paramApolloActionData2)
  {
    if (paramApolloActionData2.limitStart == paramApolloActionData1.limitStart) {
      return 0;
    }
    if (paramApolloActionData2.limitStart > paramApolloActionData1.limitStart) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anke
 * JD-Core Version:    0.7.0.1
 */