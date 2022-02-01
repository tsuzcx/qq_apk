import java.util.ArrayList;

class apxs
  implements apxy
{
  apxs(apxp paramapxp) {}
  
  public void a(apyb paramapyb, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramapyb.b.size())
    {
      apxx localapxx = (apxx)paramapyb.b.get(i);
      if (localapxx != null) {
        localapxx.b(paramBoolean, paramapyb.a, paramArrayOfByte);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxs
 * JD-Core Version:    0.7.0.1
 */