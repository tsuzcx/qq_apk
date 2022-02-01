import android.os.Bundle;

public class aqyv
{
  public int a;
  public String a;
  public int b;
  public int c = -1;
  public int d = -1;
  public int e = -1;
  
  public aqyv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static aqyv a(Bundle paramBundle)
  {
    int j = 0;
    int n = -1;
    String str = "";
    int i;
    int k;
    int m;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("result", -1);
      j = paramBundle.getInt("realSaveNum", 0);
      k = paramBundle.getInt("payChannel", -1);
      m = paramBundle.getInt("payState", -1);
      n = paramBundle.getInt("provideState", -1);
    }
    for (paramBundle = paramBundle.getString("message");; paramBundle = str)
    {
      return new aqyv(i, j, k, m, n, paramBundle);
      m = -1;
      k = -1;
      i = -1;
    }
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", this.jdField_a_of_type_Int);
    localBundle.putInt("realSaveNum", this.b);
    localBundle.putInt("payChannel", this.c);
    localBundle.putInt("payState", this.d);
    localBundle.putInt("provideState", this.e);
    localBundle.putString("message", this.jdField_a_of_type_JavaLangString);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyv
 * JD-Core Version:    0.7.0.1
 */