package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

public final class NotificationCompat$CarExtender
  implements NotificationCompat.Extender
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
  private static final String EXTRA_COLOR = "app_color";
  private static final String EXTRA_CONVERSATION = "car_conversation";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
  private static final String EXTRA_LARGE_ICON = "large_icon";
  private static final String KEY_AUTHOR = "author";
  private static final String KEY_MESSAGES = "messages";
  private static final String KEY_ON_READ = "on_read";
  private static final String KEY_ON_REPLY = "on_reply";
  private static final String KEY_PARTICIPANTS = "participants";
  private static final String KEY_REMOTE_INPUT = "remote_input";
  private static final String KEY_TEXT = "text";
  private static final String KEY_TIMESTAMP = "timestamp";
  private int mColor = 0;
  private Bitmap mLargeIcon;
  private NotificationCompat.CarExtender.UnreadConversation mUnreadConversation;
  
  public NotificationCompat$CarExtender() {}
  
  public NotificationCompat$CarExtender(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (NotificationCompat.getExtras(paramNotification) == null) {
      paramNotification = null;
    } else {
      paramNotification = NotificationCompat.getExtras(paramNotification).getBundle("android.car.EXTENSIONS");
    }
    if (paramNotification != null)
    {
      this.mLargeIcon = ((Bitmap)paramNotification.getParcelable("large_icon"));
      this.mColor = paramNotification.getInt("app_color", 0);
      this.mUnreadConversation = getUnreadConversationFromBundle(paramNotification.getBundle("car_conversation"));
    }
  }
  
  @RequiresApi(21)
  private static Bundle getBundleForUnreadConversation(@NonNull NotificationCompat.CarExtender.UnreadConversation paramUnreadConversation)
  {
    Bundle localBundle1 = new Bundle();
    Object localObject = paramUnreadConversation.getParticipants();
    int i = 0;
    if ((localObject != null) && (paramUnreadConversation.getParticipants().length > 1)) {
      localObject = paramUnreadConversation.getParticipants()[0];
    } else {
      localObject = null;
    }
    Parcelable[] arrayOfParcelable = new Parcelable[paramUnreadConversation.getMessages().length];
    while (i < arrayOfParcelable.length)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("text", paramUnreadConversation.getMessages()[i]);
      localBundle2.putString("author", (String)localObject);
      arrayOfParcelable[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("messages", arrayOfParcelable);
    localObject = paramUnreadConversation.getRemoteInput();
    if (localObject != null) {
      localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((RemoteInput)localObject).getResultKey()).setLabel(((RemoteInput)localObject).getLabel()).setChoices(((RemoteInput)localObject).getChoices()).setAllowFreeFormInput(((RemoteInput)localObject).getAllowFreeFormInput()).addExtras(((RemoteInput)localObject).getExtras()).build());
    }
    localBundle1.putParcelable("on_reply", paramUnreadConversation.getReplyPendingIntent());
    localBundle1.putParcelable("on_read", paramUnreadConversation.getReadPendingIntent());
    localBundle1.putStringArray("participants", paramUnreadConversation.getParticipants());
    localBundle1.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
    return localBundle1;
  }
  
  @RequiresApi(21)
  private static NotificationCompat.CarExtender.UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle paramBundle)
  {
    Object localObject1 = null;
    CharSequence localCharSequence = null;
    if (paramBundle == null) {
      return null;
    }
    Object localObject2 = paramBundle.getParcelableArray("messages");
    String[] arrayOfString1;
    int i;
    if (localObject2 != null)
    {
      arrayOfString1 = new String[localObject2.length];
      i = 0;
      while (i < arrayOfString1.length)
      {
        if (!(localObject2[i] instanceof Bundle)) {}
        do
        {
          i = 0;
          break;
          arrayOfString1[i] = ((Bundle)localObject2[i]).getString("text");
        } while (arrayOfString1[i] == null);
        i += 1;
      }
      i = 1;
      if (i == 0) {
        return null;
      }
    }
    else
    {
      arrayOfString1 = null;
    }
    localObject2 = (PendingIntent)paramBundle.getParcelable("on_read");
    PendingIntent localPendingIntent = (PendingIntent)paramBundle.getParcelable("on_reply");
    android.app.RemoteInput localRemoteInput = (android.app.RemoteInput)paramBundle.getParcelable("remote_input");
    String[] arrayOfString2 = paramBundle.getStringArray("participants");
    if (arrayOfString2 != null)
    {
      if (arrayOfString2.length != 1) {
        return null;
      }
      localObject1 = localCharSequence;
      if (localRemoteInput != null)
      {
        localObject1 = localRemoteInput.getResultKey();
        localCharSequence = localRemoteInput.getLabel();
        CharSequence[] arrayOfCharSequence = localRemoteInput.getChoices();
        boolean bool = localRemoteInput.getAllowFreeFormInput();
        if (Build.VERSION.SDK_INT >= 29) {
          i = localRemoteInput.getEditChoicesBeforeSending();
        } else {
          i = 0;
        }
        localObject1 = new RemoteInput((String)localObject1, localCharSequence, arrayOfCharSequence, bool, i, localRemoteInput.getExtras(), null);
      }
      localObject1 = new NotificationCompat.CarExtender.UnreadConversation(arrayOfString1, (RemoteInput)localObject1, localPendingIntent, (PendingIntent)localObject2, arrayOfString2, paramBundle.getLong("timestamp"));
    }
    return localObject1;
  }
  
  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramBuilder;
    }
    Bundle localBundle = new Bundle();
    Object localObject = this.mLargeIcon;
    if (localObject != null) {
      localBundle.putParcelable("large_icon", (Parcelable)localObject);
    }
    int i = this.mColor;
    if (i != 0) {
      localBundle.putInt("app_color", i);
    }
    localObject = this.mUnreadConversation;
    if (localObject != null) {
      localBundle.putBundle("car_conversation", getBundleForUnreadConversation((NotificationCompat.CarExtender.UnreadConversation)localObject));
    }
    paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
    return paramBuilder;
  }
  
  @ColorInt
  public int getColor()
  {
    return this.mColor;
  }
  
  public Bitmap getLargeIcon()
  {
    return this.mLargeIcon;
  }
  
  @Deprecated
  public NotificationCompat.CarExtender.UnreadConversation getUnreadConversation()
  {
    return this.mUnreadConversation;
  }
  
  public CarExtender setColor(@ColorInt int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public CarExtender setLargeIcon(Bitmap paramBitmap)
  {
    this.mLargeIcon = paramBitmap;
    return this;
  }
  
  @Deprecated
  public CarExtender setUnreadConversation(NotificationCompat.CarExtender.UnreadConversation paramUnreadConversation)
  {
    this.mUnreadConversation = paramUnreadConversation;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.CarExtender
 * JD-Core Version:    0.7.0.1
 */