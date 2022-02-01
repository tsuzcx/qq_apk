class bplo
  implements bprh
{
  bplo(bplj parambplj) {}
  
  public void aV_()
  {
    bplj.a(this.a).d();
  }
  
  public void b()
  {
    bplj.a(this.a).d();
    bplj.a(this.a).a();
    bplj.a(this.a).a(bplj.a(this.a));
  }
  
  public void c()
  {
    bplj.a(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bplo
 * JD-Core Version:    0.7.0.1
 */