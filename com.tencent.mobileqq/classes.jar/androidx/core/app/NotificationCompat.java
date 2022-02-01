package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat
{
  public static final int BADGE_ICON_LARGE = 2;
  public static final int BADGE_ICON_NONE = 0;
  public static final int BADGE_ICON_SMALL = 1;
  public static final String CATEGORY_ALARM = "alarm";
  public static final String CATEGORY_CALL = "call";
  public static final String CATEGORY_EMAIL = "email";
  public static final String CATEGORY_ERROR = "err";
  public static final String CATEGORY_EVENT = "event";
  public static final String CATEGORY_MESSAGE = "msg";
  public static final String CATEGORY_NAVIGATION = "navigation";
  public static final String CATEGORY_PROGRESS = "progress";
  public static final String CATEGORY_PROMO = "promo";
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  public static final String CATEGORY_REMINDER = "reminder";
  public static final String CATEGORY_SERVICE = "service";
  public static final String CATEGORY_SOCIAL = "social";
  public static final String CATEGORY_STATUS = "status";
  public static final String CATEGORY_SYSTEM = "sys";
  public static final String CATEGORY_TRANSPORT = "transport";
  @ColorInt
  public static final int COLOR_DEFAULT = 0;
  public static final int DEFAULT_ALL = -1;
  public static final int DEFAULT_LIGHTS = 4;
  public static final int DEFAULT_SOUND = 1;
  public static final int DEFAULT_VIBRATE = 2;
  public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  public static final String EXTRA_MESSAGES = "android.messages";
  public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
  public static final String EXTRA_PEOPLE = "android.people";
  public static final String EXTRA_PICTURE = "android.picture";
  public static final String EXTRA_PROGRESS = "android.progress";
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  public static final String EXTRA_SMALL_ICON = "android.icon";
  public static final String EXTRA_SUB_TEXT = "android.subText";
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  public static final String EXTRA_TEMPLATE = "android.template";
  public static final String EXTRA_TEXT = "android.text";
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  public static final String EXTRA_TITLE = "android.title";
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  public static final int FLAG_AUTO_CANCEL = 16;
  public static final int FLAG_BUBBLE = 4096;
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  public static final int FLAG_GROUP_SUMMARY = 512;
  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  public static final int FLAG_INSISTENT = 4;
  public static final int FLAG_LOCAL_ONLY = 256;
  public static final int FLAG_NO_CLEAR = 32;
  public static final int FLAG_ONGOING_EVENT = 2;
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  public static final int FLAG_SHOW_LIGHTS = 1;
  public static final int GROUP_ALERT_ALL = 0;
  public static final int GROUP_ALERT_CHILDREN = 2;
  public static final int GROUP_ALERT_SUMMARY = 1;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  public static final int STREAM_DEFAULT = -1;
  public static final int VISIBILITY_PRIVATE = 0;
  public static final int VISIBILITY_PUBLIC = 1;
  public static final int VISIBILITY_SECRET = -1;
  
  public static NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
  {
    Object localObject = null;
    Notification.Action localAction = null;
    if (Build.VERSION.SDK_INT >= 20) {
      localObject = getActionCompatFromAction(paramNotification.actions[paramInt]);
    }
    do
    {
      return localObject;
      if (Build.VERSION.SDK_INT >= 19)
      {
        localAction = paramNotification.actions[paramInt];
        SparseArray localSparseArray = paramNotification.extras.getSparseParcelableArray("android.support.actionExtras");
        paramNotification = (Notification)localObject;
        if (localSparseArray != null) {
          paramNotification = (Bundle)localSparseArray.get(paramInt);
        }
        return NotificationCompatJellybean.readAction(localAction.icon, localAction.title, localAction.actionIntent, paramNotification);
      }
      localObject = localAction;
    } while (Build.VERSION.SDK_INT < 16);
    return NotificationCompatJellybean.getAction(paramNotification, paramInt);
  }
  
  @RequiresApi(20)
  static NotificationCompat.Action getActionCompatFromAction(Notification.Action paramAction)
  {
    boolean bool2 = false;
    Object localObject1 = paramAction.getRemoteInputs();
    RemoteInput[] arrayOfRemoteInput;
    if (localObject1 == null) {
      arrayOfRemoteInput = null;
    }
    label262:
    label277:
    label330:
    label363:
    for (;;)
    {
      boolean bool1;
      boolean bool3;
      if (Build.VERSION.SDK_INT >= 24) {
        if ((paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies")) || (paramAction.getAllowGeneratedReplies()))
        {
          bool1 = true;
          bool3 = paramAction.getExtras().getBoolean("android.support.action.showsUserInterface", true);
          if (Build.VERSION.SDK_INT < 28) {
            break label262;
          }
        }
      }
      for (int i = paramAction.getSemanticAction();; i = paramAction.getExtras().getInt("android.support.action.semanticAction", 0))
      {
        if (Build.VERSION.SDK_INT >= 29) {
          bool2 = paramAction.isContextual();
        }
        if (Build.VERSION.SDK_INT < 23) {
          break label330;
        }
        if ((paramAction.getIcon() != null) || (paramAction.icon == 0)) {
          break label277;
        }
        return new NotificationCompat.Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, null, bool1, i, bool3, bool2);
        arrayOfRemoteInput = new RemoteInput[localObject1.length];
        i = 0;
        if (i >= localObject1.length) {
          break label363;
        }
        Object localObject2 = localObject1[i];
        String str = localObject2.getResultKey();
        CharSequence localCharSequence = localObject2.getLabel();
        CharSequence[] arrayOfCharSequence = localObject2.getChoices();
        bool1 = localObject2.getAllowFreeFormInput();
        if (Build.VERSION.SDK_INT >= 29) {}
        for (int j = localObject2.getEditChoicesBeforeSending();; j = 0)
        {
          arrayOfRemoteInput[i] = new RemoteInput(str, localCharSequence, arrayOfCharSequence, bool1, j, localObject2.getExtras(), null);
          i += 1;
          break;
        }
        bool1 = false;
        break;
        bool1 = paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies");
        break;
      }
      if (paramAction.getIcon() == null) {}
      for (localObject1 = null;; localObject1 = IconCompat.createFromIconOrNullIfZeroResId(paramAction.getIcon())) {
        return new NotificationCompat.Action((IconCompat)localObject1, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, null, bool1, i, bool3, bool2);
      }
      return new NotificationCompat.Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, null, bool1, i, bool3, bool2);
    }
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 19) {
      if (paramNotification.actions != null) {
        i = paramNotification.actions.length;
      }
    }
    while (Build.VERSION.SDK_INT < 16) {
      return i;
    }
    return NotificationCompatJellybean.getActionCount(paramNotification);
  }
  
  public static boolean getAllowSystemGeneratedContextualActions(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return paramNotification.getAllowSystemGeneratedContextualActions();
    }
    return false;
  }
  
  public static int getBadgeIconType(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getBadgeIconType();
    }
    return 0;
  }
  
  @Nullable
  public static NotificationCompat.BubbleMetadata getBubbleMetadata(@NonNull Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return NotificationCompat.BubbleMetadata.fromPlatform(paramNotification.getBubbleMetadata());
    }
    return null;
  }
  
  public static String getCategory(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramNotification.category;
    }
    return null;
  }
  
  public static String getChannelId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getChannelId();
    }
    return null;
  }
  
  @RequiresApi(19)
  public static CharSequence getContentTitle(Notification paramNotification)
  {
    return paramNotification.extras.getCharSequence("android.title");
  }
  
  @Nullable
  public static Bundle getExtras(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification);
    }
    return null;
  }
  
  public static String getGroup(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getGroup();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getString("android.support.groupKey");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.groupKey");
    }
    return null;
  }
  
  public static int getGroupAlertBehavior(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getGroupAlertBehavior();
    }
    return 0;
  }
  
  @RequiresApi(21)
  public static List<NotificationCompat.Action> getInvisibleActions(Notification paramNotification)
  {
    ArrayList localArrayList = new ArrayList();
    paramNotification = paramNotification.extras.getBundle("android.car.EXTENSIONS");
    if (paramNotification == null) {
      return localArrayList;
    }
    paramNotification = paramNotification.getBundle("invisible_actions");
    if (paramNotification != null)
    {
      int i = 0;
      while (i < paramNotification.size())
      {
        localArrayList.add(NotificationCompatJellybean.getActionFromBundle(paramNotification.getBundle(Integer.toString(i))));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static boolean getLocalOnly(Notification paramNotification)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 20) {
      if ((paramNotification.flags & 0x100) != 0) {
        bool = true;
      }
    }
    do
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        return paramNotification.extras.getBoolean("android.support.localOnly");
      }
    } while (Build.VERSION.SDK_INT < 16);
    return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.localOnly");
  }
  
  static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (((arrayOfParcelable instanceof Notification[])) || (arrayOfParcelable == null)) {
      return (Notification[])arrayOfParcelable;
    }
    Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
    int i = 0;
    while (i < arrayOfParcelable.length)
    {
      arrayOfNotification[i] = ((Notification)arrayOfParcelable[i]);
      i += 1;
    }
    paramBundle.putParcelableArray(paramString, arrayOfNotification);
    return arrayOfNotification;
  }
  
  public static String getShortcutId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getShortcutId();
    }
    return null;
  }
  
  public static String getSortKey(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getSortKey();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getString("android.support.sortKey");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.sortKey");
    }
    return null;
  }
  
  public static long getTimeoutAfter(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getTimeoutAfter();
    }
    return 0L;
  }
  
  public static boolean isGroupSummary(Notification paramNotification)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 20) {
      if ((paramNotification.flags & 0x200) != 0) {
        bool = true;
      }
    }
    do
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        return paramNotification.extras.getBoolean("android.support.isGroupSummary");
      }
    } while (Build.VERSION.SDK_INT < 16);
    return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.isGroupSummary");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.NotificationCompat
 * JD-Core Version:    0.7.0.1
 */