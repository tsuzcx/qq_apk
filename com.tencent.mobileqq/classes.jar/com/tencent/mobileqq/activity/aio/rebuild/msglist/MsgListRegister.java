package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.anim.EggReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.IRefreshCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.IReloadFilter;
import com.tencent.mobileqq.dating.NearbyMsgBoxReadConfirmCallback;
import com.tencent.mobileqq.dating.NearbyMsgBoxSendCallback;
import com.tencent.mobileqq.nearby.api.IHotChatReadConfirmCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tofumsg.TofuMsgUpdateCallback;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;

public class MsgListRegister
{
  private SparseArray<IHeadMsgRefresher> jdField_a_of_type_AndroidUtilSparseArray;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private List<IMsgLoader> jdField_a_of_type_JavaUtilList;
  private List<IReadConfirmCallback> b;
  private List<IReloadFilter> c;
  private List<IRefreshCallback> d;
  private List<IMsgUpdateCallback> e;
  private List<AbsListView.OnScrollListener> f;
  
  public MsgListRegister(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new CustomizeGrayTipsMsgFilter());
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseArray.append(1, new UnreadHeadMsgRefresher());
    Object localObject = new DefaultHeadMsgRefresher();
    this.jdField_a_of_type_AndroidUtilSparseArray.append(23, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(14, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(6, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(21, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(4, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(3, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(26, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(18, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(19, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(5, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(20, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(13, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(101, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(102, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(22, new ReplyHeadMsgRefresher());
    localObject = new AttentionHeadMsgRefresher();
    this.jdField_a_of_type_AndroidUtilSparseArray.append(17, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(10, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(100, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(11, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(103, new EssenceHeadMsgRefresher());
  }
  
  private void c()
  {
    try
    {
      if (this.b == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new GrayTipsReadConfirmCallback());
        localArrayList.add(new FlashChatReadConfirmCallback());
        localArrayList.add(new EggReadConfirmCallback());
        localArrayList.add(new PokeReadConfirmCallback());
        localArrayList.add((IReadConfirmCallback)((IHotChatReadConfirmCallback)QRoute.api(IHotChatReadConfirmCallback.class)).get());
        localArrayList.add(new NearbyMsgBoxReadConfirmCallback());
        this.b = localArrayList;
      }
      return;
    }
    finally {}
  }
  
  private void d()
  {
    this.c = new ArrayList();
    this.c.add(new StickerReloadFilter());
    this.c.add(new MarketFaceReloadFilter());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a == 1) {
      this.c.add(new TroopBindPAReloadFilter());
    }
    this.c.add(new PokeReloadFilter());
    this.c.add(new JubaoReloadFilter());
  }
  
  private void e()
  {
    this.d = new ArrayList();
    this.d.add((IRefreshCallback)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(65));
    this.d.add(new ScribbleRefreshCallback());
  }
  
  private void f()
  {
    try
    {
      if (this.e == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new DtReportMsgUpdateCallback());
        localArrayList.add(new ApolloUpdateCallback());
        localArrayList.add(new ReactiveMsgUpdateCallback());
        localArrayList.add(new TroopGiftMsgUpdateCallback());
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(65));
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(67));
        localArrayList.add(new FlashChatMsgUpdateCallback());
        localArrayList.add(new AppGuideTipsMsgUpdateCallback());
        localArrayList.add(new AIOSpreadMsgUpdateCallback());
        localArrayList.add(new ArkMsgUpdateCallback());
        localArrayList.add(new StickerMsgUpdateCallback());
        localArrayList.add(new StructMsgUpdateCallback());
        localArrayList.add(new DiscussMsgUpdateCallback());
        localArrayList.add(new NearbyMsgBoxSendCallback());
        localArrayList.add(new TofuMsgUpdateCallback());
        this.e = localArrayList;
      }
      return;
    }
    finally {}
  }
  
  private void g()
  {
    this.f = new ArrayList();
    this.f.add((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(121));
    this.f.add((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(18));
    this.f.add((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(110));
    this.f.add((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(133));
    this.f.add((AbsListView.OnScrollListener)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(102));
  }
  
  public IHeadMsgRefresher a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      b();
    }
    return (IHeadMsgRefresher)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public List<IMsgLoader> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<IReadConfirmCallback> b()
  {
    if (this.b == null) {
      c();
    }
    return this.b;
  }
  
  public List<IReloadFilter> c()
  {
    if (this.c == null) {
      d();
    }
    return this.c;
  }
  
  public List<IRefreshCallback> d()
  {
    if (this.d == null) {
      e();
    }
    return this.d;
  }
  
  public List<IMsgUpdateCallback> e()
  {
    if (this.e == null) {
      f();
    }
    return this.e;
  }
  
  @NonNull
  public List<AbsListView.OnScrollListener> f()
  {
    if (this.f == null) {
      g();
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister
 * JD-Core Version:    0.7.0.1
 */