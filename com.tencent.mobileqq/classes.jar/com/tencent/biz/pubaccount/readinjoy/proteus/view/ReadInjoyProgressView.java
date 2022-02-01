package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInjoyProgressView
  extends NativeText
{
  private int jdField_a_of_type_Int = 0;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString;
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_b_of_type_JavaLangString;
  
  public ReadInjoyProgressView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new ReadInjoyProgressView.1(this, paramVafContext.getContext());
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mNative.setBackgroundColor(0);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof JSONObject)) {
      paramObject = (JSONObject)paramObject;
    }
    try
    {
      this.jdField_a_of_type_Int = paramObject.getInt("progress");
      this.jdField_a_of_type_JavaLangString = paramObject.getString("bgcolor");
      this.jdField_b_of_type_JavaLangString = paramObject.getString("fgcolor");
      return true;
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyProgressView
 * JD-Core Version:    0.7.0.1
 */