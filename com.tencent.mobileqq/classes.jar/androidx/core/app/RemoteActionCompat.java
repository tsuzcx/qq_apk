package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat
  implements VersionedParcelable
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public PendingIntent mActionIntent;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public CharSequence mContentDescription;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean mEnabled;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public IconCompat mIcon;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean mShouldShowIcon;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public CharSequence mTitle;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteActionCompat() {}
  
  public RemoteActionCompat(@NonNull RemoteActionCompat paramRemoteActionCompat)
  {
    Preconditions.checkNotNull(paramRemoteActionCompat);
    this.mIcon = paramRemoteActionCompat.mIcon;
    this.mTitle = paramRemoteActionCompat.mTitle;
    this.mContentDescription = paramRemoteActionCompat.mContentDescription;
    this.mActionIntent = paramRemoteActionCompat.mActionIntent;
    this.mEnabled = paramRemoteActionCompat.mEnabled;
    this.mShouldShowIcon = paramRemoteActionCompat.mShouldShowIcon;
  }
  
  public RemoteActionCompat(@NonNull IconCompat paramIconCompat, @NonNull CharSequence paramCharSequence1, @NonNull CharSequence paramCharSequence2, @NonNull PendingIntent paramPendingIntent)
  {
    this.mIcon = ((IconCompat)Preconditions.checkNotNull(paramIconCompat));
    this.mTitle = ((CharSequence)Preconditions.checkNotNull(paramCharSequence1));
    this.mContentDescription = ((CharSequence)Preconditions.checkNotNull(paramCharSequence2));
    this.mActionIntent = ((PendingIntent)Preconditions.checkNotNull(paramPendingIntent));
    this.mEnabled = true;
    this.mShouldShowIcon = true;
  }
  
  @NonNull
  @RequiresApi(26)
  public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction paramRemoteAction)
  {
    Preconditions.checkNotNull(paramRemoteAction);
    RemoteActionCompat localRemoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon(paramRemoteAction.getIcon()), paramRemoteAction.getTitle(), paramRemoteAction.getContentDescription(), paramRemoteAction.getActionIntent());
    localRemoteActionCompat.setEnabled(paramRemoteAction.isEnabled());
    if (Build.VERSION.SDK_INT >= 28) {
      localRemoteActionCompat.setShouldShowIcon(paramRemoteAction.shouldShowIcon());
    }
    return localRemoteActionCompat;
  }
  
  @NonNull
  public PendingIntent getActionIntent()
  {
    return this.mActionIntent;
  }
  
  @NonNull
  public CharSequence getContentDescription()
  {
    return this.mContentDescription;
  }
  
  @NonNull
  public IconCompat getIcon()
  {
    return this.mIcon;
  }
  
  @NonNull
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  public void setShouldShowIcon(boolean paramBoolean)
  {
    this.mShouldShowIcon = paramBoolean;
  }
  
  public boolean shouldShowIcon()
  {
    return this.mShouldShowIcon;
  }
  
  @NonNull
  @RequiresApi(26)
  public RemoteAction toRemoteAction()
  {
    RemoteAction localRemoteAction = new RemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
    localRemoteAction.setEnabled(isEnabled());
    if (Build.VERSION.SDK_INT >= 28) {
      localRemoteAction.setShouldShowIcon(shouldShowIcon());
    }
    return localRemoteAction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.RemoteActionCompat
 * JD-Core Version:    0.7.0.1
 */