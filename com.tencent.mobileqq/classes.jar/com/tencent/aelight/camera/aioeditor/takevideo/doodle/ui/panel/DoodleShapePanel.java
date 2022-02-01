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
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private DoodleColorAndModeView jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView;
  private AEDoodlePenWidthSeekBar jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar;
  private DoodleShapePanel.DoodlePanelListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodleShapePanel$DoodlePanelListener;
  
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
    LayoutInflater.from(getContext()).inflate(2131558513, this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView = ((DoodleColorAndModeView)findViewById(2131370051));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView.setColorSelectListener(new DoodleShapePanel.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar = ((AEDoodlePenWidthSeekBar)findViewById(2131377129));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar.setOnSeekBarChangeListener(new DoodleShapePanel.2(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379115));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new DoodleShapePanel.3(this));
  }
  
  public void setPanelListener(DoodleShapePanel.DoodlePanelListener paramDoodlePanelListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodleShapePanel$DoodlePanelListener = paramDoodlePanelListener;
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView.a(localArrayList, true, paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar.setProgress(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel
 * JD-Core Version:    0.7.0.1
 */