package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ZimuViewFilm
  extends ZimuView
{
  WeakReference<ZimuView> j;
  final int[] k = { 44, 30 };
  IZimuItemView.FontPara[] l;
  
  public ZimuViewFilm(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
    paramVideoAppInterface = new IZimuItemView.FontPara(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 5);
    int n = 0;
    this.l = new IZimuItemView.FontPara[] { paramVideoAppInterface, new IZimuItemView.FontPara(Color.parseColor("#fdeabd"), Color.parseColor("#000000"), 4) };
    this.j = new WeakReference(this);
    float f = this.g * 0.48F;
    int i = 0;
    int m;
    for (;;)
    {
      paramVideoAppInterface = this.k;
      m = n;
      if (i >= paramVideoAppInterface.length) {
        break;
      }
      paramVideoAppInterface[i] = ((int)(paramVideoAppInterface[i] * f));
      i += 1;
    }
    for (;;)
    {
      paramVideoAppInterface = this.l;
      if (m >= paramVideoAppInterface.length) {
        break;
      }
      paramVideoAppInterface = paramVideoAppInterface[m];
      paramVideoAppInterface.c *= f;
      m += 1;
    }
  }
  
  protected List<ZimuItemView> b(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    a();
    ZimuItemViewFilm localZimuItemViewFilm = new ZimuItemViewFilm(getContext(), this.j, this.e, 0, this.g);
    localZimuItemViewFilm.a(paramBoolean);
    localZimuItemViewFilm.a(0, 0);
    localZimuItemViewFilm.a(this.b, this.k[0], this.l[0]);
    localZimuItemViewFilm.b(this.b, this.k[1], this.l[1]);
    localZimuItemViewFilm.a(paramSentenceInfo);
    localZimuItemViewFilm.b(0L);
    paramSentenceInfo = new ArrayList();
    paramSentenceInfo.add(localZimuItemViewFilm);
    return paramSentenceInfo;
  }
  
  void d()
  {
    ZimuItemViewFilm localZimuItemViewFilm = (ZimuItemViewFilm)this.h.get(0);
    if ((localZimuItemViewFilm != null) && (localZimuItemViewFilm.p())) {
      e();
    }
  }
  
  public String getID()
  {
    return "film";
  }
  
  public int getViewHeight()
  {
    return (int)getContext().getResources().getDimension(2131298444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewFilm
 * JD-Core Version:    0.7.0.1
 */