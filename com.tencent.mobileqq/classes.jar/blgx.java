import android.view.View;

public abstract interface blgx
{
  public abstract boolean isNeedRecreatePanel(int paramInt);
  
  public abstract View onCreatePanel(int paramInt);
  
  public abstract void onHideAllPanel();
  
  public abstract void onPanelChanged(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgx
 * JD-Core Version:    0.7.0.1
 */