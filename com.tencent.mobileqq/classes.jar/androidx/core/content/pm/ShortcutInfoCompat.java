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
    if ((this.mPersons != null) && (this.mPersons.length > 0))
    {
      localPersistableBundle.putInt("extraPersonCount", this.mPersons.length);
      int i = 0;
      while (i < this.mPersons.length)
      {
        localPersistableBundle.putPersistableBundle("extraPerson_" + (i + 1), this.mPersons[i].toPersistableBundle());
        i += 1;
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
    if ((paramPersistableBundle == null) || (!paramPersistableBundle.containsKey("extraLongLived"))) {
      return false;
    }
    return paramPersistableBundle.getBoolean("extraLongLived");
  }
  
  @Nullable
  @RequiresApi(25)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static androidx.core.app.Person[] getPersonsFromExtra(@NonNull PersistableBundle paramPersistableBundle)
  {
    Object localObject;
    if ((paramPersistableBundle == null) || (!paramPersistableBundle.containsKey("extraPersonCount")))
    {
      localObject = null;
      return localObject;
    }
    int j = paramPersistableBundle.getInt("extraPersonCount");
    androidx.core.app.Person[] arrayOfPerson = new androidx.core.app.Person[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfPerson;
      if (i >= j) {
        break;
      }
      arrayOfPerson[i] = androidx.core.app.Person.fromPersistableBundle(paramPersistableBundle.getPersistableBundle("extraPerson_" + (i + 1)));
      i += 1;
    }
  }
  
  Intent addToIntent(Intent paramIntent)
  {
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[(this.mIntents.length - 1)]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
    Object localObject3;
    Object localObject4;
    PackageManager localPackageManager;
    Object localObject1;
    if (this.mIcon != null)
    {
      localObject3 = null;
      localObject4 = null;
      if (this.mIsAlwaysBadged)
      {
        localPackageManager = this.mContext.getPackageManager();
        localObject1 = localObject4;
        if (this.mActivity == null) {}
      }
    }
    try
    {
      localObject1 = localPackageManager.getActivityIcon(this.mActivity);
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
    return this.mIntents[(this.mIntents.length - 1)];
  }
  
  @NonNull
  public Intent[] getIntents()
  {
    return (Intent[])Arrays.copyOf(this.mIntents, this.mIntents.length);
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
    if (this.mIcon != null) {
      localBuilder.setIcon(this.mIcon.toIcon());
    }
    if (!TextUtils.isEmpty(this.mLongLabel)) {
      localBuilder.setLongLabel(this.mLongLabel);
    }
    if (!TextUtils.isEmpty(this.mDisabledMessage)) {
      localBuilder.setDisabledMessage(this.mDisabledMessage);
    }
    if (this.mActivity != null) {
      localBuilder.setActivity(this.mActivity);
    }
    if (this.mCategories != null) {
      localBuilder.setCategories(this.mCategories);
    }
    localBuilder.setRank(this.mRank);
    if (Build.VERSION.SDK_INT >= 29)
    {
      if ((this.mPersons != null) && (this.mPersons.length > 0))
      {
        android.app.Person[] arrayOfPerson = new android.app.Person[this.mPersons.length];
        int i = 0;
        while (i < arrayOfPerson.length)
        {
          arrayOfPerson[i] = this.mPersons[i].toAndroidPerson();
          i += 1;
        }
        localBuilder.setPersons(arrayOfPerson);
      }
      localBuilder.setLongLived(this.mIsLongLived);
    }
    for (;;)
    {
      return localBuilder.build();
      localBuilder.setExtras(buildLegacyExtrasBundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.content.pm.ShortcutInfoCompat
 * JD-Core Version:    0.7.0.1
 */