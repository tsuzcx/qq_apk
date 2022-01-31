package com.tencent.av.ui;

import actn;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import ldw;
import mqq.os.MqqHandler;

public class MutiMemberThumbList
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private final String jdField_a_of_type_JavaLangString = "%d名成员被邀请";
  private final ArrayList<ldw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131372377, 2131372378, 2131372379, 2131372380, 2131372381, 2131372382, 2131372383 };
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = -1L;
  private final String jdField_b_of_type_JavaLangString = "%d+";
  private boolean jdField_b_of_type_Boolean;
  
  public MutiMemberThumbList(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MutiMemberThumbList(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MutiMemberThumbList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(int paramInt, ArrayList<ldw> paramArrayList)
  {
    QLog.d("MutiMemberThumbList", 1, "doDisplay " + paramInt);
    ThreadManager.getSubThreadHandler().post(new MutiMemberThumbList.1(this, paramInt, paramArrayList));
  }
  
  private void b()
  {
    addView(LayoutInflater.from(getContext()).inflate(2131559543, null));
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onDetachedFromWindow()
  {
    QLog.d("MutiMemberThumbList", 1, "onDetachedFromWindow ");
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setBitMapFetcher(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void setDisPlayList(ArrayList<ldw> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      setVisibility(4);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      QLog.d("MutiMemberThumbList", 1, "setDisPlayList " + this.jdField_b_of_type_Long);
      return;
    }
    QLog.d("MutiMemberThumbList", 1, "setDisPlayList cost" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ldw localldw = (ldw)paramArrayList.next();
      this.jdField_a_of_type_JavaUtilArrayList.add(localldw);
    }
    a(this.jdField_a_of_type_JavaUtilArrayList.size(), (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone());
  }
  
  public void setHeadImgMask(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setMoreInfoDrawableColor(String paramString)
  {
    int i = actn.a(32.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(1);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor(paramString));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setSize(i, i);
  }
  
  public void setRelatedView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void setRelationShipInfo(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setTextColor(String paramString)
  {
    this.jdField_b_of_type_Int = Color.parseColor(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MutiMemberThumbList
 * JD-Core Version:    0.7.0.1
 */