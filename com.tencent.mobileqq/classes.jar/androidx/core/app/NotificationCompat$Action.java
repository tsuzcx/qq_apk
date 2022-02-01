package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;

public class NotificationCompat$Action
{
  static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
  static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
  public static final int SEMANTIC_ACTION_ARCHIVE = 5;
  public static final int SEMANTIC_ACTION_CALL = 10;
  public static final int SEMANTIC_ACTION_DELETE = 4;
  public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
  public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
  public static final int SEMANTIC_ACTION_MUTE = 6;
  public static final int SEMANTIC_ACTION_NONE = 0;
  public static final int SEMANTIC_ACTION_REPLY = 1;
  public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
  public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
  public static final int SEMANTIC_ACTION_UNMUTE = 7;
  public PendingIntent actionIntent;
  @Deprecated
  public int icon;
  private boolean mAllowGeneratedReplies;
  private final RemoteInput[] mDataOnlyRemoteInputs;
  final Bundle mExtras;
  @Nullable
  private IconCompat mIcon;
  private final boolean mIsContextual;
  private final RemoteInput[] mRemoteInputs;
  private final int mSemanticAction;
  boolean mShowsUserInterface = true;
  public CharSequence title;
  
  public NotificationCompat$Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(localIconCompat, paramCharSequence, paramPendingIntent);
  }
  
  NotificationCompat$Action(int paramInt1, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(localIconCompat, paramCharSequence, paramPendingIntent, paramBundle, paramArrayOfRemoteInput1, paramArrayOfRemoteInput2, paramBoolean1, paramInt2, paramBoolean2, paramBoolean3);
  }
  
  public NotificationCompat$Action(@Nullable IconCompat paramIconCompat, @Nullable CharSequence paramCharSequence, @Nullable PendingIntent paramPendingIntent)
  {
    this(paramIconCompat, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true, false);
  }
  
  NotificationCompat$Action(@Nullable IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mIcon = paramIconCompat;
    if ((paramIconCompat != null) && (paramIconCompat.getType() == 2)) {
      this.icon = paramIconCompat.getResId();
    }
    this.title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.actionIntent = paramPendingIntent;
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    this.mExtras = paramBundle;
    this.mRemoteInputs = paramArrayOfRemoteInput1;
    this.mDataOnlyRemoteInputs = paramArrayOfRemoteInput2;
    this.mAllowGeneratedReplies = paramBoolean1;
    this.mSemanticAction = paramInt;
    this.mShowsUserInterface = paramBoolean2;
    this.mIsContextual = paramBoolean3;
  }
  
  public PendingIntent getActionIntent()
  {
    return this.actionIntent;
  }
  
  public boolean getAllowGeneratedReplies()
  {
    return this.mAllowGeneratedReplies;
  }
  
  public RemoteInput[] getDataOnlyRemoteInputs()
  {
    return this.mDataOnlyRemoteInputs;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  @Deprecated
  public int getIcon()
  {
    return this.icon;
  }
  
  @Nullable
  public IconCompat getIconCompat()
  {
    if (this.mIcon == null)
    {
      int i = this.icon;
      if (i != 0) {
        this.mIcon = IconCompat.createWithResource(null, "", i);
      }
    }
    return this.mIcon;
  }
  
  public RemoteInput[] getRemoteInputs()
  {
    return this.mRemoteInputs;
  }
  
  public int getSemanticAction()
  {
    return this.mSemanticAction;
  }
  
  public boolean getShowsUserInterface()
  {
    return this.mShowsUserInterface;
  }
  
  public CharSequence getTitle()
  {
    return this.title;
  }
  
  public boolean isContextual()
  {
    return this.mIsContextual;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.Action
 * JD-Core Version:    0.7.0.1
 */