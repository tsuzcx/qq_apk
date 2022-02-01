package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
  public static final int[] a;
  private static final DoodlePanel.PenMode[] jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel$PenMode = { DoodlePanel.PenMode.FREE_DRAW, DoodlePanel.PenMode.ERASER, DoodlePanel.PenMode.RECT, DoodlePanel.PenMode.OVAL, DoodlePanel.PenMode.ARROW, DoodlePanel.PenMode.LINE, DoodlePanel.PenMode.SEQUENCE_NUMBER };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DoodleColorAndModeView jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView;
  private AEDoodlePenWidthSeekBar jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar;
  private DoodlePanel.DoodlePanelListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel$DoodlePanelListener;
  private TextView b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -14079703, -1, -1027508, -1131223, -6038445, -12147713, -7768577, -496479 };
  }
  
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
      this.jdField_a_of_type_Int = paramContext.getInt(2, 0);
      paramContext.recycle();
    }
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Int == 1) {
      LayoutInflater.from(getContext()).inflate(2131558514, this);
    } else {
      LayoutInflater.from(getContext()).inflate(2131558512, this);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView = ((DoodleColorAndModeView)findViewById(2131370051));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView.setColorSelectListener(new DoodlePanel.1(this));
    this.jdField_a_of_type_Float = TypedValue.applyDimension(1, 34.0F, getResources().getDisplayMetrics());
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369709));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369541));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379557));
    this.b = ((TextView)findViewById(2131379594));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar = ((AEDoodlePenWidthSeekBar)findViewById(2131377129));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar.setOnSeekBarChangeListener(new DoodlePanel.2(this));
  }
  
  public void a(DoodlePanel.PenMode paramPenMode, int paramInt, float paramFloat)
  {
    paramPenMode = new ArrayList();
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramPenMode.add(Integer.valueOf(arrayOfInt[i]));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView.a(paramPenMode, true, paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar.setProgress(paramFloat);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView.a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369541)
    {
      if ((i != 2131379557) && (i != 2131379594)) {
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel$DoodlePanelListener;
      if (paramView != null) {
        paramView.b();
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel$DoodlePanelListener;
      if (paramView != null) {
        paramView.a();
      }
    }
  }
  
  public void setPanelListener(DoodlePanel.DoodlePanelListener paramDoodlePanelListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel$DoodlePanelListener = paramDoodlePanelListener;
  }
  
  public void setUndoEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localImageView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel
 * JD-Core Version:    0.7.0.1
 */