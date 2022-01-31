class bdvj
  extends bdvm
{
  bdvj(bdvi parambdvi) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      bdvi.a(this.a);
      return;
    }
    bdvi.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bdvj
 * JD-Core Version:    0.7.0.1
 */