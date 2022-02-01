package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.anim.EggReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.IRefreshCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.IReloadFilter;
import com.tencent.mobileqq.dating.NearbyMsgBoxReadConfirmCallback;
import com.tencent.mobileqq.dating.NearbyMsgBoxSendCallback;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.nearby.api.IHotChatReadConfirmCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tofumsg.TofuMsgUpdateCallback;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;

public class MsgListRegister
{
  private final AIOContext a;
  private List<IMsgLoader> b;
  private SparseArray<IHeadMsgRefresher> c;
  private List<IReadConfirmCallback> d;
  private List<IReloadFilter> e;
  private List<IRefreshCallback> f;
  private List<IMsgUpdateCallback> g;
  private List<AbsListView.OnScrollListener> h;
  
  public MsgListRegister(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  private void g()
  {
    this.b = new ArrayList();
    if ((this.a instanceof TroopAIOContext)) {
      this.b.add(new OneClickJumpMsgFilter());
    } else if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(this.a)) {
      this.b.add(new GuildOneClickJumpMsgFilter());
    }
    this.b.add(new CustomizeGrayTipsMsgFilter());
  }
  
  private void h()
  {
    this.c = new SparseArray();
    this.c.append(1, new UnreadHeadMsgRefresher());
    Object localObject = new DefaultHeadMsgRefresher();
    this.c.append(23, localObject);
    this.c.append(14, localObject);
    this.c.append(6, localObject);
    this.c.append(21, localObject);
    this.c.append(4, localObject);
    this.c.append(3, localObject);
    this.c.append(26, localObject);
    this.c.append(18, localObject);
    this.c.append(19, localObject);
    this.c.append(5, localObject);
    this.c.append(20, localObject);
    this.c.append(13, localObject);
    this.c.append(101, localObject);
    this.c.append(102, localObject);
    this.c.append(22, new ReplyHeadMsgRefresher());
    localObject = new AttentionHeadMsgRefresher();
    this.c.append(17, localObject);
    this.c.append(10, localObject);
    this.c.append(100, localObject);
    this.c.append(11, localObject);
    this.c.append(103, new EssenceHeadMsgRefresher());
    this.c.append(104, new TodoHeadMsgRefresher());
  }
  
  private void i()
  {
    try
    {
      if (this.d == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new GrayTipsReadConfirmCallback());
        localArrayList.add(new FlashChatReadConfirmCallback());
        localArrayList.add(new EggReadConfirmCallback());
        localArrayList.add(new PokeReadConfirmCallback());
        localArrayList.add((IReadConfirmCallback)((IHotChatReadConfirmCallback)QRoute.api(IHotChatReadConfirmCallback.class)).get());
        localArrayList.add(new NearbyMsgBoxReadConfirmCallback());
        this.d = localArrayList;
      }
      return;
    }
    finally {}
  }
  
  private void j()
  {
    this.e = new ArrayList();
    this.e.add(new StickerReloadFilter());
    this.e.add(new MarketFaceReloadFilter());
    if (this.a.O().a == 1) {
      this.e.add(new TroopBindPAReloadFilter());
    }
    this.e.add(new PokeReloadFilter());
    this.e.add(new JubaoReloadFilter());
  }
  
  private void k()
  {
    this.f = new ArrayList();
    this.f.add((IRefreshCallback)this.a.a(65));
    this.f.add(new ScribbleRefreshCallback());
  }
  
  private void l()
  {
    try
    {
      if (this.g == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new DtReportMsgUpdateCallback());
        localArrayList.add(new ApolloUpdateCallback());
        localArrayList.add(new ReactiveMsgUpdateCallback());
        localArrayList.add(new TroopGiftMsgUpdateCallback());
        localArrayList.add(this.a.a(65));
        localArrayList.add(this.a.a(67));
        localArrayList.add(new FlashChatMsgUpdateCallback());
        localArrayList.add(new AppGuideTipsMsgUpdateCallback());
        localArrayList.add(new AIOSpreadMsgUpdateCallback());
        localArrayList.add(new ArkMsgUpdateCallback());
        localArrayList.add(new StickerMsgUpdateCallback());
        localArrayList.add(new StructMsgUpdateCallback());
        localArrayList.add(new DiscussMsgUpdateCallback());
        localArrayList.add(new NearbyMsgBoxSendCallback());
        localArrayList.add(new TofuMsgUpdateCallback());
        this.g = localArrayList;
      }
      return;
    }
    finally {}
  }
  
  private void m()
  {
    this.h = new ArrayList();
    this.h.add((AbsListView.OnScrollListener)this.a.a(121));
    this.h.add((AbsListView.OnScrollListener)this.a.a(18));
    this.h.add((AbsListView.OnScrollListener)this.a.a(110));
    this.h.add((AbsListView.OnScrollListener)this.a.a(133));
    this.h.add((AbsListView.OnScrollListener)this.a.a(102));
    AIOContext localAIOContext = this.a;
    if ((localAIOContext instanceof TroopAIOContext)) {
      this.h.add(localAIOContext.a(138));
    } else if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(this.a)) {
      this.h.add(this.a.a(150));
    }
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(this.a)) {
      this.h.add(this.a.a(151));
    }
  }
  
  public IHeadMsgRefresher a(int paramInt)
  {
    if (this.c == null) {
      h();
    }
    return (IHeadMsgRefresher)this.c.get(paramInt);
  }
  
  public List<IMsgLoader> a()
  {
    if (this.b == null) {
      g();
    }
    return this.b;
  }
  
  public List<IReadConfirmCallback> b()
  {
    if (this.d == null) {
      i();
    }
    return this.d;
  }
  
  public List<IReloadFilter> c()
  {
    if (this.e == null) {
      j();
    }
    return this.e;
  }
  
  public List<IRefreshCallback> d()
  {
    if (this.f == null) {
      k();
    }
    return this.f;
  }
  
  public List<IMsgUpdateCallback> e()
  {
    if (this.g == null) {
      l();
    }
    return this.g;
  }
  
  @NonNull
  public List<AbsListView.OnScrollListener> f()
  {
    if (this.h == null) {
      m();
    }
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister
 * JD-Core Version:    0.7.0.1
 */