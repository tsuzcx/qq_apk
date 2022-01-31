class atni
  implements atne
{
  atni(atnf paramatnf) {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      atnf.b(this.a);
      return;
    case 1: 
      atnf.c(this.a);
      return;
    case 2: 
      atnf.a(this.a);
      return;
    case 3: 
      atnf.d(this.a);
      return;
    }
    atnf.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atni
 * JD-Core Version:    0.7.0.1
 */