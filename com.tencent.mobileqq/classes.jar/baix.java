public class baix
{
  public static baeh a(int paramInt, baei parambaei, azxr paramazxr)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1002: 
      return a(parambaei, paramazxr);
    }
    return b(parambaei, paramazxr);
  }
  
  private static baeh a(baei parambaei, azxr paramazxr)
  {
    bair localbair = null;
    long l = paramazxr.a;
    if ((l == azxy.b) || (l == azxy.c) || (l == azxy.d)) {
      localbair = new bair(parambaei, paramazxr);
    }
    do
    {
      return localbair;
      if (l == azxy.e) {
        return new bais(parambaei, paramazxr);
      }
      if (l == azxy.f) {
        return new baiu(parambaei, paramazxr);
      }
      if (l == azxy.g) {
        return new bait(parambaei, paramazxr);
      }
      if ((l == azxy.i) || (l == azxy.j)) {
        return new baiw(parambaei, paramazxr);
      }
      if (l == azxy.k) {
        return new baiv(parambaei, paramazxr);
      }
    } while (!azxy.a(l));
    return new baiq(parambaei, paramazxr);
  }
  
  private static baeh b(baei parambaei, azxr paramazxr)
  {
    long l = paramazxr.a;
    if (azxy.a(l)) {
      return new baig(parambaei, paramazxr);
    }
    if ((l == azxy.i) || (l == azxy.j)) {
      return new baij(parambaei, paramazxr);
    }
    if (l == azxy.g) {
      return new baih(parambaei, paramazxr);
    }
    return new baid(parambaei, paramazxr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baix
 * JD-Core Version:    0.7.0.1
 */