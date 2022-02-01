import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

public abstract class bmar
{
  private volatile boolean hasInflated;
  protected Activity mActivity;
  protected bmas mPartManager;
  protected View mRootView;
  private ViewStub stub;
  
  @Deprecated
  public bmar(Activity paramActivity, View paramView, bmas parambmas)
  {
    this.mActivity = paramActivity;
    this.mRootView = paramView;
    this.mPartManager = parambmas;
  }
  
  public bmar(Activity paramActivity, ViewStub paramViewStub, bmas parambmas)
  {
    this.stub = paramViewStub;
    this.mActivity = paramActivity;
    this.mPartManager = parambmas;
  }
  
  public final void ensureInflate()
  {
    if (this.hasInflated) {
      return;
    }
    View localView = this.stub.inflate();
    this.hasInflated = true;
    initAfterInflation(localView);
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return null;
  }
  
  public ViewStub getStub()
  {
    return this.stub;
  }
  
  public boolean hasInflated()
  {
    return this.hasInflated;
  }
  
  protected void initAfterInflation(View paramView) {}
  
  protected abstract void initView();
  
  public void onActivityPause() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume() {}
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void send(int paramInt, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmar
 * JD-Core Version:    0.7.0.1
 */