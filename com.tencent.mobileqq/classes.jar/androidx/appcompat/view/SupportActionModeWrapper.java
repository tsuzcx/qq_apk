package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.core.internal.view.SupportMenu;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportActionModeWrapper
  extends android.view.ActionMode
{
  final Context mContext;
  final ActionMode mWrappedObject;
  
  public SupportActionModeWrapper(Context paramContext, ActionMode paramActionMode)
  {
    this.mContext = paramContext;
    this.mWrappedObject = paramActionMode;
  }
  
  public void finish()
  {
    this.mWrappedObject.finish();
  }
  
  public View getCustomView()
  {
    return this.mWrappedObject.getCustomView();
  }
  
  public Menu getMenu()
  {
    return new MenuWrapperICS(this.mContext, (SupportMenu)this.mWrappedObject.getMenu());
  }
  
  public MenuInflater getMenuInflater()
  {
    return this.mWrappedObject.getMenuInflater();
  }
  
  public CharSequence getSubtitle()
  {
    return this.mWrappedObject.getSubtitle();
  }
  
  public Object getTag()
  {
    return this.mWrappedObject.getTag();
  }
  
  public CharSequence getTitle()
  {
    return this.mWrappedObject.getTitle();
  }
  
  public boolean getTitleOptionalHint()
  {
    return this.mWrappedObject.getTitleOptionalHint();
  }
  
  public void invalidate()
  {
    this.mWrappedObject.invalidate();
  }
  
  public boolean isTitleOptional()
  {
    return this.mWrappedObject.isTitleOptional();
  }
  
  public void setCustomView(View paramView)
  {
    this.mWrappedObject.setCustomView(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    this.mWrappedObject.setSubtitle(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setSubtitle(paramCharSequence);
  }
  
  public void setTag(Object paramObject)
  {
    this.mWrappedObject.setTag(paramObject);
  }
  
  public void setTitle(int paramInt)
  {
    this.mWrappedObject.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mWrappedObject.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    this.mWrappedObject.setTitleOptionalHint(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.SupportActionModeWrapper
 * JD-Core Version:    0.7.0.1
 */