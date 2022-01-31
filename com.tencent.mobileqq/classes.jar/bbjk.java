import java.util.ArrayList;

public class bbjk
{
  public static bbjs a(int paramInt, ArrayList<bbjs> paramArrayList)
  {
    bbjs localbbjs = bbjs.a(paramInt);
    paramArrayList.add(localbbjs);
    return localbbjs;
  }
  
  public static bbjs a(int paramInt1, ArrayList<bbjs> paramArrayList, String paramString, int paramInt2)
  {
    bbjs localbbjs = a(paramInt1, paramArrayList);
    paramArrayList = paramString;
    if (paramString == null) {
      paramArrayList = "";
    }
    localbbjs.b = paramArrayList;
    localbbjs.e = paramInt2;
    return localbbjs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjk
 * JD-Core Version:    0.7.0.1
 */