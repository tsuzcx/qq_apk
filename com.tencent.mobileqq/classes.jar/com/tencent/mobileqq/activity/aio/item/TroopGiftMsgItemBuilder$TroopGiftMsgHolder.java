package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.util.Observable;
import java.util.Observer;

abstract class TroopGiftMsgItemBuilder$TroopGiftMsgHolder
  extends BaseBubbleBuilder.ViewHolder
  implements Observer
{
  public MessageForTroopGift A;
  private QQAppInterface B;
  public LinearLayout a;
  public TextView b;
  public TextView c;
  public Button d;
  public ImageView e;
  public BubbleImageView f;
  public View g;
  public View s;
  public ViewGroup t;
  public ViewGroup u;
  public ViewGroup v;
  public Button w;
  public Button x;
  public Button y;
  public Button z;
  
  public TroopGiftMsgItemBuilder$TroopGiftMsgHolder(QQAppInterface paramQQAppInterface)
  {
    this.B = paramQQAppInterface;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (AIOAnimationControlManager.DownloadGftData)paramObject;
    if ((paramObservable.a.equals(TroopGiftUtil.b(this.A))) && (this.A.isLoading)) {
      this.s.post(new TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1(this, paramObservable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgHolder
 * JD-Core Version:    0.7.0.1
 */