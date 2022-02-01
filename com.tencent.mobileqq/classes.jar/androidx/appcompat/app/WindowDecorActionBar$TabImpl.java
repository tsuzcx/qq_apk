package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ScrollingTabContainerView;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar$TabImpl
  extends ActionBar.Tab
{
  private ActionBar.TabListener mCallback;
  private CharSequence mContentDesc;
  private View mCustomView;
  private Drawable mIcon;
  private int mPosition = -1;
  private Object mTag;
  private CharSequence mText;
  
  public WindowDecorActionBar$TabImpl(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public ActionBar.TabListener getCallback()
  {
    return this.mCallback;
  }
  
  public CharSequence getContentDescription()
  {
    return this.mContentDesc;
  }
  
  public View getCustomView()
  {
    return this.mCustomView;
  }
  
  public Drawable getIcon()
  {
    return this.mIcon;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public void select()
  {
    this.this$0.selectTab(this);
  }
  
  public ActionBar.Tab setContentDescription(int paramInt)
  {
    return setContentDescription(this.this$0.mContext.getResources().getText(paramInt));
  }
  
  public ActionBar.Tab setContentDescription(CharSequence paramCharSequence)
  {
    this.mContentDesc = paramCharSequence;
    if (this.mPosition >= 0) {
      this.this$0.mTabScrollView.updateTab(this.mPosition);
    }
    return this;
  }
  
  public ActionBar.Tab setCustomView(int paramInt)
  {
    return setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(paramInt, null));
  }
  
  public ActionBar.Tab setCustomView(View paramView)
  {
    this.mCustomView = paramView;
    if (this.mPosition >= 0) {
      this.this$0.mTabScrollView.updateTab(this.mPosition);
    }
    return this;
  }
  
  public ActionBar.Tab setIcon(int paramInt)
  {
    return setIcon(AppCompatResources.getDrawable(this.this$0.mContext, paramInt));
  }
  
  public ActionBar.Tab setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    if (this.mPosition >= 0) {
      this.this$0.mTabScrollView.updateTab(this.mPosition);
    }
    return this;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  public ActionBar.Tab setTabListener(ActionBar.TabListener paramTabListener)
  {
    this.mCallback = paramTabListener;
    return this;
  }
  
  public ActionBar.Tab setTag(Object paramObject)
  {
    this.mTag = paramObject;
    return this;
  }
  
  public ActionBar.Tab setText(int paramInt)
  {
    return setText(this.this$0.mContext.getResources().getText(paramInt));
  }
  
  public ActionBar.Tab setText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    if (this.mPosition >= 0) {
      this.this$0.mTabScrollView.updateTab(this.mPosition);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.WindowDecorActionBar.TabImpl
 * JD-Core Version:    0.7.0.1
 */