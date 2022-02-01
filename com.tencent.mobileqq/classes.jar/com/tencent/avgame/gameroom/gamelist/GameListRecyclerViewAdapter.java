package com.tencent.avgame.gameroom.gamelist;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class GameListRecyclerViewAdapter
  extends RecyclerView.Adapter<GameListRecyclerViewAdapter.GameViewHolder>
{
  protected LayoutInflater a;
  protected List<GameItem> b = new ArrayList();
  protected boolean c = false;
  protected int d = 0;
  protected IGameRoomPresenter e;
  protected GameGridItemView.GameGridClickListener f;
  private RecyclerView g;
  private Context h;
  private int i;
  private Drawable j;
  private View k;
  private AnimatorSet l;
  private LruCache<String, URLDrawable> m = new LruCache(20);
  private LruCache<String, URLDrawable> n = new LruCache(20);
  private Runnable o = new GameListRecyclerViewAdapter.1(this);
  
  public GameListRecyclerViewAdapter(Context paramContext, RecyclerView paramRecyclerView, GameGridItemView.GameGridClickListener paramGameGridClickListener, IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.g = paramRecyclerView;
    this.h = paramContext;
    this.a = LayoutInflater.from(paramContext);
    this.e = paramIGameRoomPresenter;
    this.f = paramGameGridClickListener;
  }
  
  private void b()
  {
    AnimatorSet localAnimatorSet = this.l;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning()))
    {
      this.l.removeAllListeners();
      this.l.end();
    }
    this.l = null;
    this.k = null;
    this.g.removeCallbacks(this.o);
  }
  
  public GameListRecyclerViewAdapter.GameViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.a.inflate(2131624315, null);
    GameGridItemView localGameGridItemView = (GameGridItemView)paramViewGroup.findViewById(2131433945);
    localGameGridItemView.a(this.f);
    return new GameListRecyclerViewAdapter.GameViewHolder(paramViewGroup, localGameGridItemView);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseAnimation: ");
      localStringBuilder.append(this.d);
      QLog.i("GameListRecyclerViewAdapter", 2, localStringBuilder.toString());
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
    int i1 = GameRoomViewLayoutParamsDef.r;
    int i2 = ViewUtils.dip2px(4.0F);
    this.g.setPadding(GameRoomViewLayoutParamsDef.r, GameRoomViewLayoutParamsDef.s, i1 - i2, GameRoomViewLayoutParamsDef.t);
    this.g.setLayoutManager(new GridLayoutManager(this.h, paramInt));
    this.g.setHasFixedSize(true);
    this.g.setAdapter(this);
  }
  
  public void a(GameListRecyclerViewAdapter.GameViewHolder paramGameViewHolder, int paramInt)
  {
    Object localObject1 = paramGameViewHolder.a.getLayoutParams();
    if ((localObject1 instanceof FrameLayout.LayoutParams))
    {
      ((ViewGroup.LayoutParams)localObject1).width = GameRoomViewLayoutParamsDef.p;
      ((ViewGroup.LayoutParams)localObject1).height = GameRoomViewLayoutParamsDef.q;
      int i1 = this.i;
      if (paramInt % i1 == 0) {
        i1 = 51;
      } else if ((paramInt + 1) % i1 == 0) {
        i1 = 53;
      } else {
        i1 = 49;
      }
      ((FrameLayout.LayoutParams)localObject1).gravity = i1;
    }
    paramGameViewHolder.itemView.setPadding(0, 0, 0, GameRoomViewLayoutParamsDef.u);
    GameItem localGameItem = (GameItem)this.b.get(paramInt);
    Object localObject2;
    if (!TextUtils.isEmpty(localGameItem.n)) {
      localObject2 = localGameItem.n;
    } else {
      localObject2 = localGameItem.d;
    }
    URLDrawable localURLDrawable;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localURLDrawable = (URLDrawable)this.m.get(localObject2);
      localObject1 = localURLDrawable;
      if (localURLDrawable == null)
      {
        if (this.j == null)
        {
          localObject1 = AVGameUtil.c("avgame_list_card_bg_small@2x.png");
          if (localObject1 != null) {
            this.j = new BitmapDrawable((Bitmap)localObject1);
          } else {
            this.j = URLDrawableHelperConstants.a;
          }
        }
        localObject1 = this.j;
        localObject1 = URLDrawable.getDrawable((String)localObject2, (Drawable)localObject1, (Drawable)localObject1);
        ((URLDrawable)localObject1).startDownload();
        this.m.put(localObject2, localObject1);
      }
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = null;
    }
    if (!TextUtils.isEmpty(localGameItem.s))
    {
      localURLDrawable = (URLDrawable)this.n.get(localGameItem.s);
      localObject1 = localURLDrawable;
      if (localURLDrawable == null)
      {
        localObject1 = URLDrawable.getDrawable(localGameItem.s, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a);
        ((URLDrawable)localObject1).startDownload();
        this.n.put(localGameItem.s, localObject1);
      }
    }
    else
    {
      localObject1 = null;
    }
    paramGameViewHolder.a.a(localGameItem, this.c, this.d, paramInt, (URLDrawable)localObject1, (URLDrawable)localObject2);
    paramGameViewHolder.itemView.setScaleX(1.0F);
    paramGameViewHolder.itemView.setScaleY(1.0F);
    if (paramInt == this.d)
    {
      b();
      this.k = paramGameViewHolder.itemView;
      this.g.postDelayed(this.o, 500L);
    }
    else if (this.k == paramGameViewHolder.itemView)
    {
      b();
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramGameViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<GameItem> paramList, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gameList: ");
      localStringBuilder.append(paramList);
      localStringBuilder.append(" isHost:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" currentGameIndex:");
      localStringBuilder.append(paramInt);
      QLog.i("GameListRecyclerViewAdapter", 2, localStringBuilder.toString());
    }
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
    a(paramBoolean, paramInt, true);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    this.d = paramInt;
    b();
    notifyDataSetChanged();
    if (paramBoolean2) {
      this.g.smoothScrollToPosition(paramInt);
    }
  }
  
  public GameItem b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (GameItem)this.b.get(paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */