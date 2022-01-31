class bgqk
  implements bgqi
{
  bgqk(bgqj parambgqj) {}
  
  public void a(int paramInt, String paramString, bgqg parambgqg)
  {
    if ((paramInt == 0) && (parambgqg != null))
    {
      if (this.a.isRuntimeLoaderValid(parambgqg)) {
        this.a.onRuntimeReady();
      }
      return;
    }
    this.a.onRuntimeFail(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqk
 * JD-Core Version:    0.7.0.1
 */