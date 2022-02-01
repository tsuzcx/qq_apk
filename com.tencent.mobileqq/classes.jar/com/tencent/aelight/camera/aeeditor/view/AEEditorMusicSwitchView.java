package com.tencent.aelight.camera.aeeditor.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AEEditorMusicSwitchView
  extends FrameLayout
  implements View.OnClickListener
{
  private View a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private int e = 0;
  private AEEditorMusicSwitchView.SwitchClickListener f;
  
  public AEEditorMusicSwitchView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorMusicSwitchView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorMusicSwitchView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    this.e = paramInt;
    b(paramInt);
    c(paramInt);
    AEEditorMusicSwitchView.SwitchClickListener localSwitchClickListener = this.f;
    if (localSwitchClickListener != null) {
      localSwitchClickListener.a(paramInt);
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext).inflate(2064056452, this, true);
    this.b = ((TextView)this.a.findViewById(2063991556));
    this.c = ((TextView)this.a.findViewById(2063991522));
    this.d = ((ImageView)this.a.findViewById(2063991210));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    b(this.e);
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.setTextColor(-16777216);
      this.c.setTextColor(Color.parseColor("#9699A5"));
      return;
    }
    if (paramInt == 1)
    {
      this.b.setTextColor(Color.parseColor("#9699A5"));
      this.c.setTextColor(-16777216);
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.setTranslationX(0.0F);
      return;
    }
    if (paramInt == 1)
    {
      paramInt = getMeasuredWidth();
      int i = this.d.getMeasuredWidth();
      this.d.setTranslationX(paramInt - i);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2063991556)
    {
      if (this.e == 0) {
        return;
      }
      a(0);
      return;
    }
    if (i == 2063991522)
    {
      if (this.e == 1) {
        return;
      }
      a(1);
    }
  }
  
  public void setSwitchClickListener(@Nullable AEEditorMusicSwitchView.SwitchClickListener paramSwitchClickListener)
  {
    this.f = paramSwitchClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorMusicSwitchView
 * JD-Core Version:    0.7.0.1
 */