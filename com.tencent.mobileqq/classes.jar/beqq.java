class beqq
  implements beqo
{
  beqq(beqp parambeqp) {}
  
  public void a(int paramInt, String paramString, beqm parambeqm)
  {
    if ((paramInt == 0) && (parambeqm != null))
    {
      if (this.a.isRuntimeLoaderValid(parambeqm)) {
        this.a.onRuntimeReady();
      }
      return;
    }
    this.a.onRuntimeFail(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqq
 * JD-Core Version:    0.7.0.1
 */