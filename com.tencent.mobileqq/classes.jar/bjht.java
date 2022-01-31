import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface bjht
{
  public abstract void attachQQContext(Activity paramActivity, QQAppInterface paramQQAppInterface);
  
  public abstract void clearCache();
  
  public abstract void forceRefresh();
  
  public abstract void onSwitchOutofQzone();
  
  public abstract void resetReportFlag();
  
  public abstract void setQzoneSwitchlistener(aiet paramaiet);
  
  public abstract void setRightButtonType(int paramInt);
  
  public abstract int setTitleAlphaAndGetLastValue(int paramInt);
  
  public abstract void setTitleView(ViewGroup paramViewGroup);
  
  public abstract void updatePublishBox(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjht
 * JD-Core Version:    0.7.0.1
 */