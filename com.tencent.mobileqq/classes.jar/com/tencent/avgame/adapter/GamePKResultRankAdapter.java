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
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;

public class GamePKResultRankAdapter
  extends RecyclerView.Adapter<GamePKResultRankAdapter.ViewHolder>
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private UserInfoHandler jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = null;
  ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GamePKResultRankAdapter(Context paramContext, ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> paramArrayList, int paramInt, HashMap<String, String> paramHashMap, UserInfoHandler paramUserInfoHandler)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = paramUserInfoHandler;
  }
  
  public GamePKResultRankAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558790, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558794, paramViewGroup, false)) {
      return new GamePKResultRankAdapter.ViewHolder(paramViewGroup);
    }
  }
  
  public SurvivalPkResultInfo.Pair<Integer, Long> a(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt >= 0)) {
      return (SurvivalPkResultInfo.Pair)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ArrayList<SurvivalPkResultInfo.Pair<Integer, Long>> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(GamePKResultRankAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.a(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).second), (byte)1);
    GamePKResultRankAdapter.ViewHolder.a(paramViewHolder).setImageBitmap(localBitmap);
    GamePKResultRankAdapter.ViewHolder.a(paramViewHolder).setTypeface(AVGameText.a());
    GamePKResultRankAdapter.ViewHolder.a(paramViewHolder).setText(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).first));
    localBitmap = AVGameUtils.a("avgame_pk_result_rank_num@2x.png");
    if (localBitmap != null) {
      GamePKResultRankAdapter.ViewHolder.a(paramViewHolder).setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(((SurvivalPkResultInfo.Pair)localObject).second));
    GamePKResultRankAdapter.ViewHolder.b(paramViewHolder).setText((CharSequence)localObject);
    float f = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localObject = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 1712460323, 1713576244 });
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i == 1) {
      ((GradientDrawable)localObject).setCornerRadius(f);
    }
    for (;;)
    {
      GamePKResultRankAdapter.ViewHolder.a(paramViewHolder).setBackgroundDrawable((Drawable)localObject);
      break;
      if ((i > 1) && (paramInt == 0)) {
        ((GradientDrawable)localObject).setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      } else if ((i > 1) && (paramInt == i - 1)) {
        ((GradientDrawable)localObject).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
      } else {
        ((GradientDrawable)localObject).setCornerRadius(0.0F);
      }
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size();; i = this.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GamePKResultRankAdapter", 2, "getItemCount size: " + i);
      }
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.adapter.GamePKResultRankAdapter
 * JD-Core Version:    0.7.0.1
 */