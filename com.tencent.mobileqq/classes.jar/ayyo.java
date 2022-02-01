public class ayyo
{
  public static aysw a(int paramInt, aysx paramaysx, aymg paramaymg)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1002: 
      return a(paramaysx, paramaymg);
    }
    return b(paramaysx, paramaymg);
  }
  
  private static aysw a(aysx paramaysx, aymg paramaymg)
  {
    ayyi localayyi = null;
    long l = paramaymg.a;
    if ((l == aymn.b) || (l == aymn.c) || (l == aymn.d)) {
      localayyi = new ayyi(paramaysx, paramaymg);
    }
    do
    {
      return localayyi;
      if (l == aymn.e) {
        return new ayyj(paramaysx, paramaymg);
      }
      if (l == aymn.f) {
        return new ayyl(paramaysx, paramaymg);
      }
      if (l == aymn.g) {
        return new ayyk(paramaysx, paramaymg);
      }
      if ((l == aymn.i) || (l == aymn.j)) {
        return new ayyn(paramaysx, paramaymg);
      }
      if (l == aymn.k) {
        return new ayym(paramaysx, paramaymg);
      }
    } while (!aymn.a(l));
    return new ayyh(paramaysx, paramaymg);
  }
  
  private static aysw b(aysx paramaysx, aymg paramaymg)
  {
    long l = paramaymg.a;
    if (aymn.a(l)) {
      return new ayxx(paramaysx, paramaymg);
    }
    if ((l == aymn.i) || (l == aymn.j)) {
      return new ayya(paramaysx, paramaymg);
    }
    if (l == aymn.g) {
      return new ayxy(paramaysx, paramaymg);
    }
    return new ayxu(paramaysx, paramaymg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyo
 * JD-Core Version:    0.7.0.1
 */