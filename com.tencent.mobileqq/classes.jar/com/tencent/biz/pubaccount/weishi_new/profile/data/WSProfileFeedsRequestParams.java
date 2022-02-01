package com.tencent.biz.pubaccount.weishi_new.profile.data;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import java.util.ArrayList;

public class WSProfileFeedsRequestParams
  extends FetcherParams
{
  private String a;
  private ArrayList<String> b;
  private int c;
  private int d;
  
  public WSProfileFeedsRequestParams(boolean paramBoolean1, boolean paramBoolean2, String paramString, ArrayList<String> paramArrayList, int paramInt1, int paramInt2)
  {
    super(paramBoolean1, paramBoolean2);
    this.a = paramString;
    this.b = paramArrayList;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public ArrayList<String> d()
  {
    return this.b;
  }
  
  public int e()
  {
    return this.c;
  }
  
  public int f()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.data.WSProfileFeedsRequestParams
 * JD-Core Version:    0.7.0.1
 */