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
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning()))
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
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558798, null);
    GameGridItemView localGameGridItemView = (GameGridItemView)paramViewGroup.findViewById(2131367689);
    localGameGridItemView.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameGridItemView$GameGridClickListener);
    return new GameListRecyclerViewAdapter.GameViewHolder(paramViewGroup, localGameGridItemView);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListRecyclerViewAdapter", 2, "pauseAnimation: " + this.jdField_a_of_type_Int);
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    int i = GameRoomViewLayoutParamsDef.g;
    int j = ViewUtils.a(4.0F);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setPadding(GameRoomViewLayoutParamsDef.g, GameRoomViewLayoutParamsDef.h, i - j, GameRoomViewLayoutParamsDef.i);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, paramInt));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this);
  }
  
  public void a(GameListRecyclerViewAdapter.GameViewHolder paramGameViewHolder, int paramInt)
  {
    Object localObject1 = paramGameViewHolder.a.getLayoutParams();
    int i;
    GameItem localGameItem;
    label100:
    Object localObject2;
    if ((localObject1 instanceof FrameLayout.LayoutParams))
    {
      ((ViewGroup.LayoutParams)localObject1).width = GameRoomViewLayoutParamsDef.e;
      ((ViewGroup.LayoutParams)localObject1).height = GameRoomViewLayoutParamsDef.f;
      if (paramInt % this.jdField_b_of_type_Int == 0)
      {
        i = 51;
        ((FrameLayout.LayoutParams)localObject1).gravity = i;
      }
    }
    else
    {
      paramGameViewHolder.itemView.setPadding(0, 0, 0, GameRoomViewLayoutParamsDef.j);
      localGameItem = (GameItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (TextUtils.isEmpty(localGameItem.l)) {
        break label374;
      }
      localObject1 = localGameItem.l;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label428;
      }
      localObject2 = (URLDrawable)this.jdField_a_of_type_AndroidUtilLruCache.get(localObject1);
      if (localObject2 != null) {
        break label421;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        localObject2 = AVGameUtils.a("avgame_list_card_bg_small@2x.png");
        if (localObject2 == null) {
          break label384;
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable((Bitmap)localObject2);
      }
      label159:
      localObject2 = URLDrawable.getDrawable((String)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((URLDrawable)localObject2).startDownload();
      this.jdField_a_of_type_AndroidUtilLruCache.put(localObject1, localObject2);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localGameItem.m))
      {
        localObject2 = (URLDrawable)this.jdField_b_of_type_AndroidUtilLruCache.get(localGameItem.m);
        if (localObject2 == null)
        {
          localObject2 = URLDrawable.getDrawable(localGameItem.m, URLDrawableHelper.TRANSPARENT, URLDrawableHelper.TRANSPARENT);
          ((URLDrawable)localObject2).startDownload();
          this.jdField_b_of_type_AndroidUtilLruCache.put(localGameItem.m, localObject2);
        }
      }
      for (;;)
      {
        paramGameViewHolder.a.a(localGameItem, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, paramInt, (URLDrawable)localObject2, (URLDrawable)localObject1);
        paramGameViewHolder.itemView.setScaleX(1.0F);
        paramGameViewHolder.itemView.setScaleY(1.0F);
        if (paramInt == this.jdField_a_of_type_Int)
        {
          b();
          this.jdField_a_of_type_AndroidViewView = paramGameViewHolder.itemView;
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        }
        for (;;)
        {
          EventCollector.getInstance().onRecyclerBindViewHolder(paramGameViewHolder, paramInt, getItemId(paramInt));
          return;
          if ((paramInt + 1) % this.jdField_b_of_type_Int == 0)
          {
            i = 53;
            break;
          }
          i = 49;
          break;
          label374:
          localObject1 = localGameItem.c;
          break label100;
          label384:
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelper.TRANSPARENT;
          break label159;
          if (this.jdField_a_of_type_AndroidViewView == paramGameViewHolder.itemView) {
            b();
          }
        }
        continue;
        localObject2 = null;
      }
      label421:
      localObject1 = localObject2;
      continue;
      label428:
      localObject1 = null;
    }
  }
  
  public void a(List<GameItem> paramList, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListRecyclerViewAdapter", 2, "gameList: " + paramList + " isHost:" + paramBoolean + " currentGameIndex:" + paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */