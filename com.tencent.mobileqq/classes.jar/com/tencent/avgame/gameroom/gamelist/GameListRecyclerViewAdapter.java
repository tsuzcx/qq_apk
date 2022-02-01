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
  protected int a;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private LruCache<String, URLDrawable> jdField_a_of_type_AndroidUtilLruCache = new LruCache(20);
  protected LayoutInflater a;
  private View jdField_a_of_type_AndroidViewView;
  protected IGameRoomPresenter a;
  protected GameGridItemView.GameGridClickListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GameListRecyclerViewAdapter.1(this);
  protected List<GameItem> a;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private LruCache<String, URLDrawable> jdField_b_of_type_AndroidUtilLruCache = new LruCache(20);
  
  public GameListRecyclerViewAdapter(Context paramContext, RecyclerView paramRecyclerView, GameGridItemView.GameGridClickListener paramGameGridClickListener, IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameGridItemView$GameGridClickListener = paramGameGridClickListener;
  }
  
  private void b()
  {
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public GameItem a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (GameItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public GameListRecyclerViewAdapter.GameViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558698, null);
    GameGridItemView localGameGridItemView = (GameGridItemView)paramViewGroup.findViewById(2131367442);
    localGameGridItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameGridItemView$GameGridClickListener);
    return new GameListRecyclerViewAdapter.GameViewHolder(paramViewGroup, localGameGridItemView);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseAnimation: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("GameListRecyclerViewAdapter", 2, localStringBuilder.toString());
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    int i = GameRoomViewLayoutParamsDef.r;
    int j = ViewUtils.a(4.0F);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setPadding(GameRoomViewLayoutParamsDef.r, GameRoomViewLayoutParamsDef.s, i - j, GameRoomViewLayoutParamsDef.t);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, paramInt));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this);
  }
  
  public void a(GameListRecyclerViewAdapter.GameViewHolder paramGameViewHolder, int paramInt)
  {
    Object localObject1 = paramGameViewHolder.a.getLayoutParams();
    if ((localObject1 instanceof FrameLayout.LayoutParams))
    {
      ((ViewGroup.LayoutParams)localObject1).width = GameRoomViewLayoutParamsDef.p;
      ((ViewGroup.LayoutParams)localObject1).height = GameRoomViewLayoutParamsDef.q;
      int i = this.jdField_b_of_type_Int;
      if (paramInt % i == 0) {
        i = 51;
      } else if ((paramInt + 1) % i == 0) {
        i = 53;
      } else {
        i = 49;
      }
      ((FrameLayout.LayoutParams)localObject1).gravity = i;
    }
    paramGameViewHolder.itemView.setPadding(0, 0, 0, GameRoomViewLayoutParamsDef.u);
    GameItem localGameItem = (GameItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    if (!TextUtils.isEmpty(localGameItem.l)) {
      localObject2 = localGameItem.l;
    } else {
      localObject2 = localGameItem.c;
    }
    URLDrawable localURLDrawable;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localURLDrawable = (URLDrawable)this.jdField_a_of_type_AndroidUtilLruCache.get(localObject2);
      localObject1 = localURLDrawable;
      if (localURLDrawable == null)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          localObject1 = AVGameUtil.a("avgame_list_card_bg_small@2x.png");
          if (localObject1 != null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable((Bitmap)localObject1);
          } else {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
        localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject1 = URLDrawable.getDrawable((String)localObject2, (Drawable)localObject1, (Drawable)localObject1);
        ((URLDrawable)localObject1).startDownload();
        this.jdField_a_of_type_AndroidUtilLruCache.put(localObject2, localObject1);
      }
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = null;
    }
    if (!TextUtils.isEmpty(localGameItem.m))
    {
      localURLDrawable = (URLDrawable)this.jdField_b_of_type_AndroidUtilLruCache.get(localGameItem.m);
      localObject1 = localURLDrawable;
      if (localURLDrawable == null)
      {
        localObject1 = URLDrawable.getDrawable(localGameItem.m, URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable, URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((URLDrawable)localObject1).startDownload();
        this.jdField_b_of_type_AndroidUtilLruCache.put(localGameItem.m, localObject1);
      }
    }
    else
    {
      localObject1 = null;
    }
    paramGameViewHolder.a.a(localGameItem, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, paramInt, (URLDrawable)localObject1, (URLDrawable)localObject2);
    paramGameViewHolder.itemView.setScaleX(1.0F);
    paramGameViewHolder.itemView.setScaleY(1.0F);
    if (paramInt == this.jdField_a_of_type_Int)
    {
      b();
      this.jdField_a_of_type_AndroidViewView = paramGameViewHolder.itemView;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
    else if (this.jdField_a_of_type_AndroidViewView == paramGameViewHolder.itemView)
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
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    a(paramBoolean, paramInt, true);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt;
    b();
    notifyDataSetChanged();
    if (paramBoolean2) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(paramInt);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */