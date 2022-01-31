class bepz
  implements bepx
{
  bepz(bepy parambepy) {}
  
  public void a(int paramInt, String paramString, bepv parambepv)
  {
    if ((paramInt == 0) && (parambepv != null))
    {
      if (this.a.isRuntimeLoaderValid(parambepv)) {
        this.a.onRuntimeReady();
      }
      return;
    }
    this.a.onRuntimeFail(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepz
 * JD-Core Version:    0.7.0.1
 */