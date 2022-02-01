import android.util.Log;

class bpda
  implements bpdh
{
  bpda(bpcz parambpcz) {}
  
  public void a(int paramInt)
  {
    Log.d("ModuleController", "onScrolling() top => " + paramInt);
    this.a.d(paramInt);
  }
  
  public void b(int paramInt)
  {
    Log.d("ModuleController", "onScrollStop -> top:" + paramInt);
    this.a.c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpda
 * JD-Core Version:    0.7.0.1
 */