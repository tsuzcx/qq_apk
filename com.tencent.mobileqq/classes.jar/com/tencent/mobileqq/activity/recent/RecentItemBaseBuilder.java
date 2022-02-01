package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.ThemeImageWrapper;
import java.util.List;

public abstract class RecentItemBaseBuilder
{
  public static final int[] c = { 2131888438, 2131888227, 2131888206, 2131888211, 2131888207, 2131888208, 2131891973, 2131890183, 2131890181, 2131888205, 2131888209, 2131888210 };
  public static final int[] d = { 2130839698, 2130839697, 2130839702, 2130839702, 2130839699, 2130839699, 2130839697, 2130839702, 2130839702, 2130839699, 2130839700, 2130839704 };
  public static final int[] e = { 2131438111, 2131438142, 2131438107, 2131438132, 2131438127, 2131438128, 2131438145, 2131438141, 2131438140, 2131438106, 2131438130, 2131438131 };
  protected RecentAdapter f;
  protected SwipRightMenuBuilder g;
  
  public int a()
  {
    return 1;
  }
  
  public abstract View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener);
  
  public final View a(Context paramContext, int paramInt, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    RecentAdapter localRecentAdapter = this.f;
    if ((localRecentAdapter != null) && (localRecentAdapter.a()))
    {
      if (this.g == null) {
        this.g = a(paramContext);
      }
      return this.g.createView(paramContext, localView, paramRecentItemBaseHolder, -1);
    }
    paramRecentItemBaseHolder.leftView = localView;
    paramRecentItemBaseHolder.rightMenuItems = null;
    return localView;
  }
  
  public SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299609);
    int j = paramContext.getResources().getDimensionPixelSize(2131299608);
    int k = a();
    paramContext = e;
    int[] arrayOfInt1 = c;
    int[] arrayOfInt2 = d;
    return new RecentItemBaseBuilder.RecentSwipeTextViewMenuBuilder(k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.g;
    int i;
    if (localSwipRightMenuBuilder != null)
    {
      SimpleModeHelper.a(localSwipRightMenuBuilder);
      i = this.g.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramRecentItemBaseHolder, paramOnClickListener);
    }
    else
    {
      i = 0;
    }
    int j = paramView.getScrollX();
    if (paramInt >= 0)
    {
      paramContext = this.f;
      if ((paramContext != null) && (paramContext.i == paramInt))
      {
        paramView.scrollTo(i, 0);
        break label88;
      }
    }
    if (j != 0) {
      paramView.scrollTo(0, 0);
    }
    label88:
    if ((j != 0) && (QLog.isDevelopLevel()))
    {
      paramContext = this.f;
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = Integer.valueOf(paramContext.i);
      }
      NearbyUtils.a("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
    }
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.g == null) {
        paramView.g = new ThemeImageWrapper();
      }
      paramView.g.setSupportMaskView(true);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.f = paramRecentAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder
 * JD-Core Version:    0.7.0.1
 */