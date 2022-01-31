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
import omr;
import ppz;
import rpe;
import rph;

public class PTSImageView
  extends KandianUrlImageView
  implements IView<ppz>
{
  private PTSViewDecorationUtil.RoundedCorner jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner;
  private final String jdField_a_of_type_JavaLangString = "PTSImageView";
  private URL jdField_a_of_type_JavaNetURL;
  private ppz jdField_a_of_type_Ppz;
  private String b;
  
  public PTSImageView(ppz paramppz)
  {
    super(paramppz.getContext());
    this.jdField_a_of_type_Ppz = paramppz;
    this.jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this.jdField_a_of_type_Ppz);
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public ppz a()
  {
    return this.jdField_a_of_type_Ppz;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner.getSaveCount(paramCanvas);
    this.jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner.clipPath(paramCanvas);
    super.draw(paramCanvas);
    this.jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner.drawCorner(paramCanvas, i);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rph localrph = this.jdField_a_of_type_Rpe.a();
    if ((localrph == null) || (localrph.a)) {
      setImageSrc(this.b);
    }
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
  }
  
  public void setImageSrc(String paramString)
  {
    try
    {
      if ((this.b == null) || (!this.b.equalsIgnoreCase(paramString)) || (this.jdField_a_of_type_JavaNetURL == null))
      {
        this.b = paramString;
        this.jdField_a_of_type_JavaNetURL = new URL(this.b);
        QLog.d("PTSImageView", 2, "[setImageSrc], current path changed ");
      }
      for (;;)
      {
        QLog.d("PTSImageView", 2, "[setImageSrc], mPathUrl = " + this.jdField_a_of_type_JavaNetURL);
        omr.a(this, this.jdField_a_of_type_JavaNetURL, getContext());
        return;
        QLog.d("PTSImageView", 2, "[setImageSrc], current path unchanged ");
      }
      return;
    }
    catch (MalformedURLException paramString)
    {
      this.jdField_a_of_type_JavaNetURL = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSImageView
 * JD-Core Version:    0.7.0.1
 */