package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortcutInfoCompat$Builder
{
  private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();
  
  @RequiresApi(25)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ShortcutInfoCompat$Builder(@NonNull Context paramContext, @NonNull ShortcutInfo paramShortcutInfo)
  {
    this.mInfo.mContext = paramContext;
    this.mInfo.mId = paramShortcutInfo.getId();
    paramContext = paramShortcutInfo.getIntents();
    this.mInfo.mIntents = ((Intent[])Arrays.copyOf(paramContext, paramContext.length));
    this.mInfo.mActivity = paramShortcutInfo.getActivity();
    this.mInfo.mLabel = paramShortcutInfo.getShortLabel();
    this.mInfo.mLongLabel = paramShortcutInfo.getLongLabel();
    this.mInfo.mDisabledMessage = paramShortcutInfo.getDisabledMessage();
    this.mInfo.mCategories = paramShortcutInfo.getCategories();
    this.mInfo.mPersons = ShortcutInfoCompat.getPersonsFromExtra(paramShortcutInfo.getExtras());
    this.mInfo.mRank = paramShortcutInfo.getRank();
  }
  
  public ShortcutInfoCompat$Builder(@NonNull Context paramContext, @NonNull String paramString)
  {
    this.mInfo.mContext = paramContext;
    this.mInfo.mId = paramString;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ShortcutInfoCompat$Builder(@NonNull ShortcutInfoCompat paramShortcutInfoCompat)
  {
    this.mInfo.mContext = paramShortcutInfoCompat.mContext;
    this.mInfo.mId = paramShortcutInfoCompat.mId;
    this.mInfo.mIntents = ((Intent[])Arrays.copyOf(paramShortcutInfoCompat.mIntents, paramShortcutInfoCompat.mIntents.length));
    this.mInfo.mActivity = paramShortcutInfoCompat.mActivity;
    this.mInfo.mLabel = paramShortcutInfoCompat.mLabel;
    this.mInfo.mLongLabel = paramShortcutInfoCompat.mLongLabel;
    this.mInfo.mDisabledMessage = paramShortcutInfoCompat.mDisabledMessage;
    this.mInfo.mIcon = paramShortcutInfoCompat.mIcon;
    this.mInfo.mIsAlwaysBadged = paramShortcutInfoCompat.mIsAlwaysBadged;
    this.mInfo.mIsLongLived = paramShortcutInfoCompat.mIsLongLived;
    this.mInfo.mRank = paramShortcutInfoCompat.mRank;
    if (paramShortcutInfoCompat.mPersons != null) {
      this.mInfo.mPersons = ((Person[])Arrays.copyOf(paramShortcutInfoCompat.mPersons, paramShortcutInfoCompat.mPersons.length));
    }
    if (paramShortcutInfoCompat.mCategories != null) {
      this.mInfo.mCategories = new HashSet(paramShortcutInfoCompat.mCategories);
    }
  }
  
  @NonNull
  public ShortcutInfoCompat build()
  {
    if (TextUtils.isEmpty(this.mInfo.mLabel)) {
      throw new IllegalArgumentException("Shortcut must have a non-empty label");
    }
    if ((this.mInfo.mIntents == null) || (this.mInfo.mIntents.length == 0)) {
      throw new IllegalArgumentException("Shortcut must have an intent");
    }
    return this.mInfo;
  }
  
  @NonNull
  public Builder setActivity(@NonNull ComponentName paramComponentName)
  {
    this.mInfo.mActivity = paramComponentName;
    return this;
  }
  
  @NonNull
  public Builder setAlwaysBadged()
  {
    this.mInfo.mIsAlwaysBadged = true;
    return this;
  }
  
  @NonNull
  public Builder setCategories(@NonNull Set<String> paramSet)
  {
    this.mInfo.mCategories = paramSet;
    return this;
  }
  
  @NonNull
  public Builder setDisabledMessage(@NonNull CharSequence paramCharSequence)
  {
    this.mInfo.mDisabledMessage = paramCharSequence;
    return this;
  }
  
  @NonNull
  public Builder setIcon(IconCompat paramIconCompat)
  {
    this.mInfo.mIcon = paramIconCompat;
    return this;
  }
  
  @NonNull
  public Builder setIntent(@NonNull Intent paramIntent)
  {
    return setIntents(new Intent[] { paramIntent });
  }
  
  @NonNull
  public Builder setIntents(@NonNull Intent[] paramArrayOfIntent)
  {
    this.mInfo.mIntents = paramArrayOfIntent;
    return this;
  }
  
  @NonNull
  public Builder setLongLabel(@NonNull CharSequence paramCharSequence)
  {
    this.mInfo.mLongLabel = paramCharSequence;
    return this;
  }
  
  @Deprecated
  @NonNull
  public Builder setLongLived()
  {
    this.mInfo.mIsLongLived = true;
    return this;
  }
  
  @NonNull
  public Builder setLongLived(boolean paramBoolean)
  {
    this.mInfo.mIsLongLived = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setPerson(@NonNull Person paramPerson)
  {
    return setPersons(new Person[] { paramPerson });
  }
  
  @NonNull
  public Builder setPersons(@NonNull Person[] paramArrayOfPerson)
  {
    this.mInfo.mPersons = paramArrayOfPerson;
    return this;
  }
  
  @NonNull
  public Builder setRank(int paramInt)
  {
    this.mInfo.mRank = paramInt;
    return this;
  }
  
  @NonNull
  public Builder setShortLabel(@NonNull CharSequence paramCharSequence)
  {
    this.mInfo.mLabel = paramCharSequence;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.content.pm.ShortcutInfoCompat.Builder
 * JD-Core Version:    0.7.0.1
 */