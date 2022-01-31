package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.util.FaceDecoder;
import mlw;

public class WebFastCommentCreator
  implements ItemCreator
{
  private FaceDecoder a;
  
  public WebFastCommentCreator(FaceDecoder paramFaceDecoder)
  {
    this.a = paramFaceDecoder;
  }
  
  public int a(BaseData paramBaseData)
  {
    return 12;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new mlw(LayoutInflater.from(paramContext).inflate(2130969602, paramViewGroup, false), paramBaseData, this.a);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.d == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastCommentCreator
 * JD-Core Version:    0.7.0.1
 */