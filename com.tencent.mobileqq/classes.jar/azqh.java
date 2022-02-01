public class azqh
{
  public static azlv a(int paramInt, azlw paramazlw, azfe paramazfe)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1002: 
      return a(paramazlw, paramazfe);
    }
    return b(paramazlw, paramazfe);
  }
  
  private static azlv a(azlw paramazlw, azfe paramazfe)
  {
    azqb localazqb = null;
    long l = paramazfe.a;
    if ((l == azfl.b) || (l == azfl.c) || (l == azfl.d)) {
      localazqb = new azqb(paramazlw, paramazfe);
    }
    do
    {
      return localazqb;
      if (l == azfl.e) {
        return new azqc(paramazlw, paramazfe);
      }
      if (l == azfl.f) {
        return new azqe(paramazlw, paramazfe);
      }
      if (l == azfl.g) {
        return new azqd(paramazlw, paramazfe);
      }
      if ((l == azfl.i) || (l == azfl.j)) {
        return new azqg(paramazlw, paramazfe);
      }
      if (l == azfl.k) {
        return new azqf(paramazlw, paramazfe);
      }
    } while (!azfl.a(l));
    return new azqa(paramazlw, paramazfe);
  }
  
  private static azlv b(azlw paramazlw, azfe paramazfe)
  {
    long l = paramazfe.a;
    if (azfl.a(l)) {
      return new azpq(paramazlw, paramazfe);
    }
    if ((l == azfl.i) || (l == azfl.j)) {
      return new azpt(paramazlw, paramazfe);
    }
    if (l == azfl.g) {
      return new azpr(paramazlw, paramazfe);
    }
    return new azpn(paramazlw, paramazfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqh
 * JD-Core Version:    0.7.0.1
 */