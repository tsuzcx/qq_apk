package com.tencent.ilive.commonpages.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ilive.base.bizmodule.BizModuleContext;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.ilive.config.PageConfigInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.RoomBootBizModules;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;
import java.util.List;

public abstract class RoomBaseFragment
  extends LiveTemplateFragment
{
  protected RoomBizContext roomBizContext;
  protected RoomBootBizModules roomBootBizModules;
  protected RoomEngine roomEngine;
  
  public BizModuleContext createBizModuleContext()
  {
    this.roomBizContext = new RoomBizContext();
    initBizContextRoomInfo();
    return this.roomBizContext;
  }
  
  public BootBizModules createBootBizModules()
  {
    this.roomBootBizModules = createRooBootBizModules();
    return this.roomBootBizModules;
  }
  
  public void createBootBizModulesExtData()
  {
    this.roomBootBizModules.setRoomEngine(this.roomEngine);
  }
  
  public abstract RoomBootBizModules createRooBootBizModules();
  
  public abstract PageConfigInterface getPageUIConfig();
  
  public RoomEngine getRoomEngine()
  {
    return this.roomEngine;
  }
  
  public abstract void initBizContextRoomInfo();
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = getActivity().getSupportFragmentManager().getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment != this)) {
        localFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public boolean onBackPressed()
  {
    return super.onBackPressed();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (this.roomBootBizModules == null) {
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    for (paramLayoutInflater = null;; paramLayoutInflater = this.roomBootBizModules.getLayout())
    {
      AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.roomBootBizModules.onCreateView();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.roomBootBizModules = null;
    this.roomBizContext = null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.roomBootBizModules != null) {
      this.roomBootBizModules.getLayout().removeAllViews();
    }
  }
  
  public void setRoomEngine(RoomEngine paramRoomEngine)
  {
    this.roomEngine = paramRoomEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.RoomBaseFragment
 * JD-Core Version:    0.7.0.1
 */