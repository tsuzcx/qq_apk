package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class GameSyncOptionFragment$1
  extends SimpleAdapter
{
  GameSyncOptionFragment$1(GameSyncOptionFragment paramGameSyncOptionFragment, Context paramContext, List paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramList, paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    GameSyncOptionFragment.a(this.a, localView, (String)GameSyncOptionFragment.a().get(paramInt), paramInt);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameSyncOptionFragment.1
 * JD-Core Version:    0.7.0.1
 */