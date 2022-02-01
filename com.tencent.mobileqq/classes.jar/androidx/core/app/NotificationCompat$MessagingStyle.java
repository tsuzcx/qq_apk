package androidx.core.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.MessagingStyle;
import android.app.Notification.MessagingStyle.Message;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.text.BidiFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat$MessagingStyle
  extends NotificationCompat.Style
{
  public static final int MAXIMUM_RETAINED_MESSAGES = 25;
  @Nullable
  private CharSequence mConversationTitle;
  @Nullable
  private Boolean mIsGroupConversation;
  private final List<NotificationCompat.MessagingStyle.Message> mMessages = new ArrayList();
  private Person mUser;
  
  private NotificationCompat$MessagingStyle() {}
  
  public NotificationCompat$MessagingStyle(@NonNull Person paramPerson)
  {
    if (TextUtils.isEmpty(paramPerson.getName())) {
      throw new IllegalArgumentException("User's name must not be empty.");
    }
    this.mUser = paramPerson;
  }
  
  @Deprecated
  public NotificationCompat$MessagingStyle(@NonNull CharSequence paramCharSequence)
  {
    this.mUser = new Person.Builder().setName(paramCharSequence).build();
  }
  
  @Nullable
  public static MessagingStyle extractMessagingStyleFromNotification(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    if ((paramNotification != null) && (!paramNotification.containsKey("android.selfDisplayName")) && (!paramNotification.containsKey("android.messagingStyleUser"))) {
      return null;
    }
    try
    {
      MessagingStyle localMessagingStyle = new MessagingStyle();
      localMessagingStyle.restoreFromCompatExtras(paramNotification);
      return localMessagingStyle;
    }
    catch (ClassCastException paramNotification) {}
    return null;
  }
  
  @Nullable
  private NotificationCompat.MessagingStyle.Message findLatestIncomingMessage()
  {
    int i = this.mMessages.size() - 1;
    while (i >= 0)
    {
      NotificationCompat.MessagingStyle.Message localMessage = (NotificationCompat.MessagingStyle.Message)this.mMessages.get(i);
      if ((localMessage.getPerson() != null) && (!TextUtils.isEmpty(localMessage.getPerson().getName()))) {
        return localMessage;
      }
      i -= 1;
    }
    if (!this.mMessages.isEmpty()) {
      return (NotificationCompat.MessagingStyle.Message)this.mMessages.get(this.mMessages.size() - 1);
    }
    return null;
  }
  
  private boolean hasMessagesWithoutSender()
  {
    int i = this.mMessages.size() - 1;
    while (i >= 0)
    {
      NotificationCompat.MessagingStyle.Message localMessage = (NotificationCompat.MessagingStyle.Message)this.mMessages.get(i);
      if ((localMessage.getPerson() != null) && (localMessage.getPerson().getName() == null)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  @NonNull
  private TextAppearanceSpan makeFontColorSpan(int paramInt)
  {
    return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
  }
  
  private CharSequence makeMessageLine(NotificationCompat.MessagingStyle.Message paramMessage)
  {
    BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int j;
    int i;
    label31:
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      j = 1;
      if (j == 0) {
        break label190;
      }
      i = -16777216;
      if (paramMessage.getPerson() != null) {
        break label195;
      }
      localObject1 = "";
      label42:
      int k = i;
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = this.mUser.getName();
        k = i;
        localObject2 = localObject1;
        if (j != 0)
        {
          k = i;
          localObject2 = localObject1;
          if (this.mBuilder.getColor() != 0)
          {
            k = this.mBuilder.getColor();
            localObject2 = localObject1;
          }
        }
      }
      localObject1 = localBidiFormatter.unicodeWrap(localObject2);
      localSpannableStringBuilder.append((CharSequence)localObject1);
      localSpannableStringBuilder.setSpan(makeFontColorSpan(k), localSpannableStringBuilder.length() - ((CharSequence)localObject1).length(), localSpannableStringBuilder.length(), 33);
      if (paramMessage.getText() != null) {
        break label207;
      }
    }
    label190:
    label195:
    label207:
    for (paramMessage = "";; paramMessage = paramMessage.getText())
    {
      localSpannableStringBuilder.append("  ").append(localBidiFormatter.unicodeWrap(paramMessage));
      return localSpannableStringBuilder;
      j = 0;
      break;
      i = -1;
      break label31;
      localObject1 = paramMessage.getPerson().getName();
      break label42;
    }
  }
  
  public void addCompatExtras(Bundle paramBundle)
  {
    super.addCompatExtras(paramBundle);
    paramBundle.putCharSequence("android.selfDisplayName", this.mUser.getName());
    paramBundle.putBundle("android.messagingStyleUser", this.mUser.toBundle());
    paramBundle.putCharSequence("android.hiddenConversationTitle", this.mConversationTitle);
    if ((this.mConversationTitle != null) && (this.mIsGroupConversation.booleanValue())) {
      paramBundle.putCharSequence("android.conversationTitle", this.mConversationTitle);
    }
    if (!this.mMessages.isEmpty()) {
      paramBundle.putParcelableArray("android.messages", NotificationCompat.MessagingStyle.Message.getBundleArrayForMessages(this.mMessages));
    }
    if (this.mIsGroupConversation != null) {
      paramBundle.putBoolean("android.isGroupConversation", this.mIsGroupConversation.booleanValue());
    }
  }
  
  public MessagingStyle addMessage(NotificationCompat.MessagingStyle.Message paramMessage)
  {
    this.mMessages.add(paramMessage);
    if (this.mMessages.size() > 25) {
      this.mMessages.remove(0);
    }
    return this;
  }
  
  public MessagingStyle addMessage(CharSequence paramCharSequence, long paramLong, Person paramPerson)
  {
    addMessage(new NotificationCompat.MessagingStyle.Message(paramCharSequence, paramLong, paramPerson));
    return this;
  }
  
  @Deprecated
  public MessagingStyle addMessage(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
  {
    this.mMessages.add(new NotificationCompat.MessagingStyle.Message(paramCharSequence1, paramLong, new Person.Builder().setName(paramCharSequence2).build()));
    if (this.mMessages.size() > 25) {
      this.mMessages.remove(0);
    }
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    setGroupConversation(isGroupConversation());
    Object localObject1;
    label101:
    NotificationCompat.MessagingStyle.Message localMessage;
    if (Build.VERSION.SDK_INT >= 24)
    {
      CharSequence localCharSequence;
      long l;
      if (Build.VERSION.SDK_INT >= 28)
      {
        localObject1 = new Notification.MessagingStyle(this.mUser.toAndroidPerson());
        if ((this.mIsGroupConversation.booleanValue()) || (Build.VERSION.SDK_INT >= 28)) {
          ((Notification.MessagingStyle)localObject1).setConversationTitle(this.mConversationTitle);
        }
        if (Build.VERSION.SDK_INT >= 28) {
          ((Notification.MessagingStyle)localObject1).setGroupConversation(this.mIsGroupConversation.booleanValue());
        }
        Iterator localIterator = this.mMessages.iterator();
        if (!localIterator.hasNext()) {
          break label281;
        }
        localMessage = (NotificationCompat.MessagingStyle.Message)localIterator.next();
        if (Build.VERSION.SDK_INT < 28) {
          break label239;
        }
        localObject2 = localMessage.getPerson();
        localCharSequence = localMessage.getText();
        l = localMessage.getTimestamp();
        if (localObject2 != null) {
          break label229;
        }
      }
      label229:
      for (localObject2 = null;; localObject2 = ((Person)localObject2).toAndroidPerson())
      {
        localObject2 = new Notification.MessagingStyle.Message(localCharSequence, l, (android.app.Person)localObject2);
        if (localMessage.getDataMimeType() != null) {
          ((Notification.MessagingStyle.Message)localObject2).setData(localMessage.getDataMimeType(), localMessage.getDataUri());
        }
        ((Notification.MessagingStyle)localObject1).addMessage((Notification.MessagingStyle.Message)localObject2);
        break label101;
        localObject1 = new Notification.MessagingStyle(this.mUser.getName());
        break;
      }
      label239:
      if (localMessage.getPerson() == null) {
        break label578;
      }
    }
    label281:
    label411:
    label544:
    label554:
    label578:
    for (Object localObject2 = localMessage.getPerson().getName();; localObject2 = null)
    {
      localObject2 = new Notification.MessagingStyle.Message(localMessage.getText(), localMessage.getTimestamp(), (CharSequence)localObject2);
      break;
      ((Notification.MessagingStyle)localObject1).setBuilder(paramNotificationBuilderWithBuilderAccessor.getBuilder());
      label358:
      do
      {
        return;
        localObject1 = findLatestIncomingMessage();
        if ((this.mConversationTitle == null) || (!this.mIsGroupConversation.booleanValue())) {
          break;
        }
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
        if (localObject1 != null)
        {
          localObject2 = paramNotificationBuilderWithBuilderAccessor.getBuilder();
          if (this.mConversationTitle == null) {
            break label529;
          }
          localObject1 = makeMessageLine((NotificationCompat.MessagingStyle.Message)localObject1);
          ((Notification.Builder)localObject2).setContentText((CharSequence)localObject1);
        }
      } while (Build.VERSION.SDK_INT < 16);
      localObject2 = new SpannableStringBuilder();
      int i;
      int j;
      if ((this.mConversationTitle != null) || (hasMessagesWithoutSender()))
      {
        i = 1;
        j = this.mMessages.size() - 1;
        if (j < 0) {
          break label554;
        }
        localObject1 = (NotificationCompat.MessagingStyle.Message)this.mMessages.get(j);
        if (i == 0) {
          break label544;
        }
      }
      for (localObject1 = makeMessageLine((NotificationCompat.MessagingStyle.Message)localObject1);; localObject1 = ((NotificationCompat.MessagingStyle.Message)localObject1).getText())
      {
        if (j != this.mMessages.size() - 1) {
          ((SpannableStringBuilder)localObject2).insert(0, "\n");
        }
        ((SpannableStringBuilder)localObject2).insert(0, (CharSequence)localObject1);
        j -= 1;
        break label411;
        if (localObject1 == null) {
          break;
        }
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
        if (((NotificationCompat.MessagingStyle.Message)localObject1).getPerson() == null) {
          break;
        }
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(((NotificationCompat.MessagingStyle.Message)localObject1).getPerson().getName());
        break;
        localObject1 = ((NotificationCompat.MessagingStyle.Message)localObject1).getText();
        break label358;
        i = 0;
        break label399;
      }
      new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText((CharSequence)localObject2);
      return;
    }
  }
  
  @Nullable
  public CharSequence getConversationTitle()
  {
    return this.mConversationTitle;
  }
  
  public List<NotificationCompat.MessagingStyle.Message> getMessages()
  {
    return this.mMessages;
  }
  
  public Person getUser()
  {
    return this.mUser;
  }
  
  @Deprecated
  public CharSequence getUserDisplayName()
  {
    return this.mUser.getName();
  }
  
  public boolean isGroupConversation()
  {
    boolean bool = false;
    if ((this.mBuilder != null) && (this.mBuilder.mContext.getApplicationInfo().targetSdkVersion < 28) && (this.mIsGroupConversation == null)) {
      if (this.mConversationTitle != null) {
        bool = true;
      }
    }
    while (this.mIsGroupConversation == null) {
      return bool;
    }
    return this.mIsGroupConversation.booleanValue();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void restoreFromCompatExtras(Bundle paramBundle)
  {
    this.mMessages.clear();
    if (paramBundle.containsKey("android.messagingStyleUser")) {}
    for (this.mUser = Person.fromBundle(paramBundle.getBundle("android.messagingStyleUser"));; this.mUser = new Person.Builder().setName(paramBundle.getString("android.selfDisplayName")).build())
    {
      this.mConversationTitle = paramBundle.getCharSequence("android.conversationTitle");
      if (this.mConversationTitle == null) {
        this.mConversationTitle = paramBundle.getCharSequence("android.hiddenConversationTitle");
      }
      Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("android.messages");
      if (arrayOfParcelable != null) {
        this.mMessages.addAll(NotificationCompat.MessagingStyle.Message.getMessagesFromBundleArray(arrayOfParcelable));
      }
      if (paramBundle.containsKey("android.isGroupConversation")) {
        this.mIsGroupConversation = Boolean.valueOf(paramBundle.getBoolean("android.isGroupConversation"));
      }
      return;
    }
  }
  
  public MessagingStyle setConversationTitle(@Nullable CharSequence paramCharSequence)
  {
    this.mConversationTitle = paramCharSequence;
    return this;
  }
  
  public MessagingStyle setGroupConversation(boolean paramBoolean)
  {
    this.mIsGroupConversation = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.MessagingStyle
 * JD-Core Version:    0.7.0.1
 */