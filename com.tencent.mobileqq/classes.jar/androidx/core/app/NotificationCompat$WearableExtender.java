package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class NotificationCompat$WearableExtender
  implements NotificationCompat.Extender
{
  private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
  private static final int DEFAULT_FLAGS = 1;
  private static final int DEFAULT_GRAVITY = 80;
  private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
  private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
  private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
  private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
  private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
  private static final int FLAG_HINT_HIDE_ICON = 2;
  private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
  private static final int FLAG_START_SCROLL_BOTTOM = 8;
  private static final String KEY_ACTIONS = "actions";
  private static final String KEY_BACKGROUND = "background";
  private static final String KEY_BRIDGE_TAG = "bridgeTag";
  private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
  private static final String KEY_CONTENT_ICON = "contentIcon";
  private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
  private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
  private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
  private static final String KEY_DISMISSAL_ID = "dismissalId";
  private static final String KEY_DISPLAY_INTENT = "displayIntent";
  private static final String KEY_FLAGS = "flags";
  private static final String KEY_GRAVITY = "gravity";
  private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
  private static final String KEY_PAGES = "pages";
  @Deprecated
  public static final int SCREEN_TIMEOUT_LONG = -1;
  @Deprecated
  public static final int SCREEN_TIMEOUT_SHORT = 0;
  @Deprecated
  public static final int SIZE_DEFAULT = 0;
  @Deprecated
  public static final int SIZE_FULL_SCREEN = 5;
  @Deprecated
  public static final int SIZE_LARGE = 4;
  @Deprecated
  public static final int SIZE_MEDIUM = 3;
  @Deprecated
  public static final int SIZE_SMALL = 2;
  @Deprecated
  public static final int SIZE_XSMALL = 1;
  public static final int UNSET_ACTION_INDEX = -1;
  private ArrayList<NotificationCompat.Action> mActions = new ArrayList();
  private Bitmap mBackground;
  private String mBridgeTag;
  private int mContentActionIndex = -1;
  private int mContentIcon;
  private int mContentIconGravity = 8388613;
  private int mCustomContentHeight;
  private int mCustomSizePreset = 0;
  private String mDismissalId;
  private PendingIntent mDisplayIntent;
  private int mFlags = 1;
  private int mGravity = 80;
  private int mHintScreenTimeout;
  private ArrayList<Notification> mPages = new ArrayList();
  
  public NotificationCompat$WearableExtender() {}
  
  public NotificationCompat$WearableExtender(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    if (paramNotification != null) {
      paramNotification = paramNotification.getBundle("android.wearable.EXTENSIONS");
    } else {
      paramNotification = null;
    }
    if (paramNotification != null)
    {
      Object localObject = paramNotification.getParcelableArrayList("actions");
      if ((Build.VERSION.SDK_INT >= 16) && (localObject != null))
      {
        NotificationCompat.Action[] arrayOfAction = new NotificationCompat.Action[((ArrayList)localObject).size()];
        int i = 0;
        while (i < arrayOfAction.length)
        {
          if (Build.VERSION.SDK_INT >= 20) {
            arrayOfAction[i] = NotificationCompat.getActionCompatFromAction((Notification.Action)((ArrayList)localObject).get(i));
          } else if (Build.VERSION.SDK_INT >= 16) {
            arrayOfAction[i] = NotificationCompatJellybean.getActionFromBundle((Bundle)((ArrayList)localObject).get(i));
          }
          i += 1;
        }
        Collections.addAll(this.mActions, arrayOfAction);
      }
      this.mFlags = paramNotification.getInt("flags", 1);
      this.mDisplayIntent = ((PendingIntent)paramNotification.getParcelable("displayIntent"));
      localObject = NotificationCompat.getNotificationArrayFromBundle(paramNotification, "pages");
      if (localObject != null) {
        Collections.addAll(this.mPages, (Object[])localObject);
      }
      this.mBackground = ((Bitmap)paramNotification.getParcelable("background"));
      this.mContentIcon = paramNotification.getInt("contentIcon");
      this.mContentIconGravity = paramNotification.getInt("contentIconGravity", 8388613);
      this.mContentActionIndex = paramNotification.getInt("contentActionIndex", -1);
      this.mCustomSizePreset = paramNotification.getInt("customSizePreset", 0);
      this.mCustomContentHeight = paramNotification.getInt("customContentHeight");
      this.mGravity = paramNotification.getInt("gravity", 80);
      this.mHintScreenTimeout = paramNotification.getInt("hintScreenTimeout");
      this.mDismissalId = paramNotification.getString("dismissalId");
      this.mBridgeTag = paramNotification.getString("bridgeTag");
    }
  }
  
  @RequiresApi(20)
  private static Notification.Action getActionFromActionCompat(NotificationCompat.Action paramAction)
  {
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    Object localObject;
    if (i >= 23)
    {
      localObject = paramAction.getIconCompat();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((IconCompat)localObject).toIcon();
      }
      localObject = new Notification.Action.Builder((Icon)localObject, paramAction.getTitle(), paramAction.getActionIntent());
    }
    else
    {
      localObject = paramAction.getIconCompat();
      if ((localObject != null) && (((IconCompat)localObject).getType() == 2)) {
        i = ((IconCompat)localObject).getResId();
      } else {
        i = 0;
      }
      localObject = new Notification.Action.Builder(i, paramAction.getTitle(), paramAction.getActionIntent());
    }
    Bundle localBundle;
    if (paramAction.getExtras() != null) {
      localBundle = new Bundle(paramAction.getExtras());
    } else {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
    if (Build.VERSION.SDK_INT >= 24) {
      ((Notification.Action.Builder)localObject).setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
    }
    ((Notification.Action.Builder)localObject).addExtras(localBundle);
    paramAction = paramAction.getRemoteInputs();
    if (paramAction != null)
    {
      paramAction = RemoteInput.fromCompat(paramAction);
      int k = paramAction.length;
      i = j;
      while (i < k)
      {
        ((Notification.Action.Builder)localObject).addRemoteInput(paramAction[i]);
        i += 1;
      }
    }
    return ((Notification.Action.Builder)localObject).build();
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlags = (paramInt | this.mFlags);
      return;
    }
    this.mFlags = ((paramInt ^ 0xFFFFFFFF) & this.mFlags);
  }
  
  public WearableExtender addAction(NotificationCompat.Action paramAction)
  {
    this.mActions.add(paramAction);
    return this;
  }
  
  public WearableExtender addActions(List<NotificationCompat.Action> paramList)
  {
    this.mActions.addAll(paramList);
    return this;
  }
  
  @Deprecated
  public WearableExtender addPage(Notification paramNotification)
  {
    this.mPages.add(paramNotification);
    return this;
  }
  
  @Deprecated
  public WearableExtender addPages(List<Notification> paramList)
  {
    this.mPages.addAll(paramList);
    return this;
  }
  
  public WearableExtender clearActions()
  {
    this.mActions.clear();
    return this;
  }
  
  @Deprecated
  public WearableExtender clearPages()
  {
    this.mPages.clear();
    return this;
  }
  
  public WearableExtender clone()
  {
    WearableExtender localWearableExtender = new WearableExtender();
    localWearableExtender.mActions = new ArrayList(this.mActions);
    localWearableExtender.mFlags = this.mFlags;
    localWearableExtender.mDisplayIntent = this.mDisplayIntent;
    localWearableExtender.mPages = new ArrayList(this.mPages);
    localWearableExtender.mBackground = this.mBackground;
    localWearableExtender.mContentIcon = this.mContentIcon;
    localWearableExtender.mContentIconGravity = this.mContentIconGravity;
    localWearableExtender.mContentActionIndex = this.mContentActionIndex;
    localWearableExtender.mCustomSizePreset = this.mCustomSizePreset;
    localWearableExtender.mCustomContentHeight = this.mCustomContentHeight;
    localWearableExtender.mGravity = this.mGravity;
    localWearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
    localWearableExtender.mDismissalId = this.mDismissalId;
    localWearableExtender.mBridgeTag = this.mBridgeTag;
    return localWearableExtender;
  }
  
  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    Bundle localBundle = new Bundle();
    if (!this.mActions.isEmpty()) {
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject = new ArrayList(this.mActions.size());
        Iterator localIterator = this.mActions.iterator();
        while (localIterator.hasNext())
        {
          NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
          if (Build.VERSION.SDK_INT >= 20) {
            ((ArrayList)localObject).add(getActionFromActionCompat(localAction));
          } else if (Build.VERSION.SDK_INT >= 16) {
            ((ArrayList)localObject).add(NotificationCompatJellybean.getBundleForAction(localAction));
          }
        }
        localBundle.putParcelableArrayList("actions", (ArrayList)localObject);
      }
      else
      {
        localBundle.putParcelableArrayList("actions", null);
      }
    }
    int i = this.mFlags;
    if (i != 1) {
      localBundle.putInt("flags", i);
    }
    Object localObject = this.mDisplayIntent;
    if (localObject != null) {
      localBundle.putParcelable("displayIntent", (Parcelable)localObject);
    }
    if (!this.mPages.isEmpty())
    {
      localObject = this.mPages;
      localBundle.putParcelableArray("pages", (Parcelable[])((ArrayList)localObject).toArray(new Notification[((ArrayList)localObject).size()]));
    }
    localObject = this.mBackground;
    if (localObject != null) {
      localBundle.putParcelable("background", (Parcelable)localObject);
    }
    i = this.mContentIcon;
    if (i != 0) {
      localBundle.putInt("contentIcon", i);
    }
    i = this.mContentIconGravity;
    if (i != 8388613) {
      localBundle.putInt("contentIconGravity", i);
    }
    i = this.mContentActionIndex;
    if (i != -1) {
      localBundle.putInt("contentActionIndex", i);
    }
    i = this.mCustomSizePreset;
    if (i != 0) {
      localBundle.putInt("customSizePreset", i);
    }
    i = this.mCustomContentHeight;
    if (i != 0) {
      localBundle.putInt("customContentHeight", i);
    }
    i = this.mGravity;
    if (i != 80) {
      localBundle.putInt("gravity", i);
    }
    i = this.mHintScreenTimeout;
    if (i != 0) {
      localBundle.putInt("hintScreenTimeout", i);
    }
    localObject = this.mDismissalId;
    if (localObject != null) {
      localBundle.putString("dismissalId", (String)localObject);
    }
    localObject = this.mBridgeTag;
    if (localObject != null) {
      localBundle.putString("bridgeTag", (String)localObject);
    }
    paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
    return paramBuilder;
  }
  
  public List<NotificationCompat.Action> getActions()
  {
    return this.mActions;
  }
  
  @Deprecated
  public Bitmap getBackground()
  {
    return this.mBackground;
  }
  
  public String getBridgeTag()
  {
    return this.mBridgeTag;
  }
  
  public int getContentAction()
  {
    return this.mContentActionIndex;
  }
  
  @Deprecated
  public int getContentIcon()
  {
    return this.mContentIcon;
  }
  
  @Deprecated
  public int getContentIconGravity()
  {
    return this.mContentIconGravity;
  }
  
  public boolean getContentIntentAvailableOffline()
  {
    return (this.mFlags & 0x1) != 0;
  }
  
  @Deprecated
  public int getCustomContentHeight()
  {
    return this.mCustomContentHeight;
  }
  
  @Deprecated
  public int getCustomSizePreset()
  {
    return this.mCustomSizePreset;
  }
  
  public String getDismissalId()
  {
    return this.mDismissalId;
  }
  
  @Deprecated
  public PendingIntent getDisplayIntent()
  {
    return this.mDisplayIntent;
  }
  
  @Deprecated
  public int getGravity()
  {
    return this.mGravity;
  }
  
  @Deprecated
  public boolean getHintAmbientBigPicture()
  {
    return (this.mFlags & 0x20) != 0;
  }
  
  @Deprecated
  public boolean getHintAvoidBackgroundClipping()
  {
    return (this.mFlags & 0x10) != 0;
  }
  
  public boolean getHintContentIntentLaunchesActivity()
  {
    return (this.mFlags & 0x40) != 0;
  }
  
  @Deprecated
  public boolean getHintHideIcon()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  @Deprecated
  public int getHintScreenTimeout()
  {
    return this.mHintScreenTimeout;
  }
  
  @Deprecated
  public boolean getHintShowBackgroundOnly()
  {
    return (this.mFlags & 0x4) != 0;
  }
  
  @Deprecated
  public List<Notification> getPages()
  {
    return this.mPages;
  }
  
  public boolean getStartScrollBottom()
  {
    return (this.mFlags & 0x8) != 0;
  }
  
  @Deprecated
  public WearableExtender setBackground(Bitmap paramBitmap)
  {
    this.mBackground = paramBitmap;
    return this;
  }
  
  public WearableExtender setBridgeTag(String paramString)
  {
    this.mBridgeTag = paramString;
    return this;
  }
  
  public WearableExtender setContentAction(int paramInt)
  {
    this.mContentActionIndex = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setContentIcon(int paramInt)
  {
    this.mContentIcon = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setContentIconGravity(int paramInt)
  {
    this.mContentIconGravity = paramInt;
    return this;
  }
  
  public WearableExtender setContentIntentAvailableOffline(boolean paramBoolean)
  {
    setFlag(1, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setCustomContentHeight(int paramInt)
  {
    this.mCustomContentHeight = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setCustomSizePreset(int paramInt)
  {
    this.mCustomSizePreset = paramInt;
    return this;
  }
  
  public WearableExtender setDismissalId(String paramString)
  {
    this.mDismissalId = paramString;
    return this;
  }
  
  @Deprecated
  public WearableExtender setDisplayIntent(PendingIntent paramPendingIntent)
  {
    this.mDisplayIntent = paramPendingIntent;
    return this;
  }
  
  @Deprecated
  public WearableExtender setGravity(int paramInt)
  {
    this.mGravity = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintAmbientBigPicture(boolean paramBoolean)
  {
    setFlag(32, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintAvoidBackgroundClipping(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintContentIntentLaunchesActivity(boolean paramBoolean)
  {
    setFlag(64, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintHideIcon(boolean paramBoolean)
  {
    setFlag(2, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintScreenTimeout(int paramInt)
  {
    this.mHintScreenTimeout = paramInt;
    return this;
  }
  
  @Deprecated
  public WearableExtender setHintShowBackgroundOnly(boolean paramBoolean)
  {
    setFlag(4, paramBoolean);
    return this;
  }
  
  public WearableExtender setStartScrollBottom(boolean paramBoolean)
  {
    setFlag(8, paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.WearableExtender
 * JD-Core Version:    0.7.0.1
 */