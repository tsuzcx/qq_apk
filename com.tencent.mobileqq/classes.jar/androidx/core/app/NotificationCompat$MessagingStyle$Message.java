package androidx.core.app;

import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class NotificationCompat$MessagingStyle$Message
{
  static final String KEY_DATA_MIME_TYPE = "type";
  static final String KEY_DATA_URI = "uri";
  static final String KEY_EXTRAS_BUNDLE = "extras";
  static final String KEY_NOTIFICATION_PERSON = "sender_person";
  static final String KEY_PERSON = "person";
  static final String KEY_SENDER = "sender";
  static final String KEY_TEXT = "text";
  static final String KEY_TIMESTAMP = "time";
  @Nullable
  private String mDataMimeType;
  @Nullable
  private Uri mDataUri;
  private Bundle mExtras = new Bundle();
  @Nullable
  private final Person mPerson;
  private final CharSequence mText;
  private final long mTimestamp;
  
  public NotificationCompat$MessagingStyle$Message(CharSequence paramCharSequence, long paramLong, @Nullable Person paramPerson)
  {
    this.mText = paramCharSequence;
    this.mTimestamp = paramLong;
    this.mPerson = paramPerson;
  }
  
  @Deprecated
  public NotificationCompat$MessagingStyle$Message(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
  {
    this(paramCharSequence1, paramLong, new Person.Builder().setName(paramCharSequence2).build());
  }
  
  @NonNull
  static Bundle[] getBundleArrayForMessages(List<Message> paramList)
  {
    Bundle[] arrayOfBundle = new Bundle[paramList.size()];
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      arrayOfBundle[i] = ((Message)paramList.get(i)).toBundle();
      i += 1;
    }
    return arrayOfBundle;
  }
  
  @Nullable
  static Message getMessageFromBundle(Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        if (paramBundle.containsKey("text"))
        {
          if (!paramBundle.containsKey("time")) {
            return null;
          }
          if (paramBundle.containsKey("person"))
          {
            localObject = Person.fromBundle(paramBundle.getBundle("person"));
          }
          else if ((paramBundle.containsKey("sender_person")) && (Build.VERSION.SDK_INT >= 28))
          {
            localObject = Person.fromAndroidPerson((android.app.Person)paramBundle.getParcelable("sender_person"));
          }
          else
          {
            if (!paramBundle.containsKey("sender")) {
              break label195;
            }
            localObject = new Person.Builder().setName(paramBundle.getCharSequence("sender")).build();
          }
          localObject = new Message(paramBundle.getCharSequence("text"), paramBundle.getLong("time"), (Person)localObject);
          if ((paramBundle.containsKey("type")) && (paramBundle.containsKey("uri"))) {
            ((Message)localObject).setData(paramBundle.getString("type"), (Uri)paramBundle.getParcelable("uri"));
          }
          if (paramBundle.containsKey("extras")) {
            ((Message)localObject).getExtras().putAll(paramBundle.getBundle("extras"));
          }
          return localObject;
        }
        else
        {
          return null;
        }
      }
      catch (ClassCastException paramBundle)
      {
        return null;
      }
      label195:
      Object localObject = null;
    }
  }
  
  @NonNull
  static List<Message> getMessagesFromBundleArray(Parcelable[] paramArrayOfParcelable)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfParcelable.length);
    int i = 0;
    while (i < paramArrayOfParcelable.length)
    {
      if ((paramArrayOfParcelable[i] instanceof Bundle))
      {
        Message localMessage = getMessageFromBundle((Bundle)paramArrayOfParcelable[i]);
        if (localMessage != null) {
          localArrayList.add(localMessage);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    Object localObject = this.mText;
    if (localObject != null) {
      localBundle.putCharSequence("text", (CharSequence)localObject);
    }
    localBundle.putLong("time", this.mTimestamp);
    localObject = this.mPerson;
    if (localObject != null)
    {
      localBundle.putCharSequence("sender", ((Person)localObject).getName());
      if (Build.VERSION.SDK_INT >= 28) {
        localBundle.putParcelable("sender_person", this.mPerson.toAndroidPerson());
      } else {
        localBundle.putBundle("person", this.mPerson.toBundle());
      }
    }
    localObject = this.mDataMimeType;
    if (localObject != null) {
      localBundle.putString("type", (String)localObject);
    }
    localObject = this.mDataUri;
    if (localObject != null) {
      localBundle.putParcelable("uri", (Parcelable)localObject);
    }
    localObject = this.mExtras;
    if (localObject != null) {
      localBundle.putBundle("extras", (Bundle)localObject);
    }
    return localBundle;
  }
  
  @Nullable
  public String getDataMimeType()
  {
    return this.mDataMimeType;
  }
  
  @Nullable
  public Uri getDataUri()
  {
    return this.mDataUri;
  }
  
  @NonNull
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  @Nullable
  public Person getPerson()
  {
    return this.mPerson;
  }
  
  @Deprecated
  @Nullable
  public CharSequence getSender()
  {
    Person localPerson = this.mPerson;
    if (localPerson == null) {
      return null;
    }
    return localPerson.getName();
  }
  
  @NonNull
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public long getTimestamp()
  {
    return this.mTimestamp;
  }
  
  public Message setData(String paramString, Uri paramUri)
  {
    this.mDataMimeType = paramString;
    this.mDataUri = paramUri;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.MessagingStyle.Message
 * JD-Core Version:    0.7.0.1
 */