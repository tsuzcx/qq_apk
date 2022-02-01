import java.util.ArrayList;

class aqbb
  implements aqbh
{
  aqbb(aqay paramaqay) {}
  
  public void a(aqbk paramaqbk, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramaqbk.b.size())
    {
      aqbg localaqbg = (aqbg)paramaqbk.b.get(i);
      if (localaqbg != null) {
        localaqbg.b(paramBoolean, paramaqbk.a, paramArrayOfByte);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbb
 * JD-Core Version:    0.7.0.1
 */