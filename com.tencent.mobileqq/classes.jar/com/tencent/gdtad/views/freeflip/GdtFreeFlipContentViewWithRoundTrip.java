package com.tencent.gdtad.views.freeflip;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.image.GdtDrawableLoader.Listener;
import com.tencent.image.URLDrawable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import qmo;
import qmp;

public abstract class GdtFreeFlipContentViewWithRoundTrip
  extends GdtFreeFlipContentView
{
  protected int a;
  private GdtDrawableLoader.Listener jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener = new qmo(this);
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  
  public GdtFreeFlipContentViewWithRoundTrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
  }
  
  public GdtFreeFlipContentViewWithRoundTrip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private int a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry == null) || (localEntry.getValue() == null)) {
        GdtLog.d("GdtFreeFlipContentViewWithRoundTrip", "checkDrawableLoaded error");
      } else if (TextUtils.equals(((qmp)localEntry.getValue()).jdField_a_of_type_JavaLangString, paramString)) {
        return ((Integer)localEntry.getKey()).intValue();
      }
    }
    return 0;
  }
  
  private URLDrawable a(int paramInt)
  {
    if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) || (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null)) {
      return null;
    }
    return ((qmp)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).a();
  }
  
  private void a()
  {
    setImageDrawable(a());
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry == null) || (localEntry.getValue() == null))
        {
          GdtLog.d("GdtFreeFlipContentViewWithRoundTrip", "checkDrawableLoaded error");
        }
        else
        {
          if (!((qmp)localEntry.getValue()).jdField_a_of_type_Boolean) {
            break;
          }
          if (((qmp)localEntry.getValue()).a() == null) {
            return;
          }
        }
      }
    }
    this.jdField_b_of_type_Boolean = true;
    postInvalidate();
  }
  
  protected URLDrawable a()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    GdtLog.b("GdtFreeFlipContentViewWithRoundTrip", String.format("onViewResume location:%d", new Object[] { Integer.valueOf(paramInt) }));
    this.jdField_b_of_type_Int = paramInt;
    a();
  }
  
  public boolean a()
  {
    return (super.a()) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int != 0);
  }
  
  protected URLDrawable b()
  {
    int i = 2;
    if (this.jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      return a(i);
      if (this.jdField_b_of_type_Int == 2) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void b(int paramInt)
  {
    GdtLog.b("GdtFreeFlipContentViewWithRoundTrip", String.format("onViewPause location:%d", new Object[] { Integer.valueOf(paramInt) }));
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.freeflip.GdtFreeFlipContentViewWithRoundTrip
 * JD-Core Version:    0.7.0.1
 */