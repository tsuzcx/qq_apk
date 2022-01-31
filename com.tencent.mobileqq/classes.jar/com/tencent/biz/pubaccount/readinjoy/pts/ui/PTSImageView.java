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
import orc;
import pwq;
import sfd;
import sfg;

public class PTSImageView
  extends KandianUrlImageView
  implements IView<pwq>
{
  private PTSViewDecorationUtil.RoundedCorner jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner;
  private final String jdField_a_of_type_JavaLangString = "PTSImageView";
  private URL jdField_a_of_type_JavaNetURL;
  private pwq jdField_a_of_type_Pwq;
  private String b;
  
  public PTSImageView(pwq parampwq)
  {
    super(parampwq.getContext());
    this.jdField_a_of_type_Pwq = parampwq;
    this.jdField_a_of_type_ComTencentPtsUtilsPTSViewDecorationUtil$RoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this.jdField_a_of_type_Pwq);
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public pwq a()
  {
    return this.jdField_a_of_type_Pwq;
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
    sfg localsfg = this.jdField_a_of_type_Sfd.a();
    if ((localsfg == null) || (localsfg.a)) {
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
        orc.a(this, this.jdField_a_of_type_JavaNetURL, getContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSImageView
 * JD-Core Version:    0.7.0.1
 */