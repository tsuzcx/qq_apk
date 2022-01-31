class bfve
  extends bfvh
{
  bfve(bfvd parambfvd) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      bfvd.a(this.a);
      return;
    }
    bfvd.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfve
 * JD-Core Version:    0.7.0.1
 */