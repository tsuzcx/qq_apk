package com.tencent.avgame.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo.Pair;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;

public class GamePKResultRankAdapter
  extends RecyclerView.Adapter<GamePKResultRankAdapter.ViewHolder>
{
  ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> a = new ArrayList();
  private Context b;
  private int c = 0;
  private HashMap<String, String> d = null;
  private UserInfoHandler e = null;
  private boolean f = false;
  
  public GamePKResultRankAdapter(Context paramContext, ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> paramArrayList, int paramInt, HashMap<String, String> paramHashMap, UserInfoHandler paramUserInfoHandler)
  {
    this.b = paramContext;
    this.c = paramInt;
    this.a = paramArrayList;
    this.d = paramHashMap;
    this.e = paramUserInfoHandler;
  }
  
  public GamePKResultRankAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.f) {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624306, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624310, paramViewGroup, false);
    }
    return new GamePKResultRankAdapter.ViewHolder(paramViewGroup);
  }
  
  public SurvivalPkResultInfo.Pair<Integer, Long> a(int paramInt)
  {
    if ((paramInt < this.a.size()) && (paramInt >= 0)) {
      return (SurvivalPkResultInfo.Pair)this.a.get(paramInt);
    }
    return null;
  }
  
  public ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> a()
  {
    return this.a;
  }
  
  public void a(GamePKResultRankAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      Bitmap localBitmap = this.e.a(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).second), (byte)1);
      GamePKResultRankAdapter.ViewHolder.a(paramViewHolder).setImageBitmap(localBitmap);
      GamePKResultRankAdapter.ViewHolder.b(paramViewHolder).setTypeface(AVGameText.getTypeface());
      GamePKResultRankAdapter.ViewHolder.b(paramViewHolder).setText(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).first));
      localBitmap = AVGameUtil.c("avgame_pk_result_rank_num@2x.png");
      if (localBitmap != null) {
        GamePKResultRankAdapter.ViewHolder.b(paramViewHolder).setBackgroundDrawable(new BitmapDrawable(localBitmap));
      }
      localObject = (String)this.d.get(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).second));
      GamePKResultRankAdapter.ViewHolder.c(paramViewHolder).setText((CharSequence)localObject);
      float f1 = ViewUtils.dip2px(12.0F);
      localObject = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 1712460323, 1713576244 });
      int i = this.a.size();
      if (i == 1) {
        ((GradientDrawable)localObject).setCornerRadius(f1);
      } else if ((i > 1) && (paramInt == 0)) {
        ((GradientDrawable)localObject).setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      } else if ((i > 1) && (paramInt == i - 1)) {
        ((GradientDrawable)localObject).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 });
      } else {
        ((GradientDrawable)localObject).setCornerRadius(0.0F);
      }
      GamePKResultRankAdapter.ViewHolder.d(paramViewHolder).setBackgroundDrawable((Drawable)localObject);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.d = paramHashMap;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    int i = this.c;
    if ((i != 0) && (i <= this.a.size())) {
      i = this.c;
    } else {
      i = this.a.size();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItemCount size: ");
      localStringBuilder.append(i);
      QLog.i("GamePKResultRankAdapter", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.adapter.GamePKResultRankAdapter
 * JD-Core Version:    0.7.0.1
 */