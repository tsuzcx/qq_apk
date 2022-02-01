package androidx.core.app;

import android.app.Notification.Builder;
import android.app.Notification.DecoratedCustomViewStyle;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat$DecoratedCustomViewStyle
  extends NotificationCompat.Style
{
  private static final int MAX_ACTION_BUTTONS = 3;
  
  private RemoteViews createRemoteViews(RemoteViews paramRemoteViews, boolean paramBoolean)
  {
    RemoteViews localRemoteViews = applyStandardTemplate(true, 2131559558, false);
    localRemoteViews.removeAllViews(2131361989);
    List localList = getNonContextualActions(this.mBuilder.mActions);
    if ((paramBoolean) && (localList != null))
    {
      int j = Math.min(localList.size(), 3);
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          localRemoteViews.addView(2131361989, generateActionButton((NotificationCompat.Action)localList.get(i)));
          i += 1;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      for (i = 0;; i = 8)
      {
        localRemoteViews.setViewVisibility(2131361989, i);
        localRemoteViews.setViewVisibility(2131361953, i);
        buildIntoRemoteViews(localRemoteViews, paramRemoteViews);
        return localRemoteViews;
      }
    }
  }
  
  private RemoteViews generateActionButton(NotificationCompat.Action paramAction)
  {
    int i;
    Object localObject;
    if (paramAction.actionIntent == null)
    {
      i = 1;
      localObject = this.mBuilder.mContext.getPackageName();
      if (i == 0) {
        break label123;
      }
    }
    label123:
    for (int j = 2131559555;; j = 2131559554)
    {
      localObject = new RemoteViews((String)localObject, j);
      ((RemoteViews)localObject).setImageViewBitmap(2131361957, createColoredBitmap(paramAction.getIconCompat(), this.mBuilder.mContext.getResources().getColor(2131165889)));
      ((RemoteViews)localObject).setTextViewText(2131361988, paramAction.title);
      if (i == 0) {
        ((RemoteViews)localObject).setOnClickPendingIntent(2131361951, paramAction.actionIntent);
      }
      if (Build.VERSION.SDK_INT >= 15) {
        ((RemoteViews)localObject).setContentDescription(2131361951, paramAction.title);
      }
      return localObject;
      i = 0;
      break;
    }
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
    if (Build.VERSION.SDK_INT >= 24) {}
    for (;;)
    {
      return null;
      paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView();
      if (paramNotificationBuilderWithBuilderAccessor != null) {}
      while (paramNotificationBuilderWithBuilderAccessor != null)
      {
        return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
        paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    while (this.mBuilder.getContentView() == null) {
      return null;
    }
    return createRemoteViews(this.mBuilder.getContentView(), false);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (;;)
    {
      return null;
      RemoteViews localRemoteViews = this.mBuilder.getHeadsUpContentView();
      if (localRemoteViews != null) {}
      for (paramNotificationBuilderWithBuilderAccessor = localRemoteViews; localRemoteViews != null; paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView()) {
        return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.DecoratedCustomViewStyle
 * JD-Core Version:    0.7.0.1
 */