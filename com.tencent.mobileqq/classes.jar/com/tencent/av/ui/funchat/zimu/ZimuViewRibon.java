package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.core.VcSystemInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZimuViewRibon
  extends ZimuViewMotion
{
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  int[] jdField_a_of_type_ArrayOfInt = { 86, 60, 56, 44, 32 };
  IZimuItemView.FontPara[] jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara = { new IZimuItemView.FontPara(Color.parseColor("#cc8de1"), Color.parseColor("#ffffff"), 7), new IZimuItemView.FontPara(Color.parseColor("#57d4d9"), Color.parseColor("#ffffff"), 7), new IZimuItemView.FontPara(Color.parseColor("#ffc903"), Color.parseColor("#ffffff"), 7) };
  private int e = 0;
  private int f = 0;
  
  public ZimuViewRibon(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  @NonNull
  private ZimuItemViewRibon a(SentenceInfo paramSentenceInfo, int paramInt1, int paramInt2, boolean paramBoolean, ZimuItemViewRibon paramZimuItemViewRibon)
  {
    int j = this.jdField_a_of_type_ArrayOfInt.length;
    int i = this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara.length;
    j = paramInt1 % j;
    paramZimuItemViewRibon.a(paramBoolean);
    paramZimuItemViewRibon.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[j], this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara[(paramInt1 % i)]);
    paramZimuItemViewRibon.a(paramSentenceInfo);
    i = a(this.jdField_c_of_type_Int * (paramInt1 % 4), paramZimuItemViewRibon.d());
    paramZimuItemViewRibon.a(this.jdField_a_of_type_Int, i);
    paramSentenceInfo = new StringBuilder();
    paramSentenceInfo.append("onCreateItemView:");
    paramSentenceInfo.append(paramInt1);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(paramInt2);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(i);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(this.jdField_c_of_type_Int);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(this.jdField_a_of_type_ArrayOfInt[j]);
    AVLog.printColorLog("ZimuViewRibon", paramSentenceInfo.toString());
    paramZimuItemViewRibon.a(paramInt2);
    return paramZimuItemViewRibon;
  }
  
  long a()
  {
    long l = VcSystemInfo.getMaxCpuFreq();
    if (l > 1800000L) {
      this.jdField_c_of_type_Long = 50L;
    } else if (l > 1400000L) {
      this.jdField_c_of_type_Long = 62L;
    } else {
      this.jdField_c_of_type_Long = 83L;
    }
    return this.jdField_c_of_type_Long;
  }
  
  public String a()
  {
    return "ribbon";
  }
  
  protected List<ZimuItemView> a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    Object localObject;
    int k;
    if (this.f % 3 == 0)
    {
      i = this.jdField_a_of_type_JavaUtilRandom.nextInt(3000);
      if ((i & 0x1) == 1) {
        j = 1;
      } else {
        j = 0;
      }
      localObject = new ZimuItemViewRibon(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
      int m = this.e;
      if (j != 0) {
        k = i;
      } else {
        k = 0;
      }
      localArrayList.add(a(paramSentenceInfo, m, k, paramBoolean, (ZimuItemViewRibon)localObject));
      this.e += 1;
      localObject = new ZimuItemViewRibon(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
      k = this.e;
      if (j != 0) {
        i = 0;
      }
      localArrayList.add(a(paramSentenceInfo, k, i, paramBoolean, (ZimuItemViewRibon)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreateItemView random 00 :");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("||");
      ((StringBuilder)localObject).append(paramSentenceInfo.a);
      AVLog.printColorLog("ZimuViewRibon", ((StringBuilder)localObject).toString());
    }
    else
    {
      j = this.jdField_a_of_type_JavaUtilRandom.nextInt(3000);
      if ((j & 0x1) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = new ZimuItemViewRibon(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
      k = this.e;
      if (i != 0) {
        i = j;
      } else {
        i = 0;
      }
      localArrayList.add(a(paramSentenceInfo, k, i, paramBoolean, (ZimuItemViewRibon)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreateItemView random zz :");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramSentenceInfo.a);
      AVLog.printColorLog("ZimuViewRibon", ((StringBuilder)localObject).toString());
    }
    this.e += 1;
    this.f += 1;
    return localArrayList;
  }
  
  public void b()
  {
    float f1 = this.jdField_a_of_type_Float * 0.48F;
    int k = this.jdField_a_of_type_ArrayOfInt.length;
    int j = 0;
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      localObject[i] = ((int)(localObject[i] * f1));
      i += 1;
    }
    k = this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara.length;
    i = j;
    while (i < k)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara;
      localObject[i].jdField_a_of_type_Float *= f1;
      i += 1;
    }
    a();
    super.b();
  }
  
  protected void b(ZimuItemView paramZimuItemView)
  {
    super.b(paramZimuItemView);
    paramZimuItemView.d();
    SentenceInfo localSentenceInfo = paramZimuItemView.a;
    paramZimuItemView = (ZimuItemViewRibon)paramZimuItemView;
    a(localSentenceInfo, this.e, 0, true, paramZimuItemView);
    this.e += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewRibon
 * JD-Core Version:    0.7.0.1
 */