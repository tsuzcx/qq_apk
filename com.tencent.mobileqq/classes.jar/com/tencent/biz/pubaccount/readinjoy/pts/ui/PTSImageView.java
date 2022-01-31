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
import obj;
import pei;
import rct;
import rcw;

public class PTSImageView
  extends KandianUrlImageView
  implements IView<pei>
{
  private PTSViewDecorationUtil.RoundedCorner jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner;
  private final String jdField_a_of_type_JavaLangString = "PTSImageView";
  private URL jdField_a_of_type_JavaNetURL;
  private pei jdField_a_of_type_Pei;
  private String b;
  
  public PTSImageView(pei parampei)
  {
    super(parampei.getContext());
    this.jdField_a_of_type_Pei = parampei;
    this.jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this.jdField_a_of_type_Pei);
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public pei a()
  {
    return this.jdField_a_of_type_Pei;
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
    rcw localrcw = this.jdField_a_of_type_Rct.a();
    if ((localrcw == null) || (localrcw.a)) {
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
        obj.a(this, this.jdField_a_of_type_JavaNetURL, getContext());
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