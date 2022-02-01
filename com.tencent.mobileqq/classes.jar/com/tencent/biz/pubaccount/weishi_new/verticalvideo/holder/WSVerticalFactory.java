package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.NewGdtAdWSVerticalCommonVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.vas.VasAdvWSVerticalViewHolder;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.Iterator;
import java.util.List;

public class WSVerticalFactory
{
  public static BaseViewHolder<WSVerticalItemData> a(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 1002) {
          return new WSVerticalAvatarBottomVideoHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
        }
      }
    }
    try
    {
      Iterator localIterator = paramWSVerticalPageFragment.a().getDataList().iterator();
      while (localIterator.hasNext())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)localIterator.next();
        if ((localWSVerticalItemData.a() != null) && (GdtAdUtil.a(new GdtAd(GdtAdUtil.a(localWSVerticalItemData.a())), 105586)))
        {
          WSLog.e("WSVerticalFactory", "命中实验，走老逻辑");
          return new NewGdtAdWSVerticalCommonVideoHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
        }
      }
      WSLog.e("WSVerticalFactory", "未命中实验，走新逻辑");
    }
    catch (Exception localException)
    {
      label120:
      break label120;
    }
    WSLog.d("WSVerticalFactory", "读取实验参数失败，走新逻辑");
    return new VasAdvWSVerticalViewHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
    return new WSVerticalOperationCenterBottomVideoHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
    return new WSVerticalOperationRightVideoHolder(paramViewGroup, paramInt, paramWSVerticalPageFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalFactory
 * JD-Core Version:    0.7.0.1
 */