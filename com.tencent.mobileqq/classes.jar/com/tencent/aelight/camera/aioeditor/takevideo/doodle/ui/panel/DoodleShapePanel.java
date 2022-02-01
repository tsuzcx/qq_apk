package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView;
import java.util.ArrayList;
import java.util.List;

public class DoodleShapePanel
  extends RelativeLayout
{
  private DoodleColorAndModeView a;
  private AEDoodlePenWidthSeekBar b;
  private RelativeLayout c;
  private DoodleShapePanel.DoodlePanelListener d;
  
  public DoodleShapePanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DoodleShapePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131624066, this);
    this.a = ((DoodleColorAndModeView)findViewById(2131437212));
    this.a.setColorSelectListener(new DoodleShapePanel.1(this));
    this.b = ((AEDoodlePenWidthSeekBar)findViewById(2131445502));
    this.b.setOnSeekBarChangeListener(new DoodleShapePanel.2(this));
    this.c = ((RelativeLayout)findViewById(2131447850));
    this.c.setOnClickListener(new DoodleShapePanel.3(this));
  }
  
  public void setPanelListener(DoodleShapePanel.DoodlePanelListener paramDoodlePanelListener)
  {
    this.d = paramDoodlePanelListener;
  }
  
  public void setSelectedColorAndWidth(int paramInt, float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = DoodlePanel.a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Integer.valueOf(arrayOfInt[i]));
      i += 1;
    }
    this.a.a(localArrayList, true, paramInt);
    this.b.setProgress(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel
 * JD-Core Version:    0.7.0.1
 */