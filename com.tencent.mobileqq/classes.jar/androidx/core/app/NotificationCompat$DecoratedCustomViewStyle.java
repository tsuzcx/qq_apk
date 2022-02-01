package androidx.core.app;

import android.app.Notification.Builder;
import android.app.Notification.DecoratedCustomViewStyle;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.R.color;
import androidx.core.R.id;
import androidx.core.R.layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat$DecoratedCustomViewStyle
  extends NotificationCompat.Style
{
  private static final int MAX_ACTION_BUTTONS = 3;
  
  private RemoteViews createRemoteViews(RemoteViews paramRemoteViews, boolean paramBoolean)
  {
    int i = R.layout.notification_template_custom_big;
    int m = 1;
    int k = 0;
    RemoteViews localRemoteViews1 = applyStandardTemplate(true, i, false);
    localRemoteViews1.removeAllViews(R.id.actions);
    List localList = getNonContextualActions(this.mBuilder.mActions);
    if ((paramBoolean) && (localList != null))
    {
      int n = Math.min(localList.size(), 3);
      if (n > 0)
      {
        i = 0;
        for (;;)
        {
          j = m;
          if (i >= n) {
            break;
          }
          RemoteViews localRemoteViews2 = generateActionButton((NotificationCompat.Action)localList.get(i));
          localRemoteViews1.addView(R.id.actions, localRemoteViews2);
          i += 1;
        }
      }
    }
    int j = 0;
    if (j != 0) {
      i = k;
    } else {
      i = 8;
    }
    localRemoteViews1.setViewVisibility(R.id.actions, i);
    localRemoteViews1.setViewVisibility(R.id.action_divider, i);
    buildIntoRemoteViews(localRemoteViews1, paramRemoteViews);
    return localRemoteViews1;
  }
  
  private RemoteViews generateActionButton(NotificationCompat.Action paramAction)
  {
    int i;
    if (paramAction.actionIntent == null) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = this.mBuilder.mContext.getPackageName();
    int j;
    if (i != 0) {
      j = R.layout.notification_action_tombstone;
    } else {
      j = R.layout.notification_action;
    }
    localObject = new RemoteViews((String)localObject, j);
    ((RemoteViews)localObject).setImageViewBitmap(R.id.action_image, createColoredBitmap(paramAction.getIconCompat(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
    ((RemoteViews)localObject).setTextViewText(R.id.action_text, paramAction.title);
    if (i == 0) {
      ((RemoteViews)localObject).setOnClickPendingIntent(R.id.action_container, paramAction.actionIntent);
    }
    if (Build.VERSION.SDK_INT >= 15) {
      ((RemoteViews)localObject).setContentDescription(R.id.action_container, paramAction.title);
    }
    return localObject;
  }
  
  private static List<NotificationCompat.Action> getNonContextualActions(List<NotificationCompat.Action> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      NotificationCompat.Action localAction = (NotificationCompat.Action)paramList.next();
      if (!localAction.isContextual()) {
        localArrayList.add(localAction);
      }
    }
    return localArrayList;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView();
    if (paramNotificationBuilderWithBuilderAccessor == null) {
      paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
    }
    if (paramNotificationBuilderWithBuilderAccessor == null) {
      return null;
    }
    return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    if (this.mBuilder.getContentView() == null) {
      return null;
    }
    return createRemoteViews(this.mBuilder.getContentView(), false);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    RemoteViews localRemoteViews = this.mBuilder.getHeadsUpContentView();
    if (localRemoteViews != null) {
      paramNotificationBuilderWithBuilderAccessor = localRemoteViews;
    } else {
      paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
    }
    if (localRemoteViews == null) {
      return null;
    }
    return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.DecoratedCustomViewStyle
 * JD-Core Version:    0.7.0.1
 */