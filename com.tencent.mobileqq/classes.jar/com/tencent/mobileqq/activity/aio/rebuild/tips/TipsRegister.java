package com.tencent.mobileqq.activity.aio.rebuild.tips;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.activity.aio.coreui.tips.IMsgTipsListener;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

public class TipsRegister
{
  private final AIOContext a;
  private volatile List<IMsgTipsFilter> b;
  private volatile List<IMsgTipsListener> c;
  
  public TipsRegister(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  private void c()
  {
    try
    {
      if (this.b == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new FoldMsgTipsFilter());
        localArrayList.add(new MediaMsgTipsFilter());
        localArrayList.add(new KandianMsgTipsFilter());
        localArrayList.add(new NearbyTipsFilter());
        localArrayList.add(new ConfessTipsFilter());
        localArrayList.add(new GameMsgTipsFilter());
        localArrayList.add(new TroopMsgTipsFilter());
        localArrayList.add(new SpecialCareTipsFilter());
        localArrayList.add(new WeiShiTipsFilter());
        localArrayList.add(new TempMsgBoxTipsFilter());
        localArrayList.add(new CMRTipsFilter());
        localArrayList.add(new SubAccountTipsFilter());
        if (this.a.O().a == 1008) {
          localArrayList.add(new PATipsFilter());
        }
        localArrayList.add(this.a.a(24));
        localArrayList.add(this.a.a(39));
        localArrayList.add(new WatchTogetherTipsFilter());
        localArrayList.add((IMsgTipsFilter)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildMsgTipsFilter());
        this.b = localArrayList;
      }
      return;
    }
    finally {}
  }
  
  private void d()
  {
    try
    {
      if (this.c == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new SpecialCareTipsFilter());
        if (this.a.H()) {
          localArrayList.add(this.a.a(109));
        }
        localArrayList.add(this.a.a(115));
        this.c = localArrayList;
      }
      return;
    }
    finally {}
  }
  
  public List<IMsgTipsFilter> a()
  {
    if (this.b == null) {
      c();
    }
    return this.b;
  }
  
  public List<IMsgTipsListener> b()
  {
    if (this.c == null) {
      d();
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.TipsRegister
 * JD-Core Version:    0.7.0.1
 */