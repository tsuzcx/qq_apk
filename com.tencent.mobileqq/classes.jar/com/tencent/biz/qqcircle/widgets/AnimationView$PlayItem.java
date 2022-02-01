package com.tencent.biz.qqcircle.widgets;

import java.util.ArrayList;
import org.json.JSONObject;

public class AnimationView$PlayItem
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public AnimationView$PlayItem(int paramInt)
  {
    this.d = paramInt;
  }
  
  public AnimationView$PlayItem(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = paramInt3;
  }
  
  protected static PlayItem a(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {
      return null;
    }
    int i = paramJSONObject.optInt("frame");
    if (i > 0) {
      return new PlayItem(i);
    }
    int k = paramJSONObject.optInt("from");
    int m = paramJSONObject.optInt("to");
    int j = paramJSONObject.optInt("cycle", 1);
    paramJSONObject = localObject;
    if (m > 0)
    {
      paramJSONObject = localObject;
      if (k > 0)
      {
        paramJSONObject = localObject;
        if (m > k)
        {
          i = j;
          if (j < 0) {
            i = 1;
          }
          paramJSONObject = new PlayItem(k, m, i);
        }
      }
    }
    return paramJSONObject;
  }
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.d;
    if (i > 0)
    {
      localArrayList.add(Integer.valueOf(i));
      return localArrayList;
    }
    int j = this.c;
    if (j > 0)
    {
      i = this.b;
      if ((i > 0) && (j > i)) {
        while (i < this.c + 1)
        {
          localArrayList.add(Integer.valueOf(i));
          i += 1;
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.AnimationView.PlayItem
 * JD-Core Version:    0.7.0.1
 */