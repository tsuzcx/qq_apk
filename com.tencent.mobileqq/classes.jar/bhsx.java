import com.tencent.biz.pubaccount.CustomWebView;

public abstract interface bhsx
  extends bhni
{
  public abstract String getCurrentUrl();
  
  public abstract CustomWebView getWebView();
  
  public abstract void hideQQBrowserButton();
  
  public abstract boolean isActivityResume();
  
  public abstract void setBottomBarVisible(boolean paramBoolean);
  
  public abstract void showActionSheet();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsx
 * JD-Core Version:    0.7.0.1
 */