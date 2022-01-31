class bdus
  extends bduv
{
  bdus(bdur parambdur) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      bdur.a(this.a);
      return;
    }
    bdur.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bdus
 * JD-Core Version:    0.7.0.1
 */