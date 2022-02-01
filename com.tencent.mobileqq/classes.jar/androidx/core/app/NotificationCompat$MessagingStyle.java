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
    if (!TextUtils.isEmpty(paramPerson.getName()))
    {
      this.mUser = paramPerson;
      return;
    }
    throw new IllegalArgumentException("User's name must not be empty.");
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
    Object localObject;
    while (i >= 0)
    {
      localObject = (NotificationCompat.MessagingStyle.Message)this.mMessages.get(i);
      if ((((NotificationCompat.MessagingStyle.Message)localObject).getPerson() != null) && (!TextUtils.isEmpty(((NotificationCompat.MessagingStyle.Message)localObject).getPerson().getName()))) {
        return localObject;
      }
      i -= 1;
    }
    if (!this.mMessages.isEmpty())
    {
      localObject = this.mMessages;
      return (NotificationCompat.MessagingStyle.Message)((List)localObject).get(((List)localObject).size() - 1);
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
    if (Build.VERSION.SDK_INT >= 21) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    if (j != 0) {
      i = -16777216;
    } else {
      i = -1;
    }
    Object localObject1 = paramMessage.getPerson();
    String str = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = paramMessage.getPerson().getName();
    }
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
    if (paramMessage.getText() == null) {
      paramMessage = str;
    } else {
      paramMessage = paramMessage.getText();
    }
    localSpannableStringBuilder.append("  ").append(localBidiFormatter.unicodeWrap(paramMessage));
    return localSpannableStringBuilder;
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
    Boolean localBoolean = this.mIsGroupConversation;
    if (localBoolean != null) {
      paramBundle.putBoolean("android.isGroupConversation", localBoolean.booleanValue());
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
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        localObject1 = new Notification.MessagingStyle(this.mUser.toAndroidPerson());
      } else {
        localObject1 = new Notification.MessagingStyle(this.mUser.getName());
      }
      if ((this.mIsGroupConversation.booleanValue()) || (Build.VERSION.SDK_INT >= 28)) {
        ((Notification.MessagingStyle)localObject1).setConversationTitle(this.mConversationTitle);
      }
      if (Build.VERSION.SDK_INT >= 28) {
        ((Notification.MessagingStyle)localObject1).setGroupConversation(this.mIsGroupConversation.booleanValue());
      }
      Iterator localIterator = this.mMessages.iterator();
      while (localIterator.hasNext())
      {
        NotificationCompat.MessagingStyle.Message localMessage = (NotificationCompat.MessagingStyle.Message)localIterator.next();
        if (Build.VERSION.SDK_INT >= 28)
        {
          localObject2 = localMessage.getPerson();
          CharSequence localCharSequence = localMessage.getText();
          long l = localMessage.getTimestamp();
          if (localObject2 == null) {
            localObject2 = null;
          } else {
            localObject2 = ((Person)localObject2).toAndroidPerson();
          }
          localObject2 = new Notification.MessagingStyle.Message(localCharSequence, l, (android.app.Person)localObject2);
        }
        else
        {
          if (localMessage.getPerson() != null) {
            localObject2 = localMessage.getPerson().getName();
          } else {
            localObject2 = null;
          }
          localObject2 = new Notification.MessagingStyle.Message(localMessage.getText(), localMessage.getTimestamp(), (CharSequence)localObject2);
        }
        if (localMessage.getDataMimeType() != null) {
          ((Notification.MessagingStyle.Message)localObject2).setData(localMessage.getDataMimeType(), localMessage.getDataUri());
        }
        ((Notification.MessagingStyle)localObject1).addMessage((Notification.MessagingStyle.Message)localObject2);
      }
      ((Notification.MessagingStyle)localObject1).setBuilder(paramNotificationBuilderWithBuilderAccessor.getBuilder());
      return;
    }
    Object localObject1 = findLatestIncomingMessage();
    if ((this.mConversationTitle != null) && (this.mIsGroupConversation.booleanValue()))
    {
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
    }
    else if (localObject1 != null)
    {
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
      if (((NotificationCompat.MessagingStyle.Message)localObject1).getPerson() != null) {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(((NotificationCompat.MessagingStyle.Message)localObject1).getPerson().getName());
      }
    }
    if (localObject1 != null)
    {
      localObject2 = paramNotificationBuilderWithBuilderAccessor.getBuilder();
      if (this.mConversationTitle != null) {
        localObject1 = makeMessageLine((NotificationCompat.MessagingStyle.Message)localObject1);
      } else {
        localObject1 = ((NotificationCompat.MessagingStyle.Message)localObject1).getText();
      }
      ((Notification.Builder)localObject2).setContentText((CharSequence)localObject1);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject2 = new SpannableStringBuilder();
      int i;
      if ((this.mConversationTitle == null) && (!hasMessagesWithoutSender())) {
        i = 0;
      } else {
        i = 1;
      }
      int j = this.mMessages.size() - 1;
      while (j >= 0)
      {
        localObject1 = (NotificationCompat.MessagingStyle.Message)this.mMessages.get(j);
        if (i != 0) {
          localObject1 = makeMessageLine((NotificationCompat.MessagingStyle.Message)localObject1);
        } else {
          localObject1 = ((NotificationCompat.MessagingStyle.Message)localObject1).getText();
        }
        if (j != this.mMessages.size() - 1) {
          ((SpannableStringBuilder)localObject2).insert(0, "\n");
        }
        ((SpannableStringBuilder)localObject2).insert(0, (CharSequence)localObject1);
        j -= 1;
      }
      new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText((CharSequence)localObject2);
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
    Object localObject = this.mBuilder;
    boolean bool2 = false;
    boolean bool1 = false;
    if ((localObject != null) && (this.mBuilder.mContext.getApplicationInfo().targetSdkVersion < 28) && (this.mIsGroupConversation == null))
    {
      if (this.mConversationTitle != null) {
        bool1 = true;
      }
      return bool1;
    }
    localObject = this.mIsGroupConversation;
    bool1 = bool2;
    if (localObject != null) {
      bool1 = ((Boolean)localObject).booleanValue();
    }
    return bool1;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void restoreFromCompatExtras(Bundle paramBundle)
  {
    this.mMessages.clear();
    if (paramBundle.containsKey("android.messagingStyleUser")) {
      this.mUser = Person.fromBundle(paramBundle.getBundle("android.messagingStyleUser"));
    } else {
      this.mUser = new Person.Builder().setName(paramBundle.getString("android.selfDisplayName")).build();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.MessagingStyle
 * JD-Core Version:    0.7.0.1
 */