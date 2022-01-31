class bmdg
  implements bmdi
{
  private final bmdf a;
  
  bmdg(bmdf parambmdf)
  {
    this.a = parambmdf;
  }
  
  public void a(bmdn parambmdn, bmdk parambmdk)
  {
    switch (parambmdk.a)
    {
    default: 
      return;
    case 0: 
      this.a.a(parambmdn);
      return;
    case 1: 
      this.a.b(parambmdn);
      return;
    case 2: 
      this.a.c(parambmdn);
      return;
    case 3: 
      this.a.d(parambmdn);
      return;
    case 4: 
      this.a.e(parambmdn);
      return;
    case 5: 
      this.a.f(parambmdn);
      return;
    }
    throw new IllegalArgumentException("ON_ANY must not been send by anybody");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdg
 * JD-Core Version:    0.7.0.1
 */