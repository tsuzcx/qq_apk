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
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

public class MarketFaceItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public long a;
  public FrameLayout a;
  public ImageView a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public BreathAnimationLayout a;
  public PttAudioPlayView a;
  public PttAudioWaveView a;
  public TriangleView a;
  EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  DuiButtonImageView jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView;
  public PicEmoticonInfo a;
  public boolean a;
  ImageView b;
  public RelativeLayout b;
  public boolean b = false;
  ImageView c;
  ImageView d;
  public int e = -1;
  public ImageView e;
  public ImageView f;
  ImageView g;
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.b();
    }
    if ((this.g != null) && ((this.g.getDrawable() instanceof Animatable))) {
      ((Animatable)this.g.getDrawable()).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */