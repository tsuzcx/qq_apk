import android.view.View;
import android.view.View.OnClickListener;
import org.json.JSONObject;

public abstract interface bhsw
  extends bhni
{
  public abstract void doTransparent(JSONObject paramJSONObject);
  
  public abstract long getRulesFromUrl();
  
  public abstract int getTitleBarAlpa();
  
  public abstract int getTitleBarHeight();
  
  public abstract View getTitleBarView();
  
  public abstract void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, adea paramadea);
  
  public abstract void setWarnToastVisible(boolean paramBoolean, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsw
 * JD-Core Version:    0.7.0.1
 */