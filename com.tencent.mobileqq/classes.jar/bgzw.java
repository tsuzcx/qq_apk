import org.json.JSONObject;

public abstract interface bgzw
  extends bguj
{
  public abstract long getDetect302Time();
  
  public abstract boolean getIsReloadUrl();
  
  public abstract long getOpenUrlAfterCheckOfflineTime();
  
  public abstract long getReadIndexFromOfflineTime();
  
  public abstract JSONObject getX5Performance();
  
  public abstract long getgetWebViewTime();
  
  public abstract long getinitBrowserTime();
  
  public abstract long getinitTBSTime();
  
  public abstract long getinitTime();
  
  public abstract boolean getisWebViewCache();
  
  public abstract long getmClickTime();
  
  public abstract long getmOnCreateMilliTimeStamp();
  
  public abstract boolean getmPerfFirstLoadTag();
  
  public abstract long getmStartLoadUrlMilliTimeStamp();
  
  public abstract long getmTimeBeforeLoadUrl();
  
  public abstract long getonCreateTime();
  
  public abstract long getpluginFinished();
  
  public abstract long getviewInflateTime();
  
  public abstract boolean isMainPageUseLocalFile();
  
  public abstract void setX5Performance(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzw
 * JD-Core Version:    0.7.0.1
 */