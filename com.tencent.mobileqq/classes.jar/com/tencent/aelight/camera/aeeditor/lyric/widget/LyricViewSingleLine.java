package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LyricViewSingleLine
  extends LyricView
{
  public LyricViewSingleLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2064318577, this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll = ((LyricViewScroll)paramContext.findViewById(2064122852));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewInternalBase = ((LyricViewInternalSingleLine)paramContext.findViewById(2064122851));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewInternalBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewAttribute);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.setScrollEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewSingleLine
 * JD-Core Version:    0.7.0.1
 */