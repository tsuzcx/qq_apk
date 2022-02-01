package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.core.VcSystemInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ZimuViewPacMan
  extends ZimuViewMotion
{
  static final IZimuItemView.FontPara[] jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara = { new IZimuItemView.FontPara(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 4) };
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  int[] jdField_a_of_type_ArrayOfInt = { 48, 38, 34 };
  Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = { null, null };
  List<ZimuViewPacMan.RAILWAY> jdField_b_of_type_JavaUtilList = new ArrayList(4);
  final int[] jdField_b_of_type_ArrayOfInt = { 70, 58, 52 };
  int[] c;
  
  public ZimuViewPacMan(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
    this.jdField_c_of_type_ArrayOfInt = new int[] { 116, 102, 90 };
    int i = 0;
    while (i < 4)
    {
      paramVideoAppInterface = new ZimuViewPacMan.RAILWAY(this, i, 0);
      this.jdField_b_of_type_JavaUtilList.add(paramVideoAppInterface);
      i += 1;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
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
    return "pacman";
  }
  
  protected List<ZimuItemView> a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    int k = this.jdField_a_of_type_JavaUtilRandom.nextInt(40);
    int m = this.jdField_b_of_type_ArrayOfInt.length;
    int n = this.jdField_c_of_type_ArrayOfInt.length;
    int i = k % this.jdField_a_of_type_ArrayOfInt.length;
    int j = c();
    Object localObject = new ZimuItemViewPacMan.PacManPara(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap, this.jdField_c_of_type_ArrayOfInt[(k % n)], this.jdField_b_of_type_ArrayOfInt[(k % m)], j);
    localObject = new ZimuItemViewPacMan(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, (ZimuItemViewPacMan.PacManPara)localObject);
    ((ZimuItemViewPacMan)localObject).a(paramBoolean);
    ((ZimuItemViewPacMan)localObject).a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[i], jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara[0]);
    ((ZimuItemViewPacMan)localObject).a(paramSentenceInfo);
    m = this.jdField_c_of_type_Int;
    k = ((ZimuItemViewPacMan)localObject).d();
    j = a(j * m, k);
    ((ZimuItemViewPacMan)localObject).a(this.jdField_a_of_type_Int, j);
    ((ZimuItemViewPacMan)localObject).a(0L);
    localArrayList.add(localObject);
    paramSentenceInfo = new StringBuilder();
    paramSentenceInfo.append("onCreateItemView:|");
    paramSentenceInfo.append(j);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(k);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(this.jdField_c_of_type_Int);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(this.jdField_a_of_type_ArrayOfInt[i]);
    AVLog.printColorLog("ZimuViewPacMan", paramSentenceInfo.toString());
    return localArrayList;
  }
  
  void a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ZimuViewPacMan.RAILWAY localRAILWAY = (ZimuViewPacMan.RAILWAY)localIterator.next();
      if (localRAILWAY.jdField_a_of_type_Int == paramInt)
      {
        localRAILWAY.jdField_b_of_type_Int -= 1;
        if (localRAILWAY.jdField_b_of_type_Int == 0)
        {
          localIterator.remove();
          this.jdField_b_of_type_JavaUtilList.add(0, localRAILWAY);
        }
      }
    }
  }
  
  protected void a(ZimuItemView paramZimuItemView)
  {
    a(((ZimuItemViewPacMan)paramZimuItemView).e());
  }
  
  public void b()
  {
    float f = this.jdField_a_of_type_Float * 0.48F;
    int j = this.jdField_a_of_type_ArrayOfInt.length;
    int i = 0;
    int[] arrayOfInt;
    while (i < j)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    j = this.jdField_b_of_type_ArrayOfInt.length;
    i = 0;
    while (i < j)
    {
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    j = this.jdField_c_of_type_ArrayOfInt.length;
    i = 0;
    while (i < j)
    {
      arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    try
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = BitmapFactory.decodeResource(getContext().getResources(), 2130842400);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[1] = BitmapFactory.decodeResource(getContext().getResources(), 2130842401);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    a();
    super.b();
  }
  
  protected void b(ZimuItemView paramZimuItemView)
  {
    super.b(paramZimuItemView);
    paramZimuItemView.d();
    paramZimuItemView = (ZimuItemViewPacMan)paramZimuItemView;
    int i = this.jdField_a_of_type_JavaUtilRandom.nextInt(40);
    int j = this.jdField_c_of_type_ArrayOfInt.length;
    int k = this.jdField_b_of_type_ArrayOfInt.length;
    int m = this.jdField_a_of_type_ArrayOfInt.length;
    int n = c();
    paramZimuItemView.a(new ZimuItemViewPacMan.PacManPara(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap, this.jdField_c_of_type_ArrayOfInt[(i % j)], this.jdField_b_of_type_ArrayOfInt[(i % k)], n));
    paramZimuItemView.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[(i % m)], jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara[0]);
    i = a(n * this.jdField_c_of_type_Int, paramZimuItemView.d());
    paramZimuItemView.a(this.jdField_a_of_type_Int, i);
    paramZimuItemView.a(0L);
  }
  
  int c()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int j = this.jdField_b_of_type_JavaUtilList.size();
    if (i < j)
    {
      i = j - i;
      if (i > 1)
      {
        i = this.jdField_a_of_type_JavaUtilRandom.nextInt(i * 10) % i;
        break label53;
      }
    }
    i = 0;
    label53:
    ZimuViewPacMan.RAILWAY localRAILWAY = (ZimuViewPacMan.RAILWAY)this.jdField_b_of_type_JavaUtilList.get(i);
    localRAILWAY.jdField_b_of_type_Int += 1;
    this.jdField_b_of_type_JavaUtilList.remove(i);
    this.jdField_b_of_type_JavaUtilList.add(localRAILWAY);
    return localRAILWAY.jdField_a_of_type_Int;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    int j = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length;
    int i = 0;
    while (i < j)
    {
      Bitmap[] arrayOfBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
      if (arrayOfBitmap[i] != null)
      {
        arrayOfBitmap[i].recycle();
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewPacMan
 * JD-Core Version:    0.7.0.1
 */