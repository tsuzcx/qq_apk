class binc
  extends binf
{
  binc(binb parambinb) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      binb.a(this.a);
      return;
    }
    binb.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     binc
 * JD-Core Version:    0.7.0.1
 */