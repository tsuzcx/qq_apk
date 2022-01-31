import android.util.Log;

class atcc
  implements atbm
{
  atcc(atca paramatca) {}
  
  public void a(int paramInt, String paramString)
  {
    Log.i("Huiyin", "code " + paramInt + ", filename " + paramString);
    if (paramInt == 0)
    {
      atca.a(this.a, paramString);
      atca.a(this.a, 1);
      Log.i("Huiyin", "file created " + atca.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcc
 * JD-Core Version:    0.7.0.1
 */