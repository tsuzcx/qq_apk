package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class ComboProviderGridAdapter$LockAnimationDrawable
  extends DetectableAnimationDrawable
{
  ImageView a = null;
  ImageView b = null;
  PopupWindow c = null;
  QIMFilterCategoryItem d = null;
  
  public ComboProviderGridAdapter$LockAnimationDrawable(AnimationDrawable paramAnimationDrawable, ImageView paramImageView1, PopupWindow paramPopupWindow, ImageView paramImageView2, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    super(paramAnimationDrawable);
    this.c = paramPopupWindow;
    this.a = paramImageView1;
    this.b = paramImageView2;
    this.d = paramQIMFilterCategoryItem;
  }
  
  public void a()
  {
    this.c.dismiss();
    this.a.setImageDrawable(null);
    this.a = null;
    this.c = null;
    Object localObject = (CaptureComboManager)QIMManager.a(5);
    ((CaptureComboManager)localObject).i().b(this.d.a);
    SharedPreUtils.l(BaseApplicationImpl.getApplication(), this.d.a, false);
    VideoFilterTools.a().b(3, this.d.e, this.d.a);
    Bundle localBundle = new Bundle();
    localBundle.putInt("apply_source", 1);
    localBundle.putInt("capture_scene", 0);
    ((CaptureComboManager)localObject).b(this.d, (Activity)this.b.getContext(), localBundle);
    this.b.setVisibility(8);
    localObject = ((CaptureComboManager)localObject).c(this.d);
    ComboProviderGridAdapter.a(this.b, (CaptureComboBase)localObject, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderGridAdapter.LockAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */