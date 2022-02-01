package android.content.res;

import android.app.AndroidAppHelper;
import android.util.DisplayMetrics;

public class XModuleResources
  extends Resources
{
  private XModuleResources(AssetManager paramAssetManager, DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    super(paramAssetManager, paramDisplayMetrics, paramConfiguration);
  }
  
  public static XModuleResources createInstance(String paramString, XResources paramXResources)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("path must not be null");
    }
    AssetManager localAssetManager = new AssetManager();
    localAssetManager.addAssetPath(paramString);
    if (paramXResources != null) {}
    for (paramXResources = new XModuleResources(localAssetManager, paramXResources.getDisplayMetrics(), paramXResources.getConfiguration());; paramXResources = new XModuleResources(localAssetManager, null, null))
    {
      AndroidAppHelper.addActiveResource(paramString, paramXResources);
      return paramXResources;
    }
  }
  
  public XResForwarder fwd(int paramInt)
  {
    return new XResForwarder(this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XModuleResources
 * JD-Core Version:    0.7.0.1
 */