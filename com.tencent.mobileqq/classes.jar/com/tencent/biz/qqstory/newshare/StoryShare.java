package com.tencent.biz.qqstory.newshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.newshare.callback.OnPrepareShareListener;
import com.tencent.biz.qqstory.newshare.callback.OnShareListener;
import com.tencent.biz.qqstory.newshare.callback.StoryShareCallback;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.newshare.ui.ActionSheetShareUI;
import com.tencent.biz.qqstory.newshare.ui.OnShareUIListener;
import com.tencent.biz.qqstory.newshare.ui.ShareUI;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import java.util.List;
import java.util.Map;

public class StoryShare
  implements OnShareUIListener
{
  private ShareUI a;
  private ShareModeBase b;
  private OnShareListener c;
  private OnShareUIListener d;
  private final StoryShareCallback e = new StoryShare.1(this);
  private OnPrepareShareListener f = new StoryShare.2(this);
  
  public StoryShare() {}
  
  private StoryShare(@NonNull Activity paramActivity)
  {
    this.a = new ActionSheetShareUI(paramActivity);
  }
  
  public static StoryShare a(@NonNull Activity paramActivity)
  {
    return new StoryShare(paramActivity);
  }
  
  public static StoryShare a(@NonNull Activity paramActivity, ShareUI paramShareUI)
  {
    return new StoryShare().a(paramShareUI);
  }
  
  public StoryShare a()
  {
    if (this.a.g() == null) {
      return this;
    }
    this.a.c = false;
    return this;
  }
  
  public StoryShare a(int paramInt)
  {
    Activity localActivity = this.a.g();
    if (localActivity == null) {
      return this;
    }
    this.a.b = localActivity.getString(paramInt);
    return this;
  }
  
  public StoryShare a(OnShareListener paramOnShareListener)
  {
    this.c = paramOnShareListener;
    return this;
  }
  
  public StoryShare a(@NonNull ShareModeBase paramShareModeBase)
  {
    this.b = paramShareModeBase;
    this.b.a(this.a.g());
    this.b.q = this.f;
    this.d = new StoryShare.3(this);
    return this;
  }
  
  public StoryShare a(ShareUI paramShareUI)
  {
    this.a = paramShareUI;
    return this;
  }
  
  public StoryShare a(@NonNull String paramString)
  {
    this.a.b = paramString;
    return this;
  }
  
  public StoryShare a(String paramString1, String paramString2)
  {
    ShareModeBase localShareModeBase = this.b;
    if (localShareModeBase != null)
    {
      localShareModeBase.u.put(paramString1, paramString2);
      return this;
    }
    throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
  }
  
  public StoryShare a(@NonNull List<int[]> paramList)
  {
    this.a.d = paramList;
    return this;
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Activity localActivity;
    if (paramInt1 == 29782)
    {
      localActivity = this.a.g();
      if ((paramInt2 != -1) || (localActivity == null)) {}
    }
    try
    {
      TroopShareUtility.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
      if (this.c != null) {
        this.c.b(1);
      }
      if (this.c == null) {
        break label144;
      }
      this.c.d();
      return true;
    }
    catch (Exception paramIntent)
    {
      label80:
      break label80;
    }
    paramIntent = this.c;
    if (paramIntent != null) {
      paramIntent.c(1);
    }
    paramIntent = this.c;
    if (paramIntent != null)
    {
      paramIntent.d();
      return true;
      paramIntent = this.c;
      if (paramIntent != null) {
        paramIntent.d(1);
      }
      paramIntent = this.c;
      if (paramIntent != null) {
        paramIntent.d();
      }
    }
    label144:
    return true;
    return false;
  }
  
  public StoryShare b()
  {
    SLog.a("StoryShare", "show(): %s", toString());
    if (this.b == null)
    {
      localOnShareListener = this.c;
      if (localOnShareListener != null) {
        localOnShareListener.c(0);
      }
      return this;
    }
    this.a.a(this.d);
    OnShareListener localOnShareListener = this.c;
    if (localOnShareListener != null) {
      localOnShareListener.a();
    }
    this.a.d();
    localOnShareListener = this.c;
    if (localOnShareListener != null) {
      localOnShareListener.b();
    }
    return this;
  }
  
  public void b(int paramInt) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.StoryShare
 * JD-Core Version:    0.7.0.1
 */