import java.util.ArrayList;

class annf
  implements annl
{
  annf(annc paramannc) {}
  
  public void a(anno paramanno, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramanno.b.size())
    {
      annk localannk = (annk)paramanno.b.get(i);
      if (localannk != null) {
        localannk.b(paramBoolean, paramanno.a, paramArrayOfByte);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annf
 * JD-Core Version:    0.7.0.1
 */