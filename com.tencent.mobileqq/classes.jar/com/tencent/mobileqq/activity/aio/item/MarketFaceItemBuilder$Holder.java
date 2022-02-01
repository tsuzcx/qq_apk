package com.tencent.mobileqq.activity.aio.item;

import android.graphics.drawable.Animatable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;

public class MarketFaceItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public boolean A = false;
  public PttAudioPlayView B;
  public PttAudioWaveView C;
  public RelativeLayout D;
  public RelativeLayout E;
  public TriangleView F;
  ImageView G;
  public BreathAnimationLayout H;
  public IPicEmoticonInfo a;
  EmoticonPackage b;
  public ImageView c;
  ImageView d;
  ImageView e;
  ImageView f;
  DuiButtonImageView g;
  public ImageView s;
  public ImageView t;
  public FrameLayout u;
  public ProgressBar v;
  public TextView w;
  public boolean x;
  public long y;
  public int z = -1;
  
  public void a()
  {
    Object localObject = this.B;
    if (localObject != null) {
      ((PttAudioPlayView)localObject).b();
    }
    localObject = this.C;
    if (localObject != null) {
      ((PttAudioWaveView)localObject).b();
    }
    localObject = this.G;
    if ((localObject != null) && ((((ImageView)localObject).getDrawable() instanceof Animatable))) {
      ((Animatable)this.G.getDrawable()).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */