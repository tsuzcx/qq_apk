package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class NotificationCompat$Action$Builder
{
  private boolean mAllowGeneratedReplies = true;
  private final Bundle mExtras;
  private final IconCompat mIcon;
  private final PendingIntent mIntent;
  private boolean mIsContextual;
  private ArrayList<RemoteInput> mRemoteInputs;
  private int mSemanticAction;
  private boolean mShowsUserInterface = true;
  private final CharSequence mTitle;
  
  public NotificationCompat$Action$Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent) {}
  
  public NotificationCompat$Action$Builder(NotificationCompat.Action paramAction)
  {
    this(paramAction.getIconCompat(), paramAction.title, paramAction.actionIntent, new Bundle(paramAction.mExtras), paramAction.getRemoteInputs(), paramAction.getAllowGeneratedReplies(), paramAction.getSemanticAction(), paramAction.mShowsUserInterface, paramAction.isContextual());
  }
  
  public NotificationCompat$Action$Builder(@Nullable IconCompat paramIconCompat, @Nullable CharSequence paramCharSequence, @Nullable PendingIntent paramPendingIntent)
  {
    this(paramIconCompat, paramCharSequence, paramPendingIntent, new Bundle(), null, true, 0, true, false);
  }
  
  private NotificationCompat$Action$Builder(@Nullable IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mIcon = paramIconCompat;
    this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mIntent = paramPendingIntent;
    this.mExtras = paramBundle;
    if (paramArrayOfRemoteInput == null) {}
    for (paramIconCompat = null;; paramIconCompat = new ArrayList(Arrays.asList(paramArrayOfRemoteInput)))
    {
      this.mRemoteInputs = paramIconCompat;
      this.mAllowGeneratedReplies = paramBoolean1;
      this.mSemanticAction = paramInt;
      this.mShowsUserInterface = paramBoolean2;
      this.mIsContextual = paramBoolean3;
      return;
    }
  }
  
  private void checkContextualActionNullFields()
  {
    if (!this.mIsContextual) {}
    while (this.mIntent != null) {
      return;
    }
    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
  }
  
  public Builder addExtras(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.mExtras.putAll(paramBundle);
    }
    return this;
  }
  
  public Builder addRemoteInput(RemoteInput paramRemoteInput)
  {
    if (this.mRemoteInputs == null) {
      this.mRemoteInputs = new ArrayList();
    }
    this.mRemoteInputs.add(paramRemoteInput);
    return this;
  }
  
  public NotificationCompat.Action build()
  {
    checkContextualActionNullFields();
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (this.mRemoteInputs != null)
    {
      Iterator localIterator = this.mRemoteInputs.iterator();
      while (localIterator.hasNext())
      {
        RemoteInput localRemoteInput = (RemoteInput)localIterator.next();
        if (localRemoteInput.isDataOnly()) {
          ((List)localObject1).add(localRemoteInput);
        } else {
          ((List)localObject2).add(localRemoteInput);
        }
      }
    }
    if (((List)localObject1).isEmpty())
    {
      localObject1 = null;
      if (!((List)localObject2).isEmpty()) {
        break label173;
      }
    }
    label173:
    for (localObject2 = null;; localObject2 = (RemoteInput[])((List)localObject2).toArray(new RemoteInput[((List)localObject2).size()]))
    {
      return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, (RemoteInput[])localObject2, (RemoteInput[])localObject1, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
      localObject1 = (RemoteInput[])((List)localObject1).toArray(new RemoteInput[((List)localObject1).size()]);
      break;
    }
  }
  
  public Builder extend(NotificationCompat.Action.Extender paramExtender)
  {
    paramExtender.extend(this);
    return this;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public Builder setAllowGeneratedReplies(boolean paramBoolean)
  {
    this.mAllowGeneratedReplies = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setContextual(boolean paramBoolean)
  {
    this.mIsContextual = paramBoolean;
    return this;
  }
  
  public Builder setSemanticAction(int paramInt)
  {
    this.mSemanticAction = paramInt;
    return this;
  }
  
  public Builder setShowsUserInterface(boolean paramBoolean)
  {
    this.mShowsUserInterface = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.Action.Builder
 * JD-Core Version:    0.7.0.1
 */