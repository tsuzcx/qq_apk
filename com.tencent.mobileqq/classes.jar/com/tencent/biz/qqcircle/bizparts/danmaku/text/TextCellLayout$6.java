package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFullTypeResult;

class TextCellLayout$6
  implements QCircleFullTypeResult
{
  TextCellLayout$6(TextCellLayout paramTextCellLayout, int paramInt1, int paramInt2) {}
  
  public void result(int paramInt, String paramString1, String paramString2)
  {
    QCircleHostQzoneThreadHelper.postNormalThread(new TextCellLayout.6.1(this, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.6
 * JD-Core Version:    0.7.0.1
 */