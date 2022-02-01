package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView;
import com.tencent.mobileqq.R.styleable;
import java.util.ArrayList;
import java.util.List;

public class DoodlePanel
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final int[] a = { -14079703, -1, -1027508, -1131223, -6038445, -12147713, -7768577, -496479 };
  private static final DoodlePanel.PenMode[] b = { DoodlePanel.PenMode.FREE_DRAW, DoodlePanel.PenMode.ERASER, DoodlePanel.PenMode.RECT, DoodlePanel.PenMode.OVAL, DoodlePanel.PenMode.ARROW, DoodlePanel.PenMode.LINE, DoodlePanel.PenMode.SEQUENCE_NUMBER };
  private int c = 0;
  private DoodleColorAndModeView d;
  private ImageView e;
  private FrameLayout f;
  private TextView g;
  private TextView h;
  private AEDoodlePenWidthSeekBar i;
  private DoodlePanel.DoodlePanelListener j;
  private float k;
  
  public DoodlePanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DoodlePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DoodleColorAndModeView);
      this.c = paramContext.getInt(2, 0);
      paramContext.recycle();
    }
    b();
  }
  
  private void b()
  {
    if (this.c == 1) {
      LayoutInflater.from(getContext()).inflate(2131624067, this);
    } else {
      LayoutInflater.from(getContext()).inflate(2131624065, this);
    }
    this.d = ((DoodleColorAndModeView)findViewById(2131437212));
    this.d.setColorSelectListener(new DoodlePanel.1(this));
    this.k = TypedValue.applyDimension(1, 34.0F, getResources().getDisplayMetrics());
    this.f = ((FrameLayout)findViewById(2131436820));
    this.e = ((ImageView)findViewById(2131436642));
    this.e.setOnClickListener(this);
    this.g = ((TextView)findViewById(2131448309));
    this.h = ((TextView)findViewById(2131448351));
    this.h.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i = ((AEDoodlePenWidthSeekBar)findViewById(2131445502));
    this.i.setOnSeekBarChangeListener(new DoodlePanel.2(this));
  }
  
  private void setColorLayoutVisibilityAnimated(boolean paramBoolean)
  {
    boolean bool;
    if (this.d.getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramBoolean == bool) {
      return;
    }
    if (paramBoolean)
    {
      this.d.animate().setListener(new DoodlePanel.3(this)).setDuration(150L).alpha(1.0F).translationY(0.0F);
      return;
    }
    this.d.animate().setListener(new DoodlePanel.4(this)).setDuration(150L).alpha(0.0F).translationY(this.k);
  }
  
  public void a(DoodlePanel.PenMode paramPenMode, int paramInt, float paramFloat)
  {
    paramPenMode = new ArrayList();
    int[] arrayOfInt = a;
    int n = arrayOfInt.length;
    int m = 0;
    while (m < n)
    {
      paramPenMode.add(Integer.valueOf(arrayOfInt[m]));
      m += 1;
    }
    this.d.a(paramPenMode, true, paramInt);
    this.i.setProgress(paramFloat);
  }
  
  public boolean a()
  {
    return this.d.a();
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131436642)
    {
      if ((m != 2131448309) && (m != 2131448351)) {
        return;
      }
      paramView = this.j;
      if (paramView != null) {
        paramView.b();
      }
    }
    else
    {
      paramView = this.j;
      if (paramView != null) {
        paramView.a();
      }
    }
  }
  
  public void setPanelListener(DoodlePanel.DoodlePanelListener paramDoodlePanelListener)
  {
    this.j = paramDoodlePanelListener;
  }
  
  public void setUndoEnabled(boolean paramBoolean)
  {
    this.e.setEnabled(paramBoolean);
    ImageView localImageView = this.e;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 4;
    }
    localImageView.setVisibility(m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel
 * JD-Core Version:    0.7.0.1
 */