package com.tencent.mobileqq.apollo.touch;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CMActionTouchManager
  implements ICMTouchManager
{
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\d+#?_pet");
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 350L;
  private Context jdField_a_of_type_AndroidContentContext;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private View jdField_a_of_type_AndroidViewView;
  private OnApolloViewListener jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener;
  private CMActionTouchManager.CheckForLongPress jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager$CheckForLongPress = new CMActionTouchManager.CheckForLongPress(this);
  private String jdField_a_of_type_JavaLangString;
  private List<ApolloSkeletonBounding> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  
  public CMActionTouchManager(View paramView, OnApolloViewListener paramOnApolloViewListener)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidViewView.getContext();
    this.jdField_a_of_type_Long = ViewConfiguration.getLongPressTimeout();
    this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener = paramOnApolloViewListener;
  }
  
  private int a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView instanceof ApolloTextureView)) {
      return ((ApolloTextureView)localView).getWindowAttachCount();
    }
    if ((localView instanceof ApolloSurfaceView)) {
      return ((ApolloSurfaceView)localView).getWindowAttachCount();
    }
    return 0;
  }
  
  public static ClickInfo a(float paramFloat1, float paramFloat2, List<ApolloSkeletonBounding> paramList)
  {
    ClickInfo localClickInfo = new ClickInfo();
    localClickInfo.jdField_a_of_type_Int = -1;
    localClickInfo.jdField_a_of_type_JavaLangString = "";
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][CMActionTouchManager]", 2, new Object[] { "all bounding:", paramList });
    }
    Object localObject = paramList.iterator();
    ApolloSkeletonBounding localApolloSkeletonBounding;
    while (((Iterator)localObject).hasNext())
    {
      localApolloSkeletonBounding = (ApolloSkeletonBounding)((Iterator)localObject).next();
      if ((localApolloSkeletonBounding.giftHeight > 0.0F) && (localApolloSkeletonBounding.giftWidth > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.giftX) && (paramFloat1 <= localApolloSkeletonBounding.giftX + localApolloSkeletonBounding.giftWidth) && (paramFloat2 >= localApolloSkeletonBounding.giftY) && (paramFloat2 <= localApolloSkeletonBounding.giftY + localApolloSkeletonBounding.giftHeight))
      {
        localClickInfo.jdField_a_of_type_Int = 2;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        localClickInfo.jdField_a_of_type_JavaLangString = paramList;
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("gift mNode:");
          paramList.append(localClickInfo.jdField_a_of_type_Int);
          paramList.append(",mApolloId=");
          paramList.append(localClickInfo.jdField_a_of_type_JavaLangString);
          QLog.d("[cmshow][CMActionTouchManager]", 2, paramList.toString());
        }
        return localClickInfo;
      }
    }
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localApolloSkeletonBounding = (ApolloSkeletonBounding)((Iterator)localObject).next();
      if ((localApolloSkeletonBounding.brand1Width > 0.0F) && (localApolloSkeletonBounding.brand1Height > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.brand1X) && (paramFloat1 <= localApolloSkeletonBounding.brand1X + localApolloSkeletonBounding.brand1Width) && (paramFloat2 >= localApolloSkeletonBounding.brand1Y) && (paramFloat2 <= localApolloSkeletonBounding.brand1Y + localApolloSkeletonBounding.brand1Height))
      {
        localClickInfo.jdField_a_of_type_Int = 3;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        localClickInfo.jdField_a_of_type_JavaLangString = paramList;
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("sprite brand, mNode:");
          paramList.append(localClickInfo.jdField_a_of_type_Int);
          paramList.append(",mApolloId=");
          paramList.append(localClickInfo.jdField_a_of_type_JavaLangString);
          QLog.d("ApolloSkeletonBounding", 2, paramList.toString());
        }
        return localClickInfo;
      }
      if ((localApolloSkeletonBounding.brand2Width > 0.0F) && (localApolloSkeletonBounding.brand2Height > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.brand2X) && (paramFloat1 <= localApolloSkeletonBounding.brand2X + localApolloSkeletonBounding.brand2Width) && (paramFloat2 >= localApolloSkeletonBounding.brand2Y) && (paramFloat2 <= localApolloSkeletonBounding.brand2Y + localApolloSkeletonBounding.brand2Height))
      {
        localClickInfo.jdField_a_of_type_Int = 4;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        localClickInfo.jdField_a_of_type_JavaLangString = paramList;
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("pet brand, mNode:");
          paramList.append(localClickInfo.jdField_a_of_type_Int);
          paramList.append(",mApolloId=");
          paramList.append(localClickInfo.jdField_a_of_type_JavaLangString);
          QLog.d("ApolloSkeletonBounding", 2, paramList.toString());
        }
        return localClickInfo;
      }
    }
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localApolloSkeletonBounding = (ApolloSkeletonBounding)((Iterator)localObject).next();
      if ((localApolloSkeletonBounding.bubbleWidth > 0.0F) && (localApolloSkeletonBounding.bubbleHeight > 0.0F) && (paramFloat1 >= localApolloSkeletonBounding.bubbleX) && (paramFloat1 <= localApolloSkeletonBounding.bubbleX + localApolloSkeletonBounding.bubbleWidth) && (paramFloat2 >= localApolloSkeletonBounding.bubbleY) && (paramFloat2 <= localApolloSkeletonBounding.bubbleY + localApolloSkeletonBounding.bubbleHeight))
      {
        localClickInfo.jdField_a_of_type_Int = 1000;
        if (TextUtils.isEmpty(localApolloSkeletonBounding.extendString)) {
          paramList = localApolloSkeletonBounding.name;
        } else {
          paramList = localApolloSkeletonBounding.extendString;
        }
        localClickInfo.jdField_a_of_type_JavaLangString = paramList;
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("bubble, mNode:");
          paramList.append(localClickInfo.jdField_a_of_type_Int);
          paramList.append(",mApolloId=");
          paramList.append(localClickInfo.jdField_a_of_type_JavaLangString);
          QLog.d("[cmshow][CMActionTouchManager]", 2, paramList.toString());
        }
        return localClickInfo;
      }
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      localObject = (ApolloSkeletonBounding)paramList.get(i);
      if ((paramFloat1 >= ((ApolloSkeletonBounding)localObject).x) && (paramFloat1 <= ((ApolloSkeletonBounding)localObject).x + ((ApolloSkeletonBounding)localObject).width) && (paramFloat2 >= ((ApolloSkeletonBounding)localObject).y) && (paramFloat2 <= ((ApolloSkeletonBounding)localObject).y + ((ApolloSkeletonBounding)localObject).height))
      {
        localClickInfo.jdField_a_of_type_Int = 1;
        if (TextUtils.isEmpty(((ApolloSkeletonBounding)localObject).extendString)) {
          paramList = ((ApolloSkeletonBounding)localObject).name;
        } else {
          paramList = ((ApolloSkeletonBounding)localObject).extendString;
        }
        localClickInfo.jdField_a_of_type_JavaLangString = paramList;
        if (!TextUtils.isEmpty(localClickInfo.jdField_a_of_type_JavaLangString))
        {
          paramList = jdField_a_of_type_JavaUtilRegexPattern.matcher(localClickInfo.jdField_a_of_type_JavaLangString);
          if ((paramList != null) && (paramList.matches())) {
            localClickInfo.jdField_a_of_type_Int = 5;
          }
        }
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("other cmshow area, mNode:");
          paramList.append(localClickInfo.jdField_a_of_type_Int);
          paramList.append(",mApolloId=");
          paramList.append(localClickInfo.jdField_a_of_type_JavaLangString);
          QLog.d("[cmshow][CMActionTouchManager]", 2, paramList.toString());
        }
        return localClickInfo;
      }
      i -= 1;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("not cmshow area, mNode:");
      paramList.append(localClickInfo.jdField_a_of_type_Int);
      paramList.append(",mApolloId=");
      paramList.append(localClickInfo.jdField_a_of_type_JavaLangString);
      QLog.d("[cmshow][CMActionTouchManager]", 2, paramList.toString());
    }
    return localClickInfo;
  }
  
  public float a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][CMActionTouchManager]", 2, "[getManRectMaxHeight]");
    }
    float f = 0.0F;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      f = Math.max(f, ((ApolloSkeletonBounding)localIterator.next()).height);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][CMActionTouchManager]", 2, new Object[] { "[getManRectMaxHeight] height:", Float.valueOf(f) });
    }
    return f;
  }
  
  public void a(RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
  }
  
  public void a(ApolloSkeletonBounding paramApolloSkeletonBounding, int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = localList.size();
    int k = 1;
    i -= 1;
    int j;
    for (;;)
    {
      j = k;
      if (i < 0) {
        break;
      }
      ApolloSkeletonBounding localApolloSkeletonBounding = (ApolloSkeletonBounding)localList.get(i);
      if (localApolloSkeletonBounding.name.equals(paramApolloSkeletonBounding.name))
      {
        if (paramInt == 0) {
          localApolloSkeletonBounding.updateData(paramApolloSkeletonBounding);
        } else {
          localList.remove(localApolloSkeletonBounding);
        }
        j = 0;
        break;
      }
      i -= 1;
    }
    if (j != 0) {
      localList.add(paramApolloSkeletonBounding);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.jdField_d_of_type_Boolean;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener == null) {
      return false;
    }
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localRectF != null)
    {
      if (!localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        QLog.d("[cmshow][CMActionTouchManager]", 2, "touch not in mTouchableRect!");
        return false;
      }
      QLog.d("[cmshow][CMActionTouchManager]", 2, "touch in mTouchableRect!");
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager$CheckForLongPress;
          if (paramMotionEvent != null)
          {
            this.jdField_a_of_type_AndroidViewView.removeCallbacks(paramMotionEvent);
            return false;
          }
        }
        else
        {
          this.jdField_d_of_type_Float = paramMotionEvent.getX();
          this.jdField_c_of_type_Float = paramMotionEvent.getY();
          if ((Math.abs(this.jdField_d_of_type_Float - this.jdField_a_of_type_Float) > ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop()) || (Math.abs(this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) > ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop()))
          {
            this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager$CheckForLongPress);
            this.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_Boolean = true;
          }
          return true;
        }
      }
      else
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager$CheckForLongPress;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_AndroidViewView.removeCallbacks(paramMotionEvent);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener != null) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Int >= 0) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
        {
          i = 8;
          int j = this.jdField_a_of_type_Int;
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j != 5)
                {
                  if (j == 1000) {
                    i = 7;
                  }
                }
                else {
                  i = 12;
                }
              }
              else {
                i = 11;
              }
            }
            else {
              i = 10;
            }
          }
          else {
            i = 9;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener.onNotifyStatusChanged(i, this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaLangString = null;
        }
      }
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager$CheckForLongPress == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager$CheckForLongPress = new CMActionTouchManager.CheckForLongPress(this);
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager$CheckForLongPress.a();
      this.jdField_a_of_type_AndroidViewView.postDelayed(this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager$CheckForLongPress, this.jdField_a_of_type_Long);
    }
    this.jdField_c_of_type_Float = paramMotionEvent.getY();
    this.jdField_d_of_type_Float = paramMotionEvent.getX();
    float f1 = this.jdField_d_of_type_Float;
    this.jdField_a_of_type_Float = f1;
    float f2 = this.jdField_c_of_type_Float;
    this.jdField_b_of_type_Float = f2;
    f2 = this.jdField_a_of_type_AndroidViewView.getBottom() - this.jdField_a_of_type_AndroidViewView.getTop() - f2;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("list length:");
      paramMotionEvent.append(this.jdField_a_of_type_JavaUtilList.size());
      paramMotionEvent.append("mPY = ");
      paramMotionEvent.append(this.jdField_c_of_type_Float);
      paramMotionEvent.append(", pty = ");
      paramMotionEvent.append(f2);
      paramMotionEvent.append(",mPX = ");
      paramMotionEvent.append(this.jdField_d_of_type_Float);
      paramMotionEvent.append(", xInView = ");
      paramMotionEvent.append(f1);
      paramMotionEvent.append("super.getBottom() = ");
      paramMotionEvent.append(this.jdField_a_of_type_AndroidViewView.getBottom());
      paramMotionEvent.append("super.getTop()");
      paramMotionEvent.append(this.jdField_a_of_type_AndroidViewView.getTop());
      QLog.d("[cmshow][CMActionTouchManager]", 2, paramMotionEvent.toString());
    }
    paramMotionEvent = a(f1, f2, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Int = paramMotionEvent.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramMotionEvent.jdField_a_of_type_JavaLangString;
    if (this.jdField_c_of_type_Boolean)
    {
      float f3 = this.jdField_a_of_type_AndroidViewView.getWidth();
      float f4 = this.jdField_a_of_type_AndroidViewView.getHeight();
      if ((f3 > 0.0F) && (f4 > 0.0F))
      {
        if ((f1 < f3 / 2.0F) && (f2 < f4) && (this.jdField_a_of_type_Int != 1000)) {
          return false;
        }
        if (f2 > f4) {
          return false;
        }
      }
    }
    if ((this.jdField_a_of_type_Int >= 0) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.touch.CMActionTouchManager
 * JD-Core Version:    0.7.0.1
 */