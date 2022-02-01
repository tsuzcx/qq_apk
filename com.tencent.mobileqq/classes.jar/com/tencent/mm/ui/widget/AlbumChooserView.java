package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class AlbumChooserView
  extends LinearLayout
{
  private TextView a;
  private WeImageView b;
  private boolean c = false;
  private AlbumChooserView.OnAlbumChooserViewClick d;
  
  public AlbumChooserView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AlbumChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131624161, this, true);
    this.a = ((TextView)paramContext.findViewById(2131428170));
    this.b = ((WeImageView)paramContext.findViewById(2131428169));
    this.b.setRotation(90.0F);
    setOnClickListener(new AlbumChooserView.1(this));
  }
  
  public void initAlbumTxt(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public void initAlbumTxt(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.setText(paramString);
    this.a.setTextColor(getContext().getResources().getColor(paramInt1));
    ((LinearLayout)this.a.getParent()).setBackground(getContext().getResources().getDrawable(paramInt4));
    this.b.setIconColor(getContext().getResources().getColor(paramInt2));
    ((FrameLayout)this.b.getParent()).setBackground(getContext().getResources().getDrawable(paramInt3));
  }
  
  public void playAlbumIconAnim()
  {
    if (!this.c)
    {
      this.c = true;
      this.b.animate().rotationBy(180.0F).setDuration(200L).withEndAction(new AlbumChooserView.2(this)).start();
    }
  }
  
  public void playAlbumIconAnim(String paramString)
  {
    if (!this.c)
    {
      this.c = true;
      this.b.animate().rotationBy(180.0F).setDuration(200L).withEndAction(new AlbumChooserView.3(this, paramString)).start();
    }
  }
  
  public void setOnAlbumChooserViewClick(AlbumChooserView.OnAlbumChooserViewClick paramOnAlbumChooserViewClick)
  {
    this.d = paramOnAlbumChooserViewClick;
  }
  
  public void updateAlbumTxt(String paramString)
  {
    playAlbumIconAnim(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.AlbumChooserView
 * JD-Core Version:    0.7.0.1
 */