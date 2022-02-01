import java.util.ArrayList;

class apnl
  implements apnr
{
  apnl(apni paramapni) {}
  
  public void a(apnu paramapnu, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramapnu.b.size())
    {
      apnq localapnq = (apnq)paramapnu.b.get(i);
      if (localapnq != null) {
        localapnq.b(paramBoolean, paramapnu.a, paramArrayOfByte);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnl
 * JD-Core Version:    0.7.0.1
 */