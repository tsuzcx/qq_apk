package androidx.core.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;

public class Person
{
  private static final String ICON_KEY = "icon";
  private static final String IS_BOT_KEY = "isBot";
  private static final String IS_IMPORTANT_KEY = "isImportant";
  private static final String KEY_KEY = "key";
  private static final String NAME_KEY = "name";
  private static final String URI_KEY = "uri";
  @Nullable
  IconCompat mIcon;
  boolean mIsBot;
  boolean mIsImportant;
  @Nullable
  String mKey;
  @Nullable
  CharSequence mName;
  @Nullable
  String mUri;
  
  Person(Person.Builder paramBuilder)
  {
    this.mName = paramBuilder.mName;
    this.mIcon = paramBuilder.mIcon;
    this.mUri = paramBuilder.mUri;
    this.mKey = paramBuilder.mKey;
    this.mIsBot = paramBuilder.mIsBot;
    this.mIsImportant = paramBuilder.mIsImportant;
  }
  
  @NonNull
  @RequiresApi(28)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Person fromAndroidPerson(@NonNull android.app.Person paramPerson)
  {
    Person.Builder localBuilder = new Person.Builder().setName(paramPerson.getName());
    if (paramPerson.getIcon() != null) {}
    for (IconCompat localIconCompat = IconCompat.createFromIcon(paramPerson.getIcon());; localIconCompat = null) {
      return localBuilder.setIcon(localIconCompat).setUri(paramPerson.getUri()).setKey(paramPerson.getKey()).setBot(paramPerson.isBot()).setImportant(paramPerson.isImportant()).build();
    }
  }
  
  @NonNull
  public static Person fromBundle(@NonNull Bundle paramBundle)
  {
    Object localObject = paramBundle.getBundle("icon");
    Person.Builder localBuilder = new Person.Builder().setName(paramBundle.getCharSequence("name"));
    if (localObject != null) {}
    for (localObject = IconCompat.createFromBundle((Bundle)localObject);; localObject = null) {
      return localBuilder.setIcon((IconCompat)localObject).setUri(paramBundle.getString("uri")).setKey(paramBundle.getString("key")).setBot(paramBundle.getBoolean("isBot")).setImportant(paramBundle.getBoolean("isImportant")).build();
    }
  }
  
  @NonNull
  @RequiresApi(22)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Person fromPersistableBundle(@NonNull PersistableBundle paramPersistableBundle)
  {
    return new Person.Builder().setName(paramPersistableBundle.getString("name")).setUri(paramPersistableBundle.getString("uri")).setKey(paramPersistableBundle.getString("key")).setBot(paramPersistableBundle.getBoolean("isBot")).setImportant(paramPersistableBundle.getBoolean("isImportant")).build();
  }
  
  @Nullable
  public IconCompat getIcon()
  {
    return this.mIcon;
  }
  
  @Nullable
  public String getKey()
  {
    return this.mKey;
  }
  
  @Nullable
  public CharSequence getName()
  {
    return this.mName;
  }
  
  @Nullable
  public String getUri()
  {
    return this.mUri;
  }
  
  public boolean isBot()
  {
    return this.mIsBot;
  }
  
  public boolean isImportant()
  {
    return this.mIsImportant;
  }
  
  @NonNull
  @RequiresApi(28)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public android.app.Person toAndroidPerson()
  {
    android.app.Person.Builder localBuilder = new android.app.Person.Builder().setName(getName());
    if (getIcon() != null) {}
    for (Icon localIcon = getIcon().toIcon();; localIcon = null) {
      return localBuilder.setIcon(localIcon).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
    }
  }
  
  @NonNull
  public Person.Builder toBuilder()
  {
    return new Person.Builder(this);
  }
  
  @NonNull
  public Bundle toBundle()
  {
    Bundle localBundle2 = new Bundle();
    localBundle2.putCharSequence("name", this.mName);
    if (this.mIcon != null) {}
    for (Bundle localBundle1 = this.mIcon.toBundle();; localBundle1 = null)
    {
      localBundle2.putBundle("icon", localBundle1);
      localBundle2.putString("uri", this.mUri);
      localBundle2.putString("key", this.mKey);
      localBundle2.putBoolean("isBot", this.mIsBot);
      localBundle2.putBoolean("isImportant", this.mIsImportant);
      return localBundle2;
    }
  }
  
  @NonNull
  @RequiresApi(22)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PersistableBundle toPersistableBundle()
  {
    PersistableBundle localPersistableBundle = new PersistableBundle();
    if (this.mName != null) {}
    for (String str = this.mName.toString();; str = null)
    {
      localPersistableBundle.putString("name", str);
      localPersistableBundle.putString("uri", this.mUri);
      localPersistableBundle.putString("key", this.mKey);
      localPersistableBundle.putBoolean("isBot", this.mIsBot);
      localPersistableBundle.putBoolean("isImportant", this.mIsImportant);
      return localPersistableBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.Person
 * JD-Core Version:    0.7.0.1
 */