package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public abstract class ButtonBase
  extends TextBase
{
  protected static final int DRAWABLE_BOTTOM = 3;
  protected static final int DRAWABLE_LEFT = 0;
  protected static final int DRAWABLE_RIGHT = 2;
  protected static final int DRAWABLE_TOP = 1;
  protected static final int NORMAL = 0;
  protected static final int PRESS = 1;
  protected static final int SELECTED = 4;
  private static final String TAG = "ButtonBase";
  protected final Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  protected final Drawable TRANSPARENT_PLACE_HOLDER = new ColorDrawable(0);
  protected float mAlpha = (0.0F / 0.0F);
  private SparseArray<ButtonBase.ClickStatus> mClickStatusArr = new SparseArray(4);
  protected int mCompoundDrawablePadding;
  protected boolean mEnable = true;
  private List<Runnable> mRunnableList;
  protected int mState;
  protected boolean mSupportHtmlStyle = false;
  
  public ButtonBase(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private void doOnFinish(Runnable paramRunnable)
  {
    if (this.mRunnableList == null) {
      this.mRunnableList = new ArrayList();
    }
    this.mRunnableList.add(paramRunnable);
  }
  
  private void setClickStatus(JSONArray paramJSONArray)
  {
    int i = 0;
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() >= 4)
      {
        JSONArray localJSONArray1 = paramJSONArray.getJSONArray(0);
        JSONArray localJSONArray2 = paramJSONArray.getJSONArray(1);
        JSONArray localJSONArray3 = paramJSONArray.getJSONArray(2);
        paramJSONArray = paramJSONArray.getJSONArray(3);
        while (i < paramJSONArray.length())
        {
          ButtonBase.ClickStatus localClickStatus = getStatus(Integer.valueOf(paramJSONArray.getString(i)).intValue());
          if (i < localJSONArray1.length()) {
            localClickStatus.img = localJSONArray1.getString(i);
          }
          if (i < localJSONArray2.length()) {
            localClickStatus.textColor = localJSONArray2.getString(i);
          }
          if (i < localJSONArray3.length()) {
            localClickStatus.direction = Integer.valueOf(localJSONArray3.getString(i)).intValue();
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramJSONArray)
    {
      Log.e("ButtonBase", "setClickStatus :", paramJSONArray);
      doOnFinish(new ButtonBase.4(this));
      setTextColorForStates();
    }
  }
  
  private void setStatusBackGroundColor(JSONArray paramJSONArray)
  {
    int i = 0;
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() >= 2)
      {
        JSONArray localJSONArray1 = paramJSONArray.getJSONArray(0);
        JSONArray localJSONArray2 = paramJSONArray.getJSONArray(1);
        while (i < localJSONArray2.length())
        {
          int j = Integer.valueOf(localJSONArray2.getString(i)).intValue();
          if (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            getStatus(j).backgroundColor = str;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("ButtonBase", "setStatusBackgroud: setStatusBackgroud :" + paramJSONArray);
      doOnFinish(new ButtonBase.2(this));
    }
  }
  
  private void setStatusBackground(JSONArray paramJSONArray)
  {
    int i = 0;
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() >= 2)
      {
        JSONArray localJSONArray1 = paramJSONArray.getJSONArray(0);
        JSONArray localJSONArray2 = paramJSONArray.getJSONArray(1);
        while (i < localJSONArray2.length())
        {
          int j = Integer.valueOf(localJSONArray2.getString(i)).intValue();
          if (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            getStatus(j).background = str;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("ButtonBase", "setStatusBackground: setStatusBackground :" + paramJSONArray);
      doOnFinish(new ButtonBase.1(this));
    }
  }
  
  private void setStatusImage(JSONArray paramJSONArray)
  {
    int i = 0;
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() >= 2)
      {
        JSONArray localJSONArray1 = paramJSONArray.getJSONArray(0);
        JSONArray localJSONArray2 = paramJSONArray.getJSONArray(1);
        while (i < localJSONArray2.length())
        {
          int j = Integer.valueOf(localJSONArray2.getString(i)).intValue();
          if (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            getStatus(j).img = str;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("ButtonBase", "setStatusBackgroud: setStatusBackgroud :" + paramJSONArray);
      doOnFinish(new ButtonBase.3(this));
    }
  }
  
  private void setStatusTextColor(JSONArray paramJSONArray)
  {
    int i = 0;
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() >= 2)
      {
        JSONArray localJSONArray1 = paramJSONArray.getJSONArray(0);
        JSONArray localJSONArray2 = paramJSONArray.getJSONArray(1);
        while (i < localJSONArray2.length())
        {
          int j = Integer.valueOf(localJSONArray2.getString(i)).intValue();
          if (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            getStatus(j).textColor = str;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("ButtonBase", "setStatusBackgroud: setStatusBackgroud :" + paramJSONArray);
      setTextColorForStates();
    }
  }
  
  protected ButtonBase.ClickStatus getStatus(int paramInt)
  {
    ButtonBase.ClickStatus localClickStatus2 = (ButtonBase.ClickStatus)this.mClickStatusArr.get(paramInt);
    ButtonBase.ClickStatus localClickStatus1 = localClickStatus2;
    if (localClickStatus2 == null)
    {
      localClickStatus1 = new ButtonBase.ClickStatus();
      this.mClickStatusArr.put(paramInt, localClickStatus1);
    }
    return localClickStatus1;
  }
  
  public boolean isSelected()
  {
    return this.mState == 4;
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if (this.mState == 4) {}
    for (boolean bool = true;; bool = false)
    {
      setSelected(bool);
      if ((this.mAlpha >= 0.0D) && (this.mAlpha <= 1.001D)) {
        getNativeView().setAlpha(this.mAlpha);
      }
      getNativeView().setEnabled(this.mEnable);
      if (this.mRunnableList == null) {
        break;
      }
      Iterator localIterator = this.mRunnableList.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = super.setAttribute(paramInt, paramObject);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = true;
      switch (paramInt)
      {
      case 40: 
      case 41: 
      case 45: 
      case 46: 
      default: 
        bool1 = false;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
            } while (!(paramObject instanceof JSONArray));
            setStatusBackground((JSONArray)paramObject);
            return true;
          } while (!(paramObject instanceof JSONArray));
          setClickStatus((JSONArray)paramObject);
          return true;
        } while (!(paramObject instanceof JSONArray));
        setStatusImage((JSONArray)paramObject);
        return true;
      } while (!(paramObject instanceof JSONArray));
      setStatusBackGroundColor((JSONArray)paramObject);
      return true;
    } while (!(paramObject instanceof JSONArray));
    setStatusTextColor((JSONArray)paramObject);
    return true;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool1 = false;
    int i = 0;
    boolean bool2 = super.setAttribute(paramInt, paramString);
    if (!bool2)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 13: 
        localObject = Utils.toDouble(paramString);
        if (localObject != null)
        {
          this.mCompoundDrawablePadding = Utils.rp2px(((Double)localObject).doubleValue());
          return true;
        }
        LogUtil.QLog.d("ButtonBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
        return true;
      case 45: 
        paramString = Utils.toInteger(paramString);
        if (paramString != null) {}
        for (paramInt = paramString.intValue();; paramInt = 0)
        {
          if (paramInt == 1) {
            i = 4;
          }
          this.mState = i;
          return true;
        }
      case 48: 
        localObject = Utils.toFloat(paramString);
        if (localObject != null)
        {
          this.mAlpha = ((Float)localObject).floatValue();
          return true;
        }
        LogUtil.QLog.d("ButtonBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
        return true;
      }
      Object localObject = Utils.toInteger(paramString);
      if (localObject != null)
      {
        if (((Integer)localObject).intValue() == 1) {
          bool1 = true;
        }
        this.mEnable = bool1;
        return true;
      }
      LogUtil.QLog.d("ButtonBase", 2, "setAttribute: fail to parse - " + paramInt + ": " + paramString);
      return true;
    }
    return bool2;
  }
  
  protected abstract void setBackgroundColorForStates();
  
  protected abstract void setBackgroundForStates();
  
  protected abstract void setCompoundDrawableForStates();
  
  public void setSelected(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mState = 4;
      return;
    }
    this.mState = 0;
  }
  
  protected abstract void setTextColorForStates();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase
 * JD-Core Version:    0.7.0.1
 */