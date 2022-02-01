package com.tencent.mobileqq.ark;

import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class ArkAdapterItemForTextMsg$1
  implements ArkViewImplement.LoadCallback
{
  ArkAdapterItemForTextMsg$1(ArkAdapterItemForTextMsg paramArkAdapterItemForTextMsg, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, int paramInt, ArkAioContainerWrapper paramArkAioContainerWrapper) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.g.setVisibility(0);
      ArkAdapterItemForTextMsg.a(this.e, this.b, this.a);
      this.a.h.setVisibility(0);
      this.b.a(this.a, this.e);
    }
    else
    {
      this.a.g.setVisibility(8);
      this.a.h.setVisibility(8);
    }
    QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.e.b.appName, ", position=", Integer.valueOf(this.c), ",state=", Integer.valueOf(paramInt) });
    this.b.a(this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg.1
 * JD-Core Version:    0.7.0.1
 */