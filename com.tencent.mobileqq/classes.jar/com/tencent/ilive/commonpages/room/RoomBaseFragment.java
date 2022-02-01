package com.tencent.ilive.commonpages.room;

import android.content.Context;
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
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.RoomBootBizModules;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.Room;
import com.tencent.livesdk.liveengine.FloatRoomManager.RoomEventInterceptor;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Iterator;
import java.util.List;

public abstract class RoomBaseFragment
  extends LiveTemplateFragment
  implements FloatRoomManager.Room
{
  public static final String TAG = "RoomBaseFragment";
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
  
  public void destroyRoomAuto()
  {
    if (BizEngineMgr.getInstance().getLiveEngine() != null)
    {
      localObject = BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().b(this);
      if (localObject != null)
      {
        if (((FloatRoomManager.RoomEventInterceptor)localObject).b()) {
          return;
        }
        BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().a(null);
        BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().a(null);
      }
    }
    super.destroyRoomAuto();
    Object localObject = this.roomEngine;
    if (localObject != null)
    {
      ((RoomEngine)localObject).unint();
      this.roomEngine = null;
    }
  }
  
  public void destroyRoomByHand()
  {
    super.destroyRoomAuto();
    RoomEngine localRoomEngine = this.roomEngine;
    if (localRoomEngine != null)
    {
      localRoomEngine.unint();
      this.roomEngine = null;
    }
  }
  
  public abstract PageConfigInterface getPageUIConfig();
  
  public RoomEngine getRoomEngine()
  {
    return this.roomEngine;
  }
  
  public abstract void initBizContextRoomInfo();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
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
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
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
    paramLayoutInflater = this.roomBootBizModules;
    if (paramLayoutInflater == null)
    {
      if (getActivity() != null) {
        getActivity().finish();
      }
      paramLayoutInflater = null;
    }
    else
    {
      paramLayoutInflater.onCreateView();
      paramLayoutInflater = this.roomBootBizModules.getLayout();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    RoomBootBizModules localRoomBootBizModules = this.roomBootBizModules;
    if (localRoomBootBizModules != null) {
      localRoomBootBizModules.getLayout().removeAllViews();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void setRoomEngine(RoomEngine paramRoomEngine)
  {
    this.roomEngine = paramRoomEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.RoomBaseFragment
 * JD-Core Version:    0.7.0.1
 */