package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Typeface;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class NormalBigTextItem
  extends NormalTextItem
{
  public NormalBigTextItem(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.k = AIOUtils.b(36.0F, BaseApplicationImpl.getContext().getResources());
    this.g.setTypeface(Typeface.DEFAULT_BOLD);
    g(this.k);
  }
  
  public int t()
  {
    return AIOUtils.b(36.0F, BaseApplicationImpl.getContext().getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.NormalBigTextItem
 * JD-Core Version:    0.7.0.1
 */