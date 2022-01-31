import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;
import com.tencent.mobileqq.ark.ArkAppCenter;

final class anms
  implements ArkEnvironmentManager.LibraryLoader
{
  public boolean Load()
  {
    ArkAppCenter.f();
    return ArkAppCenter.b;
  }
  
  public boolean isLibraryLoad()
  {
    return ArkAppCenter.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anms
 * JD-Core Version:    0.7.0.1
 */