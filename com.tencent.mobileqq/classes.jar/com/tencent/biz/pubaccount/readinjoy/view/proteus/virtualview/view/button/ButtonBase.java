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
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() >= 4)
      {
        int i = 0;
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
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() < 2) {
        break label120;
      }
      int i = 0;
      localObject = paramJSONArray.getJSONArray(0);
      JSONArray localJSONArray = paramJSONArray.getJSONArray(1);
      while (i < localJSONArray.length())
      {
        int j = Integer.valueOf(localJSONArray.getString(i)).intValue();
        if (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          getStatus(j).backgroundColor = str;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label85:
      break label85;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setStatusBackgroud: setStatusBackgroud :");
    ((StringBuilder)localObject).append(paramJSONArray);
    Log.e("ButtonBase", ((StringBuilder)localObject).toString());
    label120:
    doOnFinish(new ButtonBase.2(this));
  }
  
  private void setStatusBackground(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() < 2) {
        break label120;
      }
      int i = 0;
      localObject = paramJSONArray.getJSONArray(0);
      JSONArray localJSONArray = paramJSONArray.getJSONArray(1);
      while (i < localJSONArray.length())
      {
        int j = Integer.valueOf(localJSONArray.getString(i)).intValue();
        if (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          getStatus(j).background = str;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label85:
      break label85;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setStatusBackground: setStatusBackground :");
    ((StringBuilder)localObject).append(paramJSONArray);
    Log.e("ButtonBase", ((StringBuilder)localObject).toString());
    label120:
    doOnFinish(new ButtonBase.1(this));
  }
  
  private void setStatusImage(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() < 2) {
        break label120;
      }
      int i = 0;
      localObject = paramJSONArray.getJSONArray(0);
      JSONArray localJSONArray = paramJSONArray.getJSONArray(1);
      while (i < localJSONArray.length())
      {
        int j = Integer.valueOf(localJSONArray.getString(i)).intValue();
        if (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          getStatus(j).img = str;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label85:
      break label85;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setStatusBackgroud: setStatusBackgroud :");
    ((StringBuilder)localObject).append(paramJSONArray);
    Log.e("ButtonBase", ((StringBuilder)localObject).toString());
    label120:
    doOnFinish(new ButtonBase.3(this));
  }
  
  private void setStatusTextColor(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    try
    {
      if (paramJSONArray.length() < 2) {
        break label120;
      }
      int i = 0;
      localObject = paramJSONArray.getJSONArray(0);
      JSONArray localJSONArray = paramJSONArray.getJSONArray(1);
      while (i < localJSONArray.length())
      {
        int j = Integer.valueOf(localJSONArray.getString(i)).intValue();
        if (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          getStatus(j).textColor = str;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label85:
      break label85;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setStatusBackgroud: setStatusBackgroud :");
    ((StringBuilder)localObject).append(paramJSONArray);
    Log.e("ButtonBase", ((StringBuilder)localObject).toString());
    label120:
    setTextColorForStates();
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
    boolean bool;
    if (this.mState == 4) {
      bool = true;
    } else {
      bool = false;
    }
    setSelected(bool);
    float f = this.mAlpha;
    if ((f >= 0.0D) && (f <= 1.001D)) {
      getNativeView().setAlpha(this.mAlpha);
    }
    getNativeView().setEnabled(this.mEnable);
    Object localObject = this.mRunnableList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
    }
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = super.setAttribute(paramInt, paramObject);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = true;
      if (paramInt != 39)
      {
        if (paramInt != 47)
        {
          switch (paramInt)
          {
          default: 
            return false;
          case 44: 
            bool1 = bool2;
            if (!(paramObject instanceof JSONArray)) {
              break;
            }
            setStatusTextColor((JSONArray)paramObject);
            return true;
          case 43: 
            bool1 = bool2;
            if (!(paramObject instanceof JSONArray)) {
              break;
            }
            setStatusImage((JSONArray)paramObject);
            return true;
          case 42: 
            bool1 = bool2;
            if (!(paramObject instanceof JSONArray)) {
              break;
            }
            setClickStatus((JSONArray)paramObject);
            return true;
          }
        }
        else
        {
          bool1 = bool2;
          if ((paramObject instanceof JSONArray))
          {
            setStatusBackGroundColor((JSONArray)paramObject);
            return true;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if ((paramObject instanceof JSONArray))
        {
          setStatusBackground((JSONArray)paramObject);
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = super.setAttribute(paramInt, paramString);
    int i = 0;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (!bool2)
    {
      Object localObject;
      if (paramInt != 13)
      {
        if (paramInt != 45)
        {
          if (paramInt != 48)
          {
            if (paramInt != 49) {
              return false;
            }
            localObject = Utils.toInteger(paramString);
            if (localObject != null)
            {
              bool1 = bool3;
              if (((Integer)localObject).intValue() == 1) {
                bool1 = true;
              }
              this.mEnable = bool1;
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("setAttribute: fail to parse - ");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(": ");
              ((StringBuilder)localObject).append(paramString);
              LogUtil.QLog.d("ButtonBase", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            localObject = Utils.toFloat(paramString);
            if (localObject != null)
            {
              this.mAlpha = ((Float)localObject).floatValue();
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("setAttribute: fail to parse - ");
              ((StringBuilder)localObject).append(paramInt);
              ((StringBuilder)localObject).append(": ");
              ((StringBuilder)localObject).append(paramString);
              LogUtil.QLog.d("ButtonBase", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
        else
        {
          paramString = Utils.toInteger(paramString);
          if (paramString != null) {
            paramInt = paramString.intValue();
          } else {
            paramInt = 0;
          }
          if (paramInt == 1) {
            i = 4;
          }
          this.mState = i;
        }
      }
      else
      {
        localObject = Utils.toDouble(paramString);
        if (localObject != null)
        {
          this.mCompoundDrawablePadding = Utils.rp2px(((Double)localObject).doubleValue());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setAttribute: fail to parse - ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(": ");
          ((StringBuilder)localObject).append(paramString);
          LogUtil.QLog.d("ButtonBase", 2, ((StringBuilder)localObject).toString());
        }
      }
      bool1 = true;
    }
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase
 * JD-Core Version:    0.7.0.1
 */