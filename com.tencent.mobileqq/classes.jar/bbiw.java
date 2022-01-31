import java.util.ArrayList;

public class bbiw
{
  public static bbje a(int paramInt, ArrayList<bbje> paramArrayList)
  {
    bbje localbbje = bbje.a(paramInt);
    paramArrayList.add(localbbje);
    return localbbje;
  }
  
  public static bbje a(int paramInt1, ArrayList<bbje> paramArrayList, String paramString, int paramInt2)
  {
    bbje localbbje = a(paramInt1, paramArrayList);
    paramArrayList = paramString;
    if (paramString == null) {
      paramArrayList = "";
    }
    localbbje.b = paramArrayList;
    localbbje.e = paramInt2;
    return localbbje;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbiw
 * JD-Core Version:    0.7.0.1
 */