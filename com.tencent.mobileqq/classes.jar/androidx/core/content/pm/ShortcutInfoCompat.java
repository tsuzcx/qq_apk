package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.Set;

public class ShortcutInfoCompat
{
  private static final String EXTRA_LONG_LIVED = "extraLongLived";
  private static final String EXTRA_PERSON_ = "extraPerson_";
  private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
  ComponentName mActivity;
  Set<String> mCategories;
  Context mContext;
  CharSequence mDisabledMessage;
  IconCompat mIcon;
  String mId;
  Intent[] mIntents;
  boolean mIsAlwaysBadged;
  boolean mIsLongLived;
  CharSequence mLabel;
  CharSequence mLongLabel;
  androidx.core.app.Person[] mPersons;
  int mRank;
  
  @RequiresApi(22)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  private PersistableBundle buildLegacyExtrasBundle()
  {
    PersistableBundle localPersistableBundle = new PersistableBundle();
    Object localObject = this.mPersons;
    if ((localObject != null) && (localObject.length > 0))
    {
      localPersistableBundle.putInt("extraPersonCount", localObject.length);
      int j;
      for (int i = 0; i < this.mPersons.length; i = j)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("extraPerson_");
        j = i + 1;
        ((StringBuilder)localObject).append(j);
        localPersistableBundle.putPersistableBundle(((StringBuilder)localObject).toString(), this.mPersons[i].toPersistableBundle());
      }
    }
    localPersistableBundle.putBoolean("extraLongLived", this.mIsLongLived);
    return localPersistableBundle;
  }
  
  @RequiresApi(25)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static boolean getLongLivedFromExtra(@NonNull PersistableBundle paramPersistableBundle)
  {
    if ((paramPersistableBundle != null) && (paramPersistableBundle.containsKey("extraLongLived"))) {
      return paramPersistableBundle.getBoolean("extraLongLived");
    }
    return false;
  }
  
  @Nullable
  @RequiresApi(25)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static androidx.core.app.Person[] getPersonsFromExtra(@NonNull PersistableBundle paramPersistableBundle)
  {
    if ((paramPersistableBundle != null) && (paramPersistableBundle.containsKey("extraPersonCount")))
    {
      int k = paramPersistableBundle.getInt("extraPersonCount");
      androidx.core.app.Person[] arrayOfPerson = new androidx.core.app.Person[k];
      int j;
      for (int i = 0; i < k; i = j)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("extraPerson_");
        j = i + 1;
        localStringBuilder.append(j);
        arrayOfPerson[i] = androidx.core.app.Person.fromPersistableBundle(paramPersistableBundle.getPersistableBundle(localStringBuilder.toString()));
      }
      return arrayOfPerson;
    }
    return null;
  }
  
  Intent addToIntent(Intent paramIntent)
  {
    Object localObject1 = this.mIntents;
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", localObject1[(localObject1.length - 1)]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
    Object localObject3;
    Object localObject4;
    PackageManager localPackageManager;
    if (this.mIcon != null)
    {
      localObject3 = null;
      localObject4 = null;
      if (this.mIsAlwaysBadged)
      {
        localPackageManager = this.mContext.getPackageManager();
        localObject3 = this.mActivity;
        localObject1 = localObject4;
        if (localObject3 == null) {}
      }
    }
    try
    {
      localObject1 = localPackageManager.getActivityIcon((ComponentName)localObject3);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = this.mContext.getApplicationInfo().loadIcon(localPackageManager);
      }
      this.mIcon.addToShortcutIntent(paramIntent, (Drawable)localObject3, this.mContext);
      return paramIntent;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = localObject4;
      }
    }
  }
  
  @Nullable
  public ComponentName getActivity()
  {
    return this.mActivity;
  }
  
  @Nullable
  public Set<String> getCategories()
  {
    return this.mCategories;
  }
  
  @Nullable
  public CharSequence getDisabledMessage()
  {
    return this.mDisabledMessage;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public IconCompat getIcon()
  {
    return this.mIcon;
  }
  
  @NonNull
  public String getId()
  {
    return this.mId;
  }
  
  @NonNull
  public Intent getIntent()
  {
    Intent[] arrayOfIntent = this.mIntents;
    return arrayOfIntent[(arrayOfIntent.length - 1)];
  }
  
  @NonNull
  public Intent[] getIntents()
  {
    Intent[] arrayOfIntent = this.mIntents;
    return (Intent[])Arrays.copyOf(arrayOfIntent, arrayOfIntent.length);
  }
  
  @Nullable
  public CharSequence getLongLabel()
  {
    return this.mLongLabel;
  }
  
  public int getRank()
  {
    return this.mRank;
  }
  
  @NonNull
  public CharSequence getShortLabel()
  {
    return this.mLabel;
  }
  
  @RequiresApi(25)
  public ShortcutInfo toShortcutInfo()
  {
    ShortcutInfo.Builder localBuilder = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
    Object localObject = this.mIcon;
    if (localObject != null) {
      localBuilder.setIcon(((IconCompat)localObject).toIcon(this.mContext));
    }
    if (!TextUtils.isEmpty(this.mLongLabel)) {
      localBuilder.setLongLabel(this.mLongLabel);
    }
    if (!TextUtils.isEmpty(this.mDisabledMessage)) {
      localBuilder.setDisabledMessage(this.mDisabledMessage);
    }
    localObject = this.mActivity;
    if (localObject != null) {
      localBuilder.setActivity((ComponentName)localObject);
    }
    localObject = this.mCategories;
    if (localObject != null) {
      localBuilder.setCategories((Set)localObject);
    }
    localBuilder.setRank(this.mRank);
    if (Build.VERSION.SDK_INT >= 29)
    {
      localObject = this.mPersons;
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = new android.app.Person[localObject.length];
        int i = 0;
        while (i < localObject.length)
        {
          localObject[i] = this.mPersons[i].toAndroidPerson();
          i += 1;
        }
        localBuilder.setPersons((android.app.Person[])localObject);
      }
      localBuilder.setLongLived(this.mIsLongLived);
    }
    else
    {
      localBuilder.setExtras(buildLegacyExtrasBundle());
    }
    return localBuilder.build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.pm.ShortcutInfoCompat
 * JD-Core Version:    0.7.0.1
 */