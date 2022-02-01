package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.TabIcon;
import java.util.ArrayList;
import java.util.List;

public class AEPlayShowTabView
  extends QIMSlidingTabView
{
  private int curIndex;
  private ArrayList<QIMSlidingTabView.TabIcon> dataList = null;
  
  public AEPlayShowTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getCurIndex()
  {
    return this.curIndex;
  }
  
  public ArrayList<QIMSlidingTabView.TabIcon> getDataList()
  {
    return this.dataList;
  }
  
  public void initTabItemsWithRedDot(ArrayList<QIMSlidingTabView.TabIcon> paramArrayList)
  {
    this.dataList = paramArrayList;
    super.initTabItemsWithRedDot(paramArrayList);
  }
  
  public void onTabChecked(int paramInt)
  {
    super.onTabChecked(paramInt);
    this.curIndex = paramInt;
    ArrayList localArrayList = getmTabItemList();
    if (localArrayList == null) {
      return;
    }
    int i = 0;
    while (i < localArrayList.size())
    {
      View localView = (View)localArrayList.get(i);
      if (i == paramInt)
      {
        localView.setScaleX(1.143F);
        localView.setScaleY(1.143F);
      }
      else
      {
        localView.setScaleX(1.0F);
        localView.setScaleY(1.0F);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowTabView
 * JD-Core Version:    0.7.0.1
 */