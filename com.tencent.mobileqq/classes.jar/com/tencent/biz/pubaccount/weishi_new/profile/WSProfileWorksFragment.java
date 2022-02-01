package com.tencent.biz.pubaccount.weishi_new.profile;

import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSChangeItemViewVisibilityEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageEventHandler;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.BaseViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.RecyclerViewWithHeaderFooter;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.WSXGridSpacingItemDecoration;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.XRecyclerView;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import java.util.ArrayList;
import java.util.List;

public class WSProfileWorksFragment
  extends WSBaseFragment<WSProfileWorksContract.View, WSProfileWorksPresenter>
  implements WSSimpleEventReceiver, WSProfileWorksContract.View, OnTabSelectedListener
{
  private XRecyclerView f;
  private View g;
  private TextView h;
  private View i;
  private View j;
  private GridLayoutManager k;
  private WSProfileWorkAdapter l;
  private WSVerticalPageEventHandler m;
  private int n;
  private String o;
  private boolean p;
  private boolean q = true;
  private int r;
  private boolean s;
  private String t;
  private String u;
  
  private void C()
  {
    int i1 = this.n;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return;
      }
      if ((!x()) && (!this.q))
      {
        this.g.setVisibility(0);
        v();
        return;
      }
      b(true, true);
      return;
    }
    b(true, true);
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager)) {
        return ((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
      }
    }
    return -1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(View paramView)
  {
    this.f = ((XRecyclerView)paramView.findViewById(1929707574));
    this.f.setIsAutoScrolling(true);
    this.g = paramView.findViewById(1929707558);
    this.h = ((TextView)paramView.findViewById(1929707611));
    this.i = paramView.findViewById(1929707564);
    this.j = paramView.findViewById(1929707557);
    q();
  }
  
  private void a(@android.support.annotation.NonNull WSChangeItemViewVisibilityEvent paramWSChangeItemViewVisibilityEvent)
  {
    if (!this.p)
    {
      WSLog.e("WSProfileWorksFragment", "changeItemViewVisibility() page is not selected.");
      return;
    }
    if (this.l != null)
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        localObject = ((XRecyclerView)localObject).getRecyclerView();
        if (localObject == null) {
          return;
        }
        int i2 = 0;
        int i1 = 0;
        while (i1 < ((RecyclerView)localObject).getChildCount())
        {
          RecyclerView.ViewHolder localViewHolder = ((RecyclerView)localObject).getChildViewHolder(((RecyclerView)localObject).getChildAt(i1));
          if ((localViewHolder instanceof WSProfileWorkHolder))
          {
            stSimpleMetaFeed localstSimpleMetaFeed = ((WSProfileWorkHolder)localViewHolder).a();
            if ((localstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramWSChangeItemViewVisibilityEvent.getFeedId())) && (paramWSChangeItemViewVisibilityEvent.getFeedId().equals(localstSimpleMetaFeed.id)))
            {
              localObject = localViewHolder.itemView;
              if (paramWSChangeItemViewVisibilityEvent.isShow()) {
                i1 = i2;
              } else {
                i1 = 4;
              }
              ((View)localObject).setVisibility(i1);
              return;
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder)
  {
    paramBaseViewHolder.itemView.post(new WSProfileWorksFragment.4(this, paramBaseViewHolder));
  }
  
  private boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.l.c().size();
    int i1;
    if ((!paramBoolean1) && (!paramBoolean2)) {
      i1 = a(this.f.getRecyclerView());
    } else {
      i1 = i2;
    }
    return i2 - i1 <= paramInt;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList)
  {
    w();
    if (((paramBoolean2) || (paramBoolean1)) && (paramList.size() == 0))
    {
      this.g.setVisibility(0);
      v();
      return true;
    }
    this.g.setVisibility(8);
    return false;
  }
  
  public static WSProfileWorksFragment b(int paramInt, String paramString)
  {
    WSProfileWorksFragment localWSProfileWorksFragment = new WSProfileWorksFragment();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_page_type", paramInt);
    localBundle.putString("key_page_from", paramString);
    localIntent.putExtras(localBundle);
    localWSProfileWorksFragment.setArguments(localIntent.getExtras());
    return localWSProfileWorksFragment;
  }
  
  private List<stSimpleMetaFeed> b(int paramInt)
  {
    Object localObject = (WSVerticalItemData)this.l.b(Math.max(paramInt, 0));
    if (localObject == null) {
      return null;
    }
    localObject = ((WSVerticalItemData)localObject).b();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    return localArrayList;
  }
  
  private void q()
  {
    Object localObject = this.f.getLoadMoreLayoutHelper();
    if (localObject != null) {
      ((LoadingMoreHelper)localObject).setPreLoaderCount(18);
    }
    this.k = new GridLayoutManager(this.a, 3);
    this.l = new WSProfileWorkAdapter(this.a);
    this.f.setRefreshEnable(false);
    localObject = this.f.getRecyclerView();
    this.l.a(this.t);
    ((RecyclerViewWithHeaderFooter)localObject).setAdapter(this.l);
    this.l.a(new WSProfileWorksFragment.1(this));
    ((RecyclerViewWithHeaderFooter)localObject).setLayoutManager(this.k);
    ((RecyclerViewWithHeaderFooter)localObject).setItemAnimator(null);
    ((RecyclerViewWithHeaderFooter)localObject).addItemDecoration(new WSXGridSpacingItemDecoration(3, WeishiUIUtil.c));
    this.f.setRefreshCallback(new WSProfileWorksFragment.2(this));
    this.l.a(new WSProfileWorksFragment.3(this));
  }
  
  private void t()
  {
    View localView = View.inflate(getBaseActivity(), 2131626456, null);
    TextView localTextView = (TextView)localView.findViewById(2131436034);
    int i1 = this.r - this.l.c().size();
    if (i1 > 0) {
      localTextView.setText(getResources().getString(1929838635, new Object[] { Integer.valueOf(i1) }));
    } else {
      localTextView.setText(2131891055);
    }
    this.l.a(localView);
  }
  
  private void v()
  {
    Object localObject;
    if (b() == 1)
    {
      localObject = this.h;
      if (x()) {
        i1 = 1929838634;
      } else {
        i1 = 1929838638;
      }
      ((TextView)localObject).setText(i1);
      return;
    }
    boolean bool = this.q;
    int i1 = 1929838632;
    if (!bool)
    {
      if (x())
      {
        localObject = getResources();
      }
      else
      {
        localObject = getResources();
        i1 = 1929838633;
      }
      localObject = ((Resources)localObject).getString(i1);
    }
    else
    {
      if (x())
      {
        localObject = getResources();
      }
      else
      {
        localObject = getResources();
        i1 = 1929838637;
      }
      localObject = ((Resources)localObject).getString(i1);
    }
    this.h.setText((CharSequence)localObject);
  }
  
  private void w()
  {
    View localView = this.g;
    if ((localView != null) && (localView.isShown())) {
      this.g.setVisibility(8);
    }
    localView = this.j;
    if ((localView != null) && (localView.isShown())) {
      this.j.setVisibility(8);
    }
  }
  
  private boolean x()
  {
    return TextUtils.equals(WeishiUtils.n(), this.o);
  }
  
  private void y()
  {
    w();
    this.j.setVisibility(0);
    this.j.setOnClickListener(new WSProfileWorksFragment.5(this));
  }
  
  public void A()
  {
    if (!this.p) {
      C();
    }
    this.p = true;
  }
  
  public void B() {}
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.s = false;
    if (paramBoolean)
    {
      paramString = this.l;
      if ((paramString != null) && (paramString.c().size() == 0)) {
        y();
      }
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSVerticalPageEventHandler localWSVerticalPageEventHandler = this.m;
    if (localWSVerticalPageEventHandler != null)
    {
      WSProfileWorkAdapter localWSProfileWorkAdapter = this.l;
      if (localWSProfileWorkAdapter == null) {
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof FollowEvent))
      {
        localWSVerticalPageEventHandler.a((FollowEvent)paramWSSimpleBaseEvent, localWSProfileWorkAdapter.c());
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
      {
        localWSVerticalPageEventHandler.a((LikeRspEvent)paramWSSimpleBaseEvent, localWSProfileWorkAdapter.c());
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSAddCommentEvent))
      {
        localWSVerticalPageEventHandler.a((WSAddCommentEvent)paramWSSimpleBaseEvent, localWSProfileWorkAdapter.c());
        return;
      }
      if ((paramWSSimpleBaseEvent instanceof WSChangeItemViewVisibilityEvent)) {
        a((WSChangeItemViewVisibilityEvent)paramWSSimpleBaseEvent);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.o = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.t = paramString;
    WSProfileWorkAdapter localWSProfileWorkAdapter = this.l;
    if (localWSProfileWorkAdapter == null) {
      return;
    }
    localWSProfileWorkAdapter.a(paramString);
    if (paramBoolean) {
      this.l.notifyDataSetChanged();
    }
  }
  
  public void a(List<stSimpleMetaFeed> paramList) {}
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.s = false;
    if (this.j.isShown()) {
      this.j.setVisibility(8);
    }
    this.f.a(true, paramBoolean3);
    if (a(paramBoolean1, paramBoolean2, paramList)) {
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      this.l.b(paramList);
    }
    else
    {
      this.l.a(paramList);
      this.f.a();
    }
    if (!paramBoolean3)
    {
      t();
      return;
    }
    if (a(18, paramBoolean1, paramBoolean2)) {
      b(false, false);
    }
  }
  
  public int b()
  {
    return this.n;
  }
  
  public void b(String paramString)
  {
    this.u = paramString;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.s) {
      return;
    }
    this.s = true;
    ((WSProfileWorksPresenter)aO_()).a(this.o, this.n, paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      WSProfileWorkAdapter localWSProfileWorkAdapter = this.l;
      if (localWSProfileWorkAdapter != null) {
        localWSProfileWorkAdapter.d();
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  @android.support.annotation.NonNull
  public WSProfileWorksPresenter n()
  {
    WSProfileWorksPresenter localWSProfileWorksPresenter = new WSProfileWorksPresenter();
    localWSProfileWorksPresenter.a(this.o);
    return localWSProfileWorksPresenter;
  }
  
  public void o()
  {
    this.o = null;
    this.p = false;
    this.q = true;
    this.s = false;
    this.r = 0;
    Object localObject = this.g;
    if ((localObject != null) && (((View)localObject).isShown())) {
      this.g.setVisibility(8);
    }
    localObject = this.j;
    if ((localObject != null) && (((View)localObject).isShown())) {
      this.j.setVisibility(8);
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((WSProfileWorkAdapter)localObject).d();
      this.f.a(true, false);
      this.l.b();
    }
    if (aO_() != null) {
      ((WSProfileWorksPresenter)aO_()).b();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null)
    {
      this.n = getArguments().getInt("key_page_type");
      this.u = getArguments().getString("key_page_from");
    }
    WSSimpleEventBus.a().a(this);
    this.m = new WSVerticalPageEventHandler();
  }
  
  @Nullable
  public View onCreateView(@androidx.annotation.NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(1929773070, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WSSimpleEventBus.a().b(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void p()
  {
    this.s = false;
    if (this.p) {
      b(false, true);
    }
  }
  
  public void r()
  {
    View localView = this.i;
    if ((localView != null) && (!localView.isShown())) {
      this.i.setVisibility(0);
    }
  }
  
  public void s() {}
  
  public void u()
  {
    View localView = this.i;
    if ((localView != null) && (localView.isShown())) {
      this.i.setVisibility(8);
    }
  }
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowEvent.class);
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    localArrayList.add(WSChangeItemViewVisibilityEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileWorksFragment
 * JD-Core Version:    0.7.0.1
 */