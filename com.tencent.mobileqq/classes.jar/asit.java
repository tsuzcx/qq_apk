import com.tencent.mobileqq.data.EmoticonPackage;

public abstract interface asit
{
  public abstract void onPackageAdded(EmoticonPackage paramEmoticonPackage);
  
  public abstract void onPackageDeleted(EmoticonPackage paramEmoticonPackage);
  
  public abstract void onPackageMoved(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asit
 * JD-Core Version:    0.7.0.1
 */