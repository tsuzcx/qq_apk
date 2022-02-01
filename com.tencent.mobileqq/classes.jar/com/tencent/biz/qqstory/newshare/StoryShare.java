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
  private OnPrepareShareListener jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener = new StoryShare.2(this);
  private OnShareListener jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener;
  private final StoryShareCallback jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackStoryShareCallback = new StoryShare.1(this);
  private ShareModeBase jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase;
  private OnShareUIListener jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener;
  private ShareUI jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI;
  
  public StoryShare() {}
  
  private StoryShare(@NonNull Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI = new ActionSheetShareUI(paramActivity);
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.a() == null) {
      return this;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public StoryShare a(int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.a();
    if (localActivity == null) {
      return this;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.jdField_a_of_type_JavaLangString = localActivity.getString(paramInt);
    return this;
  }
  
  public StoryShare a(OnShareListener paramOnShareListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener = paramOnShareListener;
    return this;
  }
  
  public StoryShare a(@NonNull ShareModeBase paramShareModeBase)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase = paramShareModeBase;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.a());
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener = this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnPrepareShareListener;
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener = new StoryShare.3(this);
    return this;
  }
  
  public StoryShare a(ShareUI paramShareUI)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI = paramShareUI;
    return this;
  }
  
  public StoryShare a(@NonNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public StoryShare a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase == null) {
      throw new IllegalStateException("Error: mShareMode is null! StoryShare should init mode() first!");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase.b.put(paramString1, paramString2);
    return this;
  }
  
  public StoryShare a(@NonNull List<int[]> paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 29782)
    {
      Activity localActivity = this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.a();
      if ((paramInt2 == -1) && (localActivity != null)) {}
      for (;;)
      {
        try
        {
          TroopShareUtility.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Activity)localActivity, paramInt2, paramIntent);
          if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.a(1);
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.a();
          }
        }
        catch (Exception paramIntent)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.c(1);
          if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.a();
          continue;
        }
        return true;
        if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.d(1);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.a();
        }
      }
    }
    return false;
  }
  
  public StoryShare b()
  {
    SLog.a("StoryShare", "show(): %s", toString());
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareModeBaseShareModeBase == null) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.c(0);
      }
    }
    do
    {
      return this;
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener);
      if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.b();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiShareUI.d();
    } while (this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackOnShareListener.c();
    return this;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.StoryShare
 * JD-Core Version:    0.7.0.1
 */