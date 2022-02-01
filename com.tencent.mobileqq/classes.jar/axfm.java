import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;

class axfm
  implements axfv<Pair<String, Integer>, EmoticonPackage>
{
  axfm(axfj paramaxfj) {}
  
  public EmoticonPackage a(Pair<String, Integer> paramPair)
  {
    return this.a.c((String)paramPair.first, ((Integer)paramPair.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfm
 * JD-Core Version:    0.7.0.1
 */