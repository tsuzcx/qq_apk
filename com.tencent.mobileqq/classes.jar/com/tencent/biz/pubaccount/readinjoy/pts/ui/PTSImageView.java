package com.tencent.biz.pubaccount.readinjoy.pts.ui;

import android.graphics.Canvas;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import pjr;
import tlt;
import tlw;

public class PTSImageView
  extends KandianUrlImageView
  implements IView
{
  private static final String TAG = "PTSImageView";
  private String mPath;
  private URL mPathUrl;
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
  
  public PTSImageView(PTSNodeImage paramPTSNodeImage)
  {
    super(paramPTSNodeImage.getContext());
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    this.mRoundedCorner.clipPath(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
    this.mRoundedCorner.drawBorder(paramCanvas);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    tlw localtlw = this.mController.a();
    if ((localtlw == null) || (localtlw.a)) {
      setImageSrc(this.mPath);
    }
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    tlw localtlw = this.mController.a();
    if ((localtlw == null) || (localtlw.a)) {
      setImageSrc(this.mPath);
    }
  }
  
  public void setImageSrc(String paramString)
  {
    try
    {
      if ((this.mPath == null) || (!this.mPath.equalsIgnoreCase(paramString)) || (this.mPathUrl == null))
      {
        this.mPath = paramString;
        this.mPathUrl = new URL(this.mPath);
        QLog.d("PTSImageView", 2, "[setImageSrc], current path changed ");
      }
      for (;;)
      {
        QLog.d("PTSImageView", 2, "[setImageSrc], mPathUrl = " + this.mPathUrl);
        pjr.a(this, this.mPathUrl, getContext());
        return;
        QLog.d("PTSImageView", 2, "[setImageSrc], current path unchanged ");
      }
      return;
    }
    catch (MalformedURLException paramString)
    {
      this.mPathUrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSImageView
 * JD-Core Version:    0.7.0.1
 */